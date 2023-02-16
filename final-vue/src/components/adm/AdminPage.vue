<template>
  <main
    class="main-content position-relative max-height-vh-100 h-100 border-radius-lg"
    style="overflow-y: auto; overflow-x: hidden"
  >
    <!-- Navbar -->
    <nav class="navbar navbar-main navbar-expand-lg mx-5 px-0 shadow-none rounded" id="navbarBlur" navbar-scroll="true">
      <div class="container-fluid py-1 px-2">
        <nav aria-label="breadcrumb">
          <ol class="breadcrumb bg-transparent mb-1 pb-0 pt-1 px-0 me-sm-6 me-5">
            <li class="breadcrumb-item text-sm">
              <a class="opacity-5 text-dark" href="javascript:;">Dashboard</a>
            </li>
            <li class="breadcrumb-item text-sm text-dark active" aria-current="page">Admin</li>
          </ol>
          <h6 class="font-weight-bold mb-0">Administrator</h6>
        </nav>
      </div>
    </nav>
    <!-- End Navbar -->
    <div class="container-fluid py-4 px-5">
      <div class="row">
        <div class="col-12">
          <div class="card card-background card-background-after-none align-items-start mt-4 mb-5">
            <img
              src="../assets/img/3d-cube.png"
              alt="3d-cube"
              class="position-absolute top-0 end-1 w-25 max-width-200 mt-n6 d-sm-block d-none"
              style="z-index: 999"
            />
          </div>
        </div>
      </div>
      <div class="row" style="margin-top: 50px">
        <div class="col-12">
          <div class="card border shadow-xs mb-4">
            <div class="card-header border-bottom pb-0">
              <div class="d-sm-flex align-items-center">
                <div>
                  <h6 class="font-weight-semibold text-lg mb-0">User list</h6>
                  <p class="text-sm">See information about all users</p>
                </div>
                <div class="input-group w-sm-25 ms-auto">
                  <span class="input-group-text text-body" style="cursor: pointer" @click="userList">
                    <svg
                      xmlns="http://www.w3.org/2000/svg"
                      width="16px"
                      height="16px"
                      fill="none"
                      viewBox="0 0 24 24"
                      stroke-width="1.5"
                      stroke="currentColor"
                    >
                      <path
                        stroke-linecap="round"
                        stroke-linejoin="round"
                        d="M21 21l-5.197-5.197m0 0A7.5 7.5 0 105.196 5.196a7.5 7.5 0 0010.607 10.607z"
                      ></path>
                    </svg>
                  </span>
                  <input
                    type="text"
                    class="form-control"
                    placeholder="이름 검색"
                    v-model="$store.state.userList.searchWord"
                    @keydown.enter="userList"
                  />
                </div>
              </div>
            </div>
            <div class="card-body px-0 py-0">
              <div class="table-responsive p-0">
                <table class="table align-items-center mb-0">
                  <thead class="bg-gray-100">
                    <tr>
                      <th class="text-secondary text-xs font-weight-semibold opacity-7">User</th>
                      <th class="text-secondary text-xs font-weight-semibold opacity-7 ps-2">Authority</th>
                      <th class="text-center text-secondary text-xs font-weight-semibold opacity-7">Status</th>
                      <th class="text-center text-secondary text-xs font-weight-semibold opacity-7">Registerd</th>
                      <th class="text-secondary opacity-7"></th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr v-for="(user, index) in listGetters" :key="index">
                      <!-- v-for로 회원리스트를 받아와서 넣으면 된다. userProfileImage는? - 가능하면 -->
                      <td>
                        <div class="d-flex px-2 py-1">
                          <div class="d-flex align-items-center">
                            <img
                              src="../assets/img/team-2.jpg"
                              class="avatar avatar-sm rounded-circle me-2"
                              alt="user1"
                            />
                          </div>
                          <div class="d-flex flex-column justify-content-center ms-1">
                            <h6 class="mb-0 text-sm font-weight-semibold">{{ user.userName }}</h6>
                            <p class="text-sm text-secondary mb-0">{{ user.userEmail }}</p>
                          </div>
                        </div>
                      </td>
                      <td>
                        <p class="text-sm text-dark font-weight-semibold mb-0">
                          {{ user.admin ? "관리자" : "일반회원" }}
                        </p>
                      </td>
                      <td class="align-middle text-center text-sm">
                        <span class="badge badge-sm border border-success text-success bg-success" v-if="user.loggedIn">
                          Online
                        </span>
                        <span class="badge badge-sm border border-secondary text-secondary bg-secondary" v-else>
                          Offline
                        </span>
                      </td>
                      <td class="align-middle text-center">
                        <span class="text-secondary text-sm font-weight-normal">{{
                          user.userRegisterDate | makeDateStr("/")
                        }}</span>
                      </td>
                      <td class="align-middle" @click="showAdminModal(user)">
                        <!-- 관리자가 회원 정보를 수정-> 모달창을 띄운 뒤 정보 수정이 가능하도록 -->
                        <a
                          href="javascript:;"
                          class="text-secondary font-weight-bold text-xs"
                          data-bs-toggle="tooltip"
                          data-bs-title="Edit user"
                        >
                          <svg
                            width="14"
                            height="14"
                            viewBox="0 0 15 16"
                            fill="none"
                            xmlns="http://www.w3.org/2000/svg"
                          >
                            <path
                              d="M11.2201 2.02495C10.8292 1.63482 10.196 1.63545 9.80585 2.02636C9.41572 2.41727 9.41635 3.05044 9.80726 3.44057L11.2201 2.02495ZM12.5572 6.18502C12.9481 6.57516 13.5813 6.57453 13.9714 6.18362C14.3615 5.79271 14.3609 5.15954 13.97 4.7694L12.5572 6.18502ZM11.6803 1.56839L12.3867 2.2762L12.3867 2.27619L11.6803 1.56839ZM14.4302 4.31284L15.1367 5.02065L15.1367 5.02064L14.4302 4.31284ZM3.72198 15V16C3.98686 16 4.24091 15.8949 4.42839 15.7078L3.72198 15ZM0.999756 15H-0.000244141C-0.000244141 15.5523 0.447471 16 0.999756 16L0.999756 15ZM0.999756 12.2279L0.293346 11.5201C0.105383 11.7077 -0.000244141 11.9624 -0.000244141 12.2279H0.999756ZM9.80726 3.44057L12.5572 6.18502L13.97 4.7694L11.2201 2.02495L9.80726 3.44057ZM12.3867 2.27619C12.7557 1.90794 13.3549 1.90794 13.7238 2.27619L15.1367 0.860593C13.9869 -0.286864 12.1236 -0.286864 10.9739 0.860593L12.3867 2.27619ZM13.7238 2.27619C14.0917 2.64337 14.0917 3.23787 13.7238 3.60504L15.1367 5.02064C16.2875 3.8721 16.2875 2.00913 15.1367 0.860593L13.7238 2.27619ZM13.7238 3.60504L3.01557 14.2922L4.42839 15.7078L15.1367 5.02065L13.7238 3.60504ZM3.72198 14H0.999756V16H3.72198V14ZM1.99976 15V12.2279H-0.000244141V15H1.99976ZM1.70617 12.9357L12.3867 2.2762L10.9739 0.86059L0.293346 11.5201L1.70617 12.9357Z"
                              fill="#64748B"
                            />
                          </svg>
                        </a>
                      </td>
                    </tr>
                  </tbody>
                </table>
              </div>
              <div class="border-top py-3 px-3 d-flex align-items-center">
                <!-- Pagination을 이용하여 모든 유저리스트를 볼 수 있도록  -->
                <div style="margin: auto">
                  <PaginationAdminUI v-on:call-parent="movePage"></PaginationAdminUI>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <footer class="footer pt-3">
        <div class="container-fluid">
          <div class="row align-items-center justify-content-lg-between">
            <div class="col-lg-6 mb-lg-0 mb-4">
              <div class="copyright text-center text-xs text-muted text-lg-start">
                Copyright Corporate UI by
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
    <user-admin-update-modal></user-admin-update-modal>
  </main>
