package com.safetyas.sds.client.api.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"유해물질 무료 서비스"})
@RestController
@RequestMapping(value = "/sds-api")
@RequiredArgsConstructor
public class HazardIdentificationController {

}
