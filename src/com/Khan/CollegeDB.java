package com.Khan;

import org.omg.PortableInterceptor.ORBInitInfoPackage.DuplicateName;

import java.sql.*;
import java.util.ArrayList;

import static sun.plugin.javascript.navig.JSType.URL;

public class CollegeDB {


    // Declare and innitialize table and  column  names

    private static final String OK = "OK";                // Table names
    private static final String FirstName = "SFName";
    private static final String TABLE_NAME1 = "students";
    private static final String TABLE_NAME2 = "instructors";
    private static final String TABLE_NAME3 = "courses";
    private static final String TABLE_NAME4 = "sections";
    private static final String TABLE_NAME5 = "prerequisites";

          // Column names

    static final String ID_COL = "courseID";
    static final String SECTION_COL = "section";
    static final String CNAME_COL = "className";
    static final String CrHr_COL = "creditHours";
    static final String INSTRUCTOR_COL = "Instructor";
    static final String CTIME_COL = "classTime";
    static final String DAYS_COL = "days";
    static final String BLDGROOM_COL = "bldgRoom";
    static final String SID_COL = "SID";
    static final String SFName_COL = "SFName";
    static final String SLName_COL = "SLName";
    private CollegeDB collegeProgram;


   public static void main(String[] args) {
       String url = "jdbc:sqlite:College.db";

       try (Connection con = DriverManager.getConnection(url)) {
           if (con != null) {
               DatabaseMetaData metaData = con.getMetaData();
               System.out.println("The driver name is " + metaData.getDriverName());
           } else{
               System.out.println("There is no connection");

               con.close();
           }

       } catch (SQLException e) {

           e.getMessage();
       }

   }
        private void createTable3 () {  // Create courses table

            try (Connection con = DriverManager.getConnection(URL)) {
                Statement statement = con.createStatement();

                String createTableSql = "CREATE TABLE IF NOT EXISTS courses (id INTEGER PRIMARY KEY, courseID TEXT, sections TEXT NOT NULL, className TEXT NOT NULL,creditHours int NOT NULL, Instructor TEXT NOT NULL,ClassTime TEXT NOT NULL, Days TEXT NOT NULL, bldgRoom TEXT ) ";
                statement.execute(createTableSql);

                                       // Populate courses table

                String insertDataSql = "INSERT INTO courses(courseID, sectionName , className, creditHours,Instructor,ClassTime,Days,bldgRoom) VALUES('ITEC2545',01,'Java Programing',6,'Brian','9:45am-12:30pm','Tu/Wed','T3030')";
                statement.execute(insertDataSql);

            } catch (SQLException sqle) {

                if (sqle.getMessage().contains("Course exists already")) {

                } else if (sqle.getMessage().contains("Prequisite not completed ")) {

                } else {
                    throw new RuntimeException(sqle);
                }

            }

        }
        private void createTable1 () {
            try (Connection con = DriverManager.getConnection(URL)) {
                Statement statement = con.createStatement();

                // Create students table

                String createTableSql = "CREATE TABLE IF NOT EXISTS students (id INTEGER PRIMARY KEY, studentID TEXT NOT NULL,courseID NOT NULL,FOREIGN KEY(courseID) REFERENCES courses(courseID), sFName TEXT,sLName,className TEXT, Instructor TEXT,ClassTime TEXT, Days TEXT, bldgRoom TEXT )";
                statement.execute(createTableSql);

                // Populate students table

                String insertDataSql = "INSERT INTO students(studentID, studentName, className,Instructor,ClassTime,Days,bldgRoom) VALUES('ITEC2545','Java Programing','Paul', 'Mark','Brian','9:45am-12:30pm','Tu/Wed','T3030')";
                statement.execute(insertDataSql);
                insertDataSql = "INSERT INTO students (studentID,sFName, sLName, className,Instructor,ClassTime,Days,bldgRoom) VALUES('ITEC2545','Java Programing','Henriette', 'Marie','Brian','9:45am-12:30pm','Tu/Wed','T3030')";
                statement.execute(insertDataSql);


            } catch (SQLException sqle) {

                if (sqle.getMessage().contains("Student exists already")) {

                } else if(sqle.getMessage().contains("Does not meet the requirement")){

                } else {
                    throw new RuntimeException(sqle);
                }
            }
        }



