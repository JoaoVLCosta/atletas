package br.edu.fateczl.atletas.model;

import androidx.annotation.NonNull;

public class AtletaSenior extends Atleta {

    private boolean cardiaco;

    public AtletaSenior(String dados, boolean cardiaco) {
        super(dados);
        this.cardiaco = cardiaco;
    }

    @NonNull
    @Override
    public String toString(){
        String saude = saude = "Não tem problemas cardiacos";;
        if(isCardiaco()){
            saude = "Tem problemas cardiacos";
        }
        return super.toString() + "\nsaude: " + saude;
    }

    public boolean isCardiaco() {
        return cardiaco;
    }

    public void setCardiaco(boolean cardiaco) {
        this.cardiaco = cardiaco;
    }
}
