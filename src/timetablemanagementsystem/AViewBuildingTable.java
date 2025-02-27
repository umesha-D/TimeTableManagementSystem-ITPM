/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetablemanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author ashan
 */
public class AViewBuildingTable extends javax.swing.JFrame {

    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStmt;
    
    /**
     * Creates new form AViewBuildingTable
     */
    public AViewBuildingTable() {
        initComponents();
        dbconnect();
        show_buildingDetails();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    
    private void dbconnect(){
        final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
        final String JDBC_URL = "jdbc:derby:C:/Derby/TTMS;create=true";
        
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(JDBC_URL);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AAddBuildings.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AAddBuildings.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }  
        
    }
    
    
    public ArrayList<ABuildingModel> buildingList() {
        
        ArrayList<ABuildingModel> buildingList = new ArrayList<>();
        try {
            String query = "SELECT * FROM BUILDINGS";
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            
            ABuildingModel abuildingmodel ;
            
            while(rs.next()){
                abuildingmodel = new ABuildingModel ( rs.getString("building_no"), rs.getString("building_name"), rs.getInt("noOf_rooms"));
                buildingList.add(abuildingmodel);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex + "Exception occured in BuildingList method");
            Logger.getLogger(AAddBuildings.class.getName()).log(Level.SEVERE, null, ex);         
        }
        return buildingList;
    }
    
    public void show_buildingDetails(){
        ArrayList<ABuildingModel> buildingList = buildingList();
        DefaultTableModel tableModel = (DefaultTableModel) onlyBuildings_table.getModel();
        
        Object[] row = new Object[3];
        for (int i = 0; i < buildingList.size(); i++) {
            row[0] = buildingList.get(i).getBuildingNumber();
            row[1] = buildingList.get(i).getBuildingName();
            row[2] = buildingList.get(i).getNoOfRooms();
            
            tableModel.addRow(row);
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

        Background_pnl = new javax.swing.JPanel();
        viewBuildingsTable_TopBar = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        onlyBuildings_table = new javax.swing.JTable();
        searchTextFieldBuildingsTable = new javax.swing.JTextField();
        btn_searchviewBuildingsTable = new javax.swing.JButton();
        btn_refreshviewBuildingsTable = new javax.swing.JButton();
<<<<<<< HEAD
        viewBuildingTable_backBtn = new javax.swing.JButton();
=======
        viewBuildingTable_exitBtn = new javax.swing.JButton();
>>>>>>> a2a2f3591b0f88043da8f9fcb36d4459fc4388a5

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Background_pnl.setBackground(new java.awt.Color(247, 247, 247));

        viewBuildingsTable_TopBar.setBackground(new java.awt.Color(20, 181, 117));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("BUILDINGS TABLE");

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/clear btn.png"))); // NOI18N
        jButton3.setText("LOGOUT");
<<<<<<< HEAD
=======
        jButton3.setToolTipText("If you click this this you can sign out from the system");
>>>>>>> a2a2f3591b0f88043da8f9fcb36d4459fc4388a5
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/clear btn hover.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout viewBuildingsTable_TopBarLayout = new javax.swing.GroupLayout(viewBuildingsTable_TopBar);
        viewBuildingsTable_TopBar.setLayout(viewBuildingsTable_TopBarLayout);
        viewBuildingsTable_TopBarLayout.setHorizontalGroup(
            viewBuildingsTable_TopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewBuildingsTable_TopBarLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        viewBuildingsTable_TopBarLayout.setVerticalGroup(
            viewBuildingsTable_TopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewBuildingsTable_TopBarLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(viewBuildingsTable_TopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        onlyBuildings_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Building Number", "Building Name", "Number Of Rooms"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(onlyBuildings_table);
        if (onlyBuildings_table.getColumnModel().getColumnCount() > 0) {
            onlyBuildings_table.getColumnModel().getColumn(0).setResizable(false);
            onlyBuildings_table.getColumnModel().getColumn(1).setResizable(false);
            onlyBuildings_table.getColumnModel().getColumn(2).setResizable(false);
        }

        searchTextFieldBuildingsTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        searchTextFieldBuildingsTable.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        searchTextFieldBuildingsTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTextFieldBuildingsTableKeyReleased(evt);
            }
        });

        btn_searchviewBuildingsTable.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        btn_searchviewBuildingsTable.setForeground(new java.awt.Color(255, 255, 255));
        btn_searchviewBuildingsTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/add btn.png"))); // NOI18N
        btn_searchviewBuildingsTable.setText("Search");
<<<<<<< HEAD
=======
        btn_searchviewBuildingsTable.setToolTipText("If you click this you can search Buildngs");
>>>>>>> a2a2f3591b0f88043da8f9fcb36d4459fc4388a5
        btn_searchviewBuildingsTable.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_searchviewBuildingsTable.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/add btn hover.png"))); // NOI18N
        btn_searchviewBuildingsTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchviewBuildingsTableActionPerformed(evt);
            }
        });
        btn_searchviewBuildingsTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btn_searchviewBuildingsTableKeyReleased(evt);
            }
        });

        btn_refreshviewBuildingsTable.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        btn_refreshviewBuildingsTable.setForeground(new java.awt.Color(255, 255, 255));
        btn_refreshviewBuildingsTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/add btn.png"))); // NOI18N
        btn_refreshviewBuildingsTable.setText("Refresh");
