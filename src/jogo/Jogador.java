/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Jogador implements java.io.Serializable {
    int nivel, exp;
    double dinheiro;
    String nome;
    String password;
    ArrayList<Poderes> listaPoderes;
    ArrayList<Personagem> listaPersonagem;
    ArrayList<Torre> listaTorres;
    
    public Jogador(double d, String n, String p){
        this.dinheiro = d;
        this.nome = n;
        this.password = p;
        listaPoderes = new ArrayList<Poderes>();
        listaPersonagem = new ArrayList<Personagem>();
        listaTorres = new ArrayList<Torre>();
    }
    
    
    //---sets e gets---
    public void setNome(String n){
        this.nome = n;
    }
    public String getNome(){
        return this.nome;
    }
    public String getPassword(){
        return this.password;
    }
    public int getNivel(){
        return this.nivel;
    }
    public int getExp(){
        return this.exp;
    }
    public void setDinheiro(double d){
        this.dinheiro = d;
    }
    public double getDinheiro(){
        return this.dinheiro;
    }
    public void setPassword(String p){
        this.password = p;
    }
    public void setNivel(int n){
        this.nivel = n;
    }
    public void setExp(int e){
        this.exp=+ e;
    }
    
    
    
    public void addPoder(Poderes p){
        listaPoderes.add(p);
    }
    public void addPersonagem(Personagem p){
        listaPersonagem.add(p);
    }
    public void addTorre(Torre t){
        listaTorres.add(t);
    }
    
    public void remPoder(int i){
        listaPoderes.remove(i);
    }
    public void remPersonagem(int i){
        listaPersonagem.remove(i);
    }
    
    //devolve o numero das personagens pertencentes ao jogador
    public ArrayList getPersonagens(){
        ArrayList<Integer> listaindice=null;
        listaindice= new ArrayList<Integer>();
        for(int i=0; i<this.listaPersonagem.size();i++){
            listaindice.add(listaPersonagem.get(i).getNumero());
        }
        return listaindice;
    }
    
    //devolve o numero dos poderes pertencentes ao jogador
    public ArrayList getPoderes(){
        ArrayList<Integer> listaindice=null;
        listaindice= new ArrayList<Integer>();
        for(int i=0; i<this.listaPoderes.size();i++){
            listaindice.add(listaPoderes.get(i).getNumero());
        }
        return listaindice;
    }
}
