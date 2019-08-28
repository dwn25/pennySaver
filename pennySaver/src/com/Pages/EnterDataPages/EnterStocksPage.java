package com.Pages.EnterDataPages;

import com.Pages.AskQuestionPage.CryptoQuestionPage;
import com.Support.Constant;
import com.Support.Forex.Stocks;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author DNartey
 */
public class EnterStocksPage extends javax.swing.JFrame {
    /**
     * Creates new form EnterStocksPage
     */
    public EnterStocksPage() {
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
        wholePanel = new javax.swing.JPanel();
        SIdeBarPanel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        personalinfoPanel = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        budgetLabel = new javax.swing.JLabel();
        stockPanel = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        budgetLabel1 = new javax.swing.JLabel();
        EnterInfoPanel = new javax.swing.JPanel();
        symbol = new javax.swing.JTextField();
        number = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nextBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        headerPanel = new javax.swing.JPanel();
        firstName = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        firstName1 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(637, 434));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/pSsmallLogo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(257, 257, 257)
                .addComponent(jLabel4)
                .addContainerGap(280, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(0, 178, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        wholePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SIdeBarPanel.setBackground(new java.awt.Color(29, 45, 68));
        SIdeBarPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/pSsmallLogo.png"))); // NOI18N
        SIdeBarPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, 100));

