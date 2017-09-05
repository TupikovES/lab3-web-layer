<%--
  Created by IntelliJ IDEA.
  User: petka
  Date: 28.03.2017
  Time: 9:33
  To change this template use File | Settings | File Templates.
--%>
<%@include file="../header.jsp"%>
<%@include file="../modal_add_club.jsp"%>
<spring:url value="/views/club/js/club.js" var="modal_js"/>
<script src="${modal_js}" type="text/javascript" ></script>
    <h2>Clubs page</h2>
<div>
    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
        Add club...
    </button>
</div>
<form method="post" action="${rc}/clubs/rename" class="navbar-form navbar-left">
    <div class="form-group">
        <div class="input-group">
            <span class="input-group-addon">Specify a suffix for objects[suffix]-[name]</span>
            <input type="text" name="suffix" class="form-control" id="suffix" placeholder="[suffix]">
            <span class="input-group-btn">
                <button type="submit" id="rename" class="btn btn-default">Rename</button>
            </span>
        </div>
    </div>

</form>
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
    <c:forEach var="club" items="${clubs}">
        <tr>
            <th><a href="${rc}/division/views/${club.id}"><c:out value="${club.name}"/></a></th>
            <th><c:out value="${club.city}"/></th>
            <th><a href="${rc}/clubs/edit/${club.id}"><span class="glyphicon glyphicon-pencil"></span></a></th>
            <th><a href="${rc}/clubs/del/${club.id}"><span class="glyphicon glyphicon-remove"></span></a></th>
        </tr>
    </c:forEach>
    </tbody>

</table>

<%@include file="../footer.jsp"%>

