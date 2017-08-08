
$(function(){
	$("#dlg").dialog({
		onClose:function(){
			//alert(1);
			initFormData();
			
		}
	})
})



/**
 * 多条件查询账户记录
 */
function searchAccount(){
	$("#dg").datagrid("load",{
		aname:$("#aname").val(),
		type:$("#type").combobox("getValue"),
		time:$("#time").datebox("getValue")
	})
}

function formateType(val,rowdata,index){
	if(val==0){
		return "工商";
	}
	if(val==1){
		return "建设";
	}
}

/**
 * 打开添加账户对话框
 */
function openAddAccountDlg(){
	$("#dlg").dialog("open");
}



function initFormData(){
	$("#fm").form("clear");
}

function closeDlg(){
	$("#dlg").dialog("close");
}


/**
 *   提交表单
 */

function submitForm(){
	$("#fm").form("submit",{
		url:"account/saveOrUpdateAccount",
		onSubmit: function(){    
	        return $("#fm").form("validate");   
	    }, 
	    success:function(data){
	    	/**
	    	 * data  原生json 字符串
	    	 */
	    	data= JSON.parse(data);// 字符串 转为js 对象
	    	if(data.code==200){
	    		/**
	    		 * 关闭对话框
	    		 * 刷新datagrid 
	    		 */
	    		closeDlg();
	    		searchAccount();
	    	}else{
	    		$.messager.alert("来自旺财",data.msg,"error");
	    	}
	    	
	    }
	})
}


function openModifyAccountDlg(){
	var rows=$("#dg").datagrid("getSelections");// 获取用户选中的行记录
	if(rows.length==0){
		$.messager.alert("来自旺财","请选择更新记录!","error");
		return;
	}
	
	if(rows.length>1){
		$.messager.alert("来自旺财","只能选择一条记录进行更新!","error");
		return;
	}
	
	$("#fm").form("load",rows[0]);//填充选中饿行记录数据到表单
	//openAddAccountDlg();
	$("#dlg").dialog("open");
}


function deleteAccount(){
	var rows=$("#dg").datagrid("getSelections");// 获取用户选中的行记录
	if(rows.length==0){
		$.messager.alert("来自旺财","请选择删除记录!","error");
		return;
	}
	
	
	/**
	 * ajax 
	 *   post
	 *   url:account/deleteAccount
	 *   data:ids=10&ids=20&ids=30
	 */
	var ids="ids=";
	for(var i=0;i<rows.length;i++){
		if(i<=rows.length-2){
			ids=ids+rows[i].id+"&ids=";
		}else{
			ids=ids+rows[i].id;
		}
	}
	
	$.messager.confirm("来自旺财","确定删除选中的"+rows.length+"条记录?",function(r){
		if(r){
			$.ajax({
				type:"post",
				url:"account/deleteAccount",
				data:ids,
				dataType:"json",
				success:function(data){
					if(data.code==200){
						searchAccount();
					}else{
						$.messager.alert("来自旺财",data.msg,"error");
					}
				}
			})
		}
	})
	
	
	
	
}