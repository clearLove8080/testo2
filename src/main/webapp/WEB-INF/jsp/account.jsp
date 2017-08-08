<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="common.jsp" %> 
<script type="text/javascript" src="<%=basePath%>js/account.js"></script>

<!-- 添加datagrid -->
<table id="dg"  class="easyui-datagrid" url="account/queryAccountsByParams" 
             pagination=true rownumbers=true fit=true  toolbar="#tb"   >
   <thead>   
        <tr> 
            <th data-options="field:'cb'"  checkbox=true></th>   
            <th data-options="field:'id'">编码</th>   
            <th data-options="field:'aname'">账户名称</th>   
            <th data-options="field:'money'">金额</th> 
            <th data-options="field:'type'" formatter="formateType" >类型</th> 
            <th data-options="field:'remark'">备注</th> 
            <th data-options="field:'createTime'">创建时间</th> 
            <th data-options="field:'updateTime'">更新时间</th>   
        </tr>   
    </thead>  
</table>


<div id="tb">
  <a href="javascript:openAddAccountDlg()" class="easyui-linkbutton" plain=true iconCls="icon-save">添加</a>
  <a href="javascript:openModifyAccountDlg()" class="easyui-linkbutton"  plain=true iconCls="icon-edit">修改</a>
  <a href="javascript:deleteAccount()" class="easyui-linkbutton"  plain=true iconCls="icon-remove">删除</a><br/>
  账户名称: <input id="aname" type="text" name="aname" />
  账户类型: <select id="type"  class="easyui-combobox" panelHeight="auto" name="type" style="width:200px;">   
    <option value="">全部</option>   
    <option value="0">工商</option>   
    <option value="1">建设</option>   
    </select>
    日期: <input id="time"  class="easyui-datebox" name="time" />    
  <a href="javascript:searchAccount()" class="easyui-linkbutton" plain=true iconCls="icon-search">查询</a>
</div>


<div id="dlg" class="easyui-dialog" title="保存账户" style="width:500px;height:300px;"   
        iconCls='icon-save' resizable=true   modal=true  closed=true  buttons="#bt">   
     <form id="fm"  method="post">
        账户名:<input name="aname" type="text"/><br/>
       账户类型:
     <select id="type"  class="easyui-combobox" panelHeight="auto" name="type" style="width:200px;">   
		    <option value="">全部</option>   
		    <option value="0">工商</option>   
		    <option value="1">建设</option>   
    </select><br/>
   账户金额:<input name="money" type="text"/><br/>
      备注:<input name="remark" type="text"/><br/>
      <input name="id" type="hidden"/><br/>
     </form>  
</div>  


<div id="bt">
    <a href="javascript:submitForm()" class="easyui-linkbutton" plain=true iconCls="icon-save">保存</a>
    <a href="javascript:closeDlg()" class="easyui-linkbutton"  plain=true iconCls="icon-cancel">取消</a>
</div>


 