<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 11/12/2021
  Time: 10:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Sandwich</title>

</head>
<body>
<form method="post" action="/calculator">
    <h2>Calculator</h2>
    <div>
        <span>First operand: </span>
        <input type="number" name="number1" >
    </div>
    <br>
    <div>
        <span>Operator</span>
        <select name="operator" >
            <option>Addition</option>
            <option value="+">+</option>
            <option value="-">-</option>
            <option value="*">*</option>
            <option value="/">/</option>
        </select>
    </div>
    <br>
    <div>
        <span>Second operand: </span>
        <input type="number" name="number2" >
    </div>
    <br>
    <div>
        <input type="submit" value="Calculate">
    </div>
    <div>
    <h4>Result: ${result}</h4>
    </div>
</form>
<script src="/assert/jquery/jquery-3.5.1.min.js"></script>
</body>
</html>
