<%-- 
    Document   : register
    Johns Hopkins University
    Web Application Development with Java
    Group project
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="includes/header.jsp" />

<section>
    <h1 id="title">Register</h1>
    
    <p>${error}</p>
    
    <form action="PandaBooksController" method="post">
        <fieldset>
            <legend>Contact Information</legend>
            <label>First Name
                <input type="text" name="fName" required/>
            </label>
                    
            <label>Last Name
                <input type="text" name="lName" required/>
            </label>
            
            <label>Username
                <input type="text" name="userName" required/>
            </label>
            
            <label>Password
                <input type="text" name="password" required/>
            </label>

            <label>Email
                <input type="email" name="email" required/>
            </label>
        </fieldset>
                
        <label>&nbsp;</label>
        <input type="hidden" name="action" value="createAccount">
        <input type="submit" value="Create account"/>
    </form>
</section>

<c:import url="includes/footer.jsp" />
