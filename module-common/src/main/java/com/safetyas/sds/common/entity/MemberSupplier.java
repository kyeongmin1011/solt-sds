package com.safetyas.sds.common.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
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
@Table(name = "sds_member_supplier")
public class MemberSupplier extends CommonEntity implements Serializable {

  @Builder
  public MemberSupplier(Member member, Long memberSupplierSeq, String supplierGroup, String name,
      String dept, String phone, String addr, String defaultYn, LocalDateTime inDate,
      LocalDateTime modDate, LocalDateTime delDate) {
    super(inDate, modDate, delDate);
    setMember(member);
    this.memberSupplierSeq = memberSupplierSeq;
    this.supplierGroup = supplierGroup;
    this.name = name;
    this.phone = phone;
    this.addr = addr;
    this.defaultYn = defaultYn;
  }

  @Id
  @GeneratedValue
  @Column(name = "member_supplier_seq", nullable = false, length = 20)
  private Long memberSupplierSeq;

  @Column(name = "supplier_group", columnDefinition = "varchar(1) comment '공급사 그룹 구분. 당사: T, 타사: O'")
  private String supplierGroup;

  @Column(name = "dept", columnDefinition = "varchar(100) comment '조직명'")
  private String dept;

  @Column(name = "name", columnDefinition = "varchar(100) comment '공급자 이름'")
  private String name;

  @Column(name = "phone", columnDefinition = "varchar(100) comment '전화번호'")
  private String phone;

  @Column(name = "addr", columnDefinition = "varchar(500) comment '주소'")
  private String addr;

  @Column(name = "default_yn", columnDefinition = "varchar(1) comment '기본공급자 설정'")
  private String defaultYn;

  @JsonBackReference
  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "member_seq", foreignKey = @ForeignKey(name = "member_seq_member_supplier_fk"))
  private Member member;  // 멤버

  public void setMember(Member member) {
    if (this.member != null) {
      this.member.getMemberSupplierList().remove(this);
    }
    this.member = member;
    member.getMemberSupplierList().add(this);
  }
}
