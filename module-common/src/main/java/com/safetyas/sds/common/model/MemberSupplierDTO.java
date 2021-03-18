package com.safetyas.sds.common.model;

import com.safetyas.sds.common.entity.Member;
import com.safetyas.sds.common.entity.MemberSupplier;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class MemberSupplierDTO implements Serializable {

  private static final long serialVersionUID = -4980142705037288082L;

  private Long memberSupplierSeq;
  private String supplierGroup;
  private String dept;
  private String name;
  private String phone;
  private String addr1;
  private String addr2;
  private String defaultYn;

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
