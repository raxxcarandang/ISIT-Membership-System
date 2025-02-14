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
public class viewonly extends javax.swing.JFrame {

int count = 0;
int count1 = 0;
int count2 = 0;
int count3 = 0;
int count4 = 0;
int count5 = 0;
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
String url = "jdbc:mysql://localhost:3306/ISITDatabase";
String user = "root";
String pass = group9login2.pass;
int ccounter = 0;
Connection cloud9 = null;
PreparedStatement call = null;
ResultSet output = null;

//Method for loading or getting the data from the database's member_info table
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
    call = cloud9.prepareStatement("SELECT * FROM Member_info WHERE " + condition + " LIKE " + "\"" + searchbox.getText() + "%\"");
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
    call = cloud9.prepareStatement("SELECT * FROM Guardian_info WHERE " + condition1 + " LIKE " + "\"" + searchbox1.getText() + "%\"");
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
    call = cloud9.prepareStatement("SELECT * FROM Organization_info WHERE " + condition2 + " LIKE " + "\"" + searchbox2.getText() + "%\"");
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
    call = cloud9.prepareStatement("SELECT * FROM Company_info WHERE " + condition3 + " LIKE " + "\"" + searchbox3.getText() + "%\"");
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
                     if ((output.getString("Member_ID")==null))
                     {
                         columninfo4.add("N/A");
                     }
                     else
                     {
                     columninfo4.add(output.getString("Member_ID"));
                     }
                      if ((output.getString("Guardian_ID")==null))
                     {
                         columninfo4.add("N/A");
                     }
                     else
                     {
                     columninfo4.add(output.getString("Guardian_ID")); 
                     }
                     columninfo4.add(output.getString("Contact_ID")); 
                     columninfo4.add(output.getString("Phone_Number"));
                     columninfo4.add(output.getString("Email_Address"));
                 }
                 RecordTable4.addRow(columninfo4);
                 
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
    call = cloud9.prepareStatement("SELECT * FROM Contact_info WHERE " + condition4 + " LIKE " + "\"" + searchbox4.getText() + "%\"");
    output = call.executeQuery();
    ResultSetMetaData reqdata = output.getMetaData();
    count4 = reqdata.getColumnCount();
    
    DefaultTableModel RecordTable4 = (DefaultTableModel)infotable4.getModel();
    RecordTable4.setRowCount(0);
    
        while (output.next())
                {
                 Vector columninfo4 = new Vector();  
                 
                 for (int c =1; c<=count4; c++) {
                     columninfo4.add(output.getString("Member_ID"));
                     columninfo4.add(output.getString("Guardian_ID"));
                     columninfo4.add(output.getString("Contact_ID"));
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
                     columninfo5.add(output.getString("Achievement_Record"));
                     columninfo5.add(output.getString("Member_ID"));
                     columninfo5.add(output.getString("Organization_ID"));
                     columninfo5.add(output.getString("Achievement_ID"));
                     columninfo5.add(output.getString("Achievement"));
                     columninfo5.add(output.getString("Awarder")); 
                     columninfo5.add(output.getString("Award_Date"));
                 }
                 RecordTable5.addRow(columninfo5);
                 
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
    call = cloud9.prepareStatement("SELECT * FROM Achievement_info WHERE " + condition5 + " LIKE " + "\"" + searchbox5.getText() + "%\"");
    output = call.executeQuery();
    ResultSetMetaData reqdata = output.getMetaData();
    count5 = reqdata.getColumnCount();
    
    DefaultTableModel RecordTable5 = (DefaultTableModel)infotable5.getModel();
    RecordTable5.setRowCount(0);
    
        while (output.next())
                {
                 Vector columninfo5 = new Vector();  
                 
                 for (int a =1; a<=count5; a++) {
                     columninfo5.add(output.getString("Achievement_Record"));
                     columninfo5.add(output.getString("Member_ID"));
                     columninfo5.add(output.getString("Organization_ID"));
                     columninfo5.add(output.getString("Achievement_ID"));
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
    /**
     * Creates new form group9
     */
    public viewonly() {
        initComponents();
        insert.setEnabled(false);
        insert1.setEnabled(false);
        insert2.setEnabled(false);
        insert3.setEnabled(false);
        insert4.setEnabled(false);
        insert5.setEnabled(false);
        update.setEnabled(false);
        update1.setEnabled(false);
        update2.setEnabled(false);
        update3.setEnabled(false);
        update4.setEnabled(false);
        update5.setEnabled(false);
        delete.setEnabled(false);
        delete1.setEnabled(false);
        delete2.setEnabled(false);
        delete3.setEnabled(false);
        delete4.setEnabled(false);
        delete5.setEnabled(false);
        loadmemberbase();
        loadguardianbase();
        loadorganizationbase();
        loadcompanybase();
        loadcontactbase();
        loadachievementbase();
        getmembercount();
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

        jPanel7 = new javax.swing.JPanel();
        titlel1 = new javax.swing.JLabel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        infotable = new javax.swing.JTable();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        mname = new javax.swing.JTextField();
        lname = new javax.swing.JTextField();
        idnum = new javax.swing.JTextField();
        address = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        birthday = new javax.swing.JTextField();
        pwdcheck = new javax.swing.JCheckBox();
        fname = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        memid = new javax.swing.JTextField();
        insert = new javax.swing.JButton();
        yearlevelbox = new javax.swing.JComboBox<>();
        genderbox = new javax.swing.JComboBox<>();
        searchcon = new javax.swing.JComboBox<>();
        searchbox = new javax.swing.JTextField();
        search = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        infotable1 = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        fname1 = new javax.swing.JTextField();
        mname1 = new javax.swing.JTextField();
        guardid = new javax.swing.JTextField();
        insert1 = new javax.swing.JButton();
        update1 = new javax.swing.JButton();
        delete1 = new javax.swing.JButton();
        reset1 = new javax.swing.JButton();
        exit1 = new javax.swing.JButton();
        memid1 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        searchcon1 = new javax.swing.JComboBox<>();
        searchbox1 = new javax.swing.JTextField();
        search1 = new javax.swing.JButton();
        lname1 = new javax.swing.JTextField();
        genderbox1 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        address1 = new javax.swing.JTextField();
        grec = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        infotable4 = new javax.swing.JTable();
        searchcon4 = new javax.swing.JComboBox<>();
        searchbox4 = new javax.swing.JTextField();
        search4 = new javax.swing.JButton();
        phone = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        memid4 = new javax.swing.JTextField();
        insert4 = new javax.swing.JButton();
        update4 = new javax.swing.JButton();
        delete4 = new javax.swing.JButton();
        reset4 = new javax.swing.JButton();
        exit4 = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();
        conid = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        contype = new javax.swing.JComboBox<>();
        jLabel37 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        infotable2 = new javax.swing.JTable();
        memid2 = new javax.swing.JTextField();
        orgname = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        address2 = new javax.swing.JTextField();
        insert2 = new javax.swing.JButton();
        update2 = new javax.swing.JButton();
        delete2 = new javax.swing.JButton();
        reset2 = new javax.swing.JButton();
        exit2 = new javax.swing.JButton();
        memstatus = new javax.swing.JComboBox<>();
        orgid = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        datejoined = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        searchcon2 = new javax.swing.JComboBox<>();
        searchbox2 = new javax.swing.JTextField();
        search2 = new javax.swing.JButton();
        jLabel33 = new javax.swing.JLabel();
        orgrec = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        searchcon5 = new javax.swing.JComboBox<>();
        searchbox5 = new javax.swing.JTextField();
        search5 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        infotable5 = new javax.swing.JTable();
        dateawarded = new javax.swing.JTextField();
        delete5 = new javax.swing.JButton();
        reset5 = new javax.swing.JButton();
        exit5 = new javax.swing.JButton();
        update5 = new javax.swing.JButton();
        awarder = new javax.swing.JTextField();
        memid5 = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        insert5 = new javax.swing.JButton();
        jLabel40 = new javax.swing.JLabel();
        orgid2 = new javax.swing.JTextField();
        achievementid = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        achievement = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        arecord = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        infotable3 = new javax.swing.JTable();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        comname = new javax.swing.JTextField();
        comid = new javax.swing.JTextField();
        comaddress = new javax.swing.JTextField();
        insert3 = new javax.swing.JButton();
        update3 = new javax.swing.JButton();
        delete3 = new javax.swing.JButton();
        reset3 = new javax.swing.JButton();
        exit3 = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        memid3 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        searchcon3 = new javax.swing.JComboBox<>();
        searchbox3 = new javax.swing.JTextField();
        search3 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        position = new javax.swing.JTextField();
        comrec = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("INTEGRATED STUDENTS OF INFORMATION TECHNOLOGY MEMBERSHIP SYSTEM");
        setBackground(new java.awt.Color(0, 0, 0));
        setForeground(java.awt.Color.white);
        setIconImages(null);
        getContentPane().setLayout(null);

        jPanel7.setBackground(new java.awt.Color(25, 25, 112));
        jPanel7.setLayout(null);

        titlel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        titlel1.setForeground(new java.awt.Color(255, 255, 255));
        titlel1.setText("INTEGRATED STUDENTS OF INFORMATION TECHNOLOGY");
        jPanel7.add(titlel1);
        titlel1.setBounds(150, 0, 1000, 40);

        jTabbedPane4.setBackground(new java.awt.Color(137, 207, 240));
        jTabbedPane4.setForeground(new java.awt.Color(0, 0, 0));
        jTabbedPane4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTabbedPane4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(137, 207, 240));
        jPanel2.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(null);

        infotable.setAutoCreateRowSorter(true);
        infotable.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        infotable.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
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
        infotable.setSelectionBackground(new java.awt.Color(0, 255, 51));
        infotable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        infotable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        infotable.setShowGrid(true);
        infotable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                infotableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(infotable);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(10, 50, 1260, 260);

        update.setBackground(new java.awt.Color(51, 51, 255));
        update.setFont(new java.awt.Font("Segoe UI", 1, 34)); // NOI18N
        update.setForeground(new java.awt.Color(0, 0, 0));
        update.setText("UPDATE");
        update.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        jPanel2.add(update);
        update.setBounds(270, 440, 200, 55);

        delete.setBackground(new java.awt.Color(255, 0, 0));
        delete.setFont(new java.awt.Font("Segoe UI", 1, 34)); // NOI18N
        delete.setForeground(new java.awt.Color(0, 0, 0));
        delete.setText("DELETE");
        delete.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        jPanel2.add(delete);
        delete.setBounds(540, 440, 200, 55);

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
        jPanel2.add(reset);
        reset.setBounds(800, 440, 200, 55);

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
        jPanel2.add(exit);
        exit.setBounds(1070, 440, 200, 55);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ID NUMBER");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(80, 320, 90, 16);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ADDRESS");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(-10, 380, 100, 16);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("YEAR LEVEL");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(170, 320, 90, 16);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("FIRST NAME");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(280, 320, 90, 16);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("MIDDLE NAME");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(550, 320, 90, 16);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("LAST NAME");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(700, 320, 90, 16);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Ex. \"1999- 07- 14\"");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(1020, 370, 170, 20);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("GENDER");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(920, 320, 90, 16);

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
        jPanel2.add(mname);
        mname.setBounds(550, 340, 150, 30);

        lname.setForeground(new java.awt.Color(255, 255, 255));
        lname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnameActionPerformed(evt);
            }
        });
        jPanel2.add(lname);
        lname.setBounds(710, 340, 220, 30);

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
        jPanel2.add(idnum);
        idnum.setBounds(90, 340, 80, 30);

        address.setForeground(new java.awt.Color(255, 255, 255));
        address.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        address.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressActionPerformed(evt);
            }
        });
        jPanel2.add(address);
        address.setBounds(10, 400, 1240, 30);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("BIRTHDAY");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(1020, 320, 100, 16);

        birthday.setForeground(new java.awt.Color(255, 255, 255));
        birthday.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        birthday.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        birthday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                birthdayActionPerformed(evt);
            }
        });
        jPanel2.add(birthday);
        birthday.setBounds(1040, 340, 140, 30);

        pwdcheck.setBackground(new java.awt.Color(137, 207, 240));
        pwdcheck.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        pwdcheck.setForeground(new java.awt.Color(0, 0, 0));
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
        jPanel2.add(pwdcheck);
        pwdcheck.setBounds(1190, 340, 70, 27);

        fname.setForeground(new java.awt.Color(255, 255, 255));
        fname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnameActionPerformed(evt);
            }
        });
        jPanel2.add(fname);
        fname.setBounds(290, 340, 250, 30);

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 0, 0));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("MEMBER ID");
        jPanel2.add(jLabel27);
        jLabel27.setBounds(0, 320, 90, 16);

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
        jPanel2.add(memid);
        memid.setBounds(10, 340, 70, 30);

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
        jPanel2.add(insert);
        insert.setBounds(10, 440, 200, 55);

        yearlevelbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1ST YEAR", "2ND YEAR", "3RD YEAR", "4TH YEAR", "GRADUATED" }));
        yearlevelbox.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 51, 51)));
        jPanel2.add(yearlevelbox);
        yearlevelbox.setBounds(180, 340, 100, 30);

        genderbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MALE", "FEMALE" }));
        genderbox.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 51, 51)));
        jPanel2.add(genderbox);
        genderbox.setBounds(940, 340, 90, 30);

        searchcon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<SEARCH>", "MEMBER ID", "ID NUMBER", "YEAR LEVEL", "FIRST NAME", "MIDDLE NAME", "LAST NAME", "GENDER", "ADDRESS", "BIRTHDAY", "PWD" }));
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
        jPanel2.add(searchcon);
        searchcon.setBounds(10, 10, 150, 30);

        searchbox.setForeground(new java.awt.Color(255, 255, 255));
        searchbox.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        searchbox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(searchbox);
        searchbox.setBounds(170, 10, 1000, 30);

        search.setBackground(new java.awt.Color(0, 0, 204));
        search.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        search.setForeground(new java.awt.Color(255, 255, 255));
        search.setText("SEARCH");
        search.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)));
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        jPanel2.add(search);
        search.setBounds(1160, 10, 100, 30);

        jTabbedPane4.addTab("            MEMBER           ", jPanel2);

        jPanel3.setBackground(new java.awt.Color(137, 207, 240));
        jPanel3.setLayout(null);

        infotable1.setAutoCreateRowSorter(true);
        infotable1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        infotable1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
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
        infotable1.setSelectionBackground(new java.awt.Color(0, 255, 51));
        infotable1.setSelectionForeground(new java.awt.Color(255, 255, 255));
        infotable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        infotable1.setShowGrid(true);
        infotable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                infotable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(infotable1);

        jPanel3.add(jScrollPane2);
        jScrollPane2.setBounds(10, 50, 1260, 260);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("GUARDIAN ID");
        jPanel3.add(jLabel12);
        jLabel12.setBounds(270, 320, 90, 16);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("ADDRESS");
        jPanel3.add(jLabel13);
        jLabel13.setBounds(-10, 380, 100, 16);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("FIRST NAME");
        jPanel3.add(jLabel14);
        jLabel14.setBounds(430, 320, 90, 16);

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("MIDDLE NAME");
        jPanel3.add(jLabel15);
        jLabel15.setBounds(690, 320, 90, 16);

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("LAST NAME");
        jPanel3.add(jLabel16);
        jLabel16.setBounds(920, 320, 90, 20);

        fname1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fname1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fname1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fname1ActionPerformed(evt);
            }
        });
        jPanel3.add(fname1);
        fname1.setBounds(440, 340, 240, 30);

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
        jPanel3.add(mname1);
        mname1.setBounds(690, 340, 230, 30);

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
        jPanel3.add(guardid);
        guardid.setBounds(280, 340, 150, 30);

        insert1.setBackground(new java.awt.Color(0, 204, 0));
        insert1.setFont(new java.awt.Font("Segoe UI", 1, 34)); // NOI18N
        insert1.setForeground(new java.awt.Color(0, 0, 0));
        insert1.setText("INSERT");
        insert1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        insert1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insert1ActionPerformed(evt);
            }
        });
        jPanel3.add(insert1);
        insert1.setBounds(20, 440, 200, 55);

        update1.setBackground(new java.awt.Color(51, 51, 255));
        update1.setFont(new java.awt.Font("Segoe UI", 1, 34)); // NOI18N
        update1.setForeground(new java.awt.Color(0, 0, 0));
        update1.setText("UPDATE");
        update1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        update1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update1ActionPerformed(evt);
            }
        });
        jPanel3.add(update1);
        update1.setBounds(270, 440, 200, 55);

        delete1.setBackground(new java.awt.Color(255, 0, 0));
        delete1.setFont(new java.awt.Font("Segoe UI", 1, 34)); // NOI18N
        delete1.setForeground(new java.awt.Color(0, 0, 0));
        delete1.setText("DELETE");
        delete1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        delete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete1ActionPerformed(evt);
            }
        });
        jPanel3.add(delete1);
        delete1.setBounds(540, 440, 200, 55);

        reset1.setBackground(new java.awt.Color(255, 255, 0));
        reset1.setFont(new java.awt.Font("Segoe UI", 1, 34)); // NOI18N
        reset1.setForeground(new java.awt.Color(0, 0, 0));
        reset1.setText("RESET");
        reset1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        reset1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset1ActionPerformed(evt);
            }
        });
        jPanel3.add(reset1);
        reset1.setBounds(800, 440, 200, 55);

        exit1.setBackground(new java.awt.Color(153, 153, 153));
        exit1.setFont(new java.awt.Font("Segoe UI", 1, 34)); // NOI18N
        exit1.setForeground(new java.awt.Color(0, 0, 0));
        exit1.setText("LOG-OUT");
        exit1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        exit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit1ActionPerformed(evt);
            }
        });
        jPanel3.add(exit1);
        exit1.setBounds(1060, 440, 200, 55);

        memid1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        memid1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(memid1);
        memid1.setBounds(160, 340, 110, 30);

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 0, 0));
        jLabel29.setText("GUARDIAN RECORD #");
        jPanel3.add(jLabel29);
        jLabel29.setBounds(10, 320, 130, 16);

        searchcon1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<SEARCH>", "GUARDIAN RECORD#", "MEMBER ID", "GUARDIAN ID", "FIRST NAME", "MIDDLE NAME", "LAST NAME", "GENDER", "ADDRESS" }));
        searchcon1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchcon1ActionPerformed(evt);
            }
        });
        jPanel3.add(searchcon1);
        searchcon1.setBounds(10, 10, 150, 30);

        searchbox1.setForeground(new java.awt.Color(255, 255, 255));
        searchbox1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        searchbox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbox1ActionPerformed(evt);
            }
        });
        jPanel3.add(searchbox1);
        searchbox1.setBounds(170, 10, 1000, 30);

        search1.setBackground(new java.awt.Color(0, 0, 204));
        search1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        search1.setForeground(new java.awt.Color(255, 255, 255));
        search1.setText("SEARCH");
        search1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)));
        search1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search1ActionPerformed(evt);
            }
        });
        jPanel3.add(search1);
        search1.setBounds(1160, 10, 100, 30);

        lname1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lname1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(lname1);
        lname1.setBounds(930, 340, 240, 30);

        genderbox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MALE", "FEMALE" }));
        genderbox1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 51, 51)));
        jPanel3.add(genderbox1);
        genderbox1.setBounds(1180, 340, 90, 30);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("GENDER");
        jPanel3.add(jLabel10);
        jLabel10.setBounds(1160, 320, 90, 16);

        address1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        address1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        address1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                address1ActionPerformed(evt);
            }
        });
        jPanel3.add(address1);
        address1.setBounds(10, 400, 1260, 30);

        grec.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        grec.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(grec);
        grec.setBounds(10, 340, 140, 30);

        jLabel46.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(0, 0, 0));
        jLabel46.setText("MEMBER ID");
        jPanel3.add(jLabel46);
        jLabel46.setBounds(160, 320, 70, 16);

        jTabbedPane4.addTab("         GUARDIAN        ", jPanel3);

        jPanel1.setBackground(new java.awt.Color(137, 207, 240));
        jPanel1.setLayout(null);

        infotable4.setAutoCreateRowSorter(true);
        infotable4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        infotable4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
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
        infotable4.setSelectionBackground(new java.awt.Color(0, 255, 51));
        infotable4.setSelectionForeground(new java.awt.Color(255, 255, 255));
        infotable4.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        infotable4.setShowGrid(true);
        infotable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                infotable4MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(infotable4);

        jPanel1.add(jScrollPane5);
        jScrollPane5.setBounds(10, 50, 1260, 260);

        searchcon4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<SEARCH>", "MEMBER ID", "GUARDIAN ID", "CONTACT ID", "PHONE NUMBER", "E-MAIL ADDRESS" }));
        searchcon4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchcon4ActionPerformed(evt);
            }
        });
        jPanel1.add(searchcon4);
        searchcon4.setBounds(10, 10, 150, 30);

        searchbox4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(searchbox4);
        searchbox4.setBounds(170, 10, 1000, 30);

        search4.setBackground(new java.awt.Color(0, 0, 204));
        search4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        search4.setForeground(new java.awt.Color(255, 255, 255));
        search4.setText("SEARCH");
        search4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)));
        search4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search4ActionPerformed(evt);
            }
        });
        jPanel1.add(search4);
        search4.setBounds(1160, 10, 100, 30);

        phone.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        phone.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(phone);
        phone.setBounds(10, 400, 630, 30);

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 0, 0));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("PHONE NUMBER");
        jPanel1.add(jLabel26);
        jLabel26.setBounds(-20, 380, 150, 16);

        email.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        email.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });
        jPanel1.add(email);
        email.setBounds(660, 400, 610, 30);

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(0, 0, 0));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText(" ID TYPE");
        jPanel1.add(jLabel34);
        jLabel34.setBounds(-40, 320, 150, 16);

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
        jPanel1.add(memid4);
        memid4.setBounds(240, 340, 400, 30);

        insert4.setBackground(new java.awt.Color(0, 204, 0));
        insert4.setFont(new java.awt.Font("Segoe UI", 1, 34)); // NOI18N
        insert4.setForeground(new java.awt.Color(0, 0, 0));
        insert4.setText("INSERT");
        insert4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        insert4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insert4ActionPerformed(evt);
            }
        });
        jPanel1.add(insert4);
        insert4.setBounds(10, 440, 200, 55);

        update4.setBackground(new java.awt.Color(51, 51, 255));
        update4.setFont(new java.awt.Font("Segoe UI", 1, 34)); // NOI18N
        update4.setForeground(new java.awt.Color(0, 0, 0));
        update4.setText("UPDATE");
        update4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        update4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update4ActionPerformed(evt);
            }
        });
        jPanel1.add(update4);
        update4.setBounds(270, 440, 200, 55);

        delete4.setBackground(new java.awt.Color(255, 0, 0));
        delete4.setFont(new java.awt.Font("Segoe UI", 1, 34)); // NOI18N
        delete4.setForeground(new java.awt.Color(0, 0, 0));
        delete4.setText("DELETE");
        delete4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        delete4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete4ActionPerformed(evt);
            }
        });
        jPanel1.add(delete4);
        delete4.setBounds(540, 440, 200, 55);

        reset4.setBackground(new java.awt.Color(255, 255, 0));
        reset4.setFont(new java.awt.Font("Segoe UI", 1, 34)); // NOI18N
        reset4.setForeground(new java.awt.Color(0, 0, 0));
        reset4.setText("RESET");
        reset4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        reset4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset4ActionPerformed(evt);
            }
        });
        jPanel1.add(reset4);
        reset4.setBounds(800, 440, 200, 55);

        exit4.setBackground(new java.awt.Color(153, 153, 153));
        exit4.setFont(new java.awt.Font("Segoe UI", 1, 34)); // NOI18N
        exit4.setForeground(new java.awt.Color(0, 0, 0));
        exit4.setText("LOG-OUT");
        exit4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        exit4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit4ActionPerformed(evt);
            }
        });
        jPanel1.add(exit4);
        exit4.setBounds(1060, 440, 200, 55);

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(0, 0, 0));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("EMAIL ADDRESS");
        jPanel1.add(jLabel35);
        jLabel35.setBounds(650, 380, 120, 16);

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
        jPanel1.add(conid);
        conid.setBounds(660, 340, 610, 30);

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(0, 0, 0));
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("CONTACT ID");
        jPanel1.add(jLabel36);
        jLabel36.setBounds(620, 320, 150, 20);

        contype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MEMBER", "GUARDIAN" }));
        contype.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 51, 51)));
        contype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contypeActionPerformed(evt);
            }
        });
        jPanel1.add(contype);
        contype.setBounds(10, 340, 220, 30);

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(0, 0, 0));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("MEMBER/GUARDIAN ID");
        jPanel1.add(jLabel37);
        jLabel37.setBounds(230, 320, 150, 16);

        jTabbedPane4.addTab("        CONTACT          ", jPanel1);

        jPanel4.setBackground(new java.awt.Color(137, 207, 240));
        jPanel4.setLayout(null);

        infotable2.setAutoCreateRowSorter(true);
        infotable2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        infotable2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
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
        infotable2.setSelectionBackground(new java.awt.Color(0, 255, 51));
        infotable2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        infotable2.setShowGrid(true);
        infotable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                infotable2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(infotable2);

        jPanel4.add(jScrollPane3);
        jScrollPane3.setBounds(10, 50, 1260, 260);

        memid2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        memid2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        memid2.setName(""); // NOI18N
        memid2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memid2ActionPerformed(evt);
            }
        });
        jPanel4.add(memid2);
        memid2.setBounds(210, 340, 100, 30);

        orgname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        orgname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(orgname);
        orgname.setBounds(500, 340, 300, 30);

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("MEMBERSHIP STATUS");
        jPanel4.add(jLabel21);
        jLabel21.setBounds(810, 320, 125, 16);

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 0));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("ORGANIZATION NAME");
        jPanel4.add(jLabel22);
        jLabel22.setBounds(490, 320, 150, 16);

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 0, 0));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("MEMBER ID");
        jPanel4.add(jLabel23);
        jLabel23.setBounds(180, 320, 130, 16);

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("ORGANIZATION ADDRESS");
        jPanel4.add(jLabel19);
        jLabel19.setBounds(0, 380, 170, 16);

        address2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        address2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        address2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                address2ActionPerformed(evt);
            }
        });
        jPanel4.add(address2);
        address2.setBounds(10, 400, 1260, 30);

        insert2.setBackground(new java.awt.Color(0, 204, 0));
        insert2.setFont(new java.awt.Font("Segoe UI", 1, 34)); // NOI18N
        insert2.setForeground(new java.awt.Color(0, 0, 0));
        insert2.setText("INSERT");
        insert2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        insert2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insert2ActionPerformed(evt);
            }
        });
        jPanel4.add(insert2);
        insert2.setBounds(10, 440, 200, 55);

        update2.setBackground(new java.awt.Color(51, 51, 255));
        update2.setFont(new java.awt.Font("Segoe UI", 1, 34)); // NOI18N
        update2.setForeground(new java.awt.Color(0, 0, 0));
        update2.setText("UPDATE");
        update2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        update2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update2ActionPerformed(evt);
            }
        });
        jPanel4.add(update2);
        update2.setBounds(270, 440, 200, 55);

        delete2.setBackground(new java.awt.Color(255, 0, 0));
        delete2.setFont(new java.awt.Font("Segoe UI", 1, 34)); // NOI18N
        delete2.setForeground(new java.awt.Color(0, 0, 0));
        delete2.setText("DELETE");
        delete2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        delete2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete2ActionPerformed(evt);
            }
        });
        jPanel4.add(delete2);
        delete2.setBounds(530, 440, 200, 55);

        reset2.setBackground(new java.awt.Color(255, 255, 0));
        reset2.setFont(new java.awt.Font("Segoe UI", 1, 34)); // NOI18N
        reset2.setForeground(new java.awt.Color(0, 0, 0));
        reset2.setText("RESET");
        reset2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        reset2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset2ActionPerformed(evt);
            }
        });
        jPanel4.add(reset2);
        reset2.setBounds(790, 440, 200, 55);

        exit2.setBackground(new java.awt.Color(153, 153, 153));
        exit2.setFont(new java.awt.Font("Segoe UI", 1, 34)); // NOI18N
        exit2.setForeground(new java.awt.Color(0, 0, 0));
        exit2.setText("LOG-OUT");
        exit2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        exit2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit2ActionPerformed(evt);
            }
        });
        jPanel4.add(exit2);
        exit2.setBounds(1060, 440, 200, 55);

        memstatus.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        memstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MEMBER", "OFFICER", "PRESIDENT", "ADVISER", "ALUMNI", "DROPOUT", "EXPELLED", "EXPIRED", "PASSED AWAY" }));
        memstatus.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 51, 51)));
        memstatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memstatusActionPerformed(evt);
            }
        });
        jPanel4.add(memstatus);
        memstatus.setBounds(810, 340, 160, 30);

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
        jPanel4.add(orgid);
        orgid.setBounds(320, 340, 170, 30);

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 0, 0));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("ORGANIZATION RECORD #");
        jPanel4.add(jLabel30);
        jLabel30.setBounds(0, 320, 160, 16);

        datejoined.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        datejoined.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(datejoined);
        datejoined.setBounds(980, 340, 290, 30);

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 0, 0));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("DATE JOINED");
        jPanel4.add(jLabel31);
        jLabel31.setBounds(970, 320, 90, 20);

        searchcon2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<SEARCH>", "ORGANIZATION RECORD #", "MEMBER ID", "ORGANIZATION ID", "ORGANIZATION NAME", "ORGANIZATION ADDRESS", "MEMBERSHIP STATUS", "DATE JOINED" }));
        searchcon2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchcon2ActionPerformed(evt);
            }
        });
        jPanel4.add(searchcon2);
        searchcon2.setBounds(10, 10, 150, 30);

        searchbox2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        searchbox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbox2ActionPerformed(evt);
            }
        });
        jPanel4.add(searchbox2);
        searchbox2.setBounds(170, 10, 1000, 30);

        search2.setBackground(new java.awt.Color(0, 0, 255));
        search2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        search2.setForeground(new java.awt.Color(255, 255, 255));
        search2.setText("SEARCH");
        search2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 153)));
        search2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search2ActionPerformed(evt);
            }
        });
        jPanel4.add(search2);
        search2.setBounds(1160, 10, 100, 30);

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 0, 0));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("ORGANIZATION ID");
        jPanel4.add(jLabel33);
        jLabel33.setBounds(310, 320, 130, 16);

        orgrec.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        orgrec.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(orgrec);
        orgrec.setBounds(10, 340, 190, 30);

        jTabbedPane4.addTab("        ORGANIZATION     ", jPanel4);

        jPanel6.setBackground(new java.awt.Color(137, 207, 240));
        jPanel6.setLayout(null);

        searchcon5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<SEARCH>", "ACHIEVEMENT RECORD #", "MEMBER ID", "ORGANIZATION ID", "ACHIEVEMENT ID", "ACHIEVEMENT", "AWARDER", "DATE AWARDED" }));
        searchcon5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchcon5ActionPerformed(evt);
            }
        });
        jPanel6.add(searchcon5);
        searchcon5.setBounds(10, 10, 150, 30);

        searchbox5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel6.add(searchbox5);
        searchbox5.setBounds(170, 10, 1000, 30);

        search5.setBackground(new java.awt.Color(0, 0, 255));
        search5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        search5.setForeground(new java.awt.Color(255, 255, 255));
        search5.setText("SEARCH");
        search5.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)));
        search5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search5ActionPerformed(evt);
            }
        });
        jPanel6.add(search5);
        search5.setBounds(1160, 10, 100, 30);

        infotable5.setAutoCreateRowSorter(true);
        infotable5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        infotable5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
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
        infotable5.setSelectionBackground(new java.awt.Color(0, 255, 51));
        infotable5.setSelectionForeground(new java.awt.Color(255, 255, 255));
        infotable5.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        infotable5.setShowGrid(true);
        infotable5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                infotable5MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(infotable5);

        jPanel6.add(jScrollPane6);
        jScrollPane6.setBounds(10, 50, 1260, 260);

        dateawarded.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dateawarded.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        dateawarded.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateawardedActionPerformed(evt);
            }
        });
        jPanel6.add(dateawarded);
        dateawarded.setBounds(610, 400, 660, 30);

        delete5.setBackground(new java.awt.Color(255, 0, 0));
        delete5.setFont(new java.awt.Font("Segoe UI", 1, 34)); // NOI18N
        delete5.setForeground(new java.awt.Color(0, 0, 0));
        delete5.setText("DELETE");
        delete5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        delete5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete5ActionPerformed(evt);
            }
        });
        jPanel6.add(delete5);
        delete5.setBounds(540, 440, 200, 55);

        reset5.setBackground(new java.awt.Color(255, 255, 0));
        reset5.setFont(new java.awt.Font("Segoe UI", 1, 34)); // NOI18N
        reset5.setForeground(new java.awt.Color(0, 0, 0));
        reset5.setText("RESET");
        reset5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        reset5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset5ActionPerformed(evt);
            }
        });
        jPanel6.add(reset5);
        reset5.setBounds(800, 440, 200, 55);

        exit5.setBackground(new java.awt.Color(153, 153, 153));
        exit5.setFont(new java.awt.Font("Segoe UI", 1, 34)); // NOI18N
        exit5.setForeground(new java.awt.Color(0, 0, 0));
        exit5.setText("LOG-OUT");
        exit5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        exit5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit5ActionPerformed(evt);
            }
        });
        jPanel6.add(exit5);
        exit5.setBounds(1060, 440, 200, 55);

        update5.setBackground(new java.awt.Color(51, 51, 255));
        update5.setFont(new java.awt.Font("Segoe UI", 1, 34)); // NOI18N
        update5.setForeground(new java.awt.Color(0, 0, 0));
        update5.setText("UPDATE");
        update5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        update5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update5ActionPerformed(evt);
            }
        });
        jPanel6.add(update5);
        update5.setBounds(270, 440, 200, 55);

        awarder.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        awarder.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel6.add(awarder);
        awarder.setBounds(10, 400, 590, 30);

        memid5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        memid5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        memid5.setName(""); // NOI18N
        memid5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                memid5MouseClicked(evt);
            }
        });
        memid5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memid5ActionPerformed(evt);
            }
        });
        jPanel6.add(memid5);
        memid5.setBounds(200, 340, 190, 30);

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(0, 0, 0));
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("MEMBER ID");
        jPanel6.add(jLabel38);
        jLabel38.setBounds(160, 320, 150, 16);

        insert5.setBackground(new java.awt.Color(0, 204, 0));
        insert5.setFont(new java.awt.Font("Segoe UI", 1, 34)); // NOI18N
        insert5.setForeground(new java.awt.Color(0, 0, 0));
        insert5.setText("INSERT");
        insert5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        insert5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insert5ActionPerformed(evt);
            }
        });
        jPanel6.add(insert5);
        insert5.setBounds(10, 440, 200, 55);

        jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(0, 0, 0));
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("ORGANIZATION ID");
        jPanel6.add(jLabel40);
        jLabel40.setBounds(380, 320, 150, 16);

        orgid2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        orgid2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        orgid2.setName(""); // NOI18N
        orgid2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                orgid2MouseClicked(evt);
            }
        });
        orgid2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orgid2ActionPerformed(evt);
            }
        });
        jPanel6.add(orgid2);
        orgid2.setBounds(400, 340, 160, 30);

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
        jPanel6.add(achievementid);
        achievementid.setBounds(570, 340, 190, 30);

        jLabel41.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(0, 0, 0));
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("ACHIEVEMENT RECORD #");
        jPanel6.add(jLabel41);
        jLabel41.setBounds(10, 320, 150, 16);

        jLabel42.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(0, 0, 0));
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("DATE AWARDED");
        jPanel6.add(jLabel42);
        jLabel42.setBounds(580, 380, 150, 16);

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
        jPanel6.add(achievement);
        achievement.setBounds(770, 340, 500, 30);

        jLabel43.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(0, 0, 0));
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setText("ACHIEVEMENT ");
        jPanel6.add(jLabel43);
        jLabel43.setBounds(740, 320, 150, 16);

        jLabel44.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(0, 0, 0));
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText("AWARDER");
        jPanel6.add(jLabel44);
        jLabel44.setBounds(-30, 380, 150, 16);

        jLabel45.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(0, 0, 0));
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel45.setText("ACHIEVEMENT ID");
        jPanel6.add(jLabel45);
        jLabel45.setBounds(540, 320, 150, 16);

        arecord.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        arecord.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel6.add(arecord);
        arecord.setBounds(10, 340, 180, 30);

        jTabbedPane4.addTab("        ACHIEVEMENT        ", jPanel6);

        jPanel5.setBackground(new java.awt.Color(137, 207, 240));
        jPanel5.setLayout(null);

        infotable3.setAutoCreateRowSorter(true);
        infotable3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        infotable3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
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
        infotable3.setSelectionBackground(new java.awt.Color(0, 255, 51));
        infotable3.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        infotable3.setShowGrid(true);
        infotable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                infotable3MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(infotable3);

        jPanel5.add(jScrollPane4);
        jScrollPane4.setBounds(10, 50, 1260, 260);

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 0, 0));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("COMPANY RECORD #");
        jPanel5.add(jLabel24);
        jLabel24.setBounds(0, 320, 140, 16);

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 0, 0));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("COMPANY NAME");
        jPanel5.add(jLabel25);
        jLabel25.setBounds(770, 320, 150, 16);

        comname.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        comname.setForeground(new java.awt.Color(255, 0, 0));
        comname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        comname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.add(comname);
        comname.setBounds(800, 340, 470, 30);

        comid.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        comid.setForeground(new java.awt.Color(255, 0, 0));
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
        jPanel5.add(comid);
        comid.setBounds(290, 340, 260, 30);

        comaddress.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        comaddress.setForeground(new java.awt.Color(255, 0, 0));
        comaddress.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        comaddress.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        comaddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comaddressActionPerformed(evt);
            }
        });
        jPanel5.add(comaddress);
        comaddress.setBounds(10, 400, 1260, 30);

        insert3.setBackground(new java.awt.Color(0, 204, 0));
        insert3.setFont(new java.awt.Font("Segoe UI", 1, 34)); // NOI18N
        insert3.setForeground(new java.awt.Color(0, 0, 0));
        insert3.setText("INSERT");
        insert3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        insert3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insert3ActionPerformed(evt);
            }
        });
        jPanel5.add(insert3);
        insert3.setBounds(10, 440, 200, 55);

        update3.setBackground(new java.awt.Color(51, 51, 255));
        update3.setFont(new java.awt.Font("Segoe UI", 1, 34)); // NOI18N
        update3.setForeground(new java.awt.Color(0, 0, 0));
        update3.setText("UPDATE");
        update3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        update3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update3ActionPerformed(evt);
            }
        });
        jPanel5.add(update3);
        update3.setBounds(270, 440, 200, 55);

        delete3.setBackground(new java.awt.Color(255, 0, 0));
        delete3.setFont(new java.awt.Font("Segoe UI", 1, 34)); // NOI18N
        delete3.setForeground(new java.awt.Color(0, 0, 0));
        delete3.setText("DELETE");
        delete3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        delete3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete3ActionPerformed(evt);
            }
        });
        jPanel5.add(delete3);
        delete3.setBounds(540, 440, 200, 55);

        reset3.setBackground(new java.awt.Color(255, 255, 0));
        reset3.setFont(new java.awt.Font("Segoe UI", 1, 34)); // NOI18N
        reset3.setForeground(new java.awt.Color(0, 0, 0));
        reset3.setText("RESET");
        reset3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        reset3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset3ActionPerformed(evt);
            }
        });
        jPanel5.add(reset3);
        reset3.setBounds(800, 440, 200, 55);

        exit3.setBackground(new java.awt.Color(153, 153, 153));
        exit3.setFont(new java.awt.Font("Segoe UI", 1, 34)); // NOI18N
        exit3.setForeground(new java.awt.Color(0, 0, 0));
        exit3.setText("LOG-OUT");
        exit3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        exit3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit3ActionPerformed(evt);
            }
        });
        jPanel5.add(exit3);
        exit3.setBounds(1060, 440, 200, 55);

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 0, 0));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("COMPANY ADDRESS");
        jPanel5.add(jLabel28);
        jLabel28.setBounds(10, 380, 120, 16);

        memid3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        memid3.setForeground(new java.awt.Color(255, 0, 0));
        memid3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        memid3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        memid3.setName(""); // NOI18N
        memid3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                memid3MouseClicked(evt);
            }
        });
        memid3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memid3ActionPerformed(evt);
            }
        });
        jPanel5.add(memid3);
        memid3.setBounds(140, 340, 140, 30);

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(0, 0, 0));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("COMPANY ID");
        jPanel5.add(jLabel32);
        jLabel32.setBounds(270, 320, 110, 16);

        searchcon3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<SEARCH>", "COMPANY RECORD #", "MEMBER ID", "COMPANY ID", "JOB", "COMPANY NAME", "COMPANY ADDRESS" }));
        searchcon3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchcon3ActionPerformed(evt);
            }
        });
        jPanel5.add(searchcon3);
        searchcon3.setBounds(10, 10, 150, 30);

        searchbox3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        searchbox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbox3ActionPerformed(evt);
            }
        });
        jPanel5.add(searchbox3);
        searchbox3.setBounds(170, 10, 1000, 30);

        search3.setBackground(new java.awt.Color(0, 0, 204));
        search3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        search3.setForeground(new java.awt.Color(255, 255, 255));
        search3.setText("SEARCH");
        search3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)));
        search3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search3ActionPerformed(evt);
            }
        });
        jPanel5.add(search3);
        search3.setBounds(1160, 10, 100, 30);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("JOB");
        jPanel5.add(jLabel8);
        jLabel8.setBounds(560, 320, 80, 16);

        position.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        position.setForeground(new java.awt.Color(255, 0, 0));
        position.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        position.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        position.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                positionActionPerformed(evt);
            }
        });
        jPanel5.add(position);
        position.setBounds(560, 340, 230, 30);

        comrec.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        comrec.setForeground(new java.awt.Color(255, 0, 0));
        comrec.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        comrec.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.add(comrec);
        comrec.setBounds(10, 340, 120, 30);

        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(0, 0, 0));
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("MEMBER ID");
        jPanel5.add(jLabel39);
        jLabel39.setBounds(120, 320, 110, 16);

        jTabbedPane4.addTab("         COMPANY         ", jPanel5);

        jPanel7.add(jTabbedPane4);
        jTabbedPane4.setBounds(0, 40, 1280, 560);

        getContentPane().add(jPanel7);
        jPanel7.setBounds(0, 0, 1280, 650);

        setSize(new java.awt.Dimension(1294, 637));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
