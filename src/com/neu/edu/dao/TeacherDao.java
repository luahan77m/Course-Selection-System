package com.neu.edu.dao;

import com.neu.edu.entity.Teacher;
import com.neu.edu.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
* ClassName:TeacherDao
* Description: 教师数据库操作处理
*/
public class TeacherDao{
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    /**
    * MethodName :保存
    * Description: 将一个属性与数据库表属性相对应的对象插入到数据库中
    * @param teacher 数据对象
    */
    public int  save(Teacher teacher){

        String sql = "insert into teacher (id,username,password,email,role,tellphone,remark)  values (? ,? ,? ,? ,? ,? ,?)" ;
        try {
            conn = DbUtil.getCon();
            pstmt = conn.prepareStatement(sql);
            pstmt.setObject(1,null);
            pstmt.setObject(2,teacher.getUsername());
            pstmt.setObject(3,teacher.getPassword());
            pstmt.setObject(4,teacher.getEmail());
            pstmt.setObject(5,teacher.getRole());
            pstmt.setObject(6,teacher.getTellphone());
            pstmt.setObject(7,teacher.getRemark());
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
        String sql = "delete from teacher  where id = ?" ;
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
    * @param teacher 与数据库表对应的对象
    */
    public int update(Teacher teacher) {
        String sql = "update teacher set id = ?,username = ?,password = ?,email = ?,role = ?,tellphone = ?,remark = ? where id = ?";
        try {
            conn = DbUtil.getCon();
            pstmt = conn.prepareStatement(sql);
            pstmt.setObject(1,teacher.getId());
            pstmt.setObject(2,teacher.getUsername());
            pstmt.setObject(3,teacher.getPassword());
            pstmt.setObject(4,teacher.getEmail());
            pstmt.setObject(5,teacher.getRole());
            pstmt.setObject(6,teacher.getTellphone());
            pstmt.setObject(7,teacher.getRemark());
            pstmt.setInt(8,teacher.getId());
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
    public Teacher queryById(int id){
        String sql = "select * from teacher where id = ?" ;
        try {
            conn = DbUtil.getCon();
            pstmt = conn.prepareStatement(sql);//预编译sql语句
            pstmt.setInt(1,id);
            rs = pstmt.executeQuery();
            // 获取查询的值
            while (rs.next()) {
                Teacher teacher = new Teacher();
                teacher.setId(rs.getInt("id"));
                teacher.setUsername(rs.getString("username"));
                teacher.setPassword(rs.getString("password"));
                teacher.setEmail(rs.getString("email"));
                teacher.setRole(rs.getString("role"));
                teacher.setTellphone(rs.getString("tellphone"));
                teacher.setRemark(rs.getString("remark"));
                return teacher;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbUtil.close(conn,pstmt);
        }
        return null;
    }


    public Teacher login(String username,String pasword){
        String sql = "select * from teacher where username = ? and password = ?" ;
        try {
            conn = DbUtil.getCon();
            pstmt = conn.prepareStatement(sql);//预编译sql语句
           pstmt.setString(1,username);
           pstmt.setString(2,pasword);
            rs = pstmt.executeQuery();
            // 获取查询的值
            while (rs.next()) {
                Teacher teacher = new Teacher();
                teacher.setId(rs.getInt("id"));
                teacher.setUsername(rs.getString("username"));
                teacher.setPassword(rs.getString("password"));
                teacher.setEmail(rs.getString("email"));
                teacher.setRole(rs.getString("role"));
                teacher.setTellphone(rs.getString("tellphone"));
                teacher.setRemark(rs.getString("remark"));
                return teacher;
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
    public List<Teacher> queryAll(){
        String sql = "select * from teacher" ;
        List<Teacher> list = new ArrayList<Teacher>();
        try {
            conn = DbUtil.getCon();
            pstmt = conn.prepareStatement(sql);
            Class clazz = Teacher.class;
            rs = pstmt.executeQuery();
            // 获取查询的值
            while (rs.next()) {
                Teacher teacher = new Teacher();
                teacher.setId(rs.getInt("id"));
                teacher.setUsername(rs.getString("username"));
                teacher.setPassword(rs.getString("password"));
                teacher.setEmail(rs.getString("email"));
                teacher.setRole(rs.getString("role"));
                teacher.setTellphone(rs.getString("tellphone"));
                teacher.setRemark(rs.getString("remark"));
                list.add(teacher);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbUtil.close(conn,pstmt);
        }
        return list;
    }

}
