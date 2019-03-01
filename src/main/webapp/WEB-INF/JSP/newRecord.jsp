<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="layout" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="newRecord" scope="request" type="application.models.NewRecordModel"/>

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
							<select name="selectedBook">
								<option value="" disabled selected>Select a book</option>
								<c:forEach var="bookName" items="${newRecord.books}">
									<option value="${bookName}">${bookName}</option>
								</c:forEach>
							</select>
							<label>
								Choose a Book
							</label>
						</div>
						<div class="col m6 input-field">
							<input name="pageNumber" id="page-number" type="number" class="validate">
							<label for="page-number">Write the page number that you recorded so far</label>
						</div>
					</div>
					<div class="row">
						<div class="col s12 m2 push-m10 right-align">
							<button class="btn waves-effect green" type="submit"><i class="material-icons right">send</i></button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</jsp:body>
</layout:Layout>