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
public class AViewGroupRoomTable extends javax.swing.JFrame {

    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStmt;       

    /**
     * Creates new form AViewGroupRoomTable
     */
    public AViewGroupRoomTable() {
        initComponents();
        dbconnect();
        show_GroupRoomDetails();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    public ArrayList<ARoomGroupModel> roomGroupList() {
        
        ArrayList<ARoomGroupModel> roomGroupList = new ArrayList<>();
        try {
            String query = "SELECT * FROM grouprooms";
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            
            ARoomGroupModel grouproommodel ;

            while(rs.next()){
                grouproommodel = new ARoomGroupModel (rs.getInt("grouproom_id"), rs.getString("group_id"), rs.getString("groupsub_id"), rs.getString("group_tag"), rs.getString("group_building"), rs.getString("group_room"));
                roomGroupList.add(grouproommodel);            
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex + "Exception occured in RoomList method");
            Logger.getLogger(AAddBuildings.class.getName()).log(Level.SEVERE, null, ex);         
        }
        return roomGroupList;            
    }
    
    public void show_GroupRoomDetails(){
        
        ArrayList<ARoomGroupModel> roomGroupList = roomGroupList();
        DefaultTableModel tableModel = (DefaultTableModel) onlyGroupRooms_table.getModel();
        
        Object[] row = new Object[6];
        for (int i = 0; i < roomGroupList.size(); i++) {
            
            row[0] = roomGroupList.get(i).getId();
            row[1] = roomGroupList.get(i).getGroup_name();
            row[2] = roomGroupList.get(i).getGroupSub_name();
            row[3] = roomGroupList.get(i).getGroupTag();
            row[4] = roomGroupList.get(i).getGroupBuilding();
            row[5] = roomGroupList.get(i).getGroupRoom();
            
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
        viewGroupRoomsTable_TopBar = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        searchTextFieldGroupRoomsTable = new javax.swing.JTextField();
        btn_searchviewGroupRoomsTable = new javax.swing.JButton();
        btn_refreshviewGroupRoomsTable = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        onlyGroupRooms_table = new javax.swing.JTable();
        viewGroupRoomsTable_exitBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(247, 247, 247));

        viewGroupRoomsTable_TopBar.setBackground(new java.awt.Color(20, 181, 117));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("GROUP ROOMS TABLE");

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

        javax.swing.GroupLayout viewGroupRoomsTable_TopBarLayout = new javax.swing.GroupLayout(viewGroupRoomsTable_TopBar);
        viewGroupRoomsTable_TopBar.setLayout(viewGroupRoomsTable_TopBarLayout);
        viewGroupRoomsTable_TopBarLayout.setHorizontalGroup(
            viewGroupRoomsTable_TopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewGroupRoomsTable_TopBarLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        viewGroupRoomsTable_TopBarLayout.setVerticalGroup(
            viewGroupRoomsTable_TopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewGroupRoomsTable_TopBarLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(viewGroupRoomsTable_TopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        searchTextFieldGroupRoomsTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        searchTextFieldGroupRoomsTable.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        searchTextFieldGroupRoomsTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTextFieldGroupRoomsTableKeyReleased(evt);
            }
        });

        btn_searchviewGroupRoomsTable.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        btn_searchviewGroupRoomsTable.setForeground(new java.awt.Color(255, 255, 255));
        btn_searchviewGroupRoomsTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/add btn.png"))); // NOI18N
        btn_searchviewGroupRoomsTable.setText("Search");
        btn_searchviewGroupRoomsTable.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_searchviewGroupRoomsTable.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/add btn hover.png"))); // NOI18N
        btn_searchviewGroupRoomsTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchviewGroupRoomsTableActionPerformed(evt);
            }
        });

        btn_refreshviewGroupRoomsTable.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        btn_refreshviewGroupRoomsTable.setForeground(new java.awt.Color(255, 255, 255));
        btn_refreshviewGroupRoomsTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/add btn.png"))); // NOI18N
        btn_refreshviewGroupRoomsTable.setText("Refresh");
        btn_refreshviewGroupRoomsTable.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_refreshviewGroupRoomsTable.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/add btn hover.png"))); // NOI18N
        btn_refreshviewGroupRoomsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_refreshviewGroupRoomsTableMouseClicked(evt);
            }
        });
        btn_refreshviewGroupRoomsTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refreshviewGroupRoomsTableActionPerformed(evt);
            }
        });

        onlyGroupRooms_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Group ID", "Sub Group ID", "Tag", "Building Name", "Room Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        onlyGroupRooms_table.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(onlyGroupRooms_table);

        viewGroupRoomsTable_exitBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        viewGroupRoomsTable_exitBtn.setForeground(new java.awt.Color(255, 255, 255));
        viewGroupRoomsTable_exitBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/clear btn.png"))); // NOI18N
        viewGroupRoomsTable_exitBtn.setText("Exit");
        viewGroupRoomsTable_exitBtn.setToolTipText("If You click this you can close this window only");
        viewGroupRoomsTable_exitBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        viewGroupRoomsTable_exitBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/clear btn hover.png"))); // NOI18N
        viewGroupRoomsTable_exitBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewGroupRoomsTable_exitBtnMouseClicked(evt);
            }
        });
        viewGroupRoomsTable_exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewGroupRoomsTable_exitBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(viewGroupRoomsTable_TopBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(searchTextFieldGroupRoomsTable, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_searchviewGroupRoomsTable, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_refreshviewGroupRoomsTable, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(viewGroupRoomsTable_exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(viewGroupRoomsTable_TopBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_searchviewGroupRoomsTable, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_refreshviewGroupRoomsTable, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchTextFieldGroupRoomsTable, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(viewGroupRoomsTable_exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void searchTextFieldGroupRoomsTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextFieldGroupRoomsTableKeyReleased
        // TODO add your handling code here:
        DefaultTableModel table = (DefaultTableModel)onlyGroupRooms_table.getModel();
        String search = searchTextFieldGroupRoomsTable.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
        onlyGroupRooms_table.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_searchTextFieldGroupRoomsTableKeyReleased

    private void btn_searchviewGroupRoomsTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchviewGroupRoomsTableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_searchviewGroupRoomsTableActionPerformed

    private void btn_refreshviewGroupRoomsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_refreshviewGroupRoomsTableMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) onlyGroupRooms_table.getModel();
        model.setRowCount(0);
        show_GroupRoomDetails();
    }//GEN-LAST:event_btn_refreshviewGroupRoomsTableMouseClicked

    private void btn_refreshviewGroupRoomsTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshviewGroupRoomsTableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_refreshviewGroupRoomsTableActionPerformed

    private void viewGroupRoomsTable_exitBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewGroupRoomsTable_exitBtnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_viewGroupRoomsTable_exitBtnMouseClicked

    private void viewGroupRoomsTable_exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewGroupRoomsTable_exitBtnActionPerformed
        // TODO add your handling code here:
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_viewGroupRoomsTable_exitBtnActionPerformed

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
            java.util.logging.Logger.getLogger(AViewGroupRoomTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AViewGroupRoomTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AViewGroupRoomTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AViewGroupRoomTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AViewGroupRoomTable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_refreshviewGroupRoomsTable;
    private javax.swing.JButton btn_searchviewGroupRoomsTable;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable onlyGroupRooms_table;
    private javax.swing.JTextField searchTextFieldGroupRoomsTable;
    private javax.swing.JPanel viewGroupRoomsTable_TopBar;
    private javax.swing.JButton viewGroupRoomsTable_exitBtn;
    // End of variables declaration//GEN-END:variables
}
