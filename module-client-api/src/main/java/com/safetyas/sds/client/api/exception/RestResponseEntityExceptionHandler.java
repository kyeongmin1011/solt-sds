package com.safetyas.sds.client.api.exception;

import com.safetyas.sds.client.api.response.CommonResult;
import com.safetyas.sds.client.api.response.ResponseService;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RequiredArgsConstructor
@RestControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

  private final ResponseService responseService;

  @ExceptionHandler(MaxUploadSizeExceededException.class)
  protected ResponseEntity<Object> handleConflict(
      RuntimeException ex, WebRequest request) {
    String bodyOfResponse = "파일크기는 10MB 를 넘을 수 없습니다";
    return handleExceptionInternal(ex, bodyOfResponse,
        new HttpHeaders(), HttpStatus.PAYLOAD_TOO_LARGE, request);
  }


  @ExceptionHandler(CustomUserNotFoundException.class)
  protected CommonResult userNotFoundException(RuntimeException ex, WebRequest request) {
    String bodyOfResponse = "사용자를 찾을 수 없습니다.";
    return responseService.getFailResult(401, bodyOfResponse);
  }

  @ExceptionHandler(NoSuchElementException.class)
  protected CommonResult customNoSuchElementException(RuntimeException ex, WebRequest request) {
    String bodyOfResponse = "NoSuchElementException (해당 요소를 찾을 수 없습니다.)";
    return responseService.getFailResult(403, bodyOfResponse);
  }

}
