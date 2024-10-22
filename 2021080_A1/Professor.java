import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Professor implements User {
        String name;
        String email;
        String password;
        static ArrayList<Professor> professorLoginDatabase =  new ArrayList<>();
        Scanner sc = new Scanner(System.in);
    public Professor(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        professorLoginDatabase.add(this);
    }
    public Professor() {
    }

    // VIEW COURSE THAT YOU ARE ASSIGNED BY THE ADMIN
    public void viewCourses() {
        System.out.println("Your assigned course is: ");
        for (Course course : Course.courseList) {
            if(Objects.equals(course.getProfessor(), name)){
                System.out.println(course);
            }
        }
    }

    // UPDATE DETAILS ABOUT YOUR COURSE
    public void updateCourse() {
        viewCourses();
        System.out.println("Enter course code to confirm: ");
        String courseCode = sc.nextLine();
        for (Course course : Course.courseList) {
            if (Objects.equals(course.getCode(), courseCode)) {
                char choice = 'y';
                while (choice == 'y') {
                    System.out.println("Select what you want to update: ");
                    System.out.println("1. Class Timings.\n" +
                            "2. Syllabus.\n" +
                            "3. Pre Requisites.\n" +
                            "4. Enrollment Limits.\n" +
                            "5. Office Hours.");
                    int updateChoice = sc.nextInt();
                    sc.nextLine();
                    switch (updateChoice) {
                        case 1:
                            System.out.println("Enter new timings: ");
                            String timing = sc.nextLine();
                            course.setTimings(timing);
                            break;
                        case 2:
                            System.out.println("Enter new Syllabus: ");
                            String syllabus = sc.nextLine();
                            course.setSyllabus(syllabus);
                            break;
                        case 3:
                            System.out.println("Enter new Pre-Requisites: ");
                            String pre = sc.nextLine();
                            course.setPreRequisites(pre);
                            break;
                        case 4:
                            System.out.println("Enter new Enrollment Limit: ");
                            int el = sc.nextInt();
                            course.setEnrollmentLimits(el);
                            break;
                        case 5:
                            System.out.println("Enter new Office Hours: ");
                            String oh = sc.nextLine();
                            course.setOfficeHours(oh);
                            break;
                        default:
                            System.out.println("Invalid input!");
                            break;
                    }
                    System.out.println("Do you want to update more? (y/n) ");
                    choice = sc.next().charAt(0);
                }
                System.out.println("Course has been updated! ");
                viewCourses();
            }

        }

    }

    @Override
    public void menu() {
        System.out.println("Select what you want to do: ");
        char redoChoice = 'y';
        while (redoChoice == 'y') {
            System.out.println("1. View Courses.\n" +
                    "2. Update Courses.");
            int profMenuChoice = sc.nextInt();
            sc.nextLine();
            switch (profMenuChoice) {
                case 1:
                    viewCourses();
                    break;
                case 2:
                    updateCourse();
                    break;
                default:
                    System.out.println("Invalid input! ");
            }
            System.out.println("Do you want to more as a Professor? (y/n)");
            redoChoice = sc.next().charAt(0);
            sc.nextLine();
        }
    }

    @Override
    public String toString() {
        return "Professor Name: " + name ;
    }
}

