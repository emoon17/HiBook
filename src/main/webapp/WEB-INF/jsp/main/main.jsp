<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<article class="ranker-content">
	<div class="d-flex justify-content-between align-items-center pb-3">
		<div class="font50 p-4 font-weight-bold">BestSeller</div>
		<div class="font30 p-4">
			<a href="#">더 보러가기</a>
		</div>
	</div>
	<!-- 베스트셀러 -->
	<div id="bestSeller" class="contents-box pb-2">
		<div class="d-flex flex-wrap p-3">
			<c:forEach items="bestBookList" var ="bestBook">
				<article id="Best" class="m-4">
					<a href="#"> <img src="/static/image/list.png" alt="이미지"
						width="300" height="300">
						<div class="ml-3 pt-3 font20 font-weight-bold">
							제목 : <span class="ml-3"> ${bastBook.title}</span>
						</div>
						<div class="ml-3 font-weight-bold font20 ">
							작가 : <span class="ml-3">칼 세이건</span>
						</div>
					</a>
				</article>
			</c:forEach>
		</div>
	</div>
	<!-- 편집장 추천 -->
	<div
		class="d-flex justify-content-between align-items-center pt-5 pb-4">
		<div class="font50 p-4 font-weight-bold">Editor Choice </div>
		<div class="font30 p-4">
			<a href="#">더 보러가기</a>
		</div>
	</div>

	<div id="reviewRanker" class="contents-box ">
		<div class="d-flex flex-wrap p-3">
			<article id="review1" class="m-4">
				<a href="#"> <img src="/static/image/list.png" alt="이미지"
					width="300" height="300">
					<div class="ml-3 pt-3 font20 font-weight-bold">
						제목 : <span class="ml-3"> 코스모스</span>
					</div>
					<div class="ml-3 font-weight-bold font20 ">
						작가 : <span class="ml-3">칼 세이건</span>
					</div>
				</a>
			</article>
			<article id="review2" class="m-4">
				<a href="#"> <img src="/static/image/list.png" alt="이미지"
					width="300" height="300" class="list-box">
					<div class="ml-3 pt-3 font20 font-weight-bold">
						제목 : <span class="ml-3"> 코스모스</span>
					</div>
					<div class="ml-3 font20 font-weight-bold">
						작가 : <span class="ml-3">칼 세이건</span>
					</div>
				</a>
			</article>
			<article id="review3" class="m-4">
				<a href="#"> <img src="/static/image/list.png" alt="이미지"
					width="300" height="300" class="list-box">
					<div class="ml-3 pt-3 font20 font-weight-bold">
						제목 : <span class="ml-3"> 코스모스</span>
					</div>
					<div class="font20 ml-3 font-weight-bold">
						작가 : <span class="ml-3">칼 세이건</span>
					</div>
				</a>
			</article>
			<article id="review4" class="m-4">
				<a href="#"> <img src="/static/image/list.png" alt="이미지"
					width="300" height="300" class="list-box">
					<div class="ml-3 pt-3 font20 font-weight-bold">
						제목 : <span class="ml-3"> 코스모스</span>
					</div>
					<div class="ml-3 font20 font-weight-bold">
						작가 : <span class="ml-3">칼 세이건</span>
					</div>
				</a>
			</article>
			<article id="review5" class="m-4">
				<a href="#"> <img src="/static/image/list.png" alt="이미지"
					width="300" height="300" class="list-box">
					<div class="ml-3 pt-3 font20 font-weight-bold">
						제목 : <span class="ml-3"> 코스모스</span>
					</div>
					<div class="ml-3 font20 font-weight-bold">
						작가 : <span class="ml-3">칼 세이건</span>
					</div>
				</a>
			</article>
			<article id="review6" class="m-4">
				<a href="#"> <img src="/static/image/list.png" alt="이미지"
					width="300" height="300" class="list-box">
					<div class="ml-3 pt-3 font20 font-weight-bold">
						제목 : <span class="ml-3"> 코스모스</span>
					</div>
					<div class="ml-3 font20 font-weight-bold">
						작가 : <span class="ml-3">칼 세이건</span>
					</div>
				</a>
			</article>
		</div>
	</div>
</article>
<article class="reivewcontent"></article>