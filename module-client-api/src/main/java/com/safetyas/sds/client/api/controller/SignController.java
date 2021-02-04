package com.safetyas.sds.client.api.controller;

import com.safetyas.sds.client.api.exception.CustomUserNotFoundException;
import com.safetyas.sds.client.api.response.ResponseService;
import com.safetyas.sds.client.api.response.SingleResult;
import com.safetyas.sds.client.api.service.ApiMemberService;
import com.safetyas.sds.client.config.security.JwtTokenProvider;
import com.safetyas.sds.common.entity.Member;
import com.safetyas.sds.common.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"회원가입, 로그인, 로그아웃 "})
@RestController
@RequestMapping(value = "/sign-in")
@RequiredArgsConstructor
public class SignController {

  private final ResponseService responseService;
  private final PasswordEncoder passwordEncoder;
  private final ApiMemberService apiMemberService;
  private final JwtTokenProvider jwtTokenProvider;

  @ApiOperation(value = "로그인", notes = "회원 아이디 로그인을 한다.")
  @PostMapping(value = "/sign-in")
  public SingleResult<String> signIn(@ApiParam(value = "회원ID", required = true) @RequestParam String memberId,
      @ApiParam(value = "비밀번호", required = true) @RequestParam String password) {

    Member member = apiMemberService.findByMemberId(memberId).orElseThrow(CustomUserNotFoundException::new);
    if (!passwordEncoder.matches(password, member.getPwd()))
      throw new CustomUserNotFoundException();

    return responseService.getSingleResult(jwtTokenProvider.createToken(String.valueOf(memberId), member.getRole()));
  }
}
