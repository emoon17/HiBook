<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<table id="reviewBox" class="table h-100 w-100 font30 mt-5 text-center">
	<thead>
		<tr>
			<th>작성일</th>
			<th>책 제목</th>
			<th>내용</th>
			<th>선택</th>
		</tr>
	</thead>
	<c:if test="${empty loginId}">
	<tbody>
		<tr>
			<td></td>
			<td class="font-weight-bold">로그인 시 사용 가능합니다.</td>
		</tr>
	</tbody>
	</c:if>
	<c:if test="${not empty loginId}">
	<c:forEach items="${myReviewViewList}" var="myReviewView">
		<tbody>
			<tr>
				<td class="text-center">${myReviewView.review.createdAt}</td>
				<td class="text-center">${myReviewView.title}</td>
				<td class="text-center">${myReviewView.review.content}</td>
				<td class="text-center"><input type="checkbox" name="check" value="${myReviewView.review.id}" style="width: 40px; height: 40px;"></td>
			</tr>
		</tbody>
	</c:forEach>
	</c:if>
</table>