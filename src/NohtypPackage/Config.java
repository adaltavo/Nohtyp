/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NohtypPackage;

import java.awt.Color;
import javax.swing.text.StyleConstants;

/**
 *
 * @author Principal
 */
public class Config extends javax.swing.JDialog {
Ventana padre;
    /**
     * Creates new form Config
     */
    public Config(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        padre=(Ventana)parent;
        this.setLocation(400, 200);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbxnum = new javax.swing.JComboBox();
        cbxreser = new javax.swing.JComboBox();
        cbxcomen = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        cbxtexto = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Configuraciones");

        jLabel1.setFont(new java.awt.Font("Tunga", 0, 18)); // NOI18N
        jLabel1.setText("Color palabras reservadas en texto");

        jLabel2.setFont(new java.awt.Font("Tunga", 0, 18)); // NOI18N
        jLabel2.setText("Color de comentarios en texto");

        jLabel3.setFont(new java.awt.Font("Tunga", 0, 18)); // NOI18N
        jLabel3.setText("Color de números en texto");

        cbxnum.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Negro", "Rojo", "Rosa", "Azul", "Verde", "Amarillo", "Naranja" }));
        cbxnum.setSelectedIndex(3);

        cbxreser.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Negro", "Rojo", "Rosa", "Azul", "Verde", "Amarillo", "Naranja" }));
        cbxreser.setSelectedIndex(2);

        cbxcomen.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Negro", "Rojo", "Rosa", "Azul", "Verde", "Amarillo", "Naranja" }));
        cbxcomen.setSelectedIndex(1);
        cbxcomen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxcomenActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tunga", 0, 18)); // NOI18N
        jLabel4.setText("Color del texto");

        cbxtexto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Negro", "Rojo", "Rosa", "Azul", "Verde", "Amarillo", "Naranja" }));
        cbxtexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxtextoActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tunga", 0, 18)); // NOI18N
        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tunga", 0, 18)); // NOI18N
        jButton2.setText("Guardar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxtexto, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxcomen, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxnum, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxreser, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbxnum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbxreser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxcomen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbxtexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(25, Short.MAX_VALUE))
        );

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

    private void cbxcomenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxcomenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxcomenActionPerformed

    private void cbxtextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxtextoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxtextoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
/*
        Negro
Rojo
Rosa
Azul
Verde
Amarillo
Naranja
Cafe
        */
        
String temp="";
if(cbxnum.getSelectedIndex()==0)
    padre.num=Color.black;
if(cbxnum.getSelectedIndex()==1)
    padre.num=Color.red;
if(cbxnum.getSelectedIndex()==2)
    padre.num=Color.magenta;
if(cbxnum.getSelectedIndex()==3)
    padre.num=Color.blue;
if(cbxnum.getSelectedIndex()==4)
    padre.num=Color.green;
if(cbxnum.getSelectedIndex()==5)
    padre.num=Color.yellow;
if(cbxnum.getSelectedIndex()==6)
    padre.num=Color.orange;


if(cbxreser.getSelectedIndex()==0)
    padre.reser=Color.black;
if(cbxreser.getSelectedIndex()==1)
    padre.reser=Color.red;
if(cbxreser.getSelectedIndex()==2)
    padre.reser=Color.magenta;
if(cbxreser.getSelectedIndex()==3)
    padre.reser=Color.blue;
if(cbxreser.getSelectedIndex()==4)
    padre.reser=Color.green;
if(cbxreser.getSelectedIndex()==5)
    padre.reser=Color.yellow;
if(cbxreser.getSelectedIndex()==6)
    padre.reser=Color.orange;


if(cbxcomen.getSelectedIndex()==0)
    padre.comen=Color.black;
if(cbxcomen.getSelectedIndex()==1)
    padre.comen=Color.red;
if(cbxcomen.getSelectedIndex()==2)
    padre.comen=Color.magenta;
if(cbxcomen.getSelectedIndex()==3)
    padre.comen=Color.blue;
if(cbxcomen.getSelectedIndex()==4)
    padre.comen=Color.green;
if(cbxcomen.getSelectedIndex()==5)
    padre.comen=Color.yellow;
if(cbxcomen.getSelectedIndex()==6)
    padre.comen=Color.orange;


if(cbxtexto.getSelectedIndex()==0)
    padre.texto=Color.black;
if(cbxtexto.getSelectedIndex()==1)
    padre.texto=Color.red;
if(cbxtexto.getSelectedIndex()==2)
    padre.texto=Color.magenta;
if(cbxtexto.getSelectedIndex()==3)
    padre.texto=Color.blue;
if(cbxtexto.getSelectedIndex()==4)
    padre.texto=Color.green;
if(cbxtexto.getSelectedIndex()==5)
    padre.texto=Color.yellow;
if(cbxtexto.getSelectedIndex()==6)
    padre.texto=Color.orange;

padre.comentario=padre.st.addAttribute(padre.st.getEmptySet(), StyleConstants.Foreground, padre.comen);
padre.normal=padre.st.addAttribute(padre.st.getEmptySet(), StyleConstants.Foreground, padre.texto);
padre.numero=padre.st.addAttribute(padre.st.getEmptySet(), StyleConstants.Foreground, padre.num);
padre.reservado=padre.st.addAttribute(padre.st.getEmptySet(), StyleConstants.Foreground, padre.reser);

temp=padre.obTexto();
padre.inTexto("");
padre.inTexto(temp);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
this.setVisible(false);
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
            java.util.logging.Logger.getLogger(Config.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Config.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Config.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Config.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Config dialog = new Config(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbxcomen;
    private javax.swing.JComboBox cbxnum;
    private javax.swing.JComboBox cbxreser;
    private javax.swing.JComboBox cbxtexto;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
