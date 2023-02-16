<template>
  <div style="overflow-y: auto; overflow-x: hidden">
    <div class="container position-sticky z-index-sticky top-0">
      <div class="row">
        <div class="col-12">
          <!-- Navbar -->
          <nav
            class="navbar navbar-expand-lg blur border-radius-sm top-0 z-index-3 shadow position-absolute my-3 py-2 start-0 end-0 mx-4"
          >
            <div class="container-fluid px-1">
              <router-link class="navbar-brand font-weight-bolder ms-lg-0" to="/">Corporate UI</router-link>
              <button
                class="navbar-toggler shadow-none ms-2"
                type="button"
                data-bs-toggle="collapse"
                data-bs-target="#navigation"
                aria-controls="navigation"
                aria-expanded="false"
                aria-label="Toggle navigation"
              >
                <span class="navbar-toggler-icon mt-2">
                  <span class="navbar-toggler-bar bar1"></span>
                  <span class="navbar-toggler-bar bar2"></span>
                  <span class="navbar-toggler-bar bar3"></span>
                </span>
              </button>
              <div class="collapse navbar-collapse" id="navigation">
                <ul class="navbar-nav mx-auto ms-xl-auto">
                  <li class="nav-item">
                    <router-link class="nav-link d-flex align-items-center me-2" to="/">
                      <svg
                        width="14"
                        height="14"
                        viewBox="0 0 26 26"
                        version="1.1"
                        xmlns="http://www.w3.org/2000/svg"
                        xmlns:xlink="http://www.w3.org/1999/xlink"
                        fill="currentColor"
                        class="opacity-6 me-1"
                      >
                        <g id="dashboard" stroke="none" stroke-width="1" fill-rule="evenodd">
                          <g id="template" transform="translate(1.000000, 1.000000)">
                            <path
                              d="M0,1.71428571 C0,0.76752 0.76752,0 1.71428571,0 L22.2857143,0 C23.2325143,0 24,0.76752 24,1.71428571 L24,5.14285714 C24,6.08962286 23.2325143,6.85714286 22.2857143,6.85714286 L1.71428571,6.85714286 C0.76752,6.85714286 0,6.08962286 0,5.14285714 L0,1.71428571 Z"
                            ></path>
                            <path
                              d="M0,12 C0,11.0532171 0.76752,10.2857143 1.71428571,10.2857143 L12,10.2857143 C12.9468,10.2857143 13.7142857,11.0532171 13.7142857,12 L13.7142857,22.2857143 C13.7142857,23.2325143 12.9468,24 12,24 L1.71428571,24 C0.76752,24 0,23.2325143 0,22.2857143 L0,12 Z"
                            ></path>
                            <path
                              d="M18.8571429,10.2857143 C17.9103429,10.2857143 17.1428571,11.0532171 17.1428571,12 L17.1428571,22.2857143 C17.1428571,23.2325143 17.9103429,24 18.8571429,24 L22.2857143,24 C23.2325143,24 24,23.2325143 24,22.2857143 L24,12 C24,11.0532171 23.2325143,10.2857143 22.2857143,10.2857143 L18.8571429,10.2857143 Z"
                            ></path>
                          </g>
                        </g>
                      </svg>
                      Dashboard
                    </router-link>
                  </li>

                  <li class="nav-item">
                    <router-link
                      class="nav-link d-flex align-items-center me-2 text-dark font-weight-bold"
                      to="/register"
                    >
                      <svg
                        width="16"
                        height="16"
                        xmlns="http://www.w3.org/2000/svg"
                        viewBox="0 0 24 24"
                        fill="currentColor"
                        class="text-dark me-1"
                      >
                        <path
                          fill-rule="evenodd"
                          d="M12 1.5a5.25 5.25 0 00-5.25 5.25v3a3 3 0 00-3 3v6.75a3 3 0 003 3h10.5a3 3 0 003-3v-6.75a3 3 0 00-3-3v-3c0-2.9-2.35-5.25-5.25-5.25zm3.75 8.25v-3a3.75 3.75 0 10-7.5 0v3h7.5z"
                          clip-rule="evenodd"
                        />
                      </svg>
                      Sign Up
                    </router-link>
                  </li>
                  <li class="nav-item">
                    <router-link class="nav-link d-flex align-items-center me-2" to="/Login">
                      <svg
                        width="16"
                        height="16"
                        xmlns="http://www.w3.org/2000/svg"
                        viewBox="0 0 24 24"
                        fill="currentColor"
                        class="opacity-6 me-1"
                      >
                        <path
                          fill-rule="evenodd"
                          d="M15.75 1.5a6.75 6.75 0 00-6.651 7.906c.067.39-.032.717-.221.906l-6.5 6.499a3 3 0 00-.878 2.121v2.818c0 .414.336.75.75.75H6a.75.75 0 00.75-.75v-1.5h1.5A.75.75 0 009 19.5V18h1.5a.75.75 0 00.53-.22l2.658-2.658c.19-.189.517-.288.906-.22A6.75 6.75 0 1015.75 1.5zm0 3a.75.75 0 000 1.5A2.25 2.25 0 0118 8.25a.75.75 0 001.5 0 3.75 3.75 0 00-3.75-3.75z"
                          clip-rule="evenodd"
                        />
                      </svg>
                      Sign In
                    </router-link>
                  </li>
                </ul>
              </div>
            </div>
          </nav>
          <!-- End Navbar -->
        </div>
      </div>
    </div>
    <main class="main-content mt-0">
      <section>
        <div class="page-header min-vh-100">
          <div class="container">
            <div class="row">
              <div class="col-md-6">
                <div class="position-absolute w-40 top-0 start-0 h-100 d-md-block d-none">
                  <div
                    class="oblique-image position-absolute d-flex fixed-top ms-auto h-100 z-index-0 bg-cover me-n8"
                    style="background-image: url('../assets/img/image-sign-up.jpg')"
                  >
                    <div class="my-auto text-start max-width-350 ms-7">
                      <h1 class="mt-3 text-white font-weight-bolder">
                        Start your <br />
                        new journey.
                      </h1>
                      <p class="text-white text-lg mt-4 mb-4">
                        Use these awesome forms to login or create new account in your project for free.
                      </p>
                      <div class="d-flex align-items-center">
                        <div class="avatar-group d-flex">
                          <a
                            href="javascript:;"
                            class="avatar avatar-sm rounded-circle"
                            data-bs-toggle="tooltip"
                            data-original-title="Jessica Rowland"
                          >
                            <img alt="Image placeholder" src="../assets/img/team-3.jpg" class="" />
                          </a>
                          <a
                            href="javascript:;"
                            class="avatar avatar-sm rounded-circle"
                            data-bs-toggle="tooltip"
                            data-original-title="Audrey Love"
                          >
                            <img alt="Image placeholder" src="../assets/img/team-4.jpg" class="rounded-circle" />
                          </a>
                          <a
                            href="javascript:;"
                            class="avatar avatar-sm rounded-circle"
                            data-bs-toggle="tooltip"
                            data-original-title="Michael Lewis"
                          >
                            <img alt="Image placeholder" src="../assets/img/marie.jpg" class="rounded-circle" />
                          </a>
                          <a
                            href="javascript:;"
                            class="avatar avatar-sm rounded-circle"
                            data-bs-toggle="tooltip"
                            data-original-title="Audrey Love"
                          >
                            <img alt="Image placeholder" src="../assets/img/team-1.jpg" class="rounded-circle" />
                          </a>
                        </div>
                        <p class="font-weight-bold text-white text-sm mb-0 ms-2">Join 2.5M+ users</p>
                      </div>
                    </div>
                    <div class="text-start position-absolute fixed-bottom ms-7">
                      <h6 class="text-white text-sm mb-5">
                        Copyright © 2022 Corporate UI Design System by Creative Tim.
                      </h6>
                    </div>
                  </div>
                </div>
              </div>
              <div class="col-md-4 d-flex flex-column mx-auto">
                <div class="card card-plain mt-8">
                  <div class="card-header pb-0 text-left bg-transparent">
                    <h3 class="font-weight-black text-dark display-6">Sign up</h3>
                    <p class="mb-0">Nice to meet you! Please enter your details.</p>
                  </div>
                  <div class="card-body">
                    <form role="form">
                      <label>Name</label>
                      <div class="mb-3">
                        <input
                          type="text"
                          class="form-control"
                          placeholder="Enter your name"
                          aria-label="Name"
                          aria-describedby="name-addon"
                          :class="{
                            'is-valid': isUserNameFocusAndValid,
                            'is-invalid': isUserNameFocusAndInvalid,
                          }"
                          v-model="userName"
                          @input="validateUserName"
                          @focus="isUserNameFocus = true"
                        />
                        <div class="valid-feedback">Valid.</div>
                        <div class="invalid-feedback">올바른 이름을 입력해 주세요.</div>
                      </div>
                      <label>Email Address</label>
                      <div class="mb-3">
                        <input
                          type="email"
                          class="form-control"
                          placeholder="Enter your email address"
                          aria-label="Email"
                          aria-describedby="email-addon"
                          :class="{
                            'is-valid': isUserEmailFocusAndValid,
                            'is-invalid': isUserEmailFocusAndInValid,
                          }"
                          v-model="userEmail"
                          @input="validateEmail"
                          @focus="isUserEmailFocus = true"
                        />
                        <div class="valid-feedback">Valid.</div>
                        <div class="invalid-feedback">올바른 Email 을 입력해 주세요.</div>
                      </div>
                      <label>Password</label>
                      <div class="mb-3">
                        <input
                          type="password"
                          class="form-control"
                          placeholder="Create a password"
                          aria-label="Password"
                          aria-describedby="password-addon"
                          :class="{
                            'is-valid': isUserPasswordFocusAndValid,
                            'is-invalid': isUserPasswordFocusAndInvalid,
                          }"
                          v-model="userPassword"
                          @input="validatePassword"
                          @focus="isUserPasswordFocus = true"
                        />
                        <div class="valid-feedback">Valid.</div>
                        <div class="invalid-feedback">
                          1개 이상의 특수문자, 대소문자 및 숫자를 포함하고 8자리 이상이여야 합니다.
                        </div>
                      </div>
                      <div class="form-check form-check-info text-left mb-0">
                        <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault" />
                        <label class="font-weight-normal text-dark mb-0" for="flexCheckDefault">
                          I agree the
                          <a href="javascript:;" class="text-dark font-weight-bold">Terms and Conditions</a>.
                        </label>
                      </div>
                      <div class="text-center">
                        <button type="button" class="btn btn-dark w-100 mt-4 mb-3" @click="register">Sign up</button>
                      </div>
                    </form>
                  </div>
                  <div class="card-footer text-center pt-0 px-lg-2 px-1">
                    <p class="mb-4 text-xs mx-auto">
                      Already have an account?
                      <a href="javascript:;" class="text-dark font-weight-bold">Sign in</a>
                    </p>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
    </main>
  </div>
