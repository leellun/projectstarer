package com.newland.security.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
public class ManagerLoginUrlAuthenticationEntryPoint implements AuthenticationEntryPoint {
    public ManagerLoginUrlAuthenticationEntryPoint() {
    }

    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
        response.setContentType("application/json;charset=utf-8");
        response.addHeader("Access-Control-Allow-Methods", "GET,HEAD,PUT,POST,DELETE");
        response.addHeader("Access-Control-Allow-Origin", "*");
        PrintWriter out = response.getWriter();
        final String message = "请登陆!";
        out.write(message);
        out.flush();
        out.close();
    }

}
