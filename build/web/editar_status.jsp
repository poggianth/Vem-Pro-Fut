<%-- 
    Document   : editar_statusInscricao
    Created on : 26/09/2022, 10:38:17
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

        <title>Editar Status</title>
    </head>
    <body>
        <div class="wrapper">
            <div class="left">
                <a href="index_clube.jsp" class="text-white" style="font-size: 20pt;">
                    <i class="fas fa-arrow-left pr-2"></i>Voltar
                </a>
                <h1 style="padding-top: 50px;"><img src="img/caderno.novo.png" alt="" height="200px"></h1>
                <h1 style="padding-top: 150px;">Alterar</h1>
                <br/>
                <h1>Altere o status da inscrição</h1>
                <br/>
            </div>
            <div class="right">
                <h1 class="pt-4 text-center" style="border-bottom: 1px solid #008CAB;">Inscrição</h1>
                <div class="text-center mt-5">
                    <form action="Controle" method="post">

                        <table class="table table-hover table-striped">
                            <thead class="text-white" style="background: linear-gradient(to right,#008CAB,#034E5D);">
                                <tr>
                                    <th class="text-center">ID INSCRIÇÃO</th>
                                    <th class="text-center">ID VAGA</th>
                                    <th class="text-center">ID JOGADOR</th>
                                    <th class="text-center">DATA DA INSCRIÇÃO <br> (yyyy-mm-dd)</th>
                                    <th class="text-center">STATUS</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr id="passar">
                                    <td class="text-center"><c:out value="${inscricao.idinscricao}"/></td>
                                    <td class="text-center"><c:out value="${inscricao.idvaga}"/></td>
                                    <td class="text-center"><c:out value="${inscricao.idjogador}"/></td>
                                    <td class="text-center"><c:out value="${inscricao.data_inscricao}"/></td>
                                    <td class="text-center">
                                        <select id="status" name="status" class="form-control">
                                            <option value="Aprovado" <c:if test="${inscricao.status == 'Aprovado'}"> selected</c:if>>Aprovado</option>
                                            <option value="Em andamento" <c:if test="${inscricao.status == 'Em andamento'}"> selected</c:if>>Em andamento</option>
                                            <option value="Reprovado" <c:if test="${inscricao.status == 'Reprovado'}"> selected</c:if>>Reprovado</option>
                                            </select>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                            <br>
                            <div class="text-center">
                                <input value="<c:out value="${inscricao.idinscricao}"/>" name="idinscricao" id="idinscricao" hidden>
                            <input value="confirmar_status" name="acao" id="acao" hidden>
                            <input type="submit" class="btn btn-success">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
