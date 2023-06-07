<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<article class="pt-5">
	<div class="font50 font-weight-bold">장바구니</div>
	<table class="table h-100 w-100 font30 mt-5 text-center">
		<thead>
			<tr>
				<th>상품 명</th>
				<th>수량</th>
				<th>가격</th>
				<th>선택</th>
			</tr>
		</thead>
		<c:forEach items="${cartViewList}" var="cartView">
			<tbody>
				<tr>
					<td class="text-center"><a
						href="/hiBook/hi_detail_view?isbn13=${cartView.product.isbn13}"
						class="cart-title">${cartView.product.title}</a></td>
					<td class="text-center" id="countChangeInput"><input
						type="text" name="count" style="width: 50px; height: 40px;"
						class="count text-center" value="${cartView.cart.count}">
						<button type="button" class="countChange btn font30 mr-3"
							data-product-id="${cartView.product.id}"
							data-product-price="${cartView.product.price}">수량변경</button></td>

					<td class="text-center"><fmt:formatNumber
							value="${cartView.cart.price}" pattern="#,###" /> <c:set
							var="sum" value="${sum + cartView.cart.price}" /></td>



					<td class="text-center"><input type="checkbox" name="check"
						value="${cartView.product.id}" style="width: 40px; height: 40px;"></td>
				</tr>
			</tbody>
		</c:forEach>

	</table>
	<div
		class="d-flex justify-content-end align-items-center font-weight-bold">
		<div class="font30 total-table-text">총 합계 :</div>

		<div class="font30 total-table-sum">
			<fmt:formatNumber value="${sum}" pattern="#,###" />
			원
		</div>
	</div>
	<div class="d-flex justify-content-end align-items-center">
		<button type="button" class="btn font30 mr-3" id="prouductDelete">삭제</button>
		<button type="button" class="btn font30 mr-5" id="productOrder">주문</button>
	</div>
</article>

<script>
	$(document).ready(function() {

		$('.countChange').on('click', function() {
			let changeCount = $(this).siblings('input[type=text]').val();
			//let countValue = changeCount;
			//alert();
			if (changeCount > 10) {
				alert("10개까지만 주문 가능합니다. ")
				$('#count').val(1);
			}

			let productId = $(this).data('product-id');

			let price = $(this).data('product-price');

			let count = parseInt(changeCount);
			//alert(productId);

			$.ajax({
				//request
				type : 'put',
				url : '/hiBook/cart_update',
				data : {
					'productId' : productId,
					'count' : count,
					'price' : price
				},
				success : function(data) {
					if (data.code == 1) {
						document.location.reload();
					} else {
						alert(data.errorMessage);
					}
				},
				error : function(e) {
					alert("오류가 발생했습니다.");
				}
			});
		});

		$('#prouductDelete').on('click', function() {
			//alert("dd");
			$('input[name=check]:checked').each(function() {
				let productId = $(this).val();
				//alert(productId);

				$.ajax({
					//request
					type : 'delete',
					url : '/hiBook/cart_delete',
					data : {
						'productId' : productId
					}
					// response
					,
					success : function(data) {
						if (data.code == 1) {
							document.location.reload();
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

		$('#productOrder').on('click', function() {

				let productIdArr = new Array();
			$('input[name=check]:checked').each(function(i) {
				let productId = $(this).val();
				productIdArr.push(productId);
				//alert(productIdArr);

			});
				console.log(productIdArr);
			
			$.ajax({
				//request
				type : "post",
				url : "/hiBook/order/order_create",
				data : {
					"productIdArr" : productIdArr
				},
				success : function(data) {
					if (data.code == 1) {
						location.href = "/hiBook/order_view";
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