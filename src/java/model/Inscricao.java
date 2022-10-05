package model;

/**
 *
 * @author Th
 */
public class Inscricao {
    private int idinscricao;
    private int idvaga;
    private int idjogador;
    private String data_inscricao; //Converter em date
    private String status;

    public Inscricao() {
    }

    public Inscricao(int idinscricao, int idvaga, int idjogador, String data_inscricao, String status) {
        this.idinscricao = idinscricao;
        this.idvaga = idvaga;
        this.idjogador = idjogador;
        this.data_inscricao = data_inscricao;
        this.status = status;
    }

    public int getIdinscricao() {
        return idinscricao;
    }

    public void setIdinscricao(int idinscricao) {
        this.idinscricao = idinscricao;
    }

    public int getIdvaga() {
        return idvaga;
    }

    public void setIdvaga(int idvaga) {
        this.idvaga = idvaga;
    }

    public int getIdjogador() {
        return idjogador;
    }

    public void setIdjogador(int idjogador) {
        this.idjogador = idjogador;
    }

    public String getData_inscricao() {
        return data_inscricao;
    }

    public void setData_inscricao(String data_inscricao) {
        this.data_inscricao = data_inscricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
     
}
