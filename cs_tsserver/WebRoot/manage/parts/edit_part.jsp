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
		<input type="hidden" id="id" name="_id" value="${part.unitId }"/>
		<table class="tableStyle" useMultColor="true"  useCheckBox="true">
			<tr>
				<td>名&nbsp;&nbsp;称：<input type="text" id="name" name="_name" value="${part.unitName }"/></td>
				<td>
					班&nbsp;&nbsp;组：
	 				<select id="teamId" name="_teamId">
						<option value="">请选择</option>
						<c:forEach items="${teamList}" var="team">
							<option value="${team.id }" <c:if test="${part.teamId == team.id }">selected="selected"</c:if>>${team.name }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td valign="top">
					修成1：
					<input type="text" id="xc1" name="_xc1" class="validate[required]" />
				</td>
				<td valign="top">
					修成2：
					<input type="text" id="xc2" name="_xc2" class="validate[required]" />
				</td>
			</tr>
			<tr>
				<td valign="top">
					探伤人员1&nbsp;&nbsp;：
					<select id="w1" name="_w1">
						<option value="">请选择</option>
						<c:forEach items="${tsUsers}" var="user">
							<option value="${user.xm }" <c:if test="${part.w1 == user.xm }">selected="selected"</c:if>>${user.xm }</option>
						</c:forEach>
					</select>
				</td>
				<td valign="top">
					探伤人员2&nbsp;&nbsp;：
					<select id="w2" name="_w2">
						<option value="">请选择</option>
						<c:forEach items="${tsUsers}" var="user">
							<option value="${user.xm }" <c:if test="${part.w2 == user.xm }">selected="selected"</c:if>>${user.xm }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td valign="top">
					探伤人员3&nbsp;&nbsp;：
					<select id="w3" name="_w3">
						<option value="">请选择</option>
						<c:forEach items="${tsUsers}" var="user">
							<option value="${user.xm }" <c:if test="${part.w3 == user.xm }">selected="selected"</c:if>>${user.xm }</option>
						</c:forEach>
					</select>
				</td>
				<td valign="top">
					探伤人员4&nbsp;&nbsp;：
					<select id="w4" name="_w4">
						<option value="">请选择</option>
						<c:forEach items="${tsUsers}" var="user">
							<option value="${user.xm }" <c:if test="${part.w4 == user.xm }">selected="selected"</c:if>>${user.xm }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td valign="top">
					探伤人员5&nbsp;&nbsp;：
					<select id="w5" name="_w5">
						<option value="">请选择</option>
						<c:forEach items="${tsUsers}" var="user">
							<option value="${user.xm }" <c:if test="${part.w5 == user.xm }">selected="selected"</c:if>>${user.xm }</option>
						</c:forEach>
					</select>
				</td>
				<td valign="top">
					探伤人员6&nbsp;&nbsp;：
					<select id="w6" name="_w6">
						<option value="">请选择</option>
						<c:forEach items="${tsUsers}" var="user">
							<option value="${user.xm }" <c:if test="${part.w6 == user.xm }">selected="selected"</c:if>>${user.xm }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td valign="top">
					探伤人员7&nbsp;&nbsp;：
					<select id="w7" name="_w7">
						<option value="">请选择</option>
						<c:forEach items="${tsUsers}" var="user">
							<option value="${user.xm }" <c:if test="${part.w7 == user.xm }">selected="selected"</c:if>>${user.xm }</option>
						</c:forEach>
					</select>
				</td>
				<td valign="top">
					探伤人员8&nbsp;&nbsp;：
					<select id="w8" name="_w8">
						<option value="">请选择</option>
						<c:forEach items="${tsUsers}" var="user">
							<option value="${user.xm }" <c:if test="${part.w8 == user.xm }">selected="selected"</c:if>>${user.xm }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td valign="top">
					探伤人员9&nbsp;&nbsp;：
					<select id="w9" name="_w9">
						<option value="">请选择</option>
						<c:forEach items="${tsUsers}" var="user">
							<option value="${user.xm }" <c:if test="${part.w9 == user.xm }">selected="selected"</c:if>>${user.xm }</option>
						</c:forEach>
					</select>
				</td>
				<td valign="top">
					探伤人员10：
					<select id="w10" name="_w10">
						<option value="">请选择</option>
						<c:forEach items="${tsUsers}" var="user">
							<option value="${user.xm }" <c:if test="${part.w10 == user.xm }">selected="selected"</c:if>>${user.xm }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td valign="top">
					探伤人员11：
					<select id="w11" name="_w11">
						<option value="">请选择</option>
						<c:forEach items="${tsUsers}" var="user">
							<option value="${user.xm }" <c:if test="${part.w11 == user.xm }">selected="selected"</c:if>>${user.xm }</option>
						</c:forEach>
					</select>
				</td>
				<td valign="top">
					探伤人员12：
					<select id="w12" name="_w12">
						<option value="">请选择</option>
						<c:forEach items="${tsUsers}" var="user">
							<option value="${user.xm }" <c:if test="${part.w12 == user.xm }">selected="selected"</c:if>>${user.xm }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td valign="top">
					技术人员1&nbsp;&nbsp;：
					<select id="t1" name="_t1">
						<option value="">请选择</option>
						<c:forEach items="${tsUsers}" var="user">
							<option value="${user.xm }" <c:if test="${part.t1 == user.xm }">selected="selected"</c:if>>${user.xm }</option>
						</c:forEach>
					</select>
				</td>
				<td valign="top">
					探伤人员2&nbsp;&nbsp;：
					<select id="t2" name="_t2">
						<option value="">请选择</option>
						<c:forEach items="${tsUsers}" var="user">
							<option value="${user.xm }" <c:if test="${part.t2 == user.xm }">selected="selected"</c:if>>${user.xm }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td valign="top">
					质检人员1&nbsp;&nbsp;：
					<select id="q1" name="_q1">
						<option value="">请选择</option>
						<c:forEach items="${tsUsers}" var="user">
							<option value="${user.xm }" <c:if test="${part.q1 == user.xm }">selected="selected"</c:if>>${user.xm }</option>
						</c:forEach>
					</select>
				</td>
				<td valign="top">
					质检人员2&nbsp;&nbsp;：
					<select id="q2" name="_q2">
						<option value="">请选择</option>
						<c:forEach items="${tsUsers}" var="user">
							<option value="${user.xm }" <c:if test="${part.q2 == user.xm }">selected="selected"</c:if>>${user.xm }</option>
						</c:forEach>
					</select>
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
			var name = $("#name").val();
			var teamId = $("#teamId").val();
			var xc1 = $("#xc1").val();
			var xc2 = $("#xc2").val();
			var w1 = $("#w1").val();
			var w2 = $("#w2").val();
			var w3 = $("#w3").val();
			var w4 = $("#w4").val();
			var w5 = $("#w5").val();
			var w6 = $("#w6").val();
			var w7 = $("#w7").val();
			var w8 = $("#w8").val();
			var w9 = $("#w9").val();
			var w10 = $("#w10").val();
			var w11 = $("#w11").val();
			var w12 = $("#w12").val();
			var t1 = $("#t1").val();
			var t2 = $("#t2").val();
			var q1 = $("#q1").val();
			var q2 = $("#q2").val();
			if(isNotEmpty(teamId) && isNotEmpty(name)){
				$.post("partManageAction!saveOrUpdateParts.do",{"id":id, "teamId":teamId, "name":name, "xc1":xc1, "xc2":xc2, 
					"w1":w1, "w2":w2, "w3":w3, "w4":w4, "w5":w5, "w6":w6, "w7":w7, "w8":w8, "w9":w9, "w10":w10, "w11":w11, "w12":w12,
					"t1":t1, "t2":t2, "q1":q1, "q2":q2},
					function(data){
						if(data == "success"){
							top.Dialog.alert("编辑配件成功！");
							top.window.frmright.location.href="partManageAction!findPartsByCondition.do";
						}else{
							top.Dialog.alert("编辑配件失败！");
						}
				})
			}else{
				top.Dialog.alert("请输入完整配件信息！");
			}
			
		})
		
		function isNotEmpty(fileds){
			return (fileds == null || fileds == "" || fileds == undefined) ? false: true;
		}
	})
</script>	
</body>
</html>