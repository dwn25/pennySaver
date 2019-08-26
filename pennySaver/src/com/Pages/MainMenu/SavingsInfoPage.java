package com.Pages.MainMenu;

import com.Pages.EditPages.EditSavingsPage;
import com.Pages.Main.Main;
import com.Support.Constant;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author DNartey
 */
public class SavingsInfoPage extends javax.swing.JFrame {
    Double income, monthlySavings;
    Double amount, final_principal, rate, time, interest;
    String employmentStatus;

    /**
     * Creates new form SavingsInfoPage
     */
    public SavingsInfoPage() {
        setLocationRelativeTo(null);
        setResizable(false);       
        initComponents();
        onRun();
    }

    public void onRun(){
        Constant.DoConnect();
        final_principal = getFieldDouble("principal");
        rate = getFieldDouble("rate");
        time = getFieldDouble("time");
        interest = getFieldDouble("SAVED_INTEREST");
        amount = getFieldDouble("SAVED_AMOUNT");
        compoundInterest(amount,final_principal, rate, time,interest);
        principalField.setText(null);
        principalField.setText("$" + final_principal.toString());
        rateField.setText(null);
        rateField.setText(rate.toString()+"%");       
        timeField.setText(null);
        timeField.setText(time.toString() + " Year(s)");      
        interestField.setText(null);
        interestField.setText("$ "+interest.toString());    
        totalField.setText(null);
        totalField.setText("$" + amount.toString());  
        employmentStatus = getFieldString("employment_status");
        income = getIncome();
        String monthlySavingsx = getField("monthly_savings");
        String text  = "\n"
                + "Based off of your monthly take home income of: $"+ income +"\n"
                + "Emplyoment Status of :" + employmentStatus + "\n"
                + "Monthly savings of :$" + monthlySavingsx + "\n"
                + "Your financial information has been laid down. \n"
                + "Adjust the values below to see your forecast";  
        jTextArea.setText(text);
        jTextArea.setWrapStyleWord(true);
        jTextArea.setLineWrap(true);
        jTextArea.setOpaque(false);
        jTextArea.setEditable(false);
        jTextArea.setFocusable(false);
    }
    
        public String getField( String column){
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
        return null;
    }
    
       public Double getFieldDouble(String column){
        try{
            String SQL= "SELECT " + column +" From ROOT.PBANK WHERE username= '"+Constant.currentUser+"'";    
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
       
      public String getFieldString(String column){
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
        return null;
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

        jPanel1 = new javax.swing.JPanel();
        jFrame1 = new javax.swing.JFrame();
        jPanel7 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        WholePanel3 = new javax.swing.JPanel();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea = new javax.swing.JTextArea();
        headerPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        SIdeBarPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        mainMenu2 = new javax.swing.JButton();
        SavingsIcon = new javax.swing.JButton();
        StocksIcon = new javax.swing.JButton();
        cryptoIcon = new javax.swing.JButton();
        editTextbtn = new javax.swing.JButton();
        logoutBtn = new javax.swing.JButton();
        budgetIcon = new javax.swing.JButton();

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
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        WholePanel3.setBackground(new java.awt.Color(91, 139, 151));
        WholePanel3.setForeground(new java.awt.Color(255, 255, 255));
        WholePanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        InfoPanel3.setBackground(new java.awt.Color(240, 235, 216));

        rateField.setBackground(new java.awt.Color(240, 235, 216));
        rateField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        rateField.setForeground(new java.awt.Color(63, 64, 76));
        rateField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        rateField.setBorder(null);

        timeField.setBackground(new java.awt.Color(240, 235, 216));
        timeField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        timeField.setForeground(new java.awt.Color(63, 64, 76));
        timeField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        timeField.setBorder(null);

        interestField.setBackground(new java.awt.Color(240, 235, 216));
        interestField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        interestField.setForeground(new java.awt.Color(63, 64, 76));
        interestField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        interestField.setBorder(null);

        totalField.setBackground(new java.awt.Color(240, 235, 216));
        totalField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        totalField.setForeground(new java.awt.Color(63, 64, 76));
        totalField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        totalField.setBorder(null);

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
        principalField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        principalField.setBorder(null);

        Edit.setBackground(new java.awt.Color(34, 47, 66));
        Edit.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        Edit.setForeground(new java.awt.Color(255, 255, 255));
        Edit.setText("Edit");
        Edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditActionPerformed(evt);
            }
        });

        jTextArea.setBackground(new java.awt.Color(240, 235, 216));
        jTextArea.setColumns(20);
        jTextArea.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jTextArea.setForeground(new java.awt.Color(63, 64, 76));
        jTextArea.setLineWrap(true);
        jTextArea.setRows(5);
        jTextArea.setToolTipText("");
        jTextArea.setWrapStyleWord(true);
        jTextArea.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane1.setViewportView(jTextArea);

