<%-- 
    Document   : register
    Johns Hopkins University
    Web Application Development with Java
    Group project
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="includes/header.jsp" />

<section class="container">
    <c:if test="${not empty error}">
        <p class="alert alert-warning">${error}</p>
    </c:if>
    
    <form action="PandaBooksController" method="post">
        <div class="form-row">
            <div class="form-group col-md-4">
                <label for="firstname">First Name</label>
                <input type="text" name="fName" required class="form-control" placeholder="Enter first name"/>
            </div>
            <div class="form-group col-md-4">
                <label for="lastname">Last Name</label>
                <input type="text" name="lName" required class="form-control" placeholder="Enter last name"/>
            </div>
            <div class="form-group col-md-4">
                <label for="username">Username</label>
                <input type="text" name="userName" required class="form-control" placeholder="Choose a username"/>
            </div>
        </div>
        
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="email">Email</label>
                <input type="email" name="email" required class="form-control" placeholder="Email"/>
            </div>
            <div class="form-group col-md-6">
                <label for="password">Password</label>
                <input type="password" name="password" required class="form-control" placeholder="password"/>
            </div>
        </div>
        
        <div class="form-group">
            <label for="inputAddress">Address</label>
            <input type="text" class="form-control" name="inputAddress" placeholder="1234 Main St">
        </div>
        
        <div class="form-group">
            <label for="inputAddress2">Address 2</label>
            <input type="text" class="form-control" name="inputAddress2" placeholder="Apartment, studio, or floor">
        </div>
        
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="city">City</label>
                <input type="text" class="form-control" name="city">
            </div>
            <div class="form-group col-md-4">
                <label for="inputState">State</label>
                <select name="state" class="form-control">
                    <option selected>Choose...</option>
                    <option>...</option>
                </select>
            </div>
            <div class="form-group col-md-2">
                <label for="zip">Zip</label>
                <input type="text" class="form-control" name="zip">
            </div>
        </div>
        
        <div class="form-group">
            <label>&nbsp;</label>
            <input type="hidden" name="action" value="createAccount">
        </div>
        
        <button type="submit" class="btn btn-bg my-2">Create account</button>
    </form>
</section>

<c:import url="includes/footer.jsp" />
