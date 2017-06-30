<%--
  Created by IntelliJ IDEA.
  User: petka
  Date: 16.05.2017
  Time: 22:06
  To change this template use File | Settings | File Templates.
--%>
<%@include file="../header.jsp"%>
<h2>Search result for "${query}"</h2>
<hr>
<table class="table">
    <caption>Result list</caption>
    <thead>
    <tr>
        <th>Name</th>
        <th>Type</th>
        <th>param</th>
        <th>value</th>
        <th></th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="result" items="${results}">
        <tr>
            <th><c:out value="${result.name}"/></th>
            <th>${result.objectType}</th>
            <th>${result.attributeName}</th>
            <th>${result.stringValue} ${result.intValue}</th>
            <th><a href="${rc}/xml/${result.id}" target="_blank">View XSTL</a></th>
            <th><a href="${rc}/xml/export/${result.id}" target="_blank">export</a></th>
        </tr>
    </c:forEach>
    </tbody>

</table>
<%@include file="../footer.jsp"%>
