<template>
  <el-container style="height: 100%; border: 1px solid #eee">
    <el-aside :width="aside_width" style="background-color: rgb(238, 241, 246);height: 100%;margin-left: -1px">
      <Aside :isCollapse="isCollapse"></Aside>
    </el-aside>

    <el-container style="height: 100%;">
      <el-header style="text-align: right; font-size: 10px;height: 100%;border-bottom: rgba(77,168,168,0.66) 1px solid;background-color: #eceee2">
        <Header @doCollapse="doCollapse" :icon="icon"></Header>
      </el-header>

      <el-main style="height: 100%">
        <router-view/>
      </el-main>
    </el-container>
  </el-container>
</template>



<script>


  import Aside from "@/components/Aside.vue";
  import Header from "@/components/Header.vue";

  export default {
    name: "Index",
    components: {Header, Aside},
    data(){
      return {
        isCollapse:false,
        aside_width:'200px',
        icon:'el-icon-s-fold'
      }
    },
    methods:{
      doCollapse(){
        this.isCollapse = !this.isCollapse
        if (!this.isCollapse) {//展开
          this.aside_width='200px'
          this.icon="el-icon-s-fold"
        }else{//收起
          this.aside_width='64px'
          this.icon = "el-icon-s-unfold"
        }
      }
    }
  }
</script>

<style scoped>
  .el-header {
    #background-color: #23d08e;
    color: #333;
    line-height: 60px;
  }

  .el-main{
    padding: 5px;
  }

  .el-aside {
    color: #333;
  }
</style>