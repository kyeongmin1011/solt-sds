package com.safetyas.sds.common.service.admin;

import com.safetyas.sds.common.entity.Notice;
import com.safetyas.sds.common.model.NoticeDto;
import com.safetyas.sds.common.repository.admin.NoticeRepository;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class NoticeService {

  private final NoticeRepository noticeRepository;
  private final ModelMapper modelMapper;

  @Transactional
  public NoticeDto selectNotice(Long id) {
    return modelMapper.map(noticeRepository.findById(id).orElseThrow(NoSuchElementException::new),
        NoticeDto.class);
  }

  @Transactional
  public void insertNotice(NoticeDto noticeDto) {
    noticeRepository.save(noticeDto.toEntity());
  }

  @Transactional
  public void updateNotice(Long id, NoticeDto noticeDto) {
    Notice notice = noticeRepository.findById(id).orElseThrow(NoSuchElementException::new);
    notice.updateNotice(noticeDto);
    noticeRepository.save(notice);
  }

  @Transactional
  public void deleteNotice(Long id) {
    Notice notice = noticeRepository.findById(id).orElseThrow(NoSuchElementException::new);
    notice.updateDelDate();
    noticeRepository.save(notice);
  }
}
