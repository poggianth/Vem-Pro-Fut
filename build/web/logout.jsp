<%-- 
    Document   : logout
    Created on : 07/09/2022, 10:20:25
    Author     : Thiago
--%>

<%
    HttpSession sessao = request.getSession();
    sessao.invalidate();
    response.sendRedirect("index.jsp");
%>
