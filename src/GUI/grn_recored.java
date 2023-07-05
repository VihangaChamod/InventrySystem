/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DataBase.DBMS;
import java.lang.invoke.MethodHandles;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author 3c tech
 */
public class grn_recored extends javax.swing.JFrame {

   
    public grn_recored() {
        
      
        
        initComponents();
        
     
        try {
            
        
         TableModel tm=jTable1.getModel();
       DefaultTableModel df=(DefaultTableModel) tm;
      df.setRowCount(0);
               ResultSet rs=DBMS.SE("select * from grn_product ");

               while (rs.next()) {   
                   
                   Vector v=new Vector();
                   
                     ResultSet rs1=DBMS.SE("select * from grn where id='"+rs.getString("grn_id")+"'");
                     
                     while (rs1.next()) {                       
                       
                         v.add(rs1.getString("date"));
                         v.add(rs1.getString("suppliar_mobile"));
                         
                         
                  ResultSet rs2 = DBMS.SE("select brand_id from product where id='" + rs.getString("product_id") + "'   ");
                  
                         while (rs2.next()) {                             
                             
                           ResultSet rs3 = DBMS.SE("select name from brand where id='" + rs2.getString("brand_id") + "'");
                           
                             while (rs3.next()) {                                 
                                 v.add(rs3.getString("name"));
                             }
                             
                         }

                     ResultSet rs4 = DBMS.SE("select name from product where id='" + rs.getString("product_id") + "'   ");
                     
                         while (rs4.next()) {                             
                             v.add(rs4.getString("name"));
                         }

                     v.add(rs.getString("qty"));
                      v.add(rs.getString("buying_price"));
                      
                      
                      
                      String sr = rs.getString("qty");
                String s1 = rs.getString("buying_price");
                double b1 = Double.parseDouble(sr);
                double b2 = Double.parseDouble(s1);
                double total = b1 * b2;
                

                 String ts=String.valueOf(total);
                v.add(ts);

                
                
                
                
                     String s2 = "";


                
                    v.add(rs1.getString("paid_amount"));
                    s2 = rs1.getString("paid_amount");
                

                double b3 = Double.parseDouble(s2);

                double x1 = total - b3;
                
                String x=String.valueOf(x1);

                v.add(x);
                      
                      
                      
                   
                
                
                
        
                
                
                   }
                   
                   df.addRow(v);
            }
                         
         try {
            
        
     
              

             
             
             
             int g=0;
                int cx= df.getRowCount();
               
                for (int j = 0; j < cx; j++) {
                    
                    String col1=(String) jTable1.getValueAt(j, 4);
                    int col2=Integer.parseInt(col1);
                    g=col2+g;
                }
                jLabel17.setText(g+"");
                
                
                
                
                    double g1=0.0;
                int cx1= df.getRowCount();
               
                for (int t = 0; t < cx1; t++) {
                    
                    String col3=  (String) jTable1.getValueAt(t, 6);
                    double co12=Double.parseDouble(col3);
                    g1=g1+co12;
                }
                jLabel13.setText(g1+"");
                
                
                 double g2=0.0;
                int cx2= df.getRowCount();
               
                for (int q = 0; q < cx2; q++) {
                    
                    String col3=  (String) jTable1.getValueAt(q, 8);
                       double co12=Double.parseDouble(col3);
                
               g2=g2+co12;
                
                
              jLabel1.setText(g2+"");
            
                }  } catch (Exception e2) {
        }
        
       
         } catch (Exception e) {
             System.out.println(e);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jTextField3 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Supliar", "Brand", "Product", "Qty", "Buying price", "Total", "Paid Amount", "Balance"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 900, 690));

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton7.setForeground(new java.awt.Color(51, 0, 0));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resorces/CloseAndMinimize/minimize (1).png"))); // NOI18N
        jButton7.setBorder(null);
        jButton7.setContentAreaFilled(false);
        jButton7.setFocusable(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 10, 40, 40));

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(51, 0, 0));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resorces/CloseAndMinimize/cancel (1).png"))); // NOI18N
        jButton6.setBorder(null);
        jButton6.setContentAreaFilled(false);
        jButton6.setFocusable(false);
        jButton6.setPreferredSize(new java.awt.Dimension(15, 19));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 10, 40, 40));

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setText("Qty");
        jLabel16.setOpaque(true);
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 710, 80, 40));

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setOpaque(true);
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 710, 150, 40));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setText("Total");
        jLabel14.setOpaque(true);
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 710, 80, 40));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setOpaque(true);
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 710, 190, 40));

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setText("Balance");
        jLabel15.setOpaque(true);
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 710, 80, 40));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 710, 170, 40));

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(204, 153, 0));
        jLabel18.setText("GRN All");
        jLabel18.setOpaque(true);
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 20, 100, 30));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resorces/CloseAndMinimize/iconfinder_Open_v2_131829.png"))); // NOI18N
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 10, 40, 30));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "GRN ALL", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tempus Sans ITC", 1, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setOpaque(false);

        jButton1.setBackground(new java.awt.Color(255, 204, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Filter");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Buying price");

        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField4KeyReleased(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Supliar");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Brand");

        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField5KeyReleased(evt);
            }
        });

        jTextField8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField8KeyReleased(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Qty");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Paid Amount");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Product");

        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField6KeyReleased(evt);
            }
        });

        jTextField10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField10KeyReleased(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 153, 102));
        jButton2.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Print");
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Date Time");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 250, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField3)
                                .addGap(30, 30, 30)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(10, 10, 10)
                                                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(30, 30, 30)
                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(10, 10, 10)
                                                .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(10, 10, 10))
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(30, 30, 30)))
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 50, 440, 700));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resorces/149795.jpg"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 770));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        this.setState(Home.ICONIFIED);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
       
        this.dispose();

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 String s=jTextField3.getText();
        String ss1=jTextField1.getText();
        
        
        
        try {
            
        
         TableModel tm=jTable1.getModel();
       DefaultTableModel df=(DefaultTableModel) tm;
      df.setRowCount(0);
               ResultSet rs=DBMS.SE("select * from grn_product where grn_id in(select id from grn where date between '"+s+"'and '"+ss1+"')");

               while (rs.next()) {   
                   
                   Vector v=new Vector();
                   
                     ResultSet rs1=DBMS.SE("select * from grn where id='"+rs.getString("grn_id")+"'");
                     
                     while (rs1.next()) {                       
                       
                         v.add(rs1.getString("date"));
                         v.add(rs1.getString("suppliar_mobile"));
                         
                         
                  ResultSet rs2 = DBMS.SE("select brand_id from product where id='" + rs.getString("product_id") + "'   ");
                  
                         while (rs2.next()) {                             
                             
                           ResultSet rs3 = DBMS.SE("select name from brand where id='" + rs2.getString("brand_id") + "'");
                           
                             while (rs3.next()) {                                 
                                 v.add(rs3.getString("name"));
                             }
                             
                         }

                     ResultSet rs4 = DBMS.SE("select name from product where id='" + rs.getString("product_id") + "'   ");
                     
                         while (rs4.next()) {                             
                             v.add(rs4.getString("name"));
                         }

                     v.add(rs.getString("qty"));
                      v.add(rs.getString("buying_price"));
                      
                      
                      
                      String sr = rs.getString("qty");
                String s1 = rs.getString("buying_price");
                double b1 = Double.parseDouble(sr);
                double b2 = Double.parseDouble(s1);
                double total = b1 * b2;
                

                 String ts=String.valueOf(total);
                v.add(ts);

                
                
                
                
                     String s2 = "";


                
                    v.add(rs1.getString("paid_amount"));
                    s2 = rs1.getString("paid_amount");
                

                double b3 = Double.parseDouble(s2);

                double x1 = total - b3;
                
                String x=String.valueOf(x1);

                v.add(x);
                      
                      
                      
                   
                
                
                
        
                
                
                   }
                   
                   df.addRow(v);
            }
                         
         try {
            
        
     
              

             
             
             
             int g=0;
                int cx= df.getRowCount();
               
                for (int j = 0; j < cx; j++) {
                    
                    String col1=(String) jTable1.getValueAt(j, 4);
                    int col2=Integer.parseInt(col1);
                    g=col2+g;
                }
                jLabel17.setText(g+"");
                
                
                
                
                    double g1=0.0;
                int cx1= df.getRowCount();
               
                for (int t = 0; t < cx1; t++) {
                    
                    String col3=  (String) jTable1.getValueAt(t, 6);
                    double co12=Double.parseDouble(col3);
                    g1=g1+co12;
                }
                jLabel13.setText(g1+"");
                
                
                 double g2=0.0;
                int cx2= df.getRowCount();
               
                for (int q = 0; q < cx2; q++) {
                    
                    String col3=  (String) jTable1.getValueAt(q, 8);
                       double co12=Double.parseDouble(col3);
                
               g2=g2+co12;
                
                
              jLabel1.setText(g2+"");
            
                }  } catch (Exception e2) {
        }
        
       
         } catch (Exception e) {
             System.out.println(e);
        }
      
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyReleased
String s=jTextField4.getText();
        try {
            
        
         TableModel tm=jTable1.getModel();
       DefaultTableModel df=(DefaultTableModel) tm;
      df.setRowCount(0);
               ResultSet rs=DBMS.SE("select * from grn_product where grn_id in(select id from grn where suppliar_mobile like '%"+s+"%')");

               while (rs.next()) {   
                   
                   Vector v=new Vector();
                   
                     ResultSet rs1=DBMS.SE("select * from grn where id='"+rs.getString("grn_id")+"'");
                     
                     while (rs1.next()) {                       
                       
                         v.add(rs1.getString("date"));
                         v.add(rs1.getString("suppliar_mobile"));
                         
                         
                  ResultSet rs2 = DBMS.SE("select brand_id from product where id='" + rs.getString("product_id") + "'   ");
                  
                         while (rs2.next()) {                             
                             
                           ResultSet rs3 = DBMS.SE("select name from brand where id='" + rs2.getString("brand_id") + "'");
                           
                             while (rs3.next()) {                                 
                                 v.add(rs3.getString("name"));
                             }
                             
                         }

                     ResultSet rs4 = DBMS.SE("select name from product where id='" + rs.getString("product_id") + "'   ");
                     
                         while (rs4.next()) {                             
                             v.add(rs4.getString("name"));
                         }

                     v.add(rs.getString("qty"));
                      v.add(rs.getString("buying_price"));
                      
                      
                      
                      String sr = rs.getString("qty");
                String s1 = rs.getString("buying_price");
                double b1 = Double.parseDouble(sr);
                double b2 = Double.parseDouble(s1);
                double total = b1 * b2;
                

                 String ts=String.valueOf(total);
                v.add(ts);

                
                
                
                
                     String s2 = "";


                
                    v.add(rs1.getString("paid_amount"));
                    s2 = rs1.getString("paid_amount");
                

                double b3 = Double.parseDouble(s2);

                double x1 = total - b3;
                
                String x=String.valueOf(x1);

                v.add(x);
                      
                      
                      
                   
                
                
                
        
                
                
                   }
                   
                   df.addRow(v);
            }
                         
         try {
            
        
     
              

             
             
             
             int g=0;
                int cx= df.getRowCount();
               
                for (int j = 0; j < cx; j++) {
                    
                    String col1=(String) jTable1.getValueAt(j, 4);
                    int col2=Integer.parseInt(col1);
                    g=col2+g;
                }
                jLabel17.setText(g+"");
                
                
                
                
                    double g1=0.0;
                int cx1= df.getRowCount();
               
                for (int t = 0; t < cx1; t++) {
                    
                    String col3=  (String) jTable1.getValueAt(t, 6);
                    double co12=Double.parseDouble(col3);
                    g1=g1+co12;
                }
                jLabel13.setText(g1+"");
                
                
                 double g2=0.0;
                int cx2= df.getRowCount();
               
                for (int q = 0; q < cx2; q++) {
                    
                    String col3=  (String) jTable1.getValueAt(q, 8);
                       double co12=Double.parseDouble(col3);
                
               g2=g2+co12;
                
                
              jLabel1.setText(g2+"");
            
                }  } catch (Exception e2) {
        }
        
       
         } catch (Exception e) {
             System.out.println(e);
        }
        
        
 











    }//GEN-LAST:event_jTextField4KeyReleased

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased

             String s=jTextField2.getText();
        try {
            
        
         TableModel tm=jTable1.getModel();
       DefaultTableModel df=(DefaultTableModel) tm;
      df.setRowCount(0);
               ResultSet rs=DBMS.SE("select * from grn_product where buying_price like '%"+s+"%'");

               while (rs.next()) {   
                   
                   Vector v=new Vector();
                   
                     ResultSet rs1=DBMS.SE("select * from grn where id='"+rs.getString("grn_id")+"'");
                     
                     while (rs1.next()) {                       
                       
                         v.add(rs1.getString("date"));
                         v.add(rs1.getString("suppliar_mobile"));
                         
                         
                  ResultSet rs2 = DBMS.SE("select brand_id from product where id='" + rs.getString("product_id") + "'   ");
                  
                         while (rs2.next()) {                             
                             
                           ResultSet rs3 = DBMS.SE("select name from brand where id='" + rs2.getString("brand_id") + "'");
                           
                             while (rs3.next()) {                                 
                                 v.add(rs3.getString("name"));
                             }
                             
                         }

                     ResultSet rs4 = DBMS.SE("select name from product where id='" + rs.getString("product_id") + "'   ");
                     
                         while (rs4.next()) {                             
                             v.add(rs4.getString("name"));
                         }

                     v.add(rs.getString("qty"));
                      v.add(rs.getString("buying_price"));
                      
                      
                      
                      String sr = rs.getString("qty");
                String s1 = rs.getString("buying_price");
                double b1 = Double.parseDouble(sr);
                double b2 = Double.parseDouble(s1);
                double total = b1 * b2;
                

                 String ts=String.valueOf(total);
                v.add(ts);

                
                
                
                
                     String s2 = "";


                
                    v.add(rs1.getString("paid_amount"));
                    s2 = rs1.getString("paid_amount");
                

                double b3 = Double.parseDouble(s2);

                double x1 = total - b3;
                
                String x=String.valueOf(x1);

                v.add(x);
                      
                      
                      
                   
                
                
                
      
                
                
                   }
                   
                   df.addRow(v);
            }
               
                         
         try {
            
        
     
              

             
             
             
             int g=0;
                int cx= df.getRowCount();
               
                for (int j = 0; j < cx; j++) {
                    
                    String col1=(String) jTable1.getValueAt(j, 4);
                    int col2=Integer.parseInt(col1);
                    g=col2+g;
                }
                jLabel17.setText(g+"");
                
                
                
                
                    double g1=0.0;
                int cx1= df.getRowCount();
               
                for (int t = 0; t < cx1; t++) {
                    
                    String col3=  (String) jTable1.getValueAt(t, 6);
                    double co12=Double.parseDouble(col3);
                    g1=g1+co12;
                }
                jLabel13.setText(g1+"");
                
                
                 double g2=0.0;
                int cx2= df.getRowCount();
               
                for (int q = 0; q < cx2; q++) {
                    
                    String col3=  (String) jTable1.getValueAt(q, 8);
                       double co12=Double.parseDouble(col3);
                
               g2=g2+co12;
                
                
              jLabel1.setText(g2+"");
            
                }  } catch (Exception e2) {
        }
               
        
       
         } catch (Exception e) {
             System.out.println(e);
        }
        
        
              // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2KeyReleased

    private void jTextField5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyReleased
