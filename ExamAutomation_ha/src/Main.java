
import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        JOptionPane.showMessageDialog(null, "Welcome to the greatest Exam Automation XD",
                "Welcome", JOptionPane.INFORMATION_MESSAGE);

        boolean isAppRunning = true;

        while (isAppRunning) {

            int chosenOptionForRole = Integer.
                    parseInt(JOptionPane.showInputDialog(null, "Choose your role?\n1. Student\n2. Professor" +
                            "\n3. Admin\n\n0. Exit",
                            "Choose Role", JOptionPane.QUESTION_MESSAGE));

            switch (chosenOptionForRole) {
                case 1:
                    // student page
                    boolean inStudentPage = true;
                    while (inStudentPage) {
                        int chosenOptionInStudentPage = Integer.
                                parseInt(JOptionPane.showInputDialog(null,
                                        "Choose Option?\n1. Log-In\n2. Sign-Up\n\n0. Back",
                                        "Student Page",
                                        JOptionPane.QUESTION_MESSAGE));

                        switch (chosenOptionInStudentPage) {
                            case 1:
                                // Log in std
                                Student thisStudent = null;
                                if (!Database.isEmptyFromStudent()) {
                                    thisStudent = Student.logIn();
                                    if (!thisStudent.equals(null)) {
                                        boolean inStudentMethodsPage = true;
                                        while (inStudentMethodsPage) {
                                            int chosenOptionInStudentMethodPage = Integer.
                                                    parseInt(JOptionPane.showInputDialog(null,
                                                            "Choose Option:" +
                                                                    "\n1. Show my classes\n2. Join a class" +
                                                                    "\n3. Show class information\n4. Answer exam" +
                                                                    "\n5. Answer homework\n6. See exam grades" +
                                                                    "\n7. See homework grade\n8. Read Announcement" +
                                                                    "\n9. ..." +
                                                                    "\n\n0. Back",
                                                            "Student Page",
                                                            JOptionPane.QUESTION_MESSAGE));

                                            int thisStudentStdNo = thisStudent.getStdNo();
                                            switch (chosenOptionInStudentMethodPage) {
                                                case 1:
                                                    Student.showClasses(thisStudentStdNo);
                                                    continue;

                                                case 2:
                                                    Student.joinClass(thisStudentStdNo);
                                                    continue;

                                                case 3:
                                                    Class.showClassInfo();
                                                    continue;

                                                case 4:
                                                    Student.answerExam(thisStudentStdNo);
                                                    continue;

                                                case 5:
                                                    Student.answerHomework(thisStudentStdNo);
                                                    continue;

                                                case 6:
                                                    Student.seeGradeOfExam(thisStudentStdNo);
                                                    continue;

                                                case 7:
                                                    Student.seeGradeOfHomework(thisStudentStdNo);
                                                    continue;

                                                case 8:
                                                    Student.readAnnouncement(thisStudentStdNo);
                                                    continue;

                                                case 0:
                                                    inStudentMethodsPage = false;
                                                    break;
                                            }
                                        }
                                    }
                                }
                                continue;

                            case 2:
                                // sign up std
                                Student.signUp();
                                continue;

                            case 0:
                                inStudentPage = false;
                                break;
                        }
                    }
                    continue;

                case 2:
                    // Teacher page
                    boolean inTeacherPage = true;
                    while (inTeacherPage) {
                        int chosenOptionInTeacherPage = Integer.
                                parseInt(JOptionPane.showInputDialog(null,
                                        "Choose Option?\n1. Log-In\n\n0. Back",
                                        "Professor Page",
                                        JOptionPane.QUESTION_MESSAGE));

                        switch (chosenOptionInTeacherPage) {
                            case 1:
                                // log in prof
                                Professor thisProfessor = null;
                                if (!Database.isEmptyFromProfessor()) {
                                    thisProfessor = Professor.logIn();
                                    if (!thisProfessor.equals(null)) {
                                        boolean inProfessorMethodsPage = true;
                                        while (inProfessorMethodsPage) {
                                            int chosenOptionInProfessorMethodsPage = Integer.
                                                    parseInt(JOptionPane.showInputDialog(null,
                                                            "Choose Option:" +
                                                                    "\n1. Add Student\n2. Remove Student" +
                                                                    "\n3. Add Question\n4. Remove Question" +
                                                                    "\n5. Add Reference\n6. Create Exam" +
                                                                    "\n7. Create Homework\n8. Send Announcement" +
                                                                    "\n9. Score Exam\n10. Score Homework" +
                                                                    "\n\n0. Back",
                                                            "Professor Page",
                                                            JOptionPane.QUESTION_MESSAGE));

                                            int thisProfessorNo = thisProfessor.getProfessorNo();
                                            switch (chosenOptionInProfessorMethodsPage) {
                                                case 1:
                                                    Professor.addStudent();
                                                    continue;

                                                case 2:
                                                    Professor.removeStudent();
                                                    continue;

                                                case 3:
                                                    Professor.addQuestion(thisProfessorNo);
                                                    continue;

                                                case 4:
                                                    Professor.removeQuestion(thisProfessorNo);
                                                    continue;

                                                case 5:
                                                    Professor.addReference(thisProfessorNo);
                                                    continue;

                                                case 6:
                                                    Professor.createExam(thisProfessorNo);
                                                    continue;

                                                case 7:
                                                    Professor.createHomework(thisProfessorNo);
                                                    continue;

                                                case 8:
                                                    Professor.sendAnnouncement(thisProfessorNo);
                                                    continue;

                                                case 9:
                                                    Professor.scoreExam(thisProfessorNo);
                                                    continue;

                                                case 10:
                                                    Professor.scoreHomework(thisProfessorNo);
                                                    continue;

                                                case 0:
                                                    inProfessorMethodsPage = false;
                                                    break;
                                            }
                                        }
                                    }

                                }

                                continue;

//                            case 2:
//                                // sign up prof
//                                Professor.signUp();
//                                continue;

                            case 0:
                                inTeacherPage = false;
                                break;
                        }
                    }
                    continue;

                case 3:
                    // Admin Page
                    boolean inAdminPage = true;
                    while (inAdminPage) {
                        int chosenOptionInAdminPage = Integer.
                                parseInt(JOptionPane.showInputDialog(null,
                                        "Choose Option?\n1. Log-In\n\n0. Back",
                                        "Admin Page",
                                        JOptionPane.QUESTION_MESSAGE));

                        switch (chosenOptionInAdminPage) {
                            case 1:
                                // log in admin page
                                Admin thisAdmin = Admin.logIn();
                                if (!thisAdmin.equals(null)) {
                                    boolean inAdminMethodsPage = true;
                                    while (inAdminMethodsPage) {
                                        int chosenOptionInAdminPageMethods = Integer.
                                                parseInt(JOptionPane.showInputDialog(null,
                                                        "Choose an Option:" +
                                                                "\n1. Add Professor" +
                                                                "\n\n0. Back",
                                                        "Admin page",
                                                        JOptionPane.QUESTION_MESSAGE));

                                        switch (chosenOptionInAdminPageMethods) {
                                            case 1:
                                                Admin.addProfessor();
                                                continue;

                                            case 0:
                                                inAdminMethodsPage = false;
                                                break;

                                        }
                                    }
                                }

                                continue;

                            case 0:
                                inAdminPage = false;
                                break;
                        }
                    }
                    continue;

                case 0:
                    isAppRunning = false;
                    break;
            }
        }

        JOptionPane.showMessageDialog(null, "Bye-Bye", "GG", JOptionPane.INFORMATION_MESSAGE);

    }
}