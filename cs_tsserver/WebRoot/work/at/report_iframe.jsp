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
	<script type="text/javascript">
		$(function(){
			parent.document.getElementById("btime").value = '${btime}';
			parent.document.getElementById("etime").value = '${etime}';
			
			var key1,key2,value;
			<c:forEach items="${map}" var="item">
				key1 = "${item.key}";
				<c:forEach items="${item.value}" var="tmp">
					key2 = "${tmp.key}";
					value = "<a href='javascript:void(0);' style='color:blue;font-weight:bold;' onclick='openDetail(\""+key1+"\",\""+key2+"\")'>${tmp.value}</a>";
					$("#"+key1+"_"+key2).html(value);
				</c:forEach>
			</c:forEach>
		});
	
		function printit(){
			if (window.print) {
		        window.print();
		    }
		    else {
		        var WebBrowser = '<OBJECT ID="WebBrowser1" WIDTH=0 HEIGHT=0 CLASSID="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2"></OBJECT>';
		        document.body.insertAdjacentHTML('beforeEnd', WebBrowser);
		        WebBrowser1.ExecWB(6, 2);
		    }
		}
		
		function openDetail(pjname,jctype){
			top.Dialog.open({URL:encodeURI("<%=basePath%>decRecordAction!listBadPJRecord.do?btime=${btime}&etime=${etime}&pjname="+pjname+"&jctype="+jctype),Width:1000,Height:"100",Title:"裂损配件"});
		}
	</script>
  </head>
<body>
    <!--startprint-->
	<table class="tableStyle">
		<tr>
			<td colspan="${fn:length(jcTypes)+1}">
				<div align="center" style="font-size: 16px;margin-top: 5px;font-weight: bold;">机车零、部件探伤裂损统计表</div>
				<div align="right" style="margin-right: 30px;font-weight: bold;">日期：${btime}&nbsp;至&nbsp;${etime}</div>
			</td>
		</tr>
		<tr>
			<th>&nbsp;</th>
			<c:forEach items="${jcTypes}" var="jctype">
				<th>${jctype.jcTypeEvalue}</th>
			</c:forEach>
		</tr>
		<c:forEach items="${map}" var="item">
			<tr align="center">
				<td>${item.key}</td>
				<c:forEach items="${jcTypes}" var="jctype">
					<td id="${item.key}_${jctype.jcTypeEvalue}">0</td>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>	
	<!--endprint-->
    <link href="<%=basePath %>My97DatePicker/skin/WdatePicker.css" rel="stylesheet" type="text/css" />
  	<script type="text/javascript" src="<%=basePath %>My97DatePicker/WdatePicker.js"></script>
</body>
</html>