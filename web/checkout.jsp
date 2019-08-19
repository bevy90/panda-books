<%-- 
    Document   : checkout
    Johns Hopkins University
    Web Application Development with Java
    Group project
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="includes/header.jsp" />

<section class="container">
    <div class="row">
        <div class="col-md-4 order-md-2 mb-4">
            <h4 class="d-flex justify-content-between align-items-center mb-3">
                <span class="text-muted">Your cart</span>
                <span class="badge badge-secondary badge-pill">${cartSize}</span>
            </h4>

            <ul class="list-group mb-3">
                <c:forEach var="item" items="${cart.items}">
                    <li class="list-group-item d-flex justify-content-between lh-condensed">
                        <div>
                            <h6 class="my-0">${item.getKey().title}</h6>
                            <small class="text-muted">(${item.getValue()})</small>
                        </div>
                        <span class="text-muted">${item.getKey().price * item.getValue()}</span>
                    </li>
                </c:forEach>
                <li class="list-group-item d-flex justify-content-between">
                    <span>Total (USD)</span>
                    <strong>${cart.total}</strong>
                </li>
            </ul>
        </div>
        
        <div class="col-md-8 order-md-1">
            <h4 class="mb-3">Billing address</h4>
            <form action="PandaBooksController" method="post">
                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="fName">First name</label>
                        <input type="text" class="form-control" name="fName" placeholder="" value="">
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="lName">Last name</label>
                        <input type="text" class="form-control" name="lName" placeholder="" value="">
                    </div>
                </div>

                <div class="mb-3">
                    <label for="address">Address</label>
                    <input type="text" class="form-control" name="address" placeholder="1234 Main St">
                </div>

                <div class="mb-3">
                    <label for="address2">Address 2 <span class="text-muted">(Optional)</span></label>
                    <input type="text" class="form-control" name="address2" placeholder="Apartment or suite">
                </div>

                <div class="row">
                    <div class="col-md-5 mb-3">
                        <label for="country">Country</label>
                        <select class="custom-select d-block w-100" name="country">
                            <option value="">Choose...</option>
                            <option>United States</option>
                        </select>
                    </div>
                    <div class="col-md-4 mb-3">
                        <label for="state">State</label>
                        <select class="custom-select d-block w-100" name="state">
                            <option value="">Choose...</option>
                            <option>California</option>
                        </select>
                    </div>
                    <div class="col-md-3 mb-3">
                        <label for="zip">Zip</label>
                        <input type="text" class="form-control" name="zip" placeholder="">
                    </div>
                </div>

                <hr class="mb-4">

                <h4 class="mb-3">Payment</h4>

                <div class="d-block my-3">
                    <div class="custom-control custom-radio">
                        <input id="credit" name="paymentMethod" type="radio" class="custom-control-input" checked>
                        <label class="custom-control-label" for="credit">Credit card</label>
                    </div>
                    <div class="custom-control custom-radio">
                        <input id="debit" name="paymentMethod" type="radio" class="custom-control-input">
                        <label class="custom-control-label" for="debit">Debit card</label>
                    </div>
                    <div class="custom-control custom-radio">
                        <input id="paypal" name="paymentMethod" type="radio" class="custom-control-input">
                        <label class="custom-control-label" for="paypal">PayPal</label>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="cc-name">Name on card</label>
                        <input type="text" class="form-control" name="cc-name" placeholder="">
                        <small class="text-muted">Full name as displayed on card</small>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="cc-number">Credit card number</label>
                        <input type="text" class="form-control" name="cc-number" placeholder="">
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-3 mb-3">
                        <label for="cc-expiration">Expiration</label>
                        <input type="text" class="form-control" name="cc-expiration" placeholder="">
                    </div>
                    <div class="col-md-3 mb-3">
                        <label for="cc-cvv">CVV</label>
                        <input type="text" class="form-control" name="cc-cvv" placeholder="">
                    </div>
                </div>

                <hr class="mb-4">
                
                <div>
                    <label>&nbsp;</label>
                    <input type="hidden" name="action" value="order"/>
                </div>
                <button class="btn btn-bg my-2 btn-lg btn-block" type="submit">Place order</button>
            </form>
        </div>
    </div>
</section>

<c:import url="includes/footer.jsp" />
