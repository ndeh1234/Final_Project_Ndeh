package com.Khan;

public class Controller {

    private CollegeGUI gui;
    private CollegeDB db;

    public static void main(String[] args) {
        new Controller().startApp();
    }

    private void startApp() {

        db = new CollegeDB(courseID, sections, className, creditHours, Instructor, classTime, days, bldgRoom);


    }
}