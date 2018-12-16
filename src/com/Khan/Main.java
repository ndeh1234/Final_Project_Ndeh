package com.Khan;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {



    private CollegeGUI gui;
    private CollegeDB db;
    private static Controller controller;

    public static void main(String[] args) {

        CollegeDB db = new CollegeDB();
        CollegeGUI gui = new CollegeGUI( controller);




    }
}