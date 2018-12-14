package com.Khan;

import org.omg.PortableInterceptor.ORBInitInfoPackage.DuplicateName;

import java.sql.*;
import java.util.ArrayList;

import static sun.plugin.javascript.navig.JSType.URL;

public class CollegeDB {


    private static final String OK = "OK";
    String url = "jdbc:sqlite:college.sqlite";   // Connection String

    // Declare and innitialize table column  names

    private static final String TABLE_NAME1 = "students";
    private static final String TABLE_NAME2 = "instructors";
    private static final String TABLE_NAME3 = "courses";
    private static final String TABLE_NAME4 = "sections";
    private static final String TABLE_NAME5 = "prerequisites";
    static final String ID_COL = "courseID";
    static final String SECTION_COL = "section";
    static final String CNAME_COL = "className";
    static final String CrHr_COL = "creditHours";
    static final String INSTRUCTOR_COL = "Instructor";
    static final String CTIME_COL = "classTime";
    static final String DAYS_COL = "days";
    static final String BLDGROOM_COL = "bldgRoom";


    CollegeDB() {
        createTable1();
    }


    private void createTable1() {

        try (Connection con = DriverManager.getConnection(URL)) {
            Statement statement = con.createStatement();

            String createTableSql = "CREATE TABLE IF NOT EXISTS courses ( INTEGER PRIMARY KEY, courseID TEXT, sections TEXT, className TEXT,creditHours int, Instructor TEXT,ClassTime TEXT, Days TEXT, bldgRoom TEXT ) ";
            statement.execute(createTableSql);

            String insertDataSql = "INSERT INTO courses(courseID, sectionName , className, creditHours,Instructor,ClassTime,Days,bldgRoom) VALUES('ITEC2545',01,'Java Programing',6,'Brian','9:45am-12:30pm','Tu/Wed','T3030')";
            statement.execute(insertDataSql);

        } catch (SQLException sqle) {


            throw new RuntimeException(sqle);
        }

    }


