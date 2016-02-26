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
				<td>问题类型：</td>
				<td> 
					<select id="type" name="_type">
					    <option value=''>--请选择--</option>
					   	<option value="1" <c:if test="${qid == 1}">selected="selected"</c:if>>磁粉理论</option>
						<option value="2" <c:if test="${qid == 2}">selected="selected"</c:if>>超声波理论</option>
						<option value="3" <c:if test="${qid == 3}">selected="selected"</c:if>>磁粉</option>
						<option value="4" <c:if test="${qid == 4}">selected="selected"</c:if>>超声波工艺</option>
					 </select>
				</td>
			</tr>
			<tr>
				<td>问题：</td>
				<td valign="top">
					<textarea rows="" cols="" id="text" name="_text" class="validate[required]" ></textarea>
				</td>
			</tr>
			<tr>
				<td>正确答案：</td>
				<td valign="top">
					<input type="radio" value="1" name="_rightAnswer"/>1
					<input type="radio" value="2" name="_rightAnswer"/>2
					<input type="radio" value="3" name="_rightAnswer"/>3
					<input type="radio" value="4" name="_rightAnswer"/>4
				</td>
			</tr>
			<tr>
				<td>答案1：</td>
				<td valign="top">
					<input id="answerA" name="_answerA" class="validate[required]"/>
				</td>
			</tr>
			<tr>
				<td>答案2：</td>
				<td valign="top">
					<input id="answerB" name="_answerB" class="validate[required]"/>
				</td>
			</tr>
			<tr>
				<td>答案3：</td>
				<td valign="top">
					<input id="answerC" name="_answerC" class="validate[required]"/>
				</td>
			</tr>
			<tr>
				<td>答案4：</td>
				<td valign="top">
					<input id="answerD" name="_answerD" class="validate[required]"/>
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
			//问题类型
			var type = $("#type").val();
			//问题
			var text = $("#text").val();
			//答案
			var rightAnswer =  $("[name='_rightAnswer']").val();
			//答案A
			var answerA = $("#answerA").val();
			//答案B
			var answerB = $("#answerB").val();
			//答案C
			var answerC = $("#answerC").val();
			//答案D
			var answerD = $("#answerD").val();
			if(text != "" && text != null && text != undefined){
				//ACTION
				$.post("questionManageAction!saveOrUpdateDetecQuestion.do",{"type":type, "text":text, "rightAnswer":rightAnswer, "answerA":answerB, "answerB":answerB, "answerC":answerC, "answerD":answerD},
					function(data){
						if(data == "success"){
							top.Dialog.alert("新建问题成功！");
							top.window.frmright.location.href="questionManageAction!findDetecQuestionByCondition.do";
						}else{
							top.Dialog.alert("新建问题失败！");
						}
				})
			}else{
				top.Dialog.alert("问题名不能为空！");
			}
		})
	})
</script>	
</body>
</html>