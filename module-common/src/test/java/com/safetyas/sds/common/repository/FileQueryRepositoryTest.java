package com.safetyas.sds.common.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.safetyas.sds.common.dto.FileDTO;
import com.safetyas.sds.common.entity.File;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class FileQueryRepositoryTest {

  @Autowired
  FileQueryRepository fileQueryRepository;
  @Autowired
  FileRepository fileRepository;

  @Test
  void testFileQuery() {
    //given
    File file = File.builder()
        .relateTable("table3")
        .recordSeq((long)3)
        .type("type3")
        .name("name3")
        .oriName("originName3")
        .build();
    fileRepository.save(file);
    //when
    FileDTO fileDTO = FileDTO.builder()
        .relateTable("table3")
        .recordSeq((long)3)
        .type("type3")
        .name("name3")
        .oriName("originName3")
        .build();
    File result = fileQueryRepository.selectCompanyCertificate(fileDTO);
    //then
    System.out.println(result.getOriName());
    assertThat(result.getOriName()).isEqualTo(file.getOriName());

  }

}