<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>

    <meta http-equiv="Content-Type" content="text/html; UTF-8">

    <fmt:setLocale value="${ empty sessionScope.lang ? 'en' : sessionScope.lang}"/>
    <fmt:setBundle basename="messages" var="bundle"/>
    <title><fmt:message key="yourBouqet" bundle="${bundle}"/></title>
</head>
<a href="/"><button><fmt:message key="home"  bundle="${bundle}" /></button></a>
<h2 align="center"><fmt:message key = "yourBouqet"  bundle="${bundle}"/></h2>
<c:if test="${!empty flowers}">

    <h3 align="center"><fmt:message key="flowers" bundle="${bundle}"/></h3>
    <table  style="text-align:center" width="70%">
        <tr>
            <th><fmt:message key="ID" bundle="${bundle}"/> </th>
            <th><fmt:message key="name" bundle="${bundle}"/> </th>
            <th><fmt:message key="colour" bundle="${bundle}"/></th>
            <th><fmt:message key="freshness" bundle="${bundle}"/></th>
            <th><fmt:message key="length" bundle="${bundle}"/></th>
            <th><fmt:message key="price" bundle="${bundle}"/></th>
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

            </tr>
        </c:forEach>
    </table>
</c:if>
<c:if test="${!empty notes}">
    <h3 align="center"><fmt:message key="notes" bundle="${bundle}"/></h3>
    <table  style="text-align:right" width="70%">

        <tr>
            <th><fmt:message key="ID" bundle="${bundle}"/> </th>
            <th><fmt:message key="name" bundle="${bundle}"/> </th>
            <th><fmt:message key="noteMessage" bundle="${bundle}"/></th>
            <th><fmt:message key="price" bundle="${bundle}"/></th>
        </tr>
        <c:forEach var="note" items="${notes}">
            <tr>
                <td>
                    <c:out value="${note.id}"/>
                </td>
                <td>
                    <c:out value="${note.name}"/>
                </td>

                <td>
                    <c:out value="${note.noteMessage}"/>
                </td>
                <td>
                    <c:out value="${note.price}"/>
                </td>

            </tr>
        </c:forEach>
    </table>
</c:if>
<c:if test="${!empty paperWraps}">
    <h3 align="center"><fmt:message key="paperWraps" bundle="${bundle}"/></h3>
    <table  style="text-align:right" width="70%">

        <tr>
            <th><fmt:message key="ID" bundle="${bundle}"/> </th>
            <th><fmt:message key="name" bundle="${bundle}"/> </th>
            <th><fmt:message key="length" bundle="${bundle}"/></th>
            <th><fmt:message key="price" bundle="${bundle}"/></th>
        </tr>
        <c:forEach var="note" items="${paperWraps}">
            <tr>
                <td>
                    <c:out value="${note.id}"/>
                </td>
                <td>
                    <c:out value="${note.name}"/>
                </td>

                <td>
                    <c:out value="${note.length}"/>
                </td>
                <td>
                    <c:out value="${note.price}"/>
                </td>

            </tr>
        </c:forEach>
    </table>
</c:if>
<c:if test="${empty hide}">
<h2 align="center"><fmt:message key="total" bundle="${bundle}"/> ${bouquet.price} </h2>
<form>
    <input type="hidden" name="bouquetID" value="${bouquet.id}">
    <button type="submit" name="command" value="SortByFreshness"><fmt:message key="sortByFreshness" bundle="${bundle}"/></button>
</form>
<form>
    <p><input type= "text" name="lowRange"></p>
    <p> <input type ="text" name="highRange"></p>
    <input type="hidden" name="bouquetID" value="${bouquet.id}">
    <button type="submit" name="command" value="FindInLengthRange"><fmt:message key="findInRange" bundle="${bundle}"/> </button>
</form>
</c:if>

</body>
</html>
