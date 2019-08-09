package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author DNartey
 */
public class BudgetInfoPage extends javax.swing.JFrame {
    Connection con;
    Statement stmt;
    ResultSet rs;
    String url;
    String pwd;
    String username;
    /**
     * Creates new form BudgettingInfoPage
     */
    public BudgetInfoPage() {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        homeField = new javax.swing.JTextField();
        entertainmentField = new javax.swing.JTextField();
        feesField = new javax.swing.JTextField();
        personalCareField = new javax.swing.JTextField();
        diningAndDrinksField = new javax.swing.JTextField();
        autoAndCommutingField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        travelField = new javax.swing.JTextField();
        billsAndUtilitiesField = new javax.swing.JTextField();
        loansField = new javax.swing.JTextField();
        educationField = new javax.swing.JTextField();
        shoppingField = new javax.swing.JTextField();
        backBtn = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        Edit = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        otherField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mainMenuItemBtn = new javax.swing.JMenuItem();
        budgetMenuItem = new javax.swing.JMenuItem();
        stocksMenuItem = new javax.swing.JMenuItem();
        cryptoMenuItem = new javax.swing.JMenuItem();
        savingsMenutItem = new javax.swing.JMenuItem();
        logoutMenuItem = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(637, 434));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/pSsmallLogo.png"))); // NOI18N

        jLabel14.setForeground(new java.awt.Color(153, 153, 153));
        jLabel14.setText("Fees:");

        jLabel15.setForeground(new java.awt.Color(153, 153, 153));
        jLabel15.setText("Personal Care:");

        jLabel16.setForeground(new java.awt.Color(153, 153, 153));
        jLabel16.setText("Education:");

        jLabel17.setForeground(new java.awt.Color(153, 153, 153));
        jLabel17.setText("Loans:");

        homeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeFieldActionPerformed(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(153, 153, 153));
        jLabel7.setText("Home:");

