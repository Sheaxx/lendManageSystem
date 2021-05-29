<template>
  <div id="app">
    <div class="title">出租管理系统</div>
    <div class="option">
      <router-link class="freelancer" :to="{path:'/freelancer'}">自由职业者</router-link>
      <a class="project">项目</a>
      <a class="client">客户</a>
      <a class="timeTable">时间表</a>
      <router-view></router-view>
    </div>
  </div>
</template>

<style>
body {
  background: #c2d9cd;
}
.title {
  width: 100%;
  height: 44px;
  margin-top: 100px;
  text-align: center;
  color: #fcfaf1;
  font-size: 40px;
}
.option {
  width: 80%;
  display: flex;
  margin: 90px auto;
}
.option a {
  height: 80px;
  width: 20%;
  flex: 1;
  line-height: 80px;
  text-align: center;
  background: #538797;
  border: none;
  font-size: 30px;
  color: #fcfaf1;
  margin: 0 20px;
  border-radius: 25px;
  box-shadow: 0 0 15px 1px rgba(0, 0, 0, 0.514);
}
</style>
