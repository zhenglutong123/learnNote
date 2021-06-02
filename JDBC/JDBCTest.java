package src;

import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


/**
 * @author zlt
 * @create 2021-06-02 14:15
 */
public class JDBCTest {

    //方式一
    @Test
    public void test01() throws SQLException {
        Driver driver=new com.mysql.jdbc.Driver();

        String url="jdbc:mysql://localhost:3306/eleguaranteedb";
        Properties info=new Properties();
        info.setProperty("user","root");
        info.setProperty("password","123456");
        Connection connect = driver.connect(url, info);
        System.out.println(connect);
    }

    //方式二
    @Test
    public void test02() throws Exception {
        InputStream resourceAsStream = Connection.class.getClassLoader().getResourceAsStream("src\\jdbc.properties");

        Properties info=new Properties();
        info.load(resourceAsStream);
        Class.forName(info.getProperty("driver"));
        DriverManager.getConnection(info.getProperty("driver"),info.getProperty("user"),info.getProperty("password"));
    }
}