String s=jTextField5.getText();
        try {
            
        
         TableModel tm=jTable1.getModel();
       DefaultTableModel df=(DefaultTableModel) tm;
      df.setRowCount(0);
               ResultSet rs=DBMS.SE("select * from grn_product where product_id in(select id from product where brand_id in(select id from brand where name like'%"+s+"%') )");

               while (rs.next()) {   
                   
                   Vector v=new Vector();
                   
                     ResultSet rs1=DBMS.SE("select * from grn where id='"+rs.getString("grn_id")+"'");
                     
                     while (rs1.next()) {                       
                       
                         v.add(rs1.getString("date"));
                         v.add(rs1.getString("suppliar_mobile"));
                         
                         
                  ResultSet rs2 = DBMS.SE("select brand_id from product where id='" + rs.getString("product_id") + "'   ");
                  
                         while (rs2.next()) {                             
                             
                           ResultSet rs3 = DBMS.SE("select name from brand where id='" + rs2.getString("brand_id") + "'");
                           
                             while (rs3.next()) {                                 
                                 v.add(rs3.getString("name"));
                             }
                             
                         }

                     ResultSet rs4 = DBMS.SE("select name from product where id='" + rs.getString("product_id") + "'   ");
                     
                         while (rs4.next()) {                             
                             v.add(rs4.getString("name"));
                         }

                     v.add(rs.getString("qty"));
                      v.add(rs.getString("buying_price"));
                      
                      
                      
                      String sr = rs.getString("qty");
                String s1 = rs.getString("buying_price");
                double b1 = Double.parseDouble(sr);
                double b2 = Double.parseDouble(s1);
                double total = b1 * b2;
                

                 String ts=String.valueOf(total);
                v.add(ts);

                
                
                
                
                     String s2 = "";


                
                    v.add(rs1.getString("paid_amount"));
                    s2 = rs1.getString("paid_amount");
                

                double b3 = Double.parseDouble(s2);

                double x1 = total - b3;
                
                String x=String.valueOf(x1);

                v.add(x);
                      
                      
                      
                   
                
                
      
                
                
                
                   }
                   
                   df.addRow(v);
            }
               
                         
         try {
            
        
     
              

             
             
             
             int g=0;
                int cx= df.getRowCount();
               
                for (int j = 0; j < cx; j++) {
                    
                    String col1=(String) jTable1.getValueAt(j, 4);
                    int col2=Integer.parseInt(col1);
                    g=col2+g;
                }
                jLabel17.setText(g+"");
                
                
                
                
                    double g1=0.0;
                int cx1= df.getRowCount();
               
                for (int t = 0; t < cx1; t++) {
                    
                    String col3=  (String) jTable1.getValueAt(t, 6);
                    double co12=Double.parseDouble(col3);
                    g1=g1+co12;
                }
                jLabel13.setText(g1+"");
                
                
                 double g2=0.0;
                int cx2= df.getRowCount();
               
                for (int q = 0; q < cx2; q++) {
                    
                    String col3=  (String) jTable1.getValueAt(q, 8);
                       double co12=Double.parseDouble(col3);
                
               g2=g2+co12;
                
                
              jLabel1.setText(g2+"");
            
                }  } catch (Exception e2) {
        }
               
        
       
         } catch (Exception e) {
             System.out.println(e);
        }
        
               // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5KeyReleased

    private void jTextField6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyReleased
