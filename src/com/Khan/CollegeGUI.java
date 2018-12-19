package com.Khan;

import sun.swing.SwingUtilities2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.util.ArrayList;


public class CollegeGUI extends JFrame {

    Connection con;
    Statement stm;
    PreparedStatement preStatement, updatePreStmt;

    private JPanel mainPanel;
    private JButton DropButton;

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

    DefaultTableModel model;
    JScrollPane scrollpane;

    private CollegeDB db;

    private Controller controller;

    // Defining Constructor

    public CollegeGUI(Controller controller) {

        super("Online Registration Application");

        // Calling connect method, this will connect us to the database

        Connect();

       // this.controller = controller;


        // Defining Labels

        Title = new JLabel("Online Registration Application");
        JLabel ID = new JLabel("ID");
        JLabel Section = new JLabel("Section");
        JLabel ClassName = new JLabel("Class Name");
        JLabel CreditHours = new JLabel("CrHrs");
        JLabel Instructor = new JLabel("Instructor");
        JLabel ClassTime = new JLabel("Class Time");
        JLabel Days = new JLabel("Days");
        JLabel bldgRoom = new JLabel("Bldg/Room");


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

        panel = new JPanel();
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



        ExitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    con.close();

                    System.exit(0);

                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }

        });

            RegisterButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {

                    try{

                        if (ae.getSource() == RegisterButton) {

                            if (SectionTextField.getText().equals(""))

                                JOptionPane.showMessageDialog(IDTextField,

                                        "Please provide Section_TextFieldField");

                            else if(ClassNameTextField.getText().equals(""))

                                JOptionPane.showMessageDialog(IDTextField,

                                        "Please provide ClassName_Field");

                            else if(CreditHoursTextField.getText().equals(""))
                                JOptionPane.showMessageDialog(IDTextField, "Please provide CreditHours_TextField");

                            else if(InstructorTextField.equals(""))

                                JOptionPane.showMessageDialog(IDTextField, "Please provide Instructor_TextField");
                            else if(ClassTimeTextField.getText().equals(""))
                                JOptionPane.showMessageDialog(IDTextField,"Please provide class_Time_FieldTextField");
                            else if(BldgRoomTextField.getText().equals("Please provide BldgRoom_TextField"));


                            else {

                                //Fetching column values from Database

                                preStatement.setString(1,IDTextField.getText());

                                preStatement.setString(2, SectionTextField.getText());

                                preStatement.setString(3,ClassNameTextField.getText());

                                preStatement.setString(4,CreditHoursTextField.getText());
                                preStatement.setString(5, InstructorTextField.getText());
                                preStatement.setString(7,ClassTimeTextField.getText());
                                preStatement.setString(8, DaysTextField.getText());
                                preStatement.setString(9,BldgRoomTextField.getText());


                                //Executing SQLITE Update Query

                                int i = preStatement.executeUpdate();

                                if(i==1){

                                    JOptionPane.showMessageDialog(panel,

                                            "Successfully Registered");

                                }


                            }

                }
            } catch (SQLException e) {
                        e.printStackTrace();
                    };


           UpdateButton.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {


                   if (SectionTextField.getText().equals(""))

                       JOptionPane.showMessageDialog(IDTextField,

                               "Please provide Section_TextField");

                   else if(ClassNameTextField.getText().equals(""))

                       JOptionPane.showMessageDialog(IDTextField,

                               "Please provide ClassName_TextField");

                   else if(CreditHoursTextField.getText().equals(""))

                       JOptionPane.showMessageDialog(IDTextField,

                               "Please provide CreditHours_TextField");

                   else if(InstructorTextField.equals(""))

                       JOptionPane.showMessageDialog(IDTextField,

                               "Please Instructor TextField");
                   else if(InstructorTextField.equals(""))

                       JOptionPane.showMessageDialog(IDTextField, "Please provide Instructor_TextField");
                   else if(ClassTimeTextField.getText().equals(""))
                       JOptionPane.showMessageDialog(IDTextField,"Please provide class_Time_FieldTextField");
                   else if(BldgRoomTextField.getText().equals("Please provide BldgRoom_TextField"));

                   else {
                       int r = Table.getSelectedRow();

                       try{

                           if(r>=0) {


                               String id = (String) Table.getModel().

                                       getValueAt(r, 1);


                              // updatePreStmt = (PreparedStatement) con.prepareStatement(



                               updatePreStmt.setString(2,ClassNameTextField.getText());

                               updatePreStmt.setString(3,CreditHoursTextField.getText());

                               updatePreStmt.setString(4,InstructorTextField.getText());

                               updatePreStmt.setString(5,ClassTimeTextField.getText() );
                               updatePreStmt.setString(6, DaysTextField.getText());
                               updatePreStmt.setString(7,BldgRoomTextField.getText());

                               int i = 0;
                               try {

                                   i = updatePreStmt.executeUpdate();

                               } catch (SQLException e1) {
                                   e1.printStackTrace();
                               }

                               if(i==1){
                                  Table.setValueAt(SectionTextField.getText(),r,2);

                                   Table.setValueAt(ClassNameTextField.getText(), r, 3);

                                   Table.setValueAt(InstructorTextField.getText(),r,4);
                                   Table.setValueAt(CreditHoursTextField.getText(),r,5);
                                   Table.setValueAt(InstructorTextField.getText(), r, 6);
                                   Table.setValueAt(ClassTimeTextField.getText(), r, 7);
                                   Table.setValueAt(DaysTextField.getText(), r,8);
                                   Table.setValueAt(BldgRoomTextField.getText(),r,9);


                               }

                               else JOptionPane.showMessageDialog(panel,

                                       "ID does't Exists in Database");


                       }




                   } catch (SQLException e1) {
                           e1.printStackTrace();
                       }





                //  Storing records in a List



            };




    }



});}});}


}