        shoppingField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shoppingFieldActionPerformed(evt);
            }
        });

        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        jLabel8.setForeground(new java.awt.Color(153, 153, 153));
        jLabel8.setText("Dining & Drinks:");

        Edit.setText("Edit");
        Edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditActionPerformed(evt);
            }
        });

        jLabel9.setForeground(new java.awt.Color(153, 153, 153));
        jLabel9.setText("Shopping:");

        jLabel18.setForeground(new java.awt.Color(153, 153, 153));
        jLabel18.setText("Other:");

        jLabel10.setForeground(new java.awt.Color(153, 153, 153));
        jLabel10.setText("Auto & Commuting:");

        jLabel11.setForeground(new java.awt.Color(153, 153, 153));
        jLabel11.setText("Travel:");

        jLabel12.setForeground(new java.awt.Color(153, 153, 153));
        jLabel12.setText("Bills & Utilities:");

        jLabel13.setForeground(new java.awt.Color(153, 153, 153));
        jLabel13.setText("Entertainment:");

        jLabel19.setForeground(new java.awt.Color(153, 153, 153));
        jLabel19.setText("Your Budget Has Been Calculated Below");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(257, 257, 257)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel13)
                                            .addComponent(jLabel14))
                                        .addGap(122, 122, 122))
                                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(personalCareField)
                                            .addComponent(feesField)
                                            .addComponent(entertainmentField)
                                            .addComponent(autoAndCommutingField)
                                            .addComponent(travelField)
                                            .addComponent(billsAndUtilitiesField)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(educationField))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(loansField, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(diningAndDrinksField)
                                            .addComponent(homeField)
                                            .addComponent(shoppingField)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(42, 42, 42)
                                        .addComponent(jLabel19)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(Edit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(backBtn))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addGap(18, 18, 18)
                                .addComponent(otherField, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(homeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(shoppingField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(diningAndDrinksField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(autoAndCommutingField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(travelField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(billsAndUtilitiesField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(entertainmentField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(feesField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(personalCareField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(loansField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(educationField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(otherField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backBtn)
                    .addComponent(Edit))
                .addGap(20, 20, 20))
        );

        menuBar.setBackground(new java.awt.Color(0, 0, 0));
        menuBar.setForeground(new java.awt.Color(51, 51, 51));

        jMenu1.setText("File");

        mainMenuItemBtn.setText("Main Menu");
        mainMenuItemBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mainMenuItemBtnMouseClicked(evt);
            }
        });
        mainMenuItemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainMenuItemBtnActionPerformed(evt);
            }
        });
        jMenu1.add(mainMenuItemBtn);

        budgetMenuItem.setText("Budget");
        budgetMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                budgetMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(budgetMenuItem);

        stocksMenuItem.setText("Stocks");
        stocksMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stocksMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(stocksMenuItem);

        cryptoMenuItem.setText("Crypto");
        cryptoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cryptoMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(cryptoMenuItem);

        savingsMenutItem.setText("Savings Forecast");
        savingsMenutItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savingsMenutItemActionPerformed(evt);
            }
        });
        jMenu1.add(savingsMenutItem);

        logoutMenuItem.setText("Logout");
        logoutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(logoutMenuItem);

        menuBar.add(jMenu1);

        jMenu2.setText("Help");
        menuBar.add(jMenu2);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void DoConnect(){
        try{
            //Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            //Class.forName("org.apache.derby.jdbc.ClientDriver");
            String url= "jdbc:derby://localhost:1527/pennySaverDatabase";
            username="root";
            pwd="password";
            con= DriverManager.getConnection(url, username, pwd);
            stmt=con.createStatement();
        }catch (SQLException err){
        System.out.println(err.getMessage());
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
  }
    private void budgetMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_budgetMenuItemActionPerformed
        // TODO add your handling code here:
        BudgetInfoPage m = new BudgetInfoPage();
        m.setLocationRelativeTo(null);
        m.setVisible(true);
        this.hide();
    }//GEN-LAST:event_budgetMenuItemActionPerformed

    private void stocksMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stocksMenuItemActionPerformed
        // TODO add your handling code here:
        StocksInfoPage m = new StocksInfoPage();
        m.setLocationRelativeTo(null);
        m.setVisible(true);
        this.hide();
    }//GEN-LAST:event_stocksMenuItemActionPerformed

    private void cryptoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cryptoMenuItemActionPerformed
        // TODO add your handling code here:
        CryptoInfoPage m = new CryptoInfoPage();
        m.setLocationRelativeTo(null);
        m.setVisible(true);
        this.hide();
    }//GEN-LAST:event_cryptoMenuItemActionPerformed

    private void savingsMenutItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savingsMenutItemActionPerformed
        // TODO add your handling code here:
        SavingsInfoPage m = new SavingsInfoPage();
        m.setLocationRelativeTo(null);
        m.setVisible(true);
        this.hide();
    }//GEN-LAST:event_savingsMenutItemActionPerformed

    private void logoutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutMenuItemActionPerformed
        // TODO add your handling code here:
        String[] options={"Yes", "No"};
        int t = JOptionPane.showOptionDialog(null, "Are You Sure You Want To Logout?", "Confirm Logout", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if (t==JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(rootPane, "Goodbye, Please come again");
            System.exit(0);
        }
    }//GEN-LAST:event_logoutMenuItemActionPerformed

    private void mainMenuItemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainMenuItemBtnActionPerformed
    }//GEN-LAST:event_mainMenuItemBtnActionPerformed

    private void mainMenuItemBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainMenuItemBtnMouseClicked
    MainMenu m = new MainMenu();
    m.setLocationRelativeTo(null);
    m.setVisible(true);
    this.hide();
    }//GEN-LAST:event_mainMenuItemBtnMouseClicked

    private void homeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeFieldActionPerformed

    }//GEN-LAST:event_homeFieldActionPerformed

    private void shoppingFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shoppingFieldActionPerformed

    }//GEN-LAST:event_shoppingFieldActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure you want to leave without saving","Warning",dialogButton);
        if(dialogResult == JOptionPane.YES_OPTION){
            Main m = new Main();
            m.setVisible(true);
            this.hide();
        }
    }//GEN-LAST:event_backBtnActionPerformed

    private void EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditActionPerformed
        DoConnect();
        Double home, shopping, dineAndDrinks, auto, travel, billsAndUtils,
        entertainment, fees, personalCare, loans, education, other;
        try{
            String home1 = homeField.getText();
            String shopping1 = shoppingField.getText();
            String dine1 = diningAndDrinksField.getText();
            String auto1 = autoAndCommutingField.getText();
            String travel1 = travelField.getText();
            String bills1 = billsAndUtilitiesField.getText();
            String ent1 = entertainmentField.getText();
            String fees1 = feesField.getText();
            String personal1 = personalCareField.getText();
            String loans1 = loansField.getText();
            String edu1 = educationField.getText();
            String other1 = otherField.getText();
            if(home1.isEmpty()){
                JOptionPane.showMessageDialog(rootPane, "Home Cannot Be Empty");
            }
            else if(shopping1.isEmpty()){
                JOptionPane.showMessageDialog(rootPane, "Shopping Cannot Be Empty");
            }
            else if(dine1.isEmpty()){
                JOptionPane.showMessageDialog(rootPane, "Dining & Drinks Cannot Be Empty");
            }
            else if(auto1.isEmpty()){
                JOptionPane.showMessageDialog(rootPane, "Auto & Commuting Cannot Be Empty");
            }
            else if(travel1.isEmpty()){
                JOptionPane.showMessageDialog(rootPane, "Travel Cannot Be Empty");
            }
            else if(bills1.isEmpty()){
                JOptionPane.showMessageDialog(rootPane, "Bills & Utilities Cannot Be Empty");
            }
            else if(ent1.isEmpty()){
                JOptionPane.showMessageDialog(rootPane, "Entertainment Cannot Be Empty");
            }
            else if(fees1.isEmpty()){
                JOptionPane.showMessageDialog(rootPane, "Fees Cannot Be Empty");
            }
            else if(personal1.isEmpty()){
                JOptionPane.showMessageDialog(rootPane, "Personal Care Cannot Be Empty");
            }
            else if(loans1.isEmpty()){
                JOptionPane.showMessageDialog(rootPane, "Loans Cannot Be Empty");
            }
            else if(edu1.isEmpty()){
                JOptionPane.showMessageDialog(rootPane, "Education Cannot Be Empty");
            }
            else if(other1.isEmpty()){
                JOptionPane.showMessageDialog(rootPane, "Other Cannot Be Empty");
            }
            else{
                home = Double.parseDouble(home1);
                shopping = Double.parseDouble(shopping1);
                dineAndDrinks = Double.parseDouble(dine1);
                auto = Double.parseDouble(auto1);
                travel = Double.parseDouble(travel1);
                billsAndUtils = Double.parseDouble(bills1);
                entertainment = Double.parseDouble(ent1);
                fees = Double.parseDouble(fees1);
                personalCare = Double.parseDouble(personal1);
                loans = Double.parseDouble(loans1);
                education = Double.parseDouble(edu1);
                other = Double.parseDouble(other1);
                String[] options={"Yes", "No"};
                int t =  JOptionPane.showOptionDialog(null, "Are You Sure You Want To Save?", "Confirm Save", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                if(t==JOptionPane.YES_OPTION){
                    String sql = ("INSERT INTO ROOT.PBUDGET( USERNAME , HOME , SHOPPING , DINING_AND_DRINKS , AUTO , TRAVEL , BILLS , ENTERTAINMENT , FEES , PERSONAL , LOANS , EDUCATION, OTHER )values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    //String sql = ("INSERT INTO ROOT.PUSERS( USERNAME , PASSWORD ,FIRSTNAME,  LASTNAME ,  EMAILADDRESS  )values(?,?,?,?,?)" );
                    PreparedStatement statement = con.prepareStatement(sql);
                    statement.setString(1, Constant.currentUser);
                    statement.setDouble(2, home);
                    statement.setDouble(3, shopping);
                    statement.setDouble(4, dineAndDrinks);
                    statement.setDouble(5, auto);
                    statement.setDouble(6, travel);
                    statement.setDouble(7, billsAndUtils);
                    statement.setDouble(8, entertainment);
                    statement.setDouble(9, fees);
                    statement.setDouble(10, personalCare);
                    statement.setDouble(11, loans);
                    statement.setDouble(12, education);
                    statement.setDouble(13, other);
                    int rowsInserted = statement.executeUpdate();
                    if(rowsInserted > 0){
                        System.out.println("A new user was inserted successfully!");
                        JOptionPane.showMessageDialog(null, "Save Succesful");
                        SavingsPlanPage eP = new SavingsPlanPage();
                        eP.setVisible(true);
                        this.hide();
                    }
                }
            }
        }catch(NumberFormatException err){
            JOptionPane.showMessageDialog(rootPane, "Please Enter Only Numbers");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(rootPane, "An Error Occurred");
        }
    }//GEN-LAST:event_EditActionPerformed

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
            java.util.logging.Logger.getLogger(BudgetInfoPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BudgetInfoPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BudgetInfoPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BudgetInfoPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BudgetInfoPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Edit;
    private javax.swing.JTextField autoAndCommutingField;
    private javax.swing.JButton backBtn;
    private javax.swing.JTextField billsAndUtilitiesField;
    private javax.swing.JMenuItem budgetMenuItem;
    private javax.swing.JMenuItem cryptoMenuItem;
    private javax.swing.JTextField diningAndDrinksField;
    private javax.swing.JTextField educationField;
    private javax.swing.JTextField entertainmentField;
    private javax.swing.JTextField feesField;
    private javax.swing.JTextField homeField;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField loansField;
    private javax.swing.JMenuItem logoutMenuItem;
    private javax.swing.JMenuItem mainMenuItemBtn;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JTextField otherField;
    private javax.swing.JTextField personalCareField;
    private javax.swing.JMenuItem savingsMenutItem;
    private javax.swing.JTextField shoppingField;
    private javax.swing.JMenuItem stocksMenuItem;
    private javax.swing.JTextField travelField;
    // End of variables declaration//GEN-END:variables
}
