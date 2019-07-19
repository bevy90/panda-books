<%-- 
    Document   : account
    Created on : Jul 12, 2019, 3:02:36 PM
    Author     : bever
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="includes/header.jsp" />

<c:choose>
    <c:when test="${not empty customer}">
        <p>You are logged in</p>
        <form action="PandaBooksController" method="post">
            <input type="hidden" name="action" value="logout">
            <input type="submit" value="Logout">
        </form>
    </c:when>
    <c:otherwise>
        <p>You are not logged in</p>
        <form action="PandaBooksController" method="post">
            <input type="hidden" name="action" value="login">
            <input type="submit" value="Log in">
        </form>
        <form action="PandaBooksController" method="post">
            <input type="hidden" name="action" value="register">
            <input type="submit" value="Register">
        </form>
    </c:otherwise>
</c:choose>

<c:import url="includes/footer.jsp" />
