package com.safetyas.sds.common.service.client;

import com.safetyas.sds.common.repository.FaqRepository;
import com.safetyas.sds.common.repository.MemberBoardRepository;
import com.safetyas.sds.common.repository.MemberQueryRepository;
import com.safetyas.sds.common.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MainService {

  private final NoticeRepository noticeRepository;
  private final FaqRepository faqRepository;
  private final MemberBoardRepository memberBoardRepository;
  private final MemberQueryRepository memberQueryRepository;

  public void selectClientMain() {

    noticeRepository.findTop5ByOrderByNoticeSeqDesc();
    faqRepository.findTop5ByOrderByFaqSeqDesc();
    memberBoardRepository.selectClientMainMemberBoardList(1L);
    memberQueryRepository.selectClientMainMemberInfo(1L);
  }
}
