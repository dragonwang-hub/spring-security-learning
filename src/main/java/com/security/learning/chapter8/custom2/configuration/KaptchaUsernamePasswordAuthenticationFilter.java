package com.security.learning.chapter8.custom2.configuration;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class KaptchaUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        // 在此处进行验证码的校验，在用此Filter替换UPAF
        // ...
        // from request
        if (!request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        }
        String verifyCode = request.getParameter("kaptcha");
        // from session
        String sessionKaptcha = (String) request.getSession().getAttribute("kaptcha");
        // match
        if (verifyCode != null && verifyCode.equalsIgnoreCase(sessionKaptcha)) {
            return super.attemptAuthentication(request, response);
        }
        throw new AuthenticationServiceException("Verify code error");
    }
}
