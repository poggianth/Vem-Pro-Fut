<%-- 
    Document   : index
    Created on : 27/08/2022, 10:19:44
    Author     : Thiago
--%>

<%@page import="model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession sessao = request.getSession();
    if (sessao.getAttribute("idDados") == null) {
        response.sendRedirect("index.jsp");
    } else {
        int idUsu = Integer.parseInt(sessao.getAttribute("idDados").toString());
        System.out.println("Consegui pegar o ID do Usuário: " + idUsu);
    }
%>


<!DOCTYPE html>
<html lang="pt-BR">

    <head>
        <%@include file="icone.txt"%>
        <title>Página Inicial</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@8/swiper-bundle.min.css"/>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="css/styleIndexClu.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
        <style>
            i.dropdown:hover{
                cursor: pointer;
            }
        </style>
    </head>


    <body>

        <!--!Inicio da Navbar-->
        <div class="container-fluid" id="nav">
            <div class="container navbar navbar-expand-sm navbar-light pt-4 pb-4" id="cabecalho">
                <a class="navbar-brand">
                    <img src="img/LOGO.png" alt="logo" style="width: 60px">
                </a>
                <ul class="navbar-nav col justify-content-end">
                    <li class="nav-item pr-2">
                        <a class="nav-link" style="margin-top: 2px;" href="sobre.jsp" id="itens">Sobre</a>
                    </li>
                    <li class="nav-item dropdown pr-4">
                        <form action="Controle" method="post">
                            <input type="hidden" value="verPerfil" name="acao" id="acao">
                            <button type="submit" style="background-color: white; border: none;"><i class="bi bi-person-fill login"></i></button>
                        </form>
                    </li>
                    <li class="nav-item">
                        <div class="dropdown">
                            <i class="bi bi-list login dropdown" data-toggle="dropdown"></i>
                            <div class="dropdown-menu">
                                <a class="dropdown-item" href="logout.jsp" id="sair">Sair</a>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
        <!--Final da Navbar-->

        <br>

        <!--Primeiro Titulo-->
        <div class="container-fluid text-center titulos pb-3">
            <h1>Vagas Disponíveis</h1>
            <br>
        </div>
        <!--Final do Primeiro Titulo-->

        <!--/////////////////////////////////////////////////////////////////////////-->

        <!--Inicio do Carrossel de Cards-->
        <div class="slide-container swiper">
            <div class="slide-content">
                <div class="card-wrapper swiper-wrapper">
                    <div class="card swiper-slide">
                        <div class="image-content">
                            <span class="overlay"></span>

                            <div class="card-image">
                                <img src="img/caneta.png" alt="" class="card-img pr-2"
                                     style="height: 110px; width: 110px;">
                            </div>
                        </div>

                        <div class="card-content">
                            <h2 class="name">CADASTRE UMA VAGA</h2>
                            <p class="description">
                                Adicione uma vaga e ache aquele seu futuro jogador(a)
                                <br>Cadastre de acordo com seus requisitos e preferências
                            </p>

                            <form action="Controle" method="post">
                                <input type="hidden" value="entrarCadVagas" name="acao" id="acao">
                                <input type="submit" class="button" value="Adicionar Vagas">
                            </form>
                        </div>
                    </div>

                    <div class="card swiper-slide">
                        <div class="image-content">
                            <span class="overlay"></span>

                            <div class="card-image">
                                <img src="img/olho.png" alt="" class="card-img"
                                     style="height: 120px; width: 100px;">
                            </div>
                        </div>

                        <div class="card-content">
                            <h2 class="name">VER MINHAS VAGAS</h2>
                            <p class="description">
                                Veja todas as vagas que você cadastrou
                                <br>
                                Com certeza você já conseguiu aquele jogador(a) que você queria.
                                Caso contrário, relaxe, aqui você acha rapidin
                            </p>

                            <form action="Controle" method="post">
                                <input type="hidden" value="listarVagasPorClube" name="acao" id="acao">
                                <input type="submit" class="button" value="Minhas Vagas">
                            </form>
                        </div>

                    </div>

                    <div class="card swiper-slide">
                        <div class="image-content">
                            <span class="overlay"></span>

                            <div class="card-image">
                                <img src="img/caderno.novo.png" alt="" class="card-img" style="height: 120px; width: 100px;">
                            </div>
                        </div>

                        <div class="card-content">
                            <h2 class="name">VISÃO COMPLETA</h2>
                            <p class="description">
                                Veja todas as vagas disponíveis no momento
                                <br>
                                Não perca tempo e abrace a 
                                <br>
                                oportunidade!  
                            </p>

                            <a class="button" href="Controle?acao=verTodasVagas_clube">Ver vagas</a>
                        </div>
                    </div>
                </div>

            </div>
        </div>
        <!--Final do Carrossel de Cards-->

        <!--/////////////////////////////////////////////////////////////////////////-->


        <!--Inicio do Rodape-->
        <nav class="navbar navbar-expand-sm fixed-bottom text-white pt-" id="rodape">
            <ul class="navbar-nav" style="margin: 0 auto;">
                <li class="nav-item mr-4">
                    <a class="nav-link itens_rodape" href="#"><i class="bi bi-instagram pr-2"></i><strong class="nomes_rodape">@vemprofut</strong></a>
                </li>
                <li class="nav-item mr-4">
                    <a class="nav-link itens_rodape" href="#"><strong>Vem pro Fut&copy;</strong></a>
                </li>
                <li class="nav-item mr-4">
                    <a class="nav-link itens_rodape" href="#"><i class="bi bi-whatsapp pr-2"></i><strong>27 997110344</strong></a>
                </li>
            </ul>
        </nav>
    </div>
    <!--Final do Rodape-->

</body>

<script src="js/swiper-bundle.min.js"></script>
<script src="js/script_novo_clube.js"></script>

</html>