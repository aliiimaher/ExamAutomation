import javax.swing.*;
import java.util.ArrayList;

public class Admin extends Person {

    // --------------- Attributes ---------------
    // nothing XD


    // --------------- Methods ---------------
    public static Admin logIn() {
        Admin aliTheAdmin = new Admin("Ali", "Maher", "CSE", "113");


        String password = JOptionPane.showInputDialog(null,
                "Enter the password:",
                "Admin Log-In",
                JOptionPane.QUESTION_MESSAGE);

        if (password.equals("113"))
                return aliTheAdmin;

        else {
            String newPassword;
            do {
                newPassword = JOptionPane.showInputDialog(null,
                        "Try again:",
                        "Admin Log-In",
                        JOptionPane.QUESTION_MESSAGE);
            } while (!newPassword.equals("113"));
            return aliTheAdmin;
        }
    }

    public static Professor addProfessor() {
        String firstName = JOptionPane.showInputDialog(null,
                "Please Enter Professor First Name:", "Professor Sign-Up Operation",
                JOptionPane.QUESTION_MESSAGE);

        String lastName = JOptionPane.showInputDialog(null,
                "Please Enter Professor Last Name:", "Professor Sign-Up Operation",
                JOptionPane.QUESTION_MESSAGE);

        String filed = JOptionPane.showInputDialog(null,
                "Enter Professor Filed:", "Professor Sign-Up Operation",
                JOptionPane.QUESTION_MESSAGE);

        String password = JOptionPane.showInputDialog(null,
                "Enter Professor Password:", "Professor Sign-Up Operation",
                JOptionPane.QUESTION_MESSAGE);

        int professorNo;
        do {
            professorNo = Integer
                    .parseInt(JOptionPane.showInputDialog(null,
                            "Enter professorNo \n(It has three digits)",
                            "professor Sign-Up Operation",
                            JOptionPane.QUESTION_MESSAGE));
        }while (!Database.isUniqueProfessorNo(professorNo));


        // new the needed class
        ArrayList<Class> classes = new ArrayList<>();
        //

        // Adding user to data base
        Professor newProfessor = new Professor(firstName, lastName, filed, password, professorNo,
                classes);

        System.out.println(newProfessor.toString());
        Database.getProfessorArrayList().add(newProfessor);
        JOptionPane.showMessageDialog(null,
                "ha ha ha! Professor have signed up successfully!",
                "Professor Sign-Up Operation",
                JOptionPane.INFORMATION_MESSAGE);

        return newProfessor;
    }


    // --------------- Constructor ---------------
    public Admin(String firstName, String lastName, String field, String password) {
        super(firstName, lastName, field, password);
    }
}
