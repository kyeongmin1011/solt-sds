package com.safetyas.sds.common.entity.matter;

import com.safetyas.sds.common.entity.CommonEntity;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "sds_matter_step03")
public class MatterStep03 extends CommonEntity implements Serializable {

  @Builder
  public MatterStep03 ( Long matterStep03Seq, String a001, String a002, String a003, String a004, String a005,
      String a006,  String a007, LocalDateTime inDate, LocalDateTime modDate, LocalDateTime delDate) {
    super(inDate, modDate, delDate);
    this.matterStep03Seq = matterStep03Seq;
    this.a001 = a001;
    this.a002 = a002;
    this.a003 = a003;
    this.a004 = a004;
    this.a005 = a005;
    this.a006 = a006;
    this.a007 = a007;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "matter_step03_seq", nullable = false, length = 20)
  private Long matterStep03Seq;

  @Column(name = "step03_a001", columnDefinition = "varchar(255) comment '화학물질명'")
  private String a001;

  @Column(name = "step03_a002", columnDefinition = "varchar(255) comment '관용명 및 이명'")
  private String a002;

  @Column(name = "step03_a003", columnDefinition = "varchar(255) comment 'CAS No.'")
  private String a003;

  @Column(name = "step03_a004", columnDefinition = "varchar(255) comment 'KE No.'")
  private String a004;

  @Column(name = "step03_a005", columnDefinition = "varchar(255) comment '함유량'")
  private String a005;

  @Column(name = "step03_a006", columnDefinition = "varchar(255) comment '대체자료 승인번호'")
  private String a006;

  @Column(name = "step03_a007", columnDefinition = "varchar(255) comment '대체자료 유효기간'")
  private String a007;
}
