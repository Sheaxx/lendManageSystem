<template>
  <div id="app">
    <el-button class="add" icon="el-icon-plus" @click="addInfo">添加</el-button>
    <el-table class="table" :data="freelancer" stripe :header-cell-style="{textAlign: 'center'}" :cell-style="{ textAlign: 'center' }" :row-class-name="tableRowClassName">
      <el-table-column prop="freelancerId" label="编号" width="250"></el-table-column>
      <el-table-column prop="freelancerName" label="姓名" width="250"></el-table-column>
      <el-table-column prop="freelancerType" label="类型" width="200"> </el-table-column>
      <el-table-column prop="freelancerTelNumber" label="联系方式"></el-table-column>
      <el-table-column label="操作" class="option">
        <div slot-scope="scope" >
          <a href="" class="update" @click.prevent="updateInfo(scope.$index)">修改</a>
          <a href="" class="delete" @click.prevent="deleteInfo(scope.$index)">删除</a>
        </div>
      </el-table-column>
    </el-table>
    <div class="showUpdate" v-if="showUpdate">
      <div class="content">
        <el-form ref="form" :model="form" label-width="80px">
          <div class="formTitle">修改自由职业者</div>
          <el-form-item label="姓名">
            <el-input v-model="form.name"></el-input>
          </el-form-item>
          <el-form-item label="类型">
            <el-select v-model="form.type" placeholder="请选择类型">
              <el-option label="A" value="A"></el-option>
              <el-option label="B" value="B"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="联系方式">
            <el-input v-model="form.telNumber"></el-input>
          </el-form-item>
          <el-form-item class="button">
            <el-button type="primary" @click="saveUpdate">保存</el-button>
            <el-button @click="closeUpdate">取消</el-button>
          </el-form-item>
        </el-form>
      </div>
    </div>
    <div class="showAdd" v-if="showAdd">
      <div class="content">
        <el-form ref="form" :model="form" label-width="80px">
          <div class="formTitle">添加自由职业者</div>
          <el-form-item label="姓名">
            <el-input v-model="form.name"></el-input>
          </el-form-item>
          <el-form-item label="类型">
            <el-select v-model="form.type" placeholder="请选择类型">
              <el-option label="A" value="A"></el-option>
              <el-option label="B" value="B"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="联系方式">
            <el-input v-model="form.telNumber"></el-input>
          </el-form-item>
          <el-form-item class="button">
            <el-button type="primary" @click="saveAdd">添加</el-button>
            <el-button @click="closeAdd">取消</el-button>
          </el-form-item>
        </el-form>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      index: 0,
      showAdd:false,
      showUpdate: false,
      form: {
        id:"",
        name: "",
        type: "",
        telNumber: "",
      },
      freelancer: [
        {
          freelancerId: "001",
          freelancerName: "温客行",
          freelancerType: "A",
          freelancerTelNumber: "13711447629",
        },
        {
          freelancerId: "001",
          freelancerName: "温客行",
          freelancerType: "A",
          freelancerTelNumber: "13711447629",
        },
      ],
    };
  },
  methods: {
    tableRowClassName({ row, rowIndex }) {
      // 把每一行的索引放进row
      row.index = rowIndex;
    },
    addInfo(){//添加
      this.form.name = ''
      this.form.type = ''
      this.form.telNumber = ''
      this.showAdd = true
    },
    saveAdd(){//保存添加
      this.freelancer.push(this.form)
      this.showAdd = false
      this.$message({
        message: '添加成功',
        type: 'success'
      });
    },
    closeAdd() {//关闭添加
      this.showAdd = false
    },
    updateInfo(row) {//修改
      this.index = row
      this.form.name = this.freelancer[row].freelancerName;
      this.form.type = this.freelancer[row].freelancerType;
      this.form.telNumber = this.freelancer[row].freelancerTelNumber;
      this.showUpdate = true;
    },
    saveUpdate() {//保存修改
      this.freelancer[this.index].freelancerName = this.form.name
      this.freelancer[this.index].freelancerType = this.form.type
      this.freelancer[this.index].freelancerTelNumber = this.form.telNumber
      this.showUpdate = false
      this.$message({
        message: '修改成功',
        type: 'success'
      });
    },
    closeUpdate() {//关闭修改
      this.showUpdate = false;
    },
    deleteInfo(row) {//删除
      this.$confirm("此操作将永久删除该自由职业者, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      }).then(() => {
        this.freelancer.splice(row,1)
          this.$message({
            type: "success",
            message: "删除成功!",
          });
        }).catch(() => {
          this.$message({
            type: "info",
            message: "已取消删除",
          });
        });
    },
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
.showUpdate, .showAdd {
  width: 100%;
  height: 100%;
  position: absolute;
  top: 0;
  left: 0;
  background: rgba(0, 0, 0, 0.5);
  z-index: 1;
}
.content {
  width: 490px;
  height: 300px;
  background: #fff;
  position: absolute;
  top: 50%;
  left: 50%;
  margin-left: -300px;
  margin-top: -200px;
  padding: 30px;
  padding-right: 80px;
}
.formTitle {
  font-size: 20px;
  margin-bottom: 30px;
}
.button {
  margin-top: 30px;
  text-align: center;
}
</style>