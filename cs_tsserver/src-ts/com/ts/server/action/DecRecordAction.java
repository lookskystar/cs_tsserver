package com.ts.server.action;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.ts.common.pojo.DecBadPJRec;
import com.ts.common.pojo.DecRecord;
import com.ts.common.pojo.DictJcType;
import com.ts.common.pojo.Users;
import com.ts.common.util.Contains;
import com.ts.common.util.ImageZipUtil;
import com.ts.common.util.MD5;
import com.ts.server.service.DecRecordService;
import com.ts.server.service.UsersService;

public class DecRecordAction {
	
	@Resource(name="decRecordService")
	private DecRecordService decRecordService;
	@Resource(name="usersService")
	private UsersService usersService;
	
	private DecRecord decRec;
	
	private List<String> pjNames;
	private List<Integer> pjAmounts;
	private List<String> pjNums;
	private List<File> images;
	private List<String> imagesFileName;
	
	private HttpServletRequest request=ServletActionContext.getRequest();
	private SimpleDateFormat YMD_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	private SimpleDateFormat YMDHMS_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	/**
	 * 进入记录填写列表页面
	 */
	public String listUnfinishDecRecord() throws Exception {
		String btimeTemp = request.getParameter("btime");
		String etimeTemp = request.getParameter("etime");
		String btime = null;
		String etime = null;
		Date now = new Date();
		if(btimeTemp==null || "".equals(btimeTemp)){
			btimeTemp = YMD_FORMAT.format(now);
		}
		btime = btimeTemp + " 00:00:00";
		if(etimeTemp==null || "".equals(etimeTemp)){
			etimeTemp = YMD_FORMAT.format(now);
		}
		etime = etimeTemp + " 23:59:59";
		List<DecRecord> list = decRecordService.listDecRecords(btime, etime,Contains.DECRECORD_UNFINISH_STATUS);
		request.setAttribute("decRecs", list);
		request.setAttribute("btime", btimeTemp);
		request.setAttribute("etime", etimeTemp);
		return "unfinishDecRecords";
	}
	
	/**
	 * 进入记录填写页面
	 * @return
	 */
	public String fillDecRecordInput(){
		Long decRecId=Long.parseLong(request.getParameter("decRecId"));
		DecRecord decRec=decRecordService.getDecRecord(decRecId);
		List<DecBadPJRec> decBadPjs=decRecordService.listDecBadPjRec(decRecId);
		request.setAttribute("decRec", decRec);
		request.setAttribute("decBadPjs", decBadPjs);
		return "fillDecRecordDialog";
	}
	
	/**
	 * 记录详情
	 */
	public String updateDecrecordInput() throws Exception {
		return "updatedecrecord";
	}
	
	
	/**
	 * 进入记录填写
	 */
	public String listFinishDecRecord() throws Exception {
		String btimeTemp = request.getParameter("btime");
		String etimeTemp = request.getParameter("etime");
		String btime = null;
		String etime = null;
		Date now = new Date();
		if(btimeTemp==null || "".equals(btimeTemp)){
			btimeTemp = YMD_FORMAT.format(now);
		}
		btime = btimeTemp + " 00:00:00";
		if(etimeTemp==null || "".equals(etimeTemp)){
			etimeTemp = YMD_FORMAT.format(now);
		}
		etime = etimeTemp + " 23:59:59";
		List<DecRecord> list = decRecordService.listDecRecords(btime, etime,Contains.DECRECORD_FINISH_STATUS);
		request.setAttribute("decRecs", list);
		request.setAttribute("btime", btimeTemp);
		request.setAttribute("etime", etimeTemp);
		return "finishDecRecords";
	}
	
	
	/**
	 * 记录详情
	 */
	public String decrecordDetail() throws Exception {
		Long decRecId=Long.parseLong(request.getParameter("decRecId"));
		DecRecord decRec=decRecordService.getDecRecord(decRecId);
		List<DecBadPJRec> badPJRecs = decRecordService.listDecBadPjRec(decRecId);
		request.setAttribute("decRec", decRec);
		request.setAttribute("badPJRecs", badPJRecs);
		return "decrecordDetail";
	}
	
	/**
	 * 报表 默认为当月第一天至当天
	 */
	public String report() throws Exception {
		String btimeTemp = request.getParameter("btime");
		String etimeTemp = request.getParameter("etime");
		String btime = null;
		String etime = null;
		Date now = new Date();
		if(btimeTemp==null || "".equals(btimeTemp)){
			Calendar cal = Calendar.getInstance(); 
			cal.setTime(new Date()); 
			cal.set(Calendar.DAY_OF_MONTH, 1); 
			btimeTemp = YMD_FORMAT.format(cal.getTime());
		}
		btime = btimeTemp + " 00:00:00";
		if(etimeTemp==null || "".equals(etimeTemp)){
			etimeTemp = YMD_FORMAT.format(now);
		}
		etime = etimeTemp + " 23:59:59";
		Map<String, Map<String,Integer>> map = decRecordService.countBadPJ(btime,etime);
		//所有车型
		List<DictJcType> jcTypes = decRecordService.listJcTypes();
		request.setAttribute("map", map);
		request.setAttribute("jcTypes", jcTypes);
		request.setAttribute("btime", btimeTemp);
		request.setAttribute("etime", etimeTemp);
		return "reportiframe";
	}
	
