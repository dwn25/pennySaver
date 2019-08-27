package com.Pages.MainMenu;

import com.Pages.Main.Main;
import com.Support.Constant;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author DNartey
 */
public class EditPersonalInfoPage extends javax.swing.JFrame {
    boolean budget, savings, stocks, crypto;

    /**
     * Creates new form EditInfoPage
     */
    public EditPersonalInfoPage() {
        setResizable(false);
        initComponents();
        onRun();
    }

public void onRun(){
        Constant.DoConnect();
        putFieldString(incomeField,"net_income");
        getField(netWorthLabel,"net_worth");
        getField(amountLabel,"monthly_savings");
        menuInit();
    }
    public void menuInit(){
        try{
            Constant.DoConnect();
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
            stocksIcon.setEnabled(stocks);
            cryptoIcon.setEnabled(crypto);
        }catch(Exception e){
            System.out.println("Unable to fetch Menus");
        }
    }
    
        public boolean getMenu(String column){
        try{
            String SQL= "SELECT "+ column+" From ROOT.PUSERS WHERE username= '"+Constant.currentUser+"'";    
            ResultSet rs = Constant.stmt.executeQuery(SQL);
            if(rs.next()){
                boolean val = rs.getBoolean(column);
                return val;
                }
            else{
                JOptionPane.showMessageDialog(rootPane, "Unable To Find Value");
            } 
        }catch(SQLException err){
        System.out.println("Unable to fetch income");
        }  
        return false;
   }
 
    public void getField(JTextField label1, String column){
        try{
            String SQL= "SELECT " + column +" From ROOT.PUSERS WHERE username= '"+Constant.currentUser+"'";    
            ResultSet rs = Constant.stmt.executeQuery(SQL);
            if(rs.next()){
                String val = rs.getString(column);
                label1.setText(null);
                label1.setText(val);
                }
            else{
                JOptionPane.showMessageDialog(rootPane, "Unable To Find Value");
            } 
        }catch(SQLException err){
        System.out.println("Unable to fetch "+ column);
        }        
    }
    
   public void getFieldString(JTextField label1, String column){
        try{
            String SQL= "SELECT " + column +" From ROOT.PUSERS WHERE username= '"+Constant.currentUser+"'";    
            ResultSet rs = Constant.stmt.executeQuery(SQL);
            if(rs.next()){
                String val = rs.getString(column);
                label1.setText(null);
                label1.setText(val);
                }
            else{
                JOptionPane.showMessageDialog(rootPane, "Unable To Find Value");
            } 
        }catch(SQLException err){
        System.out.println("Unable to fetch "+ column);
        }        
    }
    public void putFieldString(javax.swing.JTextField JtexTield, String column){
        try{
            String SQL= "SELECT " + column +" From ROOT.PUSERS WHERE username= '"+Constant.currentUser+"'";    
            ResultSet rs = Constant.stmt.executeQuery(SQL);
            if(rs.next()){
                String val = rs.getString(column);
                JtexTield.setText(val);
                }
            else{
                JOptionPane.showMessageDialog(rootPane, "Unable To Find Value");
            } 
        }catch(SQLException err){
        System.out.println("Unable to fetch "+ column);
        }        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        WholePanel = new javax.swing.JPanel();
        headerPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        SIdeBarPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        mainMenu = new javax.swing.JToggleButton();
        logoutBtn = new javax.swing.JToggleButton();
        SavingsIcon = new javax.swing.JToggleButton();
        budgetIcon = new javax.swing.JToggleButton();
        editInfoPage = new javax.swing.JToggleButton();
        cryptoIcon = new javax.swing.JToggleButton();
        stocksIcon = new javax.swing.JToggleButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        amountLabel = new javax.swing.JTextField();
        netWorthLabel = new javax.swing.JTextField();
        incomeField = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        employmentStatus = new javax.swing.JComboBox<>();
        saveBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        WholePanel.setBackground(new java.awt.Color(240, 235, 216));
        WholePanel.setForeground(new java.awt.Color(255, 255, 255));
        WholePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        headerPanel.setBackground(new java.awt.Color(34, 47, 66));

        jLabel1.setBackground(new java.awt.Color(34, 47, 66));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Edit Info");

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        WholePanel.add(headerPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 440, 100));

