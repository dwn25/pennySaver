package com.Pages.MainMenu;

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
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.RectangleInsets;
import org.jfree.util.UnitType;

/**
 *
 * @author DNartey
 */
public class BudgetBreakdownPage extends javax.swing.JFrame {
    String mainAdvice;
    Double home, shopping, dineAndDrinks, auto, travel, billsAndUtils,
        entertainment, fees, personalCare, loans, education, other;
    Double netIncome, needs, wants;
    Double budgetWants, budgetNeeds, budgetSavings, budgetTotal;
    /**
     * Creates new form BudgetBreakdownPage
     */
    public BudgetBreakdownPage() {
        setResizable(false);
        initComponents();
        onRun();
    }
    
    public void onRun(){
       Constant.DoConnect();
       calcs();
       //putFieldString(incomeField,"net_income");
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
        myChartPanel.removeAll();
        myChartPanel.add(chartPanel);
        myChartPanel.validate();
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
        myChartPanel2.removeAll();
        myChartPanel2.add(chartPanel);
        myChartPanel2.validate();
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
        jLabel15 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        personalCareField = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        otherField = new javax.swing.JTextField();
        entertainmentField = new javax.swing.JTextField();
        travelField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        shoppingField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        Edit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        adviceTextArea = new javax.swing.JTextArea();
        SIdeBarPanel = new javax.swing.JPanel();
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
        budgetPanel = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        budgetLabel1 = new javax.swing.JLabel();
        mainMenuPanel = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        mainMenuLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        homeField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        diningAndDrinksField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        autoAndCommutingField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        billsAndUtilitiesField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        educationField = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        loansField = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        feesField = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        myChartPanel = new javax.swing.JPanel();
        myChartPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        WholePanel.setBackground(new java.awt.Color(240, 235, 216));
        WholePanel.setForeground(new java.awt.Color(255, 255, 255));
        WholePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        headerPanel.setBackground(new java.awt.Color(91, 139, 151));

        jLabel1.setBackground(new java.awt.Color(32, 33, 35));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Weekly Budget");

        jLabel2.setBackground(new java.awt.Color(32, 33, 35));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Your Budget Has Been Calculated Below");

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 756, Short.MAX_VALUE))
                .addGap(0, 4, Short.MAX_VALUE))
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        WholePanel.add(headerPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 760, 100));

        DataPanel.setBackground(new java.awt.Color(240, 235, 216));
        DataPanel.setForeground(new java.awt.Color(63, 64, 76));

        jLabel15.setBackground(new java.awt.Color(240, 235, 216));
        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(63, 64, 76));
        jLabel15.setText("Personal Care:");

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

        otherField.setEditable(false);
        otherField.setBackground(new java.awt.Color(240, 235, 216));
        otherField.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        otherField.setForeground(new java.awt.Color(63, 64, 76));

        entertainmentField.setEditable(false);
        entertainmentField.setBackground(new java.awt.Color(240, 235, 216));
        entertainmentField.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        entertainmentField.setForeground(new java.awt.Color(63, 64, 76));

        travelField.setEditable(false);
        travelField.setBackground(new java.awt.Color(240, 235, 216));
        travelField.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        travelField.setForeground(new java.awt.Color(63, 64, 76));

        jLabel11.setBackground(new java.awt.Color(29, 45, 68));
        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(63, 64, 76));
        jLabel11.setText("Travel:");

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

        javax.swing.GroupLayout DataPanelLayout = new javax.swing.GroupLayout(DataPanel);
        DataPanel.setLayout(DataPanelLayout);
        DataPanelLayout.setHorizontalGroup(
            DataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DataPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(DataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(DataPanelLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(travelField, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(DataPanelLayout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(otherField, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(DataPanelLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(shoppingField, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(DataPanelLayout.createSequentialGroup()
                        .addGroup(DataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(DataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(entertainmentField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(personalCareField, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                    .addComponent(personalCareField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(shoppingField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(otherField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(travelField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(0, 6, Short.MAX_VALUE))
        );

        WholePanel.add(DataPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 430, 200, 150));

        Edit.setBackground(new java.awt.Color(29, 45, 68));
        Edit.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        Edit.setForeground(new java.awt.Color(255, 255, 255));
        Edit.setText("Back");
        Edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditActionPerformed(evt);
            }
        });
        WholePanel.add(Edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 520, 130, 40));

        adviceTextArea.setBackground(new java.awt.Color(240, 235, 216));
        adviceTextArea.setColumns(20);
        adviceTextArea.setForeground(new java.awt.Color(63, 64, 76));
        adviceTextArea.setRows(5);
        jScrollPane1.setViewportView(adviceTextArea);

        WholePanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 620, 430, 90));

        SIdeBarPanel.setBackground(new java.awt.Color(29, 45, 68));
        SIdeBarPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        savingsPanel.add(savingsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 110, 40));

        SIdeBarPanel.add(savingsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 120, 40));

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
        editInfoPanel.add(editInfoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 110, 40));

        SIdeBarPanel.add(editInfoPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 120, 40));

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

        budgetPanel.setBackground(new java.awt.Color(240, 235, 216));
        budgetPanel.setForeground(new java.awt.Color(63, 64, 76));
        budgetPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                budgetPanelMouseClicked(evt);
            }
        });
        budgetPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel12.setBackground(new java.awt.Color(153, 153, 153));
        jPanel12.setForeground(new java.awt.Color(204, 204, 204));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        budgetPanel.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 40));

        budgetLabel1.setBackground(new java.awt.Color(240, 235, 216));
        budgetLabel1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        budgetLabel1.setForeground(new java.awt.Color(63, 64, 76));
        budgetLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        budgetLabel1.setText("Budget");
        budgetLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                budgetLabel1MouseClicked(evt);
            }
        });
        budgetPanel.add(budgetLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 110, 40));

        SIdeBarPanel.add(budgetPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, -1, -1));

        mainMenuPanel.setBackground(new java.awt.Color(29, 45, 68));
        mainMenuPanel.setForeground(new java.awt.Color(160, 170, 178));
        mainMenuPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mainMenuPanelMouseClicked(evt);
            }
        });
        mainMenuPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel11.setForeground(new java.awt.Color(204, 204, 204));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        mainMenuPanel.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 40));

        mainMenuLabel.setBackground(new java.awt.Color(41, 57, 80));
        mainMenuLabel.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        mainMenuLabel.setForeground(new java.awt.Color(255, 255, 255));
        mainMenuLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        mainMenuLabel.setText("Main Menu");
        mainMenuLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mainMenuLabelMouseClicked(evt);
            }
        });
        mainMenuPanel.add(mainMenuLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 40));

        SIdeBarPanel.add(mainMenuPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 120, 40));

        WholePanel.add(SIdeBarPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 710));

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

        billsAndUtilitiesField.setEditable(false);
        billsAndUtilitiesField.setBackground(new java.awt.Color(240, 235, 216));
        billsAndUtilitiesField.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        billsAndUtilitiesField.setForeground(new java.awt.Color(63, 64, 76));

        jLabel12.setBackground(new java.awt.Color(29, 45, 68));
        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(63, 64, 76));
        jLabel12.setText("Bills & Utilities:");

        educationField.setEditable(false);
        educationField.setBackground(new java.awt.Color(240, 235, 216));
        educationField.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        educationField.setForeground(new java.awt.Color(63, 64, 76));

        jLabel16.setBackground(new java.awt.Color(240, 235, 216));
        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(63, 64, 76));
        jLabel16.setText("Education:");

        loansField.setEditable(false);
        loansField.setBackground(new java.awt.Color(240, 235, 216));
        loansField.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        loansField.setForeground(new java.awt.Color(63, 64, 76));

        jLabel17.setBackground(new java.awt.Color(240, 235, 216));
        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(63, 64, 76));
        jLabel17.setText("Loans:");

        feesField.setEditable(false);
        feesField.setBackground(new java.awt.Color(240, 235, 216));
        feesField.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        feesField.setForeground(new java.awt.Color(63, 64, 76));

        jLabel14.setBackground(new java.awt.Color(240, 235, 216));
        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(63, 64, 76));
        jLabel14.setText("Fees:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(loansField, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(educationField, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGap(45, 45, 45)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(billsAndUtilitiesField, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel7)
                                .addComponent(jLabel10)
                                .addComponent(jLabel8)
                                .addComponent(jLabel14))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(homeField, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(diningAndDrinksField, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(autoAndCommutingField, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(feesField, javax.swing.GroupLayout.Alignment.TRAILING)))))
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(homeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(feesField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(diningAndDrinksField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(autoAndCommutingField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loansField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(educationField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(billsAndUtilitiesField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addContainerGap())
        );

        WholePanel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 430, 230, 210));

        myChartPanel.setLayout(new java.awt.BorderLayout());
        WholePanel.add(myChartPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 380, 330));

        myChartPanel2.setLayout(new java.awt.BorderLayout());
        WholePanel.add(myChartPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, 380, 330));

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

    private void EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditActionPerformed
        BudgetInfoPage m = new BudgetInfoPage();
        m.setLocationRelativeTo(null);
        m.setVisible(true);
        this.hide();
    }//GEN-LAST:event_EditActionPerformed

    private void savingsLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_savingsLabelMouseClicked
        SavingsInfoPage m = new SavingsInfoPage();
        m.setLocationRelativeTo(null);
        m.setVisible(true);
        this.hide();
    }//GEN-LAST:event_savingsLabelMouseClicked

    private void savingsPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_savingsPanelMouseClicked
        SavingsInfoPage m = new SavingsInfoPage();
        m.setLocationRelativeTo(null);
        m.setVisible(true);
        this.hide();
    }//GEN-LAST:event_savingsPanelMouseClicked

    private void editInfoLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editInfoLabelMouseClicked
        EditPersonalInfoPage m = new EditPersonalInfoPage();
        m.setLocationRelativeTo(null);
        m.setVisible(true);
        this.hide();
    }//GEN-LAST:event_editInfoLabelMouseClicked

    private void editInfoPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editInfoPanelMouseClicked
        EditPersonalInfoPage m = new EditPersonalInfoPage();
        m.setLocationRelativeTo(null);
        m.setVisible(true);
        this.hide();
    }//GEN-LAST:event_editInfoPanelMouseClicked

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

    private void budgetLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_budgetLabel1MouseClicked
        BudgetInfoPage m = new BudgetInfoPage();
        m.setLocationRelativeTo(null);
        m.setVisible(true);
        this.hide();
    }//GEN-LAST:event_budgetLabel1MouseClicked

    private void budgetPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_budgetPanelMouseClicked
        BudgetInfoPage m = new BudgetInfoPage();
        m.setLocationRelativeTo(null);
        m.setVisible(true);
        this.hide();
    }//GEN-LAST:event_budgetPanelMouseClicked

    private void mainMenuLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainMenuLabelMouseClicked
        MainMenu m = new MainMenu();
        m.setLocationRelativeTo(null);
        m.setVisible(true);
        this.hide();
    }//GEN-LAST:event_mainMenuLabelMouseClicked

    private void mainMenuPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainMenuPanelMouseClicked
        MainMenu m = new MainMenu();
        m.setLocationRelativeTo(null);
        m.setVisible(true);
        this.hide();
    }//GEN-LAST:event_mainMenuPanelMouseClicked

    private void homeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeFieldActionPerformed

    }//GEN-LAST:event_homeFieldActionPerformed

    private void shoppingFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shoppingFieldActionPerformed

    }//GEN-LAST:event_shoppingFieldActionPerformed

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
            java.util.logging.Logger.getLogger(BudgetBreakdownPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BudgetBreakdownPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BudgetBreakdownPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BudgetBreakdownPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BudgetBreakdownPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CryptoPanel;
    private javax.swing.JPanel DataPanel;
    private javax.swing.JButton Edit;
    private javax.swing.JPanel SIdeBarPanel;
    private javax.swing.JPanel WholePanel;
    private javax.swing.JTextArea adviceTextArea;
    private javax.swing.JTextField autoAndCommutingField;
    private javax.swing.JTextField billsAndUtilitiesField;
    private javax.swing.JLabel budgetLabel1;
    private javax.swing.JPanel budgetPanel;
    private javax.swing.JLabel cryptoLabel;
    private javax.swing.JTextField diningAndDrinksField;
    private javax.swing.JLabel editInfoLabel;
    private javax.swing.JPanel editInfoPanel;
    private javax.swing.JTextField educationField;
    private javax.swing.JTextField entertainmentField;
    private javax.swing.JTextField feesField;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JTextField homeField;
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField loansField;
    private javax.swing.JLabel mainMenuLabel;
    private javax.swing.JPanel mainMenuPanel;
    private javax.swing.JPanel myChartPanel;
    private javax.swing.JPanel myChartPanel2;
    private javax.swing.JTextField otherField;
    private javax.swing.JTextField personalCareField;
    private javax.swing.JLabel savingsLabel;
    private javax.swing.JPanel savingsPanel;
    private javax.swing.JTextField shoppingField;
    private javax.swing.JLabel stocksLabel;
    private javax.swing.JPanel stocksPanel1;
    private javax.swing.JTextField travelField;
    // End of variables declaration//GEN-END:variables
}