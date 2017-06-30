<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../header.jsp"%>

<h2>Import page</h2>

Message: ${message}
<form method="post" action="${rc}/xml/import" enctype="multipart/form-data">
    <div class="input-group">
        <div class="label">Import file:</div>
        <input type="file" name="file" id="file" />
        <input type="submit" value="Import"/>
    </div>
</form>
<p>File name: ${fileName}</p>

<%@include file="../footer.jsp"%>
