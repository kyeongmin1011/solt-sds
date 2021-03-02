package com.safetyas.sds.common.model;

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
public class CbiAgencyDTO implements Serializable {

  private static final long serialVersionUID = -8836498330080926358L;

  private Long cbiAgencySeq;
  private String state;
  private String note;
}
