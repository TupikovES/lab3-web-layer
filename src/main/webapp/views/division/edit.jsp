<%--
  Created by IntelliJ IDEA.
  User: petka
  Date: 18.05.2017
  Time: 17:47
  To change this template use File | Settings | File Templates.
--%>
<%@include file="../header.jsp"%>

<h2>Edit "${division.name}"</h2>

<form method="post" action="${rc}/division/update" class="form-horizontal">
    <div class="form-group">
        <label for="name" class="col-sm-3 control-label">Name division</label>
        <div class="col-sm-9">
            <input type="text" class="form-control" id="name" name="name" placeholder="Name" value="${division.name}">
        </div>
    </div>
    <input type="hidden" name="id" value="${division.id}">
    <input type="submit" class="button btn-default" value="Save">
</form>

<%@include file="../footer.jsp"%>
