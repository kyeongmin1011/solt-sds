package com.safetyas.sds.common.entity;

import java.io.Serializable;
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
@Table(name = "sds_point_event")
public class PointEvent extends CommonEntity implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "point_event_seq", nullable = false)
  private Long pointEventSeq;

  @Column(name = "use_case", nullable = false)
  private String useCase;

  @Column(name = "type", nullable = false)
  private String type;

  @Column(name = "point_value", nullable = false)
  private Integer pointValue;
}
