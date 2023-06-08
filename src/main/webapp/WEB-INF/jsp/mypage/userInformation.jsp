<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<article class="pt-5 container">
	<div class="font50 font-weight-bold mb-5">개인정보수정</div>
	<div class="d-flex  align-items-center pt-5">
		<div class="font30 ml-5 mr-5 font-weight-bold" style="width: 170px;">성명</div>
		<input type="text" id="name"
			class="main-keyword form-control text-center font30 text-start ml-5"
			style="height: 85px; width: 650px;" value="${name}">
	</div>

	<div class="d-flex  align-items-center pt-5">
		<div class="font30 ml-5 mr-5 font-weight-bold " style="width: 170px;">휴대전화</div>
		<input type="text" id="phoneNumber"
			class="main-keyword form-control text-center font30 text-start ml-5"
			style="height: 85px; width: 650px;" value="${phoneNumber}">
	</div>

	<div class="d-flex  align-items-center pt-5">
		<div class="font30 ml-5 mr-5 font-weight-bold " style="width: 170px;">로그인아이디</div>
		<input type="text" id="loginId"
			class="main-keyword form-control text-center font30 text-start ml-5"
			style="height: 85px; width: 650px;" value="${loginId}">
	</div>

	<div class="d-flex  align-items-center pt-5">
		<div class="font30 ml-5 mr-5 font-weight-bold " style="width: 170px;">주소</div>
		<input type="text" id="postcode" placeholder="우편번호"
			style="height: 85px; width: 650px;"
			class="font30 ml-5 form-control main-keyword" value="${postcode}">
		<button type="button"
			class="check-btn btn pl-3 font-weight-bold font30 main-keyword"
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
			class="font30 ml-5 mt-3 form-control main-keyword" value="${detailAddress}">
	</div>

	<div class="d-flex align-items-center pt-5">
		<div class="font30 ml-5 mr-5 font-weight-bold " style="width: 170px;">계정연동</div>
		<button type="button" class="btn font30 ml-5 mt-3 main-keyword"
			style="width: 150px;">kakao </button>
	</div>

	<div class="d-flex  align-items-center pt-5">
		<div class="font30 ml-5 mr-5 font-weight-bold " style="width: 170px;">프로필이미지</div>
		<div class="file-upload d-flex">



			<%-- file 태그는 숨겨두고 이미지를 클릭하면 file 태그를 클릭한 것처럼 이벤트를 줄 것이다. --%>
			<input type="file" id="file" name="file" class="d-none"
				accept=".gif, .jpg, .png, .jpeg" multiple="multiple">


			<div class="d-flex justify-content-between align-items-center">


				<input type="button" id="fileUpLoadBtn" value="사진 첨부" name="images"
					class="btn ml-5 main-keyword font30" style="width: 150px;">
				<%-- 업로드 된 임시 파일 이름 저장될 곳 --%>
				<div id="fileName" style="height: 10px;" class="font20 ml-3"></div>

			</div>

		</div>
	</div>

	<div class="post-div d-flex justify-content-end ">
		<form id="fileUploadForm" action="/hibook/mypage/information_update" method="put"
			enctype="multipart/form-data">
			<button type="button" id="UpdateBtn"
				class="post-btn btn font30 font-weight-bold ">수정하기</button>
		</form>
	</div>
</article>

<!--다음 주소  -->
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	$(document).ready(function() {

		// 파일선택 업로드 버튼 누르기 뒤에 있는 file 인풋 누르기
		$('#fileUpLoadBtn').on('click', function(e) {
			$('#file').click();
		});

		let textFileList = new Array(); //이미지 이름을 담아놓을 배열
		// 파일 유효성 확인, 업로드 된 파일 이름 노출
		$('#file').on('change', function(e) {
			//	alert("ss");

			let fileName = e.target.files[0].name; // 파일이름
			let file = e.target.files; // 선택된 파일
			let filesArr = Array.prototype.slice.call(file); //아규먼트를 배열에 담아놓는다.

			let ext = fileName.split(".").pop().toLowerCase();
			if (ext != 'jpg' && ext != 'jepg' && ext != 'gif' && ext != 'png') {
				alert("파일 형식에 맞지 않습니다. \n가능 파일: jpg, jepg, gif, png ");
				// 인풋 파일 제거 , 파일 이름 비우기
				file.clear(); //인풋파일 제거
				$('#fileName').text('');
			}

			for (let i = 0; i < filesArr.length; i++) {
				textFileList.push(filesArr[i].name);
			}

			for (let i = 0; i < textFileList.length; i++) {
				$('#fileName').text(textFileList);// 배열에서 파일 이름을 꺼내서 보여준다.

			}

			if (textFileList.length > 1) {
				alert("프로필은 최대 1개까지 업로드 가능합니다.");
				$('#fileName').text(''); // 세개 이상 추가 시 없애버림
				file = null;
				textFileList.length = 0;
				$('#file').val(''); //인풋파일 제거
				return;
			}

		});
		
		$('#UpdateBtn').on('click', function(){
			
			let name = $("#name").val();
			let loginId = $('#loginId').val();
			let phoneNumber = $('#phoneNumber').val();
			let address = $('#address').val();
			let postcode = $('#postcode').val();
			let detailAddress = $('#detailAddress').val();
			
			/* let addressList = new Array();
			addressList.push(Address);
			addressList.push(detailAddress); */
			
		//	alert(Address);
			let formData = new FormData($('#fileUploadForm')[0]); // 폼객체
			
			formData.append("name", name);
			formData.append('phoneNumber', phoneNumber);
			formData.append('loginId', loginId);
			formData.append('address', address);
			formData.append('postcode', postcode);
			formData.append('detailAddress', detailAddress);
			formData.append('file', $('#file')[0].files[0]); 
			
			//ajax 통신으로 forData에 있는 데이터 전송
			 $.ajax({
					//request
				type:"put"
				, url:"/hiBook/mypage/information_update"
				, data:formData // json이 아니라 form객체를 통으로 넣어야됌
					
				// 파일 업로드시 필요한 3가지 설정 - Requestbody에 json이 아니라 form객체가 담겨지는 설정
				// 자바스크립트에서 폼태그 만들기
				, enctype:"multipart/form-data"
				, processData:false
				, contentType:false
					
					//response
				, success:function(data) {
					if (data.code == 1) {
						// 성공
						alert("개인정보 수정이 완료되었습니다. \n 로그인을 다시 해주세요");
						location.href="/hiBook/user/sign_in_view";
					} else {
							//실패
						alert(data.errorMessage);
					}
				}
				, error:function(e){
					alert("수정에 실패하였습니다.")
				}
			}); 
				
		});
			
	

		//다음 주소 
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