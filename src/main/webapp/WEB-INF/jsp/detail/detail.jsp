<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:forEach items="${inquiryBookList}" var ="inquiryBook">
<article class="pt-5">
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

</article>
<div class="line"></div>
<article>
	<%-- 댓글 목록 --%>
		<div class="card-comment-list mt-5">
			<%-- 댓글내용 --%>
			<c:forEach items="${reviewViewList}" var="reviewView">
				<div class="card-comment  d-flex justify-content-between m-3">
					<div class="font-weight-bold font30 ">
						${reviewView.user.loginId}<span class="ml-3">:</span> <span
							id="content" class="font30 ml-3">${reviewView.review.content}</span>
					</div>

					<%-- <%-- 모달로 댓글 삭제하기 --%>
						<img src="/static/image/delete.png"
							class="mt-1 more-btn write-area"
							data-toggle="modal" data-target="#modal"
							data-isbn13-id="${reviewView.review.isbn13}"
							data-comment-content="${reviewView.review.content}"
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
			
</c:forEach>
				</div>
			<%--댓글 달기 --%>
			<%-- 	<c:if test="${not empty userId}"> --%>
			<div class="d-flex mt-4 comment-write">
				<input type="text"
					class=" form-control mr-2 font30"
					placeholder="댓글 달기" />
				<button type="button" class="comment-btn btn btn-light font30"
					data-isbn13-id="${inquiryBook.isbn13}">등록</button>
			</div>
		</c:forEach>
		</div>
</article>

<script>
	$(document).ready(function(){
		
		//댓글 게시 버튼 눌렀을 때
		$('.comment-btn').on('click', function() {

			let isbn13 = $(this).data('isbn13-id');
		
			// 지금 클릭 된 게시버튼 근처에 있는 형제의 input을 가져온다. : siblings
			let content = $(this).siblings('input').val();
			if (content == '') {
				alert("댓글을 입력하여주세요.");
				return;
			}
			//alert(content);

			//ajax
			$.ajax({
				type : 'put',
				url : '/hiBook/hi_detail/comment_create',
				data : {
					"isbn13" : isbn13,
					"content" : content
				}

				,
				success : function(data) {
					if (data.code == 1) {
						alert("댓글을 등록하였습니다.");
						document.location.reload();
					} else {
						alert(data.errorMessage);
					}
				},
				error : function(e) {
					alert("오류가 발생했습니다.")
				}
			});
		}) // comment-btn end
		
		$(".more-btn").on('click', function() {
			//getting
			let isbn13 = $(this).data('isbn13-id');
			let content = $(this).data('comment-content');
		//	alert(isbn13);
		//	alert(content);
			$("#modal").data("isbn13", isbn13);
			$("#modal").data("content", content);
			//setting
			
		});
		
		$('#deleteCommentBtn').on('click', function(e) {
			e.preventDefault();
			
			let isbn13 = $("#modal").data('isbn13');
			let content = $('#modal').data("content");
			//alert(content);
			
			$.ajax({
				//request
				type : 'delete'
				, url : '/hiBook/hi_detail/comment_delete'
				, data : {
					"isbn13" : isbn13,
					"content" : content
				}
				,success : function(data) {
					if (data.code == 1) {
						alert("댓글을 삭제하였습니다.");
						document.location.reload();
					} else {
						alert("댓글 삭제에 실패하였습니다.");
					}
				},
				error : function(e) {
					alert("오류가 발생했습니다.")
				}
			});
		
		});
		
		
		
		
		
	}); /* document */
</script>