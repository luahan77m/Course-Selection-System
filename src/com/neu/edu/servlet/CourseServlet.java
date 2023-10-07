package com.neu.edu.servlet;

import com.neu.edu.dao.ApplyinfoDao;
import com.neu.edu.dao.CourseDao;
import com.neu.edu.dao.TeacherDao;
import com.neu.edu.entity.Applyinfo;
import com.neu.edu.entity.Course;
import com.neu.edu.entity.Teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
* ClassName:CourseServlet
* Description:课程请求处理
*/
@WebServlet(name = "CourseServlet",urlPatterns = "/CourseServlet")
public class CourseServlet extends HttpServlet {

    CourseDao courseDao = new CourseDao();

    TeacherDao teacherDao=new TeacherDao();

    ApplyinfoDao applyinfoDao=new ApplyinfoDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // 设置请求编码集 防止接收参数乱码
//        request.setCharacterEncoding("utf-8");
//        // 设置响应格式为网页编码，编码为utf-8 防止输出乱码
//        response.setCharacterEncoding("utf-8");
        if(request.getParameter("type").equals("save")){
            //插入操作业务...
            save(request,response);
        }else if (request.getParameter("type").equals("delete")){
            //删除操作业务...
            delete(request,response);
        }else if (request.getParameter("type").equals("update")){
            //修改操作业务...
            update(request,response);
        }else if (request.getParameter("type").equals("query")){
            //查询所有操作业务...
            query(request,response);
        }else if (request.getParameter("type").equals("preadd")){
            //查询数据库中的所有教师信息，并将结果传递给courseAdd.jsp页面进行展示。该方法用于添加课程前的准备工作。
            preadd(request,response);
        }else if (request.getParameter("type").equals("choose")){
            //查询数据库中的所有课程信息，并将结果传递给courseChooseList.jsp页面进行展示。该方法还接收用户id并根据用户选择的课程进行标记。
            choose(request,response);
        }else if (request.getParameter("type").equals("me")){
            //查询该主管教师数据库中的所有课程申请信息，并将结果传递给courseMeList.jsp页面进行展示。
            me(request,response);
        }else if (request.getParameter("type").equals("edit")){
            //根据主键id查询数据库中的课程信息，并将结果传递给courseUpdate.jsp页面进行展示。
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




    //添加Course信息
    protected void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String period=request.getParameter("period");
        String atid=request.getParameter("atid");
        String name=request.getParameter("name");
        String stid=request.getParameter("stid");
        String classroom=request.getParameter("classroom");
        String remark=request.getParameter("remark");
        String credit=request.getParameter("credit");
        String timeinfo=request.getParameter("timeinfo");
        String content=request.getParameter("content");

        Course obj=new  Course();

        obj.setPeriod(period);
        obj.setAtid(atid);
        obj.setName(name);
        obj.setStid(stid);
        obj.setClassroom(classroom);
        obj.setRemark(remark);
        obj.setCredit(credit);
        obj.setTimeinfo(timeinfo);
        obj.setContent(content);

        courseDao.save(obj);//调用数据库添加
        response.sendRedirect("CourseServlet?type=query");
    }

    //修改Course信息
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String period=request.getParameter("period");
        String atid=request.getParameter("atid");
        String name=request.getParameter("name");
        String stid=request.getParameter("stid");
        String classroom=request.getParameter("classroom");
        String remark=request.getParameter("remark");
        String id=request.getParameter("id");
        String credit=request.getParameter("credit");
        String timeinfo=request.getParameter("timeinfo");
        String content=request.getParameter("content");

        Course obj=new  Course();

        obj.setPeriod(period);
        obj.setAtid(atid);
        obj.setName(name);
        obj.setStid(stid);
        obj.setClassroom(classroom);
        obj.setRemark(remark);
         obj.setId(Integer.parseInt(id));
        obj.setCredit(credit);
        obj.setTimeinfo(timeinfo);
        obj.setContent(content);

        courseDao.update(obj); //调用数据库修改功能
        response.sendRedirect("CourseServlet?type=query");
    }


    //根据主键id删除Course信息 id是整数
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr=request.getParameter("id");
        Integer id= Integer.parseInt(idStr);
        courseDao.delete(id);//调用数据库删除
        response.sendRedirect("CourseServlet?type=query");
    }


    //Course查询数据库中的所有数据
    protected void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用数据库查询所有方法
        List<Course>  courseList=courseDao.queryAll(); //调用数据库查询所有
        for (Course course : courseList) {
            Teacher teacher = teacherDao.queryById(Integer.parseInt(course.getStid()));
            course.setTeacher(teacher);
        }
        request.setAttribute("courseList",courseList);   //绑定接受参数
        request.getRequestDispatcher("courseList.jsp").forward(request,response);
    }


    protected void me(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用数据库查询所有方法
        List<Course>  courseList=courseDao.queryAll(); //调用数据库查询所有
        request.setAttribute("courseList",courseList);   //绑定接受参数
        request.getRequestDispatcher("courseMeList.jsp").forward(request,response);
    }



    protected void choose(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用数据库查询所有方法
        List<Course>  courseList=courseDao.queryAll(); //调用数据库查询所有
//获取所有的选课信息
        List<Applyinfo> applyinfos = applyinfoDao.queryAll();

//        接收用户id
        String sid = request.getParameter("sid");
        //用户选择的所有课程
        //新创建集合存放用户选择的课程
        ArrayList<Applyinfo> as = new ArrayList<>();
        for (Applyinfo applyinfo : applyinfos) {
            if(applyinfo.getSid().equals(sid)){
                as.add(applyinfo);
            }
        }

        for (Course course : courseList) {
            Teacher teacher = teacherDao.queryById(Integer.parseInt(course.getStid()));
            course.setTeacher(teacher);
            for (Applyinfo a : as) {
                if(course.getId().toString().equals(a.getCid())){
                    course.setRemark("2");
                }
            }
        }

        request.setAttribute("courseList",courseList);   //绑定接受参数
        request.getRequestDispatcher("courseChooseList.jsp").forward(request,response);
    }


    protected void preadd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用数据库查询所有方法
        List<Teacher> teachers = teacherDao.queryAll();//调用数据库查询所有

        request.setAttribute("ts",teachers);   //绑定接受参数
        request.getRequestDispatcher("courseAdd.jsp").forward(request,response);
    }


    //Course根据主键id查询数据
    protected void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用数据库查询所有方法
        String idStr=request.getParameter("id");
        Integer id= Integer.parseInt(idStr);
        Course  course=courseDao.queryById(id); //调用数据库根据主键查询
        request.setAttribute("course",course);   //绑定接受参数
        request.getRequestDispatcher("courseDetail.jsp").forward(request,response);
    }

    //Course根据主键id查询数据 跳转到编辑页面
    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用数据库查询所有方法
        String idStr=request.getParameter("id");
        Integer id= Integer.parseInt(idStr);
        Course  course=courseDao.queryById(id); //调用数据库根据主键查询
        request.setAttribute("course",course);   //绑定接受参数
        request.getRequestDispatcher("courseUpdate.jsp").forward(request,response);
    }




}
