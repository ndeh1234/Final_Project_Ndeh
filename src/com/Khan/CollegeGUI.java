package com.Khan;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.util.ArrayList;

import static java.lang.Class.forName;
import static sun.plugin.javascript.navig.JSType.URL;

public class CollegeGUI extends JFrame  {

    Connection con;
    Statement stm;
    PreparedStatement preStatement,updatePreStmt;

    private JPanel mainPanel;
    private JTextField collegeProgramNameText;
    private JButton DropButton;
    private JTextField courseIDTextField;
    private JList collegeProgramList;
    private JTextField FirstNameTextField;
    private JTextField LastNameTextField;
    private JTextField CourseTextField;
    private JTextField IDTextField;
    private JTextField SectionTextField;
    private JTextField ClassNameTextField;
    private JTextField InstructorTextField;
    private JTextField ClassTimeTextField;
    private JTextField DaysTextField;
    private JTextField BldgRoomTextField;
    private JButton ExitButton;
    private JButton RegisterButton;
    private JTable Table;
    private JLabel Title;
    private JTextField CreditHoursTextField;
    private JButton UpdateButton;

  JPanel panel;
   JTable tabel;
   DefaultTableModel model;
    JScrollPane scrollpane;

    private CollegeDB db;
    DefaultListModel<CollegeProgram> allCollegeProgramListModel;  // Add List Model
    private Controller controller;

    // Defining Constructor

    public CollegeGUI(Controller controller) {

        super("Online Registration Application");

        // Calling connect method, this will connect us to the database

        Connect();

       this.controller = controller;



        // Defining Labels

         Title = new JLabel("Online Registration Application");
         JLabel ID = new JLabel("ID");
        JLabel Section = new JLabel("Section");
        JLabel ClassName = new JLabel("Class Name");
        JLabel CreditHours = new JLabel("CrHrs");
        JLabel Instructor = new JLabel("Instructor");
        JLabel ClassTime = new JLabel("Class Time");
        JLabel Days = new JLabel("Days");
        JLabel bldgRoom = new JLabel ("Bldg/Room");



        // Defining  Fields

        IDTextField = new JTextField();

        IDTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
            }
        });
        SectionTextField = new JTextField();

        ClassNameTextField = new JTextField();

        CreditHoursTextField = new JTextField();

        ClassTimeTextField = new JTextField();

        DaysTextField = new JTextField();

        BldgRoomTextField = new JTextField();



        // Fixing all Labels and TextFields

        add(Title);
        add(ID);
        add(Section);
        add(ClassName);
        add(CreditHours);
        add(Instructor);
        add(ClassTime);
        add(Days);
        add(bldgRoom);



        // Defining Register Button

        RegisterButton = new JButton("Register");


        //RegisterButton.addActionListener();

        // Defining Drop Button

        DropButton = new JButton("Drop");

        DropButton.setEnabled(false);


        // Defining Exit Button

        ExitButton = new JButton("Exit");

        // Defining update button

        UpdateButton = new JButton("Update");

        UpdateButton.setEnabled(false);


        // Fixing all Buttons

         add(RegisterButton);
         add(DropButton);
         add(ExitButton);
         add(UpdateButton);

        // Defining Panel

        panel= new JPanel();
        panel.setLayout(new GridLayout());
        panel.setBorder(BorderFactory.createDashedBorder(Color.GREEN));
        add(panel);

        // Defining Model for Table

        model = new DefaultTableModel();

        // Adding Object of DefaultTabletModel into JTable

         Table = new JTable((TableModel) model);


        //Fixing Columns move

        Table.getTableHeader().setReorderingAllowed(false);

        // Defining Column Names on model

        model.addColumn("ID");

        model.addColumn("Section");

        model.addColumn("Class Name");

        model.addColumn("CrHrs");

        model.addColumn("Instructor");

        model.addColumn("Class Time");
        model.addColumn("Days");
        model.addColumn("Bldg/Room");


        // Enable Scrolling on table

        scrollpane = new JScrollPane(Table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,

                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        panel.add(scrollpane);



        //Displaying Frame in Center of the Screen

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        this.setLocation(dim.width/2-this.getSize().width/2,

                dim.height/2-this.getSize().height/2);

                addListeners();

        // Regular setup stuff for the JFrame window
        setContentPane(mainPanel);
        pack();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


    }
        // Connection with Database

    public void Connect() {



        }

         



    private void errorDialog(String msg) {
        JOptionPane.showMessageDialog(CollegeGUI.this, msg, "error", JOptionPane.ERROR_MESSAGE);
    }

    private void addListeners() {

        // Defining column names on model

        DefaultTableModel tableModel = new DefaultTableModel();

        tableModel.addColumn("ID");
        tableModel.addColumn("sections");
        tableModel.addColumn("Class Name");
        tableModel.addColumn("Cr/Hrs");
        tableModel.addColumn("Instructor");
        tableModel.addColumn("classTime");
        tableModel.addColumn("Days");
        tableModel.addColumn("bldgRoom");



    }


        public void actionPerformed(ActionEvent ae){

        if(ae.getSource()== ExitButton){
            if(IDTextField.getText().equals("") || SectionTextField.getText().equals("") ||
                    ClassTimeTextField.getText().equals("") || CreditHoursTextField.getText().equals("") ||
            InstructorTextField.getText().equals(""))JOptionPane.showMessageDialog(IDTextField, "Fields will not Blank");
            else{

                //  Storing records in a List



            }
        }
        }

    public void setListData(ArrayList<CollegeProgram> allData) {

    }
}
