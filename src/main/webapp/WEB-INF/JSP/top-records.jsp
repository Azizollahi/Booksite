<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="layout" tagdir="/WEB-INF/tags"%>

<layout:Layout>
	<jsp:attribute name="title">Book reading fair share</jsp:attribute>
	<jsp:attribute name="header"><jsp:include page="navHeader.jsp"/></jsp:attribute>
	<jsp:body>
		<div class="card">
			<div class="card-content">
				<span class="card-title">Reading statistics</span>
					<table class="responsive-table striped highlight centered">
						<thead>
							<tr>
								<th>User Name</th>
								<th>Book Name</th>
								<th>Page</th>
								<th>Improvements</th>
								<th>Update time</th>
								<th>Last time update</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>Karami</td>
								<td>OOA</td>
								<td>At page 300</td>
								<td>+46 pages</td>
								<td>02/14/2019 08:34:12</td>
								<td>02/13/2019 18:20:00</td>
							</tr>
						</tbody>
					</table>
				<div class="section"></div>
				<div class="row">
					<div class="col s4">
						<label for="totalReadingOfTheDay"><span>Average reading on a day</span></label>
						<p id="totalReadingOfTheDay">1<%--#{totalReadingOfTheDay}--%></p>
					</div>
					<div class="col s4">
						<label for="totalReadingOfYesterday"><span>Total reading from last time</span></label>
						<p id="totalReadingOfYesterday">1<%--#{totalReadingOfTheDay}--%></p>
					</div>
					<div class="col s4">
						<label for="totalReadingOfTheWeek"><span>Total reading of the week</span></label>
						<p id="totalReadingOfTheWeek">2<%--#{totalReadingOfTheWeek}--%></p>
					</div>
					<div class="col s4">
						<label for="totalReadingOfTheMonth"><span>Total reading of the month</span></label>
						<p id="totalReadingOfTheMonth">3<%--#{totalReadingOfTheMonth}--%></p>
					</div>
					<div class="col s4">
						<label for="totalReadingOfTheYear"><span>Total reading of the year</span></label>
						<p id="totalReadingOfTheYear">4<%--#{totalReadingOfTheYear}--%></p>
					</div>
					<div class="col s4">
						<label for="totalReading"><span>Total reading</span></label>
						<p id="totalReading">5<%--#{totalReading}--%></p>
					</div>
				</div>
			</div>
		</div>
	</jsp:body>

</layout:Layout>