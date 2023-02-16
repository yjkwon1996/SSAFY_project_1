<template>
  <div class="ps">
    <router-view name="NavBar"></router-view>
    <router-view></router-view>
    <spinnerUI v-if="isLoading"></spinnerUI>
  </div>
</template>

<script>
import Navbar from "./components/common/NavBar.vue";
import SpinnerUI from "./components/ui_component/SpinnerUI.vue";
import http from "./common/axios";

export default {
  name: "App",
  data() {
    return {
      isLoading: false,
    };
  },
  components: {
    Navbar,
    SpinnerUI,
  },
  // spinner
  created() {
    http.interceptors.request.use(
      (config) => {
        this.isLoading = true;
        return config;
      },
      (error) => {
        this.isLoading = false;
        return Promise.reject(error);
      }
    );

    http.interceptors.response.use(
      (response) => {
        this.isLoading = false;
        return response;
      },
      (error) => {
        this.isLoading = false;
        return Promise.reject(error);
      }
    );
  },
};
</script>

<style>
@import url("https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css");
</style>
