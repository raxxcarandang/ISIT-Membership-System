/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ISITDatabaseRegistry;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMoonlightContrastIJTheme;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.sql.*;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.Toolkit;
import java.sql.ResultSetMetaData;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.UIManager;


/**
 *
 * @group9 7885425
 */
public class adminlogin extends javax.swing.JFrame {
String url = "jdbc:mysql://localhost:3306/ISITDatabase";
String user = "root";
public static String pass = "";
String accessusername = "";
String accesspassword = "";
String accesslevel = "";
Connection cloud9 = null;
PreparedStatement call = null;
ResultSet output = null;
JFrame programexit;
int passfail = 0;
    /**
     * Creates new form group9ui
     */
    public adminlogin() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("ISIT.png")));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        canvas1 = new java.awt.Canvas();
        img1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        login = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        showpass = new javax.swing.JToggleButton();
        userbox = new javax.swing.JTextField();
        passbox = new javax.swing.JPasswordField();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("I.S.I.T. ADMINISTRATION SYSTEM");
        setBackground(new java.awt.Color(0, 0, 204));
        setForeground(java.awt.Color.blue);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 102, 255));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(null);
        jPanel1.add(canvas1);
        canvas1.setBounds(0, 0, 0, 0);

        img1.setBackground(new java.awt.Color(0, 0, 0));
        img1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ISITDatabaseRegistry/ISIT.png"))); // NOI18N
        jPanel1.add(img1);
        img1.setBounds(0, 0, 500, 510);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 500, 510);

        jPanel3.setBackground(new java.awt.Color(0, 51, 102));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setLayout(null);

        login.setBackground(new java.awt.Color(0, 102, 255));
        login.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        login.setForeground(new java.awt.Color(0, 0, 0));
        login.setText("LOG-IN");
        login.setToolTipText("");
        login.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        jPanel3.add(login);
        login.setBounds(120, 320, 80, 50);

        clear.setBackground(new java.awt.Color(0, 255, 0));
        clear.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        clear.setForeground(new java.awt.Color(0, 0, 0));
        clear.setText("CLEAR");
        clear.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        jPanel3.add(clear);
        clear.setBounds(210, 320, 70, 50);

        exit.setBackground(new java.awt.Color(255, 0, 0));
        exit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        exit.setForeground(new java.awt.Color(0, 0, 0));
        exit.setText("EXIT");
        exit.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        jPanel3.add(exit);
        exit.setBounds(290, 320, 70, 50);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("PASSWORD:");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(120, 250, 80, 30);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("USERNAME:");
        jPanel3.add(jLabel1);
        jLabel1.setBounds(120, 190, 80, 16);

        jPanel2.setBackground(new java.awt.Color(0, 51, 204));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("I.S.I.T. ADMIN SYSTEM");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel2.add(jLabel3);
        jLabel3.setBounds(0, 20, 470, 40);

        jPanel3.add(jPanel2);
        jPanel2.setBounds(0, 40, 470, 80);

        showpass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ISITDatabaseRegistry/show3.png"))); // NOI18N
        showpass.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 51, 153), new java.awt.Color(0, 51, 153), null, null));
        showpass.setIconTextGap(0);
        showpass.setOpaque(false);
        showpass.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/ISITDatabaseRegistry/hide2.png"))); // NOI18N
        showpass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                showpassFocusLost(evt);
            }
        });
        showpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showpassActionPerformed(evt);
            }
        });
        jPanel3.add(showpass);
        showpass.setBounds(330, 282, 30, 30);

        userbox.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        userbox.setForeground(new java.awt.Color(255, 255, 255));
        userbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userboxActionPerformed(evt);
            }
        });
        jPanel3.add(userbox);
        userbox.setBounds(120, 210, 240, 35);

        passbox.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        passbox.setForeground(new java.awt.Color(255, 255, 255));
        passbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passboxActionPerformed(evt);
            }
        });
        jPanel3.add(passbox);
        passbox.setBounds(120, 280, 210, 35);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(500, 0, 470, 510);

        setBounds(0, 0, 985, 549);
    }// </editor-fold>//GEN-END:initComponents

    private void userboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userboxActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_userboxActionPerformed

    private void passboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passboxActionPerformed

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        // TODO add your handling code here:
        String username = userbox.getText();
        String password = passbox.getText(); 
        try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        cloud9 = DriverManager.getConnection(url,user,pass);
        call = cloud9.prepareStatement("SELECT * FROM Member_login WHERE username =? HAVING password =?");
        call.setString(1, userbox.getText());
        call.setString(2, passbox.getText());
        output = call.executeQuery();
         while (output.next()) {
        accessusername = output.getString("username");
        accesspassword = output.getString("password");
        accesslevel = output.getString("Access_level");
        }
          if ((username.isEmpty()) && (password.isEmpty())) {
               JOptionPane.showMessageDialog(null, "USERNAME FIELD & PASSWORD FIELD CANNOT BE EMPTY");
           }
          else if ((username.equals(accessusername))&&(password.equals(accesspassword))) {
               if (accesslevel.equalsIgnoreCase("Admin")) {
               JOptionPane.showMessageDialog(null, "ADMIN LOG-IN SUCCESSFUL");
               new ISITDatabaseRegistrator().setVisible(true);
               this.setVisible(false);
               cloud9.close();
               }
               else if (accesslevel.equalsIgnoreCase("Member")){
               JOptionPane.showMessageDialog(null, "ADMINISTRATORS ONLY! NO MEMBERS ALLOWED!");
               }
           }
            else if (username.isEmpty()) {
               JOptionPane.showMessageDialog(null, "USERNAME FIELD CANNOT BE EMPTY");
           }
            else if (password.isEmpty()) {
               JOptionPane.showMessageDialog(null, "PASSWORD FIELD CANNOT BE EMPTY");
           }
           else {
               JOptionPane.showMessageDialog(null, "INVALID USERNAME OR PASSWORD!");
           }
           
        }
        catch (Exception L) {
        JOptionPane.showMessageDialog(null, "CONNECTION FAILED");
        do {
        pass = JOptionPane.showInputDialog("Incorrect MySQL Password \n Please Enter a New one");
        if (pass != null) 
        {
        try {
             cloud9 = DriverManager.getConnection(url,user,pass);
             JOptionPane.showMessageDialog(null, "Connection Established\n Please Try Logging-In Again");
             passfail = 0;
        }
        catch (Exception P){
            passfail = 1;
            JOptionPane.showMessageDialog(null, "Invalid MySQL Password! \n Please Try Again");
        }
        }
        else {
            passfail = 0;
        }
        }
        while (passfail != 0);
        }
    }//GEN-LAST:event_loginActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        // TODO add your handling code here:
        userbox.setText("");
        passbox.setText("");
    }//GEN-LAST:event_clearActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        // TODO add your handling code here:
          programexit = new JFrame("Exit");
       if (JOptionPane.showConfirmDialog(programexit, "ARE YOU SURE YOU WANT TO EXIT THE PROGRAM?", "PROGRAM", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
         System.exit(0);
        try {
            cloud9.close();
        }
        catch (Exception C) {
            JOptionPane.showMessageDialog(null, "CONNECTION WON'T CLOSE!");
        }
       }
    }//GEN-LAST:event_exitActionPerformed

    private void showpassFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_showpassFocusLost
        // TODO add your handling code here:
        showpass.setSelected(false);
        passbox.setEchoChar('*');
    }//GEN-LAST:event_showpassFocusLost

    private void showpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showpassActionPerformed
        // TODO add your handling code here:
        if (showpass.isSelected())
        {
            passbox.setEchoChar((char)0);
        }
        else {
            passbox.setEchoChar('*');
        }
    }//GEN-LAST:event_showpassActionPerformed

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
             UIManager.setLookAndFeel(new FlatMoonlightContrastIJTheme());    
            }
         catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adminlogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new adminlogin().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Canvas canvas1;
    private javax.swing.JButton clear;
    private javax.swing.JButton exit;
    private javax.swing.JLabel img1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton login;
    private javax.swing.JPasswordField passbox;
    private javax.swing.JToggleButton showpass;
    private javax.swing.JTextField userbox;
    // End of variables declaration//GEN-END:variables
}
