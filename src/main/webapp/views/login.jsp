<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Đăng nhập</title>
</head>
<body>
	<div class="container">
		<div class="d-flex justify-content-center h-100">
			<div class="card">
				<div class="card-header">
					<h3>Đăng nhập</h3>
					<div class="d-flex justify-content-end social_icon">
						<span><i class="fab fa-facebook-square"></i></span> <span><i
							class="fab fa-google-plus-square"></i></span> <span><i
							class="fab fa-twitter-square"></i></span>
					</div>
				</div>
				<div class="card-body">
					<form action="<c:url value='/dang-nhap?action=login'/>"
						method="post">
						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-user"></i></span>
							</div>
							<input type="text" class="form-control" name="username"
								placeholder="username">

						</div>
						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-key"></i></span>
							</div>
							<input type="password" class="form-control" name="password"
								placeholder="password">
						</div>
						<!-- <div class="row align-items-center remember">
						<input type="checkbox">Lưu tài khoản
					</div> -->
						<br />
						<br />
						<div class="form-group">
							<input type="submit" value="Đăng nhập"
								class="btn float-right login_btn">
						</div>
					</form>
				</div>
				<div class="card-footer">
					<div class="d-flex justify-content-center links">
						Bạn chưa có tài khoản?<a
							href="<c:url value='/dang-ky?action=register'/>">Đăng ký</a>
					</div>
					<div class="d-flex justify-content-center">
						<a href="#">Quên mật khẩu?</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>