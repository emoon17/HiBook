<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
					<td class="text-center">${cartView.product.title}</td>
					<td class="text-center" id="countChangeInput"><input id="count" type="text" name="count" style="width: 50px; height: 40px;" class="text-center" value="${cartView.cart.count}">
							<button type="button" class="btn font30 mr-3"  id="countChange">수량변경</button></td>

					<td class="text-center">${cartView.cart.price}</td>
					<td class="text-center"><input type="checkbox" name="check"
						value="${cartView.product.id}"
						style="width: 40px; height: 40px;" ></td>
			</tr>
		</tbody>
		</c:forEach>

	</table>
	<div class="d-flex justify-content-end align-items-center">
	
		<button type="button" class="btn font30 mr-3" id="prouductDelete">삭제</button>
		<button class="btn font30 mr-5" id="productOrder">주문</button>
	</div>
</article>

<script>
	$(document).ready(function(){
		
		$('#countChange').on('click', function(){
			
			
			let change = $(this).siblings('input[type=text]').val();
			alert(change);
		});
		
		$('#prouductDelete').on('click', function(){
			//alert("dd");
			let productId = $('input[name=check]:checked').val();
			alert(productId);
			
			$.ajax({
				//request
				type : 'delete'
				, url : '/hiBook/cart_delete'
				, data : {
					'productId' : productId
				}
				// response
				, success:function(data){
					if (data.code == 1) {
						alert("상품이 삭제 되었습니다.");
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
</script>