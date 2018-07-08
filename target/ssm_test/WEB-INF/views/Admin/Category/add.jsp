<%@ include file="../Public/header.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<div class="aright">

<fieldset class="layui-elem-field layui-field-title" style="margin: 20px 30px 20px 20px;">
  <legend>添加栏目</legend>
</fieldset>

<form class="layui-form bform" method="post" action="${ctx}/backend/category/addAjax" enctype="multipart/form-data">

  <div class="layui-form-item">
    <label class="layui-form-label">栏目名称</label>
    <div class="layui-input-block">
      <input type="text" name="name" required lay-verify="required" placeholder="必填内容" autocomplete="off" class="layui-input">
    </div>
  </div>

  <div class="layui-form-item" style="width: 300px;">
    <label class="layui-form-label">所属栏目</label>
    <div class="layui-input-block">
      <select name="tid">
      <option value="0">顶级栏目</option>

        <c:forEach var="f" items="${categoryFather}">
          <option value="${f.id}">${f.name}</option>
        </c:forEach>

      </select>
    </div>
  </div>

  <div class="layui-form-item">
    <label class="layui-form-label">所属类型</label>
    <div class="layui-input-block">
      <input type="radio" name="type" value="1" title="文章" checked="">
      <input type="radio" name="type" value="2" title="产品" >
    </div>
  </div>

  <div class="layui-form-item">
    <label class="layui-form-label">缩略图</label>
     <div class="layui-input-block">
     <div class="file-box">
     <i class="layui-icon">&#xe61f;</i>
     <input class="file-btn" type="button" value="选择图片"> 
     <input class="file-txt" type="text" name="textfield" id="textfield"> 
     <input class="file-file" type="file" name="pic" id="pic" size="28" onchange="document.getElementById('textfield').value=this.value" /> 
     </div>
     </div>
  </div>

  <div class="layui-form-item">
    <label class="layui-form-label">关键词</label>
    <div class="layui-input-block">
      <input type="text" name="keywords" placeholder="请输入内容" autocomplete="off" class="layui-input">
    </div>
  </div>

  <div class="layui-form-item layui-form-text">
    <label class="layui-form-label">描述</label>
    <div class="layui-input-block">
      <textarea name="description" placeholder="请输入内容" class="layui-textarea"></textarea>
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