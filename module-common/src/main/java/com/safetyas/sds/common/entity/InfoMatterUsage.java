package com.safetyas.sds.common.entity;

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
@Table(name = "sds_info_matter_usage") // 물질용도선택
public class InfoMatterUsage {

  @Id
  @Column(name = "serial_number", length = 50)
  private String serialNumber;

  @Column(name = "usage", columnDefinition = "varchar(255) comment '용도'")
  private String usage;

  @Column(name = "note", columnDefinition = "varchar(500) comment '설명'")
  private String note;

}
