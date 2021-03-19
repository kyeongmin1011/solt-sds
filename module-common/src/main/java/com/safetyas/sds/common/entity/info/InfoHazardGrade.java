package com.safetyas.sds.common.entity.info;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
@Table(name = "sds_info_hazard_grade") // 나라별 유해성 위험성 등급
public class InfoHazardGrade {

  @Id
  @Column(name = "hazard_grade_key", length = 50)
  private String hazardGradeKey;

  @Column(name = "group_title", columnDefinition = "varchar(50) comment '그룹명'")
  private String groupTitle;

  @Column(name = "group_type", columnDefinition = "varchar(50) comment '그룹'")
  private String groupType;

  @Column(name = "element_idx", columnDefinition = "varchar(50) comment '항목인덱스'")
  private String elementIdx;

  @Column(name = "element_num", columnDefinition = "varchar(50) comment '항목번호'")
  private Integer elementNum;

  @Column(name = "element_title", columnDefinition = "varchar(255) comment '항목명'")
  private String elementTitle;

  @Column(name = "hazard_value", columnDefinition = "int(11) comment '구분숫자값'")
  private Integer hazardValue;

  @Column(name = "kor", columnDefinition = "varchar(255) comment '국내'")
  private String kor;

  @Column(name = "unGhs", columnDefinition = "varchar(255) comment 'UN'")
  private String unGhs;

  @Column(name = "usa", columnDefinition = "varchar(255) comment '미국'")
  private String usa;

  @Column(name = "eu_clp", columnDefinition = "varchar(255) comment '유럽'")
  private String euClp;

  @OneToOne(cascade = {CascadeType.ALL}, orphanRemoval = true, fetch = FetchType.LAZY)
  @JoinColumn(name = "grade_detail_seq", foreignKey = @ForeignKey(name = "grade_detail_seq_info_hazard_grade_fk"))
  private InfoHazardGradeDetail infoHazardGradeDetail;

  @OneToMany(mappedBy = "infoHazardGrade")
  private List<InfoPhrase> infoPhraseList = new ArrayList<>();

}
