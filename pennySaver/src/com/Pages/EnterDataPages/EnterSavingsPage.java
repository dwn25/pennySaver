package com.Pages.EnterDataPages;

import com.Pages.Main.NoUseMain;
import com.Pages.MainMenu.BudgetInfoPage;
import com.Pages.MainMenu.MainMenu;
import com.Support.Constant;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author DNartey
 */
public class EnterSavingsPage extends javax.swing.JFrame {
    Double income, monthlySavings;
    Double amount, final_principal, rate, time, interest;
    String employeeStatus;
    /**
     * Creates new form SavingsPlanPage
     */
    public EnterSavingsPage() {
        setLocationRelativeTo(null);
        setResizable(false);
        initComponents();
        onRun();
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
        
    public void onRun(){
        Constant.DoConnect();
        income = getIncome();
        employeeStatus = getField("employment_status");
        monthlySavings = getFieldD("monthly_savings");
        String text  = "\n"
                + "Based off of your monthly take home income of :$"+ income +"\n"
                + "Emplyoment Status of: " + employeeStatus + "\n"
                + "Monthly savings of: $" + monthlySavings + "\n"
                + "Adjust the values below to see your forecast";  
        jTextArea.setText(text);
        jTextArea.setWrapStyleWord(true);
        jTextArea.setLineWrap(true);
        jTextArea.setOpaque(false);
        jTextArea.setEditable(false);
        jTextArea.setFocusable(false);
    }

    public String getField(String column){
        try{
            String SQL= "SELECT " + column +" From ROOT.PUSERS WHERE username= '"+Constant.currentUser+"'";    
            ResultSet rs = Constant.stmt.executeQuery(SQL);
            if(rs.next()){
                String val = rs.getString(column);
                return val;
                }
            else{
                JOptionPane.showMessageDialog(rootPane, "Unable To Find Value");
            } 
        }catch(SQLException err){
        System.out.println("Unable to fetch "+ column);
        }       
        return "N/A";
    }
    
   public Double getFieldD(String column){
        try{
            String SQL= "SELECT " + column +" From ROOT.PUSERS WHERE username= '"+Constant.currentUser+"'";    
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
    public void compoundInterest(double amount1, double principle1, double rate1, double time1, double ci1){
	amount1=principle1*((1+rate1/100)*(1+rate1/100)*(1+rate1/100));
 	ci1=amount1-principle1;
        amount = amount1;
        final_principal = principle1;
        rate = rate1;
        time = time1;
        interest = ci1;
	System.out.println("amount="+amount1);
 	System.out.println("principle= "+principle1);
	System.out.println("rate="+rate1);
	System.out.println("time="+time1);
	System.out.println("compound interest="+ci1);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        wholePanel = new javax.swing.JPanel();
        saveBtn = new javax.swing.JButton();
        dataEntryPanel = new javax.swing.JPanel();
        rateField = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        interestField = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        principalField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        amountField = new javax.swing.JTextField();
        timeField = new javax.swing.JTextField();
        headerPanel = new javax.swing.JPanel();
        firstName1 = new javax.swing.JLabel();
        firstName2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea = new javax.swing.JTextArea();
        nextBtn = new javax.swing.JButton();
        calculateBtn = new javax.swing.JButton();
        SIdeBarPanel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        personalInfoPage = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        budgetLabel = new javax.swing.JLabel();
        stocksInfo = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        budgetLabel2 = new javax.swing.JLabel();
        stocksInfo1 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        budgetLabel3 = new javax.swing.JLabel();
        stockPanel = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        budgetLabel1 = new javax.swing.JLabel();
        stocksInfo2 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        budgetLabel4 = new javax.swing.JLabel();
        resetBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        wholePanel.setBackground(new java.awt.Color(240, 235, 216));
        wholePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        saveBtn.setBackground(new java.awt.Color(34, 47, 66));
        saveBtn.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        saveBtn.setForeground(new java.awt.Color(255, 255, 255));
        saveBtn.setText("Save");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });
        wholePanel.add(saveBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 480, 150, 50));

        dataEntryPanel.setBackground(new java.awt.Color(240, 235, 216));

        rateField.setBackground(new java.awt.Color(240, 235, 216));
        rateField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        rateField.setForeground(new java.awt.Color(63, 64, 76));
        rateField.setText("2.15");
        rateField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rateFieldActionPerformed(evt);
            }
        });

        jLabel18.setBackground(new java.awt.Color(240, 235, 216));
        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(63, 64, 76));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("Rate:");

        interestField.setBackground(new java.awt.Color(240, 235, 216));
        interestField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        interestField.setForeground(new java.awt.Color(63, 64, 76));
        interestField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                interestFieldActionPerformed(evt);
            }
        });

        jLabel19.setBackground(new java.awt.Color(240, 235, 216));
        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(63, 64, 76));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("Compound Interest:");

        jLabel12.setBackground(new java.awt.Color(240, 235, 216));
        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(63, 64, 76));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Amount:");

        jLabel7.setBackground(new java.awt.Color(240, 235, 216));
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(63, 64, 76));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Principal:");

        principalField.setBackground(new java.awt.Color(240, 235, 216));
        principalField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        principalField.setForeground(new java.awt.Color(63, 64, 76));
        principalField.setText("5000");
        principalField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                principalFieldActionPerformed(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(240, 235, 216));
        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(63, 64, 76));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Time:");

        amountField.setBackground(new java.awt.Color(240, 235, 216));
        amountField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        amountField.setForeground(new java.awt.Color(63, 64, 76));
        amountField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amountFieldActionPerformed(evt);
            }
        });

        timeField.setBackground(new java.awt.Color(240, 235, 216));
        timeField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        timeField.setForeground(new java.awt.Color(63, 64, 76));
        timeField.setText("1");
        timeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dataEntryPanelLayout = new javax.swing.GroupLayout(dataEntryPanel);
        dataEntryPanel.setLayout(dataEntryPanelLayout);
        dataEntryPanelLayout.setHorizontalGroup(
            dataEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataEntryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dataEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dataEntryPanelLayout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(amountField, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dataEntryPanelLayout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(interestField, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dataEntryPanelLayout.createSequentialGroup()
                        .addGroup(dataEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(dataEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(rateField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(principalField)
                            .addComponent(timeField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE))))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        dataEntryPanelLayout.setVerticalGroup(
            dataEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataEntryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dataEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(principalField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dataEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(rateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dataEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(timeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(dataEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(amountField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dataEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(interestField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        wholePanel.add(dataEntryPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 215, 430, 200));

        headerPanel.setBackground(new java.awt.Color(34, 47, 66));

        firstName1.setBackground(new java.awt.Color(34, 47, 66));
        firstName1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        firstName1.setForeground(new java.awt.Color(255, 255, 255));
        firstName1.setText("Try Out Different Values");

        firstName2.setBackground(new java.awt.Color(34, 47, 66));
        firstName2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        firstName2.setForeground(new java.awt.Color(255, 255, 255));
        firstName2.setText("Savings Forecast");

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(firstName2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(firstName1, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(firstName2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(firstName1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        wholePanel.add(headerPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 440, 80));

        jTextArea.setEditable(false);
        jTextArea.setBackground(new java.awt.Color(240, 235, 216));
        jTextArea.setColumns(20);
        jTextArea.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jTextArea.setForeground(new java.awt.Color(63, 64, 76));
        jTextArea.setRows(5);
        jScrollPane1.setViewportView(jTextArea);

        wholePanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 440, 140));

        nextBtn.setBackground(new java.awt.Color(34, 47, 66));
        nextBtn.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        nextBtn.setForeground(new java.awt.Color(255, 255, 255));
        nextBtn.setText("Next");
        nextBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextBtnActionPerformed(evt);
            }
        });
        wholePanel.add(nextBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 480, 150, 50));

        calculateBtn.setBackground(new java.awt.Color(34, 47, 66));
        calculateBtn.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        calculateBtn.setForeground(new java.awt.Color(255, 255, 255));
        calculateBtn.setText("Calculate");
        calculateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculateBtnActionPerformed(evt);
            }
        });
        wholePanel.add(calculateBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 430, 150, 50));

        SIdeBarPanel.setBackground(new java.awt.Color(29, 45, 68));
        SIdeBarPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/pSsmallLogo.png"))); // NOI18N
        SIdeBarPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, 100));

        personalInfoPage.setBackground(new java.awt.Color(29, 45, 68));
        personalInfoPage.setForeground(new java.awt.Color(160, 170, 178));
        personalInfoPage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                personalInfoPageMouseClicked(evt);
            }
        });
        personalInfoPage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel11.setBackground(new java.awt.Color(0, 0, 0));
        jPanel11.setForeground(new java.awt.Color(204, 204, 204));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        personalInfoPage.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 40));

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
        personalInfoPage.add(budgetLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 40));

        SIdeBarPanel.add(personalInfoPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 120, 40));

        stocksInfo.setBackground(new java.awt.Color(29, 45, 68));
        stocksInfo.setForeground(new java.awt.Color(160, 170, 178));
        stocksInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stocksInfoMouseClicked(evt);
            }
        });
        stocksInfo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel13.setBackground(new java.awt.Color(0, 0, 0));
        jPanel13.setForeground(new java.awt.Color(204, 204, 204));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        stocksInfo.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 40));

        budgetLabel2.setBackground(new java.awt.Color(41, 57, 80));
        budgetLabel2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        budgetLabel2.setForeground(new java.awt.Color(255, 255, 255));
        budgetLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        budgetLabel2.setText("Stocks Input");
        budgetLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                budgetLabel2MouseClicked(evt);
            }
        });
        stocksInfo.add(budgetLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 40));

        stocksInfo1.setBackground(new java.awt.Color(29, 45, 68));
        stocksInfo1.setForeground(new java.awt.Color(160, 170, 178));
        stocksInfo1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stocksInfo1MouseClicked(evt);
            }
        });
        stocksInfo1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel14.setBackground(new java.awt.Color(0, 0, 0));
        jPanel14.setForeground(new java.awt.Color(204, 204, 204));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        stocksInfo1.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 40));

        budgetLabel3.setBackground(new java.awt.Color(41, 57, 80));
        budgetLabel3.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        budgetLabel3.setForeground(new java.awt.Color(255, 255, 255));
        budgetLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        budgetLabel3.setText("Crypto Input");
        budgetLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                budgetLabel3MouseClicked(evt);
            }
        });
        stocksInfo1.add(budgetLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 40));

        stocksInfo.add(stocksInfo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 120, 40));

        SIdeBarPanel.add(stocksInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 120, -1));

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
        budgetLabel1.setText("Sales Forecast");
        budgetLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                budgetLabel1MouseClicked(evt);
            }
        });
        stockPanel.add(budgetLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 110, 40));

        SIdeBarPanel.add(stockPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, -1, 40));

        stocksInfo2.setBackground(new java.awt.Color(29, 45, 68));
        stocksInfo2.setForeground(new java.awt.Color(160, 170, 178));
        stocksInfo2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stocksInfo2MouseClicked(evt);
            }
        });
        stocksInfo2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel15.setBackground(new java.awt.Color(0, 0, 0));
        jPanel15.setForeground(new java.awt.Color(204, 204, 204));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        stocksInfo2.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 40));

        budgetLabel4.setBackground(new java.awt.Color(41, 57, 80));
        budgetLabel4.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        budgetLabel4.setForeground(new java.awt.Color(255, 255, 255));
        budgetLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        budgetLabel4.setText("Budget Entry");
        budgetLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                budgetLabel4MouseClicked(evt);
            }
        });
        stocksInfo2.add(budgetLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 40));

        SIdeBarPanel.add(stocksInfo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 120, 50));

        wholePanel.add(SIdeBarPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 550));

        resetBtn.setBackground(new java.awt.Color(34, 47, 66));
        resetBtn.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        resetBtn.setForeground(new java.awt.Color(255, 255, 255));
        resetBtn.setText("Reset");
        resetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBtnActionPerformed(evt);
            }
        });
        wholePanel.add(resetBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 430, 150, 50));

        getContentPane().add(wholePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void principalFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_principalFieldActionPerformed
                    
    }//GEN-LAST:event_principalFieldActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        Constant.DoConnect();
        try{
            String prin = principalField.getText();
            String rat1 = rateField.getText();
            String tim1 = timeField.getText();
            if(prin.isEmpty()){
                JOptionPane.showMessageDialog(rootPane, "Principal Cannot Be Empty");
            }
            else if(rat1.isEmpty()){
                JOptionPane.showMessageDialog(rootPane, "Rate Cannot Be Empty");
            }
            else if(tim1.isEmpty()){
                JOptionPane.showMessageDialog(rootPane, "Time Cannot Be Empty");
            }
            else{
                amount = 0.0;
                interest = 0.0;
                final_principal = Double.parseDouble(prin);
                rate = Double.parseDouble(rat1);
                time = Double.parseDouble(tim1);
                compoundInterest(amount,final_principal, rate, time,interest);
                String[] options={"Yes", "No"};
                int f =  JOptionPane.showOptionDialog(null, "Are You Sure You Want To Save These Values?", "Confirm Save", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                if(f==JOptionPane.YES_OPTION){
                    if(Constant.currentUser.length()>2){
                        String sql = "INSERT INTO ROOT.PBANK (USERNAME, PRINCIPAL, RATE, \"TIME\", SAVED_INTEREST, SAVED_AMOUNT)" +"	VALUES (?, ?, ?, ?, ?, ?)";
                        PreparedStatement statement = Constant.con.prepareStatement(sql);
                        statement.setString(1, Constant.currentUser);
                        statement.setDouble(2, final_principal);
                        statement.setDouble(3, rate);
                        statement.setDouble(4, time);
                        statement.setDouble(5, interest);
                        statement.setDouble(6, amount);
                        int rowsInserted = statement.executeUpdate();
                        if(rowsInserted > 0){
                            System.out.println("Savings: A new user was inserted successfully!");
                            JOptionPane.showMessageDialog(null, "Save Succesful");
                            MainMenu m = new MainMenu();
                            m.setVisible(true);
                            this.hide();
                            }
                    }
                }
            }
        }catch(NumberFormatException err){
            JOptionPane.showMessageDialog(rootPane, "Please Enter Only Numbers");
        }catch(Exception ex){
            System.out.println(ex.toString());
            JOptionPane.showMessageDialog(rootPane, "An Error Occurred");
        }        Constant.DoConnect();
    }//GEN-LAST:event_saveBtnActionPerformed

    private void rateFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rateFieldActionPerformed
    }//GEN-LAST:event_rateFieldActionPerformed

    private void interestFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_interestFieldActionPerformed
    }//GEN-LAST:event_interestFieldActionPerformed

    private void amountFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amountFieldActionPerformed
    }//GEN-LAST:event_amountFieldActionPerformed

    private void timeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeFieldActionPerformed
    }//GEN-LAST:event_timeFieldActionPerformed

    private void nextBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextBtnActionPerformed
        if(Constant.hasStocks && Constant.hasCrypto && Constant.hasBudget && Constant.hasSavings){
            NoUseMain  m = new NoUseMain();
            m.setVisible(true);
            this.hide();
        }else{
            MainMenu m = new MainMenu();
            m.setVisible(true);
            this.hide();
        }
    }//GEN-LAST:event_nextBtnActionPerformed

    private void calculateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calculateBtnActionPerformed
        try{
            String princ1 = principalField.getText();
            String rate1 = rateField.getText();
            String time1 = timeField.getText();
            if(princ1.isEmpty()){
                JOptionPane.showMessageDialog(rootPane, "Principal Cannot Be Empty");
            }
            else if(rate1.isEmpty()){
                JOptionPane.showMessageDialog(rootPane, "Rate Cannot Be Empty");
            }
            else if(time1.isEmpty()){
                JOptionPane.showMessageDialog(rootPane, "Time Cannot Be Empty");
            }
            else{
                amount = 0.0;
                interest = 0.0;
                final_principal = Double.parseDouble(princ1);
                rate = Double.parseDouble(rate1);
                time = Double.parseDouble(time1);
                compoundInterest(amount,final_principal, rate, time,interest);
                amountField.setText(null);
                amountField.setText(amount.toString());
                interestField.setText(null);
                interestField.setText(interest.toString());
            }
        }catch(NumberFormatException err){
            JOptionPane.showMessageDialog(rootPane, "Please Enter Only Numbers");
        }
    }//GEN-LAST:event_calculateBtnActionPerformed

    private void budgetLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_budgetLabelMouseClicked
        BudgetInfoPage m = new BudgetInfoPage();
        m.setLocationRelativeTo(null);
        m.setVisible(true);
        this.hide();
    }//GEN-LAST:event_budgetLabelMouseClicked

    private void personalInfoPageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_personalInfoPageMouseClicked
        BudgetInfoPage m = new BudgetInfoPage();
        m.setLocationRelativeTo(null);
        m.setVisible(true);
        this.hide();
    }//GEN-LAST:event_personalInfoPageMouseClicked

    private void budgetLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_budgetLabel2MouseClicked
    }//GEN-LAST:event_budgetLabel2MouseClicked

    private void budgetLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_budgetLabel3MouseClicked
    }//GEN-LAST:event_budgetLabel3MouseClicked

    private void stocksInfo1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stocksInfo1MouseClicked
    }//GEN-LAST:event_stocksInfo1MouseClicked

    private void stocksInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stocksInfoMouseClicked
    }//GEN-LAST:event_stocksInfoMouseClicked

    private void budgetLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_budgetLabel1MouseClicked
        BudgetInfoPage m = new BudgetInfoPage();
        m.setLocationRelativeTo(null);
        m.setVisible(true);
        this.hide();
    }//GEN-LAST:event_budgetLabel1MouseClicked

    private void stockPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stockPanelMouseClicked
        BudgetInfoPage m = new BudgetInfoPage();
        m.setLocationRelativeTo(null);
        m.setVisible(true);
        this.hide();
    }//GEN-LAST:event_stockPanelMouseClicked

    private void budgetLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_budgetLabel4MouseClicked
    }//GEN-LAST:event_budgetLabel4MouseClicked

    private void stocksInfo2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stocksInfo2MouseClicked
    }//GEN-LAST:event_stocksInfo2MouseClicked

    private void resetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBtnActionPerformed
        // TODO add your handling code here:
        principalField.setText(null);
        principalField.setText("5000.0");
        rateField.setText(null);
        rateField.setText("2.15");
        timeField.setText(null);
        timeField.setText("1");
        amountField.setText(null);
        interestField.setText(null);
    }//GEN-LAST:event_resetBtnActionPerformed

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
            java.util.logging.Logger.getLogger(EnterSavingsPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EnterSavingsPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EnterSavingsPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EnterSavingsPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EnterSavingsPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel SIdeBarPanel;
    private javax.swing.JTextField amountField;
    private javax.swing.JLabel budgetLabel;
    private javax.swing.JLabel budgetLabel1;
    private javax.swing.JLabel budgetLabel2;
    private javax.swing.JLabel budgetLabel3;
    private javax.swing.JLabel budgetLabel4;
    private javax.swing.JButton calculateBtn;
    private javax.swing.JPanel dataEntryPanel;
    private javax.swing.JLabel firstName1;
    private javax.swing.JLabel firstName2;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JTextField interestField;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea;
    private javax.swing.JButton nextBtn;
    private javax.swing.JPanel personalInfoPage;
    private javax.swing.JTextField principalField;
    private javax.swing.JTextField rateField;
    private javax.swing.JButton resetBtn;
    private javax.swing.JButton saveBtn;
    private javax.swing.JPanel stockPanel;
    private javax.swing.JPanel stocksInfo;
    private javax.swing.JPanel stocksInfo1;
    private javax.swing.JPanel stocksInfo2;
    private javax.swing.JTextField timeField;
    private javax.swing.JPanel wholePanel;
    // End of variables declaration//GEN-END:variables
}
