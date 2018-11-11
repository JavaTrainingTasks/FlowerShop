<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; UTF-8">
    <fmt:setLocale value="${ empty param.lang ? 'en' : param.lang}"/>
    <fmt:setBundle basename="messages" var="bundle"/>
    <title><fmt:message key="indexPage" bundle="${bundle}"/></title>
</head>
<p></p><a href="?lang=en">
    <button>EN</button>
    <p></p></a>
<a href="?lang=ua">
    <button>UA</button>
</a>
<h1><fmt:message key="welcome" bundle="${bundle}"/></h1>
<h2> <fmt:message key="wannaStart"  bundle="${bundle}"/></h2>

</body>
</html>