<%@ page language="java" import="java.util.*,dao.*,entity.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
         <%  
                 Cookie cookie = null;
         Cookie[] cookies = null;
         String logID = "";
   // 获取cookies的数据,是一个数组
         cookies = request.getCookies();
         if( cookies != null ){
          for (int i = 0; i < cookies.length; i++){
          cookie = cookies[i];
          if(cookie.getName().equals("passid")){
            logID = cookie.getValue();
          }
      }
  }else{
      out.println("<h2>没有发现 Cookie</h2>");
  }
         
         String ID=request.getParameter("id"); 
         TestInfoDao dao=new TestInfoDao();
         TestInfo testInfo =dao.findById(ID);
         
         StudentDao studentDao = new StudentDao();
         Student student = studentDao.findById(testInfo.getStudentID());
         int flag = 0;
         if(student.getSex()==0){
           flag = 0;
         }else{
           flag = 1;
         }
         %> 
        <script type="text/javascript">  
        function myAction(pid){  
        document.forms[0].id.value=pid;  
        document.forms[0].submit();  
         }  
        function add(){
        location.href="addCustomer.jsp";
        }
      </script>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>盘点系统</title>

	<link rel="stylesheet" type="text/css" href="../Css/identify.css" />
	<link rel="stylesheet" type="text/css" href="../Css/layout.css" />
	<link rel="stylesheet" type="text/css" href="../Css/account.css" />
	<link rel="stylesheet" type="text/css" href="../Css/style.css" />
	<link rel="stylesheet" type="text/css" href="../Css/control_index.css" />

	<link rel="stylesheet" href="../assets/css/amazeui.css" />
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="../assets/css/core.css" />
	<link rel="stylesheet" href="../assets/css/menu.css" />
	<link rel="stylesheet" href="../assets/css/index.css" />
	<link rel="stylesheet" href="../assets/css/admin.css" />
	<link rel="stylesheet" href="../assets/css/page/typography.css" />
	<link rel="stylesheet" href="../assets/css/page/form.css" />

	<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.js"></script>
</head>
<body>
<!-- Begin page -->
<header class="am-topbar am-topbar-fixed-top">
	<div class="am-topbar-left am-hide-sm-only">
		<a href="index.html" class="logo"><span>教师</span><i class="zmdi zmdi-layers"></i></a>
	</div>

	<div class="contain">
		<ul class="am-nav am-navbar-nav am-navbar-left">

			<li><h4 class="page-title">体测信息</h4></li>
		</ul>

		<ul class="am-nav am-navbar-nav am-navbar-right">
			<li class="inform"><i class="am-icon-bell-o" aria-hidden="true"></i></li>
			<li class="hidden-xs am-hide-sm-only">
				<form role="search" class="app-search">
					<input type="text" placeholder="Search..." class="form-control">
					<a href=""><img src="../assets/img/search.png"></a>
				</form>
			</li>
		</ul>
	</div>
</header>
<!-- end page -->


<div class="admin">
	<!--<div class="am-g">-->
	<!-- ========== Left Sidebar Start ========== -->
	<!--<div class="left side-menu am-hide-sm-only am-u-md-1 am-padding-0">
        <div class="slimScrollDiv" style="position: relative; overflow: hidden; width: auto; height: 548px;">
            <div class="sidebar-inner slimscrollleft" style="overflow: hidden; width: auto; height: 548px;">-->
	<!-- sidebar start -->
	<div class="admin-sidebar am-offcanvas  am-padding-0" id="admin-offcanvas">
		<div class="am-offcanvas-bar admin-offcanvas-bar">
			<!-- User -->
			<div class="user-box am-hide-sm-only">
				<div class="user-img">
					<img src="../assets/img/avatar-1.jpg" alt="user-img" title="Mat Helme" class="img-circle img-thumbnail img-responsive">
					<div class="user-status offline"><i class="am-icon-dot-circle-o" aria-hidden="true"></i></div>
				</div>
				<h5><a href="#"><%=logID %></a> </h5>
				<ul class="list-inline">
					<li>
						<a href="#">
							<i class="fa fa-cog" aria-hidden="true"></i>
						</a>
					</li>

					<li>
						<a href="#" class="text-custom">
							<i class="fa fa-cog" aria-hidden="true"></i>
						</a>
					</li>
				</ul>
			</div>
			<!-- End User -->

	                   	 <ul class="am-list admin-sidebar-list">
						    <li><a href="TeacherList.jsp"><span class="am-icon-home"></span> 首页</a></li>
						    <li class="admin-parent">
						      <a class="am-cf" data-am-collapse="{target: '#collapse-nav1'}"><span class="am-icon-table"></span>学生体测信息<span class="am-icon-angle-right am-fr am-margin-right"></span></a>
						      <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav1">
						        <li><a href="studentList.jsp" class="am-cf">学生列表</span></a></li>
						        <li><a href="studentList.jsp">不及格学生</a></li>
						      </ul>
						    </li>
							 <li class="admin-parent">
								 <a class="am-cf" data-am-collapse="{target: '#collapse-nav5'}"><span class="am-icon-file"></span> 个人中心 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
								 <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav5">
								     <li><a href="TeacherList.jsp" class="am-cf"> 个人信息</a></li>
									 <li><a href="updatePassword.jsp" class="am-cf"> 修改密码</a></li>
									 <li><a href="../index.jsp">退出登录</a></li>
								 </ul>
							 </li>

						  </ul>
		</div>
	</div>
	<!-- sidebar end -->

	<!--</div>
