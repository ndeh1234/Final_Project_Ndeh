package com.Khan;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class CollegeGUI extends JFrame {
    private JPanel mainPanel;
    private JButton RegistrationButton;
    private JTextField ClassNameTextField;
    private JButton dropClassButton;
    private JButton addClassButton;
    private JTextField FirstNameTextField;
    private JTextField MiddleNameTextField;
    private JTextField LastNameTextField;
    private JTextField studentInstructorIDTextField;
    private JLabel CourseID;
    private JLabel courseID;
    private JLabel enterCourse;
    private JTable myScheduleTable;
    private JTextField courseIDTextField;
    private JTextField classTimeTextField;
    private JTextField daysTextField;
    private JTextField instructorTextField;
    private JTextField studentTextField;
    private JTextField bldgRoomTextField;

    private CollegeDB db;


    public CollegeGUI() {
        
        setContentPane(mainPanel);
        pack();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        final DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("courseID");
        tableModel.addColumn("Class Name");
        tableModel.addColumn("Instructor");
        tableModel.addColumn("Days");
        tableModel.addColumn("Time");

        // Adds initial data to the JTable DefaultTableModel


    }



}