        private void createTable2 () {
            try (Connection con = DriverManager.getConnection(URL)) {
                Statement statement = con.createStatement();

                //  Create  instructors table

                String createTableSql = " CREATE TABLE IF NOT EXISTS instructors (id INTEGER PRIMARY KEY, instructorID int NOT NULL, studentID TEXT NOT NULL,courseID NOT NULL,FOREIGN KEY(courseID) REFERENCES courses(courseID), iFName TEXT, iLName TEXT, className TEXT,ClassTime TEXT, Days TEXT, bldgRoom TEXT )";
                statement.execute(createTableSql);

                // Populate  instructor table

                String insertDataSql = "INSERT INTO instructors (instructorID,iFName,iLName, className,ClassTime,Days,bldgRoom) VALUES(001,'Paul', 'Mark','Cisco NetWorking','9:45am-12:30pm','Tu/Wed','T3030')";
                statement.execute(insertDataSql);
                insertDataSql = "INSERT INTO instructors (instructorID,iFName,iLName, className,ClassTime,Days,bldgRoom) VALUES(002,' Zach', 'Speedling','Computer Hardware Basics','9:45am-12:30pm','Mon/Fr','T3030')";
                statement.execute(insertDataSql);

            } catch (SQLException sqle) {

                if (sqle.getMessage().contains("Instructor exists already")) {

                } else {


                    throw new RuntimeException(sqle);
                }

            }
        }

        // Create  sections table

        private void createTable4 () {

            try (Connection con = DriverManager.getConnection(URL)) {

                Statement statement = con.createStatement();


                String createTableSql = " CREATE TABLE IF NOT EXISTS sections (id INTEGER PRIMARY KEY, studentID TEXT NOT NULL,courseID NOT NULL,FOREIGN KEY(courseID) REFERENCES courses(courseID),sectionName NOT NULL, startTime TEXT, endTime TEXT, className TEXT, Days TEX )";
                statement.execute(createTableSql);

                // Populate section table with data

                String insertDataSql = "INSERT INTO sections ( sectionName, className, startTime, endTime, Days) VALUES('Period 1', '3:00pm','6:00pm','English101','Mon/Fr')";
                insertDataSql = "INSERT INTO sections  (sectionName, className, startTime, endTime, Days) VALUES('Period 2', '3:00pm','6:00pm','Sociology322','Tu/Th')";
                statement.execute(insertDataSql);

            } catch (SQLException sqle) {

                if (sqle.getMessage().contains("Section exists already")) {

                } else {
                    throw new RuntimeException(sqle);
                }
            }
        }
        // Create Prerequisites table

        private void createTable5 () {


            try (Connection con = DriverManager.getConnection(URL)) {
                Statement statement = con.createStatement();


                String createTableSql = "CREATE TABLE IF NOT EXISTS prerequisites(id INTEGER PRIMARY KEY, NOT NULL, courseID NOT NULL,FOREIGN KEY(courseID) REFERENCES courses(courseID),className TEXT,creditHours, Instructor TEXT NOT NULL, FOREIGN KEY(InstructorID) REFERENCES Instructors(InstructorID),ClassTime TEXT, Days TEXT, bldgRoom TEXT )";
                statement.execute(createTableSql);

                // Populate prerequisites table with data

                String insertDataSql = "INSERT INTO prerequisites (courseID) VALUES('ITEC1150','ITEC1100','ITEC1110','ITEC1250') ";
                statement.execute(insertDataSql);


            } catch (SQLException sqle) {

                if (sqle.getMessage().contains("Prerequisite exists already")) {

                } else {


                    throw new RuntimeException(sqle);
                }
            }
        }

        // Query for data from 4 tables using inner join

        ArrayList<CollegeProgram> fetchAllRecords () {
            ArrayList<CollegeProgram> allRecords = new ArrayList<CollegeProgram>();

            try (Connection con = DriverManager.getConnection(URL)) {   //

                Statement statement = con.createStatement();
                String selectAll = "SELECT sections, className, creditHours, Instructor, classTime, Days, bldgRoom FROM courses ORDER BY courseID inner join students ON courses.coursesID" +
                        "=students.coursesID inner join Instructors ON students.studentsID = Instructors.studentsID inner join sections ON Instructors.InstructorsID =" +
                        "sections.InstructorsID";
                ResultSet rsAll = statement.executeQuery(selectAll);
                System.out.println("Sections ClassName CreditHours Instructor ClassTime Days BldgRoom");


                while (rsAll.next()) {

                    String sections = rsAll.getString("sections");
                    String className = rsAll.getString("className");
                    int creditHours = rsAll.getInt("creditHours");
                    String Instructor = rsAll.getString("Instructor");
                    String classTime = rsAll.getString("classTime");
                    String Days = rsAll.getString("Days");
                    String bldgRoom = rsAll.getString("bldgRoom");
                    System.out.println(sections + " " + className + " " + creditHours + " " + Instructor + " " + classTime + " " + Days + " " + bldgRoom);

                System.out.println();
                System.out.println();
                }

                rsAll.close();

                return allRecords;  // Returns all records
                // If there is no data, this will be empty

            } catch (SQLException sqle) {

                throw new RuntimeException(sqle);


            }
        }


