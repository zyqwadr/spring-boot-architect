package xyz.nesting.example.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UrlInterceptor implements HandlerInterceptor {
	private Logger log = LoggerFactory.getLogger(UrlInterceptor.class) ;
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		log.debug("preHandle: [URL:{}, METHOD:{}]", request.getRequestURL(), request.getMethod());
		return true;
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception arg3)
			throws Exception {
		log.debug("afterCompletion: [URL:{}, METHOD:{}]", request.getRequestURL(), request.getMethod());
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView arg3)
			throws Exception {
		log.debug("postHandle: [URL:{}, METHOD:{}]", request.getRequestURL(), request.getMethod());
	}

}
