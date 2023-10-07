<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<c:if test="${sessionScope.loginUser==null}">
    <script>
        alert("登录以后才可以访问");
        location.href = "denglu.jsp";
    </script>
</c:if>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>在线课程申请系统</title>
    <link rel="stylesheet" href="${ctx}/static/layui/css/layui.css" media="all">
    <script src="${ctx}/static/layui/layui.js"></script>
    <script src="${ctx}/static/js/jquery-1.9.1.min.js"></script>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin ">
    <div class="layui-header" style="background-color: #2F4F4F ">
        <div class="layui-logo " style="background-color: #2F4F4F ;color: white">在线课程申请系统</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-right ">
            <li class="layui-nav-item">
                <a href="javascript:;"style="background-color: #2F4F4F  ; color: white">
                    ${sessionScope.loginUser.username}
                </a>

            </li>
            <li class="layui-nav-item"><a href="${ctx}/StudentServlet?type=logout"style="background-color: #2F4F4F ;color: white ">退出登录</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-green" >
        <div class="layui-side-scroll ">

            <c:if test="${sessionScope.loginUser.role=='主管教师'}">
                <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
                <ul class="layui-nav layui-nav-tree layui-bg-green" style=" color:black" lay-filter="test">
                    <li class="layui-nav-item layui-nav-itemed">
                        <a class="" href="javascript:;">课程信息</a>
                        <dl class="layui-nav-child">
                            <dd><a href="${ctx}/CourseServlet?type=preadd"
                                   target="tqmContent">添加</a></dd>
                            <dd><a href="${ctx}/CourseServlet?type=query"
                                   target="tqmContent">管理</a></dd>
                        </dl>
                    </li>
                    <li class="layui-nav-item  layui-nav-itemed">
                        <a href="javascript:;">教师</a>
                        <dl class="layui-nav-child">
                            <dd><a href="${ctx}/teacherAdd.jsp"
                                   target="tqmContent">添加</a></dd>

                            <dd><a href="${ctx}/TeacherServlet?type=query"
                                   target="tqmContent">管理</a></dd>
                        </dl>
                    </li>
                    <li class="layui-nav-item  layui-nav-itemed">
                        <a href="javascript:;">学生</a>
                        <dl class="layui-nav-child">
                            <dd><a href="${ctx}/studentAdd.jsp"
                                   target="tqmContent">添加</a></dd>
                        </dl>

                        <dl class="layui-nav-child">
                            <dd><a href="${ctx}/StudentServlet?type=query"
                                   target="tqmContent">管理</a></dd>
                        </dl>
                    </li>
                    <li class="layui-nav-item  layui-nav-itemed">
                        <a href="javascript:;">课程审批</a>


                        <dl class="layui-nav-child">
                            <dd><a href="${ctx}/ApplyinfoServlet?type=lastShen"
                                   target="tqmContent">审批</a></dd>
                        </dl>
                    </li>

                </ul>
            </c:if>

            <c:if test="${sessionScope.loginUser.role=='学生'}">
                <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
                <ul class="layui-nav layui-nav-tree layui-bg-green" style=" color:black" lay-filter="test">
                    <li class="layui-nav-item layui-nav-itemed">
                        <a class="" href="javascript:;">课程信息</a>
                        <dl class="layui-nav-child">
                            <dd><a href="${ctx}/CourseServlet?type=choose&sid=${loginUser.id}"
                                   target="tqmContent">选课</a></dd>

                        </dl>
                    </li>

                    <li class="layui-nav-item layui-nav-itemed">
                        <a class="" href="javascript:;">我的申请</a>
                        <dl class="layui-nav-child">
                            <dd><a href="${ctx}/ApplyinfoServlet?type=me&sid=${loginUser.id}"
                                   target="tqmContent">我的</a></dd>

                        </dl>

                    </li>


                </ul>
            </c:if>


            <c:if test="${sessionScope.loginUser.role=='主讲教师'}">
                <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
                <ul class="layui-nav layui-nav-tree layui-bg-green" style=" color:black" lay-filter="test">
                    <li class="layui-nav-item layui-nav-itemed">
                        <a class="" href="javascript:;">课程信息</a>
                        <dl class="layui-nav-child">
                            <dd><a href="${ctx}/CourseServlet?type=me"
                                   target="tqmContent">我的</a></dd>

                        </dl>
                    </li>


                </ul>
            </c:if>




        </div>
    </div>

    <div class="layui-body" style="overflow: hidden;">
        <!-- 内容主体区域 -->
        <div style="padding: 0px;height: 100%;width: 100%;">
            <iframe src="welcome.html" name="tqmContent"
                    style="border: 0px solid blue;height: 100%;width: 100%;"></iframe>
        </div>
    </div>


</div>

<script>
    //JavaScript代码区域
    layui.use('element', function () {
        var element = layui.element;

    });
</script>
</body>
</html>