<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="layout" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="layout" tagdir="/WEB-INF/tags"%>

<layout:Layout>
	<jsp:attribute name="title">Book reading fair share</jsp:attribute>
	<jsp:attribute name="header"><jsp:include page="navHeader.jsp"/></jsp:attribute>
	<jsp:attribute name="scripts">
		<script>
			document.addEventListener('DOMContentLoaded', function() {
				var elems = document.querySelectorAll('select');
				var instances = M.FormSelect.init(elems);
			});
		</script>
	</jsp:attribute>
	<jsp:body>
		<div class="card">
			<div class="card-content">
				<span class="card-title">Register a new record</span>
				<form action="/profile/newRecord" method="post">
					<div class="row">
						<div class="col m6 input-field" >
							<select>
								<option value="" disabled selected>Choose your option</option>
								<option value="1">Option 1</option>
								<option value="2">Option 2</option>
								<option value="3">Option 3</option>
							</select>
							<label>
								Choose a Book
							</label>
						</div>
						<div class="col m6 input-field">
							<input name="Improvements" id="improvement_pages" type="number" class="validate">
							<label for="improvement_pages">Improvement Pages</label>
						</div>
					</div>
					<button class="btn waves-effect green" type="submit"><i class="material-icons right">send</i></button>
				</form>
			</div>
		</div>
	</jsp:body>
</layout:Layout>