package com.techyogi.microservice.dept.repos;

import com.techyogi.microservice.dept.model.Department;
import com.techyogi.microservice.dept.model.common.SqlQueries;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentRepository {

    private static final Logger logger = LoggerFactory.getLogger(DepartmentRepository.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    /***
     * This method is used to get all department details
     * @return {@link List<Department>}
     */
    public List<Department> getAllDepDetails() {
        logger.info("fetching all the list of department");
        return jdbcTemplate.execute(SqlQueries.GET_ALL_DEP, (PreparedStatementCallback<List<Department>>) ps -> {

            List<Department> list_dep = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Department dep = new Department();
                dep.setDep_id(rs.getString("DEP_ID"));
                dep.setDep_name(rs.getString("DEP_NM"));
                dep.setDep_code(rs.getString("DEP_CD"));
                list_dep.add(dep);
            }
            return list_dep;
        });
    }

    /***
     * This method is used to save the department details
     * @param dep_id
     * @return {@link Department}
     */
    public Department getDepById(String dep_id) {
        logger.info("fetching the department details for id: [{}]", dep_id);
        return jdbcTemplate.execute(SqlQueries.GET_DEP_BY_ID, (PreparedStatementCallback<Department>) ps -> {
            ps.setString(1, dep_id);
            ResultSet rs = ps.executeQuery();
            Department dep = new Department();
            while (rs.next()) {
                dep.setDep_id(rs.getString("DEP_ID"));
                dep.setDep_name(rs.getString("DEP_NM"));
                dep.setDep_code(rs.getString("DEP_CD"));
            }
            return dep;
        });
    }

    /***
     * This method is used to save the department details
     * @param dep_code
     * @return {@link Department}
     */
    public Department getDeptByCode(String dep_code) {
        logger.info("fetching the department details for Code: [{}]", dep_code);
        return jdbcTemplate.execute(SqlQueries.GET_DEP_BY_CODE, (PreparedStatementCallback<Department>) ps -> {
            ps.setString(1, dep_code);
            ResultSet rs = ps.executeQuery();
            Department dep = new Department();
            while (rs.next()) {
                dep.setDep_id(rs.getString("deptId"));
                dep.setDep_name(rs.getString("deptName"));
                dep.setDep_code(rs.getString("deptCode"));
            }
            return dep;
        });
    }
}
