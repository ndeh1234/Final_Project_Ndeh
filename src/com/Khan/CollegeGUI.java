package com.Khan;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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

    private Controller Controller;


    protected CollegeGUI(Controller courses){

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
        for(String course: courses.keySet()){
            tableModel.addRow(new String[]{course, courses.get(course)});

        }

          addClassButton.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {

                // Read data from JTextFields
               String courseID = courseIDTextField.getUIClassID();
               String className  = ClassNameTextField.getName();
               String Instructor = instructorTextField.getName();
               String classTime = classTimeTextField.getUIClassID();
               String Days = daysTextField.getUIClassID();
               String bldgRoom = bldgRoomTextField.getName();
               String studentInstructorID = studentInstructorIDTextField.getUIClassID();
               tableModel.addRow(new String[]{courseID,className,Instructor,classTime,Days,bldgRoom});

              // courseID.setText("Enter course to add");

          RegistrationButton.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  enterCourse.setText("Schedule Updated");
              }
          });
              }
          });
             }

    public CollegeGUI() {

    }


    public void setListData(ArrayList<CollegeProgram> allData) {

    }
}













