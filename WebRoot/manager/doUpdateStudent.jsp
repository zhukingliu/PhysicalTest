<%@page import="java.sql.Date"%>
<%@page import="java.text.*"%>
<%@ page import="java.util.*,entity.*,dao.*" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%> 
<!-- 处理操作的页面，并非用于显示数据,所以无需任何HTML代码 -->  
<%  
    //接收数据,在JSP中每个页面都具备一个隐藏的对象,这个对象包含着所有提交的请求信息  
    //这就是request对象，也成为请求对象  
    //request是一个隐式对象，所谓的隐式对象是无需声明直接使用的对象(事实上声明是存在的，不过不由我们来做)  
    //getParameter是request中最常见的方法，作用是根据传入的name获取value  
    //setCharacterEncoding是设置请求对象中参数的编码,必须在调用getParameter之前调用该方法  
    //并且一般来说这里的编码要和提交页面的编码一致  
    request.setCharacterEncoding("UTF-8");  
    String ID=request.getParameter("Id");
    String Name=request.getParameter("Name");
    SimpleDateFormat simFormat = new SimpleDateFormat("yyyy-MM-dd");
    java.util.Date Birthday = simFormat.parse(request.getParameter("birthday"));  
    java.sql.Date sqlBirthday = new java.sql.Date(Birthday.getTime());
    String Sex=request.getParameter("sex");  
    String Project=request.getParameter("project");
    String College=request.getParameter("college");  
    String TeacherName=request.getParameter("teacher");  
    String LeaderName=request.getParameter("leader");
    TeacherDao teacherDao = new TeacherDao();
    Teacher teacher = teacherDao.findByName(TeacherName);
    LeaderDao leaderDao = new LeaderDao();
    Leader leader = leaderDao.findByName(LeaderName);
     Student obj=new Student();  
     obj.setStudentID(ID);
     obj.setName(Name);
     obj.setBirthday(sqlBirthday);
     if(Sex.equals("男")){
     obj.setSex(0);}
     else{
     obj.setSex(1);
     }
     obj.setProject(Project);
     obj.setCollege(College);
     obj.setTeacherID(teacher.getID());
     obj.setLeaderID(leader.getLeaderID());
     obj.setPassword("");
    StudentDao dao=new StudentDao();  
    boolean flag=false;
    flag=dao.update(obj);
    System.out.println(obj.getSex());
    if(flag){  
    out.println("<script>alert('修改信息成功！');window.location.href='studentList.jsp';</script>"); 
    }else{
     out.println("<script>alert('修改信息失败！');window.location.href='studentList.jsp';</script>"); 
    }
    //除了request外,还有个隐藏的对象叫response  
    //response也是隐式对象，无需声明就可以直接使用  
    //和request不同的地方在于,它是表示响应  
    //现在我们要做的时候结束完所有工作后，页面重新为index.jsp  
    //所以需要通过响应对象将index.jsp页面响应回客户浏览器，否则客户浏览器得到的是doadd.jsp的页面代码  
    //换句话说就是空无一物  
   
%> 