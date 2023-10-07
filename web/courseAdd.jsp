<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%--项目绝对路径--%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>课程添加页面</title>
    <!-- 引入css样式和js文件-->
    <meta charset="UTF-8">
    <link rel="stylesheet" href="static/layui/css/layui.css"/>
    <script type="text/javascript" src="static/layui/layui.js"></script>
</head>
<body>
<div class="layui-container">


    <form class="layui-form" action="CourseServlet?type=save" method="post" style="width: 500px;margin: 50px auto;">
        <div class="layui-form-item">
            <label class="layui-form-label">课程名</label>
            <div class="layui-input-block">
                <input type="text" name="name" id="name" value="" lay-verify autocomplete="off"
                       placeholder="请输入课程名"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">课程简介</label>
            <div class="layui-input-block">
                <textarea name="content" placeholder="请输入内容" class="layui-textarea"></textarea>

            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">学时</label>
            <div class="layui-input-block">
                <input type="text" name="period" id="period" value="" lay-verify autocomplete="off"
                       placeholder="请输入学时"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">学分</label>
            <div class="layui-input-block">
                <input type="text" name="credit" id="credit" value="" lay-verify autocomplete="off"
                       placeholder="请输入学分"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
        <label class="layui-form-label">主讲教师</label>
        <div class="layui-input-block">
            <select name="stid" lay-verify="required">
                <c:forEach items="${ts}" var="t">
                    <c:if test="${t.role=='主讲教师'}">
                        <option value="${t.id}">${t.username}</option>
                    </c:if>
                </c:forEach>
            </select>
        </div>
    </div>


        <input name="atid" hidden value="马超">
        <div class="layui-form-item">
            <label class="layui-form-label">授课教室</label>
            <div class="layui-input-block">
                <input type="text" name="classroom" id="classroom" value="" lay-verify autocomplete="off"
                       placeholder="请输入授课教室"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">上课时间</label>
            <div class="layui-input-block">
                <input type="text" name="timeinfo" id="timeinfo" value="" lay-verify autocomplete="off"
                       placeholder="请输入上课时间"
                       class="layui-input" >
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">备注</label>
            <div class="layui-input-block">
                <input type="text" name="remark" id="remark" value="" lay-verify autocomplete="off"
                       placeholder="请输入备注"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item" style="text-align:center;">
            <div class="layui-input-block">
                <button type="submit" class="layui-btn layui-bg-cyan" lay-submit="" lay-filter="demo1">提交</button>
                <button type="reset" class="layui-btn layui-btn-primary layui-bg-cyan">重置</button>
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

    layui.use('laydate', function(){
        var laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
            elem: '#test-date' //指定元素
        });
    });
</script>

</body>
</html>
