<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    ${dpVO }
<!-- Page Content -->
<div class="container my-3">
	<!-- Portfolio Item Row -->
	<div class="row">	
		<div class="col-md-6">
		  <img class="img-fluid mt-3" src="${dpVO.dpImgDirectory }" alt="">
		</div>	
		<div class="col-md-6">
			<h2 class="my-3 pb-2 border-bottom"> ${dpVO.dpTitle}</h2>
			<h4><span class="mr-2">목표 마일리지</span><b>${dpVO.goalMileage }</b></h4>
			<h4><span class="mr-2">현재 참여 마일리지</span><b>${dpVO.donationMileage }</b></h4>
			<h4><span class="mr-2">참여자 수</span>${dpVO.totalEntry }</h4>
			<h3 class="mt-3 sub-1-txt-gnt">${(dpVO.donationMileage/dpVO.goalMileage)*100 }%</h3>
			<div class="progress mb-3">
				<div class="progress-bar bg-sub-3-gnt" role="progressbar" style="width:${(dpVO.donationMileage/dpVO.goalMileage)*100 }%" aria-valuenow="${(dpVO.donationMileage/dpVO.goalMileage)*100 }" aria-valuemin="0" aria-valuemax="100"></div>
			</div>
			<p>${dpVO.dpSummery }</p>
			<c:choose>
				<c:when test="${sessionScope.mvo==null||sessionScope.mvo.id==null}">
					<button id="entryBtn" class="btn btn-point-gnt btn-block" type="button">참여하기</button>		
				</c:when>
				<c:when test="${tdpVO!=null&&tdpVO.tdNo!=0 }">
					<button id="checkEntryBtn" class="btn btn-point-gnt btn-block" type="button">참여하기</button>
				</c:when>
				<c:otherwise>
					<button class="btn btn-point-gnt btn-block" type="submit" data-toggle="modal" data-target="#entryForm">참여하기</button>	
				</c:otherwise>
			</c:choose>
				
		</div>
		<!-- 참여 신청 Modal -->
		<div class="modal fade" id="entryForm" role="dialog">
			<div class="modal-dialog modal-dialog-centered">
				<div class="modal-content">
					<div class="modal-header bg-point-gnt">
						<h4 class="modal-title text-center text-white">재능기부 참여 신청</h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>					
					<form method="post" action="${pageContext.request.contextPath }/addTakeDonation.do" id="entryDonation">
						<div class="modal-body bg-light">
							<div class="m-3">
								<input type="hidden" name="dpno" value="${dpVO.dpNo}">
								<p>${dpVO.dpTitle }</p>
								<p>${dpVO.startDate } - ${dpVO.endDate }</p>
							</div>
							<div class="form-group my-3">
								<label for="">사용할 마일리지 <small class="pl-1">보유 마일리지 : <span id="userMileage">${sessionScope.mvo.mileage }</span></small></label>
								<input type="text" class="form-control form-control-sm" name="tdMileage" id="tdMileage">
								
							</div>
							<div class="form-group my-3">
								<label class="">한줄 응원 메세지</label><input type="text" class="form-control" name="cheerUpMessage" id="cheerUpMessage">
							</div>
							<div class="form-check small-txt">
								<input type="checkbox" class="form-check-input" id="entryAgree">
								<label class="form-check-label" for="entryAgree">상기 내용에 동의합니다</label>								
							</div>							
						</div>
						<div class="modal-footer">
							<button type="submit" class="btn btn-point-gnt">신청하기</button>
							<button type="button" class="btn" id="cancelBtn">취소</button>
						</div>					
					</form>
				</div>
		
			</div>
		</div>
		<!-- /.참여 신청 modal -->
	</div>
	<!-- /.row -->
</div>
<!-- /.container -->
		
<nav id="navbar-dp-info" class="mt-5 border-top border-bottom">
	<div class="container border-left">
		<ul class="nav nav-pills">	
			<li class="nav-item">
				<a class="nav-link" href="#dp_summary">재능기부 요약정보</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="#dp_info">재능기부 소개</a>
			</li>	
			<li class="nav-item">
				<a class="nav-link" href="#dp_member">재능기부자 소개</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="#dp_community">커뮤니티</a>
			</li>
		</ul>
	</div>
</nav>
	
