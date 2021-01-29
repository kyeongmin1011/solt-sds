package com.safetyas.sds.admin.api.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"1. 회원 로그인 "})
@RestController
@RequestMapping(value = "/sign-in")
@RequiredArgsConstructor
public class SignInController {

}
