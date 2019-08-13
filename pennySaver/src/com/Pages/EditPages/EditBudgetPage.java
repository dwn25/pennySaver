package com.Pages.EditPages;

import com.Pages.Main.Main;
import com.Pages.MainMenu.BudgetInfoPage;
import com.Pages.MainMenu.CryptoInfoPage;
import com.Pages.MainMenu.EditPersonalInfoPage;
import com.Pages.MainMenu.MainMenu;
import com.Pages.MainMenu.SavingsInfoPage;
import com.Pages.MainMenu.StocksInfoPage;
import com.Support.Constant;
import java.awt.Color;
import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.RectangleInsets;
import org.jfree.util.UnitType;

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
       updateBar();
       updateSecondBar();
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
        //plot.setLabelBackgroundPaint(color.WHITE);
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
        budgetChart.removeAll();
        budgetChart.add(chartPanel);
        budgetChart.validate();
    }
    
    public void updateBar(){
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Home", home);
        dataset.setValue("Dining & Drinks", dineAndDrinks);
        dataset.setValue("Auto", auto);
        dataset.setValue("Bills", billsAndUtils);
        dataset.setValue("Loans", loans);
        dataset.setValue("Fees", fees);
        dataset.setValue("Education", education);
        JFreeChart barChart = ChartFactory.createPieChart(
        "Needs",
        dataset,
        false, true, false);
        barChart.setBackgroundPaint(new Color(240,235,216));
        barChart.getTitle().setPaint(new Color(29,45,68));

        PiePlot plot = (PiePlot) barChart.getPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setOutlineVisible(false);
        plot.setShadowPaint(null);
        //plot.setSimpleLabels(true);
        plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0} = {2}", NumberFormat.getNumberInstance(), NumberFormat.getPercentInstance()));

        plot.setLabelFont(new Font("Takoma", Font.PLAIN, 12));
        plot.setLabelPaint(Color.BLACK);
        //plot.setLabelBackgroundPaint(color.WHITE);
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
        myChartPanel2.removeAll();
        myChartPanel2.add(chartPanel);
        myChartPanel2.validate();
    }
    
    public void updateSecondBar(){
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Shopping", shopping);
        dataset.setValue("Travel", travel);
        dataset.setValue("Entertainment", entertainment);
        dataset.setValue("Personal Care", personalCare);
        dataset.setValue("Other", other);
        JFreeChart barChart = ChartFactory.createPieChart(
        "Wants",
         dataset,
        false, true, false);
        barChart.setBackgroundPaint(new Color(240,235,216));
        barChart.getTitle().setPaint(new Color(29,45,68));

        PiePlot plot = (PiePlot) barChart.getPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setOutlineVisible(false);
        plot.setShadowPaint(null);
        //plot.setSimpleLabels(true);
        plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0} = {2}", NumberFormat.getNumberInstance(), NumberFormat.getPercentInstance()));

        plot.setLabelFont(new Font("Takoma", Font.PLAIN, 12));
        plot.setLabelPaint(Color.BLACK);
        //plot.setLabelBackgroundPaint(color.WHITE);
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
        myChartPanel1.removeAll();
        myChartPanel1.add(chartPanel);
        myChartPanel1.validate();
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
        InfoPanel = new javax.swing.JPanel();
        ADVICE = new javax.swing.JScrollPane();
        adviceTextArea = new javax.swing.JTextArea();
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
        allCharts = new javax.swing.JPanel();
        myChartPanel2 = new javax.swing.JPanel();
        myChartPanel1 = new javax.swing.JPanel();
        budgetChart = new javax.swing.JPanel();
        resetBTn = new javax.swing.JButton();
        updateBTn = new javax.swing.JButton();
        saveBTn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        headerPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        SIdeBarPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        SIdeBarPanel1 = new javax.swing.JPanel();
        stocksPanel1 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        stocksLabel = new javax.swing.JLabel();
        CryptoPanel = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        cryptoLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        mainMenu = new javax.swing.JToggleButton();
        logoutBtn = new javax.swing.JToggleButton();
        budgetSelected1 = new javax.swing.JToggleButton();
        savingsNormal = new javax.swing.JToggleButton();
        editinfoBtn = new javax.swing.JToggleButton();

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

        WholePanel.setBackground(new java.awt.Color(240, 235, 216));
        WholePanel.setForeground(new java.awt.Color(255, 255, 255));
        WholePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        InfoPanel.setBackground(new java.awt.Color(240, 235, 216));
        InfoPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        adviceTextArea.setBackground(new java.awt.Color(240, 235, 216));
        adviceTextArea.setColumns(20);
        adviceTextArea.setForeground(new java.awt.Color(63, 64, 76));
        adviceTextArea.setRows(5);
        ADVICE.setViewportView(adviceTextArea);

        InfoPanel.add(ADVICE, new org.netbeans.lib.awtextra.AbsoluteConstraints(512, 260, 428, 110));

        dataEntryPanel.setBackground(new java.awt.Color(240, 235, 216));
        dataEntryPanel.setForeground(new java.awt.Color(255, 255, 255));

        autoAndCommutingField.setBackground(new java.awt.Color(240, 235, 216));
        autoAndCommutingField.setForeground(new java.awt.Color(63, 64, 76));

        feesField.setBackground(new java.awt.Color(240, 235, 216));
        feesField.setForeground(new java.awt.Color(63, 64, 76));

        entertainmentField.setBackground(new java.awt.Color(240, 235, 216));
        entertainmentField.setForeground(new java.awt.Color(63, 64, 76));

        homeField.setBackground(new java.awt.Color(240, 235, 216));
        homeField.setForeground(new java.awt.Color(63, 64, 76));
        homeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeFieldActionPerformed(evt);
            }
        });

        jLabel17.setBackground(new java.awt.Color(29, 45, 68));
        jLabel17.setForeground(new java.awt.Color(63, 64, 76));
        jLabel17.setText("Loans:");

        jLabel16.setBackground(new java.awt.Color(29, 45, 68));
        jLabel16.setForeground(new java.awt.Color(63, 64, 76));
        jLabel16.setText("Education:");

        jLabel15.setBackground(new java.awt.Color(29, 45, 68));
        jLabel15.setForeground(new java.awt.Color(63, 64, 76));
        jLabel15.setText("Personal Care:");

        jLabel14.setBackground(new java.awt.Color(29, 45, 68));
        jLabel14.setForeground(new java.awt.Color(63, 64, 76));
        jLabel14.setText("Fees:");

        jLabel13.setBackground(new java.awt.Color(29, 45, 68));
        jLabel13.setForeground(new java.awt.Color(63, 64, 76));
        jLabel13.setText("Entertainment:");

        diningAndDrinksField.setBackground(new java.awt.Color(240, 235, 216));
        diningAndDrinksField.setForeground(new java.awt.Color(63, 64, 76));

        personalCareField.setBackground(new java.awt.Color(240, 235, 216));
        personalCareField.setForeground(new java.awt.Color(63, 64, 76));

        jLabel9.setBackground(new java.awt.Color(29, 45, 68));
        jLabel9.setForeground(new java.awt.Color(63, 64, 76));
        jLabel9.setText("Shopping:");

        jLabel18.setBackground(new java.awt.Color(29, 45, 68));
        jLabel18.setForeground(new java.awt.Color(63, 64, 76));
        jLabel18.setText("Other:");

        jLabel8.setBackground(new java.awt.Color(29, 45, 68));
        jLabel8.setForeground(new java.awt.Color(63, 64, 76));
        jLabel8.setText("Dining & Drinks:");

        shoppingField.setBackground(new java.awt.Color(240, 235, 216));
        shoppingField.setForeground(new java.awt.Color(63, 64, 76));
        shoppingField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shoppingFieldActionPerformed(evt);
            }
        });

        educationField.setBackground(new java.awt.Color(240, 235, 216));
        educationField.setForeground(new java.awt.Color(63, 64, 76));

        loansField.setBackground(new java.awt.Color(240, 235, 216));
        loansField.setForeground(new java.awt.Color(63, 64, 76));

        jLabel7.setBackground(new java.awt.Color(29, 45, 68));
        jLabel7.setForeground(new java.awt.Color(63, 64, 76));
        jLabel7.setText("Home:");

        billsAndUtilitiesField.setBackground(new java.awt.Color(240, 235, 216));
        billsAndUtilitiesField.setForeground(new java.awt.Color(63, 64, 76));

        travelField.setBackground(new java.awt.Color(240, 235, 216));
        travelField.setForeground(new java.awt.Color(63, 64, 76));

        jLabel12.setBackground(new java.awt.Color(29, 45, 68));
        jLabel12.setForeground(new java.awt.Color(63, 64, 76));
        jLabel12.setText("Bills & Utilities:");

        jLabel11.setBackground(new java.awt.Color(29, 45, 68));
        jLabel11.setForeground(new java.awt.Color(63, 64, 76));
        jLabel11.setText("Travel:");

        jLabel10.setBackground(new java.awt.Color(29, 45, 68));
        jLabel10.setForeground(new java.awt.Color(63, 64, 76));
        jLabel10.setText("Auto & Commuting:");

        otherField.setBackground(new java.awt.Color(240, 235, 216));
        otherField.setForeground(new java.awt.Color(63, 64, 76));

        jLabel20.setBackground(new java.awt.Color(29, 45, 68));
        jLabel20.setForeground(new java.awt.Color(63, 64, 76));
        jLabel20.setText("Income:");

        incomeField.setBackground(new java.awt.Color(240, 235, 216));
        incomeField.setForeground(new java.awt.Color(63, 64, 76));
        incomeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                incomeFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dataEntryPanelLayout = new javax.swing.GroupLayout(dataEntryPanel);
        dataEntryPanel.setLayout(dataEntryPanelLayout);
        dataEntryPanelLayout.setHorizontalGroup(
            dataEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataEntryPanelLayout.createSequentialGroup()
                .addGroup(dataEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dataEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(dataEntryPanelLayout.createSequentialGroup()
                        .addComponent(incomeField, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(feesField))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dataEntryPanelLayout.createSequentialGroup()
                        .addComponent(entertainmentField, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(211, 211, 211))
                    .addGroup(dataEntryPanelLayout.createSequentialGroup()
                        .addGroup(dataEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(diningAndDrinksField, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(travelField, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(autoAndCommutingField, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(shoppingField, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(homeField, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(dataEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dataEntryPanelLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(dataEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dataEntryPanelLayout.createSequentialGroup()
                                        .addGroup(dataEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel18)
                                            .addComponent(jLabel16))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(dataEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(otherField, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(educationField, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dataEntryPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addGap(12, 12, 12)
                                        .addComponent(loansField, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(dataEntryPanelLayout.createSequentialGroup()
                                .addGroup(dataEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(dataEntryPanelLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel15))
                                    .addComponent(jLabel12))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(dataEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(billsAndUtilitiesField, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                                    .addComponent(personalCareField))))))
                .addGap(0, 35, Short.MAX_VALUE))
            .addGroup(dataEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(dataEntryPanelLayout.createSequentialGroup()
                    .addGap(81, 81, 81)
                    .addComponent(jLabel20)
                    .addContainerGap(339, Short.MAX_VALUE)))
        );
        dataEntryPanelLayout.setVerticalGroup(
            dataEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataEntryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dataEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(dataEntryPanelLayout.createSequentialGroup()
                        .addGroup(dataEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(incomeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(feesField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(dataEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(homeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(dataEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(shoppingField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(dataEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(diningAndDrinksField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(dataEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(autoAndCommutingField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(dataEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(travelField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(dataEntryPanelLayout.createSequentialGroup()
                        .addGroup(dataEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(personalCareField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addGap(12, 12, 12)
                        .addGroup(dataEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(billsAndUtilitiesField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(dataEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(loansField, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(dataEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(educationField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(dataEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(otherField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dataEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(entertainmentField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
            .addGroup(dataEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(dataEntryPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel20)
                    .addContainerGap(217, Short.MAX_VALUE)))
        );

        InfoPanel.add(dataEntryPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(506, 15, 470, -1));

        allCharts.setBackground(new java.awt.Color(240, 235, 216));
        allCharts.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        myChartPanel2.setLayout(new java.awt.BorderLayout());
        allCharts.add(myChartPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 470, 200));

        myChartPanel1.setLayout(new java.awt.BorderLayout());
        allCharts.add(myChartPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 470, 197));

        budgetChart.setLayout(new java.awt.BorderLayout());
        allCharts.add(budgetChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 470, 197));

        InfoPanel.add(allCharts, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 470, 590));

        resetBTn.setBackground(new java.awt.Color(29, 45, 68));
        resetBTn.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        resetBTn.setForeground(new java.awt.Color(255, 255, 255));
        resetBTn.setText("Reset");
        resetBTn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBTnActionPerformed(evt);
            }
        });
        InfoPanel.add(resetBTn, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 380, 201, 64));

        updateBTn.setBackground(new java.awt.Color(29, 45, 68));
        updateBTn.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        updateBTn.setForeground(new java.awt.Color(255, 255, 255));
        updateBTn.setText("Update");
        updateBTn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBTnActionPerformed(evt);
            }
        });
        InfoPanel.add(updateBTn, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 380, 190, 64));

        saveBTn.setBackground(new java.awt.Color(29, 45, 68));
        saveBTn.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        saveBTn.setForeground(new java.awt.Color(255, 255, 255));
        saveBTn.setText("Save");
        saveBTn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBTnActionPerformed(evt);
            }
        });
        InfoPanel.add(saveBTn, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 450, 201, 64));

        backBtn.setBackground(new java.awt.Color(29, 45, 68));
        backBtn.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        backBtn.setForeground(new java.awt.Color(255, 255, 255));
        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        InfoPanel.add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 450, 190, 64));

        WholePanel.add(InfoPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 940, 580));

        headerPanel.setBackground(new java.awt.Color(34, 47, 66));

        jLabel1.setBackground(new java.awt.Color(34, 47, 66));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Alter The categories To Generate a New Chart");

        jLabel2.setBackground(new java.awt.Color(34, 47, 66));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Edit Budget");

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(headerPanelLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 959, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        WholePanel.add(headerPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 940, 110));

        SIdeBarPanel.setBackground(new java.awt.Color(29, 45, 68));
        SIdeBarPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/pSsmallLogo.png"))); // NOI18N
        SIdeBarPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        SIdeBarPanel1.setBackground(new java.awt.Color(29, 45, 68));
        SIdeBarPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        SIdeBarPanel1.add(stocksPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 120, 40));

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

        SIdeBarPanel1.add(CryptoPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 120, 40));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/pSsmallLogo.png"))); // NOI18N
        SIdeBarPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

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
        SIdeBarPanel1.add(mainMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 130, 50));

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
        SIdeBarPanel1.add(logoutBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 130, 50));

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
        SIdeBarPanel1.add(budgetSelected1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 130, 50));

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
        SIdeBarPanel1.add(savingsNormal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 130, 50));

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
        SIdeBarPanel1.add(editinfoBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 130, 50));

        SIdeBarPanel.add(SIdeBarPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 490));

        WholePanel.add(SIdeBarPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 700));

        getContentPane().add(WholePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 700));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
                updateBar();
                updateSecondBar();
            }
        }catch(NumberFormatException err){
            JOptionPane.showMessageDialog(rootPane, "Please Enter Only Numbers");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(rootPane, "An Error Occurred");
        }
    }//GEN-LAST:event_updateBTnActionPerformed

    private void resetBTnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBTnActionPerformed
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

    private void budgetSelected1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_budgetSelected1MouseClicked
    }//GEN-LAST:event_budgetSelected1MouseClicked

    private void budgetSelected1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_budgetSelected1ActionPerformed
    }//GEN-LAST:event_budgetSelected1ActionPerformed

    private void savingsNormalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_savingsNormalMouseClicked
        SavingsInfoPage m = new SavingsInfoPage();
        m.setLocationRelativeTo(null);
        m.setVisible(true);
        this.hide();
    }//GEN-LAST:event_savingsNormalMouseClicked

    private void savingsNormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savingsNormalActionPerformed

    }//GEN-LAST:event_savingsNormalActionPerformed

    private void editinfoBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editinfoBtnMouseClicked
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
    private javax.swing.JScrollPane ADVICE;
    private javax.swing.JPanel CryptoPanel;
    private javax.swing.JPanel InfoPanel;
    private javax.swing.JPanel SIdeBarPanel;
    private javax.swing.JPanel SIdeBarPanel1;
    private javax.swing.JPanel WholePanel;
    private javax.swing.JTextArea adviceTextArea;
    private javax.swing.JPanel allCharts;
    private javax.swing.JTextField autoAndCommutingField;
    private javax.swing.JButton backBtn;
    private javax.swing.JTextField billsAndUtilitiesField;
    private javax.swing.JPanel budgetChart;
    private javax.swing.JToggleButton budgetSelected1;
    private javax.swing.JLabel cryptoLabel;
    private javax.swing.JPanel dataEntryPanel;
    private javax.swing.JTextField diningAndDrinksField;
    private javax.swing.JToggleButton editinfoBtn;
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JTextField loansField;
    private javax.swing.JToggleButton logoutBtn;
    private javax.swing.JToggleButton mainMenu;
    private javax.swing.JPanel myChartPanel1;
    private javax.swing.JPanel myChartPanel2;
    private javax.swing.JTextField otherField;
    private javax.swing.JTextField personalCareField;
    private javax.swing.JButton resetBTn;
    private javax.swing.JButton saveBTn;
    private javax.swing.JToggleButton savingsNormal;
    private javax.swing.JTextField shoppingField;
    private javax.swing.JLabel stocksLabel;
    private javax.swing.JPanel stocksPanel1;
    private javax.swing.JTextField travelField;
    private javax.swing.JButton updateBTn;
    // End of variables declaration//GEN-END:variables
}
