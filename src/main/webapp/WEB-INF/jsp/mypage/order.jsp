<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<article class="pt-5">
	<div class="font50 font-weight-bold">주문하기</div>
	<table class="table h-100 w-100 font30 mt-5 text-center">
		<thead>
			<tr>
				<th>상품 명</th>
				<th>가격</th>
				<th>수량</th>
				
			</tr>
		</thead>
		<tbody>
			<tr>
				<td class="text-center"></td>
					<td class="text-center"></td>
					<td class="text-center"></td>
			</tr>
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
				<td class="text-center"></td>
					<td class="text-center"></td>
					<td class="text-center"></td>
			</tr>
		</tbody>

	</table>
	
	<div class="font50 font-weight-bold">주소확인</div>
	<div class="d-flex  align-items-center pt-5">
		<div class="font40 ml-5 mr-5" style="width: 170px;">주소</div>
		<input type="text" id="postcode" placeholder="우편번호"
			style="height: 85px; width: 650px;"
			class="font30 ml-5 form-control main-keyword">
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
			class="font30 ml-5 mt-3 form-control main-keyword">
	</div>
	
	<div class="d-flex">
		<div class="font40 ml-5 mr-5 pt-4" style="width: 170px;">전화번호</div>
		<input type="text" id="phoneNumber" name="phoneNumber" 
			style="height: 85px; width: 650px;"
			class="font30 ml-5 mt-3 form-control main-keyword" value="">
	</div>
	
	<div class="line mt-5"></div>
	
	<div class="d-flex justify-content-end align-items-center mr-5 pt-5">
		<button type="button" class="btn main-keyword font40">결제하기</button>
	</div>
</article>