</template>

<script>
import Vue from "vue";
import VueAlertify from "vue-alertify";
Vue.use(VueAlertify);

import http from "@/common/axios.js";

export default {
  data() {
    return {
      userName: "",
      userEmail: "",
      userPassword: "",

      isUserNameFocus: false,
      isUserEmailFocus: false,
      isUserPasswordFocus: false,

      isUserNameValid: false,
      isUserEmailValid: false,
      isUserPasswordValid: false,
    };
  },
  computed: {
    isUserNameFocusAndValid() {
      return this.isUserNameFocus && this.isUserNameValid;
    },
    isUserNameFocusAndInvalid() {
      return this.isUserNameFocus && !this.isUserNameValid;
    },
    isUserEmailFocusAndValid() {
      return this.isUserEmailFocus && this.isUserEmailValid;
    },
    isUserEmailFocusAndInValid() {
      return this.isUserEmailFocus && !this.isUserEmailValid;
    },
    isUserPasswordFocusAndValid() {
      return this.isUserPasswordFocus && this.isUserPasswordValid;
    },
    isUserPasswordFocusAndInvalid() {
      return this.isUserPasswordFocus && !this.isUserPasswordValid;
    },
    isUserPassword2FocusAndValid() {
      return this.isUserPassword2Focus && this.isUserPassword2Valid;
    },
    isUserPassword2FocusAndInvalid() {
      return this.isUserPassword2Focus && !this.isUserPassword2Valid;
    },
  },
  methods: {
    validateUserName() {
      let patternKorAtList = new RegExp(/^[r-ㅎ|가-힣]+$/u);

      this.isUserNameValid = patternKorAtList.test(this.userName) && this.userName.length > 1 ? true : false;
      console.log(this.isUserNameValid);
    },
    validateEmail() {
      // ^ 시작일치, $ 끝 일치
      // {2, 3} 2개 ~ 3개
      // * 0회 이상, + 1회 이상
      // [-.] - 또는 _ 또는 .
      // ? 없거나 1회
      let regexp = /^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/i;
      this.isUserEmailValid = regexp.test(this.userEmail) ? true : false;
      console.log(this.isUserEmailValid);
    },
    validatePassword() {
      let patternEngAtListOne = new RegExp(/[a-zA-Z]+/); // + for at least one
      let patternSpeAtListOne = new RegExp(/[~!@#$%^&*()_+|<>?:{}]+/); // + for at least one
      let patternNumAtListOne = new RegExp(/[0-9]+/); // + for at least one

      this.isUserPasswordValid =
        patternEngAtListOne.test(this.userPassword) &&
        patternSpeAtListOne.test(this.userPassword) &&
        patternNumAtListOne.test(this.userPassword) &&
        this.userPassword.length >= 8
          ? true
          : false;
    },

    async register() {
      if (!this.isUserNameValid || !this.isUserEmailValid || !this.isUserPasswordValid) return;

      let registerObj = {
        userName: this.userName,
        userEmail: this.userEmail,
        userPassword: this.userPassword,
      };
      //axios가 json으로 parameter를 보내는 방법? 객체를 전달
      try {
        let { data } = await http.post("/api/users", registerObj); // JSON Request, { params : registerObj } X params 를 쓰면 get => query string
        let $this = this;
        this.$store.commit("SET_REGISTERED_USERID", data.id);
        console.log(this.$store.state.registeredUserId);
        this.$alertify.alert("회원가입을 축하합니다. 관심지역 등록 페이지로 이동합니다", function () {
          $this.$router.push("/address");
        });
      } catch (error) {
        console.log(error);
        this.$alertify.error("서버에 문제가 발생했습니다.");
      }
    },
  },
};
</script>

<style></style>
