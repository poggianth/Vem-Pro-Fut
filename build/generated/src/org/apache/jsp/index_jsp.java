package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    HttpSession sessao = request.getSession();
    if(sessao.getAttribute("usuario")==null){
        response.sendRedirect("login.jsp");
    }

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"pt-br\">\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("<title>Vem pro FUT</title>\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css\">\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js\"></script>\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\"></script>\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("<link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.7.0/css/all.css\" integrity=\"sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("<link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("<style>\n");
      out.write("    * {\n");
      out.write("        color: white;\n");
      out.write("        font-weight: 500;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    body {\n");
      out.write("        background-color: black;\n");
      out.write("        background-attachment: fixed;\n");
      out.write("        background-repeat: no-repeat;\n");
      out.write("        background-size: 100%;\n");
      out.write("    }\n");
      out.write("</style>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("    <div class=\"container-fluid\">\n");
      out.write("        <div class=\"container-fluid\" id=\"menu_icones\">\n");
      out.write("            <!-- Div menu icone -->\n");
      out.write("            <div class=\"container\" id=\"ct\">\n");
      out.write("                <div class=\"row p-2\">\n");
      out.write("                    <div class=\"col-6\" style=\"padding-bottom: 10px;\">\n");
      out.write("                        <i class=\"fas fa-phone pr-1\"></i>+2 123 4567897\n");
      out.write("                        <i class=\"far fa-envelope pl-3 pr-1\"></i>info@example.com\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"col-6 text-right\">\n");
      out.write("                        <nav class=\"navbar navbar-expand justify-content-end\">\n");
      out.write("                            <ul class=\"navbar-nav\">\n");
      out.write("                                <i class=\"fab fa-facebook-f pl-3\"></i>\n");
      out.write("                                <i class=\"fab fa-twitter pl-3\"></i>\n");
      out.write("                                <i class=\"fab fa-instagram pl-3\"></i>\n");
      out.write("                                <i class=\"fab fa-linkedin-in pl-3\"></i>\n");
      out.write("                            </ul>\n");
      out.write("                        </nav>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"container\" id=\"conteudo\">\n");
      out.write("            <!-- Container logo e itens -->\n");
      out.write("            <div class=\"text-right pt-3\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-3\">\n");
      out.write("                        <a href=\"#\" style=\"text-decoration: none;\">\n");
      out.write("                            <h1>Vem pro FUT</h1>\n");
      out.write("                        </a>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"col-9\">\n");
      out.write("                        <nav class=\"navbar navbar-expand-xl justify-content-end\">\n");
      out.write("                            <ul class=\"navbar-nav\">\n");
      out.write("                                <li class=\"nav-item\">\n");
      out.write("                                    <span class=\"nav-link ponteiroEAmarelo pl-3 pr-3\"\n");
      out.write("                                        style=\"border-bottom: 3px solid #024059;\">Inicio\n");
      out.write("                                    </span>\n");
      out.write("                                </li>\n");
      out.write("\n");
      out.write("                                <li class=\"nav-item\">\n");
      out.write("                                    <span class=\"nav-link ponteiroEAmarelo pl-3 pr-3\" data-toggle=\"dropdown\">Sobre\n");
      out.write("                                    </span>\n");
      out.write("                                </li>\n");
      out.write("                                <li class=\"nav\">\n");
      out.write("\n");
      out.write("                                </li>\n");
      out.write("                                <li class=\"nav-item\">\n");
      out.write("                                    <a href=\"login.jsp\" target=\"_top\" class=\"btn\" style=\"background-color: #024059; color: white;\">Fazer Login</a>\n");
      out.write("                                    <!-- <input type=\"button\" class=\"btn\" value=\"escolherCadastro\" name=\"acao\" hidden>\n");
      out.write("                                    <input type=\"button\" class=\"btn\" value=\"Fazer Login\"\n");
      out.write("                                        style=\"background-color: #024059; color: white;\"> -->\n");
      out.write("                                </li>\n");
      out.write("                            </ul>\n");
      out.write("                        </nav>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div> <!-- FIM DIV CONTAINER CONTEUDO -->\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!-- DIV CONTAINER CONTEUDO -->\n");
      out.write("        <div class=\"container-fluid\">\n");
      out.write("\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div id=\"demo\" class=\"carousel slide\" data-ride=\"carousel\">\n");
      out.write("    \n");
      out.write("                    <!-- The slideshow -->\n");
      out.write("                    <div class=\"carousel-inner mt-5 pb-5\">\n");
      out.write("                        <div class=\"carousel-item active\">\n");
      out.write("                            <div class=\"col-6 mt-3\">\n");
      out.write("                                <h3 class=\"text-azul\">EXPLORE YOUR TRAVEL</h3>\n");
      out.write("                                <h1 class=\"bolder text-white\">TRAVELLING ARROUND <br> THE WORLD</h1>\n");
      out.write("                                <p class=\"normal\">\n");
      out.write("                                    Este é o melhor site para viajar!! Ainda está com dúvida? Te convencerei no próximo\n");
      out.write("                                    texto, aperta na setinha aqui do lado DIREITO.\n");
      out.write("                                </p>\n");
      out.write("                                <button type=\"button\" class=\"btn bg-azul text-white mr-3\">Contact Us</button>\n");
      out.write("                                <button type=\"button\" class=\"btn btn-outline-azul text-white\">About Us</button>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"carousel-item\">\n");
      out.write("                            <div class=\"col-6 mt-3\">\n");
      out.write("                                <h3 class=\"text-azul\">EXPLORE YOUR TRAVEL</h3>\n");
      out.write("                                <h1 class=\"bolder text-white\">TRAVELLING ARROUND <br> THE WORLD</h1>\n");
      out.write("                                <p class=\"normal\">\n");
      out.write("                                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Temporibus, nisi animi\n");
      out.write("                                    omnis vitae ut?\n");
      out.write("                                </p>\n");
      out.write("                                <button type=\"button\" class=\"btn bg-azul text-white\">Contact Us</button>\n");
      out.write("                                <button type=\"button\" class=\"btn btn-outline-azul text-white\">About Us</button>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"carousel-item\">\n");
      out.write("                            <div class=\"col-6 mt-3\">\n");
      out.write("                                <h3 class=\"text-azul\">EXPLORE YOUR TRAVEL</h3>\n");
      out.write("                                <h1 class=\"bolder text-white\">TRAVELLING ARROUND <br> THE WORLD</h1>\n");
      out.write("                                <p class=\"normal\">\n");
      out.write("                                    O que aconteceu? Não entendendeu nada do último slide? Passa para o próximo e siga a\n");
      out.write("                                    informação que ele possui...\n");
      out.write("                                </p>\n");
      out.write("                                <button type=\"button\" class=\"btn bg-azul text-white\">Contact Us</button>\n");
      out.write("                                <button type=\"button\" class=\"btn btn-outline-azul text-white\">About Us</button>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div> <!-- fim div carrossel -->\n");
      out.write("            </div>\n");
      out.write("            <a class=\"carousel-control-prev\" href=\"#demo\" data-slide=\"prev\">\n");
      out.write("                <i class=\"fas fa-arrow-left\" style=\"font-size: 25pt;\"></i>\n");
      out.write("            </a>\n");
      out.write("            <a class=\"carousel-control-next\" href=\"#demo\" data-slide=\"next\">\n");
      out.write("                <i class=\"fas fa-arrow-right\" style=\"font-size: 25pt;\"></i>\n");
      out.write("            </a>\n");
      out.write("        </div>\n");
      out.write("        <!-- Fim da div container fluid que contém o carrossel -->\n");
      out.write("\n");
      out.write("\n");
      out.write("    </div> <!-- Fim da div container -->\n");
      out.write("</body>\n");
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
