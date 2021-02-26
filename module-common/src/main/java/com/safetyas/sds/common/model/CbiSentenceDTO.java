package com.safetyas.sds.common.model;

import java.util.ArrayList;
import java.util.List;
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
@ToString
@Builder
public class CbiSentenceDTO {
  private List<String> nonKnowledgeList = new ArrayList<>();  // 비공지성
  private List<String> confidentialityList = new ArrayList<>(); // 비밀관리성
  private List<String> economicUsefulnessList = new ArrayList<>();  // 경제적 유용성
}
