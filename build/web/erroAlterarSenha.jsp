<%-- 
    Document   : erroAlterarSenha
    Created on : 30/09/2022, 10:12:30
    Author     : Thiago
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="icone.txt"%>
        <meta http-equiv="refresh" content="3,url=index.jsp" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
              integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
        <title>ERRO</title>
    </head>
    <body class="bg-danger">
        <div class="jumbotron bg-danger text-white text-center">
            <h1><i class="fas fa-exclamation-circle"></i> OPS!!!</h1>
            <br>
            <h2>Email não encontrado</h2>
            <br>
            <h3>O email que você informou, não está cadastrado no sistema!</h3>
            <br>
            <h4>Informe um email válido ou crie uma conta nova!</h4>
            <br>
            <h5>Você está sendo redirecionado para a página principal!</h5>
        </div>
    </body>
</html>
