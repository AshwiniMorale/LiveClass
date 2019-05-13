<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.SQLException"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="java.net.CookieHandler"%>
<%@ page import="java.io.PrintWriter"%>
<%@ include file="connection.jsp"%>

<%
	Integer hdrUserId = (Integer) session.getAttribute("userId");
	String hdrUserName = (String) session.getAttribute("userName");
	String hdrEmailId = (String) session.getAttribute("emailId");
%>
<!-- HEADER DESKTOP-->
<header class="header-desktop3 d-none d-lg-block">
	<div class="section__content section__content--p35">
		<div class="header3-wrap">
			<div class="header__logo">
				<a href="#"> <span class="text text-white">EDUCATION ERP</span>
				</a>
			</div>
			<div class="header__navbar">
				<ul class="list-unstyled">
					<li><a href="stuDashboard.jsp"> <i class="fas fa-tachometer-alt"></i>Dashboard
							<span class="bot-line"></span>
					</a></li>
					<li><a href="showStudentDetails.jsp"> <i class="fas fa-file-text"></i> <span
							class="bot-line"></span>C
					</a></li>
					<li><a href="#"> <i class="fas fa-file-text"></i> <span
							class="bot-line"></span>C++
					</a></li>
					<li class="has-sub"><a href="#"> <i
							class="fas fa-file-text"></i> <span class="bot-line"></span>Java
					</a></li>
					<li class="has-sub"><a href="#"> <i
							class="fas fa-file-text"></i> <span class="bot-line"></span>Bootstrap
					</a></li>
				</ul>
			</div>
			<div class="header__tool">
				<div class="header-button-item has-noti js-item-menu">
					<i class="zmdi zmdi-notifications"></i>
					<div class="notifi-dropdown notifi-dropdown--no-bor js-dropdown">
						<div class="notifi__title">
							<p>You have 3 Notifications</p>
						</div>
						<div class="notifi__item">
							<div class="bg-c1 img-cir img-40">
								<i class="zmdi zmdi-email-open"></i>
							</div>
							<div class="content">
								<p>You got a email notification</p>
								<span class="date">April 12, 2018 06:50</span>
							</div>
						</div>
						<div class="notifi__item">
							<div class="bg-c2 img-cir img-40">
								<i class="zmdi zmdi-account-box"></i>
							</div>
							<div class="content">
								<p>Your account has been blocked</p>
								<span class="date">April 12, 2018 06:50</span>
							</div>
						</div>
						<div class="notifi__item">
							<div class="bg-c3 img-cir img-40">
								<i class="zmdi zmdi-file-text"></i>
							</div>
							<div class="content">
								<p>You got a new file</p>
								<span class="date">April 12, 2018 06:50</span>
							</div>
						</div>
						<div class="notifi__footer">
							<a href="#">All notifications</a>
						</div>
					</div>
				</div>
				<div class="account-wrap">
					<div
						class="account-item account-item--style2 clearfix js-item-menu">
						<div class="image">
							<img src="images/icon/avatar-01.jpg" alt="FS" />
						</div>
						<div class="content">
							<a class="js-acc-btn" href="#"><%=hdrUserName%></a>
						</div>
						<div class="account-dropdown js-dropdown">
							<div class="info clearfix">
								<div class="image">
									<a href="#"> <img src="images/icon/avatar-01.jpg" alt="FS" />
									</a>
								</div>
								<div class="content">
									<h5 class="name">
										<a href="#"><%=hdrUserName%></a>
									</h5>
									<span class="email"><%=hdrEmailId%></span>
								</div>
							</div>
							<div class="account-dropdown__body">
								<div class="account-dropdown__item">
									<a href="showStudentprofile.jsp"> <i class="zmdi zmdi-account"></i>Account
									</a>
								</div>
								<div class="account-dropdown__item">
									<a href="#"> <i class="zmdi zmdi-settings"></i>Setting
									</a>
								</div>
							</div>
							<div class="account-dropdown__footer">
								<a href="#"> <i class="zmdi zmdi-power"></i>Logout
								</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</header>
<!-- END HEADER DESKTOP-->

