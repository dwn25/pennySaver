package com.Pages;

import com.Support.Constant;
import java.text.NumberFormat;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.Format;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

/**
 *
 * @author DNartey
 */
public class FIrstEnterInfoPage extends javax.swing.JFrame {
    /**
     * Creates new form ReturningUserPage
     */
    public FIrstEnterInfoPage() {
        setLocationRelativeTo(null);
        setResizable(false);
        initComponents();
        String text = "\n"
                + "\n"
                + "Thank You for choosing PennySaver. PennySaver is a financial application with"
                + " a variety of services. The services that we offer include:\n" +
                "» Financial Consultancy\n" +
                "» Budgetting\n" +
                "» Stock Tracking\n" +
                "» CryptoCurrency Tracking\n" +
                "» Savings Forecast\n" +
                "In order to proceed, we require some information about your current financial status."
                    + " Please fill out the short form below in order to get started.";
        jTextArea.setText(text);
        jTextArea.setWrapStyleWord(true);
        jTextArea.setLineWrap(true);
        jTextArea.setOpaque(false);
        jTextArea.setEditable(false);
        jTextArea.setFocusable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        formatted = new javax.swing.JFormattedTextField();
        jPanel1 = new javax.swing.JPanel();
        wholePanel = new javax.swing.JPanel();
        SIdeBarPanel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        budgetPanel = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        budgetLabel = new javax.swing.JLabel();
        pageInfoPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea = new javax.swing.JTextArea();
        divider = new javax.swing.JPanel();
        headerPanel = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        dataEntryPanel = new javax.swing.JPanel();
        employmentStatus = new javax.swing.JComboBox<>();
        monthlySavingsField = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        netWorthField = new javax.swing.JTextField();
        nextBtn = new javax.swing.JButton();
        Cancel = new javax.swing.JButton();
        incomeField = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();

        formatted.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));
        formatted.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formattedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        wholePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SIdeBarPanel.setBackground(new java.awt.Color(29, 45, 68));
        SIdeBarPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/pSsmallLogo.png"))); // NOI18N
        SIdeBarPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 100, 100));

        budgetPanel.setBackground(new java.awt.Color(240, 235, 216));
        budgetPanel.setForeground(new java.awt.Color(63, 64, 76));
        budgetPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                budgetPanelMouseClicked(evt);
            }
        });
        budgetPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel11.setForeground(new java.awt.Color(204, 204, 204));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        budgetPanel.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 40));

        budgetLabel.setBackground(new java.awt.Color(240, 235, 216));
        budgetLabel.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        budgetLabel.setForeground(new java.awt.Color(63, 64, 76));
        budgetLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        budgetLabel.setText("Personal Info");
        budgetLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                budgetLabelMouseClicked(evt);
            }
        });
        budgetPanel.add(budgetLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 110, 40));

        SIdeBarPanel.add(budgetPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 120, 40));

        wholePanel.add(SIdeBarPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 550));

        pageInfoPanel.setBackground(new java.awt.Color(240, 235, 216));
        pageInfoPanel.setForeground(new java.awt.Color(255, 255, 255));
        pageInfoPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextArea.setEditable(false);
        jTextArea.setBackground(new java.awt.Color(240, 235, 216));
        jTextArea.setColumns(20);
        jTextArea.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jTextArea.setForeground(new java.awt.Color(63, 64, 76));
        jTextArea.setRows(5);
        jTextArea.setBorder(null);
        jScrollPane2.setViewportView(jTextArea);

        pageInfoPanel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 440));

        divider.setBackground(new java.awt.Color(29, 45, 68));

        javax.swing.GroupLayout dividerLayout = new javax.swing.GroupLayout(divider);
        divider.setLayout(dividerLayout);
        dividerLayout.setHorizontalGroup(
            dividerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 27, Short.MAX_VALUE)
        );
        dividerLayout.setVerticalGroup(
            dividerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pageInfoPanel.add(divider, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        wholePanel.add(pageInfoPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 330, 440));

        headerPanel.setBackground(new java.awt.Color(91, 139, 151));

        jLabel9.setBackground(new java.awt.Color(32, 33, 35));
        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Welcome to PennySavers");

        jLabel10.setBackground(new java.awt.Color(32, 33, 35));
        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Please enter your details below");

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE))
                .addContainerGap())
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addContainerGap())
        );

        wholePanel.add(headerPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 620, 100));

        dataEntryPanel.setBackground(new java.awt.Color(240, 235, 216));
        dataEntryPanel.setForeground(new java.awt.Color(255, 255, 255));

        employmentStatus.setBackground(new java.awt.Color(240, 235, 216));
        employmentStatus.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        employmentStatus.setForeground(new java.awt.Color(63, 64, 76));
        employmentStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Unemployed", "Student", "Employed Part Time", "Employed Full TIme", "Self-Employed" }));
        employmentStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employmentStatusActionPerformed(evt);
            }
        });

        monthlySavingsField.setBackground(new java.awt.Color(240, 235, 216));
        monthlySavingsField.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        monthlySavingsField.setForeground(new java.awt.Color(63, 64, 76));
        monthlySavingsField.setBorder(null);
        monthlySavingsField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthlySavingsFieldActionPerformed(evt);
            }
        });

        jLabel19.setBackground(new java.awt.Color(240, 235, 216));
        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(63, 64, 76));
        jLabel19.setText("Amount Willing to Save Every Month:");

        jLabel7.setBackground(new java.awt.Color(240, 235, 216));
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(63, 64, 76));
        jLabel7.setText("Net Worth:");

        jLabel8.setBackground(new java.awt.Color(240, 235, 216));
        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(63, 64, 76));
        jLabel8.setText("Employment Status:");

        netWorthField.setBackground(new java.awt.Color(240, 235, 216));
        netWorthField.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        netWorthField.setForeground(new java.awt.Color(63, 64, 76));
        netWorthField.setBorder(null);
        netWorthField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                netWorthFieldActionPerformed(evt);
            }
        });

        nextBtn.setBackground(new java.awt.Color(63, 64, 76));
        nextBtn.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        nextBtn.setForeground(new java.awt.Color(255, 255, 255));
        nextBtn.setText("Next");
        nextBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextBtnActionPerformed(evt);
            }
        });

        Cancel.setBackground(new java.awt.Color(63, 64, 76));
        Cancel.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        Cancel.setForeground(new java.awt.Color(255, 255, 255));
        Cancel.setText("Cancel");
        Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelActionPerformed(evt);
            }
        });

        incomeField.setBackground(new java.awt.Color(240, 235, 216));
        incomeField.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        incomeField.setForeground(new java.awt.Color(63, 64, 76));
        incomeField.setBorder(null);
        incomeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                incomeFieldActionPerformed(evt);
            }
        });

        jLabel18.setBackground(new java.awt.Color(240, 235, 216));
        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(63, 64, 76));
        jLabel18.setText("Monhtly Take Home Income:");

        jSeparator1.setBackground(new java.awt.Color(29, 45, 68));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator2.setBackground(new java.awt.Color(29, 45, 68));
        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator3.setBackground(new java.awt.Color(29, 45, 68));
        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator4.setBackground(new java.awt.Color(29, 45, 68));
        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout dataEntryPanelLayout = new javax.swing.GroupLayout(dataEntryPanel);
        dataEntryPanel.setLayout(dataEntryPanelLayout);
        dataEntryPanelLayout.setHorizontalGroup(
            dataEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataEntryPanelLayout.createSequentialGroup()
                .addGroup(dataEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nextBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(dataEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(dataEntryPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(monthlySavingsField, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, dataEntryPanelLayout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addGroup(dataEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(dataEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19)
                                    .addGroup(dataEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                                        .addComponent(netWorthField, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addGroup(dataEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(incomeField, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(employmentStatus, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)))))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        dataEntryPanelLayout.setVerticalGroup(
            dataEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataEntryPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(netWorthField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(employmentStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(incomeField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(monthlySavingsField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nextBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Cancel)
                .addContainerGap(64, Short.MAX_VALUE))
        );

        wholePanel.add(dataEntryPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, -1, 450));

        getContentPane().add(wholePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(-7, 0, 740, 540));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void netWorthFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_netWorthFieldActionPerformed
     
    }//GEN-LAST:event_netWorthFieldActionPerformed

    
    private void nextBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextBtnActionPerformed
        Constant.DoConnect();
        double netWorth=0, monthlyIncome=0, monthlySavings=0;
        try{
            try{
                String nw = netWorthField.getText();
                String income = incomeField.getText();
                String mS = monthlySavingsField.getText();
                if(nw.isEmpty()){
                    JOptionPane.showMessageDialog(rootPane, "Net Worth Cannot Be Empty");
                }
                else if(mS.isEmpty()){
                    JOptionPane.showMessageDialog(rootPane, "Monthly Savings Cannot Be Empty"); 
                }
                else if(income.isEmpty()){
                    JOptionPane.showMessageDialog(rootPane, "Income Cannot Be Empty");
                }
                else {
                    netWorth = Double.parseDouble(netWorthField.getText());
                    monthlySavings = Double.parseDouble(monthlySavingsField.getText());
                    monthlyIncome = Double.parseDouble(incomeField.getText());   
                    Object obj = employmentStatus.getSelectedItem();
                    String status = obj.toString();
                    System.out.println(status);
                    System.out.println(netWorth);
                    System.out.println(monthlyIncome);
                    System.out.println(monthlySavings);
                    String sql = ("UPDATE ROOT.PUSERS SET employment_status = ?, net_income = ?, net_worth = ?, monthly_savings = ? WHERE username= ?");
                    PreparedStatement statement = Constant.con.prepareStatement(sql);
                    statement.setString(1, status);
                    statement.setDouble(2, monthlyIncome);
                    statement.setDouble(3, netWorth);
                    statement.setDouble(4, monthlySavings);
                    statement.setString(5, Constant.currentUser);
                    int rowsInserted = statement.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Data Save Succesful");
                    StocksQuestionPage sQ = new StocksQuestionPage();
                    sQ.setLocationRelativeTo(null);
                    sQ.setVisible(true);
                    this.hide();
                }      
            }catch(Exception err){
                System.out.println(err.toString());
                JOptionPane.showMessageDialog(rootPane, "INCORRECT!! Please try again");
            }
        }catch(NumberFormatException err){
            JOptionPane.showMessageDialog(rootPane, "INCORRECT!! Please try again");
        }
    }//GEN-LAST:event_nextBtnActionPerformed

    private void CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelActionPerformed
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure you want to leave without saving","Warning",dialogButton);
        if(dialogResult == JOptionPane.YES_OPTION){
            Main m = new Main();
            m.setVisible(true);
            this.hide();
        }
    }//GEN-LAST:event_CancelActionPerformed

    private void incomeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_incomeFieldActionPerformed
    }//GEN-LAST:event_incomeFieldActionPerformed

    private void monthlySavingsFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthlySavingsFieldActionPerformed
    }//GEN-LAST:event_monthlySavingsFieldActionPerformed

    private void employmentStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employmentStatusActionPerformed
    }//GEN-LAST:event_employmentStatusActionPerformed

    private void formattedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formattedActionPerformed
    }//GEN-LAST:event_formattedActionPerformed

    private void budgetLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_budgetLabelMouseClicked
        BudgetInfoPage m = new BudgetInfoPage();
        m.setLocationRelativeTo(null);
        m.setVisible(true);
        this.hide();
    }//GEN-LAST:event_budgetLabelMouseClicked

    private void budgetPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_budgetPanelMouseClicked
        BudgetInfoPage m = new BudgetInfoPage();
        m.setLocationRelativeTo(null);
        m.setVisible(true);
        this.hide();
    }//GEN-LAST:event_budgetPanelMouseClicked

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
            java.util.logging.Logger.getLogger(FIrstEnterInfoPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FIrstEnterInfoPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FIrstEnterInfoPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FIrstEnterInfoPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FIrstEnterInfoPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancel;
    private javax.swing.JPanel SIdeBarPanel;
    private javax.swing.JLabel budgetLabel;
    private javax.swing.JPanel budgetPanel;
    private javax.swing.JPanel dataEntryPanel;
    private javax.swing.JPanel divider;
    private javax.swing.JComboBox<String> employmentStatus;
    private javax.swing.JFormattedTextField formatted;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JTextField incomeField;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextArea jTextArea;
    private javax.swing.JTextField monthlySavingsField;
    private javax.swing.JTextField netWorthField;
    private javax.swing.JButton nextBtn;
    private javax.swing.JPanel pageInfoPanel;
    private javax.swing.JPanel wholePanel;
    // End of variables declaration//GEN-END:variables
}
