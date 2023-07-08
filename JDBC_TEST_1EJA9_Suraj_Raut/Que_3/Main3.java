package JDBC_TEST_1EJA9_Suraj_Raut.Que_3;

import java.sql.*;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER STUDENT ADDRESS");
        String add = sc.next();
        System.out.println("ENTER STUDENT ROLL NO");
        String rollNo = sc.next();
        Connection con = null;
        CallableStatement cs = null;
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/2datab","root","Suraj12345");
            cs=con.prepareCall("{call insertVal(?,?)}");
            cs.setString(1,add);
            cs.setString(2,rollNo);
            cs.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
