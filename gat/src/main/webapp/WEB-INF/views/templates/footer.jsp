<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
    <hr>
    <!--Footer-->
	<footer class="small-txt my-4 text-center">
		<ul class="list-inline py -3">
			<li class="list-inline-item"><a href="#">서비스 소개</a></li>
			<li class="list-inline-item"><a href="#">이달의 기부자</a></li>
			<li class="list-inline-item"><a href="${pageContext.request.contextPath }/board/contact.do">문의하기</a></li>
			<li class="list-inline-item"><a href="#">이용약관</a></li>
			<li class="list-inline-item"><a href="#">개인정보보호 정책</a></li>
		</ul>
		<!--Copyright-->
		<div class="footer-copyright">
			HI-FIVE㈜ | 대표 서정우 | 105-87-52825 | 경기도 성남시 분당구 삼평동 대왕판교로 670길 유스페이스2 B동 8 층 | 대표전화 031-606-9311~20
		</div>
		<div class="footer-copyright my-1">
			© 2018 Copyright HI-FIVE Inc.
		</div>
		<!--/.Copyright-->
		
	</footer>
	<!--/.Footer-->
	
    <!-- Bootstrap core JavaScript -->
    <script type="text/javascript" src="//code.jquery.com/jquery-1.11.0.min.js"></script>
    <script src="${pageContext.request.contextPath }/resources/jquery/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath }/resources/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script type="text/javascript" src="/gat/resources/editor/js/HuskyEZCreator.js" charset="utf-8"></script>

  </body>
  <script type="text/javascript">
	$(function() {
		//전역변수
		var obj = [];
		//스마트에디터 프레임생성
		nhn.husky.EZCreator.createInIFrame({
			oAppRef : obj,
			elPlaceHolder : "editor",
			sSkinURI : "/gat/resources/editor/SmartEditor2Skin.html",
			htParams : {
				// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
				bUseToolbar : true,
				// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
				bUseVerticalResizer : true,
				// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
				bUseModeChanger : true,
			}
		});
		//전송버튼
		$("#savebutton").click(function() {
			//id가 smarteditor인 textarea에 에디터에서 대입
			obj.getById["editor"].exec("UPDATE_CONTENTS_FIELD", []);
			//폼 submit
			$("#contactForm").submit();
		})
	})
</script>
</html>