package com.newland.security.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 认证拦截
 */
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    @Autowired
    @Qualifier("userDetailService")
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
//        String authHeader = httpServletRequest.getHeader(JwtTokenUtil.TOKEN_HEADER);
//        if (!StringUtils.isEmpty(authHeader) && authHeader.startsWith(JwtTokenUtil.TOKEN_PREFIX)) {
//            String authToken = authHeader.substring(JwtTokenUtil.TOKEN_PREFIX.length());
//            String username = JwtTokenUtil.getUserNmae(authToken);
//            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//                if (JwtTokenUtil.veryfy(authToken, username)) {
//                    UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
//                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//                }
//            }
//        }
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }
}
