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
public class Poderes implements java.io.Serializable {
    String nome;
    double energia;
    double forca;
    int nivel;
    double preco;
    int numero;
    
    
  public Poderes(String no, double e, double f, int ni, double p, int n){
      this.nome = no;
      this.energia = e;
      this.forca = f;
      this.nivel = ni;
      this.preco = p;
      this.numero = n;
  }
  
  public String getNome(){
      return this.nome;
  }
  public double getEnergia(){
      return this.energia;
  }
  public double getForca(){
      return this.forca;
  }
  public int getNivel(){
      return this.nivel;
  }
  public double getPreco(){
      return this.preco;
  }
  public int getNumero(){
      return this.numero;
  }
  
  
  public void setNome(String no){
      this.nome = no;
  }
  public void setEneria(double e){
      this.energia = e;
  }
  public void setForca(double f){
      this.forca = f;
  }
  public void setNivel(int ni){
      this.nivel = ni;
  }
  public void setPreco(double p){
      this.preco = p;
  }
  public void setNumero(int n){
      this.numero = n;
  }
  
  
  
}
