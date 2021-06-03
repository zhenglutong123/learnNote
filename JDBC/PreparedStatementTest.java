package com.test.code;

import org.junit.Test;

import java.util.List;

/**
 * @author zlt
 * @create 2021-06-03 14:55
 */
public class PreparedStatementTest {
    @Test
    public void test01(){
//        String sql="insert into user_test values('1','张三',18),('2','李四',18),('3','王五',18),('5','赵六',18)";
//        String sql="delete from user_test where id=?";
//        String sql="update user_test set id=? where id=?";
//        JDBCUtil.unifiedSQL(sql, 1,3);

        String sql="select * from user_test";
        List<UsetBean> usetBeans = JDBCUtil.querySQl(UsetBean.class, sql, null);
        for (UsetBean usetBean : usetBeans) {
            System.out.println(usetBean);
        }
    }
}
