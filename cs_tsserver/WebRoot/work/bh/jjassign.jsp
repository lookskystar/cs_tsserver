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
                  <button onclick="jjquery();";><span class="icon_find">查询</span></button>
              </td>
          </tr>
      
    </table>

	<table class="tableStyle">
	 
		<tr>
		    <th width="2%" align="center">序号</th>
			<th width="8%" align="center"><span>机车类型</span></th>
			<th width="6%" align="center"><span>机车编号</span></th>
			<th width="6%" align="center"><span>修程</span></th>
			<th width="5%" align="center"><span>修次</span></th>
			<th width="16%" align="center"><span>报活时间</span></th>
			<th width="10%" align="center"><span>报活小组</span></th>
			<th width="8%" align="center"><span>报活人姓名</span></th>
			<th width="10%" align="center"><span>部件名称</span></th>
			<th width="5%" align="center"><span>数量</span></th>
			<th width="13%" align="center">操作</th>
		</tr>

	<c:if test="${!empty declist}">
		<c:forEach items="${declist}" var="decAtRecord" varStatus="status">
		<tr>
		    <td align="center">${ status.index + 1}</td>
			<td align="center"><span>${decAtRecord.jcType }</span></td>
			<td align="center"><span>${decAtRecord.jcNumber }</span></td>
			<td align="center"><span>${decAtRecord.atxc }</span></td>
			<td align="center"><span>${decAtRecord.atxci }</span></td>
			<td align="center"><span>${decAtRecord.atTime }</span></td>
			<td align="center">
			<c:forEach items="${teamlist}" var="entry">
    	         <c:if test="${decAtRecord.team==entry.teamId}">${entry.name}</c:if>
    	    </c:forEach>
			</td>
			<td align="center"><span>${decAtRecord.name }</span></td>
			<td align="center"><span>${decAtRecord.unit }</span></td>
			<td align="center"><span>${decAtRecord.unitNumber }</span></td>
			<td align="center">
				<a href="javascript:void(0);" onclick="jjassign(${decAtRecord.id });" style="color:blue;">派工</a>
			</td>
		</tr>
		</c:forEach>
	</c:if>
	<c:if test="${empty declist}">
		<tr> 
		    <td class="ver01" align="center" colspan="11">没有相应的数据记录!</td>
		</tr>
	</c:if>
	
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


//派工
function jjassign(id){
	top.Dialog.open({URL:"<%=basePath%>tsAssignAction!urgentInput.do?id="+id,Width:500,Height:300,Title:"确定派工"});
}

function jjquery() {
	var bTime = $("#bTime").val();
	var eTime = $("#eTime").val();	
	window.location.href = "<%=basePath%>tsAssignAction!jjquery.do?bTime=" + bTime + "&eTime=" + eTime;
}



</script>
</html>