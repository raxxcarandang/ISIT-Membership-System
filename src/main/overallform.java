/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package group9.database2;
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
 * @GROUP9:
Lead Programmer
Carandang, Raxx Morenz R.

Database-Managers:
Villanueva, Marie Paula Joy Z.
Gazzingan, Michael Angelo C. 

Documentation-Managers:
Quindoza, Maxine Anne P.
Moises, Pearlyn V.

 */
public class overallform extends javax.swing.JFrame {
JFrame programexit;
int count = 0;
int count1 = 0;
int count2 = 0;
int count3 = 0;
int count4 = 0;
int count5 = 0;
int rcounter = 0;
int rcounter1 = 0;
int rcounter2 = 0;
int rcounter3 = 0;
int rcounter4 = 0;
int rcounter5 = 0;
int searchtype = 0;
String pwd = "FALSE";
String membership = "";
String condition = "";
String condition1 = "";
String condition2 = "";
String condition3 = "";
String condition4 = "";
String condition5 = "";
String contacttype = "";
public JFrame deletion;
public static final String url = "jdbc:mysql://localhost:3306/ISITDatabase";
public static final String user = "root";
public static final String pass = "hackerman";
int ccounter = 0;
Connection cloud9 = null;
PreparedStatement call = null;
ResultSet output = null;
    /**
     * Creates new form overallform
     */
public void loadmemberbase()
{
    try{
    Class.forName("com.mysql.cj.jdbc.Driver");
    cloud9 = DriverManager.getConnection(url, user, pass);
    call = cloud9.prepareStatement("SELECT * FROM Member_info");
    output = call.executeQuery();
    ResultSetMetaData reqdata = output.getMetaData();
    count = reqdata.getColumnCount();
    DefaultTableModel RecordTable = (DefaultTableModel)infotable.getModel();
    RecordTable.setRowCount(0);
    
        while (output.next())
                {
                 Vector columninfo = new Vector();  
                 
                 for (int m =1; m<=count; m++) {
                     columninfo.add(output.getObject("Member_ID"));
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
                 rcounter = RecordTable.getRowCount();
        rcounter++;
        memid.setText("" +rcounter);
                }
        
    }
    catch (Exception M) {
        JOptionPane.showMessageDialog(null, "MEMBER INFO DATABASE CONNECTION ERROR");
    }

}

public void searchmemberbase()
{
    try{
    Class.forName("com.mysql.cj.jdbc.Driver");
    cloud9 = DriverManager.getConnection(url, user, pass);
    call = cloud9.prepareStatement("SELECT * FROM Member_info WHERE " + condition + " LIKE " + "\"%" + searchbox.getText() + "%\"");
    output = call.executeQuery();
    ResultSetMetaData reqdata = output.getMetaData();
    count = reqdata.getColumnCount();
    
    DefaultTableModel RecordTable = (DefaultTableModel)infotable.getModel();
    RecordTable.setRowCount(0);
    
        while (output.next())
                {
                 Vector columninfo = new Vector();  
                 
                 for (int m =1; m<=count; m++) {
                     columninfo.add(output.getObject("Member_ID"));
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
    }
    catch (Exception M) {
        JOptionPane.showMessageDialog(null, "MEMBER INFO DATABASE SEARCH ERROR");
    }
}

//Method for loading or getting the data from the database's guardian_info table
public void loadguardianbase()
{
    try{
    Class.forName("com.mysql.cj.jdbc.Driver");
    cloud9 = DriverManager.getConnection(url, user, pass);
    call = cloud9.prepareStatement("SELECT * FROM Guardian_info");
    output = call.executeQuery();
    ResultSetMetaData reqdata = output.getMetaData();
    count1 = reqdata.getColumnCount();
    
    DefaultTableModel RecordTable1 = (DefaultTableModel)infotable1.getModel();
    RecordTable1.setRowCount(0);
    
        while (output.next())
                {
                 Vector columninfo1 = new Vector();  
                 
                 for (int g =1; g<=count1; g++) {
                     columninfo1.add(output.getObject("Guardian_Record"));
                     columninfo1.add(output.getObject("Member_ID"));
                     columninfo1.add(output.getObject("Guardian_ID"));
                     columninfo1.add(output.getString("First_Name"));
                     columninfo1.add(output.getString("Middle_Name"));
                     columninfo1.add(output.getString("Surname")); 
                     columninfo1.add(output.getString("Gender"));
                     columninfo1.add(output.getString("Address"));
                 }
                 RecordTable1.addRow(columninfo1);
                 rcounter1 = RecordTable1.getRowCount();
                    rcounter1++;
                guardid.setText("" +rcounter1);
                grec.setText("" +rcounter1);
                }
    }
    catch (Exception G) {
        JOptionPane.showMessageDialog(null, "GUARDIAN INFO DATABASE CONNECTION ERROR");
    }
}

public void searchguardianbase()
{
    try{
    Class.forName("com.mysql.cj.jdbc.Driver");
    cloud9 = DriverManager.getConnection(url, user, pass);
    call = cloud9.prepareStatement("SELECT * FROM Guardian_info WHERE " + condition + " LIKE " + "\"%" + searchbox.getText() + "%\"");
    output = call.executeQuery();
    ResultSetMetaData reqdata = output.getMetaData();
    count1 = reqdata.getColumnCount();
    
    DefaultTableModel RecordTable1 = (DefaultTableModel)infotable1.getModel();
    RecordTable1.setRowCount(0);
    
        while (output.next())
                {
                 Vector columninfo1 = new Vector();  
                 
                 for (int g =1; g<=count1; g++) {
                     columninfo1.add(output.getObject("Guardian_Record"));
                     columninfo1.add(output.getObject("Member_ID"));
                     columninfo1.add(output.getObject("Guardian_ID"));
                     columninfo1.add(output.getString("First_Name"));
                     columninfo1.add(output.getString("Middle_Name"));
                     columninfo1.add(output.getString("Surname")); 
                     columninfo1.add(output.getString("Gender"));
                     columninfo1.add(output.getString("Address"));
                 }
                 RecordTable1.addRow(columninfo1);
                 
                }
    }
    catch (Exception G) {
        JOptionPane.showMessageDialog(null, "GUARDIAN INFO DATABASE SEARCH ERROR");
    }
}

//Method for loading or getting the data from the database's organization_info table
public void loadorganizationbase()
{
    try{
    Class.forName("com.mysql.cj.jdbc.Driver");
    cloud9 = DriverManager.getConnection(url, user, pass);
    call = cloud9.prepareStatement("SELECT * FROM Organization_info");
    output = call.executeQuery();
    ResultSetMetaData reqdata = output.getMetaData();
    count2 = reqdata.getColumnCount();
    
    DefaultTableModel RecordTable2 = (DefaultTableModel)infotable2.getModel();
    RecordTable2.setRowCount(0);
    
        while (output.next())
                {
                 Vector columninfo2 = new Vector();  
                 
                 for (int o =1; o<=count2; o++) {
                     columninfo2.add(output.getObject("Organization_Record"));
                     columninfo2.add(output.getObject("Member_ID"));
                     columninfo2.add(output.getObject("Organization_ID"));
                     columninfo2.add(output.getString("Organization_Name"));
                     columninfo2.add(output.getString("Organization_Address"));
                     columninfo2.add(output.getString("Membership_Status")); 
                     columninfo2.add(output.getString("Join_Date"));
                 }
                 RecordTable2.addRow(columninfo2);
                 rcounter2 = RecordTable2.getRowCount();
                    rcounter2++;
                orgrec.setText("" +rcounter2);
                
                }
    }
    catch (Exception G) {
        JOptionPane.showMessageDialog(null, "ORGANIZATION INFO DATABASE CONNECTION ERROR");
    }
}

public void searchorganizationbase()
{
    try{
    Class.forName("com.mysql.cj.jdbc.Driver");
    cloud9 = DriverManager.getConnection(url, user, pass);
    call = cloud9.prepareStatement("SELECT * FROM Organization_info WHERE " + condition + " LIKE " + "\"%" + searchbox.getText() + "%\"");
    output = call.executeQuery();
    ResultSetMetaData reqdata = output.getMetaData();
    count2 = reqdata.getColumnCount();
    
    DefaultTableModel RecordTable2 = (DefaultTableModel)infotable2.getModel();
    RecordTable2.setRowCount(0);
    
        while (output.next())
                {
                 Vector columninfo2 = new Vector();  
                 
                 for (int o =1; o<=count2; o++) {
                     columninfo2.add(output.getObject("Organization_Record"));
                     columninfo2.add(output.getObject("Member_ID"));
                     columninfo2.add(output.getObject("Organization_ID"));
                     columninfo2.add(output.getString("Organization_Name"));
                     columninfo2.add(output.getString("Organization_Address"));
                     columninfo2.add(output.getString("Membership_Status")); 
                     columninfo2.add(output.getString("Join_Date"));
                 }
                 RecordTable2.addRow(columninfo2);
                 
                }
    }
    catch (Exception G) {
        JOptionPane.showMessageDialog(null, "ORGANIZATION INFO DATABASE SEARCH ERROR");
    }
}

//Method for loading or getting the data from the database's company_info table
public void loadcompanybase()
{
    try{
    Class.forName("com.mysql.cj.jdbc.Driver");
    cloud9 = DriverManager.getConnection(url, user, pass);
    call = cloud9.prepareStatement("SELECT * FROM Company_info");
    output = call.executeQuery();
    ResultSetMetaData reqdata = output.getMetaData();
    count3 = reqdata.getColumnCount();
    
    DefaultTableModel RecordTable3 = (DefaultTableModel)infotable3.getModel();
    RecordTable3.setRowCount(0);
    
        while (output.next())
                {
                 Vector columninfo3 = new Vector();  
                 
                 for (int c =1; c<=count3; c++) {
                     columninfo3.add(output.getObject("Company_Record"));
                     columninfo3.add(output.getObject("Member_ID"));
                     columninfo3.add(output.getObject("Company_ID"));
                     columninfo3.add(output.getString("Job"));
                     columninfo3.add(output.getString("Company_Name"));
                     columninfo3.add(output.getString("Company_Address"));
                 }
                 RecordTable3.addRow(columninfo3);
                 rcounter3 = RecordTable3.getRowCount();
                    rcounter3++;
                comrec.setText("" +rcounter3);
                }
    }
    catch (Exception C) {
        JOptionPane.showMessageDialog(null, "COMPANY INFO DATABASE CONNECTION ERROR");
    }
}

public void searchcompanybase()
{
    try{
    Class.forName("com.mysql.cj.jdbc.Driver");
    cloud9 = DriverManager.getConnection(url, user, pass);
    call = cloud9.prepareStatement("SELECT * FROM Company_info WHERE " + condition + " LIKE " + "\"%" + searchbox.getText() + "%\"");
    output = call.executeQuery();
    ResultSetMetaData reqdata = output.getMetaData();
    count3 = reqdata.getColumnCount();
    
    DefaultTableModel RecordTable3 = (DefaultTableModel)infotable3.getModel();
    RecordTable3.setRowCount(0);
    
        while (output.next())
                {
                 Vector columninfo3 = new Vector();  
                 
                 for (int c =1; c<=count3; c++) {
                     columninfo3.add(output.getObject("Company_Record"));
                     columninfo3.add(output.getObject("Member_ID"));
                     columninfo3.add(output.getObject("Company_ID"));
                     columninfo3.add(output.getString("Job"));
                     columninfo3.add(output.getString("Company_Name"));
                     columninfo3.add(output.getString("Company_Address"));
                 }
                 RecordTable3.addRow(columninfo3);
                 
                }
    }
    catch (Exception C) {
        JOptionPane.showMessageDialog(null, "COMPANY INFO DATABASE SEARCH ERROR");
    }
}

public void loadcontactbase()
{
    try{
    String empty = "N/A";
    Class.forName("com.mysql.cj.jdbc.Driver");
    cloud9 = DriverManager.getConnection(url, user, pass);
    call = cloud9.prepareStatement("SELECT * FROM Contact_info");
    output = call.executeQuery();
    ResultSetMetaData reqdata = output.getMetaData();
    count4 = reqdata.getColumnCount();
    
    DefaultTableModel RecordTable4 = (DefaultTableModel)infotable4.getModel();
    RecordTable4.setRowCount(0);
    
        while (output.next())
                {
                 Vector columninfo4 = new Vector();  
                 
                 for (int c =1; c<=count4; c++) {
                     if ((output.getObject("Member_ID")==null))
                     {
                         columninfo4.add("N/A");
                     }
                     else
                     {
                     columninfo4.add(output.getObject("Member_ID"));
                     }
                      if ((output.getObject("Guardian_ID")==null))
                     {
                         columninfo4.add("N/A");
                     }
                     else
                     {
                     columninfo4.add(output.getObject("Guardian_ID")); 
                     }
                     columninfo4.add(output.getObject("Contact_ID")); 
                     columninfo4.add(output.getString("Phone_Number"));
                     columninfo4.add(output.getString("Email_Address"));
                 }
                 RecordTable4.addRow(columninfo4);
                 rcounter4 = RecordTable4.getRowCount();
                    rcounter4++;
                conid.setText("" +rcounter4);
                }
    }
    catch (Exception C) {
        JOptionPane.showMessageDialog(null, "CONTACT INFO DATABASE CONNECTION ERROR");
    }
}

public void searchcontactbase()
{
    try{
    Class.forName("com.mysql.cj.jdbc.Driver");
    cloud9 = DriverManager.getConnection(url, user, pass);
    call = cloud9.prepareStatement("SELECT * FROM Contact_info WHERE " + condition + " LIKE " + "\"%" + searchbox.getText() + "%\"");
    output = call.executeQuery();
    ResultSetMetaData reqdata = output.getMetaData();
    count4 = reqdata.getColumnCount();
    
    DefaultTableModel RecordTable4 = (DefaultTableModel)infotable4.getModel();
    RecordTable4.setRowCount(0);
    
        while (output.next())
                {
                 Vector columninfo4 = new Vector();  
                 
                 for (int c =1; c<=count4; c++) {
                     columninfo4.add(output.getObject("Member_ID"));
                     columninfo4.add(output.getObject("Guardian_ID"));
                     columninfo4.add(output.getObject("Contact_ID"));
                     columninfo4.add(output.getString("Phone_Number"));
                     columninfo4.add(output.getString("Email_Address"));
                 }
                 RecordTable4.addRow(columninfo4);
                 
                }
    }
    catch (Exception C) {
        JOptionPane.showMessageDialog(null, "CONTACT INFO DATABASE SEARCH ERROR");
    }
}

public void loadachievementbase()
{
    try{
    Class.forName("com.mysql.cj.jdbc.Driver");
    cloud9 = DriverManager.getConnection(url, user, pass);
    call = cloud9.prepareStatement("SELECT * FROM Achievement_info");
    output = call.executeQuery();
    ResultSetMetaData reqdata = output.getMetaData();
    count5 = reqdata.getColumnCount();
    
    DefaultTableModel RecordTable5 = (DefaultTableModel)infotable5.getModel();
    RecordTable5.setRowCount(0);
    
        while (output.next())
                {
                 Vector columninfo5 = new Vector();  
                 
                 for (int a =1; a<=count5; a++) {
                     columninfo5.add(output.getObject("Achievement_Record"));
                     columninfo5.add(output.getObject("Member_ID"));
                     columninfo5.add(output.getObject("Organization_ID"));
                     columninfo5.add(output.getObject("Achievement_ID"));
                     columninfo5.add(output.getString("Achievement"));
                     columninfo5.add(output.getString("Awarder")); 
                     columninfo5.add(output.getString("Award_Date"));
                 }
                 RecordTable5.addRow(columninfo5);
                 rcounter5 = RecordTable5.getRowCount();
                 rcounter5++;
                arecord.setText("" +rcounter5);
                }
    }
    catch (Exception G) {
        JOptionPane.showMessageDialog(null, "ACHIEVEMENT INFO DATABASE CONNECTION ERROR");
    }
}

public void searchachievementbase()
{
    try{
   Class.forName("com.mysql.cj.jdbc.Driver");
    cloud9 = DriverManager.getConnection(url, user, pass);
    call = cloud9.prepareStatement("SELECT * FROM Achievement_info WHERE " + condition + " LIKE " + "\"%" + searchbox.getText() + "%\"");
    output = call.executeQuery();
    ResultSetMetaData reqdata = output.getMetaData();
    count5 = reqdata.getColumnCount();
    
    DefaultTableModel RecordTable5 = (DefaultTableModel)infotable5.getModel();
    RecordTable5.setRowCount(0);
    
        while (output.next())
                {
                 Vector columninfo5 = new Vector();  
                 
                 for (int a =1; a<=count5; a++) {
                     columninfo5.add(output.getObject("Achievement_Record"));
                     columninfo5.add(output.getObject("Member_ID"));
                     columninfo5.add(output.getObject("Organization_ID"));
                     columninfo5.add(output.getObject("Achievement_ID"));
                     columninfo5.add(output.getString("Achievement"));
                     columninfo5.add(output.getString("Awarder")); 
                     columninfo5.add(output.getString("Award_Date"));
                 }
                 RecordTable5.addRow(columninfo5);
                 
                }
    }
    catch (Exception G) {
        JOptionPane.showMessageDialog(null, "ACHIEVEMENT INFO DATABASE SEARCH ERROR");
    }
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




    public overallform() {
        initComponents();
        loadmemberbase();
        loadguardianbase();
        loadcontactbase();
        loadorganizationbase();
        loadachievementbase();
        loadcompanybase();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel27 = new javax.swing.JLabel();
        memid = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        idnum = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
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
        pwdcheck = new javax.swing.JCheckBox();
        address = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        insert = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        grec = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        guardid = new javax.swing.JTextField();
        fname1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        mname1 = new javax.swing.JTextField();
        lname1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        genderbox1 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        address1 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        contype = new javax.swing.JComboBox<>();
        jLabel34 = new javax.swing.JLabel();
        phone = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        conid = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        orgrec = new javax.swing.JTextField();
        address2 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        orgid = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        orgname = new javax.swing.JTextField();
        memstatus = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        datejoined = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        arecord = new javax.swing.JTextField();
        achievementid = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        achievement = new javax.swing.JTextField();
        dateawarded = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        awarder = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        comrec = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        comaddress = new javax.swing.JTextField();
        comid = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        position = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        comname = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        manage = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        infotable = new javax.swing.JTable();
        memid4 = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        infotable1 = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        infotable4 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        infotable2 = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        infotable5 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        infotable3 = new javax.swing.JTable();
        searchcon = new javax.swing.JComboBox<>();
        searchbox = new javax.swing.JTextField();
        search = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("I.S.I.T MEMBERSHIP OVERALLFORM");
        setBackground(new java.awt.Color(0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.NW_RESIZE_CURSOR));
        getContentPane().setLayout(null);

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("MEMBER ID");
        getContentPane().add(jLabel27);
        jLabel27.setBounds(10, 450, 90, 16);

        memid.setForeground(new java.awt.Color(255, 255, 255));
        memid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        memid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
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
        getContentPane().add(memid);
        memid.setBounds(10, 470, 70, 17);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ID NUMBER");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(80, 450, 90, 16);

        idnum.setForeground(new java.awt.Color(255, 255, 255));
        idnum.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        idnum.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
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
        getContentPane().add(idnum);
        idnum.setBounds(90, 470, 80, 17);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("YEAR LEVEL");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(170, 450, 90, 16);

        yearlevelbox.setForeground(new java.awt.Color(255, 255, 255));
        yearlevelbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1ST YEAR", "2ND YEAR", "3RD YEAR", "4TH YEAR", "GRADUATED" }));
        yearlevelbox.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 51, 51)));
        getContentPane().add(yearlevelbox);
        yearlevelbox.setBounds(180, 470, 100, 26);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("FIRST NAME");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(280, 450, 90, 16);

        fname.setForeground(new java.awt.Color(255, 255, 255));
        fname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnameActionPerformed(evt);
            }
        });
        getContentPane().add(fname);
        fname.setBounds(290, 470, 170, 17);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("MIDDLE NAME");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(470, 450, 90, 16);

        mname.setForeground(new java.awt.Color(255, 255, 255));
        mname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        mname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
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
        getContentPane().add(mname);
        mname.setBounds(470, 470, 150, 17);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("LAST NAME");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(620, 450, 90, 16);

        lname.setForeground(new java.awt.Color(255, 255, 255));
        lname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnameActionPerformed(evt);
            }
        });
        getContentPane().add(lname);
        lname.setBounds(630, 470, 170, 17);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("GENDER");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(780, 450, 90, 16);

        genderbox.setForeground(new java.awt.Color(255, 255, 255));
        genderbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MALE", "FEMALE", "LGBTQIA+" }));
        genderbox.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 51, 51)));
        getContentPane().add(genderbox);
        genderbox.setBounds(810, 470, 90, 26);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("BIRTHDATE");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(890, 450, 100, 16);

        birthday.setForeground(new java.awt.Color(255, 255, 255));
        birthday.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        birthday.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        birthday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                birthdayActionPerformed(evt);
            }
        });
        getContentPane().add(birthday);
        birthday.setBounds(910, 470, 140, 17);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Ex. \"1999- 07- 14\"");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(930, 760, 170, 16);

        pwdcheck.setBackground(new java.awt.Color(0, 51, 102));
        pwdcheck.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        pwdcheck.setForeground(new java.awt.Color(255, 255, 255));
        pwdcheck.setText("PWD");
        pwdcheck.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pwdcheck.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                pwdcheckItemStateChanged(evt);
            }
        });
        pwdcheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwdcheckActionPerformed(evt);
            }
        });
        getContentPane().add(pwdcheck);
        pwdcheck.setBounds(1060, 460, 70, 27);

        address.setForeground(new java.awt.Color(255, 255, 255));
        address.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        address.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressActionPerformed(evt);
            }
        });
        getContentPane().add(address);
        address.setBounds(10, 510, 1120, 17);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ADDRESS");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 490, 100, 16);

        insert.setBackground(new java.awt.Color(0, 204, 0));
        insert.setFont(new java.awt.Font("Segoe UI", 1, 34)); // NOI18N
        insert.setForeground(new java.awt.Color(0, 0, 0));
        insert.setText("INSERT");
        insert.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertActionPerformed(evt);
            }
        });
        getContentPane().add(insert);
        insert.setBounds(60, 965, 200, 40);

        reset.setBackground(new java.awt.Color(255, 255, 0));
        reset.setFont(new java.awt.Font("Segoe UI", 1, 34)); // NOI18N
        reset.setForeground(new java.awt.Color(0, 0, 0));
        reset.setText("RESET");
        reset.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });
        getContentPane().add(reset);
        reset.setBounds(650, 965, 200, 40);

        exit.setBackground(new java.awt.Color(153, 153, 153));
        exit.setFont(new java.awt.Font("Segoe UI", 1, 34)); // NOI18N
        exit.setForeground(new java.awt.Color(0, 0, 0));
        exit.setText("LOG-OUT");
        exit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        getContentPane().add(exit);
        exit.setBounds(920, 965, 200, 40);

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("GUARDIAN RECORD #");
        getContentPane().add(jLabel29);
        jLabel29.setBounds(10, 540, 130, 16);

        grec.setForeground(new java.awt.Color(255, 255, 255));
        grec.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        grec.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(grec);
        grec.setBounds(10, 560, 120, 17);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("GUARDIAN ID");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(140, 540, 90, 16);

        guardid.setForeground(new java.awt.Color(255, 255, 255));
        guardid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        guardid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        guardid.setName(""); // NOI18N
        guardid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                guardidMouseClicked(evt);
            }
        });
        guardid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardidActionPerformed(evt);
            }
        });
        getContentPane().add(guardid);
        guardid.setBounds(140, 560, 100, 17);

        fname1.setForeground(new java.awt.Color(255, 255, 255));
        fname1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fname1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fname1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fname1ActionPerformed(evt);
            }
        });
        getContentPane().add(fname1);
        fname1.setBounds(250, 560, 230, 17);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("FIRST NAME");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(240, 540, 90, 16);

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("MIDDLE NAME");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(490, 540, 90, 16);

        mname1.setForeground(new java.awt.Color(255, 255, 255));
        mname1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        mname1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        mname1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mname1MouseClicked(evt);
            }
        });
        mname1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mname1ActionPerformed(evt);
            }
        });
        getContentPane().add(mname1);
        mname1.setBounds(490, 560, 230, 17);

        lname1.setForeground(new java.awt.Color(255, 255, 255));
        lname1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lname1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(lname1);
        lname1.setBounds(730, 560, 300, 17);

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("LAST NAME");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(720, 540, 90, 16);

        genderbox1.setForeground(new java.awt.Color(255, 255, 255));
        genderbox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MALE", "FEMALE", "LGBTQIA+" }));
        genderbox1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 51, 51)));
        getContentPane().add(genderbox1);
        genderbox1.setBounds(1040, 550, 90, 26);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("GENDER");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(1020, 530, 90, 16);

        address1.setForeground(new java.awt.Color(255, 255, 255));
        address1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        address1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        address1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                address1ActionPerformed(evt);
            }
        });
        getContentPane().add(address1);
        address1.setBounds(10, 600, 1120, 17);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("ADDRESS");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(10, 580, 100, 16);

        contype.setForeground(new java.awt.Color(255, 255, 255));
        contype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MEMBER" }));
        contype.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 51, 51)));
        contype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contypeActionPerformed(evt);
            }
        });
        getContentPane().add(contype);
        contype.setBounds(10, 640, 220, 26);

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText(" ID TYPE");
        getContentPane().add(jLabel34);
        jLabel34.setBounds(-30, 620, 150, 16);

        phone.setForeground(new java.awt.Color(255, 255, 255));
        phone.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        phone.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(phone);
        phone.setBounds(10, 690, 500, 17);

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("PHONE NUMBER");
        getContentPane().add(jLabel26);
        jLabel26.setBounds(0, 670, 150, 16);

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("EMAIL ADDRESS");
        getContentPane().add(jLabel35);
        jLabel35.setBounds(510, 670, 120, 16);

        email.setForeground(new java.awt.Color(255, 255, 255));
        email.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        email.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });
        getContentPane().add(email);
        email.setBounds(520, 690, 610, 17);

        conid.setForeground(new java.awt.Color(255, 255, 255));
        conid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        conid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        conid.setName(""); // NOI18N
        conid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                conidMouseClicked(evt);
            }
        });
        conid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conidActionPerformed(evt);
            }
        });
        getContentPane().add(conid);
        conid.setBounds(530, 650, 600, 17);

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("CONTACT ID");
        getContentPane().add(jLabel36);
        jLabel36.setBounds(490, 630, 150, 16);

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("ORGANIZATION RECORD #");
        getContentPane().add(jLabel30);
        jLabel30.setBounds(10, 720, 160, 16);

        orgrec.setForeground(new java.awt.Color(255, 255, 255));
        orgrec.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        orgrec.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(orgrec);
        orgrec.setBounds(10, 740, 150, 17);

        address2.setForeground(new java.awt.Color(255, 255, 255));
        address2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        address2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        address2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                address2ActionPerformed(evt);
            }
        });
        getContentPane().add(address2);
        address2.setBounds(10, 780, 1120, 17);

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("ORGANIZATION ADDRESS");
        getContentPane().add(jLabel19);
        jLabel19.setBounds(10, 760, 170, 16);

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("ORGANIZATION ID");
        getContentPane().add(jLabel33);
        jLabel33.setBounds(160, 720, 130, 16);

        orgid.setForeground(new java.awt.Color(255, 255, 255));
        orgid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        orgid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        orgid.setName(""); // NOI18N
        orgid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                orgidMouseClicked(evt);
            }
        });
        orgid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orgidActionPerformed(evt);
            }
        });
        getContentPane().add(orgid);
        orgid.setBounds(170, 740, 120, 17);

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("ORGANIZATION NAME");
        getContentPane().add(jLabel22);
        jLabel22.setBounds(290, 720, 150, 16);

        orgname.setForeground(new java.awt.Color(255, 255, 255));
        orgname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        orgname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(orgname);
        orgname.setBounds(300, 740, 430, 17);

        memstatus.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        memstatus.setForeground(new java.awt.Color(255, 255, 255));
        memstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MEMBER", "OFFICER", "PRESIDENT", "ADVISER", "ALUMNI", "DROPOUT", "EXPELLED", "EXPIRED", "PASSED AWAY" }));
        memstatus.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 51, 51)));
        memstatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memstatusActionPerformed(evt);
            }
        });
        getContentPane().add(memstatus);
        memstatus.setBounds(740, 730, 150, 30);

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("MEMBERSHIP STATUS");
        getContentPane().add(jLabel21);
        jLabel21.setBounds(740, 710, 125, 16);

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("DATE JOINED");
        getContentPane().add(jLabel31);
        jLabel31.setBounds(900, 720, 90, 16);

        datejoined.setForeground(new java.awt.Color(255, 255, 255));
        datejoined.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        datejoined.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(datejoined);
        datejoined.setBounds(900, 740, 230, 17);

        jLabel41.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("ACHIEVEMENT RECORD #");
        getContentPane().add(jLabel41);
        jLabel41.setBounds(10, 800, 150, 16);

        arecord.setForeground(new java.awt.Color(255, 255, 255));
        arecord.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        arecord.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(arecord);
        arecord.setBounds(10, 820, 180, 17);

        achievementid.setForeground(new java.awt.Color(255, 255, 255));
        achievementid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        achievementid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        achievementid.setName(""); // NOI18N
        achievementid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                achievementidMouseClicked(evt);
            }
        });
        achievementid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                achievementidActionPerformed(evt);
            }
        });
        getContentPane().add(achievementid);
        achievementid.setBounds(200, 820, 130, 17);

        jLabel45.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel45.setText("ACHIEVEMENT ID");
        getContentPane().add(jLabel45);
        jLabel45.setBounds(170, 800, 150, 16);

        jLabel43.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setText("ACHIEVEMENT ");
        getContentPane().add(jLabel43);
        jLabel43.setBounds(310, 800, 150, 16);

        achievement.setForeground(new java.awt.Color(255, 255, 255));
        achievement.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        achievement.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        achievement.setName(""); // NOI18N
        achievement.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                achievementMouseClicked(evt);
            }
        });
        achievement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                achievementActionPerformed(evt);
            }
        });
        getContentPane().add(achievement);
        achievement.setBounds(340, 820, 790, 17);

        dateawarded.setForeground(new java.awt.Color(255, 255, 255));
        dateawarded.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dateawarded.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        dateawarded.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateawardedActionPerformed(evt);
            }
        });
        getContentPane().add(dateawarded);
        dateawarded.setBounds(530, 860, 600, 17);

        jLabel42.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("DATE AWARDED");
        getContentPane().add(jLabel42);
        jLabel42.setBounds(500, 840, 150, 16);

        awarder.setForeground(new java.awt.Color(255, 255, 255));
        awarder.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        awarder.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(awarder);
        awarder.setBounds(10, 860, 510, 17);

        jLabel44.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText("AWARDER");
        getContentPane().add(jLabel44);
        jLabel44.setBounds(0, 840, 150, 16);

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("COMPANY RECORD #");
        getContentPane().add(jLabel24);
        jLabel24.setBounds(10, 880, 140, 16);

        comrec.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        comrec.setForeground(new java.awt.Color(255, 255, 255));
        comrec.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        comrec.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(comrec);
        comrec.setBounds(10, 900, 120, 21);

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("COMPANY ADDRESS");
        getContentPane().add(jLabel28);
        jLabel28.setBounds(10, 920, 120, 16);

        comaddress.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        comaddress.setForeground(new java.awt.Color(255, 255, 255));
        comaddress.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        comaddress.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        comaddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comaddressActionPerformed(evt);
            }
        });
        getContentPane().add(comaddress);
        comaddress.setBounds(10, 940, 1120, 21);

        comid.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        comid.setForeground(new java.awt.Color(255, 255, 255));
        comid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        comid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        comid.setName(""); // NOI18N
        comid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comidMouseClicked(evt);
            }
        });
        comid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comidActionPerformed(evt);
            }
        });
        getContentPane().add(comid);
        comid.setBounds(140, 900, 100, 21);

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("COMPANY ID");
        getContentPane().add(jLabel32);
        jLabel32.setBounds(130, 880, 110, 16);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("JOB");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(250, 880, 80, 16);

        position.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        position.setForeground(new java.awt.Color(255, 255, 255));
        position.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        position.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        position.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                positionActionPerformed(evt);
            }
        });
        getContentPane().add(position);
        position.setBounds(250, 900, 290, 21);

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("COMPANY NAME");
        getContentPane().add(jLabel25);
        jLabel25.setBounds(520, 880, 150, 16);

        comname.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        comname.setForeground(new java.awt.Color(255, 255, 255));
        comname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        comname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(comname);
        comname.setBounds(550, 900, 580, 21);

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Ex. \"1999- 07- 14\"");
        getContentPane().add(jLabel17);
        jLabel17.setBounds(890, 490, 170, 16);

        manage.setBackground(new java.awt.Color(0, 102, 255));
        manage.setFont(new java.awt.Font("Segoe UI", 1, 34)); // NOI18N
        manage.setForeground(new java.awt.Color(0, 0, 0));
        manage.setText("UPDATE");
        manage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        manage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageActionPerformed(evt);
            }
        });
        getContentPane().add(manage);
        manage.setBounds(360, 965, 200, 40);

        infotable.setAutoCreateRowSorter(true);
        infotable.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        infotable.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        infotable.setForeground(new java.awt.Color(255, 255, 255));
        infotable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MEMBER ID", "ID NUMBER", "YEAR LEVEL", "FIRST NAME", "MIDDLE NAME", "LAST NAME", "GENDER", "ADDRESS", "BIRTHDAY", "PWD"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        infotable.setAutoscrolls(false);
        infotable.setGridColor(new java.awt.Color(0, 255, 0));
        infotable.setSelectionBackground(new java.awt.Color(0, 204, 0));
        infotable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        infotable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        infotable.setShowGrid(true);
        infotable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                infotableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(infotable);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 30, 620, 80);

        memid4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        memid4.setForeground(new java.awt.Color(255, 255, 255));
        memid4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        memid4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        memid4.setName(""); // NOI18N
        memid4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                memid4MouseClicked(evt);
            }
        });
        memid4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memid4ActionPerformed(evt);
            }
        });
        getContentPane().add(memid4);
        memid4.setBounds(240, 650, 270, 20);

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("MEMBER/GUARDIAN ID");
        getContentPane().add(jLabel37);
        jLabel37.setBounds(230, 630, 160, 16);

        infotable1.setAutoCreateRowSorter(true);
        infotable1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        infotable1.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        infotable1.setForeground(new java.awt.Color(255, 255, 255));
        infotable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "GUARDIAN RECORD #", "MEMBER ID", "GUARDIAN ID", "FIRST NAME", "MIDDLE NAME", "LAST NAME", "GENDER", "ADDRESS"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        infotable1.setAutoscrolls(false);
        infotable1.setGridColor(new java.awt.Color(0, 255, 0));
        infotable1.setSelectionBackground(new java.awt.Color(0, 204, 0));
        infotable1.setSelectionForeground(new java.awt.Color(255, 255, 255));
        infotable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        infotable1.setShowGrid(true);
        infotable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                infotable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(infotable1);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(640, 30, 490, 80);

        infotable4.setAutoCreateRowSorter(true);
        infotable4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        infotable4.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        infotable4.setForeground(new java.awt.Color(255, 255, 255));
        infotable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MEMBER ID", "GUARDIAN ID", "CONTACT ID", "PHONE NUMBER", "E-MAIL ADDRESS"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
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
        infotable4.setAutoscrolls(false);
        infotable4.setGridColor(new java.awt.Color(0, 255, 0));
        infotable4.setSelectionBackground(new java.awt.Color(0, 204, 0));
        infotable4.setSelectionForeground(new java.awt.Color(255, 255, 255));
        infotable4.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        infotable4.setShowGrid(true);
        infotable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                infotable4MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(infotable4);

        getContentPane().add(jScrollPane5);
        jScrollPane5.setBounds(10, 110, 1120, 80);

        infotable2.setAutoCreateRowSorter(true);
        infotable2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        infotable2.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        infotable2.setForeground(new java.awt.Color(255, 255, 255));
        infotable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ORGANIZATION RECORD #", "MEMBER ID", "ORGANIZATION ID", "ORGANIZATION NAME", "ORGANIZATION ADDRESS", "MEMBERSHIP STATUS", "DATE JOINED"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        infotable2.setAutoscrolls(false);
        infotable2.setGridColor(new java.awt.Color(0, 255, 0));
        infotable2.setSelectionBackground(new java.awt.Color(0, 204, 0));
        infotable2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        infotable2.setShowGrid(true);
        infotable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                infotable2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(infotable2);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(10, 190, 1120, 90);

        infotable5.setAutoCreateRowSorter(true);
        infotable5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        infotable5.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        infotable5.setForeground(new java.awt.Color(255, 255, 255));
        infotable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ACHIEVEMENT RECORD #", "MEMBER ID", "ORGANIZATION ID", "ACHIEVEMENT ID", "ACHIEVEMENT", "AWARDER", "DATE AWARDED"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        infotable5.setAutoscrolls(false);
        infotable5.setGridColor(new java.awt.Color(0, 255, 0));
        infotable5.setSelectionBackground(new java.awt.Color(0, 204, 0));
        infotable5.setSelectionForeground(new java.awt.Color(255, 255, 255));
        infotable5.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        infotable5.setShowGrid(true);
        infotable5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                infotable5MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(infotable5);

        getContentPane().add(jScrollPane6);
        jScrollPane6.setBounds(10, 280, 1120, 80);

        infotable3.setAutoCreateRowSorter(true);
        infotable3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        infotable3.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        infotable3.setForeground(new java.awt.Color(255, 255, 255));
        infotable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "COMPANY RECORD #", "MEMBER ID", "COMPANY ID", "POSITION", "COMPANY NAME", "COMPANY ADDRESS"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        infotable3.setAutoscrolls(false);
        infotable3.setGridColor(new java.awt.Color(0, 255, 0));
        infotable3.setSelectionBackground(new java.awt.Color(0, 204, 0));
        infotable3.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        infotable3.setShowGrid(true);
        infotable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                infotable3MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(infotable3);

        getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(10, 360, 1120, 80);

        searchcon.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        searchcon.setForeground(new java.awt.Color(255, 255, 255));
        searchcon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MEMBER ID", " " }));
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
        getContentPane().add(searchcon);
        searchcon.setBounds(10, 5, 150, 20);

        searchbox.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        searchbox.setForeground(new java.awt.Color(255, 255, 255));
        searchbox.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        searchbox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(searchbox);
        searchbox.setBounds(170, 5, 860, 20);

        search.setBackground(new java.awt.Color(0, 0, 204));
        search.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        search.setForeground(new java.awt.Color(255, 255, 255));
        search.setText("SEARCH");
        search.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)));
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        getContentPane().add(search);
        search.setBounds(1030, 5, 100, 20);

        setBounds(0, 0, 1153, 606);
    }// </editor-fold>//GEN-END:initComponents

    private void memidMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_memidMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_memidMouseClicked

    private void memidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_memidActionPerformed

    private void idnumMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_idnumMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_idnumMouseClicked

    private void idnumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idnumActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_idnumActionPerformed

    private void fnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fnameActionPerformed

    private void mnameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnameMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_mnameMouseClicked

    private void mnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnameActionPerformed

    private void lnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lnameActionPerformed

    private void birthdayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_birthdayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_birthdayActionPerformed

    private void pwdcheckItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_pwdcheckItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_pwdcheckItemStateChanged

    private void pwdcheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwdcheckActionPerformed
        // TODO add your handling code here:
        if (pwdcheck.isSelected()){
            pwd = "TRUE";
        }
        else {
            pwd = "FALSE";
        }

    }//GEN-LAST:event_pwdcheckActionPerformed

    private void addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressActionPerformed

    private void insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertActionPerformed
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
            idnum.setText("");
            yearlevelbox.setSelectedIndex(0);
            fname.setText("");
            mname.setText("");
            lname.setText("");
            genderbox.setSelectedIndex(0);
            birthday.setText("");
            address.setText("");
            pwdcheck.setSelected(false);
            getmembercount();
        }
        catch (Exception A) {
            JOptionPane.showMessageDialog(null, "INSERT ERROR");
        }
        
         try{
    Class.forName("com.mysql.cj.jdbc.Driver");
    cloud9 = DriverManager.getConnection(url, user, pass);
    call = cloud9.prepareStatement("INSERT INTO Guardian_info (Guardian_Record, Member_ID, Guardian_ID, First_Name, Middle_Name, Surname, Gender, Address) VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
    call.setObject(1, grec.getText());
    call.setObject(2, memid.getText());
    call.setObject(3, guardid.getText());
    call.setString(4, fname1.getText());
    call.setString(5, mname1.getText());
    call.setString(6, lname1.getText());
    call.setString(7, genderbox1.getSelectedItem().toString());
    call.setString(8, address1.getText());
    call.executeUpdate();
        guardid.setText("");
        fname1.setText("");
        mname1.setText("");
        genderbox1.setSelectedIndex(0);
        address1.setText("");
    
        }
       catch (Exception B) {
           JOptionPane.showMessageDialog(null, "GUARDIAN INSERT ERROR");
       }
         
         try{
    Class.forName("com.mysql.cj.jdbc.Driver");
    cloud9 = DriverManager.getConnection(url, user, pass);
    call = cloud9.prepareStatement("INSERT INTO Contact_info (Member_ID, Guardian_ID, Contact_ID, Phone_Number, Email_Address) VALUES(?, ?, ?, ?, ?)");
    if (contype.getSelectedIndex()==0) {
    call.setObject(1, memid.getText());
    call.setString(2, null);
    call.setObject(3, conid.getText());
    call.setString(4, phone.getText());
    call.setString(5, email.getText());
    call.executeUpdate();
    contype.setSelectedIndex(0);
         conid.setText("");
         phone.setText("");
         email.setText("");
        }
         }
       catch (Exception C) {
           JOptionPane.showMessageDialog(null, "CONTACT INSERT ERROR");
       }
         
          try{
    Class.forName("com.mysql.cj.jdbc.Driver");
    cloud9 = DriverManager.getConnection(url, user, pass);
    call = cloud9.prepareStatement("INSERT INTO Organization_info (Member_ID, Organization_Record, Organization_ID, Organization_Name, Organization_Address, Membership_Status, Join_Date) VALUES( ?, ?, ?, ?, ?, ?, ?)");
    call.setObject(1, memid.getText());
    call.setObject(2, orgrec.getText());
    call.setObject(3, orgid.getText());
    call.setString(4, orgname.getText());
    call.setString(5, address2.getText());
    call.setString(6, memstatus.getSelectedItem().toString());
    call.setString(7, datejoined.getText());
    call.executeUpdate();
        orgid.setText("");
        orgname.setText("");
        address2.setText("");
        memstatus.setSelectedIndex(0);
        datejoined.setText("");
        }
       catch (Exception D) {
           JOptionPane.showMessageDialog(null, "ORGANIZATION INSERT ERROR");
       }
          
           try{
    Class.forName("com.mysql.cj.jdbc.Driver");
    cloud9 = DriverManager.getConnection(url, user, pass);
    call = cloud9.prepareStatement("INSERT INTO Achievement_info (Achievement_Record, Member_ID, Organization_ID, Achievement_ID, Achievement, Awarder, Award_Date) VALUES(?, ?, ?, ?, ?, ?, ?)");
    call.setObject(1, arecord.getText());
    call.setObject(2, memid.getText());
    call.setObject(3, orgid.getText());
    call.setString(4, achievementid.getText());
    call.setString(5, achievement.getText());
    call.setString(6, awarder.getText());
    call.setString(7, dateawarded.getText());
    call.executeUpdate();
        achievementid.setText("");
        achievement.setText("");
        awarder.setText("");
        dateawarded.setText("");
        
        }
       catch (Exception E) {
           JOptionPane.showMessageDialog(null, "ACHIEVEMENT INSERT ERROR");
       }
           
           try{
    Class.forName("com.mysql.cj.jdbc.Driver");
    cloud9 = DriverManager.getConnection(url, user, pass);
    call = cloud9.prepareStatement("INSERT INTO Company_info (Company_Record, Member_ID, Company_ID, Job, Company_Name, Company_Address) VALUES( ?, ?, ?, ?, ?, ?)");
    call.setObject(1, comrec.getText());
    call.setObject(2, memid.getText());
    call.setObject(3, comid.getText());
    call.setString(4, position.getText());
    call.setString(5, comname.getText());
    call.setString(6, comaddress.getText());
    call.executeUpdate();
        comid.setText("");
        position.setText("");
        comname.setText("");
        comaddress.setText("");
        JOptionPane.showMessageDialog(null,"Whole Member Information Inserted!");
        }
       catch (Exception F) {
           JOptionPane.showMessageDialog(null, "COMPANY INSERT ERROR");
       }
    }//GEN-LAST:event_insertActionPerformed

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
        pwdcheck.setSelected(false);
        
        guardid.setText("");
        fname1.setText("");
        mname1.setText("");
        genderbox1.setSelectedIndex(0);
        address1.setText("");
 
         contype.setSelectedIndex(0);
         conid.setText("");
         phone.setText("");
         email.setText("");
     
        orgid.setText("");
        orgname.setText("");
        address2.setText("");
        memstatus.setSelectedIndex(0);
        datejoined.setText("");
     
        achievementid.setText("");
        achievement.setText("");
        awarder.setText("");
        dateawarded.setText("");
        
        comid.setText("");
        position.setText("");
        comname.setText("");
        comaddress.setText("");
    }//GEN-LAST:event_resetActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        // TODO add your handling code here:
        programexit = new JFrame("Exit");
        if (JOptionPane.showConfirmDialog(programexit, "ARE YOU SURE YOU WANT TO LOG-OUT?", "PROGRAM", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
            try{
                new group9login2().setVisible(true);
                this.dispose();
                cloud9.close();
            }
            catch (Exception D) {
                JOptionPane.showMessageDialog(null, "Connection Was Not Closed!");
            }
        }
    }//GEN-LAST:event_exitActionPerformed

    private void guardidMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guardidMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_guardidMouseClicked

    private void guardidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_guardidActionPerformed

    private void fname1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fname1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fname1ActionPerformed

    private void mname1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mname1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_mname1MouseClicked

    private void mname1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mname1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mname1ActionPerformed

    private void address1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_address1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_address1ActionPerformed

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void conidMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_conidMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_conidMouseClicked

    private void conidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_conidActionPerformed

    private void address2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_address2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_address2ActionPerformed

    private void orgidMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_orgidMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_orgidMouseClicked

    private void orgidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orgidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_orgidActionPerformed

    private void memstatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memstatusActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_memstatusActionPerformed

    private void achievementidMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_achievementidMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_achievementidMouseClicked

    private void achievementidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_achievementidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_achievementidActionPerformed

    private void achievementMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_achievementMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_achievementMouseClicked

    private void achievementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_achievementActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_achievementActionPerformed

    private void dateawardedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateawardedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateawardedActionPerformed

    private void comaddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comaddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comaddressActionPerformed

    private void comidMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comidMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_comidMouseClicked

    private void comidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comidActionPerformed

    private void positionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_positionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_positionActionPerformed

    private void manageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageActionPerformed
        // TODO add your handling code here:
        new group9v2().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_manageActionPerformed

    private void contypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contypeActionPerformed
        // TODO add your handling code here:
        contype.setEnabled(false);
    }//GEN-LAST:event_contypeActionPerformed

    private void infotableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_infotableMouseClicked
        // TODO add your handling code here:
        String statuspwd = "";
        String ylevel = "";
        String sex = "";
        DefaultTableModel RecordTable = (DefaultTableModel)infotable.getModel();
        int SelectedRows = infotable.getSelectedRow();
        int sortedrow = infotable.convertRowIndexToModel(SelectedRows);
        memid.setText(RecordTable.getValueAt(sortedrow, 0).toString());
        idnum.setText(RecordTable.getValueAt(sortedrow, 1).toString());
        ylevel = (RecordTable.getValueAt(sortedrow, 2).toString());
        fname.setText(RecordTable.getValueAt(sortedrow, 3).toString());
        mname.setText(RecordTable.getValueAt(sortedrow, 4).toString());
        lname.setText(RecordTable.getValueAt(sortedrow, 5).toString());
        sex = (RecordTable.getValueAt(sortedrow, 6).toString());
        address.setText(RecordTable.getValueAt(sortedrow, 7).toString());
        birthday.setText(RecordTable.getValueAt(sortedrow, 8).toString());
        statuspwd = (RecordTable.getValueAt(sortedrow, 9).toString());

        if (statuspwd.equalsIgnoreCase("TRUE"))
        {
            pwdcheck.setSelected(true);
        }
        else
        {
            pwdcheck.setSelected(false);
        }

        if (ylevel.equalsIgnoreCase("1ST YEAR")) {
            yearlevelbox.setSelectedIndex(0);
        }
        else  if (ylevel.equalsIgnoreCase("2ND YEAR")) {
            yearlevelbox.setSelectedIndex(1);
        }
        else  if (ylevel.equalsIgnoreCase("3RD YEAR")) {
            yearlevelbox.setSelectedIndex(2);
        }
        else  if (ylevel.equalsIgnoreCase("4TH YEAR")) {
            yearlevelbox.setSelectedIndex(3);
        }
        else  if (ylevel.equalsIgnoreCase("GRADUATED")) {
            yearlevelbox.setSelectedIndex(4);
        }
        else {
            yearlevelbox.setSelectedIndex(0);
        }

        if (sex.equalsIgnoreCase("MALE")) {
            genderbox.setSelectedIndex(0);
        }
        else  if (sex.equalsIgnoreCase("FEMALE")) {
            genderbox.setSelectedIndex(1);
        }

    }//GEN-LAST:event_infotableMouseClicked

    private void memid4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_memid4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_memid4MouseClicked

    private void memid4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memid4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_memid4ActionPerformed

    private void infotable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_infotable1MouseClicked
        // TODO add your handling code here:
        String sex1 = "";
        DefaultTableModel RecordTable1 = (DefaultTableModel)infotable1.getModel();
        int SelectedRows1 = infotable1.getSelectedRow();
        int sortedrow1 = infotable1.convertRowIndexToModel(SelectedRows1);
        grec.setText(RecordTable1.getValueAt(sortedrow1, 0).toString());
        memid.setText(RecordTable1.getValueAt(sortedrow1, 1).toString());
        guardid.setText(RecordTable1.getValueAt(sortedrow1, 2).toString());
        fname1.setText(RecordTable1.getValueAt(sortedrow1, 3).toString());
        mname1.setText(RecordTable1.getValueAt(sortedrow1, 4).toString());
        lname1.setText(RecordTable1.getValueAt(sortedrow1, 5).toString());
        sex1 = RecordTable1.getValueAt(sortedrow1, 6).toString();
        address1.setText(RecordTable1.getValueAt(sortedrow1, 7).toString());

        if (sex1.equalsIgnoreCase("MALE")) {
            genderbox1.setSelectedIndex(0);
        }
        else  if (sex1.equalsIgnoreCase("FEMALE")) {
            genderbox1.setSelectedIndex(1);
        }

    }//GEN-LAST:event_infotable1MouseClicked

    private void infotable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_infotable4MouseClicked
        // TODO add your handling code here:
        DefaultTableModel RecordTable4 = (DefaultTableModel)infotable4.getModel();
        int SelectedRows4 = infotable4.getSelectedRow();
        int sortedrow4 = infotable4.convertRowIndexToModel(SelectedRows4);
        if (RecordTable4.getValueAt(sortedrow4, 0) != "N/A") {
            contype.setSelectedIndex(0);
            memid4.setText(RecordTable4.getValueAt(sortedrow4, 0).toString());
        }
        else if (RecordTable4.getValueAt(sortedrow4, 1) != "N/A") {
            contype.setSelectedIndex(1);
            memid4.setText(RecordTable4.getValueAt(sortedrow4, 1).toString());
        }
        conid.setText(RecordTable4.getValueAt(sortedrow4, 2).toString());
        phone.setText(RecordTable4.getValueAt(sortedrow4, 3).toString());
        email.setText(RecordTable4.getValueAt(sortedrow4, 4).toString());

    }//GEN-LAST:event_infotable4MouseClicked

    private void infotable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_infotable2MouseClicked
        // TODO add your handling code here:
        DefaultTableModel RecordTable2 = (DefaultTableModel)infotable2.getModel();
        int SelectedRows2 = infotable2.getSelectedRow();
        int sortedrow2 = infotable2.convertRowIndexToModel(SelectedRows2);
        orgrec.setText(RecordTable2.getValueAt(sortedrow2, 0).toString());
        memid.setText(RecordTable2.getValueAt(sortedrow2, 1).toString());
        orgid.setText(RecordTable2.getValueAt(sortedrow2, 2).toString());
        orgname.setText(RecordTable2.getValueAt(sortedrow2, 3).toString());
        address2.setText(RecordTable2.getValueAt(sortedrow2, 4).toString());
        membership = (RecordTable2.getValueAt(sortedrow2, 5).toString());
        datejoined.setText(RecordTable2.getValueAt(sortedrow2, 6).toString());
        if (membership.equalsIgnoreCase("MEMBER")) {
            memstatus.setSelectedIndex(0);
        }
        else if (membership.equalsIgnoreCase("LEADER")) {
            memstatus.setSelectedIndex(1);
        }
        else if (membership.equalsIgnoreCase("PRESIDENT")) {
            memstatus.setSelectedIndex(2);
        }
        else if (membership.equalsIgnoreCase("ADVISER")) {
            memstatus.setSelectedIndex(3);
        }
        else if (membership.equalsIgnoreCase("ALUMNI")) {
            memstatus.setSelectedIndex(4);
        }
        else if (membership.equalsIgnoreCase("DROPOUT")) {
            memstatus.setSelectedIndex(5);
        }
        else if (membership.equalsIgnoreCase("EXPELLED")) {
            memstatus.setSelectedIndex(6);
        }
        else if (membership.equalsIgnoreCase("EXPIRED")) {
            memstatus.setSelectedIndex(7);
        }
        else if (membership.equalsIgnoreCase("PASSED AWAY")) {
            memstatus.setSelectedIndex(8);
        }
        else
        {
            memstatus.setSelectedIndex(0);
        }
    }//GEN-LAST:event_infotable2MouseClicked

    private void infotable5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_infotable5MouseClicked
        // TODO add your handling code here:
        DefaultTableModel RecordTable5 = (DefaultTableModel)infotable5.getModel();
        int SelectedRows5 = infotable5.getSelectedRow();
        int sortedrow5 = infotable5.convertRowIndexToModel(SelectedRows5);
        arecord.setText(RecordTable5.getValueAt(sortedrow5, 0).toString());
        memid.setText(RecordTable5.getValueAt(sortedrow5, 1).toString());
        orgid.setText(RecordTable5.getValueAt(sortedrow5, 2).toString());
        achievementid.setText(RecordTable5.getValueAt(sortedrow5, 3).toString());
        achievement.setText(RecordTable5.getValueAt(sortedrow5, 4).toString());
        awarder.setText(RecordTable5.getValueAt(sortedrow5, 5).toString());
        dateawarded.setText(RecordTable5.getValueAt(sortedrow5, 6).toString());
    }//GEN-LAST:event_infotable5MouseClicked

    private void infotable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_infotable3MouseClicked
        // TODO add your handling code here:
        DefaultTableModel RecordTable3 = (DefaultTableModel)infotable3.getModel();
        int SelectedRows3 = infotable3.getSelectedRow();
        int sortedrow3 = infotable3.convertRowIndexToModel(SelectedRows3);
        comrec.setText(RecordTable3.getValueAt(sortedrow3, 0).toString());
        memid.setText(RecordTable3.getValueAt(sortedrow3, 1).toString());
        comid.setText(RecordTable3.getValueAt(sortedrow3, 2).toString());
        position.setText(RecordTable3.getValueAt(sortedrow3, 3).toString());
        comname.setText(RecordTable3.getValueAt(sortedrow3, 4).toString());
        comaddress.setText(RecordTable3.getValueAt(sortedrow3, 5).toString());

    }//GEN-LAST:event_infotable3MouseClicked

    private void searchconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchconMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_searchconMouseClicked

    private void searchconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchconActionPerformed
        // TODO add your handling code here:

        if (searchcon.getSelectedIndex()==0) {
            condition = "member_id";
        }
        
    }//GEN-LAST:event_searchconActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:

        searchmemberbase();
        searchguardianbase();
        searchcontactbase();
        searchorganizationbase();
        searchachievementbase();
        searchcompanybase();

    }//GEN-LAST:event_searchActionPerformed

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
            java.util.logging.Logger.getLogger(group9v2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new overallform().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField achievement;
    private javax.swing.JTextField achievementid;
    private javax.swing.JTextField address;
    private javax.swing.JTextField address1;
    private javax.swing.JTextField address2;
    private javax.swing.JTextField arecord;
    private javax.swing.JTextField awarder;
    private javax.swing.JTextField birthday;
    private javax.swing.JTextField comaddress;
    private javax.swing.JTextField comid;
    private javax.swing.JTextField comname;
    private javax.swing.JTextField comrec;
    private javax.swing.JTextField conid;
    private javax.swing.JComboBox<String> contype;
    private javax.swing.JTextField dateawarded;
    private javax.swing.JTextField datejoined;
    private javax.swing.JTextField email;
    private javax.swing.JButton exit;
    private javax.swing.JTextField fname;
    private javax.swing.JTextField fname1;
    private javax.swing.JComboBox<String> genderbox;
    private javax.swing.JComboBox<String> genderbox1;
    private javax.swing.JTextField grec;
    private javax.swing.JTextField guardid;
    private javax.swing.JTextField idnum;
    private javax.swing.JTable infotable;
    private javax.swing.JTable infotable1;
    private javax.swing.JTable infotable2;
    private javax.swing.JTable infotable3;
    private javax.swing.JTable infotable4;
    private javax.swing.JTable infotable5;
    private javax.swing.JButton insert;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextField lname;
    private javax.swing.JTextField lname1;
    private javax.swing.JButton manage;
    private javax.swing.JTextField memid;
    private javax.swing.JTextField memid4;
    private javax.swing.JComboBox<String> memstatus;
    private javax.swing.JTextField mname;
    private javax.swing.JTextField mname1;
    private javax.swing.JTextField orgid;
    private javax.swing.JTextField orgname;
    private javax.swing.JTextField orgrec;
    private javax.swing.JTextField phone;
    private javax.swing.JTextField position;
    private javax.swing.JCheckBox pwdcheck;
    private javax.swing.JButton reset;
    private javax.swing.JButton search;
    private javax.swing.JTextField searchbox;
    private javax.swing.JComboBox<String> searchcon;
    private javax.swing.JComboBox<String> yearlevelbox;
    // End of variables declaration//GEN-END:variables
}
