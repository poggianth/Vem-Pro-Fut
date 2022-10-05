<%-- 
    Document   : minhas_vagas
    Created on : 27/09/2022, 16:54:10
    Author     : sala304b
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

        <title>Minhas Inscrições</title>
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
    <body onload="status()">

        <div class="wrapper">
            <div class="left">
                <a href="index_jogador.jsp" class="text-white" style="font-size: 20pt;">
                    <i class="fas fa-arrow-left pr-2"></i>Voltar
                </a>
                <h1 style="padding-top: 50px;"><img src="img/caderno.novo.png" alt="" height="200px"></h1>
                <h1 style="padding-top: 150px;">Minhas Inscrições</h1>
            </div>
            <div class="right">
                <h1 class="pt-4 text-center" style="border-bottom: 1px solid #008CAB;">Veja o andamento das suas inscrições</h1>
                <div class="text-center mt-5">
                    <table class="table table-hover table-striped">
                        <thead class="text-white" style="background: linear-gradient(to right,#008CAB,#034E5D);">
                            <tr>
                                <th class="text-center">ID VAGA</th>
                                <th class="text-center">DATA DA INSCRIÇÃO <br> (yyyy-mm-dd)</th>
                                <th class="text-center">STATUS</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${minhas_inscricoes}" var="ins">
                                <tr id="passar">
                                    <td class="text-center"><c:out value="${ins.idvaga}"/></td>
                                    <td class="text-center"><c:out value="${ins.data_inscricao}"/></td>
                                    <td class="text-center" class="text-center">
                                        <input class="<c:out value="${ins.status}"/> text-center" value="<c:out value="${ins.status}"/>" disabled="" style="border: none;">
                                    </td>
                                    <td class="text-center">
                                        <a href="Controle?acao=deletarInscricao&idinscricao=<c:out value="${ins.idinscricao}"/>" class="btn btn-danger">Desistir</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
