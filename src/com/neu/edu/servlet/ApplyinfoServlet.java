package com.neu.edu.servlet;

import com.neu.edu.dao.ApplyinfoDao;
import com.neu.edu.entity.Applyinfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
* ClassName:ApplyinfoServlet
* Description:课程申请请求处理
*/
@WebServlet(name = "ApplyinfoServlet",urlPatterns = "/ApplyinfoServlet")
public class ApplyinfoServlet extends HttpServlet {

    ApplyinfoDao applyinfoDao = new ApplyinfoDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // 设置请求编码集 防止接收参数乱码
//        request.setCharacterEncoding("utf-8");
//        // 设置响应格式为网页编码，编码为utf-8 防止输出乱码
//        response.setCharacterEncoding("utf-8");
            //新增数据
        if(request.getParameter("type").equals("save")){
            save(request,response);
            //删除数据
        }else if (request.getParameter("type").equals("delete")){
            delete(request,response);
            //修改数据
        }else if (request.getParameter("type").equals("update")){
            update(request,response);
            //查询所有信息
        } else if (request.getParameter("type").equals("query")){
            query(request,response);
            //获取主讲教师审批的申请信息列表，查询结果传递给 applyinfoShenList.jsp 页面进行展示。
        }else if (request.getParameter("type").equals("shen")){
            shen(request,response);
            //获取主管教师审批的申请信息列表，将查询结果传递给 applyinfoLastShenList.jsp 页面进行展示。
        }else if (request.getParameter("type").equals("lastShen")) {
             lastShen(request, response);
            //查询当前用户相关的申请信息列表，供用户查看其自己的申请信息。
        }else if (request.getParameter("type").equals("me")){
            me(request,response);
            //根据id 查询申请信息数据
        }else if (request.getParameter("type").equals("get")){
            get(request,response);
            //根据cid获取当前主讲教师的审批信息然后保存到数据库中，并进行页面重定向到shen
        }else if (request.getParameter("type").equals("firstShen")){
            firstShen(request,response);
            //处理主管教师审批的操作，包括接收审批信息并更新申请信息对象，然后保存到数据库中，并转发到 applyinfoUpdate.jsp 页面，以供进一步编辑或展示。
        }else if (request.getParameter("type").equals("secondShen")){
            secondShen(request,response);
            //将更新后的申请信息存入数据库，并重定向到 me 方法，显示当前用户的申请信息列表
        }else if (request.getParameter("type").equals("lShen")){
            lShen(request,response);
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




    //添加Applyinfo信息
    protected void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String atname=request.getParameter("atname");
        String prove=request.getParameter("prove");
        String atid=request.getParameter("atid");
        String stid=request.getParameter("stid");
        String remark=request.getParameter("remark");
        String content=request.getParameter("content");
        String sid=request.getParameter("sid");
        String ctime=request.getParameter("ctime");
        String streason=request.getParameter("streason");
        String atreason=request.getParameter("atreason");
        String cid=request.getParameter("cid");
        String status=request.getParameter("status");
        String stname=request.getParameter("stname");

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = simpleDateFormat.format(date);


        Applyinfo obj=new Applyinfo();

        obj.setAtname(atname);
        obj.setProve(prove);
        obj.setAtid(atid);
        obj.setStid(stid);
        obj.setRemark(remark);
        obj.setContent(content);
        obj.setSid(sid);
        obj.setCtime(str);
        obj.setStreason(streason);
        obj.setAtreason(atreason);
        obj.setCid(cid);
        obj.setStatus(status);
        obj.setStname(stname);

        applyinfoDao.save(obj);//调用数据库添加
        response.sendRedirect("ApplyinfoServlet?type=me&sid="+sid);
    }

    //修改Applyinfo信息
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String atname=request.getParameter("atname");
        String prove=request.getParameter("prove");
        String atid=request.getParameter("atid");
        String stid=request.getParameter("stid");
        String remark=request.getParameter("remark");
        String content=request.getParameter("content");
        String sid=request.getParameter("sid");
        String ctime=request.getParameter("ctime");
        String streason=request.getParameter("streason");
        String id=request.getParameter("id");
        String atreason=request.getParameter("atreason");
        String cid=request.getParameter("cid");
        String status=request.getParameter("status");
        String stname=request.getParameter("stname");

        Applyinfo obj=new Applyinfo();

        obj.setAtname(atname);
        obj.setProve(prove);
        obj.setAtid(atid);
        obj.setStid(stid);
        obj.setRemark(remark);
        obj.setContent(content);
        obj.setSid(sid);
        obj.setCtime(ctime);
        obj.setStreason(streason);
         obj.setId(Integer.parseInt(id));
        obj.setAtreason(atreason);
        obj.setCid(cid);
        obj.setStatus(status);
        obj.setStname(stname);

