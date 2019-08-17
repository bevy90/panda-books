<%-- 
    Document   : header
    Johns Hopkins University
    Web Application Development with Java
    Group project
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Panda Books</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/470d2b793b.js"></script>
    <link rel="stylesheet" href="styles/main.css">
</head>
    
<body>
    <!-- start header -->
  <header>
      <div class="custom-nav-container d-flex aligh-items-center 
      justify-content-between px-2 py-3 shadow-sm">
          <a class="text-clipped navbar-brand" href="index.jsp">
              <i class="fas fa-book-open d-flex">
                  <span class="m-auto"> Panda Books</span>
              </i>
          </a>
          <div class="main-nav-outer d-flex">
              <i class="fas fa-times text-clipped menu-close-icon d-lg-none"></i>
              <nav class="main-nav navbar navbar-light navbar-expand-lg text-center m-auto">
                  <ul class="navbar-nav d-flex">
                      <li class="nav-item">
                          <a class="nav-link" href="index.jsp">Home</a>
                      </li>
                      <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Categories</a>
                            <div class="dropdown-menu">
                                <a class="dropdown-item" href="PandaBooksController?action=browseGenre&amp;genre=Children's">Children's</a>
                                <a class="dropdown-item" href="PandaBooksController?action=browseGenre&amp;genre=Fantasy">Fantasy</a>
                                <a class="dropdown-item" href="PandaBooksController?action=browseGenre&amp;genre=Mystery">Mystery</a>
                                <a class="dropdown-item" href="PandaBooksController?action=browseGenre&amp;genre=Non-Fiction">Non-Fiction</a>
                                <a class="dropdown-item" href="PandaBooksController?action=browseGenre&amp;genre=Poetry">Poetry</a>
                                <a class="dropdown-item" href="PandaBooksController?action=browseGenre&amp;genre=Romance">Romance</a>
                                <a class="dropdown-item" href="PandaBooksController?action=browseGenre&amp;genre=SCI-FI">Sci-Fi</a>
                            </div>
                     </li>
                      <li class="nav-item">
                            <a class="nav-link" href="about.jsp">About</a>
                      </li>
                      
                      
                  </ul>
              </nav>
          </div>

          <!-- Right hand side icons -->
          <div class="nav-icons-container d-flex justify-content-between ">
              <div class="nav-icons">
                  <a  href="PandaBooksController?action=browse">
                    <i class="fas fa-search text-clipped"></i>  
                  </a>
              </div>
              <div class="nav-icons">
                    <a  href="cart.jsp">
                      <i class="fas fa-shopping-bag bag-item-count text-clipped"></i> 
                      <span class="badge">${empty cartSize ? 0 : cartSize}</span> 
                    </a>
                </div>
                <!-- Form for logging in -->
                <div class="nav-icons">
                    <c:choose>
                        <c:when test="${not empty customer}">
                            <div class="dropdown">
                                <a class="dropdown-toggle" href="" data-toggle="dropdown">
                                    <i class="fas fa-user text-clipped"></i>
                                </a>
                                <div class="dropdown-menu">
                                    <a class="dropdown-item" href="PandaBooksController?action=goToAccount">My account</a>
                                    <div class="dropdown-divider mt-0"> </div>
                                    <form action="PandaBooksController" class="p-2" text-secondary>
                                        <input type="hidden" name="action" value="logout">
                                        <button type="submit" class="btn btn-bg my-2">Log out</button>
                                    </form>
                                </div>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <div class="dropdown">
                                <a class="dropdown-toggle" href="" data-toggle="dropdown">
                                    <i class="fas fa-user text-clipped"></i>
                                </a>
                                <div class="dropdown-menu">
                                    <form action="PandaBooksController" class="p-2" text-secondary>
                                        <input type="hidden" name="action" value="login">
                                        <div class="form-group">
                                            <input type="text" class="form-control" name="userName" 
                                            placeholder = "Enter username" required>
                                        </div>
                                        <div class="form-group">
                                            <input type="password" class="form-control" name='password'
                                             placeholder = "Enter password" required>
                                        </div>
                                        <button type="submit" class="btn btn-bg my-2">Sign in</button>
                                    </form>
                                    <div class="dropdown-divider mt-0"> </div>
                                    <a class="dropdown-item" href="PandaBooksController?action=register">Don't have an account? Sign up</a>
                                    <a class="dropdown-item" href="#">Forgot password</a>
                                </div>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </div>

                <div class="nav-icons d-lg-none">
                      <i class="fas fa-bars open-menu-icon text-clipped"></i>  
                </div>
          </div>
      </div>