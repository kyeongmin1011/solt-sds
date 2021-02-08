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
@Table(name = "sds_file")
public class File extends CommonEntity implements Serializable {

  @Builder
  public File(Long fileSeq, String relateTable, Long recordSeq, String type, String path,
      String name, Integer size, String ext, String oriName, Long regUserSeq, Long modUserSeq,
      LocalDateTime inDate, LocalDateTime modDate, LocalDateTime delDate) {
    super(inDate, modDate, delDate);
    this.fileSeq = fileSeq;
    this.recordSeq = recordSeq;
    this.relateTable = relateTable;
    this.type = type;
    this.path = path;
    this.name = name;
    this.size = size;
    this.ext = ext;
    this.oriName = oriName;
    this.regUserSeq = regUserSeq;
    this.modUserSeq = modUserSeq;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "file_seq")
  private Long fileSeq;

  @Column(name = "relate_table", columnDefinition = "varchar(100) comment '관련 테이블'")
  private String relateTable;

  @Column(name = "record_seq", columnDefinition = "bigint(20) comment '관련 시퀀스'")
  private Long recordSeq;

  @Column(name = "type", columnDefinition = "varchar(100) comment '파일 타입'")
  private String type;

  @Column(name = "path", columnDefinition = "varchar(500) comment '파일 경로'")
  private String path;

  @Column(name = "name", columnDefinition = "varchar(500) comment '파일 이름'")
  private String name;

  @Column(name = "size", columnDefinition = "int(11) comment '파일 사이즈'")
  private Integer size;

  @Column(name = "ext", columnDefinition = "varchar(100) comment '파일 확장자'")
  private String ext;

  @Column(name = "ori_name", columnDefinition = "varchar(500) comment '오리지널 이름'")
  private String oriName;

  @Column(name = "req_user_seq", columnDefinition = "bigint(20) comment '등록 사용자'")
  private Long regUserSeq;

  @Column(name = "mod_user_seq", columnDefinition = "bigint(20) comment '수정사용자'")
  private Long modUserSeq;
}
