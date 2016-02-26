package com.ts.common.util;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
/**
 * ȫ���쳣 �����쳣���浽��־�ļ�����ת������ҳ��
 *
 */
public class ExceptionInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 6094586137631997114L;
	private Logger log = Logger.getLogger(ExceptionInterceptor.class);

	public String intercept(ActionInvocation invocation) throws Exception {
			try {
				//����ִ��ʣ�����������Action����
				return invocation.invoke();
			} catch (Throwable e) {
				log.error(e, e);
				return "g_error";
			}
	}

}
