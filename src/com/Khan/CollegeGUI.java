package com.Khan;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

public class CollegeGUI extends JFrame {
    private JPanel mainPanel;
    private JButton RegistrationButton;
    private JTextField ClassNameTextField;
    private JButton dropClassButton;
    private JButton addClassButton;
    private JTextField studentInstructorIDTextField;
    private JLabel CourseID;
    private JLabel courseID;
    private JTextField courseIDTextField;
    private JTextField instructorTextField;
    private JTextField studentTextField;
    private JTextField firstNameTextField;
    private JTextField middleNameTextField;
    private JTextField lastNameTextField;
    private JScrollPane scrollPane1;
    private JSlider ClassSize;
    private JList ScheduleJList;

    private CollegeDB db;
    DefaultListModel<CollegeDB> CourseListModel;  // Add List Model
    private Controller controller;

    public CollegeGUI(Controller controller) {
        this.controller = controller;


        setContentPane(mainPanel);
        pack();
        setVisible(true);
       // configureTable();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        CourseListModel = new DefaultListModel<>();
        ScheduleJList.setModel(CourseListModel);

        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("courseID");
        tableModel.addColumn("Class Name");
        tableModel.addColumn("Instructor");
        tableModel.addColumn("Days");
        tableModel.addColumn("Time");

        addClassButton.addActionListener(new ActionListener() {
                                             @Override
                                             public void actionPerformed(ActionEvent e) {
                                                 String name1 = firstNameTextField.getText();
                                                 String name2 = lastNameTextField.getText();
                                                 String courseID = courseIDTextField.getUIClassID();


                                             }
                                         }
        );
    }
}
               