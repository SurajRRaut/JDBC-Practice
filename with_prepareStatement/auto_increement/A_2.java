package with_prepareStatement.auto_increement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class A_2 {
    public static void main(String[] args) {
        ArrayList<A_1> arr= new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("HOW MANY RECORDS U WANT STORE IN ARRAYLIST");
        int num = sc.nextInt();
        for(int i = 0;i<num;i++) {
            System.out.println("ENTER STUDENT FULL NAME");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.println("ENTER STUDENT DIVISION");
            char division = sc.next().charAt(0);
            A_1 a1 = new A_1(name, division);
            //only accept objects >>>
            arr.add(a1);
        }
        System.out.println(arr);
        System.out.println("YOU WANT STOR THIS DATE IN DATABASE");
        String answer = sc.next();
        if(answer.equalsIgnoreCase("yes")){
            Connection con = null;
            PreparedStatement pstmt = null;
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1datab","root","Suraj12345");
                pstmt = con.prepareStatement("insert into student values(?,?,?)");

                int sum = 0,count =0;
                for(int i= 0;i<arr.size();i++){
                    // Alter table and give constrained Auto Increment (but insert first value in auto inc column)
                    pstmt.setInt(1,0);
                    pstmt.setString(2, arr.get(i).getStudent_Name());
                    pstmt.setString(3, arr.get(i).getStudent_Div() + "");
                    count = pstmt.executeUpdate();
                    sum+=count;
                }
                System.out.println(sum +" DATA INSERTED SUCCESSFULLY");

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }else{
            System.out.println("Thank you for visiting");
        }
    }
}
