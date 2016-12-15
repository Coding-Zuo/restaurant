package com.zuo.restaurant.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.zuo.restaurant.po.User;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	

	// 进入handler 方法之前执行
	// 身份认证，身份授权
	// 比如身份认证，如果认证不通过，表示当前用户没有登录，需要此方法拦截，不再向下执行
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 获取请求的url
		String url = request.getRequestURI();
		// 判断url是否是公开地址（实际使用时将公开地址配置配置文件中）
		// 这里公开地址就是登录提交的地址
		if (url.indexOf("login") >= 0||url.indexOf("admin")>=0) {
			// 如果进行登录提交，放行
			return true;
		}
		if(url.indexOf(".jpg")>=0||url.indexOf(".png")>=0||url.indexOf(".jpeg")>=0){
			return true;
		}
		if(url.indexOf("outSite")>=0){
			return true;
		}
		if(url.indexOf("register")>0){
			return true;
		}
		// 判断session
		HttpSession session = request.getSession();
		// 从session中取出用户信息
		User user=(User) session.getAttribute("loginUser");
		if (user!=null) {
			// 身份信息存在。放行
			return true;
		}

		// 执行到这里表示前面都没放行，用户身份需要认证
		request.getRequestDispatcher("/WEB-INF/jsp/outSite/index.jsp").forward(request, response);

		// false表示拦截住
		// true 放行
		return false;
	}

}
