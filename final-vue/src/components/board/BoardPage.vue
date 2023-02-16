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
            <li class="breadcrumb-item text-sm text-dark active" aria-current="page">Board</li>
          </ol>
          <h6 class="font-weight-bold mb-0">게시판</h6>
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
                  <h6 class="font-weight-semibold text-lg mb-0">문의 게시판</h6>
                  <p class="text-sm">See information about all boards</p>
                </div>
                <div class="input-group w-sm-25 ms-auto">
                  <span class="input-group-text text-body" style="cursor: pointer" @click="boardList">
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
                    placeholder="게시글 검색"
                    v-model="$store.state.board.searchWord"
                    @keydown.enter="boardList"
                  />
                </div>
              </div>
            </div>
            <div class="card-body px-0 py-0">
              <div class="table-responsive p-0">
                <table class="table align-items-center mb-0">
                  <thead class="bg-gray-100">
                    <tr>
                      <th class="text-secondary text-xs font-weight-semibold opacity-7">글 번호</th>
                      <th class="text-secondary text-xs font-weight-semibold opacity-7 ps-2">제목</th>
                      <th class="text-center text-secondary text-xs font-weight-semibold opacity-7">작성자</th>
                      <th class="text-center text-secondary text-xs font-weight-semibold opacity-7">등록 시간</th>
                      <th class="text-center text-secondary text-xs font-weight-semibold opacity-7">조회수</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr
                      style="cursor: pointer"
                      v-for="(board, index) in listGetters"
                      :key="index"
                      @click="boardDetail(board.boardId)"
                    >
                      <td class="text-secondary text-xs font-weight-semibold">
                        &nbsp;&nbsp;&nbsp;&nbsp;{{ board.boardId }}
                      </td>
                      <td>{{ board.title }}</td>
                      <td style="text-align: center">{{ board.userName }}</td>
                      <td style="text-align: center">
                        {{ board.regDt.date.year }}/{{ board.regDt.date.month }}/{{ board.regDt.date.day }} &nbsp;
                        {{ board.regDt.time.hour | makeDateStr() }}:{{ board.regDt.time.minute | makeDateStr() }}:{{
                          board.regDt.time.second | makeDateStr()
                        }}
                      </td>
                      <td style="text-align: center">{{ board.readCount }}</td>
                    </tr>
                    <!-- 게시글 받아오기 vuex?? -->
                    <!-- <tr
											style="cursor: pointer"
											v-for="(board, index) in listGetters"
											@click="boardDetail(board.boardId)"
											v-bind:key="index"
										>
											<td>{{ board.boardId }}</td>
											<td>{{ board.title }}</td>
											<td>{{ board.userName }}</td>
											<td>{{ board.regDt.date | makeDateStr("/") }}</td>
											<td>{{ board.readCount }}</td>
										</tr> -->
                  </tbody>
                </table>
              </div>
              <!-- Pagination -->
              <div class="border-top py-3 px-3 d-flex align-items-center">
                <!-- PaginationUI Component 4개 props 필요-->
                <!-- <pagination-uI
                  v-bind:listRowCount="listRowCount"
                  v-bind:pageLinkCount="pageLinkCount"
                  v-bind:currentPageIndex="currentPageIndex"
                  v-bind:totalListItemCount="totalListItemCount"
                  v-on:call-parent-move-page="movePage"
                ></pagination-uI> -->
                <button class="btn btn-sm btn-white mb-0" @click="showInsertModal">글쓰기</button>
                <div style="margin: auto">
                  <PaginationUI v-on:call-parent="movePage"></PaginationUI>
                </div>
                <insert-modal v-on:call-parent-insert="closeAfterInsert"></insert-modal>
                <detail-modal
                  v-on:call-parent-change-to-update="changeToUpdate"
                  v-on:call-parent-change-to-delete="changeToDelete"
                ></detail-modal>
                <update-modal v-on:call-parent-update="closeAfterUpdate"></update-modal>
              </div>
            </div>
          </div>
        </div>
      </div>
      <footer class="footer pt-3" style="position: flex; bottom: 0; padding: 10px">
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
  </main>
</template>

<script>
import http from "@/common/axios.js"; // axios 객체
import util from "@/common/util.js";
import PaginationUI from "@/components/pagination/PaginationUI.vue";

import InsertModal from "@/components/board/modal/BoardInsertModal.vue"; // vue 컴포넌트
import DetailModal from "@/components/board/modal/BoardDetailModal.vue";
import UpdateModal from "@/components/board/modal/BoardUpdateModal.vue";

