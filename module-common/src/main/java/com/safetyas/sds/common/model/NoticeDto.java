package com.safetyas.sds.common.model;

import com.safetyas.sds.common.entity.Notice;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NoticeDto {

  private Long noticeSeq;
  private String category;
  private String title;
  private String content;
  private Integer viewCount;
  private String writerName; // 입력자 이름
  private Long memberSeq; // 입력자 멤버 시퀀스

  public Notice toEntity(NoticeDto noticeDto) {
    Notice notice = new Notice();
    BeanUtils.copyProperties(notice, noticeDto);
    return notice;
  }
}