        SIdeBarPanel.setBackground(new java.awt.Color(29, 45, 68));
        SIdeBarPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/pSsmallLogo.png"))); // NOI18N
        SIdeBarPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        mainMenu.setBackground(new java.awt.Color(41, 57, 80));
        mainMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/Logos/MenuButtons/MainMenuNormal.jpg"))); // NOI18N
        mainMenu.setBorder(null);
        mainMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mainMenuMouseClicked(evt);
            }
        });
        mainMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainMenuActionPerformed(evt);
            }
        });
        SIdeBarPanel.add(mainMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 130, 50));

        logoutBtn.setBackground(new java.awt.Color(41, 57, 80));
        logoutBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/Logos/MenuButtons/logoutBtn.jpg"))); // NOI18N
        logoutBtn.setBorder(null);
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
        SIdeBarPanel.add(logoutBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 130, 50));

        SavingsIcon.setBackground(new java.awt.Color(41, 57, 80));
        SavingsIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/Logos/MenuButtons/SavingsNormal.jpg"))); // NOI18N
        SavingsIcon.setBorder(null);
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
        SIdeBarPanel.add(SavingsIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 130, 50));

        budgetIcon.setBackground(new java.awt.Color(41, 57, 80));
        budgetIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/Logos/MenuButtons/BudgetNormal.jpg"))); // NOI18N
        budgetIcon.setBorder(null);
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
        SIdeBarPanel.add(budgetIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 130, 50));

        editInfoPage.setBackground(new java.awt.Color(240, 235, 216));
        editInfoPage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/Logos/MenuButtons/EditInfoSelected.jpg"))); // NOI18N
        editInfoPage.setBorder(null);
        editInfoPage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editInfoPageMouseClicked(evt);
            }
        });
        editInfoPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editInfoPageActionPerformed(evt);
            }
        });
        SIdeBarPanel.add(editInfoPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 130, 50));

        cryptoIcon.setBackground(new java.awt.Color(41, 57, 80));
        cryptoIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/Logos/MenuButtons/CryptoNormal.jpg"))); // NOI18N
        cryptoIcon.setBorder(null);
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
        SIdeBarPanel.add(cryptoIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 130, 50));

        stocksIcon.setBackground(new java.awt.Color(41, 57, 80));
        stocksIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/Logos/MenuButtons/StocksNormal.jpg"))); // NOI18N
        stocksIcon.setBorder(null);
        stocksIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stocksIconMouseClicked(evt);
            }
        });
        stocksIcon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stocksIconActionPerformed(evt);
            }
        });
        SIdeBarPanel.add(stocksIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 130, 50));

        WholePanel.add(SIdeBarPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 490));

        jPanel1.setBackground(new java.awt.Color(240, 235, 216));

        jLabel8.setBackground(new java.awt.Color(240, 235, 216));
        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(63, 64, 76));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Employment Status");

        jLabel19.setBackground(new java.awt.Color(240, 235, 216));
        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(63, 64, 76));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("Amount Willing to Save Every Month");

        jLabel7.setBackground(new java.awt.Color(240, 235, 216));
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(63, 64, 76));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Net Worth");

        amountLabel.setBackground(new java.awt.Color(240, 235, 216));
        amountLabel.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        amountLabel.setForeground(new java.awt.Color(63, 64, 76));
        amountLabel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amountLabelActionPerformed(evt);
            }
        });

        netWorthLabel.setBackground(new java.awt.Color(240, 235, 216));
        netWorthLabel.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        netWorthLabel.setForeground(new java.awt.Color(63, 64, 76));
        netWorthLabel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                netWorthLabelActionPerformed(evt);
            }
        });

        incomeField.setBackground(new java.awt.Color(240, 235, 216));
        incomeField.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        incomeField.setForeground(new java.awt.Color(63, 64, 76));
        incomeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                incomeFieldActionPerformed(evt);
            }
        });

        jLabel21.setBackground(new java.awt.Color(240, 235, 216));
        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(63, 64, 76));
        jLabel21.setText("Income:");

        employmentStatus.setBackground(new java.awt.Color(240, 235, 216));
        employmentStatus.setEditable(true);
        employmentStatus.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        employmentStatus.setForeground(new java.awt.Color(63, 64, 76));
        employmentStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Unemployed", "Student", "Employed Part Time", "Employed Full TIme", "Self-Employed" }));
        employmentStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employmentStatusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel21)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(netWorthLabel)
                            .addComponent(incomeField)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(employmentStatus, 0, 158, Short.MAX_VALUE)
                            .addComponent(amountLabel))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(incomeField, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(netWorthLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(employmentStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(amountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        WholePanel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 420, 140));

        saveBtn.setBackground(new java.awt.Color(29, 45, 68));
        saveBtn.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        saveBtn.setForeground(new java.awt.Color(255, 255, 255));
        saveBtn.setText("Save");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });
        WholePanel.add(saveBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 420, 190, 64));

        deleteBtn.setBackground(new java.awt.Color(182, 44, 48));
        deleteBtn.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        deleteBtn.setForeground(new java.awt.Color(255, 255, 255));
        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });
        WholePanel.add(deleteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 420, 190, 64));

        jLabel23.setBackground(new java.awt.Color(240, 235, 216));
        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(63, 64, 76));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Please input your desired changes and click Save.");
        WholePanel.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 440, -1));

        jLabel24.setBackground(new java.awt.Color(240, 235, 216));
        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(63, 64, 76));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("If you would like to update your personal details,");
        WholePanel.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 440, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(WholePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(WholePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mainMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainMenuMouseClicked
        MainMenu m = new MainMenu();
        m.setVisible(true);
        this.hide();
    }//GEN-LAST:event_mainMenuMouseClicked

    private void mainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainMenuActionPerformed

    }//GEN-LAST:event_mainMenuActionPerformed

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

    private void SavingsIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SavingsIconMouseClicked
        SavingsInfoPage m = new SavingsInfoPage();
        m.setLocationRelativeTo(null);
        m.setVisible(true);
        this.hide();
    }//GEN-LAST:event_SavingsIconMouseClicked

    private void SavingsIconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SavingsIconActionPerformed

    }//GEN-LAST:event_SavingsIconActionPerformed

    private void budgetIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_budgetIconMouseClicked
        BudgetInfoPage m = new BudgetInfoPage();
        m.setVisible(true);
        this.hide();
    }//GEN-LAST:event_budgetIconMouseClicked

    private void budgetIconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_budgetIconActionPerformed
    }//GEN-LAST:event_budgetIconActionPerformed

    private void editInfoPageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editInfoPageMouseClicked
    }//GEN-LAST:event_editInfoPageMouseClicked

    private void editInfoPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editInfoPageActionPerformed
    }//GEN-LAST:event_editInfoPageActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        Constant.DoConnect();
        double netWorth=0, monthlyIncome=0, monthlySavings=0;
        try{
                String nw = netWorthLabel.getText();
                String income = incomeField.getText();
                String mS = amountLabel.getText();
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
                    netWorth = Double.parseDouble(netWorthLabel.getText());
                    monthlySavings = Double.parseDouble(amountLabel.getText());
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
                }      
        }catch(NumberFormatException err){
            JOptionPane.showMessageDialog(rootPane, "Please Enter Only Numbers");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(rootPane, "An Error Occurred");
        }
    }//GEN-LAST:event_saveBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        String[] options={"Yes", "No"};
        int t =  JOptionPane.showOptionDialog(null, "Are You Sure You Want To Delete Your Account?", "Delete", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        try{
        if(t==JOptionPane.YES_OPTION){
            int p =  JOptionPane.showOptionDialog(null, "Are You Sure You Want To Delete Your Account? \n"
                    + " This Decision Cannot Be Reversed", "Delete", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if(p==JOptionPane.YES_OPTION){
                Constant.DoConnect();
                String sql = "DELETE FROM ROOT.PUSERS WHERE USERNAME = ?";
                PreparedStatement statement = Constant.con.prepareStatement(sql);
                statement.setString(1, Constant.currentUser);
                statement.executeUpdate();
                if(budget){
                    String sql1 = "DELETE FROM ROOT.PBUDGET WHERE USERNAME = ?";
                    PreparedStatement statement1 = Constant.con.prepareStatement(sql1);
                    statement.setString(1, Constant.currentUser);
                    statement1.executeUpdate();
                }
                if(savings){
                    String sql1 = "DELETE FROM ROOT.PBANK WHERE USERNAME = ?";
                    PreparedStatement statement1 = Constant.con.prepareStatement(sql1);
                    statement.setString(1, Constant.currentUser);
                    statement1.executeUpdate();
                }
                if(stocks){
                    String sql1 = "DELETE FROM ROOT.PSTOCKS WHERE USERNAME = ?";
                    PreparedStatement statement1 = Constant.con.prepareStatement(sql1);
                    statement.setString(1, Constant.currentUser);
                    statement1.executeUpdate();
                }
                if(crypto){                   
                    String sql1 = "DELETE FROM ROOT.PCRYPTO WHERE USERNAME = ?";
                    PreparedStatement statement1 = Constant.con.prepareStatement(sql1);
                    statement.setString(1, Constant.currentUser);
                    statement1.executeUpdate();  
                }
                JOptionPane.showMessageDialog(rootPane, "Succesfully Deleted Account");
                Constant.currentUser = "";
                Main m = new Main();
                m.setVisible(true);
                this.hide();
            }
        }
        }catch(SQLException e){
            
        }
        
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void incomeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_incomeFieldActionPerformed
    }//GEN-LAST:event_incomeFieldActionPerformed

    private void amountLabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amountLabelActionPerformed
    }//GEN-LAST:event_amountLabelActionPerformed

    private void netWorthLabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_netWorthLabelActionPerformed
    }//GEN-LAST:event_netWorthLabelActionPerformed

    private void employmentStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employmentStatusActionPerformed

    }//GEN-LAST:event_employmentStatusActionPerformed

    private void cryptoIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cryptoIconMouseClicked
        CryptoInfoPage m = new CryptoInfoPage();
        m.setVisible(true);
        this.hide();
    }//GEN-LAST:event_cryptoIconMouseClicked

    private void cryptoIconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cryptoIconActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cryptoIconActionPerformed

    private void stocksIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stocksIconMouseClicked
        StocksInfoPage m = new StocksInfoPage();
        m.setVisible(true);
        this.hide();
    }//GEN-LAST:event_stocksIconMouseClicked

    private void stocksIconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stocksIconActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stocksIconActionPerformed

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
            java.util.logging.Logger.getLogger(EditPersonalInfoPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditPersonalInfoPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditPersonalInfoPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditPersonalInfoPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditPersonalInfoPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel SIdeBarPanel;
    private javax.swing.JToggleButton SavingsIcon;
    private javax.swing.JPanel WholePanel;
    private javax.swing.JTextField amountLabel;
    private javax.swing.JToggleButton budgetIcon;
    private javax.swing.JToggleButton cryptoIcon;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JToggleButton editInfoPage;
    private javax.swing.JComboBox<String> employmentStatus;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JTextField incomeField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToggleButton logoutBtn;
    private javax.swing.JToggleButton mainMenu;
    private javax.swing.JTextField netWorthLabel;
    private javax.swing.JButton saveBtn;
    private javax.swing.JToggleButton stocksIcon;
    // End of variables declaration//GEN-END:variables
}
