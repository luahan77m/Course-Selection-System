<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>系统首页</title>
</head>
<body>
<c:if test="${sessionScope.loginUser.username==null}">
    <script>
        location.href = "denglu.jsp";
    </script>
</c:if>
<c:if test="${sessionScope.loginUser.username!=null}">
    <script>
        location.href = "OrderinfoServlet?type=query";
    </script>
</c:if>


</body>
</html>
