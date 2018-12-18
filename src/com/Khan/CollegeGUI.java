package com.Khan;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CollegeGUI extends JFrame {
    private JPanel mainPanel;
    private JTextField collegeProgramNameText;
    private JButton dropButton;
    private JButton RegisterButton;
    private JLabel courseID;
    private JTextField courseIDTextField;
    private JList collegeProgramList;
    private JTextField FirstNameTextField;
    private JTextField LastNameTextField;
    private JTextField CourseTextField;
    private JTextField IDTextField;
    private JButton DropButton;
    private JTable ScheduleTable;
    private JButton registerButton;

    private CollegeDB db;
    DefaultListModel<CollegeProgram> allCollegeProgramListModel;  // Add List Model
    private Controller controller;

    public CollegeGUI(Controller controller) {
        this.controller=controller;

      //  this.controller = controller; // Stores a reference to the controller object
        // need this to make requests to the database

        // Configure the list model
       // allCollegeProgramListModel = new DefaultListModel<CollegeProgram>();
       // collegeProgramList.setModel(allCollegeProgramListModel);

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
        tableModel.addColumn("sections");
        tableModel.addColumn("Class Name");
        tableModel.addColumn("creditHours");
        tableModel.addColumn("Instructor");
         tableModel.addColumn("classTime");
        tableModel.addColumn("Days");
         tableModel.addColumn("bldgRoom");

         // Add the initial data to the JTable DefaultTableModel


        RegisterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Read data  , and send messages to the database through controller
                String collegeProgram = collegeProgramNameText.getText();

                if (collegeProgram.isEmpty()) {

                    errorDialog("enter a college program name");
                    return;
                }

                int courseID;
                try{courseID = Integer.parseInt(courseIDTextField.getText());
                }catch (NumberFormatException nfe){
                    errorDialog("Try again");
                    return;
                }

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

         dropButton.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {



                 CollegeProgram collegeProgram = (CollegeProgram) collegeProgramList.getSelectedValue();

                 if(collegeProgram!=null){
                     JOptionPane.showMessageDialog(CollegeGUI.this,"Please Select a College Program to drop");


                 }else{
                     controller.deleteCollegeProgram(collegeProgram);

                     ArrayList<CollegeProgram>collegePrograms=controller.getAllData();
                     setListData(collegePrograms);
                 }
             }
         });
    }
}

               