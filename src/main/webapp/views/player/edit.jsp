<%--
  Created by IntelliJ IDEA.
  User: petka
  Date: 18.05.2017
  Time: 17:47
  To change this template use File | Settings | File Templates.
--%>
<%@include file="../header.jsp"%>

<h2>Edit "${player.firstName}"</h2>

<form method="post" action="${rc}/player/update" class="form-horizontal">
    <div class="form-group">
        <label for="firstName" class="col-sm-3 control-label">First Name</label>
        <div class="col-sm-9">
            <input type="text" class="form-control" id="firstName" name="firstName" placeholder="First Name" value="${player.firstName}">
        </div>
    </div>
    <div class="form-group">
        <label for="lastName" class="col-sm-3 control-label">Last name</label>
        <div class="col-sm-9">
            <input type="text" class="form-control" id="lastName" name="lastName" placeholder="Last Name" value="${player.lastName}">
        </div>
    </div>
    <div class="form-group">
        <label for="age" class="col-sm-3 control-label">Age</label>
        <div class="col-sm-9">
            <input type="text" class="form-control" id="age" name="age" placeholder="Name" value="${player.age}">
        </div>
    </div>
    <input type="hidden" name="id" value="${player.id}">
    <input type="submit" class="button btn-default" value="Save">
</form>

<%@include file="../footer.jsp"%>
