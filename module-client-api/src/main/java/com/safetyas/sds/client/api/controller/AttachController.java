package com.safetyas.sds.client.api.controller;

import com.safetyas.sds.client.api.util.ResourceCloseHelper;
import com.safetyas.sds.common.model.FileDTO;
import com.safetyas.sds.common.repository.FileQueryRepository;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/attach")
public class AttachController {

  private final FileQueryRepository fileQueryRepository;
  private final ModelMapper modelMapper;

  /**
   * 첨부파일로 등록된 파일에 대하여 다운로드를 제공한다.
   */
  @RequestMapping(value = "/download")
  public void downloadAttach(@ModelAttribute("attachVO") FileDTO fileDTO,
      HttpServletRequest request, HttpServletResponse response) throws Exception {
    // input 검증

    response.setContentType("application/x-msdownload");

    fileDTO = modelMapper.map(fileQueryRepository.selectFileByFileDTO(fileDTO), FileDTO.class);

    File uFile = new File(fileDTO.getPath(), fileDTO.getName());
    long fSize = uFile.length();

    if (fSize > 0) {
      String mimetype = "application/x-msdownload";
      if (fileDTO.getExt().toLowerCase().equals("xml")) {
        mimetype = "application/xml";
      }

      response.setContentType(mimetype);
      setDisposition(fileDTO.getOriName(), request, response, false);

      /*
       * FileCopyUtils.copy(in, response.getOutputStream());
       * in.close();
       * response.getOutputStream().flush();
       * response.getOutputStream().close();
       */
      BufferedInputStream in = null;
      BufferedOutputStream out = null;

      try {
        in = new BufferedInputStream(new FileInputStream(uFile));
        out = new BufferedOutputStream(response.getOutputStream());

        FileCopyUtils.copy(in, out);
        out.flush();
      } catch (IOException ex) {
        // 다음 Exception 무시 처리
        // Connection reset by peer: socket write error
        //EgovBasicLogger.ignore("IO Exception", ex);
      } finally {
        ResourceCloseHelper.close(in, out);
      }

    } else {
      response.setContentType("application/x-msdownload");
    }
  }

  /**
   * Disposition 지정하기.
   *
   * @param filename
   * @param request
   * @param response
   * @throws Exception
   */
  private void setDisposition(String filename, HttpServletRequest request,
      HttpServletResponse response, boolean isImage) throws Exception {
    String browser = getBrowser(request);

    String dispositionPrefix = isImage ? "filename=" : "attachment; filename=";
    String encodedFilename = null;

    if (browser.equals("MSIE")) {
      encodedFilename = URLEncoder.encode(filename, "UTF-8").replaceAll("\\+", "%20");
    } else if (browser.equals("Trident")) { // IE11 문자열 깨짐 방지
      encodedFilename = URLEncoder.encode(filename, "UTF-8").replaceAll("\\+", "%20");
    } else if (browser.equals("Firefox")) {
      encodedFilename = "\"" + new String(filename.getBytes("UTF-8"), "8859_1") + "\"";
    } else if (browser.equals("Opera")) {
      encodedFilename = "\"" + new String(filename.getBytes("UTF-8"), "8859_1") + "\"";
    } else if (browser.equals("Chrome")) {
      StringBuffer sb = new StringBuffer();
      for (int i = 0; i < filename.length(); i++) {
        char c = filename.charAt(i);
        if (c > '~') {
          sb.append(URLEncoder.encode("" + c, "UTF-8"));
        } else {
          sb.append(c);
        }
      }
      encodedFilename = "\"" + new String(sb.toString().getBytes("UTF-8"), "8859_1") + "\"";
    } else {
      throw new IOException("Not supported browser");
    }

    response.setHeader("Content-Disposition", dispositionPrefix + encodedFilename);

    if (!isImage && "Opera".equals(browser)) {
      response.setContentType("application/octet-stream;charset=UTF-8");
    }
  }

  /**
   * 브라우저 구분 얻기.
   *
   * @param request
   * @return
   */
  private String getBrowser(HttpServletRequest request) {
    String header = request.getHeader("User-Agent");
    if (header.indexOf("MSIE") > -1) {
      return "MSIE";
    } else if (header.indexOf("Trident") > -1) { // IE11 문자열 깨짐 방지
      return "Trident";
    } else if (header.indexOf("Chrome") > -1) {
      return "Chrome";
    } else if (header.indexOf("Opera") > -1) {
      return "Opera";
    }
    return "Firefox";
  }
}
