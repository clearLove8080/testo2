 <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <%@include file="common.jsp" %> 
    <script type="text/javascript" src="<%=basePath%>js/index.js"></script>
  <body  class="easyui-layout">
 <div region="north" style="height: 78px;background-color: #E0ECFF">
    <table style="padding: 5px" width="100%">
        <tr>
            <td width="50%">
                <img alt="logo" src="images/bglogo.png">
            </td>
            <td valign="bottom" align="right" width="50%">
                <font size="3">&nbsp;&nbsp;<strong>欢迎：</strong></font>sxt
            </td>
        </tr>
    </table>
</div>
<div region="center">
    <div class="easyui-tabs" fit="true" border="false" id="tabs">
        <div title="首页" data-options="iconCls:'icon-home'">
            <div align="center" style="padding-top: 100px"><font color="blue" size="10">挖财财务管理系统1.0版</font></div>
        </div>
    </div>
</div>
<div region="west" style="width: 200px" title="导航菜单" split="true">
    <div class="easyui-accordion" data-options="fit:true,border:false">
        <div title="管理中心" data-options="selected:true,iconCls:'icon-yxgl'" style="padding: 10px">
            <a href="javascript:openTab('账户管理','account/index')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-yxjhgl'" style="width: 150px">账户管理</a>
            <a href="javascript:openTab('收入管理','payIn/index')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-khkfjh'" style="width: 150px">收入管理</a>
            <a href="javascript:openTab('支出管理','payOut/index')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-khkfjh'" style="width: 150px">支出管理</a>
            <a href="javascript:openTab('报表管理','count/index')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-khkfjh'" style="width: 150px">报表管理</a>     	
        </div>
       
        
        <div title="系统管理"  data-options="iconCls:'icon-item'" style="padding:10px">
            <a href="javascript:openPasswordModifyDialog()" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-modifyPassword'" style="width: 150px;">修改密码</a>
            <a href="javascript:logout()" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-exit'" style="width: 150px;">安全退出</a>
        </div>
    </div>
</div>
<div region="south" style="height: 25px;padding: 5px" align="center">
    版本所有 上海尚学堂 <a href="http://www.shsxt.com" target="_blank">www.shsxt.com</a>(2016-2026)
</div>
  </body>
</html>
