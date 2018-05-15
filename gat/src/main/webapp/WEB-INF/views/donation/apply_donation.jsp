<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!-- Page Heading -->
	<div class="page-heading bg-sub-3-gnt">
		<h4 class="py-5 text-center">재능기부 신청하기</h4>
	</div>
	
	<!-- /.Page Heading -->
	
	<!-- Page Content -->
	<div class="container">
		<div class="row">
			<div class="col-10 offset-lg-1 my-4">
				<h3 class="mt-4 mb-3">재능기부자 기본 정보
						<small>info</small>
					</h3>
				<div class="jumbotron">
					재능기부자 기본 정보
				</div>
			</div>
		</div>
	</div>
	<!-- /.Page Content -->
	<!-- Page Content -->
	<div class="container">
		<div class="row">
			<div class="col-10 offset-lg-1 my-4" data-spy="scroll" data-target="#navbar-dp-info" data-offset="50">
				<form action="#" method="#">
					<div class="control-group form-group">
						<div class="controls">
							<label>재능기부 프로젝트명</label>
							<input type="text" class="form-control" id="name" required data-validation-required-message="재능기부 프로젝트명을 입력하세요">
						</div>
					</div>
					<div class="control-group form-group">
						<div class="controls">
							<label>재능기부 기간</label>
							<input type="date" id="start_date"> - <input type="date" id="end_date">
						</div>
					</div>
					<div class="control-group form-group">
						<div class="controls">
							<label>주소</label>
							<button type="" class="btn btn-sm">검색</button>
							<input type="text" class="form-control" name="address">
						</div>
						<div class="view-map"></div>
					</div>
					<div class="control-group form-group">
						<label>이미지</label>
						<button type="" class="btn btn-sm">검색</button>
						<input type="upload" class="form-control" name="address">
					</div>
					<div class="control-group form-group">
						<div class="controls">
							<label>재능기부 프로젝트 소개</label>
							<textarea rows="10" cols="100" class="form-control" id="message" required data-validation-required-message="Please enter your message" maxlength="999" style="resize:none" placeholder="문의내용"></textarea>
						</div>
					</div>
					<div id="success"></div>
					<!-- For success/fail messages -->
					<button type="submit" class="btn btn-sub-2-gnt btn-block" id="apply_gibu">재능기부 신청하기</button>
				</form>
			</div>
		</div>
		<!-- /.row -->

	</div>
	<!-- /.container -->
