<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 3/11/21
  Time: 9:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Simple Calculator</title>
</head>
<body>
<h1>Simple Calculator</h1>
<form method="post" action="/calculator">
    <fieldset>
        <legend style="font-weight: bold">Calculator</legend>
        <table>
            <tr>
                <td>First operand: </td>
                <td><input name="first-operand" type="text"/></td>
            </tr>
            <tr>
                <td>Operator: </td>
                <td>
                    <select name="operator">
                        <option value="+">Addition</option>
                        <option value="-">Subtraction</option>
                        <option value="*">Multiplication</option>
                        <option value="/">Division</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Second operand: </td>
                <td><input name="second-operand" type="text"/></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Calculate"/></td>
            </tr>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
