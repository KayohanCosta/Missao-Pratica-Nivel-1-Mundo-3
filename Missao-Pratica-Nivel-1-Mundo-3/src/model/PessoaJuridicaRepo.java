/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Optional;

/**
 *
 * @author Cami
 */
public class PessoaJuridicaRepo {
    private ArrayList<PessoaJuridica> lista = new ArrayList<>();
    
    public void persistir(String nome) throws IOException{
        try(ObjectOutputStream oStream = new ObjectOutputStream(new FileOutputStream(nome))){
            System.out.println("Dados de Pessoa Juridica Armazenados.");
            oStream.writeObject(lista);
        }
    }
    
    public void recuperar(String nome) throws IOException, ClassNotFoundException{
        try(ObjectInputStream oStream = new ObjectInputStream(new FileInputStream(nome))){
            System.out.println("Dados de Pessoa Juridica Recuperados.");
            lista = (ArrayList<PessoaJuridica>) oStream.readObject();
        }
    }
    
    public void inserir(PessoaJuridica pessoa){
        lista.add(pessoa);
    }
    
    public void alterar(PessoaJuridica pessoa){
        for (PessoaJuridica p : lista) {
            if (p.getId() == pessoa.getId()) {
                p.setNome(pessoa.getNome());
                p.setCNPJ(pessoa.getCNPJ());
                return;
            }
        }
    }
    
    public void excluir(int id){
        lista.removeIf(p -> p.getId() == id);   
    }
    
    public PessoaJuridica obter(int id){
        for(PessoaJuridica p: lista){
            if(p.getId() == id){
                return p;
            }
        }
        return null;
    }
    
    public ArrayList<PessoaJuridica> obterTodos(){
        return new ArrayList<>(lista);
    }
    
    public void main(String[] args){
        System.out.println(obter(25));
    }
    
}
