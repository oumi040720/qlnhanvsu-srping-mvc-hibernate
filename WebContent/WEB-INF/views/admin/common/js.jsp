<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<script src='<c:url value="/template/admin/vendor/jquery/jquery.min.js"/>'></script>
<script src='<c:url value="/template/admin/vendor/bootstrap/js/bootstrap.min.js"/>'></script>
<script src='<c:url value="/template/admin/vendor/jquery-slimscroll/jquery.slimscroll.min.js"/>'></script>
<script src='<c:url value="/template/admin/vendor/jquery.easy-pie-chart/jquery.easypiechart.min.js"/>'></script>
<script src='<c:url value="/template/admin/vendor/chartist/js/chartist.min.js"/>'></script>
<script src='<c:url value="/template/admin/scripts/klorofil-common.js"/>'></script>


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
