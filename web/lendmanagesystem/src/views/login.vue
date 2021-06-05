<template>
  <div id="app">
    <div class="title">出租管理系统</div>
    <el-form ref="form" :model="form" label-width="80px" class="form">
      <el-form-item label="用户名" class="item">
        <el-input v-model="form.userName"></el-input>
      </el-form-item>
      <el-form-item label="密码" class="item">
        <el-input v-model="form.password" show-password></el-input>
      </el-form-item>
      <el-form-item class="button">
        <el-button type="primary" @click="login">登录</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      userName:'root',
      password:'123456',
      form:{
        userName:'',
        password:''
      }
    }
  },
  methods:{
    login(){
      if(this.form.userName == this.userName && this.form.password == this.password){
        this.$router.push('home')
      }else{
        this.$message.error('用户名与密码不匹配');
      }
    }
  }
}
</script>

<style>
body {
  background: #cbdce7;
}
.title {
  width: 100%;
  height: 44px;
  margin-top: 100px;
  text-align: center;
  color: #5596bd;
  font-size: 40px;
}
.form {
  width: 30%;
  margin: 130px auto;
}
.item .el-form-item__label {
  color:#5596bd;
  font-size: 20px;
}
.button {
  margin-top: 30px;
  text-align: center;
}
</style>