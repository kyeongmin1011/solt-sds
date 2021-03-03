package com.safetyas.sds.common.entity.info;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "sds_info_precaution") // 예방조치문구
public class InfoPrecaution {

  @Id
  @Column(name = "hp_code", length = 50)
  private String hpCode;

  @Column(name = "code_type", columnDefinition = "varchar(50) comment '항목'")
  private String codeType;

  @Column(name = "phrase", columnDefinition = "varchar(500) comment '문구'")
  private String phrase;
}
