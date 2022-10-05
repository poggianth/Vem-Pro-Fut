/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.ClubeDAO;
import dao.InscricaoDAO;
import dao.JogadorDAO;
//import dao.ResponsavelDAO;
import dao.UsuarioDAO;
import dao.VagaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Clube;
import model.Inscricao;
import model.Jogador;
//import model.Responsavel;
import model.Usuario;
import model.Vaga;

/**
 *
 * @author Th
 */
public class Controle extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");

        switch (acao) {
            case "deletar_jogador":
                System.out.println("entrou no deletar jogador");
                // Deletar via ID DADOS
                int idDadosJog = Integer.parseInt(request.getParameter("idJog"));

                JogadorDAO deletejogDAO = new JogadorDAO();

                if (deletejogDAO.delete(idDadosJog)) {
                    UsuarioDAO userdeleteDAO = new UsuarioDAO();
                    if (userdeleteDAO.delete(idDadosJog, "jogador")) {
                        System.out.println("Jogador e USUÁRIO deletados com sucesso!!");
                        RequestDispatcher contaDeletada = request.getRequestDispatcher("sucessoDelConta.jsp");
                        contaDeletada.forward(request, response);
                    }
                }
                break;
            case "deletar_clube":
                System.out.println("Entrou no deletar clube");
                int idDadosClu = Integer.parseInt(request.getParameter("idClu"));

                ClubeDAO deletecluDAO = new ClubeDAO();

                if (deletecluDAO.delete(idDadosClu)) {
                    UsuarioDAO userdeleteDAO = new UsuarioDAO();
                    if (userdeleteDAO.delete(idDadosClu, "clube")) {
                        System.out.println("Clube e Usuário deletados com sucesso!!");
                        RequestDispatcher contaDeletada = request.getRequestDispatcher("sucessoDelConta.jsp");
                        contaDeletada.forward(request, response);
                    }
                }

                break;
            /*
                case "deletar_responsavel":
                System.out.println("Entrou no deletar responsavel");
                int idDadosRes = Integer.parseInt(request.getParameter("idRes"));

                ResponsavelDAO deleteresDAO = new ResponsavelDAO();

                if (deleteresDAO.delete(idDadosRes)) {
                    UsuarioDAO userdeleteDAO = new UsuarioDAO();
                    if (userdeleteDAO.delete(idDadosRes, "responsavel")) {
                        System.out.println("Responsável e Usuário deletados com sucesso!!");
                        response.sendRedirect("index.jsp");
                    }
                }
                break;
             */
            case "verTodasVagas":
                System.out.println("Entrou em ver vagas");
                VagaDAO todasVagasDAO = new VagaDAO();
                request.setAttribute("lista_vagas", todasVagasDAO.read());
                request.setAttribute("imagem", "img/caderno.novo.png");
                RequestDispatcher visualizar = request.getRequestDispatcher("listar_vagas.jsp");
                visualizar.forward(request, response);
                break;

            case "verTodasVagas_clube":
                System.out.println("entrou no verTodasVagas_clube");
                VagaDAO todasVagasClubeDAO = new VagaDAO();
                request.setAttribute("lista_vagas", todasVagasClubeDAO.read());
                request.setAttribute("imagem", "img/caderno.novo.png");
                RequestDispatcher visualizarTodasVagasClu = request.getRequestDispatcher("listar_vagas_clube.jsp");
                visualizarTodasVagasClu.forward(request, response);
                break;

            case "verVagas":
                System.out.println("Entrou no selecionar por posição!");
                VagaDAO vagaDAO = new VagaDAO();
                String posicao = request.getParameter("posicao");
                request.setAttribute("lista_vagas", vagaDAO.readPorPosicao(posicao));

                switch (posicao) {
                    case "Goleiro":
                        request.setAttribute("imagem", "img/GOLEIRO.png");
                        break;
                    case "Zagueiro":
                        request.setAttribute("imagem", "img/zagueiro.png");
                        break;
                    case "Lateral":
                        request.setAttribute("imagem", "img/LATERAL.png");
                        break;
                    case "Volante":
                        request.setAttribute("imagem", "img/volante.png");
                        break;
                    case "Meio Campo":
                        request.setAttribute("imagem", "img/meiocampo.png");
                        break;
                    case "Meia":
                        request.setAttribute("imagem", "img/meia.png");
                        break;
                    case "Ponta":
                        request.setAttribute("imagem", "img/ponta.png");
                        break;
                    case "Atacante":
                        request.setAttribute("imagem", "img/atacante.png");
                        break;
                    default:
                        request.setAttribute("imagem", "img/caderno.novo.png");
                        break;
                }

                RequestDispatcher visualizarVagaPorPosi = request.getRequestDispatcher("listar_vagas.jsp");
                visualizarVagaPorPosi.forward(request, response);
                break;

            case "inscreverSeVaga":
                System.out.println("Entrou no inscrever-se");
                VagaDAO vagaInsDAO = new VagaDAO();
                int idVaga = Integer.parseInt(request.getParameter("idvaga"));
                request.setAttribute("vagaSelecionada", vagaInsDAO.selecionarPorIdVaga(idVaga));
                System.out.println("o id da vaga é: " + idVaga);

                HttpSession sessao = request.getSession();
                int idUsu = Integer.parseInt(sessao.getAttribute("idDados").toString());
                UsuarioDAO user_perfilDAO = new UsuarioDAO();
                Usuario user_perfil = user_perfilDAO.selecionarUsu(idUsu);

                int idDados = user_perfil.getIdDados();

                Jogador jogInscrever = new Jogador();
                JogadorDAO jogInscreverDAO = new JogadorDAO();

                jogInscrever = jogInscreverDAO.selecionarPorId(idDados);

                String sexo = jogInscrever.getSexo();

                request.setAttribute("idjogador", idDados);
                request.setAttribute("sexo", sexo);

                RequestDispatcher inscricaoVaga = request.getRequestDispatcher("inscricaoVagas.jsp");
                inscricaoVaga.forward(request, response);
                break;

            case "deletarVaga":
                System.out.println("entrou no deletarVaga");
                VagaDAO deleteVagaDAO = new VagaDAO();
                int idvaga = Integer.parseInt(request.getParameter("idvaga"));

                if (deleteVagaDAO.delete(idvaga)) {
                    System.out.println("Vaga deletada com sucesso!");
                    RequestDispatcher vagaDeletada = request.getRequestDispatcher("sucessoDelVaga.jsp");
                    vagaDeletada.forward(request, response);
                }
                break;

            case "editar_status":
                System.out.println("chegou no editar_status");
                InscricaoDAO insAltSttsDAO = new InscricaoDAO();

                int idInscricao = Integer.parseInt(request.getParameter("idinscricao"));

                request.setAttribute("inscricao", insAltSttsDAO.listarPorID(idInscricao));
                RequestDispatcher alterarStatus = request.getRequestDispatcher("editar_status.jsp");
                alterarStatus.forward(request, response);

                break;

            case "minhas_inscricoes":
                System.out.println("Chegou no minhas_inscricoes");
                HttpSession sessaominhasInsc = request.getSession();

                int idDadosIns = Integer.parseInt(sessaominhasInsc.getAttribute("idDados").toString());

                UsuarioDAO user_minhasInscDAO = new UsuarioDAO();

                Usuario user_minhasInsc = user_minhasInscDAO.selecionarUsu(idDadosIns);
                InscricaoDAO minhasInscricaoDAO = new InscricaoDAO();

                request.setAttribute("minhas_inscricoes", minhasInscricaoDAO.listarPorJogador(user_minhasInsc.getIdDados()));

                RequestDispatcher visuminhasInsc = request.getRequestDispatcher("minhas_inscricoes.jsp");
                visuminhasInsc.forward(request, response);
                break;

            case "deletarInscricao":
                System.out.println("chegou no deletarInscricao");
                InscricaoDAO insDeletarInsDAO = new InscricaoDAO();
                int idDeletarIns = Integer.parseInt(request.getParameter("idinscricao"));
                System.out.println(idDeletarIns);

                if (insDeletarInsDAO.delete(idDeletarIns)) {
                    System.out.println("Inscrição deletada com sucesso!");
                    RequestDispatcher vagaDeletada = request.getRequestDispatcher("sucessoDelInsc.jsp");
                    vagaDeletada.forward(request, response);
                } else {
                    RequestDispatcher vagaDeletada = request.getRequestDispatcher("erroDelInsc.jsp");
                    vagaDeletada.forward(request, response);
                }

                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.setContentType("text/html; charset=UTF-8");
        String acao = request.getParameter("acao");

        // Ao apertar o botão para entrar no sistema, o controle verifica se o usuário existe no banco de dados; caso exista (passa o ID do usuário via SESSÃO)
        switch (acao) {
            case "entrar":
                Usuario user = new Usuario();
                user.setEmail(request.getParameter("email"));
                user.setSenha(request.getParameter("senha"));
                /* verificar se o objeto é nulo */
                System.out.println(user.getEmail());
                System.out.println(user.getSenha());
                UsuarioDAO userDAO = new UsuarioDAO();
                Usuario usuVerificado = userDAO.verificar(user);

                if (usuVerificado.getIdDados() > 0) {
                    HttpSession sessao = request.getSession();
                    sessao.setAttribute("idDados", usuVerificado.getIdUsuario());
                    // Passando o tipo via sessão
                    sessao.setAttribute("tipo", usuVerificado.getTipo());
                    System.out.println(usuVerificado.getIdUsuario());
                    System.out.println(usuVerificado.getTipo());

                    String tipoUsu = usuVerificado.getTipo();
                    if (tipoUsu.equals("jogador")) {
                        RequestDispatcher visualizar = request.getRequestDispatcher("index_jogador.jsp");
                        visualizar.forward(request, response);
                    } else if (tipoUsu.equals("responsavel")) {
                        RequestDispatcher visualizar = request.getRequestDispatcher("index_responsavel.jsp");
                        visualizar.forward(request, response);
                    } else {
                        RequestDispatcher visualizar = request.getRequestDispatcher("index_clube.jsp");
                        visualizar.forward(request, response);
                    }
                } else {
                    response.sendRedirect("erroLogin.jsp");
                }
                break;

            case "cadastrar_jogador":
                Jogador jog = new Jogador();
                JogadorDAO jogDAO = new JogadorDAO();
                Usuario usu = new Usuario();
                jog.setNome(request.getParameter("nome"));
                jog.setData_nasc(request.getParameter("data"));
                jog.setSexo(request.getParameter("sexo"));
                jog.setTelefone(request.getParameter("telefone"));
                jog.setEmail(request.getParameter("email"));
                jog.setNacionalidade(request.getParameter("nacionalidade"));
                jog.setEstado(request.getParameter("estado"));
                jog.setCidade(request.getParameter("cidade"));
                jog.setCep(request.getParameter("cep"));
                jog.setPosicao_principal(request.getParameter("posicao_principal"));
                jog.setPosicao_secundaria(request.getParameter("posicao_secundaria"));
                jog.setAltura(Double.parseDouble(request.getParameter("altura")));
                jog.setPeso(Double.parseDouble(request.getParameter("peso")));
                usu.setEmail(request.getParameter("email"));
                usu.setSenha(request.getParameter("senha"));
                usu.setTipo(request.getParameter("tipo"));

                UsuarioDAO usuCadJogDAO = new UsuarioDAO();
                if (usuCadJogDAO.jaExiste(usu.getEmail())) {
                    RequestDispatcher visualizar = request.getRequestDispatcher("email_ja_cadastrado.jsp");
                    visualizar.forward(request, response);
                } else {
                    int idCriado = jogDAO.create(jog, usu);
                    if (idCriado > 0) {
                        System.out.println("Jogador criado com sucesso!");
                        System.out.println("ID DO JOGADOR CRIADO: " + idCriado);

                        RequestDispatcher visualizar = request.getRequestDispatcher("cadastro_concluido.jsp");
                        visualizar.forward(request, response);
                    } else {
                        System.out.println("Erro ao criar Jogador!");
                        RequestDispatcher visualizar = request.getRequestDispatcher("erro.jsp");
                        visualizar.forward(request, response);
                    }
                }
                break;

            /*
            case "cadastrar_responsavel":
                Responsavel res = new Responsavel();
                ResponsavelDAO resDAO = new ResponsavelDAO();
                Usuario usu_res = new Usuario();

                res.setNome(request.getParameter("nome"));
                res.setData_nasc(request.getParameter("data"));
                res.setSexo(request.getParameter("sexo"));
                res.setTelefone(request.getParameter("telefone"));
                res.setEmail(request.getParameter("email"));
                res.setNacionalidade(request.getParameter("nacionalidade"));
                res.setEstado(request.getParameter("estado"));
                res.setCidade(request.getParameter("cidade"));
                res.setCep(request.getParameter("cep"));

                usu_res.setEmail(request.getParameter("email"));
                usu_res.setSenha(request.getParameter("senha"));
                usu_res.setTipo(request.getParameter("tipo"));
                
                idCriado = resDAO.create(res, usu_res);
                if (idCriado > 0) {
                    System.out.println("Responsável criado com sucesso!");
                    System.out.println("ID DO RESPONSÁVEL CRIADO: " + idCriado);
                    RequestDispatcher visualizar = request.getRequestDispatcher("cadastro_concluido.jsp");
                    visualizar.forward(request, response);
                } else {
                    System.out.println("Erro ao criar Responsável!");
                    RequestDispatcher visualizar = request.getRequestDispatcher("erro.jsp");
                    visualizar.forward(request, response);
                }
                break;
             */
            case "cadastrar_clube":
                Clube clu = new Clube();
                ClubeDAO cluDAO = new ClubeDAO();
                Usuario user_clu = new Usuario();

                clu.setRazao(request.getParameter("razao"));
                clu.setFantasia(request.getParameter("fantasia"));
                clu.setData_fundacao(request.getParameter("fundacao"));
                clu.setPais(request.getParameter("pais"));
                clu.setEstado(request.getParameter("estado"));
                clu.setCidade(request.getParameter("cidade"));
                clu.setCep(request.getParameter("cep"));
                clu.setTelefone(request.getParameter("telefone"));
                clu.setEmail(request.getParameter("email"));
                clu.setCnpj(request.getParameter("cnpj"));
                clu.setSobre(request.getParameter("sobre"));
                clu.setResponsavel_cadastro(request.getParameter("resp"));

                user_clu.setEmail(request.getParameter("email"));
                user_clu.setSenha(request.getParameter("senha"));
                user_clu.setTipo(request.getParameter("tipo"));

                UsuarioDAO usuCadCluDAO = new UsuarioDAO();
                if (usuCadCluDAO.jaExiste(user_clu.getEmail())) {
                    RequestDispatcher visualizar = request.getRequestDispatcher("email_ja_cadastrado.jsp");
                    visualizar.forward(request, response);
                } else {
                    int idCriado = cluDAO.create(clu, user_clu);
                    if (idCriado > 0) {
                        System.out.println("Clube criado com sucesso");
                        System.out.println("ID do clube criado: " + idCriado);
                        RequestDispatcher visualizar = request.getRequestDispatcher("cadastro_concluido.jsp");
                        visualizar.forward(request, response);
                    } else {
                        System.out.println("Erro ao criar Clube!");
                        RequestDispatcher visualizar = request.getRequestDispatcher("erro.jsp");
                        visualizar.forward(request, response);
                    }
                }
                break;

            case "verPerfil":
                System.out.println("entrou no perfil");
                HttpSession sessao = request.getSession();
                int idUsu = Integer.parseInt(sessao.getAttribute("idDados").toString());

                // fazer um select e setar um usuario
                UsuarioDAO user_perfilDAO = new UsuarioDAO();
                Usuario user_perfil = user_perfilDAO.selecionarUsu(idUsu);

                String tipoDeAcesso = user_perfil.getTipo();
                int idDados = user_perfil.getIdDados();
                System.out.println("É um " + tipoDeAcesso + " que está tentando acessar");
                System.out.println("O id dele(a) é: " + idDados);

                if (tipoDeAcesso.equals("jogador")) {
                    JogadorDAO jogPerfilDAO = new JogadorDAO();
                    request.setAttribute("jogador", jogPerfilDAO.selecionarPorId(idDados));
                    RequestDispatcher visualizar = request.getRequestDispatcher("perfilJog.jsp");
                    visualizar.forward(request, response);
                } else {
                    ClubeDAO cluPerfilDAO = new ClubeDAO();
                    request.setAttribute("clube", cluPerfilDAO.selecionarPorId(idDados));
                    RequestDispatcher visualizar = request.getRequestDispatcher("perfilClube.jsp");
                    visualizar.forward(request, response);
                }

                /*
                if (tipoDeAcesso.equals("jogador")) {
                    JogadorDAO jogPerfilDAO = new JogadorDAO();
                    request.setAttribute("jogador", jogPerfilDAO.selecionarPorId(idDados));
                    RequestDispatcher visualizar = request.getRequestDispatcher("perfilJog.jsp");
                    visualizar.forward(request, response);
                } else if (tipoDeAcesso.equals("responsavel")) {
                    ResponsavelDAO resPerfilDAO = new ResponsavelDAO();
                    request.setAttribute("responsavel", resPerfilDAO.selecionarPorId(idDados));
                    RequestDispatcher visualizar = request.getRequestDispatcher("perfilResp.jsp");
                    visualizar.forward(request, response);
                } else if (tipoDeAcesso.equals("clube")) {
                    ClubeDAO cluPerfilDAO = new ClubeDAO();
                    request.setAttribute("clube", cluPerfilDAO.selecionarPorId(idDados));
                    RequestDispatcher visualizar = request.getRequestDispatcher("perfilClube.jsp");
                    visualizar.forward(request, response);
                }
                 */
                break;

            case "alterar_jogador":
                System.out.println("entrei no alterar!!");
                Jogador editjog = new Jogador();
                JogadorDAO editjogDAO = new JogadorDAO();
                Usuario usu_editjog = new Usuario();
                UsuarioDAO usu_editjogDAO = new UsuarioDAO();

                System.out.println("já criei os objetos");

                editjog.setIdjogador(Integer.parseInt(request.getParameter("idJog")));
                editjog.setNome(request.getParameter("nome"));
                editjog.setData_nasc(request.getParameter("data"));
                editjog.setSexo(request.getParameter("sexo"));
                editjog.setTelefone(request.getParameter("telefone"));
                editjog.setEmail(request.getParameter("email"));
                editjog.setNacionalidade(request.getParameter("nacionalidade"));
                editjog.setEstado(request.getParameter("estado"));
                editjog.setCidade(request.getParameter("cidade"));
                editjog.setCep(request.getParameter("cep"));
                editjog.setPosicao_principal(request.getParameter("posicao_principal"));
                editjog.setPosicao_secundaria(request.getParameter("posicao_secundaria"));
                editjog.setAltura(Double.parseDouble(request.getParameter("altura")));
                editjog.setPeso(Double.parseDouble(request.getParameter("peso")));
                editjog.setIdDados(Integer.parseInt(request.getParameter("idJog")));
                editjog.setEmail(request.getParameter("email"));

                HttpSession sessaoAltJog = request.getSession();
                usu_editjog.setIdUsuario(Integer.parseInt(sessaoAltJog.getAttribute("idDados").toString()));
                usu_editjog.setEmail(request.getParameter("email"));
                usu_editjog.setSenha(request.getParameter("senha"));

                if (usu_editjogDAO.validarSenha(usu_editjog)) {
                    if (editjogDAO.update(editjog, editjog.getIdDados())) {
                        System.out.println("Dados de jogador alterados com sucesso!!");
                        if (usu_editjogDAO.update(usu_editjog)) {
                            System.out.println("Dados de usuário alterados com sucesso!!");
                        }
                        RequestDispatcher visualizar = request.getRequestDispatcher("sucessoAltJog.jsp");
                        visualizar.forward(request, response);
                    } else {
                        System.out.println("ERRO AO ALTERAR DADOS DE JOGADOR");
                        RequestDispatcher visualizar = request.getRequestDispatcher("erroAltJog.jsp");
                        visualizar.forward(request, response);
                    }
                } else {
                    System.out.println("chegou no senha diferente");
                    RequestDispatcher visualizar = request.getRequestDispatcher("erroSenhaDiferenteJogador.jsp");
                    visualizar.forward(request, response);
                }

                break;
            /*
            case "alterar_responsavel":
                Responsavel editres = new Responsavel();
                ResponsavelDAO editresDAO = new ResponsavelDAO();
                Usuario usu_editres = new Usuario();
                UsuarioDAO usu_editresDAO = new UsuarioDAO();

                editres.setIdresponsavel(Integer.parseInt(request.getParameter("idRes")));
                editres.setNome(request.getParameter("nome"));
                editres.setData_nasc(request.getParameter("data"));
                editres.setSexo(request.getParameter("sexo"));
                editres.setTelefone(request.getParameter("telefone"));
                editres.setEmail(request.getParameter("email"));
                editres.setNacionalidade(request.getParameter("nacionalidade"));
                editres.setEstado(request.getParameter("estado"));
                editres.setCidade(request.getParameter("cidade"));
                editres.setCep(request.getParameter("cep"));
                editres.setIdDados(Integer.parseInt(request.getParameter("idRes")));

                HttpSession sessaoAltRes = request.getSession();
                usu_editres.setIdUsuario(Integer.parseInt(sessaoAltRes.getAttribute("idDados").toString()));

                usu_editres.setEmail(request.getParameter("email"));
                usu_editres.setSenha(request.getParameter("senha"));

                if (editresDAO.update(editres)) {
                    System.out.println("Dados de responsável com sucesso!!");
                    if (usu_editresDAO.update(usu_editres)) {
                        System.out.println("Dados de responsável com sucesso!!");
                    }
                    RequestDispatcher visualizar = request.getRequestDispatcher("index_responsavel.jsp");
                    visualizar.forward(request, response);
                } else {
                    System.out.println("ERRO AO ALETRAR DADOS DE RESPONSÁVEL");
                }
                break;
             */
            case "alterar_clube":
                Clube editclu = new Clube();
                ClubeDAO editcluDAO = new ClubeDAO();
                Usuario usu_editclu = new Usuario();
                UsuarioDAO usu_editcluDAO = new UsuarioDAO();

                editclu.setIdclube(Integer.parseInt(request.getParameter("idClu")));
                editclu.setRazao(request.getParameter("razao"));
                editclu.setFantasia(request.getParameter("fantasia"));
                editclu.setData_fundacao(request.getParameter("fundacao"));
                editclu.setPais(request.getParameter("pais"));
                editclu.setEstado(request.getParameter("estado"));
                editclu.setCidade(request.getParameter("cidade"));
                editclu.setCep(request.getParameter("cep"));
                editclu.setTelefone(request.getParameter("telefone"));
                editclu.setEmail(request.getParameter("email"));
                editclu.setCnpj(request.getParameter("cnpj"));
                editclu.setSobre(request.getParameter("sobre"));
                editclu.setResponsavel_cadastro(request.getParameter("resp"));
                editclu.setIdDados(Integer.parseInt(request.getParameter("idClu")));

                HttpSession sessaoAltClu = request.getSession();
                usu_editclu.setIdUsuario(Integer.parseInt(sessaoAltClu.getAttribute("idDados").toString()));
                usu_editclu.setEmail(request.getParameter("email"));
                usu_editclu.setSenha(request.getParameter("senha"));

                if (usu_editcluDAO.validarSenha(usu_editclu)) {
                    if (editcluDAO.update(editclu)) {
                        System.out.println("Dados do Clube alterado com sucesso!!");
                        if (usu_editcluDAO.update(usu_editclu)) {
                            System.out.println("Dados do Usuário alterado com sucesso!!");
                        }
                        RequestDispatcher visualizar = request.getRequestDispatcher("sucessoAltClu.jsp");
                        visualizar.forward(request, response);
                    } else {
                        System.out.println("ERRO AO ALTERAR DADOS DO CLUBE!!");
                        RequestDispatcher visualizar = request.getRequestDispatcher("erroAltClu.jsp");
                        visualizar.forward(request, response);
                    }
                } else {
                    RequestDispatcher visualizar = request.getRequestDispatcher("erroSenhaDiferenteClu.jsp");
                    visualizar.forward(request, response);
                }

                break;

            case "entrarCadVagas":
                System.out.println("chegou no entrar cad");

                HttpSession sessaoEntrarCad = request.getSession();
                int idUsuario = Integer.parseInt(sessaoEntrarCad.getAttribute("idDados").toString());

                // fazer um select e setar um usuario
                UsuarioDAO user_CadVagasDAO = new UsuarioDAO();
                Usuario user_CadVagas = user_CadVagasDAO.selecionarUsu(idUsuario);
                int idDadosVag = user_CadVagas.getIdDados();

                ClubeDAO cluCadVagasDAO = new ClubeDAO();
                request.setAttribute("clube", cluCadVagasDAO.selecionarPorId(idDadosVag));
                RequestDispatcher visualizar = request.getRequestDispatcher("cadastrarVaga.jsp");
                visualizar.forward(request, response);

                /*ClubeDAO cluPerfilDAO = new ClubeDAO();
                    request.setAttribute("clube", cluPerfilDAO.selecionarPorId(idDados));
                    RequestDispatcher visualizar = request.getRequestDispatcher("perfilClube.jsp");
                    visualizar.forward(request, response);*/
                break;

            case "concluirCadVagas":
                System.out.println("chegou no concluir");
                Vaga vaga = new Vaga();
                VagaDAO vagaDAO = new VagaDAO();

                vaga.setIdclube(Integer.parseInt(request.getParameter("idclube")));
                vaga.setPais(request.getParameter("pais"));
                vaga.setEstado(request.getParameter("estado"));
                vaga.setCidade(request.getParameter("cidade"));
                vaga.setCep(request.getParameter("cep"));
                vaga.setBairro(request.getParameter("bairro"));
                vaga.setNome_local(request.getParameter("nome_local"));
                vaga.setReferencia(request.getParameter("referencia"));
                vaga.setData(request.getParameter("data"));
                System.out.println(vaga.getData());
                vaga.setResponsavel_vaga(request.getParameter("responsavel_vaga"));
                vaga.setPosicao(request.getParameter("posicao"));
                vaga.setSub_requisitado(Integer.parseInt(request.getParameter("sub_requisitado")));
                vaga.setSexo_requisitado(request.getParameter("sexo"));

                Usuario usu_cadVag = new Usuario();
                UsuarioDAO usu_cadVagDAO = new UsuarioDAO();
                HttpSession sessaoCadVag = request.getSession();
                usu_cadVag.setIdUsuario(Integer.parseInt(sessaoCadVag.getAttribute("idDados").toString()));
                usu_cadVag.setSenha(request.getParameter("senha"));

                if (usu_cadVagDAO.validarSenha(usu_cadVag)) {
                    if (vagaDAO.create(vaga)) {
                        System.out.println("Vaga criado com sucesso");
                        request.setAttribute("lista_vagas", vagaDAO.read());
                        RequestDispatcher visualizarVaga = request.getRequestDispatcher("sucessoCadVag.jsp");
                        visualizarVaga.forward(request, response);
                    }
                } else {
                    RequestDispatcher erroSenhaDif = request.getRequestDispatcher("erroSenhaDiferenteClu.jsp");
                    erroSenhaDif.forward(request, response);
                }
                break;

            case "listarVagasPorClube":
                System.out.println("Entou no minhas vagas");

                HttpSession sessaoListarPorClube = request.getSession();
                int idUsuListarPorClube = Integer.parseInt(sessaoListarPorClube.getAttribute("idDados").toString());

                UsuarioDAO user_listarPorClubeDAO = new UsuarioDAO();
                Usuario usuListarPorClube = user_listarPorClubeDAO.selecionarUsu(idUsuListarPorClube);

                int idDadosListarPorClube = usuListarPorClube.getIdDados();

                InscricaoDAO inscricoesPorClubeDAO = new InscricaoDAO();
                VagaDAO vagasPorClubeDAO = new VagaDAO();

                request.setAttribute("lista_inscricoes", inscricoesPorClubeDAO.listarPorClube(idDadosListarPorClube));
                request.setAttribute("lista_vagas", vagasPorClubeDAO.listarPorClube(idDadosListarPorClube));

                RequestDispatcher visualizarListarPorClube = request.getRequestDispatcher("vagas_clube.jsp");
                visualizarListarPorClube.forward(request, response);

                break;

            case "confirmar_inscricao":
                System.out.println("Entrou no cad_inscricao");
                Inscricao createIns = new Inscricao();
                InscricaoDAO createInsDAO = new InscricaoDAO();
                createIns.setIdvaga(Integer.parseInt(request.getParameter("idvaga")));
                createIns.setIdjogador(Integer.parseInt(request.getParameter("idjogador")));
                createIns.setData_inscricao(request.getParameter("data_inscricao"));
                createIns.setStatus(request.getParameter("status"));

                String sexoJog = request.getParameter("sexo");
                String sexoVag = request.getParameter("sexoVag");
                System.out.println("Sexo jogador: " + sexoJog);
                System.out.println("Sexo vaga: " + sexoVag);

                if (createInsDAO.jaEstaInscrito(createIns)) {
                    if (sexoJog.equals(sexoVag)) {
                        if (createInsDAO.create(createIns)) {
                            System.out.println("Inscrição confirmada com sucesso!");
                            response.sendRedirect("inscricao_confirmada.jsp");
                        }
                    } else {
                        RequestDispatcher sexoErrado = request.getRequestDispatcher("erroSexoErrado.jsp");
                        sexoErrado.forward(request, response);
                    }

                } else {
                    RequestDispatcher jaEstaInscrito = request.getRequestDispatcher("erroJaEstaInscrito.jsp");
                    jaEstaInscrito.forward(request, response);
                }

                break;

            case "confirmar_status":
                System.out.println("entrou no cofirmar status");
                InscricaoDAO insDAO = new InscricaoDAO();

                int idInscricao = Integer.parseInt(request.getParameter("idinscricao"));
                System.out.println("o id para ser alterado é: " + idInscricao);
                String status = request.getParameter("status");
                System.out.println("o status será: " + status);

                if (insDAO.alterarStatus(status, idInscricao)) {
                    System.out.println("Status alterado com SUCESSO!");

                    RequestDispatcher statusAlterado = request.getRequestDispatcher("index_clube.jsp");
                    statusAlterado.forward(request, response);
                }
                break;

            case "esqueciASenha":
                System.out.println("Entrou no esqueciASenha");
                UsuarioDAO usuesqueciSenhaDAO = new UsuarioDAO();
                String email = request.getParameter("email");
                String novaSenha = request.getParameter("senha");

                if (usuesqueciSenhaDAO.jaExiste(email)) {
                    if (usuesqueciSenhaDAO.alterarSenha(novaSenha, email)) {
                        RequestDispatcher senhaAlterada = request.getRequestDispatcher("senha_alteradaSucesso.jsp");
                        senhaAlterada.forward(request, response);
                    } else {
                        RequestDispatcher senhaAlterada = request.getRequestDispatcher("erroAlterarSenha.jsp");
                        senhaAlterada.forward(request, response);
                    }
                } else {
                    RequestDispatcher senhaAlterada = request.getRequestDispatcher("erroAlterarSenha.jsp");
                    senhaAlterada.forward(request, response);
                }

                break;

            case "verPerfilPorInscricao":
                System.out.println("entrou no verPerfilPorInscricao");
                int idJog = Integer.parseInt(request.getParameter("idJog"));
                System.out.println("O ID do jog para visualizar é: " + idJog);

                JogadorDAO jogPorInscDAO = new JogadorDAO();

                request.setAttribute("jogadorInsc", jogPorInscDAO.selecionarPorId(idJog));
                RequestDispatcher visuJogInsc = request.getRequestDispatcher("perfilPorInsc.jsp");
                visuJogInsc.forward(request, response);
                break;
            default:
                System.out.println("ENTROU NO DEFAULT!");
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
