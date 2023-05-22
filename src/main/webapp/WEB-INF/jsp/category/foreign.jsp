<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<article class="ranker-content">
	<div class="d-flex justify-content-between align-items-center pb-3">
		<div class="font50 p-4 font-weight-bold">소설 / 시 / 희곡</div>
	</div>
	<!-- 소설 / 시 / 희곡 -->
	<div id="novelPoem" class="mallType-box pb-2">
		<div class="d-flex flex-wrap p-3">
			<c:forEach items="${foreignBookNovelPoemList}" var="foreignBookNovelPoem">
			<a href="/hiBook/hi_detail_view?isbn13=${foreignBookNovelPoem.isbn13}">
				<article id="novelPoemBook" class="best-box p-2">
					<div class="d-flex justify-content-center">
						<img src="${foreignBookNovelPoem.cover}" alt="이미지"
							width="200" height="200" class="pl-3">
					</div>
						<div class="d-flex justify-content-center">
							<div class="pt-3 font20 font-weight-bold">
								Bets Rank :${foreignBookNovelPoem.bestRank} <span class="ml-1"> </span>
							</div>
						</div>
						<div class="d-flex justify-content-center">
							<div class="pt-3 font20 font-weight-bold">
								제목 : ${foreignBookNovelPoem.title} <span class="ml-1"> </span>
							</div>
						</div>
						<div class="d-flex justify-content-center mt-1">
							<div class="font-weight-bold font20 ">
								작가 : ${foreignBookNovelPoem.author}<span class="ml-1"></span>
							</div>
						</div>
					</article>
				</a>
				</c:forEach>
		</div>
	</div>
	
	<!-- 어린이-->
	<div
		class="d-flex justify-content-between align-items-center pt-5 pb-4">
		<div class="font50 p-4 font-weight-bold">어린이 / 만화 </div>
	</div>

	<div id="reference" class="mallType-box ">
		<div class="d-flex flex-wrap p-3">
		<c:forEach items="${foreignChildrenBookList}" var="foreignChildrenBook">
			<a href="/hiBook/hi_detail_view?isbn13=${foreignChildrenBook.isbn13}">
				<article id="referenceBook" class="best-box p-2">
						<div class="d-flex justify-content-center">
							<img src="${foreignChildrenBook.cover}" alt="이미지"
								width="200" height="200" class="pl-3">
						</div>
							<div class="d-flex justify-content-center">
								<div class="pt-3 font20 font-weight-bold">
									Rank : <span class="ml-1">${foreignChildrenBook.bestRank} </span>
								</div>
							</div>
							<div class="d-flex justify-content-center">
								<div class="pt-3 font20 font-weight-bold">
									제목 : <span class="ml-1"> ${foreignChildrenBook.title}</span>
								</div>
							</div>
							<div class="d-flex justify-content-center mt-1">
								<div class="font-weight-bold font20 ">
									작가 : <span class="ml-1">${foreignChildrenBook.author}</span>
								</div>
							</div>
							
					</article>
				</a>
			</c:forEach>
		</div>
	</div> 
 
	<!-- 일본 도서-->
	<div
		class="d-flex justify-content-between align-items-center pt-5 pb-4">
		<div class="font50 p-4 font-weight-bold">일본도서 </div>
	</div>

	<div id="japanese" class="mallType-box ">
		<div class="d-flex flex-wrap p-3">
		<c:forEach items="${foreignJapaneseBookList}" var="foreignJapaneseBook">
		<a href="/hiBook/hi_detail_view?isbn13=${foreignJapaneseBook.isbn13}">
			<article id="japaneseBook" class="best-box p-2">
					<div class="d-flex justify-content-center">
						<img src="${foreignJapaneseBook.cover}" alt="이미지"
							width="200" height="200" class="pl-3">
					</div>
						<div class="d-flex justify-content-center">
							<div class="pt-3 font20 font-weight-bold">
								Rank : <span class="ml-1">${foreignJapaneseBook.bestRank} </span>
							</div>
						</div>
						<div class="d-flex justify-content-center">
							<div class="pt-3 font20 font-weight-bold">
								제목 : <span class="ml-1"> ${foreignJapaneseBook.title}</span>
							</div>
						</div>
						<div class="d-flex justify-content-center mt-1">
							<div class="font-weight-bold font20 ">
								작가 : <span class="ml-1">${foreignJapaneseBook.author}</span>
							</div>
						</div>
				</article>
			</a>
			</c:forEach>
		</div>
	</div>
	
	
</article>
