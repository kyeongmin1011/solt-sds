package com.safetyas.sds.client.api.controller;

import com.safetyas.sds.client.api.request.MemberInfoRequest;
import com.safetyas.sds.client.api.response.CommonResult;
import com.safetyas.sds.client.api.response.ResponseService;
import com.safetyas.sds.client.api.service.ClientMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Api(tags = {"멤버 정보, 제품 공급자"})
@RestController
@RequestMapping(value = "/member")
@RequiredArgsConstructor
public class MemberController {

  private final ResponseService responseService;
  private final ClientMemberService clientMemberService;

  @ApiOperation(value = "멤버정보 수정", notes = "멤버 정보 수정한다.")
  @PostMapping(value = "/update-member-info")
  public CommonResult signIn(@RequestBody MemberInfoRequest memberInfoRequest, final MultipartHttpServletRequest multiRequest) {
    MultipartFile file = multiRequest.getFile("companyCertificate");
    clientMemberService.updateMemberInfo(memberInfoRequest, file);

    return responseService.getSuccessResult();
  }


}
