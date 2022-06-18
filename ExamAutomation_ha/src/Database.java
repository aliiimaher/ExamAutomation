import javax.swing.*;
import java.util.ArrayList;

public class Database {

    // --------------- Attributes ---------------
    private static ArrayList<Person> personArrayList = new ArrayList<>();
    private static ArrayList<Student> studentArrayList = new ArrayList<>();
    private static ArrayList<Professor> professorArrayList = new ArrayList<>();
    private static ArrayList<Class> classArrayList = new ArrayList<>();
    private static ArrayList<Exam> examArrayList = new ArrayList<>();
    private static ArrayList<Homework> homeworkArrayList = new ArrayList<>();
    private static ArrayList<Question> questionArrayList = new ArrayList<>();
    // Define some of the data manually to not repeat same flow again and again.
    Admin aliTheAdmin = new Admin("Ali", "Maher", "CSE", "113");


    // --------------- Methods ---------------
    public static boolean isAvailableStudent(int stdNo) {
        for (Student student: getStudentArrayList())
            if (stdNo == student.getStdNo())
                return true;
        return false;
    }

    public static boolean isAvailableProfessor(int professorNo) {
        for (Professor professor: getProfessorArrayList())
            if (professorNo == professor.getProfessorNo())
                return true;
        return false;
    }

    public static Student getStudentFromStdNo(int stdNo) {
        for (Student student: getStudentArrayList())
            if (stdNo == student.getStdNo())
                return student;
        return null;
    }

    public static Professor getProfessorFromProfessorNo(int professorNo) {
        for (Professor professor: getProfessorArrayList())
            if (professorNo == professor.getProfessorNo())
                return professor;
        return null;
    }

    public static boolean isUniqueStdNo(int stdNo) {
        if (getStudentArrayList().isEmpty()) {
            JOptionPane.showMessageDialog(null, "This StdNo is unique :D",
                    "Unique Student Number",
                    JOptionPane.INFORMATION_MESSAGE);
            return true;
        }

        for (Student student : studentArrayList)
            if (student.getStdNo() == stdNo) {
                JOptionPane.showMessageDialog(null,
                        "This Std No have been taken before :(",
                        "Unique Student Number",
                        JOptionPane.QUESTION_MESSAGE);
                return false;
            }

        JOptionPane.showMessageDialog(null,
                "This Student number is unique :D",
                "Unique Student Number",
                JOptionPane.INFORMATION_MESSAGE);
        return true;
    }

    public static boolean isUniqueProfessorNo(int professorNo) {
        if (getProfessorArrayList().isEmpty()) {
            JOptionPane.showMessageDialog(null, "This ProfessorNo is unique :D",
                    "Unique Professor Number",
                    JOptionPane.INFORMATION_MESSAGE);
            return true;
        }

        for (Professor professor : professorArrayList)
            if (professor.getProfessorNo() == professorNo) {
                JOptionPane.showMessageDialog(null,
                        "This ProfessorNo have been taken before :(",
                        "Unique Professor Number",
                        JOptionPane.QUESTION_MESSAGE);
                return false;
            }

        JOptionPane.showMessageDialog(null,
                "This Professor number is unique :D",
                "Unique Professor Number",
                JOptionPane.INFORMATION_MESSAGE);
        return true;
    }

    public static boolean isEmptyFromStudent() {
        if (getStudentArrayList().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Sorry, Please Sign-Up first.",
                    "Log In",
                    JOptionPane.INFORMATION_MESSAGE);
            return true;
        }
        return false;
    }

    public static boolean isEmptyFromProfessor() {
        if (getProfessorArrayList().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Sorry, Please Sign-Up first.",
                    "Log In",
                    JOptionPane.INFORMATION_MESSAGE);
            return true;
        }
        return false;
    }

    public static Class getClassFromClassCode(int classCode) {
        for (Class tempClass: getClassArrayList())
            if (classCode == tempClass.getClassCode())
                return tempClass;
        return null;
    }

    public static Exam getExamFromExamCode(int examCode) {
        for (Exam exam: getExamArrayList())
            if (examCode == exam.getExamCode())
                return exam;
        return null;
    }

    public static Homework getHomeworkFromHomeworkCode(int homeworkCode) {
        for (Homework homework: getHomeworkArrayList())
            if (homeworkCode == homework.getHwCode())
                return homework;
        return null;
    }

    public static Question getQuestionFromQuestionTitle(String questionTitle) {
        for (Question question: Database.getQuestionArrayList())
            if (questionTitle.equals(question.getQuestionTitle()))
                return question;
        return null;
    }

    public static boolean isOverlapped(int stdNo, Class selectedClass) {

        Student thisStudent = getStudentFromStdNo(stdNo);

        if (thisStudent.getClasses().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "You can get this class.",
                    "Sections Overlapping Checking",
                    JOptionPane.INFORMATION_MESSAGE);

            return true;
        } else {
            for (Class tempClass: thisStudent.getClasses())
                if (!tempClass.getClassScheduling().equals(selectedClass.getClassScheduling())) {
                    JOptionPane.showMessageDialog(null,
                            "You can get this class.",
                            "Sections Overlapping Checking",
                            JOptionPane.INFORMATION_MESSAGE);
                    return true;
                }

            JOptionPane.showMessageDialog(null,
                    "You can't get this class :(",
                    "Sections Overlapping Checking",
                    JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }


    // --------------- Constructor ---------------
    public Database(){

    }


    // --------------- Getter_Setter ---------------
    public static ArrayList<Person> getPersonArrayList() {
        return personArrayList;
    }

    public static void setPersonArrayList(ArrayList<Person> personArrayList) {
        Database.personArrayList = personArrayList;
    }

    public static ArrayList<Student> getStudentArrayList() {
        return studentArrayList;
    }

    public static void setStudentArrayList(ArrayList<Student> studentArrayList) {
        Database.studentArrayList = studentArrayList;
    }

    public static ArrayList<Professor> getProfessorArrayList() {
        return professorArrayList;
    }

    public static void setProfessorArrayList(ArrayList<Professor> professorArrayList) {
        Database.professorArrayList = professorArrayList;
    }

    public static ArrayList<Class> getClassArrayList() {
        return classArrayList;
    }

    public static void setClassArrayList(ArrayList<Class> classArrayList) {
        Database.classArrayList = classArrayList;
    }

    public static ArrayList<Exam> getExamArrayList() {
        return examArrayList;
    }

    public static ArrayList<Homework> getHomeworkArrayList() {
        return homeworkArrayList;
    }

    public static void setHomeworkArrayList(ArrayList<Homework> homeworkArrayList) {
        Database.homeworkArrayList = homeworkArrayList;
    }

    public static void setExamArrayList(ArrayList<Exam> examArrayList) {
        Database.examArrayList = examArrayList;
    }

    public static ArrayList<Question> getQuestionArrayList() {
        return questionArrayList;
    }

    public static void setQuestionArrayList(ArrayList<Question> questionArrayList) {
        Database.questionArrayList = questionArrayList;
    }
}
