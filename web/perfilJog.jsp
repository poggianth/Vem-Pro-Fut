<%-- 
    Document   : usuario
    Created on : 13/09/2022, 16:37:30
    Author     : sala304b
--%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <title>Meu perfil de Jogador</title>
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
                        <a class="btn btn-danger" href="Controle?acao=deletar_jogador&idJog=<c:out value="${jogador.idDados}"/>">Sim</a>
                    </div>

                </div>
            </div>
        </div>

        <form action="Controle" method="post">

            <div class="wrapper">
                <div class="left">
                    <a href="index_jogador.jsp" class="text-white" style="font-size: 20pt;">
                        <i class="fas fa-arrow-left pr-2"></i>Voltar
                    </a>
                    <h1 style="padding-top: 50px;">
                        <img src="images/jogador.png" alt="" height="200px">
                    </h1>
                    <h1>Jogador</h1>
                    <br/>
                    <h2>Olá, <c:out value="${jogador.nome}" /> seja bem-vindo!</h2>
                    <h2>Verifique ou altere as informaçoes do seu perfil aqui do lado.</h2>
                    <br>
                    <h4>Por questões de segurança, pedimos que insira a sua senha atual!</h4>
                </div>

                <div class="right">
                    <h1 class="pt-4 text-center">Minha Conta</h1>
                    <h4 class=" text-center" style="border-bottom: 1px solid #008CAB;">Visualize e edite suas informaçoes de login.</h4>
                    <div class="row">
                        <div class="col-6">
                            <br>
                            <label for="email">Email</label>
                            <input type="email" class="form-control" placeholder="joao@gmail.com" id="email" name="email" value="<c:out value="${jogador.email}" />" readonly="">
                        </div>
                        <div class="col-3">
                            <br>
                            <label for="senha">Informe sua senha</label>
                            <input type="password" onchange="conferirSenha()" class="form-control" placeholder="123" id="senha" name="senha" required readonly="">
                        </div>
                        <div class="col-3">
                            <br>
                            <label for="senha2">Confirme sua senha</label>
                            <input type="password" onchange="conferirSenha()" class="form-control" placeholder="123" id="senha2" name="senha2" required readonly="">
                        </div>
                    </div>
                    <br>
                    <h4 class=" text-center" style="border-bottom: 1px solid #008CAB;">Visualize e edite suas informaçoes pessoais abaixo.</h4>
                    <br>
                    <div class="row">
                        <div class="col-4">
                            <label for="idJog">Id Jogador</label>
                            <input type="text" class="form-control" id="idJog" name="idJog" value="<c:out value="${jogador.idDados}" />" readonly="">
                        </div>
                        <div class="col-4">
                            <label for="nome">Nome completo</label>
                            <input type="text" class="form-control" id="nome" name="nome" value="<c:out value="${jogador.nome}" />" readonly="">
                        </div>
                        <div class="col-4">
                            <label for="data">Data de Nascimento</label>
                            <input type="date" class="form-control" id="data" name="data" value="<c:out value="${jogador.data_nasc}" />" readonly="">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-4">
                            <br>
                            <label for="telefone">Telefone</label>
                            <input type="text" class="form-control" id="telefone" name="telefone" value="<c:out value="${jogador.telefone}" />" readonly="">
                        </div>
                        <div class="col-4">
                            <br>
                            <label for="nacionalidade">Nacionalidade</label>
                            <input type="text" class="form-control" id="nacionalidade" name="nacionalidade" value="<c:out value="${jogador.nacionalidade}" />" readonly="">
                        </div>
                        <div class="col-4">
                            <br>
                            <p style="font-size: 15pt">Sexo: </p>
                            <div class="form-check-inline form-group">
                                <input type="radio" class="form-check-input" id="sexo" name="sexo" value="M" <c:if test="${jogador.sexo == 'M'}"> checked</c:if> disabled>Masculino
                                <input type="radio" class="form-check-input ml-3" id="sexo2" name="sexo" value="F" <c:if test="${jogador.sexo == 'F'}"> checked</c:if> disabled>Feminino
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-4">
                                <br>
                                <label for="estado">Estado</label>
                                <input type="text" class="form-control" id="estado" name="estado" value="<c:out value="${jogador.estado}" />" readonly="">
                        </div>
                        <div class="col-4">
                            <br>
                            <label for="cidade">Cidade</label>
                            <input type="text" class="form-control" id="cidade" name="cidade" value="<c:out value="${jogador.cidade}" />" readonly="">
                        </div>
                        <div class="col-4">
                            <br>
                            <label for="cep">Cep</label>
                            <input type="text" class="form-control" id="cep" name="cep" value="<c:out value="${jogador.cep}" />" readonly="">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-3">
                            <br>
                            <label for="posicao_principal">Posição Principal</label>
                            <select class="form-control" id="posicao_principal" name="posicao_principal" required disabled="">
                                <option value="Goleiro" <c:if test="${jogador.posicao_principal == 'Goleiro'}">selected</c:if>>Goleiro</option>
                                <option value="Lateral" <c:if test="${jogador.posicao_principal == 'Lateral'}">selected</c:if>>Lateral</option>
                                <option value="Zagueiro" <c:if test="${jogador.posicao_principal == 'Zagueiro'}">selected</c:if>>Zagueiro</option>
                                <option value="Volante" <c:if test="${jogador.posicao_principal == 'Volante'}">selected</c:if>>Volante</option>
                                <option value="Meio Campo" <c:if test="${jogador.posicao_principal == 'Meio Campo'}">selected</c:if>>Meio Campo</option>
                                <option value="Meia" <c:if test="${jogador.posicao_principal == 'Meia'}">selected</c:if>>Meia</option>
                                <option value="Ponta" <c:if test="${jogador.posicao_principal == 'Ponta'}">selected</c:if>>Ponta</option>
                                <option value="Atacante" <c:if test="${jogador.posicao_principal == 'Atacante'}">selected</c:if>>Atacante</option>
                                </select>
                            </div>
                            <div class="col-3">
                                <br>
                                <label for="posicao_secundaria">Posição Secundaria</label>
                                <select class="form-control" id="posicao_secundaria" name="posicao_secundaria" required disabled="">
                                    <option value="Goleiro" <c:if test="${jogador.posicao_secundaria == 'Goleiro'}">selected</c:if>>Goleiro</option>
                                <option value="Lateral" <c:if test="${jogador.posicao_secundaria == 'Lateral'}">selected</c:if>>Lateral</option>
                                <option value="Zagueiro" <c:if test="${jogador.posicao_secundaria == 'Zagueiro'}">selected</c:if>>Zagueiro</option>
                                <option value="Volante" <c:if test="${jogador.posicao_secundaria == 'Volante'}">selected</c:if>>Volante</option>
                                <option value="Meio Campo" <c:if test="${jogador.posicao_secundaria == 'Meio Campo'}">selected</c:if>>Meio Campo</option>
                                <option value="Meia" <c:if test="${jogador.posicao_secundaria == 'Meia'}">selected</c:if>>Meia</option>
                                <option value="Ponta" <c:if test="${jogador.posicao_secundaria == 'Ponta'}">selected</c:if>>Ponta</option>
                                <option value="Atacante" <c:if test="${jogador.posicao_secundaria == 'Atacante'}">selected</c:if>>Atacante</option>
                                </select>
                            </div>
                            <div class="col-3">
                                <br>
                                <label for="altura">Altura</label>
                                <input type="text" class="form-control" id="altura" name="altura" value="<c:out value="${jogador.altura}" />" readonly="">
                        </div>
                        <div class="col-3">
                            <br>
                            <label for="peso">Peso</label>
                            <input type="text" class="form-control" id="peso" name="peso" value="<c:out value="${jogador.peso}" />" readonly="">
                        </div>
                    </div>
                    <br>
                    <script>
                        $(document).ready(function () {
                            $('#altura').mask('0.00');
                            $('#cep').mask('00000-000');
                            $('#telefone').mask('(00)00000-0000');
                            $('#cnpj').mask('00.000.000/0000-00');
                        });

                        function liberarCampos() {
                            document.getElementById("nome").readOnly = false;
                            document.getElementById("data").readOnly = false;
                            document.getElementById("telefone").readOnly = false;
                            document.getElementById("nacionalidade").readOnly = false;
                            document.getElementById("sexo").disabled = false;
                            document.getElementById("sexo2").disabled = false;
                            document.getElementById("estado").readOnly = false;
                            document.getElementById("cidade").readOnly = false;
                            document.getElementById("cep").readOnly = false;
                            document.getElementById("posicao_principal").disabled = false;
                            document.getElementById("posicao_secundaria").disabled = false;
                            document.getElementById("altura").readOnly = false;
                            document.getElementById("peso").readOnly = false;
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
                        /*function confirmarCancelar(resp) {
                         if (resp == 'sim') {
                         location.reload();
                         }
                         }*/
                    </script>
                    <br>
                    <div class="text-center mb-5">
                        <input value="jogador" name="tipo" id="tipo" hidden>
                        <input value="alterar_jogador" name="acao" id="acao" hidden>
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