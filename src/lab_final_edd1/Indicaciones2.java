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
public class Indicaciones2 extends javax.swing.JFrame {

    /**
     * Creates new form Indicaciones2
     */
    public Indicaciones2() {
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
        atras = new javax.swing.JLabel();
        ganr = new javax.swing.JLabel();
        primero = new javax.swing.JLabel();
        propied = new javax.swing.JLabel();
        turno = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        atras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                atrasMouseClicked(evt);
            }
        });
        jPanel1.add(atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 70, 60));

        ganr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ganrMouseClicked(evt);
            }
        });
        jPanel1.add(ganr, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 160, 40, 50));
        jPanel1.add(primero, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 240, 40, 50));

        propied.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                propiedMouseClicked(evt);
            }
        });
        jPanel1.add(propied, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 420, 50, 50));

        turno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                turnoMouseClicked(evt);
            }
        });
        jPanel1.add(turno, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 310, 40, 50));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Data1/indicaciones2.jpg"))); // NOI18N
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

    private void atrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_atrasMouseClicked
        Indicaciones1 f = new Indicaciones1();
        f.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_atrasMouseClicked

    private void ganrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ganrMouseClicked
        Icon icono = new ImageIcon(getClass().getResource("/Data1/ganar.png"));
        JOptionPane.showMessageDialog(rootPane, "", "!!!", JOptionPane.PLAIN_MESSAGE, icono);
    }//GEN-LAST:event_ganrMouseClicked

    private void turnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_turnoMouseClicked
        Icon icono = new ImageIcon(getClass().getResource("/Data1/turno.png"));
        JOptionPane.showMessageDialog(rootPane, "", "!!!", JOptionPane.PLAIN_MESSAGE, icono);
    }//GEN-LAST:event_turnoMouseClicked

    private void propiedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_propiedMouseClicked
       Icon icono = new ImageIcon(getClass().getResource("/Data1/prop.png"));
        JOptionPane.showMessageDialog(rootPane, "", "!!!", JOptionPane.PLAIN_MESSAGE, icono);
    }//GEN-LAST:event_propiedMouseClicked

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
            java.util.logging.Logger.getLogger(Indicaciones2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Indicaciones2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Indicaciones2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Indicaciones2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Indicaciones2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel atras;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel ganr;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel primero;
    private javax.swing.JLabel propied;
    private javax.swing.JLabel turno;
    // End of variables declaration//GEN-END:variables
}
