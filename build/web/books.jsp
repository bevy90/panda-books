<%-- 
    Document   : books
    Johns Hopkins University
    Web Application Development with Java
    Group project
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="includes/header.jsp" />

<!-- start books -->
   <section class="browse-books pt-10">
        <div class="container">
            <div class="section-heading text-left mb-2">
                <h1 class="text-clipped text-uppercase">Books</h1>
            </div>
 
            <div class="row">
                <div class="col-lg-2 col-md-3">  
                    <div class="list-group text-secondary">
                        <a href="PandaBooksController?action=browse" class="list-group-item">All Books</a>
                        <a href="PandaBooksController?action=browse" class="list-group-item">Newly Arrived</a>
                        <a href="PandaBooksController?action=browse" class="list-group-item">Summer Reading</a>
                        <a href="PandaBooksController?action=browse" class="list-group-item">Best Sellers</a>
                        <a href="PandaBooksController?action=browseGenre&amp;genre=Children's" class="list-group-item">Children's</a>
                        <a href="PandaBooksController?action=browseGenre&amp;genre=Fantasy" class="list-group-item">Fantasy</a>
                        <a href="PandaBooksController?action=browseGenre&amp;genre=Mystery" class="list-group-item">Mystery</a>
                        <a href="PandaBooksController?action=browseGenre&amp;genre=Non-Fiction" class="list-group-item">Non-Fiction</a>
                        <a href="PandaBooksController?action=browseGenre&amp;genre=Poetry" class="list-group-item">Poetry</a>
                        <a href="PandaBooksController?action=browseGenre&amp;genre=Romance" class="list-group-item">Romance</a>
                        <a href="PandaBooksController?action=browseGenre&amp;genre=SCI-FI" class="list-group-item">Sci-Fi</a>
                    </div>
                </div>
                
                <div class="col-lg-10 col-md-9">
                    <div class="row">
                        <c:forEach var="book" items="${books}">
                            <div class="col-sm-4 col-md-3 mb-2">
                                <div class="card card-body mb-4 text-center browse-books">
                                    <img class="img-responsive" src="${book.path}" alt="Image"> 
                                    <a href="PandaBooksController?action=viewBook&AMP;bookId=${book.bookId}">
                                        <span class="my-0 card-title text-uppercase font-weight-bold">${book.title}</span>
                                    </a>
                                    <br>
                                    <span class="text-secondary"> $${book.price} </span> <br> 
                                    <ul class="nav nav-tabs card-header-tabs">
                                        <li class="nav-item">
                                            <a href="PandaBooksController?action=addToCart&AMP;bookId=${book.bookId}">
                                                <button type="submit" class="btn btn-bg my-2">Add to Cart</button> 
                                            </a>
                                        </li>
                                        <c:if test="${not empty customer}">
                                            <li class="nav-item pt-2">
                                                 <a href="PandaBooksController?action=addToFavorites&AMP;bookId=${book.bookId}">
                                                    <button type="button" class="btn btn-secondary" title="favorites"> <i class="fas fa-heart"></i> </button> <br>
                                                </a>
                                            </li>
                                            <li class="nav-item pt-2">      
                                                 <a href="PandaBooksController?action=addToWishList&AMP;bookId=${book.bookId}">
                                                    <button type="button" class="btn btn-secondary" title="wishlist"> <i class="fas fa-plus-circle"></i> </button> <br>
                                                </a>
                                            </li>
                                         </c:if>
                                    </ul>
                                </div>  
                            </div>
                        </c:forEach>  
                    </div>
                </div>
            </div>
        </div>
    </section>
  <!-- end books -->


<c:import url="includes/footer.jsp" />
