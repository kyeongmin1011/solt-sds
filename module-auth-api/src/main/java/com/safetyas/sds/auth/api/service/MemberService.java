package com.safetyas.sds.auth.api.service;

import com.safetyas.sds.auth.api.dto.LoginResponse;
import com.safetyas.sds.auth.api.dto.MemberSummary;
import com.safetyas.sds.auth.api.dto.Token;
import com.safetyas.sds.auth.api.entity.Member;
import com.safetyas.sds.auth.api.repository.MemberRepository;
import com.safetyas.sds.auth.api.request.LoginRequest;
import com.safetyas.sds.auth.api.util.CookieUtil;
import com.safetyas.sds.auth.config.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
  private final MemberRepository memberRepository;
  private final TokenProvider tokenProvider;
  private final CookieUtil cookieUtil;

  public ResponseEntity<LoginResponse> login(LoginRequest loginRequest, String accessToken, String refreshToken) {
    String id = loginRequest.getId();
    Member member = memberRepository.findByMemberId(id).orElseThrow(() -> new IllegalArgumentException("Member not found with id " + id));

    Boolean accessTokenValid = tokenProvider.validateToken(accessToken);
    Boolean refreshTokenValid = tokenProvider.validateToken(refreshToken);

    HttpHeaders responseHeaders = new HttpHeaders();
    Token newAccessToken;
    Token newRefreshToken;
    if (!accessTokenValid && !refreshTokenValid) {
      newAccessToken = tokenProvider.generateAccessToken(member.getMemberId());
      newRefreshToken = tokenProvider.generateRefreshToken(member.getMemberId());
      addAccessTokenCookie(responseHeaders, newAccessToken);
      addRefreshTokenCookie(responseHeaders, newRefreshToken);
    }

    if (!accessTokenValid && refreshTokenValid) {
      newAccessToken = tokenProvider.generateAccessToken(member.getMemberId());
      addAccessTokenCookie(responseHeaders, newAccessToken);
    }

    if (accessTokenValid && refreshTokenValid) {
      newAccessToken = tokenProvider.generateAccessToken(member.getMemberId());
      newRefreshToken = tokenProvider.generateRefreshToken(member.getMemberId());
      addAccessTokenCookie(responseHeaders, newAccessToken);
      addRefreshTokenCookie(responseHeaders, newRefreshToken);
    }

    LoginResponse loginResponse = new LoginResponse(LoginResponse.SuccessFailure.SUCCESS, "Auth successful. Tokens are created in cookie.");
    return ResponseEntity.ok().headers(responseHeaders).body(loginResponse);

  }

  public ResponseEntity<LoginResponse> refresh(String accessToken, String refreshToken) {
    Boolean refreshTokenValid = tokenProvider.validateToken(refreshToken);
    if (!refreshTokenValid) {
      throw new IllegalArgumentException("Refresh Token is invalid!");
    }

    String memberId = tokenProvider.getUsernameFromToken(accessToken);

    Token newAccessToken = tokenProvider.generateAccessToken(memberId);
    HttpHeaders responseHeaders = new HttpHeaders();
    responseHeaders.add(HttpHeaders.SET_COOKIE, cookieUtil.createAccessTokenCookie(newAccessToken.getTokenValue(), newAccessToken.getDuration()).toString());

    LoginResponse loginResponse = new LoginResponse(LoginResponse.SuccessFailure.SUCCESS, "Auth successful. Tokens are created in cookie.");
    return ResponseEntity.ok().headers(responseHeaders).body(loginResponse);
  }

  public MemberSummary getUserProfile() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();

    Member member = memberRepository.findByMemberId(customUserDetails.getUsername()).orElseThrow(() -> new IllegalArgumentException("User not found with email " + customUserDetails.getUsername()));
    return member.toMemberSummary();
  }

  private void addAccessTokenCookie(HttpHeaders httpHeaders, Token token) {
    httpHeaders.add(HttpHeaders.SET_COOKIE, cookieUtil.createAccessTokenCookie(token.getTokenValue(), token.getDuration()).toString());
  }

  private void addRefreshTokenCookie(HttpHeaders httpHeaders, Token token) {
    httpHeaders.add(HttpHeaders.SET_COOKIE, cookieUtil.createRefreshTokenCookie(token.getTokenValue(), token.getDuration()).toString());
  }
}
