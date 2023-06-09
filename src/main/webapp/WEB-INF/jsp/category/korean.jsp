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
			<c:forEach items="${koreanNovelBookList}" var="koreanNovelBook">
			<a href="/hiBook/hi_detail_view?isbn13=${koreanNovelBook.isbn13}">
				<article id="novelPoemBook" class="best-box p-2">
					<div class="d-flex justify-content-center">
						<img src="${koreanNovelBook.cover}" alt="이미지"
							width="200" height="200" class="pl-3">
					</div>
						<div class="d-flex justify-content-center">
							<div class="pt-3 font20 font-weight-bold">
								Bets Rank :${koreanNovelBook.bestRank} <span class="ml-1"> </span>
							</div>
						</div>
						<div class="d-flex justify-content-center">
							<div class="pt-3 font20 font-weight-bold">
								제목 : ${koreanNovelBook.title} <span class="ml-1"> </span>
							</div>
						</div>
						<div class="d-flex justify-content-center mt-1">
							<div class="font-weight-bold font20 ">
								작가 : ${koreanNovelBook.author}<span class="ml-1"></span>
							</div>
						</div>
					</article>
				</a>
				</c:forEach>
		</div>
	</div>

	<!-- 경제경영/자기계발-->
	<div
		class="d-flex justify-content-between align-items-center pt-5 pb-4">
		<div class="font50 p-4 font-weight-bold">경제경영 / 자기계발 </div>
	</div>

	<div id="economy" class="mallType-box ">
		<div class="d-flex flex-wrap p-3">
		<c:forEach items="${koreanEconomyBookList}" var="koreanEconomyBook">
		<a href="/hiBook/hi_detail_view?isbn13=${koreanEconomyBook.isbn13}">
			<article id="economyBook" class="best-box p-2">
					<div class="d-flex justify-content-center">
						<img src="${koreanEconomyBook.cover}" alt="이미지"
							width="200" height="200" class="pl-3">
					</div>
						<div class="d-flex justify-content-center">
							<div class="pt-3 font20 font-weight-bold">
								Best Rank : <span class="ml-1">${koreanEconomyBook.bestRank} </span>
							</div>
						</div>
						<div class="d-flex justify-content-center">
							<div class="pt-3 font20 font-weight-bold">
								제목 : <span class="ml-1"> ${koreanEconomyBook.title}</span>
							</div>
						</div>
						<div class="d-flex justify-content-center mt-1">
							<div class="font-weight-bold font20 ">
								작가 : <span class="ml-1">${koreanEconomyBook.author}</span>
							</div>
						</div>
				</article>
			</a>
		</c:forEach>
		</div>
	</div>
	
	<!-- 에세이-->
	<div
		class="d-flex justify-content-between align-items-center pt-5 pb-4">
		<div class="font50 p-4 font-weight-bold">어린이 / 만화 </div>
	</div>

	<div id="reference" class="mallType-box ">
		<div class="d-flex flex-wrap p-3">
		<c:forEach items="${koreanEssayBookList}" var="koreanEssayBook">
			<a href="/hiBook/hi_detail_view?isbn13=${koreanEssayBook.isbn13}">
				<article id="referenceBook" class="best-box p-2">
						<div class="d-flex justify-content-center">
							<img src="${koreanEssayBook.cover}" alt="이미지"
								width="200" height="200" class="pl-3">
						</div>
							<div class="d-flex justify-content-center">
								<div class="pt-3 font20 font-weight-bold">
									Rank : <span class="ml-1">${koreanEssayBook.bestRank} </span>
								</div>
							</div>
							<div class="d-flex justify-content-center">
								<div class="pt-3 font20 font-weight-bold">
									제목 : <span class="ml-1"> ${koreanEssayBook.title}</span>
								</div>
							</div>
							<div class="d-flex justify-content-center mt-1">
								<div class="font-weight-bold font20 ">
									작가 : <span class="ml-1">${koreanEssayBook.author}</span>
								</div>
							</div>
							
					</article>
				</a>
			</c:forEach>
		</div>
	</div>
</article>
