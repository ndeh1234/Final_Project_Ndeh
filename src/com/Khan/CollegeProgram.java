package com.Khan;

public class CollegeProgram {


    private String courseID;
    private static String className;
    private static String Instructor;
    private static String classTime;
    private String Days;
    private String bldgRoom;



    CollegeProgram(String courseID, String sections, String ci, String cn, String I, String ct, String D, String bldgR){
        this.courseID = ci;
        className = cn;
        Instructor = I;
        classTime = ct;
        Days = D;
        bldgRoom = bldgR;

    }

    public static String getCourseID() {
        return null;

    }

    public static String getSections() {
        return null;
    }

    public static String getCreditHours() {
        return null;
    }

    public static String getDays() {

        return null;
    }


    public String courseID(){
        return courseID;
    }
    public void setCourseID(String courseID){
        this.courseID = courseID;

    }

    public static String getClassName(){
        return className;
    }
    public void setClassName(String className){
        this.className=className;
    }

    public void setInstructor(String Instructor){
        this.Instructor = Instructor;
    }

    public static String getInstructor(){
        return Instructor;
    }

    public void setClassTime(String classTime){
        this.classTime = classTime;
    }
    public static String getClassTime(){

        return classTime;
    }

    public void setDays(String Days){
        this.Days = Days;
    }

    public void setbldgRoom(String bldgRoom){
        this.bldgRoom =bldgRoom;
    }

    public String getBldgRoom(){
        return bldgRoom;
    }
    @Override
    public String toString(){

        return "student: " +courseID+ "is" +className+ "is taught by" +Instructor+ "at" +classTime+ "on" +Days+ "in" +bldgRoom;


    }
}
