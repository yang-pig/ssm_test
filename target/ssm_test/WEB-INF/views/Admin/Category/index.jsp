<%@ include file="../Public/header.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/tags" prefix="date"%>
<div class="aright">

    <div class="arz cl"><a href="${ctx}/backend/category/add"><i class="layui-icon">&#xe608;</i>添加栏目</a></div>
    <form method="post" class="aform cl">
        <table width="100%">
            <tr>
                <th width="10%" align="center">栏目编号</th>
                <th width="20%" align="center">栏目名称</th>
                <th width="10%" align="center">栏目类型</th>
                <th width="20%" align="center">栏目图片</th>
                <th width="20%" align="center">添加时间</th>
                <th width="20%" align="center">基本操作</th>
            </tr>
                <c:forEach var="f" items="${categoryFather}">
                <tr>
                    <td align="center">${f.id}</td>
                    <td style="padding-left: 20px;"><a target="_blank" href="{:U('Home/index/category',array('id'=>$vo['id']))}">${f.name}</a></td>
                    <td align="center">


                        <c:if test="${f.type == 1}">
                            文章
                        </c:if>
                        <c:if test="${f.type == 2}">
                            产品
                        </c:if>


                    </td>
                    <td align="center">

                        <c:if test="${f.pic == '' ||  f.pic == null}">
                            暂无图片
                        </c:if>
                        <c:if test="${f.pic != ''}">
                            <img src="${f.pic}" height="30">
                        </c:if>


                    </td>
                    <td align="center">
                        <date:date value="${f.time}" patten="yyyy-MM-dd HH:mm"/>
                    </td>
                    <td align="center">
                        <a href="${ctx}/backend/category/edit?id=${f.id}">修改</a> | <a href="${ctx}/backend/category/del?id=${f.id}" onclick="return confirm('您确定删除吗？');">删除</a>
                    </td>
                </tr>
                    <c:forEach var="c" items="${categoryChild}">
                        <c:if test="${c.tid == f.id}">
                        <tr>
                            <td align="center">${c.id}</td>
                            <td style="padding-left: 20px;">
                                ———— <a target="_blank" href="{:U('Home/index/category',array('id'=>$vs['id']))}">${c.name}</a>
                            </td>
                            <td align="center">
                                <c:if test="${c.type == 1}">
                                    文章
                                </c:if>
                                <c:if test="${c.type == 2}">
                                    产品
                                </c:if>
                            </td>
                            <td align="center">
                                <c:if test="${f.pic == '' ||  f.pic == null}">
                                    暂无图片
                                </c:if>
                                <c:if test="${f.pic != ''}">
                                    <img src="${f.pic}" height="30">
                                </c:if>
                            </td>
                            <td align="center">
                                <date:date value="${c.time}" patten="yyyy-MM-dd HH:mm"/>
                            </td>
                            <td align="center">
                                <a href="${ctx}/backend/category/edit?id=${c.id}">修改</a> | <a href="${ctx}/backend/category/del?id=${c.id}" onclick="return confirm('您确定删除吗？');">删除</a>
                            </td>
                        </tr>
                        </c:if>
                    </c:forEach>
                </c:forEach>
        </table>
    </form>
</div>
</div>
</body>
</html>



