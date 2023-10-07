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
        </tr>


        <c:forEach items="${applyinfoList}" var="v">
            <c:if test="${v.sid==loginUser.id}">
                <c:if test="${v.status!=5}">
                    <tr>
                        <td>${v.id}</td>
                        <td>${v.sid}</td>
                        <td>${v.cid}</td>
                        <td>${v.content}</td>
                            <%--<td>${v.prove}</td>--%>
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

                    </tr>

                </c:if>
            </c:if>
        </c:forEach>


        </tbody>
    </table>
</div>
<script>

</script>

</body>
</html>
