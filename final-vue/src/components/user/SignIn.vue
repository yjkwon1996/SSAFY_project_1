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
              <router-link class="navbar-brand font-weight-bolder ms-lg-0" to="/"
                >Corporate UI</router-link
              >
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
                    <router-link class="nav-link d-flex align-items-center me-2" to="/register">
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
                          d="M12 1.5a5.25 5.25 0 00-5.25 5.25v3a3 3 0 00-3 3v6.75a3 3 0 003 3h10.5a3 3 0 003-3v-6.75a3 3 0 00-3-3v-3c0-2.9-2.35-5.25-5.25-5.25zm3.75 8.25v-3a3.75 3.75 0 10-7.5 0v3h7.5z"
                          clip-rule="evenodd"
                        />
                      </svg>
                      Sign Up
                    </router-link>
                  </li>
                  <li class="nav-item">
                    <router-link
                      class="nav-link d-flex align-items-center me-2 text-dark font-weight-bold"
                      to="/Login"
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
                          d="M15.75 1.5a6.75 6.75 0 00-6.651 7.906c.067.39-.032.717-.221.906l-6.5 6.499a3 3 0 00-.878 2.121v2.818c0 .414.336.75.75.75H6a.75.75 0 00.75-.75v-1.5h1.5A.75.75 0 009 19.5V18h1.5a.75.75 0 00.53-.22l2.658-2.658c.19-.189.517-.288.906-.22A6.75 6.75 0 1015.75 1.5zm0 3a.75.75 0 000 1.5A2.25 2.25 0 0118 8.25a.75.75 0 001.5 0 3.75 3.75 0 00-3.75-3.75z"
                          clip-rule="evenodd"
                        />
                      </svg>
                      Sign In
                    </router-link>
                  </li>
                </ul>
                <ul class="navbar-nav d-lg-block d-none">
                  <li class="nav-item">
                    <a
                      href="https://www.creative-tim.com/product/corporate-ui-dashboard"
                      class="btn btn-sm mb-0 bg-gradient-dark"
                      >Free download</a
                    >
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
              <div class="col-xl-4 col-md-6 d-flex flex-column mx-auto">
                <div class="card card-plain mt-8">
                  <div class="card-header pb-0 text-left bg-transparent">
                    <h3 class="font-weight-black text-dark display-6">Login</h3>
                    <p class="mb-0">Welcome back! Please enter your details.</p>
                  </div>
                  <div class="card-body">
                    <form role="form">
                      <label>Email Address</label>
                      <div class="mb-3">
                        <input
                          type="email"
                          class="form-control"
                          placeholder="Enter your email address"
                          aria-label="Email"
                          aria-describedby="email-addon"
                          v-model="userEmail"
                        />
                      </div>
                      <label>Password</label>
                      <div class="mb-3">
                        <input
                          type="password"
                          class="form-control"
                          placeholder="Enter password"
                          aria-label="Password"
                          aria-describedby="password-addon"
                          v-model="userPassword"
                        />
                      </div>
                      <div class="d-flex align-items-center">
                        <div class="form-check form-check-info text-left mb-0">
                          <input
                            class="form-check-input"
                            type="checkbox"
                            value=""
                            id="flexCheckDefault"
                          />
                          <label class="font-weight-normal text-dark mb-0" for="flexCheckDefault">
                            Remember for 14 days
                          </label>
                        </div>
                        <a href="javascript:;" class="text-xs font-weight-bold ms-auto"
                          >Forgot password</a
                        >
                      </div>
                      <div class="text-center">
                        <button type="button" @click="login" class="btn btn-dark w-100 mt-4 mb-3">
                          Sign in
                        </button>
                        <button
                          @click="loginWithKakao"
                          style="border: 0px; background-color: white; width: 100%; padding: 0px"
                        >
                          <img
                            style="width: 100%; height: 38px"
                            src="../assets/img/kakao_login_medium_wide.png"
                            alt="kakao-logo"
                          />
                        </button>
                      </div>
                    </form>
                  </div>
                  <div class="card-footer text-center pt-0 px-lg-2 px-1">
                    <p class="mb-4 text-xs mx-auto">
                      Don't have an account?
                      <a href="javascript:;" class="text-dark font-weight-bold">Sign up</a>
                    </p>
                  </div>
                </div>
              </div>
              <div class="col-md-6">
                <div class="position-absolute w-40 top-0 end-0 h-100 d-md-block d-none">
                  <div
                    class="oblique-image position-absolute fixed-top ms-auto h-100 z-index-0 bg-cover ms-n8"
                    style="background-image: url('../assets/img/image-sign-in.jpg')"
                  >
                    <div
                      class="blur mt-12 p-4 text-center border border-white border-radius-md position-absolute fixed-bottom m-4"
                    >
                      <h2 class="mt-3 text-dark font-weight-bold">
                        Enter our global community of developers.
                      </h2>
                      <h6 class="text-dark text-sm mt-5">
                        Copyright © 2022 Corporate UI Design System by Creative Tim.
                      </h6>
                    </div>
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

