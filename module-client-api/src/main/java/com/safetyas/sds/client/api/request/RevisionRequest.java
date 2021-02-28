package com.safetyas.sds.client.api.request;

import java.io.Serializable;
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
public class RevisionRequest implements Serializable {

  private static final long serialVersionUID = 8376493226403188380L;

  private Long productSeq;
  private String agencyCbiType;
  private String agencyCbiDocYn;
}
