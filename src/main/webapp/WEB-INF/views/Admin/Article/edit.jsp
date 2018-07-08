<%@ include file="../Public/header.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>

<link rel="stylesheet" href="${ctx}/resources/simditor/styles/simditor.css">
<link rel="stylesheet" href="${ctx}/resources/simditor/styles/simditor-markdown.css">
<script type="text/javascript" src="${ctx}/resources/simditor/scripts/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="${ctx}/resources/simditor/scripts/module.js"></script>
<script type="text/javascript" src="${ctx}/resources/simditor/scripts/uploader.js"></script>
<script type="text/javascript" src="${ctx}/resources/simditor/scripts/hotkeys.js"></script>
<script type="text/javascript" src="${ctx}/resources/simditor/scripts/simditor.js"></script>
<script type="text/javascript" src="${ctx}/resources/simditor/scripts/marked.js"></script>
<script type="text/javascript" src="${ctx}/resources/simditor/scripts/to-markdown.js"></script>
<script type="text/javascript" src="${ctx}/resources/simditor/scripts/simditor-markdown.js"></script>
<div class="aright">
<style type="text/css">
.tpt_sels a{padding-right:15px;position:relative}
.tpt_sels a{padding:0 20px 0 8px;color:#3B6268;background:#FFFFBA;border:1px #F8E06E solid;margin-right:5px;margin-bottom:5px;font-size:14px;height:26px;line-height:26px;display:block;float:left}
.tpt_pres a.selected{padding:0 8px;color:#3B6268;background:#FFFFBA;border:1px #F8E06E solid;margin-right:5px;margin-bottom:5px;font-size:14px;height:26px;line-height:26px;display:block;float:left}
.tpt_pres a{padding:0 8px;color:#fff;background:#5AC7A9;border:1px #5AC7A9 solid;margin-right:5px;margin-bottom:5px;font-size:14px;height:26px;line-height:26px;display:block;float:left}
.tpt_sels a em{width: 12px;height: 12px;font-style: normal;display: block;position: absolute;top: 7px;right: 4px;z-index: 2;background: url(${ctx}/resources/img/sx.png) no-repeat 0 0;}
</style>        
<fieldset class="layui-elem-field layui-field-title" style="margin: 20px 30px 20px 20px;">
  <legend>添加文章</legend>
</fieldset>

<form class="layui-form bform" method="post" action="${ctx}/backend/article/editAjax" enctype="multipart/form-data">

  <input type="hidden" value="${article.id}" name="id"/>
  <div class="layui-form-item">
    <label class="layui-form-label">文章标题</label>
    <div class="layui-input-block">
      <input type="text" name="title" value="${article.title}" required lay-verify="required" placeholder="必填内容" autocomplete="off" class="layui-input">
    </div>
  </div>

  <div class="layui-form-item" style="width: 300px;">
    <label class="layui-form-label">所属栏目</label>
    <div class="layui-input-block">
      <select name="tid">

          <c:forEach var="f" items="${categoryList}">

            <option <c:if test="${article.tid == f.id}">selected="selected"</c:if>
                    value="${f.id}">${f.name}</option>

          </c:forEach>

      </select>
    </div>
  </div>

  <div class="layui-form-item">
    <label class="layui-form-label">文章作者</label>
    <div class="layui-input-block">
      <input type="text" name="author" value="${article.author}" placeholder="请输入内容" autocomplete="off" class="layui-input">
    </div>
  </div>

  <div class="layui-form-item">
    <label class="layui-form-label">文章来源</label>
    <div class="layui-input-block">
      <input type="text" name="source" value="${article.source}" placeholder="请输入内容" autocomplete="off" class="layui-input">
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">审核显示</label>
    <div class="layui-input-block">


      <input type="checkbox" title="显示" name="open" value="1" <c:if test="${article.status == 1}">checked</c:if>>

    </div>
  </div>

  <div class="layui-form-item">
    <label class="layui-form-label">推荐精选</label>
    <div class="layui-input-block">

      <input type="checkbox" title="推荐" name="commend" value="1" <c:if test="${article.commend == 1}">checked</c:if>>
      <input type="checkbox" title="精选" name="choice" value="1" <c:if test="${article.choice == 1}">checked</c:if>>
    </div>
  </div>

  <div class="layui-form-item">
    <label class="layui-form-label">缩略图</label>
     <div class="layui-input-block">
         <div class="file-box">
            <i class="layui-icon">&#xe61f;</i>
            <input class="file-btn" type="button" value="选择图片">
            <input class="file-txt" type="text" name="textfield" id="textfield"><c:if test="${article.pic != '' && article.pic != null}"><img src="${article.pic}" height="50"></c:if>
            <input class="file-file" type="file" name="pic" id="pic" size="28" onchange="document.getElementById('textfield').value=this.value" />
         </div>
     </div>
  </div>

  <div class="layui-form-item layui-form-text">
    <label class="layui-form-label">文章描述</label>
    <div class="layui-input-block">
      <textarea name="description" placeholder="请输入内容" class="layui-textarea">${article.description}</textarea>
    </div>
  </div>

  <div class="layui-form-item layui-form-text">
    <label class="layui-form-label">文章内容</label>
    <div class="layui-input-block">
      <textarea id="editor" name="content"  placeholder="请输入内容" autofocus="true" class="layui-textarea">${article.content}</textarea>
    </div>
  </div>

  <div class="tpt_item">
	<input type="hidden" name="keywords" value="">
	<div id="tpt_sel" class="tpt_sels" style="margin-top: 20px;">
		<span style="margin-bottom: 5px;float: left;margin-left: 110px;">


<c:if test="${keywords != null && fn:length(keywords) > 0}">
  <c:forEach var="k" items="${keywords}">
    <a href='javascript:;'>${k}<em></em></a>
  </c:forEach>

</c:if>

        </span>
		<div class="layui-form-item" style="margin-bottom: 10px;">
			<label class="layui-form-label">文章标签</label>
			<div class="layui-input-block">
				<input id="tpt_input" type="text" value="" autocomplete="off" class="layui-input" style="width: 400px;float: left;margin-right: 20px;">
				<button class="layui-btn" id="tpt_btn" type="button" style="background: #FF5722;">添加标签</button>
			</div>
		</div>
	</div>
	<div id="tpt_pre" class="tpt_pres layui-input-block cl" style="margin-bottom: 15px;">

    </div>

  <div class="layui-form-item">
    <div class="layui-input-block">
	  <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
      <button class="layui-btn layui-btn-primary" onclick="history.go(-1)">返回</button>
    </div>
  </div>

</form>
<script type="text/javascript">
$(function() {
	$('#tpt_input').keydown(function(e) {

		if (e.which === 13) {
			$("#tpt_btn").click();
			e.preventDefault();
			return false;
		}
	});
	$("#tpt_sel").on('click', 'a>em', function() {
		var name = "keywords";
//		console.log($(this).parent().text());
//		return false;
		var tag = $(this).parent().text();
		$(this).parent().remove();
		var tags = new Array();
		$("#tpt_sel").find('a').each(function() {
			tags.push($(this).text());
		});
		$("input[name=" + name + "]").val(tags.join(","));
		$("#tpt_pre a:contains('" + tag + "')").removeClass("selected");
	});
	$("#tpt_btn").click(function() {
		var name = "keywords";
		var tags = $.trim($("input[name=" + name + "]").val());
		if (tags !== "") {
			tags = tags.split(",");
		} else {
			tags = new Array();
		}
		var tag = $.trim($("#tpt_input").val());
		if (tag !== '' && $.inArray(tag, tags) === -1) {
			tags.push(tag);
			$("#tpt_pre a:contains('" + tag + "')").addClass("selected");
		}
		$("#tpt_sel").children('span').empty();
		$.each(tags, function(k, v) {
			$("#tpt_sel").children('span').append('<a href="javascript:;">' + v + '<em></em></a>');
		});
		$("input[name=" + name + "]").val(tags.join(","));
		$("#tpt_input").val('');
	});
	$("#tpt_pre").on('click', 'a:not(.selected)', function() {
		var name = "keywords";
		var tags = $.trim($("input[name=" + name + "]").val());
		if (tags !== "") {
			tags = tags.split(",");
		} else {
			tags = new Array();
		}
		var tag = $.trim($(this).text());
		if (tag !== '' && $.inArray(tag, tags) === -1) {
			tags.push(tag);
		}
		$("#tpt_sel").children('span').empty();
		$.each(tags, function(k, v) {
			$("#tpt_sel").children('span').append('<a href="javascript:;">' + v + '<em></em></a>');
		});
		$("input[name=" + name + "]").val(tags.join(","));
		$(this).addClass('selected');
	});
});
</script>
<script>
        var editor = new Simditor({
          textarea: $('#editor'),
          upload:{
            url: "{:U('article/doUploadPic')}",
            params: null,
            fileKey: 'upload_file',
            connectionCount: 3,
            leaveConfirm: '正在上传文件，如果离开上传会自动取消'
          },
          markdown: false,
          toolbar: [
          'title',
          'bold',
          'italic',
          'underline',
          'strikethrough',
          'fontScale',
          'color',
          'ol',
          'ul',
          'blockquote',
          'code',
          'table',
          'link',
          'image',
          'hr',
          'alignment',
          'markdown'
          ]
        });
</script>
<script>
layui.use('form', function(){
  var form = layui.form();
});
</script>
</div>
</div>
</body>
</html>