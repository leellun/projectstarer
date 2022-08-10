package com.newland.security.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 访问拒绝处理，未认证 或认证失败
 */
@Slf4j
public class ManagerAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        final String message = "未认证，请在前端系统进行认证";
        response.setContentType("application/json;charset=utf-8");
        response.addHeader("Access-Control-Allow-Methods", "GET,HEAD,PUT,POST,DELETE");
        response.addHeader("Access-Control-Allow-Origin", "*");
        try (PrintWriter out = response.getWriter()) {
            out.write(message);
            out.flush();
        } catch (IOException e) {
            log.error("sendChallenge error：", e);
        }
    }

}