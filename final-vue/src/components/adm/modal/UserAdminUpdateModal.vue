<template>
  <div
    class="modal fade"
    id="adminModal"
    tabindex="-1"
    aria-labelledby="exampleModalLabel"
    aria-hidden="true"
  >
    >
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">회원정보 수정</h5>
          <button
            type="button"
            class="btn-close"
            data-bs-dismiss="modal"
            aria-label="Close"
          ></button>
        </div>
        <div class="modal-body">
          <form>
            <div class="mb-3">
              <label for="recipient-name" class="col-form-label">이름</label>
              <input type="text" class="form-control" id="recipient-name" v-model="userName" />
            </div>
            <div class="mb-3">
              <label for="recipient-email" class="col-form-label">이메일</label>
              <input type="email" class="form-control" id="recipient-email" v-model="userEmail" />
            </div>
          </form>
        </div>
        <div class="modal-footer">
          <button
            type="button"
            class="btn btn-secondary"
            data-bs-dismiss="modal"
            @click="closeUserInfo"
          >
            닫기
          </button>
          <button type="button" class="btn btn-primary" @click="changeUserInfo">수정</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";
import Vue from "vue";
import VueAlertify from "vue-alertify";
Vue.use(VueAlertify);

import http from "@/common/axios.js";
export default {
  data() {
    return {
      userName: "",
      userEmail: "",
    };
  },
  computed: {
    ...mapState(["adminUserInfo", "adminModalOpen"]),
    checkModalOpen() {
      return this.adminModalOpen;
    },
  },
  methods: {
    async changeUserInfo() {
      let registerObj = {
        userName: this.userName,
        userEmail: this.userEmail,
      };
      try {
        await http.put(`/api/users/${this.adminUserInfo.userId}`, registerObj); // JSON Request, { params : registerObj } X params 를 쓰면 get => query string
        let $this = this;
        this.$alertify.alert("수정 완료", function () {
          $this.$store.commit("SET_ADMIN_MODAL_OPEN", false);
        });
      } catch (error) {
        console.log(error);
        this.$alertify.error("서버에 문제가 발생했습니다.");
      }
    },
    closeUserInfo() {
      this.$store.commit("SET_ADMIN_MODAL_OPEN", false);
    },
  },
  watch: {
    checkModalOpen() {
      if (!this.adminModalOpen) {
        this.$store.commit("SET_ADMIN_USER_INFO", { userId: 0, userName: "", userEmail: "" });
      }
      this.userName = this.adminUserInfo.userName;
      this.userEmail = this.adminUserInfo.userEmail;
    },
  },
};
</script>

<style scoped></style>
