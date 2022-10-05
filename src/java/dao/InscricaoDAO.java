package dao;

import connection.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import model.Inscricao;

/**
 *
 * @author Th
 */
public class InscricaoDAO {

    private Connection con = null;

    public boolean alterarStatus(String status, int idinscricao) {
        con = MyConnection.getConnection();

        String sql = "UPDATE inscricao SET status = ? WHERE idinscricao = ?";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, status);
            stmt.setInt(2, idinscricao);
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao alterar status: " + e);
            return false;
        } finally {
            MyConnection.closeConnection(con, stmt);
        }
    }
    
    public boolean jaEstaInscrito(Inscricao ins){
        con = MyConnection.getConnection();
        boolean resp = true;
        
        String sql = "select * from inscricao where idvaga=? and idjogador=?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, ins.getIdvaga());
            stmt.setInt(2, ins.getIdjogador());
            rs = stmt.executeQuery();
            
            while (rs.next()) {                
                resp = false;
            }
        } catch (Exception e) {
            System.out.println("O jogador não está inscrito.");
            resp = false;
        }
        return resp;
    }

    public boolean create(Inscricao ins) {
        con = MyConnection.getConnection();

        String sql = "INSERT INTO inscricao(idvaga, idjogador, data_inscricao, status) VALUES (?,?,?,?)";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, ins.getIdvaga());
            stmt.setInt(2, ins.getIdjogador());
            
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            System.out.println("yyyy/MM/dd HH:mm:ss-> "+dtf.format(LocalDateTime.now()));
            String dt_atual = dtf.format(LocalDateTime.now());
            
            
            stmt.setString(3, dt_atual);
            stmt.setString(4, ins.getStatus());
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao inserir Inscrição: " + e);
            return false;
        } finally {
            MyConnection.closeConnection(con, stmt);
        }
    }

    public List<Inscricao> listarTodas() {
        con = MyConnection.getConnection();

        String sql = "select * from inscricao";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Inscricao> inscricoes = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Inscricao ins = new Inscricao();
                ins.setIdinscricao(rs.getInt("idinscricao"));
                ins.setIdvaga(rs.getInt("idvaga"));
                ins.setIdjogador(rs.getInt("idjogador"));
                ins.setData_inscricao(rs.getString("data_inscricao"));
                ins.setStatus(rs.getString("status"));
                inscricoes.add(ins);
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar todas as vagas: " + e);
        } finally {
            MyConnection.closeConnection(con, stmt, rs);
        }
        return inscricoes;
    }

    public Inscricao listarPorID(int idInscricao) {
        con = MyConnection.getConnection();

        String sql = "select * from inscricao where idinscricao=?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Inscricao ins = new Inscricao();
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, idInscricao);
            rs = stmt.executeQuery();
            while (rs.next()) {
                ins.setIdinscricao(rs.getInt("idinscricao"));
                ins.setIdvaga(rs.getInt("idvaga"));
                ins.setIdjogador(rs.getInt("idjogador"));
                ins.setData_inscricao(rs.getString("data_inscricao"));
                ins.setStatus(rs.getString("status"));
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar Inscricão por ID: " + e);
        } finally {
            MyConnection.closeConnection(con, stmt, rs);
        }
        return ins;
    }

    public List<Inscricao> listarPorClube(int idclube) {
        con = MyConnection.getConnection();

        String sql = "select inscricao.* from inscricao, vaga where vaga.idvaga=inscricao.idvaga and vaga.idclube=?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Inscricao> inscricoes = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, idclube);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Inscricao ins = new Inscricao();
                ins.setIdinscricao(rs.getInt("idinscricao"));
                ins.setIdvaga(rs.getInt("idvaga"));
                ins.setIdjogador(rs.getInt("idjogador"));
                ins.setData_inscricao(rs.getString("data_inscricao"));
                ins.setStatus(rs.getString("status"));
                inscricoes.add(ins);
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar as vagas por Idclube: " + e);
        } finally {
            MyConnection.closeConnection(con, stmt, rs);
        }
        return inscricoes;
    }
    
    public List<Inscricao> listarPorJogador(int idJogador) {
        con = MyConnection.getConnection();

        String sql = "select * from inscricao where idjogador=?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Inscricao> inscricoes = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, idJogador);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Inscricao ins = new Inscricao();
                ins.setIdinscricao(rs.getInt("idinscricao"));
                ins.setIdvaga(rs.getInt("idvaga"));
                ins.setIdjogador(rs.getInt("idjogador"));
                ins.setData_inscricao(rs.getString("data_inscricao"));
                ins.setStatus(rs.getString("status"));
                inscricoes.add(ins);
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar as vagas por Id jogador: " + e);
        } finally {
            MyConnection.closeConnection(con, stmt, rs);
        }
        return inscricoes;
    }

    public boolean delete(int id) {
        con = MyConnection.getConnection();

        String sql = "delete from inscricao where idinscricao=?";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("[ERRO] Não foi possível excluir a Inscrição:: " + e);
            return false;
        } finally {
            MyConnection.closeConnection(con, stmt);
        }
    }
}
