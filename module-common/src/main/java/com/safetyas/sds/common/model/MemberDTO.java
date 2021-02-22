package com.safetyas.sds.common.model;

import java.io.Serializable;
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
public class MemberDTO implements Serializable {

  private static final long serialVersionUID = -9050711445853488362L;

  private Long memberSeq;
  private Integer level;
  private String role;
  private String memberId;
  private String pwd;
  private String token;
  private LocalDateTime loginLast;
  private Integer loginCount;
  private MemberInfoDTO memberInfo; // 고객 정보
  private List<MemberSupplierDTO> memberSupplierList = new ArrayList<>();
  private List<MemberBoardDTO> memberBoardList = new ArrayList<>();
  private List<MemberBoardCommentDTO> memberBoardCommentList = new ArrayList<>();
}
