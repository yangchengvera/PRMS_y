<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<link href="<c:url value='/css/main.css'/>" rel="stylesheet" type="text/css"/>
<fmt:setBundle basename="ApplicationResources" />
<title> <fmt:message key="title.crudpresenter"/> </title>
</head>
<body>
        <h1><fmt:message key="label.crudpresenter"/></h1>
        <c:url var="url" scope="page" value="/nocturne/addeditrp">
        		<c:param name="name" value=""/>
                <c:param name="address" value=""/>
                <c:param name="joinDate" value=""/>
                <c:param name="insert" value="true"/>
        </c:url>
	<c:if test="${sessionScope.user.roles[0].role==('admin')}">
        <a href="${url}"><fmt:message key="label.crudrp.add"/></a>
	</c:if>
        <br/><br/>
        <table class="borderAll">
            <tr>
                <th><fmt:message key="label.crudpresenter.name"/></th>
                <th><fmt:message key="label.crudpresenter.address"/></th>
                <th><fmt:message key="label.crudpresenter.joinDate"/></th>
                <th><fmt:message key="label.crudpresenter.edit"/> <fmt:message key="label.crudrp.delete"/></th>
            </tr>
            <c:forEach var="crudpresenter" items="${prs}" varStatus="status">
                <tr class="${status.index%2==0?'even':'odd'}">
                    <td class="nowrap">${crudpresenter.name}</td>
                    <td class="nowrap">${crudpresenter.address}</td>
                    <td class="nowrap">${crudpresenter.joinDate}</td>
                    <td class="nowrap">
                        <c:url var="updurl" scope="page" value="/nocturne/addeditrp">
                            <c:param name="name" value="${crudpresenter.name}"/>
                            <c:param name="address" value="${crudpresenter.address}"/>
                            <c:param name="joinDate" value="${crudpresenter.joinDate}"/>
                             <c:param name="insert" value="false"/>
                        </c:url>
                        <a href="${updurl}"><fmt:message key="label.crudpresenter.edit"/></a>
                        &nbsp;&nbsp;&nbsp;
                        <c:url var="delurl" scope="page" value="/nocturne/deleterp">
                            <c:param name="name" value="${crudrp.name}"/>
                        </c:url>
                        <a href="${delurl}"><fmt:message key="label.crudpresenter.delete"/></a>
                    </td>
                </tr>
            </c:forEach>
        </table>
</body>
</html>