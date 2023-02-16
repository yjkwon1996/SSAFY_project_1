import Vue from "vue";
import VueRouter from "vue-router";

// Vue + Router
Vue.use(VueRouter);

import NavBar from "@/components/common/NavBar.vue";
import MainPage from "@/components/main/MainPage.vue";
import UserProfile from "@/components/user/UserProfile.vue";
import SignIn from "@/components/user/SignIn.vue";
import SignUp from "@/components/user/SignUp.vue";
import MapPage from "@/components/house/MapPage.vue";
import AdminPage from "@/components/adm/AdminPage.vue";
import MapSection from "@/components/house/MapSection.vue";
import HouseSearchBar from "@/components/house/HouseSearchBar.vue";
import BoardPage from "@/components/board/BoardPage.vue";
import AddressGrid from "@/components/address/AddressGrid.vue";

export default new VueRouter({
  routes: [
    {
      path: "/",
      components: {
        NavBar: NavBar,
        default: MainPage,
      },
    },
    {
      path: "/profile",
      components: {
        default: UserProfile,
      },
    },
    {
      name: "LoginPage",
      path: "/login",
      components: {
        default: SignIn,
      },
    },
    {
      name: "RegisterPage",
      path: "/register",
      components: {
        default: SignUp,
      },
    },
    {
      path: "/map",
      components: {
        default: MapPage,
        MapSection: MapSection,
        HouseSearchBar: HouseSearchBar,
      },
    },
    {
      path: "/admin",
      components: {
        NavBar: NavBar,
        default: AdminPage,
      },
    },
    {
      path: "/board",
      components: {
        NavBar: NavBar,
        default: BoardPage,
      },
    },
    {
      path: "/address",
      components: {
        default: AddressGrid,
      },
    },
  ],
});
