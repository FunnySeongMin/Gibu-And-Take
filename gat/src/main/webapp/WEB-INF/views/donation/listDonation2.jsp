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
							<a href="${pageContext.request.contextPath }/donation/detailDonation.do">Project Two</a>
						</h4>
						<p class="card-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam viverra euismod odio, gravida pellentesque urna varius vitae.</p>
					</div>
				</div>
			</div>
			<div class="col-lg-4 col-sm-4 portfolio-item">
				<div class="card h-100">
					<a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
					<div class="card-body">
						<h4 class="card-title">
							<a href="${pageContext.request.contextPath }/donation/detailDonation.do">Project Three</a>
						</h4>
						<p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quos quisquam, error quod sed cumque, odio distinctio velit nostrum temporibus necessitatibus et facere atque iure perspiciatis mollitia recusandae vero vel quam!</p>
					</div>
				</div>
			</div>
			<div class="col-lg-4 col-sm-4 portfolio-item">
				<div class="card h-100">
					<a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
					<div class="card-body">
						<h4 class="card-title">
							<a href="${pageContext.request.contextPath }/donation/detailDonation.do">Project Four</a>
						</h4>
						<p class="card-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam viverra euismod odio, gravida pellentesque urna varius vitae.</p>
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
        <h3><a href="${pageContext.request.contextPath }/donation/detailDonation.do">Project One</a></h3>
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Laudantium veniam exercitationem expedita laborum at voluptate. Labore, voluptates totam at aut nemo deserunt rem magni pariatur quos perspiciatis atque eveniet unde.</p>
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
        <h3><a href="${pageContext.request.contextPath }/donation/detailDonation.do">Project Two</a></h3>
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ut, odit velit cumque vero doloremque repellendus distinctio maiores rem expedita a nam vitae modi quidem similique ducimus! Velit, esse totam tempore.</p>
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
        <h3><a href="${pageContext.request.contextPath }/donation/detailDonation.do">Project Three</a></h3>
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Omnis, temporibus, dolores, at, praesentium ut unde repudiandae voluptatum sit ab debitis suscipit fugiat natus velit excepturi amet commodi deleniti alias possimus!</p>
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
        <h3><a href="${pageContext.request.contextPath }/donation/detailDonation.do">Project Four</a></h3>
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo, quidem, consectetur, officia rem officiis illum aliquam perspiciatis aspernatur quod modi hic nemo qui soluta aut eius fugit quam in suscipit?</p>
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
    <ul class="pagination justify-content-center mt-5">
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
    </ul>
</div>
<!-- /.container -->



        

        <p id="loading">
            <img src="images/loading.gif" alt="Loading…" />
        </p>







	<script type="text/javascript" src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
    var win = $(window);
    var i=0;
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
                    	$('#posts').append("<div class=row>");
                    	$('#posts').append("<div class=col-md-7>");
                    	$('#posts').append("<a href=${pageContext.request.contextPath }/donation/detailDonation.do>");
                    	$('#posts').append("<img class=img-fluid rounded mb-3 mb-md-0 src=http://placehold.it/700x300 alt=>");
                    	$('#posts').append("</a>");
                    	$('#posts').append("</div>");
                    	$('#posts').append("<div class=col-md-5>");
                    	$('#posts').append("<h3><a href=${pageContext.request.contextPath }/donation/detailDonation.do>"+result[i].DP_TITLE+"</a></h3>");
                    	$('#posts').append("<p>"+result[i].DP_SUMMERY+"</p>");
                    	$('#posts').append("<a class=btn btn-primary href=#>View Project");
                    	$('#posts').append("<span class=glyphicon glyphicon-chevron-right></span>");
                    	$('#posts').append("</a>");
                    	$('#posts').append("</div>");
                    	$('#posts').append("</div>");
                    	$('#posts').append("<hr>");
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