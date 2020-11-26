<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><dec:title default="Trang chủ" /></title>
<!-- css -->
<link
	href="<c:url value='/template/web/bootstrap/css/bootstrap.min.css'/>"
	rel="stylesheet" type="text/css" media="all" />
<link href="<c:url value='/template/web/css/style.css'/>"
	rel="stylesheet" type="text/css" media="all" />

<link
	href="<c:url value='/template/web/vendor/bootstrap/css/bootstrap.min.css'/>"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="<c:url value='/template/web/css/scrolling-nav.css'/>"
	rel="stylesheet">

		<script src="<c:url value='/template/admin/js/jquery-2.1.4.min.js'/>"></script>
		<script src="<c:url value='/template/admin/js/bootstrap.min.js'/>"></script>
		<script src="<c:url value='/template/paging/jquery.twbsPagination.js'/>" type="text/javascript"></script>

</head>
<body>
	<!-- header -->
	<%@include file="/common/web/header.jsp"%>
	<!-- header -->
	<div class="container-full">
		<dec:body />
	</div>
	<!-- footer -->
	<%@include file="/common/web/footer.jsp"%>
	<!-- footer -->
	<script type="text/javascript"
		src="<c:url value='/template/web/jquery/jquery.min.js'/>"></script>

	<script type="text/javascript"
		src="<c:url value='/template/web/bootstrap/js/bootstrap.bundle.min.js'/>"></script>

	<%-- <script
		src="<c:url value='/template/web/vendor/jquery/jquery.min.js'/>"></script>
	<script
		src="<c:url value='/template/web/vendor/bootstrap/js/bootstrap.bundle.min.js'/>"></script>

	<!-- Plugin JavaScript -->
	<script
		src="<c:url value='/template/web/vendor/jquery-easing/jquery.easing.min.js'/>"></script>

	<!-- Custom JavaScript for this theme -->
	<script src="<c:url value='/template/web/js/scrolling-nav.js'/>"></script> --%>
</body>
</html>