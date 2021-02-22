package com.safetyas.sds.common.model;

import com.safetyas.sds.common.entity.MemberBoardComment;
import java.io.Serializable;
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
public class MemberBoardCommentDTO implements Serializable {

  private static final long serialVersionUID = -4890172477028801391L;
  private Long commentSeq;
  private String category;
  private String title;
  private String writerName;
  private String writerEmail;
  private String content;
  private Integer viewCount;

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
