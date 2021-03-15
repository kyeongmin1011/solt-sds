package com.safetyas.sds.common.entity.msds;

import com.safetyas.sds.common.entity.CommonEntity;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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
public class MatterData extends CommonEntity implements Serializable {

  @Id
  @Column(name = "matter_data_key", length = 50)
  private String matterDataKey; // 카스번호+'#'+번
  @Column(name = "db_type", columnDefinition = "varchar(50) comment '디비구분타입-일반:G, 프리미엄:P'")
  private String dbType;
  @Column(name = "cas", columnDefinition = "varchar(50) comment '카스번호'")
  private String cas;
  @Column(name = "chem_name", columnDefinition = "varchar(500) comment '물질명'")
  private String chemName;
  @Column(name = "other_name", columnDefinition = "varchar(500) comment '이명'")
  private String otherName;
  @Column(name = "note", columnDefinition = "varchar(50) comment '비고'")
  private String note;

  @OneToOne(mappedBy = "matterData", fetch = FetchType.LAZY)
  private MatterPhyscChem matterPhyscChem;

  @OneToOne(mappedBy = "matterData", fetch = FetchType.LAZY)
  private MatterHealth matterHealth;

  @OneToOne(mappedBy = "matterData", fetch = FetchType.LAZY)
  private MatterEnv matterEnv;

  @OneToOne(mappedBy = "matterData", fetch = FetchType.LAZY)
  private MatterLaw matterLaw;

  @OneToOne(mappedBy = "matterData", fetch = FetchType.LAZY)
  private MatterPhyscDv matterPhyscDv;

  @OneToOne(mappedBy = "matterData", fetch = FetchType.LAZY)
  private ProductMatter productMatter;
}
