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
<div class="layui-fluid">


    <table class="layui-table">
        <tbody>
        <tr >
             <th>ID</th>
             <th>姓名</th>
             <th>密码</th>
             <th>邮箱</th>
             <th>职务信息</th>
             <th>联系电话</th>
             <th>备注</th>
            <th>操作</th>
        </tr>


    <c:forEach items="${teacherList}" var="v">
        <tr>
            <td>${v.id}</td>
            <td>${v.username}</td>
            <td>${v.password}</td>
            <td>${v.email}</td>
            <td>${v.role}</td>
            <td>${v.tellphone}</td>
            <td>${v.remark}</td>
            <td style="width: 180px;">
                <a href="TeacherServlet?type=edit&id=${v.id}" class="layui-btn layui-btn layui-btn-sm">修改</a>
                <a href="TeacherServlet?type=delete&id=${v.id}" class="layui-btn layui-btn-danger layui-btn-sm layui-bg-blue">删除</a>

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
                title: '教师详情查看',
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
