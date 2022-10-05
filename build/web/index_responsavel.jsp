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
    } else{
        int idUsu = Integer.parseInt(sessao.getAttribute("idDados").toString());
        System.out.println("Consegui pegar o ID do Usuário: " + idUsu);
    }
%>
<!DOCTYPE html>
<html lang="pt-br">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Vem pro FUT</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">

    <link rel="stylesheet" href="css/style.css">
    <style>
        * {
            color: white;
            font-weight: 500;
        }

        body {
            background-color: black;
            background-attachment: fixed;
            background-repeat: no-repeat;
            background-size: 100%;
        }
    </style>
</head>

<body>
    <!-- Menu de ícones -->
    <div class="container-fluid" id="menu_icones">
        <!-- Div menu icone -->
        <div class="container">
            <div class="row p-2">
                <div class="col-6" style="padding-bottom: 10px;">
                    <i class="fas fa-phone pr-1"></i>+2 123 4567897
                    <i class="far fa-envelope pl-3 pr-1"></i>info@example.com

                </div>

                <div class="col-6 text-right">
                    <nav class="navbar navbar-expand justify-content-end">
                        <ul class="navbar-nav">
                            <i class="fab fa-facebook-f pl-3"></i>
                            <i class="fab fa-twitter pl-3"></i>
                            <i class="fab fa-instagram pl-3"></i>
                            <i class="fab fa-linkedin-in pl-3"></i>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
    </div> <!-- Fim do menu de Ícones -->

    <!-- Início Container-fluid -->
    <div class="container-fluid">
        <div class="container">
            <!-- Container logo e itens -->
            <div class="text-right pt-3">
                <div class="row">
                    <div class="col-3">
                        <a href="#" style="text-decoration: none;">
                            <h1>Vem pro FUT</h1>
                        </a>
                    </div>

                    <div class="col-9">
                        <nav class="navbar navbar-expand-xl justify-content-end">
                            <ul class="navbar-nav">
                                <li class="nav-item mr-3"> 
                                    <a class="nav-link navbar_itens" href="sobre.jsp" target="_self" style="color: white;">Sobre</a>
                                </li>
                                
                                <li class="nav-item mr-3">
                                    <form action="Controle" method="post">
                                        <input type="hidden" value="verPerfil" name="acao" id="acao">
                                        <input type="submit" class="btn btn-azul" value="Meu Perfil">
                                        <!--<button type="submit" class="btn btn-azul"></button>
                                        <a href="perfil.jsp" class="nav-link navbar_itens">Ver perfil</a>-->
                                    </form>
                                    <!--<a href="Controle?acao=verPerfil" class="nav-link navbar_itens">
                                        Ver perfil
                                        <i type="button" class="fas fa-user dropdown" data-toggle="dropdown" style="font-size: 15pt;"></i>
                                    </a>-->
                                </li>
                                <li class="nav-item ml-3">
                                    <div class="dropdown">
                                        <i type="button" class="fas fa-bars dropdown pt-1 mt-1" data-toggle="dropdown" style="font-size: 15pt;"></i>
                                        <div class="dropdown-menu">
                                            <a href="escolhaCadastros.jsp" target="_self" class="dropdown-item btn" style="color: #339900;">Entrar</a>
                                            <a href="logout.jsp" target="_self" class="dropdown-item btn" style="color: #990000;">Sair</a>
                                        </div>
                                    </div>
                                </li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
        </div> 
    </div> <!-- Fim do container-fluid -->
</body>

</html>