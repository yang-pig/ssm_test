<%@ include file="../Public/header.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<div class="aright">

<fieldset class="layui-elem-field layui-field-title" style="margin: 20px 30px 20px 20px;">
  <legend>添加导航</legend>
</fieldset>

<form class="layui-form bform" method="post" action="${ctx}/backend/nav/addAjax">

  <div class="layui-form-item">
    <label class="layui-form-label">导航名称</label>
    <div class="layui-input-block">
      <input type="text" name="name" required lay-verify="required" placeholder="必填内容" autocomplete="off" class="layui-input">
    </div>
  </div>

  <div class="layui-form-item" style="width: 300px;">
    <label class="layui-form-label">导航分类</label>
    <div class="layui-input-block">
      <select name="tid">
      <option value="0">顶级导航</option>


      <c:forEach var="navf" items="${navFather}">
        <option value="${navf.id}">${navf.name}</option>
      </c:forEach>

      </select>
    </div>
  </div>

  <div class="layui-form-item">
    <label class="layui-form-label">导航排序</label>
    <div class="layui-input-block">
      <input type="text" name="sort" value="50" autocomplete="off" class="layui-input">
    </div>
  </div>

  <div class="layui-form-item">
    <label class="layui-form-label">窗口模式</label>
    <div class="layui-input-block">
      <input type="checkbox" name="blank" value="1" title="新窗口">
    </div>
  </div>

  <div class="layui-form-item">
    <label class="layui-form-label">前台显示</label>
    <div class="layui-input-block">
      <input type="radio" name="status" value="1" title="显示" checked>
      <input type="radio" name="status" value="0" title="隐藏">
    </div>
  </div>

  <div class="layui-form-item">
    <label class="layui-form-label">连接地址</label>
    <div class="layui-input-block">
      <input type="text" name="link" placeholder="请输入内容" autocomplete="off" class="layui-input">
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