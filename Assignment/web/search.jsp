<%-- 
    Document   : search
    Created on : Dec 13, 2019, 5:34:12 PM
    Author     : SE130162
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search</title>
    </head>
    <body>
        <div class="hearder">
            <section class="box-logout">
                <span class="badge-welcome">Welcome ${sessionScope.USERNAME}</span>
                <a class="btn-action-logout" href="logout">Log out</a>   
            </section>

            <section class="field-header">
                <h1 style="text-align: center; font-size: 40px;"> Search Page</h1>
            </section>
        </div>
        <div class="search-wrapper">

            <form class="search-form"action="search">
                <span >Search Value :</span>
                <input type="text" name="txtSearchValue" value="${param.txtSearchValue}"/>
                <input class="btn-search"type="submit" value="Search" />
            </form>
            <a href="loadBooktoShop">Book Store</a>
            <c:set var="searchValue" value="${param.txtSearchValue}"/>
            <c:if test="${not empty searchValue}">
                <c:set var="result" value="${requestScope.SEARCHRESULT}"/>
                <c:if test="${not empty result}">
                    <table border="1" class="tbl-search-result">
                        <thead>
                            <tr>
                                <th>No.</th>
                                <th>Username</th>
                                <th>Password</th>
                                <th>Last Name</th>
                                <th>Role</th>
                                <th>Delete</th>
                                <th>Update</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="dto" items="${result}" varStatus="counter">
                            <form action="update">
                                <tr>
                                    <td>${counter.count}</td>
                                    <td>
                                        ${dto.username}
                                        <input type="hidden" name="Username" value="${dto.username}" />
                                    </td>
                                    <td>
                                        <input type="password" name="txtPassword"
                                               value="${dto.password}" />
                                        <input type="hidden" name="Password" value="${dto.password}" />
                                    </td>
                                    <td>
                                        ${dto.lastname}
                                    </td>
                                    <td>
                                        <input type="checkbox" name="chkAdmin" value="admin" <c:if test="${dto.isAdmin}">
                                               checked
                                            </c:if>
                                            />
                                    </td>
                                    <td>
                                        <c:url var="urlRewriting" value="delete">
                                            <c:param name="Username" value="${dto.username}"/>
                                            <c:param name="lastSearchValue" value="${searchValue}"/>
                                        </c:url>
                                        <a href="${urlRewriting}">Delete</a>
                                    </td>
                                    <td>
                                        <input type="submit" value="Update"/> 
                                        <input type="hidden" name="lastSearchValue" value="${searchValue}" />
                                    </td>
                                </tr>
                            </form>
                        </c:forEach>
                        </tbody>
                    </table>
                </c:if>
                <c:if test="${empty result}">
                    <h2> No record is matched !!!</h2>
                </c:if>
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
    .field-header{
        margin-bottom: 50px;
        box-sizing: border-box;
    }
    .tbl-search-result{
        font-family: monospace;
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
    .box-logout{
        padding: 5px;
        border: 0.1px #cccccc dotted;
        float:right;
        font-size:12px;  
        display: block;
        position: relative;
    }
    .hearder{
        width: 100%;
        margin-bottom: 20px;
        height: auto;
        border-bottom: #f7ffff 0.1px solid;
    }
    .search-wrapper{
        width: 100%;
        height: auto;
        clear: both;
        margin-top: 20px;
        padding: 40px 0 20px 20px;
        border: 1px #cccccc dashed;
    }
    .badge-welcome{
        text-align: center;
    }
    .search-form{
        margin-top: 30px;
        margin-bottom: 30px;
        text-align: center;
    }
    .btn-search{
        padding: 5px;
        background-color: #f9f9f9;
        border: #cccccc 0.5px solid;       
    }.btn-search:hover{
        background-color: #f0f9f0;        
    }
</style>