</template>

<script>
import Vue from "vue";
import VueAlertify from "vue-alertify";

import UserAdminUpdateModal from "./modal/UserAdminUpdateModal.vue";
import PaginationAdminUI from "@/components/pagination/PaginationAdminUI.vue";
import { Modal } from "bootstrap";

Vue.use(VueAlertify);

import http from "@/common/axios.js"; // axios 객체
import { mapState } from "vuex";
export default {
  components: { UserAdminUpdateModal, PaginationAdminUI },
  data() {
    return {
      adminModal: null,
    };
  },
  created() {
    this.userList();
  },
  computed: {
    ...mapState(["users", "adminModalOpen"]),
    checkModalOpen() {
      return this.adminModalOpen;
    },
    listGetters() {
      return this.$store.getters.getUserList;
    },
  },
  filters: {
    makeDateStr: function (date, separator) {
      console.log(date);
      let ret = "";
      ret += date[0] + separator;
      if (date[1] < 10) ret += "0";
      ret += date[1] + separator;
      if (date[2] < 10) ret += "0";
      ret += date[2];

      return ret;
    },
  },
  mounted() {
    this.adminModal = new Modal(document.querySelector("#adminModal"));
  },
  methods: {
    showAdminModal(user) {
      console.log(user);
      this.$store.commit("SET_MODAL", { modalOpen: true, user: user });
      this.adminModal.show();
    },

    userList() {
      this.$store.dispatch("userCount");
      this.$store.dispatch("userList");
    },

    // pagination
    movePage(pageIndex) {
      console.log("UserMainVue : movePage : pageIndex : " + pageIndex);

      // store commit 으로 변경
      // this.offset = (pageIndex - 1) * this.listRowCount;
      // this.currentPageIndex = pageIndex;
      this.$store.commit("SET_USER_MOVE_PAGE", pageIndex);
      this.userList();
    },
    async getAllUsers() {
      if (document.querySelector("#adminModal")) {
        var myModalEl = document.querySelector("#adminModal");
        myModalEl.addEventListener("hidden.bs.modal", function (event) {
          if (this.adminModalOpen) $this.$store.commit("SET_ADMIN_MODAL_OPEN", false);
        });
      }
      this.userList();
    },
  },
  watch: {
    checkModalOpen() {
      this.adminModal.hide();
      this.getAllUsers();
    },
  },
};
</script>

<style></style>
