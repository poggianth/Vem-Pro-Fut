<%-- 
    Document   : vagas_clube
    Created on : 24/09/2022, 11:08:49
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
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
        <link rel="stylesheet" href="css/stylePerfil.css">

        <title>Minhas Vagas</title>
        <style>
            .Aprovado{
                background-color: #28a745;
                color: white;
            }

            .Reprovado{
                background-color: #dc3545;
                color: white;
            }

        </style>
    </head>

    <body>
        <div class="wrapper">
            <div class="right" style="width: 100%">
                <a href="index_clube.jsp" class="text-dark" style="font-size: 20pt;">
                    <i class="fas fa-arrow-left pr-2"></i>Voltar
                </a>
                <h1 class="pt-4 text-center" style="border-bottom: 1px solid #008CAB;">Veja suas vagas</h1>
                <div class="text-center mt-5">
                    <table class="table table-hover table-striped">
                        <thead class="text-white" style="background: linear-gradient(to right,#008CAB,#034E5D);">
                            <tr>
                                <th class="text-center pl-5">ID VAGA</th>
                                <th class="text-center pl-5">PAIS</th>
                                <th class="text-center pl-5">ESTADO</th>
                                <th class="text-center pl-5">CIDADE</th>
                                <th class="text-center pl-5">CEP</th>
                                <th class="text-center pl-5">BAIRRO</th>
                                <th class="text-center pl-5">NOME DO LOCAL</th>
                                <th class="text-center pl-5">PONTO DE REFERÊNCIA</th>
                                <th class="text-center pl-5">RESPONSÁVEL PELA VAGA</th>
                                <th class="text-center pl-5">POSIÇÃO REQUISITADA</th>
                                <th class="text-center pl-5">SUB REQUISITADO</th>
                                <th class="text-center pl-5">SEXO REQUISITADO</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${lista_vagas}" var="vaga">
                                <tr id="passar">
                                    <td class="text-center pl-5"><c:out value="${vaga.idvaga}"/></td>
                                    <td class="text-center pl-5"><c:out value="${vaga.pais}"/></td>
                                    <td class="text-center pl-5"><c:out value="${vaga.estado}"/></td>
                                    <td class="text-center pl-5"><c:out value="${vaga.cidade}"/></td>
                                    <td class="text-center pl-5"><c:out value="${vaga.cep}"/></td>
                                    <td class="text-center pl-5"><c:out value="${vaga.bairro}"/></td>
                                    <td class="text-center pl-5"><c:out value="${vaga.nome_local}"/></td>
                                    <td class="text-center pl-5"><c:out value="${vaga.referencia}"/></td>
                                    <td class="text-center pl-5"><c:out value="${vaga.responsavel_vaga}"/></td>
                                    <td class="text-center pl-5"><c:out value="${vaga.posicao}"/></td>
                                    <td class="text-center pl-5"><c:out value="${vaga.sub_requisitado}"/></td>
                                    <td class="text-center pl-5"><c:out value="${vaga.sexo_requisitado}"/></td>
                                    <td class="text-center">
                                        <a href="Controle?acao=deletarVaga&idvaga=<c:out value="${vaga.idvaga}"/>"
                                           <button type="button" class="btn btn-danger">Excluir</button>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <h1 class="pt-5 text-center" style="border-bottom: 1px solid #008CAB;">Veja quem se inscreveu nas suas vagas:</h1>
                <br>
                <table class="table table-hover table-striped">
                    <thead class="text-white" style="background: linear-gradient(to right,#008CAB,#034E5D);">
                        <tr>
                            <th></th>
                            <th class="text-center">ID INSCRIÇÃO</th>
                            <th class="text-center">ID VAGA</th>
                            <th class="text-center">ID JOGADOR</th>
                            <th class="text-center">DATA DA INSCRIÇÃO <br> (yyyy-mm-dd)</th>
                            <th class="text-center">STATUS</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${lista_inscricoes}" var="inscricao">
                            <tr id="passar">
                                <td class="text-center">
                                    <form action="Controle" method="post">
                                        <input type="hidden" name="idJog" id="idJog" value="<c:out value="${inscricao.idjogador}"/>">
                                        <input type="hidden" name="acao" id="acao" value="verPerfilPorInscricao">
                                        <input type="submit" class="btn btn-primary" value="Ver perfil">
                                    </form>
                                </td>
                                <td class="text-center"><c:out value="${inscricao.idinscricao}"/></td>
                                <td class="text-center"><c:out value="${inscricao.idvaga}"/></td>
                                <td class="text-center"><c:out value="${inscricao.idjogador}"/></td>
                                <td class="text-center"><c:out value="${inscricao.data_inscricao}"/></td>
                                <td class="text-center" class="text-center">
                                    <input class="<c:out value="${inscricao.status}"/> text-center" value="<c:out value="${inscricao.status}"/>" disabled="" style="border: none;">
                                </td>
                                <td class="text-center">
                                    <a href="Controle?acao=editar_status&idinscricao=<c:out value="${inscricao.idinscricao}"/>"
                                       <button type="button" class="btn btn-warning">Alterar Status</button>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
