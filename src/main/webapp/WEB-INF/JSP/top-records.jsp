<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="layout" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="topRecord" scope="request" type="application.models.TopRecordsModel"/>

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
							<c:forEach var = "i" begin = "0" end = "${topRecord.record.size()-1}">
								<tr>
									<td>${topRecord.record.get(i).readerName}</td>
									<td>${topRecord.record.get(i).bookName}</td>
									<td>${topRecord.record.get(i).pageNumber}</td>
									<td>${topRecord.record.get(i).improvement}</td>
									<td>${topRecord.record.get(i).updateTime}</td>
									<td>${topRecord.record.get(i).lastUpdate}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				<div class="section"></div>
				<div class="row">
					<div class="col s4">
						<label for="averageReadingOnADay"><span>Average reading on a day</span></label>
						<p id="averageReadingOnADay">${topRecord.averageReading}</p>
					</div>
					<div class="col s4">
						<label for="totalReadingOfYesterday"><span>Total reading from last time</span></label>
						<p id="totalReadingOfYesterday">${topRecord.totalReadingOfTheDay}</p>
					</div>
					<div class="col s4">
						<label for="totalReadingOfTheWeek"><span>Total reading of the week</span></label>
						<p id="totalReadingOfTheWeek">${topRecord.totalReadingOfTheWeek}</p>
					</div>
					<div class="col s4">
						<label for="totalReadingOfTheMonth"><span>Total reading of the month</span></label>
						<p id="totalReadingOfTheMonth">${topRecord.totalReadingOfTheMonth}</p>
					</div>
					<div class="col s4">
						<label for="totalReadingOfTheYear"><span>Total reading of the year</span></label>
						<p id="totalReadingOfTheYear">${topRecord.totalReadingOfTheYear}</p>
					</div>
					<div class="col s4">
						<label for="totalReading"><span>Total reading</span></label>
						<p id="totalReading">${topRecord.totalReading}</p>
					</div>
				</div>
			</div>
		</div>
	</jsp:body>

</layout:Layout>