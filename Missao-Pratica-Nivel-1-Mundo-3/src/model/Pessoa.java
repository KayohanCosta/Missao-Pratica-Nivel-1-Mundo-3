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
public class Pessoa implements Serializable {
    private int id;
    private String nome;
    
    public Pessoa(int id, String nome){
        this.id = id;
        this.nome = nome;
    }
    
    protected void exibir(){
        System.out.println("Id: " + this.getId() + "\nNome: "+ this.getNome());
    }
    
    protected void setId(int id){
        this.id = id;
    }
    
    protected int getId(){
        return this.id;
    }
    
    protected void setNome(String nome){
        this.nome = nome;
    }
    
    protected String getNome(){
        return this.nome;
    }
    
}
