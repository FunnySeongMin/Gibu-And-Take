<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- 현재 보유 금액을 업데이트 -->
<!-- <script type="text/javascript">
$("#submitBtn").click(function(){ //충전 버튼을 클릭하면					
		var symbolComp=$(":input[name=symbol]:checked");		
		var tradeTypeComp=$(":input[name=tradeType]:checked");		
		var quantity=$("#quantity").val();		
		if(symbolComp.length==0){
			alert("주식을 선택하세요!");
			return;
		}else if(tradeTypeComp.length==0){
			alert("거래방식을 선택하세요!");
			return;
		}
		var symbol=symbolComp.val();
		var tradeType=tradeTypeComp.val();
		// 주식 매도시 데이터 체크를 jquery에서 미리 한다. 	
	 $.ajax({
			type:"POST",
			url:"addMemberMileage.do",				
			data:$("#addMileageForm").serialize(),			   
			success:function(result){ 					
				if(result.error=="fail"){
					alert(result.message);					
				}else{
					var newInfo="";
						$.each(result,function(index,sh){
							 newInfo+="<tr><td>"+sh.symbol+"</td>";
							 newInfo+="<td>"+sh.quantity+"</td>";
							 newInfo+="<td>"+sh.totalPrice+"</td></tr>";
					});
					$("#sharesView").html(newInfo);
				}
				$("#reset").click();
			}// success
		  });//ajax 			 	 			
		 });//click			
});//ready
</script>  -->


<br><br>
<h2>환전하기^0^</h2>
<form name="addMileageForm" method="post" action="addMileage.do">
<input type="hidden" name="mugNo" value="1">
<input type="hidden" name="mvo" value="${sessionScope.mvo}">
<input type="number" name="mtVolume" placeholder="가격" required="required">원 
<!-- <button type="submit" id="submitBtn">충전</button> <br><br><br><br> -->
<button type="submit" id="submitBtn">충전</button> <br><br><br><br> 
보유 마일리지: ${sessionScope.mvo.mileage}원
<!-- 현재 마일리지 : <span id="myMileageView"></span>원 -->
</form>
<br><br>