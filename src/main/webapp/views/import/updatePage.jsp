<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../header.jsp"%>

<h2>Update object</h2>

<p>Old object</p>
<div>id: ${oldObject.objectId}</div>
<div>Name: ${oldObject.objectName}</div>
<div>Parent: ${oldObject.objectParent}</div>
<div>Type: ${oldObject.objectType}</div>
<c:forEach var="param" items="${oldParamList}">
    <div>Param: ${param.stringValue}
        <c:if test="${param.numberValue == 0}">
            <c:out value="${param.numberValue}"/>
        </c:if>
    </div>
</c:forEach>

<hr/>

<p>New object</p>
<div>id: ${newObject.objectId}</div>
<div>Name: ${newObject.objectName}</div>
<div>Parent: ${newObject.objectParent}</div>
<div>Type: ${newObject.objectType}</div>
<c:forEach var="param" items="${newParamList}">
    <div>Param: ${param.stringValue}
        <c:if test="${param.numberValue == 0}">
            <c:out value="${param.numberValue}"/>
        </c:if>
    </div>
</c:forEach>

<div>
    <form action="${rc}/xml/update" method="post">
        <input type="submit" value="Update"/>
        <a href="${rc}/xml/import?message=Canceled">Cancel</a>
    </form>
</div>

<%@include file="../footer.jsp"%>