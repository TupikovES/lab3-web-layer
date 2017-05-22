<%--
  Created by IntelliJ IDEA.
  User: petka
  Date: 18.05.2017
  Time: 17:47
  To change this template use File | Settings | File Templates.
--%>
<%@include file="../header.jsp"%>

<h2>Edit "${club.name}"</h2>

<form method="post" action="${rc}/clubs/update" class="form-horizontal">
    <div class="form-group">
        <label for="name" class="col-sm-3 control-label">Name club</label>
        <div class="col-sm-9">
            <input type="text" class="form-control" id="name" name="name" placeholder="Name" value="${club.name}">
        </div>
    </div>
    <div class="form-group">
        <label for="city" class="col-sm-3 control-label">City</label>
        <div class="col-sm-9">
            <input type="text" class="form-control" id="city" name="city" placeholder="City" value="${club.city}">
        </div>
    </div>
    <input type="hidden" name="id" value="${club.id}">
    <input type="submit" class="button btn-default" value="Save">
</form>

<%@include file="../footer.jsp"%>
