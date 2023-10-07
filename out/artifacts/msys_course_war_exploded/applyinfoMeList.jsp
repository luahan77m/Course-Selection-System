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
    <script type="text/javascript" src="static/layui/layui.js">

    </script>
</head>
<body>

<div class="layui-fluid">


    <table class="layui-table">
        <tbody>
        <tr >
            <th>ID</th>
            <th>学生</th>
            <th>课程</th>
            <th>理由</th>
            <%--<th>证明</th>--%>
            <th>状态</th>
            <th>申请时间</th>
            <th>主讲教师</th>
            <th>主讲教师姓名</th>
            <th>主讲教师理由</th>
            <th>主管教师</th>
            <th>主管教师姓名</th>
            <th>主管教师理由</th>
            <th>备注</th>
            <th>操作</th>
        </tr>


        <c:forEach items="${applyinfoList}" var="v">
            <c:if test="${v.sid==loginUser.id}">
            <c:if test="${v.status!=5}">
            <tr>
                <td>${v.id}</td>
                <td>${v.sid}</td>
                <td>${v.cid}</td>
                <td>${v.content}</td>
                <td>
                <c:if test="${v.status=='1'}"><span class="layui-form ">待审核</span></c:if>
                    <c:if test="${v.status=='2'}"><span class="layui-form ">拒绝</span></c:if>
                    <c:if test="${v.status=='3'}"><span class="layui-form ">主讲教师通过</span></c:if>
                    <c:if test="${v.status=='4'}"><span class="layui-form ">主管教师通过</span></c:if>
                    <c:if test="${v.status=='5'}"><span class="layui-form ">审批结束</span></c:if></td>
                <td>${v.ctime}</td>
                <td>${v.stid}</td>
                <td>${v.stname}</td>
                <td>${v.streason}</td>
                <td>${v.atid}</td>
                <td>${v.atname}</td>
                <td>${v.atreason}</td>
                <td>${v.remark}</td>
                <td style="width: 180px;">
                    <a href="ApplyinfoServlet?type=lShen&id=${v.id}&status=5" class="layui-btn layui-btn layui-btn-sm layui-bg-green">学生确认</a>

                </td>
            </tr>

</c:if>
            </c:if>
        </c:forEach>


        </tbody>
    </table>
    <!-- 分页部分 -->
    <div class="layui-pagination" style="margin-left:400px;margin-top: 100px;" id="pagination">
        <div class="layui-box layui-laypage layui-laypage-default" id="layui-laypage-0">
            <a href="#" class="${currentPage <= 1 ? 'layui-disabled' : ''}" ${currentPage <= 1 ? 'disabled' : ''}>首页</a>
            <a href="#" class="${currentPage <= 1 ? 'layui-disabled' : ''}" ${currentPage <= 1 ? 'disabled' : ''}>上一页</a>
            <span class="layui-laypage-curr">
            <em class="layui-laypage-em"></em>
            <em>${currentPage}</em>
        </span>
            <a href="#" class="${currentPage >= totalPages ? 'layui-disabled' : ''}" ${currentPage >= totalPages ? 'disabled' : ''}>下一页</a>
            <a href="#" class="${currentPage >= totalPages ? 'layui-disabled' : ''}" ${currentPage >= totalPages ? 'disabled' : ''}>尾页</a>
        </div>
    </div>
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
            // 获取分页元素
            var pagination = document.getElementById("pagination");

            // 构建分页链接
            var prevPageLink = '<a href="ApplyinfoServlet?type=query&page=' + (currentPage - 1) + '" class="' + (currentPage <= 1 ? 'layui-disabled' : '') + '"' + (currentPage <= 1 ? 'disabled' : '') + '>上一页</a>';
            var nextPageLink = '<a href="ApplyinfoServlet?type=query&page=' + (currentPage + 1) + '" class="' + (currentPage >= totalPages ? 'layui-disabled' : '') + '"' + (currentPage >= totalPages ? 'disabled' : '') + '>下一页</a>';

            // 更新分页部分的内容
            pagination.innerHTML = '<a href="ApplyinfoServlet?type=query&page=1" class="' + (currentPage <= 1 ? 'layui-disabled' : '') + '"' + (currentPage <= 1 ? 'disabled' : '') + '>首页</a>' +
                prevPageLink +
                '<span class="layui-laypage-curr"><em class="layui-laypage-em"></em><em>' + currentPage + '</em></span>' +
                nextPageLink +
                '<a href="ApplyinfoServlet?type=query&page=' + totalPages + '" class="' + (currentPage >= totalPages ? 'layui-disabled' : '') + '"' + (currentPage >= totalPages ? 'disabled' : '') + '>尾页</a>';
            layer.open({
                offset: '100px', //设置弹出窗口的位置 上边距100px
                type: 2,  //弹出类型
                skin: 'layui-layer-demo', //样式类名
                title: '课程申请详情查看',
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
