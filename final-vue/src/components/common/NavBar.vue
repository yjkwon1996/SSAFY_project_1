<template>
  <aside
    class="sidenav navbar navbar-vertical navbar-expand-xs border-0 bg-slate-900 fixed-start"
    id="sidenav-main"
  >
    <div class="sidenav-header">
      <i
        class="fas fa-times p-3 cursor-pointer text-secondary opacity-5 position-absolute end-0 top-0 d-none d-xl-none"
        aria-hidden="true"
        id="iconSidenav"
      ></i>
      <router-link to="/" class="navbar-brand d-flex align-items-center m-0">
        <div class="container">
          <div class="neon">Neon </div>
          <div class="flux">Flux </div>
        </div>
      </router-link>
    </div>
    <div class="collapse navbar-collapse px-4 w-auto ps ps--active-x" id="sidenav-collapse-main" style="margin-top: 100px;">
      <ul class="navbar-nav">
        <li class="nav-item">
          <router-link to="/" class="nav-link nav-link-text ms-1">
            <div
              class="icon icon-shape icon-sm px-0 text-center d-flex align-items-center justify-content-center"
            >
              <svg
                width="30px"
                height="30px"
                viewBox="0 0 48 48"
                version="1.1"
                xmlns="http://www.w3.org/2000/svg"
                xmlns:xlink="http://www.w3.org/1999/xlink"
              >
                <title>dashboard</title>
                <g id="dashboard" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
                  <g
                    id="template"
                    transform="translate(12.000000, 12.000000)"
                    fill="#FFFFFF"
                    fill-rule="nonzero"
                  >
                    <path
                      class="color-foreground"
                      d="M0,1.71428571 C0,0.76752 0.76752,0 1.71428571,0 L22.2857143,0 C23.2325143,0 24,0.76752 24,1.71428571 L24,5.14285714 C24,6.08962286 23.2325143,6.85714286 22.2857143,6.85714286 L1.71428571,6.85714286 C0.76752,6.85714286 0,6.08962286 0,5.14285714 L0,1.71428571 Z"
                      id="Path"
                    ></path>
                    <path
                      class="color-background"
                      d="M0,12 C0,11.0532171 0.76752,10.2857143 1.71428571,10.2857143 L12,10.2857143 C12.9468,10.2857143 13.7142857,11.0532171 13.7142857,12 L13.7142857,22.2857143 C13.7142857,23.2325143 12.9468,24 12,24 L1.71428571,24 C0.76752,24 0,23.2325143 0,22.2857143 L0,12 Z"
                      id="Path"
                    ></path>
                    <path
                      class="color-background"
                      d="M18.8571429,10.2857143 C17.9103429,10.2857143 17.1428571,11.0532171 17.1428571,12 L17.1428571,22.2857143 C17.1428571,23.2325143 17.9103429,24 18.8571429,24 L22.2857143,24 C23.2325143,24 24,23.2325143 24,22.2857143 L24,12 C24,11.0532171 23.2325143,10.2857143 22.2857143,10.2857143 L18.8571429,10.2857143 Z"
                      id="Path"
                    ></path>
                  </g>
                </g>
              </svg>
            </div>
            dashboard
          </router-link>
        </li>
        <li class="nav-item">
          <router-link to="/board" class="nav-link-text ms-1 nav-link">
            <div
              class="icon icon-shape icon-sm px-0 text-center d-flex align-items-center justify-content-center"
            >
              <svg
                width="30px"
                height="30px"
                viewBox="0 0 48 48"
                version="1.1"
                xmlns="http://www.w3.org/2000/svg"
                xmlns:xlink="http://www.w3.org/1999/xlink"
              >
                <title>board</title>
                <g id="board" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
                  <g id="credit-card" transform="translate(12.000000, 15.000000)" fill="#FFFFFF">
                    <path
                      class="color-background"
                      d="M3,0 C1.343145,0 0,1.343145 0,3 L0,4.5 L24,4.5 L24,3 C24,1.343145 22.6569,0 21,0 L3,0 Z"
                      id="Path"
                      fill-rule="nonzero"
                    ></path>
                    <path
                      class="color-foreground"
                      d="M24,7.5 L0,7.5 L0,15 C0,16.6569 1.343145,18 3,18 L21,18 C22.6569,18 24,16.6569 24,15 L24,7.5 Z M3,13.5 C3,12.67155 3.67158,12 4.5,12 L6,12 C6.82842,12 7.5,12.67155 7.5,13.5 C7.5,14.32845 6.82842,15 6,15 L4.5,15 C3.67158,15 3,14.32845 3,13.5 Z M10.5,12 C9.67158,12 9,12.67155 9,13.5 C9,14.32845 9.67158,15 10.5,15 L12,15 C12.82845,15 13.5,14.32845 13.5,13.5 C13.5,12.67155 12.82845,12 12,12 L10.5,12 Z"
                      id="Shape"
                    ></path>
                  </g>
                </g>
              </svg>
            </div>
            board
          </router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link nav-link-text ms-1" to="/map">
            <div
              class="icon icon-shape icon-sm px-0 text-center d-flex align-items-center justify-content-center"
            >
              <svg
                width="30px"
                height="30px"
                viewBox="0 0 48 48"
                version="1.1"
                xmlns="http://www.w3.org/2000/svg"
                xmlns:xlink="http://www.w3.org/1999/xlink"
              >
                <title>map</title>
                <g id="map" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
                  <g id="credit-card" transform="translate(12.000000, 15.000000)" fill="#FFFFFF">
                    <path
                      class="color-background"
                      d="M3,0 C1.343145,0 0,1.343145 0,3 L0,4.5 L24,4.5 L24,3 C24,1.343145 22.6569,0 21,0 L3,0 Z"
                      id="Path"
                      fill-rule="nonzero"
                    ></path>
                    <path
                      class="color-foreground"
                      d="M24,7.5 L0,7.5 L0,15 C0,16.6569 1.343145,18 3,18 L21,18 C22.6569,18 24,16.6569 24,15 L24,7.5 Z M3,13.5 C3,12.67155 3.67158,12 4.5,12 L6,12 C6.82842,12 7.5,12.67155 7.5,13.5 C7.5,14.32845 6.82842,15 6,15 L4.5,15 C3.67158,15 3,14.32845 3,13.5 Z M10.5,12 C9.67158,12 9,12.67155 9,13.5 C9,14.32845 9.67158,15 10.5,15 L12,15 C12.82845,15 13.5,14.32845 13.5,13.5 C13.5,12.67155 12.82845,12 12,12 L10.5,12 Z"
                      id="Shape"
                    ></path>
                  </g>
                </g>
              </svg>
            </div>
            map
          </router-link>
        </li>
        <li class="nav-item" v-if="this.loginStatus & this.user.isAdmin">
          <router-link to="/admin" class="nav-link nav-link-text ms-1">
            <div
              class="icon icon-shape icon-sm px-0 text-center d-flex align-items-center justify-content-center"
            >
              <svg
                width="30px"
                height="30px"
                viewBox="0 0 48 48"
                version="1.1"
                xmlns="http://www.w3.org/2000/svg"
                xmlns:xlink="http://www.w3.org/1999/xlink"
              >
                <title>table</title>
                <g id="table" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
                  <g
                    id="view-grid"
                    transform="translate(12.000000, 12.000000)"
                    fill="#FFFFFF"
                    fill-rule="nonzero"
                  >
                    <path
                      class="color-foreground"
                      d="M3.42857143,0 C1.53502286,0 0,1.53502286 0,3.42857143 L0,6.85714286 C0,8.75069143 1.53502286,10.2857143 3.42857143,10.2857143 L6.85714286,10.2857143 C8.75069143,10.2857143 10.2857143,8.75069143 10.2857143,6.85714286 L10.2857143,3.42857143 C10.2857143,1.53502286 8.75069143,0 6.85714286,0 L3.42857143,0 Z"
                      id="Path"
                    ></path>
                    <path
                      class="color-background"
                      d="M3.42857143,13.7142857 C1.53502286,13.7142857 0,15.2492571 0,17.1428571 L0,20.5714286 C0,22.4650286 1.53502286,24 3.42857143,24 L6.85714286,24 C8.75069143,24 10.2857143,22.4650286 10.2857143,20.5714286 L10.2857143,17.1428571 C10.2857143,15.2492571 8.75069143,13.7142857 6.85714286,13.7142857 L3.42857143,13.7142857 Z"
                      id="Path"
                    ></path>
                    <path
                      class="color-background"
                      d="M13.7142857,3.42857143 C13.7142857,1.53502286 15.2492571,0 17.1428571,0 L20.5714286,0 C22.4650286,0 24,1.53502286 24,3.42857143 L24,6.85714286 C24,8.75069143 22.4650286,10.2857143 20.5714286,10.2857143 L17.1428571,10.2857143 C15.2492571,10.2857143 13.7142857,8.75069143 13.7142857,6.85714286 L13.7142857,3.42857143 Z"
                      id="Path"
                    ></path>
                    <path
                      class="color-foreground"
                      d="M13.7142857,17.1428571 C13.7142857,15.2492571 15.2492571,13.7142857 17.1428571,13.7142857 L20.5714286,13.7142857 C22.4650286,13.7142857 24,15.2492571 24,17.1428571 L24,20.5714286 C24,22.4650286 22.4650286,24 20.5714286,24 L17.1428571,24 C15.2492571,24 13.7142857,22.4650286 13.7142857,20.5714286 L13.7142857,17.1428571 Z"
                      id="Path"
                    ></path>
                  </g>
                </g>
              </svg>
            </div>
            admin
          </router-link>
        </li>

        <li class="nav-item mt-2">
          <div class="d-flex align-items-center nav-link">
            <div v-if="isLoginGetters">
              <img v-bind:src="imgURL" style="height:16px; width:16px border-radius:50%;" />
            </div>
            <div v-else>
              <svg
                xmlns="http://www.w3.org/2000/svg"
                width="16"
                height="16"
                class="ms-2"
                viewBox="0 0 24 24"
                fill="currentColor"
              >
                <path
                  fill-rule="evenodd"
                  d="M18.685 19.097A9.723 9.723 0 0021.75 12c0-5.385-4.365-9.75-9.75-9.75S2.25 6.615 2.25 12a9.723 9.723 0 003.065 7.097A9.716 9.716 0 0012 21.75a9.716 9.716 0 006.685-2.653zm-12.54-1.285A7.486 7.486 0 0112 15a7.486 7.486 0 015.855 2.812A8.224 8.224 0 0112 20.25a8.224 8.224 0 01-5.855-2.438zM15.75 9a3.75 3.75 0 11-7.5 0 3.75 3.75 0 017.5 0z"
                  clip-rule="evenodd"
                />
              </svg>
            </div>
            <span class="font-weight-normal text-md ms-2" v-if="isLoginGetters"
              >{{ this.user.userName }}님</span
            >
            <span class="font-weight-normal text-md ms-2" v-else>Account Pages</span>
          </div>
        </li>
        <li v-if="isLoginGetters" class="nav-item border-start my-0 pt-2">
          <router-link class="nav-link position-relative ms-0 ps-2 py-2" to="/profile"
            >Profile</router-link
          >
        </li>
        <li v-if="!isLoginGetters" class="nav-item border-start my-0 pt-2">
          <router-link class="nav-link position-relative ms-0 ps-2 py-2" to="/login"
            >Sign In</router-link
          >
        </li>
        <li v-if="!isLoginGetters" class="nav-item border-start my-0 pt-2">
          <router-link class="nav-link position-relative ms-0 ps-2 py-2" to="/register"
            >Sign Up</router-link
          >
        </li>
        <li v-if="isLoginGetters" class="nav-item border-start my-0 pt-2">
          <a
            class="nav-link position-relative ms-0 ps-2 py-2"
            style="cursor: pointer"
            @click="logout"
            >Logout</a
          >
        </li>
      </ul>
    </div>
    <div class="sidenav-footer mx-4" style="position: absolute; bottom: 0; padding: 10px">
      <div class="card border-radius-md" id="sidenavCard">
        <div class="card-body text-start p-3 w-100" style="min-width: 170px">
          <div class="mb-3 font-weight-bold down" style="color: white; font-size: 15px">☎ HELP</div>
          <div class="docs-info">
            <h6 class="font-weight-semibold up mb-2">You need help?</h6>
            <a>
              <i
                class="fas fa-arrow-right-long ms-1"
                aria-hidden="true"
                style="font-size: 12px; letter-spacing: 2px"
              >
                010-1111-2222</i
              >
            </a>
          </div>
        </div>
      </div>
    </div>
  </aside>
