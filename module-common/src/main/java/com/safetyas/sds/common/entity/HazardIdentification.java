package com.safetyas.sds.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "sds_hazard_identification") //
public class HazardIdentification {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "hazard_info_seq", nullable = false, length = 20)
  private Long hazardInfoSeq;

  @Column(name = "cas", columnDefinition = "varchar(50) comment '카스번호'")
  private String cas;

  @Column(name = "cause", columnDefinition = "varchar(500) comment '사유'")
  private String cause;

  @Column(name = "refer", columnDefinition = "varchar(500) comment '참고사항'")
  private String refer;

}
