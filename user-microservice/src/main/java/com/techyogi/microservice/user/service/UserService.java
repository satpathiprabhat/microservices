package com.techyogi.microservice.user.service;

import com.techyogi.microservice.user.VO.Department;
import com.techyogi.microservice.user.VO.ResponseTemplateVO;
import com.techyogi.microservice.user.common.DepartmentNotFoundException;
import com.techyogi.microservice.user.common.UserNotFoundException;
import com.techyogi.microservice.user.model.UserInfo;
import com.techyogi.microservice.user.repo.UserRepository;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.sql.SQLException;

@Service
public class UserService {

    @Autowired
    UserRepository repository;
    @Autowired
    RestTemplate restTemplate;
    @Value("${department.service.url}")
    private String dept_ms_url;
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public UserInfo getUserById(String user_id) {
        logger.info("<<<<<<<<<< In side getUserById Method >>>>>>>>");
        try {
            return repository.getUserById(user_id);
        } catch (SQLException e) {
            logger.error("Error in getUserById Method", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public ResponseTemplateVO getUserWithDepartment(String user_id) throws SQLException {
        logger.info("<<<<<<<<<< In side service getUserWithDepartment Method >>>>>>>>");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        //try{
            UserInfo user = repository.getUserById(user_id);
            if (user != null && user.getDeptCode() != null) {
                Department department = restTemplate.getForObject(dept_ms_url+"/getByCode/" + user.getDeptCode(), Department.class);

                if (StringUtils.isNotEmpty(department.getDep_code()) && department!=null) {
                    vo.setUser(user);
                    vo.setDepartment(department);
                } else {
                    logger.error("Department not found for user_id: " + user_id);
                    throw new DepartmentNotFoundException("No Department Found With Code:" + user.getDeptCode());
                }
            } else {
                throw new UserNotFoundException("User details Not Found for user id: " + user_id);
            }
        /*} catch (Exception e) {
            logger.error("<<<<<<<<<< Exception in service getUserWithDepartment Method >>>>>>>>", e);
            e.printStackTrace();
        }*/
        return vo;
    }

}
