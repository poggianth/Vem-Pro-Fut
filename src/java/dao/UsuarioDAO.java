package dao;

import connection.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import model.Usuario;

/**
 *
 * @author Th
 */
public class UsuarioDAO {

    private Connection con = null;

    public Usuario verificar(Usuario user) {
        con = MyConnection.getConnection();

        String sql = "select * from usuario where email=? and senha=?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usu = new Usuario();

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, user.getEmail());
            stmt.setString(2, user.getSenha());
            rs = stmt.executeQuery();

            while (rs.next()) {
                usu.setIdUsuario(rs.getInt("idUsuario"));
                usu.setEmail(rs.getString("email"));
                usu.setSenha(rs.getString("senha"));
                usu.setTipo(rs.getString("tipo"));
                usu.setIdDados(rs.getInt("idDados"));
            }
        } catch (Exception e) {
            System.out.println("Erro ao validar usuário: " + e);
        } finally {
            MyConnection.closeConnection(con, stmt, rs);
        }
        return usu;
    }

    public boolean validarSenha(Usuario usu) {
        con = MyConnection.getConnection();
        boolean resp = false;

        String sql = "select * from usuario where idusuario=?";
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, usu.getIdUsuario());
            rs = stmt.executeQuery();

            while (rs.next()) {
                String senha = rs.getString("senha");
                System.out.println(senha);
                if (senha.equals(usu.getSenha())) {
                    resp = true;
                }
            }
        } catch (Exception e) {
            System.out.println("Senha errada");
            resp = false;
        }
        return resp;
    }

    // Verifica se o email já está cadastrado, caso exista, retornará verdadeiro.
    public boolean jaExiste(String email) {
        con = MyConnection.getConnection();
        boolean resp = false;

        String sql = "select * from usuario where email=?";
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, email);
            rs = stmt.executeQuery();

            while (rs.next()) {
                System.out.println("Email já cadastrado no sistema!");
                resp = true;
            }
        } catch (Exception e) {
            System.out.println("Email não cadastrado no sistema!");
            resp = false;
        }
        return resp;
    }

    public boolean alterarSenha(String senha, String email) {
        con = MyConnection.getConnection();
        String sql = "update usuario set senha=? where email=?";

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, senha);
            stmt.setString(2, email);
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao atualizar senha do Usuário: " + e);
            return false;
        } finally {
            MyConnection.closeConnection(con, stmt);
        }
    }

    public Usuario selecionarUsu(int id) {
        con = MyConnection.getConnection();

        String sql = "select * from usuario where idusuario=?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usu = new Usuario();

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                usu.setEmail(rs.getString("email"));
                usu.setSenha(rs.getString("senha"));
                usu.setTipo(rs.getString("tipo"));
                usu.setIdDados(rs.getInt("idDados"));
            }
        } catch (Exception e) {
            System.out.println("[OPS] Erro ao selecionar usuário: " + e);
        } finally {
            MyConnection.closeConnection(con, stmt, rs);
        }
        return usu;
    }

    public boolean create(Usuario user) {
        con = MyConnection.getConnection();
        String sql = "insert into usuario(email, senha, tipo, idDados) values(?,?,?,?)";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, user.getEmail());
            stmt.setString(2, user.getSenha());
            stmt.setString(3, user.getTipo());
            stmt.setInt(4, user.getIdDados());
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao criar Usuário: " + e);
            return false;
        } finally {
            MyConnection.closeConnection(con, stmt);
        }
    }

    public boolean delete(int id, String tipo) {
        con = MyConnection.getConnection();
        // adicionar condicional do tipo
        String sql = "delete from usuario where idDados=? and tipo=?";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.setString(2, tipo);
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao excluir Usuário: " + e);
            return false;
        } finally {
            MyConnection.closeConnection(con, stmt);
        }
    }

    public boolean update(Usuario usu) {
        con = MyConnection.getConnection();

        String sql = "update usuario set email=?, senha=? where idusuario=?";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, usu.getEmail());
            stmt.setString(2, usu.getSenha());
            stmt.setInt(3, usu.getIdUsuario());
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao atualizar Usuário: " + e);
            return false;
        } finally {
            MyConnection.closeConnection(con, stmt);
        }
    }
}
