<%--
  Created by IntelliJ IDEA.
  User: petka
  Date: 12.05.2017
  Time: 8:33
  To change this template use File | Settings | File Templates.
--%>
<%@include file="../header.jsp"%>
<%@include file="../modal_add_player.jsp"%>

<spring:url value="/views/player/js/player.js" var="modal_js"/>
<script src="${modal_js}" type="text/javascript"></script>

<h2>Players from ${division.name}</h2>
${breadcrumb}
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#playerModal">
    Add player...
</button>

<table class="table">
    <caption>Player list</caption>
    <thead>
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Age</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="player" items="${players}">
        <tr>
            <th><a href="${rc}/player/view/${player.id}"><c:out value="${player.firstName}"/></a></th>
            <th><a href="${rc}/player/view/${player.id}"><c:out value="${player.lastName}"/></a></th>
            <th><c:out value="${player.age}"/></th>
            <th><a href="${rc}/player/edit/${player.id}"><span class="glyphicon glyphicon-pencil"></span></a></th>
            <th><a href="${rc}/player/del/${player.id}"><span class="glyphicon glyphicon-remove"></span></a></th>
        </tr>
    </c:forEach>
    </tbody>

</table>

<%@include file="../footer.jsp"%>
