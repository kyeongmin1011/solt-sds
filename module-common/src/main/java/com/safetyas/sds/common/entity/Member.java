package com.safetyas.sds.common.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
@Table(name = "sds_member")
public class Member extends CommonEntity implements Serializable {

  @Builder
  public Member(Long memberSeq, Integer level, String role, String memberId, String pwd, String token,
      LocalDateTime loginLast, Integer loginCount, LocalDateTime inDate,
      LocalDateTime modDate, LocalDateTime delDate) {
    super(inDate, modDate, delDate);
    this.memberSeq = memberSeq;
    this.level = level;
    this.role = role;
    this.memberId = memberId;
    this.pwd = pwd;
    this.token = token;
    this.loginLast = loginLast;
    this.loginCount = loginCount;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "member_seq", nullable = false, length = 20)
  private Long memberSeq;  // 멤버 시퀀스

  @Column(name = "level", length = 10)
  private Integer level;  // 멤버 레벨

  @Column(name = "role", length = 100)
  private String role;  // 멤버 롤

  @Column(name = "member_id", length = 50)
  private String memberId;  // 아이디

  @Column(name = "pwd")
  private String pwd; // 패스워드

  @Column(name = "token")
  private String token; // 토큰정보

  @Column(name = "login_last")
  private LocalDateTime loginLast;  // 마지막 로그인

  @Column(name = "login_count", length = 10)
  private Integer loginCount;  // 로그인 횟수

/*  @JsonManagedReference
  @OneToOne(cascade = {CascadeType.ALL}, orphanRemoval = true, fetch = FetchType.LAZY)
  @JoinColumn(name = "member_info_seq", foreignKey = @ForeignKey(name = "member_info_seq_member_fk"))
  private MemberInfo memberInfo;

  @JsonManagedReference
  @OneToOne(cascade = {CascadeType.ALL}, orphanRemoval = true, fetch = FetchType.LAZY)
  @JoinColumn(name = "admin_info_seq", foreignKey = @ForeignKey(name = "admin_info_seq_member_fk"))
  private AdminInfo adminInfo;*/

  @OneToOne
  @JsonBackReference
  private MemberInfo memberInfo; // 고객 정보

  @OneToOne
  @JsonBackReference
  private AdminInfo adminInfo; // 관리자 정보

  @JsonManagedReference
  @OneToMany(mappedBy = "member")
  List<MemberSupplier> memberSupplierList = new ArrayList<>();

  @JsonManagedReference
  @OneToMany(mappedBy = "member")
  List<MemberBoard> memberBoardList = new ArrayList<>();
}
