package com.Pages.MainMenu;

import com.Pages.Main.Main;
import com.Support.Constant;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
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
            String SQL= "SELECT " + column +" From "+ Constant.tableName + ".PUSERS WHERE username= '"+Constant.currentUser+"'";    
            ResultSet rs = Constant.stmt.executeQuery(SQL);
            if(rs.next()){
                String val = rs.getString(column);
                label1.setText("$ " + val);
                }
            else{
                System.out.println("Unable To Find Value");
            } 
        }catch(SQLException err){
        System.out.println("Unable to fetch "+ column);
        }        
    }
    
   public void getFieldString(javax.swing.JLabel label1, String column){
        try{
            String SQL= "SELECT " + column +" From  "+ Constant.tableName + ".PUSERS WHERE username= '"+Constant.currentUser+"'";    
            ResultSet rs = Constant.stmt.executeQuery(SQL);
            if(rs.next()){
                String val = rs.getString(column);
                label1.setText(val);
                }
            else{
                System.out.println("Unable To Find Value");
            } 
        }catch(SQLException err){
        System.out.println("Unable to fetch "+ column);
        }        
    }

    public void onRun(){
        try{
            Constant.DoConnect();
            getFieldString(firstName,"firstname");
            getField(netWorthLabel,"net_worth");
            getFieldString(employmentStatusLabel,"employment_status");
            getField(takeHomeIncomeLabel,"net_income");
            getField(amountLabel,"monthly_savings");
            menuInit();
        }catch(Exception e){}
        finally {
            try { Constant.rs.close(); } catch (Exception e) { /* ignored */ }
            try { Constant.stmt.close(); } catch (Exception e) { /* ignored */ }
            try { Constant.con.close(); } catch (Exception e) { /* ignored */ }
        }
    }
    
    public void menuInit(){
        try{
            Constant.DoConnect();
            boolean budget, savings, stocks, crypto;
            budget = getMenu("hasbudget");
            savings = getMenu("hasSavings");
            stocks = getMenu("hasStocks");
            crypto = getMenu("hasCrypto");
            /*
            System.out.println(budget);
            System.out.println(savings);
            System.out.println(stocks);
            System.out.println(crypto);
            */
            budgetIcon.setEnabled(budget);
            SavingsIcon.setEnabled(savings);
            StocksIcon.setEnabled(stocks);
            cryptoIcon.setEnabled(crypto);
        }catch(Exception e){
            System.out.println("Unable to fetch Menus");
        }finally {
            try { Constant.rs.close(); } catch (Exception e) { /* ignored */ }
            try { Constant.stmt.close(); } catch (Exception e) { /* ignored */ }
            try { Constant.con.close(); } catch (Exception e) { /* ignored */ }
        }
    }
    
        public boolean getMenu(String column){
        try{
            String SQL= "SELECT "+ column+" From  "+ Constant.tableName + ".PUSERS WHERE username= '"+Constant.currentUser+"'";    
            ResultSet rs = Constant.stmt.executeQuery(SQL);
            if(rs.next()){
                boolean val = rs.getBoolean(column);
                return val;
                }
            else{
                System.out.println("Unable To Find Value");
            } 
        }catch(SQLException err){
        System.out.println("Unable to fetch income");
        }  
        return false;
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
        jLabel4 = new javax.swing.JLabel();
        jToggleButton2 = new javax.swing.JToggleButton();
        budgetIcon = new javax.swing.JButton();
        SavingsIcon = new javax.swing.JButton();
        StocksIcon = new javax.swing.JButton();
        cryptoIcon = new javax.swing.JButton();
        editTextbtn = new javax.swing.JButton();
        logoutBtn = new javax.swing.JButton();
        helpBtn = new javax.swing.JButton();
        InfoPanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        netWorthLabel = new javax.swing.JLabel();
        employmentStatusLabel = new javax.swing.JLabel();
        takeHomeIncomeLabel = new javax.swing.JLabel();
        amountLabel = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
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

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/pSsmallLogo.png"))); // NOI18N
        SIdeBarPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jToggleButton2.setBackground(new java.awt.Color(240, 235, 216));
        jToggleButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/Logos/MenuButtons/MainMenuSelected.jpg"))); // NOI18N
        jToggleButton2.setBorder(null);
        jToggleButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jToggleButton2MouseClicked(evt);
            }
        });
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });
        SIdeBarPanel.add(jToggleButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 140, 50));

        budgetIcon.setBackground(new java.awt.Color(41, 57, 80));
        budgetIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/Logos/MenuButtons/BudgetNormal.jpg"))); // NOI18N
        budgetIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                budgetIconMouseClicked(evt);
            }
        });
        budgetIcon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                budgetIconActionPerformed(evt);
            }
        });
        SIdeBarPanel.add(budgetIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 140, 50));

        SavingsIcon.setBackground(new java.awt.Color(41, 57, 80));
        SavingsIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/Logos/MenuButtons/SavingsNormal.jpg"))); // NOI18N
        SavingsIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SavingsIconMouseClicked(evt);
            }
        });
        SavingsIcon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SavingsIconActionPerformed(evt);
            }
        });
        SIdeBarPanel.add(SavingsIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 140, 50));

        StocksIcon.setBackground(new java.awt.Color(41, 57, 80));
        StocksIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/Logos/MenuButtons/StocksNormal.jpg"))); // NOI18N
        StocksIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                StocksIconMouseClicked(evt);
            }
        });
        StocksIcon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StocksIconActionPerformed(evt);
            }
        });
        SIdeBarPanel.add(StocksIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 140, 50));

        cryptoIcon.setBackground(new java.awt.Color(41, 57, 80));
        cryptoIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/Logos/MenuButtons/CryptoNormal.jpg"))); // NOI18N
        cryptoIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cryptoIconMouseClicked(evt);
            }
        });
        cryptoIcon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cryptoIconActionPerformed(evt);
            }
        });
        SIdeBarPanel.add(cryptoIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 140, 50));

        editTextbtn.setBackground(new java.awt.Color(41, 57, 80));
        editTextbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/Logos/MenuButtons/EditInfoNormal.jpg"))); // NOI18N
        editTextbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editTextbtnMouseClicked(evt);
            }
        });
        editTextbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editTextbtnActionPerformed(evt);
            }
        });
        SIdeBarPanel.add(editTextbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 140, 50));

        logoutBtn.setBackground(new java.awt.Color(41, 57, 80));
        logoutBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/Logos/MenuButtons/logoutBtn.jpg"))); // NOI18N
        logoutBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutBtnMouseClicked(evt);
            }
        });
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });
        SIdeBarPanel.add(logoutBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 140, 50));

        helpBtn.setBackground(new java.awt.Color(41, 57, 80));
        helpBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/Logos/MenuButtons/HelpButtonNormal.jpg"))); // NOI18N
        helpBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                helpBtnMouseClicked(evt);
            }
        });
        helpBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpBtnActionPerformed(evt);
            }
        });
        SIdeBarPanel.add(helpBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 470, 140, 50));

        WholePanel.add(SIdeBarPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 520));

        InfoPanel.setBackground(new java.awt.Color(240, 235, 216));

        jLabel7.setBackground(new java.awt.Color(240, 235, 216));
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(63, 64, 76));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Net Worth");

        netWorthLabel.setBackground(new java.awt.Color(240, 235, 216));
        netWorthLabel.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        netWorthLabel.setForeground(new java.awt.Color(63, 64, 76));
        netWorthLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        employmentStatusLabel.setBackground(new java.awt.Color(240, 235, 216));
        employmentStatusLabel.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        employmentStatusLabel.setForeground(new java.awt.Color(63, 64, 76));
        employmentStatusLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        takeHomeIncomeLabel.setBackground(new java.awt.Color(240, 235, 216));
        takeHomeIncomeLabel.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        takeHomeIncomeLabel.setForeground(new java.awt.Color(63, 64, 76));
        takeHomeIncomeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        amountLabel.setBackground(new java.awt.Color(240, 235, 216));
        amountLabel.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        amountLabel.setForeground(new java.awt.Color(63, 64, 76));
        amountLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel8.setBackground(new java.awt.Color(240, 235, 216));
        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(63, 64, 76));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Employment Status");

        jLabel18.setBackground(new java.awt.Color(240, 235, 216));
        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(63, 64, 76));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Monthly Take Home Income");

        jLabel19.setBackground(new java.awt.Color(240, 235, 216));
        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(63, 64, 76));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Monthly Savings");

        jLabel10.setBackground(new java.awt.Color(240, 235, 216));
        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 32)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(63, 64, 76));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Outline of Current Holdings");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout InfoPanelLayout = new javax.swing.GroupLayout(InfoPanel);
        InfoPanel.setLayout(InfoPanelLayout);
        InfoPanelLayout.setHorizontalGroup(
            InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InfoPanelLayout.createSequentialGroup()
                .addGroup(InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(InfoPanelLayout.createSequentialGroup()
                        .addGroup(InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(InfoPanelLayout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InfoPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(netWorthLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(employmentStatusLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(InfoPanelLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(InfoPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(amountLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                            .addComponent(takeHomeIncomeLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(20, 20, 20))
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
        InfoPanelLayout.setVerticalGroup(
            InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InfoPanelLayout.createSequentialGroup()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(InfoPanelLayout.createSequentialGroup()
                        .addComponent(jSeparator1)
                        .addContainerGap())
                    .addGroup(InfoPanelLayout.createSequentialGroup()
                        .addGroup(InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 26, Short.MAX_VALUE)
                        .addGroup(InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InfoPanelLayout.createSequentialGroup()
                                .addGap(0, 56, Short.MAX_VALUE)
                                .addComponent(takeHomeIncomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(amountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54))
                            .addGroup(InfoPanelLayout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(netWorthLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(employmentStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );

        WholePanel.add(InfoPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 600, 430));

        headerPanel.setBackground(new java.awt.Color(34, 47, 66));

        jLabel1.setBackground(new java.awt.Color(34, 47, 66));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Welcome back to PennySavers");

        firstName.setBackground(new java.awt.Color(34, 47, 66));
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
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
                    .addComponent(firstName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(firstName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        WholePanel.add(headerPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 600, 90));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(WholePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(WholePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton2MouseClicked
    }//GEN-LAST:event_jToggleButton2MouseClicked


    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void budgetIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_budgetIconMouseClicked

    }//GEN-LAST:event_budgetIconMouseClicked

    private void SavingsIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SavingsIconMouseClicked
    }//GEN-LAST:event_SavingsIconMouseClicked

    private void SavingsIconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SavingsIconActionPerformed
        SavingsInfoPage m = new SavingsInfoPage();
        m.setVisible(true);
        this.hide();
    }//GEN-LAST:event_SavingsIconActionPerformed

    private void StocksIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StocksIconMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_StocksIconMouseClicked

    private void StocksIconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StocksIconActionPerformed
       StocksInfoPage m = new StocksInfoPage();
       m.setVisible(true);
       this.hide();       
    }//GEN-LAST:event_StocksIconActionPerformed

    private void cryptoIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cryptoIconMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cryptoIconMouseClicked

    private void cryptoIconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cryptoIconActionPerformed
       CryptoInfoPage m = new CryptoInfoPage();
       m.setVisible(true);
       this.hide();       
    }//GEN-LAST:event_cryptoIconActionPerformed

    private void editTextbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editTextbtnMouseClicked
    }//GEN-LAST:event_editTextbtnMouseClicked

    private void editTextbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editTextbtnActionPerformed
        EditPersonalInfoPage m = new EditPersonalInfoPage();
        m.setVisible(true);
       this.hide();  
    }//GEN-LAST:event_editTextbtnActionPerformed

    private void logoutBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutBtnMouseClicked
    }//GEN-LAST:event_logoutBtnMouseClicked

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        String[] options={"Yes", "No"};
                int t =  JOptionPane.showOptionDialog(null, "Are You Sure You Want To Logout?", "Logout", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                if(t==JOptionPane.YES_OPTION){
                    Constant.currentUser = "";
                    Main m = new Main();
                    m.setLocationRelativeTo(null);
                    m.setVisible(true);
                    this.hide();   
                }
    }//GEN-LAST:event_logoutBtnActionPerformed

    private void budgetIconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_budgetIconActionPerformed
        BudgetInfoPage m = new BudgetInfoPage();
        m.setVisible(true);
        this.hide();
    }//GEN-LAST:event_budgetIconActionPerformed

    private void helpBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_helpBtnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_helpBtnMouseClicked

    private void helpBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpBtnActionPerformed

        ImageIcon icon = new ImageIcon("src/com/pSHelp.png");
        JOptionPane.showMessageDialog(rootPane, Constant.message,"Help Page", JOptionPane.INFORMATION_MESSAGE, icon);
    }//GEN-LAST:event_helpBtnActionPerformed

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
    private javax.swing.JPanel InfoPanel;
    private javax.swing.JPanel SIdeBarPanel;
    private javax.swing.JButton SavingsIcon;
    private javax.swing.JButton StocksIcon;
    private javax.swing.JPanel WholePanel;
    private javax.swing.JLabel amountLabel;
    private javax.swing.JButton budgetIcon;
    private javax.swing.JButton cryptoIcon;
    private javax.swing.JButton editTextbtn;
    private javax.swing.JLabel employmentStatusLabel;
    private javax.swing.JLabel firstName;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JButton helpBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JLabel netWorthLabel;
    private javax.swing.JLabel takeHomeIncomeLabel;
    // End of variables declaration//GEN-END:variables
}
