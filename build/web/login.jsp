<%-- 
    Document   : login
    Created on : Jul 22, 2019, 11:21:40 AM
    Author     : bever
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="includes/header.jsp" />

<section>
    <h1 id="title">Login</h1>
            
    <form action="PandaBooksController" method="post">
        <fieldset>
            <label>Username
                <input type="text" name="userName" required/>
            </label>
            
            <label>Password
                <input type="text" name="password" required/>
            </label>
        </fieldset>
                
        <label>&nbsp;</label>
        <input type="hidden" name="action" value="login">
        <input type="submit" value="Login"/>
    </form>
</section>

<c:import url="includes/footer.jsp" />
