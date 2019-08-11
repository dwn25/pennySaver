package com.Pages;

import com.Support.Constant;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Base64;
import javax.swing.JOptionPane;

/**
 *
 * @author DNartey
 */
public class MainMenu extends javax.swing.JFrame {
    /**
     * Creates new form MainMenu
     */
    public MainMenu() {
        setResizable(false);
        initComponents();
        setLocationRelativeTo(null);
        onRun();
    }
    
    

    public void getField(javax.swing.JLabel label1, String column){
        try{
            String SQL= "SELECT " + column +" From ROOT.PUSERS WHERE username= '"+Constant.currentUser+"'";    
            ResultSet rs = Constant.stmt.executeQuery(SQL);
            if(rs.next()){
                String val = rs.getString(column);
                label1.setText("$ " + val);
                }
            else{
                JOptionPane.showMessageDialog(rootPane, "Unable To Find Value");
            } 
        }catch(SQLException err){
        System.out.println("Unable to fetch "+ column);
        }        
    }
    
   public void getFieldString(javax.swing.JLabel label1, String column){
        try{
            String SQL= "SELECT " + column +" From ROOT.PUSERS WHERE username= '"+Constant.currentUser+"'";    
            ResultSet rs = Constant.stmt.executeQuery(SQL);
            if(rs.next()){
                String val = rs.getString(column);
                label1.setText(val);
                }
            else{
                JOptionPane.showMessageDialog(rootPane, "Unable To Find Value");
            } 
        }catch(SQLException err){
        System.out.println("Unable to fetch "+ column);
        }        
    }

