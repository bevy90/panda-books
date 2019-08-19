<%-- 
    Document   : account
    Johns Hopkins University
    Web Application Development with Java
    Group project
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="includes/header.jsp" />

<section class="container">
    <div class="row">
        <div class="col-md-4 order-md-1">
            <h4 class="d-flex justify-content-between align-items-center mb-3">
                <span class="text-muted">${customer.firstName} ${customer.lastName}</span>
            </h4>
            
            <ul class="nav nav-pills flex-column">
                <li class="nav-item">
                  <a href="PandaBooksController?action=edit" class="nav-link">Edit account</a>
                </li>
                <li class="nav-item">
                  <a href="PandaBooksController?action=viewOrders" class="nav-link">My Orders</a>
                </li>
              </ul>
        </div>
            
        <div class="col-md-8 order-md-2">
            <c:choose>
                <c:when test="${customer.favoriteBooks.size() > 0}">
                    <section class="container">
                        <h4 class="mb-3">Favorite Books</h4>
                        <div class="row">
                            <c:forEach var="book" items="${customer.favoriteBooks}">
                                <div class="col-sm-4">
                                    <div class="card card-body mb-4 text-center">
                                        <h5 class="my-0 card-title text-uppercase font-weight-bold">${book.title}</h5>
                                        <a href="PandaBooksController?action=viewBook&AMP;bookId=${book.bookId}" class="card-link">
                                            <img class="card-img-bottom" src="${book.path}" class="img-responsive" style="width:100%" alt="Image">
                                        </a>
                                        <p class="card-text pricing-card-title font-weight-bold">$${book.price}</p>

                                        <ul class="nav nav-tabs card-header-tabs">
                                            <li class="nav-item">
                                                <a href="PandaBooksController?action=addToCart&AMP;bookId=${book.bookId}" class="nav-link">
                                                    <i class="fas fa-cart-plus fa-2x text-clipped"></i></a>
                                            </li>
                                            <li class="nav-item">
                                                <a href="PandaBooksController?action=removeFromFavorites&AMP;bookId=${book.bookId}" class="nav-link">
                                                    <i class="fas fa-minus-circle fa-2x text-clipped"></i></a>
                                            </li>
                                        </ul>
                                    </div>     
                                </div>
                            </c:forEach>
                        </div>
                    </section>
                </c:when>
                <c:otherwise>
                    <p>You have not added any books to your favorites. Click on the heart icon underneath a book to add it to your favorites.</p>
                    <a href="PandaBooksController?action=browse" class="btn btn-bg my-2">Browse books</a>
                </c:otherwise>
            </c:choose>
                    
            <c:choose>
                <c:when test="${customer.wishList.size() > 0}">
                    <section class="container">
                        <h1>Wish List</h1>
                        <div class="row">
                            <c:forEach var="book" items="${customer.wishList}">
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
                                            <li class="nav-item">
                                                <a href="PandaBooksController?action=removeFromWishList&AMP;bookId=${book.bookId}" class="nav-link"><i class="fas fa-minus-circle fa-2x text-clipped"></i></a>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </section>
                </c:when>
                <c:otherwise>
                    <p>You have not added any books to your wish list. Click on the plus icon underneath a book to add it to your wish list.</p>
                    <a href="PandaBooksController?action=browse" class="btn btn-bg my-2">Browse books</a>
                </c:otherwise>
            </c:choose>
                    
            <c:if test="${customer.recentVisit.size() > 0}">
                  <section class="container">
                    <h1>Recently visited</h1>
                    <div class="row">
                        <c:forEach var="book" items="${customer.recentVisit}">
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
                                    </ul>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </section>      
            </c:if>
        </div>
    </div>
</section>
<c:import url="includes/footer.jsp" />
