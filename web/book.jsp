<%-- 
    Document   : book
    Johns Hopkins University
    Web Application Development with Java
    Group project
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="includes/header.jsp" />

<section class="container">
    <div class="row">
        <div class="col-sm-4">
            <div class="card card-body mb-4 text-center">
                <h5 class="my-0 card-title text-uppercase font-weight-bold">${book.title}</h5>
                <a href="PandaBooksController?action=viewBook&AMP;bookId=${book.bookId}" class="card-link">
                    <img class="card-img-bottom" src="${book.path}" class="img-responsive" style="width:100%" alt="Image">
                </a>
                <p class="card-text pricing-card-title font-weight-bold">$${book.price}</p>
                <ul class="nav nav-tabs card-header-tabs">
                    <li class="nav-item">
                        <a href="PandaBooksController?action=addToCart&AMP;bookId=${book.bookId}" class="nav-link"><i class="fas fa-cart-plus fa-2x text-clipped"></i></a>
                    </li>
                    <c:if test="${not empty customer}">
                        <li class="nav-item">
                            <a href="PandaBooksController?action=addToFavorites&AMP;bookId=${book.bookId}" class="nav-link"><i class="fas fa-heart fa-2x text-clipped"></i></a>
                        </li>
                        <li class="nav-item">
                            <a href="PandaBooksController?action=addToWishList&AMP;bookId=${book.bookId}" class="nav-link"><i class="fas fa-plus-circle fa-2x text-clipped"></i></a>
                        </li>
                    </c:if>
                </ul>
            </div>
        </div>
          
        <div class="col-sml-8">
            <div class="card card-body mb-4">
                <p class="card-text font-weight-normal">${book.description}</p>
            </div>
        </div>
    </div>
</section>

<c:import url="includes/footer.jsp" />