	/**
	 * ajax判断用户
	 * @return
	 */
	public String ajaxIdentifyUser(){
		HttpServletResponse response=ServletActionContext.getResponse();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String cardnum=request.getParameter("cardnum");
		Users user=null;
		String result="failure";
		if(username!=null&&!"".equals(username)){
			password = MD5.GetMD5Code(password);
			user=usersService.login(username, password);
		}else{
			user=usersService.login(cardnum);
		}
		if(user!=null){
			if(user.getPosId()==Contains.JSY_ROLE_ID){
				result="jsy_"+user.getXm();
			}else if(user.getPosId()==Contains.ZJY_ROLE_ID){
				result="zjy_"+user.getXm();
			}else{
				result="login_other";
			}
		}
		response.setContentType("text/plain");
		try {
			response.getWriter().print(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

/**
	 * 填写探伤记录信息
	 * @throws Exception 
	 */
	public String updateDecRecord() throws Exception{
		Long decRecId=Long.parseLong(request.getParameter("decRecId"));
		DecRecord decRecord=decRecordService.getDecRecord(decRecId);
		decRecord.setUnitNotext(decRec.getUnitNotext());
		decRecord.setUnitNumber(decRec.getUnitNumber());
		decRecord.setAtResult(decRec.getAtResult());
		decRecord.setOperResult(decRec.getOperResult());
		decRecord.setTway(decRec.getTway());
		decRecord.setT1(decRec.getT1());
		decRecord.setQ1(decRec.getQ1());
		decRecord.setAtTime(decRec.getAtTime());
		decRecord.setStatus(Contains.DECRECORD_FINISH_STATUS);
		decRecordService.saveOrUpdateDecRecord(decRecord);
		request.setAttribute("message", "探伤记录填写成功!");
		return listUnfinishDecRecord();
	}

	/**
	 * 进入添加裂损配件页面
	 * @return
	 */
	public String addBadPJInput(){
		Long decRecId=Long.parseLong(request.getParameter("decRecId"));
		DecRecord decRecord=decRecordService.getDecRecord(decRecId);
		request.setAttribute("decRecord", decRecord);
		return "addBadPJInput";
	}
	
	/**
	 * 添加裂损配件
	 * @return
	 * @throws Exception 
	 */
	public String addBadPJ() throws Exception{
		Long decRecId=Long.parseLong(request.getParameter("decRecId"));
		DecRecord decRecord=decRecordService.getDecRecord(decRecId);
		if(pjNames!=null&&pjNames.size()>0){
			String imageUrl=null;//压缩图片地址
			String bigImageUrl=null;//原图片地址
			DecBadPJRec decBadPjRec=null;
			String newImageName=null;//新图片名称
			String savePath=null;//保存路径
			String Path=ServletActionContext.getServletContext().getRealPath("uploadImage");
			for(int i=0;i<pjNames.size();i++){
				if(images!=null&&images.size()-1>=i){
					File file=images.get(i);
					String imageName=imagesFileName.get(i);
					newImageName=UUID.randomUUID()+"_s"+ imageName.substring(imageName.indexOf("."));//压缩文件名
					savePath=Path+"/"+newImageName;
					imageUrl="uploadImage/"+newImageName;
					ImageZipUtil.zipImageFile(file, new File(savePath), 340, 450, 1.0f);//压缩后的文件上传
					
					newImageName=UUID.randomUUID()+imageName.substring(imageName.indexOf("."));//修改源文件名
					savePath=Path+"/"+newImageName;
					bigImageUrl="uploadImage/"+newImageName;
					File distFile=new File(savePath);
					FileUtils.copyFile(file, distFile);//上传单个原文件
				}
				decBadPjRec=new DecBadPJRec();
				decBadPjRec.setDecRecId(decRecord);
				decBadPjRec.setPjAmount(pjAmounts.get(i));
				decBadPjRec.setPjName(pjNames.get(i));
				decBadPjRec.setPjNums(pjNums.get(i));
				decBadPjRec.setPjImageUrls(imageUrl);
				decBadPjRec.setPjBigImageUrl(bigImageUrl);
				decRecordService.saveOrUpdateDecBadPjRec(decBadPjRec);
			}
			
		}
		request.setAttribute("message", "裂损配件信息添加成功!");
		return listUnfinishDecRecord();
	}
	
	/**
	 * ajax删除裂损配件信息
	 * @return
	 * @throws IOException 
	 */
	public String ajaxDelBadPJ() throws IOException{
		Long badPJId=Long.parseLong(request.getParameter("badPJId"));
		decRecordService.delBadPJRecById(badPJId);
		ServletActionContext.getResponse().getWriter().print("success");
		return null;
	}
	
	/**
	 * 裂损配件列表
	 * @return
	 */
	public String listBadPJRecord() throws Exception {
		String btime = request.getParameter("btime") + " 00:00:00";
		String etime = request.getParameter("etime") + " 23:59:59";
		String pjName = request.getParameter("pjname");
		String jctype = request.getParameter("jctype");
		
		List<DecBadPJRec> badPJRecs = decRecordService.listDecBadPjRec(btime,etime,pjName,jctype);
		request.setAttribute("badPJRecs", badPJRecs);
		return "listbadpj";
	}
	
	public DecRecord getDecRec() {
		return decRec;
	}

	public void setDecRec(DecRecord decRec) {
		this.decRec = decRec;
	}

	public List<String> getPjNames() {
		return pjNames;
	}

	public void setPjNames(List<String> pjNames) {
		this.pjNames = pjNames;
	}
	
	public List<Integer> getPjAmounts() {
		return pjAmounts;
	}

	public void setPjAmounts(List<Integer> pjAmounts) {
		this.pjAmounts = pjAmounts;
	}

	public List<String> getPjNums() {
		return pjNums;
	}

	public void setPjNums(List<String> pjNums) {
		this.pjNums = pjNums;
	}

	public List<File> getImages() {
		return images;
	}

	public void setImages(List<File> images) {
		this.images = images;
	}

	public List<String> getImagesFileName() {
		return imagesFileName;
	}

	public void setImagesFileName(List<String> imagesFileName) {
		this.imagesFileName = imagesFileName;
	}
}
