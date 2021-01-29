package com.safetyas.sds.client.api.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"물질 오픈소스 데이터 검색 리스팅"})
@RestController
@RequestMapping(value = "/matter-sas-library")
@RequiredArgsConstructor
public class MatterOpenSourceController {

}
