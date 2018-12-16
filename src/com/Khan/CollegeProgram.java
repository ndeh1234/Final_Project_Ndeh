package com.Khan;

public class CollegeProgram {


    private String courseID;
    private  String className;
    private  String Instructor;
    private  String classTime;
    private String Days;
    private String bldgRoom;
    private String sections;
    private int creditHours;
    private String studentID;
    private String SFName;
    private String SLName;



    CollegeProgram( String ci,String sec,String cn,int CrHr,String I,String ct,String D,String SID,String SFNAME, String SLNAME,  String bldgR){
        courseID = ci;
        className = cn;
        Instructor = I;
        classTime = ct;
        Days = D;
        bldgRoom = bldgR;
        sections= sec;
        creditHours = CrHr;
        studentID = SID;
        SFName = SFNAME;
        SLName = SLNAME;

    }

        // Getter and Setter methods, toString

    public  String getCourseID() {
        return courseID;

    }

    public String getSections() {
        return sections;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public  String getDays() {

        return Days;
    }


    public void setCourseID(String courseID){
        this.courseID = courseID;

    }

    public String getClassName(){
        return className;
    }
    public void setClassName(String className){
        this.className=className;
    }

    public void setInstructor(String Instructor){
        this.Instructor = Instructor;
    }

    public  String getInstructor(){
        return Instructor;
    }

    public void setClassTime(String classTime){
        this.classTime = classTime;
    }
    public  String getClassTime(){

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

    public String getStudentID() {

        return studentID;
    }

    public String getSFName() {

        return SFName;
    }

    public String getSLName() {
        return SLName;
    }

    public String getbldgRoom() {
        return bldgRoom;
    }
    @Override
    public String toString(){

        return "student: " +courseID+ "is" +className+ "is taught by" +Instructor+ "at" +classTime+ "on" +Days+ "in" +bldgRoom;


    }



}
