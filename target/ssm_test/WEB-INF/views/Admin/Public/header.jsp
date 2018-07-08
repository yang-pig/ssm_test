<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>博客管理系统</title>
    <link rel="stylesheet" href="${ctx}/resources/css/admin.css">
    <link rel="stylesheet" href="${ctx}/resources/layui/css/layui.css">
    <script src="${ctx}/resources/layui/layui.js"></script>
</head>
<body>
<div class="header">
    <h2 class="z cl"><a href="#"><img src="${ctx}/resources/img/logo.png"></a></h2>
    <div class="y cl">
        <a target="_blank" href="#">网站首页</a>
        <a href="${ctx}/backend/login/layout">退出</a>
    </div>
</div>
<div class="admin">
    <div class="aleft">
        <h3><i class="layui-icon" style="position: relative;right: 3px;top: 1px;font-size: 18px;color: #009688;">&#xe643;</i>操作菜单</h3>
        <ul class="cl">
            <li><i class="layui-icon">&#xe601;</i><a href="${ctx}/backend/nav/index">导航管理</a></li>
            <li><i class="layui-icon">&#xe61f;</i><a href="${ctx}/backend/category/index">栏目管理</a></li>
            <li><i class="layui-icon">&#xe63c;</i><a href="${ctx}/backend/article/index">文章管理</a></li>
            <li><i class="layui-icon">&#xe60c;</i><a href="${ctx}/backend/banner/index">幻灯管理</a></li>
        </ul>
        <h3><i class="layui-icon" style="position: relative;right: 3px;top: 1px;font-size: 18px;color: #009688;">&#xe614;</i>系统管理</h3>
        <ul class="cl">
            <li><i class="layui-icon">&#xe62c;</i><a href="${ctx}/backend/conf/index">网站配置</a></li>
            <li><i class="layui-icon">&#xe631;</i><a href="${ctx}/backend/member/index">密码修改</a></li>
            <li><i class="layui-icon">&#x1006;</i><a href="${ctx}/backend/login/layout">立即退出</a></li>
        </ul>
    </div>