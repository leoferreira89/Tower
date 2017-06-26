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
public class Personagem implements java.io.Serializable {
    int vida;
    int preco;
    int energia;
    int forca;
    double agilidade;
    int numero;
    String tipo;
    
    public Personagem(int v,int e, int f, double a,int n,int p, String t){
        this.vida = v;
        this.energia = e;
        this.forca = f;
        this.agilidade = a;
        this.numero = n;
        this.preco = p;
        this.tipo = t;
        
    }

    Personagem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int getPreco(){
        return this.preco;
    }
    public int getVida(){
        return this.vida;
    }
    public int getEnergia(){
        return this.energia;
    }
    public int getForca(){
        return this.forca;
    }
    public double getAgilidade(){
        return this.agilidade;
    }
    public int getNumero(){
        return this.numero;
    }
    
    public void setPreco(int p){
        this.preco = p;
    }
    public void setVida(int v){
        this.vida= v;
    }
    public void setEnergia(int e){
        this.energia= e;
    }
    public void setForca(int f){
        this.forca= f;
    }
    public void setAgilidade(double a){
        this.agilidade= a;
    }
    public void setNumero(int n){
        this.numero = n;
    }
    public void setTipo(String t){
        this.tipo= t;
    }
}
