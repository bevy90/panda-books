<%-- 
    Document   : books
    Created on : Jul 12, 2019, 3:01:29 PM
    Author     : bever
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="includes/header.jsp" />

<section class="container">
    <div class="row">
        <div class="col-sm-4">
            <div class="panel panel-primary">
                <div class="panel-heading">Book Name</div>
                <div class="panel-body"><img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image"></div>
                <div class="panel-footer">Price
                    <form action="PandaBooksController" method="post">
                        <input type="hidden" name="bookId" value="pf01">
                        <input type="hidden" name="action" value="addToCart">
                        <input type="submit" value="Add To Cart">
                    </form>
                </div>
            </div>
        </div>
                
        <div class="col-sm-4">
            <div class="panel panel-primary">
                <div class="panel-heading">Book Name</div>
                <div class="panel-body"><img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image"></div>
                <div class="panel-footer">Price
                    <form action="PandaBooksController" method="post">
                        <input type="hidden" name="bookId" value="pf02">
                        <input type="hidden" name="action" value="addToCart">
                        <input type="submit" value="Add To Cart">
                    </form>
                </div>
            </div>
        </div>
        
        <div class="col-sm-4">
            <div class="panel panel-primary">
                <div class="panel-heading">Book Name</div>
                <div class="panel-body"><img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image"></div>
                <div class="panel-footer">Price
                    <form action="PandaBooksController" method="post">
                        <input type="hidden" name="bookId" value="pf03">
                        <input type="hidden" name="action" value="addToCart">
                        <input type="submit" value="Add To Cart">
                    </form>
                </div>
            </div>
        </div>
</section>
        
<section class="container">
    <div class="row">
        <div class="col-sm-4">
            <div class="panel panel-primary">
                <div class="panel-heading">Book Name</div>
                <div class="panel-body"><img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image"></div>
                <div class="panel-footer">Price
                    <form action="PandaBooksController" method="post">
                        <input type="hidden" name="bookId" value="pf04">
                        <input type="hidden" name="action" value="addToCart">
                        <input type="submit" value="Add To Cart">
                    </form>
                </div>
            </div>
        </div>
                
        <div class="col-sm-4">
            <div class="panel panel-primary">
                <div class="panel-heading">Book Name</div>
                <div class="panel-body"><img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image"></div>
                <div class="panel-footer">Price
                    <form action="PandaBooksController" method="post">
                        <input type="hidden" name="bookId" value="pf05">
                        <input type="hidden" name="action" value="addToCart">
                        <input type="submit" value="Add To Cart">
                    </form>
                </div>
            </div>
        </div>
        
        <div class="col-sm-4">
            <div class="panel panel-primary">
                <div class="panel-heading">Book Name</div>
                <div class="panel-body"><img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image"></div>
                <div class="panel-footer">Price
                    <form action="PandaBooksController" method="post">
                        <input type="hidden" name="bookId" value="pf06">
                        <input type="hidden" name="action" value="addToCart">
                        <input type="submit" value="Add To Cart">
                    </form>
                </div>
            </div>
        </div>
</section>

<c:import url="includes/footer.jsp" />
