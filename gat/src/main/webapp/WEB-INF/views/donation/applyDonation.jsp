<%@ page language="java" contentType="text/html; charset=UTF-8"
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
			<h3 class="mt-4 mb-3">
				재능기부자 기본 정보 <small>info</small>
			</h3>
			<div class="jumbotron">재능기부자 기본 정보</div>
		</div>
	</div>
</div>
<!-- /.Page Content -->
<!-- Page Content -->
<div class="container">
	<div class="row">
		<div class="col-10 offset-lg-1 my-4" data-spy="scroll"
			data-target="#navbar-dp-info" data-offset="50">
			<form action="../board/addApplication.do" method="post"
				id="contactForm" enctype="multipart/form-data">
				<div class="control-group form-group">
					<div class="controls">
						<label>재능기부 프로젝트명</label> <input type="text" class="form-control"
							id="appTitle" name="appTitle" required
							data-validation-required-message="재능기부 프로젝트명을 입력하세요">
					</div>
				</div>
				<div class="control-group form-group">
					<div class="controls">
						<label>신청 종류</label> <select class="form-control"
							name="appGroupVO.agNo" id="appGroupVO.agNo">
							<option value="1">재능기부
							<option value="2">기부단체
						</select>
					</div>
				</div>
				<div class="control-group form-group">
					<div class="controls">
						<label>재능기부 기간</label> <input type="date" id="start_date"
							name="startDate"> - <input type="date" id="end_date"
							name="endDate">
					</div>
				</div>
				<div class="control-group form-group">
					<div class="controls">
						<!-- <input class="form-control" style="width: 40%; display: inline;"
							placeholder="우편번호" name="addr1" id="addr1" type="text"
							readonly="readonly"> -->
						<button type="button" class="btn btn-sub-2-gnt"
							onclick="execPostCode();">
							<i class="fa fa-search"></i> 주소 찾기
						</button>
						<input class="form-control" style="top: 5px;" placeholder="주소"
							name="place" id="place" type="text" />
					</div>
					<div class="view-map"></div>
				</div>
				<div class="control-group form-group">
					<div class="controls">
						<label>목표 마일리지</label> <input type="number" class="form-control"
							name="goalMileage" required="required">
					</div>
				</div>
				<div class="control-group form-group">
					<div class="controls">
						<label>선물 목록1</label> <input type="number" class="form-control"
							name="donationMileage1" placeholder="선물 마일리지를 입력하세요"
							required="required"> <input type="text"
							class="form-control" name="presentContents1"
							placeholder="선물내용을 입력하세요" required="required">
					</div>
					<div class="controls">
						<label>선물 목록2</label> <input type="number" class="form-control"
							name="donationMileage2" placeholder="선물 마일리지를 입력하세요"> <input
							type="text" class="form-control" name="presentContents2"
							placeholder="선물내용을 입력하세요">
					</div>
					<div class="controls">
						<label>선물 목록3</label> <input type="number" class="form-control"
							name="donationMileage3" placeholder="선물 마일리지를 입력하세요"> <input
							type="text" class="form-control" name="presentContents3"
							placeholder="선물내용을 입력하세요">
					</div>
				</div>
				<div class="control-group form-group">
					<label>대표 이미지</label>
					<!-- <button type="" class="btn btn-sm">검색</button> -->
					<input type="file" class="form-control" name="main_image"
						required="required">
				</div>
				<div class="control-group form-group">
					<div class="controls">
						<label>재능기부 프로젝트 요약</label> <input type="text" class="form-control"
							name="appSummery" placeholder="선물내용을 입력하세요">
					</div>
				</div>
				<div class="control-group form-group">
					<div class="controls">
						<label>재능기부 프로젝트 소개</label>
						<!-- <textarea rows="10" cols="100" class="form-control" id="message" required data-validation-required-message="Please enter your message" maxlength="999" style="resize:none" placeholder="문의내용"></textarea> -->
						<textarea name="appContents" id="appContents" rows="10" cols="100"
							required data-validation-required-message="재능기부 프로젝트 소개를 입력하세요"
							style="width: 918px; height: 412px;"></textarea>
					</div>
				</div>
				<div id="success"></div>
				<!-- For success/fail messages -->
				<button type="button" class="btn btn-sub-2-gnt btn-block"
					id="savebutton">재능기부 신청하기</button>
			</form>
		</div>
	</div>
	<!-- /.row -->

</div>
<!-- /.container -->