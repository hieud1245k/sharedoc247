<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
</head>
<body>
	<br>
	<br>
	<br>
	<div class="container">
		<div class="row">
			<div class="col-md-5">
				<form>
					<h2>Nhập thông tin tài liệu</h2>
					<div class="form-group">
						<div class="form-row">
							<div class="col">
								<label>Tên tài liệu:</label> <input type="text"
									class="form-control" placeholder="Tên tài liệu" required
									name="documentName">
							</div>
						</div>
					</div>
					<div class="form-group">
						<label>Mô tả:</label>
						<TextArea type="text" class="form-control" required
							name="description"> </TextArea>
					</div>
					<div class="form-group">
						<label for="exampleFormControlFile1">File tải lên</label> <input
							type="file" class="form-control-file"
							id="exampleFormControlFile1">
					</div>
					<div class="form-group">
						<label>Thể loại</label> <select class="form-control">
							<option selected>Loại tài liệu</option>
							<option>TPHCM</option>
							<option>Hà Nội</option>
							<option>Khác</option>
						</select>
					</div>
					<div class="form-group">
						<button class="btn btn-success" type="submit">Tải lên</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<br>
	<br>
	<br>
</body>
</html>