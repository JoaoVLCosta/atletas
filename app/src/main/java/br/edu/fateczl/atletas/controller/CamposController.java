package br.edu.fateczl.atletas.controller;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.edu.fateczl.atletas.model.AtletaJuvenil;
import br.edu.fateczl.atletas.model.AtletaOutro;
import br.edu.fateczl.atletas.model.AtletaSenior;

public class CamposController {

    public static boolean validar(View view, EditText[] campos){
        for(EditText c : campos){
            String texto = c.getText().toString();
            if(texto == null || texto.isEmpty()){
                toaster(view, "Cadastro Inválido");
                return false;
            }
        }
        return true;
    }

    public static String ler(EditText[] campos){
        StringBuffer buffer = new StringBuffer();
        for (EditText c : campos){
            buffer.append(c.getText().toString()).append(';');
        }
        return buffer.toString();
    }

    public static void limpar(EditText[] campos){
        for (EditText c : campos){
            c.setText("");
        }
    }

    public static void toaster(View view, String bread){
        Toast.makeText(view.getContext(), bread, Toast.LENGTH_LONG).show();
    }

    public static void cadastroS(View view, boolean problemaCardiaco, EditText[] campos) {
        AtletaSenior as = new AtletaSenior(ler(campos), problemaCardiaco);
        toaster(view, as.toString());
        limpar(campos);
    }

    public static void cadastroJ(View view, EditText[] campos) {
        AtletaJuvenil aj = new AtletaJuvenil(ler(campos));
        toaster(view, aj.toString());
        limpar(campos);
    }

    public static void cadastroO(View view, EditText[] campos) {
        AtletaOutro ao = new AtletaOutro(ler(campos));
        toaster(view, ao.toString());
        limpar(campos);
    }

}
