<%@ include file="../Public/header.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/tags" prefix="date"%>
<div class="aright">

<div class="arz cl"><a href="${ctx}/backend/nav/add"><i class="layui-icon">&#xe608;</i>添加导航</a></div>
<form method="post" class="aform cl">
<table width="100%">
<tr>
<th width="10%" align="center">导航排序</th>
<th width="20%" align="center">导航名称</th>
<th width="10%" align="center">前台显示</th>
<th width="40%" align="center">导航连接</th>
<th width="10%" align="center">添加时间</th>
<th width="10%" align="center">基本操作</th>
</tr>
<c:forEach var="navf" items="${navFather}">
<tr>
<td style="padding-left: 20px;">${navf.sort}</td>
<td style="padding-left: 20px;">${navf.name}</td>
<td align="center">
    <c:if test="${navf.status == 1}">
        显示
    </c:if>
    <c:if test="${navf.status == 0}">
        隐藏
    </c:if>
</td>
<td style="padding-left: 20px;">
    <c:choose>
        <c:when test="${navf.link == ''}">
            暂无链接
        </c:when>
        <c:otherwise>
            ${navf.link}
        </c:otherwise>
    </c:choose>

</td>
<td align="center">
    <date:date value="${navf.time}" patten="yyyy-MM-dd HH:mm"/>

</td>
<td align="center">
<a href="${ctx}/backend/nav/edit?id=${navf.id}">修改</a> | <a href="${ctx}/backend/nav/del?id=${navf.id}" onclick="return confirm('您确定删除吗？');">删除</a>
</td>
</tr>
<c:forEach var="navc" items="${navChild}">
<if condition = "$vo.id eq $vs['tid']">
<c:choose>
<c:when test="${navf.id == navc.tid}">
    <tr>
        <td style="padding-left: 20px;">———— ${navc.sort}</td>
        <td style="padding-left: 20px;">———— ${navc.name}</td>
        <td align="center">


            <c:if test="${navc.status == 1}">
                显示
            </c:if>
            <c:if test="${navc.status == 0}">
                隐藏
            </c:if>
        </td>
        <td style="padding-left: 20px;">

            <c:choose>
                <c:when test="${navc.link == ''}">
                    暂无链接
                </c:when>
                <c:otherwise>
                    ${navc.link}
                </c:otherwise>
            </c:choose>

        </td>
        <td align="center"><date:date value="${navc.time}" patten="yyyy-MM-dd HH:mm"/></td>
        <td align="center">
            <a href="${ctx}/backend/nav/edit?id=${navc.id}">修改</a> | <a href="${ctx}/backend/nav/del?id=${navc.id}" onclick="return confirm('您确定删除吗？');">删除</a>
        </td>
    </tr>

</c:when>
</c:choose>


</if>
</c:forEach>
</c:forEach>
</table>
</form> 
</div>
</div>
</body>
</html>



