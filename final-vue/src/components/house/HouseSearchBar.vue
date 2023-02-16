<template>
  <div id="mapNavBar">
    <section id="select">
      <select class="form-select main-button" v-model="sidoCode" id="sido" @change="gugunList">
        <option :value="null" selected hidden>시도 선택</option>
        <option v-for="sido in sidos" :key="sido.value" :value="sido.value">{{ sido.text }}</option>
      </select>
      <select class="form-select main-button" v-model="gugunCode" id="gugun">
        <option :value="null" selected hidden>구군 선택</option>
        <option v-for="gugun in guguns" :key="gugun.value" :value="gugun.value">
          {{ gugun.text }}
        </option>
      </select>
      <button type="button" class="btn btn-light" id="list-btn" @click="searchApt">아파트 검색</button>
    </section>
    <hr style="width: 90%; margin-left: 5%" />
    <div>
      <canvas id="chart-bars-ex" class="chart-canvas" width="80%" height="200px" margin-left="10%"></canvas>
    </div>
    <div id="roadview" style="width: 80%; height: 200px; margin-left: 10%"></div>
    <div class="card" style="width: 80%; margin-left: 10%" v-if="infoOpen">
      <ul class="list-group list-group-flush" style="width: 80%">
        <li class="list-group-item">주소 : {{ houseInf.houseAddress }}</li>
        <li class="list-group-item">거래금액 : {{ houseInf.houseDealPrice }}</li>
        <li class="list-group-item">거래일자 : {{ houseInf.houseDealDate }}</li>
      </ul>
    </div>
  </div>
</template>

<script>
import Vue from "vue";
import VueAlertify from "vue-alertify";

Vue.use(VueAlertify);

import http from "@/common/axios.js"; // axios 객체
import { mapState } from "vuex";

