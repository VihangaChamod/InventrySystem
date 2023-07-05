/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DataBase.DBMS;
import com.mysql.cj.protocol.a.MysqlBinaryValueDecoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.swing.JRViewer;
import net.sf.jasperreports.view.JasperViewer;
import sun.net.www.MeteredStream;

/**
 *
 * @author 3c tech
 */
public class invoice_recored extends javax.swing.JFrame {

    public invoice_recored() {
        
        
      
       
        
        initComponents();
        
        String selling="";
        String buy="";
        String cv="";
        
          try {
            
        
         TableModel tm=jTable1.getModel();
       DefaultTableModel df=(DefaultTableModel) tm;
      df.setRowCount(0);
               ResultSet rs=DBMS.SE("select * from invoice_product ");

               while (rs.next()) {   
                   
                   Vector v=new Vector();
                   
                     ResultSet rs1=DBMS.SE("select * from invoice where id='"+rs.getString("invoice_id")+"'");
                     
                     while (rs1.next()) {                       
                       
                         v.add(rs1.getString("date"));
                         
                         
                         
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
                         v.add(rs1.getString("discount"));
                     v.add(rs1.getString("paid_amount"));
                      
                      
                      v.add(rs.getString("qty"));
                      String sr = rs.getString("qty");
                      
                       
                      
                      
                      
                      
                             
              ResultSet rs6 = DBMS.SE("select selling_price from product where id='" + rs.getString("product_id") + "'");
     
                             while (rs6.next()) {                                 
                                 v.add(rs6.getString("selling_price"));
                                 
                                 selling=rs6.getString("selling_price");
                             }
                             
                             
                             
                               
                             
                             ResultSet rsx = DBMS.SE("select buying_price from grn_product where product_id='" + rs.getString("product_id") + "'");
                                   
                                   while (rsx.next()) {                                 
                                 
                             cv=rsx.getString("buying_price");
                             v.add(rsx.getString("buying_price"));
                                        }
                                              
                         
                         
                         
                      
                      
                      
                     
                      
                      
                      
                      
               
                double b1 = Double.parseDouble(sr);
                double b2 = Double.parseDouble(selling);
                double total = b1 * b2;
                

                 String ts=String.valueOf(total);
                v.add(ts);

                
                
                

                
                  
                

                double b3 = Double.parseDouble(cv);

                double x1 = b1*b3;
                            
               double xxx=total-x1;
                
                
                String x=String.valueOf(xxx);

                v.add(x);
                      
                      
                      
                   
                
                
                
        
                
                
                   }
                   
                   df.addRow(v);
            }
                         
         try {
            
        
     
              

             
             
             
             int g=0;
                int cx= df.getRowCount();
               
                for (int j = 0; j < cx; j++) {
                    
                    String col1=(String) jTable1.getValueAt(j, 5);
                    int col2=Integer.parseInt(col1);
                    g=col2+g;
                }
                jLabel17.setText(g+"");
                
                
                
                
                    double g1=0.0;
                int cx1= df.getRowCount();
               
                for (int t = 0; t < cx1; t++) {
                    
                    String col3=  (String) jTable1.getValueAt(t, 8);
                    double co12=Double.parseDouble(col3);
                    g1=g1+co12;
                }
                jLabel13.setText(g1+"");
                
                
                 double g2=0.0;
                int cx2= df.getRowCount();
               
                for (int q = 0; q < cx2; q++) {
                    
                    String col3=  (String) jTable1.getValueAt(q, 9);
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
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Brand", "Product", "Discount", "Paid Amount", "Qty", "Selling price", "Buying price", "Total", "Profit"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 900, 700));

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

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 720, 210, 40));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setOpaque(true);
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 720, 210, 40));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setText("Total");
        jLabel14.setOpaque(true);
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 720, 100, 40));

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setText("Profit");
        jLabel15.setOpaque(true);
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 720, 100, 40));

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setText("Qty");
        jLabel16.setOpaque(true);
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 720, 100, 40));

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setOpaque(true);
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 720, 130, 40));

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(204, 153, 0));
        jLabel18.setText("Invoice All");
        jLabel18.setOpaque(true);
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 20, 130, 30));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resorces/CloseAndMinimize/iconfinder_Open_v2_131829.png"))); // NOI18N
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 10, 40, 30));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Invoice All", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 255, 0))); // NOI18N
        jPanel1.setOpaque(false);

        jButton2.setBackground(new java.awt.Color(255, 204, 0));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(51, 51, 51));
        jButton2.setText("Print");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Brand");

        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField4KeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Product");

        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField5KeyReleased(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Qty");

        jTextField9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField9KeyReleased(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Selling Price");

        jTextField7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField7KeyReleased(evt);
            }
        });

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Discount");

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField3KeyReleased(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Paid Amount");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Date Time");

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jTextField11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField11ActionPerformed(evt);
            }
        });
        jTextField11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField11KeyReleased(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 204, 51));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Filter");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(20, 20, 20))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(25, 25, 25))
                                    .addComponent(jTextField4))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 60, 440, 700));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resorces/149795.jpg"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
     
        
           
        
        
       
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
         
         this.dispose();
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        this.setState(Home.ICONIFIED);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
 String s=jTextField2.getText();
        
        
        String selling="";
        String buy="";
        String cv="";
        
          try {
            
        
         TableModel tm=jTable1.getModel();
       DefaultTableModel df=(DefaultTableModel) tm;
      df.setRowCount(0);
               ResultSet rs=DBMS.SE("select * from invoice_product where invoice_id in(select id from invoice where discount like'"+s+"') ");

               while (rs.next()) {   
                   
                   Vector v=new Vector();
                   
                     ResultSet rs1=DBMS.SE("select * from invoice where id='"+rs.getString("invoice_id")+"'");
                     
                     while (rs1.next()) {                       
                       
                         v.add(rs1.getString("date"));
                         
                         
                         
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
                         v.add(rs1.getString("discount"));
                     v.add(rs1.getString("paid_amount"));
                      
                      
                      v.add(rs.getString("qty"));
                      String sr = rs.getString("qty");
                      
                       
                      
                      
                      
                      
                             
              ResultSet rs6 = DBMS.SE("select selling_price from product where id='" + rs.getString("product_id") + "'");
     
                             while (rs6.next()) {                                 
                                 v.add(rs6.getString("selling_price"));
                                 
                                 selling=rs6.getString("selling_price");
                             }
                             
                             
                             
                               
                             
                             ResultSet rsx = DBMS.SE("select buying_price from grn_product where product_id='" + rs.getString("product_id") + "'");
                                   
                                   while (rsx.next()) {                                 
                                 
                             cv=rsx.getString("buying_price");
                             v.add(rsx.getString("buying_price"));
                                        }
                                              
                         
                         
                         
                      
                      
                      
                     
                      
                      
                      
                      
               
                double b1 = Double.parseDouble(sr);
                double b2 = Double.parseDouble(selling);
                double total = b1 * b2;
                

                 String ts=String.valueOf(total);
                v.add(ts);

                
                
                

                
                  
                

                double b3 = Double.parseDouble(cv);

                double x1 = b1*b3;
                            
               double xxx=total-x1;
                
                
                String x=String.valueOf(xxx);

                v.add(x);
                      
                      
                      
                   
                
                
                
        
                
                
                   }
                   
                   df.addRow(v);
            }
                         
         try {
            
        
     
              

             
             
             
             int g=0;
                int cx= df.getRowCount();
               
                for (int j = 0; j < cx; j++) {
                    
                    String col1=(String) jTable1.getValueAt(j, 5);
                    int col2=Integer.parseInt(col1);
                    g=col2+g;
                }
                jLabel17.setText(g+"");
                
                
                
                
                    double g1=0.0;
                int cx1= df.getRowCount();
               
                for (int t = 0; t < cx1; t++) {
                    
                    String col3=  (String) jTable1.getValueAt(t, 8);
                    double co12=Double.parseDouble(col3);
                    g1=g1+co12;
                }
                jLabel13.setText(g1+"");
                
                
                 double g2=0.0;
                int cx2= df.getRowCount();
               
                for (int q = 0; q < cx2; q++) {
                    
                    String col3=  (String) jTable1.getValueAt(q, 9);
                       double co12=Double.parseDouble(col3);
                
               g2=g2+co12;
                
                
              jLabel1.setText(g2+"");
            
                }  } catch (Exception e2) {
        }
        
       
         } catch (Exception e) {
             System.out.println(e);
        }   
    }//GEN-LAST:event_jTextField2KeyReleased

    private void jTextField3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyReleased
        String s=jTextField3.getText();
        
        
        String selling="";
        String buy="";
        String cv="";
        
          try {
            
        
         TableModel tm=jTable1.getModel();
       DefaultTableModel df=(DefaultTableModel) tm;
      df.setRowCount(0);
               ResultSet rs=DBMS.SE("select * from invoice_product where invoice_id in (select id from invoice where paid_amount like'%"+s+"%') ");

               while (rs.next()) {   
                   
                   Vector v=new Vector();
                   
                     ResultSet rs1=DBMS.SE("select * from invoice where id='"+rs.getString("invoice_id")+"'");
                     
                     while (rs1.next()) {                       
                       
                         v.add(rs1.getString("date"));
                         
                         
                         
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
                         v.add(rs1.getString("discount"));
                     v.add(rs1.getString("paid_amount"));
                      
                      
                      v.add(rs.getString("qty"));
                      String sr = rs.getString("qty");
                      
                       
                      
                      
                      
                      
                             
              ResultSet rs6 = DBMS.SE("select selling_price from product where id='" + rs.getString("product_id") + "'");
     
                             while (rs6.next()) {                                 
                                 v.add(rs6.getString("selling_price"));
                                 
                                 selling=rs6.getString("selling_price");
                             }
                             
                             
                             
                               
                             
                             ResultSet rsx = DBMS.SE("select buying_price from grn_product where product_id='" + rs.getString("product_id") + "'");
                                   
                                   while (rsx.next()) {                                 
                                 
                             cv=rsx.getString("buying_price");
                             v.add(rsx.getString("buying_price"));
                                        }
                                              
                         
                         
                         
                      
                      
                      
                     
                      
                      
                      
                      
               
                double b1 = Double.parseDouble(sr);
                double b2 = Double.parseDouble(selling);
                double total = b1 * b2;
                

                 String ts=String.valueOf(total);
                v.add(ts);

                
                
                

                
                  
                

                double b3 = Double.parseDouble(cv);

                double x1 = b1*b3;
                            
               double xxx=total-x1;
                
                
                String x=String.valueOf(xxx);

                v.add(x);
                      
                      
                      
                   
                
                
                
        
                
                
                   }
                   
                   df.addRow(v);
            }
                         
         try {
            
        
     
              

             
             
             
             int g=0;
                int cx= df.getRowCount();
               
                for (int j = 0; j < cx; j++) {
                    
                    String col1=(String) jTable1.getValueAt(j, 5);
                    int col2=Integer.parseInt(col1);
                    g=col2+g;
                }
                jLabel17.setText(g+"");
                
                
                
                
                    double g1=0.0;
                int cx1= df.getRowCount();
               
                for (int t = 0; t < cx1; t++) {
                    
                    String col3=  (String) jTable1.getValueAt(t, 8);
                    double co12=Double.parseDouble(col3);
                    g1=g1+co12;
                }
                jLabel13.setText(g1+"");
                
                
                 double g2=0.0;
                int cx2= df.getRowCount();
               
                for (int q = 0; q < cx2; q++) {
                    
                    String col3=  (String) jTable1.getValueAt(q, 9);
                       double co12=Double.parseDouble(col3);
                
               g2=g2+co12;
                
                
              jLabel1.setText(g2+"");
            
                }  } catch (Exception e2) {
        }
        
       
         } catch (Exception e) {
             System.out.println(e);
        }  
    }//GEN-LAST:event_jTextField3KeyReleased

    private void jTextField4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyReleased
 String s=jTextField4.getText();
        
        
        String selling="";
        String buy="";
        String cv="";
        
          try {
            
        
         TableModel tm=jTable1.getModel();
       DefaultTableModel df=(DefaultTableModel) tm;
      df.setRowCount(0);
               ResultSet rs=DBMS.SE("select * from invoice_product where product_id in (select id from product where brand_id in(select id from brand where name like '%"+s+"%')) ");

               while (rs.next()) {   
                   
                   Vector v=new Vector();
                   
                     ResultSet rs1=DBMS.SE("select * from invoice where id='"+rs.getString("invoice_id")+"'");
                     
                     while (rs1.next()) {                       
                       
                         v.add(rs1.getString("date"));
                         
                         
                         
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
                         v.add(rs1.getString("discount"));
                     v.add(rs1.getString("paid_amount"));
                      
                      
                      v.add(rs.getString("qty"));
                      String sr = rs.getString("qty");
                      
                       
                      
                      
                      
                      
                             
              ResultSet rs6 = DBMS.SE("select selling_price from product where id='" + rs.getString("product_id") + "'");
     
                             while (rs6.next()) {                                 
                                 v.add(rs6.getString("selling_price"));
                                 
                                 selling=rs6.getString("selling_price");
                             }
                             
                             
                             
                               
                             
                             ResultSet rsx = DBMS.SE("select buying_price from grn_product where product_id='" + rs.getString("product_id") + "'");
                                   
                                   while (rsx.next()) {                                 
                                 
                             cv=rsx.getString("buying_price");
                             v.add(rsx.getString("buying_price"));
                                        }
                                              
                         
                         
                         
                      
                      
                      
                     
                      
                      
                      
                      
               
                double b1 = Double.parseDouble(sr);
                double b2 = Double.parseDouble(selling);
                double total = b1 * b2;
                

                 String ts=String.valueOf(total);
                v.add(ts);

                
                
                

                
                  
                

                double b3 = Double.parseDouble(cv);

                double x1 = b1*b3;
                            
               double xxx=total-x1;
                
                
                String x=String.valueOf(xxx);

                v.add(x);
                      
                      
                      
                   
                
                
                
        
                
                
                   }
                   
                   df.addRow(v);
            }
                         
         try {
            
        
     
              

             
             
             
             int g=0;
                int cx= df.getRowCount();
               
                for (int j = 0; j < cx; j++) {
                    
                    String col1=(String) jTable1.getValueAt(j, 5);
                    int col2=Integer.parseInt(col1);
                    g=col2+g;
                }
                jLabel17.setText(g+"");
                
                
                
                
                    double g1=0.0;
                int cx1= df.getRowCount();
               
                for (int t = 0; t < cx1; t++) {
                    
                    String col3=  (String) jTable1.getValueAt(t, 8);
                    double co12=Double.parseDouble(col3);
                    g1=g1+co12;
                }
                jLabel13.setText(g1+"");
                
                
                 double g2=0.0;
                int cx2= df.getRowCount();
               
                for (int q = 0; q < cx2; q++) {
                    
                    String col3=  (String) jTable1.getValueAt(q, 9);
                       double co12=Double.parseDouble(col3);
                
               g2=g2+co12;
                
                
              jLabel1.setText(g2+"");
            
                }  } catch (Exception e2) {
        }
        
       
         } catch (Exception e) {
             System.out.println(e);
        }        
        
    }//GEN-LAST:event_jTextField4KeyReleased

    private void jTextField5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyReleased
 String s=jTextField5.getText();
        
        
        String selling="";
        String buy="";
        String cv="";
        
          try {
            
        
         TableModel tm=jTable1.getModel();
       DefaultTableModel df=(DefaultTableModel) tm;
      df.setRowCount(0);
               ResultSet rs=DBMS.SE("select * from invoice_product where product_id in (select id from product where name like'%"+s+"%') ");

               while (rs.next()) {   
                   
                   Vector v=new Vector();
                   
                     ResultSet rs1=DBMS.SE("select * from invoice where id='"+rs.getString("invoice_id")+"'");
                     
                     while (rs1.next()) {                       
                       
                         v.add(rs1.getString("date"));
                         
                         
                         
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
                         v.add(rs1.getString("discount"));
                     v.add(rs1.getString("paid_amount"));
                      
                      
                      v.add(rs.getString("qty"));
                      String sr = rs.getString("qty");
                      
                       
                      
                      
                      
                      
                             
              ResultSet rs6 = DBMS.SE("select selling_price from product where id='" + rs.getString("product_id") + "'");
     
                             while (rs6.next()) {                                 
                                 v.add(rs6.getString("selling_price"));
                                 
                                 selling=rs6.getString("selling_price");
                             }
                             
                             
                             
                               
                             
                             ResultSet rsx = DBMS.SE("select buying_price from grn_product where product_id='" + rs.getString("product_id") + "'");
                                   
                                   while (rsx.next()) {                                 
                                 
                             cv=rsx.getString("buying_price");
                             v.add(rsx.getString("buying_price"));
                                        }
                                              
                         
                         
                         
                      
                      
                      
                     
                      
                      
                      
                      
               
                double b1 = Double.parseDouble(sr);
                double b2 = Double.parseDouble(selling);
                double total = b1 * b2;
                

                 String ts=String.valueOf(total);
                v.add(ts);

                
                
                

                
                  
                

                double b3 = Double.parseDouble(cv);

                double x1 = b1*b3;
                            
               double xxx=total-x1;
                
                
                String x=String.valueOf(xxx);

                v.add(x);
                      
                      
                      
                   
                
                
                
        
                
                
                   }
                   
                   df.addRow(v);
            }
                         
         try {
            
        
     
              

             
             
             
             int g=0;
                int cx= df.getRowCount();
               
                for (int j = 0; j < cx; j++) {
                    
                    String col1=(String) jTable1.getValueAt(j, 5);
                    int col2=Integer.parseInt(col1);
                    g=col2+g;
                }
                jLabel17.setText(g+"");
                
                
                
                
                    double g1=0.0;
                int cx1= df.getRowCount();
               
                for (int t = 0; t < cx1; t++) {
                    
                    String col3=  (String) jTable1.getValueAt(t, 8);
                    double co12=Double.parseDouble(col3);
                    g1=g1+co12;
                }
                jLabel13.setText(g1+"");
                
                
                 double g2=0.0;
                int cx2= df.getRowCount();
               
                for (int q = 0; q < cx2; q++) {
                    
                    String col3=  (String) jTable1.getValueAt(q, 9);
                       double co12=Double.parseDouble(col3);
                
               g2=g2+co12;
                
                
              jLabel1.setText(g2+"");
            
                }  } catch (Exception e2) {
        }
        
       
         } catch (Exception e) {
             System.out.println(e);
        }    
    }//GEN-LAST:event_jTextField5KeyReleased

    private void jTextField7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyReleased
 String s=jTextField7.getText();
        
        
        String selling="";
        String buy="";
        String cv="";
        
          try {
            
        
         TableModel tm=jTable1.getModel();
       DefaultTableModel df=(DefaultTableModel) tm;
      df.setRowCount(0);
               ResultSet rs=DBMS.SE("select * from invoice_product where product_id in (select id from product where selling_price like'%"+s+"%') ");

               while (rs.next()) {   
                   
                   Vector v=new Vector();
                   
                     ResultSet rs1=DBMS.SE("select * from invoice where id='"+rs.getString("invoice_id")+"'");
                     
                     while (rs1.next()) {                       
                       
                         v.add(rs1.getString("date"));
                         
                         
                         
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
                         v.add(rs1.getString("discount"));
                     v.add(rs1.getString("paid_amount"));
                      
                      
                      v.add(rs.getString("qty"));
                      String sr = rs.getString("qty");
                      
                       
                      
                      
                      
                      
                             
              ResultSet rs6 = DBMS.SE("select selling_price from product where id='" + rs.getString("product_id") + "'");
     
                             while (rs6.next()) {                                 
                                 v.add(rs6.getString("selling_price"));
                                 
                                 selling=rs6.getString("selling_price");
                             }
                             
                             
                             
                               
                             
                             ResultSet rsx = DBMS.SE("select buying_price from grn_product where product_id='" + rs.getString("product_id") + "'");
                                   
                                   while (rsx.next()) {                                 
                                 
                             cv=rsx.getString("buying_price");
                             v.add(rsx.getString("buying_price"));
                                        }
                                              
                         
                         
                         
                      
                      
                      
                     
                      
                      
                      
                      
               
                double b1 = Double.parseDouble(sr);
                double b2 = Double.parseDouble(selling);
                double total = b1 * b2;
                

                 String ts=String.valueOf(total);
                v.add(ts);

                
                
                

                
                  
                

                double b3 = Double.parseDouble(cv);

                double x1 = b1*b3;
                            
               double xxx=total-x1;
                
                
                String x=String.valueOf(xxx);

                v.add(x);
                      
                      
                      
                   
                
                
                
        
                
                
                   }
                   
                   df.addRow(v);
            }
                         
         try {
            
        
     
              

             
             
             
             int g=0;
                int cx= df.getRowCount();
               
                for (int j = 0; j < cx; j++) {
                    
                    String col1=(String) jTable1.getValueAt(j, 5);
                    int col2=Integer.parseInt(col1);
                    g=col2+g;
                }
                jLabel17.setText(g+"");
                
                
                
                
                    double g1=0.0;
                int cx1= df.getRowCount();
               
                for (int t = 0; t < cx1; t++) {
                    
                    String col3=  (String) jTable1.getValueAt(t, 8);
                    double co12=Double.parseDouble(col3);
                    g1=g1+co12;
                }
                jLabel13.setText(g1+"");
                
                
                 double g2=0.0;
                int cx2= df.getRowCount();
               
                for (int q = 0; q < cx2; q++) {
                    
                    String col3=  (String) jTable1.getValueAt(q, 9);
                       double co12=Double.parseDouble(col3);
                
               g2=g2+co12;
                
                
              jLabel1.setText(g2+"");
            
                }  } catch (Exception e2) {
        }
        
       
         } catch (Exception e) {
             System.out.println(e);
        }  
             
          // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7KeyReleased

    private void jTextField9KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField9KeyReleased
 String s=jTextField9.getText();
        
        
        String selling="";
        String buy="";
        String cv="";
        
          try {
            
        
         TableModel tm=jTable1.getModel();
       DefaultTableModel df=(DefaultTableModel) tm;
      df.setRowCount(0);
               ResultSet rs=DBMS.SE("select * from invoice_product where qty like'%"+s+"%' ");

               while (rs.next()) {   
                   
                   Vector v=new Vector();
                   
                     ResultSet rs1=DBMS.SE("select * from invoice where id='"+rs.getString("invoice_id")+"'");
                     
                     while (rs1.next()) {                       
                       
                         v.add(rs1.getString("date"));
                         
                         
                         
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
                         v.add(rs1.getString("discount"));
                     v.add(rs1.getString("paid_amount"));
                      
                      
                      v.add(rs.getString("qty"));
                      String sr = rs.getString("qty");
                      
                       
                      
                      
                      
                      
                             
              ResultSet rs6 = DBMS.SE("select selling_price from product where id='" + rs.getString("product_id") + "'");
     
                             while (rs6.next()) {                                 
                                 v.add(rs6.getString("selling_price"));
                                 
                                 selling=rs6.getString("selling_price");
                             }
                             
                             
                             
                               
                             
                             ResultSet rsx = DBMS.SE("select buying_price from grn_product where product_id='" + rs.getString("product_id") + "'");
                                   
                                   while (rsx.next()) {                                 
                                 
                             cv=rsx.getString("buying_price");
                             v.add(rsx.getString("buying_price"));
                                        }
                                              
                         
                         
                         
                      
                      
                      
                     
                      
                      
                      
                      
               
                double b1 = Double.parseDouble(sr);
                double b2 = Double.parseDouble(selling);
                double total = b1 * b2;
                

                 String ts=String.valueOf(total);
                v.add(ts);

                
                
                

                
                  
                

                double b3 = Double.parseDouble(cv);

                double x1 = b1*b3;
                            
               double xxx=total-x1;
                
                
                String x=String.valueOf(xxx);

                v.add(x);
                      
                      
                      
                   
                
                
                
        
                
                
                   }
                   
                   df.addRow(v);
            }
                         
         try {
            
        
     
              

             
             
             
             int g=0;
                int cx= df.getRowCount();
               
                for (int j = 0; j < cx; j++) {
                    
                    String col1=(String) jTable1.getValueAt(j, 5);
                    int col2=Integer.parseInt(col1);
                    g=col2+g;
                }
                jLabel17.setText(g+"");
                
                
                
                
                    double g1=0.0;
                int cx1= df.getRowCount();
               
                for (int t = 0; t < cx1; t++) {
                    
                    String col3=  (String) jTable1.getValueAt(t, 8);
                    double co12=Double.parseDouble(col3);
                    g1=g1+co12;
                }
                jLabel13.setText(g1+"");
                
                
                 double g2=0.0;
                int cx2= df.getRowCount();
               
                for (int q = 0; q < cx2; q++) {
                    
                    String col3=  (String) jTable1.getValueAt(q, 9);
                       double co12=Double.parseDouble(col3);
                
               g2=g2+co12;
                
                
              jLabel1.setText(g2+"");
            
                }  } catch (Exception e2) {
        }
        
       
         } catch (Exception e) {
             System.out.println(e);
        }   
          // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9KeyReleased

    private void jTextField11KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField11KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11KeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

       String s=jTextField1.getText();
       String s1=jTextField11.getText();
        
        
        String selling="";
        String buy="";
        String cv="";
        
          try {
            
        
         TableModel tm=jTable1.getModel();
       DefaultTableModel df=(DefaultTableModel) tm;
      df.setRowCount(0);
               ResultSet rs=DBMS.SE("select * from invoice_product where invoice_id in (select id from invoice where date between '"+s+"'and '"+s1+"') ");

               while (rs.next()) {   
                   
                   Vector v=new Vector();
                   
                     ResultSet rs1=DBMS.SE("select * from invoice where id='"+rs.getString("invoice_id")+"'");
                     
                     while (rs1.next()) {                       
                       
                         v.add(rs1.getString("date"));
                         
                         
                         
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
                         v.add(rs1.getString("discount"));
                     v.add(rs1.getString("paid_amount"));
                      
                      
                      v.add(rs.getString("qty"));
                      String sr = rs.getString("qty");
                      
                       
                      
                      
                      
                      
                             
              ResultSet rs6 = DBMS.SE("select selling_price from product where id='" + rs.getString("product_id") + "'");
     
                             while (rs6.next()) {                                 
                                 v.add(rs6.getString("selling_price"));
                                 
                                 selling=rs6.getString("selling_price");
                             }
                             
                             
                             
                               
                             
                             ResultSet rsx = DBMS.SE("select buying_price from grn_product where product_id='" + rs.getString("product_id") + "'");
                                   
                                   while (rsx.next()) {                                 
                                 
                             cv=rsx.getString("buying_price");
                             v.add(rsx.getString("buying_price"));
                                        }
                                              
                         
                         
                         
                      
                      
                      
                     
                      
                      
                      
                      
               
                double b1 = Double.parseDouble(sr);
                double b2 = Double.parseDouble(selling);
                double total = b1 * b2;
                

                 String ts=String.valueOf(total);
                v.add(ts);

                
                
                

                
                  
                

                double b3 = Double.parseDouble(cv);

                double x1 = b1*b3;
                            
               double xxx=total-x1;
                
                
                String x=String.valueOf(xxx);

                v.add(x);
                      
                      
                      
                   
                
                
                
        
                
                
                   }
                   
                   df.addRow(v);
            }
                         
         try {
            
        
     
              

             
             
             
             int g=0;
                int cx= df.getRowCount();
               
                for (int j = 0; j < cx; j++) {
                    
                    String col1=(String) jTable1.getValueAt(j, 5);
                    int col2=Integer.parseInt(col1);
                    g=col2+g;
                }
                jLabel17.setText(g+"");
                
                
                
                
                    double g1=0.0;
                int cx1= df.getRowCount();
               
                for (int t = 0; t < cx1; t++) {
                    
                    String col3=  (String) jTable1.getValueAt(t, 8);
                    double co12=Double.parseDouble(col3);
                    g1=g1+co12;
                }
                jLabel13.setText(g1+"");
                
                
                 double g2=0.0;
                int cx2= df.getRowCount();
               
                for (int q = 0; q < cx2; q++) {
                    
                    String col3=  (String) jTable1.getValueAt(q, 9);
                       double co12=Double.parseDouble(col3);
                
               g2=g2+co12;
                
                
              jLabel1.setText(g2+"");
            
                }  } catch (Exception e2) {
        }
        
       
         } catch (Exception e) {
             System.out.println(e);
        }  
        
        

        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

                    TableModel tm=jTable1.getModel();

        
        
        reporti i=new reporti(tm,jLabel17,jLabel13,jLabel1);
            i.setVisible(true); 
                  
        
        

     
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
      view v=new view();
        v.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel8MouseClicked

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
            java.util.logging.Logger.getLogger(invoice_recored.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(invoice_recored.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(invoice_recored.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(invoice_recored.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new invoice_recored().setVisible(true);
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables



       

   

}
