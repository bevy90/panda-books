<%-- 
    Document   : order
    Johns Hopkins University
    Web Application Development with Java
    Group project
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="includes/header.jsp" />

<section class="container">
    <c:choose>
        <c:when test="${orders.size() > 0}">
            <div class="px-4 px-lg-0">
                <div class="pb-5">
                    <div class="container">
                        <c:forEach var="order" items="${orders}">
                            <div class="row">
                                <div class="col-lg-12 p-5 bg-white rounded shadow-sm mb-5">
                                    <p><span class="font-weight-bold">Order date: </span> ${order.getValue().orderDate}</p>
                                    <p><span class="font-weight-bold">Order Status: </span> ${order.getValue().orderStatus}</p>
                                    <!-- Orders table -->
                                    <div class="table-responsive">
                                        <table class="table">
                                            <thead>
                                                <tr>
                                                    <th scope="col" class="border-0 bg-light">
                                                        <div class="p-2 px-3 text-uppercase">Product</div>
                                                    </th>
                                                    <th scope="col" class="border-0 bg-light">
                                                        <div class="py-2 text-uppercase">Price</div>
                                                    </th>
                                                    <th scope="col" class="border-0 bg-light">
                                                        <div class="py-2 text-uppercase">Quantity</div>
                                                    </th>
                                                    <th scope="col" class="border-0 bg-light">
                                                        <div class="py-2 text-uppercase">Total</div>
                                                    </th>
                                                </tr>
                                            </thead>

                                            <tbody>
                                        
                                            <c:forEach var="book" items="${order.getValue().items}">
                                                <tr>
                                                    <th scope="row" class="border-0">
                                                      <div class="p-2">
                                                        <div class="ml-3 d-inline-block align-middle">
                                                          <h5 class="mb-0"> 
                                                              <a href="PandaBooksController?action=viewBook&AMP;bookId=${book.getKey().bookId}" class="text-dark d-inline-block align-middle">
                                                                  ${book.getKey().title}
                                                              </a>
                                                          </h5>
                                                          <span class="text-muted font-weight-normal font-italic d-block">Category: ${book.getKey().genre}</span>
                                                        </div>
                                                      </div>
                                                    </th>
                                                    <td class="border-0 align-middle"><strong>$${book.getKey().price * book.getValue()}</strong></td>
                                                    <td class="border-0 align-middle">
                                                        <strong>${book.getValue()}</strong>
                                                    </td>
                                                    <td class="border-0 align-middle">&nbsp;</td>
                                                </tr>
                                            </c:forEach>
                                                <tr>
                                                    <th class="border-0">&nbsp;</th>
                                                    <td class="border-0 align-middle">&nbsp;</td>
                                                    <td class="border-0 align-middle">&nbsp;</td>
                                                    <td class="font-weight-bold">${order.getValue().totalCost}</td>
                                                </tr>
                                        </tbody>   
                                    </table>
                                </div>
                            </div>
                        </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </c:when>
        <c:otherwise>
            <p>You have not placed an order.</p>
            <a href="cart.jsp" class="btn btn-bg my-2">Go to Cart</a>
        </c:otherwise>
    </c:choose>
</section>

<c:import url="includes/footer.jsp" />