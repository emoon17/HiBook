<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<article class="pt-5">
	<div class="font50 font-weight-bold">주문하기</div>
	<table class="table h-100 w-100 font30 mt-5 text-center">
		<thead>
			<tr>
				<th>No.</th>
				<th>상품 명</th>
				<th>수량</th>
				<th>가격</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach items="${orderproductViewList}" var="orderproductView"
				varStatus="status">
				<tr>
					<td>${status.count}</td>
					<td class="text-center "><span class="title"
						data-orderproduct-id="${orderproductView.orderproduct.id}">
							${orderproductView.product.title}</span></td>
							
							<c:set
							var="orderNumber" value="${orderNumber + orderproductView.product.id}" />
							
					<td class="text-center">${orderproductView.orderproduct.count}
						<c:set var="count"
							value="${count + orderproductView.orderproduct.count}" />
					</td>
					<td class="text-center"><fmt:formatNumber
							value="${orderproductView.orderproduct.price}" pattern="#,###" />
						<c:set var="sum"
							value="${sum + orderproductView.orderproduct.price}" /></td>
				</tr>
			</c:forEach>
		</tbody>

	</table>

	<div class="font50 font-weight-bold">주문합계</div>
	<table class="table h-100 w-100 font30 mt-5 text-center">
		<thead>
			<tr>
				<th>주문 상품 수</th>
				<th>총 상품 가격</th>
				<th>총 결제 금액</th>

			</tr>
		</thead>
		<tbody>
			<tr>
				<td class="text-center" id="count" data-total-count="${count}"><fmt:formatNumber
						value="${count}" pattern="#,###" /></td>
				<td class="text-center"><fmt:formatNumber value="${sum}"
						pattern="#,###" /></td>
				<td class="text-center font-weight-bold" id="price"
					data-total-price="${sum}"><fmt:formatNumber value="${sum}"
						pattern="#,###" />원</td>
			</tr>
		</tbody>

	</table>

	<div class="font50 font-weight-bold">주소확인</div>
	<div class="d-flex  align-items-center pt-5">
		<div class="font40 ml-5 mr-5" style="width: 170px;">주소</div>
		<input type="text" id="postcode" style="height: 85px; width: 650px;"
			class="font30 ml-5 form-control main-keyword" value="${postcode}">
		<button type="button"
			class="check-btn btn pl-3 font-weight-bold font30 main-keyword ml-3"
			id="daumPostcode" style="height: 85px;">주소 검색</button>
	</div>
	<div class="d-flex">
		<div class="font30 ml-5 mr-5 font-weight-bold " style="width: 170px;"></div>
		<input type="text" id="address" name="address" placeholder="주소"
			style="height: 85px; width: 650px;"
			class="font30 ml-5 mt-3 form-control main-keyword" value="${address}">
	</div>

	<div class="d-flex">
		<div class="font30 ml-5 mr-5 font-weight-bold " style="width: 170px;"></div>
		<input type="text" id="detailAddress" name="detailAddress"
			placeholder="상세주소" style="height: 85px; width: 650px;"
			class="font30 ml-5 mt-3 form-control main-keyword"
			value="${detailAddress}">
	</div>

	<div class="d-flex">
		<div class="font40 ml-5 mr-5 pt-4" style="width: 170px;">전화번호</div>
		<input type="text" id="phoneNumber" name="phoneNumber"
			style="height: 85px; width: 650px;"
			class="font30 ml-5 mt-3 form-control main-keyword"
			value="${phoneNumber}">
	</div>

	<div class="line mt-5"></div>

	<div class="d-flex justify-content-end align-items-center mr-5 pt-5">
		<button type="button" id="payBtn" class="btn main-keyword font40" value="${orderNumber}">결제하기</button>
	</div>
</article>


<!--다음 주소  -->
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	$(document).ready(function() {
		$('#payBtn').on('click', function() {
			let orderproductIdArr = new Array();
			$('.title').each(function(i) {
				let orderproductId = $(this).data('orderproduct-id');
				orderproductIdArr.push(orderproductId);

			});
			let count = $('#count').data('total-count');
			let price = $('#price').data('total-price');
			let postcode = $('#postcode').val();
			let address = $('#address').val();
			let detailAddress = $('#detailAddress').val();
			let phoneNumber = $('#phoneNumber').val();
			let orderNumber = $('#payBtn').val();
			//alert(orderproductId);

			//	alert(phoneNumber);

			  $.ajax({
				//reques
				type : 'post',
				url : '/hiBook/order/payment',
				data : {
					'orderproductIdArr' : orderproductIdArr,
					'orderNumber' : orderNumber,
					'count' : count,
					'price' : price,
					'postcode' : postcode,
					'address' : address,
					'detailAddress' : detailAddress,
					'phoneNumber' : phoneNumber
					
				},
				success : function(data) {
					if (data.code == 1) {
						location.href = "/hiBook/order_inquiry_view";
					} else {
						alert(data.errorMessage);
					}

				},
				error : function(e) {
					alert("오류가 발생했습니다.")
				}
			});  
	
		});
		
		$('#daumPostcode').on('click', function() {

			new daum.Postcode({
				oncomplete : function(data) {
					// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

					// 각 주소의 노출 규칙에 따라 주소를 조합한다.
					// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
					var addr = ''; // 주소 변수
					var extraAddr = ''; // 참고항목 변수

					//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
					if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
						addr = data.roadAddress;
					} else { // 사용자가 지번 주소를 선택했을 경우(J)
						addr = data.jibunAddress;
					}

					// 우편번호와 주소 정보를 해당 필드에 넣는다.
					document.getElementById('postcode').value = data.zonecode;
					document.getElementById("address").value = addr;
					// 커서를 상세주소 필드로 이동한다.
					document.getElementById("detailAddress").focus();
				}
			}).open();
		});
	});
</script>