package com.safetyas.sds.common.service.client;

import com.safetyas.sds.common.dto.FileDTO;
import com.safetyas.sds.common.entity.File;
import com.safetyas.sds.common.repository.FileQueryRepository;
import com.safetyas.sds.common.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FileService {

  private final FileRepository fileRepository;
  private final FileQueryRepository fileQueryRepository;

  public void saveFile(FileDTO fileDTO) {
    fileRepository.save(fileDTO.toEntity());
  }

  public File selectCompanyCertificate(FileDTO fileDTO) {
    return fileQueryRepository.selectCompanyCertificate(fileDTO);
  }

  public void deleteFileData(File file) {
    fileRepository.delete(file);
  }
}
