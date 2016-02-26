package com.ts.server.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.ts.common.pojo.DetecExam;
import com.ts.common.pojo.DetecQuestion;
import com.ts.server.dao.ExamDao;
import com.ts.server.service.ExamService;

public class ExamServiceImpl implements ExamService{
	
	@Resource(name="examDao")
	private ExamDao examDao;

	public void deleteQuestion(int id) {
		examDao.deleteQuestion(id);
	}

	public DetecQuestion getQuestionById(int id) {
		return examDao.getQuestionById(id);
	}

	public List<DetecQuestion> listQuestion(Integer[] type) {
		return examDao.listQuestion(type);
	}

	public void saveOrUpdateQuestion(DetecQuestion question) {
		examDao.saveOrUpdateQuestion(question);
	}
	
	public void saveOrUpdateDetecExam(DetecExam exam){
		examDao.saveOrUpdateDetecExam(exam);
	}

}
