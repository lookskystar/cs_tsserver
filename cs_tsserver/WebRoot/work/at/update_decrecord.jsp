<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/common.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
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
	<!--截取文字start-->
	<script type="text/javascript" src="js/text/text-overflow.js"></script>
	<!--截取文字end-->
	<!--修正IE6支持透明PNG图start-->
    <script type="text/javascript" src="js/method/pngFix/supersleight.js"></script>
    <!--修正IE6支持透明PNG图end-->
	<script type="text/javascript" src="js/nav/ddaccordion.js"></script>
	<script>
		function checkform(){
			if($("#w1").val()==''){
			    alert("主探作业者不能为空！");
			    return false;
		    }
			if($("#w2").val()==''){
			    alert("复探作业者不能为空！");
			    return false;
		    }
		}

		//关闭此页面
		function toclose(){
			top.Dialog.close();
		}
	</script>
  </head>
<body>
  	<form action="tsAssignAaction!tsassign.do" method="post" target="frmright" onsubmit="return checkform()">   
  	    <input type="hidden" value="${decatrec.id }" name="id"/>
		<table class="tableStyle" transMode="true">
			<tr>
				<td>机车类型: </td>
				<td>
					
					<input  type="text" name="decatrec.jcType"  value="${decatrecord.jcType }"></input>
				</td>
				<td>机车车号: </td>
				<td>
					<input  type="text" name="decatrec.jcNumber"  value="${decatrecord.jcNumber }" style="width:70px;"></input>
				</td>
			</tr>
	 		<tr>
				<td>部件名称: </td>
				<td>
					<input  type="text" name="decatrec.unit" value="${decatrecord.unit }"></input>
				</td>
				
			</tr>
			<tr>	
				<td>主探作业者: </td>
				<td>
					<select id="w1"  name="decatrec.w1" style="width:120px;">
					     <option value=""></option>
					     <c:forEach items="${userslist}" var="entry">
    	                     <option value="${entry.xm}" >${entry.xm}</option>
    	                 </c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>复探作业者: </td>
				<td>
					<select id="w2"  name="decatrec.w2" style="width:120px;">
					     <option value=""></option>
					     <c:forEach items="${userslist}" var="entry">
    	                     <option value="${entry.xm}" >${entry.xm}</option>
    	                 </c:forEach>
					</select>
				</td>
			</tr>
			<tr><td></td></tr>
			<tr>
				<td colspan="4">
					<input type="submit" value=" 确定"/>&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="button" onclick="toclose();" value=" 放弃"/>
				</td>
			</tr>
		</table>
  	</form>  
</body>
</html>