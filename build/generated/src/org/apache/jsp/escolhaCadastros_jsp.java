package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class escolhaCadastros_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css\">\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js\"></script>\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\"></script>\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.7.0/css/all.css\"\n");
      out.write("        integrity=\"sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ\" crossorigin=\"anonymous\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("    <title>Escolha de Cadastro</title>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("    <div class=\"container-fluid\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"mt-5 text-center\">\n");
      out.write("                <h1>Escolha de Cadastro</h1>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div class=\"container mt-5\">\n");
      out.write("        <div class=\"alert alert-warning\">\n");
      out.write("            <i class=\"fa fa-exclamation-circle\"></i>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"card-deck\">\n");
      out.write("            <div class=\"card text-center p-3\" style=\"width: 400px;\">\n");
      out.write("                <img class=\"card-img-top logo\" src=\"images/responsavel.png\" alt=\"Card image\" style=\"margin: 0 auto;\">\n");
      out.write("                <div class=\"card-body\">\n");
      out.write("                    <h4 class=\"card-title\">Responsável</h4>\n");
      out.write("                    <p class=\"card-text\">Se você é responsável por alguém e deseja cadastrar um(a) jogador(a), clique no botão abaixo:</p>\n");
      out.write("                    <a href=\"cad_responsavel.jsp\" class=\"btn\" style=\"background-color: #024059; color: white;\">Cadastrar Responsável</a>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("    \n");
      out.write("            <div class=\"card text-center p-3\" style=\"width: 400px;\">\n");
      out.write("                <img class=\"card-img-top logo\" src=\"images/clube.png\" alt=\"Card image\" style=\"margin: 0 auto;\">\n");
      out.write("                <div class=\"card-body\">\n");
      out.write("                    <h4 class=\"card-title\">Clube</h4>\n");
      out.write("                    <p class=\"card-text\">Caso você seja responsável por um clube e deseja cadastrá-lo, clique no botão abaixo:</p>\n");
      out.write("                    <a href=\"cad_clube.jsp\" class=\"btn\" style=\"background-color: #024059; color: white;\">Cadastrar Clube</a>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"card text-center p-3\" style=\"width: 400px;\">\n");
      out.write("                <img class=\"card-img-top logo\" src=\"images/jogador.png\" alt=\"Card image\" style=\"margin: 0 auto; width: 130px; height: 150px;\">\n");
      out.write("                <div class=\"card-body\">\n");
      out.write("                    <h4 class=\"card-title\">Jogador</h4>\n");
      out.write("                    <p class=\"card-text\">Se você tem mais de 18 anos e quer realizar seu sonho, clique no botão abaixo:</p>\n");
      out.write("                    <a href=\"cad_jogador.jsp\" class=\"btn\" style=\"background-color: #024059; color: white;\">Cadastrar Jogador</a>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>\n");
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
