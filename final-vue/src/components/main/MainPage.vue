<template>
  <main
    class="main-content position-relative max-height-vh-100 h-100 border-radius-lg"
    style="overflow-y: auto; overflow-x: hidden"
  >
    <!-- End Navbar -->
    <div class="container-fluid py-4 px-5">
      <div class="row">
        <div class="col-md-12">
          <div class="d-md-flex align-items-center mb-3 mx-2">
            <div class="mb-md-0 mb-3">
              <h2 class="font-weight-bold mb-0">FLEX</h2>
            </div>
          </div>
        </div>
      </div>
      <hr class="my-0" />

      <div class="row my-4">
        <div class="col-lg-4 col-md-6 mb-md-0 mb-4">
          <div class="card shadow-xs border h-100">
            <div class="card-header pb-0">
              <h6 class="font-weight-semibold text-lg mb-0" style="font-family: 'Noto Sans KR', sans-serif;">{{ this.user.userArea[0] }} 아파트 월별 평균 거래금액</h6>
              <p class="text-sm"></p>
            </div>
            <div class="card-body py-3">
              <!-- 로그인 시에는 관심 지역에 대한 정보가 그래프로 표시되고, 비로그인 시에는 모자이크 처리 -->
              <div class="chart mb-2" v-if="isLoginGetters">
                <canvas id="chart-bars" class="chart-canvas" height="300"></canvas>
              </div>
              <div class="chart mb-2" v-if="!isLoginGetters">
                  <div class="btn btn-info font-weight-bold blind_wrap">로그인이 필요합니다.</div>
                <div>
                  <canvas id="chart-bars-ex" class="chart-canvas chblur" height="300"></canvas>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="col-lg-8 col-md-6">
          <div class="card shadow-xs border">
            <div class="card-header border-bottom pb-3">
              <div class="d-sm-flex align-items-center mb-3">
                <div>
                  <h6 class="font-weight-semibold text-lg mb-0" style="font-family: 'Noto Sans KR', sans-serif;">{{ this.user.userArea[0] }} 최근 거래</h6>
                  <p class="text-sm mb-sm-0 mb-2"></p>
                </div>
              </div>
            </div>
            <div class="card-body px-0 py-0">
              <div class="table-responsive p-0" v-if="!isLoginGetters">
                <table class="table align-items-center justify-content-center mb-0">
                  <thead class="bg-gray-100">
                    <tr>
                      <th class="text-secondary text-xs font-weight-semibold opacity-7" style="font-family: 'Noto Sans KR', sans-serif;">아파트명</th>
                      <th class="text-secondary text-xs font-weight-semibold opacity-7 ps-2" style="font-family: 'Noto Sans KR', sans-serif;">거래가격</th>
                      <th class="text-secondary text-xs font-weight-semibold opacity-7 ps-2" style="font-family: 'Noto Sans KR', sans-serif;">거래날자</th>
                      <th class="text-secondary text-xs font-weight-semibold opacity-7 ps-2" style="font-family: 'Noto Sans KR', sans-serif;">주소</th>
                    </tr>
                  </thead>

                  <div class="btn btn-info font-weight-bold blind_wrap_table">로그인이 필요합니다.</div>

                  <tbody class="chblur">
                    <tr>
                      <!-- v-for 형식으로 데이터 받아와서(최근 4개만) 띄우기 -->
                      <td>
                        <div class="d-flex px-2">
                          <div class="my-auto">
                            <h6 class="mb-0 text-sm">아파트명 더미</h6>
                          </div>
                        </div>
                      </td>
                      <td>
                        <p class="text-sm font-weight-normal mb-0">거래금액 더미</p>
                      </td>
                      <td>
                        <span class="text-sm font-weight-normal">거래날자 더미</span>
                      </td>
                      <td class="align-middle">
                        <div class="d-flex">
                          <div class="ms-2">
                            <p class="text-dark text-sm mb-0">동 더미</p>
                            <p class="text-secondary text-sm mb-0">도로명 더미</p>
                          </div>
                        </div>
                      </td>
                    </tr>
                    <tr>
                      <!-- v-for 형식으로 데이터 받아와서(최근 4개만) 띄우기 -->
                      <td>
                        <div class="d-flex px-2">
                          <div class="my-auto">
                            <h6 class="mb-0 text-sm">아파트명 더미</h6>
                          </div>
                        </div>
                      </td>
                      <td>
                        <p class="text-sm font-weight-normal mb-0">거래금액 더미</p>
                      </td>
                      <td>
                        <span class="text-sm font-weight-normal">거래날자 더미</span>
                      </td>
                      <td class="align-middle">
                        <div class="d-flex">
                          <div class="ms-2">
                            <p class="text-dark text-sm mb-0">동 더미</p>
                            <p class="text-secondary text-sm mb-0">도로명 더미</p>
                          </div>
                        </div>
                      </td>
                    </tr>
                    <tr>
                      <!-- v-for 형식으로 데이터 받아와서(최근 4개만) 띄우기 -->
                      <td>
                        <div class="d-flex px-2">
                          <div class="my-auto">
                            <h6 class="mb-0 text-sm">아파트명 더미</h6>
                          </div>
                        </div>
                      </td>
                      <td>
                        <p class="text-sm font-weight-normal mb-0">거래금액 더미</p>
                      </td>
                      <td>
                        <span class="text-sm font-weight-normal">거래날자 더미</span>
                      </td>
                      <td class="align-middle">
                        <div class="d-flex">
                          <div class="ms-2">
                            <p class="text-dark text-sm mb-0">동 더미</p>
                            <p class="text-secondary text-sm mb-0">도로명 더미</p>
                          </div>
                        </div>
                      </td>
                    </tr>
                    <tr>
                      <!-- v-for 형식으로 데이터 받아와서(최근 4개만) 띄우기 -->
                      <td>
                        <div class="d-flex px-2">
                          <div class="my-auto">
                            <h6 class="mb-0 text-sm">아파트명 더미</h6>
                          </div>
                        </div>
                      </td>
                      <td>
                        <p class="text-sm font-weight-normal mb-0">거래금액 더미</p>
                      </td>
                      <td>
                        <span class="text-sm font-weight-normal">거래날자 더미</span>
                      </td>
                      <td class="align-middle">
                        <div class="d-flex">
                          <div class="ms-2">
                            <p class="text-dark text-sm mb-0">동 더미</p>
                            <p class="text-secondary text-sm mb-0">도로명 더미</p>
                          </div>
                        </div>
                      </td>
                    </tr>
                    <tr>
                      <!-- v-for 형식으로 데이터 받아와서(최근 4개만) 띄우기 -->
                      <td>
                        <div class="d-flex px-2">
                          <div class="my-auto">
                            <h6 class="mb-0 text-sm">아파트명 더미</h6>
                          </div>
                        </div>
                      </td>
                      <td>
                        <p class="text-sm font-weight-normal mb-0">거래금액 더미</p>
                      </td>
                      <td>
                        <span class="text-sm font-weight-normal">거래날자 더미</span>
                      </td>
                      <td class="align-middle">
                        <div class="d-flex">
                          <div class="ms-2">
                            <p class="text-dark text-sm mb-0">동 더미</p>
                            <p class="text-secondary text-sm mb-0">도로명 더미</p>
                          </div>
                        </div>
                      </td>
                    </tr>
                  </tbody>
                </table>
              </div>
              <div class="table-responsive p-0" v-if="isLoginGetters">
                <table class="table align-items-center justify-content-center mb-0">
                  <thead class="bg-gray-100">
                    <tr>
                      <th class="text-secondary text-xs font-weight-semibold opacity-7" style="font-family: 'Noto Sans KR', sans-serif;">아파트명</th>
                      <th class="text-secondary text-xs font-weight-semibold opacity-7 ps-2" style="font-family: 'Noto Sans KR', sans-serif;">거래가격</th>
                      <th class="text-secondary text-xs font-weight-semibold opacity-7 ps-2" style="font-family: 'Noto Sans KR', sans-serif;">거래날자</th>
                      <th class="text-secondary text-xs font-weight-semibold opacity-7 ps-2" style="font-family: 'Noto Sans KR', sans-serif;">주소</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr v-for="(house, index) in this.currentMonthHouses" :key="index">
                      <!-- v-for 형식으로 데이터 받아와서(최근 4개만) 띄우기 -->
                      <td>
                        <div class="d-flex px-2">
                          <div class="my-auto">
                            <h6 class="mb-0 text-sm" style="font-family: 'Noto Sans KR', sans-serif;">{{ house["아파트"] }}</h6>
                          </div>
                        </div>
                      </td>
                      <td>
                        <p class="text-sm font-weight-normal mb-0" style="font-family: 'Noto Sans KR', sans-serif;">{{ house["거래금액"] }}</p>
                      </td>
                      <td>
                        <span class="text-sm font-weight-normal"
                           style="font-family: 'Noto Sans KR', sans-serif;">{{ house["년"] }}/{{ house["월"] }}/{{ house["일"] }}</span
                        >
                      </td>
                      <td class="align-middle">
                        <div class="d-flex">
                          <div class="ms-2">
                            <p class="text-dark text-sm mb-0" style="font-family: 'Noto Sans KR', sans-serif;">{{ house["법정동"] }}</p>
                            <p class="text-secondary text-sm mb-0" style="font-family: 'Noto Sans KR', sans-serif;">{{ house["도로명"] }}</p>
                          </div>
                        </div>
                      </td>
                    </tr>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
        </div>
      </div>
      <br />

      <div class="row">
        <div style="margin-bottom: 10px">
          <h3 class="font-weight-bold mb-0 highlight">속보</h3>
        </div>
        <table class="table align-items-center justify-content-center mb-5">
          <thead class="bg-gray-100">
            <tr>
              <th class="text-secondary text-xs font-weight-semibold opacity-7">기사제목</th>
              <th class="text-secondary text-xs font-weight-semibold opacity-7 ps-2">작성일시</th>
            </tr>
          </thead>
          <tbody>
            <tr
              style="cursor: pointer"
              v-for="(newsdata, index) in news.items"
              :key="index"
              @click="moveNewsLink(newsdata.link)"
            >
              <!-- v-for 형식으로 데이터 받아와서(최근 4개만) 띄우기 -->
              <td>
                <p v-html="newsdata.title" style="font-family: 'Noto Sans KR', sans-serif;"></p>
                <div class="d-flex px-2" style="font-family: 'Noto Sans KR', sans-serif;"></div>
              </td>
              <td>
                <p class="text-sm font-weight-normal mb-0">
                  {{ newsdata.pubDate | strcut() }}
                </p>
              </td>
            </tr>
          </tbody>
        </table>
      </div>

      <footer class="footer pt-3">
        <div class="container-fluid">
          <div class="row align-items-center justify-content-lg-between">
            <div class="col-lg-6 mb-lg-0 mb-4">
              <div class="copyright text-center text-xs text-muted text-lg-start">
                Copyright © 2022 Corporate UI by
                <a href="https://www.creative-tim.com" class="text-secondary" target="_blank">Creative Tim</a>.
              </div>
            </div>
            <div class="col-lg-6">
              <ul class="nav nav-footer justify-content-center justify-content-lg-end">
                <li class="nav-item">
                  <a href="https://www.creative-tim.com" class="nav-link text-xs text-muted" target="_blank"
                    >Creative Tim</a
                  >
                </li>
                <li class="nav-item">
                  <a
                    href="https://www.creative-tim.com/presentation"
                    class="nav-link text-xs text-muted"
                    target="_blank"
                    >About Us</a
                  >
                </li>
                <li class="nav-item">
                  <a href="https://www.creative-tim.com/blog" class="nav-link text-xs text-muted" target="_blank"
                    >Blog</a
                  >
                </li>
                <li class="nav-item">
                  <a
                    href="https://www.creative-tim.com/license"
                    class="nav-link text-xs pe-0 text-muted"
                    target="_blank"
                    >License</a
                  >
                </li>
              </ul>
            </div>
          </div>
        </div>
      </footer>
    </div>
  </main>
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
      chartMonth: [],
      chartData: [],
      chartDataCount: [],
      dates: [],
      myLineChart: null,
      news: [],
    };
  },
  computed: {
    ...mapState(["user", "houses", "currentMonthHouses"]),
    isLoginGetters() {
      return this.$store.getters.getLoginStatus;
    },
    imgURL() {
      return require("../../assets/img/noProfile.png");
    },
  },
  methods: {
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
    async searchApt() {
      this.$store.commit("CLEAR_HOUSE_LIST");
      this.$store.commit("CLEAR_CURRENT_MONTH_HOUSES");
      let { data } = await http.get(`http://localhost:9999/api/address/${this.user.userId}`);
      if (data.length > 0) {
        console.log(`data : ${data[0].areaNumber}`);
        let gugunCode = data[0].areaNumber;
        let response2 = await http.get(`http://localhost:9999/api/gugun/${gugunCode}`);
        this.$store.commit("SET_USER_AREA", response2.data.name);
        this.chartData = [];
        for (let i = 0; i < 6; i++) {
          const date = this.dates[i];
          try {
            let response = await http.get(`http://localhost:9999/map/aptlist/${gugunCode}/${date}`);
            let { data } = response;
            data.response.body.items.item.forEach((item) => {
              this.$store.commit("SET_HOUSE_LIST", item);
            });

            if (i == 0) {
              data.response.body.items.item.forEach((item) => {
                this.$store.commit("SET_CURRENT_MONTH_HOUSES", item);
              });
            }

            this.$store.commit("SORT_CURRENT_MONTH_HOUSES");
          } catch (error) {
            console.error(error);
          }
        }
        this.chartDataCount = [];
        this.drawChart();
      } else {
      }
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
    drawChart() {
      console.log(1);
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

      if (this.myLineChart == null) {
        fData = [100, 200, 150, 300, 20, 100];
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
    async getNews() {
      try {
        let { data } = await http.get(`http://localhost:9999/news`);
        console.log("뉴스", data);
        this.news = data;
      } catch (error) {
        console.error(error);
      }
    },
    moveNewsLink(link) {
      window.open(link, "_blank");
    },
  },
  filters: {
    strcut: function (date) {
      return date.substr(0, 25);
    },
  },
  created() {
    this.chartData = [];
    this.chartDataCount = [];
  },
  mounted() {
    this.calcDate();
    this.calcMonth();
    this.searchApt();
    this.getNews();
    this.drawChart();
  },
};
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap');
.chblur {
  filter: blur(10px);
  -webkit-filter: blur(10px);
}
.blind_wrap {
  background-color: #fff;
  position: relative;
  top: 150px;
  left: 100px;
  margin: 0 auto;
  text-align: center;
  width: 50%;
  -ms-transform: rotate(90deg);
  -webkit-transform: rotate(90deg);
  transform: rotate(340deg);
}
.blind_wrap_table {
  background-color: #fff;
  position: relative;
  top: 150px;
  margin: 0 auto;
  margin-left: 100%;
  text-align: center;
  width: 50%;
  -ms-transform: rotate(90deg);
  -webkit-transform: rotate(90deg);
  transform: rotate(340deg);
}
div:hover .highlight:after {
  width: 100%;
}
.highlight {
  display: inline-block;
  position: relative;
}
.highlight:after {
  content: "";
  width: 0;
  height: 10px;
  display: inline-block;
  background: #d9fcdb;
  position: absolute;
  bottom: 0;
  left: 0;
  z-index: -1;
  transition: 0.2s all;
}

</style>
