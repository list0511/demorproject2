package com.kardia.volunteersystem.utils;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

public class StringArrayTypeHandler extends BaseTypeHandler<String[]> {

    // 将 Java 对象转换为数据库列值存储
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, String[] parameter, JdbcType jdbcType) throws SQLException {
        // 将 String[] 数组转换为逗号分隔的字符串
        String value = Arrays.toString(parameter);
        // 去除首尾的方括号
        value = value.substring(1, value.length() - 1);
        ps.setString(i, value);
    }

    // 将数据库列值转换为 Java 对象
    @Override
    public String[] getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String columnValue = rs.getString(columnName);
        return convertStringToArray(columnValue);
    }

    @Override
    public String[] getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String columnValue = rs.getString(columnIndex);
        return convertStringToArray(columnValue);
    }

    @Override
    public String[] getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String columnValue = cs.getString(columnIndex);
        return convertStringToArray(columnValue);
    }

    // 将逗号分隔的字符串转换为 String[] 数组
    private String[] convertStringToArray(String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        // 去除空格，并分割逗号分隔的字符串
        String[] array = value.replaceAll(" ", "").split(",");
        // 去除数组中每个元素的首尾引号
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i].replaceAll("^\"|\"$", "");
        }
        return array;
    }
}