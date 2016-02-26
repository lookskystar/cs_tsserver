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
    <title>用户管理</title>
	<!--框架必需start-->
	<script type="text/javascript" src="js/jquery-1.4.js"></script>
	<script type="text/javascript" src="js/framework.js"></script>
	<link href="css/import_basic.css" rel="stylesheet" type="text/css"/>
	<link  rel="stylesheet" type="text/css" id="skin" prePath="<%=basePath%>"/>
	<!--框架必需end-->
  </head>
 <body>
 	<form action="userManageAction!findUsersByCondition.do" method="post" id="subfrom">
	 	<div>
	 		<table>
	 			<tr>
	 				<td>班组：
		 				<select id="teamId" name="teamId" >
							<option value="">请选择</option>
							<c:forEach items="${teamList}" var="team">
								<option value="${team.id }" <c:if test="${teamId == team.id }">selected="selected"</c:if>>${team.name }</option>
							</c:forEach>
						</select>
					</td>
	 				<td>姓&nbsp;&nbsp;名：<input type="text" watermark="输入姓名"  name="names" value="${names }"/></td>
	 				<td>工&nbsp;&nbsp;号：<input type="text" watermark="输入工号" name="gonghao" value="${gonghao }"/></td>
					<td><input type="submit" value="查询" /></td>
	 			</tr>
				<tr>
					<td colspan="2">
						<input type="button" value="新增" onclick="toAdd();"/>&nbsp;&nbsp;
						<input type="button" value="删除" onclick='enSureDelete();'/>&nbsp;&nbsp;
					</td>
				</tr>
			</table>
		</div>
	   	<div id="scrollContent">
			 <table class="tableStyle"  useMultColor="true"  useCheckBox="true" id="userTable">
			 	<tr>
			 		<th width="30px" align="center"></th>
			      	<th width="10%" align="center"><span>班组</span></th>
			      	<th width="10%" align="center"><span>姓名</span></th>
			      	<th width="15%" align="center"><span>工号</span></th>
			      	<th width="30%" align="center"><span>密码</span></th>
			      	<th width="10%" align="center"><span>职位</span></th>
			      	<th width="10%" align="center"><span>卡号</span></th>
			      	<th width="15%" align="center">操作</th>
			    </tr>
				<c:if test="${!empty dataPm}">
				   	<c:forEach items="${dataPm.datas}" var="user" >
				   		<tr>
				   			<td width="30px" align="center"><input id="userid" name="user" type="checkbox" value="${user.userId}"/></td>
							<td width="10%" align="center">
								<c:forEach items="${teamList}" var="team">
									<c:if test="${team.id == user.teamId}">
										${team.name }
									</c:if>
								</c:forEach>
							</td>
							<td width="10%" align="center">
								<span>
									${user.xm}
								</span>
							</td>
							<td width="15%" align="center">
								<span>
									${user.gongHao}
								</span>
							</td>
							<td width="30%" align="center">
								<span>
									${user.pw}
								</span>
							</td>
							<td width="10%" align="center">
								<c:forEach items="${positionList}" var="posi">
									<c:if test="${posi.posId == user.posId}">
										${posi.posValue }
									</c:if>
								</c:forEach>
							</td>
							<td width="10%" align="center">
								<span>
									${user.jdkId}
								</span>
							</td>
							<td width="15%" align="center">
								<a href="javascript:;" onclick="edit('${user.userId}');" ><font color="blue">编辑</font></a>
								<a href="javascript:;" onclick="deletes('${user.userId}');"><font color="blue">删除</font></a>
								<a href="javascript:;" onclick="recovery('${user.userId}');"><font color="blue">恢复默认密码</font></a>
							</td>
						</tr>
				   	</c:forEach>
				 </c:if>
				 <c:if test="${empty dataPm.datas}">
				 	<tr> 
				 		<td class="ver01" align="center" colspan="10">没有相应的数据记录!</td>
				 	</tr>
				 </c:if>
			 </table>
		</div>
		<!-- 处理分页 -->
		<div class="float_left padding5">  共有信息${dataPm.count}条。</div>
		<div class="float_right padding5 paging">
			<div class="float_left padding_top4">
				<pg:pager maxPageItems="${pageSize }" url="userManageAction!findUsersByCondition.do" items="${dataPm.count }" export="page1=pageNumber">
					<pg:param name="teamId" value="${teamId}"/>
					<pg:param name="gonghao" value="${gonghao}"/>
					<pg:param name="names" value="${names}"/>
			  		<pg:first>
						 <span><a href="${pageUrl }" id="first">首页</a></span>
			 		</pg:first>
			 		<pg:prev>
						  <span><a href="${pageUrl }">上一页</a></span>
			  		</pg:prev>
		  	  		<pg:pages>
						<c:choose>
							<c:when test="${page1==pageNumber }">
								<span class="paging_current"><a href="javascript:;">${pageNumber }</a></span>
							</c:when>
							<c:otherwise>
								<span><a href="${pageUrl }">${pageNumber }</a></span>
							</c:otherwise>
						</c:choose>
			  		</pg:pages>
			  		<pg:next>
					    <span><a href="${pageUrl }">下一页</a></span>
			  		</pg:next>
			  		<pg:last>
					  	<span><a href="${pageUrl }">末页</a></span>
			 		</pg:last>
			 	</pg:pager>
				<div class="clear"></div>
			</div>
		</div>
	</form>
	
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
		//新建
		function toAdd(){
			var diag = new top.Dialog();
			diag.Title = "增加用户";
			diag.URL = "userManageAction!addUsersInput.do";
			diag.Width=400;
			diag.Height=300;
			diag.show();
		}
		
		//判断是否选中信息
		function enSureDelete(){
			//判断是否一个未选
			var flag; 
			//遍历所有的name为user的 checkbox 
			$("input[name='user']").each(function() {
				//判断是否选中 
				if ($(this).attr("checked")) { 
					//只要有一个被选择 设置为 true
					flag = true; 
				}
		    })
		    if (flag) {  
		    	top.Dialog.confirm("确认删除？",function(){
		    		toDelete();
		    	});
		    }else {
		    	top.Dialog.alert("请至少选择一条人员信息！");
		    }
		
		}
		
		//删除
		function toDelete() {
			//用于保存 选中的那一条数据的ID 
			var users = [];  
	    	$("input[name='user']").each(function() { 
	    		if ($(this).attr("checked")) { 
	    			//将选中的值 添加到 array中
	    			users.push($(this).val());
	    		}
	    	})
	    	$.ajax({
				type:"post",
				async:false,
				url:"userManageAction!deleteUsers.do",
				data:{"users":users.join(",")},
				success:function(result){
					if(result=="success"){
		    			top.Dialog.alert("人员信息删除成功！",function(){
				    			top.window.frmright.location.href="userManageAction!findUsersByCondition.do";
			    			});
		    		}else{
		    			top.Dialog.alert("人员信息删除失败！");
		    		}
				}
			});
		}
		
		//删除
		function deletes(id) {
			//用于保存 选中的那一条数据的ID 
			var users = [];  
	    	users.push(id);
	    	top.Dialog.confirm("确认删除吗？",function(){ 
		    	$.ajax({
					type:"post",
					async:false,
					url:"userManageAction!deleteUsers.do",
					data:{"users":users.join(",")},
					success:function(result){
						if(result=="success"){
			    			top.Dialog.alert("人员信息删除成功！",function(){
					    			top.window.frmright.location.href="userManageAction!findUsersByCondition.do";
				    			});
			    		}else{
			    			top.Dialog.alert("人员信息删除失败！");
			    		}
					}
				});
			});
		}
		
		//编辑
		function edit(id){
			var diag = new top.Dialog();
			diag.Title = "编辑人员信息";
			diag.URL = "userManageAction!editUsersInput.do?id="+id;
			diag.Width=400;
			diag.Height=300;
			diag.show();
		}
		
		//恢复密码
		function recovery(id){
			top.Dialog.confirm("确认恢复默认密码？",function(){ 
		    	$.ajax({
					type:"post",
					async:false,
					url:"userManageAction!recoveryPw.do",
					data:{"id":id},
					success:function(result){
						if(result=="success"){
			    			top.Dialog.alert("默认密码恢复成功！",function(){
					    			top.window.frmright.location.href="userManageAction!findUsersByCondition.do";
				    			});
			    		}else{
			    			top.Dialog.alert("默认密码恢复失败！");
			    		}
					}
				});
			});
		}
		
</script>
</body>
</html>