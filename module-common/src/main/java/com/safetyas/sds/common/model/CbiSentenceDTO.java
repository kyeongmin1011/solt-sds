package com.safetyas.sds.common.model;

import java.io.Serializable;
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
public class CbiSentenceDTO extends CommonDTO implements Serializable {

  private static final long serialVersionUID = -3028167684869178626L;

  private String productUid;
  private List<String> nonKnowledgeList;
  private List<String> economicUsefulnessList;
  private List<String> confidentialityList;
}
