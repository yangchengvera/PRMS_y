<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<fmt:setBundle basename="ApplicationResources" />

<h3 align="center">
	<fmt:message key="caption.menu" />
</h3>
<table class="framed">
	<tr>
		<td><a href="<c:url value="/pages/login.jsp"/>"> <fmt:message
					key="caption.menu.login" />
		</a></td>
	</tr>
	<c:if test="${sessionScope.user.roles[0].role=='manager'}">
	<tr>
		<td>
				<a href="<c:url value="/nocturne/searchrp"/>"> <fmt:message
						key="caption.menu.searchrp" />
				</a>
			</td>
	</tr>

	<tr>
		<td>
				<a href="<c:url value="/nocturne/managerp"/>"> <fmt:message
						key="caption.menu.managerp" />
				</a>
			</td>
	</tr>
       
        <tr>
		<td>
				<a href="<c:url value="/nocturne/managepd"/>"> <fmt:message
						key="caption.menu.managepd" />
				</a>
			</td>
	</tr>
      
	</c:if>
        <c:if test="${(sessionScope.user.roles[0].role=='producer')}">
	<tr>
		<td>
				<a href="<c:url value="/nocturne/searchrp"/>"> <fmt:message
						key="caption.menu.searchrp" />
				</a>
			</td>
	</tr>

	<tr>
		<td>
				<a href="<c:url value="/nocturne/managerp"/>"> <fmt:message
						key="caption.menu.managerp" />
				</a>
			</td>
	</tr>
       
        <tr>
		<td>
	
                                    <form name="submitForm" method="POST" action="${pageContext.request.contextPath}/nocturne/onlypd">
                                    <input type="hidden" name="producer" value="${sessionScope.user.id}">
                                    <A HREF="javascript:document.submitForm.submit()">
                                        <fmt:message key="caption.menu.viewpersonaldetail" />
                                        </A>                                         
                                    </form>
				
			</td>
	</tr>
      
	</c:if>
	<tr>
		<td><a href="<c:url value="/nocturne/logout"/>"> <fmt:message
					key="caption.menu.logout" />
		</a></td>
	</tr>
</table>


