/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ISITDatabaseRegistry;
import ISITDatabaseRegistry.adminlogin;
import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.intellijthemes.FlatCobalt2IJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatArcDarkContrastIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMoonlightContrastIJTheme;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
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
public class ISITDatabaseRegistrator extends javax.swing.JFrame {
public static final String url = "jdbc:mysql://localhost:3306/ISITDatabase";
public static final String user = "root";
String pass = adminlogin.pass;
JFrame deletion = new JFrame();
JFrame programexit = new JFrame();
String pwd = "";
int count = 0;
int counter = 0;
int ccounter = 0;
int rcounter = 0;
String condition = "";
Connection cloud9 = null;
PreparedStatement call = null;
ResultSet output = null;
    /**
     * Creates new form ISITDatabaseRegistrator
     */
     
     
    public ISITDatabaseRegistrator() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("ISIT.png")));
        loadloginbase();
        getmembercount();
    }
public void getmembercount() {
     try{
    Class.forName("com.mysql.cj.jdbc.Driver");
    cloud9 = DriverManager.getConnection(url, user, pass);
    call = cloud9.prepareStatement("SELECT * FROM Member_info");
    output = call.executeQuery();
    ResultSetMetaData reqdata = output.getMetaData();
    count = reqdata.getColumnCount();
    
    DefaultTableModel RecordTable = new DefaultTableModel();
    RecordTable.setRowCount(0);
    
        while (output.next())
                {
                 Vector columninfo = new Vector();  
                 
                 for (int m =1; m<=count; m++) {
                     columninfo.add(output.getString("Member_ID"));
                     columninfo.add(output.getString("ID_Number"));
                     columninfo.add(output.getString("Year_Level"));
                     columninfo.add(output.getString("First_Name"));
                     columninfo.add(output.getString("Middle_Name"));
                     columninfo.add(output.getString("Surname"));
                     columninfo.add(output.getString("Gender"));
                     columninfo.add(output.getString("Address"));
                     columninfo.add(output.getString("Birthdate"));
                     columninfo.add(output.getString("PWD"));
                 }
                 RecordTable.addRow(columninfo);
                 
                }
        ccounter = RecordTable.getRowCount();
        ccounter++;
        memid.setText("" +ccounter);
    }
    catch (Exception M) {
        JOptionPane.showMessageDialog(null, "MEMBER COUNT DATABASE CONNECTION ERROR");
    }
}
public void loadloginbase() {
         try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        cloud9 = DriverManager.getConnection(url, user, pass);
        call = cloud9.prepareStatement("SELECT * FROM member_login");
        output = call.executeQuery();
        ResultSetMetaData getdata = output.getMetaData();
        counter = getdata.getColumnCount();
        DefaultTableModel logintable = (DefaultTableModel)admint.getModel();
        logintable.setRowCount(0);
        while (output.next()) {
            Vector cminfo = new Vector();
            for (int c = 1;c<=counter;c++) {
                cminfo.add(output.getObject("Login_ID"));
                cminfo.add(output.getObject("Member_ID"));
                cminfo.add(output.getString("Access_level"));
                cminfo.add(output.getString("username"));
                cminfo.add(output.getString("password"));
            }
            logintable.addRow(cminfo);
            rcounter = logintable.getRowCount();
        rcounter++;
        logid.setText("" +rcounter);
        }
        
         }
         catch (Exception L) {
             JOptionPane.showMessageDialog(null, "LOGIN DATABASE LOAD ERROR");
         }
     }
