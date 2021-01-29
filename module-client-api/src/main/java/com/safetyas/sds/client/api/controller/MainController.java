package com.safetyas.sds.client.api.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"SDS Main  메인"})
@RestController
@RequestMapping(value = "/sds-api")
@RequiredArgsConstructor
public class MainController {

}
