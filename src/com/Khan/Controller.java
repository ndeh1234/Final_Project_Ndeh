package com.Khan;

import java.util.ArrayList;

public class Controller {

    private CollegeGUI gui;
    private CollegeDB db;

    public static void main(String[] args) {

       new Controller().startApp();


    }

    private void startApp() {
        db = new CollegeDB();

        ArrayList<CollegeDB> allData = db.fetchAllRecords();

        gui = new CollegeGUI(this);
        gui.setListData(allData);
    }

      ArrayList<CollegeDB> getAllData(){
        return db.fetchAllRecords();

      }

      String addCollegeDBToDatabase(CollegeDB collegeDB){
        return db.addRecord();
      }
}
