package com.Pages.AskQuestionPage;

import com.Pages.EnterDataPages.EnterCryptoPage;
import com.Pages.Main.NoUseMain;
import com.Pages.MainMenu.MainMenu;
import com.Support.Constant;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DNartey
 */
public class CryptoQuestionPage extends javax.swing.JFrame {

    /**
     * Creates new form CryptoQuestionPage
     */
    public CryptoQuestionPage() {
        setLocationRelativeTo(null);
        setResizable(false);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        wholePanel = new javax.swing.JPanel();
        questionPanel = new javax.swing.JPanel();
        headerPanel = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        YEsBtn = new javax.swing.JButton();
        NoBtn2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        wholePanel.setBackground(new java.awt.Color(240, 235, 216));
        wholePanel.setPreferredSize(new java.awt.Dimension(637, 583));
        wholePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        questionPanel.setBackground(new java.awt.Color(240, 235, 216));
        questionPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        wholePanel.add(questionPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, -1, -1));

        headerPanel.setBackground(new java.awt.Color(34, 47, 66));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/pSsmallLogo.png"))); // NOI18N

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGap(163, 163, 163)
                .addComponent(logo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        wholePanel.add(headerPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 100));

        jLabel2.setBackground(new java.awt.Color(34, 47, 66));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(63, 64, 76));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Do you currently own any CyryptoCurrency?");
        wholePanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 440, -1));

        YEsBtn.setBackground(new java.awt.Color(34, 47, 66));
        YEsBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        YEsBtn.setForeground(new java.awt.Color(255, 255, 255));
        YEsBtn.setText("Yes");
        YEsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YEsBtnActionPerformed(evt);
            }
        });
        wholePanel.add(YEsBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 170, -1));

        NoBtn2.setBackground(new java.awt.Color(34, 47, 66));
        NoBtn2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        NoBtn2.setForeground(new java.awt.Color(255, 255, 255));
        NoBtn2.setText("No");
        NoBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoBtn2ActionPerformed(evt);
            }
        });
        wholePanel.add(NoBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, 170, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(wholePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(wholePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void YEsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_YEsBtnActionPerformed
        Constant.hasCrypto = true;
        Constant.DoConnect();
        String sql = ("UPDATE  "+ Constant.dbName + ".PUSERS SET hasCrypto = ? WHERE username= ?");
        PreparedStatement statement;
        try {
            statement = Constant.con.prepareStatement(sql);
            statement.setBoolean(1, true);
            statement.setString(2, Constant.currentUser);
            statement.execute();        
            EnterCryptoPage m = new EnterCryptoPage();
            m.setLocationRelativeTo(null);
            m.setVisible(true);
            this.hide();
               }         
        catch (SQLException ex) {
            Logger.getLogger(StocksQuestionPage.class.getName()).log(Level.SEVERE, null, ex);
        } 
         finally {
            try { Constant.rs.close(); } catch (Exception e) { /* ignored */ }
            try { Constant.stmt.close(); } catch (Exception e) { /* ignored */ }
            try { Constant.con.close(); } catch (Exception e) { /* ignored */ }
        }    
    }//GEN-LAST:event_YEsBtnActionPerformed

    private void NoBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoBtn2ActionPerformed
        Constant.hasCrypto = false;
        Constant.DoConnect();
        String sql = ("UPDATE  "+ Constant.dbName + ".PUSERS SET hasCrypto = ? WHERE username= ?");
        PreparedStatement statement;
        try {
            statement = Constant.con.prepareStatement(sql);
            statement.setBoolean(1, false);
            statement.setString(2, Constant.currentUser);
            statement.execute();     
            if(Constant.hasStocks || Constant.hasCrypto || Constant.hasBudget || Constant.hasSavings){
                MainMenu m = new MainMenu();
                m.setVisible(true);
                this.hide();
            }else{
                NoUseMain  m = new NoUseMain();
                m.setVisible(true);
                this.hide();
            }
               }         
        catch (SQLException ex) {
            Logger.getLogger(StocksQuestionPage.class.getName()).log(Level.SEVERE, null, ex);
        }  
         finally {
            try { Constant.rs.close(); } catch (Exception e) { /* ignored */ }
            try { Constant.stmt.close(); } catch (Exception e) { /* ignored */ }
            try { Constant.con.close(); } catch (Exception e) { /* ignored */ }
        }   
    }//GEN-LAST:event_NoBtn2ActionPerformed

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
            java.util.logging.Logger.getLogger(CryptoQuestionPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CryptoQuestionPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CryptoQuestionPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CryptoQuestionPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CryptoQuestionPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton NoBtn2;
    private javax.swing.JButton YEsBtn;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel questionPanel;
    private javax.swing.JPanel wholePanel;
    // End of variables declaration//GEN-END:variables
}
