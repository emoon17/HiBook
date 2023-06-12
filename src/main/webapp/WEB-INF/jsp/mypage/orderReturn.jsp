<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<article class="pt-5 ">
	<div class="font50 font-weight-bold pl-5 ">반품 조회</div>
	<div class="d-flex mt-5  align-items-center">
		<span class="font30 pl-5 font-weight-bold ml-3 mr-5">시작일</span> <input
			type="text" id="startDatepicker"
			class="form-control main-keyword font30"
			style="width: 400px; height: 85px;"> <span
			class="ml-5 mr-5 font30 font-weight-bold">종료일</span> <input
			type="text" id="endDatepicker"
			class="form-control ml-3 main-keyword font30 mr-5"
			style="width: 400px; height: 85px;">
		<button type="button" value="저장"
			class="date-btn btn font-weight-bold main-keyword font30"
			style="width: 100px; height: 85px;">조회</button>
	</div>

</article>

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
				<th><a href="/hiBook/order_detail_view?orderNumber=${orderView.order.orderNumber}"><fmt:formatDate
								value="${orderView.order.updatedAt}" pattern="yyyy-MM-dd" /></a></th>
				<th><a
					href="/hiBook/order_detail_view?orderNumber=${orderView.order.orderNumber}">${orderView.order.orderNumber}</a></th>
				<th><fmt:formatNumber value="${orderView.order.price}"
							pattern="#,###" /></th>
				<th>${orderView.order.state}</th>
			</tr>
			</c:forEach>
		</tbody>

	</table>
</div>

<script>
	$(document).ready(function(){
		
		$.datepicker.setDefaults({ //데이트피커 전체에 세팅
			changeMonth : true // 월을 선택(셀렉트)
			,
			changeYear : true // 년을 선택(셀렉트)
			,
			monthNamesShort : [ '1월', '2월', '3월', '4월', '5월', '6월',
					'7월', '8월', '9월', '10월', '11월', '12월' ] // 월 한글로 표기
			,
			dayNamesMin : [ '일', '월', '화', '수', '목', '금', '토' ] // 일 한글로 표기
			,
			minDate : "-5y" // 최소로 가능한 선택 일자 : 5년 전
			,
			maxDate : "+5y" // 최대로 가능한 선택 날짜 : 5년 후
			,
			dateFormat : 'yy-mm-dd',
			closeText : "닫기",
			currentText : "오늘",
			prevText : '이전 달',
			nextText : '다음 달'
		});

		// 오늘 날짜로 이동하는 함수
		$.datepicker._gotoToday = function(id) {
			$(id).datepicker('setDate', new Date()).datepicker('hide')
					.blur();
		};

		$('#startDatepicker').datepicker({
			showButtonPanel : true
		//  버튼 패널 노출
		/* 	,
			minDate : 0 // 오늘과 그 이후만 선택 가능

			,
			onSelect : function(dateText) {// 시작일이 선택되는 순간 종료일의 minDate 변경
				$('#endDatepicker').datepicker('option',
						'minDate', dateText);
			} */
		});

		$('#endDatepicker').datepicker({
			showButtonPanel : true,

		});
		
		$('.date-btn').on('click', function() {
			let startDate = $('#startDatepicker').val();
			let endDate = $('#endDatepicker').val();
			//	alert(endDate);

			if (startDate == '') {
				alert("조회할 시작 날짜를 선택하여주세요.");
				return;
			}

			if (endDate == '') {
				alert("조회할 마지막 날짜를 선택하여주세요.");
				return;
			}
			
			$.ajax({
				//request
				type : 'get',
				url : '/hiBook/order_return_date_search_view',
				data : {
					'startDate' : startDate,
					'endDate' : endDate
				}

				//response
				,
				success : function(data) {
					console.log(data);
					$('#orderBox').html(data);
				},

				error : function(e) {
					alert(e + "오류가 발생했습니다. 다시 시도해주세요.");
				}

			});

		});


	});
</script>
