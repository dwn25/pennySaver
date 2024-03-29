package com.Pages.MainMenu;

import com.Pages.Main.Main;
import com.Support.BudgetCalcsPage;
import javax.swing.JOptionPane;
import com.Support.Constant;
import com.Support.Forex.Crypto;
import java.awt.Font;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author DNartey
 */
public class CryptoInfoPage extends javax.swing.JFrame {
    ArrayList<Double> ChartTotalCryptoPrice = new ArrayList<>();
    ArrayList<Double> ChartStockNum = new ArrayList<Double>();
    ArrayList<String> ChartStockSymb = new ArrayList<String>();

    /**
     * Creates new form CryptoPage
     */
    public CryptoInfoPage() {
        setLocationRelativeTo(null);
        setResizable(false);
        initComponents();
        try {
            onRun();
        } catch (Exception ex) {
            Logger.getLogger(StocksInfoPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        menuInit();
    }
    
    public void onRun() throws SQLException, IOException{
        updateTable();
        BudgetCalcsPage.dynamicBar(budgetChart1, "Crypto Breakdown", ChartStockNum, ChartStockSymb);
        BudgetCalcsPage.dynamicBar(budgetChart2, "Stocks Breakdown By Price", ChartTotalCryptoPrice, ChartStockSymb);
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
                System.out.println("Unable To Find "+column);
            } 
        }catch(SQLException err){
        System.out.println("Unable to fetch income");
        }  
        return false;
   }
        
    
       public void updateTable() throws SQLException, IOException{
       try {
           Constant.DoConnect();
           String sql = "SELECT * FROM "+ Constant.tableName + ".PCRYPTO WHERE username LIKE '"+Constant.currentUser+"%'" ;
           Constant.rs=Constant.stmt.executeQuery(sql);
           DefaultTableModel tbl = (DefaultTableModel) jTable1.getModel();
           tbl.setRowCount(0);
           ResultSetMetaData rm = Constant.rs.getMetaData();           
           int numOfColumns = rm.getColumnCount();
           Vector data = new Vector();
           while(Constant.rs.next()){    
                 Vector row = new Vector(numOfColumns);
                 for(int i=1; i<=1; i++){
                     Double price = 0.0,total = 0.0;
                     Double number = Constant.rs.getDouble("crypto_number");
                     String tableSymb = Constant.rs.getString("crypto_symbol");
                     //if(number != null && tableSymb!=null){
                        ChartStockSymb.add(tableSymb);
                        ChartStockNum.add(number);
                     
                     row.add(tableSymb);
                     row.add(number);
                     price = Crypto.getPrice(tableSymb);
                     row.add(price);
                     total = number * price;
                     ChartTotalCryptoPrice.add(total);
                     row.add(total);
                     tbl.addRow(row);      
                 } 
                 data.addElement(row);
            }
       }catch (SQLException ex) {
          Logger.getLogger(StocksInfoPage.class.getName()).log(Level.SEVERE,null,ex);  
        }finally {
            try { Constant.rs.close(); } catch (Exception e) { /* ignored */ }
            try { Constant.stmt.close(); } catch (Exception e) { /* ignored */ }
            try { Constant.con.close(); } catch (Exception e) { /* ignored */ }
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

        WholePanel3 = new javax.swing.JPanel();
        InfoPanel3 = new javax.swing.JPanel();
        budgetChart1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        budgetChart2 = new javax.swing.JPanel();
        headerPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        budgetChart = new javax.swing.JPanel();
        SIdeBarPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        mainMenu = new javax.swing.JButton();
        SavingsIcon = new javax.swing.JButton();
        editTextbtn = new javax.swing.JButton();
        logoutBtn = new javax.swing.JButton();
        budgetIcon = new javax.swing.JButton();
        cryptoIcon = new javax.swing.JButton();
        SavingsIcon1 = new javax.swing.JButton();
        StocksIcon = new javax.swing.JButton();
        helpBtn2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        WholePanel3.setBackground(new java.awt.Color(91, 139, 151));
        WholePanel3.setForeground(new java.awt.Color(255, 255, 255));
        WholePanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        InfoPanel3.setBackground(new java.awt.Color(240, 235, 216));

        budgetChart1.setLayout(new java.awt.BorderLayout());

        jTable1.setBackground(new java.awt.Color(240, 235, 216));
        jTable1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable1.setForeground(new java.awt.Color(63, 64, 76));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Symbol", "Number Owned", "Price", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);

        budgetChart2.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout InfoPanel3Layout = new javax.swing.GroupLayout(InfoPanel3);
        InfoPanel3.setLayout(InfoPanel3Layout);
        InfoPanel3Layout.setHorizontalGroup(
            InfoPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InfoPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(InfoPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(InfoPanel3Layout.createSequentialGroup()
                        .addComponent(budgetChart1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(budgetChart2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InfoPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 728, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        InfoPanel3Layout.setVerticalGroup(
            InfoPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InfoPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(InfoPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(budgetChart1, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                    .addComponent(budgetChart2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE))
        );

        WholePanel3.add(InfoPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 740, 550));

        headerPanel.setBackground(new java.awt.Color(34, 47, 66));

        jLabel1.setBackground(new java.awt.Color(34, 47, 66));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Crypto Allocation");

        budgetChart.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addComponent(budgetChart, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 270, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(budgetChart, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        WholePanel3.add(headerPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 740, 90));

        SIdeBarPanel.setBackground(new java.awt.Color(29, 45, 68));
        SIdeBarPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/pSsmallLogo.png"))); // NOI18N
        SIdeBarPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        mainMenu.setBackground(new java.awt.Color(41, 57, 80));
        mainMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/Logos/MenuButtons/MainMenuNormal.jpg"))); // NOI18N
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
        SIdeBarPanel.add(mainMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 140, 50));

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

        cryptoIcon.setBackground(new java.awt.Color(240, 235, 216));
        cryptoIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/Logos/MenuButtons/CryptoSelected.jpg"))); // NOI18N
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

        SavingsIcon1.setBackground(new java.awt.Color(41, 57, 80));
        SavingsIcon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/Logos/MenuButtons/SavingsNormal.jpg"))); // NOI18N
        SavingsIcon1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SavingsIcon1MouseClicked(evt);
            }
        });
        SavingsIcon1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SavingsIcon1ActionPerformed(evt);
            }
        });
        SIdeBarPanel.add(SavingsIcon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 140, 50));

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

