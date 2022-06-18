import javax.swing.*;
import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Student extends Person {
    // --------------- Attributes ---------------
    private int stdNo;
    private int gradeAverage;
    private ArrayList<String> announcement;
    // --------------- Relations ---------------
    private ArrayList<Class> classes;


    // --------------- Methods ---------------
    // log-in method
    public static Student logIn() {

        int stdNo = Integer
                .parseInt(JOptionPane.showInputDialog(null, "Please Enter Your Student Number:",
                        "Student Log In",
                        JOptionPane.QUESTION_MESSAGE).toLowerCase());

        if (Database.isAvailableStudent(stdNo)) {
            String password = JOptionPane.showInputDialog(null, "Please Enter Your Password:",
                    "Student Log In",
                    JOptionPane.QUESTION_MESSAGE);

            Student currentStudent = Database.getStudentFromStdNo(stdNo);

            if (password.equals(currentStudent.getPassword())) {
                JOptionPane.showMessageDialog(null, "Hooray! You Log In Successfully :)",
                        "Student Log In",
                        JOptionPane.INFORMATION_MESSAGE);
                return currentStudent;
            } else {
                JOptionPane.showMessageDialog(null, "Wrong Password :/\n Do the process again!",
                        "Student Log In",
                        JOptionPane.ERROR_MESSAGE);
            }

        } else
            JOptionPane.showMessageDialog(null, "No Such userID Found :(", "Log In Failed.",
                    JOptionPane.ERROR_MESSAGE);

        return null;

    }

    public static Student signUp() {
        String firstName = JOptionPane.showInputDialog(null,
                "Please Enter Your First Name:", "Student Sign-Up Operation",
                JOptionPane.QUESTION_MESSAGE);

        String lastName = JOptionPane.showInputDialog(null,
                "Please Enter Your Last Name:", "Student Sign-Up Operation",
                JOptionPane.QUESTION_MESSAGE);

        String filed = JOptionPane.showInputDialog(null,
                "Enter Your Filed:", "Student Sign-Up Operation",
                JOptionPane.QUESTION_MESSAGE);

        String password = JOptionPane.showInputDialog(null,
                "Enter Your Password:", "Student Sign-Up Operation",
                JOptionPane.QUESTION_MESSAGE);

        int stdNo;
        do {
            stdNo = Integer
                    .parseInt(JOptionPane.showInputDialog(null,
                            "Enter Your Favorite Std Num XD\n(It has three digits)",
                            "Student Sign-Up Operation",
                            JOptionPane.QUESTION_MESSAGE));
        }while (!Database.isUniqueStdNo(stdNo));

//        int gradeAverage = 0;


        // new the needed class
        ArrayList<Class> classes = new ArrayList<>();
        ArrayList<String> announcement = new ArrayList<>();
        //

        // Adding user to data base
        Student newStudent = new Student(firstName, lastName, filed, password, stdNo,
                0, announcement, classes);

        System.out.println(newStudent.toString());
        Database.getStudentArrayList().add(newStudent);
        JOptionPane.showMessageDialog(null,
                "ha ha ha! You have signed up successfully!",
                "ُStudent Sign-Up Operation",
                JOptionPane.INFORMATION_MESSAGE);

        return newStudent;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stdNo=" + stdNo +
                ", gradeAverage=" + gradeAverage +
                ", classes=" + classes +
                '}';
    }

    public static void showClasses(int stdNo) {
        Student thisStudent = Database.getStudentFromStdNo(stdNo);

       JOptionPane.showInputDialog(null,
                "These are your classes:\n" +
                thisStudent.getClasses(),
                "Student Page",
                JOptionPane.QUESTION_MESSAGE);
    }

    public static void joinClass(int stdNo) {
        Student thisStudent = Database.getStudentFromStdNo(stdNo);

        int chosenClass = Integer.
                parseInt(JOptionPane.showInputDialog(null,
                        "Choose the class which you wanna join:\n" +
                                Database.getClassArrayList(),
                        "Student Page",
                        JOptionPane.QUESTION_MESSAGE));

        Class selectedClass = thisStudent.getClasses().get(chosenClass);

        if (Database.isOverlapped(stdNo, selectedClass)) {
            if (!thisStudent.getClasses().contains(Database.getClassArrayList().getClass())) {
                thisStudent.getClasses().add(Database.getClassArrayList().get(chosenClass));
                JOptionPane.showMessageDialog(null,
                        "Class added successfully :)",
                        "Join Class",
                        JOptionPane.INFORMATION_MESSAGE);
            } else
                JOptionPane.showMessageDialog(null,
                        "You had this class!",
                        "Join Class",
                        JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void answerExam(int stdNo) {
        Student thisStudent = Database.getStudentFromStdNo(stdNo);

        int classCode = Integer.
                parseInt(JOptionPane.showInputDialog(null,
                        "Enter the class code:",
                        "Answer Exam",
                        JOptionPane.QUESTION_MESSAGE));

        Class selectedClass = Database.getClassFromClassCode(classCode);

        if (thisStudent.getClasses().contains(selectedClass)) {
            int examCode = Integer.
                    parseInt(JOptionPane.showInputDialog(null,
                            "Enter the exam code:",
                            "Answer Exam",
                            JOptionPane.QUESTION_MESSAGE));

            Exam thisExam = null;
            if (selectedClass.getExams().contains(Database.getExamArrayList().get(examCode)))
                thisExam = Database.getExamArrayList().get(examCode);

            int numberOfQuestions = thisExam.getQuestionArrayList().size();

            // ----------------- This part is for handling descriptive questions -----------------
            // ----------------- maybe it will cover in the future ;) -----------------
//            ArrayList<String> answers = null;
//            ArrayList<ArrayList<String>>

//            for (int i = 0; i < numberOfQuestions; i++) {
//                String thisQuestionAnswer = JOptionPane.showInputDialog(null,
//                        "Enter your answer for this question:",
//                        "Answer Exam",
//                        JOptionPane.QUESTION_MESSAGE);
//                answers.add(thisQuestionAnswer);
            // ----------------- till here -----------------

            String answerSequence = JOptionPane.showInputDialog(null,
                    "Enter the correct choices respectively." +
                    "\nSeparate the choices with a dash character." +
                    "\nThis Exam has " + numberOfQuestions + "questions",
                    "Exam Answer",
                    JOptionPane.QUESTION_MESSAGE);

            thisExam.getStudentsAnswerStringArrayList().add(answerSequence);

            } else
                JOptionPane.showMessageDialog(null,
                        "You are not in this class, plz join the class first.",
                        "Answer Exam",
                        JOptionPane.INFORMATION_MESSAGE);
        }

    public static void answerHomework(int stdNo) {
        Student thisStudent = Database.getStudentFromStdNo(stdNo);

        int classCode = Integer.
                parseInt(JOptionPane.showInputDialog(null,
                        "Enter the class code:",
                        "Answer Homework",
                        JOptionPane.QUESTION_MESSAGE));

        Class selectedClass = Database.getClassFromClassCode(classCode);

        if (thisStudent.getClasses().contains(selectedClass)) {
            int homeworkCode = Integer.
                    parseInt(JOptionPane.showInputDialog(null,
                            "Enter the homework code:",
                            "Answer Homework",
                            JOptionPane.QUESTION_MESSAGE));

            Homework thisHomework = null;
            if (selectedClass.getHomeworks().contains(Database.getHomeworkArrayList().get(homeworkCode)))
                thisHomework = Database.getHomeworkArrayList().get(homeworkCode);

        }else {
            JOptionPane.showMessageDialog(null,
                    "You are not in this class, plz join the class first.",
                    "Answer Homework",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void seeGradeOfExam(int stdNo) {
        Student thisStudent = Database.getStudentFromStdNo(stdNo);

        int examCode = Integer.
                parseInt(JOptionPane.showInputDialog(null,
                        "Enter the exam code:",
                        "Exam Grade",
                        JOptionPane.QUESTION_MESSAGE));

        Exam thisExam = Database.getExamFromExamCode(examCode);
        HashMap<Student, Integer> studentScores = thisExam.getStudentsExamScores();

        if (Database.getExamFromExamCode(examCode).isCorrected()) {
            // ...
            for (Map.Entry<Student, Integer> studentScoreSet: studentScores.entrySet()) {
                if (studentScoreSet.getKey().equals(thisStudent))
                    JOptionPane.showMessageDialog(null,
                            "This is your score " +
                            studentScoreSet.getValue() +
                            ":=)",
                            "Exam Grade",
                            JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "Unfortunately, the professor didn't correct the exams yet :(",
                    "Exam Grade",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void seeGradeOfHomework(int stdNo) {
        Student thisStudent = Database.getStudentFromStdNo(stdNo);

        int homeworkCode = Integer.
                parseInt(JOptionPane.showInputDialog(null,
                        "Enter the homework code:",
                        "Homework Grade",
                        JOptionPane.QUESTION_MESSAGE));

        Homework thisHomework = Database.getHomeworkFromHomeworkCode(homeworkCode);
        HashMap<Student, Integer> studentScores = thisHomework.getStudentsHwScores();

        if (Database.getHomeworkFromHomeworkCode(homeworkCode).isCorrected()) {
            // ...
            for (Map.Entry<Student, Integer> studentScoreSet: studentScores.entrySet()) {
                if (studentScoreSet.getKey().equals(thisStudent))
                    JOptionPane.showMessageDialog(null,
                            "This is your score " +
                                    studentScoreSet.getValue() +
                                    ":=)",
                            "Homework Grade",
                            JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "Unfortunately, the professor didn't correct the homework yet :(",
                    "Homework Grade",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void readAnnouncement(int stdNo) {

        Student thisStudent = Database.getStudentFromStdNo(stdNo);

        int selectedAnnouncement = Integer.
                parseInt(JOptionPane.showInputDialog(null,
                        "Enter index of Announcement you want to read:\n" +
                                thisStudent.getAnnouncement(),
                        "Read Announcement",
                        JOptionPane.QUESTION_MESSAGE));

        JOptionPane.showMessageDialog(null,
                thisStudent.getAnnouncement().get(selectedAnnouncement),
                "Read Annoucement",
                JOptionPane.INFORMATION_MESSAGE);
    }

//    public static void getAverageGrade(int stdNo) {
//
//        Student thisStudent = Database.getStudentFromStdNo(stdNo);
//
//        int numberOfClasses = thisStudent.getClasses().size();
//        int countOfActivities = 0;
//        int sumOfGrades = 0;
//        for (int i = 0; i < numberOfClasses; i++) {
//            countOfActivities += thisStudent.getClasses().get(i).getHomeworks().size();
//            sumOfGrades += thisStudent.getClasses().get(i).getHomeworks().get()
//            countOfActivities += thisStudent.getClasses().get(i).getExams().size();
//        }
//
//    }


    // --------------- Constructor ---------------
    public Student(String firstName, String lastName, String field, String password,
                   int stdNo, int gradeAverage, ArrayList<String> announcement,
                   ArrayList<Class> classes) {
        super(firstName, lastName, field, password);
        this.stdNo = stdNo;
        this.gradeAverage = gradeAverage;
        this.announcement = announcement;
        this.classes = classes;
    }


    // --------------- Getter_Setter ---------------
    public int getStdNo() {
        return stdNo;
    }

    public void setStdNo(int stdNo) {
        this.stdNo = stdNo;
    }

    public int getGradeAverage() {
        return gradeAverage;
    }

    public void setGradeAverage(int gradeAverage) {
        this.gradeAverage = gradeAverage;
    }

    public ArrayList<Class> getClasses() {
        return classes;
    }

    public void setClasses(ArrayList<Class> classes) {
        this.classes = classes;
    }

    public ArrayList<String> getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(ArrayList<String> announcement) {
        this.announcement = announcement;
    }
}
