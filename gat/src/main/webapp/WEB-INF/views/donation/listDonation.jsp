<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="jumbotron mb-0">
	<div class="container">
		<div class="row">
			 <div class="col-lg-4 col-sm-4 portfolio-item">
				<div class="card h-100">
					<a href="${pageContext.request.contextPath }/donation/readDonationDetail.do?dpno=${rank[0].DP_NO }"><img class="card-img-top" src="${rank[0].DP_IMGDIRECTORY }" alt=""></a>

					<div class="card-body">
						<h4 class="card-title">
							<a href="${pageContext.request.contextPath }/donation/readDonationDetail.do?dpno=${rank[0].DP_NO }">${rank[0].DP_TITLE }</a>
						</h4>
						<p class="card-text">${rank[0].DP_SUMMERY }</p>
					</div>
				</div>
			</div>
			<div class="col-lg-4 col-sm-4 portfolio-item">
				<div class="card h-100">
					<a href="${pageContext.request.contextPath }/donation/readDonationDetail.do?dpno=${rank[1].DP_NO }"><img class="card-img-top" src="${rank[1].DP_IMGDIRECTORY }" alt=""></a>

					<div class="card-body">
						<h4 class="card-title">
							<a href="${pageContext.request.contextPath }/donation/readDonationDetail.do?dpno=${rank[1].DP_NO }">${rank[1].DP_TITLE }</a>
						</h4>
						<p class="card-text">${rank[1].DP_SUMMERY }</p>
					</div>
				</div>
			</div>
			<div class="col-lg-4 col-sm-4 portfolio-item">
				<div class="card h-100">
					<a href="${pageContext.request.contextPath }/donation/readDonationDetail.do?dpno=${rank[2].DP_NO }"><img class="card-img-top" src="${rank[2].DP_IMGDIRECTORY }" alt=""></a>
					<div class="card-body">
						<h4 class="card-title">
							<a href="${pageContext.request.contextPath }/donation/readDonationDetail.do?dpno=${rank[2].DP_NO }">${rank[2].DP_TITLE }</a>
						</h4>
						<p class="card-text">${rank[2].DP_SUMMERY }</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- 재능기부 신청하기 -->
<div class="bg-sub-1-gnt py-3">
	<div class="container">
		<div class="row">
			<div class="col-12">
				<span class="text-white border-right mr-1 pr-2">당신의 재능을 많은 사람들과 나누어 보세요</span>
				<a href="${pageContext.request.contextPath }/donation/applyDonation.do" class="text-white">재능기부 신청하기<i class="far fa-edit"></i></a>
			</div>
		</div>
	</div>
</div> 
<!-- Page Content -->
<div class="container mt-5 mb-5">
    <!-- Project One -->
    <div class="row">
      <div class="col-md-7">
        <a href="${pageContext.request.contextPath }/donation/readDonationDetail.do?dpno=${list[0].DP_NO }">
          <img class="img-fluid rounded mb-3 mb-md-0" src="${list[0].DP_IMGDIRECTORY }" alt="">
        </a>
      </div>
      <div class="col-md-5">
        <h3><a href="${pageContext.request.contextPath }/donation/readDonationDetail.do?dpno=${list[0].DP_NO }">${list[0].DP_TITLE }</a></h3>
        <p>${list[0].DP_SUMMERY }</p>
        <a class="btn btn-primary" href="${pageContext.request.contextPath }/donation/readDonationDetail.do?dpno=${list[0].DP_NO }">View Project

          <span class="glyphicon glyphicon-chevron-right"></span>
        </a>
      </div>
    </div>
    <!-- /.row -->

    <hr>

    <!-- Project Two -->
    <div class="row">
      <div class="col-md-7">
        <a href="${pageContext.request.contextPath }/donation/readDonationDetail.do?dpno=${list[1].DP_NO }">
          <img class="img-fluid rounded mb-3 mb-md-0" src="${list[1].DP_IMGDIRECTORY }" alt="">
        </a>
      </div>
      <div class="col-md-5">
        <h3><a href="${pageContext.request.contextPath }/donation/readDonationDetail.do?dpno=${list[1].DP_NO }">${list[1].DP_TITLE }</a></h3>
        <p>${list[1].DP_SUMMERY }</p>
        <a class="btn btn-primary" href="${pageContext.request.contextPath }/donation/readDonationDetail.do?dpno=${list[1].DP_NO }">View Project
          <span class="glyphicon glyphicon-chevron-right"></span>
        </a>
      </div>
    </div>
    <!-- /.row -->

    <hr>

    <!-- Project Three -->
    <div class="row">
      <div class="col-md-7">
        <a href="${pageContext.request.contextPath }/donation/readDonationDetail.do?dpno=${list[2].DP_NO }">
          <img class="img-fluid rounded mb-3 mb-md-0" src="${list[2].DP_IMGDIRECTORY }" alt="">
        </a>
      </div>
      <div class="col-md-5">
        <h3><a href="${pageContext.request.contextPath }/donation/readDonationDetail.do?dpno=${list[2].DP_NO }">${list[2].DP_TITLE }</a></h3>
        <p>${list[2].DP_SUMMERY }</p>
        <a class="btn btn-primary" href="${pageContext.request.contextPath }/donation/readDonationDetail.do?dpno=${list[2].DP_NO }">View Project
          <span class="glyphicon glyphicon-chevron-right"></span>
        </a>
      </div>
    </div>
    <!-- /.row -->

    <hr>

    <!-- Project Four -->
    <div class="row">

      <div class="col-md-7">
        <a href="${pageContext.request.contextPath }/donation/readDonationDetail.do?dpno=${list[3].DP_NO }">
          <img class="img-fluid rounded mb-3 mb-md-0" src="${list[3].DP_IMGDIRECTORY }" alt="">
        </a>
      </div>
      <div class="col-md-5">
        <h3><a href="${pageContext.request.contextPath }/donation/readDonationDetail.do?dpno=${list[3].DP_NO }">${list[3].DP_TITLE }</a></h3>
        <p>${list[3].DP_SUMMERY }</p>
        <a class="btn btn-primary" href="${pageContext.request.contextPath }/donation/readDonationDetail.do?dpno=${list[3].DP_NO }">View Project
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
    </ul> -->
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
                    	$('#posts').append("<hr><div class='row'><div class='col-md-7'><a href=${pageContext.request.contextPath }/donation/readDonationDetail.do?dpno="+result[i].DP_NO+"><img class='img-fluid rounded mb-3 mb-md-0' src="+result[i].DP_IMGDIRECTORY+" alt=></a></div><div class='col-md-5'><h3><a href=${pageContext.request.contextPath }/donation/readDonationDetail.do?dpno="+result[i].DP_NO+">"+result[i].DP_TITLE+"</a></h3><p>"+result[i].DP_SUMMERY+"</p><a class='btn btn-primary' href=${pageContext.request.contextPath }/donation/readDonationDetail.do?dpno="+result[i].DP_NO+">View Project<span class='glyphicon glyphicon-chevron-right'></span></a></div></div>");
                    	
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