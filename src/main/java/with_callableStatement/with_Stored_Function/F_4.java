package with_callableStatement.with_Stored_Function;

import java.sql.*;
import java.util.Scanner;

public class F_4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Connection con = null;
        CallableStatement cstmt = null;
        System.out.println("ENTER NUMBER TO CHECK ITS EVEN OR ODD");
        int num = sc.nextInt();
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1datab","root","Suraj12345");
            cstmt=con.prepareCall("{?=call EvenOdd(?)}");
            cstmt.setInt(2,num);
            cstmt.registerOutParameter(1, Types.VARCHAR);
            cstmt.execute();
            System.out.println(num+" is "+cstmt.getString(1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
