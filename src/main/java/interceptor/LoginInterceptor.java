package interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import utils.StringUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        if(uri.toUpperCase().contains("LOGIN") ||
                (request.getSession().getAttribute("user") != null)) {
            return true;
        }
        response.sendRedirect(request.getContextPath() + "/user/toLogin.action");
        return false;
    }
}
