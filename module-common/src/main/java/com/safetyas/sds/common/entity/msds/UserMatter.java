package com.safetyas.sds.common.entity.msds;

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
@Table(name = "sds_user_matter")
public class UserMatter {

  @Id
  @Column(name = "user_matter_seq", length = 20)
  private Long userMatterSeq;


}
