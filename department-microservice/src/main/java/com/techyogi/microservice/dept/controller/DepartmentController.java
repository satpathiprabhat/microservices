package com.techyogi.microservice.dept.controller;

import com.techyogi.microservice.dept.model.Department;
import com.techyogi.microservice.dept.services.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private static final Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    DepartmentService service;
    @GetMapping("/getAll")
    public List<Department> fetchAllDept(){
        return service.getAllDepartment();
    }

    @GetMapping("/getById/{dep_id}")
    public Department fetchDeptById(@PathVariable String dep_id){
        return service.getDepartmentById(dep_id);
    }

    @GetMapping("/getByCode/{dep_code}")
    public Department fetchDeptByCode(@PathVariable String dep_code){
        return service.getDepartmentByCode(dep_code);
    }
}
