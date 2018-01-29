<%@ page language="java" import="java.util.*,dao.*,entity.*" pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 <% response.setContentType("text/html;charset=utf-8"); %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
				 <%  
		 Cookie cookie = null;
         Cookie[] cookies = null;
         String ID = "";
   // 获取cookies的数据,是一个数组
         cookies = request.getCookies();
         if( cookies != null ){
          for (int i = 0; i < cookies.length; i++){
          cookie = cookies[i];
          if(cookie.getName().equals("passid")){
            ID = cookie.getValue();
          }
         }
       }else{
          out.println("<h2>没有发现 Cookie</h2>");
       }%>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>销售系统</title>
		<link rel="stylesheet" href="../assets/css/amazeui.css" />
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
		<link rel="stylesheet" href="../assets/css/core.css" />
		<link rel="stylesheet" href="../assets/css/menu.css" />
		<link rel="stylesheet" href="../assets/css/index.css" />
		<link rel="stylesheet" href="../assets/css/admin.css" />
		<link rel="stylesheet" href="../assets/css/page/typography.css" />
		<link rel="stylesheet" href="../assets/css/page/form.css" />
		
	</head>
	<body>
		<!-- Begin page -->
		<header class="am-topbar am-topbar-fixed-top">		
			<div class="am-topbar-left am-hide-sm-only">
                <a href="index.html" class="logo"><span>管理员</span><i class="zmdai zmdi-layers"></i></a>
            </div>
	
			<div class="contain">
				<ul class="am-nav am-navbar-nav am-navbar-left">

					<li><h4 class="page-title">添加学生</h4></li>
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
	                        <h5><a href="#"><%=ID %></a> </h5>
	                        <ul class="list-inline">
	                            <li>
	                                <a href="#">
	                                    <i class="am-icon-cog" aria-hidden="true"></i>
	                                </a>
	                            </li>
	
	                            <li>
	                                <a href="#" class="text-custom">
	                                    <i class="am-icon-cog" aria-hidden="true"></i>
	                                </a>
	                            </li>
	                        </ul>
	                    </div>
	                    <!-- End User -->

					     <ul class="am-list admin-sidebar-list">
						    <li><a href="myself.jsp"><span class="am-icon-home"></span> 首页</a></li>
						    <li class="admin-parent">
						      <a class="am-cf" data-am-collapse="{target: '#collapse-nav1'}"><span class="am-icon-table"></span> 学生 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
						      <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav1">
						        <li><a href="studentList.jsp" class="am-cf"> 学生信息</span></a></li>
						        <li><a href="table_complete.html">体测建议</a></li>
						      </ul>
						    </li>
						    <li class="admin-parent">
                                <a class="am-cf" data-am-collapse="{target: '#collapse-nav2'}"><span class="am-icon-table"></span> 教师 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
						      <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav2">
						        <li><a href="LeaderList.jsp" class="am-cf"> 领导信息</span></a></li>
						        <li><a href="TeacherList.jsp" class="am-cf"> 教师信息</span></a></li>
						      </ul>
						    </li>
						    <li class="admin-parent">
						      <a class="am-cf" data-am-collapse="{target: '#collapse-nav5'}"><span class="am-icon-file"></span> 个人中心 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
						      <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav5">
						        <li><a href="myself.jsp" class="am-cf"> 个人信息</a></li>
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
				<div class="am-g">
					<!-- Row start -->
						<div class="am-u-sm-12">
							<div class="card-box">


								<form action="doAddStudent.jsp" method="post" class="am-form" data-am-validator>
									<fieldset>
										<legend>添加学生列表</legend>
										<div class="am-form-group">
											<label>学号：</label>
											<input type="text" name="Id" placeholder="输入学号" required/>
										</div>
										<div class="am-form-group">
											<label>姓名：</label>
											<input type="text" name="Name" placeholder="输入姓名" required/>
										</div>
										<div class="am-form-group">
											<label>出生年月：</label>
											<input type="date" name="birthday" required/>
										</div>

                                       <div class="am-form-group">
										    <label>性别：</label>
											<select name="sex" required>
												<option>男</option>
												<option>女</option>
											</select>
										</div>

                                        <div class="am-form-group">
											<label>学院：</label>
											<input type="text" name="college" placeholder="所在学院" required/>
										</div>
										<div class="am-form-group">
											<label>专业：</label>
											<input type="text" name="project" placeholder="就读专业" required/>
										</div>
										<div class="am-form-group">
											<label>班主任：</label>
											<input type="text" name="teacher" placeholder="班主任" required/>
										</div>
										<div class="am-form-group">
											<label>领导：</label>
											<input type="text" name="leader" placeholder="领导" required/>
										</div>

										<button class="am-btn am-btn-secondary" type="submit">添加</button>
									</fieldset>
								</form>
							</div>
						</div>
					<!-- Row end -->
				</div>
			
			
			
			
			</div>
		</div>
		<!-- end right Content here -->
		<!--</div>-->
		</div>
		</div>
		
		<!-- navbar -->
		<a href="admin-offcanvas" class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu" data-am-offcanvas="{target: '#admin-offcanvas'}"><!--<i class="fa fa-bars" aria-hidden="true"></i>--></a>
		<script type="text/javascript" src="../assets/js/jquery-2.1.0.js" ></script>
		<script type="text/javascript" src="../assets/js/amazeui.min.js"></script>
		<script type="text/javascript" src="../assets/js/app.js" ></script>
		<script type="text/javascript" src="../assets/js/blockUI.js" ></script>
	</body>
	
</html>
