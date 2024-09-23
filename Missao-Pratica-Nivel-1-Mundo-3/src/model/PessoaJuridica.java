/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Cami
 */
public class PessoaJuridica extends Pessoa implements Serializable {
    
    private String cnpj;
    
    public PessoaJuridica(int id, String nome, String cnpj) {
        super(id, nome);
        this.cnpj = cnpj;
    }
    
    @Override
    public void exibir(){
        System.out.println("Id: " + this.getId() + "\nNome: "+ this.getNome() + "\nCNPJ: " + this.getCNPJ());
    }
    
    protected void setCNPJ(String cnpj){
        this.cnpj = cnpj;
    }
    
    protected String getCNPJ(){
        return this.cnpj;
    }
    
}
