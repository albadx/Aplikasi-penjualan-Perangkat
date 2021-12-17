/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author xyz
 */
public final class Supplier extends javax.swing.JFrame {

    Koneksi conn;
    public Menu menu = null;

    public Supplier() {
        initComponents();
        setLocationRelativeTo(null);
        conn = new Koneksi();
        conn.koneksiDB();
        
        AUTONUMBER();
        jTextField1.setEditable(false);

        edit.setEnabled(false);
        hapus.setEnabled(false);
        tampildata();
    }

    public void simpan() {
        try {
            String a = jTextField1.getText();
            String b = jTextField2.getText();
            String c = jTextField3.getText();
            String d = jTextField4.getText();

            String sql = "insert into supplier values ('" + a + "','" + b + "','" + c + "','" + d + "')";
            conn.sn.executeUpdate(sql);
            {
                JOptionPane.showMessageDialog(null, "data berhasil tersimpan");
            }
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "data gagal tersimpan");
            System.out.println(e.getMessage());
        }
        bersih();
        tampildata();
    }

    public void edit() {
        try {
            String a = jTextField1.getText();
            String b = jTextField2.getText();
            String c = jTextField3.getText();
            String d = jTextField4.getText();

            String sql = "update supplier set nama='" + b + "',"
                    + "telp    ='" + c + "',"
                    + "alamat    ='" + d + "'"
                    + "where id ='" + a + "'";

            conn.sn.execute(sql);
            {
                JOptionPane.showMessageDialog(null, "data berhasil terupdate");
            }
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "data gagal terupdate");
            System.out.println(e.getMessage());
        }
        bersih();
        tampildata();
    }

    public void hapus() {
        try {
            String sql = "delete from supplier where id ='" + jTextField1.getText() + "'";
            conn.sn.execute(sql);
            {
                JOptionPane.showMessageDialog(null, "data berhasil terhapus");
            }

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "data gagal terhapus");
            System.out.println(e.getMessage());
        }

        bersih();
        tampildata();
    }

    public void bersih() {
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        AUTONUMBER();

        tampildata();
        simpan.setEnabled(true);
        hapus.setEnabled(false);
        edit.setEnabled(false);
    }

    public void tampildata() {
        DefaultTableModel tabelnyo = new DefaultTableModel();
        tabelnyo.addColumn("Id Supplier");
        tabelnyo.addColumn("Nama Supplier");
        tabelnyo.addColumn("Telp");
        tabelnyo.addColumn("Alamat");
        
        try {
            conn.sn = conn.cn.createStatement();
            String sql = "Select * from supplier order by id asc";
            ResultSet rs = conn.sn.executeQuery(sql);
            while (rs.next()) {
                tabelnyo.addRow(new Object[]{
                            rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4)});
            }
            jTable1.setModel(tabelnyo);
            
            new Tabel().Kolom(jTable1);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ada Kesalahan");
        }
    }
    
    public void AUTONUMBER() {
        try {
            //--> melakukan eksekusi query untuk mengambil data dari tabel
            String sql = "SELECT MAX(RIGHT(id,2)) AS NO FROM supplier";
            Statement st = conn.cn.createStatement();
            ResultSet rsjual = st.executeQuery(sql);
            while (rsjual.next()) {
                if (rsjual.first() == false) {
                    jTextField1.setText("SUP01");
                } else {
                    rsjual.last();
                    int auto_id = rsjual.getInt(1) + 1;
                    String no = String.valueOf(auto_id);
                    int NomorJual = no.length();
                    //MENGATUR jumlah 0
                    for (int j = 0; j < 2 - NomorJual; j++) {
                        no = "0" + no;
                    }
                    jTextField1.setText("SUP" + no);
                }
            }
            rsjual.close();
            st.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "ERROR: \n" + e.toString(),
                    "Kesalahan", JOptionPane.WARNING_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        simpan = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Supplier");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setText("Kode Supplier ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("Nama Supplier");

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

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
        simpan.setText("Simpan");
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });

        edit.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        edit.setText("Ubah");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        hapus.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        hapus.setText("Hapus");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton4.setText("Batal");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setText("Telp/Hp");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setText("Alamat");

        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        jLabel7.setForeground(new java.awt.Color(153, 0, 0));
        jLabel7.setText("* kode otomatis");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7))
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 30, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(simpan)
                .addGap(18, 18, 18)
                .addComponent(edit)
                .addGap(18, 18, 18)
                .addComponent(hapus)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addGap(93, 93, 93))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {edit, hapus, jButton4, simpan});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(simpan)
                    .addComponent(edit)
                    .addComponent(hapus)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        try {
            int index = jTable1.getSelectedRow();
            TableModel model = jTable1.getModel();

            String a = model.getValueAt(index, 0).toString();
            String b = model.getValueAt(index, 1).toString();
            String c = model.getValueAt(index, 2).toString();
            String d = model.getValueAt(index, 3).toString();

            jTextField1.setText(a);
            jTextField2.setText(b);
            jTextField3.setText(c);
            jTextField4.setText(d);
            simpan.setEnabled(false);
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan " + e.getMessage());
        }
        edit.setEnabled(true);
        hapus.setEnabled(true);
    }//GEN-LAST:event_jTable1MouseClicked

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        simpan();
    }//GEN-LAST:event_simpanActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        edit();
    }//GEN-LAST:event_editActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        hapus();
    }//GEN-LAST:event_hapusActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        bersih();
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Supplier().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton edit;
    private javax.swing.JButton hapus;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JButton simpan;
    // End of variables declaration//GEN-END:variables
}
