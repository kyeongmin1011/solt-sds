package com.safetyas.sds.common.model;

import com.querydsl.core.annotations.QueryProjection;
import com.safetyas.sds.common.entity.CbiSentence;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
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
public class CbiDocumentDTO extends CommonDTO implements Serializable {

  private static final long serialVersionUID = -3028167684869178626L;

  private String productUid;  // 제품명
  private String companyName;
  private String companyAddr1;
  private String companyAddr2;
  private List<FileDTO> fileList = new ArrayList<>();

  // response
  private CbiSentenceDTO cbiSentence;

  @QueryProjection
  public CbiDocumentDTO(String productUid, String companyName, String companyAddr1,
      String companyAddr2) {
    this.productUid = productUid;
    this.companyName = companyName;
    this.companyAddr1 = companyAddr1;
    this.companyAddr2 = companyAddr2;
  }

  public void updateSentenceList(List<CbiSentence> cbiSentenceList) {
    List<String> nonKnowledgeList = cbiSentenceList
        .stream()
        .filter(test -> test.getType().equals("비공지성"))
        .map(CbiSentence::getSentence)
        .collect(Collectors.toList());

    List<String> economicUsefulnessList = cbiSentenceList
        .stream()
        .filter(test -> test.getType().equals("경제적유용성"))
        .map(CbiSentence::getSentence)
        .collect(Collectors.toList());

    List<String> confidentialityList = cbiSentenceList
        .stream()
        .filter(test -> test.getType().equals("비밀관리성"))
        .map(CbiSentence::getSentence)
        .collect(Collectors.toList());

    CbiSentenceDTO cbiSentenceDTO = CbiSentenceDTO.builder()
        .confidentialityList(confidentialityList)
        .economicUsefulnessList(economicUsefulnessList)
        .nonKnowledgeList(nonKnowledgeList)
        .build();
    this.cbiSentence = cbiSentenceDTO;
  }
}
