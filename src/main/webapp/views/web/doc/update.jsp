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
					<h2>Chỉnh sửa thông tin tài liệu</h2>
					<div class="form-group">
						<div class="form-row">
							<div class="col">
								<label>Tên tài liệu:</label> <input type="text"
									class="form-control" placeholder="Tên tài liệu" required
									name="documentName" value="${model.documentName}">
							</div>
						</div>
					</div>
					<div class="form-group">
						<label>Mô tả:</label>
						<TextArea type="text" class="form-control" required
							name="description"> ${model.description} </TextArea>
					</div>
					<%-- <div class="form-group">
						<label>Thể loại</label> ${model.categoryName} <select
							class="form-control">
							<option selected></option>
							<c:forEach var="item" items="${CATEGORIES }">
								<option>${item.categoryName }</option>>
							</c:forEach>
						</select>
					</div> --%>
					<div class="form-group">
						<button class="btn btn-success" type="submit">Cập nhật</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
</body>
</html>