package com.br.laurateodoro.meuhotel.ui.cadclientes;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.br.laurateodoro.meuhotel.R;
import com.br.laurateodoro.meuhotel.model.Cliente;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class cadCliente extends Fragment implements View.OnClickListener{

    private EditText etnome;
    private EditText etcpf;
    private EditText ettelefone;
    private CheckBox cbpcd;
    private CheckBox cbfumante;
    private Button btSalvar;
    private View root;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((AppCompatActivity)getActivity()).getSupportActionBar()
                .setDisplayShowCustomEnabled(false);
        ((AppCompatActivity) getActivity()).getSupportActionBar()
                .setDisplayHomeAsUpEnabled(false);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_cad_cliente, container, false);
        this.etnome = (EditText) root.findViewById(R.id.etnm);
        this.etcpf = (EditText) root.findViewById(R.id.etcpf);
        this.ettelefone = (EditText) root.findViewById(R.id.ettelefone);
        this.cbpcd = (CheckBox) root.findViewById(R.id.cbpcd);
        this.cbfumante = (CheckBox) root.findViewById(R.id.cbfumante);
        this.btSalvar = (Button) root.findViewById(R.id.btSalvar);
        this.btSalvar.setOnClickListener(this);
        return root;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
//verificando se é o botão salvar
            case R.id.btSalvar:
//instanciando objeto de negócio
                Cliente c = new Cliente();
//populando objeto com dados da tela
                c.setNomeHospede(this.etnome.getText().toString());
                c.setCpf(this.etcpf.getText().toString());
                c.setTelefone(this.ettelefone.getText().toString());
                if (this.cbpcd.isChecked()) {c.setPcd(1); } else {c.setPcd(0);}
                if (this.cbpcd.isChecked()) {c.setFumanteHospede(1); } else {c.setFumanteHospede(0);}
//mensagem de sucesso
                Context context =  view.getContext();
                CharSequence text = "salvo com sucesso!";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText
                        (context, text, duration);
                toast.show();
                break;
        }
    }
}