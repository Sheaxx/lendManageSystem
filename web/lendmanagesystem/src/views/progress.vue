<template>
  <div id="app">
    <el-button class="add" icon="el-icon-plus">添加</el-button>
    <el-table class="table" :data="progress" stripe :header-cell-style="{textAlign: 'center'}" :cell-style="{ textAlign: 'center' }">
      <el-table-column prop="progressId" label="编号" width="150"></el-table-column>
      <el-table-column prop="progressName" label="项目名" width="200"></el-table-column>
      <el-table-column prop="progressType" label="类型" width="150"> </el-table-column>
      <el-table-column prop="progressContent" label="内容"></el-table-column>
      <el-table-column label="操作" class="option" width="200">
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
      progress: [
        {
          progressId:"001",
          progressName:"四季山庄重建方案",
          progressType:"A",
          progressContent:"某某公司的某某方案"
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