package com.neu.edu.dao;

import com.neu.edu.entity.Applyinfo;
import com.neu.edu.util.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
* ClassName:ApplyinfoDao
* Description: 课程申请数据库操作处理
*/
public class ApplyinfoDao {
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    /**
    * MethodName :保存
    * Description: 将一个属性与数据库表属性相对应的对象插入到数据库中
    * @param applyinfo 数据对象
    */
    public int  save(Applyinfo applyinfo){

        String sql = "insert into applyinfo (id,sid,cid,content,prove,status,ctime,stid,stname,streason,atid,atname,atreason,remark)  values (? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,?)" ;
        try {
            conn = DbUtil.getCon();
            pstmt = conn.prepareStatement(sql);
            pstmt.setObject(1,null);
            pstmt.setObject(2,applyinfo.getSid());
            pstmt.setObject(3,applyinfo.getCid());
            pstmt.setObject(4,applyinfo.getContent());
            pstmt.setObject(5,applyinfo.getProve());
            pstmt.setObject(6,applyinfo.getStatus());
            pstmt.setObject(7,applyinfo.getCtime());
            pstmt.setObject(8,applyinfo.getStid());
            pstmt.setObject(9,applyinfo.getStname());
            pstmt.setObject(10,applyinfo.getStreason());
            pstmt.setObject(11,applyinfo.getAtid());
            pstmt.setObject(12,applyinfo.getAtname());
            pstmt.setObject(13,applyinfo.getAtreason());
            pstmt.setObject(14,applyinfo.getRemark());
            int i =  pstmt.executeUpdate();
            return i;
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            DbUtil.close(conn,pstmt);
        }
        return 0;
    }

    /**
    * MethodName: 删除
    * Description: 将一个属性与数据库表属性相对应的对象从数据库中删除(通过设置该对象id,通过id删除信息记录)
    */
    public int delete(int id){
        String sql = "delete from applyinfo  where id = ?" ;
        try {
            conn = DbUtil.getCon();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            int i = pstmt.executeUpdate();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbUtil.close(conn,pstmt);
        }
        return 0;
    }

    /**
    * MethodName 修改
    * Description 通过id修改数据库表
    * @param applyinfo 与数据库表对应的对象
    */
    public int update(Applyinfo applyinfo) {
        String sql = "update applyinfo set id = ?,sid = ?,cid = ?,content = ?,prove = ?,status = ?,ctime = ?,stid = ?,stname = ?,streason = ?,atid = ?,atname = ?,atreason = ?,remark = ? where id = ?";
        try {
            conn = DbUtil.getCon();
            pstmt = conn.prepareStatement(sql);
            pstmt.setObject(1,applyinfo.getId());
            pstmt.setObject(2,applyinfo.getSid());
            pstmt.setObject(3,applyinfo.getCid());
            pstmt.setObject(4,applyinfo.getContent());
            pstmt.setObject(5,applyinfo.getProve());
            pstmt.setObject(6,applyinfo.getStatus());
            pstmt.setObject(7,applyinfo.getCtime());
            pstmt.setObject(8,applyinfo.getStid());
            pstmt.setObject(9,applyinfo.getStname());
            pstmt.setObject(10,applyinfo.getStreason());
            pstmt.setObject(11,applyinfo.getAtid());
            pstmt.setObject(12,applyinfo.getAtname());
            pstmt.setObject(13,applyinfo.getAtreason());
            pstmt.setObject(14,applyinfo.getRemark());
            pstmt.setInt(15,applyinfo.getId());
            int i = pstmt.executeUpdate();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbUtil.close(conn,pstmt);
        }
        return 0;
    }

