package com.safetyas.sds.common.dto;

import com.safetyas.sds.common.entity.Member;
import com.safetyas.sds.common.entity.MemberSupplier;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class MemberSupplierDTO {
  private Long memberSupplierSeq;
  private String supplierGroup;
  private String dept;
  private String name;
  private String phone;
  private String addr1;
  private String addr2;
  private String defaultYn;

  public MemberSupplierDTO () {}

  public MemberSupplier toEntity(Member member) {
    return MemberSupplier.builder()
        .supplierGroup(this.supplierGroup)
        .name(this.name)
        .dept(this.dept)
        .phone(this.phone)
        .addr1(this.addr1)
        .addr2(this.addr2)
        .defaultYn(this.defaultYn)
        .member(member)
        .build();
  }
}
