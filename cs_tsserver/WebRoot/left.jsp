<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/common.jsp" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!--框架必需start-->
<!--框架必需start-->
<script type="text/javascript" src="js/jquery-1.4.js"></script>
<script type="text/javascript" src="js/framework.js"></script>
<link href="css/import_basic.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" id="skin"
	prePath="<%=basePath%>" />
<!--框架必需end-->

<script type="text/javascript" src="js/nav/ddaccordion.js"></script>
<script type="text/javascript" src="js/text/text-overflow.js"></script>
<style>
a {
	behavior:url(../js/method/focus.htc)
}
.categoryitems span{
	width:160px;
}
</style>
</head>

<body leftFrame="true">
<div id="scrollContent">
  <div class="arrowlistmenu">
  
	<div class="menuheader expandable"><span class="normal_icon1"></span>探伤任务</div>
	<ul class="categoryitems">
	<li><a href="tsAssignAction!assignInput.do" target="frmright"><span class="text_slice">探伤派工</span></a></li>
	<li><a href="tsAssignAction!jjassignInput.do" target="frmright"><span class="text_slice">紧急派工</span></a></li>
	</ul>
	
	<div class="menuheader expandable"><span class="normal_icon2"></span>探伤题库</div>
	<ul class="categoryitems">
	<li><a href="examAction!listExam.do?type=1" target="frmright"><span class="text_slice">磁粉题库</span></a></li>
	<li><a href="examAction!listExam.do?type=2" target="frmright"><span class="text_slice">超声波题库</span></a></li>
	<li><a href="examAction!listExam.do?type=0" target="frmright"><span class="text_slice">日常学习</span></a></li>
	</ul>
	
	<div class="menuheader expandable"><span class="normal_icon3"></span>信息查询</div>
	<ul class="categoryitems">
	<li><a href="assignQueryAction!assignQueryInput.do" target="frmright"><span class="text_slice">派工查询</span></a></li>
	</ul>
	
	<div class="menuheader expandable"><span class="normal_icon4"></span>探伤报表</div>
	<ul class="categoryitems">
	<li><a href="work/at/report.jsp" target="frmright"><span class="text_slice">报表</span></a></li>
	</ul>
	
	<div class="menuheader expandable"><span class="normal_icon5"></span>探伤记录</div>
	<ul class="categoryitems">
	<li><a href="decRecordAction!listUnfinishDecRecord.do" target="frmright"><span class="text_slice">记录填写</span></a></li>
	<li><a href="decRecordAction!listFinishDecRecord.do" target="frmright"><span class="text_slice">记录查询</span></a></li>
	</ul>
	
	<c:if test="${sessionScope.session_user.posId==99 || sessionScope.session_user.posId==102}">
		<div class="menuheader expandable"><span class="normal_icon6"></span>系统管理</div>
		<ul class="categoryitems">
		<li><a href="partManageAction!findPartsByCondition.do" target="frmright"><span class="text_slice">配件管理</span></a></li>
		<li><a href="questionManageAction!findDetecQuestionByCondition.do" target="frmright"><span class="text_slice">题库管理</span></a></li>
		<li><a href="userManageAction!findUsersByCondition.do" target="frmright"><span class="text_slice">人员管理</span></a></li>
		</ul>
	</c:if>
  </div>
</div>
</body>
</html>