<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container">
	<h2 class="font50 font-weight-bold mt-5 ml-5">Hi Book 회원가입 후 더 많은 서비스를 이용하세요!</h2>
	<div class="d-flex justify-content-center login_check">
		<form id="signUpForm" method="post" action="/user/sign_up">
				<div class="d-flex">
				<!-- 아이디 -->
					<input type="text" id="loginId" name="loginId" placeholder="아이디"
						style="height: 85px; width: 600px;"
						class="font30 mt-5 form-control main-keyword">
					<button type="button" class="check-btn btn ml-3 mt-5 font-weight-bold font30 main-keyword"
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
				<input type="text" id="name" name="name"
					placeholder="이름" style="height: 85px; width: 600px;"
					class="font30 form-control pl-3 mt-4 main-keyword">
				<div id="nameCheckLength" class="pl-3 font20 text-danger d-none">이름이
					비었습니다.</div>
	
				<!-- 비밀번호 -->
				<input type="password" id="password" name="password"
					placeholder="비밀번호" style="height: 85px; width: 600px;"
					class="font30 form-control pl-3 mt-4 main-keyword">
				<div id="passwordVal" class="pl-3 font20 text-danger d-none">소문자,
					숫자만 혼합 사용하여 8글자만 가능합니다.</div>
	
				<input type="password" id="passwordCheck" 
					placeholder="비밀번호 재입력" style="height: 85px; width: 600px;"
					class="font30 form-control pl-3 mt-4 main-keyword">
				<div id="passwordCheckVal" class="pl-3 font20 text-danger d-none">입력하신
					비밀번호와 일치하지 않습니다.</div>
				
				<!-- 전화번호 -->
				<input type="text" id="phoneNumber"  name="phoneNumber"
					placeholder="전화번호 ex) 010-1111-2222" 
					style="height: 85px; width: 600px;"
					class="font30 form-control pl-3 mt-4 main-keyword">
				<div id="phoneCheckLength" class="pl-3 font20 text-danger d-none">전화번호를
					입력해주세요.</div>
					
				<!-- 주소 입력 -->
				<div class="d-flex">
					<input type="text" id="address" name="address" 
							style="height: 85px; width: 600px;"
							class="font30 mt-4 form-control main-keyword">
					<button type="button" class="check-btn btn ml-3 mt-4 font-weight-bold font30 main-keyword"
						id="loginCheckBtn" style="height: 85px;">주소 검색</button>
				</div>
				<input type="text" id="address" name="address" placeholder="나머지 주소를 입력하세요."
						style="height: 85px; width: 600px;"
						class="font30 mt-2 form-control">
	
				<div class="font40">
					<button type="submit" id=""
					 class="font40 user-btn btn mt-5 font-weight-bold main-keyword"
						style="width: 600px; height: 85px;">회원가입</button>
				</div>
				
				<div class="login_check font30 mt-5">
					계정이 있으신가요? <a href="/hiBook/user/sign_in_view"
						class="font30 font-weight-bold ">로그인</a>
				</div>
		 </form>
	 </div>
</div>

<script>
	$(document).ready(function() {
		$("#loginCheckBtn").on('click', function() {
		
			//validation
			let loginId = $('#loginId').val().trim();
			alert(loginId);
			//초기화
			$('#userIdCheckLength').addClass('d-none');
			$('#idCheckDuplicated').addClass('d-none');
			$('#idCheckOk').addClass('d-none');
			$('#userIdFormat').addClass('d-none');
			
			let regId = /^[A-Za-z]{1}[A-Za-z0-9_-]{3,19}$/ // 반드시 영문으로 시작 숫자+언더바/하이픈 허용 4~20자리
			if (loginId.length < 4){
				$('#userIdCheckLength').removeClass('d-none') // 경고문구 노출
				return;
			} 
			
			if (!regId.test(loginId)) {
				$('#userIdFormat').removeClass('d-none');
			}
			
			// ajax
			 $.ajax({
				//request
				type:"post"
				, url:"/hiBook/user/is_duplicated_id"
				, data:{"loginId":loginId}
				//response
				,success:function(data){
					if (data.code == 1) {
						// 성공
						// 중복
						$('#idCheckDuplicated').removeClass('d-none');
					} else {
						// 실패
						$('#idCheckOk').removeClass('d-none');
					}
				}
				, error:function(e){
					alert("중복확인에 실패하였습니다.");
				}
				
			}); 
		}); // 아이디 중복확인
		
		$('#signUpForm').on('submit', function(e){
			e.preventDefault();
		});
	});
</script>