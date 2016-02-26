package com.ts.server.dao;

import java.util.List;

import com.ts.common.pojo.DetecExam;
import com.ts.common.pojo.DetecQuestion;

public interface ExamDao {
	
	/**
	 * 获取题目  null:全部
	 */
	public List<DetecQuestion> listQuestion(Integer[] type);
	
	/**
	 * 根据ID获取题目
	 */
	public DetecQuestion getQuestionById(int id);
	
	/**
	 * 新增或修改
	 */
	public void saveOrUpdateQuestion(DetecQuestion question);
	
	/**
	 * 删除
	 */
	public void deleteQuestion(int id);
	
	/**
	 * 保存考试记录
	 */
	public void saveOrUpdateDetecExam(DetecExam exam);
}
