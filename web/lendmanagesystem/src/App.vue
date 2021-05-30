<template>
  <div id="app">
    <div class="title">出租管理系统</div>
    <div class="option">
      <router-link class="freelancer" to="/freelancer">自由职业者</router-link>
      <router-link class="project" to="/progress">项目</router-link>
      <router-link class="client" to="/client">客户</router-link>
      <router-link class="timeTable" to="/timeTable">时间表</router-link>
    </div>
    <router-view></router-view>
  </div>
</template>

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
.option {
  width: 80%;
  display: flex;
  margin: 90px auto;
  padding: 0 10%;
}
.option a {
  height: 80px;
  width: 10%;
  flex: 1;
  line-height: 80px;
  text-align: center;
  background: #5596bd;
  border: none;
  font-size: 30px;
  color: #f8faf2;
  margin: 0 20px;
  border-radius: 25px;
  box-shadow: 0 0 15px 1px rgba(0, 0, 0, 0.514);
}
</style>
