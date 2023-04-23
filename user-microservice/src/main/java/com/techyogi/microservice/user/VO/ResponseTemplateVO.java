package com.techyogi.microservice.user.VO;

import com.techyogi.microservice.user.model.UserInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {

        private UserInfo user;
        private Department department;
}
