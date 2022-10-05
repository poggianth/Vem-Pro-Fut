package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class usuario_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Cadastro de Responsável</title>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <div class=\"jumbotron text-center\">\n");
      out.write("            <h1>Cadastro de Responsável</h1>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"container mb-5\">\n");
      out.write("            <form action=\"Controle\" method=\"post\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-3\">\n");
      out.write("                        <label for=\"nome\">Nome completo</label>\n");
      out.write("                        <input type=\"text\" class=\"form-control\" placeholder=\"João da Silva\" id=\"nome\" name=\"nome\" required>\n");
      out.write("                        <br>\n");
      out.write("                    </div>\n");
      out.write("                    <br>\n");
      out.write("                    <div class=\"col-3\">\n");
      out.write("                        <label for=\"data\">Data de Nascimento</label>\n");
      out.write("                        <input type=\"date\" class=\"form-control\" placeholder=\"05/02/2004\" id=\"data\" name=\"data\" required>\n");
      out.write("                        <br>\n");
      out.write("                    </div>\n");
      out.write("                    <br>\n");
      out.write("                    <div class=\"col-3\">\n");
      out.write("                        <p>Sexo: </p>\n");
      out.write("                        <div class=\"form-check-inline form-group\">\n");
      out.write("                            <input type=\"radio\" class=\"form-check-input\" id=\"sexo\" name=\"sexo\" value=\"M\" required>Masculino\n");
      out.write("                            <input type=\"radio\" class=\"form-check-input ml-3\" id=\"sexo\" name=\"sexo\" value=\"F\" required>Feminino\n");
      out.write("                        </div>\n");
      out.write("                        <br>\n");
      out.write("                    </div>\n");
      out.write("                    <br>\n");
      out.write("                    <div class=\"col-3\">\n");
      out.write("                        <label for=\"telefone\">Telefone</label>\n");
      out.write("                        <input type=\"text\" class=\"form-control\" placeholder=\"(27)12345-1234\" id=\"telefone\" name=\"telefone\" required>\n");
      out.write("                        <br>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-3\">\n");
      out.write("                        <label for=\"nacionalidade\">Nacionalidade</label>\n");
      out.write("                        <input type=\"text\" class=\"form-control\" placeholder=\"Brasileiro\" id=\"nacionalidade\" name=\"nacionalidade\" required>\n");
      out.write("                        <br>\n");
      out.write("                    </div>\n");
      out.write("                    <br>\n");
      out.write("                    <div class=\"col-3\">\n");
      out.write("                        <label for=\"estado\">Estado</label>\n");
      out.write("                        <br>\n");
      out.write("                        <select class=\"form-control\" id=\"estado\" name=\"estado\">\n");
      out.write("                            <option selected>Selecione</option>\n");
      out.write("                            <option value=\"AC\">Acre</option>\n");
      out.write("                            <option value=\"AL\">Alagoas</option>\n");
      out.write("                            <option value=\"AP\">Amapá</option>\n");
      out.write("                            <option value=\"AM\">Amazonas</option>\n");
      out.write("                            <option value=\"BA\">Bahia</option>\n");
      out.write("                            <option value=\"CE\">Ceará</option>\n");
      out.write("                            <option value=\"DF\">Distrito Federal</option>\n");
      out.write("                            <option value=\"ES\">Espírito Santo</option>\n");
      out.write("                            <option value=\"GO\">Goiás</option>\n");
      out.write("                            <option value=\"MA\">Maranhão</option>\n");
      out.write("                            <option value=\"MT\">Mato Grosso</option>\n");
      out.write("                            <option value=\"MS\">Mato Grosso do Sul</option>\n");
      out.write("                            <option value=\"MG\">Minas Gerais</option>\n");
      out.write("                            <option value=\"PA\">Pará</option>\n");
      out.write("                            <option value=\"PB\">Paraíba</option>\n");
      out.write("                            <option value=\"PR\">Paraná</option>\n");
      out.write("                            <option value=\"PE\">Pernambuco</option>\n");
      out.write("                            <option value=\"PI\">Piauí</option>\n");
      out.write("                            <option value=\"RJ\">Rio de Janeiro</option>\n");
      out.write("                            <option value=\"RN\">Rio Grande do Norte</option>\n");
      out.write("                            <option value=\"RS\">Rio Grande do Sul</option>\n");
      out.write("                            <option value=\"RO\">Rondônia</option>\n");
      out.write("                            <option value=\"RR\">Roraima</option>\n");
      out.write("                            <option value=\"SC\">Santa Catarina</option>\n");
      out.write("                            <option value=\"SP\">São Paulo</option>\n");
      out.write("                            <option value=\"SE\">Sergipe</option>\n");
      out.write("                            <option value=\"TO\">Tocantins</option>\n");
      out.write("                            <option value=\"EX\">Estrangeiro</option>\n");
      out.write("                        </select>\n");
      out.write("                        <br>\n");
      out.write("                    </div>\n");
      out.write("                    <br>\n");
      out.write("                    <div class=\"col-3\">\n");
      out.write("                        <label for=\"cidade\">Cidade</label>\n");
      out.write("                        <input type=\"text\" class=\"form-control\" placeholder=\"Vila Velha\" id=\"cidade\" name=\"cidade\" required>\n");
      out.write("                        <br>\n");
      out.write("                    </div>\n");
      out.write("                    <br>\n");
      out.write("                    <div class=\"col-3\">\n");
      out.write("                        <label for=\"cep\">Cep</label>\n");
      out.write("                        <input type=\"text\" class=\"form-control\" placeholder=\"29118-035\" id=\"cep\" name=\"cep\" required>\n");
      out.write("                        <br>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <br>\n");
      out.write("                <div class=\"text-center\">\n");
      out.write("                    <input value=\"responsavel\" name=\"tipo\" id=\"tipo\" hidden>\n");
      out.write("                    <input value=\"cadastrar_responsavel\" name=\"acao\" id=\"acao\" hidden>\n");
      out.write("                    <input class=\"btn btn-success\" type=\"submit\" value=\"Enviar\"></input>\n");
      out.write("                    <input class=\"btn btn-danger\" type=\"reset\" value=\"Limpar\"></input>\n");
      out.write("                </div>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
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
