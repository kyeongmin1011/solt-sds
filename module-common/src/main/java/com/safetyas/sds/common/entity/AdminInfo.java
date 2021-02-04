package com.safetyas.sds.common.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
  public AdminInfo(Long adminSeq, Integer level, String role, String adminId, String pwd,
      String name, String email, LocalDateTime lastLogin,
      LocalDateTime inDate, LocalDateTime modDate, LocalDateTime delDate) {
    super(inDate, modDate, delDate);
    this.adminSeq = adminSeq;
    this.level = level;
    this.role = role;
    this.adminId = adminId;
    this.pwd = pwd;
    this.name = name;
    this.email = email;
    this.lastLogin = lastLogin;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "admin_seq", nullable = false, length = 20)
  private Long adminSeq;  // 시퀀스

  @Column(name = "level", length = 10)
  private Integer level;  // 멤버 레벨

  @Column(name = "role", length = 100)
  private String role;  // 멤버 롤

  @Column(name = "admin_id", length = 50)
  private String adminId;  // 아이디

  @Column(name = "pwd", length = 100)
  private String pwd; // 패스워드

  @Column(name = "name", length = 100)
  private String name; // 이름

  @Column(name = "email", length = 100)
  private String email; // 이메일

  @Column(name = "lastLogin")
  private LocalDateTime lastLogin; // 마지막 로그인

  @JsonManagedReference
  @OneToOne(cascade = {CascadeType.ALL}, orphanRemoval = true, fetch = FetchType.LAZY)
  @JoinColumn(name = "member_seq", foreignKey = @ForeignKey(name = "member_seq_admin_info_fk"))
  private Member member;

}
