<template>
  <div id="app">
    <el-table class="table" :data="client" stripe :header-cell-style="{textAlign: 'center'}" :cell-style="{ textAlign: 'center' }">
      <el-table-column prop="clientId" label="编号" width="250"></el-table-column>
      <el-table-column prop="clientName" label="姓名" width="250"></el-table-column>
      <el-table-column prop="clientType" label="类型" width="200"> </el-table-column>
      <el-table-column prop="clientTelphone" label="联系方式"></el-table-column>
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
      client: [
        {
          clientId:"001",
          clientName:"周子舒",
          clientType:"A",
          clientTelphone:"13711447629"
        },
        {
          clientId:"001",
          clientName:"周子舒",
          clientType:"A",
          clientTelphone:"13711447629"
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