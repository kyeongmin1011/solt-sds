package com.safetyas.sds.auth.api.controller;

import com.safetyas.sds.auth.api.dto.AuthDTO;
import com.safetyas.sds.auth.api.dto.MemberClientDTO;
import com.safetyas.sds.auth.api.exception.CustomUserNotFoundException;
import com.safetyas.sds.auth.api.request.AuthenticationRequest;
import com.safetyas.sds.auth.api.response.CommonResult;
import com.safetyas.sds.auth.api.response.ResponseService;
import com.safetyas.sds.auth.config.security.CustomUserDetailService;
import com.safetyas.sds.auth.config.security.CustomUserDetails;
import com.safetyas.sds.auth.config.security.JwtTokenProvider;
import io.jsonwebtoken.impl.DefaultClaims;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
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
  private final CustomUserDetailService customUserDetailService;
  private final JwtTokenProvider jwtTokenProvider;
  private final ResponseService responseService;

  @ApiOperation(value = "인증후 토큰발급")
  @PostMapping(value = "/authenticate")
  public CommonResult createAuthenticationToken
      (@RequestBody AuthenticationRequest authenticationRequest) {
    try {
      authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(
              authenticationRequest.getUsername(), authenticationRequest.getPassword()));
    } catch (DisabledException | BadCredentialsException e) {
      throw new CustomUserNotFoundException();
    }

    CustomUserDetails userDetails = (CustomUserDetails) customUserDetailService.loadUserByUsername(authenticationRequest.getUsername());
    String token = jwtTokenProvider.createToken(userDetails);
    return responseService.getSingleResult(new AuthDTO(token));
  }

  @ApiOperation(value = "회원가입 후 토큰발급")
  @PostMapping(value = "/register")
  public CommonResult saveMember(@RequestBody MemberClientDTO memberClientDTO) {

    //TODO: 클라이언트 입력값 받아서 입력 후 인증 토큰 발급.
    //
    CustomUserDetails userDetails = (CustomUserDetails) customUserDetailService.loadUserByUsername(memberClientDTO.getMemberId());
    String token = jwtTokenProvider.createToken(userDetails);
    return responseService.getSingleResult(new AuthDTO(token));
  }

  @GetMapping(value = "/refreshtoken")
  public CommonResult getRefreshToken(HttpServletRequest request) {
    DefaultClaims claims = (DefaultClaims) request.getAttribute("claims");

    Map<String, Object> expectedMap = getMapFromIoJWTClaims(claims);
    String token = jwtTokenProvider.createRefreshToken(expectedMap, expectedMap.get("sub").toString());
    return responseService.getSingleResult(new AuthDTO(token));
  }

  public Map<String, Object> getMapFromIoJWTClaims(DefaultClaims claims) {
    Map<String, Object> expectedMap = new HashMap<>();
    for (Entry<String, Object> entry : claims.entrySet()) {
      expectedMap.put(entry.getKey(), entry.getValue());
    }
    return expectedMap;
  }

}
