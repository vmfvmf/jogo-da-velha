/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OldGame;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author vi
 */
public class TelaJogo extends javax.swing.JFrame {

    private JLabel tabuleiroImg[][];
    private Game g;
    ImageIcon xicon, oicon;

    /**
     * Creates new form TelaJogo
     */
    public TelaJogo() {
        initComponents();
    }

    public TelaJogo(Game g) {
        initComponents();
        this.g = g;
        jLInimigo.setText("Você está jogando contra " + g.getEnemy().getNick());
        tabuleiroImg = new JLabel[][]{
            {jLabel00, jLabel01, jLabel02},
            {jLabel10, jLabel11, jLabel12},
            {jLabel20, jLabel21, jLabel22}
        };
        xicon = new ImageIcon(getClass().getResource("/OldGame/x.png"));
        oicon = new ImageIcon(getClass().getResource("/OldGame/o.png"));
    }

    public void setTag(int x, int y, String tag) {
        tabuleiroImg[x][y].setIcon(tag.equals("x") ? xicon : oicon);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
          // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
          private void initComponents() {

                    jLabel00 = new javax.swing.JLabel();
                    jLabel01 = new javax.swing.JLabel();
                    jLabel02 = new javax.swing.JLabel();
                    jLabel10 = new javax.swing.JLabel();
                    jLabel11 = new javax.swing.JLabel();
                    jLabel12 = new javax.swing.JLabel();
                    jLabel20 = new javax.swing.JLabel();
                    jLabel21 = new javax.swing.JLabel();
                    jLabel22 = new javax.swing.JLabel();
                    jLInimigo = new javax.swing.JLabel();
                    jLPlanoFundo = new javax.swing.JLabel();
                    jLabel1 = new javax.swing.JLabel();

                    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                    addWindowListener(new java.awt.event.WindowAdapter() {
                              public void windowClosing(java.awt.event.WindowEvent evt) {
                                        formWindowClosing(evt);
                              }
                    });
                    getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                    jLabel00.setFont(new java.awt.Font("DejaVu Sans", 1, 48)); // NOI18N
                    jLabel00.setBorder(null);
                    jLabel00.addMouseListener(new java.awt.event.MouseAdapter() {
                              public void mouseClicked(java.awt.event.MouseEvent evt) {
                                        jLabel00MouseClicked(evt);
                              }
                              public void mouseExited(java.awt.event.MouseEvent evt) {
                                        jLabel00MouseExited(evt);
                              }
                              public void mouseEntered(java.awt.event.MouseEvent evt) {
                                        jLabel00MouseEntered(evt);
                              }
                    });
                    getContentPane().add(jLabel00, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 160, 160));

                    jLabel01.setFont(new java.awt.Font("DejaVu Sans", 1, 48)); // NOI18N
                    jLabel01.addMouseListener(new java.awt.event.MouseAdapter() {
                              public void mouseClicked(java.awt.event.MouseEvent evt) {
                                        jLabel01MouseClicked(evt);
                              }
                              public void mouseExited(java.awt.event.MouseEvent evt) {
                                        jLabel01MouseExited(evt);
                              }
                              public void mouseEntered(java.awt.event.MouseEvent evt) {
                                        jLabel01MouseEntered(evt);
                              }
                    });
                    getContentPane().add(jLabel01, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, 160, 150));

