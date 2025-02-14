<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container mx-auto" style="width: 400px;">
	<h1>Enter Todo Details</h1>
	<div>
		<form:form method="POST" modelAttribute="todo">
			<fieldset class="mt-2 p-1">
				<form:label path="description">Description</form:label>
				<form:input class="mt-2 p-1" style="width:100%" path="description" type="text" 
					placeholder="Please enter description" required="required" />
				<form:errors path="description" cssClass="text-warning" />
			</fieldset>
			
			<fieldset class="mt-2 p-1">
				<form:label path="targetDate">Target Date</form:label>
				<form:input class="mt-2 p-1" style="width:100%" path="targetDate"  
					required="required" />
				<form:errors path="targetDate" cssClass="text-warning" />
			</fieldset>
			
			<fieldset class="mt-2 p-1">
				<form:input path="done" type="hidden" value="${todo.done}" />
				<form:input path="id" type="hidden" value="${todo.id}" />
				
				<input  style="width: 100%;" value="Save Todo" type="submit" class="btn btn-primary" />
			</fieldset>
		</form:form>
	</div>
</div>
<%@ include file="common/scripts.jspf" %>
<script type="text/javascript">
	$('#targetDate').datepicker({
		format: 'yyyy-mm-dd'
	});
</script>
<%@ include file="common/footer.jspf" %>