</div>
</div>-->
	<!-- ========== Left Sidebar end ========== -->
	<!--	<div class="am-g">-->
	<!-- ============================================================== -->
	<!-- Start right Content here -->
	<div class="content-page">
		<!-- Start content -->
		<div class="content">
			<div class="card-box">
				<!-- Row start -->

				<!-- Row end -->

				<div class="offcial-table1 tr-border margin-big-top clearfix">
					<div class="tr-th clearfix">
						<div id="addInfo">
				 		<%if(flag==1){ %>
						<table>
						    <tr>
								<th class="thth1">
									身高
								</th>
								<th class="thth2">
									<%=testInfo.getHeight()%>&nbsp;&nbsp;cm
								</th>
							</tr>
							 <tr>
								<th class="thth1">
									体重
								</th>
								<th class="thth2">
									<%=testInfo.getWeight()%>&nbsp;&nbsp;kg
								</th>
							</tr>
							<tr>
								<th class="thth1">
									肺活量
								</th>
								<th class="thth2">
									<%=testInfo.getVitalCapacity()%>
								</th>
							</tr>
							<tr>
								<th class="thth1">
									跳远
								</th>
								<th class="thth2">
									<%=testInfo.getJump()%>&nbsp;&nbsp;cm
								</th>
							</tr>
							<tr>
								<th class="thth1">
									仰卧起坐
								</th>
								<th class="thth2">
									<%=testInfo.getSitUp() %>&nbsp;&nbsp;个
								</th>
							</tr>
							<tr>
								<th class="thth1">
									八百米长跑
								</th>
								<th class="thth2">
									<%=testInfo.getEightHundred() %>&nbsp;&nbsp;s
								</th>
							</tr>
							<tr>
								<th class="thth1">
									五十米短跑
								</th>
								<th class="thth2">
									<%=testInfo.getFifty() %>&nbsp;&nbsp;s
								</th>
							</tr>
							<tr>
								<th class="thth1">
									体前屈
								</th>
								<th class="thth2">
									<%=testInfo.getSitAndReach()%>&nbsp;&nbsp;cm
								</th>
							</tr>
						</table>
						<%} else{%>
						<table>
						    <tr>
								<th class="thth1">
									身高
								</th>
								<th class="thth2">
									<%=testInfo.getHeight() %>&nbsp;&nbsp;cm
								</th>
							</tr>
							 <tr>
								<th class="thth1">
									体重
								</th>
								<th class="thth2">
									<%=testInfo.getWeight() %>&nbsp;&nbsp;kg
								</th>
							</tr>
							<tr>
								<th class="thth1">
									肺活量
								</th>
								<th class="thth2">
									<%=testInfo.getVitalCapacity() %>
								</th>
							</tr>
							<tr>
								<th class="thth1">
									跳远
								</th>
								<th class="thth2">
									<%=testInfo.getJump() %>&nbsp;&nbsp;cm
								</th>
							</tr>
							<tr>
								<th class="thth1">
									引体向上
								</th>
								<th class="thth2">
									<%=testInfo.getPullUp() %>&nbsp;&nbsp;个
								</th>
							</tr>
							<tr>
								<th class="thth1">
									一千米长跑
								</th>
								<th class="thth2">
									<%=testInfo.getOneThousand() %>&nbsp;&nbsp;s
								</th>
							</tr>
							<tr>
								<th class="thth1">
									五十米短跑
								</th>
								<th class="thth2">
									<%=testInfo.getFifty() %>&nbsp;&nbsp;s
								</th>
							</tr>
							<tr>
								<th class="thth1">
									体前屈
								</th>
								<th class="thth2">
									<%=testInfo.getSitAndReach()%>&nbsp;&nbsp;cm
								</th>
							</tr>
						</table>
						<%} %>
					</div>
					</div>
				</div>
				<!-- Row start -->
				<!-- Row end -->

			</div>




		</div>


	</div>
</div>
<!-- end right Content here -->
<!--</div>-->
</div>
</div>

<!-- navbar -->
<a href="admin-offcanvas" class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu" data-am-offcanvas="{target: '#admin-offcanvas'}"><!--<i class="fa fa-bars" aria-hidden="true"></i>--></a>
</body>

</html>
