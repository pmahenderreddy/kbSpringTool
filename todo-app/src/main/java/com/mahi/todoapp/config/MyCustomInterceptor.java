package com.mahi.todoapp.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class MyCustomInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// Your custom code to execute before the request is handled by the controller
		System.out.println("Executing code before the request handler");
		System.out.println(request.getRequestURI());

		boolean goAhead = true;
		String requestURI = request.getRequestURI();
		if (requestURI.endsWith(".css") || requestURI.endsWith(".js")) {
			return goAhead;
		}

		if (!requestURI.startsWith("/login")) {
			goAhead = false;
			HttpSession session = request.getSession(false);
			if (session == null) {
				response.sendRedirect("/login");
				return false;
			}
			String mandateStr = (String) session.getAttribute("name");
			if (mandateStr == null || mandateStr.length() <= 0) {
				response.sendRedirect("/login");
				goAhead = false;
			} else {
				goAhead = true;
			}
		}
		return goAhead; // continue the request handling
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			org.springframework.web.servlet.ModelAndView modelAndView) throws Exception {
		// Your custom code to execute after the request handler
		System.out.println("Executing code after the request handler");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// Custom code to execute after the complete request has been processed
		System.out.println("Executing code after request completion");
	}
}
