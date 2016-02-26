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
	<script src="js/menu/contextmenu.js" type="text/javascript"></script>
	<script type="text/javascript">
	    $(function(){
	    	$("#jsy").click(function(){
	    		if($(this).attr("checked")){
	    			top.Dialog.open({URL:"<%=basePath%>work/at/sign_dialog.jsp",Width:400,Height:200,Title:"签名"});
	    		}
	    	});
	    	$("#zjy").click(function(){
	    		if($(this).attr("checked")){
	    			top.Dialog.open({URL:"<%=basePath%>work/at/sign_dialog.jsp",Width:400,Height:200,Title:"签名"});
	    		}
	    	});
	    });
	    
	    function checkform(){
	    	var atResult=$("#atResult").val();
	    	if(atResult==""){
	    		top.Dialog.alert("探伤结果信息不能为空!");
	    		return false;
	    	}
	    	var checkInfo=$("#checkInfoSelect").attr("editValue");
			if(checkInfo==undefined||checkInfo==""){
				checkInfo="";
			}
			$("#operResult").val(checkInfo);
			var tsway="";
			$("input[name='tsway']:checked").each(function(){
				tsway+=$(this).val()+",";
			});
			if(tsway==""){
				top.Dialog.alert("请选择探伤方法!");
				return false;
			}else{
				tsway=tsway.substring(0,tsway.length-1);
				$("#tway").val(tsway);
			}
	    	return true;
	    }
	    
	    //添加裂损配件信息
	    function addBadPJ(decRecId){
	    	top.Dialog.open({URL:"<%=basePath%>decRecordAction!addBadPJInput.do?decRecId="+decRecId,Width:620,Height:400,Title:"添加裂损配件信息"});
	    }
	    
		//关闭此页面
		function toclose(){
			top.Dialog.close();
		}
		
		function delBadPJ(badPJId){
			top.Dialog.confirm("确认要删除此信息",function(){
				$.post("<%=basePath%>decRecordAction!ajaxDelBadPJ.do",{"badPJId":badPJId},function(data){
					if(data=="success"){
						top.Dialog.alert("信息删除成功!",function(){
							top.frames[3].location.reload();
						});
					}else{
						top.Dialog.alert("信息删除失败!");
					}
					
				});
			});
		}
		
		$(function() {
   				 var atResultOption = { width: 150, items: [
                    { text: "合格", icon: "<%=basePath%>images/icons/ico4.gif", alias: "合格",  width: 150,action: menuAction},
                    { text: "裂", icon: "<%=basePath%>images/icons/ico4.gif", alias: "裂",  width: 150,action: menuAction}
                    ], onShow: applyrule,
        onContextMenu: BeforeContextMenu
	    };
   	
	    function menuAction(object) {
	    	//var obj = $(object).val();
	        $(object).val(this.data.alias);
	        $(object).focus();
	    }
	    function BeforeContextMenu() {
	        return this.id != "target3";
	    }
	    
	    function applyrule(menu) {               
	       menu.applyrule({ name: "all",
	           disable: true,
	           items: []
	       });
	    }
	    $("#atResult").contextmenu(atResultOption);
	});
	</script>
  </head>
