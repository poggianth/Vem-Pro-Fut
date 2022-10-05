package dao;

import connection.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import model.Jogador;
import model.Usuario;

/**
 *
 * @author Th
 */
public class JogadorDAO {

    private Connection con = null;

    public int create(Jogador jogador, Usuario user) {
        con = MyConnection.getConnection();
        int idCriado = 0;

        String sql = "insert into jogador(nome, data_nasc, sexo, telefone, email, nacionalidade, estado, cidade, cep, posicao_principal, posicao_secundaria, altura, peso, idDados) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String sql2 = "insert into usuario(email, senha, tipo, idDados) values(?,?,?,?)";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql, stmt.RETURN_GENERATED_KEYS);
            stmt.setString(1, jogador.getNome());

            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dtNasc = formato.parse(jogador.getData_nasc());
            java.sql.Date dt_nascimento = new java.sql.Date(dtNasc.getTime());

            stmt.setDate(2, dt_nascimento);
            stmt.setString(3, jogador.getSexo());
            stmt.setString(4, jogador.getTelefone());
            stmt.setString(5, jogador.getEmail());
            stmt.setString(6, jogador.getNacionalidade());
            stmt.setString(7, jogador.getEstado());
            stmt.setString(8, jogador.getCidade());
            stmt.setString(9, jogador.getCep());
            stmt.setString(10, jogador.getPosicao_principal());
            stmt.setString(11, jogador.getPosicao_secundaria());
            stmt.setDouble(12, jogador.getAltura());
            stmt.setDouble(13, jogador.getPeso());
            stmt.setInt(14, idCriado);
            stmt.execute();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                idCriado = rs.getInt(1);
                JogadorDAO jogDAO = new JogadorDAO();

                stmt = con.prepareStatement(sql2);
                stmt.setString(1, user.getEmail());
                stmt.setString(2, user.getSenha());
                stmt.setString(3, user.getTipo());
                stmt.setInt(4, idCriado);
                stmt.executeUpdate();

                if (jogDAO.alterarIdDados(idCriado)) {
                    System.out.println("Id dados alterado com sucesso!");
                }
            }
        } catch (Exception e) {
            System.out.println("[ERRO] Falha ao Inserir Jogador e/ou Usuário: " + e);
            idCriado = 0;
        } finally {
            MyConnection.closeConnection(con, stmt);
        }
        return idCriado;
    }

    private boolean alterarIdDados(int idJog) {
        con = MyConnection.getConnection();
        String sql = "update jogador set idDados=? where idjogador=?;";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, idJog);
            stmt.setInt(2, idJog);
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao atualizar o Id dados do Jogador: " + e);
            return false;
        } finally {
            MyConnection.closeConnection(con, stmt);
        }
    }

    public List<Jogador> read() {
        con = MyConnection.getConnection();

        String sql = "select * from jogador";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Jogador> jogadores = new ArrayList<>();
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Jogador jog = new Jogador();
                jog.setIdjogador(rs.getInt("idjogador"));
                jog.setNome(rs.getString("nome"));
                jog.setData_nasc(rs.getDate("data_nasc").toString());
                jog.setSexo(rs.getNString("sexo"));
                jog.setTelefone(rs.getString("telefone"));
                jog.setEmail(rs.getString("email"));
                jog.setNacionalidade(rs.getString("nacionalidade"));
                jog.setEstado(rs.getString("estado"));
                jog.setCidade(rs.getString("cidade"));
                jog.setCep(rs.getString("cep"));
                jog.setPosicao_principal(rs.getString("posicao_principal"));
                jog.setPosicao_secundaria(rs.getString("posicao_secundaria"));
                jog.setAltura(rs.getFloat("altura"));
                jog.setPeso(rs.getFloat("peso"));
                jogadores.add(jog);
            }
        } catch (Exception e) {
            System.out.println("[ERRO] Alguma coisa não saiu conforme o planejado: " + e);
        } finally {
            MyConnection.closeConnection(con, stmt, rs);
        }
        return jogadores;
    }

    public Jogador selecionarPorId(int idDados) {
        //select * from jogador, usuario where usuario.tipo="jogador" and jogador.idDados=1;
        con = MyConnection.getConnection();

        String sql = "select jogador.* from jogador, usuario where usuario.tipo='jogador' and jogador.idDados=?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Jogador jog = new Jogador();
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, idDados);
            rs = stmt.executeQuery();
            while (rs.next()) {
                jog.setIdjogador(rs.getInt("idjogador"));
                jog.setNome(rs.getString("nome"));
                jog.setData_nasc(rs.getString("data_nasc"));
                jog.setSexo(rs.getString("sexo"));
                jog.setTelefone(rs.getString("telefone"));
                jog.setEmail(rs.getString("email"));
                jog.setNacionalidade(rs.getString("nacionalidade"));
                jog.setEstado(rs.getString("estado"));
                jog.setCidade(rs.getString("cidade"));
                jog.setCep(rs.getString("cep"));
                jog.setPosicao_principal(rs.getString("posicao_principal"));
                jog.setPosicao_secundaria(rs.getString("posicao_secundaria"));
                jog.setAltura(rs.getDouble("altura"));
                jog.setPeso(rs.getDouble("peso"));
                jog.setIdDados(idDados);
            }
        } catch (Exception e) {
            System.out.println("[OPS] Erro ao selecionar jogador pelo ID: " + e);
        } finally {
            MyConnection.closeConnection(con, stmt, rs);
        }
        return jog;
    }

    public boolean update(Jogador jog, int idDados) {
        con = MyConnection.getConnection();

        String sql = "update jogador set nome=?, data_nasc=?, sexo=?, telefone=?, email=?, nacionalidade=?, estado=?, cidade=?, cep=?, posicao_principal=?, posicao_secundaria=?, altura=?, peso=? where idjogador=?";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, jog.getNome());

            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dtNasc = formato.parse(jog.getData_nasc());
            java.sql.Date nascimento = new java.sql.Date(dtNasc.getTime());

            stmt.setDate(2, nascimento);
            stmt.setString(3, jog.getSexo());
            stmt.setString(4, jog.getTelefone());
            stmt.setString(5, jog.getEmail());
            stmt.setString(6, jog.getNacionalidade());
            stmt.setString(7, jog.getEstado());
            stmt.setString(8, jog.getCidade());
            stmt.setString(9, jog.getCep());
            stmt.setString(10, jog.getPosicao_principal());
            stmt.setString(11, jog.getPosicao_secundaria());
            stmt.setDouble(12, jog.getAltura());
            stmt.setDouble(13, jog.getPeso());
            stmt.setInt(14, idDados);
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao atualizar o jogador: " + e);
            return false;
        } finally {
            MyConnection.closeConnection(con, stmt);
        }
    }

    public boolean delete(int id) {
        con = MyConnection.getConnection();
        String sql = "delete from inscricao where idjogador=?";
        String sql2 = "delete from jogador where idDados=?";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt = con.prepareStatement(sql2);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("[ERRO] Não foi possível excluir o jogador: " + e);
            return false;
        } finally {
            MyConnection.closeConnection(con, stmt);
        }
    }
}
