package dao;

import connection.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import model.Responsavel;
import model.Usuario;

/**
 *
 * @author Th
 */
public class ResponsavelDAO {

    private Connection con = null;

    public int create(Responsavel responsavel, Usuario user) {
        con = MyConnection.getConnection();
        int idCriado = 0;

        String sql = "insert into responsavel(nome, data_nasc, sexo, telefone, email, nacionalidade, estado, cidade, cep, idDados) VALUES(?,?,?,?,?,?,?,?,?,?)";
        String sql2 = "insert into usuario(email, senha, tipo, idDados) values(?,?,?,?)";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql, stmt.RETURN_GENERATED_KEYS);
            stmt.setString(1, responsavel.getNome());

            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dtNasc = formato.parse(responsavel.getData_nasc());
            java.sql.Date dt_nascimento = new java.sql.Date(dtNasc.getTime());

            stmt.setDate(2, dt_nascimento);
            stmt.setString(3, responsavel.getSexo());
            stmt.setString(4, responsavel.getTelefone());
            stmt.setString(5, responsavel.getEmail());
            stmt.setString(6, responsavel.getNacionalidade());
            stmt.setString(7, responsavel.getEstado());
            stmt.setString(8, responsavel.getCidade());
            stmt.setString(9, responsavel.getCep());
            stmt.setInt(10, idCriado);
            stmt.execute();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                idCriado = rs.getInt(1);
                ResponsavelDAO resDAO = new ResponsavelDAO();
                
                stmt = con.prepareStatement(sql2);
                stmt.setString(1, user.getEmail());
                stmt.setString(2, user.getSenha());
                stmt.setString(3, user.getTipo());
                stmt.setInt(4, idCriado);
                stmt.executeUpdate();
                
                if(resDAO.alterarIdDados(idCriado)){
                    System.out.println("Id dados alterado com sucesso!");
                }
            }

        } catch (Exception e) {
            System.out.println("[ERRO] Falha ao Inserir Responsavel e/ou Usuário: " + e);
            System.out.println(idCriado);
            idCriado = 0;
        } finally {
            MyConnection.closeConnection(con, stmt);
        }
        return idCriado;
    }
    
    private boolean alterarIdDados(int idResp){
        con = MyConnection.getConnection();
        String sql = "update responsavel set idDados=? where idresponsavel=?;";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, idResp);
            stmt.setInt(2, idResp);
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao atualizar o Id dados do responsável: " + e);
            return false;
        }finally{
            MyConnection.closeConnection(con, stmt);
        }
    }
    
    public Responsavel selecionarPorId(int idDados){
        //select * from jogador, usuario where usuario.tipo="jogador" and jogador.idDados=1;
        con = MyConnection.getConnection();
        
        String sql = "select responsavel.* from responsavel, usuario where usuario.tipo='responsavel' and responsavel.idDados=?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Responsavel res = new Responsavel();
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, idDados);
            rs = stmt.executeQuery();
            while (rs.next()) {                
                res.setIdresponsavel(rs.getInt("idresponsavel"));
                res.setNome(rs.getString("nome"));
                res.setData_nasc(rs.getString("data_nasc"));
                res.setSexo(rs.getString("sexo"));
                res.setTelefone(rs.getString("telefone"));
                res.setEmail(rs.getString("email"));
                res.setNacionalidade(rs.getString("nacionalidade"));
                res.setEstado(rs.getString("estado"));
                res.setCidade(rs.getString("cidade"));
                res.setCep(rs.getString("cep"));
                res.setIdDados(idDados);
            }
        } catch (Exception e) {
            System.out.println("Erro ao selecionar Responsável: " + e);
        } finally{
            MyConnection.closeConnection(con, stmt, rs);
        }
        return res;
    }
    
    public List<Responsavel> read() {
        con = MyConnection.getConnection();

        String sql = "select * from responsavel";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Responsavel> responsaveis = new ArrayList<>();
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Responsavel res = new Responsavel();
                res.setIdresponsavel(rs.getInt("idresponsavel"));
                res.setNome(rs.getString("nome"));
                res.setData_nasc(rs.getDate("data_nasc").toString());
                res.setSexo(rs.getString("sexo"));
                res.setTelefone(rs.getString("telefone"));
                res.setEmail(rs.getString("email"));
                res.setNacionalidade(rs.getString("nacionalidade"));
                res.setEstado(rs.getString("estado"));
                res.setCidade(rs.getString("cidade"));
                res.setCep(rs.getString("cep"));
                res.setIdDados(rs.getInt("idDados"));
                responsaveis.add(res);
            }
        } catch (Exception e) {
            System.out.println("[ERRO] Alguma coisa não saiu conforme o planejado: " + e);
        } finally {
            MyConnection.closeConnection(con, stmt, rs);
        }
        return responsaveis;
    }

    public boolean update(Responsavel res) {
        con = MyConnection.getConnection();

        String sql = "update responsavel set nome=?, data_nasc=?, sexo=?, telefone=?, email=?, nacionalidade=?, estado=?, cidade=?, cep=?, idDados=? where idresponsavel=?";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, res.getNome());

            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dtNasc = formato.parse(res.getData_nasc());
            java.sql.Date nascimento = new java.sql.Date(dtNasc.getTime());

            stmt.setDate(2, nascimento);
            stmt.setString(3, res.getSexo());
            stmt.setString(4, res.getTelefone());
            stmt.setString(5, res.getEmail());
            stmt.setString(6, res.getNacionalidade());
            stmt.setString(7, res.getEstado());
            stmt.setString(8, res.getCidade());
            stmt.setString(9, res.getCep());
            stmt.setInt(10, res.getIdDados());
            stmt.setInt(11, res.getIdresponsavel());
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao atualizar o Responsavel: " + e);
            return false;
        } finally {
            MyConnection.closeConnection(con, stmt);
        }
    }

    public boolean delete(int id) {
        con = MyConnection.getConnection();

        String sql = "delete from responsavel where idresponsavel=?";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("[ERRO] Não foi possível excluir o responsável: " + e);
            return false;
        } finally {
            MyConnection.closeConnection(con, stmt);
        }
    }
}
