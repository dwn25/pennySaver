/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Pages;

import static com.Support.BudgetCalcsPage.auto;
import static com.Support.BudgetCalcsPage.billsAndUtils;
import static com.Support.BudgetCalcsPage.budgetNeeds;
import static com.Support.BudgetCalcsPage.budgetSavings;
import static com.Support.BudgetCalcsPage.budgetTotal;
import static com.Support.BudgetCalcsPage.budgetWants;
import static com.Support.BudgetCalcsPage.dineAndDrinks;
import static com.Support.BudgetCalcsPage.education;
import static com.Support.BudgetCalcsPage.entertainment;
import static com.Support.BudgetCalcsPage.fees;
import static com.Support.BudgetCalcsPage.home;
import static com.Support.BudgetCalcsPage.loans;
import static com.Support.BudgetCalcsPage.needs;
import static com.Support.BudgetCalcsPage.other;
import static com.Support.BudgetCalcsPage.personalCare;
import static com.Support.BudgetCalcsPage.shopping;
import static com.Support.BudgetCalcsPage.travel;
import static com.Support.BudgetCalcsPage.wants;
import com.Support.Constant;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author DNartey
 */
public class EditBudgetPage extends javax.swing.JFrame {
    String mainAdvice;
    Double home, shopping, dineAndDrinks, auto, travel, billsAndUtils,
        entertainment, fees, personalCare, loans, education, other;
    Double netIncome, needs, wants;
    Double budgetWants, budgetNeeds, budgetSavings, budgetTotal;
    /**
     * Creates new form EditBudgetPage
     */
    public EditBudgetPage() {
        setLocationRelativeTo(null);
        setResizable(false);
        initComponents();
        onRun();
    }
    
   public void onRun(){
       Constant.DoConnect();
       calcs();
       putFieldString(incomeField,"net_income");
       homeField.setText(null);
       homeField.setText(home.toString());
       shoppingField.setText(null);
       shoppingField.setText(shopping.toString());
       diningAndDrinksField.setText(null);
       diningAndDrinksField.setText(dineAndDrinks.toString());
       autoAndCommutingField.setText(null);
       autoAndCommutingField.setText(auto.toString());
       travelField.setText(null);
       travelField.setText(travel.toString());
       billsAndUtilitiesField.setText(null);
       billsAndUtilitiesField.setText(billsAndUtils.toString());
       entertainmentField.setText(null);
       entertainmentField.setText(entertainment.toString());
       feesField.setText(null);
       feesField.setText(fees.toString());
       loansField.setText(null);
       loansField.setText(loans.toString());
       educationField.setText(null);
       educationField.setText(education.toString());
       otherField.setText(null);
       otherField.setText(other.toString());
       personalCareField.setText(null);
       personalCareField.setText(personalCare.toString());
       mainAdvice = getCurrentState(getIncome(),budgetTotal);
       adviceTextArea.setText(null);
       adviceTextArea.setText(mainAdvice);
       updateBar(budgetNeeds, budgetWants, budgetSavings);
       
   }
 
    public void calcs(){
       home = getField("HOME");
       shopping = getField("SHOPPING");
       dineAndDrinks = getField("DINING_AND_DRINKS");
       auto = getField("AUTO");
       travel = getField("TRAVEL");
       billsAndUtils = getField("BILLS");
       entertainment = getField("ENTERTAINMENT");
       fees = getField("FEES");
       personalCare = getField("PERSONAL");
       loans = getField("LOANS");
       education = getField("EDUCATION");
       other = getField("OTHER");
       needs = home + dineAndDrinks + auto+ billsAndUtils  + loans+ fees + education ;
       wants = shopping + travel + entertainment +personalCare + other;
       budgetTotal = needs + wants;
       budgetNeeds = needs;
       budgetWants = (wants*0.6);
       budgetSavings = (wants*0.4);
   }
  
