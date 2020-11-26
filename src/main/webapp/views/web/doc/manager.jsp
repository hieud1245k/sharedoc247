<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
</head>
<body>
	<div class="container">

		<div class="row">

			<!-- Blog Entries Column -->
			<div class="col-md-8">

				<h1 class="my-4">
					Tài liệu của tôi
					<!--     <small>được đề xuất</small> -->
				</h1>

				<!-- Blog Post -->
				<div class="card mb-4">
					<div class="card-body">
						<img src=<c:url value='/template/web/image/pdf.png'/> width="30"
							height="30" alt="Card image cap">
						<h2 class="card-title">name</h2>
						<p class="card-text">description</p>
						<a href="#" class="btn btn-primary">View &rarr;</a>
					</div>
					<div class="card-footer text-muted">Created_at</div>
				</div>

				<c:forEach var="item" items="${model.listResult }">
					<!-- Blog Post -->
					<div class="card mb-4">
						<div class="card-body">
							<img src=<c:url value='/template/web/image/pdf.png'/> width="30"
								height="30" alt="Card image cap">
							<h2 class="card-title">${item.documentName}</h2>
							<p class="card-text">${item.description}</p>

							<a href="<c:url value='/show?id=${item.id }' />"
								class="btn btn-primary">Xem &rarr;</a> <a
								href="<c:url value='/tai-lieu?id=${item.id }&action=update' />"
								class="btn btn-primary">Sửa thông tin &rarr;</a> <a
								href="<c:url value='/api-document?id=${item.id }&action=delete' />"
								class="btn btn-primary">Xóa &rarr;</a>
						</div>
						<div class="card-footer text-muted">Thời gian đăng:
							${item.createdAt }</div>
					</div>
				</c:forEach>

				<ul class="pagination" id="pagination"></ul>


			</div>

			<!-- Sidebar Widgets Column -->
			<div class="col-md-4">

				<!-- Search Widget -->
				<div class="card my-4">
					<h5 class="card-header">Search</h5>
					<div class="card-body">
						<div class="input-group">
							<input type="text" class="form-control"
								placeholder="Search for..."> <span
								class="input-group-append">
								<button class="btn btn-secondary" type="button">Go!</button>
							</span>
						</div>
					</div>
				</div>

				<!-- Categories Widget -->
				<div class="card my-4">
					<h5 class="card-header">Categories</h5>
					<div class="card-body">
						<div class="row">
							<div class="col-lg-6">
								<ul class="list-unstyled mb-0">
									<li><a href="#">Web Design</a></li>
									<li><a href="#">HTML</a></li>
									<li><a href="#">Freebies</a></li>
								</ul>
							</div>
							<div class="col-lg-6">
								<ul class="list-unstyled mb-0">
									<li><a href="#">JavaScript</a></li>
									<li><a href="#">CSS</a></li>
									<li><a href="#">Tutorials</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>


			</div>

		</div>
		<!-- /.row -->

	</div>
	<!-- /.container -->

	<script type="text/javascript">
		var currentPage = $
		{
			model.page
		};
		var totalPages = $
		{
			model.totalPage
		};
		var limit = 2;
		$(function() {
			window.pagObj = $('#pagination').twbsPagination({
				totalPages : totalPages,
				visiblePages : 10,
				startPage : currentPage,
				onPageClick : function(event, page) {
					// console.info(page + ' (from options)');
					if (currentPage != page) {
						$('#maxPageItem').val(limit);
						$('#page').val(page);
						$('#sortName').val('title');
						$('#sortBy').val('desc');
						$('#formSubmit').submit();
					}
				}
			}).on('page', function(event, page) {
				console.info(page + ' (from event listening)');
			});
		});
	</script>

</body>
</html>