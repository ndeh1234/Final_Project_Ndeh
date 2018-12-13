package com.Khan;

import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Vector;

import static javax.xml.ws.soap.AddressingFeature.ID;
import static sun.plugin.javascript.navig.JSType.URL;

public class CollegeDB {


    String url = "jdbc:sqlite:college.sqlite";   // Connection String
    
    private static final String TABLE_NAME1 = "students";
    private static final String TABLE_NAME2 = "instructors";
    private static final String TABLE_NAME3 = "courses";
    private static final String TABLE_NAME4 = "section";
    private static final String TABLE_NAME5 = "prerequisites";



    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection(URL);
        Statement statement = connection.createStatement();

        // Create the course table
        String createTableSql = "CREATE TABLE IF NOT EXISTS courses(id INTEGER PRIMARY KEY, courseID TEXT, className TEXT, Instructor TEXT,ClassTime TEXT, Days TEXT, bldgRoom TEXT )";
       statement.execute(createTableSql);




        // Populating the course table

        String insertDataSql = ("INSERT INTO courses(courseID,className,Instructor,ClassTime,Days,bldgRoom) VALUES('ITEC2545','Java Programing','Brian','9:45am-12:30pm','Tu/Wed','T3030')");
        statement.execute(insertDataSql);

        insertDataSql = ("INSERT INTO  courses (courseID,className,Instructor,ClassTime,Days,bldgRoom) VALUES('ITEC2425','Steve','12:30pm-3:00pm', 'Thu','T300')");
        statement.execute(insertDataSql);

        String getAllCoursesSql = "SELECT * FROM courses";
        ResultSet allCourses = statement.executeQuery(getAllCoursesSql);

        // Loop over the result set using next method() in a while loop
        while (allCourses.next()) {
            String courseID = allCourses.getString("CourseID");
            String courseName = allCourses.getString("className");
            String professor = allCourses.getString("Instructor");
            String time = allCourses.getString("classTime");
            String days = allCourses.getString("Days");
            String hallNumber = allCourses.getString("bldgRoom");

            System.out.printf("%s %s holds on %s at %s in %s and the %s name is\n", courseID, courseName, professor, time, days, hallNumber);

        }
        allCourses.close();  // close result set
        statement.close();   // close statement
        connection.close(); // Close connection


        // Create students table

        createTableSql = "CREATE TABLE IF NOT EXISTS students (id INTEGER PRIMARY KEY, studentID TEXT, studentName TEXT,className TEXT, Instructor TEXT,ClassTime TEXT, Days TEXT, bldgRoom TEXT )";
        statement.execute(createTableSql);
        // Populate student table with data

        insertDataSql = "INSERT INTO students(studentID,studentName, className,Instructor,ClassTime,Days,bldgRoom) VALUES('ITEC2545','Java Programing','Paul Mark','Brian','9:45am-12:30pm','Tu/Wed','T3030')";
        statement.execute(insertDataSql);
        insertDataSql = "INSERT INTO students (studentID,studentName, className,Instructor,ClassTime,Days,bldgRoom) VALUES('ITEC2545','Java Programing','Henriette Marie','Brian','9:45am-12:30pm','Tu/Wed','T3030')";
        statement.execute(insertDataSql);

        String getAllStudentsSql = "SELECT * FROM students";
        ResultSet allStudents = statement.executeQuery(getAllStudentsSql);

        // Loop over the result set
        while (allStudents.next()) {

            String studentID = allStudents.getString("StudentID");
            String studentName = allStudents.getString("studentName");
            String courseName = allStudents.getString("className");
            String professor = allStudents.getString("Instructor");
            String time = allStudents.getString("classTime");
            String days = allStudents.getString("Days");
            String hallNumber = allStudents.getString("bldgRoom");

            System.out.printf("%s %s has %s at %s on %s in %s and the %s name is \n", studentID, studentName, courseName, time, days, hallNumber);

        }

        allStudents.close();  // Close result set
        statement.close();    // Close statement
        connection.close();  // Close connection

    }
        Vector getColumnNames(){

        Vector colNames = new Vector();
         colNames.add("ID");
         colNames.add("courseID");
         colNames.add("className");
         colNames.add("Instructor");
         colNames.add("classTime");
         colNames.add("Days");
         colNames.add("bldgRoom");

         return colNames;
    }
       // Getting data to store to be stored as String

     Vector<Vector> getAllCourses() {
        try(Connection connection = DriverManager.getConnection(url)){
            Statement statement = connection.createStatement();

            ResultSet rs =  statement.executeQuery(getAllCourses())

            Vector<Vector>Vectors = new Vector<>();

            int id;
            String courseID , className,Instructor,classTime,Days,bldgRoom;

             while(rs.next()){
                 id = rs.getInt(ID);
                 courseID = rs.getString(courseID);
                 className = rs.getString(className);
                 Instructor = rs.getString(Instructor);
                 classTime = rs.getString(classTime);
                 Days = rs.getString(Days);
                 bldgRoom = rs.getString(bldgRoom);
                 Vector v = new Vector();
                 v.add(id); v.add(courseID); v.add(className); v.add(Instructor);
                 v.add(classTime);v.add(Days);v.add(bldgRoom);
                 Vectors.add(v);

                 return Vectors;

             }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }

         return null;
     }

    public Vector getAllStudents() {
        return null;
    }

    DefaultTableModel tableModel = new DefaultTableModel();
}








