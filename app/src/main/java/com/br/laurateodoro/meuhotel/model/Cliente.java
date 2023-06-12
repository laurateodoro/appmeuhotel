package com.br.laurateodoro.meuhotel.model;

import org.json.JSONException;
import org.json.JSONObject;

public class Cliente {
    //atributos pessoa
    private String nome;
    private String cpf;
    private String telefone;
    private String pcd;
    private String fumante;

    public Cliente (JSONObject jp) {
        try {
            this.setNomeHospede((String) jp.get("nomecliente"));
            this.setCpf((String) jp.get("cpfcliente"));
            this.setTelefone((String) jp.get("telefonecliente"));
            this.setPcd((String) jp.get("pcdcliente"));
            this.setFumanteHospede((String) jp.get("fumantecliente"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public Cliente() {

        this.nome = "";
        this.cpf = "000.000.000-00";
        this.telefone = "+00";
        this.fumante = "n";
        this.pcd = "n";
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


    public String getPcd ()
    {
        return this.pcd;
    }

    public boolean setPcd (String pcd)
    {
        boolean valido = false;
        if (pcd == "s" || pcd == "n")
        {
            this.pcd = pcd;
            valido = true;
        }
        else
        {
            this.pcd = "n";
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
            this.cpf = "xxx.xxx.xxx-xx";
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
            this.telefone = "(00)00000-0000";
        }
        return valido;
    }


    public String getFumanteHospede ()
    {
        return this.fumante;
    }

    public boolean setFumanteHospede (String fumante)
    {
        boolean valido = false;
        if (fumante == "n" || fumante == "s")
        {
            this.fumante = fumante;
            valido = true;
        }
        else
        {
            this.fumante = "n";
        }

        return valido;
    }


}