<body>
<!-- decRecordAction!updateDecRecord.do -->
  	<form action="decRecordAction!updateDecRecord.do" method="post" target="frmright" onsubmit="return checkform();">   
  	    <input type="hidden" value="${decRec.id }" name="decRecId"/>
		<table class="tableStyle" transMode="true">
			<tr>
				<td width="15%">机车类型: </td>
				<td width="38%">
					
					<input  type="text" name="decRec.jcType"  value="${decRec.jcType }" readonly="readonly"></input>
				</td>
				<td width="15%">机车车号: </td>
				<td width="32%">
					<input  type="text" name="decRec.jcNumber"  value="${decRec.jcNumber}" readonly="readonly"></input>
				</td>
			</tr>
	 		<tr>
				<td>修&nbsp;&nbsp;程: </td>
				<td>
					<input  type="text" name="decRec.xc" value="${decRec.xc }" readonly="readonly"></input>
				</td>
			    <td>修&nbsp;&nbsp;次: </td>
				<td>
					<input  type="text" name="decRec.xci" value="${decRec.xci }" readonly="readonly"></input>
				</td>
			</tr>
			<tr>
				<td>配件名称: </td>
				<td>
					<input  type="text" name="decRec.unitName" value="${decRec.unitName }" style="width:200px;"></input>
				</td>
			</tr>
			<tr>
				<td>配件编号: </td>
				<td colspan="3">
					<input  type="text" name="decRec.unitNotext" value="${decRec.unitNotext }" style="width:485px;"></input>
				</td>
			</tr>
			<tr>
				<td>配件数量: </td>
				<td>
					<input  type="text" name="decRec.unitNumber" value="${decRec.unitNumber }"></input>
				</td>
			</tr>
			<tr>
				<td>裂损配件表: </td>
				<td>
				   <a href="javascript:void(0)" style="color:blue;" onclick="addBadPJ(${decRec.id });">点击此处添加裂损配件</a>
				</td>
			</tr>
			<tr>
				<td>探伤结果: </td>
				<td>
				   <input  type="text" name="decRec.atResult" value="${decRec.atResult }" id="atResult"></input>
				   (右键选择信息)
				</td>
			    <td>处理结果: </td>
				<td>
					<input  type="hidden" name="decRec.operResult" value="" id="operResult"></input>
					<select editable="true" id="checkInfoSelect" style="width: 150px;" autoWidth="true">
					    <option value="报废">报废</option>
					    <option value="返厂">返厂</option>
					    <option value="继续使用">继续使用</option>
					    <option value="处理后继续使用">处理后继续使用</option>
				 	</select>
				</td>
			</tr>
			<tr>
				<td>探伤作业者: </td>
				<td>
					<input  type="text" name="worker" value="${decRec.mainName}&nbsp;&nbsp;${decRec.secondName}" style="width:200px;" readonly="readonly"></input>
				</td>
			</tr>
			<tr>
				<td>探伤方法: </td>
				<td>
					<input type="hidden" name="decRec.tway" id="tway" value=""/>
					<input type="checkbox" value="磁粉" name="tsway"/>磁粉
					<input type="checkbox" value="超声波" name="tsway"/>超声波
					<input type="checkbox" value="渗透" name="tsway"/>渗透
					<input type="checkbox" value="涡流" name="tsway"/>涡流
				</td>
			    <td>探伤时间: </td>
				<td>
					<input name="decRec.atTime" class="Wdate" type="text" id="d15" onFocus="WdatePicker({isShowClear:false,readOnly:true})" style="width:150px;" value="${fn:substring(decRec.atTime, 0, 19)}"/>
				</td>
			</tr>
			<tr>
				<td><input type="checkbox" id="jsy"/>技术员: </td>
				<td>
					<input  type="text" name="decRec.t1" readonly="readonly" id="t1"></input>
				</td>
			    <td><input type="checkbox" id="zjy"/>质检员: </td>
				<td>
					<input  type="text" name="decRec.q1" readonly="readonly" id="q1"></input>
				</td>
			</tr>
			<tr><td colspan="4"></td></tr>
			<tr>
				<td colspan="4">
					<input type="submit" value="确   定" style="width:120px;"/>&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="button" onclick="toclose();" value="放  弃" style="width:120px;"/>
				</td>
			</tr>
		</table>
  	</form>  <br/>
  	<a href="javascript:void(0);" style="color:blue;">已添加裂损配件:</a>
  	<table class="tableStyle" useMultColor="true" headFixMode="true">
  	       <tr><th>配件名称</th><th>配件数量</th><th>配件编号</th><th>图片信息</th><th>操作</th></tr>
  	       <c:if test="${empty decBadPjs}">
  	          <tr><td colspan="5"><center>没有添加相应的裂损配件信息!</center></td></tr>
  	       </c:if>
  	       <c:if test="${!empty decBadPjs}">
	  	       <c:forEach var="decBadPj" items="${decBadPjs}">
	  	          <tr>
	  	             <td align="center">${decBadPj.pjName}</td>
	  	             <td align="center">${decBadPj.pjAmount}</td>
	  	             <td align="center">${decBadPj.pjNums}</td>
	  	             <td align="center">
	  	               <c:if test="${!empty decBadPj.pjBigImageUrl}"><a href="<%=basePath%>${decBadPj.pjBigImageUrl}" target="_blank" style="color:blue;">查看</a></c:if>
	  	             </td>
	  	             <td align="center"><a href="javascript:void(0);" style="color:blue;" onclick="delBadPJ(${decBadPj.id});">删除</a></td>
	  	          </tr>
	  	       </c:forEach>
  	       </c:if>
  	</table>
  	<link href="<%=basePath %>My97DatePicker/skin/WdatePicker.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<%=basePath %>My97DatePicker/WdatePicker.js"></script>
</body>
</html>