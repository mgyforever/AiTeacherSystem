package com.ccut.teachingaisystem.dao;

import com.ccut.teachingaisystem.domain.log.OperationLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LogDao {
    @Insert("insert into operation_log (ip_address, user_agent, request_uri, http_method" +
            ", class_name, method_name, request_params, response_data, status_code, success" +
            ", exception_name, exception_msg, execution_time_ms, operation_time) " +
            "VALUES (#{ipAddress}, #{userAgent}, #{requestUri}, #{httpMethod}" +
            ", #{className}, #{methodName}, #{requestParams}, #{responseData}, #{statusCode}, #{success}" +
            ", #{exceptionName}, #{exceptionMsg}, #{executionTimeMs}, #{operationTime})")
    void insertOperationLog(OperationLog operationLog);

    @Select("select * from operation_log")
    List<OperationLog> selectOperationLog();
}
