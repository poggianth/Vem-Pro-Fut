<%-- 
    Document   : escolhaCadastros
    Created on : 27/08/2022, 10:17:40
    Author     : Thiago
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">

    <head>
        <title>Escolha de Cadastro</title>
        <%@include file="icone.txt"%>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@8/swiper-bundle.min.css" />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
              integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="css/styleEscolha.css">

    </head>

    <body>
        <div class="container-fluid">
            <nav class="navbar" style="margin-bottom: 50px;">
                <!-- Links -->
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a href="index.jsp" style="font-size: 20pt;">
                            <i class="fas fa-arrow-left pr-2"></i>Voltar
                        </a>
                    </li>
                </ul>
            </nav>
        
        </div>
        <br>
        <h1>Escolha seu Tipo de cadastro</h1>
        <div class="container">
            <div class="card">
                <div class="box">
                    <div class="content">
                        <img src="images/clube.png" alt="" style="height: 100px; width: 100px;">
                        <br>
                        <br>
                        <h3>Clube</h3>
                        <p>Caso você seja responsável por um clube e deseja cadastrá-lo, clique no botão abaixo:</p>
                        <a href="cad_clube.jsp">Cadastrar clube</a>
                    </div>
                </div>
            </div>

            <div class="card">
                <div class="box">
                    <div class="content">
                        <img src="images/jogador.png" alt="" style="height: 100px; width: 100px; margin-bottom: 10px">
                        <h3>Jogador</h3>
                        <p>Se você deseja realizar o seu sonho, clique no botão abaixo:</p>
                        <a href="cad_jogador.jsp" id="cadJog">Cadastrar Jogador</a>
                    </div>
                </div>
            </div>
        </div>

    </body>

</html>












<!--
<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
              integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
        <link rel="stylesheet" href="css/style.css">
        <title>Escolha de Cadastro</title>
    </head>

    <body>
        <div class="container-fluid">
            <div class="container">
                <div class="mt-5 text-center">
                    <h1>Escolha de Cadastro</h1>
                </div>
            </div>
        </div>

        <div class="container mt-5">
            <div class="card-deck">
                <div class="card text-center p-3" style="width: 400px;">
                    <img class="card-img-top logo" src="images/clube.png" alt="Card image" style="margin: 0 auto;">
                    <div class="card-body">
                        <h4 class="card-title">Clube</h4>
                        <p class="card-text">Caso você seja responsável por um clube e deseja cadastrá-lo, clique no botão abaixo:</p>
                        <a href="cad_clube.jsp" class="btn" style="background-color: #024059; color: white;">Cadastrar Clube</a>
                    </div>
                </div>

                <div class="card text-center p-3" style="width: 400px;">
                    <img class="card-img-top logo" src="images/jogador.png" alt="Card image" style="margin: 0 auto; width: 130px; height: 150px;">
                    <div class="card-body">
                        <h4 class="card-title">Jogador</h4>
                        <p class="card-text">Se você tem mais de 18 anos e quer realizar seu sonho, clique no botão abaixo:</p>
                        <a href="cad_jogador.jsp" class="btn" style="background-color: #024059; color: white;">Cadastrar Jogador</a>
                    </div>
                </div>
            </div>
        </div>


    </body>

</html>
-->
