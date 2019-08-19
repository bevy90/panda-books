<%-- 
    Document   : edit
    Johns Hopkins University
    Web Application Development with Java
    Group project
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="includes/header.jsp" />

<section class="container">
    <form action="PandaBooksController" method="post">
        <div class="form-group">
            <label for="firstname">First Name</label>
            <input type="text" name="fName" required class="form-control" value="${customer.firstName}"/>
        </div>
        <div class="form-group">
            <label for="lastname">Last Name</label>
            <input type="text" name="lName" required class="form-control" value="${customer.lastName}"/>
        </div>
        <div class="form-group">
            <label for="username">Username</label>
            <input type="text" name="userName" required class="form-control" value="${customer.userName}"/>
        </div>
        
        <div class="form-group">
            <label>&nbsp;</label>
            <input type="hidden" name="action" value="editAccount">
        </div>
        
        <button type="submit" class="btn btn-bg my-2">Update Account</button>
    </form>
</section>

<c:import url="includes/footer.jsp" />
