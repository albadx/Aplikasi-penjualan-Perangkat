package Main;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;
import javax.swing.UIManager;

public class ProgressBar extends javax.swing.JFrame {

    public ProgressBar() {
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (dim.width - getWidth()) / 2;
        int y = (dim.height - getHeight()) / 2;
        setLocation(x, y);


        jProgressBar1.setStringPainted(true);
    }

    public JProgressBar getProgressBar() {
        return jProgressBar1;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jLabel1.setFont(new java.awt.Font("Vijaya", 0, 14)); // NOI18N
        jLabel1.setText("Loading  . . .  Please Wait  .  . .");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            com.jtattoo.plaf.aluminium.AluminiumLookAndFeel.setTheme(
                    "Large-Font", "", "");
            UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
            ProgressBar pb = new ProgressBar();
            pb.setVisible(true);

            for (int i = 0; i <= 80; i++) {
                try {
                    pb.getProgressBar().setValue(i);
                    Thread.sleep(80); //lamanya progressBar berjalan
                } catch (InterruptedException ex) {
                    Logger.getLogger(ProgressBar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            pb.dispose();
            Login fl = new Login(); //habis ini berjalan langsung ke form login
            fl.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables
}
