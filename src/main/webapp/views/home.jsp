<%--
  Created by IntelliJ IDEA.
  User: petka
  Date: 24.03.2017
  Time: 3:58
  To change this template use File | Settings | File Templates.
--%>

<%@include file="header.jsp"%>

<div class="jumbotron">
    <h1>Hello, Welcome to the Football Clubs!</h1>
    <p>You can add clubs, divisions and players. And also to carry out their search.</p>
    <p><a class="btn btn-primary btn-lg" href="${rc}/clubs" role="button">Get Clubs</a></p>
</div>

<p class="text-info">
    <p>Added export and import support</p>
    <p>Click to import : <a class="" href="${rc}/xml/import"><button class="btn btn-default">Import...</button></a></p>
</div>

<%@include file="footer.jsp"%>
