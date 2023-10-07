package com.neu.edu.dao;

import com.neu.edu.entity.Student;
import com.neu.edu.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
* ClassName:StudentDao
* Description: 学生数据库操作处理
*/
public class StudentDao{
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    /**
    * MethodName :保存
    * Description: 将一个属性与数据库表属性相对应的对象插入到数据库中
    * @param student 数据对象
    */
    public int  save(Student student){

        String sql = "insert into student (id,username,password,sex,stnum,classinfo,department,tellphone,remark)  values (? ,? ,? ,? ,? ,? ,? ,? ,?)" ;
        try {
            conn = DbUtil.getCon();
            pstmt = conn.prepareStatement(sql);
            pstmt.setObject(1,null);
            pstmt.setObject(2,student.getUsername());
            pstmt.setObject(3,student.getPassword());
            pstmt.setObject(4,student.getSex());
            pstmt.setObject(5,student.getStnum());
            pstmt.setObject(6,student.getClassinfo());
            pstmt.setObject(7,student.getDepartment());
            pstmt.setObject(8,student.getTellphone());
            pstmt.setObject(9,student.getRemark());
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
        String sql = "delete from student  where id = ?" ;
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
    * @param student 与数据库表对应的对象
    */
    public int update(Student student) {
        String sql = "update student set id = ?,username = ?,password = ?,sex = ?,stnum = ?,classinfo = ?,department = ?,tellphone = ?,remark = ? where id = ?";
        try {
            conn = DbUtil.getCon();
            pstmt = conn.prepareStatement(sql);
            pstmt.setObject(1,student.getId());
            pstmt.setObject(2,student.getUsername());
            pstmt.setObject(3,student.getPassword());
            pstmt.setObject(4,student.getSex());
            pstmt.setObject(5,student.getStnum());
            pstmt.setObject(6,student.getClassinfo());
            pstmt.setObject(7,student.getDepartment());
            pstmt.setObject(8,student.getTellphone());
            pstmt.setObject(9,student.getRemark());
            pstmt.setInt(10,student.getId());
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
    public Student queryById(int id){
        String sql = "select * from student where id = ?" ;
        try {
            conn = DbUtil.getCon();
            pstmt = conn.prepareStatement(sql);//预编译sql语句
            pstmt.setInt(1,id);
            rs = pstmt.executeQuery();
            // 获取查询的值
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setUsername(rs.getString("username"));
                student.setPassword(rs.getString("password"));
                student.setSex(rs.getString("sex"));
                student.setStnum(rs.getString("stnum"));
                student.setClassinfo(rs.getString("classinfo"));
                student.setDepartment(rs.getString("department"));
                student.setTellphone(rs.getString("tellphone"));
                student.setRemark(rs.getString("remark"));
                return student;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbUtil.close(conn,pstmt);
        }
        return null;
    }

/*
* 登录*/
    public Student login(String username,String password){
        String sql = "select * from student where username = ? and password = ?" ;
        try {
            conn = DbUtil.getCon();
            pstmt = conn.prepareStatement(sql);//预编译sql语句
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            rs = pstmt.executeQuery();
            // 获取查询的值
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setUsername(rs.getString("username"));
                student.setPassword(rs.getString("password"));
                student.setSex(rs.getString("sex"));
                student.setStnum(rs.getString("stnum"));
                student.setClassinfo(rs.getString("classinfo"));
                student.setDepartment(rs.getString("department"));
                student.setTellphone(rs.getString("tellphone"));
                student.setRemark(rs.getString("remark"));
                return student;
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
    public List<Student> queryAll(){
        String sql = "select * from student" ;
        List<Student> list = new ArrayList<Student>();
        try {
            conn = DbUtil.getCon();
            pstmt = conn.prepareStatement(sql);
            Class clazz = Student.class;
            rs = pstmt.executeQuery();
            // 获取查询的值
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setUsername(rs.getString("username"));
                student.setPassword(rs.getString("password"));
                student.setSex(rs.getString("sex"));
                student.setStnum(rs.getString("stnum"));
                student.setClassinfo(rs.getString("classinfo"));
                student.setDepartment(rs.getString("department"));
                student.setTellphone(rs.getString("tellphone"));
                student.setRemark(rs.getString("remark"));
                list.add(student);
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
