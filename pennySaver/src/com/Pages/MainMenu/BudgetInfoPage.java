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
       menuInit();
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
       String advice2 = "Looks like your budget is far greater than your income. Time to do some trimming to become fiscally"
               + "responsible. You will want to take a look at your spending habbits to reduce the unnecessary spending.";
       String advice1 = "Your budget looks good. You have a stable income that far outweighs your spending needs."
               + "It looks like you can afford to increase how much you save each month in order to increase your net worth.";
       String advice3 = "Your budget could use somoe real help. Pleae call 555-555-5555 in order to set up an appointment with "
               + "out proffessionals that can set you on the right path towards fiscal responsibility.";
       if(income>budget){
           Constant.mainAdvice = advice1;
           adviceTextArea.setText(null);
           adviceTextArea.setText(advice1);
           adviceTextArea.setWrapStyleWord(true);
           adviceTextArea.setLineWrap(true);
           adviceTextArea.setOpaque(false);
           adviceTextArea.setEditable(false);
           adviceTextArea.setFocusable(false);
           return advice1;
       }else if(budget>income){
           Constant.mainAdvice = advice2;
           adviceTextArea.setText(null);
           adviceTextArea.setText(advice2);
           adviceTextArea.setWrapStyleWord(true);
           adviceTextArea.setLineWrap(true);
           adviceTextArea.setOpaque(false);
           adviceTextArea.setEditable(false);
           adviceTextArea.setFocusable(false);
           return advice2;
       }else{
           Constant.mainAdvice = advice3;
           adviceTextArea.setText(null);
           adviceTextArea.setText(advice3);
           adviceTextArea.setWrapStyleWord(true);
           adviceTextArea.setLineWrap(true);
           adviceTextArea.setOpaque(false);
           adviceTextArea.setEditable(false);
           adviceTextArea.setFocusable(false);
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
        SIdeBarPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        mainMenu = new javax.swing.JButton();
        SavingsIcon = new javax.swing.JButton();
        StocksIcon = new javax.swing.JButton();
        cryptoIcon = new javax.swing.JButton();
        editTextbtn = new javax.swing.JButton();
        logoutBtn = new javax.swing.JButton();
        budgetIcon = new javax.swing.JButton();

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
        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(63, 64, 76));
        jLabel16.setText("Education:");

        jLabel15.setBackground(new java.awt.Color(240, 235, 216));
        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(63, 64, 76));
        jLabel15.setText("Personal Care:");

        jLabel14.setBackground(new java.awt.Color(240, 235, 216));
        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(63, 64, 76));
        jLabel14.setText("Fees:");

        jLabel13.setBackground(new java.awt.Color(240, 235, 216));
        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(63, 64, 76));
        jLabel13.setText("Entertainment:");

        personalCareField.setEditable(false);
        personalCareField.setBackground(new java.awt.Color(240, 235, 216));
        personalCareField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        personalCareField.setForeground(new java.awt.Color(63, 64, 76));
        personalCareField.setBorder(null);

        jLabel18.setBackground(new java.awt.Color(240, 235, 216));
        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(63, 64, 76));
        jLabel18.setText("Other:");

        educationField.setEditable(false);
        educationField.setBackground(new java.awt.Color(240, 235, 216));
        educationField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        educationField.setForeground(new java.awt.Color(63, 64, 76));
        educationField.setBorder(null);

        loansField.setEditable(false);
        loansField.setBackground(new java.awt.Color(240, 235, 216));
        loansField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        loansField.setForeground(new java.awt.Color(63, 64, 76));
        loansField.setBorder(null);

        feesField.setEditable(false);
        feesField.setBackground(new java.awt.Color(240, 235, 216));
        feesField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        feesField.setForeground(new java.awt.Color(63, 64, 76));
        feesField.setBorder(null);

        otherField.setEditable(false);
        otherField.setBackground(new java.awt.Color(240, 235, 216));
        otherField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        otherField.setForeground(new java.awt.Color(63, 64, 76));
        otherField.setBorder(null);

        entertainmentField.setEditable(false);
        entertainmentField.setBackground(new java.awt.Color(240, 235, 216));
        entertainmentField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        entertainmentField.setForeground(new java.awt.Color(63, 64, 76));
        entertainmentField.setBorder(null);

        jLabel17.setBackground(new java.awt.Color(240, 235, 216));
        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
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
                .addGap(0, 0, Short.MAX_VALUE))
        );

        WholePanel.add(DataPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 200, 200, 130));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        adviceTextArea.setEditable(false);
        adviceTextArea.setBackground(new java.awt.Color(240, 235, 216));
        adviceTextArea.setColumns(20);
        adviceTextArea.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        adviceTextArea.setForeground(new java.awt.Color(63, 64, 76));
        adviceTextArea.setRows(5);
        adviceTextArea.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane1.setViewportView(adviceTextArea);

        WholePanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 340, 430, 90));

        jPanel1.setBackground(new java.awt.Color(240, 235, 216));

        homeField.setEditable(false);
        homeField.setBackground(new java.awt.Color(240, 235, 216));
        homeField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        homeField.setForeground(new java.awt.Color(63, 64, 76));
        homeField.setBorder(null);
        homeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeFieldActionPerformed(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(29, 45, 68));
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(63, 64, 76));
        jLabel7.setText("Home:");

        shoppingField.setEditable(false);
        shoppingField.setBackground(new java.awt.Color(240, 235, 216));
        shoppingField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        shoppingField.setForeground(new java.awt.Color(63, 64, 76));
        shoppingField.setBorder(null);
        shoppingField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shoppingFieldActionPerformed(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(29, 45, 68));
        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(63, 64, 76));
        jLabel9.setText("Shopping:");

        diningAndDrinksField.setEditable(false);
        diningAndDrinksField.setBackground(new java.awt.Color(240, 235, 216));
        diningAndDrinksField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        diningAndDrinksField.setForeground(new java.awt.Color(63, 64, 76));
        diningAndDrinksField.setBorder(null);

        jLabel8.setBackground(new java.awt.Color(29, 45, 68));
        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(63, 64, 76));
        jLabel8.setText("Dining & Drinks:");

        autoAndCommutingField.setEditable(false);
        autoAndCommutingField.setBackground(new java.awt.Color(240, 235, 216));
        autoAndCommutingField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        autoAndCommutingField.setForeground(new java.awt.Color(63, 64, 76));
        autoAndCommutingField.setBorder(null);

        jLabel10.setBackground(new java.awt.Color(29, 45, 68));
        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(63, 64, 76));
        jLabel10.setText("Auto & Commuting:");

        travelField.setEditable(false);
        travelField.setBackground(new java.awt.Color(240, 235, 216));
        travelField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        travelField.setForeground(new java.awt.Color(63, 64, 76));
        travelField.setBorder(null);

        jLabel11.setBackground(new java.awt.Color(29, 45, 68));
        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(63, 64, 76));
        jLabel11.setText("Travel:");

        billsAndUtilitiesField.setEditable(false);
        billsAndUtilitiesField.setBackground(new java.awt.Color(240, 235, 216));
        billsAndUtilitiesField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        billsAndUtilitiesField.setForeground(new java.awt.Color(63, 64, 76));
        billsAndUtilitiesField.setBorder(null);

        jLabel12.setBackground(new java.awt.Color(29, 45, 68));
        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(63, 64, 76));
        jLabel12.setText("Bills & Utilities:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(diningAndDrinksField, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(billsAndUtilitiesField, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(homeField, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(autoAndCommutingField, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(travelField, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(shoppingField, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(9, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(homeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(shoppingField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(travelField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(billsAndUtilitiesField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        WholePanel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 200, 230, 130));

        incomeField.setEditable(false);
        incomeField.setBackground(new java.awt.Color(240, 235, 216));
        incomeField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        incomeField.setForeground(new java.awt.Color(63, 64, 76));
        incomeField.setBorder(null);
        incomeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                incomeFieldActionPerformed(evt);
            }
        });
        WholePanel.add(incomeField, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 130, 86, -1));

        jLabel21.setBackground(new java.awt.Color(240, 235, 216));
        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(63, 64, 76));
        jLabel21.setText("Income:");
        WholePanel.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 130, -1, -1));

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

        budgetIcon.setBackground(new java.awt.Color(240, 235, 216));
        budgetIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/Logos/MenuButtons/BudgetSelected.jpg"))); // NOI18N
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

        WholePanel.add(SIdeBarPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 480));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(WholePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(WholePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

   
    private void shoppingFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shoppingFieldActionPerformed

    }//GEN-LAST:event_shoppingFieldActionPerformed

    private void homeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeFieldActionPerformed

    }//GEN-LAST:event_homeFieldActionPerformed

    private void incomeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_incomeFieldActionPerformed
    }//GEN-LAST:event_incomeFieldActionPerformed

    private void Edit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Edit1ActionPerformed
        EditBudgetPage m = new EditBudgetPage();
        m.setVisible(true);
        this.hide();
    }//GEN-LAST:event_Edit1ActionPerformed

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

    private void StocksIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StocksIconMouseClicked
    }//GEN-LAST:event_StocksIconMouseClicked

    private void StocksIconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StocksIconActionPerformed
        StocksInfoPage m = new StocksInfoPage();
        m.setVisible(true);
        this.hide();
    }//GEN-LAST:event_StocksIconActionPerformed

    private void cryptoIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cryptoIconMouseClicked
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

    private void budgetIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_budgetIconMouseClicked
    }//GEN-LAST:event_budgetIconMouseClicked

    private void budgetIconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_budgetIconActionPerformed
    }//GEN-LAST:event_budgetIconActionPerformed

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
    private javax.swing.JPanel DataPanel;
    private javax.swing.JButton Edit1;
    private javax.swing.JPanel SIdeBarPanel;
    private javax.swing.JButton SavingsIcon;
    private javax.swing.JButton StocksIcon;
    private javax.swing.JPanel WholePanel;
    private javax.swing.JTextArea adviceTextArea;
    private javax.swing.JTextField autoAndCommutingField;
    private javax.swing.JTextField billsAndUtilitiesField;
    private javax.swing.JButton budgetIcon;
    private javax.swing.JButton cryptoIcon;
    private javax.swing.JTextField diningAndDrinksField;
    private javax.swing.JButton editTextbtn;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField loansField;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JButton mainMenu;
    private javax.swing.JPanel myChartPanel;
    private javax.swing.JTextField otherField;
    private javax.swing.JTextField personalCareField;
    private javax.swing.JTextField shoppingField;
    private javax.swing.JTextField travelField;
    // End of variables declaration//GEN-END:variables
}
