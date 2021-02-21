package com.safetyas.sds.common.entity;

import com.safetyas.sds.common.dto.MemberSupplierDTO;
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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
      String dept, String phone, String addr1, String addr2, String defaultYn, LocalDateTime inDate,
      LocalDateTime modDate, LocalDateTime delDate) {
    super(inDate, modDate, delDate);
    setMember(member);
    this.memberSupplierSeq = memberSupplierSeq;
    this.supplierGroup = supplierGroup;
    this.dept = dept;
    this.name = name;
    this.phone = phone;
    this.addr1 = addr1;
    this.addr2 = addr2;
    this.defaultYn = defaultYn;
  }

  @Id
  @GeneratedValue
  @Column(name = "member_supplier_seq", nullable = false, length = 20)
  private Long memberSupplierSeq;

  @Column(name = "supplier_group", columnDefinition = "varchar(10) comment '공급사 그룹 구분. 당사, 타사'")
  private String supplierGroup;

  @Column(name = "dept", columnDefinition = "varchar(100) comment '조직명'")
  private String dept;

  @Column(name = "name", columnDefinition = "varchar(100) comment '공급자 이름'")
  private String name;

  @Column(name = "phone", columnDefinition = "varchar(100) comment '전화번호'")
  private String phone;

  @Column(name = "addr1", columnDefinition = "varchar(500) comment '주소'")
  private String addr1;

  @Column(name = "addr2", columnDefinition = "varchar(100) comment '상세 주소'")
  private String addr2;

  @Column(name = "default_yn", columnDefinition = "varchar(1) comment '기본공급자 설정'")
  private String defaultYn;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "member_seq", foreignKey = @ForeignKey(name = "member_seq_member_supplier_fk"))
  private Member member;  // 멤버

  @OneToMany(mappedBy = "memberSupplier")
  private List<Product> productList = new ArrayList<>();

  public void setMember(Member member) {
    if (this.member != null) {
      this.member.getMemberSupplierList().remove(this);
    }
    this.member = member;
    member.getMemberSupplierList().add(this);
  }

  public void update(MemberSupplierDTO memberSupplierDTO) {
    this.supplierGroup = memberSupplierDTO.getSupplierGroup();
    this.dept = memberSupplierDTO.getDept();
    this.name = memberSupplierDTO.getName();
    this.phone = memberSupplierDTO.getPhone();
    this.addr1 = memberSupplierDTO.getAddr1();
    this.addr2 = memberSupplierDTO.getAddr2();
    this.defaultYn = memberSupplierDTO.getDefaultYn();
  }
}
