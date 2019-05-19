<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>:: Education Details ::</title>
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
										<li class="list-inline-item active"><a href="#">Registration</a></li>
										<li class="list-inline-item seprate"><span>/</span></li>
										<li class="list-inline-item">Educational Details</li>
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
						<form action="saveusereducational.htm" method="post">
							<div class="col-md-12" style="height: 500px">
								<div class="card border border-primary">
									<div class="card-header bg-info">
										<strong class="card-title text-white">Educational
											Details</strong>
									</div>
									<div class="card-body">
										<div class="row">
											<div class="col col-3">
												<section class="card">
													<div class="card-body text-secondary">
														<input type="text" class="form-control"
															placeholder="10th Stream" name="XthStream">
													</div>
												</section>
											</div>
											<div class="col col-3">
												<section class="card">
													<div class="card-body text-secondary">
														<input type="text" class="form-control"
															placeholder="10th Board" name="XthBoard">
													</div>
												</section>
											</div>
											<div class="col col-3">
												<section class="card">
													<div class="card-body text-secondary">
														<input type="text" class="form-control"
															placeholder="10th Year" name="XthYear">
													</div>
												</section>
											</div>
											<div class="col col-3">
												<section class="card">
													<div class="card-body text-secondary">
														<input type="text" class="form-control"
															placeholder="10th Percentage" name="XthPercentage">
													</div>
												</section>
											</div>
										</div>
										<!-- first row ends -->
										<div class="row">
											<div class="col col-3">
												<section class="card">
													<div class="card-body text-secondary">
														<input type="text" class="form-control"
															placeholder="12th Stream" name="XIIthStream">
													</div>
												</section>
											</div>
											<div class="col col-3">
												<section class="card">
													<div class="card-body text-secondary">
														<input type="text" class="form-control"
															placeholder="12th Board" name="XIIthBoard">
													</div>
												</section>
											</div>
											<div class="col col-3">
												<section class="card">
													<div class="card-body text-secondary">
														<input type="text" class="form-control"
															placeholder="12th Year" name="XIIthYear">
													</div>
												</section>
											</div>
											<div class="col col-3">
												<section class="card">
													<div class="card-body text-secondary">
														<input type="text" class="form-control"
															placeholder="12th Percentage" name="XIIthPercentage">
													</div>
												</section>
											</div>
										</div>
										<!-- seccond row ends -->
										<div class="row">
											<div class="col col-3">
												<section class="card">
													<div class="card-body text-secondary">
														<input type="text" class="form-control"
															placeholder="UG Stream" name="ugStream">
													</div>
												</section>
											</div>
											<div class="col col-3">
												<section class="card">
													<div class="card-body text-secondary">
														<input type="text" class="form-control"
															placeholder="UG University" name="university">
													</div>
												</section>
											</div>
											<div class="col col-3">
												<section class="card">
													<div class="card-body text-secondary">
														<input type="text" class="form-control"
															placeholder="UG Year" name="ugYear">
													</div>
												</section>
											</div>
											<div class="col col-3">
												<section class="card">
													<div class="card-body text-secondary">
														<input type="text" class="form-control"
															placeholder="UG Percentage" name="ugPercentage">
													</div>
												</section>
											</div>
										</div>
										<!-- third row ends -->
									</div>
									<!-- card-body ends -->
									<div class="card-footer bg-white">
										<div class="row">
											<div class="col col-8">
												<div class="text-secondary">
													<span>${message }</span>
												</div>
											</div>
											<div class="col col-4">
												<div class="text-secondary">
													<button type="submit"
														class="btn btn-primary btn-block btn-flat">Save</button>
												</div>
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
	<!-- 	Pagewrapper ends -->
	<%@include file="footer.jsp"%>
</body>
</html>