package with_callableStatement.with_Stored_Function;

import java.sql.*;
import java.util.Scanner;

public class F_6 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("ENTER NUMBER 1");
        int num1 = sc.nextInt();
        System.out.println("ENTER NUMBER 2");
        int num2 = sc.nextInt();
        System.out.println("ENTER CHOICE\n1. ADDITION\n2. SUBTRACTION\n3. MULTIPLICATION\n4. DIVISION");
        int choice = sc.nextInt();
        Connection con = null;
        CallableStatement cstmt = null;

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1datab","root","Suraj12345");
            cstmt=con.prepareCall("{?=call calculator(?,?,?)}");
            cstmt.setInt(2,num1);
            cstmt.setInt(3,num2);
            cstmt.setInt(4,choice);
            cstmt.registerOutParameter(1, Types.DOUBLE);
            cstmt.execute();
            System.out.println("YOUR ANSWER IS : "+cstmt.getDouble(1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