<div class="container border border-top-0 pb-5 mb-5">	  
	<div class="row pt-3">
		<div class ="col-sm-12 px-4" data-spy="scroll" data-target="#navbar-dp-info" data-offset="50">			
			<!-- 재능기부 요약정보 -->
			<div id="dp_summary">
				<h3 class="mt-4 mb-3">재능기부 요약정보
					<small>summary</small>
				</h3>
				<div class="jumbotron">
					<p><small class="pr-1">프로젝트명</small>${dpVO.dpTitle }</p>
					<p><small class="pr-1">프로젝트 요약</small>${dpVO.dpSummery }</p>
					<p><small class="pr-1">프로젝트 장소</small><div id="map" style="width:400px;height:400px;"></div>${dpVO.place }</p>
				</div>
			</div>
			
			<!-- 재능기부 소개(스마트에디터) -->
			<div id="dp_info">
				<h3 class="mt-4 mb-3">재능기부 소개
					<small>introduce</small>
				</h3>
				<div class="jumbotron">
					${dpVO.dpContents }
				</div>
			</div>
			<!-- 재능기부자 소개 -->
			<div id="dp_member">
				<h4 class="mt-4 mb-3">재능기부자 소개
					<small>info</small>
				</h4>
				<div class="jumbotron">
					재능기부자 소개<br>재능기부자 소개<br>재능기부자 소개<br>
					재능기부자 소개<br>재능기부자 소개<br>재능기부자 소개<br>
					재능기부자 소개<br>재능기부자 소개<br>재능기부자 소개<br>
					재능기부자 소개<br>재능기부자 소개<br>재능기부자 소개<br>
					재능기부자 소개<br>재능기부자 소개<br>재능기부자 소개<br>
				</div>
			</div>
		</div>
	</div>
	
	<div class="row my-3">
		<div class="col-sm-12" id="dp_community" data-spy="scroll" data-target="#navbar-dp-info" data-offset="50">
			<ul class="nav nav-tabs nav-fill" id="myTab" role="tablist">
				<li class="nav-item">
					<a class="nav-link active" id="cheerup-tab" data-toggle="tab" href="#cheerup-message" role="tab" aria-controls="profile" aria-selected="true">응원 메시지</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" id="review-tab" data-toggle="tab" href="#entry-review" role="tab" aria-controls="home" aria-selected="false">참여 후기</a>
				</li>
				
			</ul>
			<div class="tab-content" id="myTabContent">
				<div class="tab-pane fade show active mx-3 my-3" id="cheerup-message" role="tabpanel" aria-labelledby="cheerup-tab">
					<h4 class="mt-5 pb-3 mb-3 border-bottom">응원 메시지</h4>					
					<c:forEach items="${tdList.tdpVO}" var="list">
						<div class="border-bottom">
							<div class="media mt-4">
								<div class="media-body mb-3 ml-3">
								 ${list.cheerUpMessage}<span class="small-txt border-left ml-2 pl-2">${list.memberVO.name }님 <b>${list.tdMileage }</b> 마일리지 후원</span>
								</div>
							</div>
						</div>
					</c:forEach>
					
					<!-- Pagination -->
					<ul class="pagination justify-content-center mt-5">
						<c:set var="pb" value="${tdList.tdpPb}"/>
						<c:if test="${pb.previousPageGroup}">	
							<li class="page-item">
								<a class="page-link" href="${pageContext.request.contextPath}/donation/readDonationDetail.do?dpno=${dpVO.dpNo}&tdNowPage=${pb.startPageOfPageGroup-1}&rpNowPage=1" aria-label="Previous">
									<span aria-hidden="true">&laquo;</span>
									<span class="sr-only">Previous</span>
								</a>
							</li>
						</c:if>
						<c:forEach var="i" begin="${pb.startPageOfPageGroup}" end="${pb.endPageOfPageGroup}">
							<c:choose>
								<c:when test="${pb.nowPage!=i}">
									<li class="page-item">
										<a class="page-link" href="${pageContext.request.contextPath}/donation/readDonationDetail.do?dpno=${dpVO.dpNo}&tdNowPage=${i}&rpNowPage=${rpList.rpPb.nowPage }#dp_community">${i}</a>
									</li>
								</c:when>
								<c:otherwise>
									<li class="page-item active"><a class="page-link" href="#" >${i}</a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:if test="${pb.nextPageGroup}">	
						<li class="page-item">
							<a class="page-link" href="${pageContext.request.contextPath}/donation/readDonationDetail.do?dpno=${dpVO.dpNo}&tdNowPage=${pb.endPageOfPageGroup+1}&rpNowPage=1" aria-label="Next">
								<span aria-hidden="true">&raquo;</span>
								<span class="sr-only">Next</span>
							</a>
						</li>
						</c:if>
					</ul>
				</div>
				<div class="tab-pane fade mx-3 my-3" id="entry-review" role="tabpanel" aria-labelledby="review-tab">
					<h4 class="mt-5 pb-3 mb-3 border-bottom">참여 후기</h4>
					<div class="mb-3">
						<!-- 후기 작성 btn -->
						<%-- <c:forEach items="${tdpList }" var="tdp">
							<p><c:set="${tdpList.tdNo }" var=tdNo />
							${tdp.tdNo }</p>
						</c:forEach>
						<span class="small-txt border-right pr-2 mr-2">재능기부에 참여한 후기를 남겨주세요</span>
						<a href="#" id="writeReview" class="text-dark small-txt" data-toggle="modal" data-target="#writeReviewForm">후기 작성하기<i class="far fa-edit"></i></a>	 --%>
						
						<c:if test="${(tdpVO!=null&&tdpVO.tdNo!=0)}">
							<span class="small-txt border-right pr-2 mr-2">재능기부에 참여한 후기를 남겨주세요</span>
							<a href="#" id="writeReview" class="text-dark small-txt" data-toggle="modal" data-target="#writeReviewForm">후기 작성하기<i class="far fa-edit"></i></a>					
						</c:if>
						
						<!-- 후기 작성 Modal -->
						<div class="modal fade" id="writeReviewForm" role="dialog">
							<div class="modal-dialog modal-dialog-centered">
								<div class="modal-content">
									<div class="modal-header bg-point-gnt">
										<h5 class="modal-title text-center text-white ml-3">후기 작성</h5>
										<button type="button" class="mr-2 close" data-dismiss="modal">&times;</button>
									</div>											
									<form method="post" action="${pageContext.request.contextPath}/addReview.do" id="addReview">
										<div class="modal-body bg-light">
											<div class="row m-1 p-3 border">
												<input type="hidden" name="tdno" value="${tdpVO.tdNo}">
												<input type="hidden" name="dpno" value="${dpVO.dpNo }">
												<p>${dpVO.dpTitle }</p>
												<p>프로젝트 기간, 기부자명, 대표이미지, </p>
												<p>참여번호:${tdpVO.tdNo}</p>
											</div>
											<div class="form-group my-3">
												<label for="">제목</label>
												<input type="text" class="form-control" name="rpTitle" id="rpTitle">
											</div>
											<div calss="form-group my-3">
												<label class="">별점</label>
												<input type="number" class="form-control form-sm"  name="rpRate" min="1" max="10" id="rpRate">
											</div>
											<div class="form-group my-3">
												<label class="">내용</label>
												<pre><textarea rows="7" maxlength="300" class="form-control" name="rpContents" id="rpDontents"></textarea></pre>
											</div>
															
										</div>
										<div class="modal-footer">
											<button type="submit" class="btn btn-point-gnt">후기 등록</button>
											<button type="button" class="btn" id="cancelBtn">취소</button>
										</div>					
									</form>
								</div>
							</div>
						</div>		
						<!-- /.후기 작성 modal -->
					</div>
					<table class="table table-hover">
						<thead>
							<tr>
								<td>#</td>
								<td>글제목</td>
								<td>평점</td>
								<td>작성자</td>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${rpList.list}" var="list" varStatus="i">
							<tr>
								<td>${list.rpNo }</td>
								<td><a href="#" data-toggle="modal" data-target="#entryReviewDetail${i.index}">${list.rpTitle }</a></td>
								<td><c:forEach var="rate" begin="1" end="${list.rpRate }" step="1">
									<c:out value="★"/>
								</c:forEach></td>
								<td>${list.memberVO.name }</td>
							</tr>		
							<!-- 후기 상세 Modal -->
							<div class="modal fade" id="entryReviewDetail${i.index }" role="dialog">
								<div class="modal-dialog modal-dialog-centered">
									<div class="modal-content">
										<div class="modal-header bg-point-gnt">
											<h5 class="modal-title text-center text-white ml-3">후기</h5>
											<button type="button" class="mr-2 close" data-dismiss="modal">&times;</button>
										</div>											
										<div class="modal-body bg-light">
											<div class="row m-3">
												<pre>${list.rpTitle }</pre>
											</div>
											<div class="row m-3">
												<div class="jumbotron">
												<pre>${list.rpContents }</pre>
													
												</div>
											</div>			
										</div>
									</div>
								</div>
							</div>
							</c:forEach>	
							<!-- /.후기 상세 modal -->		
						</tbody>
					</table>
					
					<!-- Pagination -->
					<ul class="pagination justify-content-center mt-5">
						<c:set var="pb" value="${rpList.rpPb}"/>
						<c:if test="${pb.previousPageGroup}">	
							<li class="page-item">
								<a class="page-link" href="${pageContext.request.contextPath}/donation/readDonationDetail.do?dpno=${dpVO.dpNo}&nowPage=${pb.startPageOfPageGroup-1}" aria-label="Previous">
									<span aria-hidden="true">&laquo;</span>
									<span class="sr-only">Previous</span>
								</a>
							</li>
						</c:if>
						<c:forEach var="i" begin="${pb.startPageOfPageGroup}" end="${pb.endPageOfPageGroup}">
							<c:choose>
								<c:when test="${pb.nowPage!=i}">
									<li class="page-item">
										<a class="page-link" href="${pageContext.request.contextPath}/donation/readDonationDetail.do?dpno=${dpVO.dpNo}&tdNowPage=${tdList.tdpPb.nowPage }&rpNowPage=${i}#dp_community}">${i}</a>
									</li>
								</c:when>
								<c:otherwise>
									<li class="page-item active"><a class="page-link" href="#" >${i}</a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:if test="${pb.nextPageGroup}">	
						<li class="page-item">
							<a class="page-link" href="${pageContext.request.contextPath}/donation/readDonationDetail.do?dpno=${dpVO.dpNo}&nowPage=${pb.endPageOfPageGroup+1}" aria-label="Next">
								<span aria-hidden="true">&raquo;</span>
								<span class="sr-only">Next</span>
							</a>
						</li>
						</c:if>
					</ul>
					
				</div>
			</div>
		</div>
	</div>
 </div>
 <!-- /.container -->