
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Rumeth
 */
public class Sales_GUI extends javax.swing.JFrame {

    /**
     * Creates new form Sales_GUI
     */
    Connection con;
    PreparedStatement stmt;
    
    public Sales_GUI() {
        initComponents();
        fillTable();             
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE, MMMM d, yyyy h:mm:ss a");
        jLabel8.setText(sdf.format(d));
        jTextArea1.setVisible(false);
    }
    void fillTable() {

        try {
            String url1 = "jdbc:derby://localhost:1527/Staff";
            con = DriverManager.getConnection(url1, "app", "123");
            stmt = con.prepareStatement("SELECT * FROM APP.INVOICE_TABLE");
            ResultSet rs = stmt.executeQuery();
            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);

            while (rs.next()) {
                Vector v = new Vector<>();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));
                dtm.addRow(v);

            }
            jTable1.setModel(dtm);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void EarningCal(){
        double sumTotal = 0;
        for (int i=0;i<jTable1.getRowCount();i++){
            sumTotal=sumTotal+Double.parseDouble(jTable1.getValueAt(i,1).toString());
        }
        jTextField2.setText(Double.toString(sumTotal));
        double Total1 =Double.parseDouble(jTextField2.getText());
        
        double sumTax = 0;
        for (int i=0;i<jTable1.getRowCount();i++){
            sumTax = sumTax+Double.parseDouble(jTable1.getValueAt(i,2).toString());
        }
        jTextField3.setText(Double.toString(sumTax));
        double Tax =Double.parseDouble(jTextField3.getText());
        
        String iTotal=String.format("LKR  %.2f", Total1);
        jTextField2.setText(iTotal);
        
        String iTax=String.format("LKR  %.2f",Tax);
        jTextField3.setText(iTax);
        
        int invoiceCount = jTable1.getRowCount();
        jTextField1.setText(Integer.toString(invoiceCount));
        
        String iInvoiceCount = String.format(" %d", invoiceCount);
        jTextField1.setText(iInvoiceCount);
        
        double netProfit = Total1 - Tax;
        String iNetProfit = String.format("LKR  %.2f", netProfit);
        jTextField4.setText(iNetProfit);
        
        jTextField1.setEditable(false);
        jTextField2.setEditable(false);
        jTextField3.setEditable(false);
        jTextField4.setEditable(false);
        }
    public void report(){
                      
        jTextArea1.setText("                                                                            Cafe.One\n                  ");
        jTextArea1.setText(jTextArea1.getText()+"                                                     56, Galle Road,\n");
        jTextArea1.setText(jTextArea1.getText()+"                                                                  Colombo, Sri Lanka.\n");
        jTextArea1.setText(jTextArea1.getText()+"                                                                         0112244558\n");
        jTextArea1.setText(jTextArea1.getText()+"--------------------------------------------------------------------------------------------------------------------------------------------------\n");
        jTextArea1.setText(jTextArea1.getText()+"\n");
        jTextArea1.setText(jTextArea1.getText()+"                                                                     SALES OVERVIEW\n");
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE, MMMM d, yyyy h:mm:ss a");
        jLabel8.setText(sdf.format(d));
        jTextArea1.setText(jTextArea1.getText()+"                                              As at :  "+jLabel8.getText()+"\n");
        jTextArea1.setText(jTextArea1.getText()+"--------------------------------------------------------------------------------------------------------------------------------------------------\n");
        jTextArea1.setText(jTextArea1.getText()+"|   Invoice Number  |\t  Paid Amount\t |\tTax Amount\t |\tPayment Method|\n");
        jTextArea1.setText(jTextArea1.getText()+"--------------------------------------------------------------------------------------------------------------------------------------------------\n");
        
        for (int i=0; i<jTable1.getRowCount();i++){
            String invoice_num=jTable1.getValueAt(i,0).toString();
            String paid_amount=jTable1.getValueAt(i,1).toString();
            String tax_amount=jTable1.getValueAt(i,2).toString();
            String payment_method=jTable1.getValueAt(i,3).toString();
            jTextArea1.setText(jTextArea1.getText()+"| "+invoice_num+"             |\t"+paid_amount+"\t\t"+tax_amount+"\t\t"+ payment_method+"\n");
            jTextArea1.setText(jTextArea1.getText()+"----------------------------------------------------------------------------------------------------------------------------------------------\n");
                       
     }
        jTextArea1.setText(jTextArea1.getText()+"\n");
        jTextArea1.setText(jTextArea1.getText()+"Total Number of Invoices\t\t\t\t "+jTextField1.getText()+"\n");
        jTextArea1.setText(jTextArea1.getText()+"\n");
        jTextArea1.setText(jTextArea1.getText()+"Total Earnings\t\t\t\t\t "+jTextField2.getText()+"\n");
        jTextArea1.setText(jTextArea1.getText()+"\n");
        jTextArea1.setText(jTextArea1.getText()+"Total Amount of Tax Charged\t\t\t\t "+jTextField3.getText()+"\n");
        jTextArea1.setText(jTextArea1.getText()+"\n");
        jTextArea1.setText(jTextArea1.getText()+"Net Profit\t\t\t\t\t "+jTextField4.getText()+"\n");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("Bundle"); // NOI18N
        setTitle(bundle.getString("Sales_GUI.title")); // NOI18N
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Invoice Number", "Paid Amount (LKR)", "Tax Charged (LKR)", "Payment Method", "Date"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 290, 529, 310));

        jLabel1.setFont(new java.awt.Font("Rockwell Nova", 0, 24)); // NOI18N
        jLabel1.setText(bundle.getString("Sales_GUI.jLabel1.text")); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, -1, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel2.setFont(new java.awt.Font("Rockwell Nova", 0, 18)); // NOI18N
        jLabel2.setText(bundle.getString("Sales_GUI.jLabel2.text")); // NOI18N

        jLabel3.setFont(new java.awt.Font("Rockwell Nova", 0, 18)); // NOI18N
        jLabel3.setText(bundle.getString("Sales_GUI.jLabel3.text")); // NOI18N

        jLabel4.setFont(new java.awt.Font("Rockwell Nova", 0, 24)); // NOI18N
        jLabel4.setText(bundle.getString("Sales_GUI.jLabel4.text")); // NOI18N

        jLabel5.setFont(new java.awt.Font("Rockwell Nova", 0, 18)); // NOI18N
        jLabel5.setText(bundle.getString("Sales_GUI.jLabel5.text")); // NOI18N

        jButton1.setFont(new java.awt.Font("Rockwell Nova", 0, 18)); // NOI18N
        jButton1.setText(bundle.getString("Sales_GUI.jButton1.text")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jTextField2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(51, 204, 0));

        jTextField3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(255, 51, 51));

        jTextField4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(0, 51, 204));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel4)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(17, 17, 17))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 530, 350));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo1.jpg"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, -1, -1));

        jLabel7.setFont(new java.awt.Font("Rockwell Nova", 0, 18)); // NOI18N
        jLabel7.setText(bundle.getString("Sales_GUI.jLabel7.text")); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 240, -1, -1));

        jLabel8.setFont(new java.awt.Font("Rockwell Nova", 0, 18)); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 190, 362, 25));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 930, 624, 108));

        jLabel10.setFont(new java.awt.Font("Rockwell Nova", 0, 18)); // NOI18N
        jLabel10.setText(bundle.getString("Sales_GUI.jLabel10.text")); // NOI18N
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, -1, -1));

        jLabel11.setFont(new java.awt.Font("Rockwell Nova", 0, 18)); // NOI18N
        jLabel11.setText(bundle.getString("Sales_GUI.jLabel11.text")); // NOI18N
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField5KeyReleased(evt);
            }
        });
        getContentPane().add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 180, 30));

        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField6KeyReleased(evt);
            }
        });
        getContentPane().add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 240, 310, 30));

        jButton2.setFont(new java.awt.Font("Rockwell Nova", 0, 14)); // NOI18N
        jButton2.setText(bundle.getString("Sales_GUI.jButton2.text")); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 230, -1, -1));

        jButton3.setFont(new java.awt.Font("Rockwell Nova", 0, 14)); // NOI18N
        jButton3.setText(bundle.getString("Sales_GUI.jButton3.text")); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 610, -1, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cups.jpg"))); // NOI18N
        jLabel12.setText(bundle.getString("Sales_GUI.jLabel12.text")); // NOI18N
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, -320, 1150, 1000));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        MessageFormat footer= new MessageFormat ("Page{0,number,integer}");
        
        try{
            jTextArea1.print();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyReleased
        try{
            String url1="jdbc:derby://localhost:1527/Staff";
            con=DriverManager.getConnection(url1,"app","123");
            stmt=con.prepareStatement("SELECT * FROM INVOICE_TABLE WHERE INVOICE_NUMBER LIKE ? OR PAYMENT_METHOD LIKE ? OR DATE LIKE ?");
            stmt.setString(1,"%"+jTextField6.getText()+"%");
            stmt.setString(2,"%"+jTextField6.getText()+"%");
            stmt.setString(3,"%"+jTextField6.getText()+"%");            
            ResultSet rs=stmt.executeQuery();
            DefaultTableModel dtm=(DefaultTableModel)jTable1.getModel();
            dtm.setRowCount(0);
            
            while(rs.next()){
                Vector v = new Vector<>();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));
                dtm.addRow(v);
                               
            }
            jTable1.setModel(dtm);
            
        }catch (Exception e) {
    System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jTextField6KeyReleased

    private void jTextField5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyReleased
       try{
            String url1="jdbc:derby://localhost:1527/Staff";
            con=DriverManager.getConnection(url1,"app","123");
            stmt=con.prepareStatement("SELECT * FROM INVOICE_TABLE WHERE DATE LIKE ?");
            stmt.setString(1,"%"+jTextField5.getText()+"%");
            
            ResultSet rs=stmt.executeQuery();
            DefaultTableModel dtm=(DefaultTableModel)jTable1.getModel();
            dtm.setRowCount(0);
            
            while(rs.next()){
                Vector v = new Vector<>();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));
                dtm.addRow(v);
                               
            }
            jTable1.setModel(dtm);
            
        }catch (Exception e) {
    System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jTextField5KeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      EarningCal();
      report();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
        fillTable();

    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Sales_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sales_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sales_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sales_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sales_GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