export default {
  data() {
    return {
      sidoCode: null,
      gugunCode: null,
      dates: [],
      chartMonth: [],
      chartData: [],
      chartDataCount: [],
      myLineChart: null,
      infoOpen: false,
      houseInf: {
        houseName: "",
        houseAddress: "",
        houseDealPrice: 0,
        houseDealDate: "",
        houseGugunCode: 0,
        houseLat: 0,
        houseLng: 0,
      },
    };
  },
  computed: {
    ...mapState(["houseInfo", "houseInfoClicked", "houses"]),
    sidos() {
      return this.$store.state.sidos;
    },
    guguns() {
      return this.$store.state.guguns;
    },
    houses() {
      return this.$store.state.houses;
    },
    checkHouseInfo() {
      return this.houseInfo;
    },
    checkHouseInfoClicked() {
      return this.houseInfoClicked;
    },
  },
  created() {
    this.$store.commit("CLEAR_SIDO_LIST");
    this.getSido();
    this.calcDate();
    this.calcMonth();
  },
  methods: {
    async getSido() {
      try {
        // axios 가 json 으로 parameter 를 보내는 방법 ? 객체를 전달
        let response = await http.get("http://localhost:9999/map/sido");
        let { data } = response;

        console.log(data);
        if (data.result == "login") {
          alert("로그인이 필요합니다.");
          this.doLogout();
        } else {
          // 시도코드 받아오기 성공에 대한 처리
          this.$store.commit("SET_SIDO_LIST", data);
        }
      } catch (error) {
        console.error(error);
      }
    },
    // logout 처리 별도 method
    doLogout() {
      this.$store.commit("SET_LOGIN", { isLogin: false, userName: "", userProfileImageUrl: "" });
      this.$router.push("/login");
    },

    async getGugun(sidoCode) {
      try {
        // axios 가 json 으로 parameter 를 보내는 방법 ? 객체를 전달
        let response = await http.get("http://localhost:9999/map/gugun", {
          params: { sido: sidoCode },
        });
        let { data } = response;

        // 시도코드 받아오기 성공에 대한 처리
        this.$store.commit("SET_GUGUN_LIST", data);
      } catch (error) {
        console.error(error);
      }
    },
    drawChart() {
      try {
        var ctx = document.getElementById("chart-bars-ex").getContext("2d");
      } catch {
        var ctx = document.getElementById("chart-bars").getContext("2d");
      }

      let monthStr = new Array();
      this.chartMonth.forEach((month) => {
        monthStr.push(month + "월");
      });

      let reversedStr = monthStr.reverse();

      this.makeChartData();

      // 초기화
      let cData = [];
      for (let i = 0; i < 12; i++) {
        cData.push(0);
      }

      for (let i = 0; i < 12; i++) {
        this.chartDataCount.push(0);
      }

      this.houses.forEach((house) => {
        this.chartDataCount[house["월"] - 1]++;
      });

      let now = new Date().getMonth();

      for (let i = 0; i < 12; i++) {
        if (this.chartDataCount[i] > 0) {
          this.chartData[i] /= this.chartDataCount[i];
        }
      }

      let cIndex = 0;
      while (cIndex < 12) {
        cData[cIndex] = this.chartData[now];
        cIndex++;

        now--;
        if (now < 0) {
          now = 11;
        }
      }

      let reversedCData = cData.reverse();

      console.log(reversedCData);

      let fData = new Array();

      for (let i = 6; i < 12; i++) {
        fData.push(reversedCData[i]);
      }

      if (this.myLineChart != null) {
        this.myLineChart.destroy();
      }

      this.myLineChart = new Chart(ctx, {
        type: "bar",
        data: {
          labels: reversedStr,
          datasets: [
            {
              label: "평균거래금액",
              tension: 0.4,
              borderWidth: 0,
              borderSkipped: false,
              backgroundColor: "#2ca8ff",
              data: fData,
              maxBarThickness: 6,
            },
          ],
        },
        options: {
          responsive: true,
          maintainAspectRatio: false,
          plugins: {
            legend: {
              display: false,
            },
            tooltip: {
              backgroundColor: "#fff",
              titleColor: "#1e293b",
              bodyColor: "#1e293b",
              borderColor: "#e9ecef",
              borderWidth: 1,
              usePointStyle: true,
            },
          },
          interaction: {
            intersect: false,
            mode: "index",
          },
          scales: {
            y: {
              stacked: true,
              grid: {
                drawBorder: false,
                display: true,
                drawOnChartArea: true,
                drawTicks: false,
                borderDash: [4, 4],
              },
              ticks: {
                beginAtZero: true,
                padding: 10,
                font: {
                  size: 12,
                  family: "Noto Sans",
                  style: "normal",
                  lineHeight: 2,
                },
                color: "#64748B",
              },
            },
            x: {
              stacked: true,
              grid: {
                drawBorder: false,
                display: false,
                drawOnChartArea: false,
                drawTicks: false,
              },
              ticks: {
                font: {
                  size: 12,
                  family: "Noto Sans",
                  style: "normal",
                  lineHeight: 2,
                },
                color: "#64748B",
              },
            },
          },
        },
      });
    },
    makeChartData() {
      // chartData 초기화
      for (let i = 0; i < 12; i++) {
        this.chartData.push(0);
      }

      this.houses.forEach((house) => {
        let month = house["월"] - 1;
        let data = house["거래금액"];

        data = data.replace(",", "");

        this.chartData[month] += Number(data);
      });
    },
    gugunList() {
      this.$store.commit("CLEAR_GUGUN_LIST");
      this.gugunCode = null;
      if (this.sidoCode) this.getGugun(this.sidoCode);
    },
    async searchApt() {
      this.$store.commit("CLEAR_HOUSE_LIST");
      if (this.gugunCode) {
        for (let i = 0; i < 6; i++) {
          const date = this.dates[i];
          try {
            let response = await http.get(`http://localhost:9999/map/aptlist/${this.gugunCode}/${date}`);
            let { data } = response;
            data.response.body.items.item.forEach((item) => {
              this.$store.commit("SET_HOUSE_LIST", item);
            });
          } catch (error) {
            console.error(error);
          }
        }
        this.chartData = [];
        this.chartDataCount = [];
        this.drawChart();
      }
      this.$store.commit("SET_COMPLETE_GET_HOUSES", true);
    },
    doLogout() {
      this.$store.commit("SET_LOGIN", {
        loginStatus: false,
        user: { userId: 0, userName: "", userEmail: "", userRegisterDate: [], userProfileImageUrl: "", isAdmin: false },
      });
      this.$router.push("/login");
    },
    calcDate() {
      let today = new Date();
      let year = today.getFullYear();
      let month = today.getMonth() + 1;
      let date = year * 100 + month;

      this.dates.push(date);

      for (let i = 1; i < 6; i++) {
        month -= 1;

        if (month <= 0) {
          year -= 1;
          month = 12;
        }

        date = year * 100 + month;
        this.dates.push(date);
      }
    },
    calcMonth() {
      let today = new Date();
      let month = today.getMonth() + 1;

      this.chartMonth.push(month);

      for (let i = 1; i < 6; i++) {
        month -= 1;

        if (month <= 0) {
          month = 12;
        }

        this.chartMonth.push(month);
      }
    },
  },
  watch: {
    checkHouseInfo() {
      this.houseInf = this.houseInfo;
      //
      // 로드뷰 만들기

      var roadviewContainer = document.getElementById("roadview"); //로드뷰를 표시할 div
      var roadview = new kakao.maps.Roadview(roadviewContainer); //로드뷰 객체
      var roadviewClient = new kakao.maps.RoadviewClient(); //좌표로부터 로드뷰 파노ID를 가져올 로드뷰 helper객체
      var position = new kakao.maps.LatLng(this.houseInf.houseLat, this.houseInf.houseLng);

      // 특정 위치의 좌표와 가까운 로드뷰의 panoId를 추출하여 로드뷰를 띄운다.
      roadviewClient.getNearestPanoId(position, 50, function (panoId) {
        roadview.setPanoId(panoId, position); //panoId와 중심좌표를 통해 로드뷰 실행
      });
    },
    checkHouseInfoClicked() {
      this.infoOpen = this.houseInfoClicked;
      //
      // 로드뷰 만들기

      var roadviewContainer = document.getElementById("roadview"); //로드뷰를 표시할 div
      var roadview = new kakao.maps.Roadview(roadviewContainer); //로드뷰 객체
      var roadviewClient = new kakao.maps.RoadviewClient(); //좌표로부터 로드뷰 파노ID를 가져올 로드뷰 helper객체
      var position = new kakao.maps.LatLng(this.houseInf.houseLat, this.houseInf.houseLng);
      console.log("2", roadview.setPanoId);
      // 특정 위치의 좌표와 가까운 로드뷰의 panoId를 추출하여 로드뷰를 띄운다.
      roadviewClient.getNearestPanoId(position, 50, function (panoId) {
        roadview.setPanoId(panoId, position); //panoId와 중심좌표를 통해 로드뷰 실행
      });
    },
  },
};
</script>

<style scoped>
#mapNavBar {
  float: left;
  height: 905px;
  width: 20%;
  background-color: #f9fafb;
}

.search {
  margin-left: 10%;
  margin-top: 30px;
  position: relative;
  width: 80%;
}

.search input {
  width: 100%;
  border: 1px solid #bbb;
  border-radius: 8px;
  padding: 10px 12px;
  font-size: 14px;
}

.search i {
  position: absolute;
  width: 17px;
  top: 10px;
  right: 12px;
  margin: 0;
}

#select select {
  width: 80%;
  margin-left: 10%;
  margin-top: 10px;
}

#select button {
  width: 80%;
  margin-left: 10%;
  margin-top: 15px;
}
</style>