String s=jTextField6.getText();
        try {
            
        
         TableModel tm=jTable1.getModel();
       DefaultTableModel df=(DefaultTableModel) tm;
      df.setRowCount(0);
               ResultSet rs=DBMS.SE("select * from grn_product where product_id in(select id from product where name like '%"+s+"%')");

               while (rs.next()) {   
                   
                   Vector v=new Vector();
                   
                     ResultSet rs1=DBMS.SE("select * from grn where id='"+rs.getString("grn_id")+"'");
                     
                     while (rs1.next()) {                       
                       
                         v.add(rs1.getString("date"));
                         v.add(rs1.getString("suppliar_mobile"));
                         
                         
                  ResultSet rs2 = DBMS.SE("select brand_id from product where id='" + rs.getString("product_id") + "'   ");
                  
                         while (rs2.next()) {                             
                             
                           ResultSet rs3 = DBMS.SE("select name from brand where id='" + rs2.getString("brand_id") + "'");
                           
                             while (rs3.next()) {                                 
                                 v.add(rs3.getString("name"));
                             }
                             
                         }

                     ResultSet rs4 = DBMS.SE("select name from product where id='" + rs.getString("product_id") + "'   ");
                     
                         while (rs4.next()) {                             
                             v.add(rs4.getString("name"));
                         }

                     v.add(rs.getString("qty"));
                      v.add(rs.getString("buying_price"));
                      
                      
                      
                      String sr = rs.getString("qty");
                String s1 = rs.getString("buying_price");
                double b1 = Double.parseDouble(sr);
                double b2 = Double.parseDouble(s1);
                double total = b1 * b2;
                

                 String ts=String.valueOf(total);
                v.add(ts);

                
                
                
                
                     String s2 = "";


                
                    v.add(rs1.getString("paid_amount"));
                    s2 = rs1.getString("paid_amount");
                

                double b3 = Double.parseDouble(s2);

                double x1 = total - b3;
                
                String x=String.valueOf(x1);

                v.add(x);
                      
                      
                      
                   
                
                
                
        
                
                
                   }
                   
                   df.addRow(v);
            }
                         
         try {
            
        
     
              

             
             
             
             int g=0;
                int cx= df.getRowCount();
               
                for (int j = 0; j < cx; j++) {
                    
                    String col1=(String) jTable1.getValueAt(j, 4);
                    int col2=Integer.parseInt(col1);
                    g=col2+g;
                }
                jLabel17.setText(g+"");
                
                
                
                
                    double g1=0.0;
                int cx1= df.getRowCount();
               
                for (int t = 0; t < cx1; t++) {
                    
                    String col3=  (String) jTable1.getValueAt(t, 6);
                    double co12=Double.parseDouble(col3);
                    g1=g1+co12;
                }
                jLabel13.setText(g1+"");
                
                
                 double g2=0.0;
                int cx2= df.getRowCount();
               
                for (int q = 0; q < cx2; q++) {
                    
                    String col3=  (String) jTable1.getValueAt(q, 8);
                       double co12=Double.parseDouble(col3);
                
               g2=g2+co12;
                
                
              jLabel1.setText(g2+"");
            
                }  } catch (Exception e2) {
        }
        
       
         } catch (Exception e) {
             System.out.println(e);
        }
        
        
        
        
        
        
        
    }//GEN-LAST:event_jTextField6KeyReleased

    private void jTextField10KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField10KeyReleased
