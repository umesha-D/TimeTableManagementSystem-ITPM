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
public class AViewSessionRoomTable extends javax.swing.JFrame {
    
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStmt; 

    /**
     * Creates new form AViewSessionRoomTable
     */
    public AViewSessionRoomTable() {
        initComponents();
        dbconnect();
        show_SessionRoomDetails();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public ArrayList<ARoomSessionModel> roomSessionList() {
        
        ArrayList<ARoomSessionModel> roomSessionList = new ArrayList<>();
        try {
            String query = "SELECT * FROM sessionrooms";
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            
            ARoomSessionModel sessionroommodel ;

            while(rs.next()){
                sessionroommodel = new ARoomSessionModel (rs.getInt("sessionroom_id"), rs.getString("session_name"), rs.getString("lecture_1"), rs.getString("lecture_2"), rs.getString("lecture_3"), rs.getString("subject_code"), rs.getString("subject_name"), rs.getString("group_id"), rs.getString("tag"), rs.getString("buildings"), rs.getString("rooms"));
                roomSessionList.add(sessionroommodel);            
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex + "Exception occured in RoomList method");
            Logger.getLogger(AAddBuildings.class.getName()).log(Level.SEVERE, null, ex);         
        }
        return roomSessionList;            
    }
    
    public void show_SessionRoomDetails(){
        
        ArrayList<ARoomSessionModel> roomSessionList = roomSessionList();
        DefaultTableModel tableModel = (DefaultTableModel) onlySessionRooms_table.getModel();
        
        Object[] row = new Object[12];
        for (int i = 0; i < roomSessionList.size(); i++) {
            
            row[0] = roomSessionList.get(i).getId();
            row[1] = roomSessionList.get(i).getSession_name();
            row[2] = roomSessionList.get(i).getLecture_one();
            row[3] = roomSessionList.get(i).getLecture_two();
            row[4] = roomSessionList.get(i).getLecture_three();
            row[5] = roomSessionList.get(i).getSubject_code();
            row[6] = roomSessionList.get(i).getSubject_name();
            row[7] = roomSessionList.get(i).getGroup_id();
            row[8] = roomSessionList.get(i).getSeesion_tag();
            row[9] = roomSessionList.get(i).getSessionBuilding();
            row[10] = roomSessionList.get(i).getSessionRoom();
            
            tableModel.addRow(row);                       
        } 
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
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        viewSessionRoomsTable_TopBar = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        searchTextFieldSessionRoomsTable = new javax.swing.JTextField();
        btn_searchviewSessionRoomsTable = new javax.swing.JButton();
        btn_refreshviewSessionRoomsTable = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        onlySessionRooms_table = new javax.swing.JTable();
        viewSessionRoomsTable_exitBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(247, 247, 247));

        viewSessionRoomsTable_TopBar.setBackground(new java.awt.Color(20, 181, 117));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("SESSION ROOMS TABLE");

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/clear btn.png"))); // NOI18N
        jButton3.setText("LOGOUT");
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/clear btn hover.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout viewSessionRoomsTable_TopBarLayout = new javax.swing.GroupLayout(viewSessionRoomsTable_TopBar);
        viewSessionRoomsTable_TopBar.setLayout(viewSessionRoomsTable_TopBarLayout);
        viewSessionRoomsTable_TopBarLayout.setHorizontalGroup(
            viewSessionRoomsTable_TopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewSessionRoomsTable_TopBarLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        viewSessionRoomsTable_TopBarLayout.setVerticalGroup(
            viewSessionRoomsTable_TopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewSessionRoomsTable_TopBarLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(viewSessionRoomsTable_TopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        searchTextFieldSessionRoomsTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        searchTextFieldSessionRoomsTable.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        searchTextFieldSessionRoomsTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTextFieldSessionRoomsTableKeyReleased(evt);
            }
        });

        btn_searchviewSessionRoomsTable.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        btn_searchviewSessionRoomsTable.setForeground(new java.awt.Color(255, 255, 255));
        btn_searchviewSessionRoomsTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/add btn.png"))); // NOI18N
        btn_searchviewSessionRoomsTable.setText("Search");
        btn_searchviewSessionRoomsTable.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_searchviewSessionRoomsTable.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/add btn hover.png"))); // NOI18N
        btn_searchviewSessionRoomsTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchviewSessionRoomsTableActionPerformed(evt);
            }
        });

        btn_refreshviewSessionRoomsTable.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        btn_refreshviewSessionRoomsTable.setForeground(new java.awt.Color(255, 255, 255));
        btn_refreshviewSessionRoomsTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/add btn.png"))); // NOI18N
        btn_refreshviewSessionRoomsTable.setText("Refresh");
        btn_refreshviewSessionRoomsTable.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_refreshviewSessionRoomsTable.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/add btn hover.png"))); // NOI18N
        btn_refreshviewSessionRoomsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_refreshviewSessionRoomsTableMouseClicked(evt);
            }
        });
        btn_refreshviewSessionRoomsTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refreshviewSessionRoomsTableActionPerformed(evt);
            }
        });

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        onlySessionRooms_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Session Name", "Lecturer 1", "Lecturer 2", "Lecturer 3", "Subject Code", "Subject Name", "Group ID", "Tag", "Building", "Room"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        onlySessionRooms_table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        onlySessionRooms_table.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(onlySessionRooms_table);
        if (onlySessionRooms_table.getColumnModel().getColumnCount() > 0) {
            onlySessionRooms_table.getColumnModel().getColumn(1).setMinWidth(100);
            onlySessionRooms_table.getColumnModel().getColumn(1).setPreferredWidth(100);
            onlySessionRooms_table.getColumnModel().getColumn(2).setMinWidth(100);
            onlySessionRooms_table.getColumnModel().getColumn(2).setPreferredWidth(100);
            onlySessionRooms_table.getColumnModel().getColumn(3).setMinWidth(100);
            onlySessionRooms_table.getColumnModel().getColumn(3).setPreferredWidth(100);
            onlySessionRooms_table.getColumnModel().getColumn(4).setMinWidth(100);
            onlySessionRooms_table.getColumnModel().getColumn(4).setPreferredWidth(100);
            onlySessionRooms_table.getColumnModel().getColumn(5).setMinWidth(100);
            onlySessionRooms_table.getColumnModel().getColumn(5).setPreferredWidth(100);
            onlySessionRooms_table.getColumnModel().getColumn(6).setMinWidth(100);
            onlySessionRooms_table.getColumnModel().getColumn(6).setPreferredWidth(100);
            onlySessionRooms_table.getColumnModel().getColumn(7).setMinWidth(100);
            onlySessionRooms_table.getColumnModel().getColumn(7).setPreferredWidth(100);
            onlySessionRooms_table.getColumnModel().getColumn(8).setMinWidth(100);
            onlySessionRooms_table.getColumnModel().getColumn(8).setPreferredWidth(100);
            onlySessionRooms_table.getColumnModel().getColumn(9).setMinWidth(100);
            onlySessionRooms_table.getColumnModel().getColumn(9).setPreferredWidth(100);
            onlySessionRooms_table.getColumnModel().getColumn(10).setMinWidth(100);
            onlySessionRooms_table.getColumnModel().getColumn(10).setPreferredWidth(100);
        }

        viewSessionRoomsTable_exitBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        viewSessionRoomsTable_exitBtn.setForeground(new java.awt.Color(255, 255, 255));
        viewSessionRoomsTable_exitBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/clear btn.png"))); // NOI18N
        viewSessionRoomsTable_exitBtn.setText("Exit");
        viewSessionRoomsTable_exitBtn.setToolTipText("If You click this you can close this window only");
        viewSessionRoomsTable_exitBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        viewSessionRoomsTable_exitBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/clear btn hover.png"))); // NOI18N
        viewSessionRoomsTable_exitBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewSessionRoomsTable_exitBtnMouseClicked(evt);
            }
        });
        viewSessionRoomsTable_exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewSessionRoomsTable_exitBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(viewSessionRoomsTable_TopBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(searchTextFieldSessionRoomsTable, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_searchviewSessionRoomsTable, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_refreshviewSessionRoomsTable, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(viewSessionRoomsTable_exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(viewSessionRoomsTable_TopBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_searchviewSessionRoomsTable, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_refreshviewSessionRoomsTable, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchTextFieldSessionRoomsTable, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(viewSessionRoomsTable_exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void searchTextFieldSessionRoomsTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextFieldSessionRoomsTableKeyReleased
        // TODO add your handling code here:
        DefaultTableModel table = (DefaultTableModel)onlySessionRooms_table.getModel();
        String search = searchTextFieldSessionRoomsTable.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
        onlySessionRooms_table.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_searchTextFieldSessionRoomsTableKeyReleased

    private void btn_searchviewSessionRoomsTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchviewSessionRoomsTableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_searchviewSessionRoomsTableActionPerformed

    private void btn_refreshviewSessionRoomsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_refreshviewSessionRoomsTableMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) onlySessionRooms_table.getModel();
        model.setRowCount(0);
        show_SessionRoomDetails();
    }//GEN-LAST:event_btn_refreshviewSessionRoomsTableMouseClicked

    private void btn_refreshviewSessionRoomsTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshviewSessionRoomsTableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_refreshviewSessionRoomsTableActionPerformed

    private void viewSessionRoomsTable_exitBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewSessionRoomsTable_exitBtnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_viewSessionRoomsTable_exitBtnMouseClicked

    private void viewSessionRoomsTable_exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewSessionRoomsTable_exitBtnActionPerformed
        // TODO add your handling code here:
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_viewSessionRoomsTable_exitBtnActionPerformed

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
            java.util.logging.Logger.getLogger(AViewSessionRoomTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AViewSessionRoomTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AViewSessionRoomTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AViewSessionRoomTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AViewSessionRoomTable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_refreshviewSessionRoomsTable;
    private javax.swing.JButton btn_searchviewSessionRoomsTable;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable onlySessionRooms_table;
    private javax.swing.JTextField searchTextFieldSessionRoomsTable;
    private javax.swing.JPanel viewSessionRoomsTable_TopBar;
    private javax.swing.JButton viewSessionRoomsTable_exitBtn;
    // End of variables declaration//GEN-END:variables
}
