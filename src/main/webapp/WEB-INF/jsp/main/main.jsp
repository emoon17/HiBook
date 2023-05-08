<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hi Book</title>

<!-- jquery : bootstrap, datepicker -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>

<!-- bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>

<!-- css -->
<link rel="stylesheet" type="text/css" href="/static/css/HiBook.css">

<!-- 폰트 -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100&display=swap"
	rel="stylesheet">

</head>
<body>
	<div id="wrap" class="bg-danger">
		<header class="bg-success d-flex ">
			<div id="logo" class="bg-primary d-flex align-items-center  pl-4">
				<a href="#" class="logo-font">Hi Book</a>
			</div>
			<div id="keyword" class="bg-light d-flex justify-content-center align-items-center">
				<input type="text" class="form-control col-6">
			</div>
			<div id="userImage" class="bg-info"></div>
		</header>
		<nav class="bg-secondary d-flex align-items-center ">
			<div class="ml-4 col-3">
				<input type="checkbox" id="menuicon"> <label for="menuicon">
					<span></span> <span></span> <span></span>
				</label>

				<div class="sidebar">
					<div class="menu-tap d-flex m-3">
						<table class="table h-100 w-100">
							<thead>
								<tr>
									<th class="font50 font-weight-bold">Menu</th>
									<c:if test="${empty userId}">
										<th class="font30 font-weight-bold"><a href="#">로그인</a></th>
										<th class="font30 font-weight-bold"><a href="#">회원가입</a></th>
									</c:if>
									<c:if test="${not empty userId}">
										<th class="font30 font-weight-bold"><a href="#">${loginId}</a></th>
										<th class="font30 font-weight-bold"><a
											href="/user/signOut">logout</a></th>
									</c:if>
								</tr>
							</thead>

							<tbody>
								<tr>
									<td colspan='3' class="font30 font-weight-bold pt-5"><a
										href="#">국내도서 </a></td>
								</tr>
								<tr>
									<td colspan='3' class="font20 font-weight-bold pt-5"><a
										href="#">소설/시/희곡 </a></td>
								</tr>
								<tr>
									<td colspan='3' class="font20 font-weight-bold pt-5"><a
										href="#">경제경영/자기계발 </a></td>
								</tr>
								<tr>
									<td colspan='3' class="font20 font-weight-bold pt-5"><a
										href="#">수험서/참고서 </a></td>
								</tr>
								<tr>
									<td colspan='3' class="font30 font-weight-bold pt-5"><a
										href="#">국외도서 </a></td>
								</tr>
								<tr>
									<td colspan='3' class="font20 font-weight-bold pt-5"><a
										href="#">소설/시/희곡 </a></td>
								</tr>
								<tr>
									<td colspan='3' class="font20 font-weight-bold pt-5"><a
										href="#">경제경영</a></td>
								</tr>
								<tr>
									<td colspan='3' class="font20 font-weight-bold pt-5"><a
										href="#">기타 언어권 </a></td>
								</tr>
								<tr>
									<td colspan='3' class="font30 font-weight-bold pt-5"><a
										href="#">e-Book </a></td>
								</tr>
								<tr>
									<td colspan='3' class="font20 font-weight-bold pt-5"><a
										href="#">소설/시 </a></td>
								</tr>
								<tr>
									<td colspan='3' class="font20 font-weight-bold pt-5"><a
										href="#">경제경영/ 자기계발 </a></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<!-- side바 메뉴 -->
				<div class="d-flex align-items-center justify-content-around col-7 font30 font-weight-bold">
					<div>국내도서</div>
					<div>국외도서</div>
					<div>e-Book</div>
				</div>
			
			
		</nav>
		<section class="contents bg-warning">
			<article class="bestcontent">
				<div class="d-flex justify-content-between align-items-center">
					<div class="font50 p-4 font-weight-bold">BestSeller</div>
					<div class="font20 p-4"><a href="#">더 보러가기</a> </div>
				</div>
				<!-- 글 목록 -->
				<div id="contentsBox" class="contents-box ">
					<div
						class="contents-parent-box d-flex flex-wrap p-3">
						<%-- <c:forEach var='posts' items='${postList}' varStatus="status"> --%>
							<article id="BestSeller">
								<a href="#">
									<img src="/static/image/list.png" alt="이미지"
										width="300" height="300" class="list-box">
									<div class="ml-3 font-weight-bold">
										제목 : <span class="ml-3"> 코스모스</span>
									</div>
									<div class="copy-font ml-3 font-weight-bold">
										작가 : <span class="ml-3">칼 세이건</span>
									</div>
								</a>
							</article>
					<!-- 	</c:forEach> -->
					</div>
			</article>
			<article class="reivewcontent"></article>
		</section>
		<footer class="bg-primary"></footer>
	</div>
</body>
</html>