        javax.swing.GroupLayout InfoPanel3Layout = new javax.swing.GroupLayout(InfoPanel3);
        InfoPanel3.setLayout(InfoPanel3Layout);
        InfoPanel3Layout.setHorizontalGroup(
            InfoPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(InfoPanel3Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(InfoPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(InfoPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Edit, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(InfoPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(principalField)
                        .addComponent(rateField)
                        .addComponent(timeField)
                        .addComponent(interestField)
                        .addComponent(totalField, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        InfoPanel3Layout.setVerticalGroup(
            InfoPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InfoPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(InfoPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(InfoPanel3Layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addGroup(InfoPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(totalField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                            .addComponent(interestField, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(Edit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        WholePanel3.add(InfoPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 420, 430));

        headerPanel.setBackground(new java.awt.Color(34, 47, 66));

        jLabel1.setBackground(new java.awt.Color(34, 47, 66));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Savings");

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE))
        );

        WholePanel3.add(headerPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 420, 90));

        SIdeBarPanel2.setBackground(new java.awt.Color(29, 45, 68));
        SIdeBarPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/pSsmallLogo.png"))); // NOI18N
        SIdeBarPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        mainMenu2.setBackground(new java.awt.Color(41, 57, 80));
        mainMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/Logos/MenuButtons/MainMenuNormal.jpg"))); // NOI18N
        mainMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mainMenu2MouseClicked(evt);
            }
        });
        mainMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainMenu2ActionPerformed(evt);
            }
        });
        SIdeBarPanel2.add(mainMenu2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 140, 50));

        SavingsIcon.setBackground(new java.awt.Color(240, 235, 216));
        SavingsIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/Logos/MenuButtons/SavingsSelected.jpg"))); // NOI18N
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
        SIdeBarPanel2.add(SavingsIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 140, 50));

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
        SIdeBarPanel2.add(StocksIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 140, 50));

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
        SIdeBarPanel2.add(cryptoIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 140, 50));

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
        SIdeBarPanel2.add(editTextbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 140, 50));

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
        SIdeBarPanel2.add(logoutBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 140, 50));

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
        SIdeBarPanel2.add(budgetIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 140, 50));

        WholePanel3.add(SIdeBarPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 520));

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

    private void EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditActionPerformed
        EditSavingsPage m = new EditSavingsPage();
        m.setLocationRelativeTo(null);
        m.setVisible(true);
        this.hide();
    }//GEN-LAST:event_EditActionPerformed

    private void mainMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainMenu2MouseClicked
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure you want to leave without saving","Warning",dialogButton);
        if(dialogResult == JOptionPane.YES_OPTION){
            MainMenu m = new MainMenu();     
            m.setVisible(true);
            this.hide();
        }
    }//GEN-LAST:event_mainMenu2MouseClicked

    private void mainMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainMenu2ActionPerformed

    }//GEN-LAST:event_mainMenu2ActionPerformed

    private void SavingsIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SavingsIconMouseClicked

    }//GEN-LAST:event_SavingsIconMouseClicked

    private void SavingsIconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SavingsIconActionPerformed

    }//GEN-LAST:event_SavingsIconActionPerformed

    private void StocksIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StocksIconMouseClicked

    }//GEN-LAST:event_StocksIconMouseClicked

    private void StocksIconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StocksIconActionPerformed
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure you want to leave without saving","Warning",dialogButton);
        if(dialogResult == JOptionPane.YES_OPTION){
            StocksInfoPage m = new StocksInfoPage();     
            m.setVisible(true);
            this.hide();
        }
    }//GEN-LAST:event_StocksIconActionPerformed

    private void cryptoIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cryptoIconMouseClicked

    }//GEN-LAST:event_cryptoIconMouseClicked

    private void cryptoIconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cryptoIconActionPerformed
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure you want to leave without saving","Warning",dialogButton);
        if(dialogResult == JOptionPane.YES_OPTION){  
            CryptoInfoPage m = new CryptoInfoPage();
            m.setVisible(true);
            this.hide();
        }
    }//GEN-LAST:event_cryptoIconActionPerformed

    private void editTextbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editTextbtnMouseClicked

    }//GEN-LAST:event_editTextbtnMouseClicked

    private void editTextbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editTextbtnActionPerformed
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure you want to leave without saving","Warning",dialogButton);
        if(dialogResult == JOptionPane.YES_OPTION){
            EditPersonalInfoPage m = new EditPersonalInfoPage();
            m.setVisible(true);
            this.hide();
    }
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
        // TODO add your handling code here:
    }//GEN-LAST:event_budgetIconMouseClicked

    private void budgetIconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_budgetIconActionPerformed
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure you want to leave without saving","Warning",dialogButton);
        if(dialogResult == JOptionPane.YES_OPTION){
            BudgetInfoPage m = new BudgetInfoPage();
            m.setLocationRelativeTo(null);
            m.setVisible(true);
            this.hide();
        }
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
    private javax.swing.JButton Edit;
    private javax.swing.JPanel InfoPanel3;
    private javax.swing.JPanel SIdeBarPanel;
    private javax.swing.JPanel SIdeBarPanel1;
    private javax.swing.JPanel SIdeBarPanel2;
    private javax.swing.JButton SavingsIcon;
    private javax.swing.JButton StocksIcon;
    private javax.swing.JPanel WholePanel3;
    private javax.swing.JButton budgetIcon;
    private javax.swing.JButton cryptoIcon;
    private javax.swing.JButton editTextbtn;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JTextField interestField;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JButton mainMenu;
    private javax.swing.JButton mainMenu1;
    private javax.swing.JButton mainMenu2;
    private javax.swing.JTextField principalField;
    private javax.swing.JTextField rateField;
    private javax.swing.JTextField timeField;
    private javax.swing.JTextField totalField;
    // End of variables declaration//GEN-END:variables
}
