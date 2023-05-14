<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<article class="pt-5">
<c:forEach items="${inquiryBookList}" var ="inquiryBook">
	<div class="description d-flex justify-content-center">
		<div class="book_cover col-6 d-flex justify-content-center align-items-center ">
				<img src="${inquiryBook.cover}" width="450" height="500">
		</div>
		
		<div class="detail col-6">
			<div class="content_detail d-flex justify-content-center align-items-center">
				<div class="font50 font-weight-bold">${inquiryBook.title}</div>
			</div>
			<div class="mt-5 d-flex justify-content-center align-items-center">
					<div class="font30 font-weight-bold">글쓴이 : ${inquiryBook.author}</div>
			</div>
			<div class="mt-5 d-flex justify-content-center align-items-center">
					<div class="font30 font-weight-bold">책 소개 : ${inquiryBook.description}</div>
			</div>
			<div class="mt-3 d-flex justify-content-center align-items-center">
					<div class="font40 font-weight-bold">판매가 : ${inquiryBook.priceSales} 원</div>
			</div>
		<div class="mt-5 d-flex justify-content-center align-items-center">
			<button type="button" id="cartBtn" class="cart_order_btn btn mr-5 font20 font-weight-bold">장바구니</button>
			<button type="button" id="orderBtn" class="cart_order_btn btn ml-5 font20 font-weight-bold">주문하기</button>
		</div>
		</div>
		
		
	</div>
</c:forEach>
</article>
<div class="line"></div>
<article>
	<%-- 댓글 목록 --%>
		<div class="card-comment-list mt-5">

			<%-- 댓글내용 --%>
				<div class="card-comment  d-flex justify-content-between m-3">
					<div class="font-weight-bold font30 ">
						아이디<span class="ml-3">:</span> <span
							id="content" class="font30 ml-3">내용</span>
					</div>

					<%-- <%-- 모달로 댓글 삭제하기 --%>
						<img src="/static/image/delete.png" id="deleteCommentBtn"
							class="mt-1 more-btn write-area"
							data-toggle="modal" data-target="#modal"
							data-post-id=""
							data-comment-content=""
							width="30px" height="35x">
						<!--댓글 Modal -->
						<div class="modal fade" id="modal">
							<%--...을 눌렀을 때 post-data-id를 모달에 심어놓을거다. --%>
							<%-- modal sm: 작은 모달 창  --%>
							<%-- modal centered: 모달 창 수직으로 가운데 정렬 --%>
							<div class="modal-dialog modal-lg modal-dialog-centered">
								<div class="modal-content text-center">
									<%-- 삭제하기 --%>
									<div class="py-3 border-bottom">
										<a href="#" id="deleteCommentBtn"
											class="font30 font-weight-bold">삭제하기</a>
									</div>
								
									<%-- data-dismiss="modal"추가하면 모달 창 닫힘 --%>
									<div class="py-3 " data-dismiss="modal">
										<a href="#" class="font30 font-weight-bold">취소하기</a>
									</div>
								</div>
							</div>
						</div>
			
				</div>

			<%--댓글 달기 --%>
			<%-- 	<c:if test="${not empty userId}"> --%>
			<div class="d-flex mt-4 comment-write">
				<input type="text"
					class=" form-control mr-2 font30"
					placeholder="댓글 달기" />
				<button type="button" class="comment-btn btn btn-light font30"
					data-post-id="">등록</button>
			</div>

		</div>

</article>