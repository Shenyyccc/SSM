<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.kuanghui.pojo.Book" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>书籍展示</title>
    <%--BookStrap美化界面--%>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>书籍列表---显示所有书籍</small>
                </h1>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-4 column">
            <a href="toaddBook" class="btn btn-primary">新增书籍</a>
        </div>
        <div class="col-md-4 column">
            <%--查询书籍   --%>
            <form action="${pageContext.request.contextPath}/book1/queryBook">
                请输入查询的书籍:
                <input type="text" name="queryBookname">
                <input type="submit" value="查询">
            </form>
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                    <tr>
                        <th>书籍编号</th>
                        <th>书籍名称</th>
                        <th>书籍数量</th>
                        <th>书籍详情</th>
                        <th>操作</th>
                    </tr>
                </thead>
                <%--书籍从数据库中查询出来,用list遍历  --%>
                <tbody>
                    <c:forEach var="book" items="${list}">
                        <tr>
                            <td>${book.id}</td>
                            <td>${book.bookName}</td>
                            <td>${book.bookCounts}</td>
                            <td>${book.detail}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/book1/tomodifyBook?bookName=${book.bookName}">修改</a> &nbsp; | &nbsp;
                                <a href="${pageContext.request.contextPath}/book1/deleteBook?bookName=${book.bookName}">删除</a>
                            </td>
                        </tr>
                    </c:forEach>

                </tbody>
            </table>
        </div>
    </div>

</div>

</body>
</html>
