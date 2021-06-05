<template>
  <div id="app">
    <el-button class="excel" icon="el-icon-download" @click="excel">生成日志</el-button>
    <el-button class="add" icon="el-icon-plus" @click="addInfo">添加</el-button>
    <el-table
      class="table"
      :data="progress"
      stripe
      :header-cell-style="{ textAlign: 'center' }"
      :cell-style="{ textAlign: 'center' }"
      :row-class-name="tableRowClassName"
    >
      <el-table-column
        prop="progressId"
        label="编号"
        width="150"
      ></el-table-column>
      <el-table-column
        prop="progressName"
        label="项目名"
        width="200"
      ></el-table-column>
      <el-table-column prop="progressType" label="类型" width="150">
      </el-table-column>
      <el-table-column prop="progressContent" label="内容"></el-table-column>
      <el-table-column label="操作" class="option" width="200">
        <div slot-scope="scope">
          <a href="" class="update" @click.prevent="updateInfo(scope.$index)"
            >修改</a
          >
          <a href="" class="delete" @click.prevent="deleteInfo(scope.$index)"
            >删除</a
          >
        </div>
      </el-table-column>
    </el-table>
    <div class="showUpdate" v-if="showUpdate">
      <div class="content">
        <el-form ref="form" :model="form" label-width="80px">
          <div class="formTitle">修改项目</div>
          <el-form-item label="项目名">
            <el-input v-model="form.progressName"></el-input>
          </el-form-item>
          <el-form-item label="类型">
            <el-select v-model="form.progressType" placeholder="请选择类型">
              <el-option label="A" value="A"></el-option>
              <el-option label="B" value="B"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="内容">
            <el-input v-model="form.progressContent"></el-input>
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
          <div class="formTitle">添加项目</div>
          <el-form-item label="编号">
            <el-input v-model="form.progressId"></el-input>
          </el-form-item>
          <el-form-item label="项目名">
            <el-input v-model="form.progressName"></el-input>
          </el-form-item>
          <el-form-item label="类型">
            <el-select v-model="form.progressType" placeholder="请选择类型">
              <el-option label="A" value="A"></el-option>
              <el-option label="B" value="B"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="内容">
            <el-input v-model="form.progressContent"></el-input>
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
import XLSX from 'xlsx'
export default {
  data() {
    return {
      index: 0,
      showAdd:false,
      showUpdate: false,
      form: {
        id:"",
        progressName: "",
        progressType: "",
        progressContent: "",
      },
      progress: [
        {
          progressId:"00001",
          progressName:"四季山庄重建方案",
          progressType:"A",
          progressContent:"某某公司的某某方案"
        },
        {
          progressId:"00002",
          progressName:"天窗初期策划方案",
          progressType:"B",
          progressContent:"某某公司的某某方案"
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
      this.progressId = ''
      this.form.progressName = ''
      this.form.progressType = ''
      this.form.progressContent = ''
      this.showAdd = true
    },
    saveAdd(){//保存添加
      var obj = {}
      obj.progressId = this.form.progressId
      obj.progressName = this.form.progressName
      obj.progressType = this.form.progressType
      obj.progressContent = this.form.progressContent
      this.progress.push(obj)
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
      this.form.progressName = this.progress[row].progressName;
      this.form.progressType = this.progress[row].progressType;
      this.form.progressContent = this.progress[row].progressContent;
      this.showUpdate = true;
    },
    saveUpdate() {//保存修改
      this.progress[this.index].progressName = this.form.progressName
      this.progress[this.index].progressType = this.form.progressType
      this.progress[this.index].progressContent = this.form.progressContent
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
      this.$confirm("此操作将永久删除该项目, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      }).then(() => {
        this.progress.splice(row,1)
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
    sheet2blob(sheet, sheetName) {
      sheetName = sheetName || "sheet1";
      var workbook = {
        SheetNames: [sheetName],
        Sheets: {},
      };
      workbook.Sheets[sheetName] = sheet;
      // 生成excel的配置项
      var wopts = {
        bookType: "xlsx", // 要生成的文件类型
        bookSST: false, // 是否生成Shared String Table，官方解释是，如果开启生成速度会下降，但在低版本IOS设备上有更好的兼容性
        type: "binary",
      };
      var wbout = XLSX.write(workbook, wopts);
      var blob = new Blob([s2ab(wbout)], { type: "application/octet-stream" });
      // 字符串转ArrayBuffer
      function s2ab(s) {
        var buf = new ArrayBuffer(s.length);
        var view = new Uint8Array(buf);
        for (var i = 0; i != s.length; ++i) view[i] = s.charCodeAt(i) & 0xff;
        return buf;
      }
      return blob;
    },
    openDownloadDialog(url, saveName) {
      if (typeof url == "object" && url instanceof Blob) {
        url = URL.createObjectURL(url); // 创建blob地址
      }
      var aLink = document.createElement("a");
      aLink.href = url;
      aLink.download = saveName || ""; // HTML5新增的属性，指定保存文件名，可以不要后缀，注意，file:///模式下不会生效
      var event;
      if (window.MouseEvent) event = new MouseEvent("click");
      else {
        event = document.createEvent("MouseEvents");
        event.initMouseEvent(
          "click",
          true,
          false,
          window,
          0,
          0,
          0,
          0,
          0,
          false,
          false,
          false,
          false,
          0,
          null
        );
      }
      aLink.dispatchEvent(event);
    },
    excel() {
      var sheet = XLSX.utils.json_to_sheet(this.progress);
      this.openDownloadDialog(this.sheet2blob(sheet), "项目.xlsx");
    },
  },
};
</script>

<style scoped>
#app {
  width: 80%;
  padding: 0 10%;
}
.add,.excel {
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
.showAdd .content {
  height: 340px;
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