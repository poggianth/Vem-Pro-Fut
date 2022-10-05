<%-- 
    Document   : cadastrarVaga
    Created on : 23/09/2022, 10:48:42
    Author     : Thiago
--%>

<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    HttpSession sessao = request.getSession();
    if (sessao.getAttribute("idDados") == null) {
        response.sendRedirect("index.jsp");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="icone.txt"%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
              integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
        <script type="text/javascript"
        src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
        <link rel="stylesheet" href="css/stylePerfil.css">
        <title>Cadastro de Vagas</title>
        <style>
            .form-control{
                border-radius: 20px;
            }
        </style>
        <script>
            $(document).ready(function () {
                $('#cep').mask('00000-000');
                $('#telefone').mask('(00)00000-0000');
                $('#cnpj').mask('00.000.000/0000-00');
                $('#sub_requisitado').mask('00');
            });
        </script>
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

        <!-- MODAL CANCELAR ALTERAÇÕES -->
        <div class="modal" id="modalCancelar">
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



        <div class="wrapper">
            <div class="left">
                <a href="index_clube.jsp" class="text-white" style="font-size: 20pt;">
                    <i class="fas fa-arrow-left pr-2"></i>Voltar
                </a>
                <h1 class="pt-5" style="margin-top: 180px">Olá, <strong><c:out value="${clube.fantasia}"/></strong>. <br> Seja bem-vindo(a) ao cadastro de vagas!</h1>
                <h2>Por favor, confira as informações antes de enviar.</h2>
            </div>
            <div class="right">
                <h1 class="pt-4 text-center" style="border-bottom: 1px solid green;">Cadastro de vagas</h1>
                <form action="Controle" method="post">
                    <div class="row pt-5">
                        <div class="col-4">
                            <br/>
                            <label for="idclube">ID do Clube</label>
                            <input type="text" class="form-control" placeholder="" id="idclube" name="idclube" value="<c:out value="${clube.idclube}"/>" required readonly="">
                        </div>
                        <div class="col-4">
                            <br/>
                            <label for="pais">País</label>
                            <input type="text" class="form-control" placeholder="Brasil" id="pais" name="pais" required>
                        </div>
                        <div class="col-4">
                            <br/>
                            <label for="estado">Estado</label>
                            <input type="text" class="form-control" placeholder="Espirito Santo" id="estado" name="estado" required>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-4">
                            <br/>
                            <label for="cidade">Cidade</label>
                            <input type="text" class="form-control" placeholder="Vitória" id="cidade" name="cidade" required>
                        </div>
                        <div class="col-4">
                            <br/>
                            <label for="cep">Cep</label>
                            <input type="text" class="form-control" placeholder="29050-625" id="cep" name="cep" required>
                        </div>
                        <div class="col-4">
                            <br/>
                            <label for="bairro">Bairro</label>
                            <input type="text" class="form-control" placeholder="Bento Ferreira" id="bairro" name="bairro" required>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-3">
                            <br/>
                            <label for="nome_local">Nome do Local do teste</label>
                            <input type="text" class="form-control" placeholder="Maracanã" id="nome_local" name="nome_local" required>
                        </div>
                        <div class="col-3">
                            <br/>
                            <label for="referencia">Ponto de Referência</label>
                            <input type="text" class="form-control" placeholder="Atrás do Senac" id="referencia" name="referencia" required>
                        </div>
                        <div class="col-3">
                            <br/>
                            <label for="responsavel_vaga">Responsável pela vaga</label>
                            <input type="text" class="form-control" placeholder="Thiago Melo" id="responsavel_vaga" name="responsavel_vaga" required>
                        </div>
                        <div class="col-3">
                            <br/>
                            <label for="data">Dia da Peneira</label>
                            <input type="date" class="form-control" placeholder="05/02/2004" id="data" name="data" required>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-4">
                            <br/>
                            <label for="posicao">Posição Requisitada</label>
                            <select class="form-control" id="posicao" name="posicao" required>
                                <option value="Goleiro">Goleiro</option>
                                <option value="Lateral">Lateral</option>
                                <option value="Zagueiro">Zagueiro</option>
                                <option value="Volante">Volante</option>
                                <option value="Meio Campo">Meio Campo</option>
                                <option value="Meia">Meia</option>
                                <option value="Ponta">Ponta</option>
                                <option value="Atacante">Atacante</option>
                            </select>
                        </div>
                        <div class="col-4">
                            <br/>
                            <label for="sub_requisitado">Sub requisitado</label>
                            <input type="number" class="form-control" min="0" placeholder="16" id="sub_requisitado" name="sub_requisitado" required>
                        </div>
                        <div class="col-4">
                            <br/>
                            <p>Sexo Requisitado: </p>
                            <div class="form-check-inline form-group">
                                <input type="radio" class="form-check-input" id="sexo" name="sexo" value="M" required>Masculino
                                <input type="radio" class="form-check-input ml-3" id="sexo" name="sexo" value="F" required>Feminino
                            </div>
                        </div>
                    </div>
                    <br>
                    <h4>Por motivos de segurança, informe sua senha abaixo:</h4>
                    <div class="row">
                        <div class="col-6">
                            <label for="senha">Senha:</label>
                            <input type="password" onchange="conferirSenha()" class="form-control" placeholder="123" id="senha" name="senha" required>
                        </div>
                        <div class="col-6">
                            <label for="senha2">Confirme sua senha:</label>
                            <input type="password" onchange="conferirSenha()" class="form-control" placeholder="123" id="senha2" name="senha2" required>
                        </div>
                    </div>
                    <br/>
                    <div class="text-center mb-5">
                        <input value="concluirCadVagas" name="acao" id="acao" hidden>
                        <input class="btn btn-success" type="submit" value="Enviar"></input>
                        <button class="btn btn-danger" type="button" id="cancelar" data-toggle="modal" data-target="#modalCancelar">
                            Limpar
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
