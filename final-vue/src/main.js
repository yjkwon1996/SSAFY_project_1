import Vue from "vue";
import App from "./App.vue";
import store from "@/store/store.js";

import router from "./routers/router.js";
import "bootstrap-icons/font/bootstrap-icons.css";
// bootstrap 5
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap";

Vue.config.productionTip = false;

new Vue({
  render: (h) => h(App),
  router,
  store,
}).$mount("#app");
