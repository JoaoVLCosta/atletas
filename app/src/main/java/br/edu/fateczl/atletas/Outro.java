package br.edu.fateczl.atletas;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import br.edu.fateczl.atletas.controller.CamposController;

public class Outro extends Fragment {

    private EditText etNomeO;
    private EditText etDataO;
    private EditText etBairroO;

    private EditText etAcademia;
    private EditText etRecorde;

    public Outro() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_outro, container, false);
        etNomeO = view.findViewById(R.id.etNomeO);
        etDataO = view.findViewById(R.id.etDataO);
        etBairroO = view.findViewById(R.id.etBairroO);

        etAcademia = view.findViewById(R.id.etAcademia);
        etRecorde = view.findViewById(R.id.etRecorde);

        Button btnCadastroO = view.findViewById(R.id.btnCadastroO);
        btnCadastroO.setOnClickListener(op -> cadastro(
                view,
                etNomeO, etDataO, etBairroO, etAcademia, etRecorde));

        return view;
    }

    private void cadastro(View view, EditText... campos){
        if(CamposController.validar(view, campos)){
            CamposController.cadastroO(view, campos);
        }
    }

}