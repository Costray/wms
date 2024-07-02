<template>
  <div style="height: 100%">
    <el-descriptions title="个人中心" :column="2" size="40" border>
      <el-descriptions-item>
        <template slot="label">
          <i class="el-icon-s-custom"></i>
          账号
        </template>
        {{user.no}}
      </el-descriptions-item>
      <el-descriptions-item>
        <template slot="label">
          <i class="el-icon-mobile-phone"></i>
          电话
        </template>
        {{user.phone}}
      </el-descriptions-item>
      <el-descriptions-item>
        <template slot="label">
          <i class="el-icon-location-outline"></i>
          性别
        </template>
        <el-tag
            :type="user.sex == '1' ? 'primary': 'danger'"
            disable-transitions><i :class="user.sex == 1 ? 'el-icon-male':'el-icon-female'"></i>{{user.sex==1?"男":"女"}}</el-tag>
      </el-descriptions-item>
      <el-descriptions-item>
        <template slot="label">
          <i class="el-icon-tickets"></i>
          角色
        </template>
        <el-tag
          type="success"
          disable-transitions>{{user.roleId==0?"超级管理员":(user.roleId==1?"管理员":"用户")}}</el-tag>
      </el-descriptions-item>
    </el-descriptions>

  </div>
</template>

<script>
export default {
  name: "Home",
  data(){
    return{
      user: JSON.parse(sessionStorage.getItem("CurUser"))
    }
  },
  methods:{

  }
}
</script>

<style scoped>

</style>