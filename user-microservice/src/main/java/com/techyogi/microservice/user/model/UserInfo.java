package com.techyogi.microservice.user.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {

    private String userId;
    private String firstName;
    private String lastName;
    private String userEmail;
    private String mobileNo;
    private String deptCode;
}
