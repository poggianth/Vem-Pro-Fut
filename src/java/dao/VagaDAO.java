package dao;

import connection.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import model.Vaga;

/**
 *
 * @author Th
 */
public class VagaDAO {

    private Connection con = null;

    public boolean create(Vaga vaga) {
        con = MyConnection.getConnection();

        String sql = "insert into vaga(idclube, pais, estado, cidade, cep, bairro, nome_local, referencia, data, responsavel_vaga, posicao, sub_requisitado, sexo_requisitado) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, vaga.getIdclube());
            stmt.setString(2, vaga.getPais());
            stmt.setString(3, vaga.getEstado());
            stmt.setString(4, vaga.getCidade());
            stmt.setString(5, vaga.getCep());
            stmt.setString(6, vaga.getBairro());
            stmt.setString(7, vaga.getNome_local());
            stmt.setString(8, vaga.getReferencia());
            
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dtNasc = formato.parse(vaga.getData());
            java.sql.Date dt_nascimento = new java.sql.Date(dtNasc.getTime());
            
            stmt.setDate(9, dt_nascimento);
            stmt.setString(10, vaga.getResponsavel_vaga());
            stmt.setString(11, vaga.getPosicao());
            stmt.setInt(12, vaga.getSub_requisitado());
            stmt.setString(13, vaga.getSexo_requisitado());
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("[ERRO] Falha ao Inserir a Vaga: " + e);
            return false;
        } finally {
            MyConnection.closeConnection(con, stmt);
        }
    }

    public List<Vaga> readPorPosicao(String posicao) {
        con = MyConnection.getConnection();

        String sql = "select * from vaga where posicao=?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Vaga> vagas = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, posicao);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Vaga vag = new Vaga();
                vag.setIdvaga(rs.getInt("idvaga"));
                vag.setIdclube(rs.getInt("idclube"));
                vag.setPais(rs.getString("pais"));
                vag.setEstado(rs.getString("estado"));
                vag.setCidade(rs.getString("cidade"));
                vag.setCep(rs.getString("cep"));
                vag.setBairro(rs.getString("bairro"));
                vag.setNome_local(rs.getString("nome_local"));
                vag.setReferencia(rs.getString("referencia"));
                vag.setResponsavel_vaga(rs.getString("responsavel_vaga"));
                vag.setPosicao(rs.getString("posicao"));
                vag.setSub_requisitado(rs.getInt("sub_requisitado"));
                vag.setSexo_requisitado(rs.getString("sexo_requisitado"));
                vagas.add(vag);
            }
        } catch (Exception e) {
            System.out.println("Erro ao selecionar vagas por posição: " + e);
        } finally {
            MyConnection.closeConnection(con, stmt, rs);
        }
        return vagas;
    }

    public List<Vaga> listarPorClube(int idClube) {
        con = MyConnection.getConnection();

        String sql = "select * from vaga where idclube=?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Vaga> vagas = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, idClube);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Vaga vag = new Vaga();
                vag.setIdvaga(rs.getInt("idvaga"));
                vag.setIdclube(rs.getInt("idclube"));
                vag.setPais(rs.getString("pais"));
                vag.setEstado(rs.getString("estado"));
                vag.setCidade(rs.getString("cidade"));
                vag.setCep(rs.getString("cep"));
                vag.setBairro(rs.getString("bairro"));
                vag.setNome_local(rs.getString("nome_local"));
                vag.setReferencia(rs.getString("referencia"));
                vag.setResponsavel_vaga(rs.getString("responsavel_vaga"));
                vag.setPosicao(rs.getString("posicao"));
                vag.setSub_requisitado(rs.getInt("sub_requisitado"));
                vag.setSexo_requisitado(rs.getString("sexo_requisitado"));
                vagas.add(vag);
            }
        } catch (Exception e) {
            System.out.println("Erro ao selecionar vagas por posição: " + e);
        } finally {
            MyConnection.closeConnection(con, stmt, rs);
        }
        return vagas;
    }

    public List<Vaga> read() {
        con = MyConnection.getConnection();

        String sql = "select * from vaga";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Vaga> vagas = new ArrayList<>();
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Vaga vag = new Vaga();
                vag.setIdvaga(rs.getInt("idvaga"));
                vag.setIdclube(rs.getInt("idclube"));
                vag.setPais(rs.getString("pais"));
                vag.setEstado(rs.getString("estado"));
                vag.setCidade(rs.getString("cidade"));
                vag.setCep(rs.getString("cep"));
                vag.setBairro(rs.getString("bairro"));
                vag.setNome_local(rs.getString("nome_local"));
                vag.setReferencia(rs.getString("referencia"));
                vag.setResponsavel_vaga(rs.getString("responsavel_vaga"));
                vag.setPosicao(rs.getString("posicao"));
                vag.setSub_requisitado(rs.getInt("sub_requisitado"));
                vag.setSexo_requisitado(rs.getString("sexo_requisitado"));
                vagas.add(vag);
            }
        } catch (Exception e) {
            System.out.println("[ERRO] Alguma coisa não saiu conforme o planejado: " + e);
        } finally {
            MyConnection.closeConnection(con, stmt, rs);
        }
        return vagas;
    }

    public Vaga selecionarPorIdVaga(int idvaga) {
        con = MyConnection.getConnection();

        String sql = "select * from vaga where idvaga=?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Vaga vag = new Vaga();

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, idvaga);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                vag.setIdvaga(rs.getInt("idvaga"));
                vag.setIdclube(rs.getInt("idclube"));
                vag.setPais(rs.getString("pais"));
                vag.setEstado(rs.getString("estado"));
                vag.setCidade(rs.getString("cidade"));
                vag.setCep(rs.getString("cep"));
                vag.setBairro(rs.getString("bairro"));
                vag.setNome_local(rs.getString("nome_local"));
                vag.setReferencia(rs.getString("referencia"));
                vag.setResponsavel_vaga(rs.getString("responsavel_vaga"));
                vag.setPosicao(rs.getString("posicao"));
                vag.setSub_requisitado(rs.getInt("sub_requisitado"));
                vag.setSexo_requisitado(rs.getString("sexo_requisitado"));
            }
        } catch (Exception e) {
            System.out.println("[ERRO] Alguma coisa não saiu conforme o planejado: " + e);
        } finally {
            MyConnection.closeConnection(con, stmt, rs);
        }
        return vag;
    }

    public boolean update(Vaga vag) {
        con = MyConnection.getConnection();

        String sql = "update vaga set idclube=?, pais=?, estado=?, cidade=?, cep=?, bairro=?, nome_local=?, referencia=?, responsavel_vaga=?, posicao=?, sub_requisitado=?, sexo_requisitado=? where idvaga=?";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, vag.getIdclube());
            stmt.setString(2, vag.getPais());
            stmt.setString(3, vag.getEstado());
            stmt.setString(4, vag.getCidade());
            stmt.setString(5, vag.getCep());
            stmt.setString(6, vag.getBairro());
            stmt.setString(7, vag.getNome_local());
            stmt.setString(8, vag.getReferencia());
            stmt.setString(9, vag.getResponsavel_vaga());
            stmt.setString(10, vag.getPosicao());
            stmt.setInt(11, vag.getSub_requisitado());
            stmt.setString(12, vag.getSexo_requisitado());
            stmt.setInt(13, vag.getIdvaga());
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao atualizar o vaga: " + e);
            return false;
        } finally {
            MyConnection.closeConnection(con, stmt);
        }
    }

    public boolean delete(int idVaga) {
        con = MyConnection.getConnection();
        String sql = "delete from inscricao where idvaga=?";
        String sql2 = "delete from vaga where idvaga=?";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, idVaga);
            stmt.executeUpdate();
            stmt = con.prepareStatement(sql2);
            stmt.setInt(1, idVaga);
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("[ERRO] Não foi possível excluir a vaga: " + e);
            return false;
        } finally {
            MyConnection.closeConnection(con, stmt);
        }
    }
}
