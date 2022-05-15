/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_final_edd1;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Hp
 */
public class Indicaciones1 extends javax.swing.JFrame {

    /**
     * Creates new form Indicaciones1
     */
    public Indicaciones1() {
     initComponents();
     this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        home = new javax.swing.JLabel();
        sgt = new javax.swing.JLabel();
        dinero = new javax.swing.JLabel();
        suerte = new javax.swing.JLabel();
        dados = new javax.swing.JLabel();
        comunitario = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeMouseClicked(evt);
            }
        });
        jPanel1.add(home, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 70, 60));

        sgt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sgtMouseClicked(evt);
            }
        });
        jPanel1.add(sgt, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 450, 70, 70));

        dinero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dineroMouseClicked(evt);
            }
        });
        jPanel1.add(dinero, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 190, 50, 40));

        suerte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                suerteMouseClicked(evt);
            }
        });
        jPanel1.add(suerte, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 260, 50, 40));

        dados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dadosMouseClicked(evt);
            }
        });
        jPanel1.add(dados, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 340, 50, 40));

        comunitario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comunitarioMouseClicked(evt);
            }
        });
        jPanel1.add(comunitario, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 410, 50, 40));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Data1/indicaciones1.jpg"))); // NOI18N
        jPanel1.add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 520));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseClicked
        Njugadores f = new Njugadores();
        f.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_homeMouseClicked

    private void sgtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sgtMouseClicked
        Indicaciones2 f = new Indicaciones2();
        f.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_sgtMouseClicked

    private void dineroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dineroMouseClicked
        Icon icono = new ImageIcon(getClass().getResource("/Data1/plata.png"));
        JOptionPane.showMessageDialog(rootPane, "", "!!!", JOptionPane.PLAIN_MESSAGE, icono);
    }//GEN-LAST:event_dineroMouseClicked

    private void suerteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_suerteMouseClicked
       Icon icono = new ImageIcon(getClass().getResource("/Data1/suerte.png"));
       JOptionPane.showMessageDialog(rootPane, "", "!!!", JOptionPane.PLAIN_MESSAGE, icono);
    }//GEN-LAST:event_suerteMouseClicked

    private void comunitarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comunitarioMouseClicked
        Icon icono = new ImageIcon(getClass().getResource("/Data1/plata.png"));
        JOptionPane.showMessageDialog(rootPane, "", "!!!", JOptionPane.PLAIN_MESSAGE, icono);
    }//GEN-LAST:event_comunitarioMouseClicked

    private void dadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dadosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_dadosMouseClicked

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
            java.util.logging.Logger.getLogger(Indicaciones1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Indicaciones1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Indicaciones1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Indicaciones1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Indicaciones1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel comunitario;
    private javax.swing.JLabel dados;
    private javax.swing.JLabel dinero;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel home;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel sgt;
    private javax.swing.JLabel suerte;
    // End of variables declaration//GEN-END:variables
}
