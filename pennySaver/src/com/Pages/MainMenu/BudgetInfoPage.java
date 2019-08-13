package com.Pages.MainMenu;

import com.Pages.EditPages.EditBudgetPage;
import com.Pages.Main.Main;
import com.Support.Constant;
import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.RingPlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.RectangleInsets;
import org.jfree.util.UnitType;

/**
 *
 * @author DNartey
 */

public class BudgetInfoPage extends javax.swing.JFrame {
    String mainAdvice;
    Double home, shopping, dineAndDrinks, auto, travel, billsAndUtils,
        entertainment, fees, personalCare, loans, education, other;
    Double netIncome, needs, wants;
    Double budgetWants, budgetNeeds, budgetSavings, budgetTotal;
    //private static final String KEY1 = "Datum 1";
    //public static final String KEY2 = "Datum 2";
    /**
     * Creates new form BudgettingInfoPage
     */
    public BudgetInfoPage() {
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
       
    public void getFieldString(javax.swing.JTextField JtexTield, String column){
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
    public void updateBar(Double needs1, Double wants1, Double savings1){
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Necessary", needs1);
        dataset.setValue("Wants", wants1);
        dataset.setValue("Savings", savings1);
        JFreeChart barChart = ChartFactory.createPieChart(
        "Budget For The Week",
        dataset,
        false, true, false);
        barChart.setBackgroundPaint(new Color(240,235,216));
        barChart.getTitle().setPaint(new Color(29,45,68));
    
        PiePlot plot = (PiePlot) barChart.getPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setOutlineVisible(false);
        plot.setShadowPaint(null);
        plot.setSimpleLabels(true);
        plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0} = {2}", NumberFormat.getNumberInstance(), NumberFormat.getPercentInstance()));

        plot.setLabelFont(new Font("Takoma", Font.PLAIN, 12));
        plot.setLabelPaint(Color.BLACK);
        //plot.setLabelBackgroundPaint(paint);
        plot.setBackgroundPaint(null);
        plot.setLabelOutlinePaint(null);
        plot.setLabelShadowPaint(null);
        plot.setSectionOutlinesVisible(false);
        //plot.setSeparatorsVisible(false);
        
        plot.setNoDataMessage("No data available");
        plot.setCircular(true);
        plot.setIgnoreZeroValues(true);
        plot.setIgnoreNullValues(true);
        plot.setSimpleLabelOffset(new RectangleInsets(UnitType.RELATIVE, 0.09, 0.09, 0.09, 0.09));
        //plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{1}"));

        ChartPanel chartPanel = new ChartPanel( barChart );
        //chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );
        myChartPanel.removeAll();
        myChartPanel.add(chartPanel);
        myChartPanel.validate();
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
        jLabel2 = new javax.swing.JLabel();
        DataPanel = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        personalCareField = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        educationField = new javax.swing.JTextField();
        loansField = new javax.swing.JTextField();
        feesField = new javax.swing.JTextField();
        otherField = new javax.swing.JTextField();
        entertainmentField = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        adviceTextArea = new javax.swing.JTextArea();
        SIdeBarPanel = new javax.swing.JPanel();
        stocksPanel1 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        stocksLabel = new javax.swing.JLabel();
        CryptoPanel = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        cryptoLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        mainMenu = new javax.swing.JToggleButton();
        logoutBtn = new javax.swing.JToggleButton();
        budgetSelected = new javax.swing.JToggleButton();
        budgetSelected1 = new javax.swing.JToggleButton();
        savingsNormal = new javax.swing.JToggleButton();
        editinfoBtn = new javax.swing.JToggleButton();
        jPanel1 = new javax.swing.JPanel();
        homeField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        shoppingField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        diningAndDrinksField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        autoAndCommutingField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        travelField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        billsAndUtilitiesField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        incomeField = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        myChartPanel = new javax.swing.JPanel();
        Edit1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        WholePanel.setBackground(new java.awt.Color(240, 235, 216));
        WholePanel.setForeground(new java.awt.Color(255, 255, 255));
        WholePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        headerPanel.setBackground(new java.awt.Color(34, 47, 66));

        jLabel1.setBackground(new java.awt.Color(34, 47, 66));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Weekly Budget");

        jLabel2.setBackground(new java.awt.Color(34, 47, 66));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Your Budget Has Been Calculated Below");

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 810, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        WholePanel.add(headerPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 810, 100));

        DataPanel.setBackground(new java.awt.Color(240, 235, 216));
        DataPanel.setForeground(new java.awt.Color(63, 64, 76));

        jLabel16.setBackground(new java.awt.Color(240, 235, 216));
        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(63, 64, 76));
        jLabel16.setText("Education:");

