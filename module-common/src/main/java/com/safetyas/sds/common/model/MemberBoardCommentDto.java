package com.safetyas.sds.common.model;

import com.safetyas.sds.common.entity.MemberBoardComment;
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
public class MemberBoardCommentDto {

  private Long commentSeq;
  private String category;
  private String title;
  private String writerName;
  private String writerEmail;
  private String content;
  private Integer viewCount;
  private MemberDto member;
  private MemberBoardDto memberBoard;

  public MemberBoardComment toEntity() {
    return MemberBoardComment.builder()
        .category(this.category)
        .title(this.title)
        .writerName(this.writerName)
        .writerEmail(this.writerEmail)
        .content(this.content)
        .build();
  }
}
