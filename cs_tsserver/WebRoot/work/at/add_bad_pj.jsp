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
	    function addBadPJ(unitName){
	    	var str="<tr>";
	    	str+="<td align='center'><input type='text' value='"+unitName+"' style='width:120px;' name='pjNames'/></td>";
	    	str+="<td align='center'><input type='text' style='width:50px;' value='1' name='pjAmounts'/></td>";
	    	str+="<td align='center'><input type='text' style='width:120px;' name='pjNums'/></td>";
	    	str+="<td align='center'><input type='file' style='width:200px;' name='images' onchange='checkFileType(this);'/></td>";
	    	str+="<td align='center'><input type='button' value='删除' onclick='delBadPJ(this);'/></td>"
	    	str+="</tr>";
	    	$("table").append(str);
	    }
	    
	    function delBadPJ(obj){
	    	$(obj).parent().parent().remove();
	    }
	    
	    function checkFileType(obj){
	    	var path=obj.value;
	    	if(path!=""){
	    		var fileType=path.substring(path.lastIndexOf(".")+1).toLowerCase();
	    		if(fileType!="jpg"&&fileType!="jpeg"&&fileType!="bmp"&&fileType!="png"&&fileType!="gif"){
	    			top.Dialog.alert("文件类型不属于图片,请重新选择!");
	    		}
	    	}
	    }
	</script>
  </head>
<body>
  	<form action="decRecordAction!addBadPJ.do?decRecId=${decRecord.id }" method="post" target="frmright" onsubmit="return checkform();" enctype="multipart/form-data">   
		<table class="tableStyle"  headFixMode="true" useMultColor="true">
		    <tr>
		      <th width="15%">配件名称</th>
		      <th width="10%">配件数量</th>
		      <th width="15%">配件编号</th>
		      <th>上传图片</th>
		      <th width="10%">操作</th>
		    </tr>
		   	<tr>
		   	    <td align="center"><input type="text" value="${decRecord.unitName}" name="pjNames"/></td>
		   	    <td align="center"><input type="text" style="width:50px;" value="1" name="pjAmounts"/></td>
		   	    <td align="center"><input type="text" name="pjNums"/></td>
		   	    <td align="center"><input type="file" class="default" style='width:200px;' name="images" onchange="checkFileType(this);"/></td>
		   	    <td align="center"><input type="button" value="添加" onclick="addBadPJ('${decRecord.unitName}');"/></td>
			</tr>
		</table>
		<center>
			<input type="submit" value=" 提 交 "/>
			<input type="reset" value=" 重 置 "/>
  		</center>
  	</form>  
</body>
</html>