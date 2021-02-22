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
@Table(name = "sds_matter_step04")
public class MatterStep04 extends CommonEntity implements Serializable {

  @Builder
  public MatterStep04 (
      Long matterStep04Seq, String a001, String a002, String a003, String a004, String a005,
      LocalDateTime inDate, LocalDateTime modDate, LocalDateTime delDate) {
    super(inDate, modDate, delDate);
    this.matterStep04Seq = matterStep04Seq;
    this.a001 = a001;
    this.a002 = a002;
    this.a003 = a003;
    this.a004 = a004;
    this.a005 = a005;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "matter_step04_seq", nullable = false, length = 20)
  private Long matterStep04Seq;

  @Column(name = "step01_a001", columnDefinition = "varchar(255) comment '가. 눈에 들어갔을 때'")
  private String a001;

  @Column(name = "step01_a001", columnDefinition = "varchar(255) comment '나. 피부에 접촉했을 때'")
  private String a002;

  @Column(name = "step01_a001", columnDefinition = "varchar(255) comment '다. 흡입했을때'")
  private String a003;

  @Column(name = "step01_a001", columnDefinition = "varchar(255) comment '라. 먹었을때'")
  private String a004;

  @Column(name = "step01_a001", columnDefinition = "varchar(255) comment '마. 기타 의사의 주의사항'")
  private String a005;
}
