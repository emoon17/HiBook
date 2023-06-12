<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<article class="ranker-content">
	<!-- keyword -->
	<div id="bestSeller" class="contents-box pb-2">
		<div class="d-flex flex-wrap p-3 justify-content-center align-items-center">
			<c:forEach items="${keywordBookList}" var ="keywordBook">
			<a href="/hiBook/hi_detail_view?isbn13=${keywordBook.isbn13}">
				<article id="Best" class="best-box p-2">
					<div class="d-flex justify-content-center">
						<img src="${keywordBook.cover}" alt="이미지"
							width="200" height="200" class="pl-3">
					</div>
						<div class="d-flex justify-content-center">
							<div class="pt-3 font20 font-weight-bold">
								Rank : <span class="ml-1"> ${keywordBook.bestRank}</span>
							</div>
						</div>
						<div class="d-flex justify-content-center">
							<div class="pt-3 font20 font-weight-bold">
								제목 : <span class="ml-1"> ${keywordBook.title}</span>
							</div>
						</div>
						<div class="d-flex justify-content-center mt-1">
							<div class="font-weight-bold font20 ">
								작가 : <span class="ml-1">${keywordBook.author}</span>
							</div>
						</div>
					</article>
				</a>
			</c:forEach>
		</div>
	</div>
</article>