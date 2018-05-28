<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- sliding img -->
<header>
	<div id="carouselExampleIndicators" class="carousel slide"
		data-ride="carousel">
		<ol class="carousel-indicators">
			<li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
			<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
			<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner" role="listbox">
			<!-- Slide One - Set the background image for this slide in the line below -->
			<div class="carousel-item active" style="background-image:url('${pageContext.request.contextPath}/resources/img/main_img01.jpg')">
				<div class="carousel-caption d-none d-md-block">
					<h3>GIBU AND TAKE</h3>
					<p>봉사활동을 더 가치있게 만드는 새로운 사회공헌 플랫폼입니다</p>
				</div>
			</div>
			<!-- Slide Two - Set the background image for this slide in the line below -->
			<div class="carousel-item"
				style="background-image: url(${pageContext.request.contextPath}/resources/img/main_img02.jpg)">
				<div class="carousel-caption d-none d-md-block">
					<h3>A gift in season is a double favor to the needy.</h3>
					<p>- Good fences makes good neighbors -</p>
				</div>
			</div>
			<!-- Slide Three - Set the background image for this slide in the line below -->
			<div class="carousel-item"
				style="background: url(${pageContext.request.contextPath}/resources/img/main_img03.png) center top">
				<div class="carousel-caption d-none d-md-block">
					<h3>GIBU AND TAKE</h3>
					<p>The die is cast.</p>
				</div>
			</div>
		</div>
		<a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
			<span class="carousel-control-prev-icon" aria-hidden="true"></span>
			<span class="sr-only">Previous</span>
		</a>
		<a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
			<span class="carousel-control-next-icon" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>
</header>