        jLabel15.setBackground(new java.awt.Color(240, 235, 216));
        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(63, 64, 76));
        jLabel15.setText("Personal Care:");

        jLabel14.setBackground(new java.awt.Color(240, 235, 216));
        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(63, 64, 76));
        jLabel14.setText("Fees:");

        jLabel13.setBackground(new java.awt.Color(240, 235, 216));
        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(63, 64, 76));
        jLabel13.setText("Entertainment:");

        personalCareField.setEditable(false);
        personalCareField.setBackground(new java.awt.Color(240, 235, 216));
        personalCareField.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        personalCareField.setForeground(new java.awt.Color(63, 64, 76));

        jLabel18.setBackground(new java.awt.Color(240, 235, 216));
        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(63, 64, 76));
        jLabel18.setText("Other:");

        educationField.setEditable(false);
        educationField.setBackground(new java.awt.Color(240, 235, 216));
        educationField.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        educationField.setForeground(new java.awt.Color(63, 64, 76));

        loansField.setEditable(false);
        loansField.setBackground(new java.awt.Color(240, 235, 216));
        loansField.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        loansField.setForeground(new java.awt.Color(63, 64, 76));

        feesField.setEditable(false);
        feesField.setBackground(new java.awt.Color(240, 235, 216));
        feesField.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        feesField.setForeground(new java.awt.Color(63, 64, 76));

        otherField.setEditable(false);
        otherField.setBackground(new java.awt.Color(240, 235, 216));
        otherField.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        otherField.setForeground(new java.awt.Color(63, 64, 76));

        entertainmentField.setEditable(false);
        entertainmentField.setBackground(new java.awt.Color(240, 235, 216));
        entertainmentField.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        entertainmentField.setForeground(new java.awt.Color(63, 64, 76));

        jLabel17.setBackground(new java.awt.Color(240, 235, 216));
        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(63, 64, 76));
        jLabel17.setText("Loans:");

        javax.swing.GroupLayout DataPanelLayout = new javax.swing.GroupLayout(DataPanel);
        DataPanel.setLayout(DataPanelLayout);
        DataPanelLayout.setHorizontalGroup(
            DataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DataPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(DataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(feesField, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(entertainmentField, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(personalCareField, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(loansField, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(DataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(otherField, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(educationField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(45, 45, 45))
        );
        DataPanelLayout.setVerticalGroup(
            DataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DataPanelLayout.createSequentialGroup()
                .addGroup(DataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(entertainmentField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(feesField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(personalCareField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loansField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGap(6, 6, 6)
                .addGroup(DataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(educationField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(otherField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGap(0, 36, Short.MAX_VALUE))
        );

        WholePanel.add(DataPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 130, 200, 210));

        adviceTextArea.setBackground(new java.awt.Color(240, 235, 216));
        adviceTextArea.setColumns(20);
        adviceTextArea.setForeground(new java.awt.Color(63, 64, 76));
        adviceTextArea.setRows(5);
        jScrollPane1.setViewportView(adviceTextArea);

        WholePanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 340, 430, 90));

        SIdeBarPanel.setBackground(new java.awt.Color(29, 45, 68));
        SIdeBarPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        stocksPanel1.add(stocksLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 110, 40));

        SIdeBarPanel.add(stocksPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 120, 40));

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
        CryptoPanel.add(cryptoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 110, 40));

        SIdeBarPanel.add(CryptoPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 120, 40));

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
        SIdeBarPanel.add(logoutBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 130, 50));

        budgetSelected.setBackground(new java.awt.Color(240, 235, 216));
        budgetSelected.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/Logos/MenuButtons/BudgetSelected.jpg"))); // NOI18N
        budgetSelected.setBorder(null);
        budgetSelected.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                budgetSelectedMouseClicked(evt);
            }
        });
        budgetSelected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                budgetSelectedActionPerformed(evt);
            }
        });
        SIdeBarPanel.add(budgetSelected, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 130, 50));

        budgetSelected1.setBackground(new java.awt.Color(240, 235, 216));
        budgetSelected1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/Logos/MenuButtons/BudgetSelected.jpg"))); // NOI18N
        budgetSelected1.setBorder(null);
        budgetSelected1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                budgetSelected1MouseClicked(evt);
            }
        });
        budgetSelected1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                budgetSelected1ActionPerformed(evt);
            }
        });
        SIdeBarPanel.add(budgetSelected1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 130, 50));

        savingsNormal.setBackground(new java.awt.Color(41, 57, 80));
        savingsNormal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/Logos/MenuButtons/SavingsNormal.jpg"))); // NOI18N
        savingsNormal.setBorder(null);
        savingsNormal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                savingsNormalMouseClicked(evt);
            }
        });
        savingsNormal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savingsNormalActionPerformed(evt);
            }
        });
        SIdeBarPanel.add(savingsNormal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 130, 50));

        editinfoBtn.setBackground(new java.awt.Color(41, 57, 80));
        editinfoBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/Logos/MenuButtons/EditInfoNormal.jpg"))); // NOI18N
        editinfoBtn.setBorder(null);
        editinfoBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editinfoBtnMouseClicked(evt);
            }
        });
        editinfoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editinfoBtnActionPerformed(evt);
            }
        });
        SIdeBarPanel.add(editinfoBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 130, 50));

        WholePanel.add(SIdeBarPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 490));

        jPanel1.setBackground(new java.awt.Color(240, 235, 216));

        homeField.setEditable(false);
        homeField.setBackground(new java.awt.Color(240, 235, 216));
        homeField.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        homeField.setForeground(new java.awt.Color(63, 64, 76));
        homeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeFieldActionPerformed(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(29, 45, 68));
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(63, 64, 76));
        jLabel7.setText("Home:");

        shoppingField.setEditable(false);
        shoppingField.setBackground(new java.awt.Color(240, 235, 216));
        shoppingField.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        shoppingField.setForeground(new java.awt.Color(63, 64, 76));
        shoppingField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shoppingFieldActionPerformed(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(29, 45, 68));
        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(63, 64, 76));
        jLabel9.setText("Shopping:");

        diningAndDrinksField.setEditable(false);
        diningAndDrinksField.setBackground(new java.awt.Color(240, 235, 216));
        diningAndDrinksField.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        diningAndDrinksField.setForeground(new java.awt.Color(63, 64, 76));

        jLabel8.setBackground(new java.awt.Color(29, 45, 68));
        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(63, 64, 76));
        jLabel8.setText("Dining & Drinks:");

        autoAndCommutingField.setEditable(false);
        autoAndCommutingField.setBackground(new java.awt.Color(240, 235, 216));
        autoAndCommutingField.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        autoAndCommutingField.setForeground(new java.awt.Color(63, 64, 76));

        jLabel10.setBackground(new java.awt.Color(29, 45, 68));
        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(63, 64, 76));
        jLabel10.setText("Auto & Commuting:");

        travelField.setEditable(false);
        travelField.setBackground(new java.awt.Color(240, 235, 216));
        travelField.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        travelField.setForeground(new java.awt.Color(63, 64, 76));

        jLabel11.setBackground(new java.awt.Color(29, 45, 68));
        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(63, 64, 76));
        jLabel11.setText("Travel:");

        billsAndUtilitiesField.setEditable(false);
        billsAndUtilitiesField.setBackground(new java.awt.Color(240, 235, 216));
        billsAndUtilitiesField.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        billsAndUtilitiesField.setForeground(new java.awt.Color(63, 64, 76));

        jLabel12.setBackground(new java.awt.Color(29, 45, 68));
        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(63, 64, 76));
        jLabel12.setText("Bills & Utilities:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(billsAndUtilitiesField, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(homeField, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(diningAndDrinksField, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(autoAndCommutingField, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(travelField, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(shoppingField, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(diningAndDrinksField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(autoAndCommutingField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(travelField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(homeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(shoppingField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(billsAndUtilitiesField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(0, 36, Short.MAX_VALUE))
        );

        WholePanel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 130, 230, 210));

        incomeField.setEditable(false);
        incomeField.setBackground(new java.awt.Color(240, 235, 216));
        incomeField.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        incomeField.setForeground(new java.awt.Color(63, 64, 76));
        incomeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                incomeFieldActionPerformed(evt);
            }
        });
        WholePanel.add(incomeField, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 100, 86, -1));

        jLabel21.setBackground(new java.awt.Color(240, 235, 216));
        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(63, 64, 76));
        jLabel21.setText("Income:");
        WholePanel.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 100, -1, -1));

        myChartPanel.setLayout(new java.awt.BorderLayout());
        WholePanel.add(myChartPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 380, 330));

        Edit1.setBackground(new java.awt.Color(29, 45, 68));
        Edit1.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        Edit1.setForeground(new java.awt.Color(255, 255, 255));
        Edit1.setText("Edit");
        Edit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Edit1ActionPerformed(evt);
            }
        });
        WholePanel.add(Edit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 440, 130, 40));

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

    

   
 
   
    private void shoppingFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shoppingFieldActionPerformed

    }//GEN-LAST:event_shoppingFieldActionPerformed

    private void homeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeFieldActionPerformed

    }//GEN-LAST:event_homeFieldActionPerformed

    private void incomeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_incomeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_incomeFieldActionPerformed

    private void stocksLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stocksLabelMouseClicked
        StocksInfoPage m = new StocksInfoPage();
        m.setLocationRelativeTo(null);
        m.setVisible(true);
        this.hide();
    }//GEN-LAST:event_stocksLabelMouseClicked

    private void stocksPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stocksPanel1MouseClicked
        StocksInfoPage m = new StocksInfoPage();
        m.setLocationRelativeTo(null);
        m.setVisible(true);
        this.hide();
    }//GEN-LAST:event_stocksPanel1MouseClicked

    private void cryptoLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cryptoLabelMouseClicked

        CryptoInfoPage m = new CryptoInfoPage();
        m.setLocationRelativeTo(null);
        m.setVisible(true);
        this.hide();
    }//GEN-LAST:event_cryptoLabelMouseClicked

    private void CryptoPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CryptoPanelMouseClicked
        CryptoInfoPage m = new CryptoInfoPage();
        m.setLocationRelativeTo(null);
        m.setVisible(true);
        this.hide();
    }//GEN-LAST:event_CryptoPanelMouseClicked

    private void Edit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Edit1ActionPerformed
        EditBudgetPage m = new EditBudgetPage();
        m.setVisible(true);
        this.hide();
    }//GEN-LAST:event_Edit1ActionPerformed

    private void mainMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainMenuMouseClicked
        // TODO add your handling code here:
        MainMenu m = new MainMenu();
        m.setVisible(true);
        this.hide();
    }//GEN-LAST:event_mainMenuMouseClicked

    private void mainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainMenuActionPerformed

    }//GEN-LAST:event_mainMenuActionPerformed

    private void logoutBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutBtnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_logoutBtnMouseClicked

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        // TODO add your handling code here:
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

    private void budgetSelectedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_budgetSelectedMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_budgetSelectedMouseClicked

    private void budgetSelectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_budgetSelectedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_budgetSelectedActionPerformed

    private void budgetSelected1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_budgetSelected1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_budgetSelected1MouseClicked

    private void budgetSelected1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_budgetSelected1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_budgetSelected1ActionPerformed

    private void savingsNormalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_savingsNormalMouseClicked
        // TODO add your handling code here:
        SavingsInfoPage m = new SavingsInfoPage();
        m.setLocationRelativeTo(null);
        m.setVisible(true);
        this.hide();
    }//GEN-LAST:event_savingsNormalMouseClicked

    private void savingsNormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savingsNormalActionPerformed

    }//GEN-LAST:event_savingsNormalActionPerformed

    private void editinfoBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editinfoBtnMouseClicked
        // TODO add your handling code here:
        EditPersonalInfoPage m = new EditPersonalInfoPage();
        m.setVisible(true);
        this.hide();
    }//GEN-LAST:event_editinfoBtnMouseClicked

    private void editinfoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editinfoBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editinfoBtnActionPerformed

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
    private javax.swing.JPanel CryptoPanel;
    private javax.swing.JPanel DataPanel;
    private javax.swing.JButton Edit1;
    private javax.swing.JPanel SIdeBarPanel;
    private javax.swing.JPanel WholePanel;
    private javax.swing.JTextArea adviceTextArea;
    private javax.swing.JTextField autoAndCommutingField;
    private javax.swing.JTextField billsAndUtilitiesField;
    private javax.swing.JToggleButton budgetSelected;
    private javax.swing.JToggleButton budgetSelected1;
    private javax.swing.JLabel cryptoLabel;
    private javax.swing.JTextField diningAndDrinksField;
    private javax.swing.JToggleButton editinfoBtn;
    private javax.swing.JTextField educationField;
    private javax.swing.JTextField entertainmentField;
    private javax.swing.JTextField feesField;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JTextField homeField;
    private javax.swing.JTextField incomeField;
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
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField loansField;
    private javax.swing.JToggleButton logoutBtn;
    private javax.swing.JToggleButton mainMenu;
    private javax.swing.JPanel myChartPanel;
    private javax.swing.JTextField otherField;
    private javax.swing.JTextField personalCareField;
    private javax.swing.JToggleButton savingsNormal;
    private javax.swing.JTextField shoppingField;
    private javax.swing.JLabel stocksLabel;
    private javax.swing.JPanel stocksPanel1;
    private javax.swing.JTextField travelField;
    // End of variables declaration//GEN-END:variables
}
