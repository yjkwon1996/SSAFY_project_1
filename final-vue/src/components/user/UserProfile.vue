<template>
  <div>
    <nav class="navbar bg-slate-900 navbar-expand-lg flex-wrap top-0 px-0 py-0">
      <div class="container py-2">
        <nav aria-label="breadcrumb">
          <router-link to="/" class="d-flex align-items-center" style="text-decoration: none">
            <span class="px-3 font-weight-bold text-lg text-white me-4">House Search</span>
          </router-link>
        </nav>
        <ul class="navbar-nav d-none d-lg-flex">
          <li class="nav-item px-3 py-3 border-radius-sm d-flex align-items-center">
            <router-link class="nav-link text-white p-0" to="/">Dashboard</router-link>
          </li>
          <li class="nav-item px-3 py-3 border-radius-sm d-flex align-items-center">
            <router-link class="nav-link text-white p-0" to="/board">board</router-link>
          </li>
          <li class="nav-item px-3 py-3 border-radius-sm d-flex align-items-center">
            <router-link class="nav-link text-white p-0" to="/map">map</router-link>
          </li>
        </ul>

        <div class="collapse navbar-collapse mt-sm-0 mt-2 me-md-0 me-sm-4" id="navbar">
          <ul class="navbar-nav ms-md-auto justify-content-end">
            <li class="nav-item d-flex align-items-center ps-2 text-white font-weight-bold px-0">
              {{ this.user.userName }} 님 &nbsp;
              <router-link to="/profile" class="nav-link text-white font-weight-bold px-0">
                <li class="nav-item dropdown pe-2 d-flex align-items-center">
                  <div class="avatar avatar-sm position-relative">
                    <img src="../assets/img/team-2.jpg" alt="profile_image" class="w-100 border-radius-md" />
                  </div>
                </li>
              </router-link>
            </li>
          </ul>
        </div>
      </div>
    </nav>
    <div class="container">
      <div class="row">
        <div class="col-12">
          <!-- Page title -->
          <div class="my-5">
            <h3>My Profile</h3>
            <hr />
          </div>
          <!-- Form START -->
          <form class="file-upload">
            <div class="row mb-5 gx-5">
              <!-- Contact detail -->
              <div class="col-xxl-8 mb-5 mb-xxl-0">
                <div class="bg-secondary-soft px-4 py-5 rounded">
                  <div class="row g-3">
                    <h4 class="mb-4 mt-0">{{ this.user.userName }}님의 프로필</h4>
                    <!-- First Name -->
                    <div class="col-md-6">
                      <label class="form-label">소속</label>
                      <input
                        type="text"
                        class="form-control"
                        placeholder=""
                        aria-label="First name"
                        value="SSAFY"
                        disabled
                      />
                    </div>
                    <!-- Last name -->
                    <div class="col-md-6">
                      <label class="form-label">국가</label>
                      <input
                        type="text"
                        class="form-control"
                        placeholder=""
                        aria-label="Last name"
                        value="대한민국"
                        disabled
                      />
                    </div>
                    <!-- Phone number -->
                    <div class="col-md-6">
                      <label class="form-label">이름</label>
                      <input
                        type="text"
                        class="form-control"
                        placeholder=""
                        aria-label="Phone number"
                        v-model="userName"
                      />
                    </div>
                    <!-- Mobile number -->
                    <div class="col-md-6">
                      <label class="form-label">이메일</label>
                      <input type="email" class="form-control" placeholder="" aria-label="email" v-model="userEmail" />
                    </div>
                    <!-- Email -->
                    <div class="col-md-6">
                      <label for="inputEmail4" class="form-label">가입일시</label>
                      <input
                        type="text"
                        class="form-control"
                        id="inputEmail4"
                        :value="user.userRegisterDate | makeDateStr('/')"
                        disabled
                      />
                    </div>
                    <!-- Skype -->
                    <div class="col-md-6">
                      <label class="form-label">관심 지역</label>
                      <input
                        type="text"
                        class="form-control"
                        placeholder=""
                        aria-label="area"
                        :value="this.user.userArea[0]"
                        disabled
                      />
                    </div>
                  </div>
                  <!-- Row END -->
                </div>
              </div>
              <!-- Upload profile -->
              <div class="col-xxl-4">
                <div class="bg-secondary-soft px-4 py-5 rounded">
                  <div class="row g-3">
                    <h4 class="mb-4 mt-0"></h4>
                    <div class="text-center">
                      <!-- Image upload -->
                      <div class="square position-relative display-2 mb-3">
                        <img :src="makeImageUrl()" style="width: 100%; height: 100%" />
                      </div>
                      <!-- Button -->
                      <input type="file" id="customFile" name="file" hidden="" accept="image/*" @change="fileChange" />
                      <label class="btn btn-success-soft btn-block" for="customFile" id="">Upload</label>
                      <!-- Content -->
                      <p class="text-muted mt-3 mb-0"><span class="me-1">Note:</span>Minimum size 300px x 300px</p>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <!-- Row END -->
            <!-- button -->
            <div class="gap-3 d-md-flex justify-content-md-end text-center">
              <button type="button" class="btn btn-danger btn-lg" @click="deleteUserProfile">Delete profile</button>
              <button type="button" class="btn btn-primary btn-lg" @click="updateUserProfile">Update profile</button>
            </div>
          </form>
          <!-- Form END -->
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
      file: "",
    };
  },
  computed: {
    ...mapState(["user"]),
  },
  filters: {
    makeDateStr: function (date, separator) {
      let ret = "";
      ret += date.year + separator;
      if (date.month < 10) ret += "0";
      ret += date.month + separator;
      if (date.day < 10) ret += "0";
      ret += date.day;

      return ret;
    },
  },
  methods: {
    fileChange(fileEvent) {
      this.file = URL.createObjectURL(fileEvent.target.files[0]);
    },
    async updateUserProfile() {
      let formData = new FormData();
      formData.append("userName", this.userName);
      formData.append("userEmail", this.userEmail);

      // file upload
      let attachFiles = document.querySelector("#customFile").files;

      if (attachFiles.length > 0) {
        const fileArray = Array.from(attachFiles);
        fileArray.forEach((file) => formData.append("file", file));
      }

      let options = {
        headers: { "Content-Type": "multipart/form-data" },
      };

      try {
        let { data } = await http.put(`/api/users/${this.user.userId}`, formData, options);
        let $this = this;
        this.$store.commit("SET_USER_UPDATE", {
          userName: this.userName,
          userEmail: this.userEmail,
          userProfileImageUrl: data.userProfileImageUrl,
        });
        this.$alertify.alert("수정 완료! 메인 페이지로 이동합니다.", function () {
          $this.$router.push("/");
        });
      } catch (error) {
        console.log(error);
        this.$alertify.error("서버에 문제가 발생했습니다.");
      }
    },
    makeImageUrl() {
      return `${this.user.userProfileImageUrl}`;
    },
    async deleteUserProfile() {
      try {
        await http.delete(`/api/users/${this.user.userId}`);
        let $this = this;
        this.$store.commit("SET_LOGIN", {
          loginStatus: false,
          user: {
            userId: 0,
            userName: "",
            userEmail: "",
            userRegisterDate: [],
            userProfileImageUrl: "",
            isAdmin: false,
          },
        });
        this.$alertify.alert("삭제 완료! 메인 페이지로 이동합니다.", function () {
          $this.$router.push("/");
        });
      } catch (error) {
        console.log(error);
        this.$alertify.error("서버에 문제가 발생했습니다.");
      }
    },
  },
  created() {
    this.userName = this.user.userName;
    this.userEmail = this.user.userEmail;
  },
};
</script>

