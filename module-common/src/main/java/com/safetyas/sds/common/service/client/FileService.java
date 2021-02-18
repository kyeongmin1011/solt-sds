package com.safetyas.sds.common.service.client;

import com.safetyas.sds.common.dto.FileDTO;
import com.safetyas.sds.common.entity.File;
import com.safetyas.sds.common.repository.FileQueryRepository;
import com.safetyas.sds.common.repository.FileRepository;
import java.util.List;
import java.util.NoSuchElementException;
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

  public void saveFile(File file) {
    fileRepository.save(file);
  }

  public void saveFiles(List<File> fileList) {
    fileRepository.saveAll(fileList);
  }

  public File selectFileByFileDTO(FileDTO fileDTO) {
    return fileQueryRepository.selectCompanyCertificate(fileDTO);
  }

  public void deleteFileData(File file) {
    fileRepository.delete(file);
  }
  public List<FileDTO> selectFileList(Long id, String relateTable) {
    return fileQueryRepository.selectFileList(id, relateTable);
  }

  public File selectFile(Long fileSeq) {
    return fileRepository.findById(fileSeq).orElseThrow(NoSuchElementException::new);
  }
}
