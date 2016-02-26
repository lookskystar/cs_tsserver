/**
 * 
 */
package com.ts.manage.service;

import com.ts.common.pojo.DetecQuestion;
import com.ts.common.util.PageModel;

/**
 * @author eleven
 *
 */
public interface QuestionManageService {
	
	public PageModel<DetecQuestion> findDetecQuestionByCondition(String type, String keys);
	
	public void saveOrUpdateDetecQuestion(DetecQuestion detecQuestion);
	
	public void deleteDetecQuestion(DetecQuestion detecQuestion);
	
	public DetecQuestion findDetecQuestionById(Integer id);
	
	public void deleteQuestions(String[] questionIdArray);
}
