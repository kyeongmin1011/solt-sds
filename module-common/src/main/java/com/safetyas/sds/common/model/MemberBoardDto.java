package com.safetyas.sds.common.model;

import com.safetyas.sds.common.entity.Member;
import com.safetyas.sds.common.entity.MemberBoard;
import com.safetyas.sds.common.entity.MemberBoardComment;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberBoardDto {

  private Long memberBoardSeq;
  private String category;
  private String title;
  private String writer;
  private String writerEmail;
  private String content;
  private Integer viewCount;
  private Member member;
  private List<MemberBoardComment> memberBoardCommentList = new ArrayList<>();

  public MemberBoard toEntity() {

    MemberBoard memberBoard = MemberBoard.builder()
        .category(this.category)
        .title(this.title)
        .writer(this.writer)
        .writerEmail(this.writerEmail)
        .content(this.content)
        .build();
    return memberBoard;
  }
}
