package com.safetyas.sds.common.model;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class HazardIdentificationDTO {

  String cas;
  List<HazardInfoDTO> hazardInfoDTOList;

  public void updateHazardInfoDTO(String cas, List<HazardInfoDTO> hazardInfoDTOList) {
    this.cas = cas;
    this.hazardInfoDTOList = hazardInfoDTOList;
  }
}
