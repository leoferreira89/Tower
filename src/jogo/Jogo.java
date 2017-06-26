/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo;

import Interface.Perfil;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class Jogo implements java.io.Serializable {
    ArrayList<Mapa> listaMapas;
    ArrayList<Personagem> listaPersonagens;
    ArrayList<Poderes> listaPoderes;
    ArrayList<Torre> listaTorres;
    ArrayList<Jogador> listaJogadores;
    
    public Jogo(){
        listaMapas = new ArrayList<Mapa>();
        listaPersonagens = new ArrayList<Personagem>();
        listaPoderes = new ArrayList<Poderes>();
        listaTorres = new ArrayList<Torre>();
        listaJogadores = new ArrayList<Jogador>();
        creatCharacter();
        creatPoderes();
        creatTorres();
    }
    public static void main(String[] args) throws IOException {
       Jogo dados = new Jogo();
       dados = dados.getDados("DataObject.obj");
       Perfil start = new Perfil(dados);
       start.setVisible(true);
    }
    
    public void addMapa(Mapa m){
        listaMapas.add(m);
    }
    public void addPersonagem(Personagem p){
        listaPersonagens.add(p);
    }
    public void addPoder(Poderes p){
        listaPoderes.add(p);
    }
    public void addTorres(Torre t){
        listaTorres.add(t);
    }
    public void addJogador(Jogador j){
        listaJogadores.add(j);
    }
    public void remJogador(int i){
        this.listaJogadores.remove(i);
    }
    public void remJogador2(String n){
        for(int i=0; i < listaJogadores.size(); i++){
            if(listaJogadores.get(i).getNome()== n ){
                listaJogadores.remove(i);
            }
        }
    }
//----------------||||METODOS RELACIONADOS COM LISTAJOGADOR||||---------------------//    
//------------------------------------------------------------------//
    //-----Retorna um jogador da lista, segundo a sua posiçao no array-----
    public Jogador getJogador(int i){
        return listaJogadores.get(i);
    }
    //-----retorna o arraylist listajogadores----//
    public ArrayList getListaJogador(){
        return this.listaJogadores;
    }
    
    //----Verifica se um nome já se encontra registado----
    public boolean getNomeJogador(String n){
        boolean ret = false;
        if (this.listaJogadores.isEmpty()){
            ret = false;
        }else{
         for(int i=0; i < listaJogadores.size(); i++){
            if(listaJogadores.get(i).getNome().equals(n)){
                return true;
            }
        }
        }
     return ret;   
    }
    
    public void setNomeJogador(int i, String nome){
        this.listaJogadores.get(i).setNome(nome);
    }
    
    public void setPassJogador(int i, String pass){
        this.listaJogadores.get(i).setPassword(pass);
        
    }
    public void setDinheiroJogador(int j,double d){
        this.listaJogadores.get(j).setDinheiro(this.listaJogadores.get(j).getDinheiro()-d);
    }
    
    //adicionar uma Personagem ao array de um certo jogador
    public void addPersonagemJogador(int j, int p){
        this.listaJogadores.get(j).addPersonagem(this.listaPersonagens.get(p));
    }
    
    //Devolve as personagens pertencentes a um jogador
    public ArrayList getPersonagensJogador(int j){
       return listaJogadores.get(j).getPersonagens();
    }
    
    //Devolve uma personagem
    public Personagem getPersona(int p){
        return this.listaPersonagens.get(p);
    }
    
    //// Criar personagens
    
    public void creatCharacter(){
        Personagem p1 = new Personagem(50,150,20,70,1,20,"Mago");
        Personagem p2 = new Personagem(70,100,25,120,2,25,"Elfo");
        Personagem p3 = new Personagem(100,50,100,50,3,25,"Viking");
        Personagem p4 = new Personagem(70,60,50,100,4,20,"Arqueiro");
        this.listaPersonagens.add(p1);
        this.listaPersonagens.add(p2);
        this.listaPersonagens.add(p3);
        this.listaPersonagens.add(p4);
     }
    
    //Cria Poderes
    public void creatPoderes(){
        //(|"Nome do poder" || Custo em energia ||  Valor de ação || nivel do poder || e custo em dinheiro|)
        Poderes pd1 = new Poderes("Cura",1,1.25,1,25,1); //Cura uma personagem amigavel (Vida maxima da unidade * 1.25)
        Poderes pd2 = new Poderes("Fogo",1,0.15,1,20,2); //Danifica uma personagem inimiga (Vida maxima da unidade(vmu) - vmu*0.15)
        Poderes pd3 = new Poderes("Maldição",1,0.10,1,30,3); //Danifica multiplas unidades inimigas(vmus - vmus*0.10)
        Poderes pd4 = new Poderes("Pata",1,1,1,25,4); //"Atordoar" uma personagem enimiga (afeta o relogio que o faz mover(Cria outro relogio que altera temporariamente o tempo do relogio inicial))
        this.listaPoderes.add(pd1);
        this.listaPoderes.add(pd2);
        this.listaPoderes.add(pd3);
        this.listaPoderes.add(pd4);
        
    }
    
    //Devolve os poderes pertencentes a um jogador
    public ArrayList getPoderesJogador(int j){
       return listaJogadores.get(j).getPoderes();
    }
    
    
    
    //Adiciona um Poder a um Jogador
    public void addPoderJogador(int j, int p){
        this.listaJogadores.get(j).addPoder(this.listaPoderes.get(p));
    }
    
    //Devolve um poder
    public Poderes getPoder(int p){
        return this.listaPoderes.get(p);
    }
    
    
    //Criar e adicionar Torre á listaTorres
    public void creatTorres(){
        Torre t1 = new Torre(250,"Jogador",100,1);
        Torre t2 = new Torre(300,"Jogador",100,2);
        Torre t3 = new Torre(150,"Jogador",100,3);
        this.listaTorres.add(t1);
        this.listaTorres.add(t2);
        this.listaTorres.add(t3);
    }
    
    
    //----------------||||METODOS RELACIONADOS COM LISTAPODERES||||---------------------// 
    //Devolve uma torre
    
    public Torre getTorre(int t){
        return this.listaTorres.get(t);
    }
    //Adicionar torre a um jogador
    public void addTorreJogador(int j, int p){
        this.listaJogadores.get(j).addTorre(this.listaTorres.get(p));
    }
    
    
    
    
    //----------------||||METODOS RELACIONADOS COM LISTAMAPAS||||---------------------// 
    
    public Mapa getMapa(int i){
        return listaMapas.get(i);
    }
    
    public void setMapa(String des){
        Mapa map= new Mapa(des);
        listaMapas.add(map); 
    }
    public void setMapaCoord(ArrayList m){
        listaMapas.get(listaMapas.size()-1).setCoordenadas(m);
    }
    public void setMapaListaLabels(Object[][] m){
        listaMapas.get(listaMapas.size()-1).setlistaLabels(m);
        
    }
    
    
    
    //-------------Guardar e Carregar ficheiro--------------//
    
    public void gravaObj(String fich) throws IOException {
      ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fich));
      oos.writeObject(this);
      oos.flush(); oos.close();
  }
    public Jogo getDados(String fich) throws IOException{
        Jogo con = new Jogo();
        try {
          ObjectInputStream ooin = new ObjectInputStream(new FileInputStream(fich));
           con = (Jogo) ooin.readObject();
          ooin.close();
      }
      catch(IOException e) {JOptionPane.showMessageDialog(null, "Excepion 1:  "+e);}
      catch(ClassNotFoundException ec) {JOptionPane.showMessageDialog(null, "Excepion 2:  "+ec);};
      return con;
    }
}
