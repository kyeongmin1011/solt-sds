package com.safetyas.sds.client.api.service;

import com.safetyas.sds.client.api.util.FileUtil;
import com.safetyas.sds.common.entity.File;
import com.safetyas.sds.common.model.FileDTO;
import com.safetyas.sds.common.service.client.FileService;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Service
@RequiredArgsConstructor
public class ClientFileService {

  private final FileService fileService;
  private final FileUtil fileUtil;

  public void insertFile(MultipartHttpServletRequest multipartHttpServletRequest,
      Map<String, Object> infoMap) {

    Map<String, MultipartFile> attachMap = multipartHttpServletRequest
        .getFiles((String) infoMap.get("type"))
        .stream()
        .collect(Collectors.toMap(MultipartFile::getOriginalFilename, file -> file));

    List<File> fileList = fileUtil.parseFiles(attachMap, infoMap)
        .stream()
        .map(FileDTO::toEntity)
        .collect(Collectors.toList());

    fileService.saveFiles(fileList);
  }
}
