package com.techyogi.microservice.dept.services;

import com.techyogi.microservice.dept.model.Department;
import com.techyogi.microservice.dept.repos.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private static final Logger logger = LoggerFactory.getLogger(DepartmentService.class);

    @Autowired
    DepartmentRepository departmentRepository;
    public List<Department> getAllDepartment(){
        logger.info("<<<<<<<<<< In side getAllDepartment Method >>>>>>>>");
        return departmentRepository.getAllDepDetails();
    }

    public Department getDepartmentById(String dep_id){
        logger.info("<<<<<<<<<< In side getDepartmentById method >>>>>>>>");
        return departmentRepository.getDepById(dep_id);
    }

    public Department getDepartmentByCode(String dep_code){
        logger.info("<<<<<<<<<< In side getDepartmentById method >>>>>>>>");
        return departmentRepository.getDeptByCode(dep_code);
    }
}
