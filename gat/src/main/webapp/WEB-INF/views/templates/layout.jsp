<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- tiles framework 선언부 -->
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<!-- Bootstrap core CSS -->
<link
	href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Custom styles for this template -->
<link
	href="${pageContext.request.contextPath}/resources/css/gat-style.css"
	rel="stylesheet">
<link href="css/bootstrap-responsive.min.css" rel="stylesheet"
	media="screen">
<!-- font awesome -->
<script src="https://use.fontawesome.com/132891cbd9.js"></script>
<!-- <link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.12/css/all.css"
	integrity="sha384-G0fIWCsCzJIMAVNQPfjH08cyYaUtMwjJwqiRKxxE/rx96Uroj1BtIQ6MLJuheaO9"
	crossorigin="anonymous"> -->
</head>
<body>
	<tiles:insertAttribute name="header" />
	<tiles:insertAttribute name="main" />
	<tiles:insertAttribute name="footer" />

	<!-- Bootstrap core JavaScript -->
	<script type="text/javascript"
		src="//code.jquery.com/jquery-1.11.0.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/jquery/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script type="text/javascript"
		src="/gat/resources/editor/js/HuskyEZCreator.js" charset="utf-8"></script>
	<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
	<script type="text/javascript"
		src="https://openapi.map.naver.com/openapi/v3/maps.js?clientId=anRlGsCNfoEuOHfb1mmv&submodules=geocoder"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/donation.js"></script>
	<script type="text/javascript">
	    function execPostCode() {
	         new daum.Postcode({
	             oncomplete: function(data) {
	                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
	 
	                // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
	                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
	                var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
	                var extraRoadAddr = ''; // 도로명 조합형 주소 변수
	 
	                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
	                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
	                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
	                    extraRoadAddr += data.bname;
	                }
	                // 건물명이 있고, 공동주택일 경우 추가한다.
	                if(data.buildingName !== '' && data.apartment === 'Y'){
	                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	                }
	                // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
	                if(extraRoadAddr !== ''){
	                    extraRoadAddr = ' (' + extraRoadAddr + ')';
	                }
	                // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
	                if(fullRoadAddr !== ''){
	                    fullRoadAddr += extraRoadAddr;
	                }
	 
	                // 우편번호와 주소 정보를 해당 필드에 넣는다.
	                console.log(data.zonecode);
	                console.log(fullRoadAddr);
	                
	                
	                $("[name=addr1]").val(data.zonecode);
	                $("[name=place]").val(fullRoadAddr);
	                
	                /* document.getElementById('signUpUserPostNo').value = data.zonecode; //5자리 새우편번호 사용
	                document.getElementById('signUpUserCompanyAddress').value = fullRoadAddr;
	                document.getElementById('signUpUserCompanyAddressDetail').value = data.jibunAddress; */
	            }
	         }).open();
	     }

	    
	    	//<!-- 스마트 에디터-->
			$(function() {
				//전역변수
				var obj = [];
				//스마트에디터 프레임생성
				nhn.husky.EZCreator.createInIFrame({
					oAppRef : obj,
					elPlaceHolder : "appContents",
					sSkinURI : "/gat/resources/editor/SmartEditor2Skin.html",
					htParams : {
						// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
						bUseToolbar : true,
						// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
						bUseVerticalResizer : false,
						// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
						bUseModeChanger : false,
					}
				});
				//전송버튼
				$("#savebutton").click(function() {
					//id가 smarteditor인 textarea에 에디터에서 대입
					obj.getById["appContents"].exec("UPDATE_CONTENTS_FIELD", []);
					//폼 submit
					$("#contactForm").submit();
				})
			});
			
			
			function submitContents() {
		        var elClickedObj = $("#appContents");
		        oEditors.getById["appContents"].exec("UPDATE_CONTENTS_FIELD", []);
		        var appContents = $("#appContents").val();

		        if( appContents == ""  || appContents == null || appContents == '&nbsp;' || appContents == '<p>&nbsp;</p>')  {
		             alert("내용을 입력하세요.");
		             oEditors.getById["appContents"].exec("FOCUS"); //포커싱
		             return;
		        }

		        try {
		            elClickedObj.submit();
		        } catch(e) {}
		    }
			
			
			<!-- 로그인 아이디 비밀번호 확인 : 아이디 중복체크, 아이디 길이확인, 비밀번호 일치여부 -->
			$(document).ready(function(){
				var checkResultId="";
				$("#id").keyup(function(){
					var id=$(this).val().trim();
					if(id.length<3 || id.length>10){
						$("#checkIdView").html("아이디는 3자이상 10자 이하여야 합니다.").css("color","#edbf71");
						checkResultId="";
						return;
					}
					else 
						$("#checkIdView").html("");
					$.ajax({
						type:"get",
						url:"checkId.do",				
						data:"id="+id,	
						success:function(data){	
							if(data=="fail"){
								$("#checkIdView").html(id+"은 이미 존재하는 아이디입니다.").css("color","#f35b56");
								checkResultId="";
							}else{					
								$("#checkIdView").html(id+"는 사용 가능한 아이디입니다.").css("color","#1e878d");		
								checkResultId=id;
							}					
						}//success		
					});//ajax
				});//keyup	
				$("#password").keyup(function(){
					var passwordCon = $("#passwordCon").val();
					var password = $("#password").val();
					var checkResultPassword="";
					if(passwordCon!="" && password != passwordCon) {//비밀번호와 비밀번호 확인이 일치하지 않는 경우
						$("#checkPasswordView").html("패스워드와 일치하지 않습니다").css("color","#f35b56");
						checkResultPassword="";
					}else if (passwordCon=="") {
						$("#checkPasswordView").html("");
						checkResultPassword="";
					}else {//비밀번호와 비밀번호 확인이 일치하여 진행 가능한 경우
						$("#checkPasswordView").html("패스워드와 일치합니다").css("color","#1e878d");
						checkResultPassword=password;
					}
				});//keyup
				$("#passwordCon").keyup(function(){
					var passwordCon = $("#passwordCon").val();
					var password = $("#password").val();
					if(passwordCon!="" && password != passwordCon) {//비밀번호와 비밀번호 확인이 일치하지 않는 경우
						$("#checkPasswordView").html("패스워드와 일치하지 않습니다").css("color","#f35b56");
						checkResultPassword="";
					}else if (passwordCon=="") {
						$("#checkPasswordView").html("");
						checkResultPassword="";
					}else {//비밀번호와 비밀번호 확인이 일치하여 진행 가능한 경우
						$("#checkPasswordView").html("패스워드와 일치합니다").css("color","#1e878d");
						checkResultPassword=password;
					}
				});//keyup
				$("#registerForm").submit(function(){
					if(checkResultId==""){
						alert("아이디를 확인하세요!");
						return false;
					}
					else if (checkResultPassword=="") {
						alert("비밀번호를 확인하세요!");
						return false;
					}
				});//submit
			});//ready
		</script>


	<script type="text/javascript">
	//지도 타입 설정하는 곳 ( 아무것도 설정 하지 않으면 자동으로 Normal로 적용된다 ) 초기화할 때 설정할수 있다. 
	var map = new naver.maps.Map('map');
	// 위성지도를 사용하려면 MapTypeId 객체의 SATELLITE 상수 값을 사용합니다. 
	//var map = new naver.maps.Map('map', {mapTypeId: naver.maps.MapTypeId.SATELLITE}); 
	// 위성지도에 지명을 적용하려면 MapTypeId 객체의 HYBRID 상수 값을 사용합니다. 
	//var map = new naver.maps.Map('map', {mapTypeId: naver.maps.MapTypeId.HYBRID}); 
	// 기본지도에 높낮이만 적용하려면 MapTypeId 객체의 TERRAIN 상수 값을 사용합니다. 
	//var map = new naver.maps.Map('map', {mapTypeId: naver.maps.MapTypeId.TERRAIN});
	
	//재능기부장소 주소정보
	var myaddress = '${dpVO.place}';// 도로명 주소나 지번 주소만 가능 (건물명 불가!!!!) 
	// 주소가 있는지 체크
	naver.maps.Service
			.geocode(
					{
						address : myaddress
					},
					function(status, response) {
						if (status !== naver.maps.Service.Status.OK) {
							return alert(myaddress + '의 검색 결과가 없거나 기타 네트워크 에러');
						}
						var result = response.result;
						// 검색 결과 갯수: result.total 
						// 첫번째 결과 결과 주소: result.items[0].address 
						// 첫번째 검색 결과 좌표: result.items[0].point.y, result.items[0].point.x 
						var myaddr = new naver.maps.Point(
								result.items[0].point.x,
								result.items[0].point.y);
						map.setCenter(myaddr); // 검색된 좌표로 지도 이동 
						// 마커 표시 ( 검색한 주소에 마커를 찍어둠 )
						var marker = new naver.maps.Marker({
							position : myaddr,
							map : map
						});
						// 마커 클릭 이벤트 처리 ( 클릭할 경우 infowindow에 등록된 이미지와 이름이 뜸 )
						naver.maps.Event.addListener(marker, "click", function(
								e) {
							if (infowindow.getMap()) {
								infowindow.close();
							} else {
								infowindow.open(map, marker);
							}
						});
						// 마크 클릭시 인포윈도우 오픈 
						var infowindow = new naver.maps.InfoWindow(
								{
									//띄워줄 이름과 사이트 이미지, 클릭했을경우 이동할 url 주소를 입력해주면 된다.
									content : '<h4> [제목을 넣어주세요]</h4><a href="https://developers.naver.com" target="_blank"><img src="https://developers.naver.com/inc/devcenter/images/nd_img.png"></a>'
								});
					});
	</script>
	
	


</body>

</body>
</html>