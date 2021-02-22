package com.safetyas.sds.common.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "sds_point")
public class Point extends CommonEntity implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "point_seq", nullable = false)
  private Long pointSeq;

  @Column(name = "point", nullable = false)
  private Integer point;

  @Column(name = "expriation_date", nullable = false)
  private LocalDateTime expirationDate;

  @OneToOne(mappedBy = "point")
  private Member member;
}