        helpBtn2.setBackground(new java.awt.Color(41, 57, 80));
        helpBtn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/Logos/MenuButtons/HelpButtonNormal.jpg"))); // NOI18N
        helpBtn2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                helpBtn2MouseClicked(evt);
            }
        });
        helpBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpBtn2ActionPerformed(evt);
            }
        });
        SIdeBarPanel.add(helpBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 580, 140, 50));

        WholePanel3.add(SIdeBarPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 640));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(WholePanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(WholePanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void SavingsIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SavingsIconMouseClicked

    }//GEN-LAST:event_SavingsIconMouseClicked

    private void SavingsIconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SavingsIconActionPerformed
        SavingsInfoPage m = new SavingsInfoPage();
        m.setVisible(true);
        this.hide();
    }//GEN-LAST:event_SavingsIconActionPerformed

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

    private void budgetIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_budgetIconMouseClicked
        BudgetInfoPage m = new BudgetInfoPage();
        m.setVisible(true);
        this.hide();
    }//GEN-LAST:event_budgetIconMouseClicked

    private void budgetIconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_budgetIconActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_budgetIconActionPerformed

    private void cryptoIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cryptoIconMouseClicked

    }//GEN-LAST:event_cryptoIconMouseClicked

    private void cryptoIconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cryptoIconActionPerformed

    }//GEN-LAST:event_cryptoIconActionPerformed

    private void SavingsIcon1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SavingsIcon1MouseClicked

    }//GEN-LAST:event_SavingsIcon1MouseClicked

    private void SavingsIcon1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SavingsIcon1ActionPerformed
        SavingsInfoPage m = new SavingsInfoPage();
        m.setVisible(true);
        this.hide();
    }//GEN-LAST:event_SavingsIcon1ActionPerformed

    private void StocksIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StocksIconMouseClicked

    }//GEN-LAST:event_StocksIconMouseClicked

    private void StocksIconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StocksIconActionPerformed
        StocksInfoPage m = new StocksInfoPage();
        m.setVisible(true);
        this.hide();
    }//GEN-LAST:event_StocksIconActionPerformed

    private void helpBtn2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_helpBtn2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_helpBtn2MouseClicked

    private void helpBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpBtn2ActionPerformed
        JTextArea jTextArea = new JTextArea(Constant.message);
        jTextArea.setFont(new Font("Tahoma", Font.PLAIN, 18));
        jTextArea.setWrapStyleWord(true);
        jTextArea.setOpaque(true);
        jTextArea.setEditable(false);
        jTextArea.setFocusable(true);
        JOptionPane.showMessageDialog(null, jTextArea,"Help Page", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_helpBtn2ActionPerformed

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
            java.util.logging.Logger.getLogger(CryptoInfoPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CryptoInfoPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CryptoInfoPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CryptoInfoPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CryptoInfoPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel InfoPanel3;
    private javax.swing.JPanel SIdeBarPanel;
    private javax.swing.JButton SavingsIcon;
    private javax.swing.JButton SavingsIcon1;
    private javax.swing.JButton StocksIcon;
    private javax.swing.JPanel WholePanel3;
    private javax.swing.JPanel budgetChart;
    private javax.swing.JPanel budgetChart1;
    private javax.swing.JPanel budgetChart2;
    private javax.swing.JButton budgetIcon;
    private javax.swing.JButton cryptoIcon;
    private javax.swing.JButton editTextbtn;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JButton helpBtn2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JButton mainMenu;
    // End of variables declaration//GEN-END:variables
}
