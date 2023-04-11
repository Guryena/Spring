<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>

   <table id="list-table" width="500" cellpadding="0" cellspacing="0" border="1">
      <form action="modify" method="post">
         <input type="hidden" name="empno" value="${content_view.empno}">
         <tr>
            <td> 사원번호 </td>
            <td> ${content_view.empno} </td>
         </tr>
         <tr>
            <td> 이름 </td>
            <td> ${content_view.ename} </td>
         </tr>
         <tr>
            <td> 직업 </td>
            <td> ${content_view.job} </td>
         </tr>
         <tr>
            <td> 매니저 </td>
            <td> ${content_view.mgr} </td>
         </tr>
         <tr>
            <td> 입사일 </td>
            <td> ${content_view.hiredate} </td>
         </tr>
         <tr>
            <td> 급여 </td>
            <td> ${content_view.sal} </td>
         </tr>
         <tr>
            <td> 커미션 </td>
            <td> ${content_view.comm} </td>
         </tr>
         <tr>
            <td> 부서번호 </td>
            <td> ${content_view.deptno} </td>
         </tr>
         
         
         <tr >
            <td colspan="2"> <input type="submit" value="수정"> &nbsp;&nbsp; <a href="list">목록보기</a> </td>
         </tr>
      </form>
   </table>
   
</body>
</html>