/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class Mapa implements java.io.Serializable {
    String descricao;
    Object[][] listaLabels;
    ArrayList<int[]> coordenadas;
    
    public Mapa(String des){
        this.descricao = des;
        listaLabels = new Object[15][14];
        coordenadas = new ArrayList<int[]>();
    }
    
    public String getDescricao(){
        return this.descricao;
    }
    
    public void setDescricao(String desc){
        this.descricao = desc;
    }
    
    public void setCoordenadas(ArrayList m){
        coordenadas = m;
    }
    public ArrayList getCoordenadas(){
        return this.coordenadas;
    }
    
    
    public void setlistaLabels(Object[][] m){
        listaLabels = m;
    }
    
    public Object[][] getListaLabels(){
        return this.listaLabels;
    }
    
}
