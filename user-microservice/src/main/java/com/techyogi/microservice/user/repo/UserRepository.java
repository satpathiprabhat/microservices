package com.techyogi.microservice.user.repo;

import com.techyogi.microservice.user.VO.ResponseTemplateVO;
import com.techyogi.microservice.user.model.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;
    private static final Logger logger = LoggerFactory.getLogger(UserRepository.class);
    private static final String GET_ALL_USER = "SELECT * FROM public.users WHERE public.users.userid= ?";

    public UserInfo getUserById(String userId) throws SQLException {
        logger.info("<<<<<<<<<< In side getUserById Method >>>>>>>>");
        return jdbcTemplate.execute(GET_ALL_USER, (PreparedStatementCallback<UserInfo>) ps -> {

            // List<UserInfo> list_user = new ArrayList<>();
            UserInfo user = new UserInfo();
            ps.setString(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                user.setUserId(rs.getString("userid"));
                user.setFirstName(rs.getString("firstname"));
                user.setLastName(rs.getString("lastname"));
                user.setUserEmail(rs.getString("email"));
                user.setDeptCode(rs.getString("deptcode"));
                user.setMobileNo(rs.getString("mobnum"));
                //list_user.add(user);
            }
            return user;
        });
    }
}