    private void createTable2() {
        try (Connection con = DriverManager.getConnection(URL)) {
            Statement statement = con.createStatement();

            String createTableSql = "CREATE TABLE IF NOT EXISTS students (id INTEGER PRIMARY KEY, studentID TEXT, sFName TEXT,sLName,className TEXT, Instructor TEXT,ClassTime TEXT, Days TEXT, bldgRoom TEXT )";
            statement.execute(createTableSql);

            String insertDataSql = "INSERT INTO students(studentID,studentName, className,Instructor,ClassTime,Days,bldgRoom) VALUES('ITEC2545','Java Programing','Paul', 'Mark','Brian','9:45am-12:30pm','Tu/Wed','T3030')";
            statement.execute(insertDataSql);
            insertDataSql = "INSERT INTO students (studentID,sFName, sLName, className,Instructor,ClassTime,Days,bldgRoom) VALUES('ITEC2545','Java Programing','Henriette', 'Marie','Brian','9:45am-12:30pm','Tu/Wed','T3030')";
            statement.execute(insertDataSql);


        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);
        }
    }

    private void createTable3() {
        try (Connection con = DriverManager.getConnection(URL)) {
            Statement statement = con.createStatement();

            String createTableSql = " CREATE TABLE IF NOT EXISTS instructors (id INTEGER PRIMARY KEY, instructorID int, iFName TEXT, iLName TEXT, className TEXT,ClassTime TEXT, Days TEXT, bldgRoom TEXT )";
            statement.execute(createTableSql);

            String insertDataSql = "INSERT INTO instructors (instructorID,iFName,iLName, className,ClassTime,Days,bldgRoom) VALUES(001,'Paul', 'Mark','Cisco NetWorking','9:45am-12:30pm','Tu/Wed','T3030')";
            statement.execute(insertDataSql);
            insertDataSql = "INSERT INTO instructors (instructorID,iFName,iLName, className,ClassTime,Days,bldgRoom) VALUES(002,' Zach', 'Speedling','Computer Hardware Basics','9:45am-12:30pm','Mon/Fr','T3030')";
            statement.execute(insertDataSql);

        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);
        }

    }

    private void createTable4() {

        try (Connection con = DriverManager.getConnection(URL)) {

            Statement statement = con.createStatement();


            String createTableSql = " CREATE TABLE IF NOT EXISTS sections (id INTEGER PRIMARY KEY, sectionName, startTime TEXT, endTime TEXT, className TEXT, Days TEX )";
            statement.execute(createTableSql);


            String insertDataSql = "INSERT INTO sections ( sectionName, className, startTime, endTime, Days) VALUES('Period 1', '3:00pm','6:00pm','English101','Mon/Fr')";
            insertDataSql = "INSERT INTO sections  (sectionName, className, startTime, endTime, Days) VALUES('Period 2', '3:00pm','6:00pm','Sociology322','Tu/Th')";
            statement.execute(insertDataSql);

        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);
        }
    }

    // Query for all data

    ArrayList<CollegeDB> fetchAllRecords() {
        ArrayList<CollegeDB> allRecords = new ArrayList<CollegeDB>();

        try (Connection con = DriverManager.getConnection(URL)) {

            Statement statement = con.createStatement();

            String selectAllSQL = "SELECT * FROM" + TABLE_NAME1 + TABLE_NAME2 + TABLE_NAME3 + TABLE_NAME4 + TABLE_NAME5;
            ResultSet rsAll = statement.executeQuery(selectAllSQL);

                // Loop over the result set from column to column

            while (rsAll.next()) {
                String courseID = rsAll.getString(ID_COL);
                String sections = rsAll.getString(SECTION_COL);
                String className = rsAll.getString(CNAME_COL);
                String creditHours = rsAll.getString(CrHr_COL);
                String Instructor = rsAll.getString(INSTRUCTOR_COL);
                String classTime = rsAll.getString(CTIME_COL);
                String days = rsAll.getString(DAYS_COL);
                String bldgRoom = rsAll.getString(DAYS_COL);
                CollegeDB CollegeRecords = new CollegeDB();

                allRecords.add(CollegeRecords);


            }

            rsAll.close();

            return allRecords;  // Returns all records
                                // If there is no data, this will be empty

        } catch (SQLException sqle) {

            throw new RuntimeException(sqle);


        }
    }
           // Insert new data

    public String addRecord(CollegeDB collegeDB) {

        String addCoursesSQL = "INSERT INTO " + TABLE_NAME1 + "VALUES ( ?, ?, ?,?, ? ,?, ? ,?)";
        final int SQLITE_CONSTRAINT_PRIMARYKEY = 12;

        try(Connection conn = DriverManager.getConnection(URL)){

            PreparedStatement addCoursesPs = conn.prepareStatement(addCoursesSQL);

            addCoursesPs.setString(1, CollegeDB.getCourseID());
            addCoursesPs.setString(2, CollegeDB.getSections());
            addCoursesPs.setString(3, CollegeDB.getClassName());
            addCoursesPs.setString(4, CollegeDB.getCreditHours());
            addCoursesPs.setString(5, CollegeDB.getInstructor());
            addCoursesPs.setString(6, CollegeDB.getClassTime());
            addCoursesPs.setString(7, CollegeDB.getDays());
            addCoursesPs.setString(8, CollegeDB.getbldgRoom());

            addCoursesPs.execute();

            return OK;

        } catch (SQLException sqle) {

            if(sqle.getErrorCode()==SQLITE_CONSTRAINT_PRIMARYKEY){

                return "Duplicate CourseID";

            }else{
                throw new RuntimeException(sqle);
            }
        }
    }

    private static String getbldgRoom() {
        return null;
    }

    private static String getDays() {
        return null;
    }

    private static String getClassTime() {
        return null;
    }

    private static String getInstructor() {
        return null;
    }

    private static String getCreditHours() {
        return null;
    }

    private static String getClassName() {
        return null;
    }

    private static String getSections() {
        return null;
    }

    private static String getCourseID() {
        return null;
    }



}


