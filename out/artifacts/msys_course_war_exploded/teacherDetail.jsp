<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%--项目绝对路径--%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>教师列表页面</title>
    <!-- 引入css样式和js文件-->
    <meta charset="UTF-8">
    <link rel="stylesheet" href="static/layui/css/layui.css"/>
    <script type="text/javascript" src="static/layui/layui.js"></script>
</head>
<body>
<div class="layui-container">


    <table class="layui-table">
        <tbody>
            <tr>
                <td>ID</td>
                <td>${teacher.id}</td>
            </tr>
            <tr>
                <td>姓名</td>
                <td>${teacher.username}</td>
            </tr>
            <tr>
                <td>密码</td>
                <td>${teacher.password}</td>
            </tr>
            <tr>
                <td>邮箱</td>
                <td>${teacher.email}</td>
            </tr>
            <tr>
                <td>职务信息</td>
                <td>${teacher.role}</td>
            </tr>
            <tr>
                <td>联系电话</td>
                <td>${teacher.tellphone}</td>
            </tr>
            <tr>
                <td>备注</td>
                <td>${teacher.remark}</td>
            </tr>
        </tbody>
    </table>
</div>


</body>
</html>
