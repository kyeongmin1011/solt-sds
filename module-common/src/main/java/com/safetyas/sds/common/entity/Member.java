package com.safetyas.sds.common.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
      LocalDateTime modDate, LocalDateTime delDate, MemberInfo memberInfo, AdminInfo adminInfo) {
    super(inDate, modDate, delDate);
    this.memberSeq = memberSeq;
    this.level = level;
    this.role = role;
    this.memberId = memberId;
    this.pwd = pwd;
    this.token = token;
    this.loginLast = loginLast;
    this.loginCount = loginCount;
    this.memberInfo = memberInfo;
    this.adminInfo = adminInfo;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "member_seq", nullable = false, length = 20)
  private Long memberSeq;

  @Column(name = "level", columnDefinition = "int(11) comment '멤버레벨'")
  private Integer level;

  @Column(name = "role", columnDefinition = "varchar(100) comment '멤버롤'")
  private String role;

  @Column(name = "member_id", columnDefinition = "varchar(100) comment '멤버아이디'")
  private String memberId;

  @Column(name = "pwd", columnDefinition = "varchar(255) comment '패스워드'")
  private String pwd;

  @Column(name = "token", columnDefinition = "varchar(255) comment '토큰정보'")
  private String token;

  @Column(name = "login_last", columnDefinition = "datetime comment '마지막 로그인'")
  private LocalDateTime loginLast;

  @Column(name = "login_count", length = 10, columnDefinition = "datetime comment '로그인 횟수'")
  private Integer loginCount;

  @OneToOne
  @JsonBackReference
  private MemberInfo memberInfo; // 고객 정보

  @OneToOne
  @JsonBackReference
  private AdminInfo adminInfo; // 관리자 정보

  @JsonManagedReference
  @OneToMany(mappedBy = "member")
  private List<MemberSupplier> memberSupplierList = new ArrayList<>();

  @JsonManagedReference
  @OneToMany(mappedBy = "member")
  private List<MemberBoard> memberBoardList = new ArrayList<>();

  @JsonManagedReference
  @OneToMany(mappedBy = "member")
  private List<MemberBoardComment> memberBoardCommentList = new ArrayList<>();
}
