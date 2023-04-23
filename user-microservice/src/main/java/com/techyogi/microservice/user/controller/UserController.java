package com.techyogi.microservice.user.controller;

import com.techyogi.microservice.user.VO.ResponseTemplateVO;
import com.techyogi.microservice.user.model.UserInfo;
import com.techyogi.microservice.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService service;

    @GetMapping("/getAll")
    public List<UserInfo> getAllUser(){
        logger.info("<<<<<<<<<< In side getAllUser Method >>>>>>>>");
        return null;
    }

    @GetMapping("/getById/{user_id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable String user_id) {
        logger.info("<<<<<<<<<< In side getUserWithDepartment Method >>>>>>>>");
        try {
            return service.getUserWithDepartment(user_id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
