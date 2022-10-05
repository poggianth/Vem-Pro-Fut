<%-- 
    Document   : email_ja_cadastrado
    Created on : 29/09/2022, 14:39:25
    Author     : sala304b
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="icone.txt"%>
        <meta http-equiv="refresh" content="2.5,url=index.jsp" />
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
            <h2>Este email já está cadastrado no sistema!!</h2>
            <br>
            <h3>Tente fazer login com este email ou cadastrar outro email.</h3>
            <h4>Você está sendo redirecionado para a página de login!</h4>
        </div>
    </body>
</html>