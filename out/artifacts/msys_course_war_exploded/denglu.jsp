<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%--判断是否有错误消息--%>
<c:if test="${msg!=null}">
    <script>
        alert("${msg}");
    </script>
</c:if>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>在线课程申请系统</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="${ctx}/static/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="${ctx}/static/style/admin.css" media="all">
    <link rel="stylesheet" href="${ctx}/static/style/login.css" media="all">
</head>
<body style="background: url('${ctx}/img/888.jpg');background-position: center center;background-size: cover;">

<div class="layadmin-user-login layadmin-user-display-show" id="LAY-user-login"
     style="display: none;">
    <form action="StudentServlet?type=login" method="post">
        <div class="layadmin-user-login-main" style=" width:450px; height:350px; margin-top:60px; margin-right:150px;background: rgba(250,250,250,0.45);">
            <div class="layadmin-user-login-box layadmin-user-login-header">
                <h2>欢迎来到在线课程申请系统</h2>
            </div>
            <div class="layadmin-user-login-box layadmin-user-login-body layui-form">
                <div class="layui-form-item">
                    <label class="layadmin-user-login-icon layui-icon layui-icon-username"
                           for="LAY-user-login-username"></label>
                    <input type="text" name="username" id="LAY-user-login-username" lay-verify="required"
                           placeholder="用户名"
                           class="layui-input">
                </div>
                <div class="layui-form-item">
                    <label class="layadmin-user-login-icon layui-icon layui-icon-password"
                           for="LAY-user-login-password"></label>
                    <input type="password" name="password" id="LAY-user-login-password" lay-verify="required"
                           placeholder="密码" class="layui-input">
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">你的身份是</label>
                    <div class="layui-input-block">
                        <input type="radio" name="role" value="主管教师" title="主管教师">
                        <input type="radio" name="role" value="主讲教师" title="主讲教师" >
                        <input type="radio" name="role" value="学生" title="学生" checked>
                    </div>
                </div>

                <div class="layui-form-item ">
                    <button type="submit" class="layui-btn layui-btn-fluid layui-bg-cyan" >
                        登录
                    </button>
                </div>


                <%--<div class="layui-trans layui-form-item layadmin-user-login-other">--%>
                    <%--<a href="register.jsp" class="layadmin-user-jump-change layadmin-link" style="color: white;">用户注册--%>
                    <%--</a>--%>

                <%--</div>--%>
            </div>
        </div>
    </form>
</div>
<script src="${ctx}/static/layui/layui.js"></script>
<script src="${ctx}/static/js/jquery-1.9.1.min.js"></script>
<script>
    //Demo
    layui.use('form', function(){
        var form = layui.form;

        //监听提交
        form.on('submit(formDemo)', function(data){
            layer.msg(JSON.stringify(data.field));
            return false;
        });
    });
</script>

</body>
</html>