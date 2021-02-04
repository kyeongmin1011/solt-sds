package com.safetyas.sds.common.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "sds_faq")
public class Faq extends CommonEntity implements Serializable {

  @Builder
  public Faq(Long faqSeq, String category, String title, String content, Integer viewCount, String writerName,
      Long memberSeq, LocalDateTime inDate, LocalDateTime modDate, LocalDateTime delDate) {
    super(inDate, modDate, delDate);
    this.faqSeq = faqSeq;
    this.category = category;
    this.title = title;
    this.content = content;
    this.viewCount = viewCount;
    this.writerName = writerName;
    this.memberSeq = memberSeq;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "faq_seq", nullable = false, length = 20)
  private Long faqSeq;

  @Column(name = "category", nullable = false, length = 100)
  private String category;

  @Column(name = "title", nullable = false, length = 250)
  private String title;

  @Column(name = "content", nullable = false, columnDefinition = "LONGTEXT")
  private String content;

  @Column(name = "view_count")
  private Integer viewCount;

  @Column(name = "writer_name")
  private String writerName; // 입력자 이름

  @Column(name = "member_seq")
  private Long memberSeq; // 입력자 멤버 시퀀스
}
