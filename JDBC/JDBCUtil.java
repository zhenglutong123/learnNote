package com.test.code;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author zlt
 * @create 2021-06-03 10:19
 */
public class JDBCUtil<T> {

    public static Connection getConnection() throws Exception {
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
        Properties pro=new Properties();
        pro.load(is);
        String driver=pro.getProperty("driver");
        String url=pro.getProperty("url");
        String user=pro.getProperty("user");
        String password=pro.getProperty("password");

        Class.forName(driver);
        return DriverManager.getConnection(url, user, password);

    }

    public static void closeResource(Connection conn, PreparedStatement pre){
        try {
            if(conn!=null)
                conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if(pre!=null)
                pre.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void closeQueryResource(Connection conn, PreparedStatement pre,ResultSet rs){
        try {
            if(conn!=null)
                conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if(pre!=null)
                pre.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            if(rs!=null)
                rs.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    //通用的增删改操作
    public static void unifiedSQL(String sql,Object... args)  {
        Connection connection =null;
        PreparedStatement ps=null;
        try {
             connection = getConnection();
             ps = connection.prepareStatement(sql);

            if(args!=null && args.length>0){
                for (int i = 0; i < args.length; i++) {
                    ps.setObject(i+1,args[i]);
                }
            }
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            closeResource(connection,ps);
        }
    }

    //通用的查询操作
    public static <T> List<T> querySQl(Class<T> clazz,String sql,Object... args)  {
        Connection connection =null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            connection = getConnection();
            ps = connection.prepareStatement(sql);

            if(args!=null && args.length>0){
                for (int i = 0; i < args.length; i++) {
                    ps.setObject(i+1,args[i]);
                }
            }
            //结果集
            rs = ps.executeQuery();
            //元数据
            ResultSetMetaData metaData = rs.getMetaData();
            //有多少列
            int columnCount = metaData.getColumnCount();
            List<T> list=new ArrayList<T>();
            while(rs.next()){
                T t = clazz.newInstance();
                for (int i = 0; i < columnCount; i++) {

                    Object value = rs.getObject(i + 1);
                    //获取每个列的列名
                    String columnLabel = metaData.getColumnLabel(i + 1);

                    //给对象指定的列名赋值
                    Field declaredField = clazz.getDeclaredField(columnLabel);
                    //设置可访问
                    declaredField.setAccessible(true);
                    declaredField.set(t,value);
                }
                list.add(t);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            closeQueryResource(connection,ps,rs);
        }
        return null;
    }
}