</template>

<script>
import Vue from "vue";
import VueAlertify from "vue-alertify";

Vue.use(VueAlertify);

import http from "@/common/axios.js"; // axios 객체
import { mapState } from "vuex";
export default {
  data() {
    return {};
  },
  methods: {
    async logout() {
      try {
        let response = await http.get(`http://localhost:9999/api/logout/${this.user.userId}`);

        this.$alertify.success("성공적으로 로그아웃 되었습니다.");
        this.$store.commit("SET_LOGIN", {
          loginStatus: false,
          user: {
            userId: 0,
            userName: "",
            userEmail: "",
            userRegisterDate: "",
            userProfileImageUrl: "",
            isAdmin: false,
          },
        });
        // Dashboard 이동
        this.$router.go(this.$router.currentRoute);
      } catch (error) {
        console.error(error);
      }
    },
  },
  computed: {
    ...mapState(["loginStatus", "user"]),
    isLoginGetters() {
      return this.$store.getters.getLoginStatus;
    },
    imgURL() {
      return `${this.user.userProfileImageUrl}`;
    },
  },
  mounted() {
    // 주의 if( Kakao == undefined ) 는 오류 발생 typeof 필요
    // typeof Kakao 는 string "undefined" 를 return
    // if (typeof Kakao !== undefined) return; 은 문법 오류는 아니나, Kakao 가 is not defuned 발생
    /* global Kakao */
    if (typeof Kakao !== "undefined") return;

    const script = document.createElement("script");

    // script.onload = () => Kakao.init(process.env.VUE_APP_KAKAO_JAVASCRIPT_KEY);
    script.onload = () => Kakao.init("8dafe1cee8acf91e33f0c004d23a449f");
    script.src = "https://developers.kakao.com/sdk/js/kakao.js";
    document.head.appendChild(script);
  },
};
</script>

