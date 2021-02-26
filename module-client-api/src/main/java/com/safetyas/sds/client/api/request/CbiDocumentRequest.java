package com.safetyas.sds.client.api.request;

import com.safetyas.sds.common.entity.CbiDocument;
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
public class CbiDocumentRequest {

  private Long productSeq;
  private String nonKnowledge;  // 비공지성
  private String economicUsefulness;  // 경제적 유용성
  private String confidentiality; // 비밀관리성

  public CbiDocument toEntity() {
    return CbiDocument.builder()
        .nonKnowledge(nonKnowledge)
        .economicUsefulness(economicUsefulness)
        .confidentiality(confidentiality)
        .build();
  }
}