                    jLabel02.setFont(new java.awt.Font("DejaVu Sans", 1, 48)); // NOI18N
                    jLabel02.addMouseListener(new java.awt.event.MouseAdapter() {
                              public void mouseClicked(java.awt.event.MouseEvent evt) {
                                        jLabel02MouseClicked(evt);
                              }
                              public void mouseExited(java.awt.event.MouseEvent evt) {
                                        jLabel02MouseExited(evt);
                              }
                              public void mouseEntered(java.awt.event.MouseEvent evt) {
                                        jLabel02MouseEntered(evt);
                              }
                    });
                    getContentPane().add(jLabel02, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 120, 160, 160));

                    jLabel10.setFont(new java.awt.Font("DejaVu Sans", 1, 48)); // NOI18N
                    jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
                              public void mouseClicked(java.awt.event.MouseEvent evt) {
                                        jLabel10MouseClicked(evt);
                              }
                              public void mouseExited(java.awt.event.MouseEvent evt) {
                                        jLabel10MouseExited(evt);
                              }
                              public void mouseEntered(java.awt.event.MouseEvent evt) {
                                        jLabel10MouseEntered(evt);
                              }
                    });
                    getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 170, 150));

                    jLabel11.setFont(new java.awt.Font("DejaVu Sans", 1, 48)); // NOI18N
                    jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
                              public void mouseClicked(java.awt.event.MouseEvent evt) {
                                        jLabel11MouseClicked(evt);
                              }
                              public void mouseExited(java.awt.event.MouseEvent evt) {
                                        jLabel11MouseExited(evt);
                              }
                              public void mouseEntered(java.awt.event.MouseEvent evt) {
                                        jLabel11MouseEntered(evt);
                              }
                    });
                    getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, 160, 160));

                    jLabel12.setFont(new java.awt.Font("DejaVu Sans", 1, 48)); // NOI18N
                    jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
                              public void mouseClicked(java.awt.event.MouseEvent evt) {
                                        jLabel12MouseClicked(evt);
                              }
                              public void mouseExited(java.awt.event.MouseEvent evt) {
                                        jLabel12MouseExited(evt);
                              }
                              public void mouseEntered(java.awt.event.MouseEvent evt) {
                                        jLabel12MouseEntered(evt);
                              }
                    });
                    getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 330, 170, 160));

                    jLabel20.setFont(new java.awt.Font("DejaVu Sans", 1, 48)); // NOI18N
                    jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
                              public void mouseClicked(java.awt.event.MouseEvent evt) {
                                        jLabel20MouseClicked(evt);
                              }
                              public void mouseExited(java.awt.event.MouseEvent evt) {
                                        jLabel20MouseExited(evt);
                              }
                              public void mouseEntered(java.awt.event.MouseEvent evt) {
                                        jLabel20MouseEntered(evt);
                              }
                    });
                    getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, 160, 150));

                    jLabel21.setFont(new java.awt.Font("DejaVu Sans", 1, 48)); // NOI18N
                    jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
                              public void mouseClicked(java.awt.event.MouseEvent evt) {
                                        jLabel21MouseClicked(evt);
                              }
                              public void mouseExited(java.awt.event.MouseEvent evt) {
                                        jLabel21MouseExited(evt);
                              }
                              public void mouseEntered(java.awt.event.MouseEvent evt) {
                                        jLabel21MouseEntered(evt);
                              }
                    });
                    getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 550, 170, 160));

                    jLabel22.setFont(new java.awt.Font("DejaVu Sans", 1, 48)); // NOI18N
                    jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
                              public void mouseClicked(java.awt.event.MouseEvent evt) {
                                        jLabel22MouseClicked(evt);
                              }
                              public void mouseExited(java.awt.event.MouseEvent evt) {
                                        jLabel22MouseExited(evt);
                              }
                              public void mouseEntered(java.awt.event.MouseEvent evt) {
                                        jLabel22MouseEntered(evt);
                              }
                    });
                    getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 550, 170, 150));

                    jLInimigo.setBackground(new java.awt.Color(250, 201, 201));
                    jLInimigo.setFont(new java.awt.Font("Bitstream Charter", 3, 36)); // NOI18N
                    jLInimigo.setForeground(new java.awt.Color(243, 245, 200));
                    jLInimigo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    jLInimigo.addMouseListener(new java.awt.event.MouseAdapter() {
                              public void mouseClicked(java.awt.event.MouseEvent evt) {
                                        jLInimigoMouseClicked(evt);
                              }
                    });
                    getContentPane().add(jLInimigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 640, 60));

                    jLPlanoFundo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    jLPlanoFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/OldGame/jogovelha1.png"))); // NOI18N
                    getContentPane().add(jLPlanoFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 660, 720));

                    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/OldGame/fundo2.jpg"))); // NOI18N
                    jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
                    getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 0, 810, 960));

                    pack();
          }// </editor-fold>//GEN-END:initComponents

    private void drawBorder(JLabel jl) {
        if (jl.getIcon() != xicon
                && jl.getIcon() != oicon) {
            jl.setBorder(BorderFactory.createLineBorder(Color.black));
        }
    }
          private void jLabel00MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel00MouseEntered
              // TODO add your handling code here:
              drawBorder(jLabel00);
          }//GEN-LAST:event_jLabel00MouseEntered

          private void jLabel00MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel00MouseExited
              // TODO add your handling code here:
              jLabel00.setBorder(BorderFactory.createEmptyBorder());

          }//GEN-LAST:event_jLabel00MouseExited

          private void jLabel00MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel00MouseClicked
              // TODO add your handling code here:
              enviarJogada(jLabel00, 0, 0);
          }//GEN-LAST:event_jLabel00MouseClicked

          private void jLabel01MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel01MouseClicked
              // TODO add your handling code here:
              enviarJogada(jLabel01, 0, 1);
          }//GEN-LAST:event_jLabel01MouseClicked

          private void jLabel02MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel02MouseClicked
              // TODO add your handling code here:
              enviarJogada(jLabel02, 0, 2);
          }//GEN-LAST:event_jLabel02MouseClicked

          private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
              // TODO add your handling code here:
              enviarJogada(jLabel10, 1, 0);
          }//GEN-LAST:event_jLabel10MouseClicked

          private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
              // TODO add your handling code here:
              enviarJogada(jLabel11, 1, 1);
          }//GEN-LAST:event_jLabel11MouseClicked

          private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
              // TODO add your handling code here:
              enviarJogada(jLabel12, 1, 2);
          }//GEN-LAST:event_jLabel12MouseClicked

          private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
              // TODO add your handling code here:
              enviarJogada(jLabel20, 2, 0);
          }//GEN-LAST:event_jLabel20MouseClicked

          private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
              // TODO add your handling code here:
              enviarJogada(jLabel21, 2, 1);
          }//GEN-LAST:event_jLabel21MouseClicked

          private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
              // TODO add your handling code here:
              enviarJogada(jLabel22, 2, 2);
          }//GEN-LAST:event_jLabel22MouseClicked

          private void jLabel01MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel01MouseEntered
              // TODO add your handling code here:
              drawBorder(jLabel01);
          }//GEN-LAST:event_jLabel01MouseEntered

          private void jLabel01MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel01MouseExited
              // TODO add your handling code here:
              jLabel01.setBorder(BorderFactory.createEmptyBorder());

          }//GEN-LAST:event_jLabel01MouseExited

          private void jLabel02MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel02MouseEntered
              // TODO add your handling code here:
              drawBorder(jLabel02);
          }//GEN-LAST:event_jLabel02MouseEntered

          private void jLabel20MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseEntered
              // TODO add your handling code here:
              drawBorder(jLabel20);
          }//GEN-LAST:event_jLabel20MouseEntered

          private void jLabel02MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel02MouseExited
              // TODO add your handling code here:
              jLabel02.setBorder(BorderFactory.createEmptyBorder());
          }//GEN-LAST:event_jLabel02MouseExited

          private void jLabel10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseEntered
              // TODO add your handling code here:
              drawBorder(jLabel10);
          }//GEN-LAST:event_jLabel10MouseEntered

          private void jLabel11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseEntered
              // TODO add your handling code here:
              drawBorder(jLabel11);
          }//GEN-LAST:event_jLabel11MouseEntered

          private void jLabel12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseEntered
              // TODO add your handling code here:
              drawBorder(jLabel12);
          }//GEN-LAST:event_jLabel12MouseEntered

          private void jLabel21MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseEntered
              // TODO add your handling code here:
              drawBorder(jLabel21);
          }//GEN-LAST:event_jLabel21MouseEntered

          private void jLabel22MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseEntered
              // TODO add your handling code here:
              drawBorder(jLabel22);
          }//GEN-LAST:event_jLabel22MouseEntered

          private void jLabel10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseExited
              // TODO add your handling code here:
              jLabel10.setBorder(BorderFactory.createEmptyBorder());
          }//GEN-LAST:event_jLabel10MouseExited

          private void jLabel11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseExited
              // TODO add your handling code here:
              jLabel11.setBorder(BorderFactory.createEmptyBorder());
          }//GEN-LAST:event_jLabel11MouseExited

          private void jLabel12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseExited
              // TODO add your handling code here:
              jLabel12.setBorder(BorderFactory.createEmptyBorder());
          }//GEN-LAST:event_jLabel12MouseExited

          private void jLabel20MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseExited
              // TODO add your handling code here:
              jLabel20.setBorder(BorderFactory.createEmptyBorder());
          }//GEN-LAST:event_jLabel20MouseExited

          private void jLabel21MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseExited
              // TODO add your handling code here:
              jLabel21.setBorder(BorderFactory.createEmptyBorder());
          }//GEN-LAST:event_jLabel21MouseExited

          private void jLabel22MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseExited
              // TODO add your handling code here:
              jLabel22.setBorder(BorderFactory.createEmptyBorder());
          }//GEN-LAST:event_jLabel22MouseExited

          private void jLInimigoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLInimigoMouseClicked
              if (g instanceof GameNetwork) {

              }
          }//GEN-LAST:event_jLInimigoMouseClicked

          private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
              if (g instanceof GameNetwork) {
                  //try {
                  // TODO add your handling code here:
                  //g.enviar("F");
                  //} catch (IOException ex) {
                  //  Logger.getLogger(TelaJogo.class.getName()).log(Level.SEVERE, null, ex);
                  //}
              }
          }//GEN-LAST:event_formWindowClosing

    private void enviarJogada(JLabel jla, int x, int y) {
        Jogada j = new Jogada(x, y);
        g.fazerJogada(j);
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
            java.util.logging.Logger.getLogger(TelaJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaJogo().setVisible(true);
            }
        });
    }

          // Variables declaration - do not modify//GEN-BEGIN:variables
          private javax.swing.JLabel jLInimigo;
          private javax.swing.JLabel jLPlanoFundo;
          private javax.swing.JLabel jLabel00;
          private javax.swing.JLabel jLabel01;
          private javax.swing.JLabel jLabel02;
          private javax.swing.JLabel jLabel1;
          private javax.swing.JLabel jLabel10;
          private javax.swing.JLabel jLabel11;
          private javax.swing.JLabel jLabel12;
          private javax.swing.JLabel jLabel20;
          private javax.swing.JLabel jLabel21;
          private javax.swing.JLabel jLabel22;
          // End of variables declaration//GEN-END:variables
}
