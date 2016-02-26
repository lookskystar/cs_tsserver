/**
 * 
 */
package com.ts.manage.service.impl;

import javax.annotation.Resource;

import com.sun.org.apache.commons.beanutils.ConvertUtils;
import com.ts.common.pojo.DetecQuestion;
import com.ts.common.util.PageModel;
import com.ts.manage.dao.QuestionManageDao;
import com.ts.manage.service.QuestionManageService;

/**
 * @author eleven
 *
 */
public class QuestionManageServiceImpl implements QuestionManageService{

	@Resource(name="questionManageDao")
	private QuestionManageDao questionManageDao;
	
	public PageModel<DetecQuestion> findDetecQuestionByCondition(String type,
			String keys) {
		return questionManageDao.findDetecQuestionByCondition(type, keys);
	}

	public void deleteDetecQuestion(DetecQuestion detecQuestion) {
		questionManageDao.deleteDetecQuestion(detecQuestion);
		
	}

	public DetecQuestion findDetecQuestionById(Integer id) {
		return questionManageDao.findDetecQuestionById(id);
	}

	public void saveOrUpdateDetecQuestion(DetecQuestion detecQuestion) {
		questionManageDao.saveOrUpdateDetecQuestion(detecQuestion);
	}

	public void deleteQuestions(String[] questionIdArray) {
		questionManageDao.deleteQuestions((Integer[])ConvertUtils.convert(questionIdArray, Integer.class));
	}

}
