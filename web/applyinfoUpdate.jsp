<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%--项目绝对路径--%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>课程申请列表页面</title>
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
            <td>${applyinfo.id}</td>
        </tr>
        <tr>
            <td>学生</td>
            <td>${applyinfo.sid}</td>
        </tr>
        <tr>
            <td>课程</td>
            <td>${applyinfo.cid}</td>
        </tr>
        <tr>
            <td>理由</td>
            <td>${applyinfo.content}</td>
        </tr>
        <tr>
            <td>状态</td>
            <td>${applyinfo.status}</td>
        </tr>
        <tr>
            <td>申请时间</td>
            <td>${applyinfo.ctime}</td>
        </tr>
        <tr>
            <td>主讲教师</td>
            <td>${applyinfo.stid}</td>
        </tr>
        <tr>
            <td>主讲教师姓名</td>
            <td>${applyinfo.stname}</td>
        </tr>
        <tr>
            <td>主讲教师理由</td>
            <td>${applyinfo.streason}</td>
        </tr>
        <tr>
            <td>主管教师</td>
            <td>${applyinfo.atid}</td>
        </tr>
        <tr>
            <td>主管教师姓名</td>
            <td>${applyinfo.atname}</td>
        </tr>
        <tr>
            <td>主管教师理由</td>
            <td>${applyinfo.atreason}</td>
        </tr>
        <tr>
            <td>备注</td>
            <td>${applyinfo.remark}</td>
        </tr>
        </tbody>
    </table>
</div>


</body>
</html>
