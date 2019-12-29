<%-- 
    Document   : viewCart
    Created on : Dec 16, 2019, 8:43:47 AM
    Author     : SE130162
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart</title>
    </head>
    <body>
        <h1 style="text-align: center;border-bottom: 1px dotted #333">Your Cart</h1>
        <div class="wrapper-cart">
            <c:set var="listItems" value="${sessionScope.ITEMS}"/>
            <c:set var="result" value="${sessionScope.CART.items}"/>
            <c:out value="${result.items}"/>
            <c:if test="${not empty result}">
                <table border="1" class="tbl-search-result">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Book Name</th>
                            <th>Quantity</th>
                        </tr>
                    </thead>
                    <tbody>
                    <form action="removeBook">
                        <c:forEach var="item" items="${result}" varStatus="counter">
                            <tr>
                                <td>
                                    ${counter.count}
                                </td>
                                <td>
                                    
                                    <c:forEach var="dto" items="${listItems}">
                                        <c:if test="${dto.productID==item.key}">
                                            ${dto.productName}
                                        </c:if>
                                    </c:forEach>
                                  
                                </td>
                                <td>
                                    ${item.value}
                                </td>
                                <td>
                                    <input type="checkbox" name="chkItem" value="${item.key}" />
                                </td>
                            </tr>
                        </c:forEach>
                        <tr>
                            <td colspan="3">
                                <a href="loadBooktoShop">Add more to your Cart</a>
                            </td>
                            <td>
                                <input type="submit" value="Remove" class="btn-group-action"/>
                            </td>
                        </tr>
                    </form>
                    <tr>
                        <td colspan="4">
                            <form action="checkOut">
                                <input type="submit" value="Check Out" class="btn-group-action btn-checkout"/>
                            </form>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </c:if>
            <c:if test="${empty result}">
                <h2 style="text-align: center">
                    Your cart is empty.
                    <a href="loadBooktoShop">Back Book Store</a>
                </h2>
            </c:if>
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
    .tbl-search-result{
        font-size: 17px;
        color: #333;
        margin-left: auto;
        margin-right: auto;
        border: none;
    }
    .tbl-search-result th{
        padding: 20px;
        background-color: #cccccc;
        border: none;
    }
    .tbl-search-result td{
        border: #ffffff 3px solid;
        text-align: center;
        padding: 5px;
    }
    .wrapper-cart{
        display: flex;
        flex-direction: column;
        align-content: center;
        justify-content: center;
        align-items: center;
    }
    .btn-group-action{
        padding: 10px;
        background-color: #f0f9f0;
        border: #cccccc 0.5px solid;
    }
    .btn-checkout{
        padding: 10px 150px 10px 150px;
    }
</style>
