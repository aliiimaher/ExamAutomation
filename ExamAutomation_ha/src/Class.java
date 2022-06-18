import javax.swing.*;
import java.util.ArrayList;

public class Class implements Examiners{

    // --------------- Attributes ---------------
    private String professorName;
    //    private ArrayList<String> studentsNames;
    //    private ArrayList<Integer> studentsStdNo;
    private int numberOfStudents;
    private ArrayList<String> references;
    private ClassScheduling classScheduling;
    private ClassSection classSection;
    private int classCode;
    // --------------- Relations ---------------
    private Professor professor;
    private ArrayList<Question> questionBank;
    private ArrayList<Student> students;
    private ArrayList<Homework> homeworks;
    private ArrayList<Exam> exams;


    // --------------- Methods ---------------
    public static void showClassInfo() {
        int classCode = Integer.
                parseInt(JOptionPane.showInputDialog(null,
                        "Enter the class index:\n" + Database.getClassArrayList(),
                        "Class Information",
                        JOptionPane.INFORMATION_MESSAGE));

        Class chosenClass = Database.getClassArrayList().get(classCode);
        
        ArrayList<Exam> enableExams = null;
        for (Exam exam: chosenClass.getExams()) {
            if (exam.isEnable())
                enableExams.add(exam);
        }

        JOptionPane.showMessageDialog(null,
                "These are your chosen class information:\n" +
                "Professor: " + chosenClass.getProfessor() +
                "References: " + chosenClass.getReferences() +
                "Exams: " + enableExams +
                "Homeworks: " + chosenClass.getHomeworks() +
                "Number of students: " + chosenClass.getNumberOfStudents() +
                "Student List: " + chosenClass.getStudents() +
                "Class Section: " + chosenClass.getClassSection() +
                "Class Scheduling: " + chosenClass.getClassScheduling(),
                "Class Information",
                JOptionPane.INFORMATION_MESSAGE);
    }


    // --------------- Constructor ---------------
    public Class(String professorName, int numberOfStudents, ArrayList<String> references,
                 ClassScheduling classScheduling, ClassSection classSection, int classCode,
                 Professor professor, ArrayList<Question> questionBank,
                 ArrayList<Student> students, ArrayList<Homework> homeworks,
                 ArrayList<Exam> exams) {
        this.professorName = professorName;
        this.numberOfStudents = numberOfStudents;
        this.references = references;
        this.classScheduling = classScheduling;
        this.classSection = classSection;
        this.classCode = classCode;
        this.professor = professor;
        this.questionBank = questionBank;
        this.students = students;
        this.homeworks = homeworks;
        this.exams = exams;
    }


    // --------------- Getter_Setter ---------------
    public String getProfessorName() {
        return professorName;
    }

    public void setProfessorName(String professorName) {
        this.professorName = professorName;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public ArrayList<String> getReferences() {
        return references;
    }

    public void setReferences(ArrayList<String> references) {
        this.references = references;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public ArrayList<Question> getQuestionBank() {
        return questionBank;
    }

    public void setQuestionBank(ArrayList<Question> questionBank) {
        this.questionBank = questionBank;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public ArrayList<Homework> getHomeworks() {
        return homeworks;
    }

    public void setHomeworks(ArrayList<Homework> homeworks) {
        this.homeworks = homeworks;
    }

    public ArrayList<Exam> getExams() {
        return exams;
    }

    public void setExams(ArrayList<Exam> exams) {
        this.exams = exams;
    }

    public ClassScheduling getClassScheduling() {
        return classScheduling;
    }

    public void setClassScheduling(ClassScheduling classScheduling) {
        this.classScheduling = classScheduling;
    }

    public ClassSection getClassSection() {
        return classSection;
    }

    public void setClassSection(ClassSection classSection) {
        this.classSection = classSection;
    }

    public int getClassCode() {
        return classCode;
    }

    public void setClassCode(int classCode) {
        this.classCode = classCode;
    }
}