public void searchloginbase() {
         try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        cloud9 = DriverManager.getConnection(url, user, pass);
        call = cloud9.prepareStatement("SELECT * FROM Member_login WHERE " + condition + " LIKE " + "\"%" + searchbox.getText() + "%\"");
        output = call.executeQuery();
        ResultSetMetaData getdata = output.getMetaData();
        counter = getdata.getColumnCount();
        DefaultTableModel logintable = (DefaultTableModel)admint.getModel();
        logintable.setRowCount(0);
        while (output.next()) {
            Vector cminfo = new Vector();
            for (int c = 1;c<=counter;c++) {
                cminfo.add(output.getObject("Login_ID"));
                cminfo.add(output.getObject("Member_ID"));
                cminfo.add(output.getString("Access_level"));
                cminfo.add(output.getString("username"));
                cminfo.add(output.getString("password"));
            }
            logintable.addRow(cminfo);
        }
         }
         catch (Exception L) {
             JOptionPane.showMessageDialog(null, "LOGIN LOAD ERROR");
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
        jLabel27 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        memid = new javax.swing.JTextField();
        idnum = new javax.swing.JTextField();
        yearlevelbox = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        fname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        mname = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        lname = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        genderbox = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        birthday = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        address = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        userbox = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        exit = new javax.swing.JButton();
        registerlogin = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        logid = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        registermember = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        pwdbox = new javax.swing.JCheckBox();
        search = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        admint = new javax.swing.JTable();
        memid1 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        searchbox = new javax.swing.JTextField();
        searchcon = new javax.swing.JComboBox<>();
        reset1 = new javax.swing.JButton();
        update = new javax.swing.JButton();
        passbox = new javax.swing.JTextField();
        accessbox = new javax.swing.JComboBox<>();
        jLabel30 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("I.S.I.T ADMIN REGISTRY");
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(null);

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("ADDRESS");
        jPanel1.add(jLabel27);
        jLabel27.setBounds(0, 490, 80, 16);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ID NUMBER");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 440, 90, 16);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("YEAR LEVEL");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(270, 440, 90, 16);

        memid.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        memid.setForeground(java.awt.Color.white);
        memid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        memid.setBorder(userbox.getBorder());
        memid.setName(""); // NOI18N
        memid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                memidMouseClicked(evt);
            }
        });
        memid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memidActionPerformed(evt);
            }
        });
        jPanel1.add(memid);
        memid.setBounds(10, 400, 120, 30);

        idnum.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        idnum.setForeground(java.awt.Color.white);
        idnum.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        idnum.setBorder(userbox.getBorder());
        idnum.setName(""); // NOI18N
        idnum.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                idnumMouseClicked(evt);
            }
        });
        idnum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idnumActionPerformed(evt);
            }
        });
        jPanel1.add(idnum);
        idnum.setBounds(10, 460, 140, 30);

        yearlevelbox.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        yearlevelbox.setForeground(java.awt.Color.white);
        yearlevelbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1ST YEAR", "2ND YEAR", "3RD YEAR", "4TH YEAR", "GRADUATED" }));
        yearlevelbox.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 51, 51)));
        jPanel1.add(yearlevelbox);
        yearlevelbox.setBounds(280, 460, 140, 30);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("FIRST NAME");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(130, 380, 90, 16);

        fname.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        fname.setForeground(java.awt.Color.white);
        fname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fname.setBorder(userbox.getBorder());
        fname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnameActionPerformed(evt);
            }
        });
        jPanel1.add(fname);
        fname.setBounds(140, 400, 140, 30);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("MIDDLE NAME");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(290, 380, 90, 16);

        mname.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        mname.setForeground(java.awt.Color.white);
        mname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        mname.setBorder(userbox.getBorder());
        mname.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnameMouseClicked(evt);
            }
        });
        mname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnameActionPerformed(evt);
            }
        });
        jPanel1.add(mname);
        mname.setBounds(290, 400, 140, 30);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("LAST NAME");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(430, 380, 90, 16);

        lname.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lname.setForeground(java.awt.Color.white);
        lname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lname.setBorder(userbox.getBorder());
        lname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnameActionPerformed(evt);
            }
        });
        jPanel1.add(lname);
        lname.setBounds(440, 400, 130, 30);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("GENDER");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(140, 440, 90, 16);

        genderbox.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        genderbox.setForeground(java.awt.Color.white);
        genderbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MALE", "FEMALE" }));
        genderbox.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 51, 51)));
        jPanel1.add(genderbox);
        genderbox.setBounds(160, 460, 110, 30);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("BIRTHDATE");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(410, 440, 100, 16);

        birthday.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        birthday.setForeground(java.awt.Color.white);
        birthday.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        birthday.setBorder(userbox.getBorder());
        birthday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                birthdayActionPerformed(evt);
            }
        });
        jPanel1.add(birthday);
        birthday.setBounds(430, 460, 140, 30);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Ex. \"1999- 07- 14\"");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(410, 490, 170, 20);

        address.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        address.setForeground(java.awt.Color.white);
        address.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        address.setBorder(userbox.getBorder());
        address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressActionPerformed(evt);
            }
        });
        jPanel1.add(address);
        address.setBounds(10, 520, 500, 30);

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("MEMBER ID");
        jPanel1.add(jLabel28);
        jLabel28.setBounds(0, 380, 90, 16);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("USERNAME:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(10, 280, 80, 16);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("I.S.I.T. ADMINISTRATION MANAGEMENT");
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel8);
        jLabel8.setBounds(10, 0, 560, 40);

        userbox.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        userbox.setForeground(java.awt.Color.white);
        userbox.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        userbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userboxActionPerformed(evt);
            }
        });
        jPanel1.add(userbox);
        userbox.setBounds(10, 300, 270, 30);

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("PASSWORD:");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(290, 280, 80, 20);

        exit.setBackground(new java.awt.Color(204, 204, 204));
        exit.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        exit.setForeground(new java.awt.Color(0, 0, 0));
        exit.setText("LOG-OUT");
        exit.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(102, 102, 102), new java.awt.Color(153, 153, 153), new java.awt.Color(153, 153, 153), new java.awt.Color(102, 102, 102)));
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        jPanel1.add(exit);
        exit.setBounds(460, 340, 110, 30);

        registerlogin.setBackground(new java.awt.Color(0, 255, 0));
        registerlogin.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        registerlogin.setForeground(new java.awt.Color(0, 0, 0));
        registerlogin.setText("REGISTER LOGIN DETAILS");
        registerlogin.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 153, 0), new java.awt.Color(0, 102, 0), new java.awt.Color(0, 153, 0), new java.awt.Color(0, 153, 0)));
        registerlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerloginActionPerformed(evt);
            }
        });
        jPanel1.add(registerlogin);
        registerlogin.setBounds(10, 340, 160, 30);

        delete.setBackground(new java.awt.Color(255, 0, 0));
        delete.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        delete.setForeground(new java.awt.Color(0, 0, 0));
        delete.setText("DELETE");
        delete.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(204, 0, 0), new java.awt.Color(255, 0, 0), new java.awt.Color(102, 0, 0), new java.awt.Color(153, 0, 0)));
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        jPanel1.add(delete);
        delete.setBounds(390, 340, 60, 30);

        logid.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        logid.setForeground(java.awt.Color.white);
        logid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        logid.setBorder(userbox.getBorder());
        logid.setName(""); // NOI18N
        logid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logidMouseClicked(evt);
            }
        });
        logid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logidActionPerformed(evt);
            }
        });
        jPanel1.add(logid);
        logid.setBounds(10, 250, 170, 30);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("LOGIN ID");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(-10, 230, 90, 16);

        registermember.setBackground(new java.awt.Color(0, 255, 0));
        registermember.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        registermember.setForeground(new java.awt.Color(0, 0, 0));
        registermember.setText("REGISTER MEMBER");
        registermember.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 153, 0), new java.awt.Color(0, 102, 0), new java.awt.Color(0, 153, 0), new java.awt.Color(0, 153, 0)));
        registermember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registermemberActionPerformed(evt);
            }
        });
        jPanel1.add(registermember);
        registermember.setBounds(10, 560, 290, 30);

        reset.setBackground(new java.awt.Color(255, 255, 0));
        reset.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        reset.setForeground(new java.awt.Color(0, 0, 0));
        reset.setText("RESET");
        reset.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(204, 204, 0), new java.awt.Color(204, 204, 0), new java.awt.Color(204, 204, 0), new java.awt.Color(204, 204, 0)));
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });
        jPanel1.add(reset);
        reset.setBounds(310, 560, 260, 30);

        pwdbox.setBackground(new java.awt.Color(0, 51, 102));
        pwdbox.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        pwdbox.setForeground(new java.awt.Color(255, 255, 255));
        pwdbox.setText("PWD");
        pwdbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwdboxActionPerformed(evt);
            }
        });
        jPanel1.add(pwdbox);
        pwdbox.setBounds(510, 520, 70, 30);

        search.setBackground(new java.awt.Color(0, 0, 204));
        search.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        search.setForeground(new java.awt.Color(255, 255, 255));
        search.setText("SEARCH");
        search.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        jPanel1.add(search);
        search.setBounds(510, 50, 60, 20);

        admint.setAutoCreateRowSorter(true);
        admint.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        admint.setForeground(new java.awt.Color(255, 255, 255));
        admint.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "LOGIN ID", "MEMBER ID", "ACCESS LEVEL", "USERNAME", "PASSWORD"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        admint.setGridColor(new java.awt.Color(0, 255, 51));
        admint.setSelectionBackground(new java.awt.Color(0, 255, 0));
        admint.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        admint.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        admint.setShowGrid(true);
        admint.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                admintMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(admint);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(10, 80, 560, 140);

        memid1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        memid1.setForeground(java.awt.Color.white);
        memid1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        memid1.setBorder(userbox.getBorder());
        memid1.setName(""); // NOI18N
        memid1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                memid1MouseClicked(evt);
            }
        });
        memid1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memid1ActionPerformed(evt);
            }
        });
        jPanel1.add(memid1);
        memid1.setBounds(370, 250, 200, 30);

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("ACCESS LEVEL");
        jPanel1.add(jLabel29);
        jLabel29.setBounds(180, 230, 90, 16);

        searchbox.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        searchbox.setForeground(java.awt.Color.white);
        searchbox.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        searchbox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(searchbox);
        searchbox.setBounds(150, 50, 360, 20);

        searchcon.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        searchcon.setForeground(java.awt.Color.white);
        searchcon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<SEARCH>", "LOGIN ID", "MEMBER ID", "ACCESS LEVEL", "USERNAME", "PASSWORD" }));
        searchcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchconMouseClicked(evt);
            }
        });
        searchcon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchconActionPerformed(evt);
            }
        });
        jPanel1.add(searchcon);
        searchcon.setBounds(10, 50, 130, 20);

        reset1.setBackground(new java.awt.Color(255, 255, 0));
        reset1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        reset1.setForeground(new java.awt.Color(0, 0, 0));
        reset1.setText("RESET");
        reset1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(204, 204, 0), new java.awt.Color(204, 204, 0), new java.awt.Color(204, 204, 0), new java.awt.Color(204, 204, 0)));
        reset1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset1ActionPerformed(evt);
            }
        });
        jPanel1.add(reset1);
        reset1.setBounds(310, 340, 70, 30);

        update.setBackground(new java.awt.Color(102, 102, 255));
        update.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        update.setForeground(new java.awt.Color(0, 0, 0));
        update.setText("UPDATE");
        update.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 51, 255), new java.awt.Color(51, 51, 255), new java.awt.Color(51, 51, 255), new java.awt.Color(51, 51, 255)));
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        jPanel1.add(update);
        update.setBounds(180, 340, 120, 30);

        passbox.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        passbox.setForeground(java.awt.Color.white);
        passbox.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(passbox);
        passbox.setBounds(290, 300, 280, 30);

        accessbox.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        accessbox.setForeground(java.awt.Color.white);
        accessbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ADMIN", "MEMBER" }));
        jPanel1.add(accessbox);
        accessbox.setBounds(190, 250, 170, 30);

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("MEMBER ID");
        jPanel1.add(jLabel30);
        jLabel30.setBounds(360, 230, 90, 16);

        jPanel2.setBackground(new java.awt.Color(0, 51, 204));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 580, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 580, 600);

        setBounds(0, 0, 597, 637);
    }// </editor-fold>//GEN-END:initComponents

    private void addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressActionPerformed

    private void birthdayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_birthdayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_birthdayActionPerformed

    private void lnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lnameActionPerformed

    private void mnameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnameMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_mnameMouseClicked

    private void mnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnameActionPerformed

    private void fnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fnameActionPerformed

    private void idnumMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_idnumMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_idnumMouseClicked

    private void idnumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idnumActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_idnumActionPerformed

    private void memidMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_memidMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_memidMouseClicked

    private void memidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_memidActionPerformed

    private void userboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userboxActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_userboxActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(deletion, "DELETE LOGIN #" + logid.getText() + "?", "DELETION", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
        {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
    cloud9 = DriverManager.getConnection(url, user, pass);
    call = cloud9.prepareStatement("DELETE FROM Member_login WHERE Login_ID =?");
    call.setObject(1, logid.getText());
    call.executeUpdate();
            JOptionPane.showMessageDialog(null, "LOGIN INFORMATION DELETED");
            loadloginbase();
     logid.setText("");
     memid1.setText("");
     userbox.setText("");
     passbox.setText("");
            }
        catch (Exception A) {
            JOptionPane.showMessageDialog(null, "MEMBER DELETION FAILED!");
                            }
        loadloginbase();
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void logidMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logidMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_logidMouseClicked

    private void logidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_logidActionPerformed

    private void registerloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerloginActionPerformed
        // TODO add your handling code here:
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            cloud9 = DriverManager.getConnection(url, user, pass);
            call = cloud9.prepareStatement("INSERT INTO Member_login (Login_ID, Member_ID, Access_level, username, password) VALUES (?, ?, ?, ?, ?)");
            call.setObject(1, logid.getText());
            call.setObject(2, memid1.getText());
            call.setString(3, accessbox.getSelectedItem().toString());
            call.setString(4, userbox.getText());
            call.setString(5, passbox.getText());
            call.executeUpdate();
            JOptionPane.showMessageDialog(null, "LOGIN INFORMATION INSERTED");
            loadloginbase();
        }
        catch (Exception C) {
            JOptionPane.showMessageDialog(null, "LOGIN INFO INSERT ERROR");
        }
    }//GEN-LAST:event_registerloginActionPerformed

    private void registermemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registermemberActionPerformed
        // TODO add your handling code here:
        try{
    Class.forName("com.mysql.cj.jdbc.Driver");
    cloud9 = DriverManager.getConnection(url, user, pass);
    call = cloud9.prepareStatement("INSERT INTO Member_info (Member_ID, ID_Number, Year_Level, First_Name, Middle_Name, Surname, Gender, Address, Birthdate, PWD) VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
    call.setObject(1, memid.getText());
    call.setString(2, idnum.getText());
    call.setString(3, yearlevelbox.getSelectedItem().toString());
    call.setString(4, fname.getText());
    call.setString(5, mname.getText());
    call.setString(6, lname.getText());
    call.setString(7, genderbox.getSelectedItem().toString());
    call.setString(8, address.getText());
    call.setString(9, birthday.getText());
    call.setString(10, pwd);
    call.executeUpdate();
    JOptionPane.showMessageDialog(null, "MEMBER INFORMATION REGISTERED");
        }
       catch (Exception B) {
           JOptionPane.showMessageDialog(null, "MEMBER INSERT ERROR");
       }
        loadloginbase();
    }//GEN-LAST:event_registermemberActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        // TODO add your handling code here:
        memid.setText("");
     idnum.setText("");
     yearlevelbox.setSelectedIndex(0);
     fname.setText("");
     mname.setText("");
     lname.setText("");
     genderbox.setSelectedIndex(0);
     birthday.setText("");
     address.setText("");
     pwdbox.setSelected(false);
     admint.setAutoCreateRowSorter(false);
        admint.setAutoCreateRowSorter(true);
     loadloginbase();
     getmembercount();
    }//GEN-LAST:event_resetActionPerformed

    private void pwdboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwdboxActionPerformed
        // TODO add your handling code here:
         if (pwdbox.isSelected()){
                pwd = "TRUE";
                                  }
        else {
            pwd = "FALSE";
             }
    }//GEN-LAST:event_pwdboxActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
       searchloginbase();
    }//GEN-LAST:event_searchActionPerformed

    private void admintMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admintMouseClicked
        // TODO add your handling code here:
        String accesslevel = "";
        DefaultTableModel logintable = (DefaultTableModel)admint.getModel();
        int selectedrow = admint.getSelectedRow();
        int sortedrow = admint.convertRowIndexToModel(selectedrow);
        logid.setText(logintable.getValueAt(sortedrow, 0).toString());
        memid1.setText(logintable.getValueAt(sortedrow, 1).toString());
        accesslevel = (logintable.getValueAt(sortedrow, 2).toString());
        userbox.setText(logintable.getValueAt(sortedrow, 3).toString());
        passbox.setText(logintable.getValueAt(sortedrow, 4).toString());
        
        if (accesslevel.equalsIgnoreCase("Admin"))
        {
            accessbox.setSelectedIndex(0);
        }
        else if (accesslevel.equalsIgnoreCase("Member")) {
            accessbox.setSelectedIndex(1);
        }
    }//GEN-LAST:event_admintMouseClicked

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        // TODO add your handling code here:
         programexit = new JFrame("Exit");
       if (JOptionPane.showConfirmDialog(programexit, "LOG-OUT?", "PROGRAM", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
          try{
           new adminlogin().setVisible(true);
           this.setVisible(false);
           cloud9.close();
          }
          catch (Exception D) {
              JOptionPane.showMessageDialog(null, "Connection Was Not Closed!");
          }
          
       }
    }//GEN-LAST:event_exitActionPerformed

    private void memid1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_memid1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_memid1MouseClicked

    private void memid1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memid1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_memid1ActionPerformed

    private void searchconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchconMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_searchconMouseClicked

    private void searchconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchconActionPerformed
        // TODO add your handling code here:

        if (searchcon.getSelectedIndex()==1) {
            condition = "login_id";
        }
        else if (searchcon.getSelectedIndex()==2) {
            condition = "member_id";
        }
        else if (searchcon.getSelectedIndex()==3) {
            condition = "access_level";
        }
        else if (searchcon.getSelectedIndex()==4) {
            condition = "username";
        }
        else if (searchcon.getSelectedIndex()==5) {
            condition = "password";
        }

    }//GEN-LAST:event_searchconActionPerformed

    private void reset1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset1ActionPerformed
        // TODO add your handling code here:
        memid1.setText("");
        logid.setText("");
        userbox.setText("");
        passbox.setText("");
        admint.setAutoCreateRowSorter(false);
        admint.setAutoCreateRowSorter(true);
        loadloginbase();
        getmembercount();
    }//GEN-LAST:event_reset1ActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cloud9 = DriverManager.getConnection(url, user, pass);
            call = cloud9.prepareStatement("UPDATE Member_login SET Member_ID =?, Access_level =?, username =?, password =? WHERE Login_ID =?");
            call.setObject(1, memid1.getText());
            call.setString(2, accessbox.getSelectedItem().toString());
            call.setString(3, userbox.getText());
            call.setString(4, passbox.getText());
            call.setObject(5, logid.getText());
            call.executeUpdate();
            JOptionPane.showMessageDialog(null, "LOGIN INFORMATION UPDATED");
            loadloginbase();
        }
        catch (Exception B) {
            JOptionPane.showMessageDialog(null, "LOGIN INFO UPDATE DATABASE FAILED");
        }
        
    }//GEN-LAST:event_updateActionPerformed

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
            java.util.logging.Logger.getLogger(ISITDatabaseRegistrator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
     
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ISITDatabaseRegistrator().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> accessbox;
    private javax.swing.JTextField address;
    private javax.swing.JTable admint;
    private javax.swing.JTextField birthday;
    private javax.swing.JButton delete;
    private javax.swing.JButton exit;
    private javax.swing.JTextField fname;
    private javax.swing.JComboBox<String> genderbox;
    private javax.swing.JTextField idnum;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField lname;
    private javax.swing.JTextField logid;
    private javax.swing.JTextField memid;
    private javax.swing.JTextField memid1;
    private javax.swing.JTextField mname;
    private javax.swing.JTextField passbox;
    private javax.swing.JCheckBox pwdbox;
    private javax.swing.JButton registerlogin;
    private javax.swing.JButton registermember;
    private javax.swing.JButton reset;
    private javax.swing.JButton reset1;
    private javax.swing.JButton search;
    private javax.swing.JTextField searchbox;
    private javax.swing.JComboBox<String> searchcon;
    private javax.swing.JButton update;
    private javax.swing.JTextField userbox;
    private javax.swing.JComboBox<String> yearlevelbox;
    // End of variables declaration//GEN-END:variables
}
