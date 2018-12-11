package com.Khan;

public class CollegeProgram {


    private String courseID;
    private String className;
    private String Instructor;
    private String classTime;
    private String Days;
    private String bldgRoom;



    CollegeProgram(String ci, String cn, String I,String ct,String D, String bldgR){
        courseID = ci;
        className = cn;
        Instructor = I;
        classTime = ct;
        Days = D;
        bldgRoom = bldgR;

    }

    public String courseID(){
        return courseID;
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

    public String getInstructor(){
        return Instructor;
    }

    public void setClassTime(String classTime){
        this.classTime = classTime;
    }
    public String getClassTime(){

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
