package br.edu.fateczl.atletas.model;

public class AtletaOutro extends Atleta{

    private String academia;
    private int recorde;

    public AtletaOutro(String dados) {
        super(dados);
        this.academia = dados.split(";")[3];
        this.recorde = Integer.parseInt(dados.split(";")[4]);
    }

    @Override
    public String toString() {
        return super.toString() + ", "
                + getAcademia() + ", "
                + getRecorde();
    }

    public String getAcademia() {
        return academia;
    }

    public void setAcademia(String academia) {
        this.academia = academia;
    }

    public int getRecorde() {
        return recorde;
    }

    public void setRecorde(int recorde) {
        this.recorde = recorde;
    }
}
