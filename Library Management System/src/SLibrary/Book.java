/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package SLibrary;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author samee
 */
public class Book extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Book.class.getName());

    /**
     * Creates new form Category
     */
    public Book() {
        initComponents();
        Connect();
        Category();
        Author();
        Publisher();
        BookLoad();
    }
     
    public class CategoryItem
    {
        int id;
        String name;
    
        public CategoryItem(int id,String name)
        {
            this.id = id;
            this.name = name;
        }
        
        
        public String toString()
        {
            return name;
        }
        
    }
    
      public class AuthorItem
    {
        int id;
        String name;
    
        public AuthorItem(int id,String name)
        {
            this.id = id;
            this.name = name;
        }
        
        
        public String toString()
        {
            return name;
        }
        
    }
      
       public class PublisherItem
    {
        int id;
        String name;
    
        public PublisherItem(int id,String name)
        {
            this.id = id;
            this.name = name;
        }
        
        
        public String toString()
        {
            return name;
        }
        
    }
    
    Connection con;
    PreparedStatement pat;
    ResultSet rs;
    
    
  public void Connect() {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/SLibrary", 
            "root", 
            "Sheetal@123"
        );
        
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
         Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
    }
}

  public void Category()
  {
      try{
      pat = con.prepareStatement("select * from category");
      rs = pat.executeQuery();
      txtcategory.removeAllItems();
      
      while(rs.next())
      {
          txtcategory.addItem(new CategoryItem(rs.getInt(1),rs.getString(2)));
      }
       }catch(SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
              }
  
  }
  
    public void Author()
  {
      try{
      pat = con.prepareStatement("select * from author");
      rs = pat.executeQuery();
      txtauthor.removeAllItems();
      
      while(rs.next())
      {
          txtauthor.addItem(new AuthorItem(rs.getInt(1),rs.getString(2)));
      }
       }catch(SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
              }
  
  }
  
    
   public void Publisher()
  {
      try{
      pat = con.prepareStatement("select * from publisher");
      rs = pat.executeQuery();
      txtpublisher.removeAllItems();
      
      while(rs.next())
      {
          txtpublisher.addItem(new PublisherItem(rs.getInt(1),rs.getString(2)));
      }
       }catch(SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
              }
  
  }
        
  public void BookLoad()
  {
      int c;
      try{
      pat = con.prepareStatement("select b.id, b.bname, c.catname, a.name, p.name, b.contents, b.pages, b.edition from book b JOIN category c On b.category = c.id JOIN author a On b.author = a.id JOIN publisher p On b.publisher = p.id");
      rs = pat.executeQuery();
      
      ResultSetMetaData rsd = rs.getMetaData();
      c = rsd.getColumnCount();
      
      DefaultTableModel d = (DefaultTableModel)jTable1.getModel();
      d.setRowCount(0);
      
      while(rs.next())
      {
          Vector v2 = new Vector();
          
          
              v2.add(rs.getString("b.id"));
              v2.add(rs.getString("b.bname"));
              v2.add(rs.getString("c.catname"));
              v2.add(rs.getString("a.name"));
              v2.add(rs.getString("p.name"));
              v2.add(rs.getString("b.contents"));
              v2.add(rs.getString("b.pages"));
              v2.add(rs.getString("b.edition"));
         
              d.addRow(v2);
          
      }
      }catch(SQLException ex){
          Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollBar1 = new javax.swing.JScrollBar();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txtcontents = new javax.swing.JTextField();
        txtcategory = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtauthor = new javax.swing.JComboBox();
        txtpublisher = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtpages = new javax.swing.JTextField();
        txtedition = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(55, 53, 62));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(246, 241, 233), 2), "Book", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24), new java.awt.Color(246, 241, 233))); // NOI18N
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(246, 241, 233));
        jLabel1.setText("Name");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(246, 241, 233));
        jLabel3.setText("Category");

        txtname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnameActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(161, 150, 134));
        jButton1.setForeground(new java.awt.Color(51, 51, 51));
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(161, 150, 134));
        jButton2.setForeground(new java.awt.Color(51, 51, 51));
        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(161, 150, 134));
        jButton3.setForeground(new java.awt.Color(51, 51, 51));
        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(161, 150, 134));
        jButton4.setForeground(new java.awt.Color(51, 51, 51));
        jButton4.setText("Cancel");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Book Name", "Category", "Author", "Publisher", "Contents", "No. of Pages", "Edition"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(246, 241, 233));
        jLabel4.setText("Contents");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(246, 241, 233));
        jLabel5.setText("Author");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(246, 241, 233));
        jLabel6.setText("Publisher");

        txtpublisher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpublisherActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(246, 241, 233));
        jLabel7.setText("No. of Pages");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(246, 241, 233));
        jLabel8.setText("Edition");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1))))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(txtname)
                            .addComponent(txtcategory, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtauthor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtpublisher, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtcontents)
                            .addComponent(txtpages)
                            .addComponent(txtedition)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtauthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtpublisher, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(27, 27, 27)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcontents, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtpages, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtedition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 10, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
       String bname = txtname.getText();
        CategoryItem citem = (CategoryItem) txtcategory.getSelectedItem();
        AuthorItem aitem = (AuthorItem) txtauthor.getSelectedItem();
        PublisherItem pitem = (PublisherItem) txtpublisher.getSelectedItem();
       
        String contents = txtcontents.getText();
        String pages = txtpages.getText();
        String edition = txtedition.getText();
        try
        {
        pat = con.prepareStatement("insert into book(bname,category,author,publisher,contents,pages,edition)values(?,?,?,?,?,?,?)");
        pat.setString(1,bname);
        pat.setInt(2,citem.id);
        pat.setInt(3,aitem.id);
        pat.setInt(4,pitem.id);
        pat.setString(5,contents);
        pat.setString(6,pages);
        pat.setString(7,edition);
        
        
        int k = pat.executeUpdate();
        
        if(k==1)
        {
            JOptionPane.showMessageDialog(this, "Book Added");
            
            BookLoad();
             txtname.setText("");
             txtcategory.setSelectedIndex(-1);
             txtauthor.setSelectedIndex(-1);
             txtpublisher.setSelectedIndex(-1);
             txtcontents.setText("");
             txtpages.setText("");
             txtedition.setText("");
             
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Error");
        }
        }catch(SQLException ex)
        {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        
   DefaultTableModel d1 = (DefaultTableModel) jTable1.getModel();
int selectIndex = jTable1.getSelectedRow();

txtname.setText(d1.getValueAt(selectIndex, 1).toString());
txtcontents.setText(d1.getValueAt(selectIndex, 5).toString());
txtpages.setText(d1.getValueAt(selectIndex, 6).toString());
txtedition.setText(d1.getValueAt(selectIndex, 7).toString());

// For combos: find matching item and select
String catName = d1.getValueAt(selectIndex, 2).toString();
for (int i=0; i<txtcategory.getItemCount(); i++) {
    if (txtcategory.getItemAt(i).toString().equals(catName)) {
        txtcategory.setSelectedIndex(i);
        break;
    }
}

String authorName = d1.getValueAt(selectIndex, 3).toString();
for (int i = 0; i < txtauthor.getItemCount(); i++) {
    if (txtauthor.getItemAt(i).toString().equals(authorName)) {
        txtauthor.setSelectedIndex(i);
        break;
    }
}

// Publisher
String publisherName = d1.getValueAt(selectIndex, 4).toString();
for (int i = 0; i < txtpublisher.getItemCount(); i++) {
    if (txtpublisher.getItemAt(i).toString().equals(publisherName)) {
        txtpublisher.setSelectedIndex(i);
        break;
    }//GEN-LAST:event_jTable1MouseClicked
}
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
DefaultTableModel d1 = (DefaultTableModel) jTable1.getModel();
int selectIndex = jTable1.getSelectedRow();

if (selectIndex == -1) {
    JOptionPane.showMessageDialog(this, "Please select a book from the table first.");
    return; // exit the update function
}

int id = Integer.parseInt(d1.getValueAt(selectIndex, 0).toString());
String bname = txtname.getText();
CategoryItem citem = (CategoryItem) txtcategory.getSelectedItem();
AuthorItem aitem = (AuthorItem) txtauthor.getSelectedItem();
PublisherItem pitem = (PublisherItem) txtpublisher.getSelectedItem();
String contents = txtcontents.getText();
String pages = txtpages.getText();
String edition = txtedition.getText();

try {
    pat = con.prepareStatement("update book set bname=?, category=?, author=?, publisher=?, contents=?, pages=?, edition=? where id=?");
    pat.setString(1, bname);
    pat.setInt(2, citem.id);
    pat.setInt(3, aitem.id);
    pat.setInt(4, pitem.id);
    pat.setString(5, contents);
    pat.setString(6, pages);
    pat.setString(7, edition);
    pat.setInt(8, id);

    int k = pat.executeUpdate();
    if (k == 1) {
        JOptionPane.showMessageDialog(this, "Book Updated");
        BookLoad();
    }
} catch (SQLException ex) {
    Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
   } 
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
       DefaultTableModel d1 = (DefaultTableModel) jTable1.getModel();
int selectIndex = jTable1.getSelectedRow();

if (selectIndex == -1) {
    JOptionPane.showMessageDialog(this, "Please select a book to delete.");
    return;
}

int id = Integer.parseInt(d1.getValueAt(selectIndex, 0).toString());

int dialogResult = JOptionPane.showConfirmDialog(this, "Do you want to delete the record?", "Warning", JOptionPane.YES_NO_OPTION);

if (dialogResult == JOptionPane.YES_OPTION) {
    try {
        pat = con.prepareStatement("delete from book where id=?");
        pat.setInt(1, id);
        int k = pat.executeUpdate();
        if (k == 1) {
            JOptionPane.showMessageDialog(this, "Book Deleted");
            BookLoad();
        }
    } catch (SQLException ex) {
        Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
    }
}

   
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseClicked

    private void txtpublisherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpublisherActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpublisherActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Book().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox txtauthor;
    private javax.swing.JComboBox txtcategory;
    private javax.swing.JTextField txtcontents;
    private javax.swing.JTextField txtedition;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtpages;
    private javax.swing.JComboBox txtpublisher;
    // End of variables declaration//GEN-END:variables
}
