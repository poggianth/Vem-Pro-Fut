<%-- 
    Document   : cad_clube
    Created on : 27/08/2022, 10:15:20
    Author     : Thiago
--%>

<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <link rel="icon" type="imagem/ico" href="images/iconeClube.ico" />
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
              integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
        <script type="text/javascript"
        src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
        <link rel="stylesheet" href="css/stylePerfil.css">
        <title>Cadastro de Clube</title>
        <style>
            .form-control{
                border-radius: 50px;
            }
        </style>
    </head>

    <body>
        <script>
            $(document).ready(function () {
                $('#cep').mask('00000-000');
                $('#telefone').mask('(00)00000-0000');
                $('#cnpj').mask('00.000.000/0000-00');
            });

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

        <!-- MODAL CANCELAR ALTERAÇÕES -->
        <div class="modal" id="modalConfirmar">
            <div class="modal-dialog">
                <div class="modal-content">

                    <!-- Modal Header -->
                    <div class="modal-header">
                        <h4 class="modal-title">Cancelar Alteração</h4>
                    </div>

                    <!-- Modal body -->
                    <div class="modal-body"><strong>Todas as alterações serão perdidas.</strong> Tem certeza que deseja cancelar a Alteração de dados?</div>

                    <!-- Modal footer -->
                    <div class="modal-footer" style="margin: 0 auto">
                        <button type="button" class="btn btn-warning" data-dismiss="modal">Não</button>
                        <button type="button" class="btn btn-danger" onclick="location.reload()" data-dismiss="modal">Sim</button>
                    </div>

                </div>
            </div>
        </div>

        <form action="Controle" method="post">

            <div class="wrapper">
                <div class="left">
                    <a href="escolhaCadastros.jsp" class="text-white" style="font-size: 20pt;">
                        <i class="fas fa-arrow-left pr-2"></i>Voltar
                    </a>
                    <h1 style="padding-top: 50px;">
                        <img src="images/clube.png" alt="" height="200px">
                    </h1>
                    <h1 style="padding-top: 50px;">1° Passo</h1>
                    <h1>Vamos criar seu usuario:</h1>
                    <br/>
                    <label for="email">Email</label>
                    <input type="email" class="form-control" placeholder="contato@flamengo.com.br" id="email" name="email" required>
                    <br>
                    <label for="senha">Crie uma senha</label>
                    <input type="password" onchange="conferirSenha()" class="form-control" placeholder="******" id="senha" name="senha" required pattern=".{6,}" title="A senha deve conter 6 dígitos ou mais!">
                    <br>
                    <label for="senha2">Confirme sua senha</label>
                    <input type="password" onchange="conferirSenha()" class="form-control" placeholder="******" id="senha2" name="senha2" required pattern=".{6,}" title="A senha deve conter 6 dígitos ou mais!">
                </div>
                <div class="right">
                    <h1 class="pt-4 text-center" style="border-bottom: 1px solid #008CAB;">Cadastro de Clube</h1>
                    <h1 class="text-center" style="margin-top: 70px">2° Passo</h1>
                    <h1 class="text-center" style="padding-bottom: 30px">Preencha as infomações abaixo:</h1>
                    <div class="row">
                        <div class="col-3">
                            <label for="razao" class="">Razão</label>
                            <input type="text" class="form-control" placeholder="Clube de Regatas do Flamengo" id="razao"
                                   name="razao" required>
                            <br>
                        </div>
                        <br>
                        <div class="col-3">
                            <label for="fantasia">Fantasia</label>
                            <input type="text" class="form-control" placeholder="Flamengo" id="fantasia" name="fantasia" required>
                            <br>
                        </div>
                        <br>
                        <div class="col-3">
                            <label for="fundacao">Data de fundação</label>
                            <input type="date" class="form-control" placeholder="05/02/1875" id="fundacao" name="fundacao" required>
                            <br>
                        </div>
                        <br>
                        <div class="col-3">
                            <label for="pais">País</label>
                            <input type="text" class="form-control" placeholder="Brasil" id="pais" name="pais" required>
                            <br>
                        </div>
                        <br>
                    </div>
                    <div class="row">
                        <div class="col-3">
                            <label for="estado">Estado</label>
                            <input type="text" class="form-control" placeholder="Espirito Santo" id="estado" name="estado" required>
                            <br>
                        </div>
                        <div class="col-3">
                            <label for="cidade">Cidade</label>
                            <input type="text" class="form-control" placeholder="Rio de Janeiro" id="cidade" name="cidade" required>
                            <br>
                        </div>
                        <br>
                        <div class="col-3">
                            <label for="cep">Cep</label>
                            <input type="text" class="form-control" placeholder="29118035" id="cep" name="cep" required>
                            <br>
                        </div>
                        <div class="col-3">
                            <label for="telefone">Telefone</label>
                            <input type="text" class="form-control" placeholder="(27)99244-9243" id="telefone" name="telefone" required>
                            <br>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-3">
                            <label for="cnpj">Cnpj</label>
                            <input type="text" class="form-control" placeholder="80.102.065/0001-82" id="cnpj" name="cnpj" required>
                            <br>
                        </div>
                        <br>
                        <div class="col-3">
                            <label for="sobre">Sobre</label>
                            <input type="text" class="form-control" placeholder="Clube surgiu em 05/02/1875..." id="sobre"
                                   name="sobre" required>
                            <br>
                        </div>
                        <br>
                        <div class="col-3">
                            <label for="resp">Responsável pelo Cadastro</label>
                            <input type="text" class="form-control" placeholder="José da Silva Ribeiro" id="resp" name="resp" required>
                        </div>
                        <br>
                    </div>
                    <br>
                    <div class="text-center mb-5">
                        <input value="clube" name="tipo" id="tipo" hidden>
                        <input value="cadastrar_clube" name="acao" id="acao" hidden>
                        <input class="btn btn-success" type="submit" value="Enviar"></input>
                        <button class="btn btn-danger" type="button" id="cancelar" data-toggle="modal" data-target="#modalConfirmar">
                            Limpar
                        </button>
                    </div>
                </div>
            </div>
        </form>
    </body>
</html>