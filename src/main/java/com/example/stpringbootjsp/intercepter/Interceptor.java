package com.example.stpringbootjsp.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
@Component
public class Interceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println(request.getRequestURI());
		// リクエストがマッピングできていない場合はfalse
//        if( handler instanceof HandlerMethod ) {
//
//            // @NonAuthが付与されているかどうかをチェックする
//            HandlerMethod hm = (HandlerMethod) handler;
//            Method method = hm.getMethod();
//            NonAuth annotation = AnnotationUtils.findAnnotation(method, NonAuth.class);
//            if (annotation != null) {
//                return true;
//            }
//
//            // ユーザ認証
//            HttpSession session = request.getSession(false);
//            try {
////                TestUser user = (TestUser)session.getAttribute("user");
////                if(!service.checkPermission(user)) {
////                    response.sendRedirect("/error");
////                    return false;
////                }
//            }catch(NullPointerException e){
//                response.sendRedirect("/error");
//                return false;
//            }
//            return true;
//        }
//        response.sendRedirect("/error");
        return true;
//		return true;
	}

//	@Override
//	public void postHandle(
//			HttpServletRequest request, HttpServletResponse response, Object handler,
//			ModelAndView modelAndView) throws Exception {
//	}
//
//	@Override
//	public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
//			Object handler, Exception exception) throws Exception {
//	}
}