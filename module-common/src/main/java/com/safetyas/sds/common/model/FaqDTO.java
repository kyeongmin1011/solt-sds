package com.safetyas.sds.common.model;

import com.querydsl.core.annotations.QueryProjection;
import com.safetyas.sds.common.entity.Faq;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FaqDTO implements Serializable {

  private static final long serialVersionUID = 921022290655154681L;

  private Long faqSeq;
  private String category;
  private String title;
  private String content;
  private Integer viewCount;
  private String writerName; // 입력자 이름
  private Long memberSeq; // 입력자 멤버 시퀀스

  @QueryProjection
  public FaqDTO(String category, String title, String content, String writerName) {
    this.category = category;
    this.title = title;
    this.content = content;
    this.writerName = writerName;
  }

  public Faq toEntity() {
    return Faq.builder()
        .category(this.category)
        .title(this.title)
        .content(this.content)
        .writerName(writerName)
        .memberSeq(memberSeq)
        .build();
  }
}
