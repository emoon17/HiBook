<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<article class="pt-5 container">
	<div class="font50 font-weight-bold mb-5">개인정보수정</div>
	<div class="d-flex  align-items-center pt-5">
		<div class="font30 ml-5 mr-5 font-weight-bold" style="width: 170px;">성명</div>
		<input type="text" id="name" class="main-keyword form-control text-center font30 text-start ml-5" style="height: 85px; width: 650px;" placeholder="정은ㅎ">
	</div>
	
	<div class="d-flex  align-items-center pt-5">
		<div class="font30 ml-5 mr-5 font-weight-bold " style="width: 170px;">휴대전화</div>
		<input type="text" id="phoneNumber" class="main-keyword form-control text-center font30 text-start ml-5" style="height: 85px; width: 650px;">
	</div>
	
	<div class="d-flex  align-items-center pt-5">
		<div class="font30 ml-5 mr-5 font-weight-bold " style="width: 170px;">로그인아이디</div>
		<input type="text" id="loginId" class="main-keyword form-control text-center font30 text-start ml-5" style="height: 85px; width: 650px;">
	</div>
	
	<div class="d-flex  align-items-center pt-5">
	<div class="font30 ml-5 mr-5 font-weight-bold " style="width: 170px;">주소</div>
				<input type="text" id="postcode" placeholder="우편번호"
					style="height: 85px; width: 650px;"
					class="font30 ml-5 form-control main-keyword">
				<button type="button"
					class="check-btn btn pl-3 font-weight-bold font30 main-keyword"
					id="daumPostcode" style="height: 85px;">주소 검색</button>
	</div>
			<div class="d-flex">
				<div class="font30 ml-5 mr-5 font-weight-bold " style="width: 170px;"></div>
					<input type="text" id="address" name="address" placeholder="주소"
						style="height: 85px; width: 650px;"
						class="font30 ml-5 mt-3 form-control main-keyword">
			</div>
			
			<div class="d-flex">
				<div class="font30 ml-5 mr-5 font-weight-bold " style="width: 170px;"></div>
			<input type="text" id="detailAddress" name="address"
				placeholder="상세주소" style="height: 85px; width: 650px;"
						class="font30 ml-5 mt-3 form-control main-keyword">
			</div>
				
			<div class="d-flex align-items-center pt-5">
				<div class="font30 ml-5 mr-5 font-weight-bold " style="width: 170px;">계정연동</div>
				<button type="button" class="btn font30 ml-5 mt-3 main-keyword" style="width: 150px;">kakao</button>
			</div>
			
			<div class="d-flex  align-items-center pt-5">
				<div class="font30 ml-5 mr-5 font-weight-bold " style="width: 170px;">프로필이미지</div>
				<div class="file-upload d-flex">
						
						
						
						<%-- file 태그는 숨겨두고 이미지를 클릭하면 file 태그를 클릭한 것처럼 이벤트를 줄 것이다. --%>
						<input type="file" id="file" name="file" class="d-none"
							accept=".gif, .jpg, .png, .jpeg" multiple="multiple">


						<div class="d-flex justify-content-between align-items-center">
							<%-- 업로드 된 임시 파일 이름 저장될 곳 --%>
							<div id="fileName" style="height: 10px;"
								class="copy-font text-center"></div>

							<input type="button" id="fileUpLoadBtn" value="사진 첨부"
								name="images" class="btn ml-5 main-keyword font30" style=" width: 150px;">

						</div>

					</div>
				</div>
				
				<div class="post-div d-flex justify-content-end ">
			<form id="fileUploadForm" action="/post/post_create" method="update"
				enctype="multipart/form-data">
				<button type="button" id="UpdateBtn"
					class="post-btn btn font30 font-weight-bold ">수정하기</button>
			</form>
		</div>
</article>

<!--다음 주소  -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	$(document).ready(function() {
		
		// 파일선택 업로드 버튼 누르기 뒤에 있는 file 인풋 누르기
		$('#fileUpLoadBtn').on('click', function(e) {
			$('#file').click();
		});
		
		//다음 주소 
		$('#daumPostcode').on('click' , function(){
			
	        new daum.Postcode({
	            oncomplete: function(data) {
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