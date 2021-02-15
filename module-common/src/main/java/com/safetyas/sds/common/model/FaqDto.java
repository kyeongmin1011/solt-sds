package com.safetyas.sds.common.model;

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
public class FaqDto implements Serializable {

  private static final long serialVersionUID = 921022290655154681L;

  private Long faqSeq;
  private String category;
  private String title;
  private String content;
  private Integer viewCount;
  private String writerName; // 입력자 이름
  private Long memberSeq; // 입력자 멤버 시퀀스

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
