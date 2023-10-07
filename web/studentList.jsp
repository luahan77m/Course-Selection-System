<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%--项目绝对路径--%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>学生列表页面</title>
    <!-- 引入css样式和js文件-->
    <meta charset="UTF-8">
    <link rel="stylesheet" href="static/layui/css/layui.css"/>
    <script type="text/javascript" src="static/layui/layui.js"></script>
</head>
<body>
<div class="layui-fluid">


    <table class="layui-table">
        <tbody>
        <tr >
             <th>ID</th>
             <th>姓名</th>
             <th>密码</th>
             <th>性别</th>
             <th>学号</th>
             <th>班级</th>
             <th>学院</th>
             <th>联系电话</th>
             <th>备注</th>
            <th>操作</th>
        </tr>


    <c:forEach items="${studentList}" var="v">
        <tr>
            <td>${v.id}</td>
            <td>${v.username}</td>
            <td>${v.password}</td>
            <td>${v.sex}</td>
            <td>${v.stnum}</td>
            <td>${v.classinfo}</td>
            <td>${v.department}</td>
            <td>${v.tellphone}</td>
            <td>${v.remark}</td>
            <td style="width: 180px;">
                <a href="StudentServlet?type=edit&id=${v.id}" class="layui-btn layui-btn layui-btn-sm">修改</a>
                <a href="StudentServlet?type=delete&id=${v.id}" class="layui-btn layui-btn-danger layui-btn-sm layui-bg-blue">删除</a>

            </td>
        </tr>
    </c:forEach>


        </tbody>
    </table>
</div>
<script>
    //注意：导航 依赖 element 模块，否则无法进行功能性操作
    //定义layui的变量
    var $;
    var layer;
    var element;
    var form;
    layui.use(['element', 'layer', 'jquery','form'], function () {
        element = layui.element;
        layer = layui.layer;
        $ = layui.jquery;
        form = layui.form;

    });
</script>

</body>
</html>
