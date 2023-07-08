package DAO_DTO_DeisgnPattern.course2;

import java.util.ArrayList;
import java.util.Scanner;

public class MainApp2 {
    private static CourseDAO2 cdao = new CourseDAO2();
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        operation();
    }
    private static void operation(){
        boolean status = true;
        while (status) {
            System.out.println("1. INSERT DATA");
            System.out.println("2. UPDATE DATA");
            System.out.println("3. DELETE DATA");
            System.out.println("4. DISPLAY DATA");
            System.out.println("5. EXIT");
            System.out.println("ENTER CHOICE...");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    saveRecords();
                    break;
                case 2:
                    updateData();
                    break;
                case 3:
                    deleteData();
                    break;

                case 4:
                    displayData();
                    break;
                case 5:
                    System.out.println("EXITED SUCCESSFULLY");
                    System.exit(0);
                    break;
                default: {
                    System.out.println("YOU ENTERED WRONG APPROACH");
                }
            }
        }
    }
    private static void saveRecords(){
        System.out.println("ENTER COURSE NAME");
        String cName = sc.next();
        System.out.println("ENTER COURSE FEES");
        double cFees = sc.nextDouble();
        CourseDTO2 cdto = new CourseDTO2();
        cdto.setCourse_name(cName);
        cdto.setCourse_fees(cFees);
        cdao.insertRecord(cdto);
    }
    private static void updateData(){
        System.out.println("ENTER COURSE ID");
        int cId = sc.nextInt();
        System.out.println("ENTER COURSE Name");
        String cName = sc.next();
        CourseDTO2 cdto = new CourseDTO2();
        cdto.setCourse_id(cId);
        cdto.setCourse_name(cName);
        int result = cdao.updateRecord(cdto);
        if(result>0){
            System.out.println("record updated successfully");
        }else {
            System.out.println("RECORD not updated");
        }
    }
    private static void deleteData(){
        System.out.println("ENTER COURSE ID");
        int id = sc.nextInt();
        CourseDTO2 cdto = new CourseDTO2();
        cdto.setCourse_id(id);
        int result = cdao.deleteRecord(cdto);
        if(result>0){
            System.out.println("record deleted successfully");
        }else {
            System.out.println("RECORD not deleted");
        }
    }
    private static void displayData(){
        System.out.println("ENTER COURSE ID TO DISPLAY DETAILS");
        int id = sc.nextInt();
        CourseDTO2 cdto = new CourseDTO2();
        cdto.setCourse_id(id);
        cdao.display(cdto);
    }
}
