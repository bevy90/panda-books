<%-- 
    Document   : book
    Created on : Jul 22, 2019, 12:03:00 AM
    Author     : bever
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="includes/header.jsp" />

<section class="container">
    <div class="panel panel-primary">
        <div class="panel-heading">${book.title}</div>
        <div class="panel-body"><img src="${book.path}" class="img-responsive" style="width:100%" alt="Image"></div>
        <div class="panel-footer">${book.price}
            <form action="PandaBooksController" method="post">
                <input type="hidden" name="bookId" value="${book.bookId}">
                <input type="hidden" name="action" value="addToCart">
                <input type="submit" value="Add To Cart">
            </form>
        </div>
    </div>
    <p>${book.description}</p>
</section>

<c:import url="includes/footer.jsp" />