        personalinfoPanel.setBackground(new java.awt.Color(29, 45, 68));
        personalinfoPanel.setForeground(new java.awt.Color(160, 170, 178));
        personalinfoPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                personalinfoPanelMouseClicked(evt);
            }
        });
        personalinfoPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel11.setBackground(new java.awt.Color(0, 0, 0));
        jPanel11.setForeground(new java.awt.Color(204, 204, 204));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        personalinfoPanel.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 40));

        budgetLabel.setBackground(new java.awt.Color(41, 57, 80));
        budgetLabel.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        budgetLabel.setForeground(new java.awt.Color(255, 255, 255));
        budgetLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        budgetLabel.setText("Personal Info");
        budgetLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                budgetLabelMouseClicked(evt);
            }
        });
        personalinfoPanel.add(budgetLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 40));

        SIdeBarPanel.add(personalinfoPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 120, 40));

        stockPanel.setBackground(new java.awt.Color(240, 235, 216));
        stockPanel.setForeground(new java.awt.Color(63, 64, 76));
        stockPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stockPanelMouseClicked(evt);
            }
        });
        stockPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel12.setBackground(new java.awt.Color(153, 153, 153));
        jPanel12.setForeground(new java.awt.Color(204, 204, 204));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        stockPanel.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 40));

        budgetLabel1.setBackground(new java.awt.Color(240, 235, 216));
        budgetLabel1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        budgetLabel1.setForeground(new java.awt.Color(63, 64, 76));
        budgetLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        budgetLabel1.setText("Stock Input");
        budgetLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                budgetLabel1MouseClicked(evt);
            }
        });
        stockPanel.add(budgetLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 110, 40));

        SIdeBarPanel.add(stockPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, -1, 40));

        wholePanel.add(SIdeBarPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 320));

        EnterInfoPanel.setBackground(new java.awt.Color(240, 235, 216));
        EnterInfoPanel.setPreferredSize(new java.awt.Dimension(637, 434));

        symbol.setBackground(new java.awt.Color(240, 235, 216));
        symbol.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        symbol.setForeground(new java.awt.Color(63, 64, 76));
        symbol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                symbolActionPerformed(evt);
            }
        });

        number.setBackground(new java.awt.Color(240, 235, 216));
        number.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        number.setForeground(new java.awt.Color(63, 64, 76));
        number.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numberActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(240, 235, 216));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(63, 64, 76));
        jLabel3.setText("Stock Symbol:");

        jLabel5.setBackground(new java.awt.Color(240, 235, 216));
        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(63, 64, 76));
        jLabel5.setText("Stock Number:");

        nextBtn.setBackground(new java.awt.Color(34, 47, 66));
        nextBtn.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        nextBtn.setForeground(new java.awt.Color(255, 255, 255));
        nextBtn.setText("Next");
        nextBtn.setMaximumSize(new java.awt.Dimension(72, 32));
        nextBtn.setMinimumSize(new java.awt.Dimension(72, 32));
        nextBtn.setPreferredSize(new java.awt.Dimension(72, 32));
        nextBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextBtnActionPerformed(evt);
            }
        });

        addBtn.setBackground(new java.awt.Color(34, 47, 66));
        addBtn.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        addBtn.setForeground(new java.awt.Color(255, 255, 255));
        addBtn.setText("Add");
        addBtn.setMaximumSize(new java.awt.Dimension(72, 32));
        addBtn.setMinimumSize(new java.awt.Dimension(72, 32));
        addBtn.setPreferredSize(new java.awt.Dimension(72, 32));
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        headerPanel.setBackground(new java.awt.Color(34, 47, 66));

        firstName.setBackground(new java.awt.Color(34, 47, 66));
        firstName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        firstName.setForeground(new java.awt.Color(255, 255, 255));
        firstName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        firstName.setText("and the number that you own");

        jLabel13.setBackground(new java.awt.Color(34, 47, 66));
        jLabel13.setForeground(new java.awt.Color(63, 64, 76));

        firstName1.setBackground(new java.awt.Color(34, 47, 66));
        firstName1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        firstName1.setForeground(new java.awt.Color(255, 255, 255));
        firstName1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        firstName1.setText("Please enter the stock symbol ");

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGap(424, 424, 424)
                .addComponent(jLabel13)
                .addContainerGap(538, Short.MAX_VALUE))
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(firstName1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(firstName, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanelLayout.createSequentialGroup()
                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(headerPanelLayout.createSequentialGroup()
                        .addComponent(firstName1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(firstName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(headerPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13)))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout EnterInfoPanelLayout = new javax.swing.GroupLayout(EnterInfoPanel);
        EnterInfoPanel.setLayout(EnterInfoPanelLayout);
        EnterInfoPanelLayout.setHorizontalGroup(
            EnterInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EnterInfoPanelLayout.createSequentialGroup()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(EnterInfoPanelLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(EnterInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(EnterInfoPanelLayout.createSequentialGroup()
                        .addGroup(EnterInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(EnterInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(symbol, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(number, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(EnterInfoPanelLayout.createSequentialGroup()
                        .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nextBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        EnterInfoPanelLayout.setVerticalGroup(
            EnterInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EnterInfoPanelLayout.createSequentialGroup()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(EnterInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(symbol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(EnterInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(number, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(27, 27, 27)
                .addGroup(EnterInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nextBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        wholePanel.add(EnterInfoPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 410, 320));

        getContentPane().add(wholePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 320));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void numberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numberActionPerformed
    }//GEN-LAST:event_numberActionPerformed

    private void symbolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_symbolActionPerformed

    }//GEN-LAST:event_symbolActionPerformed

    private void nextBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextBtnActionPerformed
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure you don't want to enter any more symbols?","Confirm Move",dialogButton);
        if(dialogResult == JOptionPane.YES_OPTION){
            CryptoQuestionPage m = new CryptoQuestionPage();
            m = new CryptoQuestionPage();
            m.setLocationRelativeTo(null);
            m.setVisible(true);
            this.hide();
        }
    }//GEN-LAST:event_nextBtnActionPerformed

    public boolean isAlpha(String name) {
        return name.matches("[a-zA-Z]+");
    }
    
    public boolean isStockInTable(String symb) {
        String query = "SELECT STOCK_SYMBOL FROM  "+ Constant.tableName + ".PSTOCKS WHERE username= '" + Constant.currentUser + "'"; 
        try {
            ResultSet rs2 = Constant.stmt.executeQuery(query) ;
            if(rs2.next()){
                String dbSymbol = rs2.getString("STOCK_SYMBOL");
                if(dbSymbol.equals(symb)){
                    return true;
                }
            }else{
                return false;
            }
        }catch(SQLException e) {
                e.printStackTrace();
                return true ;
                  }
        return false;
    }
    
    
    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        Constant.DoConnect();
        String stockSymbol,stockNumber;
        int finalStockNumber;
        try{
            stockSymbol = symbol.getText();
            stockNumber = number.getText();
            if(stockSymbol.isEmpty()){
                JOptionPane.showMessageDialog(rootPane, "Please Enter a Stock Symbol");
            }
            else if(!isAlpha(stockSymbol)){
                    JOptionPane.showMessageDialog(rootPane, "Please Only Valid Characters for the Stock Symbol");
            }
            else if(stockNumber.isEmpty()){
                   JOptionPane.showMessageDialog(rootPane, "Please Enter The Number");
            }
            else if(!Stocks.checkSymbol(stockSymbol)){
                   JOptionPane.showMessageDialog(rootPane, "Please Enter A Stock Symbol That Exists");
            }
            else if(isStockInTable(stockSymbol)){
                    JOptionPane.showMessageDialog(rootPane, "Stock Exists in Table");
                }
                else{
                finalStockNumber = Integer.parseInt(stockNumber);
                String[] options={"Yes", "No"};
                int t =  JOptionPane.showOptionDialog(null, "Are You Sure You Want To Save?", "Confirm Save", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                if(t==JOptionPane.YES_OPTION){
                    String sql = "INSERT INTO  "+ Constant.tableName + ".PSTOCKS (STOCK_SYMBOL, STOCK_NUMBER, USERNAME) VALUES (?, ?, ?)";
                    //String sql = ("INSERT INTO  "+ Constant.tableName + ".PUSERS( USERNAME , PASSWORD ,FIRSTNAME,  LASTNAME ,  EMAILADDRESS  )values(?,?,?,?,?)" );
                    PreparedStatement statement = Constant.con.prepareStatement(sql);
                    statement.setString(1, stockSymbol);
                    statement.setDouble(2, finalStockNumber);
                    statement.setString(3, Constant.currentUser);
                    int rowsInserted = statement.executeUpdate();
                    if(rowsInserted > 0){
                        System.out.println("Stocks Table: successiful insertion!");
                        JOptionPane.showMessageDialog(null, "Stock Save Succesful");
                        symbol.setText(null);
                        number.setText(null);
                    }
                }     
            }
        }catch(NumberFormatException er){
            System.out.println(er);
            JOptionPane.showMessageDialog(rootPane, "A valid number must be entered!! Please try again");
        }
        catch(Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(rootPane, "ERROR OCCURED");
        }finally {
            try { Constant.rs.close(); } catch (Exception e) { /* ignored */ }
            try { Constant.stmt.close(); } catch (Exception e) { /* ignored */ }
            try { Constant.con.close(); } catch (Exception e) { /* ignored */ }
        }
    }//GEN-LAST:event_addBtnActionPerformed

    
    private void budgetLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_budgetLabelMouseClicked

    }//GEN-LAST:event_budgetLabelMouseClicked

    private void personalinfoPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_personalinfoPanelMouseClicked

    }//GEN-LAST:event_personalinfoPanelMouseClicked

    private void budgetLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_budgetLabel1MouseClicked

    }//GEN-LAST:event_budgetLabel1MouseClicked

    private void stockPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stockPanelMouseClicked

    }//GEN-LAST:event_stockPanelMouseClicked

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
            java.util.logging.Logger.getLogger(EnterStocksPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EnterStocksPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EnterStocksPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EnterStocksPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EnterStocksPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel EnterInfoPanel;
    private javax.swing.JPanel SIdeBarPanel;
    private javax.swing.JButton addBtn;
    private javax.swing.JLabel budgetLabel;
    private javax.swing.JLabel budgetLabel1;
    private javax.swing.JLabel firstName;
    private javax.swing.JLabel firstName1;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JButton nextBtn;
    private javax.swing.JTextField number;
    private javax.swing.JPanel personalinfoPanel;
    private javax.swing.JPanel stockPanel;
    private javax.swing.JTextField symbol;
    private javax.swing.JPanel wholePanel;
    // End of variables declaration//GEN-END:variables
}