      public  void doCalcs(){
       needs = home + dineAndDrinks + auto+ billsAndUtils  + loans+ fees + education ;
       wants = shopping + travel + entertainment +personalCare + other;
       budgetTotal = needs + wants;
       budgetNeeds = needs;
       budgetWants = (wants*0.6);
       budgetSavings = (wants*0.4);
   }
  
    
    public  void updateBar( Double needs1, Double wants1, Double savings1){
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Necessary", needs1);
        dataset.setValue("Wants", wants1);
        dataset.setValue("Savings", savings1);
        JFreeChart barChart = ChartFactory.createPieChart(
        "Budget For The Week",
        dataset,
        false, true, false);
        barChart.setBackgroundPaint(new Color(51, 51, 51));
        
        PiePlot plot = (PiePlot) barChart.getPlot();
        plot.setLabelFont(new Font("SansSerif", Font.PLAIN, 12));
        
        plot.setNoDataMessage("No data available");
        plot.setCircular(false);
        plot.setLabelGap(0.02);
        plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0} = {2}", NumberFormat.getNumberInstance(), NumberFormat.getPercentInstance()));
        
        ChartPanel chartPanel = new ChartPanel( barChart );
        //chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );
        myChartPanel.removeAll();
        myChartPanel.add(chartPanel);
        myChartPanel.validate();
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
    
    

    public Double getIncome(){
        try{
            String SQL= "SELECT net_income From ROOT.PUSERS WHERE username= '"+Constant.currentUser+"'";    
            ResultSet rs = Constant.stmt.executeQuery(SQL);
            if(rs.next()){
                Double val = rs.getDouble("net_income");
                return val;
                }
            else{
                JOptionPane.showMessageDialog(rootPane, "Unable To Find Value");
            } 
        }catch(SQLException err){
        System.out.println("Unable to fetch income");
        }  
        return 0.0;
   }
    
   
   public Double getField(String column){
        try{
            String SQL= "SELECT " + column +" From ROOT.PBUDGET WHERE username= '"+Constant.currentUser+"'";    
            ResultSet rs = Constant.stmt.executeQuery(SQL);
            if(rs.next()){
                Double var = rs.getDouble(column); 
                return var;
            }
            else{
                JOptionPane.showMessageDialog(rootPane, "Unable To Find Value");
            } 
        }catch(SQLException err){
        System.out.println("Unable to fetch "+ column);
        }  
        return 0.0;
    }
   
   
   public String getCurrentState(Double income, Double budget){
       String advice1 = "Advice 1";
       String advice2 = "Advice 2";
       String advice3 = "Advice 3";
       if(income>budget){
           adviceTextArea.setText(null);
           adviceTextArea.setText(advice1);
           return advice1;
       }else if(budget>income){
            adviceTextArea.setText(null);
           adviceTextArea.setText(advice2);
           return advice2;
       }else{
           adviceTextArea.setText(null);
           adviceTextArea.setText(advice3);
           return advice3;
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

        jInternalFrame1 = new javax.swing.JInternalFrame();
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
        jLabel5 = new javax.swing.JLabel();
        InfoPanel = new javax.swing.JPanel();
        myChartPanel = new javax.swing.JPanel();
        headerPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();
        saveBTn = new javax.swing.JButton();
        resetBTn = new javax.swing.JButton();
        updateBTn = new javax.swing.JButton();
        dataEntryPanel = new javax.swing.JPanel();
        autoAndCommutingField = new javax.swing.JTextField();
        feesField = new javax.swing.JTextField();
        entertainmentField = new javax.swing.JTextField();
        homeField = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        diningAndDrinksField = new javax.swing.JTextField();
        personalCareField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        shoppingField = new javax.swing.JTextField();
        educationField = new javax.swing.JTextField();
        loansField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        billsAndUtilitiesField = new javax.swing.JTextField();
        travelField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        otherField = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        incomeField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        adviceTextArea = new javax.swing.JTextArea();
        menuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mainMenuItemBtn = new javax.swing.JMenuItem();
        budgetMenuItem = new javax.swing.JMenuItem();
        stocksMenuItem = new javax.swing.JMenuItem();
        cryptoMenuItem = new javax.swing.JMenuItem();
        savingsMenutItem = new javax.swing.JMenuItem();
        logoutMenuItem = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        WholePanel.setBackground(new java.awt.Color(91, 139, 151));
        WholePanel.setForeground(new java.awt.Color(255, 255, 255));

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

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/pSsmallLogo.png"))); // NOI18N
        SIdeBarPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        InfoPanel.setBackground(new java.awt.Color(240, 235, 216));

        myChartPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout InfoPanelLayout = new javax.swing.GroupLayout(InfoPanel);
        InfoPanel.setLayout(InfoPanelLayout);
        InfoPanelLayout.setHorizontalGroup(
            InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InfoPanelLayout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(myChartPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        InfoPanelLayout.setVerticalGroup(
            InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InfoPanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(myChartPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        headerPanel.setBackground(new java.awt.Color(91, 139, 151));

        jLabel1.setBackground(new java.awt.Color(32, 33, 35));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Your Budget Has Been Calculated Below");

        jLabel2.setBackground(new java.awt.Color(32, 33, 35));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Welcome back to PennySavers");

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 860, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 860, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        backBtn.setBackground(new java.awt.Color(91, 139, 151));
        backBtn.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        backBtn.setForeground(new java.awt.Color(255, 255, 255));
        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        saveBTn.setBackground(new java.awt.Color(91, 139, 151));
        saveBTn.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        saveBTn.setForeground(new java.awt.Color(255, 255, 255));
        saveBTn.setText("Save");
        saveBTn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBTnActionPerformed(evt);
            }
        });

        resetBTn.setBackground(new java.awt.Color(91, 139, 151));
        resetBTn.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        resetBTn.setForeground(new java.awt.Color(255, 255, 255));
        resetBTn.setText("Reset");
        resetBTn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBTnActionPerformed(evt);
            }
        });

