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
@Table(name = "sds_member_suppliers")
public class MemberSupplier extends CommonEntity implements Serializable {

  @Builder
  public MemberSupplier(Member member, Long memberSupplierSeq, String group, String name,
      String phone, String addr, String defaultYn, LocalDateTime inDate,
      LocalDateTime modDate, LocalDateTime delDate) {
    super(inDate, modDate, delDate);
    setMember(member);
    this.memberSupplierSeq = memberSupplierSeq;
    this.group = group;
    this.name = name;
    this.phone = phone;
    this.addr = addr;
    this.defaultYn = defaultYn;
  }

  @Id
  @GeneratedValue
  @Column(name = "member_supplier_seq", nullable = false, length = 20)
  private Long memberSupplierSeq;

  @Column(name = "group", nullable = false, length = 100)
  private String group;

  @Column(name = "name", nullable = false, length = 100)
  private String name;

  @Column(name = "phone", nullable = false, length = 100)
  private String phone;

  @Column(name = "addr", nullable = false, length = 500)
  private String addr;

  @Column(name = "default_yn", nullable = false, length = 1)
  private String defaultYn;

  @JsonBackReference
  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "member_seq", foreignKey = @ForeignKey(name = "member_seq_member_supplier_fk"))
  private Member member;

  public void setMember(Member member) {
    if (this.member != null) {
      this.member.getMemberSupplierList().remove(this);
    }
    this.member = member;
    member.getMemberSupplierList().add(this);
  }
}
