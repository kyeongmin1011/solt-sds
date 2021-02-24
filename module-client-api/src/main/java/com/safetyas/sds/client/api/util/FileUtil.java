package com.safetyas.sds.client.api.util;

import com.safetyas.sds.common.model.FileDTO;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUtil {

  public static final int BUFF_SIZE = 2048;

  @Value("${spring.file.path}")
  private String fileStorePath;

  public String getFileStorePath() {
    return this.fileStorePath;
  }

  public FileDTO parseFile(MultipartFile file, Map<String, Object> info) {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
    String datePath = formatter.format(new Date());
    String storePathString = fileStorePath + (String) info.get("path") + File.separator + datePath;

    File saveFolder = new File(filePathBlackList(storePathString));
    if (!saveFolder.exists() || saveFolder.isFile()) {
      saveFolder.mkdirs();
    }

    String originFileName = file.getOriginalFilename();
    int index = originFileName.lastIndexOf(".");
    String fileExt = originFileName.substring(index + 1);
    String newName = getTimeStamp() + "." + fileExt;
    int size = (int) file.getSize();

    try {
      if (!"".equals(originFileName)) {
        String filePath = storePathString + File.separator + newName;
        file.transferTo(new File(filePathBlackList(filePath)));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    return FileDTO.builder()
        .relateTable((String) info.get("relateTable"))
        .recordSeq((long) info.get("recordSeq"))
        .type((String) info.get("type"))
        .path(storePathString)
        .name(newName)
        .size(size)
        .ext(fileExt)
        .oriName(originFileName)
        .regUserSeq((long) info.get("regUserSeq"))
        .build();
  }

  public List<FileDTO> parseFiles(Map<String, MultipartFile> files, Map<String, Object> info) {

    SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
    String datePath = formatter.format(new Date());
    String storePathString = fileStorePath + (String) info.get("path") + File.separator + datePath;

    File saveFolder = new File(filePathBlackList(storePathString));
    if (!saveFolder.exists() || saveFolder.isFile()) {
      saveFolder.mkdirs();
    }

    Iterator<Entry<String, MultipartFile>> itr = files.entrySet().iterator();
    MultipartFile file;
    String filePath = "";
    List<FileDTO> fileList = new ArrayList<>();

    int fileKey = 0;
    while (itr.hasNext()) {
      Entry<String, MultipartFile> entry = itr.next();
      file = entry.getValue();
      String originFileName = file.getOriginalFilename();

      if ("".equals(originFileName)) {
        continue;
      }

      int index = originFileName.lastIndexOf(".");
      String fileExt = originFileName.substring(index + 1);
      String newName = getTimeStamp() + "_" + fileKey + "." + fileExt;
      int fileSize = (int) file.getSize();

      if (!"".equals(originFileName)) {
        filePath = storePathString + File.separator + newName;

        try {
          file.transferTo(new File(filePathBlackList(filePath)));
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }

      fileKey++;

      FileDTO fileDTO = FileDTO.builder()
          .relateTable((String) info.get("relateTable"))
          .recordSeq((long) info.get("recordSeq"))
          .type((String) info.get("type"))
          .path(storePathString)
          .name(newName)
          .size(fileSize)
          .ext(fileExt)
          .oriName(originFileName)
          .regUserSeq((long) info.get("regUserSeq"))
          .build();
      fileList.add(fileDTO);
    }
    return fileList;
  }

  private static String getTimeStamp() {

    String rtnStr = null;

    // 문자열로 변환하기 위한 패턴 설정(년도-월-일 시:분:초:초(자정이후 초))
    String pattern = "yyyyMMddhhmmssSSS";

    SimpleDateFormat sdfCurrent = new SimpleDateFormat(pattern, Locale.KOREA);
    Timestamp ts = new Timestamp(System.currentTimeMillis());

    rtnStr = sdfCurrent.format(ts.getTime());

    return rtnStr;
  }

  private static String filePathBlackList(String value) {
    String returnValue = value;
    if (returnValue == null || returnValue.trim().equals("")) {
      return "";
    }

    returnValue = returnValue.replaceAll("\\.\\./", ""); // ../
    returnValue = returnValue.replaceAll("\\.\\.\\\\", ""); // ..\

    return returnValue;
  }

  public boolean deleteFile(String filePath, String name) {
    boolean flag = false;

    String path = filePath + File.separator + name;
    File file = new File(path);
    if (file.exists()) {
      flag = file.delete();
    }

    return flag;
  }

  public static boolean isEmpty(List<MultipartFile> multipartFileList) {
    boolean b = false;
    for (MultipartFile multipartFile : multipartFileList) {
      if (multipartFile.isEmpty()) {
        b = true;
      } else {
        b = false;
      }
    }
    return b;
  }
}