        // Insert new data in the courrses table

        public String addRecord (CollegeProgram collegeProgram){

            String addStudentsSQL = "INSERT INTO " + TABLE_NAME1 + "VALUES ( ?, ?, ?,?, ? ,?, ? ,?)";
            final int SQLITE_CONSTRAINT_PRIMARYKEY = 22;

            try (Connection conn = DriverManager.getConnection(URL)) {

                PreparedStatement addStudentPs = conn.prepareStatement(addStudentsSQL);

                addStudentPs.setString(1, collegeProgram.getStudentID());
                addStudentPs.setString(2, collegeProgram.getSFName());
                addStudentPs.setString(3, collegeProgram.getSLName());
                addStudentPs.setString(4, collegeProgram.getSections());
                addStudentPs.setString(5, collegeProgram.getClassName());
                addStudentPs.setInt(6, collegeProgram.getCreditHours());
                addStudentPs.setString(7, collegeProgram.getInstructor());
                addStudentPs.setString(8, collegeProgram.getClassTime());
                addStudentPs.setString(9, collegeProgram.getDays());
                addStudentPs.setString(10, collegeProgram.getbldgRoom());

                addStudentPs.execute();

                return OK;

            } catch (SQLException sqle) {

                if (sqle.getErrorCode() == SQLITE_CONSTRAINT_PRIMARYKEY) {

                    return "Duplicate studentID";

                } else {
                    throw new RuntimeException(sqle);
                }
            }
        }

        // Insert new data in the students table

        public String addRecord () {

            String addCollegeProgramSQL = "INSERT INTO" + TABLE_NAME3 + "VALUES (?, ?, ?, ?, ?, ?,?,?)";
            final int SQLITE_CONSTRAINT_PRIMARYKEY = 12;

            try (Connection conn = DriverManager.getConnection(URL)) {

                PreparedStatement addCollegeProgramPs = conn.prepareStatement(addCollegeProgramSQL);

                addCollegeProgramPs.setString(1, collegeProgram.getCourseID());
                addCollegeProgramPs.setString(2, collegeProgram.getSections());
                addCollegeProgramPs.setString(3, collegeProgram.getClassName());
                addCollegeProgramPs.setString(4, collegeProgram.getCreditHours());
                addCollegeProgramPs.setString(5, collegeProgram.getInstructor());
                addCollegeProgramPs.setString(6, collegeProgram.getClassTime());
                addCollegeProgramPs.setString(7, collegeProgram.getDays());
                addCollegeProgramPs.setString(8, collegeProgram.getSFName());
                addCollegeProgramPs.setString(9, collegeProgram.getSLName());
                addCollegeProgramPs.setString(10, collegeProgram.getbldgRoom());

                addCollegeProgramPs.execute();

                return OK;

            } catch (SQLException sqle) {

                if (sqle.getErrorCode() == SQLITE_CONSTRAINT_PRIMARYKEY) {

                    return "Duplicate CollegeProgram name";  // Check for duplicate college program names by checking error code

                } else {
                    throw new RuntimeException(sqle);
                }
            }
        }

        // SQL delete statement

        void delete (CollegeProgram collegeProgram){
            // Delete class from courses table, under class name column

            String deleteSQL = "DELETE FROM" + TABLE_NAME3 + " WHERE" + CNAME_COL + "=?";

            try (Connection conn = DriverManager.getConnection(URL)) {
                PreparedStatement deletePreparedStatement = conn.prepareStatement(deleteSQL);

                deletePreparedStatement.setString(1, collegeProgram.getClassName());
                deletePreparedStatement.execute();


            } catch (SQLException sqle) {
                throw new RuntimeException(sqle);
            }

        }
             // Need these methods, but they don't need any code

        private static String getCourseID () {
            return null;
        }

        private static String getbldgRoom () {
            return null;
        }

        private static String getDays () {
            return null;
        }

        private static String getClassTime () {
            return null;
        }

        private static String getInstructor () {
            return null;
        }

        private static String getCreditHours () {
            return null;
        }

        private static String getClassName () {
            return null;
        }

        private static String getSections () {
            return null;
        }

        private static String getStudentID () {
            return null;
        }
        private static String getSFName () {
            return null;
        }
        private static String getSLName () {
            return null;
        }


    }



