package com.Khan;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Vector;

public class CollegeGUI extends JFrame {
    private JPanel mainPanel;
    private JButton RegistrationButton;
    private JTextField collegeProgramNameText;
    private JButton dropClassButton;
    private JButton addClassButton;
    private JTextField studentInstructorIDTextField;
    private JLabel CourseID;
    private JLabel courseID;
    private JTextField courseIDTextField;
    private JTextField instructorText;
    private JTextField studentTextField;
    private JTextField firstNameTextField;
    private JTextField middleNameTextField;
    private JTextField lastNameTextField;
    private JScrollPane scrollPane1;
    private JSlider ClassSize;
    private JList collegeProgramList;

    private CollegeDB db;
    DefaultListModel<CollegeProgram> allCollegeProgramListModel;  // Add List Model
    private Controller controller;

    public CollegeGUI(Controller controller) {

        this.controller = controller; // Stores a reference to the controller object
        // need this to make requests to the database

        // Configure the list model
        allCollegeProgramListModel = new DefaultListModel<CollegeProgram>();
        collegeProgramList.setModel(allCollegeProgramListModel);

        // and listeners
        addListeners();

        // Regular setup stuff for the JFrame window
        setContentPane(mainPanel);
        pack();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

     private void errorDialog(String msg){
        JOptionPane.showMessageDialog(CollegeGUI.this,msg,"error",JOptionPane.ERROR_MESSAGE);
     }

     private void addListeners(){

        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("courseID");
        tableModel.addColumn("Class Name");
        tableModel.addColumn("Instructor");
        tableModel.addColumn("Days");
        tableModel.addColumn("Time");

        addClassButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Read data  , and send messages to the database through controller
                String collegeProgram = collegeProgramNameText.getText();

                if (collegeProgram.isEmpty()) {

                    errorDialog("enter a college program name");
                    return;
                }

                double courseID;
                try{courseID = Double.parseDouble(courseIDTextField.getText());
                }catch (NumberFormatException nfe){
                    errorDialog("Try again");
                    return;
                }

                CollegeProgram collegeProgramRecord = new CollegeProgram(collegeProgram,)
                String name1 = firstNameTextField.getText();
                String name2 = lastNameTextField.getText();
                String courseID = courseIDTextField.getUIClassID();


                                             }
                                         }
        );
    }


    public void setListData(ArrayList<CollegeProgram> allData) {

            // Display data in allCollegeProgramListModel

        allCollegeProgramListModel.clear();
         if(allData!=null){

             for(CollegeProgram collegeProgram: allData){
                 allCollegeProgramListModel.addElement(collegeProgram);
             }
         }
    }
}

               