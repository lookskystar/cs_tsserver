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
		<input type="hidden" id="id" name="_id" value="${user.userId }"/>
		<table class="tableStyle" useMultColor="true"  useCheckBox="true">
			<tr>
				<td>班组：</td>
				<td>
	 				<select id="teamId" name="_teamId" class="default" style="width:126px;">
						<option value="">请选择</option>
						<c:forEach items="${teamList}" var="team">
							<option value="${team.id }" <c:if test="${user.teamId == team.id }">selected="selected"</c:if>>${team.name }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>姓名 ：</td>
				<td valign="top">
					<input type="text" id="xm" name="_xm" value="${user.xm }" class="validate[required]" />
				</td>
			</tr>
			<tr>
				<td>工号：</td>
				<td valign="top">
					<input type="text" id="gonghao" name="_gonghao" value="${user.gongHao }" class="validate[required]"/>
				</td>
			</tr>
			<tr>
				<td>职位：</td>
				<td>
	 				<select id="posId" name="_posId" class="default" style="width:126px;">
						<option value="">请选择</option>
						<c:forEach items="${positionList}" var="posi">
							<option value="${posi.posId }" <c:if test="${user.posId == posi.posId }">selected="selected"</c:if>>${posi.posValue }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>卡号：</td>
				<td valign="top">
					<input type="text" id="jdkId" name="_jdkId" value="${user.jdkId }"/>
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
			var teamId = $("#teamId").val();
			var xm = $("#xm").val();
			var gonghao =  $("#gonghao").val();
			var posId = $("#posId").val();
			var jdkId = $("#jdkId").val();
			if(isNotEmpty(teamId) && isNotEmpty(xm) && isNotEmpty(gonghao) && isNotEmpty(posId)){
				$.post("userManageAction!saveOrUpdateUsers.do",{"id":id, "teamId":teamId, "xm":xm, "gonghao":gonghao, "posId":posId,"jdkId":jdkId},
					function(data){
						if(data == "success"){
							top.Dialog.alert("编辑用户成功！");
							top.window.frmright.location.href="userManageAction!findUsersByCondition.do";
						}else{
							top.Dialog.alert("编辑用户失败！");
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