<%@ include file="../Public/header.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<div class="aright">
    <div class="aright_1">

        <blockquote style="padding: 10px;border-left: 5px solid #FF5722;" class="layui-elem-quote">系统信息：</blockquote>
        <table width="100%">
            <tr><td width="110px">程序版本</td><td>blog 1.0 博客管理系统</td></tr>
            <tr><td>操作系统版本</td><td>${props['os.name']} ${props['os.version']}</td></tr>
            <tr><td>操作系统类型</td><td>${props['os.arch']} ${props['sun.arch.data.model']}位</td></tr>
            <tr><td>JAVA运行环境</td><td>${props['java.runtime.name']} ${props['java.runtime.version']}</td></tr>
            <tr><td>JAVA虚拟机</td><td>${props['java.vm.name']} ${props['java.vm.version']}</td></tr>
            <tr><td>系统帐号</td><td>${props['user.name']}</td></tr>
            <tr><td>目录:</td><td>${props['user.dir']},临时目录:${props['java.io.tmpdir']}</td></tr>

            <tr><td>内存(MB)</td>
                <td>已用: <fmt:formatNumber value="${(usedMemory/1024/1024)}" pattern="#.00"/> /
                    剩余:<fmt:formatNumber value="${(useableMemory/1024/1024)}" pattern="#.00"/> /
                    最大:<fmt:formatNumber value="${(maxMemory/1024/1024)}" pattern="#.00"/>
                </td></tr>





        </table>
        <blockquote style="padding: 10px;border-left: 5px solid #FF5722;" class="layui-elem-quote">开发团队：</blockquote>
        <table width="100%">
            <tr><td width="110px">版权所有</td><td>yang-pig</td></tr>
            <tr><td>特别提醒您</td><td>本程序均可免费下载使用。</td></tr>

        </table>
    </div>
</div>
</div>
</body>
</html>