<style scoped>
aside .navbar-nav a.router-link-exact-active {
  background-color: rgba(255, 255, 255, 0.082) !important;
  border-radius: 5%;
  font-weight: bold !important;
}

html,
body {
  margin: 0;
  padding: 0;
  width: 100%;
  height: 100%;
  display: table;
  background-color: black;
}

@font-face {
  font-family: neon;
  src: url(https://s3-us-west-2.amazonaws.com/s.cdpn.io/707108/neon.ttf);
}

.container {
  display: table-cell;
  text-align: center;
  vertical-align: middle;
}

.neon {
  font-family: neon;
  color: #FB4264;
  font-size: 2vw;
  line-height: 2vw;
  text-shadow: 0 0 1vw #F40A35;
}

.flux {
  font-family: neon;
  color: #426DFB;
  font-size: 2vw;
  line-height: 2vw;
  text-shadow: 0 0 1vw #2356FF;
}

.neon {
  animation: neon 1s ease infinite;
  -moz-animation: neon 1s ease infinite;
  -webkit-animation: neon 1s ease infinite;
}

@keyframes neon {
  0%,
  100% {
    text-shadow: 0 0 1vw #FA1C16, 0 0 3vw #FA1C16, 0 0 10vw #FA1C16, 0 0 10vw #FA1C16, 0 0 .4vw #FED128, .5vw .5vw .1vw #806914;
    color: #FED128;
  }
  50% {
    text-shadow: 0 0 .5vw #800E0B, 0 0 1.5vw #800E0B, 0 0 5vw #800E0B, 0 0 5vw #800E0B, 0 0 .2vw #800E0B, .5vw .5vw .1vw #40340A;
    color: #806914;
  }
}

.flux {
  animation: flux 2s linear infinite;
  -moz-animation: flux 2s linear infinite;
  -webkit-animation: flux 2s linear infinite;
  -o-animation: flux 2s linear infinite;
}

@keyframes flux {
  0%,
  100% {
    text-shadow: 0 0 1vw #1041FF, 0 0 3vw #1041FF, 0 0 10vw #1041FF, 0 0 10vw #1041FF, 0 0 .4vw #8BFDFE, .5vw .5vw .1vw #147280;
    color: #28D7FE;
  }
  50% {
    text-shadow: 0 0 .5vw #082180, 0 0 1.5vw #082180, 0 0 5vw #082180, 0 0 5vw #082180, 0 0 .2vw #082180, .5vw .5vw .1vw #0A3940;
    color: #146C80;
  }
}
</style>
