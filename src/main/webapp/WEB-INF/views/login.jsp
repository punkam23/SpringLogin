<%--
  Created by IntelliJ IDEA.
  User: yehoshuamatamorosvalverde
  Date: 11/12/16
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login Form Intertec</title>
</head>
<body>
<form:form name="submitForm" method="POST" commandName="LoginBean" action="dosomething">

    <div align="center">
        <table>
            <tr>
                <td>Login Name</td>
                <td><input type="text" name="name" /></td>
                <br />
                <form:errors path="name" cssClass="error" />
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Submit" /></td>
            </tr>
        </table>
        <div style="color: red">${error}</div>

    </div>
</form:form>
</body>
</html>
