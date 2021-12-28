<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
    <c:when test="${uid == null}">
        <li><a href="new.jsp" class="button primary">Sign-Up</a></li>
    </c:when>
    <c:otherwise>
        <li><a href="productList.do" class="button primary">Try-Out</a></li>
    </c:otherwise>
</c:choose>

<%--1. form 을 각각의 상황에 대해 사용할 수 있도록 분리
2. action 파라미터를 이용--%>