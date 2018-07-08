<%@ include file="../Public/header.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/tags" prefix="date"%>

<div class="aright">

<fieldset class="layui-elem-field layui-field-title" style="margin: 20px 30px 20px 20px;">
  <legend>密码修改</legend>
</fieldset>

<form class="layui-form bform" method="post" action="${ctx}/backend/member/editAjax" enctype="multipart/form-data">
  <input type="hidden" name="id" value="{$ddd.id}">
  
  <div class="layui-form-item">
    <label class="layui-form-label">输入密码</label>
    <div class="layui-input-block">
      <input type="password" name="pass1" required lay-verify="required" placeholder="必填内容" autocomplete="off" class="layui-input">
    </div>
  </div>

  <div class="layui-form-item">
    <label class="layui-form-label">重复密码</label>
    <div class="layui-input-block">
      <input type="password" name="pass2" required lay-verify="required" placeholder="必填内容" autocomplete="off" class="layui-input">
    </div>
  </div>

  <div class="layui-form-item">
    <label class="layui-form-label">管理员口令</label>
    <div class="layui-input-block">
      <input type="text" name="kouling" required lay-verify="required" placeholder="必填内容" autocomplete="off" class="layui-input">
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