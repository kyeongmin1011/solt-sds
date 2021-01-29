package com.safetyas.sds.client.api.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"제품 물질 "})
@RestController
@RequestMapping(value = "/product-matter")
@RequiredArgsConstructor
public class ProductMatterController {

}
