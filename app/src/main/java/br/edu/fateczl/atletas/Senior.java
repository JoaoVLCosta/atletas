package br.edu.fateczl.atletas;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import br.edu.fateczl.atletas.controller.CamposController;
import br.edu.fateczl.atletas.model.AtletaSenior;

public class Senior extends Fragment {

    private EditText etNomeS;
    private EditText etDataS;
    private EditText etBairroS;

    private RadioButton rbSim;

    public Senior() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_senior, container, false);
        etNomeS = view.findViewById(R.id.etNomeS);
        etDataS = view.findViewById(R.id.etDataS);
        etBairroS = view.findViewById(R.id.etBairroS);

        rbSim = view.findViewById(R.id.rbSim);
        RadioButton rbNao = view.findViewById(R.id.rbNao);
        rbNao.setChecked(true);

        Button btnCadastroS = view.findViewById(R.id.btnCadastroS);
        btnCadastroS.setOnClickListener(op -> cadastro(
                view,
                etNomeS, etDataS, etBairroS));

        return view;
    }

    private void cadastro(View view, EditText... campos){
        if(CamposController.validar(view, campos)){
            CamposController.cadastroS(view, rbSim.isChecked(), campos);
        }
    }

}