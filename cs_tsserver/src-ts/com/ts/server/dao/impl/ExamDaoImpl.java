package com.ts.server.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ts.common.pojo.DetecExam;
import com.ts.common.pojo.DetecQuestion;
import com.ts.common.util.Contains;
import com.ts.server.dao.ExamDao;

public class ExamDaoImpl extends HibernateDaoSupport implements ExamDao {

	public void deleteQuestion(int id) {
		String hql = "delete from DetecQuestion t where t.id = ?";
		getSession().createQuery(hql).setInteger(0, id).executeUpdate();
	}

	public DetecQuestion getQuestionById(int id) {
		return getHibernateTemplate().get(DetecQuestion.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<DetecQuestion> listQuestion(Integer[] type) {
		String hql = "from DetecQuestion t";
		if(type==null){
			hql += " order by newid() asc,t.id asc";
			return getSession().createQuery(hql).setFirstResult(0).setMaxResults(Contains.EXAM_QUES_NUM).list(); 
		}else{
			hql += " where t.qid in (:types) order by newid() asc,t.id asc";
			return getSession().createQuery(hql).setParameterList("types", type).setFirstResult(0).setMaxResults(Contains.EXAM_QUES_NUM).list();
		}
	}

	public void saveOrUpdateQuestion(DetecQuestion question) {
		getHibernateTemplate().saveOrUpdate(question);
	}
	
	public void saveOrUpdateDetecExam(DetecExam exam){
		getHibernateTemplate().saveOrUpdate(exam);
	}
	
}
