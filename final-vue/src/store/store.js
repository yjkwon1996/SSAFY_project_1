import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

import http from "@/common/axios.js";
import util from "@/common/util.js";

import router from "@/routers/router";
import createPersistedState from "vuex-persistedstate";

export default new Vuex.Store({
  //   plugins: [createPersistedState()],
  state: {
    // main
    currentMonthHouses: [],
    // user
    loginStatus: false,

    user: {
      userId: 0,
      userName: "",
      userEmail: "",
      userRegisterDate: { day: 0, month: 0, year: 0 },
      userProfileImageUrl: "",
      userArea: [],
      isAdmin: false,
    },

    // map
    map: null,

    sidos: [{ value: null, text: "시도 선택" }],
    guguns: [{ value: null, text: "구군 선택" }],

    completeGetHouses: false,
    houses: [],

    houseInfoClicked: false,

    houseInfo: {
      houseName: "",
      houseAddress: "",
      houseDealPrice: 0,
      houseDealDate: "",
      houseGugunCode: 0,
      houseLat: 0,
      houseLng: 0,
    },

    // admin
    users: [],
    adminModalOpen: false,
    adminUserInfo: {
      userId: 0,
      userName: "",
      userEmail: "",
    },

    // admin list
    userList: {
      // list
      list: [],
      limit: 10,
      offset: 0,
      searchWord: "",

      // pagination
      listRowCount: 10,
      pageLinkCount: 10,
      currentPageIndex: 1,
      totalListItemCount: 0,

      userId: 0,
      isAdmin: 0,
      isLoggedIn: 0,
      useEmail: "",
      userName: "",
      userPassword: "",
      userRegisterDate: "",
    },

    // board
    board: {
      // list
      list: [],
      limit: 10,
      offset: 0,
      searchWord: "",

      // pagination
      listRowCount: 10,
      pageLinkCount: 10,
      currentPageIndex: 1,
      totalListItemCount: 0,

      // detail, update, delete

      boardId: 0,
      title: "",
      content: "",
      userName: "",
      regDate: "",
      regTime: "",
      readCount: 0,
      fileList: [],
      sameUser: false,
    },

    // interested area
    registeredUserId: 0,

    address: {
      sidoList: [],
      sido: "0", // 최초 선택 항목 지정
      gugunList: [],
      gugun: "0",
    },
  },
  mutations: {
    // main
    SET_CURRENT_MONTH_HOUSES(state, house) {
      state.currentMonthHouses.push(house);
    },
    CLEAR_CURRENT_MONTH_HOUSES(state) {
      state.currentMonthHouses = [];
    },
    SORT_CURRENT_MONTH_HOUSES(state) {
      let temp = [0, 0, 0, 0, 0];
      state.currentMonthHouses.sort((a, b) => {
        return b["일"] - a["일"];
      });

      for (let i = 0; i < 5; i++) {
        temp[i] = state.currentMonthHouses[i];
      }

      state.currentMonthHouses = temp;
    },
    SET_USER_AREA(state, area) {
      state.user.userArea.push(area);
    },

    // user
    SET_LOGIN_STATUS(state, payload) {
      state.loginStatus = payload;
    },
    // SET_USER(state, payload) {
    //   state.user.userId = payload.userId;
    //   state.user.userName = payload.userName;
    //   state.user.userProfileImageUrl = payload.userProfileImageUrl;
    // },
    SET_LOGIN(state, payload) {
      state.loginStatus = payload.loginStatus;
      state.user.userId = payload.user.userId;
      state.user.userName = payload.user.userName;
      state.user.userEmail = payload.user.userEmail;
      state.user.userRegisterDate = payload.user.userRegisterDate;
      console.log(payload.user.userProfileImageUrl);
      state.user.userProfileImageUrl = payload.user.userProfileImageUrl;
      state.user.isAdmin = payload.user.isAdmin;
    },
    SET_USER_UPDATE(state, payload) {
      state.user.userName = payload.userName;
      state.user.userEmail = payload.userEmail;
      state.user.userProfileImageUrl = payload.userProfileImageUrl;
    },
    // map
    SET_MAP(state, map) {
      state.map = map;
    },
    CLEAR_SIDO_LIST(state) {
      state.sidos = [];
    },
    CLEAR_GUGUN_LIST(state) {
      state.guguns = [];
    },
    CLEAR_HOUSE_LIST(state) {
      state.houses = [];
    },
    SET_SIDO_LIST(state, sidos) {
      sidos.forEach((sido) => {
        state.sidos.push({ value: sido.sidoCode, text: sido.sidoName });
      });
    },
    SET_GUGUN_LIST(state, guguns) {
      guguns.forEach((gugun) => {
        state.guguns.push({ value: gugun.gugunCode, text: gugun.gugunName });
      });
    },
    SET_HOUSE_LIST(state, houses) {
      state.houses.push(houses);
    },
    SET_COMPLETE_GET_HOUSES(state, completeGetHouses) {
      state.completeGetHouses = completeGetHouses;
    },
    SET_HOUSE_INFO_CLICKED(state, clicked) {
      state.houseInfoClicked = clicked;
    },
    SET_HOUSE_INFO(state, payload) {
      state.houseInfoClicked = payload.infoOpen;
      state.houseInfo = payload.houseInfo;
    },

    // admin
    SET_USERS(state, users) {
      state.users = users;
    },
    SET_ADMIN_MODAL_OPEN(state, status) {
      state.adminModalOpen = status;
    },
    SET_MODAL(state, payload) {
      state.adminModalOpen = payload.modalOpen;
      state.adminUserInfo.userId = payload.user.id;
      state.adminUserInfo.userName = payload.user.userName;
      state.adminUserInfo.userEmail = payload.user.userEmail;
    },
    SET_ADMIN_USER_INFO(state, userInfo) {
      state.adminUserInfo = userInfo;
    },

    // adminPaigination
    SET_USER_LIST(state, list) {
      state.userList.list = list;
    },
    SET_USER_TOTAL_LIST_ITEM_COUNT(state, count) {
      state.userList.totalListItemCount = count;
    },

    SET_USER_MOVE_PAGE(state, pageIndex) {
      state.userList.offset = pageIndex - 1; // offset 단위 처리
      state.userList.currentPageIndex = pageIndex;
    },

    SET_USER_DETAIL(state, payload) {
      state.userList.userId = payload.userId;
      state.userList.isAdmin = payload.isAdmin;
      state.userList.isLoggedIn = payload.isLoggedIn;
      state.userList.useEmail = payload.useEmail;
      state.userList.userName = payload.userName;
      state.userList.userPassword = payload.userPassword;
      state.userList.userRegisterDate = util.userRegisterDate(
        payload.userRegisterDate[0],
        payload.userRegisterDate[1],
        payload.userRegisterDate[2],
        "."
      );
    },

    // board
    SET_BOARD_LIST(state, list) {
      state.board.list = list;
    },

    SET_BOARD_TOTAL_LIST_ITEM_COUNT(state, count) {
      state.board.totalListItemCount = count;
    },

    SET_BOARD_MOVE_PAGE(state, pageIndex) {
      state.board.offset = (pageIndex - 1) * state.board.listRowCount;
      state.board.currentPageIndex = pageIndex;
    },

    SET_BOARD_DETAIL(state, payload) {
      state.board.boardId = payload.boardId;
      state.board.title = payload.title;
      state.board.content = payload.content;
      state.board.userName = payload.userName;
      state.board.regDate = util.makeDateStr(
        payload.regDt[0],
        payload.regDt[1],
        payload.regDt[2],
        "."
      );
      state.board.regTime = util.makeTimeStr(
        payload.regDt[3],
        payload.regDt[4],
        payload.regDt[5],
        ":"
      );
      state.board.readCount = payload.readCount;
      state.board.fileList = payload.fileList;
      state.board.sameUser = payload.sameUser;
    },
    // for UpdateModal title v-modal
    SET_BOARD_TITLE(state, title) {
      state.board.title = title;
    },

    // interested area
    SET_REGISTERED_USERID(state, userId) {
      state.registeredUserId = userId;
    },
    SET_ADDRESS_SIDOlIST(state, payload) {
      state.address.sidoList = payload;
      // state.address.currentList = state.address.sidoList;
      // state.address.currentAddress = "S";
    },
    SET_ADDRESS_GUGUNlIST(state, payload) {
      state.address.gugunList = payload;
      // state.address.currentList = state.address.gugunList;
      // state.address.currentAddress = "G";
    },
    SET_ADDRESS_DONGlIST(state, payload) {
      state.address.dongList = payload;
      // state.address.currentList = state.address.dongList;
      // state.address.currentAddress = "D";
    },

    SET_ADDRESS_SIDO(state, payload) {
      state.address.sido = payload;

      state.address.gugun = "0";
      state.address.dong = "0";
      state.address.gugunList = [];
    },
    SET_ADDRESS_GUGUN(state, payload) {
      state.address.gugun = payload;
    },
  },
  actions: {
    // board
    async boardList(context) {
      let params = {
        limit: this.state.board.limit,
        offset: this.state.board.offset,
        searchWord: this.state.board.searchWord,
      };

      try {
        let { data } = await http.get("/boards", { params }); // params: params shorthand property, let response 도 제거
        console.log("BoardMainVue: data : ");
        console.log(data);
        if (data.result == "login") {
          router.push("/login");
        } else {
          context.commit("SET_BOARD_LIST", data.list);
          context.commit("SET_BOARD_TOTAL_LIST_ITEM_COUNT", data.count);
        }
      } catch (error) {
        console.error(error);
      }
    },

    async userList(context) {
      let params = {
        limit: this.state.userList.limit,
        offset: this.state.userList.offset,
        searchWord: this.state.userList.searchWord,
      };

      try {
        console.log(
          "pagination limit, offset, searchword: ",
          params.limit,
          params.offset,
          params.searchWord
        );
        let { data } = await http.get("/api/users/page", { params }); // params: params shorthand property, let response 도 제거
        console.log("userList: data : ");
        console.log(data);
        if (data.result == "login") {
          router.push("/login");
        } else {
          context.commit("SET_USER_LIST", data);
        }
      } catch (error) {
        console.error(error);
      }
    },

    async userCount(context) {
      try {
        let { data } = await http.get("/api/users/count");
        console.log("userCount: data : ");
        console.log(data);
        if (data.result == "login") {
          router.push("/login");
        } else {
          context.commit("SET_USER_TOTAL_LIST_ITEM_COUNT", data);
        }
      } catch (error) {
        console.error(error);
      }
    },

    // interested area
    async getSidoList(context) {
      try {
        let { data } = await http.get("/sidos");
        context.commit("SET_ADDRESS_SIDOlIST", data);
        console.log(data);
      } catch (error) {
        console.log(error);
      }
    },
    async getGugunList(context) {
      try {
        let { data } = await http.get("/guguns/" + this.state.address.sido);
        console.log(data);
        context.commit("SET_ADDRESS_GUGUNlIST", data);
      } catch (error) {
        console.log(error);
      }
    },
  },

  getters: {
    // user
    getLoginStatus(state) {
      return state.loginStatus;
    },
    getUser(state) {
      return state.user;
    },

    // board
    getBoardList: function (state) {
      return state.board.list;
    },

    // pagination board
    getPageCount: function (state) {
      return Math.ceil(state.board.totalListItemCount / state.board.listRowCount);
    },
    getStartPageIndex: function (state) {
      if (state.board.currentPageIndex % state.board.pageLinkCount == 0) {
        //10, 20...맨마지막
        return (
          (state.board.currentPageIndex / state.board.pageLinkCount - 1) *
            state.board.pageLinkCount +
          1
        );
      } else {
        return (
          Math.floor(state.board.currentPageIndex / state.board.pageLinkCount) *
            state.board.pageLinkCount +
          1
        );
      }
    },
    getEndPageIndex: function (state, getters) {
      let ret = 0;
      if (state.board.currentPageIndex % state.board.pageLinkCount == 0) {
        //10, 20...맨마지막
        ret =
          (state.board.currentPageIndex / state.board.pageLinkCount - 1) *
            state.board.pageLinkCount +
          state.board.pageLinkCount;
      } else {
        ret =
          Math.floor(state.board.currentPageIndex / state.board.pageLinkCount) *
            state.board.pageLinkCount +
          state.board.pageLinkCount;
      }
      // 위 오류나는 코드를 아래와 같이 비교해서 처리
      return ret > getters.getPageCount ? getters.getPageCount : ret;
    },
    getPrev: function (state) {
      if (state.board.currentPageIndex <= state.board.pageLinkCount) {
        return false;
      } else {
        return true;
      }
    },
    getNext: function (state, getters) {
      if (
        Math.floor(getters.getPageCount / state.board.pageLinkCount) * state.board.pageLinkCount <
        state.board.currentPageIndex
      ) {
        return false;
      } else {
        return true;
      }
    },

    // admin pagination
    getUserList: function (state) {
      return state.userList.list;
    },
    getUserPageCount: function (state) {
      return Math.ceil(state.userList.totalListItemCount / state.userList.listRowCount);
    },
    getUserStartPageIndex: function (state) {
      if (state.userList.currentPageIndex % state.userList.pageLinkCount == 0) {
        //10, 20...맨마지막
        return (
          (state.userList.currentPageIndex / state.userList.pageLinkCount - 1) *
            state.userList.pageLinkCount +
          1
        );
      } else {
        return (
          Math.floor(state.userList.currentPageIndex / state.userList.pageLinkCount) *
            state.userList.pageLinkCount +
          1
        );
      }
    },
    getUserEndPageIndex: function (state, getters) {
      let ret = 0;
      if (state.userList.currentPageIndex % state.userList.pageLinkCount == 0) {
        //10, 20...맨마지막
        ret =
          (state.userList.currentPageIndex / state.userList.pageLinkCount - 1) *
            state.userList.pageLinkCount +
          state.userList.pageLinkCount;
      } else {
        ret =
          Math.floor(state.userList.currentPageIndex / state.userList.pageLinkCount) *
            state.userList.pageLinkCount +
          state.userList.pageLinkCount;
      }
      // 위 오류나는 코드를 아래와 같이 비교해서 처리
      return ret > getters.getUserPageCount ? getters.getUserPageCount : ret;
    },
    getUserPrev: function (state) {
      if (state.userList.currentPageIndex <= state.userList.pageLinkCount) {
        return false;
      } else {
        return true;
      }
    },
    getUserNext: function (state, getters) {
      if (
        Math.floor(getters.getUserPageCount / state.userList.pageLinkCount) *
          state.userList.pageLinkCount <
        state.userList.currentPageIndex
      ) {
        return false;
      } else {
        return true;
      }
    },
    // interested area
    getSidoList(state) {
      return state.address.sidoList;
    },
    getGugunList(state) {
      return state.address.gugunList;
    },

    getSido(state) {
      return state.address.sido;
    },
    getGugun(state) {
      return state.address.gugun;
    },
  },
});
