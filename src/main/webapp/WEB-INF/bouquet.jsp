<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; UTF-8">

    <fmt:setLocale value="${empty param.lang ? 'en' : param.lang}"/>
    <fmt:setBundle basename="messages" var="bundle"/>
    <title><fmt:message key="bouquetBuild" bundle="${bundle}"/></title>
</head>
<form action="/" method="get">
    <button name="lang" type="submit" value="en">EN</button>
    <button name="lang" type="submit" value="ua">UA</button>
</form>
<body>

<table style="width:100%">
    <tr>
        <th><fmt:message key="ID" bundle="${bundle}"/> </th>
        <th><fmt:message key="name" bundle="${bundle}"/> </th>
        <th><fmt:message key="colour" bundle="${bundle}"/></th>
        <th><fmt:message key="freshness" bundle="${bundle}"/></th>
        <th><fmt:message key="length" bundle="${bundle}"/></th>
        <th><fmt:message key="price" bundle="${bundle}"/></th>
        <th><fmt:message key="chosen" bundle="${bundle}"/></th>
    </tr>
    <c:forEach var="flower" items="${flowers}">
    <tr>
        <td>
            <c:out value="${flower.id}"/>
        </td>
        <td>
        <c:out value="${flower.name}"/>
        </td>
        <td>
            <c:out value="${flower.colour}"/>
        </td>
        <td>
            <c:out value="${flower.freshness}"/>
        </td>
        <td>
            <c:out value="${flower.length}"/>
        </td>
        <td>
            <c:out value="${flower.price}"/>
        </td>
        <td>
            <input type="checkbox" id="${flower.id}" name="scales">
        </td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
