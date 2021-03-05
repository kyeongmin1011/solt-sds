package com.safetyas.sds.common.model;

import com.querydsl.core.annotations.QueryProjection;
import com.safetyas.sds.common.entity.MemberBoard;
import java.io.Serializable;
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
public class MemberBoardDTO extends CommonDTO implements Serializable {

  private static final long serialVersionUID = 6204700889781721914L;

  private Long memberBoardSeq;
  private String category;
  private String title;
  private String writerName;
  private String writerEmail;
  private String content;
  private Integer viewCount;
  private List<MemberBoardCommentDTO> memberBoardCommentList = new ArrayList<>();
  private List<FileDTO> fileList = new ArrayList<>();

  @QueryProjection
  public MemberBoardDTO(Long memberBoardSeq, String category, String title, String content,
      String writerName,
      String writerEmail) {
    this.memberBoardSeq = memberBoardSeq;
    this.category = category;
    this.title = title;
    this.content = content;
    this.writerName = writerName;
    this.writerEmail = writerEmail;
  }

  public MemberBoard toEntity() {
    return MemberBoard.builder()
        .category(this.category)
        .title(this.title)
        .writerName(this.writerName)
        .writerEmail(this.writerEmail)
        .content(this.content)
        .build();
  }
}
