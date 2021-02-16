package com.safetyas.sds.common.model;

import com.safetyas.sds.common.entity.Notice;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NoticeDto implements Serializable {

  private static final long serialVersionUID = 1886349326519647570L;

  @Builder
  public NoticeDto(Long noticeSeq, String category, String title, String content, Integer viewCount,
      String writerName, Long memberSeq, LocalDateTime inDate, LocalDateTime modDate,
      LocalDateTime delDate) {
    this.noticeSeq = noticeSeq;
    this.category = category;
    this.title = title;
    this.content = content;
    this.viewCount = viewCount;
    this.writerName = writerName;
    this.memberSeq = memberSeq;
  }

  private Long noticeSeq;
  private String category;
  private String title;
  private String content;
  private Integer viewCount;
  private String writerName; // 입력자 이름
  private Long memberSeq; // 입력자 멤버 시퀀스
  private LocalDateTime delDate;

  public Notice toEntity() {
    return Notice.builder()
        .category(this.category)
        .title(this.title)
        .content(this.content)
        .writerName(this.writerName)
        .memberSeq(this.memberSeq)
        .delDate(this.delDate)
        .build();
  }
}
