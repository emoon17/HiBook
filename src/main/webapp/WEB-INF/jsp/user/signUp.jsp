<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="container">
	<h2 class="font50 font-weight-bold mt-5 ml-5">Hi Book 회원가입 후 더 많은
		서비스를 이용하세요!</h2>
	<div class="d-flex justify-content-center login_check">
		<form id="signUpForm" method="post" action="/hiBook/user/sign_up">
			<div class="d-flex">
				<!-- 아이디 -->
				<input type="text" id="loginId" name="loginId" placeholder="아이디"
					style="height: 85px; width: 600px;"
					class="font30 mt-5 form-control main-keyword">
				<button type="button"
					class="check-btn btn ml-3 mt-5 font-weight-bold font30 main-keyword"
					id="loginCheckBtn" style="height: 85px;">중복 확인</button>
			</div>

			<div id="userIdCheckLength" class="pl-3 font20 text-danger d-none">아이디가
				비었습니다.</div>
			<div id="userIdFormat" class="pl-3 font20 text-danger d-none">영어와
				숫자만 가능합니다.</div>
			<div id="idCheckDuplicated" class="pl-3 font20 text-danger d-none">이미
				사용중인 ID입니다.</div>
			<div id="idCheckOk" class="pl-3 font20 text-success d-none">사용
				가능한 ID 입니다.</div>

			<!-- 이름 -->
			<input type="text" id="name" name="name" placeholder="이름"
				style="height: 85px; width: 600px;"
				class="font30 form-control pl-3 mt-4 main-keyword">
			<div id="nameCheckLength" class="pl-3 font20 text-danger d-none">이름이
				비었습니다.</div>

			<!-- 비밀번호 -->
			<input type="password" id="password" name="password"
				placeholder="비밀번호" style="height: 85px; width: 600px;"
				class="font30 form-control pl-3 mt-4 main-keyword">
			<div id="passwordVal" class="pl-3 font20 text-danger d-none">소문자,
				숫자만 혼합 사용하여 8글자만 가능합니다.</div>

			<input type="password" id="passwordCheck" placeholder="비밀번호 재입력"
				style="height: 85px; width: 600px;"
				class="font30 form-control pl-3 mt-4 main-keyword">
			<div id="passwordCheckVal" class="pl-3 font20 text-danger d-none">입력하신
				비밀번호와 일치하지 않습니다.</div>

			<!-- 전화번호 -->
			<input type="text" id="phoneNumber" name="phoneNumber"
				placeholder="전화번호 ex) 010-1111-2222"
				style="height: 85px; width: 600px;"
				class="font30 form-control pl-3 mt-4 main-keyword">
			<div id="phoneCheckLength" class="pl-3 font20 text-danger d-none">전화번호를
				입력해주세요.</div>

			<!-- 주소 입력 -->
			<div class="d-flex">
				<input type="text" id="postcode" placeholder="우편번호"
					style="height: 85px; width: 600px;"
					class="font30 mt-4 form-control main-keyword">
				<button type="button"
					class="check-btn btn ml-3 mt-4 font-weight-bold font30 main-keyword"
					id="daumPostcode" style="height: 85px;">주소 검색</button>
			</div>
			<div class="d-flex">
				<input type="text" id="address" name="address" placeholder="주소"
					style="height: 85px; width: 600px;"
					class="font30 mt-4 form-control main-keyword">
			</div>
			<input type="text" id="detailAddress" name="address"
				placeholder="상세주소" style="height: 85px; width: 600px;"
				class="font30 mt-2 form-control">

			<div class="font40">
				<button type="submit" id="signUpBtn"
					class="font40 user-btn btn mt-5 font-weight-bold main-keyword"
					style="width: 600px; height: 85px;" >회원가입</button>
			</div>

			<div class="login_check font30 mt-5">
				계정이 있으신가요? <a href="/hiBook/user/sign_in_view"
					class="font30 font-weight-bold ">로그인</a>
			</div>
		</form>
	</div>
</div>

<!-- 다음주소 -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	$(document).ready(function() {
		$("#loginCheckBtn").on('click', function() {

			//validation
			let loginId = $('#loginId').val().trim();
			//alert(loginId);
			//초기화
			$('#userIdCheckLength').addClass('d-none');
			$('#idCheckDuplicated').addClass('d-none');
			$('#idCheckOk').addClass('d-none');
			$('#userIdFormat').addClass('d-none');

			let regId = /^[A-Za-z]{1}[A-Za-z0-9_-]{3,19}$/ // 반드시 영문으로 시작 숫자+언더바/하이픈 허용 4~20자리
			if (loginId.length < 4) {
				$('#userIdCheckLength').removeClass('d-none') // 경고문구 노출
				return;
			}

			if (!regId.test(loginId)) {
				$('#userIdFormat').removeClass('d-none');
			}

			// ajax
			$.ajax({
				//request
				type : "post",
				url : "/hiBook/user/is_duplicated_id",
				data : {
					"loginId" : loginId
				}
				//response
				,
				success : function(data) {
					if (data.code == 1) {
						// 성공
						// 중복
						$('#idCheckDuplicated').removeClass('d-none');
					} else {
						// 실패
						$('#idCheckOk').removeClass('d-none');
					}
				},
				error : function(e) {
					alert("중복확인에 실패하였습니다.");
				}

			});
		}); // 아이디 중복확인

		$('#signUpForm').on('submit', function(e) {
			e.preventDefault();

			//validation
			let name = $('#name').val().trim();
			let password = $('#password').val();
			let passwordCheck = $('#passwordCheck').val();
			let phoneNumber = $('#phoneNumber').val().trim();
			//alert(name);
			// 초기화
			$('#nameCheckLength').addClass('d-none');
			$('#phoneCheckLength').addClass('d-none');
			$('#userIdCheckLength').addClass('d-none');
			$('#passwordVal').addClass('d-none');
			$('#passwordCheckVal').addClass('d-none');

			if ($('#idCheckOk').hasClass('d-none')) {
				alert("아이디 중복확인을 다시 해주세요.");
				return false;
			}

			if (name == '') {
				$('#nameCheckLength').removeClass('d-none');
				return false;
			}

			let regPw = /(?=.*\d)(?=.*[a-zA-ZS]).{8,}/;
			if (!regPw.test(password)) {
				$('#passwordVal').removeClass('d-none');
				return false;
			}

			if (password != passwordCheck) {
				$('#passwordCheckVal').removeClass('d-none');
				return false;
			}

			if (phoneNumber == '') {
				$('#phoneCheckLength').removeClass('d-none');
				return false;
			}

			let url = $(this).attr('action');
			let params = $(this).serialize(); // form 태그에 있는 name으로 파라미터 구성

			$.post(url, params) // request
			.done(function(data) { //response
				if (data.code == 1) {
					alert("가입을 환영합니다. 로그인 해주세요.");
					location.href = "/hiBook/user/sign_in_view";
				} else {
					//실패
					alert(data.errorMessage);
				}
			});
		});
		
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
