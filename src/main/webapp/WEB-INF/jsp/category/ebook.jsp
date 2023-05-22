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
			<c:forEach items="${eBookNovelPoemBookList}" var="eBookNovelPoemBook">
			<a href="/hiBook/hi_detail_view?isbn13=$}">
				<article id="novelPoemBook" class="best-box p-2">
					<div class="d-flex justify-content-center">
						<img src="${eBookNovelPoemBook.cover}" alt="이미지"
							width="200" height="200" class="pl-3">
					</div>
						<div class="d-flex justify-content-center">
							<div class="pt-3 font20 font-weight-bold">
								Bets Rank :${eBookNovelPoemBook.bestRank} <span class="ml-1"> </span>
							</div>
						</div>
						<div class="d-flex justify-content-center">
							<div class="pt-3 font20 font-weight-bold">
								제목 : ${eBookNovelPoemBook.title} <span class="ml-1"> </span>
							</div>
						</div>
						<div class="d-flex justify-content-center mt-1">
							<div class="font-weight-bold font20 ">
								작가 : ${eBookNovelPoemBook.author}<span class="ml-1"></span>
							</div>
						</div>
					</article>
				</a>
				</c:forEach>
		</div>
	</div>
	
	 <!-- 만화-->
	<div
		class="d-flex justify-content-between align-items-center pt-5 pb-4">
		<div class="font50 p-4 font-weight-bold">만화 </div>
	</div>

	<div id="toon" class="mallType-box ">
		<div class="d-flex flex-wrap p-3">
		<c:forEach items="${eBookToonList}" var="eBookToon">
		<a href="/hiBook/hi_detail_view?isbn13=$}">
			<article id="webtoon" class="best-box p-2">
					<div class="d-flex justify-content-center">
						<img src="${eBookToon.cover}" alt="이미지"
							width="200" height="200" class="pl-3">
					</div>
						<div class="d-flex justify-content-center">
							<div class="pt-3 font20 font-weight-bold">
								Rank : <span class="ml-1">${eBookToon.bestRank} </span>
							</div>
						</div>
						<div class="d-flex justify-content-center">
							<div class="pt-3 font20 font-weight-bold">
								제목 : <span class="ml-1"> ${eBookToon.title}</span>
							</div>
						</div>
						<div class="d-flex justify-content-center mt-1">
							<div class="font-weight-bold font20 ">
								작가 : <span class="ml-1">${eBookToon.author}</span>
							</div>
						</div>
				</article>
			</a>
			</c:forEach>
		</div>
	</div> 
	
	 <!-- 교양 / 인문학-->
	<div
		class="d-flex justify-content-between align-items-center pt-5 pb-4">
		<div class="font50 p-4 font-weight-bold">교양 / 인문학 </div>
	</div>

	<div id="humanities" class="mallType-box ">
		<div class="d-flex flex-wrap p-3">
		<c:forEach items="${eBookHumanitiesBookList}" var="eBookHumanitiesBook">
			<a href="/hiBook/hi_detail_view?isbn13=$}">
				<article id="humanitiesBook" class="best-box p-2">
						<div class="d-flex justify-content-center">
							<img src="${eBookHumanitiesBook.cover}" alt="이미지"
								width="200" height="200" class="pl-3">
						</div>
							<div class="d-flex justify-content-center">
								<div class="pt-3 font20 font-weight-bold">
									Rank : <span class="ml-1">${eBookHumanitiesBook.bestRank} </span>
								</div>
							</div>
							<div class="d-flex justify-content-center">
								<div class="pt-3 font20 font-weight-bold">
									제목 : <span class="ml-1"> ${eBookHumanitiesBook.title}</span>
								</div>
							</div>
							<div class="d-flex justify-content-center mt-1">
								<div class="font-weight-bold font20 ">
									작가 : <span class="ml-1">${eBookHumanitiesBook.author}</span>
								</div>
							</div>
							
					</article>
				</a>
			</c:forEach>
		</div>
	</div> 
 
	
</article>
