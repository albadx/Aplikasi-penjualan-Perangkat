/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author xyz
 */
public final class ReturPembelian extends javax.swing.JFrame {

    Koneksi conn;
    public Menu menu = null;
    String tanggal;
    private Object tabel;

    public ReturPembelian() {
        initComponents();
        setLocationRelativeTo(null);
        conn = new Koneksi();
        conn.koneksiDB();
        jTextField1.setEditable(false);

        TampilComboJenis();
        TampilComboSupplier();
        jTable1.setModel(tableModel);
        Tabel(jTable1, new int[]{105, 300, 300, 90, });
        AUTONUMBER();
        
        Total.setText("0");
    }
    private javax.swing.table.DefaultTableModel tableModel = getDefaultTabelModel();

    private void Tabel(javax.swing.JTable tb, int lebar[]) {
        tb.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        int kolom = tb.getColumnCount();
        for (int i = 0; i < kolom; i++) {
            javax.swing.table.TableColumn tbc = tb.getColumnModel().getColumn(i);
            tbc.setPreferredWidth(lebar[i]);
            tb.setRowHeight(17);
        }
    }

    private javax.swing.table.DefaultTableModel getDefaultTabelModel() {
        return new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{"Kode Barang", "Nama Barang", "Keterangan", "Jumlah"}) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
    }

    public void bersihDetail() {
        jTextField3.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
        jComboBox2.setSelectedIndex(0);
    }

    public void bersih() {
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
        jComboBox1.setSelectedIndex(0);
        jComboBox2.setSelectedIndex(0);
        Total.setText("0");
        Tanggaldate2.setDate(null);
        tableModel.setRowCount(0);
        AUTONUMBER();
    }

    public void TampilComboJenis() {
        try {
            Statement stt = conn.cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String SQL = "SELECT * FROM barang";
            ResultSet res = stt.executeQuery(SQL);
            while (res.next()) {
                jComboBox2.addItem(res.getString("id"));
            }
        } catch (SQLException ex) {
        }
    }

    public void TampilComboSupplier() {
        try {
            Statement stt = conn.cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String SQL = "SELECT * FROM supplier";
            ResultSet res = stt.executeQuery(SQL);
            while (res.next()) {
                jComboBox1.addItem(res.getString("id"));
            }
        } catch (SQLException ex) {
        }
    }

    public void AUTONUMBER() {
        try {
            //--> melakukan eksekusi query untuk mengambil data dari tabel
            String sql = "SELECT MAX(RIGHT(id,2)) AS NO FROM retur";
            Statement st = conn.cn.createStatement();
            ResultSet rsjual = st.executeQuery(sql);
            while (rsjual.next()) {
                if (rsjual.first() == false) {
                    jTextField1.setText("RET01");
                } else {
                    rsjual.last();
                    int auto_id = rsjual.getInt(1) + 1;
                    String no = String.valueOf(auto_id);
                    int NomorJual = no.length();
                    //MENGATUR jumlah 0
                    for (int j = 0; j < 2 - NomorJual; j++) {
                        no = "0" + no;
                    }
                    jTextField1.setText("RET" + no);
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
        Tambah = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Tanggaldate2 = new com.toedter.calendar.JDateChooser();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        Total = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Retur Pembelian");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setText("No. Retur");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("Kode Supplier");

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
        simpan.setText("Simpan Transaksi");
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });

        Tambah.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        Tambah.setText("Tambah");
        Tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TambahActionPerformed(evt);
            }
        });

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setText("Nama Supplier");

        jLabel7.setForeground(new java.awt.Color(153, 0, 0));
        jLabel7.setText("* kode otomatis");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel9.setText("Tanggal Retur");

        Tanggaldate2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Tanggaldate2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                Tanggaldate2PropertyChange(evt);
            }
        });

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "- Pilih -" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Kode Barang");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Nama Barang");

        jComboBox2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "- Pilih -" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel12.setText("Keterangan");

        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel13.setText("Jumlah");

        jTextField6.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jTextField6.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTextField6CaretUpdate(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("Total Barang");

        Total.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Total.setEnabled(false);
        Total.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                TotalCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(simpan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Tambah)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Tanggaldate2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(29, 29, 29)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26))))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {Tambah, simpan});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)
                        .addComponent(jLabel9))
                    .addComponent(Tanggaldate2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Tambah)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(simpan))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
    }//GEN-LAST:event_jTable1MouseClicked

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        String sql = "";
        try {
            String a = jTextField1.getText();
            String b = tanggal;
            String c = jComboBox1.getSelectedItem().toString();
            String e = Total.getText();

            sql = "insert into retur values ('" + a + "','" + b + "','" + c + "','" + e + "')";
            conn.sn.executeUpdate(sql);
            {
                JOptionPane.showMessageDialog(null, "data berhasil tersimpan");
            }
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "data gagal tersimpan");
            System.out.println(e.getMessage() + " sql: " + sql);
        }
        bersih();
    }//GEN-LAST:event_simpanActionPerformed

    private void TambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TambahActionPerformed
        String NM = jTextField1.getText();
        String KB = jComboBox2.getSelectedItem().toString();
        String JM = jTextField6.getText();
        if ((NM.isEmpty()) | (KB.isEmpty()) | (JM.isEmpty())) {
            JOptionPane.showMessageDialog(null, "data tidak boleh kosong, silahkan dilengkapi");
            jComboBox2.requestFocus();
        } else {
            try {
                String a = jTextField1.getText();
                String b = jComboBox2.getSelectedItem().toString();
                String c = jTextField6.getText();
                String e = jTextField5.getText();

                String sql = "insert into detail_retur values ('" + a + "','" + b + "','" + c + "','" + e + "')";
                conn.sn.executeUpdate(sql);
                String sql1 = "Update barang Set stok=stok - '" + jTextField6.getText() + "'"
                        + "Where id='" + jComboBox2.getSelectedItem().toString() + "'";
                conn.sn.executeUpdate(sql1);
                String data[] = new String[4];
                data[0] = jComboBox2.getSelectedItem().toString();
                data[1] = jTextField3.getText();
                data[2] = jTextField5.getText();
                data[3] = jTextField6.getText();
                tableModel.insertRow(0, data);
                jComboBox1.requestFocus();
                Tambah.setEnabled(false);

                bersihDetail();

            } catch (SQLException | HeadlessException e) {
                System.out.println(e.getMessage());
            }
        }

    }//GEN-LAST:event_TambahActionPerformed

    private void Tanggaldate2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_Tanggaldate2PropertyChange
        if (Tanggaldate2.getDate() != null) {
            SimpleDateFormat Format = new SimpleDateFormat("yyyy-MM-dd");
            tanggal = Format.format(Tanggaldate2.getDate());
        }
    }//GEN-LAST:event_Tanggaldate2PropertyChange

    private void TotalCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_TotalCaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_TotalCaretUpdate

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        try {
            Statement stt = conn.cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String SQL = "SELECT * FROM barang where id='" + jComboBox2.getSelectedItem().toString() + "'";
            ResultSet res = stt.executeQuery(SQL);
            res.absolute(1);
            jTextField3.setText(res.getString("nama"));
        } catch (SQLException ex) {
        }
        jTextField6.requestFocus();
        Tambah.setEnabled(true);
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        try {
            Statement stt = conn.cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String SQL = "SELECT * FROM supplier where id='" + jComboBox1.getSelectedItem().toString() + "'";
            ResultSet res = stt.executeQuery(SQL);
            res.absolute(1);
            jTextField2.setText(res.getString("nama"));
        } catch (SQLException ex) {
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTextField6CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jTextField6CaretUpdate
        try {
            int d, ew = 0;
            d = Integer.parseInt(jTextField6.getText());
            ew = Integer.parseInt(Total.getText());
            ew = ew + d;
            Total.setText(String.valueOf(ew));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jTextField6CaretUpdate

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
            java.util.logging.Logger.getLogger(ReturPembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ReturPembelian().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Tambah;
    private com.toedter.calendar.JDateChooser Tanggaldate2;
    private javax.swing.JTextField Total;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JButton simpan;
    // End of variables declaration//GEN-END:variables
}
