<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<article class="pt-5">
	<div class="font50 font-weight-bold">장바구니</div>
	<table class="table h-100 w-100 font30 mt-5 text-center">
		<thead>
			<tr>
				<th>상품 명</th>
				<th>가격</th>
				<th>수량</th>
				<th>선택</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td class="text-center"></td>
					<td class="text-center"></td>
					<td class="text-center"><input type="text" style="width: 50px; height: 40px;" class="text-center"></td>
					<td class="text-center"><input type="checkbox" name="check"
						value=""
						style="width: 40px; height: 40px;"></td>
			</tr>
		</tbody>

	</table>
	<div class="d-flex justify-content-end align-items-center">
		<button class="btn font30 mr-3" id="countChange">수량변경</button>
		<button class="btn font30 mr-3" id="prouductDelete">삭제</button>
		<button class="btn font30 mr-5" id="productOrder">주문</button>
	</div>
</article>