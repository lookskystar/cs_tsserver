/**
 * 题库管理
 */
package com.ts.manage.action;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.ts.common.pojo.DetecQuestion;
import com.ts.common.util.PageModel;
import com.ts.manage.service.QuestionManageService;

/**
 * @author eleven
 *
 */
public class QuestionManageAction {
	
	@Resource(name="questionManageService")
	private QuestionManageService questionManageService;
	
	private String qid;
	private String keys;
	
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpServletResponse response=ServletActionContext.getResponse();
	public static final SimpleDateFormat YMD_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	public static final SimpleDateFormat YMDHMS_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public String findDetecQuestionByCondition(){
		PageModel<DetecQuestion>  dataPm = questionManageService.findDetecQuestionByCondition(qid, keys);
		request.setAttribute("dataPm", dataPm);
		return "listdetecquestion";
	}
	
	public void deleteDetecQuestions() throws IOException{
		String result = "";
		String questionsIdArray[] = request.getParameter("questions").split(",");
		try {
			questionManageService.deleteQuestions(questionsIdArray);
			result = "success";
		} catch (Exception e) {
			e.printStackTrace();
			result = "failure";
		} finally{
			response.getWriter().write(result);
		}
	}
	
	public String addDetecQuestionInput() {
		return "addetecquestion";
	}
	
	public String editDetecQuestionInput() {
		String id = request.getParameter("id");
		DetecQuestion detecQuestion = questionManageService.findDetecQuestionById(Integer.parseInt(id));
		request.setAttribute("question", detecQuestion);
		return "editdetecquestion";
	}
	
	public void saveOrUpdateDetecQuestion() throws IOException{
		String result ="";
		String id = request.getParameter("id");
		String type = request.getParameter("type");
		String text = request.getParameter("text");
		String rightAnswer = request.getParameter("rightAnswer");
		String answerA = request.getParameter("answerA");
		String answerB = request.getParameter("answerB");
		String answerC = request.getParameter("answerC");
		String answerD = request.getParameter("answerD");
		DetecQuestion detecQuestion = new DetecQuestion();
		if(StringUtils.isNotEmpty(id)){
			detecQuestion.setId(Integer.parseInt(id));
		}
		detecQuestion.setQid(Integer.parseInt(type));
		detecQuestion.setText(text);
		detecQuestion.setRightAnswer(Integer.parseInt(rightAnswer));
		detecQuestion.setAnswerA(answerA);
		detecQuestion.setAnswerB(answerB);
		detecQuestion.setAnswerC(answerC);
		detecQuestion.setAnswerD(answerD);
		try {
			questionManageService.saveOrUpdateDetecQuestion(detecQuestion);
			result = "success";
		} catch (Exception e) {
			e.printStackTrace();
			result = "failure";
		} finally{
			response.getWriter().write(result);
		}
	}
	
	public String getQid() {
		return qid;
	}
	public void setQid(String qid) {
		this.qid = qid;
	}
	public String getKeys() {
		return keys;
	}
	public void setKeys(String keys) {
		this.keys = keys;
	}
}
