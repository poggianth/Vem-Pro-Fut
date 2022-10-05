<%-- 
    Document   : usuario
    Created on : 13/09/2022, 16:37:30
    Author     : sala304b
--%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<%
    HttpSession sessao = request.getSession();
    if (sessao.getAttribute("idDados") == null) {
        response.sendRedirect("index.jsp");
    }
%>
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
        <link rel="stylesheet" href="css/stylePerfil.css">
        <script type="text/javascript"
        src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
        <title>Meu perfil de Clube</title>
        <style>
            .form-control{
                border-radius: 50px;
            }
            label{
                font-size: 15pt;
            }
        </style>
    </head>


    <body>
        <!-- Modal confirmar cancelamento de alterações -->
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

        <!-- MODAL EXCLUIR CONTA -->
        <div class="modal" id="modalExcluir">
            <div class="modal-dialog">
                <div class="modal-content">

                    <!-- Modal Header -->
                    <div class="modal-header">
                        <h4 class="modal-title"><strong>Excluir conta</strong></h4>
                    </div>

                    <!-- Modal body -->
                    <div class="modal-body">
                        <div class="alert alert-danger">
                            <p><strong>Atenção:</strong></p>
                            <i class="fa fa-exclamation-circle"></i> Ao confirmar a exclusão da conta, não será possível acessar ou recuperar a mesma.
                            <br/>
                        </div>
                        <p><strong>Tem certeza que deseja excluir sua conta?</strong></p>
                    </div>

                    <!-- Modal footer -->
                    <div class="modal-footer" style="margin: 0 auto">
                        <button type="button" class="btn btn-warning" data-dismiss="modal">Não</button>
                        <!--<input type="submit" class="btn btn-danger" value="Sim">-->
                        <a class="btn btn-danger" href="Controle?acao=deletar_clube&idClu=<c:out value="${clube.idDados}"/>">Sim</a>
                    </div>

                </div>
            </div>
        </div>


        <form action="Controle" method="post">
            <div class="wrapper">
                <div class="left">
                    <a href="index_clube.jsp" class="text-white" style="font-size: 20pt;">
                        <i class="fas fa-arrow-left pr-2"></i>Voltar
                    </a>
                    <h1 style="padding-top: 50px;"><img src="images/clube.png" alt="" height="200px"></h1>
                    <h1>Clube</h1>
                    <br/>
                    <h2>Olá, <c:out value="${clube.fantasia}" /> seja bem-vindo!</h2>
                    <h2>Verifique ou altere as informaçoes do seu perfil aqui do lado.</h2>
                    <br>
                    <h4>Por questões de segurança, pedimos que insira a sua senha atual!</h4>
                </div>
                <div class="right">
                    <h1 class="pt-4 text-center">Minha Conta</h1>
                    <h4 class=" text-center" style="border-bottom: 1px solid #008CAB;">Visualize e edite suas informaçoes de
                        login.</h4>
                    <div class="row pt-3">
                        <div class="col-12 text-center pt-4">
                            <label for="idClu">Id do Clube</label>
                            <input type="number" class="form-control" id="idClu" name="idClu" value="<c:out value="${clube.idDados}" />" readonly="">
                            <br>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-3">
                            <label for="razao" class="">Razão</label>
                            <input type="text" class="form-control" placeholder="Clube de Regatas do Flamengo" id="razao"
                                   name="razao" value="<c:out value="${clube.razao}" />" readonly="">
                            <br>
                        </div>
                        <br>
                        <div class="col-3">
                            <label for="fantasia">Fantasia</label>
                            <input type="text" class="form-control" placeholder="Flamengo" id="fantasia" name="fantasia" value="<c:out value="${clube.fantasia}" />" readonly="">
                            <br>
                        </div>
                        <br>
                        <div class="col-3">
                            <label for="fundacao">Data de fundação</label>
                            <input type="date" class="form-control" placeholder="05/02/1875" id="fundacao" name="fundacao" value="<c:out value="${clube.data_fundacao}" />" readonly="">
                            <br>
                        </div>
                        <br>
                        <div class="col-3">
                            <label for="pais">País</label>
                            <input type="text" class="form-control" placeholder="Brasil" id="pais" name="pais" value="<c:out value="${clube.pais}" />" readonly="">
                            <br>
                        </div>
                        <br>
                    </div>
                    <div class="row">
                        <div class="col-3">
                            <label for="estado">Estado</label>
                            <input type="text" class="form-control" placeholder="Espirito Santo" id="estado" name="estado" value="<c:out value="${clube.estado}" />" readonly="">
                            <br>
                        </div>
                        <div class="col-3">
                            <label for="cidade">Cidade</label>
                            <input type="text" class="form-control" placeholder="Rio de Janeiro" id="cidade" name="cidade" value="<c:out value="${clube.cidade}" />" readonly="">
                            <br>
                        </div>
                        <br>
                        <div class="col-3">
                            <label for="cep">Cep</label>
                            <input type="text" class="form-control" placeholder="29118035" id="cep" name="cep" value="<c:out value="${clube.cep}" />" readonly="">
                            <br>
                        </div>
                        <div class="col-3">
                            <label for="telefone">Telefone</label>
                            <input type="text" class="form-control" placeholder="(27)99244-9243" id="telefone" name="telefone" value="<c:out value="${clube.telefone}" />" readonly="">
                            <br>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-3">
                            <label for="cnpj">Cnpj</label>
                            <input type="text" class="form-control" placeholder="80.102.065/0001-82" id="cnpj" name="cnpj" value="<c:out value="${clube.cnpj}" />" readonly="">
                            <br>
                        </div>
                        <br>
                        <div class="col-3">
                            <label for="sobre">Sobre</label>
                            <input type="text" class="form-control" placeholder="Clube surgiu em 05/02/1875..." id="sobre"
                                   name="sobre" value="<c:out value="${clube.sobre}" />" readonly="">
                            <br>
                        </div>
                        <br>
                        <div class="col-3">
                            <label for="resp">Responsável pelo Cadastro</label>
                            <input type="text" class="form-control" placeholder="José da Silva Ribeiro" id="resp" name="resp" value="<c:out value="${clube.responsavel_cadastro}" />" readonly="">
                        </div>
                        <br>
                    </div>
                    <h3>Dados de usuário:</h3>
                    <div class="row">
                        <div class="col-6">
                            <br>
                            <label for="email">Email</label>
                            <input type="email" class="form-control" placeholder="joao@gmail.com" id="email" name="email" value="<c:out value="${clube.email}" />" readonly="">
                        </div>
                        <div class="col-3">
                            <br>
                            <label for="senha">Insira sua senha</label>
                            <input type="password" onchange="conferirSenha()" class="form-control" required placeholder="123" id="senha" name="senha" readonly="">
                        </div>
                        <div class="col-3">
                            <br>
                            <label for="senha2">Confirme sua senha</label>
                            <input type="password" onchange="conferirSenha()" class="form-control" required placeholder="123" id="senha2" name="senha2" readonly="">
                        </div>
                    </div>
                    <script>
                        $(document).ready(function () {
                            $('#cep').mask('00000-000');
                            $('#telefone').mask('(00)00000-0000');
                            $('#cnpj').mask('00.000.000/0000-00');
                        });

                        function liberarCampos() {
                            document.getElementById("razao").readOnly = false;
                            document.getElementById("fantasia").readOnly = false;
                            document.getElementById("fundacao").readOnly = false;
                            document.getElementById("pais").readOnly = false;
                            document.getElementById("estado").readOnly = false;
                            document.getElementById("cidade").readOnly = false;
                            document.getElementById("cep").readOnly = false;
                            document.getElementById("telefone").readOnly = false;
                            document.getElementById("cnpj").readOnly = false;
                            document.getElementById("sobre").readOnly = false;
                            document.getElementById("resp").readOnly = false;
                            document.getElementById("senha").readOnly = false;
                            document.getElementById("senha2").readOnly = false;
                            document.getElementById("cancelar").disabled = false;
                            document.getElementById("alterar").disabled = true;
                            document.getElementById("enviar").disabled = false;
                        }

                        function conferirSenha() {
                            const senha = document.querySelector('input[name=senha]');
                            const confirma = document.querySelector('input[name=senha2]');

                            if (confirma.value === senha.value) {
                                confirma.setCustomValidity('')
                            } else {
                                confirma.setCustomValidity('As senhas não conferem')
                            }
                        }

                        /*function bloquearcampos() {
                         document.getElementById("razao").readOnly = true;
                         document.getElementById("fantasia").readOnly = true;
                         document.getElementById("fundacao").readOnly = true;
                         document.getElementById("pais").readOnly = true;
                         document.getElementById("estado").readOnly = true;
                         document.getElementById("cidade").readOnly = true;
                         document.getElementById("cep").readOnly = true;
                         document.getElementById("telefone").readOnly = true;
                         document.getElementById("cnpj").readOnly = true;
                         document.getElementById("sobre").readOnly = true;
                         document.getElementById("resp").readOnly = true;
                         document.getElementById("cancelar").disabled = true;
                         document.getElementById("alterar").disabled = false;
                         //////////// PERGUNTAR ANTES DE RECARREGAR A PÁGINA
                         location.reload();
                         }*/
                    </script>
                    <br>
                    <div class="text-center mb-5">
                        <input value="clube" name="tipo" id="tipo" hidden>
                        <input value="alterar_clube" name="acao" id="acao" hidden>
                        <input class="btn btn-primary" type="button" onclick="liberarCampos()" value="Alterar" id="alterar"></input>
                        <input class="btn btn-success" type="submit" value="Enviar" id="enviar" disabled=""></input>
                        <button class="btn btn-warning" type="button" id="cancelar" disabled="false" data-toggle="modal" data-target="#modalConfirmar">
                            Cancelar
                        </button>
                    </div>
                    <div class="text-center">
                        <button class="btn btn-danger" type="button" id="excluir" data-toggle="modal" data-target="#modalExcluir">Excluir conta</button>
                    </div>
                </div>
            </div>
        </form>
    </body>
</html>