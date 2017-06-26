/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import javax.swing.ImageIcon;
import jogo.Jogador;
import jogo.Jogo;

/**
 *
 * @author user
 */
public class Menu extends javax.swing.JFrame {
    Jogo dados;
    int spl;
    /**
     * Creates new form Menu
     */
    public Menu(Jogo jog, int pl) {
        initComponents();
        this.dados = jog;
        this.spl = pl;
        jLabel1.setText(dados.getJogador(spl).getNome());
        jLabel4.setText("Nivel: "+Integer.toString(dados.getJogador(spl).getNivel()));
    }

    private Menu() {
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

        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(761, 822));
        setMinimumSize(new java.awt.Dimension(761, 822));
        setPreferredSize(new java.awt.Dimension(761, 822));
        setResizable(false);
        getContentPane().setLayout(null);

        jButton1.setFont(new java.awt.Font("Freestyle Script", 0, 36)); // NOI18N
        jButton1.setForeground(new java.awt.Color(102, 0, 0));
        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\packs\\rpg_gui_v1\\bt1.png")); // NOI18N
        jButton1.setText("Jogar");
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusPainted(false);
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setRequestFocusEnabled(false);
        jButton1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jButton1MouseMoved(evt);
            }
        });
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton1MouseReleased(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(250, 190, 280, 60);

        jButton5.setFont(new java.awt.Font("Freestyle Script", 0, 36)); // NOI18N
        jButton5.setForeground(new java.awt.Color(102, 0, 0));
        jButton5.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\packs\\rpg_gui_v1\\bt1.png")); // NOI18N
        jButton5.setText("Mercado");
        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        jButton5.setFocusPainted(false);
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setRequestFocusEnabled(false);
        jButton5.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jButton5MouseMoved(evt);
            }
        });
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton5MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton5MouseReleased(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(250, 280, 280, 60);

        jButton6.setFont(new java.awt.Font("Freestyle Script", 0, 36)); // NOI18N
        jButton6.setForeground(new java.awt.Color(102, 0, 0));
        jButton6.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\packs\\rpg_gui_v1\\bt1.png")); // NOI18N
        jButton6.setText("Criador");
        jButton6.setBorderPainted(false);
        jButton6.setContentAreaFilled(false);
        jButton6.setFocusPainted(false);
        jButton6.setFocusable(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setRequestFocusEnabled(false);
        jButton6.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jButton6MouseMoved(evt);
            }
        });
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton6MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton6MouseReleased(evt);
            }
        });
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6);
        jButton6.setBounds(250, 370, 280, 60);

        jButton7.setFont(new java.awt.Font("Freestyle Script", 0, 36)); // NOI18N
        jButton7.setForeground(new java.awt.Color(102, 0, 0));
        jButton7.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\packs\\rpg_gui_v1\\bt1.png")); // NOI18N
        jButton7.setText("Opções");
        jButton7.setBorderPainted(false);
        jButton7.setContentAreaFilled(false);
        jButton7.setFocusPainted(false);
        jButton7.setFocusable(false);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setRequestFocusEnabled(false);
        jButton7.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jButton7MouseMoved(evt);
            }
        });
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton7MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton7MouseReleased(evt);
            }
        });
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7);
        jButton7.setBounds(250, 470, 280, 60);

        jProgressBar1.setForeground(new java.awt.Color(153, 102, 0));
        jProgressBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jProgressBar1.setStringPainted(true);
        getContentPane().add(jProgressBar1);
        jProgressBar1.setBounds(30, 740, 148, 21);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 0));
        jLabel5.setText("Nivel Seguinte");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(30, 710, 150, 22);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 0));
        jLabel4.setText("Nivel:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 676, 60, 20);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 0));
        jLabel1.setText("Nome:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 650, 60, 20);

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\packs\\rpg_gui_v1\\wood menu.png")); // NOI18N
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 630, 770, 160);

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Jogo\\imagens\\bg anim2.gif")); // NOI18N
        jLabel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel2MouseMoved(evt);
            }
        });
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, -70, 1532, 780);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
       Opcoes op = new Opcoes(dados, spl);
       op.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseMoved
        jButton1.setIcon(new ImageIcon("C:\\Jogo\\packs\\rpg_gui_v1\\bt1-highlight.png"));
    }//GEN-LAST:event_jButton1MouseMoved

    private void jButton5MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseMoved
        jButton5.setIcon(new ImageIcon("C:\\Jogo\\packs\\rpg_gui_v1\\bt1-highlight.png"));
    }//GEN-LAST:event_jButton5MouseMoved

    private void jButton6MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseMoved
        jButton6.setIcon(new ImageIcon("C:\\Jogo\\packs\\rpg_gui_v1\\bt1-highlight.png"));
    }//GEN-LAST:event_jButton6MouseMoved

    private void jButton7MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseMoved
        jButton7.setIcon(new ImageIcon("C:\\Jogo\\packs\\rpg_gui_v1\\bt1-highlight.png"));
    }//GEN-LAST:event_jButton7MouseMoved

    private void jLabel2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseMoved
         jButton1.setIcon(new ImageIcon("C:\\Jogo\\packs\\rpg_gui_v1\\bt1.png"));
          jButton5.setIcon(new ImageIcon("C:\\Jogo\\packs\\rpg_gui_v1\\bt1.png"));
           jButton6.setIcon(new ImageIcon("C:\\Jogo\\packs\\rpg_gui_v1\\bt1.png"));
            jButton7.setIcon(new ImageIcon("C:\\Jogo\\packs\\rpg_gui_v1\\bt1.png"));
    }//GEN-LAST:event_jLabel2MouseMoved

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed
         jButton1.setIcon(new ImageIcon("C:\\Jogo\\packs\\rpg_gui_v1\\bt1-clicked.png"));
    }//GEN-LAST:event_jButton1MousePressed

    private void jButton1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseReleased
        jButton1.setIcon(new ImageIcon("C:\\Jogo\\packs\\rpg_gui_v1\\bt1.png"));
    }//GEN-LAST:event_jButton1MouseReleased

    private void jButton5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MousePressed
         jButton5.setIcon(new ImageIcon("C:\\Jogo\\packs\\rpg_gui_v1\\bt1-clicked.png"));
    }//GEN-LAST:event_jButton5MousePressed

    private void jButton5MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseReleased
        jButton5.setIcon(new ImageIcon("C:\\Jogo\\packs\\rpg_gui_v1\\bt1.png"));
    }//GEN-LAST:event_jButton5MouseReleased

    private void jButton6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MousePressed
       jButton6.setIcon(new ImageIcon("C:\\Jogo\\packs\\rpg_gui_v1\\bt1-clicked.png"));
    }//GEN-LAST:event_jButton6MousePressed

    private void jButton6MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseReleased
         jButton6.setIcon(new ImageIcon("C:\\Jogo\\packs\\rpg_gui_v1\\bt1.png"));
    }//GEN-LAST:event_jButton6MouseReleased

    private void jButton7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MousePressed
         jButton7.setIcon(new ImageIcon("C:\\Jogo\\packs\\rpg_gui_v1\\bt1-clicked.png"));
    }//GEN-LAST:event_jButton7MousePressed

    private void jButton7MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseReleased
         jButton7.setIcon(new ImageIcon("C:\\Jogo\\packs\\rpg_gui_v1\\bt1.png"));
    }//GEN-LAST:event_jButton7MouseReleased

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Mercado mrc = new Mercado(dados, spl);
        mrc.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        Criador cr = new Criador(dados, spl);
        cr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       Mapas mps= new Mapas(dados, spl);
       mps.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables
}
