<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div id="orderBox">
	<table class="table h-100 w-100 font30 mt-5 text-center">
		<thead>
			<tr>
				<th>반품 일</th>
				<th>주문 번호</th>
				<th>총 가격</th>
				<th>접수 상황</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${orderViewList}" var="orderView">
			<tr>
				<th><a href="/hiBook/order_detail_view?orderNumber=">${orderView.order.updatedAt}</a></th>
				<th><a
					href="/hiBook/order_detail_view?orderNumber=">${orderView.order.orderNumber}</a></th>
				<th>${orderView.orderproduct.price}</th>
				<th></th>
			</tr>
		</tbody>
		</c:forEach>
	</table>
</div>