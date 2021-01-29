package com.safetyas.sds.client.api.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"제품 리스트, 검색, 입력, 수정"})
@RestController
@RequestMapping(value = "/product")
@RequiredArgsConstructor
public class ProductController {

}
