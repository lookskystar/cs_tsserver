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
		<table class="tableStyle" useMultColor="true"  useCheckBox="true">
			<tr>
				<td>班组：</td>
				<td>
	 				<select id="teamId" name="_teamId" class="default" style="width:126px;">
						<option value="">请选择</option>
						<c:forEach items="${teamList}" var="team">
							<option value="${team.id }">${team.name }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>姓名 ：</td>
				<td valign="top">
					<input type="text" id="xm" name="_xm" class="validate[required]" />
				</td>
			</tr>
			<tr>
				<td>工号：</td>
				<td valign="top">
					<input type="text" id="gonghao" name="_gonghao" class="validate[required]"/>
				</td>
			</tr>
			<tr>
				<td>密码：</td>
				<td valign="top">
					<input type="text" id="pw" name="_pw" class="validate[required]"/>
				</td>
			</tr>
			<tr>
				<td>职位：</td>
				<td>
	 				<select id="posId" name="_posId" class="default" style="width:126px;">
						<option value="">请选择</option>
						<c:forEach items="${positionList}" var="posi">
							<option value="${posi.posId }">${posi.posValue }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>卡号：</td>
				<td valign="top">
					<input type="text" id="jdkId" name="_jdkId" />
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
			var teamId = $("#teamId").val();
			var xm = $("#xm").val();
			var gonghao =  $("#gonghao").val();
			var pw = $("#pw").val();
			var posId = $("#posId").val();
			var jdkId = $("#jdkId").val();
			if(isNotEmpty(teamId) && isNotEmpty(xm) && isNotEmpty(gonghao) && isNotEmpty(pw)&& isNotEmpty(posId)){
				$.post("userManageAction!saveOrUpdateUsers.do",{"teamId":teamId, "xm":xm, "gonghao":gonghao, "pw":pw, "posId":posId,"jdkId":jdkId},
					function(data){
						if(data == "success"){
							top.Dialog.alert("新增用户成功！");
							top.window.frmright.location.href="userManageAction!findUsersByCondition.do";
						}else{
							top.Dialog.alert("新增用户失败！");
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