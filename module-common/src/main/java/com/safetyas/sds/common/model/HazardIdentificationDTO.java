package com.safetyas.sds.common.model;

import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class HazardIdentificationDTO implements Serializable {

  private static final long serialVersionUID = 8360311214209675475L;
  String cas;
  List<HazardInfoDTO> hazardInfoList;

  public void updateHazardInfoDTO(String cas, List<HazardInfoDTO> hazardInfoList) {
    this.cas = cas;
    this.hazardInfoList = hazardInfoList;
  }
}
