<template>
  <div id="app">
    <el-button class="add" icon="el-icon-plus">添加</el-button>
    <el-table
      class="table"
      :data="timeTable"
      stripe
      :header-cell-style="{ textAlign: 'center' }"
      :cell-style="{ textAlign: 'center' }"
    >
      <el-table-column
        prop="timeTableId"
        label="时间表编号"
        width="250"
      ></el-table-column>
            <el-table-column
        prop="freelancerId"
        label="自由职业者编号"
        width="250"
      ></el-table-column>
            <el-table-column
        prop="timeTableStartTime"
        label="开始时间"
      ></el-table-column>
            <el-table-column
        prop="timeTableEndTime"
        label="结束时间"
      ></el-table-column>
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
      timeTable: [
        {
          timeTableId: "0012",
          freelancerId: "001",
          timeTableStartTime: "13:00:00",
          timeTableEndTime: "19:00:00",
        },
        {
          timeTableId: "0013",
          freelancerId: "002",
          timeTableStartTime: "9:00:00",
          timeTableEndTime: "17:00:00",
        },
      ],
    };
  },
};
</script>

<style scoped>
#app {
  width: 80%;
  padding: 0 10%;
}
.add {
  margin: 0 20px 30px 0;
  float: right;
}
.table {
  width: 100%;
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