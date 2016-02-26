package com.ts.manage.dao;

import com.ts.common.pojo.DetecQuestion;
import com.ts.common.util.PageModel;

public interface QuestionManageDao {
	
	/**
	 * 分页查询题库
	 * @param type
	 * @param keys
	 * @return
	 */
	public PageModel<DetecQuestion> findDetecQuestionByCondition(String type, String keys);
	
	/**
	 * 查询题库
	 * @param id
	 * @return
	 */
	public DetecQuestion findDetecQuestionById(Integer id);
	
	/**
	 * 新增更新题库
	 * @param detecQuestion
	 */
	public void saveOrUpdateDetecQuestion(DetecQuestion detecQuestion);
	
	/**
	 * 删除题库
	 * @param detecQuestion
	 */
	public void deleteDetecQuestion(DetecQuestion detecQuestion);
	
	/**
	 * 批量删除
	 * @param questionIdArray
	 */
	public void deleteQuestions(Integer[] questionIdArray);
}
