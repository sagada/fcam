package com.fast.cps.study.model.network.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserApiResponse {
    private Long id;
    private String account;
    private String password;
    private String email;
    private String phoneNumber;
    private String status;
    private LocalDateTime registeredAt;
    private LocalDateTime unRegisteredAt;

}
