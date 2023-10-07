package com.neu.edu.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 数据库连接工具类
 */
public class DbUtil {

    static String url = "jdbc:mysql://localhost:3306/msys_course?useUnicode=true&characterEncoding=UTF8" +
            "&useInformationSchema=true&remarks=true";
    static String user = "root";
    static String pwd = "luhan0420";
    static String driver = "com.mysql.jdbc.Driver";


    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public static Connection getCon() {
        try {
            return DriverManager.getConnection(url, user, pwd);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    //关闭数据库连接
    public static void close(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if (null != resultSet) resultSet.close();
            if (null != statement) statement.close();
            if (null != connection) connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void close(Connection connection) {
        close(connection, null, null);
    }

    public static void close(Connection connection, Statement statement) {
        close(connection, statement, null);
    }

    /**
     * 传入SQL语句 获取List中的map结果
     *
     * @param sql SQL语句可以带分页 排序等 或者条件查询
     * @return
     */
    public static List<Map<String, String>> queryListMap(String sql) {
        List<Map<String, String>> mapList = new ArrayList<Map<String, String>>();
        try {
            Connection conn = getCon();
            Statement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery(sql);
            Map<String, List<String>> map = new HashMap<String, List<String>>();
            ResultSetMetaData rsmd = rs.getMetaData();
            int count = rsmd.getColumnCount();  //字段总数
            //先生成几个list对象
            String[] columnNameArr = new String[count];
            for (int i = 0; i < columnNameArr.length; i++) {
                columnNameArr[i] = rsmd.getColumnName(i + 1);
            }
            /**
             * 这里是获取的一条一条
             */
            while (rs.next()) {
                Map<String, String> mapData = new HashMap<>();
                for (int i = 0; i < columnNameArr.length; i++) {
                    mapData.put(columnNameArr[i], rs.getString(i + 1));
                }
                mapList.add(mapData);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(DbUtil.class.getName() + "查询失败" + e.getMessage());
        }
        return mapList;
    }


    /**
     * jdbc执行executeUpdate语句封装方法
     *
     * @param sql    执行sql 语句
     * @param params 参数列表
     * @return
     */
    public static int executeUpdate(String sql, Object[] params) {
        try {
            Connection connection = getCon();
            PreparedStatement ps = connection.prepareStatement(sql);
            if (params != null && params.length != 0) {
                for (int i = 0; i < params.length; i++) {
                    ps.setObject(i + 1, params[i]);
                }
            }
            int row = ps.executeUpdate();
            ps.close();
            connection.close();
            return row;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 判断字符串是否为空
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(Object str) {
        return (str == null || "".equals(str));
    }


    public static void main(String[] args) {
        System.out.println(getCon()); //输出获取的连接
    }

    


}



