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
public class PessoaFisica extends Pessoa implements Serializable{
    private String cpf;
    private int idade;
    
    public PessoaFisica(int id, String nome, String cpf, int idade) {
        super(id, nome);
        this.cpf = cpf;
        this.idade = idade;
    }
    
    @Override
    public void exibir(){
        System.out.println("Id: " + this.getId() + "\nNome: "+ this.getNome() + "\nCPF: " + this.getCPF() + "\nIdade:" + this.getIdade());
    }
    
    protected void setCPF(String cpf){
        this.cpf = cpf;
    }
    
    protected String getCPF(){
        return this.cpf;
    }
    
    protected void setIdade(int idade){
        this.idade = idade;
    }
    
    protected int getIdade(){
        return this.idade;
    }
}