        applyinfoDao.update(obj); //调用数据库修改功能
        response.sendRedirect("ApplyinfoServlet?type=query");
    }


    //根据主键id删除Applyinfo信息 id是整数
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr=request.getParameter("id");
        Integer id= Integer.parseInt(idStr);
        applyinfoDao.delete(id);//调用数据库删除
        response.sendRedirect("ApplyinfoServlet?type=query");
    }


    //Applyinfo查询数据库中的所有数据
    protected void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取当前页码，默认为第一页
        int currentPage = 1;
        String pageStr = request.getParameter("page");
        if (pageStr != null && !pageStr.isEmpty()) {
            currentPage = Integer.parseInt(pageStr);
        }

        // 调用数据库查询所有方法
        List<Applyinfo> applyinfoList = applyinfoDao.queryByPage(1,5); // 调用数据库查询所有

        // 进行分页处理

        int totalCount = applyinfoList.size();
        int pageSize = 5; // 每页显示的记录数
        int totalPages = (int) Math.ceil((double) totalCount / pageSize);

        // 计算起始索引和结束索引
        int startIndex = (currentPage - 1) * pageSize;
        int endIndex = Math.min(startIndex + pageSize, totalCount);

        // 获取当前页的数据
        List<Applyinfo> currentPageData = applyinfoList.subList(startIndex, endIndex);

        // 判断是否在首页或只有一页数据
        boolean isFirstPage = (currentPage == 1);
        boolean isLastPage = (currentPage == totalPages);

        // 如果在首页或只有一页数据，将上一页和首页的链接设为不可点击
        if (isFirstPage || totalPages == 1) {
            request.setAttribute("prevPageEnabled", false);
            request.setAttribute("firstPageEnabled", false);
        } else {
            request.setAttribute("prevPageEnabled", true);
            request.setAttribute("firstPageEnabled", true);
        }

        // 如果在尾页或只有一页数据，将下一页和尾页的链接设为不可点击
        if (isLastPage || totalPages == 1) {
            request.setAttribute("nextPageEnabled", false);
            request.setAttribute("lastPageEnabled", false);
        } else {
            request.setAttribute("nextPageEnabled", true);
            request.setAttribute("lastPageEnabled", true);
        }


        // 设置数据和分页信息到请求属性中
        request.setAttribute("applyinfoList", currentPageData);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("totalPages", totalPages);

        // 转发到JSP页面进行显示
        request.getRequestDispatcher("applyinfoMeList.jsp").forward(request, response);
    }


    protected void shen(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用数据库查询所有方法
        String cid = request.getParameter("cid");
        List<Applyinfo>  applyinfoList=applyinfoDao.byCid(cid); //调用数据库查询所有
        request.setAttribute("applyinfoList",applyinfoList);   //绑定接受参数
        request.getRequestDispatcher("applyinfoShenList.jsp").forward(request,response);
    }

    protected void lastShen(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用数据库查询所有方法
        List<Applyinfo>  applyinfoList=applyinfoDao.queryAll(); //调用数据库查询所有
        request.setAttribute("applyinfoList",applyinfoList);   //绑定接受参数
        request.getRequestDispatcher("applyinfoLastShenList.jsp").forward(request,response);
    }


    protected void me(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用数据库查询所有方法
        List<Applyinfo>  applyinfoList=applyinfoDao.queryAll(); //调用数据库查询所有
        request.setAttribute("applyinfoList",applyinfoList);   //绑定接受参数
        request.getRequestDispatcher("applyinfoMeList.jsp").forward(request,response);
    }


    //Applyinfo根据主键id查询数据
    protected void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用数据库查询所有方法
        String idStr=request.getParameter("id");
        Integer id= Integer.parseInt(idStr);
        Applyinfo applyinfo=applyinfoDao.queryById(id); //调用数据库根据主键查询
        request.setAttribute("applyinfo",applyinfo);   //绑定接受参数
        request.getRequestDispatcher("applyinfoUpadte.jsp").forward(request,response);
    }

    protected void lShen(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用数据库查询所有方法
        String idStr=request.getParameter("id");
        Integer id= Integer.parseInt(idStr);
        Applyinfo applyinfo=applyinfoDao.queryById(id); //调用数据库根据主键查询

        String status = request.getParameter("status");
        applyinfo.setStatus(status);
        applyinfoDao.update(applyinfo);

        response.sendRedirect("ApplyinfoServlet?type=me&sid="+applyinfo.getSid());
    }



    protected void firstShen(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用数据库查询所有方法
        //获取审批单
        String idStr=request.getParameter("id");
        Integer id= Integer.parseInt(idStr);
        Applyinfo applyinfo=applyinfoDao.queryById(id); //调用数据库根据主键查询

        //获取审批信息
        String streason = request.getParameter("streason");
        String stid = request.getParameter("stid");
        String stname = request.getParameter("stname");
        String status=request.getParameter("status");

        //设置值
        applyinfo.setStatus(status);
        applyinfo.setStid(stid);

        applyinfo.setStname(stname);
        applyinfo.setStreason(streason);

        //更新申请单
        applyinfoDao.update(applyinfo);

        response.sendRedirect("ApplyinfoServlet?type=shen&cid="+applyinfo.getCid());
    }

    protected void secondShen(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用数据库查询所有方法
        //获取审批单
        String idStr=request.getParameter("id");
        Integer id= Integer.parseInt(idStr);
        Applyinfo applyinfo=applyinfoDao.queryById(id); //调用数据库根据主键查询

        //获取审批信息
        String atreason = request.getParameter("atreason");
        String atid = request.getParameter("atid");
        String atname = request.getParameter("atname");
        String status=request.getParameter("status");

        //设置值
        applyinfo.setStatus(status);
        applyinfo.setAtid(atid);

        applyinfo.setAtname(atname);
        applyinfo.setAtreason(atreason);

        //更新申请单
        applyinfoDao.update(applyinfo);

        request.setAttribute("applyinfo",applyinfo);   //绑定接受参数
        request.getRequestDispatcher("applyinfoUpdate.jsp").forward(request,response);
    }






}
