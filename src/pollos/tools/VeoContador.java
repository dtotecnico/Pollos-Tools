/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pollos.tools;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author dpatik
 */
public class VeoContador extends javax.swing.JFrame {

    /**
     * Creates new form VeoContador
     */
    DefaultTableModel model;
    static MyPollosTools mpt = new MyPollosTools();
    int new_id, old_id;
    
    public VeoContador() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("VeoContador 8.05");
        Calendar c2 = new GregorianCalendar();
        jDateChooser1.setCalendar(c2);
        
        
        
        JTableHeader tblhdr;
        tblhdr = tbl_granjas.getTableHeader();
        Font fuente = new Font("Verdana", Font.ITALIC, 14);
        tblhdr.setFont(fuente); 
        
        Object[] fila1 = new Object[2];
        String[] titulos1 = {"Granja", "Faena"};
        model = new DefaultTableModel(null, titulos1);
        
        tbl_granjas.setModel(model);
        
        ResultSet rs;
        String query = "SELECT nombre from granjas_id order by nombre";
        rs = mpt.ConsultaDB(query);
        try {
            while (rs.next()) {
            cmb_granjas.addItem(rs.getString("nombre"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(VeoContador.class.getName()).log(Level.SEVERE, null, ex);
        }
        lbl_counter.setText("00000");
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_counter = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_granjas = new javax.swing.JTable();
        lbl_totfaena = new javax.swing.JLabel();
        btn_totxfrm = new javax.swing.JButton();
        cmb_granjas = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbl_counter.setBackground(new java.awt.Color(204, 255, 255));
        lbl_counter.setFont(new java.awt.Font("Tahoma", 0, 150)); // NOI18N
        lbl_counter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_counter.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jDateChooser1.setDateFormatString("dd/MM/yyyy");
        jDateChooser1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        tbl_granjas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tbl_granjas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_granjas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_granjasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_granjas);

        lbl_totfaena.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbl_totfaena.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btn_totxfrm.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_totxfrm.setText("TOTAL x GRANJA");
        btn_totxfrm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_totxfrmMouseClicked(evt);
            }
        });

        cmb_granjas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cmb_granjas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "GRANJAS" }));
        cmb_granjas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_granjasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_counter, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(btn_totxfrm)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbl_totfaena, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(cmb_granjas, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(cmb_granjas, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_totxfrm, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_totfaena, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lbl_counter, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_totxfrmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_totxfrmMouseClicked
        // TODO add your handling code here:
        SimpleDateFormat ymd = new SimpleDateFormat("yyyy-MM-dd");
        String fecha = ymd.format(jDateChooser1.getDate());
        Object[] fila1 = new Object[2];
        String[] titulos1 = {"Granja", "Faena"};
        model = new DefaultTableModel(null, titulos1);
        ResultSet rs;
        rs = mpt.ConsultaDB("select granja, qty from "
                + "faena where fecha=\'" + fecha + "\'");
        try {

            while (rs.next()) {
                fila1[0] = mpt.GetNombreFrm(rs.getInt("granja"));
                fila1[1] = rs.getInt("qty");

                model.addRow(fila1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VeoContador.class.getName()).log(Level.SEVERE, null, ex);
        }
        tbl_granjas.setModel(model);
        
                rs = mpt.ConsultaDB("select sum(qty) from "
                + "faena where fecha=\'" + fecha + "\'");
        try {

            while (rs.next()) {
                lbl_totfaena.setText(String.valueOf(rs.getInt("sum(qty)")));
             }
        } catch (SQLException ex) {
            Logger.getLogger(VeoContador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_totxfrmMouseClicked

    private void cmb_granjasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_granjasActionPerformed
        // TODO add your handling code here:
        int id;
        String nombre = cmb_granjas.getSelectedItem().toString();
        id = mpt.GetIDFrm(nombre);
        System.out.println("NOMBRE: "+nombre+"  ID= "+id);
        mpt.SetFrm(id);
        
    }//GEN-LAST:event_cmb_granjasActionPerformed

    private void tbl_granjasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_granjasMouseClicked
        // TODO add your handling code here:
        int row = tbl_granjas.getSelectedRow();
        //ResultSet rs = null;
        //System.out.println("Cajero= " + jtblClrkT.getValueAt(row, 0));
        //this.setVisible(false);
        old_id = mpt.GetIDFrm(tbl_granjas.getValueAt(row, 0).toString()) ;
        System.out.println("VALOR= "+tbl_granjas.getValueAt(row, 0)+"  ID= "+old_id);
    }//GEN-LAST:event_tbl_granjasMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws InterruptedException {
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
            java.util.logging.Logger.getLogger(VeoContador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VeoContador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VeoContador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VeoContador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VeoContador().setVisible(true);
            }
        });
        
        SimpleDateFormat ymd = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat dmy = new SimpleDateFormat("dd/MM/yyyy");
        String fecha_hoy, query, fecha;
        Date date = new Date();
        fecha_hoy = ymd.format(date);
        
        int cont;
        cont = mpt.SumaDia(fecha_hoy);
        Thread.sleep(1000);
        lbl_counter.setText(String.valueOf(cont));
        
        while(true){
            date = new Date();
            fecha_hoy = ymd.format(date);
            fecha = dmy.format(date);
            cont = mpt.SumaDia(fecha_hoy);
            lbl_counter.setText(String.valueOf(cont));
            
                Thread.sleep(1000);
            
        }
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_totxfrm;
    private javax.swing.JComboBox cmb_granjas;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JLabel lbl_counter;
    private javax.swing.JLabel lbl_totfaena;
    private javax.swing.JTable tbl_granjas;
    // End of variables declaration//GEN-END:variables
}
