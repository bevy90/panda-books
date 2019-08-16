<%-- 
    Document   : account
    Created on : Jul 12, 2019, 3:02:36 PM
    Author     : bever
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="includes/header.jsp" />

<section class="container">
    <h1>Favorite Books</h1>
    <div class="row">
        <c:forEach var="book" items="${customer.favoriteBooks}">
            <div class="col-sm-4">
                        <div class="panel panel-primary">
                            <div class="panel-heading">${book.title}</div>
                            <a href="PandaBooksController?action=viewBook&AMP;id=${book.bookId}"><div class="panel-body"><img src="${book.path}" class="img-responsive" style="width:100%" alt="Image"></div></a>
                            <div class="panel-footer">${book.price}
                                <form action="PandaBooksController" method="post">
                                    <input type="hidden" name="bookId" value="${book.bookId}">
                                    <input type="hidden" name="action" value="removeFromFavorites">
                                    <input type="submit" value="Remove From Favorite">
                                </form>
                
                                <form action="PandaBooksController" method="post">
                                    <input type="hidden" name="bookId" value="${book.bookId}">
                                    <input type="hidden" name="action" value="addToCart">
                                    <input type="submit" value="Add To Cart">
                                </form>
                            </div>
                        </div>
                    </div>
        </c:forEach>
    </div>
</section>

<section class="container">
    <h1>Wish List</h1>
    <div class="row">
        <c:forEach var="book" items="${customer.wishList}">
            <div class="col-sm-4">
                        <div class="panel panel-primary">
                            <div class="panel-heading">${book.title}</div>
                            <a href="PandaBooksController?action=viewBook&AMP;id=${book.bookId}"><div class="panel-body"><img src="${book.path}" class="img-responsive" style="width:100%" alt="Image"></div></a>
                            <div class="panel-footer">${book.price}
                                <form action="PandaBooksController" method="post">
                                    <input type="hidden" name="bookId" value="${book.bookId}">
                                    <input type="hidden" name="action" value="removeFromWishList">
                                    <input type="submit" value="Remove From wish list">
                                </form>
                                    
                                <form action="PandaBooksController" method="post">
                                    <input type="hidden" name="bookId" value="${book.bookId}">
                                    <input type="hidden" name="action" value="addToCart">
                                    <input type="submit" value="Add To Cart">
                                </form>
                            </div>
                        </div>
                    </div>
        </c:forEach>
    </div>
</section>

<section class="container">
    <h1>Recently visited</h1>
    <div class="row">
        <c:forEach var="book" items="${customer.recentVisit}">
            <div class="col-sm-4">
                        <div class="panel panel-primary">
                            <div class="panel-heading">${book.title}</div>
                            <a href="PandaBooksController?action=viewBook&AMP;id=${book.bookId}"><div class="panel-body"><img src="${book.path}" class="img-responsive" style="width:100%" alt="Image"></div></a>
                            <div class="panel-footer">${book.price}
                                <form action="PandaBooksController" method="post">
                                    <input type="hidden" name="bookId" value="${book.bookId}">
                                    <input type="hidden" name="action" value="addToCart">
                                    <input type="submit" value="Add To Cart">
                                </form>
                            </div>
                        </div>
                    </div>
        </c:forEach>
    </div>
</section>

<c:import url="includes/footer.jsp" />
