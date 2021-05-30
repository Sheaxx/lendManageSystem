<template>
  <div id="app">
    <el-table class="table" :data="freelancer" stripe :header-cell-style="{textAlign: 'center'}" :cell-style="{ textAlign: 'center' }">
      <el-table-column prop="freelancerId" label="编号" width="250"></el-table-column>
      <el-table-column prop="freelancerName" label="姓名" width="250"></el-table-column>
      <el-table-column prop="freelancerType" label="类型" width="200"> </el-table-column>
      <el-table-column prop="freelancerTelphone" label="联系方式"></el-table-column>
      <el-table-column label="操作" class="option">
        <a href="" class="update">修改</a>
        <a href="" class="delete">删除</a>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
export default {
  data() {
    return {
      freelancer: [
        {
          freelancerId:"001",
          freelancerName:"温客行",
          freelancerType:"A",
          freelancerTelphone:"13711447629"
        },
        {
          freelancerId:"001",
          freelancerName:"温客行",
          freelancerType:"A",
          freelancerTelphone:"13711447629"
        },
      ],
    };
  },
};
</script>

<style scoped>
.table {
  width: 80%;
  margin: 0 auto;
  font-size: 18px;
  text-align: center;
  border-radius: 25px;
}
.option a {
  display: inline-block;
}
.update {
  margin-right: 30px;
}
</style>