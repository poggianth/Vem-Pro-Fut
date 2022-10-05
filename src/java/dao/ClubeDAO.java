package dao;

import connection.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import model.Clube;
import model.Usuario;

/**
 *
 * @author Th
 */
public class ClubeDAO {

    private Connection con = null;

    public int create(Clube clube, Usuario user) {
        con = MyConnection.getConnection();
        int idCriado = 0;
        String sql = "insert into clube(razao, fantasia, data_fundacao, pais, estado, cidade, cep, telefone, email, cnpj, sobre, responsavel_cadastro, idDados) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String sql2 = "insert into usuario(email, senha, tipo, idDados) values(?,?,?,?)";

        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql, stmt.RETURN_GENERATED_KEYS);
            stmt.setString(1, clube.getRazao());
            stmt.setString(2, clube.getFantasia());

            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dtNasc = formato.parse(clube.getData_fundacao());
            java.sql.Date dt_fundacao = new java.sql.Date(dtNasc.getTime());

            stmt.setDate(3, dt_fundacao);
            stmt.setString(4, clube.getPais());
            stmt.setString(5, clube.getEstado());
            stmt.setString(6, clube.getCidade());
            stmt.setString(7, clube.getCep());
            stmt.setString(8, clube.getTelefone());
            stmt.setString(9, clube.getEmail());
            stmt.setString(10, clube.getCnpj());
            stmt.setString(11, clube.getSobre());
            stmt.setString(12, clube.getResponsavel_cadastro());
            stmt.setInt(13, idCriado);
            stmt.execute();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                idCriado = rs.getInt(1);
                ClubeDAO cluDAO = new ClubeDAO();

                stmt = con.prepareStatement(sql2);
                stmt.setString(1, user.getEmail());
                stmt.setString(2, user.getSenha());
                stmt.setString(3, user.getTipo());
                stmt.setInt(4, idCriado);
                stmt.executeUpdate();

                if (cluDAO.alterarIdDados(idCriado)) {
                    System.out.println("Id dados alterado com sucesso!");
                }
            }

        } catch (Exception e) {
            System.out.println("[ERRO] Falha ao Inserir Clube: " + e);
            idCriado = 0;
        } finally {
            MyConnection.closeConnection(con, stmt);
        }
        return idCriado;
    }

    private boolean alterarIdDados(int idClube) {
        con = MyConnection.getConnection();
        String sql = "update clube set idDados=? where idclube=?;";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, idClube);
            stmt.setInt(2, idClube);
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao atualizar o Id dados do Clube: " + e);
            return false;
        } finally {
            MyConnection.closeConnection(con, stmt);
        }
    }

    public Clube selecionarPorId(int idDados) {
        //select * from jogador, usuario where usuario.tipo="jogador" and jogador.idDados=1;
        con = MyConnection.getConnection();

        String sql = "select clube.* from clube, usuario where usuario.tipo='clube' and clube.idDados=?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Clube clu = new Clube();
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, idDados);
            rs = stmt.executeQuery();
            while (rs.next()) {
                clu.setIdclube(rs.getInt("idclube"));
                clu.setRazao(rs.getString("razao"));
                clu.setFantasia(rs.getString("fantasia"));
                clu.setData_fundacao(rs.getString("data_fundacao"));
                clu.setPais(rs.getString("pais"));
                clu.setEstado(rs.getString("pais"));
                clu.setCidade(rs.getString("cidade"));
                clu.setCep(rs.getString("cep"));
                clu.setTelefone(rs.getString("telefone"));
                clu.setEmail(rs.getString("email"));
                clu.setCnpj(rs.getString("cnpj"));
                clu.setSobre(rs.getString("sobre"));
                clu.setResponsavel_cadastro(rs.getString("responsavel_cadastro"));
                clu.setIdDados(rs.getInt("idDados"));
            }
        } catch (Exception e) {
            System.out.println("Erro ao selecionar Clube: " + e);
        } finally {
            MyConnection.closeConnection(con, stmt, rs);
        }
        return clu;
    }

    public List<Clube> read() {
        con = MyConnection.getConnection();

        String sql = "select * from clube";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Clube> clubes = new ArrayList<>();
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Clube clu = new Clube();
                clu.setIdclube(rs.getInt("idclube"));
                clu.setRazao(rs.getString("razao"));
                clu.setFantasia(rs.getString("fantasia"));
                clu.setData_fundacao(rs.getDate("data_fundacao").toString());
                clu.setPais(rs.getString("pais"));
                clu.setEstado(rs.getString("estado"));
                clu.setCidade(rs.getString("cidade"));
                clu.setCep(rs.getString("cep"));
                clu.setTelefone(rs.getString("telefone"));
                clu.setEmail(rs.getString("email"));
                clu.setCnpj(rs.getString("cnpj"));
                clu.setSobre(rs.getString("sobre"));
                clu.setResponsavel_cadastro(rs.getString("responsavel_cadastro"));
                clubes.add(clu);
            }
        } catch (Exception e) {
            System.out.println("[ERRO] Alguma coisa não saiu conforme o planejado: " + e);
        } finally {
            MyConnection.closeConnection(con, stmt, rs);
        }
        return clubes;
    }

    public boolean update(Clube clu) {
        con = MyConnection.getConnection();

        String sql = "update clube set razao=?, fantasia=?, data_fundacao=?, pais=?, estado=?, cidade=?, cep=?, telefone=?, email=?, cnpj=?, sobre=?, responsavel_cadastro=? where idclube=?";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, clu.getRazao());
            stmt.setString(2, clu.getFantasia());

            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dtNasc = formato.parse(clu.getData_fundacao());
            java.sql.Date dt_fundacao = new java.sql.Date(dtNasc.getTime());

            stmt.setDate(3, dt_fundacao);
            stmt.setString(4, clu.getPais());
            stmt.setString(5, clu.getEstado());
            stmt.setString(6, clu.getCidade());
            stmt.setString(7, clu.getCep());
            stmt.setString(8, clu.getTelefone());
            stmt.setString(9, clu.getEmail());
            stmt.setString(10, clu.getCnpj());
            stmt.setString(11, clu.getSobre());
            stmt.setString(12, clu.getResponsavel_cadastro());
            stmt.setInt(13, clu.getIdclube());
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao atualizar o Clube: " + e);
            return false;
        } finally {
            MyConnection.closeConnection(con, stmt);
        }
    }

    public boolean delete(int id) {
        con = MyConnection.getConnection();

        String sqlSelectVagas = "select idvaga from vaga where idclube=?";
        String sqldelInsc = "delete from inscricao where idvaga=?";
        String sqldelVaga = "delete from vaga where idclube=?";
        String sqldelClube = "delete from clube where idclube=?";
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement(sqlSelectVagas);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idVaga = rs.getInt("idvaga");
                System.out.println("Achei uma inscrição: " + idVaga);
                stmt = con.prepareStatement(sqldelInsc);
                stmt.setInt(1, idVaga);
                stmt.executeUpdate();
                System.out.println("Deletei uma inscrição!");
            }

            stmt = con.prepareStatement(sqldelVaga);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt = con.prepareStatement(sqldelClube);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("[ERRO] Não foi possível excluir o clube: " + e);
            return false;
        } finally {
            MyConnection.closeConnection(con, stmt, rs);
        }
    }
}
