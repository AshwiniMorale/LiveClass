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
										<li class="list-inline-item">Lectures</li>
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
						<form action="#" method="post">
							<div class="col-md-12" style="height: 500px">
								<div class="card border border-primary">
									<div class="card-header bg-info">
										<strong class="card-title text-white">Lectures</strong>
									</div>

									<div class="card-body">
										<div class="col col-10">

											<div class="row">
												<div class="col col-5">
													<section class="card">
														<div class="card-body text-secondary">
															<a href="liveVideo.jsp"><b>Live Lectures</b></a>
														</div>
													</section>
												</div>
												<div class="col col-5">
													<section class="card">
														<div class="card-body text-secondary">
															<a href="savedVideo.jsp"><b>Saved Lectures</b></a>
														</div>
													</section>
												</div>
											</div>



										</div>
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