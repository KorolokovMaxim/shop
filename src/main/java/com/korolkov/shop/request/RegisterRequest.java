package com.korolkov.shop.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
   private String firstname;
   private String surname;
   private String email;
   private String phone;
   private String password;
}
