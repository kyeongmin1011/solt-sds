package com.safetyas.sds.client.api.request;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class ProductMatterDataSettingRequest {

  @NotEmpty
  @Size(min = 2, max = 20)
  @ApiModelProperty(value = "제품 시퀀스")
  private Long productSeq;

  @NotEmpty
  @Size(min = 2, max = 50)
  @ApiModelProperty(value = "물질 라이브러리 정보 고유키")
  private String matterDataKey;
}
