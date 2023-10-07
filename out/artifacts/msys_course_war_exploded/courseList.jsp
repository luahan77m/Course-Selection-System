<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%--项目绝对路径--%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>课程列表页面</title>
    <!-- 引入css样式和js文件-->
    <meta charset="UTF-8">
    <link rel="stylesheet" href="static/layui/css/layui.css"/>
    <script type="text/javascript" src="static/layui/layui.js">
        function deleteCourse(courseId) {
            layer.confirm('确定要删除该条记录吗？', {icon: 3, title:'删除确认'}, function(index){
                // Delete logic goes here
                window.location.href = 'CourseServlet?type=delete&id=' + courseId;
                layer.close(index);
            });
        }
    </script>
</head>
<body>
<div class="layui-fluid">


    <table class="layui-table">
        <tbody>
        <tr >
             <th>ID</th>
             <th>课程名</th>
             <th>课程简介</th>
             <th>学时</th>
             <th>学分</th>
             <th>主讲教师</th>
             <th>主管教师</th>
             <th>授课教室</th>
             <th>上课时间</th>
             <th>备注</th>
            <th>操作</th>
        </tr>


    <c:forEach items="${courseList}" var="v">
        <tr>
            <td>${v.id}</td>
            <td>${v.name}</td>
            <td>${v.content}</td>
            <td>${v.period}</td>
            <td>${v.credit}</td>
            <td>${v.teacher.username}</td>
            <td>${v.atid}</td>
            <td>${v.classroom}</td>
            <td>${v.timeinfo}</td>
            <td>${v.remark}</td>
            <td style="width: 180px;">
                <a href="CourseServlet?type=edit&id=${v.id}" class="layui-btn layui-btn layui-btn-sm">修改</a>
                <a href="CourseServlet?type=delete&id=${v.id}" class="layui-btn layui-btn-danger layui-btn-sm layui-bg-blue">删除</a>

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
        //绑定详情点击事件
        $(".showDetail").click(function () {
            var path = $(this).attr("path");
            layer.open({
                offset: '100px', //设置弹出窗口的位置 上边距100px
                type: 2,  //弹出类型
                skin: 'layui-layer-demo', //样式类名
                title: '课程详情查看',
                anim: 2,    //弹出窗口使用的动画
                area: ['800px', '620px'],  //设置弹出窗口的大小 宽度,高度
                shadeClose: true, //开启遮罩关闭
                content: path  //加载内容路径
            });
        })
    });
</script>

</body>
</html>
