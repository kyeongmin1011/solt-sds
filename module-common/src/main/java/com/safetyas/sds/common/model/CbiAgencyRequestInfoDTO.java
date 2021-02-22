package com.safetyas.sds.common.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CbiAgencyRequestInfoDTO extends CommonDTO implements Serializable {

  private static final long serialVersionUID = -3491994166682055214L;

  private Long productSeq;
  private String agencyCbiType;
  private String agencyCbiDocYn;
  private List<ProductMatterDTO> productMatterList = new ArrayList<>();
}
