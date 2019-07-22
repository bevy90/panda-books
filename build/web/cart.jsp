<%-- 
    Document   : cart
    Johns Hopkins University
    Web Application Development with Java
    Group project
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="includes/header.jsp" />

<c:choose>
    <c:when test="${cart.items.size() > 0}">
        <table>
            <tr>
                <th>Title</th>
                <th>Price</th>
                <th>Quantity</th>
                <th></th>
            </tr>
            <c:forEach var="item" items="${cart.items}">
                <tr>
                    <td>${item.getKey().title}</td>
                    <td>${item.getKey().price * item.getValue()}</td>
                    <td>
                        <form action="PandaBooksController" method="post">
                            <input type="hidden" name="action" value="modifyCart">
                            <input type="hidden" name="bookId" value="${item.getKey().bookId}">
                            <input type=text name="quantity" value="${item.getValue()}" id="quantity">
                            <input type="submit" value="Update">
                        </form>
                    </td>
                    <td>
                        <form action="PandaBooksController" method="post">
                            <input type="hidden" name="action" value="modifyCart">
                            <input type="hidden" name="bookId" value="${item.getKey().bookId}">
                            <input type="hidden" name="quantity" value="0">
                            <input type="submit" value="Remove Item">
                        </form>
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <td>Total</td>
                <td>${cart.total}</td>
            </tr>
        </table>
    </c:when>
    <c:otherwise>
        <p>Your cart is empty</p>  
    </c:otherwise>
</c:choose>
        
<form action="PandaBooksController" method="post">
  <input type="hidden" name="action" value="browse">
  <input type="submit" value="Continue Shopping">
</form>

<form action="PandaBooksController" method="post">
  <input type="hidden" name="action" value="checkout">
  <input type="submit" value="Checkout">
</form>

<c:import url="includes/footer.jsp" />
