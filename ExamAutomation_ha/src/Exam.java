import java.util.ArrayList;
import java.util.HashMap;

public class Exam {
    // --------------- Attributes ---------------
    private String examTitle;
    private ExamType examType;
    private int examCode;
    private boolean isEnable;
    private boolean isCorrected;
    private int examTimeDuration;
    private ArrayList<String> studentsAnswerStringArrayList;
    private HashMap<Student, Integer> studentsExamScores;
    // --------------- Relations ---------------
    private Class aClass;
    private ArrayList<Question> questionArrayList;


    // --------------- Methods ---------------
    // ...



    // --------------- Constructor ---------------
    public Exam(String examTitle, ExamType examType, int examCode, boolean isEnable,
                boolean isCorrected, int examTimeDuration,
                ArrayList<String> studentsAnswerStringArrayList,
                HashMap<Student, Integer> studentsExamScores, Class aClass,
                ArrayList<Question> questionArrayList) {
        this.examTitle = examTitle;
        this.examType = examType;
        this.examCode = examCode;
        this.isEnable = isEnable;
        this.isCorrected = isCorrected;
        this.examTimeDuration = examTimeDuration;
        this.studentsAnswerStringArrayList = studentsAnswerStringArrayList;
        this.studentsExamScores = studentsExamScores;
        this.aClass = aClass;
        this.questionArrayList = questionArrayList;
    }



    // --------------- Getter_Setter ---------------
    public String getExamTitle() {
        return examTitle;
    }

    public void setExamTitle(String examTitle) {
        this.examTitle = examTitle;
    }

    public ExamType getExamType() {
        return examType;
    }

    public void setExamType(ExamType examType) {
        this.examType = examType;
    }

    public int getExamCode() {
        return examCode;
    }

    public void setExamCode(int examCode) {
        this.examCode = examCode;
    }

    public Class getaClass() {
        return aClass;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }

    public boolean isEnable() {
        return isEnable;
    }

    public void setEnable(boolean enable) {
        isEnable = enable;
    }

    public ArrayList<Question> getQuestionArrayList() {
        return questionArrayList;
    }

    public void setQuestionArrayList(ArrayList<Question> questionArrayList) {
        this.questionArrayList = questionArrayList;
    }

    public boolean isCorrected() {
        return isCorrected;
    }

    public void setCorrected(boolean corrected) {
        isCorrected = corrected;
    }

    public ArrayList<String> getStudentsAnswerStringArrayList() {
        return studentsAnswerStringArrayList;
    }

    public void setStudentsAnswerStringArrayList(ArrayList<String> studentsAnswerStringArrayList) {
        this.studentsAnswerStringArrayList = studentsAnswerStringArrayList;
    }

    public HashMap<Student, Integer> getStudentsExamScores() {
        return studentsExamScores;
    }

    public void setStudentsExamScores(HashMap<Student, Integer> studentsExamScores) {
        this.studentsExamScores = studentsExamScores;
    }

    public int getExamTimeDuration() {
        return examTimeDuration;
    }

    public void setExamTimeDuration(int examTimeDuration) {
        this.examTimeDuration = examTimeDuration;
    }
}
