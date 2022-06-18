import java.util.ArrayList;
import java.util.HashMap;

public class Homework {

    // --------------- Attributes ---------------
    private String hwTitle;
    private QuestionType hwQuestionType;
    private int hwCode;
    private boolean isCorrected;
    private ArrayList<String> studentsAnswerStringArrayList;
    private HashMap<Student, Integer> studentsHwScores;
    // --------------- Relations ---------------
    private Class aClass;
    private ArrayList<Question> questionArrayList;


    // --------------- Methods ---------------
    // ...


    // --------------- Constructor ---------------
    public Homework(String hwTitle, QuestionType hwQuestionType, int hwCode,
                    boolean isCorrected, ArrayList<String> studentsAnswerStringArrayList,
                    HashMap<Student, Integer> studentsHwScores, Class aClass,
                    ArrayList<Question> questionArrayList) {
        this.hwTitle = hwTitle;
        this.hwQuestionType = hwQuestionType;
        this.hwCode = hwCode;
        this.isCorrected = isCorrected;
        this.studentsAnswerStringArrayList = studentsAnswerStringArrayList;
        this.studentsHwScores = studentsHwScores;
        this.aClass = aClass;
        this.questionArrayList = questionArrayList;
    }

    // --------------- Getter_Setter ---------------
    public String getHwTitle() {
        return hwTitle;
    }

    public void setHwTitle(String hwTitle) {
        this.hwTitle = hwTitle;
    }

    public QuestionType getHwQuestionType() {
        return hwQuestionType;
    }

    public void setHwQuestionType(QuestionType hwQuestionType) {
        this.hwQuestionType = hwQuestionType;
    }

    public int getHwCode() {
        return hwCode;
    }

    public void setHwCode(int hwCode) {
        this.hwCode = hwCode;
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

    public HashMap<Student, Integer> getStudentsHwScores() {
        return studentsHwScores;
    }

    public void setStudentsHwScores(HashMap<Student, Integer> studentsHwScores) {
        this.studentsHwScores = studentsHwScores;
    }

    public Class getaClass() {
        return aClass;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }

    public ArrayList<Question> getQuestionArrayList() {
        return questionArrayList;
    }

    public void setQuestionArrayList(ArrayList<Question> questionArrayList) {
        this.questionArrayList = questionArrayList;
    }
}
