package com.higgsup.jdbc;

import org.springframework.jdbc.core.RowMapper;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class MapperUtil<T> implements RowMapper<T> {

    private Class<T> tClass;

    public MapperUtil(Class<T> tClass) {
        this.tClass = tClass;
    }

    @Override
    public T mapRow(ResultSet resultSet, int i) throws SQLException {
        T t = null;
        try {
            t = tClass.newInstance();
            Field[] fields = tClass.getDeclaredFields();
            for (Field field : fields) {
                Class type = field.getType();
                if (type == String.class) {
                    field.set(t, resultSet.getString(field.getName()));
                } else if (type == Integer.class) {
                    field.set(t, resultSet.getInt(field.getName()));
                } else if (type == Long.class) {
                    field.set(t, resultSet.getLong(field.getName()));
                } else if (type == LocalDate.class) {
                    Date date = resultSet.getDate(field.getName());
                    if (date != null) {
                        field.set(t, date.toLocalDate());
                    }
                } else if (type == Float.class) {
                    field.set(t, resultSet.getFloat(field.getName()));
                } else if (type == Double.class) {
                    field.set(t, resultSet.getDouble(field.getName()));
                } else if (type == BigDecimal.class) {
                    field.set(t, resultSet.getBigDecimal(field.getName()));
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        return t;
    }
}
