package JDBC_TEST_1EJA9_Suraj_Raut.Que_4;

import java.sql.*;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Connection con = null;
        CallableStatement cstmt = null;
        System.out.println("ENTER VALUES TO FINE RATE OF INTEREST");
        System.out.println("ENTER AMOUNT");
        double amt = sc.nextDouble();
        System.out.println("ENTER RATE OF INTEREST");
        double roi =sc.nextDouble();
        System.out.println("ENTER TIME");
        double time = sc.nextDouble();
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/3datab","root","Suraj12345");
            cstmt=con.prepareCall("{?=call simpleInterest(?,?,?)}");
            cstmt.setDouble(2,amt);
            cstmt.setDouble(3,roi);
            cstmt.setDouble(4,time);
            cstmt.registerOutParameter(1, Types.DOUBLE);
            cstmt.execute();
            System.out.println(" RATE OF INTEREST IS : "+cstmt.getDouble(1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