<!-- Page Content -->
<div class="container mt-5">
	<!-- Portfolio Section -->
	<div class="row">
		<div class="col-lg-3 col-sm-6 portfolio-item white-txt"">
			<div class="card h-100 bg-sub-1-gnt">
				<div class="card-body">
					<h4 class="card-title">
						<a href="${pageContext.request.contextPath}/donation/listDonation.do">기부</a>
					</h4>
					<p class="card-text">Lorem ipsum dolor sit amet, consectetur
						adipiscing elit. Nam viverra euismod odio, gravida pellentesque
						urna varius vitae.</p>
					<a href="${pageContext.request.contextPath}/donation/listDonation.do">
						more <i class="fas fa-angle-double-right"></i>
					</a>
				</div>
			</div>
		</div>
		<div class="col-lg-3 col-sm-6 portfolio-item">
			<div class="card h-100">
				<a href="${pageContext.request.contextPath }/donation/readDonationDetail.do?dpno=${rank[0].DP_NO }&tdNowPage=1&rpNowPage=1">
					<img class="card-img-top" src="${rank[0].DP_IMGDIRECTORY}" alt="">
				</a>
				<div class="card-body">
					<h4 class="card-title">
						<a class="sub-1-txt-gnt" href="${pageContext.request.contextPath }/donation/readDonationDetail.do?dpno=${rank[0].DP_NO }&tdNowPage=1&rpNowPage=1">${rank[0].DP_TITLE }</a>
					</h4>
					<p class="card-text">${rank[0].DP_SUMMERY }</p>
				</div>
			</div>
		</div>
		<div class="col-lg-3 col-sm-6 portfolio-item">
			<div class="card h-100">
				<a href="${pageContext.request.contextPath }/donation/readDonationDetail.do?dpno=${rank[1].DP_NO }&tdNowPage=1&rpNowPage=1">
					<img class="card-img-top" src="${rank[1].DP_IMGDIRECTORY}" alt="">
				</a>
				<div class="card-body">
					<h4 class="card-title">
						<a class="sub-1-txt-gnt" href="${pageContext.request.contextPath }/donation/readDonationDetail.do?dpno=${rank[1].DP_NO }&tdNowPage=1&rpNowPage=1">${rank[1].DP_TITLE }</a>
					</h4>
					<p class="card-text">${rank[1].DP_SUMMERY }</p>
				</div>
			</div>
		</div>
		<div class="col-lg-3 col-sm-6 portfolio-item">
			<div class="card h-100">
				<a href="${pageContext.request.contextPath }/donation/readDonationDetail.do?dpno=${rank[2].DP_NO }&tdNowPage=1&rpNowPage=1">
					<img class="card-img-top" src="${rank[2].DP_IMGDIRECTORY}" alt="">
				</a>
				<div class="card-body">
					<h4 class="card-title">
						<a class="sub-1-txt-gnt" href="${pageContext.request.contextPath }/donation/readDonationDetail.do?dpno=${rank[2].DP_NO }&tdNowPage=1&rpNowPage=1">${rank[2].DP_TITLE }</a>
					</h4>
					<p class="card-text">${rank[2].DP_SUMMERY }</p>
				</div>
			</div>
		</div>

	</div>
	<!-- /.row -->

	<!-- Portfolio Section -->
	<div class="row">
		<div class="col-lg-3 col-sm-6 portfolio-item white-txt">
			<div class="card h-100 bg-sub-2-gnt">
				<div class="card-body">
					<h4 class="card-title">
						<a href="#">taking</a>
					</h4>
					<p class="card-text">Lorem ipsum dolor sit amet, consectetur
						adipiscing elit. Nam viverra euismod odio, gravida pellentesque
						urna varius vitae.</p>
					<a href="#">more<i class="fas fa-angle-double-right"></i></a>
				</div>
			</div>
		</div>
		<div class="col-lg-3 col-sm-6 portfolio-item">
			<div class="card h-100">
				<a href="#"><img class="card-img-top"
					src="${pageContext.request.contextPath }/resources/img/img4.jpg"
					alt=""></a>
				<div class="card-body">
					<h4 class="card-title">
						<a href="#">Project Two</a>
					</h4>
					<p class="card-text">Lorem ipsum dolor sit amet, consectetur
						adipiscing elit. Nam viverra euismod odio, gravida pellentesque
						urna varius vitae.</p>
				</div>
			</div>
		</div>
		<div class="col-lg-3 col-sm-6 portfolio-item">
			<div class="card h-100">
				<a href="#"><img class="card-img-top"
					src="${pageContext.request.contextPath }/resources/img/img5.jpg"
					alt=""></a>
				<div class="card-body">
					<h4 class="card-title">
						<a class="sub-1-txt-gnt" href="#">Project Three</a>
					</h4>
					<p class="card-text">Lorem ipsum dolor sit amet, consectetur
						adipisicing elit. Quos quisquam, error quod sed cumque, odio
						distinctio velit nostrum temporibus necessitatibus et facere atque
						iure perspiciatis mollitia recusandae vero vel quam!</p>
				</div>
			</div>
		</div>
		<div class="col-lg-3 col-sm-6 portfolio-item">
			<div class="card h-100">
				<a href="#">
					<img class="card-img-top" src="${pageContext.request.contextPath }/resources/img/img6.jpg" alt="">
				</a>
				<div class="card-body">
					<h4 class="card-title">
						<a class="sub-1-txt-gnt" href="#">Project Four</a>
					</h4>
					<p class="card-text">Lorem ipsum dolor sit amet, consectetur
						adipiscing elit. Nam viverra euismod odio, gravida pellentesque
						urna varius vitae.</p>
				</div>
			</div>
		</div>

	</div>
	<!-- /.row -->

	<!-- Portfolio Section -->
	<div class="row">
		<div class="col-lg-3 col-sm-6 portfolio-item white-txt">
			<div class="card h-100 bg-point-gnt">
				<div class="card-body">
					<h4 class="card-title">
						<a href="#">Best Person</a>
					</h4>
					<p class="card-text">Lorem ipsum dolor sit amet, consectetur
						adipiscing elit. Nam viverra euismod odio, gravida pellentesque
						urna varius vitae.</p>
					<a href="#">more<i class="fas fa-angle-double-right"></i></a>
				</div>
			</div>
		</div>
		<div class="col-lg-3 col-sm-6 portfolio-item">
			<div class="card h-100">
				<a href="#"><img class="card-img-top"
					src="${pageContext.request.contextPath }/resources/img/img2.jpg"
					alt=""></a>
				<div class="card-body">
					<h4 class="card-title">
						<a class="sub-1-txt-gnt" href="#">Project Two</a>
					</h4>
					<p class="card-text">Lorem ipsum dolor sit amet, consectetur
						adipiscing elit. Nam viverra euismod odio, gravida pellentesque
						urna varius vitae.</p>
				</div>
			</div>
		</div>
		<div class="col-lg-3 col-sm-6 portfolio-item">
			<div class="card h-100">
				<a href="#"><img class="card-img-top"
					src="${pageContext.request.contextPath }/resources/img/img4.jpg"
					alt=""></a>
				<div class="card-body">
					<h4 class="card-title">
						<a class="sub-1-txt-gnt" href="#">Project Three</a>
					</h4>
					<p class="card-text">Lorem ipsum dolor sit amet, consectetur
						adipisicing elit. Quos quisquam, error quod sed cumque, odio
						distinctio velit nostrum temporibus necessitatibus et facere atque
						iure perspiciatis mollitia recusandae vero vel quam!</p>
				</div>
			</div>
		</div>
		<div class="col-lg-3 col-sm-6 portfolio-item">
			<div class="card h-100">
				<a href="#"><img class="card-img-top"
					src="${pageContext.request.contextPath }/resources/img/img1.jpg"
					alt=""></a>
				<div class="card-body">
					<h4 class="card-title">
						<a class="sub-1-txt-gnt" href="#">Project Four</a>
					</h4>
					<p class="card-text">Lorem ipsum dolor sit amet, consectetur
						adipiscing elit. Nam viverra euismod odio, gravida pellentesque
						urna varius vitae.</p>
				</div>
			</div>
		</div>

	</div>
	<!-- /.row -->
</div>
<!--/.container -->
