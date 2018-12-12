package com.Khan;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class CollegeDB {


    private static final String DB_CONNECTION_URL = "jdbc:sqlite:college.sqlite";   // Connection String

    private static final String TABLE_NAME1 = "students";
    private static final String TABLE_NAME2 = "instructors";
    private static final String TABLE_NAME3 = "courses";
    private static final String TABLE_NAME4 = "section";
    private static final String TABLE_NAME5 = "prerequisites";


    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection(DB_CONNECTION_URL);
        Statement statement = connection.createStatement();

        String createTableSql = "CREATE TABLE IF NOT EXISTS courses(id INTEGER PRIMARY KEY, courseID TEXT, className TEXT, Instructor TEXT,ClassTime TEXT, Days TEXT, bldgRoom TEXT )";
        statement.execute(createTableSql);



        String insertDataSql =("INSERT INTO courses(courseID,className,Instructor,ClassTime,Days,bldgRoom) VALUES('ITEC2545','Java Programing','Brian','9:45am-12:30pm','Tu/Wed','T3030')");
        statement.execute(insertDataSql);

        insertDataSql =("INSERT INTO  students(courseID,className,Instructor,ClassTime,Days,bldgRoom) VALUES('ITEC2425','Steve','12:30pm-3:00pm', 'Thu','T300')");
        statement.execute(insertDataSql);

        String getAllCoursesSql = "SELECT * FROM courses";
        ResultSet allCourses = statement.executeQuery(getAllCoursesSql);

        while(allCourses.next()){
            String courseID = allCourses.getString("CourseID");
            String courseName = allCourses.getString("className");
            String professor = allCourses.getString("Instructor");
            String time = allCourses.getString("classTime");
            String days = allCourses.getString("Days");
            String hallNumber = allCourses.getString("bldgRoom");

            System.out.printf("%s %s holds on %s at %s in %s and the %s name is\n", courseID, courseName, professor, time, days, hallNumber);

        }
         allCourses.close();

    }
}









