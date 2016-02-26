<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/common/common.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<!--框架必需start-->
	<script type="text/javascript" src="js/jquery-1.4.js"></script>
	<script type="text/javascript" src="js/framework.js"></script>
	<link href="css/import_basic.css" rel="stylesheet" type="text/css"/>
	<link  rel="stylesheet" type="text/css" id="skin" prePath="<%=basePath%>"/>
	<script type="text/javascript" src="js/jquery.form.js"></script>
	<!--框架必需end-->
	<!--截取文字start-->
	<script type="text/javascript" src="js/text/text-overflow.js"></script>
	<!--截取文字end-->
	<script src="js/form/validationEngine-cn.js" type="text/javascript"></script>
	<script src="js/form/validationEngine.js" type="text/javascript"></script>
</head>
<body>
	<form action="" method="post" target="frmright" id="subform">
		<input type="hidden" id="id" name="_id" value="${id}"/>
		<table class="tableStyle" useMultColor="true"  useCheckBox="true">
			<tr>
				<td>原密码 ：</td>
				<td valign="top">
					<input type="text" id="opw" name="_opw" class="validate[required]" />
				</td>
			</tr>
			<tr>
				<td>新密码 ：</td>
				<td valign="top">
					<input type="text" id="npw" name="_npw" class="validate[required]" />
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" value=" 提 交 " id="subEnter"/>
					<input type="reset" value=" 重 置 "/>
				</td>
			</tr>
		</table>
	</form>	
<script type="text/javascript">
	$(document).ready(function(){
		$("#subEnter").bind("click",function(){
			var id = $("#id").val();
			var opw = $("#opw").val();
			var npw = $("#npw").val();
			if(isNotEmpty(opw) && isNotEmpty(npw) ){
				$.post("userManageAction!updatePw.do",{"id":id, "opw":opw, "npw":npw},
					function(data){
						if(data == "success"){
							top.Dialog.alert("修改密码成功！");
							top.window.location.href="login.jsp";
						}else if( data == "noauthor"){
							top.Dialog.alert("请匹配正确原密码！");
						}else {
							top.Dialog.alert("修改密码失败！");
						}
				})
			}else{
				top.Dialog.alert("请输入完整用户信息！");
			}
			
		})
		
		function isNotEmpty(fileds){
			return (fileds == null || fileds == "" || fileds == undefined) ? false: true;
		}
	})
</script>	
</body>
</html>