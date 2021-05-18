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
public class AViewSubjectRoomTable extends javax.swing.JFrame {
    
    
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStmt;

    /**
     * Creates new form AViewSubjectRoomTable
     */
    
    public AViewSubjectRoomTable() {
        initComponents();
        dbconnect();
        show_SubjectroomDetails();
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
    
    
    public ArrayList<ARoomSubjectModel> roomSubjectList() {
        
        ArrayList<ARoomSubjectModel> roomSubjectList = new ArrayList<>();
        try {
            String query = "SELECT * FROM subjectrooms";
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            
            ARoomSubjectModel subjectroommodel ;

            while(rs.next()){
                subjectroommodel = new ARoomSubjectModel ( rs.getString("roomsubject_code"), rs.getString("roomsubject_name"), rs.getString("subject_lecturer"), rs.getString("subject_tag"), rs.getString("subject_building"), rs.getString("subject_room"));
                roomSubjectList.add(subjectroommodel);            
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex + "Exception occured in RoomList method");
            Logger.getLogger(AAddBuildings.class.getName()).log(Level.SEVERE, null, ex);         
        }
        return roomSubjectList;            
    }
    
    public void show_SubjectroomDetails(){
        
        ArrayList<ARoomSubjectModel> roomSubjectList = roomSubjectList();
        DefaultTableModel tableModel = (DefaultTableModel) onlySubjectRooms_table.getModel();
        
        Object[] row = new Object[6];
        for (int i = 0; i < roomSubjectList.size(); i++) {
            
            row[0] = roomSubjectList.get(i).getSubjectCode();
            row[1] = roomSubjectList.get(i).getSubjectName();
            row[2] = roomSubjectList.get(i).getSubjectLecturer();
            row[3] = roomSubjectList.get(i).getSubjectTag();
            row[4] = roomSubjectList.get(i).getSubjectBuilding();
            row[5] = roomSubjectList.get(i).getSubjectRoom();
            
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

        jPanel1 = new javax.swing.JPanel();
        viewSubjectRoomsTable_TopBar = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        searchTextFieldSubjectRoomsTable = new javax.swing.JTextField();
        btn_searchviewSubjectRoomsTable = new javax.swing.JButton();
        btn_refreshviewSubjectRoomsTable = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        onlySubjectRooms_table = new javax.swing.JTable();
        viewSubjectRoomsTable_exitBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(247, 247, 247));

        viewSubjectRoomsTable_TopBar.setBackground(new java.awt.Color(20, 181, 117));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("SUBJECT ROOMS TABLE");

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

        javax.swing.GroupLayout viewSubjectRoomsTable_TopBarLayout = new javax.swing.GroupLayout(viewSubjectRoomsTable_TopBar);
        viewSubjectRoomsTable_TopBar.setLayout(viewSubjectRoomsTable_TopBarLayout);
        viewSubjectRoomsTable_TopBarLayout.setHorizontalGroup(
            viewSubjectRoomsTable_TopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewSubjectRoomsTable_TopBarLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        viewSubjectRoomsTable_TopBarLayout.setVerticalGroup(
            viewSubjectRoomsTable_TopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewSubjectRoomsTable_TopBarLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(viewSubjectRoomsTable_TopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        searchTextFieldSubjectRoomsTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        searchTextFieldSubjectRoomsTable.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        searchTextFieldSubjectRoomsTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTextFieldSubjectRoomsTableKeyReleased(evt);
            }
        });

        btn_searchviewSubjectRoomsTable.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        btn_searchviewSubjectRoomsTable.setForeground(new java.awt.Color(255, 255, 255));
        btn_searchviewSubjectRoomsTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/add btn.png"))); // NOI18N
        btn_searchviewSubjectRoomsTable.setText("Search");
        btn_searchviewSubjectRoomsTable.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_searchviewSubjectRoomsTable.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/add btn hover.png"))); // NOI18N
        btn_searchviewSubjectRoomsTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchviewSubjectRoomsTableActionPerformed(evt);
            }
        });

        btn_refreshviewSubjectRoomsTable.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        btn_refreshviewSubjectRoomsTable.setForeground(new java.awt.Color(255, 255, 255));
        btn_refreshviewSubjectRoomsTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/add btn.png"))); // NOI18N
        btn_refreshviewSubjectRoomsTable.setText("Refresh");
        btn_refreshviewSubjectRoomsTable.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_refreshviewSubjectRoomsTable.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/add btn hover.png"))); // NOI18N
        btn_refreshviewSubjectRoomsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_refreshviewSubjectRoomsTableMouseClicked(evt);
            }
        });
        btn_refreshviewSubjectRoomsTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refreshviewSubjectRoomsTableActionPerformed(evt);
            }
        });

        onlySubjectRooms_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Subject Code", "Subject Name", "Lecturer Name", "Tag", "Building Name", "Room Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        onlySubjectRooms_table.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(onlySubjectRooms_table);

        viewSubjectRoomsTable_exitBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        viewSubjectRoomsTable_exitBtn.setForeground(new java.awt.Color(255, 255, 255));
        viewSubjectRoomsTable_exitBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/clear btn.png"))); // NOI18N
        viewSubjectRoomsTable_exitBtn.setText("Exit");
        viewSubjectRoomsTable_exitBtn.setToolTipText("If You click this you can close this window only");
        viewSubjectRoomsTable_exitBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        viewSubjectRoomsTable_exitBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablemanagementsystem/AImages/clear btn hover.png"))); // NOI18N
        viewSubjectRoomsTable_exitBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewSubjectRoomsTable_exitBtnMouseClicked(evt);
            }
        });
        viewSubjectRoomsTable_exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewSubjectRoomsTable_exitBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(viewSubjectRoomsTable_TopBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(searchTextFieldSubjectRoomsTable, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_searchviewSubjectRoomsTable, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_refreshviewSubjectRoomsTable, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(viewSubjectRoomsTable_exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 761, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(viewSubjectRoomsTable_TopBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_searchviewSubjectRoomsTable, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_refreshviewSubjectRoomsTable, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchTextFieldSubjectRoomsTable, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(viewSubjectRoomsTable_exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void searchTextFieldSubjectRoomsTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextFieldSubjectRoomsTableKeyReleased
        // TODO add your handling code here:
        DefaultTableModel table = (DefaultTableModel)onlySubjectRooms_table.getModel();
        String search = searchTextFieldSubjectRoomsTable.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
        onlySubjectRooms_table.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_searchTextFieldSubjectRoomsTableKeyReleased

    private void btn_searchviewSubjectRoomsTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchviewSubjectRoomsTableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_searchviewSubjectRoomsTableActionPerformed

    private void btn_refreshviewSubjectRoomsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_refreshviewSubjectRoomsTableMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) onlySubjectRooms_table.getModel();
        model.setRowCount(0);
        show_SubjectroomDetails();
    }//GEN-LAST:event_btn_refreshviewSubjectRoomsTableMouseClicked

    private void btn_refreshviewSubjectRoomsTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshviewSubjectRoomsTableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_refreshviewSubjectRoomsTableActionPerformed

    private void viewSubjectRoomsTable_exitBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewSubjectRoomsTable_exitBtnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_viewSubjectRoomsTable_exitBtnMouseClicked

    private void viewSubjectRoomsTable_exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewSubjectRoomsTable_exitBtnActionPerformed
        // TODO add your handling code here:
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_viewSubjectRoomsTable_exitBtnActionPerformed

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
            java.util.logging.Logger.getLogger(AViewSubjectRoomTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AViewSubjectRoomTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AViewSubjectRoomTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AViewSubjectRoomTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AViewSubjectRoomTable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_refreshviewSubjectRoomsTable;
    private javax.swing.JButton btn_searchviewSubjectRoomsTable;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable onlySubjectRooms_table;
    private javax.swing.JTextField searchTextFieldSubjectRoomsTable;
    private javax.swing.JPanel viewSubjectRoomsTable_TopBar;
    private javax.swing.JButton viewSubjectRoomsTable_exitBtn;
    // End of variables declaration//GEN-END:variables
}
