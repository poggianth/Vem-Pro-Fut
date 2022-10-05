package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html lang=\"pt-br\">\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.7.0/css/all.css\"\n");
      out.write("              integrity=\"sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ\" crossorigin=\"anonymous\">\n");
      out.write("        <script src=\"js/script.js\"></script>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("        <title>Página de Login</title>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container-fluid p-4\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-lg-6\">\n");
      out.write("                    <div class=\"pb-5\">\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <img src=\"images/FUT DREAM.png\" alt=\"\" class=\"logo\">\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"row justify-content-center mt-4 mb-4 borda-direita\">\n");
      out.write("                            <img src=\"images/teste.png\" alt=\"\" class=\"imagem\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <!-- Tela de login na parte direita -->\n");
      out.write("                <div class=\"col-lg-6 mt-4 pt-2\">\n");
      out.write("                    <div class=\"text-primary\">\n");
      out.write("                        <h1><strong>Tela de login</strong></h1>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"mt-5 pt-4\">\n");
      out.write("                        <form action=\"Controle\" method=\"post\">\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"email\">Email:</label>\n");
      out.write("                                <input type=\"email\" class=\"form-control\" id=\"email\" placeholder=\"joao@gmail.com\"\n");
      out.write("                                       name=\"email\" required>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"senha\">Senha:</label>\n");
      out.write("                                <input type=\"password\" class=\"form-control\" id=\"senha\" placeholder=\"Digite sua senha\"\n");
      out.write("                                       name=\"senha\" required>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <input value=\"entrar\" name=\"acao\" id=\"acao\" hidden>\n");
      out.write("                            <button type=\"submit\" class=\"btn btn-primary\">Entrar</button>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"text-center mt-3\">\n");
      out.write("                        <p>Ou</p>\n");
      out.write("                    </div>\n");
      out.write("                    <br>\n");
      out.write("\n");
      out.write("                    <div class=\"text-center\">\n");
      out.write("                        <h4><strong>\n");
      out.write("                            <a href=\"escolhaCadastros.jsp\" target=\"_blank\" style=\"text-decoration: none;\">\n");
      out.write("                                Criar conta</a>\n");
      out.write("                        </strong></h4>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <nav class=\"navbar navbar-expand-sm fixed-bottom bg-primary text-white\">\n");
      out.write("            <ul class=\"navbar-nav\" style=\"margin: 0 auto;\">\n");
      out.write("                <li class=\"nav-item \">\n");
      out.write("                    <strong>Vem pro Fut&copy;</strong>\n");
      out.write("                </li>\n");
      out.write("                <li class=\"nav-item ml-4\">\n");
      out.write("                    <strong><a href=\"sobre.jsp\" class=\"text-white\" target=\"_blank\" style=\"text-decoration: none;\">\n");
      out.write("                                Sobre</a></strong>\n");
      out.write("                </li>\n");
      out.write("            </ul>\n");
      out.write("        </nav>\n");
      out.write("    </body>\n");
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
