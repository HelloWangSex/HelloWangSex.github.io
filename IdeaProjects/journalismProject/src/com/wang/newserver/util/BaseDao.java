package com.wang.newserver.util;


import com.mysql.cj.protocol.Resultset;
import jdk.nashorn.internal.runtime.ListAdapter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.*;

/**
 * @author Wang
 * @version 1.0
 * @date 2020/4/15  18:25
 */
public class BaseDao {

    //增删改通用方法
    /* 只要提供了 connection 连接 、sql语句、参数列表 param  就可以执行咯！
     * connection 数据库连接
     * sql     要执行slq语句
     * param 参数列表
     * */

    public void cudDao(Connection connection, String sql, List param) throws Exception {

        PreparedStatement pst = connection.prepareStatement(sql);
        //准备参数

        //遍历参数集合来设置参数
        for (int i = 0; i < param.size(); i++) {
            pst.setObject(i + 1, param.get(i));   // setObject 列表索引从 1  开始
        }
        //执行增删改方法...
        pst.execute();
        //关闭资源
        pst.close();
    }

    //查询通用方法
    public List<Map> queryDao(Connection connection, String sql, List param) throws Exception {
        List<Map> lists = new ArrayList<Map>();

        PreparedStatement pst = connection.prepareStatement(sql);
        for (int i = 0; i < param.size(); i++) {
            pst.setObject(i + 1, param.get(i));
        }

        //执行查询  返回结果集
        ResultSet resultSet = pst.executeQuery();

        //元数据，获取列名信息
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        //遍历结果集，封装成集合,表中每一行数据，都是一个map;
        while (resultSet.next()) {
            //每次结果集中取出一条数据 封装成一个 map;
            Map map = new HashMap();
            for (int i = 0; i < columnCount; i++) {
                //列名和列的值 传到 map 中   数据库索引是从 1 开始的
                map.put(metaData.getColumnName(i+1), resultSet.getObject(metaData.getColumnName(i+1)));
            }
            lists.add(map);
        }
        return lists;
    }


    public static void main(String[] args) throws Exception {
        Connection con = Database1.getCon();
        BaseDao baseDao = new BaseDao();
        //增
       /* String sql = "insert into test(name ,password)values(?,?)";
        List param = new ArrayList();
        param.add("tom");
        param.add("123");*/

        //修改
        /*String sql = "update test set name=? where id=?";
        List param = new ArrayList();
        param.add("wang");
        param.add(9);*/

        //删除
       /* String sql = "delete from test where id=?";
        List param = new ArrayList();
        param.add(9);
        baseDao.cudDao(con, sql, param);*/

        //测试查询
       String sql="select * from test";
        List param=new ArrayList();
        List lists=baseDao.queryDao(con,sql,param);
        System.out.println(lists);
        con.close();

    }
}
