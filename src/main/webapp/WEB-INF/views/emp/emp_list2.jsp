<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table width="500" cellpadding="0" cellspacing="0" border="1">
      <tr>
         <td>사원번호</td>
         <td>사원이름</td>
         <td>직업</td>
         <td>매니저</td>
         <td>입사일</td>
         <td>급여</td>
         <td>커미션</td>
         <td>부서번호</td>
      </tr>
      <c:forEach var="emp" items="${emps}">
      <tr>
         <td><a href="/emp/content_view?empno=${emp.empno}">${emp.empno}</a></td>
         <td>${emp.ename}</td>
         <td>${emp.job}</td>
         <td>${emp.mgr}</td>
         <td>${emp.hiredate}</td>
         <td>${emp.sal}</td>
         <td>${emp.comm}</td>
         <td>${emp.deptno}</td>
      </tr>
      </c:forEach>
      <tr>
         <td colspan="5"> <a href="write_view">글작성</a> </td>
      </tr>
   </table>
   
   
   	<c:if test="${pageMaker.prev}">
		<a href="list2${pageMaker.makeQuery(pageMaker.startPage - 1) }">«</a>
	</c:if>

	<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }"
		var="idx">
		<c:out value="${pageMaker.cri.pageNum == idx?'':''}" />
		<a href="list2${pageMaker.makeQuery(idx)}">${idx}</a>
	</c:forEach>

	<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
		<a href="list2${pageMaker.makeQuery(pageMaker.endPage +1) }"> » </a>
	</c:if>
	<br>
   
   
</body>
</html>