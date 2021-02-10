package com.safetyas.sds.auth.config.security;

import io.jsonwebtoken.ExpiredJwtException;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

public class JwtAuthenticationFilter extends GenericFilterBean {

  Logger log = LoggerFactory.getLogger(this.getClass());
  private final JwtTokenProvider jwtTokenProvider;

  // Jwt Provider 주입
  public JwtAuthenticationFilter(JwtTokenProvider jwtTokenProvider) {
    this.jwtTokenProvider = jwtTokenProvider;
  }

  // Request로 들어오는 Jwt Token의 유효성을 검증(jwtTokenProvider.validateToken)하는 filter를 filterChain에 등록합니다.
  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
    try {
      String token = jwtTokenProvider.resolveToken((HttpServletRequest) request);
      if (token != null && jwtTokenProvider.validateToken(token)) {
        //유효한 토큰에서 정보추출해서 시큐리티 userDetail 넣어주는 로직
        Authentication auth = jwtTokenProvider.getTokenAuthentication(token);
        SecurityContextHolder.getContext().setAuthentication(auth);
      } else {
        log.info("Cannot set the Security Context");
      }
    }catch(ExpiredJwtException ex){
      HttpServletRequest req = (HttpServletRequest)request;
      String isRefreshToken = req.getHeader("isRefreshToken");
      String requestURL =  req.getRequestURL().toString();
      // allow for Refresh Token creation if following conditions are true.
      if (isRefreshToken != null && isRefreshToken.equals("true") && requestURL.contains("refresh-token")) {
        allowForRefreshToken(ex, req);
      } else
        request.setAttribute("exception", ex);
    }
    filterChain.doFilter(request, response);
  }

  private void allowForRefreshToken(ExpiredJwtException ex, HttpServletRequest request) {
    // create a UsernamePasswordAuthenticationToken with null values.
    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
        null, null, null);
    // After setting the Authentication in the context, we specify
    // that the current user is authenticated. So it passes the
    // Spring Security Configurations successfully.
    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
    // Set the claims so that in controller we will be using it to create
    // new JWT
    request.setAttribute("claims", ex.getClaims());
  }
}
