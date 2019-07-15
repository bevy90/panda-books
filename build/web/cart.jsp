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
                <th>Id</th>
                <th>Quantity</th>
                <th></th>
            </tr>
            <c:forEach var="item" items="${cart.items}">
                <tr>
                    <td>${item.getKey().title}</td>
                    <td>
                        <form action="PandaBooksController" method="post">
                            <input type="hidden" name="action" value="modifyCart">
                            <input type="hidden" name="bookId" value="${item.getKey().title}">
                            <input type=text name="quantity" value="${item.getValue()}" id="quantity">
                            <input type="submit" value="Update">
                        </form>
                    </td>
                    <td>
                        <form action="PandaBooksController" method="post">
                            <input type="hidden" name="action" value="modifyCart">
                            <input type="hidden" name="bookId" value="${item.getKey().title}">
                            <input type="hidden" name="quantity" value="0">
                            <input type="submit" value="Remove Item">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:when>
    <c:otherwise>
        <p>Your cart is empty</p>  
    </c:otherwise>
</c:choose>

<c:import url="includes/footer.jsp" />
