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
		<div class="d-flex flex-wrap p-3 justify-content-center">
			<c:forEach items="${bestBookList}" var ="bestBook">
			<a href="/hiBook/hi_detail_view?isbn13=${bestBook.isbn13}">
				<article id="Best" class="best-box p-2">
					<div class="d-flex justify-content-center">
						<img src="${bestBook.cover}" alt="이미지"
							width="200" height="200" class="pl-3">
					</div>
						<div class="d-flex justify-content-center">
							<div class="pt-3 font20 font-weight-bold">
								Rank : <span class="ml-1"> ${bestBook.bestRank}</span>
							</div>
						</div>
						<div class="d-flex justify-content-center">
							<div class="pt-3 font20 font-weight-bold">
								제목 : <span class="ml-1"> ${bestBook.title}</span>
							</div>
						</div>
						<div class="d-flex justify-content-center">
							<div class="font-weight-bold font20 ">
								작가 : <span class="ml-1">${bestBook.author}</span>
							</div>
						</div>
					</article>
				</a>
			</c:forEach>
		</div>
	</div>

	<!-- 블로그 베스트-->
	<div
		class="d-flex justify-content-between align-items-center pt-5 pb-4">
		<div class="font50 p-4 font-weight-bold">Best Blog </div>
		<div class="font30 p-4">
			<a href="#">더 보러가기</a>
		</div>
	</div>

	<div id="reviewRanker" class="contents-box ">
		<div class="d-flex flex-wrap p-3">
		<c:forEach items="${bestBlogBookList}" var ="bestBlog">
		<a href="/hiBook/hi_detail_view?isbn13=${bestBlog.isbn13}">
			<article id="Best" class="best-box p-2">
					<div class="d-flex justify-content-center">
						<img src="${bestBlog.cover}" alt="이미지"
							width="200" height="200" class="pl-3">
					</div>
						<div class="d-flex justify-content-center">
							<div class="pt-3 font20 font-weight-bold">
								Rank : <span class="ml-1"> ${bestBlog.bestRank}</span>
							</div>
						</div>
						<div class="d-flex justify-content-center">
							<div class="pt-3 font20 font-weight-bold">
								제목 : <span class="ml-1"> ${bestBlog.title}</span>
							</div>
						</div>
						<div class="d-flex justify-content-center">
							<div class="font-weight-bold font20 ">
								작가 : <span class="ml-1">${bestBlog.author}</span>
							</div>
						</div>
						
				</article>
			</a>
		</c:forEach>
		</div>
	</div>
</article>
