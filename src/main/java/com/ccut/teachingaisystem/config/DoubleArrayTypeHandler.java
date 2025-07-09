package com.ccut.teachingaisystem.config;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

@MappedTypes(double[].class)
public class DoubleArrayTypeHandler implements TypeHandler<double[]> {
    @Override
    public void setParameter(PreparedStatement ps, int i, double[] parameter, JdbcType jdbcType) throws SQLException {
        // 将 double[] 转换为数据库支持的类型（如 VARCHAR 或 BLOB）
        // 将数组转为逗号分隔的字符串
        String arrayString = Arrays.toString(parameter)
                .replace("[", "").replace("]", "");
        ps.setString(i, arrayString); // 使用字符串方式存储
    }
    @Override
    public double[] getResult(ResultSet rs, String columnName) throws SQLException {
        // 从数据库结果集中还原 double[]
        if (rs.getString(columnName).equals("null")) {
            return null;
        }
        String str = rs.getString(columnName);
        return str != null ? parseStringToArray(str) : null;
    }

    @Override
    public double[] getResult(ResultSet rs, int columnIndex) throws SQLException {
        String str = rs.getString(columnIndex);
        return str != null ? parseStringToArray(str) : null;
    }

    @Override
    public double[] getResult(CallableStatement cs, int columnIndex) throws SQLException {
        String str = cs.getString(columnIndex);
        return str != null ? parseStringToArray(str) : null;
    }

    private double[] parseStringToArray(String str) {
        String[] items = str.split(",\\s*");
        double[] array = new double[items.length];
        for (int i = 0; i < items.length; i++) {
            array[i] = Double.parseDouble(items[i]);
        }
        return array;
    }
}
