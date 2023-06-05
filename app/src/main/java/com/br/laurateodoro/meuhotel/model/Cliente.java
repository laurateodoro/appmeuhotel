package com.br.laurateodoro.meuhotel.model;

import org.json.JSONException;
import org.json.JSONObject;

public class Cliente {
    //atributos pessoa
    private String nome;
    private String cpf;
    private String telefone;
    private int pcd;
    private int fumante;

    public Cliente (JSONObject jp) {
        try {
            this.setNomeHospede((String) jp.get("nomecliente"));
            this.setCpf((String) jp.get("cpfcliente"));
            this.setTelefone((String) jp.get("telefonecliente"));
            this.setPcd((int) jp.get("pcdcliente"));
            this.setFumanteHospede((int) jp.get("fumantecliente"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public Cliente() {

        this.nome = "";
        this.cpf = "000.000.000-00";
        this.telefone = "+00";
        this.fumante = 0;
        this.pcd = 0;
    }

    public JSONObject toJsonObject() {
        JSONObject json = new JSONObject();
        try {
            json.put("nomecliente", this.nome);
            json.put("cpfcliente", this.cpf);
            json.put("telefonecliente", this.telefone);
            json.put("pcdcliente", this.pcd);
            json.put("fumantecliente", this.fumante);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json;
    }


    public int getPcd ()
    {
        return this.pcd;
    }

    public boolean setPcd (int pcd)
    {
        boolean valido = false;
        if (pcd == 0 || pcd == 1)
        {
            this.pcd = pcd;
            valido = true;
        }
        else
        {
            this.pcd = 0;
        }

        return valido;
    }

    public String getNomeHospede ()
    {
        return this.nome;
    }

    public boolean setNomeHospede (String nome)
    {
        boolean valido = false;
        if (nome.matches("^[a-zA-Z\\s]*$") && (nome.length() >= 5))
        {
            this.nome = nome;
            valido = true;
        }
        else
        {
            this.nome = "Anônimo";
        }
        return valido;
    }


    public String getCpf ()
    {
        return this.cpf;
    }

    public boolean setCpf (String cpf)
    {
        boolean valido = false;
        if (cpf.length() == 11)
        {
            this.cpf = cpf;
            valido = true;
        }
        else
        {
            this.cpf = "Anônimo";
        }
        return valido;
    }


    public String getTelefone ()
    {
        return this.telefone;
    }

    public boolean setTelefone (String telefone)
    {
        boolean valido = false;
        if (telefone.length() >= 11 && telefone.length() <= 20)
        {
            if (telefone.length() == 11) {
                this.telefone = "+55" + telefone;
            } else {
                this.telefone = telefone;
            }
            valido = true;
        }
        else
        {
            this.telefone = "Anônimo";
        }
        return valido;
    }


    public int getFumanteHospede ()
    {
        return this.fumante;
    }

    public boolean setFumanteHospede (int fumante)
    {
        boolean valido = false;
        if (fumante == 0 || fumante == 1)
        {
            this.fumante = fumante;
            valido = true;
        }
        else
        {
            this.fumante = -1;
        }

        return valido;
    }


}