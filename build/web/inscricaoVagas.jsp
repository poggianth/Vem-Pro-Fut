<%-- 
    Document   : inscricaoVagas
    Created on : 24/09/2022, 10:23:46
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
<html lang="pt-br">
    <head>
        <%@include file="icone.txt"%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
              integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
        <link rel="stylesheet" href="css/stylePerfil.css">
        <title>Inscrição de Vagas</title>
    </head>
    <body>
        <div class="wrapper">
            <div class="left" style="width: 30%">
                <a href="index_jogador.jsp" class="text-white" style="font-size: 20pt;">
                    <i class="fas fa-arrow-left pr-2"></i>Voltar
                </a>
                <h1 style="padding-top: 50px;"><img src="img/caderno.novo.png" alt="" height="200px"></h1>
                <h1 style="padding-top: 150px;">Inscrição</h1>
                <br/>
                <h1>Você está prestes a se inscrever na seguinte vaga:</h1>
                <br/>
            </div>
            <div class="right" style="width: 70%">
                <h1 class="pt-4 text-center" style="border-bottom: 1px solid #008CAB;">Dados da Vaga</h1>
                <div class="text-center mt-5">
                    <table class="table table-hover table-striped">
                        <thead class="text-white" style="background: linear-gradient(to right,#008CAB,#034E5D);">
                            <tr>
                                <th class="text-center">ID VAGA</th>
                                <th class="text-center">ID CLUBE</th>
                                <th class="text-center">PAIS</th>
                                <th class="text-center">ESTADO</th>
                                <th class="text-center">CIDADE</th>
                                <th class="text-center">CEP</th>
                                <th class="text-center">BAIRRO</th>
                                <th class="text-center">NOME DO LOCAL</th>
                                <th class="text-center">PONTO DE REFERÊNCIA</th>
                                <th class="text-center">RESPONSÁVEL PELA VAGA</th>
                                <th class="text-center">POSIÇÃO REQUISITADA</th>
                                <th class="text-center">SUB REQUISITADO</th>
                                <th class="text-center">SEXO REQUISITADO</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr id="passar">
                                <td class="text-center"><c:out value="${vagaSelecionada.idvaga}"/></td>
                                <td class="text-center"><c:out value="${vagaSelecionada.idclube}"/></td>
                                <td class="text-center"><c:out value="${vagaSelecionada.pais}"/></td>
                                <td class="text-center"><c:out value="${vagaSelecionada.estado}"/></td>
                                <td class="text-center"><c:out value="${vagaSelecionada.cidade}"/></td>
                                <td class="text-center"><c:out value="${vagaSelecionada.cep}"/></td>
                                <td class="text-center"><c:out value="${vagaSelecionada.bairro}"/></td>
                                <td class="text-center"><c:out value="${vagaSelecionada.nome_local}"/></td>
                                <td class="text-center"><c:out value="${vagaSelecionada.referencia}"/></td>
                                <td class="text-center"><c:out value="${vagaSelecionada.responsavel_vaga}"/></td>
                                <td class="text-center"><c:out value="${vagaSelecionada.posicao}"/></td>
                                <td class="text-center"><c:out value="${vagaSelecionada.sub_requisitado}"/></td>
                                <td class="text-center"><c:out value="${vagaSelecionada.sexo_requisitado}"/></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div class="container pt-5 text-center">
                    <h1>Deseja confirmar sua inscrição?</h1>

                    <form action="Controle" method="post">
                        <div class="row">
                            <div class="col-3">
                                <input type="number" class="form-control" value="<c:out value="${vagaSelecionada.idvaga}"/>" name="idvaga" id="idvaga" readonly="" style="opacity: 0.5;" hidden="">
                            </div>
                            <div class="col-3">
                                <input type="number" class="form-control" value="<c:out value="${idjogador}"/>" name="idjogador" id="idjogador" readonly="" style="opacity: 0.5;" hidden="">
                            </div>
                            <div class="col-3">
                                <input type="text" class="form-control" value="Em andamento" name="status" id="status" readonly="" style="opacity: 0.5;" hidden="">
                            </div>
                        </div>
                        <div class="text-center mt-5 mb-5">
                            <a href="index_jogador.jsp" class="btn btn-danger">Não</a>
                            <input value="confirmar_inscricao" name="acao" id="acao" hidden>
                            <input value="<c:out value="${sexo}"/>" name="sexo" id="sexo" hidden>
                            <input value="<c:out value="${vagaSelecionada.sexo_requisitado}"/>" name="sexoVag" id="sexoVag" hidden>
                            <input class="btn btn-success" type="submit" value="Sim"></input>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