<<<<<<< HEAD
=======
        btn_refreshviewBuildingsTable.setToolTipText("If you click this you can refresh the table");
>>>>>>> a2a2f3591b0f88043da8f9fcb36d4459fc4388a5
        btn_refreshviewBuildingsTable.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_refreshviewBuildingsTable.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/add btn hover.png"))); // NOI18N
        btn_refreshviewBuildingsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_refreshviewBuildingsTableMouseClicked(evt);
            }
        });
        btn_refreshviewBuildingsTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refreshviewBuildingsTableActionPerformed(evt);
            }
        });

<<<<<<< HEAD
        viewBuildingTable_backBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        viewBuildingTable_backBtn.setForeground(new java.awt.Color(255, 255, 255));
        viewBuildingTable_backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/clear btn.png"))); // NOI18N
        viewBuildingTable_backBtn.setText("BACK");
        viewBuildingTable_backBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        viewBuildingTable_backBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/clear btn hover.png"))); // NOI18N
        viewBuildingTable_backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewBuildingTable_backBtnActionPerformed(evt);
=======
        viewBuildingTable_exitBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        viewBuildingTable_exitBtn.setForeground(new java.awt.Color(255, 255, 255));
        viewBuildingTable_exitBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/clear btn.png"))); // NOI18N
        viewBuildingTable_exitBtn.setText("Exit");
        viewBuildingTable_exitBtn.setToolTipText("If You click this you can close this window only");
        viewBuildingTable_exitBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        viewBuildingTable_exitBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/clear btn hover.png"))); // NOI18N
        viewBuildingTable_exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewBuildingTable_exitBtnActionPerformed(evt);
>>>>>>> a2a2f3591b0f88043da8f9fcb36d4459fc4388a5
            }
        });

        javax.swing.GroupLayout Background_pnlLayout = new javax.swing.GroupLayout(Background_pnl);
        Background_pnl.setLayout(Background_pnlLayout);
        Background_pnlLayout.setHorizontalGroup(
            Background_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(viewBuildingsTable_TopBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Background_pnlLayout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addGroup(Background_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
<<<<<<< HEAD
                    .addComponent(viewBuildingTable_backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
=======
                    .addComponent(viewBuildingTable_exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
>>>>>>> a2a2f3591b0f88043da8f9fcb36d4459fc4388a5
                    .addGroup(Background_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(Background_pnlLayout.createSequentialGroup()
                            .addComponent(searchTextFieldBuildingsTable, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btn_searchviewBuildingsTable, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(btn_refreshviewBuildingsTable, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38))
        );
        Background_pnlLayout.setVerticalGroup(
            Background_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Background_pnlLayout.createSequentialGroup()
                .addComponent(viewBuildingsTable_TopBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(Background_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(Background_pnlLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(searchTextFieldBuildingsTable, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_searchviewBuildingsTable, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btn_refreshviewBuildingsTable, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
<<<<<<< HEAD
                .addComponent(viewBuildingTable_backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
=======
                .addComponent(viewBuildingTable_exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
>>>>>>> a2a2f3591b0f88043da8f9fcb36d4459fc4388a5
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background_pnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background_pnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void searchTextFieldBuildingsTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextFieldBuildingsTableKeyReleased
        // TODO add your handling code here:
        DefaultTableModel table = (DefaultTableModel)onlyBuildings_table.getModel();
        String search = searchTextFieldBuildingsTable.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
        onlyBuildings_table.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));          
    }//GEN-LAST:event_searchTextFieldBuildingsTableKeyReleased

    private void btn_searchviewBuildingsTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchviewBuildingsTableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_searchviewBuildingsTableActionPerformed

    private void btn_refreshviewBuildingsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_refreshviewBuildingsTableMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) onlyBuildings_table.getModel();
        model.setRowCount(0);
        show_buildingDetails();      
    }//GEN-LAST:event_btn_refreshviewBuildingsTableMouseClicked

    private void btn_refreshviewBuildingsTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshviewBuildingsTableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_refreshviewBuildingsTableActionPerformed

    private void btn_searchviewBuildingsTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_searchviewBuildingsTableKeyReleased
        // TODO add your handling code here:      
    }//GEN-LAST:event_btn_searchviewBuildingsTableKeyReleased

<<<<<<< HEAD
    private void viewBuildingTable_backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewBuildingTable_backBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_viewBuildingTable_backBtnActionPerformed
=======
    private void viewBuildingTable_exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewBuildingTable_exitBtnActionPerformed
        // TODO add your handling code here:
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_viewBuildingTable_exitBtnActionPerformed
>>>>>>> a2a2f3591b0f88043da8f9fcb36d4459fc4388a5

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
            java.util.logging.Logger.getLogger(AViewBuildingTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AViewBuildingTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AViewBuildingTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AViewBuildingTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AViewBuildingTable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background_pnl;
    private javax.swing.JButton btn_refreshviewBuildingsTable;
    private javax.swing.JButton btn_searchviewBuildingsTable;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable onlyBuildings_table;
    private javax.swing.JTextField searchTextFieldBuildingsTable;
<<<<<<< HEAD
    private javax.swing.JButton viewBuildingTable_backBtn;
=======
    private javax.swing.JButton viewBuildingTable_exitBtn;
>>>>>>> a2a2f3591b0f88043da8f9fcb36d4459fc4388a5
    private javax.swing.JPanel viewBuildingsTable_TopBar;
    // End of variables declaration//GEN-END:variables
}
