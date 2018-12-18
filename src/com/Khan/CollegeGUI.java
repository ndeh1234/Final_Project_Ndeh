package com.Khan;

import com.sun.xml.internal.bind.v2.model.core.ID;
import netscape.security.UserTarget;
import sun.usagetracker.UsageTrackerClient;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.nio.file.attribute.UserPrincipal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CollegeGUI extends JFrame implements ActionListener {
    private JPanel mainPanel;
    private JTextField collegeProgramNameText;
    private JButton dropButton;
    private JButton RegisterButton;
    private JTextField courseIDTextField;
    private JList collegeProgramList;
    private JTextField FirstNameTextField;
    private JTextField LastNameTextField;
    private JTextField CourseTextField;
    private JTextField IDTextField;
    private JTable ScheduleTable;
    private JButton exitButton;
    private JButton registerButton;
    JTable table;


    private CollegeDB db;
    DefaultListModel<CollegeProgram> allCollegeProgramListModel;  // Add List Model
    private Controller controller;

    // Defining Constructor

    public CollegeGUI(Controller controller) {
        this.controller = controller;
        setSize(700, 360);
        setLayout(null);


        // Defining Labels

        JLabel title = new JLabel("Online Registration Application");

        title.setBounds(60, 7, 200, 30);

        JLabel IdLabel = new JLabel("ID");
        JLabel FirstNameLabel = new JLabel("First Name");
        FirstNameLabel.setBounds(30, 85, 60, 30);
        JLabel LastNameLabel = new JLabel("Last Name");
        LastNameLabel.setBounds(30, 85, 60, 30);
        JLabel studentLabel = new JLabel("Student");
        JLabel InstructorLabel = new JLabel("Instructor");
        JLabel ScheduleLabel = new JLabel("Schedule");

        // Defining ID Field

        IDTextField = new JTextField();
        IDTextField.setBounds(95, 50, 100, 30);
        IDTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
            }
        });

        // Defining name Field

        FirstNameTextField = new JTextField();
        FirstNameTextField.setBounds(95, 120, 60, 30);
        LastNameTextField = new JTextField();
        LastNameTextField.setBounds(95, 120, 60, 30);

        // Defining course Field

        CourseTextField = new JTextField();
        CourseTextField.setBounds(95, 120, 60, 30);

        // Defining Exit Button

        exitButton = new JButton();
        exitButton.setBounds(25, 230, 80, 30);

        // Defining Register Button

        registerButton = new JButton();
        registerButton.setBounds(110, 230, 100, 30);
        registerButton.addActionListener(this);

        // Defining Drop Button

        dropButton = new JButton();
        dropButton.setBounds(110, 230, 100, 30);

        // Defining Panel

        mainPanel = new JPanel();
        mainPanel.setBounds(250, 10, 400, 300);
        mainPanel.setBorder(BorderFactory.createDashedBorder(Color.GREEN));
        add(mainPanel);


        addListeners();

        // Regular setup stuff for the JFrame window
        setContentPane(mainPanel);
        pack();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    private void errorDialog(String msg) {
        JOptionPane.showMessageDialog(CollegeGUI.this, msg, "error", JOptionPane.ERROR_MESSAGE);
    }

    private void addListeners() {

        // Defining column names on model

        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("courseID");
        tableModel.addColumn("sections");
        tableModel.addColumn("Class Name");
        tableModel.addColumn("creditHours");
        tableModel.addColumn("Instructor");
        tableModel.addColumn("classTime");
        tableModel.addColumn("Days");
        tableModel.addColumn("bldgRoom");



    }


        public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==exitButton){
            if(IDTextField.getText().equals("") || FirstNameTextField.getText().equals("") ||
                    LastNameTextField.getText().equals("") || courseIDTextField.getText().equals("") ||
            IDTextField.getText().equals(""))JOptionPane.showMessageDialog(IDTextField, "Fields will not Blank");
            else{

                //  Storing records in a List



            }
        }
        }

    public void setListData(ArrayList<CollegeProgram> allData) {

    }
}
