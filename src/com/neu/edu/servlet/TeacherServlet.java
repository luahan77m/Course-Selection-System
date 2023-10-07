package com.neu.edu.servlet;

import com.neu.edu.dao.TeacherDao;
import com.neu.edu.entity.Teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
* ClassName:TeacherServlet
* Description:教师请求处理
*/
@WebServlet(name = "TeacherServlet",urlPatterns = "/TeacherServlet")
public class TeacherServlet extends HttpServlet {

    TeacherDao teacherDao = new TeacherDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // 设置请求编码集 防止接收参数乱码
//        request.setCharacterEncoding("utf-8");
//        // 设置响应格式为网页编码，编码为utf-8 防止输出乱码
//        response.setCharacterEncoding("utf-8");
        if(request.getParameter("type").equals("save")){
            //插入
            save(request,response);
        }else if (request.getParameter("type").equals("delete")){
            //删除
            delete(request,response);
        }else if (request.getParameter("type").equals("update")){
            //修改
            update(request,response);
        }else if (request.getParameter("type").equals("query")){
            //查询
            query(request,response);
        }else if (request.getParameter("type").equals("edit")){
            //该方法用于根据老师的id查询特定学生的信息，并转发到老师信息编辑页面
            edit(request,response);
        }else{
            System.err.println("动作类型不匹配！");
        }

        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.write("write something here!");

        writer.flush();
        writer.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }




    //添加Teacher信息
    protected void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String password=request.getParameter("password");
        String role=request.getParameter("role");
        String remark=request.getParameter("remark");
        String tellphone=request.getParameter("tellphone");
        String email=request.getParameter("email");
        String username=request.getParameter("username");

        Teacher obj=new  Teacher();

        obj.setPassword(password);
        obj.setRole(role);
        obj.setRemark(remark);
        obj.setTellphone(tellphone);
        obj.setEmail(email);
        obj.setUsername(username);

        teacherDao.save(obj);//调用数据库添加
        response.sendRedirect("TeacherServlet?type=query");
    }

    //修改Teacher信息
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String password=request.getParameter("password");
        String role=request.getParameter("role");
        String remark=request.getParameter("remark");
        String id=request.getParameter("id");
        String tellphone=request.getParameter("tellphone");
        String email=request.getParameter("email");
        String username=request.getParameter("username");

        Teacher obj=new  Teacher();

        obj.setPassword(password);
        obj.setRole(role);
        obj.setRemark(remark);
         obj.setId(Integer.parseInt(id));
        obj.setTellphone(tellphone);
        obj.setEmail(email);
        obj.setUsername(username);

        teacherDao.update(obj); //调用数据库修改功能
        response.sendRedirect("TeacherServlet?type=query");
    }


    //根据主键id删除Teacher信息 id是整数
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr=request.getParameter("id");
        Integer id= Integer.parseInt(idStr);
        teacherDao.delete(id);//调用数据库删除
        response.sendRedirect("TeacherServlet?type=query");
    }


    //Teacher查询数据库中的所有数据
    protected void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用数据库查询所有方法
        List<Teacher>  teacherList=teacherDao.queryAll(); //调用数据库查询所有
        request.setAttribute("teacherList",teacherList);   //绑定接受参数
        request.getRequestDispatcher("teacherList.jsp").forward(request,response);
    }




    //Teacher根据主键id查询数据 跳转到编辑页面
    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用数据库查询所有方法
        String idStr=request.getParameter("id");
        Integer id= Integer.parseInt(idStr);
        Teacher  teacher=teacherDao.queryById(id); //调用数据库根据主键查询
        request.setAttribute("teacher",teacher);   //绑定接受参数
        request.getRequestDispatcher("teacherUpdate.jsp").forward(request,response);
    }




}
