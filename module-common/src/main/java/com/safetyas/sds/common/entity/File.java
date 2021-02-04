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
      String name, String size, String ext, String oriName, Long regUserSeq, Long modUserSeq,
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

  @Column(name = "relate_table")
  private String relateTable;

  @Column(name = "record_seq")
  private Long recordSeq;

  @Column(name = "type")
  private String type;

  @Column(name = "path")
  private String path;

  @Column(name = "name")
  private String name;

  @Column(name = "size")
  private String size;

  @Column(name = "ext")
  private String ext;

  @Column(name = "ori_name")
  private String oriName;

  @Column(name = "req_user_seq")
  private Long regUserSeq; // 등록사용자

  @Column(name = "mod_user_seq")
  private Long modUserSeq; // 수정사용자
}
