package com.techyogi.microservice.user.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    private String dep_id;
    private String dep_name;
    private String dep_code;
}
