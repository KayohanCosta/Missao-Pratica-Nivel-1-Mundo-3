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

/**
 *
 * @author Cami
 */
public class PessoaFisicaRepo {
    private ArrayList<PessoaFisica> lista = new ArrayList<>();
    
    public void persistir(String nome) throws IOException{
        try(ObjectOutputStream oStream = new ObjectOutputStream(new FileOutputStream(nome))){
            System.out.println("Dados de Pessoa Fisica Armazenados.");
            oStream.writeObject(lista);
        }
    }
    
    public void recuperar(String nome) throws IOException, ClassNotFoundException{
        try(ObjectInputStream oStream = new ObjectInputStream(new FileInputStream(nome))){
            System.out.println("Dados de Pessoa Fisica Recuperados.");
            lista = (ArrayList<PessoaFisica>) oStream.readObject();
        }
    }
    
    public void inserir(PessoaFisica pessoa){
        lista.add(pessoa);
    }
    
    public void alterar(PessoaFisica pessoa){
        for (PessoaFisica p : lista) {
            if (p.getId() == pessoa.getId()) {
                p.setNome(pessoa.getNome());
                p.setCPF(pessoa.getCPF());
                p.setIdade(pessoa.getIdade());
                return;
            }
        }
    }
    
    public void excluir(int id){
        lista.removeIf(p -> p.getId() == id);
    }
    
    public PessoaFisica obter(int id){
        for(PessoaFisica p: lista){
            if(p.getId() == id){
                return p;
            }
        }
        return null;}
    
    public ArrayList<PessoaFisica> obterTodos(){
        return new ArrayList<>(lista);
    }
    
}
