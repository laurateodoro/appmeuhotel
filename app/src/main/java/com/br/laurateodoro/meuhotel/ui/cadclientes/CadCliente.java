package com.br.laurateodoro.meuhotel.ui.cadclientes;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.br.laurateodoro.meuhotel.R;
import com.br.laurateodoro.meuhotel.model.Cliente;
import com.google.android.material.snackbar.Snackbar;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class CadCliente extends Fragment implements View.OnClickListener, Response.ErrorListener,
        Response.Listener {


    private EditText etnome;
    private EditText etcpf;
    private EditText ettelefone;
    private CheckBox cbpcd;
    private CheckBox cbfumante;
    private Button btSalvar;

    //volley
    private RequestQueue requestQueue;
    private JsonObjectRequest jsonObjectReq;
    private View root;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((AppCompatActivity) getActivity()).getSupportActionBar()
                .setDisplayShowCustomEnabled(false);
        ((AppCompatActivity) getActivity()).getSupportActionBar()
                .setDisplayHomeAsUpEnabled(false);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.root = inflater.inflate(R.layout.fragment_cad_cliente, container, false);
        this.etnome = (EditText) root.findViewById(R.id.etnm);
        this.etcpf = (EditText) root.findViewById(R.id.etcpf);
        this.ettelefone = (EditText) root.findViewById(R.id.ettelefone);
        this.cbpcd = (CheckBox) root.findViewById(R.id.cbpcd);
        this.cbfumante = (CheckBox) root.findViewById(R.id.cbfumante);
        this.btSalvar = (Button) root.findViewById(R.id.btSalvar);
        this.btSalvar.setOnClickListener(this);

        //instanciando a fila de requests - caso o objeto seja o root

        this.requestQueue = Volley.newRequestQueue(root.getContext());

        //inicializando a fila de requests do SO
        this.requestQueue.start();
        return this.root;
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
                if (this.cbpcd.isChecked()) {
                    c.setPcd("s");
                } else {
                    c.setPcd("n");
                }
                if (this.cbpcd.isChecked()) {
                    c.setFumanteHospede("s");
                } else {
                    c.setFumanteHospede("n");
                }
                /*
//mensagem de sucesso
                Context context = view.getContext();
                CharSequence text = "salvo com sucesso!";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText
                        (context, text, duration);
                toast.show();
*/
                jsonObjectReq = new JsonObjectRequest(
                        Request.Method.POST,
                        "http://10.0.2.2/cadcliente.php",
                        c.toJsonObject(), this, this);
                requestQueue.add(jsonObjectReq);
                break;
        }
    }


    @Override
    public void onErrorResponse(VolleyError error) {
        Snackbar mensagem = Snackbar.make(root,
                "Ops! Houve um problema ao realizar o cadastro: " +
                        error.toString(), Snackbar.LENGTH_LONG);
        mensagem.show();
    }


    @Override
    public void onResponse(Object response) {
        String resposta = response.toString();
        try {
            if (resposta.equals("500")) {
                Snackbar mensagem = Snackbar.make(root,
                        "Erro! = " + resposta,
                        Snackbar.LENGTH_LONG);
                mensagem.show();
            } else {
                //sucesso
                // limpar campos da tela
                this.etnome.setText("");
                this.etcpf.setText("");
                this.ettelefone.setText("");
                this.cbpcd.setText("");
                this.cbfumante.setText("");
                //mensagem de sucesso
                Snackbar mensagem = Snackbar.make(root,
                        "Sucesso! = " + resposta,
                        Snackbar.LENGTH_LONG);
                mensagem.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
