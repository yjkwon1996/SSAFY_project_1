<template>
   <div class="container mt-3 px-0" id="sidoGridView">
      <div class="row mx-0" v-for="(i, idx1) in rowCount" :key="idx1">
         <div @click="sidoSelect(addr)" class="col-3 p-2 text-center addr" v-for="(addr, idx2) in sidoList.slice((i - 1) * 4, i * 4)" :key="idx2">{{ addr.name }}</div>
      </div>
   </div>
</template>


<script>
export default {
   computed: {
      rowCount() {
         return Math.ceil(this.sidoList.length / 4);
      },
      sidoList: {
         get() {
            return this.$store.state.address.sidoList;
         },
      },
   },
   methods: {
      sidoSelect(addr) {
         this.$emit("call-sido-select", addr);
      },
   },
};
</script>


<style scoped>
#sidoGridView {
   position: absolute;
   top: 300px;
   left: 0;
   right: 0;

   width: 600px;
   border: 0.5px solid lightgray;
}

#sidoGridView >>> .addr {
   cursor: pointer;
}

#sidoGridView >>> .addr:hover {
   background-color: dodgerblue;
   color: white;
}
</style>