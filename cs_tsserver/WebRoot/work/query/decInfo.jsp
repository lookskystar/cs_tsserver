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

		//关闭此页面
		function toclose(){
			top.Dialog.close();
		}
	</script>
  </head>
<body>
  	<form action="assignQueryAction!decInfoInput.do" method="post" target="frmright" >   
  	    <input type="hidden" value="${decatrecord.id }" name="id"/>
		<table class="tableStyle" formMode="true">
			<tr>
				<td width="20%">机车类型: </td>
				<td width="30%">
					
					${decatrecord.jcType }
				</td>
				<td width="20%">机车车号: </td>
				<td width="30%">
					${decatrecord.jcNumber }
				</td>
			</tr>
			<tr>	
				<td>主探作业者: </td>
				<td>
					${decatrecord.w1 }
				</td>
				<td>复探作业者: </td>
				<td>
					${decatrecord.w2 }
				</td>
			</tr>
	 		<tr>
				<td>部件名称: </td>
				<td colspan="3">
					${decatrecord.unit }
				</td>
			</tr>
	 		<tr>	
			
				<td>部件编号: </td>
				<td colspan="3"  style="word-wrap: break-word;word-break: break-all;">
					${decatrecord.unitNumberText }
				</td>
				
			</tr>
			<tr>
				<td>报活时间: </td>
				<td colspan="3">
					${decatrecord.atTime }
				</td>
			</tr>
			<tr>
				<td colspan="4" align="center">
					<input type="button" onclick="toclose();" value=" 关闭"/>
				</td>
			</tr>
		</table>
  	</form>  
</body>
</html>