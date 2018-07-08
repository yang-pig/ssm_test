<%@ include file="../Public/header.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<div class="aright">
          
<fieldset class="layui-elem-field layui-field-title" style="margin: 20px 30px 20px 20px;">
  <legend>修改导航</legend>
</fieldset>

<form class="layui-form bform" method="post" action="${ctx}/backend/nav/editAjax">
  <input type="hidden" name="id" value="${nav.id}">
  <div class="layui-form-item">
    <label class="layui-form-label">导航名称</label>
    <div class="layui-input-block">
      <input type="text" name="name" value="${nav.name}" required lay-verify="required" placeholder="必填内容" autocomplete="off" class="layui-input">
    </div>
  </div>

  <div class="layui-form-item" style="width: 300px;">
    <label class="layui-form-label">导航分类</label>
    <div class="layui-input-block">
      <select name="tid">
       <option value="0">顶级导航</option>


        <c:forEach var="navf" items="${navFather}">
          <option
                  <c:if test="${navf.id == nav.id}">
                    disabled
                  </c:if>

                  <c:if test="${navf.id == nav.tid}">
                    selected="selected"
                  </c:if>

                  value="${navf.id}">${navf.name}</option>WW
        </c:forEach>
      </select>
    </div>
  </div>

  <div class="layui-form-item">
    <label class="layui-form-label">导航排序</label>
    <div class="layui-input-block">
      <input type="text" name="sort" value="${nav.sort}" placeholder="请输入内容" autocomplete="off" class="layui-input">
    </div>
  </div>

  <div class="layui-form-item">
    <label class="layui-form-label">窗口模式</label>
    <div class="layui-input-block">
      <input type="checkbox" name="blank" value="1" title="新窗口" <c:if test="${nav.blank == 1}"> checked </c:if>>
    </div>
  </div>

  <div class="layui-form-item">
    <label class="layui-form-label">前台显示</label>
    <div class="layui-input-block">
      <input type="radio" name="status" value="1" title="显示" <c:if test="${nav.status == 1}"> checked </c:if>>
      <input type="radio" name="status" value="0" title="隐藏" <c:if test="${nav.status == 0}"> checked </c:if>>
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">连接地址</label>
    <div class="layui-input-block">
      <input type="text" name="link" value="${nav.link}" placeholder="请输入内容" autocomplete="off" class="layui-input">
    </div>
  </div>

  <div class="layui-form-item">
    <div class="layui-input-block">
	  <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
      <button class="layui-btn layui-btn-primary" onclick="history.go(-1)">返回</button>
    </div>
  </div>

</form>
<script>
layui.use('form', function(){
  var form = layui.form();
});
</script>
</div>
</div>
</body>
</html>