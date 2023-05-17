<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="logo" class="d-flex align-items-center  pl-4">
	<a href="/hiBook/main/main_veiw" class="logo-font">Hi Book</a>
</div>
<div id="keyword"
	class="d-flex justify-content-center align-items-center">
	<input type="text" class="main-keyword form-control col-6 font30"
		placeholder="제목 또는 글쓴이를 입력하여주세요." style="height: 80px; width: 320px;">
	<button type="button" class="main-keyword  btn ml-3 font30 "
		id="keywordBtn" style="height: 80px; width: 110px;">검색</button>
</div>
<div id="userImage" class="pl-5 pt-4">
	<div id="imgae-border">
		<img src="/static/image/userImage.png" alt="유저이미지" class="user-image">
	</div>
	<div class="pt-2 pl-4 font20">유저아이디</div>
</div>