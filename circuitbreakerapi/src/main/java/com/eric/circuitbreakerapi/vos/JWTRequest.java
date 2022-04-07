package com.eric.circuitbreakerapi.vos;

import lombok.Data;

@Data
public class JWTRequest {
  private String userName;
  private String password;
}
