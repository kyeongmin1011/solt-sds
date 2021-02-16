package com.safetyas.sds.client.config.security;

import io.jsonwebtoken.ExpiredJwtException;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

public class JwtAuthenticationFilter extends GenericFilterBean {
  private JwtTokenProvider jwtTokenProvider;

  // Jwt Provider 주입
  public JwtAuthenticationFilter(JwtTokenProvider jwtTokenProvider) {
    this.jwtTokenProvider = jwtTokenProvider;
  }

  // Request로 들어오는 Jwt Token의 유효성을 검증(jwtTokenProvider.validateToken)하는 filter를 filterChain에 등록합니다.
  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
    String token = jwtTokenProvider.resolveToken((HttpServletRequest) request);
    if (token != null && jwtTokenProvider.validateToken(token)) {
      //유효한 토큰에서 정보추출해서 시큐리티 userDetail 넣어주는 로직
      Authentication auth = jwtTokenProvider.getTokenAuthentication(token);
      SecurityContextHolder.getContext().setAuthentication(auth);

      /*디비에서 useKey 검증해서 시큐리티에 userDetail 넣어주는 로직
      Authentication auth = jwtTokenProvider.getAuthentication(token);
      SecurityContextHolder.getContext().setAuthentication(auth);
      */
    }
    filterChain.doFilter(request, response);
  }

  private void allowForRefreshToken(ExpiredJwtException ex, HttpServletRequest request) {
    //
  }
}
