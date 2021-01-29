package com.safetyas.sds.client.api.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"1:1 게시판"})
@RestController
@RequestMapping(value = "/member-board")
@RequiredArgsConstructor
public class MemberBoardController {

}
