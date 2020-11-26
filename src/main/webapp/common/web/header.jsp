<%@page import="com.sharedoc247.model.UserModel"%>
<%@page import="com.sharedoc247.utils.SessionUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	<div class="container">
		<a class="navbar-brand" href="#">Chia sẻ tài liệu 247</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<c:if test="${not empty USERMODEL }">
					<li class="nav-item"><a class="nav-link"
						href="<c:url value='/tai-lieu?action=upload'/>">Tải lên tài liệu</a></li>
				</c:if>
				
				<c:if test="${not empty USERMODEL }">
					<li class="nav-item"><a class="nav-link"
						href="<c:url value='/tai-lieu'/>">Tài liệu của bạn</a></li>
				</c:if>
				
				<c:if test="${empty USERMODEL }">
					<li class="nav-item"><a class="nav-link"
						href="<c:url value='/dang-nhap?action=login'/>">Đăng nhập</a></li>
				</c:if>
				
				<c:if test="${empty USERMODEL }">
					<li class="nav-item"><a class="nav-link"
						href="<c:url value='/dang-ky?action=register'/>">Đăng ký</a></li>
				</c:if>
				
				<c:if test="${not empty USERMODEL }">
					<li class="nav-item"><a class="nav-link" href="#">
					Welcome,<% out.print(((UserModel)request.getSession().getAttribute("USERMODEL")).getFullName()); %></a>
					</li>
					<li class="nav-item"><a class="nav-link"
						href="<c:url value='/thoat?action=logout'/>">thoát</a>
					</li>
				</c:if>
			</ul>
		</div>
	</div>
</nav>
