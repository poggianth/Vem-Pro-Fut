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
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
              integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
        <title>Meu perfil de Responsável</title>
    </head>


    <body>
        <div class="jumbotron text-center">
            <h1>Meu perfil - Responsável</h1>
            <h2>
                <a href="index_responsavel.jsp">Voltar</a>
            </h2>
        </div>

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
                        <a class="btn btn-danger" href="Controle?acao=deletar_responsavel&idRes=<c:out value="${responsavel.idDados}"/>">Sim</a>
                    </div>

                </div>
            </div>
        </div>

        <div class="container mb-5">
            <form action="Controle" method="post">
                <div class="row">
                    <div class="col-12 text-center">
                        <label for="idRes">Id do Responsável</label>
                        <input type="number" class="form-control" id="idRes" name="idRes" value="<c:out value="${responsavel.idDados}" />" readonly="">
                        <br>
                    </div>
                </div>
                <div class="row">
                    <div class="col-3">
                        <label for="nome">Nome completo</label>
                        <input type="text" class="form-control" id="nome" name="nome" value="<c:out value="${responsavel.nome}" />" readonly="">
                        <br>
                    </div>
                    <br>
                    <div class="col-3">
                        <label for="data">Data de Nascimento</label>
                        <input type="date" class="form-control" placeholder="05/02/2004" id="data" name="data" value="<c:out value="${responsavel.data_nasc}" />" readonly="">
                        <br>
                    </div>
                    <br>
                    <div class="col-3">
                        <p>Sexo: </p>
                        <div class="form-check-inline form-group">
                            <input type="radio" class="form-check-input" id="sexo" name="sexo" value="M" <c:if test="${responsavel.sexo == 'M'}"> checked</c:if> disabled="">Masculino
                            <input type="radio" class="form-check-input ml-3" id="sexo2" name="sexo" value="F" <c:if test="${responsavel.sexo == 'F'}"> checked</c:if> disabled="">Feminino
                            </div>
                            <br>
                        </div>
                        <br>
                        <div class="col-3">
                            <label for="telefone">Telefone</label>
                            <input type="text" class="form-control" placeholder="(27)12345-1234" id="telefone" name="telefone" value="<c:out value="${responsavel.telefone}" />" readonly="">
                        <br>
                    </div>
                </div>

                <div class="row">
                    <div class="col-3">
                        <label for="nacionalidade">Nacionalidade</label>
                        <input type="text" class="form-control" placeholder="Brasileiro" id="nacionalidade" name="nacionalidade" value="<c:out value="${responsavel.nacionalidade}" />" readonly="">
                        <br>
                    </div>
                    <br>
                    <div class="col-3">
                        <label for="estado">Estado</label>
                        <input type="text" class="form-control" placeholder="Espirito Santo" id="estado" name="estado" value="<c:out value="${responsavel.estado}" />" readonly="">
                        <br>
                    </div>
                    <br>
                    <div class="col-3">
                        <label for="cidade">Cidade</label>
                        <input type="text" class="form-control" placeholder="Vila Velha" id="cidade" name="cidade" value="<c:out value="${responsavel.cidade}" />" readonly="">
                        <br>
                    </div>
                    <br>
                    <div class="col-3">
                        <label for="cep">Cep</label>
                        <input type="text" class="form-control" placeholder="29118-035" id="cep" name="cep" value="<c:out value="${responsavel.cep}" />" readonly="">
                        <br>
                    </div>
                </div>
                <h3>Dados de usuário:</h3>
                <div class="row">
                    <div class="col-6">
                        <br>
                        <label for="email">Email</label>
                        <input type="email" class="form-control" placeholder="joao@gmail.com" id="email" name="email" value="<c:out value="${responsavel.email}" />" readonly="">
                    </div>
                    <div class="col-3">
                        <br>
                        <label for="senha">Informe sua senha</label>
                        <input type="password" onchange="conferirSenha()" class="form-control" placeholder="123" id="senha" name="senha" readonly="">
                    </div>
                    <div class="col-3">
                        <br>
                        <label for="senha2">Confirme sua senha</label>
                        <input type="password" onchange="conferirSenha()" class="form-control" placeholder="123" id="senha2" name="senha2" readonly="">
                    </div>
                </div>
                <script>
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
                        document.getElementById("email").readOnly = false;
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
                     document.getElementById("nome").readOnly = true;
                     document.getElementById("data").readOnly = true;
                     document.getElementById("telefone").readOnly = true;
                     document.getElementById("nacionalidade").readOnly = true;
                     document.getElementById("sexo").disabled = true;
                     document.getElementById("sexo2").disabled = true;
                     document.getElementById("estado").readOnly = true;
                     document.getElementById("cidade").readOnly = true;
                     document.getElementById("cep").readOnly = true;
                     document.getElementById("cancelar").disabled = true;
                     document.getElementById("alterar").disabled = false;
                     //////////// PERGUNTAR ANTES DE RECARREGAR A PÁGINA
                     location.reload();
                     }*/
                </script>
                <br>
                <div class="text-center mb-5">
                    <input value="responsavel" name="tipo" id="tipo" hidden>
                    <input value="alterar_responsavel" name="acao" id="acao" hidden>
                    <input class="btn btn-primary" type="button" onclick="liberarCampos()" value="Alterar" id="alterar"></input>
                    <input class="btn btn-success" type="submit" value="Enviar" id="enviar" disabled=""></input>
                    <button class="btn btn-warning" type="button" id="cancelar" disabled="false" data-toggle="modal" data-target="#modalConfirmar">
                        Cancelar
                    </button>
                </div>
            </form>
            <div class="text-center">
                <button class="btn btn-danger" type="button" id="excluir" data-toggle="modal" data-target="#modalExcluir">Excluir conta</button>
            </div>
        </div>
    </body>
</html>