<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container mx-auto" style="width: 600px;">
	<h1>Welcome ${name}!</h1>
	<div>
		<div>
			<a href="/list-todos">Manage my todo's</a>
		</div>
		<div>
			<a href="/list-todos-filter">Manage filter todo's (to demonstrate session user/last-filter-used)</a>
		</div>
	</div>
</div>
<%@ include file="common/scripts.jspf" %>
<%@ include file="common/footer.jspf" %>