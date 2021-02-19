package com.safetyas.sds.common.model;

import java.time.LocalDateTime;
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
public class MemberDTO {

  private Long memberSeq;
  private Integer level;
  private String role;
  private String memberId;
  private String pwd;
  private String token;
  private LocalDateTime loginLast;
  private Integer loginCount;
  //private MemberInfoDto memberInfo; // 고객 정보
  //private AdminInfoDto adminInfo; // 관리자 정보
  //private List<MemberSupplierDto> memberSupplierList = new ArrayList<>();
  private List<MemberBoardDTO> memberBoardList = new ArrayList<>();
  private List<MemberBoardCommentDTO> memberBoardCommentList = new ArrayList<>();
}
