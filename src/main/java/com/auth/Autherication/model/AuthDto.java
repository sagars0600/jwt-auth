package com.auth.Autherication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AuthDto {
    private String jwtToken;
    private UserWithOutPassword userWithOutPassword;
}