String s=jTextField10.getText();
        try {
            
        
         TableModel tm=jTable1.getModel();
       DefaultTableModel df=(DefaultTableModel) tm;
      df.setRowCount(0);
               ResultSet rs=DBMS.SE("select * from grn_product where grn_id in(select id from grn where paid_amount like '%"+s+"%')");

               while (rs.next()) {   
                   
                   Vector v=new Vector();
                   
                     ResultSet rs1=DBMS.SE("select * from grn where id='"+rs.getString("grn_id")+"'");
                     
                     while (rs1.next()) {                       
                       
                         v.add(rs1.getString("date"));
                         v.add(rs1.getString("suppliar_mobile"));
                         
                         
                  ResultSet rs2 = DBMS.SE("select brand_id from product where id='" + rs.getString("product_id") + "'   ");
                  
                         while (rs2.next()) {                             
                             
                           ResultSet rs3 = DBMS.SE("select name from brand where id='" + rs2.getString("brand_id") + "'");
                           
                             while (rs3.next()) {                                 
                                 v.add(rs3.getString("name"));
                             }
                             
                         }

                     ResultSet rs4 = DBMS.SE("select name from product where id='" + rs.getString("product_id") + "'   ");
                     
                         while (rs4.next()) {                             
                             v.add(rs4.getString("name"));
                         }

                     v.add(rs.getString("qty"));
                      v.add(rs.getString("buying_price"));
                      
                      
                      
                      String sr = rs.getString("qty");
                String s1 = rs.getString("buying_price");
                double b1 = Double.parseDouble(sr);
                double b2 = Double.parseDouble(s1);
                double total = b1 * b2;
                

                 String ts=String.valueOf(total);
                v.add(ts);

                
                
                
                
                     String s2 = "";


                
                    v.add(rs1.getString("paid_amount"));
                    s2 = rs1.getString("paid_amount");
                

                double b3 = Double.parseDouble(s2);

                double x1 = total - b3;
                
                String x=String.valueOf(x1);

                v.add(x);
                      
                      
                      
                   
                
                
                
        
                
                
                   }
                   
                   df.addRow(v);
            }
                         
         try {
            
        
     
              

             
             
             
             int g=0;
                int cx= df.getRowCount();
               
                for (int j = 0; j < cx; j++) {
                    
                    String col1=(String) jTable1.getValueAt(j, 4);
                    int col2=Integer.parseInt(col1);
                    g=col2+g;
                }
                jLabel17.setText(g+"");
                
                
                
                
                    double g1=0.0;
                int cx1= df.getRowCount();
               
                for (int t = 0; t < cx1; t++) {
                    
                    String col3=  (String) jTable1.getValueAt(t, 6);
                    double co12=Double.parseDouble(col3);
                    g1=g1+co12;
                }
                jLabel13.setText(g1+"");
                
                
                 double g2=0.0;
                int cx2= df.getRowCount();
               
                for (int q = 0; q < cx2; q++) {
                    
                    String col3=  (String) jTable1.getValueAt(q, 8);
                       double co12=Double.parseDouble(col3);
                
               g2=g2+co12;
                
                
              jLabel1.setText(g2+"");
            
                }  } catch (Exception e2) {
        }
        
       
         } catch (Exception e) {
             System.out.println(e);
        }
        

