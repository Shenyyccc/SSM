<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2023/6/21
  Time: 18:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>增加书籍页面</title>
</head>


<body>
<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>新增书籍</small>
                </h1>
            </div>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/book1/addBook">

        <div class="form-group">
            书籍名称: <input type="text" class="form-control" name="bookName">
        </div>
        <div class="form-group">
            书籍数量: <input type="text" class="form-control" name="bookCounts">
        </div>
        <div class="form-group">
            书籍详情: <input type="text" class="form-control" name="detail" >
        </div>

        <input type="submit" value="添加">

    </form>


</div>

</body>
</html>
