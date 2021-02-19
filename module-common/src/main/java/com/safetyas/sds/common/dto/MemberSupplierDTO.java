package com.safetyas.sds.common.dto;

import com.safetyas.sds.common.entity.MemberSupplier;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemberSupplierDTO {
  private Long memberSupplierSeq;
  private String supplierGroup;
  private String name;
  private String dept;
  private String phone;
  private String addr1;
  private String addr2;
  private String defaultYn;

  public MemberSupplier toEntity() {

    return null;
  }
}
