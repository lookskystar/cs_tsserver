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
	
	<!--引入组件start-->
	<script type="text/javascript" src="js/attention/zDialog/zDrag.js"></script>
	<script type="text/javascript" src="js/attention/zDialog/zDialog.js"></script>
	<!--引入弹窗组件end-->
	<script type="text/javascript" src="js/nav/ddaccordion.js"></script>
	<script type="text/javascript" src="js/text/text-overflow.js"></script>
	<!--修正IE6支持透明PNG图start-->
    <script type="text/javascript" src="js/method/pngFix/supersleight.js"></script>
    <!--修正IE6支持透明PNG图end-->

</head>
<body>

<div id="scrollContent">
<form action="decRecordAction!listFinishDecRecord.do" method="post">
<center>
查询条件:
    开始时间:<input name="btime" class="Wdate" type="text" id="d15" onFocus="WdatePicker({isShowClear:false,readOnly:true})" value="${btime}"/>
   结束时间:<input name="etime" class="Wdate" type="text" id="d15" onFocus="WdatePicker({isShowClear:false,readOnly:true})" value="${etime}"/>
   <input type="submit" value="查询"/></center>
	<table class="tableStyle"  headFixMode="true" useMultColor="true">
		<tr>
			<th width="8%" align="center"><span>机车类型</span></th>
			<th width="6%" align="center"><span>机车编号</span></th>
			<th width="6%" align="center"><span>修程</span></th>
			<th width="5%" align="center"><span>修次</span></th>
			<th width="16%" align="center"><span>探伤时间</span></th>
			<th width="10%" align="center"><span>主探作业者</span></th>
			<th width="8%" align="center"><span>复探作业者</span></th>
			<th width="10%" align="center"><span>部件名称</span></th>
			<th width="5%" align="center"><span>数量</span></th>
			<th width="13%" align="center">操作</th>
		</tr>

	<c:if test="${!empty decRecs}">
		<c:forEach items="${decRecs}" var="decRec">
		<tr>
			<td align="center"><span>${decRec.jcType}</span></td>
			<td align="center"><span>${decRec.jcNumber}</span></td>
			<td align="center"><span>${decRec.xc }</span></td>
			<td align="center"><span>${decRec.xci }</span></td>
			<td align="center"><span>${decRec.atTime }</span></td>
			<td align="center"><span>${decRec.mainName }</span></td>
			<td align="center"><span>${decRec.secondName }</span></td>
			<td align="center"><span>${decRec.unitName }</span></td>
			<td align="center"><span>${decRec.unitNumber }</span></td>
			<td align="center">
				<a href="javascript:void(0);" onclick="findRecord(${decRec.id });" style="color:blue;">记录查看</a>
			</td>
		</tr>
		</c:forEach>
	</c:if>
	<c:if test="${empty decRecs}">
		<tr> 
		    <td class="ver01" align="center" colspan="10">没有相应的数据记录!</td>
		</tr>
	</c:if>
	</form>
	</table>
<link href="<%=basePath %>My97DatePicker/skin/WdatePicker.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath %>My97DatePicker/WdatePicker.js"></script>
</body>
<script type="text/javascript">
$(function(){
	<c:if test="${!empty message}">
	    top.Dialog.close();
		top.Dialog.alert('${message}');
	</c:if>
});

//查看记录信息
function findRecord(decRecId){
	top.Dialog.open({URL:"<%=basePath%>decRecordAction!decrecordDetail.do?decRecId="+decRecId,Width:800,Height:'100',Title:"记名探伤记录"});
}

</script>
</html>