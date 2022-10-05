package model;

/**
 *
 * @author Th
 */
public class Usuario {
    private int idUsuario;
    private String email;
    private String senha;
    private String tipo;
    private int idDados;
    
    public Usuario() {
    }

    public Usuario(int idUsuario, String email, String senha, String tipo, int idDados) {
        this.idUsuario = idUsuario;
        this.email = email;
        this.senha = senha;
        this.tipo = tipo;
        this.idDados = idDados;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getIdDados() {
        return idDados;
    }

    public void setIdDados(int idDados) {
        this.idDados = idDados;
    }
}
