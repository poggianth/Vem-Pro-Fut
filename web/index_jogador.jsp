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
        <link rel="stylesheet" href="css/styleIndexJog.css">
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
                    <a class="navbar-item pr-2">
                        <a class="nav-link" style="margin-top: 2px;" href="sobre.jsp" target="_blank" id="itens">Sobre</a>
                    </a>
                    <li class="nav-item pr-4">
                        <form action="Controle" method="post">
                            <input type="hidden" value="verPerfil" name="acao" id="acao">
                            <button type="submit" style="background-color: white; border: none;"><i class="bi bi-person-fill login"></i></button>
                        </form>
                    </li>
                    <li class="nav-item">
                        <div class="dropdown">
                            <i class="bi bi-list login dropdown" data-toggle="dropdown"></i>
                            <div class="dropdown-menu">
                                <a class="dropdown-item" href="Controle?acao=minhas_inscricoes">Minhas inscrições</a>
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
        <div class="container-fluid text-center titulos">
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
                                <img src="img/caderno.novo.png" alt="" class="card-img" style="height: 120px; width: 100px;">
                            </div>
                        </div>

                        <div class="card-content">
                            <h2 class="name">TODAS AS VAGAS</h2>
                            <p class="description">
                                Veja todas as vagas disponíveis no momento
                                <br>
                                Não perca tempo e abrace a 
                                <br>
                                oportunidade!  
                            </p>

                            <a class="button" href="Controle?acao=verTodasVagas">Ver vagas</a>
                        </div>
                    </div>

                    <div class="card swiper-slide">
                        <div class="image-content">
                            <span class="overlay"></span>

                            <div class="card-image">
                                <img src="img/GOLEIRO.png" alt="" class="card-img pr-2"
                                     style="height: 100px; width: 100px;">
                            </div>
                        </div>

                        <div class="card-content">
                            <h2 class="name">GOLEIRO</h2>
                            <p class="description">
                                "Passou cola nas luvas"
                                <br>Se você se cadastrar no Vem Pro Fut, você vai começar a ouvir isso!
                                <br>Você vai virar a nova muralha da China
                            </p>

                            <a class="button" href="Controle?acao=verVagas&posicao=Goleiro">Ver vagas</a>
                        </div>
                    </div>

                    <div class="card swiper-slide">
                        <div class="image-content">
                            <span class="overlay"></span>

                            <div class="card-image">
                                <img src="img/zagueiro.png" alt="" class="card-img"
                                     style="height: 114px; width: 100px;">
                            </div>
                        </div>

                        <div class="card-content">
                            <h2 class="name">ZAGUEIRO</h2>
                            <p class="description">
                                Chama o xerife!
                                <br>E adivinha quem chegou? Você!!
                                <br>Vem com raça e talento
                                <br>Nosso futuro capitão
                            </p>

                            <a class="button" href="Controle?acao=verVagas&posicao=Zagueiro">Ver vagas</a>
                        </div>


                    </div>
                    <div class="card swiper-slide">
                        <div class="image-content">
                            <span class="overlay"></span>

                            <div class="card-image">
                                <img src="img/LATERAL.png" alt="" class="card-img" style="height: 110px; width: 110px;">
                            </div>
                        </div>

                        <div class="card-content">
                            <h2 class="name">LATERAL</h2>
                            <p class="description">
                                Cara, tenho certeza que você não cruza, você coloca com a mão!!
                                <br>Vem fazer o arco, mas tem que ter fôlego 
                                É certo que você tem
                            </p>

                            <a class="button" href="Controle?acao=verVagas&posicao=Lateral">Ver vagas</a>
                        </div>
                    </div>

                    <div class="card swiper-slide">
                        <div class="image-content">
                            <span class="overlay"></span>

                            <div class="card-image">
                                <img src="img/volante.png" alt="" class="card-img" style="height: 115px; width: 115px;">
                            </div>
                        </div>

                        <div class="card-content">
                            <h2 class="name">VOLANTE</h2>
                            <p class="description">
                                Solta a coleira, cachorrão ta na área
                                <br>
                                O meia do outro time está vindo, o seu treinador grita
                                <br>
                                "PEGA PITBULL" RUF RUF
                            </p>

                            <a class="button" href="Controle?acao=verVagas&posicao=Volante">Ver vagas</a>
                        </div>
                    </div>

                    <div class="card swiper-slide">
                        <div class="image-content">
                            <span class="overlay"></span>

                            <div class="card-image">
                                <img src="img/meiocampo.png" alt="" class="card-img" style="height: 150px; width: 100px; padding-bottom: 30px;">
                            </div>
                        </div>

                        <div class="card-content">
                            <h2 class="name">MEIO CAMPO</h2>
                            <p class="description">
                                Elegância dentro de campo?
                                <br>Só quem é do Vem Pro Fut tem
                                <br>
                                Aqui só tem meio campista com mente fria e no pé uma mira
                            </p>

                            <a class="button" href="Controle?acao=verVagas&posicao=Meio Campo">Ver vagas</a>
                        </div>
                    </div>

                    <div class="card swiper-slide">
                        <div class="image-content">
                            <span class="overlay"></span>

                            <div class="card-image">
                                <img src="img/meia.png" alt="" class="card-img" style="height: 110px; width: 90px;">
                            </div>
                        </div>

                        <div class="card-content">
                            <h2 class="name">MEIA</h2>
                            <p class="description">
                                Com a visão que você tem, as pessoas vão achar que você ta de lupa
                                <br>Raciocínio rápido, com a certeza vai estudar o seu cérebro
                            </p>

                            <a class="button" href="Controle?acao=verVagas&posicao=Meia">Ver vagas</a>
                        </div>
                    </div>

                    <div class="card swiper-slide">
                        <div class="image-content">
                            <span class="overlay"></span>

                            <div class="card-image">
                                <img src="img/ponta.png" alt="" class="card-img" style="height: 115px; width: 100px;">
                            </div>
                        </div>

                        <div class="card-content">
                            <h2 class="name">PONTA</h2>
                            <p class="description">
                                Você só não vai ser o melhor do planeta, porque você não é desse planeta
                                <br>
                                Ao infinito e além!
                                <br>Velocidade, astucia e turbina no pé
                            </p>

                            <a class="button" href="Controle?acao=verVagas&posicao=Ponta">Ver vagas</a>
                        </div>
                    </div>

                    <div class="card swiper-slide">
                        <div class="image-content">
                            <span class="overlay"></span>

                            <div class="card-image">
                                <img src="img/atacante.png" alt="" class="card-img" style="height: 120px; width: 100px;">
                            </div>
                        </div>

                        <div class="card-content">
                            <h2 class="name">ATACANTE</h2>
                            <p class="description">
                                "Cruza" - Gol!
                                <br>
                                "Toca" - Gol!
                                <br>
                                Não importa como ela vem, o certo é que a bola vai para o fundo da rede
                            </p>

                            <a class="button" href="Controle?acao=verVagas&posicao=Atacante">Ver vagas</a>
                        </div>
                    </div>
                </div>

            </div>

            <div class="swiper-button-next swiper-navBtn"></div>
            <div class="swiper-button-prev swiper-navBtn"></div>
            <div class="swiper-pagination"></div>
        </div>
        <!--Final do Carrossel de Cards-->

        <!--/////////////////////////////////////////////////////////////////////////-->

        <!--Inicio do Rodape-->
        <nav class="navbar navbar-expand-sm text-white pt-3 fixed-bottom" id="rodape">
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

    <!--/////////////////////////////////////////////////////////////////////////-->

</div>

</body>
<script src="js/swiper-bundle.min.js"></script>
<script src="js/indexJogador.js"></script>
</html>