/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo;

/**
 *
 * @author user
 */
public class Torre implements java.io.Serializable {
    int vida,numero;
    String equipa;
    double preco;
    
   
    public Torre(int v, String eq, double p, int n){
        this.vida = v;
        this.equipa = eq;
        this.preco = p;
        this.numero = n;
    }
    
    public int getVida(){
        return this.vida;
    }
    public String getEquipa(){
        return this.equipa;
    }
    public double getPreco(){
        return this.preco;
    }
    public int getNumero(){
        return this.numero;
    }
    
    public void setVida(int v){
        this.vida = v;
    }
    public void setEquipa(String e){
        this.equipa = e;
    }
    public void setPreco(double p){
        this.preco = p;
    }
    public void setNumero(int n){
        this.numero = n;
    }
}
