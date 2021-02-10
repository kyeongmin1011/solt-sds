package com.safetyas.sds.client.api.controller;

import com.safetyas.sds.client.api.exception.CustomUserNotFoundException;
import com.safetyas.sds.client.api.request.MemberInfoRequest;
import com.safetyas.sds.client.api.response.CommonResult;
import com.safetyas.sds.client.api.response.ResponseService;
import com.safetyas.sds.client.api.response.SingleResult;
import com.safetyas.sds.client.api.service.ClientMemberService;
import com.safetyas.sds.client.config.security.CustomUserDetailService;
import com.safetyas.sds.client.config.security.JwtTokenProvider;
import com.safetyas.sds.common.entity.Member;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Api(tags = {"회원가입, 로그인, 로그아웃 "})
@RestController
@RequestMapping(value = "/sign")
@RequiredArgsConstructor
public class SignController {

  private final ResponseService responseService;
  private final PasswordEncoder passwordEncoder;
  private final ClientMemberService clientMemberService;


  private final JwtTokenProvider jwtTokenProvider;
  private final CustomUserDetailService userDetailService;

  @ApiOperation(value = "회원가입", notes = "회원가입 한다.")
  @PostMapping(value = "/up")
  public CommonResult signIn(@RequestBody MemberInfoRequest memberInfoRequest, final MultipartHttpServletRequest multiRequest) {
    MultipartFile file = multiRequest.getFile("companyCertificate");
    clientMemberService.saveJoinMember(memberInfoRequest, file);
    // TODO: 사업자 등록증 파일 저장 처리

    return responseService.getSuccessResult();
  }

}
