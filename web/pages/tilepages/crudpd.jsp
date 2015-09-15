<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<link href="<c:url value='/css/main.css'/>" rel="stylesheet" type="text/css"/>
<fmt:setBundle basename="ApplicationResources" />
<title> <fmt:message key="title.crudpd"/> </title>
</head>
<body>
        <h1><fmt:message key="label.crudpd"/></h1>
        <c:url var="url" scope="page" value="/nocturne/addeditpd">
        		<c:param name="name" value=""/>
                <c:param name="description" value=""/>
                <c:param name="duration" value=""/>
                <c:param name="insert" value="true"/>
        </c:url>
       
        <br/><br/>
        <table class="borderAll">
            <tr>
                <th><fmt:message key="label.crudpd.name"/></th>
                <th><fmt:message key="label.crudpd.address"/></th>
                <th><fmt:message key="label.crudpd.datejoin"/></th>
        
            </tr>
        
          <c:forEach var="crudpd" items="${pds}" varStatus="status">
                <tr class="${status.index%2==0?'even':'odd'}">
                    <td class="nowrap">${crudpd.name}</td>
                    <td class="nowrap">${crudpd.address}</td>
                    <td class="nowrap">${crudpd.datejoin}</td>
                    <td class="nowrap">
                        <c:url var="updurl" scope="page" value="/nocturne/addeditrp">
                            <c:param name="name" value="${crudpd.name}"/>
                            <c:param name="address" value="${crudpd.address}"/>
                            <c:param name="datejoin" value="${crudpd.datejoin}"/>
                             <c:param name="insert" value="false"/>
                        </c:url>
                       
                    </td>
                </tr>
            </c:forEach>
                
        </table>
</body>
</html>