package com.safetyas.sds.common.service.client;

import com.safetyas.sds.common.model.ClientMainMyPageDTO;
import com.safetyas.sds.common.model.FaqDTO;
import com.safetyas.sds.common.model.MemberBoardDTO;
import com.safetyas.sds.common.model.NoticeDTO;
import com.safetyas.sds.common.repository.FaqRepository;
import com.safetyas.sds.common.repository.MemberBoardRepository;
import com.safetyas.sds.common.repository.MemberQueryRepository;
import com.safetyas.sds.common.repository.NoticeRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MainService {

  private final NoticeRepository noticeRepository;
  private final FaqRepository faqRepository;
  private final MemberBoardRepository memberBoardRepository;
  private final MemberQueryRepository memberQueryRepository;
  private final ModelMapper modelMapper;

  public List<NoticeDTO> selectClientMainNoticeList() {
    return modelMapper.map(noticeRepository.findTop5ByOrderByNoticeSeqDesc(), new TypeToken<List<NoticeDTO>>() {}.getType());
  }

  public List<FaqDTO> selectClientMainFaqList(){
    return modelMapper.map(faqRepository.findTop5ByOrderByFaqSeqDesc(), new TypeToken<List<FaqDTO>>() {}.getType());
  }

  public List<MemberBoardDTO> selectClientMainMemberBoardList(){
    return modelMapper.map(memberBoardRepository.selectClientMainMemberBoardList(1L), new TypeToken<List<MemberBoardDTO>>() {}.getType());
  }

  public ClientMainMyPageDTO selectClientMainMemberInfo(){
    return memberQueryRepository.selectClientMainMemberInfo(1L);
  }
}
