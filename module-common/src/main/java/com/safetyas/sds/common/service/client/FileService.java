package com.safetyas.sds.common.service.client;

import com.safetyas.sds.common.dto.FileDTO;
import com.safetyas.sds.common.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FileService {

  private final FileRepository fileRepository;

  public void saveFile(FileDTO fileDTO) {
    fileRepository.save(fileDTO.toEntity());
  }

}
