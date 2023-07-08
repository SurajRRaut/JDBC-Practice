package DAO_DTO_DeisgnPattern.course;

import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {
    private static CourseDAO cdao = new CourseDAO();
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
        CourseDTO cdto = new CourseDTO();
        cdto.setCourse_name(cName);
        cdto.setCourse_fees(cFees);
        int result = cdao.insertRecord(cdto);
        if(result>0){
            System.out.println("record inserted successfully");
        }else {
            System.out.println("RECORD not inserted");
        }
    }
    private static void updateData(){
        System.out.println("ENTER COURSE ID");
        int cId = sc.nextInt();
        System.out.println("ENTER COURSE Name");
        String cName = sc.next();
        CourseDTO cdto = new CourseDTO();
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
        CourseDTO cdto = new CourseDTO();
        cdto.setCourse_id(id);
        int result = cdao.deleteRecord(cdto);
        if(result>0){
            System.out.println("record deleted successfully");
        }else {
            System.out.println("RECORD not deleted");
        }
    }
//    private static void displayData(){
//        ArrayList<CourseDTO> result =cdao.display();
//        for(CourseDTO data:result){
//            System.out.print(data.getCourse_id()+" ");
//            System.out.print(data.getCourse_name()+" ");
//            System.out.println(data.getCourse_fees());
//        }
//    }

    private static void displayData(){
        cdao.display();
    }
}
