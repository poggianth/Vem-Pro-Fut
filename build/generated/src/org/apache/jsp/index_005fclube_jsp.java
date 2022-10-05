package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Usuario;

public final class index_005fclube_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

    HttpSession sessao = request.getSession();
    if (sessao.getAttribute("idDados") == null) {
        response.sendRedirect("index.jsp");
    } else {
        int idUsu = Integer.parseInt(sessao.getAttribute("idDados").toString());
        System.out.println("Consegui pegar o ID do Usuário: " + idUsu);
    }

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"pt-BR\">\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <title>Tela de Clube</title>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/swiper-bundle.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/styleIndexClu.css\">\n");
      out.write("        <style>\n");
      out.write("            i.dropdown:hover{\n");
      out.write("                cursor: pointer;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <!--!Inicio da Navbar-->\n");
      out.write("        <div class=\"container-fluid\" id=\"nav\">\n");
      out.write("            <div class=\"container navbar navbar-expand-sm navbar-light pt-4 pb-4\" id=\"cabecalho\">\n");
      out.write("                <a class=\"navbar-brand\" href=\"#home\">\n");
      out.write("                    <img src=\"img/LOGO.png\" alt=\"logo\" style=\"width: 60px\">\n");
      out.write("                </a>\n");
      out.write("                <ul class=\"navbar-nav col justify-content-end\">\n");
      out.write("                    <a class=\"navbar-brand pr-2\">\n");
      out.write("                        <a class=\"nav-link\" href=\"sobre.jsp\" id=\"itens\">Sobre</a>\n");
      out.write("                    </a>\n");
      out.write("                    <li class=\"nav-item pr-2\">\n");
      out.write("                        <form action=\"Controle\" method=\"post\">\n");
      out.write("                            <input type=\"hidden\" value=\"verPerfil\" name=\"acao\" id=\"acao\">\n");
      out.write("                            <button type=\"submit\" style=\"background-color: white; border: none;\"><i class=\"bi bi-person-fill login\"></i></button>\n");
      out.write("                        </form>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <div class=\"dropdown\">\n");
      out.write("                            <i class=\"bi bi-list login dropdown\" data-toggle=\"dropdown\"></i>\n");
      out.write("                            <div class=\"dropdown-menu\">\n");
      out.write("                                <a class=\"dropdown-item\" href=\"index.jsp\">Trocar de Conta</a>\n");
      out.write("                                <a class=\"dropdown-item\" href=\"logout.jsp\" id=\"sair\">Sair</a>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!--Final da Navbar-->\n");
      out.write("\n");
      out.write("        <br>\n");
      out.write("\n");
      out.write("        <!--Primeiro Titulo-->\n");
      out.write("        <div class=\"container-fluid text-center titulos\">\n");
      out.write("            <h1>Vagas Disponíveis</h1>\n");
      out.write("            <br>\n");
      out.write("        </div>\n");
      out.write("        <!--Final do Primeiro Titulo-->\n");
      out.write("\n");
      out.write("        <!--/////////////////////////////////////////////////////////////////////////-->\n");
      out.write("\n");
      out.write("        <!--Inicio do Carrossel de Cards-->\n");
      out.write("        <div class=\"slide-container swiper\">\n");
      out.write("            <div class=\"slide-content\">\n");
      out.write("                <div class=\"card-wrapper swiper-wrapper\">\n");
      out.write("                    <div class=\"card swiper-slide\">\n");
      out.write("                        <div class=\"image-content\">\n");
      out.write("                            <span class=\"overlay\"></span>\n");
      out.write("\n");
      out.write("                            <div class=\"card-image\">\n");
      out.write("                                <img src=\"img/goleiro.png\" alt=\"\" class=\"card-img pr-2\"\n");
      out.write("                                     style=\"height: 100px; width: 100px;\">\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"card-content\">\n");
      out.write("                            <h2 class=\"name\">CADASTRE UMA VAGA</h2>\n");
      out.write("                            <p class=\"description\">\n");
      out.write("                                CADASTRE UMA VAGA DE GOLEIRO, ACHE O NOVO BUFFON\n");
      out.write("                                <br>E PROCURE O PAREDÃO QUE ESTÁ\n");
      out.write("                                <br>FALTANDO NO SEU TIME!\n");
      out.write("                            </p>\n");
      out.write("\n");
      out.write("                            <form action=\"Controle\" method=\"post\">\n");
      out.write("                                <input type=\"hidden\" value=\"entrarCadVagas\" name=\"acao\" id=\"acao\">\n");
      out.write("                                <input type=\"submit\" class=\"button\" value=\"Adicionar Vagas\">\n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"card swiper-slide\">\n");
      out.write("                        <div class=\"image-content\">\n");
      out.write("                            <span class=\"overlay\"></span>\n");
      out.write("\n");
      out.write("                            <div class=\"card-image\">\n");
      out.write("                                <img src=\"img/goleiro-removebg-preview-removebg-preview.png\" alt=\"\" class=\"card-img\"\n");
      out.write("                                     style=\"height: 90px; width: 95px; background-color: aliceblue;\">\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"card-content\">\n");
      out.write("                            <h2 class=\"name\">VER MINHAS VAGAS</h2>\n");
      out.write("                            <p class=\"description\">\n");
      out.write("                                ESTÁ PRECISANDO DE UM NOVO XERIFÃO PARA A ZAGA?\n");
      out.write("                                <br>CADASTRE UMA VAGA DE ZAGUEIRO\n");
      out.write("                                <br>QUE ESTÁ FALTANDO NO SEU TIME!\n");
      out.write("                            </p>\n");
      out.write("\n");
      out.write("                            <form action=\"Controle\" method=\"post\">\n");
      out.write("                                <input type=\"hidden\" value=\"listarVagasPorClube\" name=\"acao\" id=\"acao\">\n");
      out.write("                                <input type=\"submit\" class=\"button\" value=\"Minhas Vagas\">\n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"swiper-button-next swiper-navBtn\"></div>\n");
      out.write("            <div class=\"swiper-button-prev swiper-navBtn\"></div>\n");
      out.write("            <div class=\"swiper-pagination\"></div>\n");
      out.write("        </div>\n");
      out.write("        <!--Final do Carrossel de Cards-->\n");
      out.write("\n");
      out.write("        <!--/////////////////////////////////////////////////////////////////////////-->\n");
      out.write("\n");
      out.write("        <!--Inicio da Página de Revelações-->\n");
      out.write("\n");
      out.write("        <div class=\"container-fluid text-center pagina\" id=\"pagina_dep\" style=\"border-left: 10px solid #FF2084;\">\n");
      out.write("\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"text-center pt-3\" id=\"depoimento\">\n");
      out.write("                    <h1>Depoimento</h1>\n");
      out.write("                </div>\n");
      out.write("                <br>\n");
      out.write("                <br>\n");
      out.write("                <br>\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-sm-3\">\n");
      out.write("                        <img id=\"foto\" src=\"img/junior.png\" alt=\"\">\n");
      out.write("                        <p class=\"legenda_da_foto\">\n");
      out.write("                            \"Maestro\" Júnior\n");
      out.write("                            <br>\n");
      out.write("                            Ex Jogador\n");
      out.write("                        </p>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div id=\"titulo\" class=\"col-sm-3\">\n");
      out.write("                        <p class=\"pt-4 text-xl-left\" id=\"conteudo_da_foto\">\n");
      out.write("                            ‘’O projeto 'Vem Pro Fut’ é, sem dúvidas, uma das melhores formas de encontrar novos\n");
      out.write("                            talentos no futebol hoje em dia. É muito fácil usar o site e dar cada vez\n");
      out.write("                            mais esperança ao sonho de milhões de crianças brasileiras.’’\n");
      out.write("                            <br>\n");
      out.write("                            <br>\n");
      out.write("                            Disse o ex jogador Júnior\n");
      out.write("                        </p>\n");
      out.write("                        <br>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!--Final da Página de Revelações-->\n");
      out.write("\n");
      out.write("        <!--/////////////////////////////////////////////////////////////////////////-->\n");
      out.write("\n");
      out.write("        <!--Inicio do Rodape-->\n");
      out.write("        <nav class=\"navbar navbar-expand-sm text-white pt-3\" id=\"rodape\">\n");
      out.write("            <ul class=\"navbar-nav\" style=\"margin: 0 auto;\">\n");
      out.write("                <li class=\"nav-item mr-4\">\n");
      out.write("                    <a class=\"nav-link itens_rodape\" href=\"#\"><i class=\"bi bi-instagram pr-2\"></i><strong class=\"nomes_rodape\">@vemprofut</strong></a>\n");
      out.write("                </li>\n");
      out.write("                <li class=\"nav-item mr-4\">\n");
      out.write("                    <a class=\"nav-link itens_rodape\" href=\"#\"><strong>Vem pro Fut&copy;</strong></a>\n");
      out.write("                </li>\n");
      out.write("                <li class=\"nav-item mr-4\">\n");
      out.write("                    <a class=\"nav-link itens_rodape\" href=\"#\"><i class=\"bi bi-whatsapp pr-2\"></i><strong>27 997110344</strong></a>\n");
      out.write("                </li>\n");
      out.write("            </ul>\n");
      out.write("        </nav>\n");
      out.write("    </div>\n");
      out.write("    <!--Final do Rodape-->\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("<script src=\"js/swiper-bundle.min.js\"></script>\n");
      out.write("<script src=\"js/script_novo_clube.js\"></script>\n");
      out.write("\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
