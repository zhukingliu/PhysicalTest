<%@ page language="java" import="java.util.*,dao.*,entity.*" pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 <% response.setContentType("text/html;charset=utf-8"); %>
<!DOCTYPE html>
<html>
	<head>
	    <%  
		 Cookie cookie = null;
         Cookie[] cookies = null;
         String myID = "";
   // 获取cookies的数据,是一个数组
         cookies = request.getCookies();
         if( cookies != null ){
          for (int i = 0; i < cookies.length; i++){
          cookie = cookies[i];
          if(cookie.getName().equals("passid")){
            myID = cookie.getValue();
          }
         }
       }else{
          out.println("<h2>没有发现 Cookie</h2>");
       }
	    
	    String ID=request.getParameter("id");
	    TestInfoDao testInfoDao = new TestInfoDao();
	    TestInfo testInfo = testInfoDao.findById(ID); 
         StudentDao studentDao = new StudentDao();
         Student student = studentDao.findById(testInfo.getStudentID());
         int flag = 0;
         if(student.getSex()==0){
           flag = 0;
         }else{
           flag = 1;
         }
	    %>
		<meta charset="utf-8" />
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

					<li><h4 class="page-title">修改体测信息</h4></li>
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
	                        <h5><a href="#"><%=myID %></a> </h5>
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


								<form action="doUpdateTest.jsp" method="post" class="am-form" data-am-validator>
									<fieldset>
										<legend>修改体测信息列表</legend>
										<div class="am-form-group">
											<label>学号：</label>
											<input type="text" name="studentId" value="<%=student.getStudentID() %>" required/>
										</div>
										<div class="am-form-group">
											<label>体测号：</label>
											<input type="text" name="Id" value="<%=testInfo.getID() %>" required/>
										</div>
										<div class="am-form-group">
											<label>体测时间：</label>
											<input type="date" name="time" value=<%=testInfo.getTime() %> required/>
										</div>
										<div class="am-form-group">
											<label>身高：</label>
											<input type="number" name="height" value=<%=testInfo.getHeight() %> required/>
										</div>
										<div class="am-form-group">
											<label>体重：</label>
											<input type="number" name="weight" value=<%=testInfo.getWeight() %> required/>
										</div>
										<div class="am-form-group">
											<label>肺活量：</label>
											<input type="number" name="vitalCapacity" value=<%=testInfo.getVitalCapacity() %> required/>
										<div class="am-form-group">
											<label>跳远：</label>
											<input type="number" name="jump" value=<%=testInfo.getJump() %> required/>
											<%if(flag==1){ %>
										</div>
											<div class="am-form-group">
											<label>仰卧起坐：</label>
											<input type="number" name="sitUp" value=<%=testInfo.getSitUp() %> required/>
										</div>
										<div class="am-form-group">
											<label>八百米长跑：</label>
											<input type="number" name="eightHundred" value=<%=testInfo.getEightHundred() %> required/>
										</div>
										<%}else{ %>
										<div class="am-form-group">
											<label>引体向上：</label>
											<input type="number" name="pullUp" value=<%=testInfo.getPullUp() %> required/>
										</div>
										<div class="am-form-group">
											<label>一千米长跑：</label>
											<input type="number" name="oneThousand" value=<%=testInfo.getOneThousand() %> required/>
										</div>
										<%} %>
										<div class="am-form-group">
											<label>五十米短跑：</label>
											<input type="number" name="fifty" value=<%=testInfo.getFifty() %> required/>
										</div>
										<div class="am-form-group">
											<label>体前屈：</label>
											<input type="number" name="sitAndReach" value=<%=testInfo.getSitAndReach() %> required/>
										</div>
										<button class="am-btn am-btn-secondary" type="submit">修改</button>
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
