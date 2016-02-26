package com.ts.server.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.ts.common.pojo.DetecExam;
import com.ts.common.pojo.DetecQuestion;
import com.ts.common.pojo.Users;
import com.ts.common.util.ParseUtil;
import com.ts.server.service.ExamService;

public class ExamAction {
	
	@Resource(name="examService")
	private ExamService examService;
	
	private HttpServletRequest request=ServletActionContext.getRequest();
	private SimpleDateFormat YMDHMS_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	/**
	 * 显示题目 
	 */
	public String listExam() throws Exception {
		int type = ParseUtil.parseInt(request.getParameter("type"), 0);
		Integer[] types = null;
		if(type==1){  //1 -磁粉理论题2-超声波理题3 磁粉题4- 超声波工艺题
			types = new Integer[]{1,3};
		}else if(type==2){
			types = new Integer[]{2,4};
		}
		List<DetecQuestion> list = examService.listQuestion(types);
		request.setAttribute("questions", list);
		request.setAttribute("type", type);
		return "listExam";
	}
	
	/**
	 * 答题结束
	 */
	public String overExam() throws Exception {
		int score = ParseUtil.parseInt(request.getParameter("score"), 80);
		Users users = (Users) request.getSession().getAttribute("session_user");
		System.out.println(score);
		DetecExam exam = new DetecExam();
		exam.setExamTime(YMDHMS_FORMAT.format(new Date()));
		exam.setGongHao(users.getGongHao());
		exam.setGrade(score);
		examService.saveOrUpdateDetecExam(exam);
		return "overExam";
	}
}
