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
		<!-- PAGE CONTENT-->
		<div class="page-content--bgf7">
			<!-- BREADCRUMB -->
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
										<li class="list-inline-item">Dashboard</li>
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
						<form action="UserPersonalDetails.htm" method="post">
							<div class="row">
								<div class="col-md-12" style="height: 500px">
									<div class="card border border-primary">
										<div class="card-header bg-info">
											<strong class="card-title text-white">Profile</strong>
										</div>
										<div class="card-body">
											<div class="row">
												<div class="col">
													<section class="card">
														<div class="card-body text-secondary">
															<input type="date" class="form-control"
																placeholder="Date of Birth" name="dob"
																id="datetimepicker4">
														</div>
													</section>
												</div>
												<div class="col">
													<section class="card">
														<div class="card-body text-secondary">
															<input type="text" class="form-control"
																placeholder="Gender" name="gender">
														</div>
													</section>
												</div>
												<div class="col">
													<section class="card">
														<div class="card-body text-secondary">
															<input type="text" class="form-control"
																placeholder="Hometown" name="hometown">
														</div>
													</section>
												</div>
											</div>
											<div class="row">
												<div class="col">
													<section class="card">
														<div class="card-body text-secondary">
															<input type="text" class="form-control"
																placeholder="Area PinCode" name="areaPinCode">
														</div>
													</section>
												</div>
												<div class="col">
													<section class="card">
														<div class="card-body text-secondary">
															<input type="text" class="form-control"
																placeholder="Marital Status" name="maritalStatus">
														</div>
													</section>
												</div>
												<div class="col">
													<section class="card">
														<div class="card-body text-secondary">
															<input type="text" class="form-control"
																placeholder="Permanent Address" name="permanentAddress">
														</div>
													</section>
												</div>
											</div>
											<div class="row">
												<div class="col">
													<section class="card">
														<div class="card-body text-secondary">
															<div class="col-xs-4">
																<button type="submit"
																	class="btn btn-primary btn-block btn-flat">Save</button>
															</div>
														</div>
													</section>
												</div>
												<div class="col">
													<section class="card">
														<div class="card-body text-secondary"></div>
													</section>
												</div>
												<div class="col">
													<section class="card">
														<div class="card-body text-secondary"></div>
													</section>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>
				<!-- section__content -->
			</div>
			<!-- main content end -->
		</div>
	</div>
	<!-- 	Pagewrapper ends -->
	<%@include file="footer.jsp"%>
</body>
</html>