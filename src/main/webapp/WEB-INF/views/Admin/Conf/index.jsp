<%@ include file="../Public/header.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/tags" prefix="date"%>
<script type="text/javascript" src="${ctx}/resources/simditor/scripts/jquery-1.11.3.min.js"></script>
<div class="aright">
<style type="text/css">
.tpt_sels a{padding-right:15px;position:relative}
.tpt_sels a{padding:0 20px 0 8px;color:#3B6268;background:#FFFFBA;border:1px #F8E06E solid;margin-right:5px;margin-bottom:5px;font-size:14px;height:26px;line-height:26px;display:block;float:left}
.tpt_sels a em{width: 12px;height: 12px;font-style: normal;display: block;position: absolute;top: 7px;right: 4px;z-index: 2;background: url(__ADMIN__/img/sx.png) no-repeat 0 0;}
</style>
<div class="layui-tab" lay-filter="demo" style="margin: 20px 30px 20px 20px;">
  <ul class="layui-tab-title">
    <li class="layui-this">基本设置</li>
    <%--<li>常用设置</li>--%>
  </ul>
  <div class="layui-tab-content">
    <div class="layui-tab-item layui-show">

<form class="layui-form bform" method="post" action="${ctx}/backend/conf/doEdit" enctype="multipart/form-data">
  <input type="hidden" name="id" value="${conf.id}">
  
  <div class="layui-form-item">
    <label class="layui-form-label">网站域名</label>
    <div class="layui-input-block">
      <input type="text" name="domain" value="${conf.domain}" placeholder="请输入内容" autocomplete="off" class="layui-input">
    </div>
  </div>

  <div class="layui-form-item">
    <label class="layui-form-label">网站作者</label>
    <div class="layui-input-block">
      <input type="text" name="author" value="${conf.author}" placeholder="请输入内容" autocomplete="off" class="layui-input">
    </div>
  </div>

  <div class="layui-form-item">
    <label class="layui-form-label">作者QQ</label>
    <div class="layui-input-block">
      <input type="text" name="qq" value="${conf.qq}" placeholder="请输入内容" autocomplete="off" class="layui-input">
    </div>
  </div>

  <div class="layui-form-item">
    <label class="layui-form-label">备案号</label>
    <div class="layui-input-block">
      <input type="text" name="record" value="${conf.record}" placeholder="请输入内容" autocomplete="off" class="layui-input">
    </div>
  </div>


  <div class="layui-form-item">
    <label class="layui-form-label">LOGO</label>
     <div class="layui-input-block">
     <div class="file-box">
     <i class="layui-icon">&#xe61f;</i>
     <input class="file-btn" type="button" value="选择图片"> 
     <input class="file-txt" type="text" autocomplete="off" name="textfield" id="textfield"><c:if test="${conf.logo != '' && conf.logo != null}"><img src="${conf.logo}" height="50"></c:if>
     <input class="file-file" type="file" name="logo" id="logo" size="28" onchange="document.getElementById('textfield').value=this.value" /> 
     </div>
     </div>
  </div>

  <div class="layui-form-item">
    <label class="layui-form-label">网站标题</label>
    <div class="layui-input-block">
      <input type="text" name="title" value="${conf.title}" placeholder="必填内容" required lay-verify="required" autocomplete="off" class="layui-input">
    </div>
  </div>

  <div class="layui-form-item layui-form-text">
    <label class="layui-form-label">关键字</label>
    <div class="layui-input-block">
      <textarea name="keywords" placeholder="请输入内容" class="layui-textarea">${conf.keywords}</textarea>
    </div>
  </div>

  <div class="layui-form-item layui-form-text">
    <label class="layui-form-label">网站描述</label>
    <div class="layui-input-block">
      <textarea name="description" placeholder="请输入内容" class="layui-textarea">${conf.description}</textarea>
    </div>
  </div>

  <div class="layui-form-item">
    <div class="layui-input-block">
	  <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
      <button class="layui-btn layui-btn-primary" onclick="history.go(-1)">返回</button>
    </div>
  </div>

</form>
	
	</div>

  </div>
</div>
<script  type="text/javascript">
layui.use('form', function(){
  var form = layui.form();
});
layui.use('element', function(){
  var element = layui.element();
  element.on('tab(demo)', function(data){
    console.log(data);
  });
});
</script>
</div>
</div>
</body>
</html>