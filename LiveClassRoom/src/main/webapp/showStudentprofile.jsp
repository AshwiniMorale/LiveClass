<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>:: Dashboard ::</title>
<%@include file="links.jsp"%>
</head>
<body class="animsition">
	<div class="page-wrapper">
		<%@include file="header.jsp"%>
		<!-- PAGE CONTENT-->
		<div class="page-content--bgf7">
			<!-- 		BREADCRUMB -->
			<section class="au-breadcrumb2">
				<div class="container">
					<div class="row">
						<div class="col-md-12">
							<div class="au-breadcrumb-content">
								<div class="au-breadcrumb-left">
									<span class="au-breadcrumb-span">You are here:</span>
									<ul class="list-unstyled list-inline au-breadcrumb__list">
										<li class="list-inline-item active"><a href="#">Home</a></li>
										<li class="list-inline-item seprate"><span>/</span></li>
										<li class="list-inline-item">Profile</li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</section>
			<!-- END BREADCRUMB-->
			<div class="container-flude bg-white">
				<div class="main-containt">
					<div class="section__content section__content--p30">
						<div class="row">
							<%
								Integer userId = (Integer) session.getAttribute("userId");
							%>
							<sql:query var="listStud" dataSource="${connectionDS}">
        						SELECT * FROM tbl_users u,tbl_usr_pers_det upd
								WHERE u.userid=<%=userId%> AND upd.userid=<%=userId%>;
    						</sql:query>
							<div class="col-md-12" style="height: 500px">
								<div class="card border border-primary">
									<div class="card-header bg-info">
										<strong class="card-title text-white">Profile</strong>
									</div>
									<div class="card-body">
										<c:forEach var="user" items="${listStud.rows}">
											<div class="row">
												<div class="col">
													<section class="card">
														<div class="card-body text-secondary">
															<input type="text"
																value="<c:out value="${user.firstName}" />">
														</div>
													</section>
												</div>
												<div class="col">
													<section class="card">
														<div class="card-body text-secondary">
															<input type="text"
																value="<c:out value="${user.lastName}" />">
														</div>
													</section>
												</div>
												<div class="col">
													<section class="card">
														<div class="card-body text-secondary">
															<input type="text"
																value="<c:out value="${user.mobileNo}" />">
														</div>
													</section>
												</div>
											</div>
											<div class="row">
												<div class="col">
													<section class="card">
														<div class="card-body text-secondary">
															<input type="text"
																value="<c:out value="${user.emailId}" />">
														</div>
													</section>
												</div>
												<div class="col">
													<section class="card">
														<div class="card-body text-secondary">
															<input type="text" value="<c:out value="${user.dob}" />">
														</div>
													</section>
												</div>
												<div class="col">
													<section class="card">
														<div class="card-body text-secondary">
															<input type="text"
																value="<c:out value="${user.gender}" />">
														</div>
													</section>
												</div>
											</div>
											<div class="row">
												<div class="col">
													<section class="card">
														<div class="card-body text-secondary">
															<input type="text"
																value="<c:out value="${user.areaPinCode}" />">
														</div>
													</section>
												</div>
												<div class="col">
													<section class="card">
														<div class="card-body text-secondary">
															<input type="text"
																value="<c:out value="${user.hometown}" />">
														</div>
													</section>
												</div>
												<div class="col">
													<section class="card">
														<div class="card-body text-secondary">
															<input type="text"
																value="<c:out value="${user.permanentAddress}" />">
														</div>
													</section>
												</div>
											</div>
										</c:forEach>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@include file="footer.jsp"%>
	
	<input type="hidden" name="roleId" value="<%=userId%>">
</body>
</html>