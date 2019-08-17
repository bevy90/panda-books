<%-- 
    Document   : checkout
    Johns Hopkins University
    Web Application Development with Java
    Group project
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="includes/header.jsp" />

<div>
    <form action="PandaBooksController" method="post">
        <fieldset>
            <legend>Payment Details</legend>
            <label>Credit Card Type
                <input type="radio" name='cardType' value="Discover" required/>Discover
                <input type="radio" name='cardType' value="Master Card"/>Master Card
                <input type="radio" name='cardType' value="Visa"/>Visa
            </label>
            <label>Credit Card Number
                <input type="text" name='cardNumber' required/>
            </label>
            <label>Expiration Date
                <select name="month" required>
                    <option value="January" selected>January</option>
                    <option value="February">February</option>
                    <option value="March">March</option>
                    <option value='April'>April</option>
                    <option value="May">May</option>
                    <option value="June">June</option>
                    <option value='July'>July</option>
                    <option value="August">August</option>
                    <option value="September">September</option>
                    <option value="October">October</option>
                    <option value='November'>November</option>
                    <option value="December">December</option>
                </select>
                
                <select name="year" required>
                    <option value="2019" selected>2019</option>
                    <option value="2020">2020</option>
                    <option value="2021">2021</option>
                    <option value='2022'>2022</option>
                    <option value="2023">2023</option>
                </select>
            </label>
        </fieldset>
        <input type="hidden" name="action" value="order"/>
        <input type="submit" value="Place Order"/>
    </form>
</div>

<c:import url="includes/footer.jsp" />