import http from "@/common/axios.js"; // axios 객체

export default {
  data() {
    return {
      userEmail: "",
      userPassword: "",
    };
  },
  methods: {
    async login() {
      try {
        let response = await http.post("http://localhost:9999/api/login", {
          userEmail: this.userEmail,
          userPassword: this.userPassword,
        });
        let { data } = response;

        console.log(data);

        // 로그인 성공에 대한 처리
        this.$store.commit("SET_LOGIN", {
          loginStatus: true,
          user: {
            userId: data.id,
            userName: data.userName,
            userEmail: data.userEmail,
            userRegisterDate: data.userRegisterDate,
            userProfileImageUrl: data.userProfileImageUrl,
            isAdmin: data.isAdmin,
          },
        });
        // BoardMain 으로 이동
        alert("로그인 완료");
        this.$router.push("/");
      } catch (error) {
        console.error(error);
        if (error.response.status == "404") {
          this.$alertify.error("이메일 또는 비밀번호를 확인하세요.");
        } else {
          this.$alertify.error("서버에 문제가 생겼습니다.");
        }
      }
    },
    loginWithKakao() {
      var $this = this;

      Kakao.Auth.login({
        success: function (authObj) {
          // access_token 등 데이터가 전달된다.
          // 백엔드에 access_token 을 전달하고 user info 를 받는 방식이라면 authObj 의 access_token 을 이용한다.
          // https://developers.kakao.com/sdk/reference/js/release/Kakao.Auth.html#AuthSuccessCallback
          // 이 코드는 javascript 로 user info 를 받는 방식으로 처리한다.
          console.log("----1");
          console.log(authObj);

          // 인증ㅡ면 개인 프로파일 정보를 얻어온다. /v2/user/me
          Kakao.API.request({
            url: "/v2/user/me",
            success: async function (response) {
              if (Kakao.Auth.getAccessToken()) {
                console.log("----2");
                console.log(response);
                // Kakao Login 동의항목 부분 check
                // 이메일로 회원 가입 여부 확인 후 회원이 아닌 경우는 메세지와 함께 회원 가입 페이지로 이동
                if (!response.kakao_account.has_email || !response.kakao_account.is_email_valid) {
                  alert("kakao 인증 이메일이 없거나, 유효하지 않습니다.");
                  return;
                } else {
                  // 이미 가입한 회원
                  // async, await 필수!!
                  let result = await $this.isRegisteredUser(response.kakao_account.email);
                  console.log("----3");
                  console.log(result);
                  if (result) {
                    $this.$store.commit("SET_LOGIN", {
                      isLogin: true,
                      userName: response.properties.nickname,
                      userProfileImageUrl: response.properties.thumbnail_image,
                    });
                  } else {
                    // 가입하지 않은 회원
                    alert("kakao 인증되었으나, 회원 가입이 필요합니다.");
                    let params = {
                      userName: response.properties.nickname,
                      userEmail: response.kakao_account.email,
                    };
                    $this.$router.push({ name: "RegisterPage", params }); // params : params
                  }
                }
              }
            },
            fail: function (error) {
              console.log("----4");
              console.log(error);
            },
          });
        },
        fail: function (error) {
          console.err("----------");
          console.error(error);
        },
      });
    },
    async isRegisteredUser(email) {
      console.log(2);
      console.log(email);
      try {
        let { data } = await http.get(`/isRegisteredUser?email=${email}`);
        console.warn(data);
        console.warn(data.result);
        if (data.result == "registered") return true;
        else return false;
      } catch (error) {
        console.log(error);
      }
    },
  },
  mounted() {
    /* global Kakao */
    if (typeof Kakao != undefined) return;

    const script = document.createElement("script");

    script.onload = () => Kakao.init(process.env.VUE_APP_KAKAO_JAVASCRIPT_KEY);
    script.src = "https://developers.kakao.com/sdk/js/kakao.js";
    document.head.appendChild(script);
  },
};
</script>

<style scoped>
</style>
