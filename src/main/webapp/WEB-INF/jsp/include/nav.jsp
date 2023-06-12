<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<div class="ml-4 col-3">
				  
			</div> 
			<!-- side바 메뉴 -->
				<div class="d-flex align-items-center justify-content-around col-7 font30 font-weight-bold">
					<div><a href="/hiBook/hikorean_view">국내도서</a></div>
					<div><a href="/hiBook/hiforeign_view">국외도서</a></div>
					<div><a href="/hiBook/hiebook_view">e-Book</a></div>
					<input type="checkbox" id="menuicon"> <label for="menuicon"> 
					마이페이지
				</label>

				 <div class="sidebar">
					<div class="menu-tap d-flex m-3">
						<table class="table h-100 w-100" ">
							<thead>
								<tr>
									<th class="font50 font-weight-bold">MyPage</th>
									<c:if test="${empty loginId}">
										<th class="font30 font-weight-bold"><a href="/hiBook/user/sign_in_view">로그인</a></th>
										<th class="font30 font-weight-bold"><a href="/hiBook/user/sign_up_view">회원가입</a></th>
									</c:if>
									<c:if test="${not empty loginId}">
										<th class="font30 font-weight-bold"><a href="#">${loginId}</a></th>
										<th class="font30 font-weight-bold"><a
											href="/hiBook/user/sign_out">logout</a></th>
									</c:if>
								</tr>
							</thead>

							<tbody>
								<tr>
									<td colspan='3' class="font30 font-weight-bold pt-5"><a
										href="#"  >회원정보관리 </a></td>
								</tr>
								<tr>
									<td colspan='3' class="font20 font-weight-bold pt-5"><a
										href="/hiBook/mypage/user_information_view">개인정보수정</a></td>
								</tr>
								<tr>
									<td colspan='3' class="font20 font-weight-bold pt-5"><a
										href="/hiBook/mypage/my_review_view">마이리뷰 </a></td>
								</tr>

								<tr>
									<td colspan='3' class="font30 font-weight-bold pt-5"><a
										href="#">주문내역 </a></td>
								</tr>
								<tr>
									<td colspan='3' class="font20 font-weight-bold pt-5"><a
										href="/hiBook/mypage/cart_view">장바구니 </a></td>
								</tr>
								<tr>
									<td colspan='3' class="font20 font-weight-bold pt-5"><a
										href="/hiBook/order_inquiry_view">주문조회/반품신청</a></td>
								</tr>
								<tr>
									<td colspan='3' class="font20 font-weight-bold pt-5"><a
										href="/hiBook/order_return_view">반품내역 </a></td>
								</tr>
							
							</tbody>
						</table>
					</div>
				</div>
				</div>