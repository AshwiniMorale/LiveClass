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
		<%@include file="headerfaculty.jsp"%>
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
										<li class="list-inline-item">Faculty Dashboard</li>
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

						<%
							Integer userId = (Integer) session.getAttribute("userId");
							Integer subId = (Integer) session.getAttribute("subid");
						%>
						<sql:query var="stuSubject" dataSource="${connectionDS}">
        						SELECT subject FROM query1 q,
								WHERE q.subid=<%=subId%>;
    					</sql:query>
						<sql:query var="facSubject" dataSource="${connectionDS}">
        						SELECT subject FROM queryanswer s,
								WHERE s.subid=<%=subId%>;
    					</sql:query>
						<c:if test="${stuSubject}==${facSubject}">
							<sql:query var="queries" dataSource="${connectionDS}">
        							SELECT query FROM query1 q1,
									WHERE q1.subid=<%=subId%>;
    						</sql:query>

						</c:if>

						<form action="#" method="post">
							<div class="col-md-12" style="height: 500px">
								<div class="card border border-primary">
									<div class="card-header bg-info">
										<strong class="card-title text-white">Send Asnwer to
											students</strong>
									</div>

									<div class="card-body">
									<c:forEach var="user" items="${listStud.rows}">
										<div class="col col-8">
											<section class="card">
												<div class="card-body text-secondary">
													<input type="text"
														value="<c:out value="${queries.query}" />">
												</div>
											</section>
										</div>
										</c:forEach>
									</div>
									<!-- CARD END -->
								</div>
						</form>
					</div>
					<!-- section__content -->
				</div>
				<!-- main content end -->
			</div>
		</div>
	</div>
	<%@include file="footer.jsp"%>

</body>
</html>