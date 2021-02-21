package com.safetyas.sds.client.api.controller;

import com.safetyas.sds.client.api.request.MemberInfoRequest;
import com.safetyas.sds.client.api.response.CommonResult;
import com.safetyas.sds.client.api.response.ResponseService;
import com.safetyas.sds.client.api.service.ClientMemberService;
import com.safetyas.sds.common.dto.MemberInfoDTO;
import com.safetyas.sds.common.dto.MemberSupplierDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"멤버 정보, 제품 공급자"})
@RestController
@RequestMapping(value = "/member")
@RequiredArgsConstructor
public class MemberController {

  private final ResponseService responseService;
  private final ClientMemberService clientMemberService;

  @ApiOperation(value = "멤버정보", notes = "멤버 정보 가져오기")
  @GetMapping(value = "/info/{id}")
  public CommonResult selectMemberInfo(@PathVariable String id) {
    //testid1: dGVzdGlkMQ==
    MemberInfoDTO memberInfoDTO = clientMemberService.selectMemberInfo(id);
    return responseService.getSingleResult(memberInfoDTO);
  }

  @ApiOperation(value = "멤버정보 수정", notes = "멤버 정보 수정한다.")
  @PutMapping(value = "/update-member-info")
  public CommonResult updateMemberInfo(MemberInfoRequest memberInfoRequest) {
    clientMemberService.updateMemberInfo(memberInfoRequest);

    return responseService.getSuccessResult();
  }

  @ApiOperation(value = "멤버 공급자 리스트", notes = "멤버 공급자 리스트를 가져온다.")
  @GetMapping(value = "/suppliers")
  public CommonResult selectMemberSuppliers() {
    Long memberSeq = 1L;
    return responseService.getListResult(clientMemberService.selectMemberSuppliers(memberSeq));
  }

  @ApiOperation(value = "멤버 공급자 입력", notes = "새로운 멤버 공급자 입력한다.")
  @PostMapping(value = "/supplier-save")
  public CommonResult insertMemberSupplier(MemberSupplierDTO memberSupplierDTO) {
    Long memberSeq = 1L;
    clientMemberService.saveMemberSupplier(memberSupplierDTO, memberSeq);
    return responseService.getSuccessResult();
  }

  @ApiOperation(value = "멤버 공급자 수정", notes = "새로운 멤버 공급자 수정 입력한다.")
  @PostMapping(value = "/supplier-update")
  public CommonResult updateMemberSupplier(MemberSupplierDTO memberSupplierDTO) {
    clientMemberService.updateMemberSupplier(memberSupplierDTO);
    return responseService.getSuccessResult();
  }

  @ApiOperation(value = "멤버 공급자 삭제",
      notes = "제품을 가진 멤버 공급자인지 확인 후 삭제한다. 제품을 가질경우 삭제 불가.")
  @GetMapping(value = "/supplier-del/{seq}")
  public CommonResult deleteMemberSupplier(@PathVariable Long seq) {
    boolean deleted = clientMemberService.deleteMemberSupplier(seq);
    if (deleted) {
      return responseService.getSuccessResult();
    } else {
      return responseService.getFailResult(-1,
          "공급하는 제품이 존재하여 삭제 할 수 없습니다. 제품 삭제 후 가능합니다.");
    }
  }

}
