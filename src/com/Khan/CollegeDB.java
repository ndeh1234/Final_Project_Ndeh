package com.Khan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class CollegeDB {

    private static final String DB_CONNECTION_URL = "jdbc:sqlite:college.sqlite";   // Connection String

    private static final String TABLE_NAME1 = "students";
    private static final String TABLE_NAME2 = "instructors";
    private static final String TABLE_NAME3 = "courses";
    private static final String TABLE_NAME4 = "section";
    private static final String TABLE_NAME5 = "prerequisites";


    private String createTableSQL = "CREATE TABLE IF NOT EXISTS students(id INTEGER PRIMARY KEY, courseID TEXT, className TEXT, Instructor TEXT,ClassTime TEXT, Days TEXT, bldgRoom TEXT )";
    private String PRINT_CLASS_ROSTER = "SELECT * FROM students";

    CollegeDB() {
        createTable();

    }

    private void createTable() {

        try (Connection connection = DriverManager.getConnection(DB_CONNECTION_URL)) {
            Statement statement = connection.createStatement();

            statement.executeUpdate(createTableSQL);

            statement.executeUpdate("INSERT INTO students(courseID,className,Instructor,ClassTime,Days,bldgRoom) VALUES('ITEC2545','Java Programing','Brian','9:45am-12:30pm','Tu/Wed','T3030')");
            statement.executeUpdate("INSERT INTO  students(courseID,className,Instructor,ClassTime,Days,bldgRoom) VALUES('ITEC2425','Steve','12:30pm-3:00pm', 'Thu','T300')");


        } catch (SQLException e) {

            if (e.getMessage().contains("(table students already exixts")) { // Ignore table already exixts

            } else {

                throw new RuntimeException(e);
            }
        }
    }


      private  String createTableSQL1 = "CREATE TABLE IF NOT EXISTS instructors (id INTEGER PRIMARY KEY, instructorID TEXT, className TEXT, classTime TEXT, Days TEXT, bldgRoom TEXT)";
         String PRINT_CLASS_ROSTER1 = "SELECT * FROM instructors";



        public ArrayList<CollegeProgram> fetchAllRecords () {
            return null;
        }
    }







