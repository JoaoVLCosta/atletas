package br.edu.fateczl.atletas;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import br.edu.fateczl.atletas.controller.CamposController;

public class Juvenil extends Fragment {

    private EditText etNomeJ;
    private EditText etDataJ;
    private EditText etBairroJ;

    private EditText etAnos;

    public Juvenil() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_juvenil, container, false);
        etNomeJ = view.findViewById(R.id.etNomeJ);
        etDataJ = view.findViewById(R.id.etDataJ);
        etBairroJ = view.findViewById(R.id.etBairroJ);

        etAnos = view.findViewById(R.id.etAnos);

        Button btnCadastroJ = view.findViewById(R.id.btnCadastroJ);
        btnCadastroJ.setOnClickListener(op -> cadastro(
                view,
                etNomeJ, etDataJ, etBairroJ, etAnos));

        return view;
    }

    private void cadastro(View view, EditText... campos){
        if(CamposController.validar(view, campos)){
            CamposController.cadastroJ(view, campos);
        }
    }

}