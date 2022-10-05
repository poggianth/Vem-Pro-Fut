package model;

/**
 *
 * @author Th
 */


public class Jogador {
    private int idjogador;
    private String nome;
    private String data_nasc; //date
    private String sexo;
    private String telefone;
    private String email;
    private String nacionalidade;
    private String estado;
    private String cidade;
    private String cep;
    private String posicao_principal;
    private String posicao_secundaria;
    private double altura;
    private double peso;
    private int idDados;

    public Jogador() {
    }

    public Jogador(int idjogador, String nome, String data_nasc, String sexo, String telefone, String email, String nacionalidade, String estado, String cidade, String cep, String posicao_principal, String posicao_secundaria, double altura, double peso, int idDados) {
        this.idjogador = idjogador;
        this.nome = nome;
        this.data_nasc = data_nasc;
        this.sexo = sexo;
        this.telefone = telefone;
        this.email = email;
        this.nacionalidade = nacionalidade;
        this.estado = estado;
        this.cidade = cidade;
        this.cep = cep;
        this.posicao_principal = posicao_principal;
        this.posicao_secundaria = posicao_secundaria;
        this.altura = altura;
        this.peso = peso;
        this.idDados = idDados;
    }

    public int getIdjogador() {
        return idjogador;
    }

    public void setIdjogador(int idjogador) {
        this.idjogador = idjogador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(String data_nasc) {
        this.data_nasc = data_nasc;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getPosicao_principal() {
        return posicao_principal;
    }

    public void setPosicao_principal(String posicao_principal) {
        this.posicao_principal = posicao_principal;
    }

    public String getPosicao_secundaria() {
        return posicao_secundaria;
    }

    public void setPosicao_secundaria(String posicao_secundaria) {
        this.posicao_secundaria = posicao_secundaria;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getIdDados() {
        return idDados;
    }

    public void setIdDados(int idDados) {
        this.idDados = idDados;
    }
}