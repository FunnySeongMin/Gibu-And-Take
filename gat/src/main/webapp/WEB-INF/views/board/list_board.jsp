<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- Page Heading -->
<div class="page-heading">
	<h4 class="py-5 text-center sub2-txt">Ŀ�´�Ƽ</h4>
</div>

<!-- /.Page Heading -->

<!-- Page Content -->
<div class="container">
	<div class="col-10 offset-lg-1">
		<div class="d-flex align-items-end">
			<a href="${pageContext.request.contextPath }/board/write_board.do" class="btn btn-sm btn-point-gnt ml-auto mt-4">�۾���</a>
		</div>		
	</div>
	<div class="row">
		<div class="col-10 offset-lg-1 my-4">
			<table class="table table-hover">
				<thead>
					<tr>
						<td>��ȣ</td>
						<td>����</td>
						<td>�ۼ���</td>
						<td>�ۼ�����</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>1</td>
						<td><a href="${pageContext.request.contextPath }/board/detail_board.do">�������Դϴ�</a></td>
						<td>�ۼ����Դϴ�</td>
						<td>�ۼ������Դϴ�</td>
					</tr>
				</tbody>
			</table>
		</div>
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