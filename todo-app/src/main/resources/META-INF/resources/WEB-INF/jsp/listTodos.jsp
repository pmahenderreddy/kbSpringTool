<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
	<h1>Welcome ${name}!</h1>
	<h1>Your todos</h1>
	<div>
		<div>
			<!--<span>Filtering by: ${filter == "" || filter == null ? "all" : filter}</span>
			<span> |..| </span>-->
			<span>Number of todos : ${todos.size()}</span>
		</div>
		<hr>
		
		<table class="table">
			<thead>
				<tr>
					<th>Name</th>
					<th>Descripiton</th>
					<th>Target Date</th>
					<th>IsDone</th>
					<th class="text-center">Actions</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach var="item" items="${todos}">
				<tr>
					<td>${item.username}</td>
					<td>${item.description}</td>
					<td>${item.targetDate}</td>
					<td>${item.done}</td>
					<td class="text-center">
						<a href="update-todo?id=${item.id}" class="btn btn-primary">Update</a>
						<a href="delete-todo?id=${item.id}" class="btn btn-warning">Delete</a>
					</td>
				</tr>
				</c:forEach>
				<c:if test="${todos.size() == 0}">
					<tr><td colspan="5" class="text-center">No todos</td></tr>
				</c:if>
			</tbody>
		</table>
		
		<div>
			<a href="add-todo" class="btn btn-success">Add Todo</a>
		</div>
	</div>
</div>
<%@ include file="common/scripts.jspf" %>
<%@ include file="common/footer.jspf" %>