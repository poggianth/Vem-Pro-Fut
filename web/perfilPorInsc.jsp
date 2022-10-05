<%-- 
    Document   : perfilPorInsc
    Created on : 05/10/2022, 09:44:09
    Author     : Thiago
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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

        <title>Perfil do Candidato</title>
    </head>
    <body>
        <div class="wrapper">
            <div class="right" style="width: 100%;">
                <a href="index_clube.jsp" class="text-dark" style="font-size: 20pt;">
                    <i class="fas fa-arrow-left pr-2"></i>Voltar
                </a>
                <h1 class="pt-4 text-center" style="border-bottom: 1px solid #008CAB;">Veja as informações do concorrente abaixo:</h1>
                <div class="text-center mt-5">

                    <table class="table table-hover table-striped">
                        <thead class="text-white" style="background: linear-gradient(to right,#008CAB,#034E5D);">
                            <tr>
                                <th class="text-center">NOME</th>
                                <th class="text-center">DATA DE NASCIMENTO <br> (yyyy-mm-dd)</th>
                                <th class="text-center">SEXO</th>
                                <th class="text-center">TELEFONE</th>
                                <th class="text-center">E-MAIL</th>
                                <th class="text-center">NACIONALIDADE</th>
                                <th class="text-center">ESTADO</th>
                                <th class="text-center">CIDADE</th>
                                <th class="text-center">CEP</th>
                                <th class="text-center">POSIÇÃO PRINCIPAL</th>
                                <th class="text-center">POSIÇÃO SECUNDÁRIA</th>
                                <th class="text-center">ALTURA</th>
                                <th class="text-center">PESO</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr id="passar">
                                <td class="text-center"><c:out value="${jogadorInsc.nome}"/></td>
                                <td class="text-center"><c:out value="${jogadorInsc.data_nasc}"/></td>
                                <td class="text-center"><c:out value="${jogadorInsc.sexo}"/></td>
                                <td class="text-center"><c:out value="${jogadorInsc.telefone}"/></td>
                                <td class="text-center"><c:out value="${jogadorInsc.email}"/></td>
                                <td class="text-center"><c:out value="${jogadorInsc.nacionalidade}"/></td>
                                <td class="text-center"><c:out value="${jogadorInsc.estado}"/></td>
                                <td class="text-center"><c:out value="${jogadorInsc.cidade}"/></td>
                                <td class="text-center"><c:out value="${jogadorInsc.cep}"/></td>
                                <td class="text-center"><c:out value="${jogadorInsc.posicao_principal}"/></td>
                                <td class="text-center"><c:out value="${jogadorInsc.posicao_secundaria}"/></td>
                                <td class="text-center"><c:out value="${jogadorInsc.altura}"/></td>
                                <td class="text-center"><c:out value="${jogadorInsc.peso}"/></td>
                            </tr>
                        </tbody>
                    </table>
                    <br>
                </div>
            </div>
        </div>
    </body>
</html>
