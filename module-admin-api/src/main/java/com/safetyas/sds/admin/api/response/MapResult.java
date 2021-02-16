package com.safetyas.sds.admin.api.response;

import java.util.Map;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MapResult<String, Object> extends CommonResult {

  private Map<String, Object> list;
}
