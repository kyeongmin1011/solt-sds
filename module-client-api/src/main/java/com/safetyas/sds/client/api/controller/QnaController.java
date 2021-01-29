package com.safetyas.sds.client.api.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"자주묻는질문"})
@RestController
@RequestMapping(value = "/qna")
@RequiredArgsConstructor
public class QnaController {

}
