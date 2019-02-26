package com.lixiangyu.lee.classloader;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-01-24 14:36
 **/
public class DestroyParentMode {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        String url = "jdbc:mysql://47.97.19.30:3306/posprom";
        // 通过java库获取数据库连接
        Connection conn = java.sql.DriverManager.getConnection(url, "root", "miya@888");
        conn.prepareStatement("select * from run_promotion_gift");

        conn.close();

//        URL[] urls = ((URLClassLoader)ClassLoader.getSystemClassLoader()).getURLs();
//        for (URL urla : urls) {
//            System.out.println(urla);
//        }
    }


}
