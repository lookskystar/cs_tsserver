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
		function query() {
			var btime = $("#btime").val();
			var etime = $("#etime").val();	
			window.frames['frmrightChild'].document.location.href="<%=basePath%>decRecordAction!report.do?btime=" + btime + "&etime=" + etime;
			//window.location.href = "<%=basePath%>decRecordAction!report.do?btime=" + btime + "&etime=" + etime;
		}
		function preprint(){
			document.getElementById("frmrightChild").contentWindow.printit();
		}
	</script>
  </head>
<body>
    <div id="scrollContent">
	    <table>
	       <tr>
	           <td>
	                                             起止时间：
	           </td>
	           <td>
	                <input type="text"  id="btime" class="Wdate" onclick="WdatePicker(({dateFmt:'yyyy-MM-dd'}))" value="${btime}" style="width: 110px;"/>
	           </td>
	           <td>至:</td>
	           <td>
	           	<input type="text"  id="etime" class="Wdate" onclick="WdatePicker(({dateFmt:'yyyy-MM-dd'}))" value="${etime}" style="width: 110px;"/>
	           </td>
	           <td>
	               <button onclick="query();";><span class="icon_find">查询</span></button>&nbsp;&nbsp;
	               <button onclick="preprint();";><span class="icon_print">打印</span></button>
	           </td>
	       </tr>
	    </table>
   	 	<IFRAME scrolling="no" width="100%" frameBorder=0 id=frmrightChild name=frmrightChild onload="iframeHeight('frmrightChild')" src="<%=basePath%>decRecordAction!report.do"  allowTransparency="true"></IFRAME>
	</div>
    <link href="<%=basePath %>My97DatePicker/skin/WdatePicker.css" rel="stylesheet" type="text/css" />
  	<script type="text/javascript" src="<%=basePath %>My97DatePicker/WdatePicker.js"></script>
</body>
</html>