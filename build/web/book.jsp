<%-- 
    Document   : book
    Johns Hopkins University
    Web Application Development with Java
    Group project
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="includes/header.jsp" />

<!-- start book -->
    <div class="container-fluid">
        <div class="content-wrapper">	
            <div class="item-container ">	
                <div class="container">	
                    <div class="col-md-12">
                        <div class="book col-md-3 service-image-left">
                            <p>
                               <img class="img-responsive" src="${book.path}" alt=""></img>
                            </p>
                        </div>
                                                
                    </div>
                            
                    <div class="col-md-7">
                        <span class="text-uppercase font-weight-bold pt-20">${book.title}</span>
                        <div class="book-desc text-secondary">${book.description}</div>
                            
                        <hr>
                        <div class="product-price">$${book.price}</div>
                        <hr>
                        <button type="submit" class="btn btn-bg my-2">Add to Cart</button>
                         <c:if test="${not empty customer}">
                            <a href="PandaBooksController?action=addToWishList&AMP;bookId=${book.bookId}">
                                <button type="button" class="btn btn-secondary" title="wishlist"> <i class="fas fa-plus-circle"></i> </button>
                            </a>
                            <a href="PandaBooksController?action=addToFavorites&AMP;bookId=${book.bookId}">
                                <button type="button" class="btn btn-secondary" title="favorites"> <i class="fas fa-heart"></i> </button>
                            </a>
                        </c:if>
                         
                    </div>
                </div> 
            </div>
        </div>
    </div>
    

  <!-- end book -->

<c:import url="includes/footer.jsp" />
