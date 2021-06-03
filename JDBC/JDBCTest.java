package com.test.jdbc;

import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author zlt
 * @create 2021-06-02 17:08
 */
public class JDBCTest {

    //方式1
    @Test
    public void test01() throws SQLException {
        //加载驱动
        Driver driver=new com.mysql.jdbc.Driver();

        String url="jdbc:mysql://localhost:3306/";
        Properties p=new Properties();
        p.setProperty("user","root");
        p.setProperty("password","123456");
        //连接数据库
        Connection connect = driver.connect(url, p);
        System.out.println(connect);
    }

    //方式2
    @Test
    public void test02() throws Exception {
        //加载驱动
        Class<?> clazz = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver)clazz.newInstance();

        String url="jdbc:mysql://localhost:3306/";
        Properties p=new Properties();
        p.setProperty("user","root");
        p.setProperty("password","123456");
        //连接数据库
        Connection connect = driver.connect(url, p);
        System.out.println(connect);
    }

    //方式3
    @Test
    public void test03() throws Exception {
        //加载驱动
        Class<?> clazz = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver)clazz.newInstance();


        String url="jdbc:mysql://localhost:3306/";
        String user="root";
        String password="123456";

        //注册驱动
        DriverManager.registerDriver(driver);
        //连接数据库
        Connection connection = DriverManager.getConnection(url, user, password);

        System.out.println(connection);
    }

    //方式4
    @Test
    public void test04() throws Exception {

        String url="jdbc:mysql://localhost:3306/";
        String user="root";
        String password="123456";
        //加载驱动
        Class.forName("com.mysql.jdbc.Driver");
//      Driver driver = (Driver)clazz.newInstance();
//      //注册驱动
//      DriverManager.registerDriver(driver);
        //连接数据库
        Connection connection = DriverManager.getConnection(url, user, password);

        System.out.println(connection);
    }

    //方式5
    @Test
    public void test05() throws Exception {
        //1.读取配置文件信息
        InputStream is = JDBCTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties pro=new Properties();
        pro.load(is);

        String driver=pro.getProperty("driver");
        String url=pro.getProperty("url");
        String user=pro.getProperty("user");
        String password=pro.getProperty("password");
        //2.加载驱动
        Class.forName(driver);
        //3.连接数据库
        Connection connection = DriverManager.getConnection(url, user, password);

        System.out.println(connection);
    }
}
