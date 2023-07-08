package with_callableStatement.with_Stored_Procedure;

import java.sql.*;
import java.util.Scanner;

public class P_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER CHOICE\n1. HIKE 25% IN DEVELOPMENT AND 30% IN TESTER\n2. HIKE 10% IN DEVELOPMENT AND 15% IN TESTER ");
        int choice = sc.nextInt();
        Connection con = null;
        CallableStatement cs = null;
        ResultSet rs = null;

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/2datab","root","Suraj12345");
            cs=con.prepareCall("{call empSalHike(?)}");
            cs.setInt(1,choice);
            cs.execute();
            System.out.println("SALARY HIKE IS SUCCESSFULL...");
            System.out.println("-------------------------------------------------------------------------------------");
            cs=con.prepareCall("{call display_I_Name()}");
            cs.execute();
            rs=cs.getResultSet();
            System.out.println("THE NAME HAVE AN I LETTER IN THEIR WORD BELOW FROM EMPLOYEE TABLE");
            while(rs.next()){
                System.out.println(rs.getString(2));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}