<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



<div id="orderBox">
	<table class="table h-100 w-100 font30 mt-5 text-center">
		<thead>
			<tr>
				<th>주문 일</th>
				<th>주문 번호</th>
				<th>총 가격</th>
				<th>접수 상황</th>
				<th>반품 선택</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${orderViewList}" var="orderView">
				<tr>
					<th><a
						href="/hiBook/order_detail_view?orderNumber=${orderView.order.orderNumber}"><fmt:formatDate
								value="${orderView.order.createdAt}" pattern="yyyy-MM-dd mm:ss" /></a></th>
					<th><a
						href="/hiBook/order_detail_view?orderNumber=${orderView.order.orderNumber}">${orderView.order.orderNumber}</a></th>
					<th><fmt:formatNumber value="${orderView.order.price}"
							pattern="#,###" /></th>
					<th>${orderView.order.state}</th>
					<th><input type="checkbox" name="check"
						value="${orderView.order.orderNumber}"
						style="width: 40px; height: 40px;"></th>
				</tr>
			</c:forEach>
		</tbody>

	</table>
	<div class="return d-flex justify-content-end align-items-center pt-5">
		<button type="button" id="returnBtn" class="btn font30">반품 신청</button>
	</div>
</div>

<script>
	$(document).ready(function(){
		$('#returnBtn').on('click', function() {
			//alert("dd");

			let orderNumberArr = new Array();
			$('input[name=check]:checked').each(function(i) {
				let orderNumber = $(this).val();
				orderNumberArr.push(orderNumber);

			});
			//alert(orderNumberArr);
			//console.log(productIdArr);
			$.ajax({
				//request
				type : "put",
				url : "/hiBook/order/order_update",
				data : {
					"orderNumberArr" : orderNumberArr
				},
				success : function(data) {
					if (data.code == 1) {
						alert("반품 신청이 완료 되었습니다.")
						location.href = "/hiBook/order_return_view";
					} else {
						alert(data.errorMessage);
					}

				},
				error : function(e) {
					alert("오류가 발생했습니다.")
				}
			});
		});
	});
</script>