private JFrame programexit;
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

    private void idnumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idnumActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_idnumActionPerformed

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
     searchbox.setText("");
     searchcon.setSelectedIndex(0);
     infotable.setRowSorter(null);
     infotable.setAutoCreateRowSorter(true);
     loadmemberbase();
    }//GEN-LAST:event_resetActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        // TODO add your handling code here:
        //String dbbday = year.getText() + "-" + month.getText() + "-" + day.getText();
        
        try{
    Class.forName("com.mysql.cj.jdbc.Driver");
    cloud9 = DriverManager.getConnection(url, user, pass);
    call = cloud9.prepareStatement("UPDATE Member_info SET ID_Number =?, Year_Level =?, First_Name =?, Middle_Name =?, Surname =?, Gender =?, Address =?, Birthdate =?, PWD =? WHERE Member_ID =?");
    
    call.setString(1, idnum.getText());
    call.setString(2, yearlevelbox.getSelectedItem().toString());
    call.setString(3, fname.getText());
    call.setString(4, mname.getText());
    call.setString(5, lname.getText());
    call.setString(6, genderbox.getSelectedItem().toString());
    call.setString(7, address.getText());
    call.setString(8, birthday.getText());
    call.setString(9, pwd);
    call.setString(10, memid.getText());
    call.executeUpdate();
    JOptionPane.showMessageDialog(null, "MEMBER INFORMATION UPDATED");
    loadmemberbase();
        }
       catch (Exception B) {
           JOptionPane.showMessageDialog(null, "MEMBER UPDATE ERROR");
       }
    }//GEN-LAST:event_updateActionPerformed

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
     else  if (sex.equalsIgnoreCase("LGBTQIA+")) {
         genderbox.setSelectedIndex(2);
     }
    }//GEN-LAST:event_infotableMouseClicked

    private void idnumMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_idnumMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_idnumMouseClicked

    private void mnameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnameMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_mnameMouseClicked

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(deletion, "DELETE MEMBER #" + memid.getText() + "?", "DELETION", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
        {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
    cloud9 = DriverManager.getConnection(url, user, pass);
    call = cloud9.prepareStatement("DELETE FROM Member_info WHERE Member_ID =?");
    call.setString(1, memid.getText());
    call.executeUpdate();
            JOptionPane.showMessageDialog(null, "MEMBER INFORMATION DELETED");
            loadmemberbase();
     memid.setText("");
     idnum.setText("");
     fname.setText("");
     mname.setText("");
     lname.setText("");
     genderbox.setSelectedIndex(0);
     birthday.setText("");
     address.setText("");
            }
        catch (Exception A) {
            JOptionPane.showMessageDialog(null, "MEMBER DELETION FAILED!");
                            }
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void infotable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_infotable1MouseClicked
        // TODO add your handling code here:
        String sex1 = "";
        DefaultTableModel RecordTable1 = (DefaultTableModel)infotable1.getModel();
        int SelectedRows1 = infotable1.getSelectedRow();
        int sortedrow1 = infotable1.convertRowIndexToModel(SelectedRows1);
     grec.setText(RecordTable1.getValueAt(sortedrow1, 0).toString());
     memid1.setText(RecordTable1.getValueAt(sortedrow1, 1).toString());
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
     else  if (sex1.equalsIgnoreCase("LGBTQIA+")) {
         genderbox1.setSelectedIndex(2);
     }
    }//GEN-LAST:event_infotable1MouseClicked

    private void mname1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mname1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_mname1MouseClicked

    private void guardidMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guardidMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_guardidMouseClicked

    private void guardidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_guardidActionPerformed

    private void addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressActionPerformed

    private void lnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lnameActionPerformed

    private void mnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnameActionPerformed

    private void insert1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insert1ActionPerformed
        // TODO add your handling code here:
        try{
    Class.forName("com.mysql.cj.jdbc.Driver");
    cloud9 = DriverManager.getConnection(url, user, pass);
    call = cloud9.prepareStatement("INSERT INTO Guardian_info (Guardian_Record, Member_ID, Guardian_ID, First_Name, Middle_Name, Surname, Gender, Address) VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
    call.setObject(1, grec.getText());
    call.setObject(2, memid1.getText());
    call.setObject(3, guardid.getText());
    call.setString(4, fname1.getText());
    call.setString(5, mname1.getText());
    call.setString(6, lname1.getText());
    call.setString(7, genderbox1.getSelectedItem().toString());
    call.setString(8, address1.getText());
    call.executeUpdate();
    JOptionPane.showMessageDialog(null, "GUARDIAN INFORMATION INSERTED");
    loadguardianbase();
        }
       catch (Exception B) {
           JOptionPane.showMessageDialog(null, "GUARDIAN INSERT ERROR");
       }
    }//GEN-LAST:event_insert1ActionPerformed

    private void update1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update1ActionPerformed
        // TODO add your handling code here:
        try{
    Class.forName("com.mysql.cj.jdbc.Driver");
    cloud9 = DriverManager.getConnection(url, user, pass);
    call = cloud9.prepareStatement("UPDATE Guardian_info SET Guardian_ID =?, Member_ID =?, First_Name =?, Middle_Name =?, Surname =?, Gender =?, Address =? WHERE Guardian_Record =?");
    call.setString(1, guardid.getText());
    call.setObject(2, memid1.getText());
    call.setString(3, fname1.getText());
    call.setString(4, mname1.getText());
    call.setString(5, lname1.getText());
    call.setString(6, genderbox1.getSelectedItem().toString());
    call.setString(7, address1.getText());
    call.setString(8, grec.getText());
    call.executeUpdate();
    JOptionPane.showMessageDialog(null, "GUARDIAN INFORMATION UPDATED");
    loadguardianbase();
        }
       catch (Exception B) {
           JOptionPane.showMessageDialog(null, "GUARDIAN UPDATE ERROR");
       }
    }//GEN-LAST:event_update1ActionPerformed

    private void delete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete1ActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(deletion, "DELETE GUARDIAN RECORD #" + grec.getText() + "?", "DELETION", JOptionPane.YES_NO_OPTION)== JOptionPane.YES_OPTION )
        {
            try {
            Class.forName("com.mysql.cj.jdbc.Driver");
    cloud9 = DriverManager.getConnection(url, user, pass);
    call = cloud9.prepareStatement("DELETE FROM Guardian_info WHERE Guardian_Record =?");
    call.setString(1, grec.getText());
    call.executeUpdate();
            JOptionPane.showMessageDialog(null, "GUARDIAN INFORMATION DELETED");
            loadguardianbase();
     memid1.setText("");
     guardid.setText("");
     fname1.setText("");
     mname1.setText("");
     genderbox1.setSelectedIndex(0);
     address1.setText("");
            }
        catch (Exception A) {
            JOptionPane.showMessageDialog(null, "GUARDIAN DELETION FAILED!");
                            }
        }
    }//GEN-LAST:event_delete1ActionPerformed

    private void reset1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset1ActionPerformed
        // TODO add your handling code here:
        memid1.setText("");
     guardid.setText("");
     fname1.setText("");
     mname1.setText("");
     genderbox1.setSelectedIndex(0);
     address1.setText("");
     searchbox1.setText("");
      infotable1.setRowSorter(null);
     infotable1.setAutoCreateRowSorter(true);
     loadguardianbase();
    }//GEN-LAST:event_reset1ActionPerformed

    private void exit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit1ActionPerformed
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
    }//GEN-LAST:event_exit1ActionPerformed

    private void mname1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mname1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mname1ActionPerformed

    private void infotable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_infotable2MouseClicked
        // TODO add your handling code here:
        DefaultTableModel RecordTable2 = (DefaultTableModel)infotable2.getModel();
        int SelectedRows2 = infotable2.getSelectedRow();
        int sortedrow2 = infotable2.convertRowIndexToModel(SelectedRows2);
     orgrec.setText(RecordTable2.getValueAt(sortedrow2, 0).toString());
     memid2.setText(RecordTable2.getValueAt(sortedrow2, 1).toString());
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
    
    private void memid2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memid2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_memid2ActionPerformed

    private void address2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_address2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_address2ActionPerformed

    private void insert2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insert2ActionPerformed
        // TODO add your handling code here:
        try{
    Class.forName("com.mysql.cj.jdbc.Driver");
    cloud9 = DriverManager.getConnection(url, user, pass);
    call = cloud9.prepareStatement("INSERT INTO Organization_info (Member_ID, Organization_Record, Organization_ID, Organization_Name, Organization_Address, Membership_Status, Join_Date) VALUES( ?, ?, ?, ?, ?, ?, ?)");
    call.setObject(1, memid2.getText());
    call.setObject(2, orgrec.getText());
    call.setObject(3, orgid.getText());
    call.setString(4, orgname.getText());
    call.setString(5, address2.getText());
    call.setString(6, memstatus.getSelectedItem().toString());
    call.setString(7, datejoined.getText());
    
    call.executeUpdate();
    JOptionPane.showMessageDialog(null, "ORGANIZATION INFORMATION INSERTED");
    loadorganizationbase();
        }
       catch (Exception B) {
           JOptionPane.showMessageDialog(null, "ORGANIZATION INSERT ERROR");
       }
    }//GEN-LAST:event_insert2ActionPerformed

    private void update2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update2ActionPerformed
        // TODO add your handling code here:
        try{
    Class.forName("com.mysql.cj.jdbc.Driver");
    cloud9 = DriverManager.getConnection(url, user, pass);
    call = cloud9.prepareStatement("UPDATE Organization_info SET Member_ID =?, Organization_ID =?, Organization_Name =?, Organization_Address =?, Membership_Status =?, Join_Date = ?  WHERE Organization_RECORD =?");
    call.setObject(1, memid2.getText());
    call.setString(2, orgid.getText());
    call.setString(3, orgname.getText());
    call.setString(4, address2.getText());
    call.setString(5, memstatus.getSelectedItem().toString());
    call.setString(6, datejoined.getText());
    call.setString(7, orgrec.getText());
    call.executeUpdate();
    JOptionPane.showMessageDialog(null, "ORGANIZATION INFORMATION UPDATED");
    loadorganizationbase();
        }
       catch (Exception B) {
           JOptionPane.showMessageDialog(null, "ORGANIZATION UPDATE ERROR");
       }
    }//GEN-LAST:event_update2ActionPerformed

    private void delete2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete2ActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(deletion, "DELETE ORGANIZATION RECORD #" + orgrec.getText() + "?", "DELETION", JOptionPane.YES_NO_OPTION)== JOptionPane.YES_OPTION)
        {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
    cloud9 = DriverManager.getConnection(url, user, pass);
    call = cloud9.prepareStatement("DELETE FROM Organization_info WHERE Organization_Record =?");
    call.setString(1, orgrec.getText());
    call.executeUpdate();
            JOptionPane.showMessageDialog(null, "ORGANIZATION INFORMATION DELETED");
            loadorganizationbase();
     orgrec.setText("");
     memid2.setText("");
     orgid.setText("");
     orgname.setText("");
     address2.setText("");
     memstatus.setSelectedIndex(0);
     datejoined.setText("");
            }
        catch (Exception A) {
            JOptionPane.showMessageDialog(null, "ORGANIZATION DELETE FAILED!");
                            }
        }
    }//GEN-LAST:event_delete2ActionPerformed

    private void reset2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset2ActionPerformed
        // TODO add your handling code here:
        memid2.setText("");
     orgid.setText("");
     orgname.setText("");
     address2.setText("");
     memstatus.setSelectedIndex(0);
     datejoined.setText("");
     searchbox2.setText("");
      infotable2.setRowSorter(null);
     infotable2.setAutoCreateRowSorter(true);
     loadorganizationbase();
    }//GEN-LAST:event_reset2ActionPerformed

    private void exit2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit2ActionPerformed
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
    }//GEN-LAST:event_exit2ActionPerformed

    private void infotable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_infotable3MouseClicked
        // TODO add your handling code here:
        DefaultTableModel RecordTable3 = (DefaultTableModel)infotable3.getModel();
        int SelectedRows3 = infotable3.getSelectedRow();
        int sortedrow3 = infotable3.convertRowIndexToModel(SelectedRows3);
     comrec.setText(RecordTable3.getValueAt(sortedrow3, 0).toString());
     memid3.setText(RecordTable3.getValueAt(sortedrow3, 1).toString());
     comid.setText(RecordTable3.getValueAt(sortedrow3, 2).toString());
     position.setText(RecordTable3.getValueAt(sortedrow3, 3).toString());
     comname.setText(RecordTable3.getValueAt(sortedrow3, 4).toString());
     comaddress.setText(RecordTable3.getValueAt(sortedrow3, 5).toString());
  
    }//GEN-LAST:event_infotable3MouseClicked

    private void comidMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comidMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_comidMouseClicked

    private void comidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comidActionPerformed

    private void comaddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comaddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comaddressActionPerformed

    private void insert3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insert3ActionPerformed
        // TODO add your handling code here:
      /*  try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    cloud9 = DriverManager.getConnection(url, user, pass);
    call = cloud9.prepareStatement("SELECT * FROM Company_Table");
    output = call.executeQuery();
    if (output.next()) {
        JOptionPane.showMessageDialog(null, "EXISTING COMPANY DETECTED");
    }
    else {
    try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    cloud9 = DriverManager.getConnection(url, user, pass);
    call = cloud9.prepareStatement("INSERT INTO Company_Table (Company_ID, Company_Name) VALUES( ?, ?)");
    call.setObject(1, comid.getText());
    call.setString(2, comname.getText());
    call.executeUpdate();
    JOptionPane.showMessageDialog(null, "NEW COMPANY INSERTED INTO COMPANY TABLE");
    }
    
    catch (Exception C) {
            JOptionPane.showMessageDialog(null, "NEW COMPANY INSERTION FAILED"); 
    }
        }
        }
        catch (Exception C) {
            JOptionPane.showMessageDialog(null, "NEW COMPANY INSERTION FAILED");
        }
        */
        try{
    Class.forName("com.mysql.cj.jdbc.Driver");
    cloud9 = DriverManager.getConnection(url, user, pass);
    call = cloud9.prepareStatement("INSERT INTO Company_info (Company_Record, Member_ID, Company_ID, Job, company_Name, Company_Address) VALUES( ?, ?, ?, ?, ?, ?)");
    call.setObject(1, comrec.getText());
    call.setObject(2, memid3.getText());
    call.setObject(3, comid.getText());
    call.setString(4, position.getText());
    call.setString(5, comname.getText());
    call.setString(6, comaddress.getText());
    call.executeUpdate();
    JOptionPane.showMessageDialog(null, "COMPANY INFORMATION INSERTED");
    loadcompanybase();
        }
       catch (Exception B) {
           JOptionPane.showMessageDialog(null, "COMPANY INSERT ERROR");
       }
    }//GEN-LAST:event_insert3ActionPerformed

    private void update3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update3ActionPerformed
        // TODO add your handling code here:
        try{
    Class.forName("com.mysql.cj.jdbc.Driver");
    cloud9 = DriverManager.getConnection(url, user, pass);
    call = cloud9.prepareStatement("UPDATE Company_info SET Company_ID =?, Member_ID =?, Company_Name =?, Job =?, Company_Address =? WHERE Company_Record =?");
    call.setObject(1, comid.getText());
    call.setObject(2, memid3.getText());
    call.setString(3, comname.getText());
    call.setString(4, position.getText());
    call.setString(5, comaddress.getText());
    call.setString(6, comrec.getText());
    call.executeUpdate();
    JOptionPane.showMessageDialog(null, "COMPANY INFORMATION UPDATED");
    loadcompanybase();
        }
       catch (Exception B) {
           JOptionPane.showMessageDialog(null, "COMPANY UPDATE ERROR");
       }
    }//GEN-LAST:event_update3ActionPerformed

    private void delete3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete3ActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(deletion, "DELETE COMPANY RECORD #" + comrec.getText() + "?", "DELETION", JOptionPane.YES_NO_OPTION)== JOptionPane.YES_OPTION)
        {
            try {
            Class.forName("com.mysql.cj.jdbc.Driver");
    cloud9 = DriverManager.getConnection(url, user, pass);
    call = cloud9.prepareStatement("DELETE FROM Company_info WHERE Company_Record =?");
    call.setString(1, comrec.getText());
    call.executeUpdate();
            JOptionPane.showMessageDialog(null, "COMPANY INFORMATION DELETED");
            loadcompanybase();
     comrec.setText("");
     memid3.setText("");
     comid.setText("");
     position.setText("");
     comname.setText("");
     comaddress.setText("");
            }
        catch (Exception A) {
            JOptionPane.showMessageDialog(null, "COMPANY DELETE FAILED!");
                            }
        }
    }//GEN-LAST:event_delete3ActionPerformed

    private void reset3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset3ActionPerformed
        // TODO add your handling code here:
          memid3.setText("");
     comid.setText("");
     position.setText("");
     comname.setText("");
     comaddress.setText("");
     searchbox3.setText("");
     infotable3.setRowSorter(null);
     infotable3.setAutoCreateRowSorter(true);
     loadcompanybase();
    }//GEN-LAST:event_reset3ActionPerformed

    private void exit3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit3ActionPerformed
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
    }//GEN-LAST:event_exit3ActionPerformed

    private void birthdayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_birthdayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_birthdayActionPerformed

    private void pwdcheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwdcheckActionPerformed
        // TODO add your handling code here:
        if (pwdcheck.isSelected()){
                pwd = "TRUE";
                                  }
        else {
            pwd = "FALSE";
             }
            
    }//GEN-LAST:event_pwdcheckActionPerformed

    private void memstatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memstatusActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_memstatusActionPerformed

    private void fnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fnameActionPerformed

    private void memidMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_memidMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_memidMouseClicked

    private void memidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_memidActionPerformed

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
    JOptionPane.showMessageDialog(null, "MEMBER INFORMATION INSERTED");
    loadmemberbase();
      idnum.setText("");
     yearlevelbox.setSelectedIndex(0);
     fname.setText("");
     mname.setText("");
     lname.setText("");
     genderbox.setSelectedIndex(0);
     birthday.setText("");
     address.setText("");
     pwdcheck.setSelected(false);
     searchbox.setText("");
     searchcon.setSelectedIndex(0);
    getmembercount();
        }
       catch (Exception B) {
           JOptionPane.showMessageDialog(null, "INSERT ERROR");
       }
    }//GEN-LAST:event_insertActionPerformed

    private void orgidMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_orgidMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_orgidMouseClicked

    private void orgidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orgidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_orgidActionPerformed

    private void pwdcheckItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_pwdcheckItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_pwdcheckItemStateChanged

    private void memid3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_memid3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_memid3MouseClicked

    private void memid3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memid3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_memid3ActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
        
        searchmemberbase();
 
    }//GEN-LAST:event_searchActionPerformed

    private void search1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search1ActionPerformed
        // TODO add your handling code here:
      
        searchguardianbase();
       
    }//GEN-LAST:event_search1ActionPerformed

    private void search2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search2ActionPerformed
        // TODO add your handling code here:
     
        searchorganizationbase();
       
    }//GEN-LAST:event_search2ActionPerformed

    private void search3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search3ActionPerformed
        // TODO add your handling code here:
        searchcompanybase();
       
    }//GEN-LAST:event_search3ActionPerformed

    private void searchconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchconMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_searchconMouseClicked

    private void searchconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchconActionPerformed
        // TODO add your handling code here:
   
        if (searchcon.getSelectedIndex()==1) {
                condition = "member_id";
            }
            else if (searchcon.getSelectedIndex()==2) {
                condition = "id_number";
            }
            else if (searchcon.getSelectedIndex()==3) {
                condition = "year_level";
            }
            else if (searchcon.getSelectedIndex()==4) {
                condition = "first_name";
            }
            else if (searchcon.getSelectedIndex()==5) {
                condition = "middle_name";
            }
            else if (searchcon.getSelectedIndex()==6) {
                condition = "surname";
            }
            else if (searchcon.getSelectedIndex()==7) {
                condition = "gender";
            }
            else if (searchcon.getSelectedIndex()==8) {
                condition = "address";
            }
            else if (searchcon.getSelectedIndex()==9) {
                condition = "birthdate";
            }
            else if (searchcon.getSelectedIndex()==10) {
                condition = "PWD";
            }
        
            
    }//GEN-LAST:event_searchconActionPerformed

    private void searchcon1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchcon1ActionPerformed
        // TODO add your handling code here:
       
        if (searchcon1.getSelectedIndex()==1) {
                condition1 = "guardian_record";
            }
             else if (searchcon1.getSelectedIndex()==2) {
                condition1 = "member_id";
            }
            else if (searchcon1.getSelectedIndex()==3) {
                condition1 = "guardian_id";
            }
            else if (searchcon1.getSelectedIndex()==4) {
                condition1 = "first_name";
            }
            else if (searchcon1.getSelectedIndex()==5) {
                condition1 = "middle_name";
            }
            else if (searchcon1.getSelectedIndex()==6) {
                condition1 = "surname";
            }
             else if (searchcon1.getSelectedIndex()==7) {
                condition1 = "gender";
            }
            else if (searchcon1.getSelectedIndex()==8) {
                condition1 = "address";
            }
    }//GEN-LAST:event_searchcon1ActionPerformed

    private void searchcon2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchcon2ActionPerformed
        // TODO add your handling code here:
 
        if (searchcon2.getSelectedIndex()==1) {
                condition2 = "organization_record";
            }
        else if (searchcon2.getSelectedIndex()==2) {
                condition2 = "member_id";
            }
            else if (searchcon2.getSelectedIndex()==3) {
                condition2 = "organization_id";
            }
            else if (searchcon2.getSelectedIndex()==4) {
                condition2 = "organization_name";
            }
            else if (searchcon2.getSelectedIndex()==5) {
                condition2 = "organization_address";
            }
            else if (searchcon2.getSelectedIndex()==6) {
                condition2 = "membership_status";
            }
            
            else if (searchcon2.getSelectedIndex()==7) {
                condition2 = "join_date";
            }
    }//GEN-LAST:event_searchcon2ActionPerformed

    private void searchcon3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchcon3ActionPerformed
        // TODO add your handling code here:
        
        if (searchcon3.getSelectedIndex()==1) {
                condition3 = "company_record";
            }
        else if (searchcon3.getSelectedIndex()==2) {
                condition3 = "member_id";
            }
            else if (searchcon3.getSelectedIndex()==3) {
                condition3 = "company_id";
            }
            else if (searchcon3.getSelectedIndex()==4) {
                condition3 = "job";
            }
            else if (searchcon3.getSelectedIndex()==5) {
                condition3 = "company_name";
            }
            else if (searchcon3.getSelectedIndex()==6) {
                condition3 = "company_address";
            }
    }//GEN-LAST:event_searchcon3ActionPerformed

    private void positionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_positionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_positionActionPerformed

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

    private void searchcon4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchcon4ActionPerformed
        // TODO add your handling code here:
     
        if (searchcon4.getSelectedIndex()==1) {
                condition4 = "member_id";
            }
            else if (searchcon4.getSelectedIndex()==2) {
                condition4 = "guardian_id";
            }
            else if (searchcon4.getSelectedIndex()==3) {
                condition4 = "contact_id";
            }
            else if (searchcon4.getSelectedIndex()==4) {
                condition4 = "phone_number";
            }
            else if (searchcon4.getSelectedIndex()==5) {
                condition4 = "email_address";
            }
    }//GEN-LAST:event_searchcon4ActionPerformed

    private void search4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search4ActionPerformed
        // TODO add your handling code here:
       searchcontactbase();
    }//GEN-LAST:event_search4ActionPerformed

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void memid4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_memid4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_memid4MouseClicked

    private void memid4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memid4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_memid4ActionPerformed

    private void insert4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insert4ActionPerformed
        // TODO add your handling code here:
         try{
    Class.forName("com.mysql.cj.jdbc.Driver");
    cloud9 = DriverManager.getConnection(url, user, pass);
    call = cloud9.prepareStatement("INSERT INTO Contact_info (Member_ID, Guardian_ID, Contact_ID, Phone_Number, Email_Address) VALUES(?, ?, ?, ?, ?)");
    if (contype.getSelectedIndex()==0) {
    call.setObject(1, memid4.getText());
    call.setString(2, null);
    }
    else if (contype.getSelectedIndex()==1) {
    call.setString(1, null);
    call.setObject(2, memid4.getText());
    }
    call.setObject(3, conid.getText());
    call.setString(4, phone.getText());
    call.setString(5, email.getText());
   
    call.executeUpdate();
    JOptionPane.showMessageDialog(null, "CONTACT INFORMATION INSERTED");
    loadcontactbase();
        }
       catch (Exception B) {
           JOptionPane.showMessageDialog(null, "CONTACT INSERT ERROR");
       }
    }//GEN-LAST:event_insert4ActionPerformed

    private void update4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update4ActionPerformed
        // TODO add your handling code here:
          try{
    Class.forName("com.mysql.cj.jdbc.Driver");
    cloud9 = DriverManager.getConnection(url, user, pass);
    call = cloud9.prepareStatement("UPDATE Contact_info SET Member_ID =?, Guardian_ID =?, Phone_Number =?, Email_Address =? WHERE Contact_ID =?");
    if (contype.getSelectedIndex()==0) {
    call.setObject(1, memid4.getText());
    call.setString(2, null);
    }
    else if (contype.getSelectedIndex()==1) {
    call.setString(1, null);
    call.setObject(2, memid4.getText());
    }
    call.setString(3, phone.getText());
    call.setString(4, email.getText());
    call.setString(5, conid.getText());
    call.executeUpdate();
    JOptionPane.showMessageDialog(null, "CONTACT INFORMATION UPDATED");
    loadcontactbase();
        }
       catch (Exception B) {
           JOptionPane.showMessageDialog(null, "CONTACT UPDATE ERROR");
       }
    }//GEN-LAST:event_update4ActionPerformed

    private void delete4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete4ActionPerformed
        // TODO add your handling code here:
         if (JOptionPane.showConfirmDialog(deletion, "DELETE CONTACT #" + conid.getText() + "?", "DELETION", JOptionPane.YES_NO_OPTION)== JOptionPane.YES_OPTION)
        {
            try {
            Class.forName("com.mysql.cj.jdbc.Driver");
    cloud9 = DriverManager.getConnection(url, user, pass);
    call = cloud9.prepareStatement("DELETE FROM Contact_info WHERE Contact_ID =?");
    call.setString(1, conid.getText());
    call.executeUpdate();
            JOptionPane.showMessageDialog(null, "CONTACT INFORMATION DELETED");
            loadcontactbase();
        contype.setSelectedIndex(0);
        memid4.setText("");
     conid.setText("");
     phone.setText("");
     email.setText("");
     searchbox4.setText("");
            }
        catch (Exception A) {
            JOptionPane.showMessageDialog(null, "CONTACT DELETE FAILED!");
                            }
        }
    }//GEN-LAST:event_delete4ActionPerformed

    private void reset4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset4ActionPerformed
        // TODO add your handling code here:
        contype.setSelectedIndex(0);
        memid4.setText("");
     conid.setText("");
     phone.setText("");
     email.setText("");
     searchbox4.setText("");
     infotable4.setRowSorter(null);
     infotable4.setAutoCreateRowSorter(true);
     loadcontactbase();
    }//GEN-LAST:event_reset4ActionPerformed

    private void exit4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit4ActionPerformed
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
    }//GEN-LAST:event_exit4ActionPerformed

    private void conidMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_conidMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_conidMouseClicked

    private void conidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_conidActionPerformed

    private void contypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contypeActionPerformed

    private void searchbox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchbox1ActionPerformed

    private void searchcon5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchcon5ActionPerformed
        // TODO add your handling code here:
       
        if (searchcon5.getSelectedIndex()==1) {
                condition5 = "achievement_record";
            }
        else if (searchcon5.getSelectedIndex()==2) {
                condition5 = "member_id";
            }
            else if (searchcon5.getSelectedIndex()==3) {
                condition5 = "organization_id";
            }
            else if (searchcon5.getSelectedIndex()==4) {
                condition5 = "achievement_id";
            }
            else if (searchcon5.getSelectedIndex()==5) {
                condition5 = "achievement";
            }
            else if (searchcon5.getSelectedIndex()==6) {
                condition5 = "awarder";
            }
        else if (searchcon5.getSelectedIndex()==7) {
                condition5 = "award_date";
            }
    }//GEN-LAST:event_searchcon5ActionPerformed

    private void search5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search5ActionPerformed
        // TODO add your handling code here:
        searchachievementbase();
    }//GEN-LAST:event_search5ActionPerformed

    private void infotable5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_infotable5MouseClicked
        // TODO add your handling code here:
        DefaultTableModel RecordTable5 = (DefaultTableModel)infotable5.getModel();
        int SelectedRows5 = infotable5.getSelectedRow();
        int sortedrow5 = infotable5.convertRowIndexToModel(SelectedRows5);
     arecord.setText(RecordTable5.getValueAt(sortedrow5, 0).toString());
     memid5.setText(RecordTable5.getValueAt(sortedrow5, 1).toString());
     orgid2.setText(RecordTable5.getValueAt(sortedrow5, 2).toString());
     achievementid.setText(RecordTable5.getValueAt(sortedrow5, 3).toString());
     achievement.setText(RecordTable5.getValueAt(sortedrow5, 4).toString());
     awarder.setText(RecordTable5.getValueAt(sortedrow5, 5).toString());
     dateawarded.setText(RecordTable5.getValueAt(sortedrow5, 6).toString());
    }//GEN-LAST:event_infotable5MouseClicked

    private void dateawardedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateawardedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateawardedActionPerformed

    private void delete5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete5ActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(deletion, "DELETE ACHIEVEMENT RECORD #" + arecord.getText() + "?", "DELETION", JOptionPane.YES_NO_OPTION)== JOptionPane.YES_OPTION)
        {
            try {
            Class.forName("com.mysql.cj.jdbc.Driver");
    cloud9 = DriverManager.getConnection(url, user, pass);
    call = cloud9.prepareStatement("DELETE FROM Achievement_info WHERE Achievement_Record =?");
    call.setString(1, arecord.getText());
    call.executeUpdate();
            JOptionPane.showMessageDialog(null, "ACHIEVEMENT INFORMATION DELETED");
            loadachievementbase();
            arecord.setText("");
        memid5.setText("");
     achievementid.setText("");
     orgid2.setText("");
     achievement.setText("");
     awarder.setText("");
     dateawarded.setText("");
     searchbox5.setText("");
            }
        catch (Exception A) {
            JOptionPane.showMessageDialog(null, "ACHIEVEMENT DELETE FAILED!");
                            }
        }
    }//GEN-LAST:event_delete5ActionPerformed

    private void reset5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset5ActionPerformed
        // TODO add your handling code here:
        memid5.setText("");
        orgid2.setText("");
        achievementid.setText("");
        achievement.setText("");
        awarder.setText("");
        dateawarded.setText("");
        searchbox5.setText("");
        loadachievementbase();
        infotable5.setRowSorter(null);
        infotable5.setAutoCreateRowSorter(true);
    }//GEN-LAST:event_reset5ActionPerformed

    private void exit5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit5ActionPerformed
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
    }//GEN-LAST:event_exit5ActionPerformed

    private void update5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update5ActionPerformed
        // TODO add your handling code here:
         try{
    Class.forName("com.mysql.cj.jdbc.Driver");
    cloud9 = DriverManager.getConnection(url, user, pass);
    call = cloud9.prepareStatement("UPDATE Achievement_info SET Achievement_ID =?, Member_ID =?, Organization_ID =?, Achievement =?, Awarder =?, Award_Date =? WHERE Achievement_Record =?");
    call.setString(1, achievementid.getText());
    call.setObject(2, memid5.getText());
    call.setObject(3, orgid2.getText());
    call.setString(4, achievement.getText());
    call.setString(5, awarder.getText());
    call.setString(6, dateawarded.getText());
    call.setString(7, arecord.getText());
    call.executeUpdate();
    JOptionPane.showMessageDialog(null, "ACHIEVEMENT INFORMATION UPDATED");
    loadachievementbase();
        }
       catch (Exception B) {
           JOptionPane.showMessageDialog(null, "ACHIEVEMENT UPDATE ERROR");
       }
    }//GEN-LAST:event_update5ActionPerformed

    private void memid5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_memid5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_memid5MouseClicked

    private void memid5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memid5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_memid5ActionPerformed

    private void insert5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insert5ActionPerformed
        // TODO add your handling code here:
        try{
    Class.forName("com.mysql.cj.jdbc.Driver");
    cloud9 = DriverManager.getConnection(url, user, pass);
    call = cloud9.prepareStatement("INSERT INTO Achievement_info (Achievement_Record, Member_ID, Organization_ID, Achievement_ID, Achievement, Awarder, Award_Date) VALUES(?, ?, ?, ?, ?, ?, ?)");
    call.setObject(1, arecord.getText());
    call.setObject(2, memid5.getText());
    call.setObject(3, orgid2.getText());
    call.setString(4, achievementid.getText());
    call.setString(5, achievement.getText());
    call.setString(6, awarder.getText());
    call.setString(7, dateawarded.getText());
   
    call.executeUpdate();
    JOptionPane.showMessageDialog(null, "ACHIVEMENT INFORMATION INSERTED");
    loadachievementbase();
        }
       catch (Exception B) {
           JOptionPane.showMessageDialog(null, "ACHIEVEMENT INSERT ERROR");
       }
    }//GEN-LAST:event_insert5ActionPerformed

    private void orgid2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_orgid2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_orgid2MouseClicked

    private void orgid2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orgid2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_orgid2ActionPerformed

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

    private void searchbox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchbox3ActionPerformed

    private void fname1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fname1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fname1ActionPerformed

    private void address1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_address1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_address1ActionPerformed

    private void searchbox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchbox2ActionPerformed

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
            java.util.logging.Logger.getLogger(viewonly.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewonly().setVisible(true);
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
    private javax.swing.JButton delete;
    private javax.swing.JButton delete1;
    private javax.swing.JButton delete2;
    private javax.swing.JButton delete3;
    private javax.swing.JButton delete4;
    private javax.swing.JButton delete5;
    private javax.swing.JTextField email;
    private javax.swing.JButton exit;
    private javax.swing.JButton exit1;
    private javax.swing.JButton exit2;
    private javax.swing.JButton exit3;
    private javax.swing.JButton exit4;
    private javax.swing.JButton exit5;
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
    private javax.swing.JButton insert1;
    private javax.swing.JButton insert2;
    private javax.swing.JButton insert3;
    private javax.swing.JButton insert4;
    private javax.swing.JButton insert5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
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
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTextField lname;
    private javax.swing.JTextField lname1;
    private javax.swing.JTextField memid;
    private javax.swing.JTextField memid1;
    private javax.swing.JTextField memid2;
    private javax.swing.JTextField memid3;
    private javax.swing.JTextField memid4;
    private javax.swing.JTextField memid5;
    private javax.swing.JComboBox<String> memstatus;
    private javax.swing.JTextField mname;
    private javax.swing.JTextField mname1;
    private javax.swing.JTextField orgid;
    private javax.swing.JTextField orgid2;
    private javax.swing.JTextField orgname;
    private javax.swing.JTextField orgrec;
    private javax.swing.JTextField phone;
    private javax.swing.JTextField position;
    private javax.swing.JCheckBox pwdcheck;
    private javax.swing.JButton reset;
    private javax.swing.JButton reset1;
    private javax.swing.JButton reset2;
    private javax.swing.JButton reset3;
    private javax.swing.JButton reset4;
    private javax.swing.JButton reset5;
    private javax.swing.JButton search;
    private javax.swing.JButton search1;
    private javax.swing.JButton search2;
    private javax.swing.JButton search3;
    private javax.swing.JButton search4;
    private javax.swing.JButton search5;
    private javax.swing.JTextField searchbox;
    private javax.swing.JTextField searchbox1;
    private javax.swing.JTextField searchbox2;
    private javax.swing.JTextField searchbox3;
    private javax.swing.JTextField searchbox4;
    private javax.swing.JTextField searchbox5;
    private javax.swing.JComboBox<String> searchcon;
    private javax.swing.JComboBox<String> searchcon1;
    private javax.swing.JComboBox<String> searchcon2;
    private javax.swing.JComboBox<String> searchcon3;
    private javax.swing.JComboBox<String> searchcon4;
    private javax.swing.JComboBox<String> searchcon5;
    private javax.swing.JLabel titlel1;
    private javax.swing.JButton update;
    private javax.swing.JButton update1;
    private javax.swing.JButton update2;
    private javax.swing.JButton update3;
    private javax.swing.JButton update4;
    private javax.swing.JButton update5;
    private javax.swing.JComboBox<String> yearlevelbox;
    // End of variables declaration//GEN-END:variables
}
