<%--
  Created by IntelliJ IDEA.
  User: petka
  Date: 28.03.2017
  Time: 9:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../header.jsp"%>
<%@include file="../modal_add_club.jsp"%>
<spring:url value="/views/club/js/club.js" var="modal_js"/>
<script src="${modal_js}" type="text/javascript" ></script>
    <h2>Clubs page</h2>
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
    Add club...
</button>
<table class="table">
    <caption>Club list</caption>
    <thead>
    <tr>
        <th>Name</th>
        <th>City</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    </thead>

    <tbody>
    </tbody>

</table>

<%@include file="../footer.jsp"%>

