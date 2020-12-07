package com.loginservice.requestDTO;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminRequestDTO implements Serializable {
    private String userName;
    private String email;
}