<!-- HEADER MOBILE-->
<header class="header-mobile header-mobile-2 d-block d-lg-none">
	<div class="header-mobile__bar">
		<div class="container-fluid">
			<div class="header-mobile-inner">
				<a class="logo" href="index.html"> <span
					class="text text-white text-sm">EDUCATION ERP</span>
				</a>
				<button class="hamburger hamburger--slider" type="button">
					<span class="hamburger-box"> <span class="hamburger-inner"></span>
					</span>
				</button>
			</div>
		</div>
	</div>
	<nav class="navbar-mobile">
		<div class="container-fluid">
			<ul class="navbar-mobile__list list-unstyled">
				<li class="has-sub"><a class="js-arrow" href="#"> <i
						class="fas fa-tachometer-alt"></i>Dashboard
				</a></li>
				<li class="has-sub"><a class="js-arrow" href="#"> <i
						class="fas fa-file-text"></i>C
				</a></li>
				<li class="has-sub"><a class="js-arrow" href="#"> <i
						class="fas fa-file-text"></i>C++
				</a></li>
				<li class="has-sub"><a class="js-arrow" href="#"> <i
						class="fas fa-file-text"></i>Java
				</a></li>
				<li class="has-sub"><a class="js-arrow" href="#"> <i
						class="fas fa-file-text"></i>Bootstrap
				</a></li>
			</ul>
		</div>
	</nav>
</header>
<div class="sub-header-mobile-2 d-block d-lg-none">
	<div class="header__tool">
		<div class="header-button-item has-noti js-item-menu">
			<i class="zmdi zmdi-notifications"></i>
			<div class="notifi-dropdown notifi-dropdown--no-bor js-dropdown">
				<div class="notifi__title">
					<p>You have 3 Notifications</p>
				</div>
				<div class="notifi__item">
					<div class="bg-c1 img-cir img-40">
						<i class="zmdi zmdi-email-open"></i>
					</div>
					<div class="content">
						<p>You got a email notification</p>
						<span class="date">April 12, 2018 06:50</span>
					</div>
				</div>
				<div class="notifi__item">
					<div class="bg-c2 img-cir img-40">
						<i class="zmdi zmdi-account-box"></i>
					</div>
					<div class="content">
						<p>Your account has been blocked</p>
						<span class="date">April 12, 2018 06:50</span>
					</div>
				</div>
				<div class="notifi__item">
					<div class="bg-c3 img-cir img-40">
						<i class="zmdi zmdi-file-text"></i>
					</div>
					<div class="content">
						<p>You got a new file</p>
						<span class="date">April 12, 2018 06:50</span>
					</div>
				</div>
				<div class="notifi__footer">
					<a href="#">All notifications</a>
				</div>
			</div>
		</div>
		<div class="account-wrap">
			<div class="account-item account-item--style2 clearfix js-item-menu">
				<div class="image">
					<img src="images/icon/avatar-01.jpg" alt="FS" />
				</div>
				<div class="content">
					<a class="js-acc-btn" href="#"><%=hdrUserName%></a>
				</div>
				<div class="account-dropdown js-dropdown">
					<div class="info clearfix">
						<div class="image">
							<a href="#"> <img src="images/icon/avatar-01.jpg" alt="FS" />
							</a>
						</div>
						<div class="content">
							<h5 class="name">
								<a href="#"><%=hdrUserName%></a>
							</h5>
							<span class="email"><%=hdrEmailId%></span>
						</div>
					</div>
					<div class="account-dropdown__body">
						<div class="account-dropdown__item">
							<a href="showStudentprofile.jsp"> <i class="zmdi zmdi-account"></i>Account
							</a>
						</div>
						<div class="account-dropdown__item">
							<a href="#"> <i class="zmdi zmdi-settings"></i>Setting
							</a>
						</div>
						<div class="account-dropdown__item">
							<a href="#"> <i class="zmdi zmdi-money-box"></i>Billing
							</a>
						</div>
					</div>
					<div class="account-dropdown__footer">
						<a href="#"> <i class="zmdi zmdi-power"></i>Logout
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- END HEADER MOBILE -->
<%@include file="connection.jsp"%>

<!DOCTYPE html>
<html>
<body>


</body>
</html>