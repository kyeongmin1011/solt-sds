package com.safetyas.sds.admin.config.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Base64;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {
  @Value("${spring.jwt.secret}")
  private String secretKey;

  private final UserDetailsService userDetailsService;

  @PostConstruct
  protected void init() {
    secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
  }

  /**
   * Jwt 토큰 생성
   *
   * @param useKey String
   * @return 토큰
   */
  public String createToken(String useKey) {
    Claims claims = Jwts.claims().setSubject(useKey);
    claims.put("role", "USER");
    // TODO: 토큰 claims 에 필요한 CustomUserDetail 값 더 넣어줌.
    Date now = new Date();
    // 24시간 유효
    long tokenValidMilisecond = 1000L * 60 * 60 * 24;
    return Jwts.builder()
        .setClaims(claims) // 데이터
        .setIssuedAt(now) // 발행일자
        .setExpiration(new Date(now.getTime() + tokenValidMilisecond)) // set Expire Time
        .signWith(SignatureAlgorithm.HS256, secretKey) // 암호화 알고리즘, secret값 세팅
        .compact();
  }

  /**
   * 토큰으로 인증 정보를 조회
   *
   * @param token 토큰
   * @return Authentication
   */
  public Authentication getAuthentication(String token) {
    UserDetails userDetails = userDetailsService.loadUserByUsername(this.getUserUseKey(token));
    return new UsernamePasswordAuthenticationToken(userDetails, "USER", userDetails.getAuthorities());
  }

  /**
   * 토큰 인증되면 useKey 시큐리티에 세팅
   *
   * @param token 토큰
   * @return Authentication
   */
  public Authentication getTokenAuthentication(String token) {
/*    String useKey = getUserUseKey(token);
    UseMember useMember = UseMember.builder().useKey(useKey).role("USER").build();
    UserDetails user = new CustomUserDetails(useMember);
    return new UsernamePasswordAuthenticationToken(user,"USER", user.getAuthorities());*/
    //TODO: 멤버 정보 토큰 반환
    return null;
  }

  /**
   * 토큰에서 회원 구별 정보 추출
   *
   * @param token 토큰
   * @return useKey
   */
  public String getUserUseKey(String token) {
    return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
  }

  /**
   * Request의 Header에서 토큰 파싱 : "X-AUTH-TOKEN: jwt토큰"
   *
   * @param req HttpServletRequest
   * @return token
   */
  public String resolveToken(HttpServletRequest req) {
    return req.getHeader("X-AUTH-TOKEN");
  }

  /**
   * Jwt 토큰 유효성, 만료일자 체크
   *
   * @param jwtToken String
   * @return boolean
   */
  public boolean validateToken(String jwtToken) {
    try {
      Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwtToken);
      return !claims.getBody().getExpiration().before(new Date());
    } catch (Exception e) {
      return false;
    }
  }
}
