package com.it.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * DataSource工具类
 */
public final class DataSourceUtil {

    private static DataSource dataSource;

    static{
        try {
            InputStream inputStream = DataSourceUtil.class.getClassLoader().getResourceAsStream("druid.properties");
            Properties properties = new Properties();
            properties.load(inputStream);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static DataSource getDataSource() {
        return dataSource;
    }

    public static void main(String[] args) throws Exception{
        Connection connection = DataSourceUtil.getDataSource().getConnection();
        System.out.println(connection!=null);
        connection.close();
    }
}
