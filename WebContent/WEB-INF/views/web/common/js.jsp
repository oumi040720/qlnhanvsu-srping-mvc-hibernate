<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<script src="<c:url value="/template/web/js/jquery.min.js" />"></script>
<script src="<c:url value="/template/web/js/bootstrap.bundle.min.js" />"></script>
<script src="<c:url value="/template/web/js/isotope.pkgd.min.js" />"></script>
<script src="<c:url value="/template/web/js/stickyfill.min.js" />"></script>
<script src="<c:url value="/template/web/js/jquery.fancybox.min.js" />"></script>
<script src="<c:url value="/template/web/js/jquery.easing.1.3.js" />"></script>
<script src="<c:url value="/template/web/js/jquery.waypoints.min.js" />"></script>
<script src="<c:url value="/template/web/js/jquery.animateNumber.min.js" />"></script>
<script src="<c:url value="/template/web/js/owl.carousel.min.js" />"></script>

<script src="<c:url value="/template/web/js/bootstrap-select.min.js" />"></script>

<script src='<c:url value="/template/paging/jquery.twbsPagination.js" />'></script>

<!-- Language -->
<script>
	$(function(){
		$("a[data-lang]").click(function(){
			var lang = $(this).attr("data-lang");
			var url = $(location).attr('pathname');
			$.get(url + "?language="+ lang, function(){
				location.reload();
			});
			
			return false;
		});
	});
</script>
