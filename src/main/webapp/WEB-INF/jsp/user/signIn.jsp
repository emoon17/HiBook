<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
    
<div class="container">
	<div class="mt-3 ml-5">
		<h2 class="font50 font-weight-bold mt-5 ml-5">Hi Book 로그인 후 더 많은 서비스를 이용하세요!</h2>
	</div>
	<div class="d-flex justify-content-center login_check">
		<form id="signInForm" method="post" action="/hiBook/user/sign_in">
				<div class="d-flex">
				<!-- 아이디 -->
					<div class="font30 mt-5 mr-5 font-weight-bold">아이디 </div>
					<input type="text" id="loginId" name="loginId" placeholder="아이디"
						style="height: 85px; width: 500px;"
						class="font30 mt-5 form-control main-keyword">
					</div>
	
				<!-- 비밀번호 -->
				<div class="d-flex">
					<div class="font30 mt-5 mr-4 font-weight-bold">비밀번호 </div>
					<input type="password" id="password" name="password"
					placeholder="비밀번호" style="height: 85px; width: 500px;"
					class="font30 form-control pl-3 mt-4 mb-5 main-keyword">
				</div>
	
				<div class="font40">
					<button type="submit" id="signInBtn"
					 class="font40 user-btn btn mt-5 font-weight-bold main-keyword"
						style="width: 630px; height: 85px;">로그인</button>
				</div>
				
				<div class="login_check font30 mt-5">
					계정이 없으신가요? <a href="/hiBook/user/sign_up_view"
						class="font30 font-weight-bold ">회원가입</a>
				</div>
		 </form>
	 </div>
</div>

<script>
	$(document).ready(function() {
		$('#signInForm').on('submit', function(e) {
			e.preventDefault();
			//alert("Dd");
			
			let loginId = $('#loginId').val();
			let password = $('#password').val();
			
			//alert(loginId);
			
			
			if (loginId == '') {
				alert("아이디를 입력하세요.");
				return;
			}
			
			if (password == '') {
				alert("비밀번호를 입력하세요.");
				return;
			}
			
			let url = $(this).attr('action'); // form 태그의 action속성
			let params = $(this).serialize(); // form 태그 name 값들
			
			 $.post(url, params)
			.done(function(data) {
				if(data.code == 1) {
					location.href = "/hiBook/main/main_veiw";
				} else {
					alert(data.errorMessage);
				} 
			});
			
		});
		
	});
</script>