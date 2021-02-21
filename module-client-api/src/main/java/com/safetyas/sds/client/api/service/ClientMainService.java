package com.safetyas.sds.client.api.service;

import com.safetyas.sds.common.model.ClientMainMyPageDTO;
import com.safetyas.sds.common.model.FaqDTO;
import com.safetyas.sds.common.model.MemberBoardDTO;
import com.safetyas.sds.common.model.NoticeDTO;
import com.safetyas.sds.common.service.client.MainService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientMainService {

  private final MainService mainService;

  public List<NoticeDTO> selectClientMainNoticeList() {
    return mainService.selectClientMainNoticeList();
  }

  public List<FaqDTO> selectClientMainFaqList() {
    return mainService.selectClientMainFaqList();
  }

  public List<MemberBoardDTO> selectClientMainMemberBoardList(){
    return mainService.selectClientMainMemberBoardList();
  }

  public ClientMainMyPageDTO selectClientMainMemberInfo(){
    return mainService.selectClientMainMemberInfo();
  }
}
