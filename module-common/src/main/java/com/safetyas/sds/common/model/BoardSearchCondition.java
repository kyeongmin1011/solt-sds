package com.safetyas.sds.common.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BoardSearchCondition implements Serializable {

  private static final long serialVersionUID = 6993194994953251317L;

  private String category;
  private String keyword;
}
