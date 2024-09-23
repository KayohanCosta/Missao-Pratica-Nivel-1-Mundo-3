/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cadastropoo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import model.PessoaFisica;
import model.PessoaFisicaRepo;
import model.PessoaJuridica;
import model.PessoaJuridicaRepo;

/**
 *
 * @author Cami
 */
public class CadastroPOO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        
        Scanner in = new Scanner(System.in);
        PessoaFisicaRepo repoPFisica = new PessoaFisicaRepo();
        PessoaJuridicaRepo repoPJuridica = new PessoaJuridicaRepo();
        
        do{
        System.out.println("============================");
        System.out.println("1 - Incluir Pessoa");
        System.out.println("2 - Alterar Pessoa");
        System.out.println("3 - Excluir Pessoa");
        System.out.println("4 - Buscar pelo Id");
        System.out.println("5 - Exibir Todos");
        System.out.println("6 - Persistir Dados");
        System.out.println("7 - Recuperar Dados");
        System.out.println("0 - Finalizar Programa");
        System.out.println("============================");
        
        int input = in.nextInt();
        
        switch(input){
            case(1):
                System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                String pessoaTipoI = in.next();
                if(pessoaTipoI.equals("F")){
                    System.out.println("Insira os dados...");
                    
                    System.out.print("Nome: ");
                    String nome = in.next();
                    
                    System.out.print("CPF: ");
                    String cpf = in.next();
                    
                    System.out.print("Idade: ");
                    int idade = in.nextInt();
                    
                    int id = repoPFisica.obterTodos().size() + 1;
                    
                    PessoaFisica pessoaFNova = new PessoaFisica(id, nome, cpf, idade);
                    repoPFisica.inserir(pessoaFNova);
                    
                    System.out.println("Dados adicionados com sucesso.");
                }
                else if(pessoaTipoI.equals("J")){
                    System.out.println("Insira os dados...");
                    
                    System.out.print("Nome: ");
                    String nome = in.next();
                    
                    System.out.print("CNPJ: ");
                    String cnpj = in.next();
                    
                    int id = repoPJuridica.obterTodos().size() + 1;
                    
                    PessoaJuridica pessoaJNova = new PessoaJuridica(id,nome, cnpj);
                    repoPJuridica.inserir(pessoaJNova);
                    System.out.println("Dados adicionados com sucesso.");
                }
                break;
                
            case(2):
                System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                String pessoaTipoA = in.next();
                if(pessoaTipoA.equals("F")){
                    System.out.print("Insira um id: ");
                    int id = in.nextInt();
                    try{
                        PessoaFisica pessoaAlterar = repoPFisica.obter(id);
                        pessoaAlterar.exibir();

                        System.out.println("Insira os dados...");

                        System.out.print("Novo Nome: ");
                        String nome = in.next();

                        System.out.print("Novo CPF: ");
                        String cpf = in.next();

                        System.out.print("Nova Idade: ");
                        int idade = in.nextInt();

                        PessoaFisica pessoaFNova = new PessoaFisica(id, nome, cpf, idade);
                        repoPFisica.alterar(pessoaFNova);
                        pessoaAlterar.exibir();
                        System.out.print("Dados alterados com sucesso.");
                    }catch(Throwable e){
                        System.out.println("Erro ao obter dados: " + e.getMessage());
                        e.printStackTrace();
                    }
                    }
                else if(pessoaTipoA.equals("J")){
                    
                    System.out.print("Insira um id: ");
                    int id = in.nextInt();
                    try{
                    PessoaJuridica pessoaAlterar = repoPJuridica.obter(id);
                    pessoaAlterar.exibir();
                    
                    System.out.println("Insira os dados...");
                    
                    System.out.print("Novo Nome: ");
                    String nome = in.next();
                    
                    System.out.print("Novo CNPJ: ");
                    String cnpj = in.next();
                    
                    PessoaJuridica pessoaJNova = new PessoaJuridica(id,nome, cnpj);
                    repoPJuridica.alterar(pessoaJNova);
                    pessoaAlterar.exibir();
                    System.out.print("Dados alterados com sucesso.");
                    }catch(Throwable e){
                        System.out.println("Erro ao obter dados: " + e.getMessage());
                        e.printStackTrace();
                    }
                }
                break;
            case(3):
                System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                String pessoaTipoE = in.next();
                if(pessoaTipoE.equals("F")){
                    System.out.print("Insira um id: ");
                    int id = in.nextInt();
                    try{
                    repoPFisica.excluir(id);
                    System.out.println("Dados removidos.");
                    }catch(Throwable e){
                        System.out.println("Erro ao excluir dados: " + e.getMessage());
                        e.printStackTrace();
                    }
                }
                else if(pessoaTipoE.equals("J")){
                    System.out.print("Insira um id: ");
                    int id = in.nextInt();
                    try{
                    repoPJuridica.excluir(id);
                    System.out.println("Dados removidos.");
                    }catch(Throwable e){
                        System.out.println("Erro ao excluir dados: " + e.getMessage());
                        e.printStackTrace();
                    }
                }
                break;
                
            case(4):
                System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                String pessoaTipoO = in.next();
                if(pessoaTipoO.equals("F")){
                    System.out.print("Insira um id: ");
                    int id = in.nextInt();
                    
                    try{
                    PessoaFisica pessoaObtida = repoPFisica.obter(id);
                    pessoaObtida.exibir();
                    }catch(Throwable e){
                        System.out.println("Erro ao obter dados: " + e.getMessage());
                        e.printStackTrace();
                    }
                }
                else if(pessoaTipoO.equals("J")){
                    System.out.print("Insira um id: ");
                    int id = in.nextInt();
                    
                    try{
                        PessoaJuridica pessoaObtida = repoPJuridica.obter(id);
                        pessoaObtida.exibir();
                    }catch(Throwable e){
                        System.out.println("Erro ao obter dados: " + e.getMessage());
                        e.printStackTrace();
                    }
                }
                break;
                
            case(5):
                System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                String pessoaTipoOT = in.next();
                if(pessoaTipoOT.equals("F")){
                    ArrayList<PessoaFisica> pessoaObtida = repoPFisica.obterTodos();
                    for(PessoaFisica p: pessoaObtida){
                        p.exibir();
                    }
                }
                else if(pessoaTipoOT.equals("J")){
                    ArrayList<PessoaJuridica> pessoaObtida = repoPJuridica.obterTodos();
                    for(PessoaJuridica p: pessoaObtida){
                        p.exibir();
                    }
                }
                break;
                
            case(6):
                System.out.print("Insira um prefixo para salvar o arquivo: ");
                String arquivoNomeS = in.next();
                try{
                    repoPFisica.persistir(arquivoNomeS + ".fisica.bin");
                    repoPJuridica.persistir(arquivoNomeS + ".juridica.bin");
                    System.out.println("Dados salvos com sucesso.");
                }catch(IOException e){
                    System.out.println("Erro ao salvar dados: " + e.getMessage());
                    e.printStackTrace();
                }
                break;
                
            case(7):
                System.out.print("Insira um prefixo para recuperar o arquivo: ");               
                String arquivoNomeR = in.next();
                try{
                    repoPFisica.recuperar(arquivoNomeR + ".fisica.bin");
                    repoPJuridica.recuperar(arquivoNomeR + ".juridica.bin");
                    System.out.println("Dados recuperados com sucesso.");
                }catch(IOException | ClassNotFoundException e){
                    System.out.println("Erro ao recuperar dados: " + e.getMessage());
                    e.printStackTrace();
                }
                break;
                
            case(0):
                System.out.println("Finalizando a execução...");
                in.close();
                return;
                
            default:
                System.out.println("Escolha uma opção entre 0 a 7.");
                break;
        }
        }while(true);
        
    }
  
}
