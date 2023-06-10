<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<article class="pt-5 ">
	<div class="font50 font-weight-bold pl-5 ">주문 상세 내역</div>
</article>

<div id="orderBox">
	<table class="table h-100 w-100 font30 mt-5 text-center">
		<thead>
			<tr>
				<th>주문 번호</th>
				<th>상품 명</th>
				<th>수량</th>
				<th>가격</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${orderViewList}" var="orderView">
				<tr>
					<th>${orderView.order.orderNumber}</th>
					<th>${orderView.product.title}</th>
					<th>${orderView.orderproduct.count}</th>
					<th><fmt:formatNumber value="${orderView.orderproduct.price}"
							pattern="#,###" /> <c:set var="sum"
							value="${sum + orderView.orderproduct.price}" /></th>
				</tr>
			</c:forEach>
		</tbody>

	</table>

	<div
		class="d-flex justify-content-end align-items-center font-weight-bold">
		<div class="font30 total-table-text">총 합계 :</div>

		<div class="font30 total-table-sum">
			<fmt:formatNumber value="${sum}" pattern="#,###" />
			원
		</div>
	</div>
</div>