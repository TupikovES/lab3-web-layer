<%--
  Created by IntelliJ IDEA.
  User: petka
  Date: 13.04.2017
  Time: 9:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../header.jsp"%>

<%@include file="../modal_add_division.jsp"%>
<spring:url value="/views/division/js/division.js" var="modal_js"/>
<script src="${modal_js}" type="text/javascript" ></script>
<h2>Divisions from ${club.name}</h2>
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#divisionModal">
    Add club...
</button>
<table class="table">
    <caption>Division list</caption>
    <thead>
    <tr>
        <th>Name</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="division" items="${divisions}">
        <tr>
            <th><a href="${rc}/player/view/${division.id}"><c:out value="${division.name}"/></a></th>
            <th><a href="${rc}/division/edit/${division.id}"><span class="glyphicon glyphicon-pencil"></span></a></th>
            <th><a href="${rc}/division/del/${division.id}"><span class="glyphicon glyphicon-remove"></span></a></th>
        </tr>
    </c:forEach>
    </tbody>

</table>

<%@include file="../footer.jsp"%>
