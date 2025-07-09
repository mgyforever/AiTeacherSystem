package com.ccut.teachingaisystem.config;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

@MappedTypes(int[].class)
public class IntArrayTypeHandler extends BaseTypeHandler<int[]> {

    @Override
    public void setNonNullParameter(PreparedStatement ps
            , int i, int[] parameter, JdbcType jdbcType) throws SQLException {
        // 将数组转为逗号分隔的字符串
        String arrayString = Arrays.toString(parameter)
                .replace("[", "").replace("]", "");
        ps.setString(i, arrayString); // 使用字符串方式存储
    }

    @Override
    public int[] getNullableResult(ResultSet rs, String columnName)
            throws SQLException {
        String str = rs.getString(columnName);
        return str != null ? parseStringToArray(str) : null;
    }

    @Override
    public int[] getNullableResult(ResultSet rs, int columnIndex)
            throws SQLException {
        String str = rs.getString(columnIndex);
        return str != null ? parseStringToArray(str) : null;
    }

    @Override
    public int[] getNullableResult(CallableStatement cs, int columnIndex)
            throws SQLException {
        String str = cs.getString(columnIndex);
        return str != null ? parseStringToArray(str) : null;
    }

    private int[] parseStringToArray(String str) {
        String[] items = str.split(",\\s*");
        int[] array = new int[items.length];
        for (int i = 0; i < items.length; i++) {
            array[i] = Integer.parseInt(items[i]);
        }
        return array;
    }
}


