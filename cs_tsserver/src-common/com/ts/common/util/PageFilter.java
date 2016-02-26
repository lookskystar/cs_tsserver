package com.ts.common.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class PageFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filter) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		Integer offset=getOffset(httpServletRequest);
		Integer pageSize=getPageSize(httpServletRequest);
		SystemContext.setOffset(offset);
		SystemContext.setPageSize(pageSize);
		try {
			filter.doFilter(request, response);
		} catch (Exception e) {
			SystemContext.removeOffset();
			SystemContext.removePageSize();
		}
		

	}

	public void init(FilterConfig arg0) throws ServletException {

	}
	/**
	 * �������л�ȡoffset��ֵ
	 * @param request
	 * @return
	 */
	private static Integer getOffset(HttpServletRequest request){
		String os=request.getParameter("pager.offset");
		if(os==null){
			os=request.getParameter("pnum");
		}
		int offset=0;
		try {
			offset=Integer.parseInt(os);
		} catch (Exception e) {
			offset=0;
		}
		return offset;
	}
	/**
	 * �������л�ȡpageSize�����û��ֵ�����Session��ȡ����������ж�û�У�����Ĭ�ϵ�ֵ10
	 * @param request
	 * @return
	 */
	private static Integer getPageSize(HttpServletRequest request){
		String ps=request.getParameter("page.size");
		int pageSize=10;
		String ps2 =request.getParameter("page.size_ding");
		if(ps2!=null&&!ps2.trim().equals("")){
			ps=ps2;
		}
		if(ps==null){
			ps = request.getParameter("psize");
			if(ps!=null){
				try {
					pageSize=Integer.parseInt(ps);
				} catch (Exception e) {
					pageSize=10;
				}
			}else{
				Object ops=request.getSession().getAttribute("page.size");
				if(ops!=null){
					pageSize=(Integer)ops;
				}
			}
		}else{
			try {
				pageSize=Integer.parseInt(ps);
			} catch (Exception e) {
				pageSize=10;
			}
		}
		request.getSession().setAttribute("pageSize", pageSize);
		return pageSize;
	}
}
