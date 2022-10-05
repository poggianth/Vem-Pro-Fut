<%-- 
    Document   : inscricao_confirmada
    Created on : 26/09/2022, 11:37:26
    Author     : Thiago
--%>

<%
    HttpSession sessao = request.getSession();
    if (sessao.getAttribute("idDados") == null) {
        response.sendRedirect("index.jsp");
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <%@include file="icone.txt"%>
        <meta http-equiv="refresh" content="2,url=index_jogador.jsp" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
              integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
        <title>Inscrição Confirmada!</title>
    </head>
    <body class="bg-success">
    <div class="text-center text-white pt-5 mt-5">
        <h1>
            <i class="far fa-check-circle"></i> Inscrição confirmada com sucesso!
        </h1>
        <br>
        <h3>Aguarde a resposta do clube.</h3>
    </div>
</body>
</html>
