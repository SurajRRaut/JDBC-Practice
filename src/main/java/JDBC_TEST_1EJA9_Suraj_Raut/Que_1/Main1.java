package JDBC_TEST_1EJA9_Suraj_Raut.Que_1;


import java.util.Scanner;

public class Main1 {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        operation();
    }
    private static void operation(){
        boolean status = true;
        while (status) {
            System.out.println("1. INSERT DATA");
            System.out.println("2. DISPLAY DATA");
            System.out.println("3. EXIT");
            System.out.println("ENTER CHOICE...");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    addData();
                    break;
                case 2:
                    displaydata();
                    break;
                case 3:
                    System.out.println("EXITED SUCCESSFULLY");
                    System.exit(0);
                    break;
                default: {
                    System.out.println("YOU ENTERED WRONG APPROACH");
                }
            }
        }
    }
    private static void addData(){
        System.out.println("ENTER DATA FOR STUDENT TABLE....");
        System.out.println("ENTER ROLL NO");
        int rn= sc.nextInt();
        System.out.println("ENTER NAME");
        String name = sc.next();
        System.out.println("ENTER ADDRESS");
        String add = sc.next();
        System.out.println("ENTER CLASS");
        String clas = sc.next();
        System.out.println("ENTER MARKS SCORED");
        double marks =sc.nextDouble();
        System.out.println("ENTER DATA FOR SUBJECTS TABLE...");
        System.out.println("ENTER SCODE");
        String scode = sc.next();
        System.out.println("ENTER SUBJECT NAME");
        String subName = sc.next();
        System.out.println("ENTER MARKS REFF");
        double marks_ref= sc.nextDouble();
        Operations1.insert(rn,name,add,clas,marks,scode,subName,marks_ref);
    }
    private static void displaydata(){
        Operations1.display();
    }
}

