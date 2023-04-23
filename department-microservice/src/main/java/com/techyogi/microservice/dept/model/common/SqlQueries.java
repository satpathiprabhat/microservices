package com.techyogi.microservice.dept.model.common;

public interface SqlQueries {

    public static final String GET_ALL_DEP = "SELECT * FROM public.DEPT";
    public static final String GET_DEP_BY_ID = "SELECT * FROM public.DEPT WHERE DEPTID=?";
    public static final String GET_DEP_BY_CODE = "select * from public.dept where dept.\"deptCode\"=?";
}
