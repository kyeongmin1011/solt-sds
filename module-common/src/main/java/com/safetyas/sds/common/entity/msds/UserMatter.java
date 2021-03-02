package com.safetyas.sds.common.entity.msds;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "sds_user_matter")
public class UserMatter {

  @Id
  @Column(name = "user_matter_seq", length = 20)
  private Long userMatterSeq;

  @Column(name = "matter_database_seq", length = 20)
  private Long matterDatabaseSeq;  // 참조 물질디비시퀀스

}
