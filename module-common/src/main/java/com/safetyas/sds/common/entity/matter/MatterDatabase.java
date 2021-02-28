package com.safetyas.sds.common.entity.matter;

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
@Table(name = "sds_matter_database")
public class MatterDatabase {

  @Id
  @Column(name = "matter_database_seq", length = 20)
  private Long matterDatabaseSeq;

  @Column(name = "cas_no", columnDefinition = "varchar(50) comment '카스번호'")
  private String casNo;

  @Column(name = "chem_name", columnDefinition = "varchar(500) comment '물질명'")
  private String chemName;

  @Column(name = "other_name", columnDefinition = "varchar(500) comment '이명'")
  private String otherName;
}
