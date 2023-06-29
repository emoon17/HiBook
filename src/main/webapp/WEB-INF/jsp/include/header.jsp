<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="logo" class="d-flex align-items-center  pl-4">
	<a href="/hiBook/main/main_veiw" class="logo-font">Hi Book</a>
</div>
<div id="keyword"
	class="d-flex justify-content-center align-items-center">
	<input type="text" class="main-keyword form-control col-6 font30"
		id="keyword" placeholder="제목 또는 글쓴이를 입력하여주세요."
		style="height: 80px; width: 320px;">
	<button type="button" class="main-keyword  btn ml-3 font30 "
		id="keywordBtn" style="height: 80px; width: 110px;">검색</button>
</div>

<c:if test="${empty loginId}">
	<div class="d-flex justify-content-center align-items-center">
		<div class="pt-2 font30 mr-3">
			<a href="/hiBook/user/sign_in_view">로그인</a> | <a
				href="/hiBook/user/sign_up_view" class="pl-2">회원가입</a>
		</div>
	</div>
</c:if>

<c:if test="${not empty loginId}">
<c:if test="${not empty profileImage}">
	<div id="userImage" class="pl-4 pt-4">
		<div id="imgae-border" class="ml-4">
			<a href="/hiBook/mypage/user_information_view">
			<img src="${profileImage}" alt="유저이미지" class="user-image">
			</a>
		</div>
		
		<div class="pt-2 font20 ml-4"><a href="/hiBook/mypage/user_information_view">${loginId}</a>
			| <a href="/hiBook/user/sign_out" class="pl-2">logout</a>
		</div>
	</div>
</c:if>

<c:if test="${empty profileImage}">
<div class="d-flex align-items-center justify-content-center pt-2 mr-5 font30"><a href="/hiBook/mypage/user_information_view">${loginId}</a>
			| <a href="/hiBook/user/sign_out" class="pl-2">logout</a>
		</div>
</c:if>
</c:if>
			

<script>
	$(document).ready(function() {

		$('#keywordBtn').on('click', function() {
			let keyword = $(this).siblings('input').val();
			//alert(keyword);

			if (keyword == '') {
				alert("제목 또는 글쓴이를 입력하여주세요.");
			}

			$.ajax({
				//request
				type : "get",
				url : "/hiBook/main/main_search_view",
				data : {
					"keyword" : keyword
				},
				success : function(data) {
					$('#contents').html(data);
					alert("조회가 완료되었습니다.");
				},
				error : function(e) {
					alert("공백 없이 입력하여 주세요.")
				}
			});
		})
	});
</script>

