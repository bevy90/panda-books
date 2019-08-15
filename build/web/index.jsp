<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
Johns Hopkins University
Web Application Development with Java
Group project
-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="includes/header.jsp" />


<!-- start carousel -->
    <div class="container" >
        <div class="carousel slide" id="carousel-indicators" data-ride="carousel">
            <ol class="carousel-indicators">
                <li class="active"  data-target="#carousel-indicators" 
                data-slide-to = "0"></li>
                <li data-target="#carousel-indicators" data-slide-to = "1"></li>
                <li data-target="#carousel-indicators" data-slide-to = "2"></li>
            </ol>
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <a href="#">
                        <img class="img-flud d-lg-none d-md-none" src="images/ebookMain/summer_reading2a.jpg" alt="">
                        <img class="img-fluid d-none d-md-block" src="images/ebookMain/summer_reading1a.jpg" alt="">
                    </a>
                </div>
            
            
            
                <div class="carousel-item">
                    <a href="#">
                        <img class="img-flud d-lg-none d-md-none" src="images/ebookMain/Best_seller12a.jpg" alt="">
                        <img class="img-fluid d-none d-md-block" src="images/ebookMain/Best_seller1a.jpg" alt="">
                    </a>
                </div>
               
                
                <div class="carousel-item">
                    <a href="#">
                        <img class="img-flud d-lg-none d-md-none" src="images/ebookMain/Newly_added1a.jpg" alt="">
                        <img class="img-fluid d-none d-md-block" src="images/ebookMain/Newly_addeda.jpg" alt="">
                    </a>
                </div>
            </div>    

             <a class="carousel-control-prev"href="#carousel-indicators" role="button"
             data-slide="prev">
                <i class="fas fa-chevron-left text-clipped"></i>
            </a>
            <a class="carousel-control-next"href="#carousel-indicators" role="button"
             data-slide="next">
                <i class="fas fa-chevron-right text-clipped"></i>
            </a>
        </div>
        
    </div>
    <!-- end carousel -->
    </header>  
  <!-- end header -->

  <!-- Featured books -->
   <section class="featured-books pt-15">
       <div class="container">
           <div class="section-heading text-center mb-5">
               <h1 class="text-clipped text-uppercase">Featured Books</h1>
               <p class="text-secondary"> Find fun and exciting books</p>
           </div>

           <div class="row">
               <c:forEach var="book" items="${featuredBooks}">
                   <div class="col-3 mb-2">
                        <div class="featured-books-img mb-2">
                          <img src="${book.path}" alt="">  
                        </div>
                        <a href="PandaBooksController?action=viewBook&AMP;id=${book.bookId}">
                            <span class="text-uppercase font-weight-bold">${book.title}</span><br>
                            <span>Shop now</span> <i class="fas fa-caret-right"></i>
                        </a>  
                    </div>
               </c:forEach>
           </div>
       </div>
   </section>
  <!-- end featured books -->

<c:import url="includes/footer.jsp" />
