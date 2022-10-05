<%-- 
    Document   : login
    Created on : 27/08/2022, 10:17:53
    Author     : Thiago
--%>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <%@include file="icone.txt"%>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Vem pro Fut</title>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
              integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/styleLogin.css">

        <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
        <script src="https://kit.fontawesome.com/b99e675b6e.js"></script>

    </head>

    <body>
        <div class="container">
            <div class="row d-flex justify-content-center mt-5">
                <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                    <div class="card py-3 px-2">
                        <img src="img/logoNOVA.png" style="height: 200px; width: 400px; margin-left: 28px;">
                        <p class="text-center mb-3 mt-4">Login</p>
                        <div class="division">
                            <div class="row">
                                <div class="col-3">
                                    <div class="line l"></div>
                                </div>
                                <div class="col-6"><span>ENTRE NA SUA CONTA</span></div>
                                <div class="col-3">
                                    <div class="line r"></div>
                                </div>
                            </div>
                        </div>
                        <form action="Controle" method="post" class="myform">
                            <div class="form-group">

                                <input type="email" class="form-control" id="email" placeholder="joao@gmail.com"
                                       name="email" required>
                            </div>
                            <div class="form-group">

                                <input type="password" class="form-control" id="senha" placeholder="Digite sua senha"
                                       name="senha" required>
                            </div>

                            <div class="form-group mt-3">
                                <input value="entrar" name="acao" id="acao" hidden>
                                <button type="submit" class="btn btn-block btn-primary btn-lg"><small
                                        style="color: white;"><i class="far fa-user pr-2"></i>Entrar</small></button>
                            </div>
                            <p class="text-center mb-3 mt-2">ou</p>
                            <div class="form-group mt-3">
                                <a href="escolhaCadastros.jsp" target="_top" style="text-decoration: none;">
                                    <button type="button" class="btn btn-block btn-primary btn-lg"><small
                                            style="color: white;"><i class="far fa-user pr-2"></i>Criar conta</small></button>
                                </a>
                            </div>
                            <div class="text-center">
                                <a href="esqueciASenha.jsp" class="text-center mt-5 mb-5" target="_top" style="text-decoration: none; color: #008EAA" id="esqueciSenha">Esqueci minha senha</a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>