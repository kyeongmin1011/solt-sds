package com.safetyas.sds.common.entity;

import com.safetyas.sds.common.model.MemberInfoDTO;
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
  public Member(Long memberSeq, Integer level, String role, String memberId, String pwd,
      String token,
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
    setMemberInfo(memberInfo);
    setAdminInfo(adminInfo);
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

  @Column(name = "login_count", columnDefinition = "int(11) comment '로그인 횟수'")
  private Integer loginCount;

  @OneToOne(cascade = {CascadeType.ALL}, orphanRemoval = true, fetch = FetchType.LAZY)
  @JoinColumn(name = "member_info_seq", foreignKey = @ForeignKey(name = "member_info_seq_member_fk"))
  private MemberInfo memberInfo; // 고객 정보

  @OneToOne(cascade = {CascadeType.ALL}, orphanRemoval = true, fetch = FetchType.LAZY)
  @JoinColumn(name = "admin_seq", foreignKey = @ForeignKey(name = "admin_seq_member_fk"))
  private AdminInfo adminInfo; // 관리자 정보

  @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
  private List<MemberSupplier> memberSupplierList = new ArrayList<>();

  @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
  private List<MemberBoard> memberBoardList = new ArrayList<>();

  @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
  private List<MemberBoardComment> memberBoardCommentList = new ArrayList<>();

  @OneToOne(cascade = {CascadeType.ALL}, orphanRemoval = true, fetch = FetchType.LAZY)
  @JoinColumn(name = "point_seq", foreignKey = @ForeignKey(name = "point_seq_member_fk"))
  private Point point; // 포인트

  public void setMemberInfo(MemberInfo memberInfo) {
    this.memberInfo = memberInfo;
  }

  public void setAdminInfo(AdminInfo adminInfo) {
    this.adminInfo = adminInfo;
  }

  public void updateMemberInfo(MemberInfoDTO memberInfoDTO) {
    this.pwd = memberInfoDTO.getPwd();
    this.memberInfo.updateMemberInfo(memberInfoDTO);
  }
}
