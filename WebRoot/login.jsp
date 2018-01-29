<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,java.net.*,dao.*,entity.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body>
<%
 
  // String passid = URLEncoder.encode(request.getParameter("passid"),"utf-8");  
  // String password = URLEncoder.encode(request.getParameter("password"),"utf-8");  
   // 设置 name 和 url cookie 
   String passId = request.getParameter("passid");
   String password = request.getParameter("password");
   Cookie name = new Cookie("passid",passId);
   // 设置cookie过期时间为24小时。
   name.setMaxAge(60*60*24);  
   // 在响应头部添加cookie
   response.addCookie( name );
   
   TeacherDao teacherDao = new TeacherDao();
   ArrayList teacherList=teacherDao.findAll(); 
   StudentDao studentDao = new StudentDao();
   ArrayList studentList=studentDao.findAll();
   LeaderDao leaderDao = new LeaderDao();
   ArrayList leaderList = leaderDao.findAll();
   ManagerDao managerDao = new ManagerDao();
   ArrayList managerList = managerDao.findAll();
   int limitFlag = 0;
   for(int i =0 ; i<teacherList.size() ; i++){
   Teacher teacher = (Teacher)teacherList.get(i);
   if(teacher.getID().equals(passId)&&teacher.getPassword().equals(password)){
          limitFlag  = 1;  
     }
   }
   for(int i =0 ; i<studentList.size() ; i++){
   Student student= (Student)studentList.get(i);
   if(student.getStudentID().equals(passId)&&student.getPassword().equals(password)){
          limitFlag  = 2;  
     }
   }
   for(int i =0 ; i<leaderList.size() ; i++){
   Leader leader= (Leader)leaderList.get(i);
   if(leader.getLeaderID().equals(passId)&&leader.getPassword().equals(password)){
          limitFlag  = 3;  
     }
   }
   for(int i =0 ; i<managerList.size() ; i++){
   Manager manager= (Manager)managerList.get(i);
   if(manager.getId().equals(passId)&&manager.getPassword().equals(password)){
          limitFlag  = 4;  
     }
   }
   
   if(limitFlag  == 0){
    out.println("<script>alert('账号不存在或密码错误！');history.go(-1);</script>");
   }else if(limitFlag  == 1){//教师
   %>  
   <script type="text/javascript"> 
    window.setInterval(function(){  
            location.href="teacher/TeacherList.jsp";  
    }, 1000);  
   </script> 
   <%}else if(limitFlag  == 2){ //学生
   %>
    <script type="text/javascript"> 
    window.setInterval(function(){  
            location.href="student/studentInfo.jsp";  
    }, 1000);  
   </script>
    <%}else if(limitFlag  == 3){ //领导
   %>
    <script type="text/javascript"> 
    window.setInterval(function(){  
            location.href="teacher/TeacherList.jsp";  
    }, 1000);  
   </script>
   <%} else{//管理员
   %>      
    <script type="text/javascript"> 
    window.setInterval(function(){  
            location.href="manager/studentList.jsp";  
    }, 1000);  
   </script>
   <%} %>
   
   
   <% 
  /* Cookie cookie = null;
   Cookie[] cookies = null;
   // 获取cookies的数据,是一个数组
   cookies = request.getCookies();
   if( cookies != null ){
      out.println("<h2> 查找 Cookie 名与值</h2>");
      for (int i = 0; i < cookies.length; i++){
         cookie = cookies[i];
        
         out.print("参数名 : " + cookie.getName());
         out.print("<br>");
         out.print("参数值: " + URLDecoder.decode(cookie.getValue(), "utf-8") +" <br>");
         out.print("------------------------------------<br>");
      }
  }else{
      out.println("<h2>没有发现 Cookie</h2>");
  }*/
%>
</body>
</html>
