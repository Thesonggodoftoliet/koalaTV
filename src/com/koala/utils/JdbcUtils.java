package com.koala.utils;/*
 * @Author_Marting.Lee
 * @Date_2019/12/25
 * @Description_JdbcUtils
 */

import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class JdbcUtils {
    private static String driver;
    private static String url;
    private static String user;
    private static String password;

    static{
        try{
            Properties ps= new Properties();
            InputStream inputStream = JdbcUtils.class.getResourceAsStream("/jdbc.properties");
            ps.load(inputStream);
            driver = ps.getProperty("driver");
            url = ps.getProperty("url");
            user = ps.getProperty("user");
            password = ps.getProperty("password");
        }catch (IOException e){
            e.printStackTrace();
        }
        try{
            Class.forName(driver);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    //与数据库取得连接
    public static Connection getCon(){
        Connection con = null;
        try{
            con = DriverManager.getConnection(url,user,password);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return con;
    }

    //多结果返回
    public static List getList(Class clazz,String sql){
        List list = new ArrayList();
        Connection con = getCon();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try{
            statement = con.prepareStatement(sql);
            resultSet = statement.executeQuery(); // 执行查询
            ResultSetMetaData metaData = resultSet.getMetaData();
            while (resultSet.next()){
                Object obj = clazz.getConstructor().newInstance();
                for (int i=1;i<=metaData.getColumnCount();i++){
                    System.out.println(resultSet.getObject(i)+"-----");
                    System.out.println(metaData.getColumnName(i));

                    BeanUtils.copyProperty(obj,metaData.getColumnName(i),resultSet.getObject(i));
                }
                list.add(obj);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }catch (InstantiationException e){
            e.printStackTrace();
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }catch (InvocationTargetException e){
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } finally {
            close(resultSet,statement,con);
        }
        return list;
    }


    //获取单个结果
    public static Object getObjectById(Class clazz, String sql,Object id) {
        Connection conn = getCon();
        PreparedStatement st = null;
        ResultSet rs = null;
        Object obj = null;
        try {
            st = conn.prepareStatement(sql);
            st.setObject(1,id);
            rs = st.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            if (rs.next()) { // 有结果
                obj = clazz.getConstructor().newInstance(); // 创建实例
                for (int i = 1; i <= metaData.getColumnCount(); i++) { // 横向读入（按列读入）
                    BeanUtils.copyProperty(obj, metaData.getColumnName(i), rs.getObject(i));
                }
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } finally {
            close(rs, st, conn);
        }
        return obj;
    }


    //获取查询结果数量
    public static int getListCount(String sql) {
        int result = 0;
        Connection conn = getCon();
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();// 执行查询语句
            while (rs.next()) {
                result++;// 数量+1
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs, st, conn);
        }
        return result;
    }

    //执行数据库语句，返回受影响行数(即查询失败为0)
    public static int executeSQL(String sql, Object... ps) {
        Connection conn = getCon();
        int executeUpdate = 0;
        PreparedStatement prepareStatement = null;
        try {
            prepareStatement = conn.prepareStatement(sql);
            for (int i = 1; i <= ps.length; i++) {// 读入参数
                prepareStatement.setObject(i, ps[i - 1]);
            }
            executeUpdate = prepareStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(null, prepareStatement, conn);
        }
        return executeUpdate;
    }


    //关闭连接
    public static void close(ResultSet resultSet,Statement statement,Connection con){
        try{
            if (resultSet != null){
                resultSet.close();
            }
            if (statement != null){
                statement.close();
            }
            if (con != null){
                con.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
