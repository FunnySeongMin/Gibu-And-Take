<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- Page Content -->
<div class="container my-3">

	<!-- Portfolio Item Row -->
	<div class="row">
	
		<div class="col-md-6">
		  <img class="img-fluid mt-3" src="http://placehold.it/750x500" alt="">
		</div>
	
		<div class="col-md-6">
			<h4 class="my-3">��ɱ�� ����</h3>
			<h3 class="mt-3 sub-1-txt-gnt">63%</h3>
			<div class="progress mb-3">
				<div class="progress-bar bg-sub-3-gnt" role="progressbar" style="width: 63%" aria-valuenow="63" aria-valuemin="0" aria-valuemax="100"></div>
			</div>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam viverra euismod odio, gravida pellentesque urna varius vitae. Sed dui lorem, adipiscing in adipiscing et, interdum nec metus. Mauris ultricies, justo eu convallis placerat, felis enim.</p>
			<button class="btn btn-point-gnt btn-block" type="submit" data-toggle="modal" data-target="#entry_form">�����ϱ�</button>			
		</div>
		
		<!-- ���� ��û Modal -->
		<div class="modal fade" id="entry_form" role="dialog">
			<div class="modal-dialog modal-dialog-centered">
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title text-center">��ɱ�� ���� ��û</h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
					
					<form method="" action="">
						<div class="modal-body bg-light">
							<div class="">
								��û�� ��ɱ�� ����
							</div>
							<div class="row">
								<label for="">����� ���ϸ���</label>
								<div class="col-lg-3"><input type="text" class="form-control form-control-sm" name="td_mileage"></div>
								<small>���� ���ϸ��� : 10,000</small>
							</div>
							<div class="form-group my-3">
								<label class="">���� ���� �޼���</label><input type="text" class="form-control" name="cheerup-message">
							</div>
							<div class="form-control form-check small-txt">
								<input type="checkbox" class="form-check-input" id="entry_agree">
								<label class="form-check-label" for="entry_agree">��� ���뿡 �����մϴ�
								
							</div>							
						</div>
						<div class="modal-footer">
							<button type="submit" class="btn btn-point-gnt">��û�ϱ�</button>
							<button type="button" class="btn ">���</button>
						</div>					
					</form>
				</div>
	
			</div>
		</div>
	</div>
	<!-- /.row -->
	</div>
	<!-- /.container -->
		
	<nav id="navbar-dp-info" class="mt-5 border-top border-bottom">
		<div class="container border-left">
			<ul class="nav nav-pills">	
				<li class="nav-item">
					<a class="nav-link" href="#dp_summary">��ɱ�� �������</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="#dp_info">��ɱ�� �Ұ�</a>
				</li>	
				<li class="nav-item">
					<a class="nav-link" href="#dp_member">��ɱ���� �Ұ�</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="#dp_community">Ŀ�´�Ƽ</a>
				</li>
			</ul>
		</div>
	</nav>
	
	<div class="container border border-top-0 pb-5 mb-5">	  
		<div class="row pt-3">
			<div class ="col-sm-12 px-4" data-spy="scroll" data-target="#navbar-dp-info" data-offset="50">
			
				<!-- ��ɱ�� ������� -->
			<div id="dp_summary">
				<h3 class="mt-4 mb-3">��ɱ�� �������
					<small>summary</small>
				</h3>
				<div class="jumbotron">
					��ɱ�� �������<br>��ɱ�� �������<br>��ɱ�� �������<br>
					��ɱ�� �������<br>��ɱ�� �������<br>��ɱ�� �������<br>
					��ɱ�� �������<br>��ɱ�� �������<br>��ɱ�� �������<br>
					��ɱ�� �������<br>��ɱ�� �������<br>��ɱ�� �������<br>
					��ɱ�� �������<br>��ɱ�� �������<br>��ɱ�� �������<br>
				</div>
			</div>
			
			<!-- ��ɱ�� �Ұ�(����Ʈ������) -->
			<div id="dp_info">
				<h3 class="mt-4 mb-3">��ɱ�� �Ұ�
					<small>introduce</small>
				</h3>
				<div class="jumbotron">
					��ɱ�� �Ұ�<br>��ɱ�� �Ұ�<br>��ɱ�� �Ұ�<br>
					��ɱ�� �Ұ�<br>��ɱ�� �Ұ�<br>��ɱ�� �Ұ�<br>
					��ɱ�� �Ұ�<br>��ɱ�� �Ұ�<br>��ɱ�� �Ұ�<br>
					��ɱ�� �Ұ�<br>��ɱ�� �Ұ�<br>��ɱ�� �Ұ�<br>
					��ɱ�� �Ұ�<br>��ɱ�� �Ұ�<br>��ɱ�� �Ұ�<br>
				</div>
			</div>
			<!-- ��ɱ���� �Ұ� -->
			<div id="dp_member">
				<h4 class="mt-4 mb-3">��ɱ���� �Ұ�
					<small>info</small>
				</h5>
				<div class="jumbotron">
					��ɱ���� �Ұ�<br>��ɱ���� �Ұ�<br>��ɱ���� �Ұ�<br>
					��ɱ���� �Ұ�<br>��ɱ���� �Ұ�<br>��ɱ���� �Ұ�<br>
					��ɱ���� �Ұ�<br>��ɱ���� �Ұ�<br>��ɱ���� �Ұ�<br>
					��ɱ���� �Ұ�<br>��ɱ���� �Ұ�<br>��ɱ���� �Ұ�<br>
					��ɱ���� �Ұ�<br>��ɱ���� �Ұ�<br>��ɱ���� �Ұ�<br>
				</div>
			</div>
		</div>
	</div>
	
	<div class="row my-3">
		<div class="col-sm-12" data-spy="scroll" data-target="#navbar-dp-info" data-offset="50">
			<ul class="nav nav-tabs nav-fill" id="myTab" role="tablist">
				<li class="nav-item">
					<a class="nav-link active" id="home-tab" data-toggle="tab" href="#entry-review" role="tab" aria-controls="home" aria-selected="true">���� �ı�</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" id="profile-tab" data-toggle="tab" href="#cheerup-message" role="tab" aria-controls="profile" aria-selected="false">���� �޽���</a>
				</li>
			</ul>
			<div class="tab-content" id="myTabContent">
				<div class="tab-pane fade show mx-3 my-3 active" id="entry-review" role="tabpanel" aria-labelledby="home-tab">�����ı�</div>
				<div class="tab-pane mx-3 my-3 fade" id="cheerup-message" role="tabpanel" aria-labelledby="profile-tab">���� �޽���</div>
			</div>
		</div>
	</div>
 </div>
 <!-- /.container -->