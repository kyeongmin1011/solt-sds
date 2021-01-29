package com.safetyas.sds.client.api.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"멤버 정보, 제품 공급자"})
@RestController
@RequestMapping(value = "/member")
@RequiredArgsConstructor
public class MemberController {

}
