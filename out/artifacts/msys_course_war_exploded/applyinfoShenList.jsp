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
            <c:if test="${v.status=='1'}">
            <tr>
                <td>${v.id}</td>
                <td>${v.sid}</td>
                <td>${v.cid}</td>
                <td>${v.content}</td>
                    <%--<td>${v.prove}</td>--%>
                <td>${v.status}</td>
                <td>${v.ctime}</td>
                <td>${v.stid}</td>
                <td>${v.stname}</td>
                <td>${v.streason}</td>
                <td>${v.atid}</td>
                <td>${v.atname}</td>
                <td>${v.atreason}</td>
                <td>${v.remark}</td>
                <td style="width: 300px;">
                    <form class="layui-form" action="ApplyinfoServlet?type=firstShen" method="post">

                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">理由</label>
                            <div class="layui-input-block">
                                <textarea name="streason" placeholder="请输入申请理由" class="layui-textarea"></textarea>
                            </div>
                        </div>
                        <input name="stid" value="${loginUser.id}" hidden>
                        <input name="stname" value="${loginUser.username}" hidden>
                        <input name="id" value="${v.id}" hidden>

                        <div class="layui-form-item">
                            <label class="layui-form-label">审批状态</label>
                            <div class="layui-input-block">
                                <select name="status" lay-verify="required">
                                    <option value=""></option>
                                    <option value="3">通过</option>
                                    <option value="2">拒绝</option>

                                </select>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <div class="layui-input-block">
                                <button class="layui-btn" type="submit">提交</button>

                            </div>
                        </div>
                    </form>

                </td>
            </tr>
            </c:if>
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
