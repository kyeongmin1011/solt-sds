package com.safetyas.sds.common.model;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ClientMainDTO {

  List<NoticeDTO> NoticeList1 = new ArrayList<>();
  List<MemberBoardDTO> memberBoardList = new ArrayList<>();
  List<FaqDTO> faqList = new ArrayList<>();
}
