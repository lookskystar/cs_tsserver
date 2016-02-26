/**
 * 
 */
package com.ts.manage.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.ts.common.pojo.DetecQuestion;
import com.ts.common.util.AbstractDao;
import com.ts.common.util.PageModel;
import com.ts.manage.dao.QuestionManageDao;

/**
 * @author eleven
 *
 */
public class QuestionManageDaoImpl extends AbstractDao implements QuestionManageDao {
	
	@SuppressWarnings("unchecked")
	public PageModel<DetecQuestion> findDetecQuestionByCondition(String type,
			String keys) {
		StringBuilder builder = new StringBuilder();
		builder.append("from DetecQuestion t where 1=1");
		List<Object> params = new ArrayList<Object>();
		if(StringUtils.isNotEmpty(type)){
			builder.append(" and t.qid=?");
			params.add(Integer.parseInt(type));
		}
		if(StringUtils.isNotEmpty(keys)){
			builder.append(" and t.text like '%"+ keys +"%'");
		}
		builder.append(" order by t.id desc");
		return findPageModel(builder.toString(),params.toArray());
	}
	
	public void deleteQuestions(Integer[] questionIdArray) {
		this.getSession().createQuery("delete from DetecQuestion dq where dq.id in(:questionIds)").setParameterList("questionIds", questionIdArray).executeUpdate();
	}
	
	public void saveOrUpdateDetecQuestion(DetecQuestion detecQuestion){
		this.getHibernateTemplate().saveOrUpdate(detecQuestion);
	}
	
	public void deleteDetecQuestion(DetecQuestion detecQuestion){
		this.getHibernateTemplate().delete(detecQuestion);
	}

	public DetecQuestion findDetecQuestionById(Integer id) {
		return this.getHibernateTemplate().get(DetecQuestion.class, id);
	}
}
