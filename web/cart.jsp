<%-- 
    Document   : cart
    Johns Hopkins University
    Web Application Development with Java
    Group project
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="includes/header.jsp" />

<section class="container">
    <c:choose>
        <c:when test="${cart.items.size() > 0}">
            <div class="px-4 px-lg-0">
                <div class="pb-5">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-12 p-5 bg-white rounded shadow-sm mb-5">
                                <c:if test="${not empty checkoutError}">
                                    <p class="alert alert-warning">${checkoutError}</p>
                                </c:if>
                                <!-- Shopping cart table -->
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
                                                    <div class="py-2 text-uppercase">Remove</div>
                                                </th>
                                            </tr>
                                        </thead>
                                        
                                        <tbody>
                                            <c:forEach var="item" items="${cart.items}">
                                                <tr>
                                                    <th scope="row" class="border-0">
                                                      <div class="p-2">
                                                        <div class="ml-3 d-inline-block align-middle">
                                                          <h5 class="mb-0"> 
                                                              <a href="PandaBooksController?action=viewBook&AMP;bookId=${item.getKey().bookId}" class="text-dark d-inline-block align-middle">
                                                                  ${item.getKey().title}
                                                              </a>
                                                          </h5>
                                                          <span class="text-muted font-weight-normal font-italic d-block">Category: ${item.getKey().genre}</span>
                                                        </div>
                                                      </div>
                                                    </th>
                                                    <td class="border-0 align-middle"><strong>$${item.getKey().price * item.getValue()}</strong></td>
                                                    <td class="border-0 align-middle">
                                                        <strong>${item.getValue()}</strong>
                                                        <a href="PandaBooksController?action=modifyCart&AMP;bookId=${item.getKey().bookId}&AMP;quantity=${item.getValue() + 1}" class="text-dark">
                                                            <i class="fa fa-plus-circle"></i>
                                                        </a>
                                                        <a href="PandaBooksController?action=modifyCart&AMP;bookId=${item.getKey().bookId}&AMP;quantity=${item.getValue() - 1}" class="text-dark">
                                                            <i class="fa fa-minus-circle"></i>
                                                        </a>
                                                    </td>
                                                    <td class="border-0 align-middle">
                                                        <a href="PandaBooksController?action=modifyCart&AMP;bookId=${item.getKey().bookId}&AMP;quantity=0" class="text-dark">
                                                            <i class="fa fa-trash"></i>
                                                        </a>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                        
                        <div class="row py-5 p-4 bg-white rounded shadow-sm">
                            <div class="col-lg-6">
                                <div class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Instructions for seller</div>
                                <div class="p-4">
                                    <p class="font-italic mb-4">If you have some information for the seller you can leave them in the box below</p>
                                    <textarea name="" cols="30" rows="2" class="form-control"></textarea>
                                </div>
                            </div>
                            
                            <div class="col-lg-6">
                                <div class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Cart summary </div>
                                <div class="p-4">
                                    <p class="font-italic mb-4">Shipping and additional costs are calculated based on values you have entered.</p>
                                    <ul class="list-unstyled mb-4">
                                        <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Order Subtotal </strong><strong>$${cart.total}</strong></li>
                                        <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Shipping and handling</strong><strong>$0.00</strong></li>
                                        <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Tax</strong><strong>$0.00</strong></li>
                                        <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Total</strong>
                                            <h5 class="font-weight-bold">$${cart.total}</h5>
                                        </li>
                                    </ul>
                                    <a href="https://localhost:8443/panda-books/PandaBooksController?action=checkout" class="btn btn-bg my-2 btn-lg btn-block">Proceed to checkout</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </c:when>
        <c:otherwise>
            <p>Your cart is empty</p>
            <a href="PandaBooksController?action=browse" class="btn btn-bg my-2">Shop books</a>
        </c:otherwise>
    </c:choose>
</section>

<c:import url="includes/footer.jsp" />
