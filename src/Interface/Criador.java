/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import jogo.Jogo;

/**
 *
 * @author user
 */
public class Criador extends javax.swing.JFrame {
    Jogo dados;
    int spl;
    int text=4;
    String path;
   Object[][] matrizLabel;
   int[][] matriz;
   int[] linha;
   int[] puc;
   ArrayList<int[]> coluna;
   
    /**
     * Creates new form Criador
     */
    public Criador(Jogo jog, int pl) {
        initComponents();
        dados = jog;
        spl = pl;
      linha = new int[2];    
      puc = new int[2]; //Posição(na matriz) do ultimo caminho criado
      coluna = new ArrayList<int[]>(); 
      matriz = new int[15][14];
      matrizLabel = new Object[15][14];
     path = getTexturas(text);
     
      for(int i=0; i<15;i++){
          for(int j=0; j<14;j++){
            matriz[i][j]=0;
            jLabel1 = new javax.swing.JLabel();
            jLabel1.setBounds(i*50,j*50,50,50);
            jLabel1.setIcon(new javax.swing.ImageIcon(path));
            matrizLabel[i][j]=jLabel1;
            add(jLabel1);
          }
    }
      
        jLabel1 = new javax.swing.JLabel();
         jLabel1.setBounds(0,0,761,740);
         add(jLabel1);
         jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void  mouseClicked(java.awt.event.MouseEvent evt) {
                int indice[]= new int[2];
                indice = CheckLabelPosition(evt.getX(),evt.getY());
                if (text == 1){
                    if((indice[0]>0 && indice[1]>0) && (indice[0]<14 & indice[1]<13)){
                        JOptionPane.showMessageDialog(null,"Tem que ser nos cantos");
                    }else{
                        checkStartPoint();
                        puc[0] = indice[0];
                        puc[1] = indice[1];
                        jLabel2 = (JLabel) matrizLabel[indice[0]][indice[1]];
                        jLabel2.setIcon(new javax.swing.ImageIcon(getTexturas(text)));
                         matriz[indice[0]][indice[1]] = text;
                        setMatrizNormal();
                        jLabel4.setEnabled(true);
                    }
                          
              }else{ if(text == 3){
                  
                   if((indice[0]>0 && indice[1]>0) && (indice[0]<14 & indice[1]<13)){
                        JOptionPane.showMessageDialog(null,"Tem que ser nos cantos");
                        }else{
                            checkFinishPoint();
                            puc[0] = indice[0];
                            puc[1] = indice[1];
                            jLabel2 = (JLabel) matrizLabel[indice[0]][indice[1]];
                            jLabel2.setIcon(new javax.swing.ImageIcon(getTexturas(text)));
                             matriz[indice[0]][indice[1]] = text;
                           setMatrizNormal();
                        }
                    }else{if(text==2){
                            setMatrizNormal();
                            puc[0] = indice[0];
                            puc[1] = indice[1];
                            setTrail();
                         }else{
                            setMatrizNormal();
                            JLabel jLabel2 = new javax.swing.JLabel();
                            jLabel2 = (JLabel) matrizLabel[indice[0]][indice[1]];
                            jLabel2.setIcon(new javax.swing.ImageIcon(getTexturas(text)));
                            matrizLabel[indice[0]][indice[1]]=jLabel2;
                            if(text>4 && text<19){
                               matriz[indice[0]][indice[1]] = -1;
                            }
                                matriz[indice[0]][indice[1]] = text;
                        }
                    }
                }
            }
         });
    }
    // Verifica se o ponto de entrada já foi criado e remove-o
    private void checkStartPoint(){
        int res[]= new int[2];
        for(int i=0;i<15;i++){
            for(int j=0;j<14;j++){
                if(matriz[i][j]==text){
                    res[0]=i;
                    res[1]=j;
                }
            }
        }
        if(res==null){}else{
            matriz[res[0]][res[1]]=0;
            jLabel2 = (JLabel) matrizLabel[res[0]][res[1]];
            jLabel2.setIcon(new javax.swing.ImageIcon(getTexturas(50)));
            matrizLabel[res[0]][res[1]]= jLabel2;
        }
    }
    
    // Verifica se o ponto de saída já foi criado e remove-o
     private void checkFinishPoint(){
        int res[]= new int[2];
        for(int i=0;i<15;i++){
            for(int j=0;j<14;j++){
                if(matriz[i][j]==text){
                    res[0]=i;
                    res[1]=j;
                }
            }
        }
        if(res==null){}else{
            matriz[res[0]][res[1]]=0;
            jLabel2 = (JLabel) matrizLabel[res[0]][res[1]];
            jLabel2.setIcon(new javax.swing.ImageIcon(getTexturas(50)));
            matrizLabel[res[0]][res[1]]= jLabel2;
        }
    }
    
     
    private int[] CheckLabelPosition(int x, int y){
        int indice[]= new int[2];
        indice[0]=0;
        indice[1]=0;    
        JLabel jLabel2 = new javax.swing.JLabel();
        for(int i=0; i<15;i++){
            for(int j=0; j<14;j++){
                jLabel2 = (JLabel)matrizLabel[i][j];
                if(jLabel2.getX()-1 < x && jLabel2.getX() + 51 > x){
                    if(jLabel2.getY()-1 < y && jLabel2.getY()+ 51 > y){
                        indice[0] = i;
                        indice[1] = j;
                        linha[0] = i;
                        linha[1] = j;
                        coluna.add(linha);
                    }
                }
            }
        }
        
        return indice;
    }
    
    private String getTexturas(int i){
        String path1="C:\\Jogo\\imagens\\";
        String textura= path1+"squarep.png";
        switch(i){
            case 1: textura=path1+"dirtE.png";
                break;
            case 2:
                textura= path1+"dirt.png";
                break;
            case 3: textura= path1+"dirtEx.png";
                break;
            case 4: textura= path1+"squarep.png";
                break;
            case 5: textura="C:\\Jogo\\imagens\\dirtupleft.png";
                break;
            case 6: textura="C:\\Jogo\\imagens\\dirtupright.png";
                break;
            case 7: textura="C:\\Jogo\\imagens\\dirtdownleft.png";
                break;
            case 8: textura="C:\\Jogo\\imagens\\dirtdownright.png";
                break;
            case 9: textura="C:\\Jogo\\imagens\\dirtleft.png";
                break;
            case 10: textura="C:\\Jogo\\imagens\\dirtright.png";
                break;
            case 11: textura="C:\\Jogo\\imagens\\dirtup.png";
                break;
            case 12: textura="C:\\Jogo\\imagens\\dirtdown.png";
                break;
            case 13: textura="C:\\Jogo\\imagens\\conerupright.png";
                break;
            case 14: textura="C:\\Jogo\\imagens\\cornerupleft.png";
                break;
            case 15: textura="C:\\Jogo\\imagens\\cornerdownright.png";
                break;
            case 16: textura="C:\\Jogo\\imagens\\cornerdownleft.png";
                break;
            case 17: textura="C:\\Jogo\\imagens\\cornerULDR.png";
                break;
            case 18: textura="C:\\Jogo\\imagens\\cornerURDL.png";
                break;
            case 19: textura="C:\\Jogo\\imagens\\grassred.png";
                break;
            case 20: textura="C:\\Jogo\\imagens\\grassredleaf.png";
                break;
            case 21: textura="C:\\Jogo\\imagens\\bushr.png";
                break;
            case 22: textura="C:\\Jogo\\imagens\\bushlongr.png";
                break;
            case 23: textura="C:\\Jogo\\imagens\\bushendD.png";
                break;
            case 24: textura="C:\\Jogo\\imagens\\bushendU.png";
                break;
            
        }
        
        return textura;
    }
    
    private Criador() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(938, 889));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\imagens\\dirtupright.png")); // NOI18N
        jLabel3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel3MouseDragged(evt);
            }
        });
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel3);
        jLabel3.setBounds(860, 20, 50, 50);

        jLabel26.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\imagens\\bushendU.png")); // NOI18N
        jLabel26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel26MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel26);
        jLabel26.setBounds(860, 660, 50, 50);

        jLabel25.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\imagens\\bushendD.png")); // NOI18N
        jLabel25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel25MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel25);
        jLabel25.setBounds(780, 660, 50, 50);

        jLabel24.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\imagens\\dirtE.png")); // NOI18N
        jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel24MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel24);
        jLabel24.setBounds(780, 730, 50, 50);

        jLabel23.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\imagens\\dirtEx.png")); // NOI18N
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel23);
        jLabel23.setBounds(860, 730, 50, 50);

        jLabel22.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\imagens\\bushlongr.png")); // NOI18N
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel22);
        jLabel22.setBounds(860, 590, 50, 50);

        jLabel21.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\imagens\\bushr.png")); // NOI18N
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel21);
        jLabel21.setBounds(780, 590, 50, 50);

        jLabel31.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\imagens\\grassredleaf.png")); // NOI18N
        jLabel31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel31MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel31);
        jLabel31.setBounds(860, 520, 50, 50);

        jLabel30.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\imagens\\grassred.png")); // NOI18N
        jLabel30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel30MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel30);
        jLabel30.setBounds(780, 520, 50, 50);

        jLabel17.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\imagens\\cornerURDL.png")); // NOI18N
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel17);
        jLabel17.setBounds(860, 450, 50, 50);

        jLabel16.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\imagens\\cornerULDR.png")); // NOI18N
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel16);
        jLabel16.setBounds(780, 450, 50, 50);

        jLabel15.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\imagens\\conerupright.png")); // NOI18N
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel15);
        jLabel15.setBounds(780, 300, 50, 50);

        jLabel14.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\imagens\\cornerdownleft.png")); // NOI18N
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel14);
        jLabel14.setBounds(860, 370, 50, 50);

        jLabel13.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\imagens\\cornerdownright.png")); // NOI18N
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel13);
        jLabel13.setBounds(780, 370, 50, 50);

        jLabel12.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\imagens\\cornerupleft.png")); // NOI18N
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel12);
        jLabel12.setBounds(860, 300, 50, 50);

        jLabel11.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\imagens\\dirtupleft.png")); // NOI18N
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel11);
        jLabel11.setBounds(780, 20, 50, 50);

        jLabel10.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\imagens\\dirtup.png")); // NOI18N
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel10);
        jLabel10.setBounds(780, 230, 50, 50);

        jLabel9.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\imagens\\dirtright.png")); // NOI18N
        jLabel9.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel9MouseDragged(evt);
            }
        });
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel9);
        jLabel9.setBounds(860, 160, 50, 50);

        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\imagens\\dirtleft.png")); // NOI18N
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel8);
        jLabel8.setBounds(780, 160, 50, 50);

        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\imagens\\dirtdownright.png")); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel7);
        jLabel7.setBounds(860, 90, 50, 50);

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\imagens\\dirtdownleft.png")); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel6);
        jLabel6.setBounds(780, 90, 50, 50);

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\imagens\\dirtdown.png")); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel5);
        jLabel5.setBounds(860, 230, 50, 50);

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\imagens\\dirt.png")); // NOI18N
        jLabel4.setEnabled(false);
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel4);
        jLabel4.setBounds(780, 790, 50, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\packs\\rpg_gui_v1\\rightmenu.png")); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(750, 0, 180, 860);

        jButton1.setText("salvar mapa");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(300, 730, 170, 25);

        jButton2.setFont(new java.awt.Font("Freestyle Script", 0, 36)); // NOI18N
        jButton2.setForeground(new java.awt.Color(102, 0, 0));
        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\packs\\rpg_gui_v1\\bt1.png")); // NOI18N
        jButton2.setText("Voltar");
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setFocusPainted(false);
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setRequestFocusEnabled(false);
        jButton2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jButton2MouseMoved(evt);
            }
        });
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton2MouseReleased(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(250, 770, 280, 60);

        jLabel20.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\packs\\rpg_gui_v1\\wood menu.png")); // NOI18N
        getContentPane().add(jLabel20);
        jLabel20.setBounds(-3, 696, 760, 160);

        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(660, 760, 41, 16);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void setTrail(){
        int ii;
        int jj;
        if(puc[1]==0){
                ii= puc[1];
                jj=puc[0]-1;
                for(int i=0; i<2;i++){
                    for(int j=jj;j<jj+3;j++){
                        jLabel2 = (JLabel) matrizLabel[j][i]; 
                        jLabel2.setEnabled(false);
                        matrizLabel[j][i]=jLabel2;
                    }
                    
                }
        }
        if(puc[1]>0 && puc[1]<13){
                ii= puc[1]-1;
                jj=puc[0]-1;
//            for(int i=ii; i<ii+3; i++){
//                for(int j=jj; j<jj+3; j++){   
//                    jLabel2 = (JLabel) matrizLabel[j][i]; 
//                    jLabel2.setEnabled(false);
//                    matrizLabel[j][i]=jLabel2;
//                }  
                for(int i=ii ;i<ii+3 ; i++){
                    
                        if(i==ii){
                            jLabel2 = (JLabel) matrizLabel[jj+1][i];
                            jLabel2.setEnabled(false);
                            matrizLabel[jj+1][i]=jLabel2;
                        }
                        if(i==ii+1){
                            jLabel2 = (JLabel) matrizLabel[jj][i];
                            jLabel2.setEnabled(false);
                            matrizLabel[jj][i]=jLabel2;
                            jLabel2 = (JLabel) matrizLabel[jj+2][i];
                            jLabel2.setEnabled(false);
                            matrizLabel[jj+2][i]=jLabel2;
                        }  
                        if(i==ii+2){
                            jLabel2 = (JLabel) matrizLabel[jj+1][i];
                            jLabel2.setEnabled(false);
                            matrizLabel[jj+1][i]=jLabel2;
                        } 
                    
            }   
        }
        
    }
    
    
    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        if(jLabel4.isEnabled()==true){
            setLabelsIcons();
             setTrail();        
            text=2;
            jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\imagens\\dirts.png"));
        }
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
       setLabelsIcons();
       text=12;
        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\imagens\\dirtdowns.png"));
        setMatrizNormal();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
       setLabelsIcons();
       text=7;
        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\imagens\\dirtdownlefts.png"));
        setMatrizNormal();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        setLabelsIcons();
        text=8;
        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\imagens\\dirtdownrights.png"));
        setMatrizNormal();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        setLabelsIcons();
        text=9;
        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\imagens\\dirtlefts.png"));
        setMatrizNormal();
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel9MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseDragged
       
    }//GEN-LAST:event_jLabel9MouseDragged

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        setLabelsIcons();
        text=11;
        jLabel10.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\imagens\\dirtups.png"));
        setMatrizNormal();
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        setLabelsIcons();
        text=5;
        jLabel11.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\imagens\\dirtuplefts.png"));
        setMatrizNormal();
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel3MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseDragged

    }//GEN-LAST:event_jLabel3MouseDragged

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
         setLabelsIcons();
         text=6;
        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\imagens\\dirtuprights.png"));
        setMatrizNormal();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
         setLabelsIcons();
         text=10;
        jLabel9.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\imagens\\dirtrights.png"));
        setMatrizNormal();
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
         setLabelsIcons();
         text=14;
        jLabel12.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\imagens\\corneruplefts.png"));
        setMatrizNormal();
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
         setLabelsIcons();
         text=15;
        jLabel13.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\imagens\\cornerdownrights.png"));
        setMatrizNormal();
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
         setLabelsIcons();
         text=16;
        jLabel14.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\imagens\\cornerdownlefts.png"));
        setMatrizNormal();
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        setLabelsIcons();
        text=13;
        jLabel15.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\imagens\\coneruprights.png"));
        setMatrizNormal();
    }//GEN-LAST:event_jLabel15MouseClicked

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        setLabelsIcons();
        text=17;
        jLabel16.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\imagens\\cornerULDRs.png"));
        setMatrizNormal();
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        setLabelsIcons();
        text=18;
        jLabel17.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\imagens\\cornerURDLs.png"));
        setMatrizNormal();
    }//GEN-LAST:event_jLabel17MouseClicked

    private void jLabel30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseClicked
        setLabelsIcons();
        text=19;
        jLabel30.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\imagens\\grassreds.png"));
        setMatrizNormal();
    }//GEN-LAST:event_jLabel30MouseClicked

    private void jLabel31MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel31MouseClicked
        setLabelsIcons();
        text=20;
        jLabel31.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\imagens\\grassredleafs.png"));
        setMatrizNormal();
    }//GEN-LAST:event_jLabel31MouseClicked

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        setLabelsIcons();
        text=21;
        jLabel21.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\imagens\\bushrs.png"));
        setMatrizNormal();
    }//GEN-LAST:event_jLabel21MouseClicked

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
       setLabelsIcons();
       text=22;
        jLabel22.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\imagens\\bushlongrs.png"));
        setMatrizNormal();
    }//GEN-LAST:event_jLabel22MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jLabel2 = new javax.swing.JLabel();
        int[] row = new int[2];
        ArrayList<int[]> coord = new ArrayList<int[]>();
        int x,y;
        for(int i=0; i<coluna.size(); i++){
            x = coluna.get(i)[0] ;
            y = coluna.get(i)[1];
            jLabel2 = (JLabel) matrizLabel[x][y];
            row[0] = (jLabel2.getX()+25); 
            row[1] = (jLabel2.getY()+25);
            coord.add(row);
        }
        dados.setMapa("Descrição");
        dados.setMapaCoord(coord);
        dados.setMapaListaLabels(matrizLabel);
        
        try {
            dados.gravaObj("DataObject.obj");
        } catch (IOException ex) {
            Logger.getLogger(Criador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
        if (jLabel23.isEnabled()==true){
        setLabelsIcons();
        text=3;
        jLabel23.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\imagens\\dirtExs.png"));
        setMatrizSquare();
        }
        //jLabel23.setEnabled(false);
    }//GEN-LAST:event_jLabel23MouseClicked

    private void jLabel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseClicked
        if (jLabel24.isEnabled()==true){
            setLabelsIcons();
            text=1;
            jLabel24.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\imagens\\dirtEs.png"));
            setMatrizSquare();
        }
        //jLabel24.setEnabled(false);
    }//GEN-LAST:event_jLabel24MouseClicked

    private void jLabel25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseClicked
       setLabelsIcons();
       text=23;
        jLabel25.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\imagens\\bushendDs.png"));
        setMatrizNormal();
        
    }//GEN-LAST:event_jLabel25MouseClicked

    private void jLabel26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseClicked
        setLabelsIcons();
        text=24;
        jLabel26.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\imagens\\bushendUs.png"));
        setMatrizNormal();
    }//GEN-LAST:event_jLabel26MouseClicked

    private void jButton2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseMoved
        jButton2.setIcon(new ImageIcon("C:\\Jogo\\packs\\rpg_gui_v1\\bt1-highlight.png"));
    }//GEN-LAST:event_jButton2MouseMoved

    private void jButton2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MousePressed
        jButton2.setIcon(new ImageIcon("C:\\Jogo\\packs\\rpg_gui_v1\\bt1-clicked.png"));
    }//GEN-LAST:event_jButton2MousePressed

    private void jButton2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseReleased
        jButton2.setIcon(new ImageIcon("C:\\Jogo\\packs\\rpg_gui_v1\\bt1.png"));
    }//GEN-LAST:event_jButton2MouseReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(JOptionPane.showConfirmDialog(null, "Deseja sair sem gravar o mapa?")==JOptionPane.YES_OPTION){
            Menu mn = new Menu(dados, spl);
            mn.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    
    private void setMatrizSquare(){
        
        for(int i=1;i<14;i++){
            for(int j=1;j<13;j++){
                jLabel2 = (JLabel)matrizLabel[i][j];
                jLabel2.setEnabled(false);
                matrizLabel[i][j]= jLabel2;
            }
        }
    }
    
    public void setMatrizNormal(){
        for(int i=0;i<15;i++){
            for(int j=0;j<14;j++){
                jLabel2 = (JLabel)matrizLabel[i][j];
                jLabel2.setEnabled(true);
                matrizLabel[i][j]= jLabel2;
            }
        }
//       i
    }
    
    private void setLabelsIcons(){
        
        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\imagens\\dirtupright.png"));
        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\imagens\\dirt.png"));
        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\imagens\\dirtdown.png"));
        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\imagens\\dirtdownleft.png"));
        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\imagens\\dirtdownright.png"));
        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\imagens\\dirtleft.png"));
        jLabel9.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\imagens\\dirtright.png"));
        jLabel10.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\imagens\\dirtup.png"));
        jLabel11.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\imagens\\dirtupleft.png"));
        jLabel12.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\imagens\\cornerupleft.png"));
        jLabel13.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\imagens\\cornerdownright.png"));
        jLabel14.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\imagens\\cornerdownleft.png"));
        jLabel15.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\imagens\\conerupright.png"));
        jLabel16.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\imagens\\cornerULDR.png"));
        jLabel17.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\imagens\\cornerURDL.png"));
        jLabel30.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\imagens\\grassred.png"));
        jLabel31.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\imagens\\grassredleaf.png"));
        jLabel21.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\imagens\\bushr.png"));
        jLabel22.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\imagens\\bushlongr.png"));
        jLabel23.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\imagens\\dirtEx.png"));
        jLabel24.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\imagens\\dirtE.png"));
        jLabel25.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\imagens\\bushendD.png"));
        jLabel26.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\imagens\\bushendU.png"));
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Criador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Criador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Criador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Criador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Criador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