<style scoped>
body {
  margin-top: 20px;
  color: #9b9ca1;
}
.bg-secondary-soft {
  background-color: rgba(208, 212, 217, 0.1) !important;
}
.rounded {
  border-radius: 5px !important;
}
.py-5 {
  padding-top: 3rem !important;
  padding-bottom: 3rem !important;
}
.px-4 {
  padding-right: 1.5rem !important;
  padding-left: 1.5rem !important;
}
.file-upload .square {
  height: 250px;
  width: 250px;
  margin: auto;
  vertical-align: middle;
  border: 1px solid #e5dfe4;
  background-color: #fff;
  border-radius: 5px;
}
.text-secondary {
  --bs-text-opacity: 1;
  color: rgba(208, 212, 217, 0.5) !important;
}
.btn-success-soft {
  color: #28a745;
  background-color: rgba(40, 167, 69, 0.1);
}
.btn-danger-soft {
  color: #dc3545;
  background-color: rgba(220, 53, 69, 0.1);
}
.form-control {
  display: block;
  width: 100%;
  padding: 0.5rem 1rem;
  font-size: 0.9375rem;
  font-weight: 400;
  line-height: 1.6;
  color: #29292e;
  background-color: #fff;
  background-clip: padding-box;
  border: 1px solid #e5dfe4;
  -webkit-appearance: none;
  -moz-appearance: none;
  appearance: none;
  border-radius: 5px;
  -webkit-transition: border-color 0.15s ease-in-out, -webkit-box-shadow 0.15s ease-in-out;
  transition: border-color 0.15s ease-in-out, -webkit-box-shadow 0.15s ease-in-out;
  transition: border-color 0.15s ease-in-out, box-shadow 0.15s ease-in-out;
  transition: border-color 0.15s ease-in-out, box-shadow 0.15s ease-in-out, -webkit-box-shadow 0.15s ease-in-out;
}
</style>
