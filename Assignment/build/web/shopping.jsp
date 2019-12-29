<%-- 
    Document   : shopping
    Created on : Dec 15, 2019, 6:24:09 PM
    Author     : SE130162
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping</title>
    </head>
    <body>
        <div class="header">
            <h1 style="text-align: center; border-bottom: #f7ffff 0.1px solid;">
                Book Store 
            </h1>
            <c:set var="username" value="${sessionScope.USERNAME}"/>
            <c:if test="${not empty username}">
                <div class="box-logout">
                    <p>
                        Welcome ${username}
                        <a class="btn-action-logout" href="logout">Log out</a>
                    </p>
                </div>
            </c:if>
            <div style="clear:both;">
                <a href="viewCart.jsp" style="float:right">View Cart</a>
                <c:set var="role" value="${sessionScope.ROLE}"/>
                <c:if test="${not empty role}">
                    <c:if test="${role}">
                       <br/> <a href="search.jsp" style="float:right"> Search Page</a>
                    </c:if>
                </c:if>
               
            </div>
        </div>

        <div class="wrapper-list-items">
            <c:set var="listItems" value="${sessionScope.ITEMS}"/>
            <c:forEach var="dto" items="${listItems}" > 
                <div class="item-box-action">
                    <fieldset style="margin: 5px;">
                        <legend style="text-align: center;"> Book</legend>
                        <form action="addBook" class="form-item">
                            <input type="hidden" name="txtProductID" value="${dto.productID}" />
                            <p class="title-product-box">
                                ${dto.productName}
                            </p>
                            <input type="submit" value="Add To Cart" class="btn-action-addBook" />   
                        </form>
                    </fieldset>
                </div>
            </c:forEach>
        </div>
    </body>
</html>
<style>
    body{
        font-family: monospace;
        background-color: #f9f9f9;
        font-size: 17px;
        letter-spacing: 0.8;
        color: #333;
    }
    a{
        text-decoration: none;
        color: #4d62ff;
    }
    .hearder{ 
        width: 100%;
        margin-bottom: 20px;
        height: auto;
        padding: 20px;
    }
    .title-product-box{
        padding: 50px;
        font-size:  24px;
    }
    .wrapper-list-items{
        clear:both;
        display: flex;
        flex-direction: row;
        flex-wrap: wrap;
        align-content: center;
        justify-content: center;
        align-items: center;
        margin:10px;
    }
    .form-item{
        display: flex;
        flex-direction: column;
        align-content: center;
        justify-content: center;
        align-items: center;
        width: 300px;
    }
    .btn-action-addBook{
        background-color:#f7ffff;
        border-radius: 5%;
        padding: 10px 120px 10px 120px;
    }
    .box-logout{
        padding: 5px;
        border: 0.1px #cccccc dotted;
        float:right;
        font-size:12px;  
        display: block;
        position: relative;
    }

</style>
