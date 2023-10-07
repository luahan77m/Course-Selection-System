<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%--项目绝对路径--%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>课程修改页面</title>
    <!-- 引入css样式和js文件-->
    <meta charset="UTF-8">
    <link rel="stylesheet" href="static/layui/css/layui.css"/>
    <script type="text/javascript" src="static/layui/layui.js"></script>
</head>
<body>
<div class="layui-container">


    <form class="layui-form" action="CourseServlet?type=update" method="post" style="width: 500px;margin: 50px auto;">
        <input type="hidden" name="id" value="${course.id}"/>
        <div class="layui-form-item">
            <label class="layui-form-label">课程名</label>
            <div class="layui-input-block">
                <input type="text" name="name" id="name" value="${course.name}" lay-verify autocomplete="off"
                       placeholder="请输入课程名"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">课程简介</label>
            <div class="layui-input-block">
                <input type="text" name="content" id="content" value="${course.content}" lay-verify autocomplete="off"
                       placeholder="请输入课程简介"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">学时</label>
            <div class="layui-input-block">
                <input type="text" name="period" id="period" value="${course.period}" lay-verify autocomplete="off"
                       placeholder="请输入学时"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">学分</label>
            <div class="layui-input-block">
                <input type="text" name="credit" id="credit" value="${course.credit}" lay-verify autocomplete="off"
                       placeholder="请输入学分"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">主讲教师</label>
            <div class="layui-input-block">
                <input type="text" name="stid" id="stid" value="${course.stid}" lay-verify autocomplete="off"
                       placeholder="请输入主讲教师"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">主管教师</label>
            <div class="layui-input-block">
                <input type="text" name="atid" id="atid" value="${course.atid}" lay-verify autocomplete="off"
                       placeholder="请输入主管教师"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">授课教室</label>
            <div class="layui-input-block">
                <input type="text" name="classroom" id="classroom" value="${course.classroom}" lay-verify autocomplete="off"
                       placeholder="请输入授课教室"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">上课时间</label>
            <div class="layui-input-block">
                <input type="text" name="timeinfo" id="timeinfo" value="${course.timeinfo}" lay-verify autocomplete="off"
                       placeholder="请输入上课时间"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">备注</label>
            <div class="layui-input-block">
                <input type="text" name="remark" id="remark" value="${course.remark}" lay-verify autocomplete="off"
                       placeholder="请输入备注"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1">更新</button>
            </div>
        </div>
    </form>

</div>
<script>
    //注意：导航 依赖 element 模块，否则无法进行功能性操作
    //定义layui的变量
    var $;
    var layer;
    var element;
    var form;
    layui.use(['element', 'layer', 'jquery', 'form'], function () {
        element = layui.element;
        layer = layui.layer;
        $ = layui.jquery;
        form = layui.form;

    });
</script>

</body>
</html>
