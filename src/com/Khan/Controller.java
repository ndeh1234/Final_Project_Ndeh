package com.Khan;

import java.util.ArrayList;
import java.util.HashMap;

public class Controller {

    private CollegeGUI gui;
    private CollegeDB db;

    public static void main(String[] args) {
        new Controller().startApp();
    }

    private void startApp(){

        db = new CollegeDB();
        ArrayList<CollegeProgram> allData = db.fetchAllRecords();

        gui = new CollegeGUI(this);
        gui.setListData(allData);

    }

    ArrayList<CollegeProgram> getAllData(){

        return db.fetchAllRecords();
    }

    ArrayList<CollegeProgram> addCollgeProgramToDatabase(CollegeProgram collegeProgram){

        return  db.fetchAllRecords();
    }

   public String[] keySet() {

        return null;
    }

    public String get(String course) {
        return null;
    }
}
