<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="jumbotron">
	<div class="container">
		<div class="row">
			 <div class="col-lg-4 col-sm-4 portfolio-item">
				<div class="card h-100">
					<a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
					<div class="card-body">
						<h4 class="card-title">
							<a href="${pageContext.request.contextPath }/donation/detailDonation.do">${rank[0].DP_TITLE }</a>
						</h4>
						<p class="card-text">${rank[0].DP_SUMMERY }</p>
					</div>
				</div>
			</div>
			<div class="col-lg-4 col-sm-4 portfolio-item">
				<div class="card h-100">
					<a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
					<div class="card-body">
						<h4 class="card-title">
							<a href="${pageContext.request.contextPath }/donation/detailDonation.do">${rank[1].DP_TITLE }</a>
						</h4>
						<p class="card-text">${rank[1].DP_SUMMERY }</p>
					</div>
				</div>
			</div>
			<div class="col-lg-4 col-sm-4 portfolio-item">
				<div class="card h-100">
					<a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
					<div class="card-body">
						<h4 class="card-title">
							<a href="${pageContext.request.contextPath }/donation/detailDonation.do">${rank[2].DP_TITLE }</a>
						</h4>
						<p class="card-text">${rank[2].DP_SUMMERY }</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- Page Content -->
<div class="container mt-5 mb-5">   
	<!-- 재능기부 신청하기 -->
	<a href="${pageContext.request.contextPath }/donation/applyDonation.do" class="btn btn-point-gnt my-5">재능기부 신청하기</a>
    <!-- Project One -->
    <div class="row">
      <div class="col-md-7">
        <a href="${pageContext.request.contextPath }/donation/detailDonation.do">
          <img class="img-fluid rounded mb-3 mb-md-0" src="http://placehold.it/700x300" alt="">
        </a>
      </div>
      <div class="col-md-5">
        <h3><a href="${pageContext.request.contextPath }/donation/detailDonation.do">${list[0].DP_TITLE }</a></h3>
        <p>${list[0].DP_SUMMERY }</p>
        <a class="btn btn-primary" href="${pageContext.request.contextPath }/donation/detailDonation.do">View Project
          <span class="glyphicon glyphicon-chevron-right"></span>
        </a>
      </div>
    </div>
    <!-- /.row -->

    <hr>

    <!-- Project Two -->
    <div class="row">
      <div class="col-md-7">
        <a href="${pageContext.request.contextPath }/donation/detailDonation.do">
          <img class="img-fluid rounded mb-3 mb-md-0" src="http://placehold.it/700x300" alt="">
        </a>
      </div>
      <div class="col-md-5">
        <h3><a href="${pageContext.request.contextPath }/donation/detailDonation.do">${list[1].DP_TITLE }</a></h3>
        <p>${list[1].DP_SUMMERY }</p>
        <a class="btn btn-primary" href="${pageContext.request.contextPath }/donation/detailDonation.do">View Project
          <span class="glyphicon glyphicon-chevron-right"></span>
        </a>
      </div>
    </div>
    <!-- /.row -->

    <hr>

    <!-- Project Three -->
    <div class="row">
      <div class="col-md-7">
        <a href="${pageContext.request.contextPath }/donation/detailDonation.do">
          <img class="img-fluid rounded mb-3 mb-md-0" src="http://placehold.it/700x300" alt="">
        </a>
      </div>
      <div class="col-md-5">
        <h3><a href="${pageContext.request.contextPath }/donation/detailDonation.do">${list[2].DP_TITLE }</a></h3>
        <p>${list[2].DP_SUMMERY }</p>
        <a class="btn btn-primary" href="${pageContext.request.contextPath }/donation/detailDonation.do">View Project
          <span class="glyphicon glyphicon-chevron-right"></span>
        </a>
      </div>
    </div>
    <!-- /.row -->

    <hr>

    <!-- Project Four -->
    <div class="row">

      <div class="col-md-7">
        <a href="${pageContext.request.contextPath }/donation/detailDonation.do">
          <img class="img-fluid rounded mb-3 mb-md-0" src="http://placehold.it/700x300" alt="">
        </a>
      </div>
      <div class="col-md-5">
        <h3><a href="${pageContext.request.contextPath }/donation/detailDonation.do">${list[3].DP_TITLE }</a></h3>
        <p>${list[3].DP_SUMMERY }</p>
        <a class="btn btn-primary" href="#">View Project
          <span class="glyphicon glyphicon-chevron-right"></span>
        </a>
      </div>
    </div>
    
    <div id="posts">
        </div>
    <!-- /.row -->

    <hr>

    <!-- Pagination -->
    <!-- <ul class="pagination justify-content-center mt-5">
      <li class="page-item">
        <a class="page-link" href="#" aria-label="Previous">
          <span aria-hidden="true">&laquo;</span>
          <span class="sr-only">Previous</span>
        </a>
      </li>
      <li class="page-item">
        <a class="page-link" href="#">1</a>
      </li>
      <li class="page-item">
        <a class="page-link" href="#">2</a>
      </li>
      <li class="page-item">
        <a class="page-link" href="#">3</a>
      </li>
      <li class="page-item">
        <a class="page-link" href="#" aria-label="Next">
          <span aria-hidden="true">&raquo;</span>
          <span class="sr-only">Next</span>
        </a>
      </li>
<<<<<<< HEAD
    </ul> -->
=======
    </ul>
>>>>>>> branch 'master' of https://github.com/FunnySeongMin/Gibu-And-Take.git
</div>
<!-- /.container -->



        

        <p id="loading">
            <!-- <img src="images/loading.gif" alt="Loading…" /> -->
        </p>







	<script type="text/javascript" src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
    var win = $(window);
    var i=4;
    // 스크롤할때마다 로드
    win.scroll(function() {
        // 끝에 도달하면 로드?
        if ($(document).height() - win.height() == win.scrollTop()) {
            $('#loading').show();

            
            
            $.ajax({
            	type:"get",
                url: '../donation/DonationListView2.do',
                success: function(result) {
                	//alert(result[1].DP_SUMMERY);
                    //
                    //$('#loading').hide();
                    if(result){
                    	$('#posts').append("<hr><div class=row><div class=col-md-7><a href=${pageContext.request.contextPath }/donation/detailDonation.do><img class=img-fluid rounded mb-3 mb-md-0 src=http://placehold.it/700x300 alt=></a></div><div class=col-md-5><h3><a href=${pageContext.request.contextPath }/donation/detailDonation.do>"+result[i].DP_TITLE+"</a></h3><p>"+result[i].DP_SUMMERY+"</p><a class=btn btn-primary href=#>View Project<span class=glyphicon glyphicon-chevron-right></span></a></div></div>");
                    	
                    	i=i+1
                    }
                }
            });
            
/* 
            $('#posts').append('젠장');
            $('#loading').hide(); */
        }
    });
});
</script>