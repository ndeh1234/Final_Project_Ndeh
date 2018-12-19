Final_Project_Ndeh

                                            	
This project is about an GUI application that manages a college registration system whereby, students can register for classes, drop classes, and print roster for each class as well.
Database setup:
I have created a college relational database with five tables (Objects). The first table is a student table. The student table has the following columns: Id, first name, middle name, last name, date of birth, courses, and registration date. The second table is the Instructor table, and has the following columns: Id, first name, middle name, last name, date of birth, courses. The third table is the Course table, and has the following columns: Id, Name, Credit Hours, Teacher, Students, Hours, Days, Section. The fourth table is the Section Table, and has the following columns: Id, Start Time, End Time, Day, Course. The fifth table is the Prerequisites Table, and has the following columns: Id, courses, Credit Hours.
      In order to keep references synchronized, I have used primary and foreign keys to enforce referential integrity by enabling it for a table relationship. Display a “not allow” message when a student tries to register for courses when the corresponding prerequisite course has not been taken.  In order to check for conflicts in a student’s schedule, I have defined a check constraint that must be met by each course in the Course Table. (Reference the prerequisites table). A student is not allowed to be in two different classrooms at the same time. A student is not also allowed to register for more than 12 credit hours.
Classes to be created:
•	CollegeGUI.java.  for the UI
•	CollegeDB.java for database interaction
•	College.java to represent objects stored in the database
•	Controller.java to manage interactions between UI and database
CourseGUI.form design:
I am going to add the following components and corresponding names to CollegeGUI.form
•	JTextField = ClassNameTextField. For the class name
•	JTextField = enterCourseIdTextField. For the course student want to register or drop
•	JButton = Register. Student will click this button to confirm registration for a class
•	JButton = DropClassButton. Students will click this to drop a class.
•	JTextField = enterFirsttNameTextField. For the student/instructor first name
•	JTextField = enterMiddleNameTextField. For the student/instructor middle name
•	JTextField = enterLastNameTextField. For the student/instructor last name
•	JButton = MyscheduleButton. Student/Instructor will click on this to display schedule.

The program assumes that students can enter only course ID to register for a class. Students will need to enter both student Id and full name to be able to search for student information. Instructors will also need to enter both ID and full name to be able to retrieve data from the database. Students cannot register for the same course more than once. If a student enters a class for which he/she is registered already, display an error message and prompts the student to try again. 




																				
