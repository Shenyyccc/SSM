<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <script src="jquery-1.10.2.min.js"></script>
    <title>首页</title>
    <style>
      a{
        text-decoration: none;
        color:black;
        font-size: 18px;
      }
      h3{
        width: 180px;
        height: 38px;
        margin: 100px auto;
        text-align: center;
        line-height: 38px;
        background: deepskyblue;
        border-radius: 5px;
      }


    </style>
  </head>
  <body>
  <h3><a href="${pageContext.request.contextPath}/book1/allBook">进入书籍页面</a></h3>


  <el-form :model="form" label-width="120px">

    <el-form-item label="书籍编号">
      <el-input style="width: 80%" v-model="form.isbn"></el-input>
    </el-form-item>
    <el-form-item label="书籍名称">
      <el-input style="width: 80%" v-model="form.name"></el-input>
    </el-form-item>
    <el-form-item label="书籍数量">
      <el-input style="width: 80%" v-model="form.number"></el-input>
    </el-form-item>
    <el-form-item label="书籍详情">
      <el-input style="width: 80%" v-model="form.details"></el-input>
    </el-form-item>
    <el-table-column fixed="right" label="操作" >
      <template v-slot="scope">
        <el-button  size="mini" @click ="handleEdit(scope.row)" v-if="user.role == 1">修改</el-button>
        <el-popconfirm title="确认删除?" @confirm="handleDelete(scope.row.id)" v-if="user.role == 1">
          <template #reference>
            <el-button type="danger" size="mini" >删除</el-button>
          </template>
        </el-popconfirm>
        <el-button  size="mini" @click ="handlelend(scope.row.id,scope.row.isbn,scope.row.name,scope.row.borrownum)" v-if="user.role == 2" :disabled="scope.row.status == 0">借阅</el-button>
        <el-popconfirm title="确认还书?" @confirm="handlereturn(scope.row.id,scope.row.isbn,scope.row.borrownum)" v-if="user.role == 2" :disabled="scope.row.status == 1">
          <template #reference>
            <el-button type="danger" size="mini" :disabled="(this.isbnArray.indexOf(scope.row.isbn)) == -1 ||scope.row.status == 1" >还书</el-button>
          </template>
        </el-popconfirm>
      </template>
    </el-table-column>

        <el-date-picker value-format="YYYY-MM-DD" type="date" style="width: 80%" clearable v-model="form.createTime" ></el-date-picker>
      </div>
    </el-form-item>
  </el-form>


  <%--文件上传--%>
  <form action="${pageContext.request.contextPath}/upload1" method="post" enctype="multipart/form-data">
    <input type="file" name="file1"/>
    <input type="submit" value="上传">
  </form>
  <a href="${pageContext.request.contextPath}/download">下载图片</a>
  </body>
</html>
