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
@Table(name = "sds_matter_step02")
public class MatterStep02 extends CommonEntity implements Serializable {

  public MatterStep02(Long matterstep02Seq, String a011, String a012, String a013, String a014,
      String a015, String a016, String b011, String b012, String b013, String b111, String b112,
      String b113, String b114, String c001,
      LocalDateTime inDate, LocalDateTime modDate, LocalDateTime delDate){
    super(inDate, modDate, delDate);
    this.matterstep02Seq = matterstep02Seq;
    this.a011 = a011;
    this.a012 = a012;
    this.a012 = b012;
    this.a013 = a013;
    this.a014 = a014;
    this.a015 = a015;
    this.a016 = a016;
    this.b011 = b011;
    this.b012 = b012;
    this.b013 = b013;
    this.b111 = b111;
    this.b112 = b112;
    this.b113 = b113;
    this.b114 = b114;
    this.c001 = c001;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "matter_step02_seq", nullable = false, length = 20)
  private Long matterstep02Seq;

  @Column(name = "step02_a011", columnDefinition = "varchar(255) comment '가.급성독성'")
  private String a011;

  @Column(name = "step02_a012", columnDefinition = "varchar(255) comment '가.피부 부식성/피부 자극성'")
  private String a012;

  @Column(name = "step02_a013", columnDefinition = "varchar(255) comment '가.심한 눈 손상성/눈 자극성'")
  private String a013;

  @Column(name = "step02_a014", columnDefinition = "varchar(255) comment '가.발암성'")
  private String a014;

  @Column(name = "step02_a015", columnDefinition = "varchar(255) comment '가.특정표적장기 독성 (1회 노출)'")
  private String a015;

  @Column(name = "step02_a016", columnDefinition = "varchar(255) comment '가.수생환경 유해성'")
  private String a016;

  @Column(name = "step02_b011", columnDefinition = "varchar(255) comment '나.그림문자'")
  private String b011;

  @Column(name = "step02_b012", columnDefinition = "varchar(255) comment '나. 신호어'")
  private String b012;

  @Column(name = "step02_b013", columnDefinition = "varchar(255) comment '나. 유해위험문구'")
  private String b013;

  @Column(name = "step02_b111", columnDefinition = "varchar(255) comment '나. 예방'")
  private String b111;

  @Column(name = "step02_b112", columnDefinition = "varchar(255) comment '나. 대응'")
  private String b112;

  @Column(name = "step02_b113", columnDefinition = "varchar(255) comment '나. 저장'")
  private String b113;

  @Column(name = "step02_b114", columnDefinition = "varchar(255) comment '나. 폐기'")
  private String b114;

  @Column(name = "step02_c001", columnDefinition = "varchar(255) comment '다. 유해성 위험성'")
  private String c001;
}
