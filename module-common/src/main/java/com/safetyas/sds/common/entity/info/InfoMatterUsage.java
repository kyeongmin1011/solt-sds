package com.safetyas.sds.common.entity.info;

import com.safetyas.sds.common.entity.msds.ProductMatterMsds;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
  @Column(name = "serial_number", length = 12)
  private Float serialNumber;

  @Column(name = "matter_usage", columnDefinition = "varchar(255) comment '용도'")
  private String matterUsage;

  @Column(name = "note", columnDefinition = "varchar(500) comment '설명'")
  private String note;

}
