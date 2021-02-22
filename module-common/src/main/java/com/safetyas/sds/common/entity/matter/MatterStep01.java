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
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "sds_matter_step01")
public class MatterStep01 extends CommonEntity implements Serializable {

  public MatterStep01(Long matterStep01Seq, String a001, String b011, String b012,
      String c011, String c012, String c013, String c014,
      LocalDateTime inDate, LocalDateTime modDate, LocalDateTime delDate){
    super(inDate, modDate, delDate);
    this.matterStep01Seq = matterStep01Seq;
    this.a001 = a001;
    this.b011 = b011;
    this.b012 = b012;
    this.c011 = c011;
    this.c012 = c012;
    this.c013 = c013;
    this.c014 = c014;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "matter_step01_seq", nullable = false, length = 20)
  private Long matterStep01Seq;

  @Column(name = "step01_a001", columnDefinition = "varchar(255) comment '가.제품명'")
  private String a001; //가.제품명

  @Column(name = "step01_b011", columnDefinition = "varchar(255) comment '나.권고 용도'")
  private String b011; //나.권고 용도

  @Column(name = "step01_b012", columnDefinition = "varchar(255) comment '나. 사용상의 제한'")
  private String b012; //나. 사용상의 제한

  @Column(name = "step01_c011", columnDefinition = "varchar(255) comment '다. 회사명'")
  private String c011; //다. 회사명

  @Column(name = "step01_c012", columnDefinition = "varchar(255) comment '다. 주소'")
  private String c012; //다. 주소

  @Column(name = "step01_c013", columnDefinition = "varchar(50) comment '다. 긴급전화번호'")
  private String c013; //다. 긴급전화번호

  @Column(name = "step01_c014", columnDefinition = "varchar(50) comment '다. 담당자'")
  private String c014; //다. 담당자
}
