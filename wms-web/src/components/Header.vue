<template >
  <div style="display: flex;line-height: 60px">
    <div style="margin-top: 8px">
      <i :class="icon" style="font-size: 20px;cursor: pointer" @click="collapse"></i>
    </div>

    <div style="flex: 1;text-align: center;font-size: 34px;font-weight:bold" >
      <span>仓库管理系统</span>
    </div>
    <span style="font-size: 15px">{{user.name}}</span>
    <div style="margin-top: 5px">
      <i class="el-icon-s-custom" style="margin-left: 5px;font-size: 30px"></i>
    </div>
    <el-dropdown>
      <i class="el-icon-setting" style="margin-left: 30px;cursor: pointer;font-size: 15px;"></i>
      <el-dropdown-menu slot="dropdown" >
        <el-dropdown-item @click.native = "toGoOut">退出登录</el-dropdown-item>
      </el-dropdown-menu>
    </el-dropdown>
  </div>
</template>

<script>
export default {
  name: "Header",
  data(){
    return{
      user: JSON.parse(sessionStorage.getItem('CurUser'))
    }
  },
  props:{
    icon:String
  },
  methods:{
    toGoOut(){
      this.$confirm('确认退出?','提示',{
        confirmButtonText:'确定',
        type:'warning',
        center:true,
      }).then(()=>{
        this.$message({
          type:'success',
          message:'退出登录成功'
        })
        this.$router.push("/")
        sessionStorage.clear()
      }).catch(()=>{
        this.$message({
          type:'info',
          message:'已取消退出登录'
        })
      })

    },
    collapse(){
      this.$emit('doCollapse')
    }
  },
  created() {
    this.$router.push("/Home")
  }
}
</script>

<style scoped>

</style>