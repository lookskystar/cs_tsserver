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
<form action="decRecordAction!listUnfinishDecRecord.do" method="post">
<center>
查询条件:
    报活开始时间:<input name="btime" class="Wdate" type="text" id="d15" onFocus="WdatePicker({isShowClear:false,readOnly:true})" value="${btime}"/>
   报活结束时间:<input name="etime" class="Wdate" type="text" id="d15" onFocus="WdatePicker({isShowClear:false,readOnly:true})" value="${etime}"/>
   <input type="submit" value="查询"/></center>
	<table class="tableStyle"  headFixMode="true" useMultColor="true">
		<tr>
			<th width="8%" align="center"><span>机车类型</span></th>
			<th width="6%" align="center"><span>机车编号</span></th>
			<th width="6%" align="center"><span>修程</span></th>
			<th width="5%" align="center"><span>修次</span></th>
			<th width="16%" align="center"><span>报活时间</span></th>
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
				<a href="javascript:void(0);" onclick="fillRecord(${decRec.id });" style="color:blue;">记录填写</a>
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
<%--
   		<div style="height:35px;">
           <div class="float_left padding5">共有${pm.count}条信息</div>
        </div>
		<!-- 处理分页 -->
		<div style="height: 35px;">
			<div class="float_right padding5 paging">
				<div class="float_left padding_top4">
					<pg:pager maxPageItems="${pageSize }"
						url="tsAssignAaction!assignInput.do" items="${pm.count}"
						export="page1=pageNumber">
						<pg:first>
							<span><a href="${pageUrl  }" id="first">首页</a>
							</span>
						</pg:first>
						<pg:prev>
							<span><a href="${pageUrl  }">上一页</a>
							</span>
						</pg:prev>
						<pg:pages>
							<c:choose>
								<c:when test="${page1==pageNumber}">
									<span class="paging_current"><a href="javascript:;">${pageNumber
											}</a>
									</span>
								</c:when>
								<c:otherwise>
									<span><a href="${pageUrl  }">${pageNumber }</a>
									</span>
								</c:otherwise>
							</c:choose>
						</pg:pages>
						<pg:next>
							<span><a href="${pageUrl }">下一页</a>
							</span>
						</pg:next>
						<pg:last>
							<span><a href="${pageUrl }">末页</a>
							</span>
						</pg:last>
					</pg:pager>
					<div class="clear"></div>
				</div>
				<div class="clear"></div>
			</div>
		</div>
		<!-- 处理分页end --> --%>
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
function fillRecord(decRecId){
	top.Dialog.open({URL:"<%=basePath%>decRecordAction!fillDecRecordInput.do?decRecId="+decRecId,Width:650,Height:'100',Title:"记名探伤记录"});
}

</script>
</html>