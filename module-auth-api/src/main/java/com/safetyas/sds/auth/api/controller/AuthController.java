package com.safetyas.sds.auth.api.controller;

import com.safetyas.sds.auth.api.dto.LoginResponse;
import com.safetyas.sds.auth.api.request.LoginRequest;
import com.safetyas.sds.auth.api.response.ResponseService;
import com.safetyas.sds.auth.api.response.SingleResult;
import com.safetyas.sds.auth.api.service.MemberService;
import com.safetyas.sds.auth.api.util.SecurityCipher;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {" 인증 "})
@RestController
@RequestMapping(value = "/auth")
@RequiredArgsConstructor
public class AuthController {

  Logger log = LoggerFactory.getLogger(this.getClass());

  private final AuthenticationManager authenticationManager;
  private final ResponseService responseService;
  private final MemberService memberService;

  @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<LoginResponse> login(
      @CookieValue(name = "accessToken", required = false) String accessToken,
      @CookieValue(name = "refreshToken", required = false) String refreshToken,
      @RequestBody LoginRequest loginRequest
  ) {
    Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getId(), loginRequest.getPassword()));
    SecurityContextHolder.getContext().setAuthentication(authentication);

    String decryptedAccessToken = SecurityCipher.decrypt(accessToken);
    String decryptedRefreshToken = SecurityCipher.decrypt(refreshToken);
    return memberService.login(loginRequest, decryptedAccessToken, decryptedRefreshToken);
  }

  @PostMapping(value = "/refresh", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<LoginResponse> refreshToken(@CookieValue(name = "accessToken", required = false) String accessToken,
      @CookieValue(name = "refreshToken", required = false) String refreshToken) {
    String decryptedAccessToken = SecurityCipher.decrypt(accessToken);
    String decryptedRefreshToken = SecurityCipher.decrypt(refreshToken);
    return memberService.refresh(decryptedAccessToken, decryptedRefreshToken);
  }

}
