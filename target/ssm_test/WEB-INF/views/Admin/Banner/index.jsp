<%@ include file="../Public/header.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/tags" prefix="date"%>
<div class="aright">

<fieldset class="layui-elem-field layui-field-title" style="margin: 20px 30px 20px 20px;">
  <legend>幻灯管理</legend>
</fieldset>

<form class="layui-form bform" method="post" action="${ctx}/backend/banner/editAjax" enctype="multipart/form-data">
    <input type="hidden" name="id" value="${banner.id}">

   <div class="layui-form-item">
    <label class="layui-form-label">幻灯标题1</label>
    <div class="layui-input-block">
      <input type="text" name="atitle" value="${banner.atitle}" placeholder="请输入内容" autocomplete="off" class="layui-input">
    </div>
   </div>

   <div class="layui-form-item">
    <label class="layui-form-label">幻灯连接1</label>
    <div class="layui-input-block">
      <input type="text" name="alink" value="${banner.alink}" placeholder="请输入内容" autocomplete="off" class="layui-input">
    </div>
   </div>

   <div class="layui-form-item">
    <label class="layui-form-label">幻灯图1</label>
     <div class="layui-input-block">
     <div class="file-box">
     <i class="layui-icon">&#xe61f;</i>
     <input class="file-btn" type="button" value="选择图片"> 
     <input class="file-txt" type="text" autocomplete="off" name="textfield" id="textfield"><c:if test="${banner.apic != '' && banner.apic != null}"><img src="${banner.apic}" height="50"></c:if>
     <input class="file-file" type="file" name="apic" id="apic" size="28" onchange="document.getElementById('textfield').value=this.value" />
     </div>
     </div>
   </div>

   <div class="layui-form-item">
    <label class="layui-form-label">幻灯标题2</label>
    <div class="layui-input-block">
      <input type="text" name="btitle" value="${banner.btitle}" placeholder="请输入内容" autocomplete="off" class="layui-input">
    </div>
   </div>

   <div class="layui-form-item">
    <label class="layui-form-label">幻灯连接2</label>
    <div class="layui-input-block">
      <input type="text" name="blink" value="${banner.blink}" placeholder="请输入内容" autocomplete="off" class="layui-input">
    </div>
   </div>

   <div class="layui-form-item">
    <label class="layui-form-label">幻灯图2</label>
     <div class="layui-input-block">
     <div class="file-box">
     <i class="layui-icon">&#xe61f;</i>
     <input class="file-btn" type="button" value="选择图片"> 
     <input class="file-txt" type="text" autocomplete="off" name="textfieldb" id="textfieldb"><c:if test="${banner.bpic != '' && banner.bpic != null}"><img src="${banner.bpic}" height="50"></c:if>
     <input class="file-file" type="file" name="bpic" id="bpic" size="28" onchange="document.getElementById('textfieldb').value=this.value" /> 
     </div>
     </div>
   </div>

   <div class="layui-form-item">
    <label class="layui-form-label">幻灯标题3</label>
    <div class="layui-input-block">
      <input type="text" name="ctitle" value="${banner.ctitle}" placeholder="请输入内容" autocomplete="off" class="layui-input">
    </div>
   </div>

   <div class="layui-form-item">
    <label class="layui-form-label">幻灯连接3</label>
    <div class="layui-input-block">
      <input type="text" name="clink" value="${banner.clink}" placeholder="请输入内容" autocomplete="off" class="layui-input">
    </div>
   </div>

   <div class="layui-form-item">
    <label class="layui-form-label">幻灯图3</label>
     <div class="layui-input-block">
     <div class="file-box">
     <i class="layui-icon">&#xe61f;</i>
     <input class="file-btn" type="button" value="选择图片"> 
     <input class="file-txt" type="text" autocomplete="off" name="textfieldc" id="textfieldc"><c:if test="${banner.cpic != '' && banner.cpic != null}"><img src="${banner.cpic}" height="50"></c:if>
     <input class="file-file" type="file" name="cpic" id="cpic" size="28" onchange="document.getElementById('textfieldc').value=this.value" /> 
     </div>
     </div>
   </div>

  <div class="layui-form-item" style="margin-top: 30px;">
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