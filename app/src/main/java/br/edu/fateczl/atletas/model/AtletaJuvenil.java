package br.edu.fateczl.atletas.model;

public class AtletaJuvenil extends Atleta{

    private int anos;

    public AtletaJuvenil(String dados) {
        super(dados);
        this.anos = Integer.parseInt(dados.split(";")[3]);
    }

    @Override
    public String toString() {
        return super.toString() + ", " + getAnos();
    }

    public int getAnos() {
        return anos;
    }

    public void setAnos(int anos) {
        this.anos = anos;
    }
}
