<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
欢迎访问<br/>
<br/>
<a href="${ctx}/backend/login/index">后台演示，前台敬请期待！</a>
<br/>
<br/>
<div>
    <div>账号：admin </div>
    <div>密码：123456</div>
    <div>口令：123456</div>
</div>
</body>
</html>
