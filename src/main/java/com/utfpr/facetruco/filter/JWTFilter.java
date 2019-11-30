package com.utfpr.facetruco.filter;

import com.utfpr.facetruco.util.JWTUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.SignatureException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JWTFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) 
        throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        if( 
            req.getRequestURI().startsWith("/login") || 
            req.getRequestURI().startsWith("/usuarios") &&
            req.getMethod().equals("POST")
        ){
            filterChain.doFilter(request, response);
            return;
        }

        String token = req.getHeader(JWTUtil.TOKEN_HEADER);

        if(token == null || token.trim().isEmpty()){
            res.setStatus(401);
            return;
        }

        try {
            Jws<Claims> parser = JWTUtil.decode(token);
            System.out.println("User request: "+ parser.getBody().getSubject());
            filterChain.doFilter(request, response);
        } catch (SignatureException e) {
            res.setStatus(401);
        }

    }

    @Override
    public void destroy() {}
}