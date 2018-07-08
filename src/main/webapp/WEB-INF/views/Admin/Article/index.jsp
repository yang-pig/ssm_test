<%@ include file="../Public/header.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/tags" prefix="date"%>
<script src="${ctx}/resources/js/jquery-1.4.2.min.js"></script>
<div class="aright">
<div class="arz cl"><a href="${ctx}/backend/article/add"><i class="layui-icon">&#xe608;</i>添加文章</a></div>
<form method="post" class="aform cl" action="${ctx}/backend/article/dels">
<table width="100%">
      <tr>
	    <th width="5%" align="center"><input type="checkbox" name="checkbox" id="selall" /></th>
		<th width="5%" align="center">编号</th>
        <th width="25%" align="center">文章标题</th>
		<th width="10%" align="center">缩略图</th>
        <th width="10%" align="center">是否推荐</th>
		<th width="9%" align="center">是否精选</th>
		<%--<th width="9%" align="center">所属栏目</th>--%>
		<th width="9%" align="center">审核显示</th>
		<th width="9%" align="center">添加时间</th>
        <th width="9%" align="center">基本操作</th>
      </tr>
      <c:forEach var="vo" items="${pageInfo.list}">

	  <tr>
	    <td align="center"><input type="checkbox" class="selall" name="deletes" value="${vo.id}" /></td>
		<td align="center">${vo.id}</td>
        <td align="center"><a target="_blank" href="{:U('Home/index/article',array('id'=>$vo['id']))}">${vo.title}</a></td>
		<td align="center">

            <c:if test="${vo.pic == '' ||  vo.pic == null}">
                暂无缩略图
            </c:if>
            <c:if test="${vo.pic != ''}">
                <img src="${vo.pic}" height="30">
            </c:if>

		</td>
		<td align="center">

            <c:if test="${vo.commend == 1}">
                <span style="color:#FF5722;">已推荐</span>
            </c:if>
            <c:if test="${vo.commend != 1}">
                未推荐
            </c:if>

        </td>
		<td align="center">
            <c:if test="${vo.choice == 1}">
                <span style="color:#FF5722;">已精选</span>
            </c:if>
            <c:if test="${vo.choice != 1}">
                未精选
            </c:if>
        </td>
		<%--<td align="center">--%>
            <%--<c:if test="${vo.tid == 0}">--%>
                <%--<span style="color:#FF5722;">投稿栏目</span>--%>
            <%--</c:if>--%>
            <%--<c:if test="${vo.tid != 0}">--%>
                <%----%>
            <%--</c:if>--%>
        <%--</td>--%>
		<td align="center">
            <c:if test="${vo.status == 0}">
                <span style="color:#FF5722;">待审核</span>
            </c:if>
            <c:if test="${vo.status != 0}">
                显示
            </c:if>
        </td>

          <td align="center">

              <date:date value="${vo.time}" patten="yyyy-MM-dd HH:mm"/>

          </td>


        <td align="center"><a href="${ctx}/backend/article/edit?id=${vo.id}">修改</a> | <a href="${ctx}/backend/article/del?id=${vo.id}" onclick="return confirm('您确定要删除吗？');">删除</a>
        </td>
      </tr>
      </c:forEach>
 </table>
<div class="layui-form-item">
    <div style="margin-top: 20px;">
	  <button class="layui-btn" onclick="return confirm('您确定要删除吗？');" type="submit">删除选中</button>
      <button class="layui-btn layui-btn-primary" onclick="history.go(-1)">返回</button>
    </div>
</div>
 </form>
 <div class="pages">
     <div>
         <%--总共${pageInfo.pages}页 当前第${pageInfo.pageNum}页 一共${pageInfo.total}条记录--%>

         <!--循环遍历连续显示的页面，若是当前页就高亮显示，并且没有链接-->
         <c:forEach items="${pageInfo.navigatepageNums}" var="page_num">
             <c:if test="${page_num == pageInfo.pageNum}">
                 <span class="current">${page_num}</span>
             </c:if>
             <c:if test="${page_num != pageInfo.pageNum}">
                 <a class="num" href="${ctx}/backend/article/index?pn=${page_num}">${page_num}</a>
             </c:if>
         </c:forEach>

         <c:if test="${pageInfo.hasNextPage}">
             <a class="next" href="${ctx}/backend/article/index?pn=${pageInfo.pageNum+1}">&gt;&gt;</a>
         </c:if>



     </div>




 </div>
</div>
</div>
<script>

//    Confirm();
//    function Confirm() {
//        layui.use('layer', function(){
//            var layer = layui.layer;
//
//            layer.confirm('您确定要删除吗？', {
//                btn: ['确定','取消'] //按钮
//            }, function(){
//
//
//            }, function(){
//
//
//            });
//        });
//    }







$("#selall").click(function(){
    if($(this).attr("checked")){
		$(".selall").attr("checked","checked");
	}else{
		$(".selall").removeAttr("checked");
	}

})
</script>
</body>
</html>