<%--
  Created by IntelliJ IDEA.
  User: petka
  Date: 26.12.2016
  Time: 9:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="rc" value="<%=request.getContextPath()%>" />
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>${title}</title>
    <!-- Bootstrap
    <link href="css/bootstrap.min.css" rel="stylesheet"> -->
    <spring:url value="/views/resources/css/bootstrap.css" var="bootstrap"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <link href="${bootstrap}" rel="stylesheet" />

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>
    <header>
        <nav class="navbar navbar-default">
            <div class="container-fuild">
                <div class="navbar-header">
                    <a class="navbar-brand" href="${rc}">NetCracker</a>
                </div>
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li><a href="${rc}/clubs">Catalog</a></li>
                    </ul>
                </div>
                <form method="get" action="${rc}/search" class="navbar-form navbar-left">
                    <div class="form-group">
                        <input type="search" name="query" class="form-control" id="query" placeholder="Search">
                    </div>
                    <button type="submit" id="search" class="btn btn-default">Submit</button>
                </form>
            </div>
        </nav>
    </header>

    <div class="container">