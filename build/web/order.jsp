<%-- 
    Document   : order
    Created on : Jul 12, 2019, 3:01:48 PM
    Author     : bever
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="includes/header.jsp" />

<h1>Order</h1>

<p>Order date: ${order.orderDate}</p>
<p>Order Status: ${order.orderStstus}</p>
<table>
    <tr>
        <th>Title</th>
        <th>Quantity</th>
        <th>Price</th>
    </tr>
    
    <c:forEach var="item" items="${order.items}">
        <tr>
            <td>${item.getKey().title}</td>
            <td>${item.getValue()}</td>
            <td>${item.getKey().price * item.getValue()}</td>
        </tr>
    </c:forEach>
    <tr>
        <td>Total</td>
        <td>${order.totalCost}</td>
    </tr>
</table>

<c:import url="includes/footer.jsp" />