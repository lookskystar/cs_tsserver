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
  </head>
<body>
    <!--startprint-->
	<table class="tableStyle">
		<tr align="center">
			<th width="30px">序号</th>
			<th width="9%">机车</th>
			<th width="13%">时间</th>
			<th width="15%">配件名称</th>
			<th width="10%">数量</th>
			<th width="23%">编码</th>
			<th width="15%">作业人</th>
			<th width="15%">图片</th>
		</tr>
		<c:forEach items="${badPJRecs}" var="rec" varStatus="idx">
			<tr align="center">
				<td>${idx.index+1}</td>
				<td>${rec.decRecId.jcType}-${rec.decRecId.jcNumber}</td>
				<td>${rec.decRecId.atTime}</td>
				<td>${rec.pjName}</td>
				<td>${rec.pjAmount}</td>
				<td>${rec.pjNums}</td>
				<td>${rec.decRecId.mainName},${rec.decRecId.secondName}</td>
				<td>
					<c:choose>
						<c:when test="${!empty rec.pjImageUrls}">
							<a href="<%=basePath%>${rec.pjBigImageUrl}" target="_blank">
								<img src="${rec.pjImageUrls}" width="80px" height="50px"/>
							</a>
						</c:when>
						<c:otherwise>没有图片</c:otherwise>
					</c:choose>
				</td>
			</tr>
		</c:forEach>
	</table>	
	<!--endprint-->
</body>
</html>