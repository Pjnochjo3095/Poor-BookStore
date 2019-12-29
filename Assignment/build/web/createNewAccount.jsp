<%-- 
    Document   : createAccount
    Created on : Dec 15, 2019, 6:45:19 PM
    Author     : SE130162
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Account</title>
    </head>
    <body>
        <div class="login-box flex-row flex-center">
            <fieldset class="outside-form">
                <legend><h2>Sign Up Form</h2></legend>
                <form action="createAccount" method="POST">
                    <c:set var="er" value="${requestScope.CREATEERROR}"/>
                    <div class="wrapper-line">Username *:<input type="text" name="txtUsername" value="${param.txtUsername}" placeholder="Input username here" size="20"/>
                        <c:if test="${not empty er.usernameLengthError}">
                            <p style="color:red;font-size: 10px;">
                                ${er.usernameLengthError}
                            </p>
                        </c:if>
                    </div>
                    <div class="wrapper-line">Password *:<input type="password" name="txtPassword" value=""  placeholder="Input password here"/>
                        <c:if test="${not empty er.passwordLengthError}">
                            <p style="color:red;font-size: 10px;">
                                ${er.passwordLengthError}
                            </p>
                        </c:if>
                    </div>
                    <div class="wrapper-line">Confirm&nbsp; *:<input type="password" name="txtConfirm" value=""/>
                        <c:if test="${not empty er.confirmIsNotMatched}">
                            <p style="color:red;font-size: 10px;">
                                ${er.confirmIsNotMatched}
                            </p>
                        </c:if>
                    </div>
                    <div class="wrapper-line">LastName *:<input type="text" name="txtLastName" value="${param.txtLastName}"  placeholder="Input Last Name here"/>
                        <c:if test="${not empty er.lastNameLengthError}">
                            <p style="color:red;font-size: 10px;">
                                ${er.lastNameLengthError}
                            </p>
                        </c:if>
                    </div>
                    <div>
                        <input class="btn-group-action" type="submit" value="Sign up"/>
                        <input class="btn-group-action" style="float: right" type="reset" value="Reset" name="BtAction" />
                        <p>
                            <c:if test="${not empty er.usernameIsExisted}">
                                 <p style="color:red;font-size: 10px;">
                                ${er.usernameIsExisted}
                            </p>
                            </c:if>
                        </p>
                    </div>
                </form>
             <a href="login.html">Already has an account</a>
            </fieldset>
        </div>
    </body>
</html>
<style>
    .container{
        width: 1350px;
        height: auto;
        box-sizing: border-box;
    }
    a{
        text-decoration: none;
        color: #4d62ff;
    }
    body{
        color: #333;
        font-family: monospace;
        background-color: #f9f9f9;
    }
    .flex-colum{
        display:  flex;
        flex-direction: column;
    }
    .flex-row{
        display: flex;
        flex-direction: row;
    }
    .flex-center{
        align-content: center;
        justify-content: center;
        align-items: center;
    }
    .login-box{
        padding-top: 100px;
        margin-left: auto;
        margin-right: auto;
    }
    .wrapper-line{
        margin-bottom:20px;
        letter-spacing: 0.8;
        font-size: 17px;
    }
    .btn-group-action{
        padding: 10px;
        background-color: #f0f9f0;
        border: #cccccc 0.5px solid;
    }
    .outside-form{
        padding: 50px;    
    }
</style>