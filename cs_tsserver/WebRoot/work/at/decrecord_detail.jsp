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
		//关闭此页面
		function toclose(){
			top.Dialog.close();
		}
		//打印
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
	</script>
  </head>
<body>
	<table class="tableStyle">
		<tr>
			<td width="15%">机车类型</td>
			<td width="35%">${decRec.jcType }</td>
			<td width="15%">机车车号</td>
			<td width="35%">${decRec.jcNumber}</td>
		</tr>
		<tr>
			<td>修&nbsp;&nbsp;程</td>
			<td>${decRec.xc }</td>
			<td>修&nbsp;&nbsp;次</td>
			<td>${decRec.xci }</td>
		</tr>
		<tr>
			<td>配件名称</td>
			<td>${decRec.unitName }</td>
			<td>配件数量</td>
			<td>${decRec.unitNumber }</td>
		</tr>
		<tr>
			<td>配件编号</td>
			<td colspan="3">${decRec.unitNotext }</td>
		</tr>
		<tr>
			<td>裂损配件</td>
			<td colspan="3">
				<table class="tableStyle">
					<tr>
						<th width="30px">序列</th>
						<th width="30%">配件名称</th>
						<th width="15%">配件数量</th>
						<th width="30%">配件编号</th>
						<th width="25%">配件图片</th>
					</tr>
					<c:forEach var="rec" items="${badPJRecs}" varStatus="idx">
						<tr align="center">
							<td>${idx.index+1 }</td>
							<td>${rec.pjName}</td>
							<td>${rec.pjAmount}</td>
							<td>${rec.pjNums}</td>
							<td>
								<c:choose>
									<c:when test="${!empty rec.pjImageUrls}">
										<a href="<%=basePath%>${rec.pjBigImageUrl}" target="_blank" title="点击查看大图">
											<img src="<%=basePath%>${rec.pjImageUrls}" alt="点击查看大图" width="80px" height="50px"/>
										</a>
									
									</c:when>
									<c:otherwise>没有图片</c:otherwise>
								</c:choose>
							</td>
						</tr>
					</c:forEach>
					<c:if test="${empty badPJRecs}">
						<tr align="center">
							<td colspan="5">没有裂损配件记录!</td>
						</tr>
					</c:if>
				</table>
			</td>
		</tr>
		<tr>
			<td>探伤结果</td>
			<td>${decRec.atResult }</td>
			<td>处理结果</td>
			<td>${decRec.operResult }</td>
		</tr>
		<tr>
			<td>探伤作业者</td>
			<td colspan="3">${decRec.mainName },${decRec.secondName }</td>
		</tr>
		<tr>
			<td>探伤方法</td>
			<td>${decRec.tway }</td>
			<td>探伤时间</td>
			<td>${decRec.atTime }</td>
		</tr>
		<tr>
			<td>技术员</td>
			<td>${decRec.t1 }</td>
			<td>质检员</td>
			<td>${decRec.q1 }</td>
		</tr>
		<tr>
			<td colspan="4" align="center">
				<button onclick="toclose();"><span class="icon_remove">关闭</span></button>&nbsp;&nbsp;&nbsp;&nbsp;
				<button onclick="printit();"><span class="icon_print">打印</span></button>
			</td>
		</tr>
	</table>
</body>
</html>