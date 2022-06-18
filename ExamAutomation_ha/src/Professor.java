import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.dnd.DropTarget;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class Professor extends Person{

    // --------------- Attributes ---------------
    private int professorNo;
    // --------------- Relations ---------------
    private ArrayList<Class> classes;


    // --------------- Methods ---------------
    // log-in method
    public static Professor logIn() {

        int professorNo = Integer
                .parseInt(JOptionPane.showInputDialog(null, "Please Enter Your Professor Number:",
                        "Professor Log In",
                        JOptionPane.QUESTION_MESSAGE).toLowerCase());

        if (Database.isAvailableProfessor(professorNo)) {
            String password = JOptionPane.showInputDialog(null, "Please Enter Your Password:",
                    "Professor Log In",
                    JOptionPane.QUESTION_MESSAGE);

            Professor currentProfessor = Database.getProfessorFromProfessorNo(professorNo);

            if (password.equals(currentProfessor.getPassword())) {
                JOptionPane.showMessageDialog(null, "Hooray! You Log In Successfully :)",
                        "Professor Log In",
                        JOptionPane.INFORMATION_MESSAGE);
                return currentProfessor;
            } else {
                JOptionPane.showMessageDialog(null, "Wrong Password :/\n Do the process again!",
                        "Professor Log In",
                        JOptionPane.ERROR_MESSAGE);
            }

        } else
            JOptionPane.showMessageDialog(null, "No Such userID Found :(", "Log In Failed.",
                    JOptionPane.ERROR_MESSAGE);

        return null;

    }

    public static void addStudent() {

        int classCode = Integer.
                parseInt(JOptionPane.showInputDialog(null,
                        "Enter the class code:",
                        "Add Student",
                        JOptionPane.QUESTION_MESSAGE));

        Class thisClass = Database.getClassFromClassCode(classCode);

        int stdNo = Integer.
                parseInt(JOptionPane.showInputDialog(null,
                        "Enter the student number of student you wanna add to class:",
                        "Add Student",
                        JOptionPane.QUESTION_MESSAGE));

        Student selectedStudent = Database.getStudentFromStdNo(stdNo);

        thisClass.getStudents().add(selectedStudent);
        selectedStudent.getClasses().add(thisClass);

        JOptionPane.showMessageDialog(null,
                "The student added successfully :)",
                "Add Student",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void removeStudent() {

        int classCode = Integer.
                parseInt(JOptionPane.showInputDialog(null,
                        "Enter the class code:",
                        "Remove Student",
                        JOptionPane.QUESTION_MESSAGE));

        Class thisClass = Database.getClassFromClassCode(classCode);

        int stdNo = Integer.
                parseInt(JOptionPane.showInputDialog(null,
                        "Enter the student number of student you wanna remove from class:",
                        "Remove Student",
                        JOptionPane.QUESTION_MESSAGE));

        Student selectedStudent = Database.getStudentFromStdNo(stdNo);

        thisClass.getStudents().remove(selectedStudent);
        selectedStudent.getClasses().remove(thisClass);

        JOptionPane.showMessageDialog(null,
                "The student removed.",
                "Remove Student",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void addQuestion(int professorNo) {

        Professor thisProfessor = Database.getProfessorFromProfessorNo(professorNo);

        int classCode = Integer.
                parseInt(JOptionPane.showInputDialog(null,
                        "Enter the class code:",
                        "Add Question",
                        JOptionPane.QUESTION_MESSAGE));

        Class thisClass = Database.getClassFromClassCode(classCode);

        // ----------------- Create new question -----------------
        String questionTitle = null;
        String questionText = null;
        QuestionType questionType = QuestionType.MULTIPLE_CHOICE;
        ArrayList<Homework> homeworkArrayList = thisClass.getHomeworks();
        ArrayList<Question> questionBank = thisClass.getQuestionBank();
        ArrayList<Exam> examArrayList = thisClass.getExams();

        questionTitle = JOptionPane.showInputDialog(null,
                "Enter the question title:",
                "Add Question",
                JOptionPane.QUESTION_MESSAGE);

        questionText = JOptionPane.showInputDialog(null,
                "Enter the question text:",
                "Add Question",
                JOptionPane.QUESTION_MESSAGE);


        Question newQuestion = new Question(questionTitle, questionText, questionType,
                thisProfessor, homeworkArrayList, thisClass, examArrayList);

        questionBank.add(newQuestion);
        Database.getQuestionArrayList().add(newQuestion);

        JOptionPane.showMessageDialog(null,
                "The question added to question bank of class successfully :)",
                "Add Question",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void removeQuestion(int professorNo) {

        Professor thisProfessor = Database.getProfessorFromProfessorNo(professorNo);

        int classCode = Integer.
                parseInt(JOptionPane.showInputDialog(null,
                        "Enter the class code:",
                        "Remove Question",
                        JOptionPane.QUESTION_MESSAGE));

        Class thisClass = Database.getClassFromClassCode(classCode);

        String questionTitle = JOptionPane.showInputDialog(null,
                "Enter the question title you wanna remove from question bank:",
                "Remove Question",
                JOptionPane.QUESTION_MESSAGE);

        // ----------------- Find Question -----------------
        ArrayList<Question> questionBank = thisClass.getQuestionBank();
        Question selectedQuestion = Database.getQuestionFromQuestionTitle(questionTitle);

        questionBank.remove(selectedQuestion);
        Database.getQuestionArrayList().remove(selectedQuestion);

        JOptionPane.showMessageDialog(null,
                "The question removed from question bank of class successfully :)",
                "Remove Question",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void addReference(int professorNo) {

        Professor thisProfessor = Database.getProfessorFromProfessorNo(professorNo);

        int numberOfSelectedClass = Integer.
                parseInt(JOptionPane.showInputDialog(null,
                        "Enter Index of the class:" +
                        thisProfessor.getClasses(),
                        "Add Reference",
                        JOptionPane.QUESTION_MESSAGE));

        Class selectedClass = thisProfessor.getClasses().get(numberOfSelectedClass);

        String reference = JOptionPane.showInputDialog(null,
                "Enter the reference name:",
                "Add Reference",
                JOptionPane.QUESTION_MESSAGE);

        selectedClass.getReferences().add(reference);

        JOptionPane.showMessageDialog(null,
                "The reference added successfully :)",
                "Add Reference",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void createExam(int professorNo) {

        Professor thisProfessor = Database.getProfessorFromProfessorNo(professorNo);

        int numberOfSelectedClass = Integer.
                parseInt(JOptionPane.showInputDialog(null,
                        "Enter Index of the class:" +
                                thisProfessor.getClasses(),
                        "Add Reference",
                        JOptionPane.QUESTION_MESSAGE));

        Class selectedClass = Database.getClassFromClassCode(numberOfSelectedClass);

        int numberOfQuestion = Integer.
                parseInt(JOptionPane.showInputDialog(null,
                        "Enter number of question you are going provide for exam:",
                        "Create Exam",
                        JOptionPane.QUESTION_MESSAGE));

        // ---------- new exam ----------
        String examTitle = null;
        ExamType examType = ExamType.MULTIPLE_CHOICE;
        int examCode = 0;
        boolean isEnable = false;
        boolean isCorrected = false;
        int examTimeDuration = 0;
        ArrayList<String> studentsAnswerStringArrayList = new ArrayList<>();
        HashMap<Student, Integer> studentsExamScores = null;
        ArrayList<Question> questionArrayList = null;
        // with a hashSet we handle questions Repetition.
        HashSet<Question> questionHashSet = null;

        examTitle = JOptionPane.showInputDialog(null,
                "Enter exam title:",
                "Create Exam",
                JOptionPane.QUESTION_MESSAGE);

        examCode = Integer.
                parseInt(JOptionPane.showInputDialog(null,
                        "Enter the exam code:",
                        "Create Exam",
                        JOptionPane.QUESTION_MESSAGE));

        examTimeDuration = Integer.
                parseInt(JOptionPane.showInputDialog(null,
                        "Enter exam time duration:",
                        "Create Exam",
                        JOptionPane.QUESTION_MESSAGE));

        Random rand = new Random();
        for (int i = 0; i < numberOfQuestion; i++) {
            // generate random number
            int randNum = rand.nextInt(selectedClass.getQuestionBank().size());
            questionHashSet.add(selectedClass.getQuestionBank().get(randNum));
        }

        // now we have number of random questions :)
        questionArrayList = new ArrayList<>(questionHashSet);

        Exam newExam = new Exam(examTitle, examType, examCode, isEnable,
                isCorrected, examTimeDuration, studentsAnswerStringArrayList,
                studentsExamScores, selectedClass, questionArrayList);

        JOptionPane.showMessageDialog(null,
                "The exam created successfully!" +
                "This exam has " + numberOfQuestion + "question.",
                "Create Exam",
                JOptionPane.QUESTION_MESSAGE);

        // Add to database
        Database.getExamArrayList().add(newExam);
        selectedClass.getExams().add(newExam);
    }

    public static void createHomework(int professorNo) {

        Professor thisProfessor = Database.getProfessorFromProfessorNo(professorNo);

        int numberOfSelectedClass = Integer.
                parseInt(JOptionPane.showInputDialog(null,
                        "Enter Index of the class:" +
                                thisProfessor.getClasses(),
                        "Add Reference",
                        JOptionPane.QUESTION_MESSAGE));

        Class selectedClass = thisProfessor.getClasses().get(numberOfSelectedClass);

        // ----------- Create new Homework -----------
        String hwTitle = null;
        QuestionType questionType = QuestionType.MULTIPLE_CHOICE;
        int hwCode = 0;
        boolean isCorrected = false;
        ArrayList<String> studentsAnswerStringArrayList = null;
        HashMap<Student, Integer> studentsHwScores = null;
        ArrayList<Question> questionArrayList = null;

        hwTitle = JOptionPane.showInputDialog(null,
                "Enter homework title:",
                "Create Homework",
                JOptionPane.QUESTION_MESSAGE);

        hwCode = Integer.
                parseInt(JOptionPane.showInputDialog(null,
                        "Enter the homework code:",
                        "Create Homework",
                        JOptionPane.QUESTION_MESSAGE));

        int numberOfQuestions = Integer.
                parseInt(JOptionPane.showInputDialog(null,
                        "Enter number of homework questions:",
                        "Create Homework",
                        JOptionPane.QUESTION_MESSAGE));

        for (int i = 0; i < numberOfQuestions; i++) {
            int questionNumber = Integer.
                    parseInt(JOptionPane.showInputDialog(null,
                            "Enter question index:",
                            "Create Homework",
                            JOptionPane.QUESTION_MESSAGE));
            questionArrayList.add(selectedClass.getQuestionBank().get(questionNumber));
        }

        Homework newHomework = new Homework(hwTitle, questionType, hwCode, isCorrected,
                studentsAnswerStringArrayList, studentsHwScores, selectedClass, questionArrayList);

        selectedClass.getHomeworks().add(newHomework);
        Database.getHomeworkArrayList().add(newHomework);
    }

    public static void sendAnnouncement(int professorNo) {

        Professor thisProfessor = Database.getProfessorFromProfessorNo(professorNo);

        int stdNoOfSelectedStudent = Integer.
                parseInt(JOptionPane.showInputDialog(null,
                        "Enter the std No of wanted student:",
                        "Announcement",
                        JOptionPane.QUESTION_MESSAGE));

        Student selectedStudent = Database.getStudentFromStdNo(stdNoOfSelectedStudent);

        String announcementTxt = JOptionPane.showInputDialog(null,
                "Enter announcement text:",
                "Announcement",
                JOptionPane.QUESTION_MESSAGE);

        selectedStudent.getAnnouncement().add(announcementTxt);
    }

    public static void scoreExam(int professorNo) {

        Professor thisProfessor = Database.getProfessorFromProfessorNo(professorNo);

        int examCode = Integer.
                parseInt(JOptionPane.showInputDialog(null,
                        "Enter exam code of the exam you want to score:",
                        "Score Exam",
                        JOptionPane.QUESTION_MESSAGE));

        Exam selectedExam = Database.getExamFromExamCode(examCode);
        Class thisClass = selectedExam.getaClass();

        Student selectedStudent = null;
        int givenScore = 0;
        int numberOfStudents = thisClass.getStudents().size();
        HashMap<Student, Integer> studentExamScores = selectedExam.getStudentsExamScores();

        for (int i = 0; i < numberOfStudents; i++) {
            selectedStudent = thisClass.getStudents().get(i);

            JOptionPane.showMessageDialog(null,
                    "The selected student is " +
                            selectedStudent.getLastName(),
                    "Score Exam",
                    JOptionPane.INFORMATION_MESSAGE);

            givenScore = Integer.
                    parseInt(JOptionPane.showInputDialog(null,
                            "Please enter the grade:",
                            "Score Exam",
                            JOptionPane.QUESTION_MESSAGE));

            studentExamScores.put(selectedStudent, givenScore);
        }
    }

    public static void scoreHomework(int professorNo) {

        Professor thisProfessor = Database.getProfessorFromProfessorNo(professorNo);

        int homeworkCode = Integer.
                parseInt(JOptionPane.showInputDialog(null,
                        "Enter homework code of the homework you want to score:",
                        "Score Homework",
                        JOptionPane.QUESTION_MESSAGE));

        Homework selectedHomework = Database.getHomeworkFromHomeworkCode(homeworkCode);
        Class thisClass = selectedHomework.getaClass();

        Student selectedStudent = null;
        int givenScore = 0;
        int numberOfStudents = thisClass.getStudents().size();
        HashMap<Student, Integer> studentsHwScores = selectedHomework.getStudentsHwScores();

        for (int i = 0; i < numberOfStudents; i++) {
            selectedStudent = thisClass.getStudents().get(i);

            JOptionPane.showMessageDialog(null,
                    "The selected student is " +
                            selectedStudent.getLastName(),
                    "Score Homework",
                    JOptionPane.INFORMATION_MESSAGE);

            givenScore = Integer.
                    parseInt(JOptionPane.showInputDialog(null,
                            "Please enter the grade:",
                            "Score Homework",
                            JOptionPane.QUESTION_MESSAGE));

            studentsHwScores.put(selectedStudent, givenScore);
        }
    }



    // --------------- Constructor ---------------
    public Professor(String firstName, String lastName, String field, String password,
                     int professorNo, ArrayList<Class> classes) {
        super(firstName, lastName, field, password);
        this.professorNo = professorNo;
        this.classes = classes;
    }


    // --------------- Getter_Setter ---------------
    public int getProfessorNo() {
        return professorNo;
    }

    public void setProfessorNo(int professorNo) {
        this.professorNo = professorNo;
    }

    public ArrayList<Class> getClasses() {
        return classes;
    }

    public void setClasses(ArrayList<Class> classes) {
        this.classes = classes;
    }
}
