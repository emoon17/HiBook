<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
					<div><a href="#">국내도서</a></div>
					<div><a href="#">국외도서</a></div>
					<div><a href="#">e-Book</a></div>
					<div><a href="#">마이페이지</a></div>
				</div>