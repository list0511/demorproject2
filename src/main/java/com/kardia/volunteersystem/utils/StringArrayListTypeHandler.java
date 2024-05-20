package com.kardia.volunteersystem.utils;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringArrayListTypeHandler extends BaseTypeHandler<List<String[]>> {

    // 将 Java 对象转换为数据库列值存储
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, List<String[]> parameter, JdbcType jdbcType) throws SQLException {
        StringBuilder value = new StringBuilder();
        for (String[] innerArray : parameter) {
            value.append(Arrays.toString(innerArray)).append(";");
        }
        ps.setString(i, value.toString());
    }

    // 将数据库列值转换为 Java 对象
    @Override
    public List<String[]> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String columnValue = rs.getString(columnName);
        return convertStringToListArrays(columnValue);
    }

    @Override
    public List<String[]> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String columnValue = rs.getString(columnIndex);
        return convertStringToListArrays(columnValue);
    }

    @Override
    public List<String[]> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String columnValue = cs.getString(columnIndex);
        return convertStringToListArrays(columnValue);
    }

    // 将分号分隔的字符串转换为 List<String[]> 列表
    private List<String[]> convertStringToListArrays(String value) {
        if (value == null || value.isEmpty()) {
            return new ArrayList<>();
        }
        String[] arrayStrings = value.split(";");
        List<String[]> arrays = new ArrayList<>();
        for (String arrayString : arrayStrings) {
            String[] innerArray = arrayString.replaceAll("\\[|\\]|\"", "").split(", ");
            arrays.add(innerArray);
        }
        return arrays;
    }
}
