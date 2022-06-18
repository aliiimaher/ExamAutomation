import java.util.ArrayList;

public class Question {

    // --------------- Attributes ---------------
    private String questionTitle;
    private String questionText;
    private QuestionType questionType;
    private Person author;
    // --------------- Relations ---------------
    private ArrayList<Homework> homeworkArrayList;
    private Class questionClass;
    private ArrayList<Exam> examArrayList;


    // --------------- Methods ---------------



    // --------------- Constructor ---------------
    public Question(String questionTitle, String questionText, QuestionType questionType,
                    Person author, ArrayList<Homework> homeworkArrayList,
                    Class questionClass, ArrayList<Exam> examArrayList) {
        this.questionTitle = questionTitle;
        this.questionText = questionText;
        this.questionType = questionType;
        this.author = author;
        this.homeworkArrayList = homeworkArrayList;
        this.questionClass = questionClass;
        this.examArrayList = examArrayList;
    }


    // --------------- Getter_Setter ---------------
    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    public Person getAuthor() {
        return author;
    }

    public void setAuthor(Person author) {
        this.author = author;
    }

    public ArrayList<Homework> getHomeworkArrayList() {
        return homeworkArrayList;
    }

    public void setHomeworkArrayList(ArrayList<Homework> homeworkArrayList) {
        this.homeworkArrayList = homeworkArrayList;
    }

    public Class getQuestionClass() {
        return questionClass;
    }

    public void setQuestionClass(Class questionClass) {
        this.questionClass = questionClass;
    }

    public ArrayList<Exam> getExamArrayList() {
        return examArrayList;
    }

    public void setExamArrayList(ArrayList<Exam> examArrayList) {
        this.examArrayList = examArrayList;
    }
}
