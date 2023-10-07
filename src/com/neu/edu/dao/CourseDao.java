package com.neu.edu.dao;

import com.neu.edu.entity.Course;
import com.neu.edu.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
* ClassName:CourseDao
* Description: 课程数据库操作处理
*/
public class CourseDao{
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    /**
    * MethodName :保存
    * Description: 将一个属性与数据库表属性相对应的对象插入到数据库中
    * @param course 数据对象
    */
    public int  save(Course course){

        String sql = "insert into course (id,name,content,period,credit,stid,atid,classroom,timeinfo,remark)  values (? ,? ,? ,? ,? ,? ,? ,? ,? ,?)" ;
        try {
            conn = DbUtil.getCon();
            pstmt = conn.prepareStatement(sql);
            pstmt.setObject(1,null);
            pstmt.setObject(2,course.getName());
            pstmt.setObject(3,course.getContent());
            pstmt.setObject(4,course.getPeriod());
            pstmt.setObject(5,course.getCredit());
            pstmt.setObject(6,course.getStid());
            pstmt.setObject(7,course.getAtid());
            pstmt.setObject(8,course.getClassroom());
            pstmt.setObject(9,course.getTimeinfo());
            pstmt.setObject(10,course.getRemark());
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
        String sql = "delete from course  where id = ?" ;
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
    * @param course 与数据库表对应的对象
    */
    public int update(Course course) {
        String sql = "update course set id = ?,name = ?,content = ?,period = ?,credit = ?,stid = ?,atid = ?,classroom = ?,timeinfo = ?,remark = ? where id = ?";
        try {
            conn = DbUtil.getCon();
            pstmt = conn.prepareStatement(sql);
            pstmt.setObject(1,course.getId());
            pstmt.setObject(2,course.getName());
            pstmt.setObject(3,course.getContent());
            pstmt.setObject(4,course.getPeriod());
            pstmt.setObject(5,course.getCredit());
            pstmt.setObject(6,course.getStid());
            pstmt.setObject(7,course.getAtid());
            pstmt.setObject(8,course.getClassroom());
            pstmt.setObject(9,course.getTimeinfo());
            pstmt.setObject(10,course.getRemark());
            pstmt.setInt(11,course.getId());
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
    public Course queryById(int id){
        String sql = "select * from course where id = ?" ;
        try {
            conn = DbUtil.getCon();
            pstmt = conn.prepareStatement(sql);//预编译sql语句
            pstmt.setInt(1,id);
            rs = pstmt.executeQuery();
            // 获取查询的值
            while (rs.next()) {
                Course course = new Course();
                course.setId(rs.getInt("id"));
                course.setName(rs.getString("name"));
                course.setContent(rs.getString("content"));
                course.setPeriod(rs.getString("period"));
                course.setCredit(rs.getString("credit"));
                course.setStid(rs.getString("stid"));
                course.setAtid(rs.getString("atid"));
                course.setClassroom(rs.getString("classroom"));
                course.setTimeinfo(rs.getString("timeinfo"));
                course.setRemark(rs.getString("remark"));
                return course;
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
    public List<Course> queryAll(){
        String sql = "select * from course" ;
        List<Course> list = new ArrayList<Course>();
        try {
            conn = DbUtil.getCon();
            pstmt = conn.prepareStatement(sql);
            Class clazz = Course.class;
            rs = pstmt.executeQuery();
            // 获取查询的值
            while (rs.next()) {
                Course course = new Course();
                course.setId(rs.getInt("id"));
                course.setName(rs.getString("name"));
                course.setContent(rs.getString("content"));
                course.setPeriod(rs.getString("period"));
                course.setCredit(rs.getString("credit"));
                course.setStid(rs.getString("stid"));
                course.setAtid(rs.getString("atid"));
                course.setClassroom(rs.getString("classroom"));
                course.setTimeinfo(rs.getString("timeinfo"));
                course.setRemark(rs.getString("remark"));
                list.add(course);
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
