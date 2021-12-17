/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author xyz
 */
public final class MasterRetur extends javax.swing.JFrame {

    Koneksi conn;
    public Menu menu = null;

    public MasterRetur() {
        initComponents();
        setLocationRelativeTo(null);
        conn = new Koneksi();
        conn.koneksiDB();
        tampildata();
    }

    public void tampildata() {
        DefaultTableModel tabelnyo = new DefaultTableModel();
        tabelnyo.addColumn("No Retur");
        tabelnyo.addColumn("Tanggal Retur");
        tabelnyo.addColumn("Supplier");
        tabelnyo.addColumn("Kode Barang");
        tabelnyo.addColumn("Jumlah");
        tabelnyo.addColumn("Keterangan");

        try {
            conn.sn = conn.cn.createStatement();
            String sql = "SELECT p.`id`, p.`tglretur`,s.nama, d.`kodebarang`, d.`jumlah`, d.`keterangan` "
                    + "FROM retur p "
                    + "INNER JOIN supplier s "
                    + "ON p.`idsup` = s.`id` "
                    + "LEFT JOIN detail_retur d "
                    + "ON p.`id` = d.`id` "
                    + "ORDER BY p.`tglretur` DESC";
            ResultSet rs = conn.sn.executeQuery(sql);
            while (rs.next()) {
                tabelnyo.addRow(new Object[]{
                            rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6)});
            }
            jTable1.setModel(tabelnyo);

            new Tabel().Kolom(jTable1);
            JTable tabel = new JTable(tabelnyo);
            JScrollPane pane = new JScrollPane(tabel, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ada Kesalahan");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        simpan = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Master Retur Pembelian");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setText("Cari Berdasarkan no retur/ nama supplier");

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        simpan.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        simpan.setText("cari");
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel1)
                        .addGap(35, 35, 35)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(simpan)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(simpan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        DefaultTableModel tabelnyo = new DefaultTableModel();
        tabelnyo.addColumn("No Retur");
        tabelnyo.addColumn("Tanggal Retur");
        tabelnyo.addColumn("Supplier");
        tabelnyo.addColumn("Kode Barang");
        tabelnyo.addColumn("Jumlah");
        tabelnyo.addColumn("Keterangan");

        try {
            conn.sn = conn.cn.createStatement();
            String sql = "SELECT p.`id`, p.`tglretur`,s.nama, d.`kodebarang`, d.`jumlah`, d.`keterangan` "
                    + "FROM retur p "
                    + "INNER JOIN supplier s "
                    + "ON p.`idsup` = s.`id` "
                    + "LEFT JOIN detail_retur d "
                    + "ON p.`id` = d.`id` "
                    + "WHERE p.id like '%" + jTextField1.getText() + "%' "
                    + "OR s.nama like '%" + jTextField1.getText() + "%'"
                    + "ORDER BY p.`tglretur` DESC";
            ResultSet rs = conn.sn.executeQuery(sql);
            while (rs.next()) {
                tabelnyo.addRow(new Object[]{
                            rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6)});
            }
            jTable1.setModel(tabelnyo);

            new Tabel().Kolom(jTable1);
            JTable tabel = new JTable(tabelnyo);
            JScrollPane pane = new JScrollPane(tabel, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ada Kesalahan");
        }
    }//GEN-LAST:event_simpanActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MasterRetur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MasterRetur().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton simpan;
    // End of variables declaration//GEN-END:variables
}
