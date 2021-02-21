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
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "sds_admin_info")
public class AdminInfo extends CommonEntity implements Serializable {

  @Builder
  public AdminInfo(Long adminSeq, String dept, String position, String name, String email,
      Member member,LocalDateTime inDate, LocalDateTime modDate, LocalDateTime delDate) {
    super(inDate, modDate, delDate);
    this.adminSeq = adminSeq;
    this.dept = dept;
    this.position = position;
    this.name = name;
    this.email = email;
    setMember(member);
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "admin_seq", nullable = false, length = 20)
  private Long adminSeq;

  @Column(name = "dept", columnDefinition = "varchar(100) not null comment '부서'")
  private String dept;

  @Column(name = "position", columnDefinition = "varchar(100) comment '직급'")
  private String position;

  @Column(name = "name", columnDefinition = "varchar(100) comment '이름'")
  private String name;

  @Column(name = "email", columnDefinition = "varchar(100) comment '이메일'")
  private String email;

  @OneToOne(mappedBy = "adminInfo")
  private Member member;

  public void setMember(Member member) {
    this.member = member;
    member.setAdminInfo(this);
  }
}
