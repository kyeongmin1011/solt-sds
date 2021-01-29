package com.safetyas.sds.client.api.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"PDF"})
@RestController
@RequestMapping(value = "/pdf")
@RequiredArgsConstructor
public class PdfController {

}
