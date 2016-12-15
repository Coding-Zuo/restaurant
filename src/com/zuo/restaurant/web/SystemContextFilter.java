package com.zuo.restaurant.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.zuo.restaurant.po.SystemContext;


/**
 * Servlet Filter implementation class SystemContextFilter
 */
public class SystemContextFilter implements Filter {

	
	private int pageSize;
    /**
     * Default constructor. 
     */
    public SystemContextFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		try {
			int tps=pageSize;
			try {
				tps=Integer.parseInt(request.getParameter("pageSize"));
			} catch (NumberFormatException e) {
			}
			int pageOffset=0;
			try {
				pageOffset=Integer.parseInt(request.getParameter("pager.offset"));
			} catch (NumberFormatException e) {
			}
			SystemContext.setPageOffset(pageOffset);
			SystemContext.setPageSize(tps);
			System.out.println(SystemContext.getPageOffset());
//			HttpServletRequest req=(HttpServletRequest)request;
//			String realPath=req.getSession().getServletContext().getRealPath("");
//			realPath="/Users/zuo/Documents/workspace/Document/WebContent";
//			SystemContext.setRealPath(realPath);
//			User loginUser=(User) req.getSession().getAttribute("loginUser");
//			if(loginUser!=null){
//				SystemContext.setLoginUser(loginUser);
//			}
			chain.doFilter(request, response);
		} finally {
			SystemContext.removePageSize();
			SystemContext.removePageSize();
//			SystemContext.removeLoginUser();
//			SystemContext.removeRealPath();
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		try {
			pageSize=Integer.parseInt(fConfig.getInitParameter("pageSize"));
		} catch (NumberFormatException e) {
			pageSize=10;
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
