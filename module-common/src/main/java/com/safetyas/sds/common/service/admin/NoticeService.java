package com.safetyas.sds.common.service.admin;

import com.safetyas.sds.common.entity.Member;
import com.safetyas.sds.common.entity.Notice;
import com.safetyas.sds.common.model.NoticeDto;
import com.safetyas.sds.common.repository.MemberRepository;
import com.safetyas.sds.common.repository.admin.NoticeRepository;
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

  private final MemberRepository memberRepository;
  private final NoticeRepository noticeRepository;
  private final ModelMapper modelMapper;

  @Transactional
  public NoticeDto selectNotice(Long id) {
    return modelMapper.map(noticeRepository.findById(id).orElseThrow(NoSuchElementException::new),
        NoticeDto.class);
  }

  @Transactional
  public void insertNotice(Notice notice) {
    Member member = memberRepository.findById(1L).orElseThrow(NoSuchElementException::new);
    notice.updateMember(member);
    noticeRepository.save(notice);
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
