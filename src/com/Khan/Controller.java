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

        //ArrayList<CollegeProgram> allData = db.fetchAllRecords();

        gui = new CollegeGUI(this);

    }

     // ArrayList<CollegeProgram> getAllData(){
      //  return db.fetchAllRecords();

      //}

      }