// TODO add your handling code here:
    }//GEN-LAST:event_jTextField10KeyReleased

    private void jTextField8KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField8KeyReleased
String s=jTextField8.getText();
        try {
            
        
         TableModel tm=jTable1.getModel();
       DefaultTableModel df=(DefaultTableModel) tm;
      df.setRowCount(0);
               ResultSet rs=DBMS.SE("select * from grn_product where qty like '%"+s+"%'");

               while (rs.next()) {   
                   
                   Vector v=new Vector();
                   
                     ResultSet rs1=DBMS.SE("select * from grn where id='"+rs.getString("grn_id")+"'");
                     
                     while (rs1.next()) {                       
                       
                         v.add(rs1.getString("date"));
                         v.add(rs1.getString("suppliar_mobile"));
                         
                         
                  ResultSet rs2 = DBMS.SE("select brand_id from product where id='" + rs.getString("product_id") + "'   ");
                  
                         while (rs2.next()) {                             
                             
                           ResultSet rs3 = DBMS.SE("select name from brand where id='" + rs2.getString("brand_id") + "'");
                           
                             while (rs3.next()) {                                 
                                 v.add(rs3.getString("name"));
                             }
                             
                         }

                     ResultSet rs4 = DBMS.SE("select name from product where id='" + rs.getString("product_id") + "'   ");
                     
                         while (rs4.next()) {                             
                             v.add(rs4.getString("name"));
                         }

                     v.add(rs.getString("qty"));
                      v.add(rs.getString("buying_price"));
                      
                      
                      
                      String sr = rs.getString("qty");
                String s1 = rs.getString("buying_price");
                double b1 = Double.parseDouble(sr);
                double b2 = Double.parseDouble(s1);
                double total = b1 * b2;
                

                 String ts=String.valueOf(total);
                v.add(ts);

                
                
                
                
                     String s2 = "";


                
                    v.add(rs1.getString("paid_amount"));
                    s2 = rs1.getString("paid_amount");
                

                double b3 = Double.parseDouble(s2);

                double x1 = total - b3;
                
                String x=String.valueOf(x1);

                v.add(x);
                      
                      
                      
                   
                
                
                
        
                
                
                   }
                   
                   df.addRow(v);
            }
                         
         try {
            
        
     
              

             
             
             
             int g=0;
                int cx= df.getRowCount();
               
                for (int j = 0; j < cx; j++) {
                    
                    String col1=(String) jTable1.getValueAt(j, 4);
                    int col2=Integer.parseInt(col1);
                    g=col2+g;
                }
                jLabel17.setText(g+"");
                
                
                
                
                    double g1=0.0;
                int cx1= df.getRowCount();
               
                for (int t = 0; t < cx1; t++) {
                    
                    String col3=  (String) jTable1.getValueAt(t, 6);
                    double co12=Double.parseDouble(col3);
                    g1=g1+co12;
                }
                jLabel13.setText(g1+"");
                
                
                 double g2=0.0;
                int cx2= df.getRowCount();
               
                for (int q = 0; q < cx2; q++) {
                    
                    String col3=  (String) jTable1.getValueAt(q, 8);
                       double co12=Double.parseDouble(col3);
                
               g2=g2+co12;
                
                
              jLabel1.setText(g2+"");
            
                }  } catch (Exception e2) {
        }
        
       
         } catch (Exception e) {
             System.out.println(e);
        }
        
        
    }//GEN-LAST:event_jTextField8KeyReleased

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
                    TableModel tm=jTable1.getModel();

        
        
        reporti2 i=new reporti2(tm,jLabel17,jLabel13,jLabel1);
            i.setVisible(true); 
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        view v=new view();
        v.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel19MouseClicked

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(grn_recored.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(grn_recored.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(grn_recored.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(grn_recored.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new grn_recored().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables
}
