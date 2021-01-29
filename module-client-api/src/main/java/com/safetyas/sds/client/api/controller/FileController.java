package com.safetyas.sds.client.api.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"파일 관리"})
@RestController
@RequestMapping(value = "/file")
@RequiredArgsConstructor
public class FileController {

}
