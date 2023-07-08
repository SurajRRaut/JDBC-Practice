package with_prepareStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Array_2 {
    public static void main(String[] args) {
        ArrayList <Array_1> arr= new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("HOW MANY RECORDS U WANT STORE IN ARRAYLIST");
        int num = sc.nextInt();
        for(int i = 0;i<num;i++) {
            System.out.println("ENTER THE ROLL NUMBER");
            int rollNo = sc.nextInt();
            System.out.println("ENTER STUDENT FULL NAME");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.println("ENTER STUDENT DIVISION");
            char division = sc.next().charAt(0);
            Array_1 a1 = new Array_1(rollNo, name, division);
            //only accept objects >>>
            arr.add(a1);
        }
        System.out.println(arr);
        System.out.println("YOU WANT STORE THIS DATE IN DATABASE");
        String answer = sc.next();
        if(answer.equalsIgnoreCase("yes")){
            Connection con = null;
            PreparedStatement pstmt = null;
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1datab","root","Suraj12345");
                pstmt = con.prepareStatement("insert into student values(?,?,?)");

                for(int i= 0;i<arr.size();i++){
                    pstmt.setInt(1, arr.get(i).getStudent_Roll_Number());
                    pstmt.setString(2, arr.get(i).getStudent_Name());
                    pstmt.setString(3, arr.get(i).getStudent_Div()+"");
                    pstmt.addBatch();
                }
                int[] ar = pstmt.executeBatch();
                System.out.println(ar.length +" DATA INSERTED SUCCESSFULLY");

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            finally {
                try {
                    //Not need it will automatically done from java 7...
                    con.close();
                    System.out.println("CONNECTION CLOSED");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }else{
            System.out.println("Thank you for visiting");
        }
    }
}