    /**
    * MethodName 查询
    * Description 通过id查询数据库信息记录(通过设置该对象id,通过id查询信息记录)
    */
    public Applyinfo queryById(int id){
        String sql = "select * from applyinfo where id = ?" ;
        try {
            conn = DbUtil.getCon();
            pstmt = conn.prepareStatement(sql);//预编译sql语句
            pstmt.setInt(1,id);
            rs = pstmt.executeQuery();
            // 获取查询的值
            while (rs.next()) {
                Applyinfo applyinfo = new Applyinfo();
                applyinfo.setId(rs.getInt("id"));
                applyinfo.setSid(rs.getString("sid"));
                applyinfo.setCid(rs.getString("cid"));
                applyinfo.setContent(rs.getString("content"));
                applyinfo.setProve(rs.getString("prove"));
                applyinfo.setStatus(rs.getString("status"));
                applyinfo.setCtime(rs.getString("ctime"));
                applyinfo.setStid(rs.getString("stid"));
                applyinfo.setStname(rs.getString("stname"));
                applyinfo.setStreason(rs.getString("streason"));
                applyinfo.setAtid(rs.getString("atid"));
                applyinfo.setAtname(rs.getString("atname"));
                applyinfo.setAtreason(rs.getString("atreason"));
                applyinfo.setRemark(rs.getString("remark"));
                return applyinfo;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbUtil.close(conn,pstmt);
        }
        return null;
    }

    /**
    * MethodName 查询
    * Description 通过id查询数据库信息记录(通过设置该对象id,通过id查询信息记录)
    */
    public List<Applyinfo> queryAll(){
        String sql = "select * from applyinfo" ;
        List<Applyinfo> list = new ArrayList<Applyinfo>();
        try {
            conn = DbUtil.getCon();
            pstmt = conn.prepareStatement(sql);
            Class clazz = Applyinfo.class;
            rs = pstmt.executeQuery();
            // 获取查询的值
            while (rs.next()) {
                Applyinfo applyinfo = new Applyinfo();
                applyinfo.setId(rs.getInt("id"));
                applyinfo.setSid(rs.getString("sid"));
                applyinfo.setCid(rs.getString("cid"));
                applyinfo.setContent(rs.getString("content"));
                applyinfo.setProve(rs.getString("prove"));
                applyinfo.setStatus(rs.getString("status"));
                applyinfo.setCtime(rs.getString("ctime"));
                applyinfo.setStid(rs.getString("stid"));
                applyinfo.setStname(rs.getString("stname"));
                applyinfo.setStreason(rs.getString("streason"));
                applyinfo.setAtid(rs.getString("atid"));
                applyinfo.setAtname(rs.getString("atname"));
                applyinfo.setAtreason(rs.getString("atreason"));
                applyinfo.setRemark(rs.getString("remark"));
                list.add(applyinfo);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbUtil.close(conn,pstmt);
        }
        return list;
    }

    public List<Applyinfo> byCid(String cid){
        String sql = "select * from applyinfo where cid = ?" ;
        List<Applyinfo> list = new ArrayList<Applyinfo>();
        try {
            conn = DbUtil.getCon();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,cid);
            Class clazz = Applyinfo.class;
            rs = pstmt.executeQuery();
            // 获取查询的值
            while (rs.next()) {
                Applyinfo applyinfo = new Applyinfo();
                applyinfo.setId(rs.getInt("id"));
                applyinfo.setSid(rs.getString("sid"));
                applyinfo.setCid(rs.getString("cid"));
                applyinfo.setContent(rs.getString("content"));
                applyinfo.setProve(rs.getString("prove"));
                applyinfo.setStatus(rs.getString("status"));
                applyinfo.setCtime(rs.getString("ctime"));
                applyinfo.setStid(rs.getString("stid"));
                applyinfo.setStname(rs.getString("stname"));
                applyinfo.setStreason(rs.getString("streason"));
                applyinfo.setAtid(rs.getString("atid"));
                applyinfo.setAtname(rs.getString("atname"));
                applyinfo.setAtreason(rs.getString("atreason"));
                applyinfo.setRemark(rs.getString("remark"));
                list.add(applyinfo);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbUtil.close(conn,pstmt);
        }
        return list;
    }
    public List<Applyinfo> queryByPage(int startIndex, int pageSize) {
        List<Applyinfo> applyinfoList = new ArrayList<>();

        try {// 创建SQL查询语句
             String sql = "SELECT * FROM applyinfo LIMIT ?, ?";

             // 创建PreparedStatement对象
             PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, pageSize);
            statement.setInt(2, startIndex);

            ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    Applyinfo applyinfo = new Applyinfo();
                    applyinfo.setId(rs.getInt("id"));
                    applyinfo.setSid(rs.getString("sid"));
                    applyinfo.setCid(rs.getString("cid"));
                    applyinfo.setContent(rs.getString("content"));
                    applyinfo.setProve(rs.getString("prove"));
                    applyinfo.setStatus(rs.getString("status"));
                    applyinfo.setCtime(rs.getString("ctime"));
                    applyinfo.setStid(rs.getString("stid"));
                    applyinfo.setStname(rs.getString("stname"));
                    applyinfo.setStreason(rs.getString("streason"));
                    applyinfo.setAtid(rs.getString("atid"));
                    applyinfo.setAtname(rs.getString("atname"));
                    applyinfo.setAtreason(rs.getString("atreason"));
                    applyinfo.setRemark(rs.getString("remark"));
                    applyinfoList.add(applyinfo);
                }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return applyinfoList;
    }





}
