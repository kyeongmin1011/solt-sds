package com.safetyas.sds.client.api.controller;

import com.safetyas.sds.client.api.request.MemberInfoRequest;
import com.safetyas.sds.client.api.response.CommonResult;
import com.safetyas.sds.client.api.response.ResponseService;
import com.safetyas.sds.client.api.service.ClientMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Api(tags = {"회원가입, 로그인, 로그아웃 "})
@RestController
@RequestMapping(value = "/sign")
@RequiredArgsConstructor
public class SignController {

  private final ResponseService responseService;
  private final ClientMemberService clientMemberService;

  @ApiOperation(value = "회원가입", notes = "회원가입 한다.")
  @PostMapping(value = "/up")
  public CommonResult signIn(MemberInfoRequest memberInfoRequest) {
    MultipartFile file = memberInfoRequest.getCompanyCertificate();
    System.out.println(file.getOriginalFilename());
    clientMemberService.saveJoinMember(memberInfoRequest, file);

    return responseService.getSuccessResult();
  }

}
