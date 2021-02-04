package com.safetyas.sds.common.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "sds_notice")
public class Notice extends CommonEntity implements Serializable {

  @Builder
  public Notice(Long noticeSeq, String category, String title, String content, Integer viewCount,
      Long adminSeq, LocalDateTime inDate, LocalDateTime modDate, LocalDateTime delDate) {
    super(inDate, modDate, delDate);
    this.noticeSeq = noticeSeq;
    this.category = category;
    this.title = title;
    this.content = content;
    this.viewCount = viewCount;
    this.adminSeq = adminSeq;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "notice_seq", nullable = false, length = 20)
  private Long noticeSeq;

  @Column(name = "category", nullable = false, length = 100)
  private String category;

  @Column(name = "title", nullable = false, length = 250)
  private String title;

  @Column(name = "content", nullable = false, columnDefinition = "LONGTEXT")
  private String content;

  @Column(name = "view_count")
  private Integer viewCount;

  @Column(name = "admin_seq")
  private Long adminSeq;
}