    public void onRun(){
        Constant.DoConnect();
        getFieldString(firstName,"firstname");
        getField(netWorthLabel,"net_worth");
        getFieldString(employmentStatusLabel,"employment_status");
        getField(takeHomeIncomeLabel,"net_income");
        getField(amountLabel,"monthly_savings");
    }
       
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        WholePanel = new javax.swing.JPanel();
        SIdeBarPanel = new javax.swing.JPanel();
        budgetPanel = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        budgetLabel = new javax.swing.JLabel();
        savingsPanel = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        savingsLabel = new javax.swing.JLabel();
        editInfoPanel = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        editInfoLabel = new javax.swing.JLabel();
        stocksPanel1 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        stocksLabel = new javax.swing.JLabel();
        CryptoPanel = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        cryptoLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        InfoPanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        netWorthLabel = new javax.swing.JLabel();
        employmentStatusLabel = new javax.swing.JLabel();
        takeHomeIncomeLabel = new javax.swing.JLabel();
        amountLabel = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        totalAmount = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        headerPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        firstName = new javax.swing.JLabel();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        WholePanel.setBackground(new java.awt.Color(91, 139, 151));
        WholePanel.setForeground(new java.awt.Color(255, 255, 255));
        WholePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SIdeBarPanel.setBackground(new java.awt.Color(29, 45, 68));
        SIdeBarPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        budgetPanel.setBackground(new java.awt.Color(29, 45, 68));
        budgetPanel.setForeground(new java.awt.Color(160, 170, 178));
        budgetPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                budgetPanelMouseClicked(evt);
            }
        });
        budgetPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel11.setForeground(new java.awt.Color(204, 204, 204));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        budgetPanel.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 40));

        budgetLabel.setBackground(new java.awt.Color(41, 57, 80));
        budgetLabel.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        budgetLabel.setForeground(new java.awt.Color(255, 255, 255));
        budgetLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        budgetLabel.setText("Budget  ");
        budgetLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                budgetLabelMouseClicked(evt);
            }
        });
        budgetPanel.add(budgetLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 40));

        SIdeBarPanel.add(budgetPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 140, 40));

        savingsPanel.setBackground(new java.awt.Color(29, 45, 68));
        savingsPanel.setForeground(new java.awt.Color(160, 170, 178));
        savingsPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                savingsPanelMouseClicked(evt);
            }
        });
        savingsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel15.setForeground(new java.awt.Color(204, 204, 204));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        savingsPanel.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 40));

        savingsLabel.setBackground(new java.awt.Color(41, 57, 80));
        savingsLabel.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        savingsLabel.setForeground(new java.awt.Color(255, 255, 255));
        savingsLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        savingsLabel.setText("Savings");
        savingsLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                savingsLabelMouseClicked(evt);
            }
        });
        savingsPanel.add(savingsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 120, 40));

        SIdeBarPanel.add(savingsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 140, 40));

        editInfoPanel.setBackground(new java.awt.Color(29, 45, 68));
        editInfoPanel.setForeground(new java.awt.Color(160, 170, 178));
        editInfoPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editInfoPanelMouseClicked(evt);
            }
        });
        editInfoPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel16.setForeground(new java.awt.Color(204, 204, 204));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        editInfoPanel.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 40));

        editInfoLabel.setBackground(new java.awt.Color(41, 57, 80));
        editInfoLabel.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        editInfoLabel.setForeground(new java.awt.Color(255, 255, 255));
        editInfoLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        editInfoLabel.setText("Edit Info");
        editInfoLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editInfoLabelMouseClicked(evt);
            }
        });
        editInfoPanel.add(editInfoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 120, 40));

        SIdeBarPanel.add(editInfoPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 140, 40));

        stocksPanel1.setBackground(new java.awt.Color(29, 45, 68));
        stocksPanel1.setForeground(new java.awt.Color(160, 170, 178));
        stocksPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stocksPanel1MouseClicked(evt);
            }
        });
        stocksPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel17.setForeground(new java.awt.Color(204, 204, 204));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        stocksPanel1.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 40));

        stocksLabel.setBackground(new java.awt.Color(41, 57, 80));
        stocksLabel.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        stocksLabel.setForeground(new java.awt.Color(255, 255, 255));
        stocksLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        stocksLabel.setText("Stocks");
        stocksLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stocksLabelMouseClicked(evt);
            }
        });
        stocksPanel1.add(stocksLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 120, 40));

        SIdeBarPanel.add(stocksPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 140, 40));

        CryptoPanel.setBackground(new java.awt.Color(29, 45, 68));
        CryptoPanel.setForeground(new java.awt.Color(160, 170, 178));
        CryptoPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CryptoPanelMouseClicked(evt);
            }
        });
        CryptoPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel18.setForeground(new java.awt.Color(204, 204, 204));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        CryptoPanel.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 40));

        cryptoLabel.setBackground(new java.awt.Color(41, 57, 80));
        cryptoLabel.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        cryptoLabel.setForeground(new java.awt.Color(255, 255, 255));
        cryptoLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        cryptoLabel.setText("Crypto");
        cryptoLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cryptoLabelMouseClicked(evt);
            }
        });
        CryptoPanel.add(cryptoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 120, 40));

        SIdeBarPanel.add(CryptoPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 140, 40));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/pSsmallLogo.png"))); // NOI18N
        SIdeBarPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        WholePanel.add(SIdeBarPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 4, 135, 470));

        InfoPanel.setBackground(new java.awt.Color(240, 235, 216));

        jLabel7.setBackground(new java.awt.Color(240, 235, 216));
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(63, 64, 76));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Net Worth");

        jLabel20.setBackground(new java.awt.Color(240, 235, 216));
        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(63, 64, 76));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Total Amount");

        netWorthLabel.setBackground(new java.awt.Color(240, 235, 216));
        netWorthLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        netWorthLabel.setForeground(new java.awt.Color(63, 64, 76));
        netWorthLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        employmentStatusLabel.setBackground(new java.awt.Color(240, 235, 216));
        employmentStatusLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        employmentStatusLabel.setForeground(new java.awt.Color(63, 64, 76));
        employmentStatusLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        takeHomeIncomeLabel.setBackground(new java.awt.Color(240, 235, 216));
        takeHomeIncomeLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        takeHomeIncomeLabel.setForeground(new java.awt.Color(63, 64, 76));
        takeHomeIncomeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        amountLabel.setBackground(new java.awt.Color(240, 235, 216));
        amountLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        amountLabel.setForeground(new java.awt.Color(63, 64, 76));
        amountLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel8.setBackground(new java.awt.Color(240, 235, 216));
        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(63, 64, 76));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Employment Status");

        totalAmount.setBackground(new java.awt.Color(240, 235, 216));
        totalAmount.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        totalAmount.setForeground(new java.awt.Color(63, 64, 76));
        totalAmount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel18.setBackground(new java.awt.Color(240, 235, 216));
        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(63, 64, 76));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Monthly Take Home Income");

        jLabel19.setBackground(new java.awt.Color(240, 235, 216));
        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(63, 64, 76));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Amount Willing to Save Every Month");

        javax.swing.GroupLayout InfoPanelLayout = new javax.swing.GroupLayout(InfoPanel);
        InfoPanel.setLayout(InfoPanelLayout);
        InfoPanelLayout.setHorizontalGroup(
            InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InfoPanelLayout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(employmentStatusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(takeHomeIncomeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(netWorthLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(amountLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(totalAmount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        InfoPanelLayout.setVerticalGroup(
            InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InfoPanelLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(netWorthLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(employmentStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(takeHomeIncomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(amountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        WholePanel.add(InfoPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 540, 380));

        headerPanel.setBackground(new java.awt.Color(91, 139, 151));

        jLabel1.setBackground(new java.awt.Color(32, 33, 35));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Welcome back to PennySavers");

        firstName.setBackground(new java.awt.Color(32, 33, 35));
        firstName.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        firstName.setForeground(new java.awt.Color(255, 255, 255));
        firstName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(headerPanelLayout.createSequentialGroup()
                        .addComponent(firstName, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(firstName, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        WholePanel.add(headerPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 520, 80));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(WholePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(WholePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 468, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void budgetPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_budgetPanelMouseClicked
        BudgetInfoPage m = new BudgetInfoPage();
        m.setLocationRelativeTo(null);
        m.setVisible(true);
        this.hide();      
    }//GEN-LAST:event_budgetPanelMouseClicked

    private void savingsPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_savingsPanelMouseClicked
        SavingsInfoPage m = new SavingsInfoPage();
        m.setLocationRelativeTo(null);
        m.setVisible(true);
        this.hide();     
    }//GEN-LAST:event_savingsPanelMouseClicked

    private void stocksPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stocksPanel1MouseClicked
        StocksInfoPage m = new StocksInfoPage();
        m.setLocationRelativeTo(null);
        m.setVisible(true);
        this.hide();     
    }//GEN-LAST:event_stocksPanel1MouseClicked

    private void CryptoPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CryptoPanelMouseClicked
        // TODO add your handling code here:  
        CryptoInfoPage m = new CryptoInfoPage();
        m.setLocationRelativeTo(null);
        m.setVisible(true);
        this.hide();     
    }//GEN-LAST:event_CryptoPanelMouseClicked

    private void editInfoPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editInfoPanelMouseClicked
        EditPersonalInfoPage m = new EditPersonalInfoPage();
        m.setLocationRelativeTo(null);
        m.setVisible(true);
        this.hide(); 
    }//GEN-LAST:event_editInfoPanelMouseClicked

    private void budgetLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_budgetLabelMouseClicked
        BudgetInfoPage m = new BudgetInfoPage();        
        m.setLocationRelativeTo(null);
        m.setVisible(true);
        this.hide(); 
    }//GEN-LAST:event_budgetLabelMouseClicked

    private void savingsLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_savingsLabelMouseClicked
        // TODO add your handling code here:
        SavingsInfoPage m = new SavingsInfoPage();
        m.setLocationRelativeTo(null);
        m.setVisible(true);
        this.hide();  
    }//GEN-LAST:event_savingsLabelMouseClicked

    private void editInfoLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editInfoLabelMouseClicked
        // TODO add your handling code here:
        EditPersonalInfoPage m = new EditPersonalInfoPage();
        m.setLocationRelativeTo(null);
        m.setVisible(true);
        this.hide(); 
    }//GEN-LAST:event_editInfoLabelMouseClicked

    private void stocksLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stocksLabelMouseClicked
        // TODO add your handling code here:
        StocksInfoPage m = new StocksInfoPage();
        m.setLocationRelativeTo(null);
        m.setVisible(true);
        this.hide();  
    }//GEN-LAST:event_stocksLabelMouseClicked

    private void cryptoLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cryptoLabelMouseClicked
        
        CryptoInfoPage m = new CryptoInfoPage();
        m.setLocationRelativeTo(null);
        m.setVisible(true);
        this.hide();   
    }//GEN-LAST:event_cryptoLabelMouseClicked

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
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CryptoPanel;
    private javax.swing.JPanel InfoPanel;
    private javax.swing.JPanel SIdeBarPanel;
    private javax.swing.JPanel WholePanel;
    private javax.swing.JLabel amountLabel;
    private javax.swing.JLabel budgetLabel;
    private javax.swing.JPanel budgetPanel;
    private javax.swing.JLabel cryptoLabel;
    private javax.swing.JLabel editInfoLabel;
    private javax.swing.JPanel editInfoPanel;
    private javax.swing.JLabel employmentStatusLabel;
    private javax.swing.JLabel firstName;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JLabel netWorthLabel;
    private javax.swing.JLabel savingsLabel;
    private javax.swing.JPanel savingsPanel;
    private javax.swing.JLabel stocksLabel;
    private javax.swing.JPanel stocksPanel1;
    private javax.swing.JLabel takeHomeIncomeLabel;
    private javax.swing.JLabel totalAmount;
    // End of variables declaration//GEN-END:variables
}
