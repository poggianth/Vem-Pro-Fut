<%-- 
    Document   : cad_responsavel
    Created on : 27/08/2022, 10:17:24
    Author     : Thiago
--%>

<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <%@include file="icone.txt"%>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
              integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
        <title>Cadastro de Responsável</title>
    </head>

    <body>
        <div class="jumbotron text-center">
            <h1>Cadastro de Responsável</h1>
        </div>

        <div class="container mb-5">
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
            <form action="Controle" method="post">
                <div class="row">
                    <div class="col-3">
                        <label for="nome">Nome completo</label>
                        <input type="text" class="form-control" placeholder="João da Silva" id="nome" name="nome" required>
                        <br>
                    </div>
                    <br>
                    <div class="col-3">
                        <label for="data">Data de Nascimento</label>
                        <input type="date" class="form-control" placeholder="05/02/2004" id="data" name="data" required>
                        <br>
                    </div>
                    <br>
                    <div class="col-3">
                        <p>Sexo: </p>
                        <div class="form-check-inline form-group">
                            <input type="radio" class="form-check-input" id="sexo" name="sexo" value="M" required>Masculino
                            <input type="radio" class="form-check-input ml-3" id="sexo" name="sexo" value="F" required>Feminino
                        </div>
                        <br>
                    </div>
                    <br>
                    <div class="col-3">
                        <label for="telefone">Telefone</label>
                        <input type="text" class="form-control" placeholder="(27)12345-1234" id="telefone" name="telefone" required>
                        <br>
                    </div>
                </div>

                <div class="row">
                    <div class="col-3">
                        <label for="nacionalidade">Nacionalidade</label>
                        <input type="text" class="form-control" placeholder="Brasileiro" id="nacionalidade" name="nacionalidade" required>
                        <br>
                    </div>
                    <br>
                    <div class="col-3">
                        <label for="estado">Estado</label>
                        <input type="text" class="form-control" placeholder="Espirito Santo" id="estado" name="estado" required>
                        <br>
                    </div>
                    <br>
                    <div class="col-3">
                        <label for="cidade">Cidade</label>
                        <input type="text" class="form-control" placeholder="Vila Velha" id="cidade" name="cidade" required>
                        <br>
                    </div>
                    <br>
                    <div class="col-3">
                        <label for="cep">Cep</label>
                        <input type="text" class="form-control" placeholder="29118-035" id="cep" name="cep" required>
                        <br>
                    </div>
                </div>
                <h4>Vamos criar um usuário</h4>
                <div class="row">
                    <div class="col-6">
                        <label for="email">Email</label>
                        <input type="email" class="form-control" placeholder="joao@gmail.com" id="email" name="email" required>
                    </div>
                    <div class="col-3">
                        <label for="senha">Crie uma senha</label>
                        <input type="password" onchange="conferirSenha()" class="form-control" placeholder="123" id="senha" name="senha" required>
                    </div>
                    <div class="col-3">
                        <label for="senha2">Confirme sua senha</label>
                        <input type="password" onchange="conferirSenha()" class="form-control" placeholder="123" id="senha2" name="senha2" required>
                    </div>
                </div>
                <br>
                <div class="text-center">
                    <input value="responsavel" name="tipo" id="tipo" hidden>
                    <input value="cadastrar_responsavel" name="acao" id="acao" hidden>
                    <input class="btn btn-success" type="submit" value="Enviar"></input>
                    <input class="btn btn-danger" type="reset" value="Limpar"></input>
                </div>
            </form>
        </div>

    </body>

</html>