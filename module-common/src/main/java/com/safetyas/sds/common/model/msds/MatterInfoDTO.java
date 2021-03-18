package com.safetyas.sds.common.model.msds;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MatterInfoDTO {

    private Long seq;   // 시퀀스
    private String cas; // 카스넘버
    private String chemName;    // 물질명
    private Float contentRate;  // 함유량 %

    private MatterEnvDTO matterEnvDTO;  // 환경유해성
    private MatterHealthDTO matterHealthDTO;    // 건강유해성
    private MatterLawDTO matterLawDTO;  // 법적규제
    private MatterPhyscChemDTO matterPhyscChemDTO;  // 물리화학성
    private MatterPhyscDvDTO matterPhyscDvDTO;  // 물리화학성 구분값
}
