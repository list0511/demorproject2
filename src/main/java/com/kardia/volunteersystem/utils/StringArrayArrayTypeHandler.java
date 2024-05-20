package com.kardia.volunteersystem.utils;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

public class StringArrayArrayTypeHandler extends BaseTypeHandler<String[][]> {

    // 将 Java 对象转换为数据库列值存储
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, String[][] parameter, JdbcType jdbcType) throws SQLException {
        StringBuilder value = new StringBuilder();
        for (String[] innerArray : parameter) {
            value.append(Arrays.toString(innerArray)).append(";");
        }
        ps.setString(i, value.toString());
    }

    // 将数据库列值转换为 Java 对象
    @Override
    public String[][] getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String columnValue = rs.getString(columnName);
        return convertStringToArrays(columnValue);
    }

    @Override
    public String[][] getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String columnValue = rs.getString(columnIndex);
        return convertStringToArrays(columnValue);
    }

    @Override
    public String[][] getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String columnValue = cs.getString(columnIndex);
        return convertStringToArrays(columnValue);
    }

    // 将分号分隔的字符串转换为 String[][] 数组
    private String[][] convertStringToArrays(String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        String[] arrayStrings = value.split(";");
        String[][] arrays = new String[arrayStrings.length][];
        for (int i = 0; i < arrayStrings.length; i++) {
            String[] innerArray = arrayStrings[i].replaceAll("\\[|\\]|\"", "").split(", ");
            arrays[i] = innerArray;
        }
        return arrays;
    }
}