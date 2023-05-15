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

import com.br.laurateodoro.meuhotel.R;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class cadCliente extends Fragment {

    private EditText etnome;
    private EditText etcpf;
    private EditText ettelefone;
    private CheckBox cbpcd;
    private CheckBox cbfumante;
    private Button btSalvar;

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
        return inflater.inflate(R.layout.fragment_cad_cliente, container, false);
    }
}