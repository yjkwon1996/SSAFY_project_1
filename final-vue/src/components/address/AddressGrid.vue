<template>
   <div>
      <div style="margin-top: 7%; text-align: center; font-size: 40px; font-family: 'Nanum Gothic', sans-serif;">관심지역 선택</div>
      <div style="margin-top: 23%">
         <div class="row justify-content-center" id="addressGrid">
            <div class="col-12 d-flex justify-content-center">
               <button @click="clickSidoButton" style="border: 0.5px solid black" type="button" class="btn mx-3" :class="{ 'btn btn-secondary': sidoSelected, 'btn-light': !sidoSelected }">{{ sidoLabel }}</button>
               <button @click="clickGugunButton" style="border: 0.5px solid black" type="button" class="btn mx-3" :class="{ 'btn btn-secondary': gugunSelected, 'btn-light': !gugunSelected }">{{ gugunLabel }}</button>
            </div>
         </div>
         <sido-grid v-show="showSidoGrid" v-on:call-sido-select="sidoSelect"></sido-grid>
         <gugun-grid v-show="showGugunGrid && sidoSelected" v-on:call-gugun-select="gugunSelect"></gugun-grid>
      </div>
   </div>
</template>


<script>
// import GridUI from '@/components/address/GridUI.vue';
import SidoGrid from "./SidoGrid.vue";
import GugunGrid from "./GugunGrid.vue";

import Vue from "vue";
import VueAlertify from "vue-alertify";

Vue.use(VueAlertify);

import http from "@/common/axios.js"; // axios 객체
import { mapState } from "vuex";

export default {
   components: { SidoGrid, GugunGrid },
   data() {
      return {
         showSidoGrid: false,
         showGugunGrid: false,

         sidoLabel: "시/도",
         gugunLabel: "구/군",

         refAddr: null,
      };
   },
   methods: {
      clickSidoButton() {
         if (this.showSidoGrid) {
            this.showSidoGrid = false;
         } else {
            this.showSidoGrid = true;
            this.showGugunGrid = false;
         }
      },
      clickGugunButton() {
         if (this.showGugunGrid) {
            this.showGugunGrid = false;
         } else {
            this.showGugunGrid = true;
            this.showSidoGrid = false;
         }
      },
      getSidoList() {
         this.$store.dispatch("getSidoList");
      },
      getGugunList() {
         this.$store.dispatch("getGugunList");
      },
      sidoSelect(addr) {
         this.$store.commit("SET_ADDRESS_SIDO", addr.code);
         this.getGugunList();
         this.showSidoGrid = false;
         this.showGugunGrid = true;

         this.refAddr = addr;

         this.sidoLabel = addr.name;
         this.gugunLabel = "구/군";
      },
      async addArea(gugunCode) {
         try {
            console.log(this.registeredUserId);
            let { data } = await http.post("http://localhost:9999/api/addaddress", {
               userId: this.registeredUserId,
               areaNumber: gugunCode,
            });

            // BoardMain 으로 이동
            alert("관심지역 등록 완료. 로그인 페이지로 이동합니다.");
            this.$router.push("/login");
            } catch (error) {
            console.error(error);
         }
      },
      gugunSelect(addr) {
         this.$store.commit("SET_ADDRESS_GUGUN", addr.code);
         this.showGugunGrid = false;

         this.gugunLabel = addr.name;

         const $this = this;
         
         this.$alertify.confirm(`${this.sidoLabel} ${this.gugunLabel}를(을) 관심지역으로 등록하시겠습니까?`, function(){ $this.addArea(addr.code) }, function(){ $this.sidoSelect($this.refAddr) });
      },
   },
   created() {
      this.getSidoList();
   },
   computed: {
      ...mapState(['registeredUserId']),
      sidoSelected() {
         return this.$store.state.address.sido != "0";
      },
      gugunSelected() {
         return this.$store.state.address.gugun != "0";
      },
   },
};
</script>


<style scoped>
/* #addressGrid >>> .btn {
   width: 500px;
} */
@import url('https://fonts.googleapis.com/css?family=Black+Han+Sans:400')
</style>