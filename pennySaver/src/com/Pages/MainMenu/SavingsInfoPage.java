package com.Pages.MainMenu;

import com.Pages.EditPages.EditSavingsPage;
import javax.swing.JOptionPane;

/**
 *
 * @author DNartey
 */
public class SavingsInfoPage extends javax.swing.JFrame {

    /**
     * Creates new form SavingsInfoPage
     */
    public SavingsInfoPage() {
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
        jFrame1 = new javax.swing.JFrame();
        jPanel7 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        WholePanel3 = new javax.swing.JPanel();
        SIdeBarPanel3 = new javax.swing.JPanel();
        budgetPanel3 = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        budgetLabel6 = new javax.swing.JLabel();
        editInfoPanel3 = new javax.swing.JPanel();
        jPanel31 = new javax.swing.JPanel();
        editInfoLabel3 = new javax.swing.JLabel();
        stocksPanel4 = new javax.swing.JPanel();
        jPanel32 = new javax.swing.JPanel();
        stocksLabel3 = new javax.swing.JLabel();
        CryptoPanel3 = new javax.swing.JPanel();
        jPanel33 = new javax.swing.JPanel();
        cryptoLabel3 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        sacingsPanel = new javax.swing.JPanel();
        jPanel35 = new javax.swing.JPanel();
        budgetLabel8 = new javax.swing.JLabel();
        menuPanel = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        mainMenu = new javax.swing.JLabel();
        InfoPanel3 = new javax.swing.JPanel();
        rateField = new javax.swing.JTextField();
        timeField = new javax.swing.JTextField();
        interestField = new javax.swing.JTextField();
        totalField = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        principalField = new javax.swing.JTextField();
        Edit = new javax.swing.JButton();
        headerPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

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

        jFrame1.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel7.setBackground(new java.awt.Color(51, 51, 51));
        jPanel7.setPreferredSize(new java.awt.Dimension(637, 434));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/pSsmallLogo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(257, 257, 257)
                .addComponent(jLabel10)
                .addContainerGap(280, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addGap(0, 266, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        WholePanel3.setBackground(new java.awt.Color(91, 139, 151));
        WholePanel3.setForeground(new java.awt.Color(255, 255, 255));
        WholePanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SIdeBarPanel3.setBackground(new java.awt.Color(29, 45, 68));
        SIdeBarPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        budgetPanel3.setBackground(new java.awt.Color(29, 45, 68));
        budgetPanel3.setForeground(new java.awt.Color(160, 170, 178));
        budgetPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                budgetPanel3MouseClicked(evt);
            }
        });
        budgetPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel29.setForeground(new java.awt.Color(204, 204, 204));
        jPanel29.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        budgetPanel3.add(jPanel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 40));

        budgetLabel6.setBackground(new java.awt.Color(41, 57, 80));
        budgetLabel6.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        budgetLabel6.setForeground(new java.awt.Color(255, 255, 255));
        budgetLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        budgetLabel6.setText("Budget  ");
        budgetLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                budgetLabel6MouseClicked(evt);
            }
        });
        budgetPanel3.add(budgetLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 40));

        SIdeBarPanel3.add(budgetPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 120, 40));

        editInfoPanel3.setBackground(new java.awt.Color(29, 45, 68));
        editInfoPanel3.setForeground(new java.awt.Color(160, 170, 178));
        editInfoPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editInfoPanel3MouseClicked(evt);
            }
        });
        editInfoPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel31.setForeground(new java.awt.Color(204, 204, 204));
        jPanel31.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        editInfoPanel3.add(jPanel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 40));

        editInfoLabel3.setBackground(new java.awt.Color(41, 57, 80));
        editInfoLabel3.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        editInfoLabel3.setForeground(new java.awt.Color(255, 255, 255));
        editInfoLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        editInfoLabel3.setText("Edit Info");
        editInfoLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editInfoLabel3MouseClicked(evt);
            }
        });
        editInfoPanel3.add(editInfoLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 110, 40));

        SIdeBarPanel3.add(editInfoPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 120, 40));

        stocksPanel4.setBackground(new java.awt.Color(29, 45, 68));
        stocksPanel4.setForeground(new java.awt.Color(160, 170, 178));
        stocksPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stocksPanel4MouseClicked(evt);
            }
        });
        stocksPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel32.setForeground(new java.awt.Color(204, 204, 204));
        jPanel32.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        stocksPanel4.add(jPanel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 40));

        stocksLabel3.setBackground(new java.awt.Color(41, 57, 80));
        stocksLabel3.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        stocksLabel3.setForeground(new java.awt.Color(255, 255, 255));
        stocksLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        stocksLabel3.setText("Stocks");
        stocksLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stocksLabel3MouseClicked(evt);
            }
        });
        stocksPanel4.add(stocksLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 110, 40));

        SIdeBarPanel3.add(stocksPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 120, 40));

        CryptoPanel3.setBackground(new java.awt.Color(29, 45, 68));
        CryptoPanel3.setForeground(new java.awt.Color(160, 170, 178));
        CryptoPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CryptoPanel3MouseClicked(evt);
            }
        });
        CryptoPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel33.setForeground(new java.awt.Color(204, 204, 204));
        jPanel33.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        CryptoPanel3.add(jPanel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 40));

        cryptoLabel3.setBackground(new java.awt.Color(41, 57, 80));
        cryptoLabel3.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        cryptoLabel3.setForeground(new java.awt.Color(255, 255, 255));
        cryptoLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        cryptoLabel3.setText("Crypto");
        cryptoLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cryptoLabel3MouseClicked(evt);
            }
        });
        CryptoPanel3.add(cryptoLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 110, 40));

        SIdeBarPanel3.add(CryptoPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 120, 40));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/pSsmallLogo.png"))); // NOI18N
        SIdeBarPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        sacingsPanel.setBackground(new java.awt.Color(240, 235, 216));
        sacingsPanel.setForeground(new java.awt.Color(63, 64, 76));
        sacingsPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sacingsPanelMouseClicked(evt);
            }
        });
        sacingsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel35.setBackground(new java.awt.Color(153, 153, 153));
        jPanel35.setForeground(new java.awt.Color(204, 204, 204));
        jPanel35.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        sacingsPanel.add(jPanel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 40));

        budgetLabel8.setBackground(new java.awt.Color(240, 235, 216));
        budgetLabel8.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        budgetLabel8.setForeground(new java.awt.Color(63, 64, 76));
        budgetLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        budgetLabel8.setText("Savings");
        budgetLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                budgetLabel8MouseClicked(evt);
            }
        });
        sacingsPanel.add(budgetLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 110, 40));

        SIdeBarPanel3.add(sacingsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, -1, 40));

        menuPanel.setBackground(new java.awt.Color(29, 45, 68));
        menuPanel.setForeground(new java.awt.Color(160, 170, 178));
        menuPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuPanelMouseClicked(evt);
            }
        });
        menuPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel30.setForeground(new java.awt.Color(204, 204, 204));
        jPanel30.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        menuPanel.add(jPanel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 40));

        mainMenu.setBackground(new java.awt.Color(41, 57, 80));
        mainMenu.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        mainMenu.setForeground(new java.awt.Color(255, 255, 255));
        mainMenu.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        mainMenu.setText("Main Menu");
        mainMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mainMenuMouseClicked(evt);
            }
        });
        menuPanel.add(mainMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 40));

        SIdeBarPanel3.add(menuPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 120, 40));

        WholePanel3.add(SIdeBarPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 470));

        InfoPanel3.setBackground(new java.awt.Color(240, 235, 216));

        rateField.setBackground(new java.awt.Color(240, 235, 216));
        rateField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        rateField.setForeground(new java.awt.Color(63, 64, 76));
        rateField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        timeField.setBackground(new java.awt.Color(240, 235, 216));
        timeField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        timeField.setForeground(new java.awt.Color(63, 64, 76));
        timeField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        interestField.setBackground(new java.awt.Color(240, 235, 216));
        interestField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        interestField.setForeground(new java.awt.Color(63, 64, 76));
        interestField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        totalField.setBackground(new java.awt.Color(240, 235, 216));
        totalField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        totalField.setForeground(new java.awt.Color(63, 64, 76));
        totalField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel13.setBackground(new java.awt.Color(240, 235, 216));
        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(63, 64, 76));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Principal:");

        jLabel14.setBackground(new java.awt.Color(240, 235, 216));
        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(63, 64, 76));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Rate:");

        jLabel16.setBackground(new java.awt.Color(240, 235, 216));
        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(63, 64, 76));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Time:");

        jLabel17.setBackground(new java.awt.Color(240, 235, 216));
        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(63, 64, 76));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("Total:");

        jLabel19.setBackground(new java.awt.Color(240, 235, 216));
        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(63, 64, 76));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("Interest:");

        principalField.setBackground(new java.awt.Color(240, 235, 216));
        principalField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        principalField.setForeground(new java.awt.Color(63, 64, 76));
        principalField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Edit.setBackground(new java.awt.Color(29, 45, 68));
        Edit.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        Edit.setForeground(new java.awt.Color(255, 255, 255));
        Edit.setText("Edit");
        Edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout InfoPanel3Layout = new javax.swing.GroupLayout(InfoPanel3);
        InfoPanel3.setLayout(InfoPanel3Layout);
        InfoPanel3Layout.setHorizontalGroup(
            InfoPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InfoPanel3Layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(Edit, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(157, Short.MAX_VALUE))
            .addGroup(InfoPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(InfoPanel3Layout.createSequentialGroup()
                    .addGap(183, 183, 183)
                    .addGroup(InfoPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(InfoPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(InfoPanel3Layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addGroup(InfoPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(interestField, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(timeField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(rateField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(principalField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InfoPanel3Layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(totalField, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(62, Short.MAX_VALUE)))
        );
        InfoPanel3Layout.setVerticalGroup(
            InfoPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InfoPanel3Layout.createSequentialGroup()
                .addContainerGap(282, Short.MAX_VALUE)
                .addComponent(Edit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
            .addGroup(InfoPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(InfoPanel3Layout.createSequentialGroup()
                    .addGap(106, 106, 106)
                    .addGroup(InfoPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(InfoPanel3Layout.createSequentialGroup()
                            .addGap(116, 116, 116)
                            .addComponent(jLabel17))
                        .addGroup(InfoPanel3Layout.createSequentialGroup()
                            .addGroup(InfoPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(principalField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel13))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(InfoPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel14)
                                .addComponent(rateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(InfoPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(timeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(InfoPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel19)
                                .addComponent(interestField, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(10, 10, 10)
                            .addComponent(totalField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(134, Short.MAX_VALUE)))
        );

        WholePanel3.add(InfoPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 390, 380));

        headerPanel.setBackground(new java.awt.Color(91, 139, 151));

        jLabel1.setBackground(new java.awt.Color(32, 33, 35));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Savings");

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(156, Short.MAX_VALUE))
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        WholePanel3.add(headerPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 520, 80));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(WholePanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(WholePanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void budgetLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_budgetLabel6MouseClicked
        BudgetInfoPage m = new BudgetInfoPage();
        m.setLocationRelativeTo(null);
        m.setVisible(true);
        this.hide();
    }//GEN-LAST:event_budgetLabel6MouseClicked

    private void budgetPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_budgetPanel3MouseClicked
        BudgetInfoPage m = new BudgetInfoPage();
        m.setLocationRelativeTo(null);
        m.setVisible(true);
        this.hide();
    }//GEN-LAST:event_budgetPanel3MouseClicked

    private void editInfoLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editInfoLabel3MouseClicked
        EditPersonalInfoPage m = new EditPersonalInfoPage();
        m.setLocationRelativeTo(null);
        m.setVisible(true);
        this.hide();
    }//GEN-LAST:event_editInfoLabel3MouseClicked

    private void editInfoPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editInfoPanel3MouseClicked
        EditPersonalInfoPage m = new EditPersonalInfoPage();
        m.setLocationRelativeTo(null);
        m.setVisible(true);
        this.hide();
    }//GEN-LAST:event_editInfoPanel3MouseClicked

    private void stocksLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stocksLabel3MouseClicked
        StocksInfoPage m = new StocksInfoPage();
        m.setLocationRelativeTo(null);
        m.setVisible(true);
        this.hide();
    }//GEN-LAST:event_stocksLabel3MouseClicked

    private void stocksPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stocksPanel4MouseClicked
        StocksInfoPage m = new StocksInfoPage();
        m.setLocationRelativeTo(null);
        m.setVisible(true);
        this.hide();
    }//GEN-LAST:event_stocksPanel4MouseClicked

    private void cryptoLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cryptoLabel3MouseClicked
        CryptoInfoPage m = new CryptoInfoPage();
        m.setLocationRelativeTo(null);
        m.setVisible(true);
        this.hide();
    }//GEN-LAST:event_cryptoLabel3MouseClicked

    private void CryptoPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CryptoPanel3MouseClicked
        // TODO add your handling code here:
        CryptoInfoPage m = new CryptoInfoPage();
        m.setLocationRelativeTo(null);
        m.setVisible(true);
        this.hide();
    }//GEN-LAST:event_CryptoPanel3MouseClicked

    private void budgetLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_budgetLabel8MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_budgetLabel8MouseClicked

    private void sacingsPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sacingsPanelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_sacingsPanelMouseClicked

    private void mainMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainMenuMouseClicked
        MainMenu m = new MainMenu();
        m.setLocationRelativeTo(null);
        m.setVisible(true);
        this.hide();
    }//GEN-LAST:event_mainMenuMouseClicked

    private void menuPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPanelMouseClicked
        MainMenu m = new MainMenu();
        m.setLocationRelativeTo(null);
        m.setVisible(true);
        this.hide();
    }//GEN-LAST:event_menuPanelMouseClicked

    private void EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditActionPerformed
        EditSavingsPage m = new EditSavingsPage();
        m.setLocationRelativeTo(null);
        m.setVisible(true);
        this.hide();
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
            java.util.logging.Logger.getLogger(SavingsInfoPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SavingsInfoPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SavingsInfoPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SavingsInfoPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SavingsInfoPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CryptoPanel3;
    private javax.swing.JButton Edit;
    private javax.swing.JPanel InfoPanel3;
    private javax.swing.JPanel SIdeBarPanel3;
    private javax.swing.JPanel WholePanel3;
    private javax.swing.JLabel budgetLabel6;
    private javax.swing.JLabel budgetLabel8;
    private javax.swing.JPanel budgetPanel3;
    private javax.swing.JLabel cryptoLabel3;
    private javax.swing.JLabel editInfoLabel3;
    private javax.swing.JPanel editInfoPanel3;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JTextField interestField;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel mainMenu;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JTextField principalField;
    private javax.swing.JTextField rateField;
    private javax.swing.JPanel sacingsPanel;
    private javax.swing.JLabel stocksLabel3;
    private javax.swing.JPanel stocksPanel4;
    private javax.swing.JTextField timeField;
    private javax.swing.JTextField totalField;
    // End of variables declaration//GEN-END:variables
}
