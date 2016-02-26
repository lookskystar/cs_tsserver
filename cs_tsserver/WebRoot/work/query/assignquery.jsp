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
    <table>
          <tr>
              <td>
                                                报活起止时间：
              </td>
              <td>
                   <input type="text"  id="bTime" class="Wdate" onclick="WdatePicker(({dateFmt:'yyyy-MM-dd'}))" value="${bTime}" style="width: 110px;"/>
              </td>
              <td>
                                                 至:
              </td>
              <td>
              <input type="text"  id="eTime" class="Wdate" onclick="WdatePicker(({dateFmt:'yyyy-MM-dd'}))" value="${eTime}" style="width: 110px;"/>
              </td>
              <td>
                  <button onclick="assignquery();";><span class="icon_find">查询</span></button>
              </td>
          </tr>
      
    </table>

	<table class="tableStyle">
	 
		<tr>
		    <th width="2%" align="center">序号</th>
			<th width="8%" align="center"><span>机车类型</span></th>
			<th width="6%" align="center"><span>机车编号</span></th>
			<th width="6%" align="center"><span>修程</span></th>
			<th width="6%" align="center"><span>修次</span></th>
			<th width="16%" align="center"><span>报活时间</span></th>
			<th width="10%" align="center"><span>主探作业者</span></th>
			<th width="10%" align="center"><span>复探作业者</span></th>
			<th width="10%" align="center"><span>部件名称</span></th>
			<th width="6%" align="center"><span>数量</span></th>
			<th width="10%" align="center">操作</th>
		</tr>

	<c:if test="${!empty decatreclist}">
		<c:forEach items="${decatreclist}" var="decAtRecord"  varStatus="status">
		<tr>
		    <td align="center">${ status.index + 1}</td>
			<td align="center"><span>${decAtRecord.jcType }</span></td>
			<td align="center"><span>${decAtRecord.jcNumber }</span></td>
			<td align="center"><span>${decAtRecord.atxc }</span></td>
			<td align="center"><span>${decAtRecord.atxci }</span></td>
			<td align="center"><span>${decAtRecord.atTime }</span></td>
			<td align="center"><span>${decAtRecord.w1 }</span></td>
			<td align="center"><span>${decAtRecord.w2 }</span></td>
			<td align="center"><span>${decAtRecord.unit }</span></td>
			<td align="center"><span>${decAtRecord.unitNumber }</span></td>
			<td align="center">
				<a href="javascript:void(0);" onclick="find(${decAtRecord.id });" style="color:blue;">查看</a>
			</td>
		</tr>
		</c:forEach>
	</c:if>
	<c:if test="${empty decatreclist}">
		<tr> 
		    <td class="ver01" align="center" colspan="10">没有相应的数据记录!</td>
		</tr>
	</c:if>
	
	</table>
   		
		
       <link href="<%=basePath %>My97DatePicker/skin/WdatePicker.css" rel="stylesheet" type="text/css" />
	   <script type="text/javascript" src="<%=basePath %>My97DatePicker/WdatePicker.js"></script>
</body>
<script type="text/javascript">

function assignquery() {
	var bTime = $("#bTime").val();
	var eTime = $("#eTime").val();	
	window.location.href = "<%=basePath%>assignQueryAction!assignquery.do?bTime=" + bTime + "&eTime=" + eTime;
}

//查看
function find(id){
	top.Dialog.open({URL:"<%=basePath%>assignQueryAction!decInfoInput.do?id="+id,Width:600,Height:300,Title:"派活查看"});
}

</script>
</html>