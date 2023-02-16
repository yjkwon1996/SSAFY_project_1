<template>
  <div>
    <main class="main-content max-height-vh-100 h-100">
      <!-- Sidenav Top -->
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
            <li class="nav-item px-3 py-3 border-radius-sm bg-slate-800 d-flex align-items-center">
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
                      <img :src="makeImageUrl()" alt="profile_image" class="w-100 border-radius-md" />
                    </div>
                  </li>
                </router-link>
              </li>
            </ul>
          </div>
        </div>
      </nav>
    </main>
    <house-search-bar></house-search-bar>
    <map-section></map-section>
  </div>
</template>

<script>
import MapSection from "./MapSection.vue";
import HouseSearchBar from "./HouseSearchBar.vue";
import { mapState } from "vuex";

export default {
  computed: {
    ...mapState(["user"]),
  },
  components: { MapSection, HouseSearchBar },
  methods: {
    makeImageUrl() {
      return `${this.user.userProfileImageUrl}`;
    },
  },
};
</script>

<style></style>
