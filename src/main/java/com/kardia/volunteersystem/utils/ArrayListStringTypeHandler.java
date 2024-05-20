package com.kardia.volunteersystem.utils;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListStringTypeHandler extends BaseTypeHandler<ArrayList<String>> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, ArrayList<String> parameter, JdbcType jdbcType) throws SQLException {
        String str = String.join(",", parameter);
        ps.setString(i, str);
    }

    @Override
    public ArrayList<String> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String str = rs.getString(columnName);
        return str == null ? new ArrayList<>() : new ArrayList<>(Arrays.asList(str.split(",")));
    }

    @Override
    public ArrayList<String> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String str = rs.getString(columnIndex);
        return str == null ? new ArrayList<>() : new ArrayList<>(Arrays.asList(str.split(",")));
    }

    @Override
    public ArrayList<String> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String str = cs.getString(columnIndex);
        return str == null ? new ArrayList<>() : new ArrayList<>(Arrays.asList(str.split(",")));
    }
}
