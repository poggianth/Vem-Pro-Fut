<%-- 
    Document   : esqueciASenha
    Created on : 30/09/2022, 09:20:33
    Author     : Th
--%>

<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="icone.txt"%>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
              integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/styleLogin.css">

        <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
        <title>Esqueci a senha</title>
    </head>
    <body>
        <script>
            function conferirSenha() {
                const senha = document.querySelector('input[name=senha]');
                const confirma = document.querySelector('input[name=senha2]');

                if (confirma.value === senha.value) {
                    confirma.setCustomValidity('')
                } else {
                    confirma.setCustomValidity('As senhas não conferem')
                }
            }
        </script>
        <div class="container">
            <div class="row d-flex justify-content-center mt-5">
                <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                    <div class="card py-3 px-2">
                        <img src="img/logoNOVA.png" style="height: 200px; width: 400px; margin-left: 28px;">
                        <div class="division">
                            <div class="row">
                                <div class="col-3">
                                    <div class="line l"></div>
                                </div>
                                <div class="col-6"><span>RECUPERAÇÃO DE SENHA</span></div>
                                <div class="col-3">
                                    <div class="line r"></div>
                                </div>
                            </div>
                        </div>
                        <form action="Controle" method="post" class="myform">
                            <div class="form-group">
                                <label for="email">Informe seu email</label>
                                <input type="email" class="form-control" id="email" placeholder="joao@gmail.com"
                                       name="email" required>
                            </div>
                            <div class="form-group">
                                <label for="senha">Crie uma nova senha</label>
                                <input type="password" onchange="conferirSenha()" class="form-control" id="senha" placeholder="********"
                                       name="senha" required pattern=".{6,}" title="A senha deve conter 6 dígitos ou mais!">
                            </div>
                            <div class="form-group">
                                <label for="senha2">Confirme sua nova senha</label>
                                <input type="password" onchange="conferirSenha()" class="form-control" id="senha2" placeholder="********"
                                       name="senha2" required pattern=".{6,}" title="A senha deve conter 6 dígitos ou mais!">
                            </div>

                            <div class="form-group mt-3">
                                <input value="esqueciASenha" name="acao" id="acao" hidden>
                                <button type="submit" class="btn btn-block btn-primary btn-lg"><small
                                        style="color: white;"><i class="far fa-check-circle pr-2"></i>Feito</small></button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
