import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

// USED TO STORE ALL STUDENTS REGISTERED IN TEH UNIVERSITY SYSTEM
class RegisteredStudents extends Student {
    String email;
    String password;
    static ArrayList<RegisteredStudents> studentLoginDatabase = new ArrayList<>();

    public RegisteredStudents(String name, String email, String password) {
        super(name, email, password);
        studentLoginDatabase.add(this);
    }

    public RegisteredStudents() {
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String studentEmail = null;
        String studentName = null;
        String studentPassword = null;

        //ADMIN PASSWORD

        String adminPassword = "123";

        // PROFESSOR LIST (NAME ,EMAIL AND, PASSWORD)

        Professor registeredProfessors1 = new Professor("name1", "email1", "123");
        Professor registeredProfessors2 = new Professor("name2", "email2", "123");
        Professor registeredProfessors3 = new Professor("name3", "email3", "123");

        //COURSE DETAILS

        Course course1 = new Course("MAT101", 1, "Calculus", 2, "8AM - 10AM", null, "xyz", null, 2, "12-2PM", null);
        Course course2 = new Course("MAT102", 1, "Differential Equations", 4, "10AM - 12 Noon", null, "xyz", "MAT101", 2, "12-2PM", null);
        Course course3 = new Course("MAT103", 1, "Complex Variables", 2, "2PM - 4PM", null, "xyz", "MAT102", 2, "12-2PM", null);
        Course course4 = new Course("CSE101", 2, "Python", 2, "8AM - 10AM", null, "xyz", null, 2, "12-2PM", null);
        Course course5 = new Course("CSE102", 2, "OOPS", 4, "10AM - 12 Noon", null, "xyz", "CSE101", 2, "12-2PM", null);
        Course course6 = new Course("CSE103", 3, "Java", 4, "2PM - 4PM", null, "xyz", "CSE102", 2, "12-2PM", null);
        System.out.println("Welcome to University Course Registration System");

        // STRUCTURE OF LOGIN PORTAL WITH VARIOUS OPTIONS TO ENTER AND EXIT ANY INTERFACE ANYTIME SMOOTHLY
        // IMPLEMENTS MENUS AFTER YOU SELECT TO LOGIN IN ANY PARTICULAR PORTAL

        while (true) {
            System.out.println("1. Login as Student\n2. Login as Professor \n3. Login as Admin \n4. Exit application.");
            int loginChoice = sc.nextInt();
            sc.nextLine();
            if (loginChoice == 1) {
                System.out.println("1. Login");
                System.out.println("2. If you're new, Register");
                System.out.println("3. Exit student portal");
                int newStudent = sc.nextInt();
                sc.nextLine();
                if (newStudent == 1) {
                    System.out.println("Login as Student ");
                    System.out.println("Enter email: ");
                    String enteredEmail = sc.nextLine();
                    System.out.println("Enter password: ");
                    String enteredPassword = sc.nextLine();
                    if (!Objects.equals(studentEmail, enteredEmail)) {
                        System.out.println("Wrong Email try again! ");
                        return;
                    }
                    if (!Objects.equals(studentPassword, enteredPassword)) {
                        System.out.println("Wrong password try again! ");
                        return;
                    }
                    if (Objects.equals(studentPassword, enteredPassword) && Objects.equals(studentEmail, enteredEmail)) {
                        System.out.println("\tWelcome to Student Portal.");
                        Student student = new Student(studentName, studentEmail, studentPassword);
                        student.menu();
                    }
                }
                if (newStudent == 2) {
                    System.out.println("Register your account.");
                    System.out.println("Enter name: ");
                    studentName = sc.nextLine();
                    System.out.println("Enter email: ");
                    studentEmail = sc.nextLine();
                    System.out.println("Enter password: ");
                    studentPassword = sc.nextLine();

                    newStudent = 1;
                    RegisteredStudents registeredStudents = new RegisteredStudents(studentName, studentEmail, studentPassword);
                }

                if (newStudent == 3) {
                    continue;
                }
            } else if (loginChoice == 2) {
                System.out.println("1. Login");
                System.out.println("2. Exit professor portal.");
                int newProf = sc.nextInt();
                sc.nextLine();
                if (newProf == 1) {
                    System.out.println("Login as Professor ");
                    System.out.println("Enter email: ");
                    String enteredEmail = sc.nextLine();
                    System.out.println("Enter password: ");
                    String enteredPassword = sc.nextLine();
                    int checker = 0;
                    for (Professor professor : Professor.professorLoginDatabase) {
                        if (!(Objects.equals(enteredEmail, professor.email)) || (!(Objects.equals(enteredPassword, professor.password)))) {
                            checker++;
                        }
                    }
                    if (checker == Professor.professorLoginDatabase.size()) {
                        System.out.println("Wrong credentials!");
                        continue;
                    }
                    for (Professor professors : Professor.professorLoginDatabase) {
                        if (Objects.equals(enteredEmail, professors.email)) {
                            if (Objects.equals(enteredPassword, professors.password)) {
                                String profName = professors.name;
                                System.out.println("\tWelcome to Professor Portal.");
                                Professor professor = new Professor(profName, enteredEmail, enteredPassword);
                                professor.menu();
                            }
                        }
                    }
                }
                if (newProf == 2) {
                    return;
                }
            } else if (loginChoice == 3) {
                System.out.println("1. Login as Admin");
                System.out.println("2. Exit admin portal");
                int newAdmin = sc.nextInt();
                sc.nextLine();
                if (newAdmin == 1) {
                    System.out.println("Enter email: ");
                    String enteredEmail = sc.nextLine();
                    System.out.println("Enter password: ");
                    String enteredPassword = sc.nextLine();
                    if (!Objects.equals(adminPassword, enteredPassword)) {
                        System.out.println("Wrong password try again! ");
                    }
                    if (Objects.equals(adminPassword, enteredPassword)) {
                        System.out.println("\tWelcome to Admin Portal.");
                        Admin admin = new Admin();
                        admin.menu();
                    }
                }
                if (newAdmin == 2) {
                    return;
                }
            } else if (loginChoice == 4) {
                System.out.println("Exiting application...");
                return;
            }
        }
    }
}
