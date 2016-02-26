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
    <title>题库管理</title>
	<!--框架必需start-->
	<script type="text/javascript" src="js/jquery-1.4.js"></script>
	<script type="text/javascript" src="js/framework.js"></script>
	<link href="css/import_basic.css" rel="stylesheet" type="text/css"/>
	<link  rel="stylesheet" type="text/css" id="skin" prePath="<%=basePath%>"/>
	<!--框架必需end-->
  </head>
 <body>
 	<form action="questionManageAction!findDetecQuestionByCondition.do" method="post" id="subfrom">
	 	<div>
	 		<table>
	 			<tr>
	 				<td>分类：
		 				<select id="qid" name="qid">
							<option value="">请选择</option>
							<option value="1" <c:if test="${qid == 1}">selected="selected"</c:if>>磁粉理论</option>
							<option value="2" <c:if test="${qid == 2}">selected="selected"</c:if>>超声波理论</option>
							<option value="3" <c:if test="${qid == 3}">selected="selected"</c:if>>磁粉</option>
							<option value="4" <c:if test="${qid == 4}">selected="selected"</c:if>>超声波工艺</option>
						</select>
					</td>
	 				<td>关&nbsp;&nbsp;键&nbsp;&nbsp;字：<input type="text" watermark="输入关键字"  name="keys" value="${keys }"/></td>
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
			 <table class="tableStyle"  useMultColor="true"  useCheckBox="true" id="questionTable">
			 	<tr>
			 		<th width="30px" align="center"></th>
			      	<th width="10%" align="center"><span>问题类型</span></th>
			      	<th width="30%" align="center"><span>问题</span></th>
			      	<th width="10%" align="center"><span>选择A</span></th>
			      	<th width="10%" align="center"><span>选择B</span></th>
			      	<th width="10%" align="center"><span>选择C</span></th>
			      	<th width="10%" align="center"><span>选择D</span></th>
			      	<th width="10%" align="center"><span>正确答案</span></th>
			      	<th width="10%" align="center">操作</th>
			    </tr>
				<c:if test="${!empty dataPm}">
				   	<c:forEach items="${dataPm.datas}" var="questions" >
				   		<tr>
				   			<td width="30px" align="center"><input id="questionid" name="question" type="checkbox" value="${questions.id}"/></td>
							<td width="10%" align="center">
								<span>
									<c:if test="${questions.qid == 1}">
										磁粉理论
									</c:if>
									<c:if test="${questions.qid == 2}">
										超声波理论
									</c:if>
									<c:if test="${questions.qid == 3}">
										磁粉
									</c:if>
									<c:if test="${questions.qid == 4}">
										超声波工艺
									</c:if>
								</span>
							</td>
							<td width="30%" align="center">
								<span>
									${questions.text}
								</span>
							</td>
							<td width="10%" align="center">
								<span>
									${questions.answerA}
								</span>
							</td>
							<td width="10%" align="center">
								<span>
									${questions.answerB}
								</span>
							</td>
							<td width="10%" align="center">
								<span>
									${questions.answerC}
								</span>
							</td>
							<td width="10%" align="center">
								<span>
									${questions.answerD}
								</span>
							</td>
							<td width="10%" align="center">
								<c:if test="${questions.rightAnswer == 1}">
									A
								</c:if>
								<c:if test="${questions.rightAnswer == 2}">
									B
								</c:if>
								<c:if test="${questions.rightAnswer == 3}">
									C
								</c:if>
								<c:if test="${questions.rightAnswer == 4}">
									D
								</c:if>
							</td>
							<td width="10%" align="center">
								<a href="javascript:;" onclick="edit('${questions.id}');" ><font color="blue">编辑</font></a>
								<a href="javascript:;" onclick="deletes('${questions.id}');"><font color="blue">删除</font></a>
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
				<pg:pager maxPageItems="${pageSize }" url="questionManageAction!findDetecQuestionByCondition.do" items="${dataPm.count }" export="page1=pageNumber">
					<pg:param name="qid" value="${qid}"/>
					<pg:param name="keys" value="${keys}"/>
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
			diag.Title = "新建题库";
			diag.URL = "questionManageAction!addDetecQuestionInput.do";
			diag.Width=500;
			diag.Height=350;
			diag.show();
		}
		
		//判断是否选中信息
		function enSureDelete(){
			//判断是否一个未选
			var flag; 
			//遍历所有的name为question的 checkbox 
			$("input[name='question']").each(function() {
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
		    	top.Dialog.alert("请至少选择一条问题信息！");
		    }
		
		}
		
		//删除
		function toDelete() {
			//用于保存 选中的那一条数据的ID 
			var questions = [];  
	    	$("input[name='question']").each(function() { 
	    		if ($(this).attr("checked")) { 
	    			//将选中的值 添加到 array中
	    			questions.push($(this).val());
	    		}
	    	})
	    	$.ajax({
				type:"post",
				async:false,
				url:"questionManageAction!deleteDetecQuestions.do",
				data:{"questions":questions.join(",")},
				success:function(result){
					if(result=="success"){
		    			top.Dialog.alert("问题信息删除成功！",function(){
				    			top.window.frmright.location.href="questionManageAction!findDetecQuestionByCondition.do";
			    			});
		    		}else{
		    			top.Dialog.alert("问题信息删除失败！");
		    		}
				}
			});
		}
		
		//删除
		function deletes(id) {
			//用于保存 选中的那一条数据的ID 
			var questions = [];  
	    	questions.push(id);
	    	top.Dialog.confirm("确认删除吗？",function(){ 
		    	$.ajax({
					type:"post",
					async:false,
					url:"questionManageAction!deleteDetecQuestions.do",
					data:{"questions":questions.join(",")},
					success:function(result){
						if(result=="success"){
			    			top.Dialog.alert("问题信息删除成功！",function(){
					    			top.window.frmright.location.href="questionManageAction!findDetecQuestionByCondition.do";
				    			});
			    		}else{
			    			top.Dialog.alert("问题信息删除失败！");
			    		}
					}
				});
			});
		}
		
		//编辑
		function edit(id){
			var diag = new top.Dialog();
			diag.Title = "编辑题库";
			diag.URL = "questionManageAction!editDetecQuestionInput.do?id="+id;
			diag.Width=500;
			diag.Height=350;
			diag.show();
		}
		
		
</script>
</body>
</html>