package com.neu.edu.servlet;

import com.neu.edu.dao.StudentDao;
import com.neu.edu.dao.TeacherDao;
import com.neu.edu.entity.Student;
import com.neu.edu.entity.Teacher;
import com.neu.edu.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
* ClassName:StudentServlet
* Description:学生请求处理
*/
@WebServlet(name = "StudentServlet",urlPatterns = "/StudentServlet")
public class StudentServlet extends HttpServlet {

    StudentDao studentDao = new StudentDao();
    TeacherDao teacherDao = new TeacherDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // 设置请求编码集 防止接收参数乱码
//        request.setCharacterEncoding("utf-8");
//        // 设置响应格式为网页编码，编码为utf-8 防止输出乱码
//        response.setCharacterEncoding("utf-8");
        if(request.getParameter("type").equals("save")){
            //增加
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
        }else if (request.getParameter("type").equals("get")){
            //根据学生的id查询特定学生的详细信息
            get(request,response);
        }else if (request.getParameter("type").equals("edit")){
            // 该方法用于根据学生的id查询特定学生的信息，并转发到学生信息编辑页面
            edit(request,response);
        }else if (request.getParameter("type").equals("login")){
            //登录操作.
            login(request,response);
        }else if (request.getParameter("type").equals("logout")){
            //退出登录操作...
            logout(request,response);
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




    //添加Student信息
    protected void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String password=request.getParameter("password");
        String classinfo=request.getParameter("classinfo");
        String sex=request.getParameter("sex");
        String remark=request.getParameter("remark");
        String department=request.getParameter("department");
        String tellphone=request.getParameter("tellphone");
        String username=request.getParameter("username");
        String stnum=request.getParameter("stnum");

        Student obj=new  Student();

        obj.setPassword(password);
        obj.setClassinfo(classinfo);
        obj.setSex(sex);
        obj.setRemark(remark);
        obj.setDepartment(department);
        obj.setTellphone(tellphone);
        obj.setUsername(username);
        obj.setStnum(stnum);

        studentDao.save(obj);//调用数据库添加
        response.sendRedirect("StudentServlet?type=query");
    }

    //修改Student信息
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String password=request.getParameter("password");
        String classinfo=request.getParameter("classinfo");
        String sex=request.getParameter("sex");
        String remark=request.getParameter("remark");
        String id=request.getParameter("id");
        String department=request.getParameter("department");
        String tellphone=request.getParameter("tellphone");
        String username=request.getParameter("username");
        String stnum=request.getParameter("stnum");

        Student obj=new  Student();

        obj.setPassword(password);
        obj.setClassinfo(classinfo);
        obj.setSex(sex);
        obj.setRemark(remark);
         obj.setId(Integer.parseInt(id));
        obj.setDepartment(department);
        obj.setTellphone(tellphone);
        obj.setUsername(username);
        obj.setStnum(stnum);

        studentDao.update(obj); //调用数据库修改功能
        response.sendRedirect("StudentServlet?type=query");
    }


    //根据主键id删除Student信息 id是整数
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr=request.getParameter("id");
        Integer id= Integer.parseInt(idStr);
        studentDao.delete(id);//调用数据库删除
        response.sendRedirect("StudentServlet?type=query");
    }


    //Student查询数据库中的所有数据
    protected void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用数据库查询所有方法
        List<Student>  studentList=studentDao.queryAll(); //调用数据库查询所有
        request.setAttribute("studentList",studentList);   //绑定接受参数
        request.getRequestDispatcher("studentList.jsp").forward(request,response);
    }


    //Student查询数据库中的所有数据
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        //调用数据库查询所有方法
        String username = request.getParameter("username");
        String password=request.getParameter("password");
        String role = request.getParameter("role");

        if("主管教师".equals(role)){
            Teacher teacher1 = teacherDao.login(username, password);
            if(null==teacher1){
                //如果验证失败，则将错误信息存储在请求的属性中，并转发回登录页面denglu.jsp进行显示。
                request.setAttribute("msg","请检查用户名密码及权限");
                request.getRequestDispatcher("denglu.jsp").forward(request,response);
                return;
            }else{
                //如果验证通过，则创建一个User对象表示登录用户，并将其存储在会话中，然后转发到main.jsp页面
                User user = new User();
                user.setId(teacher1.getId());
                user.setUsername(teacher1.getUsername());
                user.setPassword(teacher1.getPassword());
                user.setRole("主管教师");
                request.getSession().setAttribute("loginUser",user);
                request.getRequestDispatcher("main.jsp").forward(request,response);
                return;
            }

        }

        if("主讲教师".equals(role)){
            Teacher teacher2 = teacherDao.login(username, password);
            if(null==teacher2){
                request.setAttribute("msg","请检查用户名密码及权限");
                request.getRequestDispatcher("denglu.jsp").forward(request,response);
                return;
            }else{
                User user = new User();
                user.setId(teacher2.getId());
                user.setUsername(teacher2.getUsername());
                user.setPassword(teacher2.getPassword());
                user.setRole("主讲教师");
                request.getSession().setAttribute("loginUser",user);
                request.getRequestDispatcher("main.jsp").forward(request,response);
                return;
            }
        }

        if("学生".equals(role)){
            Student student = studentDao.login(username,password);
            if(null==student){
                request.setAttribute("msg","请检查用户名密码及权限");
                request.getRequestDispatcher("denglu.jsp").forward(request,response);
                return;
            }else{
                User user = new User();
                user.setId(student.getId());
                user.setUsername(student.getUsername());
                user.setPassword(student.getPassword());
                user.setRole("学生");
                request.getSession().setAttribute("loginUser",user);
                request.getRequestDispatcher("main.jsp").forward(request,response);
                return;
            }
        }
    }

    //退出登录
    protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从会话中移除存储的登录用户信息，并将请求转发回登录页面denglu.jsp
        request.getSession().removeAttribute("loginUser");
        request.getRequestDispatcher("denglu.jsp").forward(request,response);
    }


    //Student根据主键id查询数据
    protected void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用数据库查询所有方法
        String idStr=request.getParameter("id");
        Integer id= Integer.parseInt(idStr);
        Student  student=studentDao.queryById(id); //调用数据库根据主键查询
        request.setAttribute("student",student);   //绑定接受参数
        request.getRequestDispatcher("studentDetail.jsp").forward(request,response);
    }

    //Student根据主键id查询数据 跳转到编辑页面
    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用数据库查询所有方法
        String idStr=request.getParameter("id");
        Integer id= Integer.parseInt(idStr);
        Student  student=studentDao.queryById(id); //调用数据库根据主键查询
        request.setAttribute("student",student);   //绑定接受参数
        request.getRequestDispatcher("studentUpdate.jsp").forward(request,response);
    }




}
