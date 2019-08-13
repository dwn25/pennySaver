package com.Pages.AskQuestionPage;


import com.Pages.EnterDataPages.EnterSavingsPage;
import com.Pages.Main.NoUseMain;
import com.Pages.MainMenu.MainMenu;
import com.Support.Constant;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DNartey
 */
public class SavingsQuestionPage extends javax.swing.JFrame {

    /**
     * Creates new form SavingsQuestionPage
     */
    public SavingsQuestionPage() {
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
        jLabel1 = new javax.swing.JLabel();
        yesBtn = new javax.swing.JButton();
        NoBtn1 = new javax.swing.JButton();

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

        jLabel1.setBackground(new java.awt.Color(34, 47, 66));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(63, 64, 76));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Would you like to see your Savings Forecast?");
        wholePanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 440, -1));

        yesBtn.setBackground(new java.awt.Color(34, 47, 66));
        yesBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        yesBtn.setForeground(new java.awt.Color(255, 255, 255));
        yesBtn.setText("Yes");
        yesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yesBtnActionPerformed(evt);
            }
        });
        wholePanel.add(yesBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 170, -1));

        NoBtn1.setBackground(new java.awt.Color(34, 47, 66));
        NoBtn1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        NoBtn1.setForeground(new java.awt.Color(255, 255, 255));
        NoBtn1.setText("No");
        NoBtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NoBtn1MouseClicked(evt);
            }
        });
        NoBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoBtn1ActionPerformed(evt);
            }
        });
        wholePanel.add(NoBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 170, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(wholePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(wholePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void NoBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoBtn1ActionPerformed
    }//GEN-LAST:event_NoBtn1ActionPerformed

    private void yesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yesBtnActionPerformed
        Constant.hasSavings = true;
        EnterSavingsPage m = new EnterSavingsPage();
        m.setLocationRelativeTo(null);
        m.setVisible(true);
        this.hide();
    }//GEN-LAST:event_yesBtnActionPerformed

    private void NoBtn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NoBtn1MouseClicked
        Constant.hasSavings = false;
        System.out.println("Savings " + Constant.hasSavings);
        if(Constant.hasStocks && Constant.hasCrypto && Constant.hasBudget && Constant.hasSavings){
            MainMenu m = new MainMenu();
            m.setVisible(true);
            this.hide();
        }else{
            NoUseMain  m = new NoUseMain();
            m.setVisible(true);
            this.hide();
        }
    }//GEN-LAST:event_NoBtn1MouseClicked

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
            java.util.logging.Logger.getLogger(SavingsQuestionPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SavingsQuestionPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SavingsQuestionPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SavingsQuestionPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SavingsQuestionPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton NoBtn1;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel questionPanel;
    private javax.swing.JPanel wholePanel;
    private javax.swing.JButton yesBtn;
    // End of variables declaration//GEN-END:variables
}
