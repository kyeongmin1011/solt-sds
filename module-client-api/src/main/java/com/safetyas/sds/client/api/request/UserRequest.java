package com.safetyas.sds.client.api.request;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserRequest implements Serializable {

  private static final long serialVersionUID = 1677182356503647988L;

  private String username;
  private String password;
}
