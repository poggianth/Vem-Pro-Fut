<%-- 
    Document   : listar_vagas_clube
    Created on : 29/09/2022, 15:06:35
    Author     : sala304b
--%>

<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
        <title>Cadastro de Clube</title>
        <link rel="stylesheet" href="css/stylePerfil.css">
        <style>
            .form-control{
                border-radius: 50px;
            }
        </style>
    </head>

    <body>

        <div class="wrapper">
            <div class="left">
                <a href="index_clube.jsp" class="text-white" style="font-size: 20pt;">
                    <i class="fas fa-arrow-left pr-2"></i>Voltar
                </a>
                <h1 style="padding-top: 50px;"><img src="<c:out value="${imagem}"/>" alt="" height="200px"></h1>
                <h1 style="padding-top: 150px;">Lista de Vagas</h1>
                <br/>
                <h1>Veja todas as vagas disponíveis</h1>
                <br/>
            </div>
            <div class="right">
                <h1 class="pt-4 text-center" style="border-bottom: 1px solid #008CAB;">Vagas</h1>
                <div class="text-center mt-5">
                    <table class="table table-hover table-striped">
                        <thead class="text-white" style="background: linear-gradient(to right,#008CAB,#034E5D);">
                            <tr>
                                <th class="text-center pl-5">ID VAGA</th>
                                <th class="text-center pl-5">ID CLUBE</th>
                                <th class="text-center pl-5">ESTADO</th>
                                <th class="text-center pl-5">CIDADE</th>
                                <th class="text-center pl-5">BAIRRO</th>
                                <th class="text-center pl-5">POSIÇÃO REQUISITADA</th>
                                <th class="text-center pl-5">SUB REQUISITADO</th>
                                <th class="text-center pl-5">SEXO REQUISITADO</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${lista_vagas}" var="vaga">
                                <tr id="passar">
                                    <td class="text-center pl-5"><c:out value="${vaga.idvaga}"/></td>
                                    <td class="text-center pl-5"><c:out value="${vaga.idclube}"/></td>
                                    <td class="text-center pl-5"><c:out value="${vaga.estado}"/></td>
                                    <td class="text-center pl-5"><c:out value="${vaga.cidade}"/></td>
                                    <td class="text-center pl-5"><c:out value="${vaga.bairro}"/></td>
                                    <td class="text-center pl-5"><c:out value="${vaga.posicao}"/></td>
                                    <td class="text-center pl-5"><c:out value="${vaga.sub_requisitado}"/></td>
                                    <td class="text-center pl-5"><c:out value="${vaga.sexo_requisitado}"/></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>