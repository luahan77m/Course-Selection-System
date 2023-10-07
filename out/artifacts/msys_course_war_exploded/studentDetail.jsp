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
<div class="layui-container">


    <table class="layui-table">
        <tbody>
            <tr>
                <td>ID</td>
                <td>${student.id}</td>
            </tr>
            <tr>
                <td>姓名</td>
                <td>${student.username}</td>
            </tr>
            <tr>
                <td>密码</td>
                <td>${student.password}</td>
            </tr>
            <tr>
                <td>性别</td>
                <td>${student.sex}</td>
            </tr>
            <tr>
                <td>学号</td>
                <td>${student.stnum}</td>
            </tr>
            <tr>
                <td>班级</td>
                <td>${student.classinfo}</td>
            </tr>
            <tr>
                <td>学院</td>
                <td>${student.department}</td>
            </tr>
            <tr>
                <td>联系电话</td>
                <td>${student.tellphone}</td>
            </tr>
            <tr>
                <td>备注</td>
                <td>${student.remark}</td>
            </tr>
        </tbody>
    </table>
</div>


</body>
</html>