        updateBTn.setBackground(new java.awt.Color(91, 139, 151));
        updateBTn.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        updateBTn.setForeground(new java.awt.Color(255, 255, 255));
        updateBTn.setText("Update");
        updateBTn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBTnActionPerformed(evt);
            }
        });

        dataEntryPanel.setBackground(new java.awt.Color(29, 45, 68));
        dataEntryPanel.setForeground(new java.awt.Color(255, 255, 255));

        autoAndCommutingField.setBackground(new java.awt.Color(29, 45, 68));
        autoAndCommutingField.setForeground(new java.awt.Color(255, 255, 255));

        feesField.setBackground(new java.awt.Color(29, 45, 68));
        feesField.setForeground(new java.awt.Color(255, 255, 255));

        entertainmentField.setBackground(new java.awt.Color(29, 45, 68));
        entertainmentField.setForeground(new java.awt.Color(255, 255, 255));

        homeField.setBackground(new java.awt.Color(29, 45, 68));
        homeField.setForeground(new java.awt.Color(255, 255, 255));
        homeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeFieldActionPerformed(evt);
            }
        });

        jLabel17.setBackground(new java.awt.Color(29, 45, 68));
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Loans:");

        jLabel16.setBackground(new java.awt.Color(29, 45, 68));
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Education:");

        jLabel15.setBackground(new java.awt.Color(29, 45, 68));
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Personal Care:");

        jLabel14.setBackground(new java.awt.Color(29, 45, 68));
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Fees:");

        jLabel13.setBackground(new java.awt.Color(29, 45, 68));
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Entertainment:");

        diningAndDrinksField.setBackground(new java.awt.Color(29, 45, 68));
        diningAndDrinksField.setForeground(new java.awt.Color(255, 255, 255));

        personalCareField.setBackground(new java.awt.Color(29, 45, 68));
        personalCareField.setForeground(new java.awt.Color(255, 255, 255));

        jLabel9.setBackground(new java.awt.Color(29, 45, 68));
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Shopping:");

        jLabel18.setBackground(new java.awt.Color(29, 45, 68));
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Other:");

        jLabel8.setBackground(new java.awt.Color(29, 45, 68));
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Dining & Drinks:");

        shoppingField.setBackground(new java.awt.Color(29, 45, 68));
        shoppingField.setForeground(new java.awt.Color(255, 255, 255));
        shoppingField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shoppingFieldActionPerformed(evt);
            }
        });

        educationField.setBackground(new java.awt.Color(29, 45, 68));
        educationField.setForeground(new java.awt.Color(255, 255, 255));

        loansField.setBackground(new java.awt.Color(29, 45, 68));
        loansField.setForeground(new java.awt.Color(255, 255, 255));

        jLabel7.setBackground(new java.awt.Color(29, 45, 68));
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Home:");

        billsAndUtilitiesField.setBackground(new java.awt.Color(29, 45, 68));
        billsAndUtilitiesField.setForeground(new java.awt.Color(255, 255, 255));

        travelField.setBackground(new java.awt.Color(29, 45, 68));
        travelField.setForeground(new java.awt.Color(255, 255, 255));

        jLabel12.setBackground(new java.awt.Color(29, 45, 68));
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Bills & Utilities:");

        jLabel11.setBackground(new java.awt.Color(29, 45, 68));
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Travel:");

        jLabel10.setBackground(new java.awt.Color(29, 45, 68));
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Auto & Commuting:");

        otherField.setBackground(new java.awt.Color(29, 45, 68));
        otherField.setForeground(new java.awt.Color(255, 255, 255));

        jLabel20.setBackground(new java.awt.Color(29, 45, 68));
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Income:");

        incomeField.setBackground(new java.awt.Color(29, 45, 68));
        incomeField.setForeground(new java.awt.Color(255, 255, 255));
        incomeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                incomeFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dataEntryPanelLayout = new javax.swing.GroupLayout(dataEntryPanel);
        dataEntryPanel.setLayout(dataEntryPanelLayout);
        dataEntryPanelLayout.setHorizontalGroup(
            dataEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dataEntryPanelLayout.createSequentialGroup()
                .addContainerGap(127, Short.MAX_VALUE)
                .addGroup(dataEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(incomeField, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(homeField, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(75, 75, 75))
            .addGroup(dataEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dataEntryPanelLayout.createSequentialGroup()
                    .addGap(81, 81, 81)
                    .addComponent(jLabel20)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(dataEntryPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(dataEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel10)
                        .addComponent(jLabel8)
                        .addComponent(jLabel13)
                        .addComponent(jLabel14)
                        .addComponent(jLabel15)
                        .addComponent(jLabel17)
                        .addComponent(jLabel12)
                        .addComponent(jLabel11)
                        .addComponent(jLabel9)
                        .addComponent(jLabel7)
                        .addComponent(jLabel18)
                        .addComponent(jLabel16))
                    .addGap(18, 18, 18)
                    .addGroup(dataEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(dataEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(shoppingField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(diningAndDrinksField, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(dataEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(dataEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(feesField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(entertainmentField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(billsAndUtilitiesField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(travelField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(autoAndCommutingField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(personalCareField, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(loansField, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(dataEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(otherField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(educationField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap(53, Short.MAX_VALUE)))
        );
        dataEntryPanelLayout.setVerticalGroup(
            dataEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataEntryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(incomeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(homeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(366, Short.MAX_VALUE))
            .addGroup(dataEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(dataEntryPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(dataEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(dataEntryPanelLayout.createSequentialGroup()
                            .addComponent(jLabel20)
                            .addGap(38, 38, 38)
                            .addComponent(jLabel9))
                        .addGroup(dataEntryPanelLayout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(shoppingField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(dataEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(diningAndDrinksField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(dataEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(autoAndCommutingField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(dataEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(travelField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel11))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(dataEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(billsAndUtilitiesField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel12))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(dataEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(entertainmentField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel13))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(dataEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(feesField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel14))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(dataEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(personalCareField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel15))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(dataEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(loansField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel17))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(dataEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(educationField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel16))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(dataEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(otherField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel18))))
                    .addContainerGap(46, Short.MAX_VALUE)))
        );

        adviceTextArea.setColumns(20);
        adviceTextArea.setRows(5);
        jScrollPane1.setViewportView(adviceTextArea);

        javax.swing.GroupLayout WholePanelLayout = new javax.swing.GroupLayout(WholePanel);
        WholePanel.setLayout(WholePanelLayout);
        WholePanelLayout.setHorizontalGroup(
            WholePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WholePanelLayout.createSequentialGroup()
                .addComponent(SIdeBarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 860, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(WholePanelLayout.createSequentialGroup()
                .addGap(167, 167, 167)
                .addGroup(WholePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(WholePanelLayout.createSequentialGroup()
                        .addComponent(updateBTn, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(resetBTn, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveBTn, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(WholePanelLayout.createSequentialGroup()
                        .addGroup(WholePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(InfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dataEntryPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        WholePanelLayout.setVerticalGroup(
            WholePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WholePanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(WholePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(WholePanelLayout.createSequentialGroup()
                        .addComponent(InfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dataEntryPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(WholePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(saveBTn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                    .addComponent(updateBTn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(resetBTn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(backBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(125, Short.MAX_VALUE))
            .addGroup(WholePanelLayout.createSequentialGroup()
                .addComponent(SIdeBarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 727, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(WholePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 760));

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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mainMenuItemBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainMenuItemBtnMouseClicked
        MainMenu m = new MainMenu();
        m.setLocationRelativeTo(null);
        m.setVisible(true);
        this.hide();
    }//GEN-LAST:event_mainMenuItemBtnMouseClicked

    private void mainMenuItemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainMenuItemBtnActionPerformed

    }//GEN-LAST:event_mainMenuItemBtnActionPerformed

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

    private void incomeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_incomeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_incomeFieldActionPerformed

    private void shoppingFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shoppingFieldActionPerformed

    }//GEN-LAST:event_shoppingFieldActionPerformed

    private void homeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeFieldActionPerformed

    }//GEN-LAST:event_homeFieldActionPerformed

    private void updateBTnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBTnActionPerformed
        Constant.DoConnect();
        try{
            String income1 = incomeField.getText();
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
            else if(income1.isEmpty()){
                JOptionPane.showMessageDialog(rootPane, "Income Cannot Be Empty");
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
                netIncome = Double.parseDouble(income1);

                /* System.out.println(netIncome);
                System.out.println(home + " " + shopping1 + " " + dineAndDrinks + " " + auto + " " + dineAndDrinks + " " +
                    billsAndUtils + " " +  entertainment + " " + fees + " " + personalCare + " " + loans + " " + education + " " + other);
                */
                doCalcs();
                getCurrentState(netIncome,budgetTotal);
                updateBar(budgetNeeds, budgetWants, budgetSavings);
            }
        }catch(NumberFormatException err){
            JOptionPane.showMessageDialog(rootPane, "Please Enter Only Numbers");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(rootPane, "An Error Occurred");
        }
    }//GEN-LAST:event_updateBTnActionPerformed

    private void resetBTnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBTnActionPerformed
        // TODO add your handling code here:
        String[] options={"Yes", "No"};
        int t =  JOptionPane.showOptionDialog(null, "Are You Sure You Want To Reset? Unsaved Data WIll Be Lost", "Confirm Reset", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if(t==JOptionPane.YES_OPTION){
            onRun();
        }
    }//GEN-LAST:event_resetBTnActionPerformed

    private void saveBTnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBTnActionPerformed
        Constant.DoConnect();
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
                    String sql = "UPDATE ROOT.PBUDGET SET \"HOME\" = ?, \"SHOPPING\" = ?, \"DINING_AND_DRINKS\" = ?, \"AUTO\" = ?, \"TRAVEL\" = ?, \"BILLS\" = ?, \"ENTERTAINMENT\" = ?, \"FEES\" = ?, \"PERSONAL\" = ?, \"LOANS\" = ?, \"EDUCATION\" = ?, \"OTHER\" = ? WHERE USERNAME = ?" +"";
                    PreparedStatement statement = Constant.con.prepareStatement(sql);
                    statement.setDouble(1, home);
                    statement.setDouble(2, shopping);
                    statement.setDouble(3, dineAndDrinks);
                    statement.setDouble(4, auto);
                    statement.setDouble(5, travel);
                    statement.setDouble(6, billsAndUtils);
                    statement.setDouble(7, entertainment);
                    statement.setDouble(8, fees);
                    statement.setDouble(9, personalCare);
                    statement.setDouble(10, loans);
                    statement.setDouble(11, education);
                    statement.setDouble(12, other);
                    statement.setString(13, Constant.currentUser);
                    int rowsInserted = statement.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Save Succesful");
                }
            }
        }catch(NumberFormatException err){
            JOptionPane.showMessageDialog(rootPane, "Please Enter Only Numbers");
        }catch(Exception ex){
            System.out.println(ex.toString());
            JOptionPane.showMessageDialog(rootPane, "Unable to Save");
        }
    }//GEN-LAST:event_saveBTnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure you want to leave without saving","Warning",dialogButton);
        if(dialogResult == JOptionPane.YES_OPTION){
            BudgetInfoPage m = new BudgetInfoPage();
            m.setLocationRelativeTo(null);
            m.setVisible(true);
            this.hide();
        }
    }//GEN-LAST:event_backBtnActionPerformed

    private void CryptoPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CryptoPanelMouseClicked
        // TODO add your handling code here:
        CryptoInfoPage m = new CryptoInfoPage();
        m.setLocationRelativeTo(null);
        m.setVisible(true);
        this.hide();
    }//GEN-LAST:event_CryptoPanelMouseClicked

    private void cryptoLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cryptoLabelMouseClicked

        CryptoInfoPage m = new CryptoInfoPage();
        m.setLocationRelativeTo(null);
        m.setVisible(true);
        this.hide();
    }//GEN-LAST:event_cryptoLabelMouseClicked

    private void stocksPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stocksPanel1MouseClicked
        StocksInfoPage m = new StocksInfoPage();
        m.setLocationRelativeTo(null);
        m.setVisible(true);
        this.hide();
    }//GEN-LAST:event_stocksPanel1MouseClicked

    private void stocksLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stocksLabelMouseClicked
        // TODO add your handling code here:
        StocksInfoPage m = new StocksInfoPage();
        m.setLocationRelativeTo(null);
        m.setVisible(true);
        this.hide();
    }//GEN-LAST:event_stocksLabelMouseClicked

    private void editInfoPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editInfoPanelMouseClicked
        EditPersonalInfoPage m = new EditPersonalInfoPage();
        m.setLocationRelativeTo(null);
        m.setVisible(true);
        this.hide();
    }//GEN-LAST:event_editInfoPanelMouseClicked

    private void editInfoLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editInfoLabelMouseClicked
        // TODO add your handling code here:
        EditPersonalInfoPage m = new EditPersonalInfoPage();
        m.setLocationRelativeTo(null);
        m.setVisible(true);
        this.hide();
    }//GEN-LAST:event_editInfoLabelMouseClicked

    private void savingsPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_savingsPanelMouseClicked
        SavingsInfoPage m = new SavingsInfoPage();
        m.setLocationRelativeTo(null);
        m.setVisible(true);
        this.hide();
    }//GEN-LAST:event_savingsPanelMouseClicked

    private void savingsLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_savingsLabelMouseClicked
        // TODO add your handling code here:
        SavingsInfoPage m = new SavingsInfoPage();
        m.setLocationRelativeTo(null);
        m.setVisible(true);
        this.hide();
    }//GEN-LAST:event_savingsLabelMouseClicked

    private void budgetPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_budgetPanelMouseClicked
        BudgetInfoPage m = new BudgetInfoPage();
        m.setLocationRelativeTo(null);
        m.setVisible(true);
        this.hide();
    }//GEN-LAST:event_budgetPanelMouseClicked

    private void budgetLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_budgetLabelMouseClicked
        BudgetInfoPage m = new BudgetInfoPage();
        m.setLocationRelativeTo(null);
        m.setVisible(true);
        this.hide();
    }//GEN-LAST:event_budgetLabelMouseClicked

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
            java.util.logging.Logger.getLogger(EditBudgetPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditBudgetPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditBudgetPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditBudgetPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditBudgetPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CryptoPanel;
    private javax.swing.JPanel InfoPanel;
    private javax.swing.JPanel SIdeBarPanel;
    private javax.swing.JPanel WholePanel;
    private javax.swing.JTextArea adviceTextArea;
    private javax.swing.JTextField autoAndCommutingField;
    private javax.swing.JButton backBtn;
    private javax.swing.JTextField billsAndUtilitiesField;
    private javax.swing.JLabel budgetLabel;
    private javax.swing.JMenuItem budgetMenuItem;
    private javax.swing.JPanel budgetPanel;
    private javax.swing.JLabel cryptoLabel;
    private javax.swing.JMenuItem cryptoMenuItem;
    private javax.swing.JPanel dataEntryPanel;
    private javax.swing.JTextField diningAndDrinksField;
    private javax.swing.JLabel editInfoLabel;
    private javax.swing.JPanel editInfoPanel;
    private javax.swing.JTextField educationField;
    private javax.swing.JTextField entertainmentField;
    private javax.swing.JTextField feesField;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JTextField homeField;
    private javax.swing.JTextField incomeField;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField loansField;
    private javax.swing.JMenuItem logoutMenuItem;
    private javax.swing.JMenuItem mainMenuItemBtn;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JPanel myChartPanel;
    private javax.swing.JTextField otherField;
    private javax.swing.JTextField personalCareField;
    private javax.swing.JButton resetBTn;
    private javax.swing.JButton saveBTn;
    private javax.swing.JLabel savingsLabel;
    private javax.swing.JMenuItem savingsMenutItem;
    private javax.swing.JPanel savingsPanel;
    private javax.swing.JTextField shoppingField;
    private javax.swing.JLabel stocksLabel;
    private javax.swing.JMenuItem stocksMenuItem;
    private javax.swing.JPanel stocksPanel1;
    private javax.swing.JTextField travelField;
    private javax.swing.JButton updateBTn;
    // End of variables declaration//GEN-END:variables
}
