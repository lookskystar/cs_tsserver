<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/common.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>"/>
    
	<!--框架必需start-->
	<script type="text/javascript" src="js/jquery-1.4.js"></script>
	<script type="text/javascript" src="js/framework.js"></script>
	<link href="css/import_basic.css" rel="stylesheet" type="text/css"/>
	<link  rel="stylesheet" type="text/css" id="skin" prePath="<%=basePath%>"/>
	<!--框架必需end-->
	<script type="text/javascript" src="js/tree/dtree/dtree.js"></script>
	<link href="js/tree/dtree/dtree.css" rel="stylesheet" type="text/css"/>
	
	<!--引入组件start-->
	<script type="text/javascript" src="js/attention/zDialog/zDrag.js"></script>
	<script type="text/javascript" src="js/attention/zDialog/zDialog.js"></script>
	<!--引入弹窗组件end-->
	<script type="text/javascript" src="js/nav/ddaccordion.js"></script>
	<script type="text/javascript" src="js/text/text-overflow.js"></script>
	<script type="text/javascript">
    	function select(id){
    		$("#"+id).attr("checked","checked");
    	}
    	function submit(){
    		$("#btnSubmit").hide();
    		var type = "${type}";
    		var score = 0;
    		var id = "";
    		var chk = null;
    		var std = null;
    		var result = null;
    		<c:forEach items="${questions}" var="ques">
    			id = '${ques.id}';
    			std = '${ques.rightAnswer}';
    			chk = $("input[name='"+id+"']:checked").val();
    			if(chk==undefined){
    				result = "<font color='red'>没有选择!</font>";
    			}else if(chk==std){
    				result = "<font color='green'>正确</font>";
    				score = score + 10;
    			}else{
    				result = "<font color='red'>选择错误:您选择了 "+ chk +"   正确答案为  " + std +" </font>";
    			}
    			$("#result_"+id).html(result);
    		</c:forEach>
    		var temp = "考试结束：您考试得分为  <font style='color: red;font-weight: bold;'>"+score+"</font>";
    		if(type==0){
    			$("#result").html(temp);	
    			top.Dialog.alert(temp);
    		}else{
    			if(score<80){
    				temp += " 考试低于80分,不能开工!";
    				$("#result").html(temp);	
    				top.Dialog.alert(temp);	
    			}else{
    				temp += " 考试高于80分,可以开工!";
    				$("#result").html(temp);	
    				top.Dialog.alert(temp,function(){
    					$.post("examAction!overExam.do",{'score':score},null);
    				});	
    			}
    		}
    	}
	</script>
  </head>
  
 <body>
   	<div id="scrollContent">
		<table class="tableStyle" id="radioTable" useColor="false">
			<tr>
				<th width="30px">序号</th><th>题目</th>
			</tr>
			<tr>
				<c:forEach items="${questions}" var="ques" varStatus="idx">
					<tr style="font-weight: bold;"><td align="center">${idx.index+1}</td><td>${ques.text}</td></tr>
					<c:if test="${!empty ques.answerA and fn:trim(ques.answerA)!=''}">
						<tr onclick="select('${ques.id}_1');">
							<td><input type="radio" name="${ques.id}" id="${ques.id}_1" value="1"/></td><td>${ques.answerA}</td>
						</tr>
					</c:if>
					<c:if test="${!empty ques.answerB and fn:trim(ques.answerB)!=''}">
						<tr onclick="select('${ques.id}_2');">
							<td><input type="radio" name="${ques.id}" value="2" id="${ques.id}_2"/></td><td>${ques.answerB}</td>
						</tr>
					</c:if>
					<c:if test="${!empty ques.answerC and fn:trim(ques.answerC)!=''}">
						<tr onclick="select('${ques.id}_3');">
							<td><input type="radio" name="${ques.id}" value="3" id="${ques.id}_3"/></td><td>${ques.answerC}</td>
						</tr>
					</c:if>
					<c:if test="${!empty ques.answerD and fn:trim(ques.answerD)!=''}">
						<tr onclick="select('${ques.id}_4');">
							<td><input type="radio" name="${ques.id}" value="4" id="${ques.id}_4"/></td><td>${ques.answerD}</td>
						</tr>
					</c:if>
					<tr>
						<td colspan="2" id="result_${ques.id}" style="font-weight: bold;"></td>
					</tr>
				</c:forEach>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button onclick="javascript:window.location.href='examAction!listExam.do?type=${type}'"><span class="icon_mark">重新作答</span></button>&nbsp;&nbsp;
					<button id="btnSubmit" onclick="submit();"><span class="icon_reply">答卷结束</span></button>
				</td>
			</tr>
			<tr>
				<td colspan="2" id="result"></td>
			</tr>
		</table>
	</div>
</body>
</html>