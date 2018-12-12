package com.Khan;

import java.util.ArrayList;
import java.util.HashMap;

public class Controller {

    private CollegeGUI gui;
    private CollegeDB db;

    public static void main(String[] args) {
        new Controller().startApp();
    }

    private void startApp() {

        db = new CollegeDB();


    }
}