import { Modal } from "bootstrap"; // vue 컴포넌트에서 bootstrap modal을 사용하기 위함.
export default {
  components: { PaginationUI, InsertModal, DetailModal, UpdateModal },
  data() {
    return {
      // modal
      insertModal: null,
      detailModal: null,
      updateModal: null,

      // 아래 data 사용 X
      // // list
      // list: [],
      // limit: 10,
      // offset: 0,
      // searchWord: '',

      // // pagination
      // listRowCount: 10,
      // pageLinkCount: 10,
      // currentPageIndex: 1,

      // totalListItemCount: 0,

      // // detail
      // boardId: 0,

      // // update
      // board: {
      //   boardId: 0,
      //   title: '',
      //   content: '',
      //   fileList: []
      // }
    };
  },
  computed: {
    // gttters 이용
    listGetters() {
      return this.$store.getters.getBoardList; // no getBoardList()
    },
  },
  methods: {
    // list
    // store actions 에 구현
    // 가능한 한 가지 방법
    boardList() {
      this.$store.dispatch("boardList");
    },

    // pagination
    movePage(pageIndex) {
      console.log("BoardMainVue : movePage : pageIndex : " + pageIndex);

      // store commit 으로 변경
      // this.offset = (pageIndex - 1) * this.listRowCount;
      // this.currentPageIndex = pageIndex;
      this.$store.commit("SET_BOARD_MOVE_PAGE", pageIndex);

      this.boardList();
    },

    // util
    makeDateStr: util.makeDateStr,

    // insert
    showInsertModal() {
      this.insertModal.show();
    },

    closeAfterInsert() {
      this.insertModal.hide();
      this.boardList();
    },

    // detail
    async boardDetail(boardId) {
      // store 변경
      // this.boardId = boardId;
      // this.$store.commit('mutateSetBoardBoardId', boardId);

      try {
        let { data } = await http.get("/boards/" + boardId);
        console.log("디테일", data);

        if (data.result == "login") {
          this.doLogout(); // this.$router.push("/login"); 에서 변경
        } else {
          let { dto } = data;
          this.$store.commit("SET_BOARD_DETAIL", dto);

          this.detailModal.show();
        }
      } catch (error) {
        console.log("BoardMainVue: error : detail");
        console.log(error);
      }
      // http.get(
      // '/boards/' + boardId, // props variable
      // )
      // .then(({ data }) => {
      //   console.log("DetailModalVue: data : ");
      //   console.log(data);

      //   if( data.result == 'login' ){
      //     this.doLogout();
      //   }else{
      //     this.$store.commit(
      //       'SET_BOARD_DETAIL',
      //       {
      //         boardId: data.dto.boardId,
      //         title: data.dto.title,
      //         content: data.dto.content,
      //         userName: data.dto.userName,
      //         regDt: this.makeDateStr(data.dto.regDt.date.year, data.dto.regDt.date.month, data.dto.regDt.date.day, '.'),
      //         fileList: data.dto.fileList,
      //         sameUser: data.dto.sameUser, // not data.dto.sameUser
      //       }
      //     );

      //     this.detailModal.show();
      //   }
      // })
      // .catch((error) => {
      //   console.log("DetailModalVue: error ");
      //   console.log(error);
      // });
    },

    // update
    // Detail 에서 board data 를 직접 변경
    // changeToUpdate( board ){
    //   this.board = board;
    //   this.detailModal.hide();
    //   this.updateModal.show();
    // },
    changeToUpdate() {
      // board parameter 필요 없음.
      // data update 사용 X
      // this.board = board;
      this.detailModal.hide();
      this.updateModal.show();
    },

    closeAfterUpdate() {
      this.updateModal.hide();
      this.boardList();
    },

    // delete
    // $emit board 사용 X
    // changeToDelete(board){
    changeToDelete() {
      this.detailModal.hide();

      var $this = this; // alertify.confirm-function()에서 this 는 alertify 객체
      this.$alertify.confirmWithTitle(
        "삭제 확인",
        "이 글을 삭제하시겠습니까?",
        function () {
          // board.boardId 사용 X
          $this.boardDelete(); // $this 사용
        },
        function () {
          console.log("cancel");
        }
      );
    },
    async boardDelete() {
      // parameter 사용 X

      try {
        let { data } = await http.delete("/boards/" + this.$store.state.board.boardId);
        console.log(data);

        if (data.result == "login") {
          this.doLogout();
        } else {
          this.$alertify.success("글이 삭제되었습니다.");
          this.boardList();
        }
      } catch (error) {
        console.log("BoardMainVue: error : delete");
        console.log(error);
      }

      // http.delete(
      //   "/boards/" + this.$store.state.board.boardId
      //   )
      //   .then(({ data }) => {
      //     console.log("BoardMainVue: data : ");
      //     console.log(data);
      //     if( data.result == 'login' ){
      //       this.doLogout();
      //     }else{
      //       this.boardList();
      //     }
      //   })
      //   .catch( error => {
      //       console.log(error)
      //   });
    },
    // logout 처리 별도 method
    doLogout() {
      this.$store.commit("SET_LOGIN", { isLogin: false, userName: "", userProfileImageUrl: "" });
      this.$router.push("/login");
    },
  },
  created() {
    this.boardList();
  },
  mounted() {
    this.insertModal = new Modal(document.getElementById("insertModal"));
    this.detailModal = new Modal(document.getElementById("detailModal"));
    this.updateModal = new Modal(document.getElementById("updateModal"));
  },
  filters: {
    makeDateStr: function (date) {
      return date < 10 ? "0" + date : date;
    },
  },
};
</script>

<style scoped></style>
