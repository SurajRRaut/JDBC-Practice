package with_callableStatement.with_Stored_Procedure;

import java.sql.*;
import java.util.Scanner;

public class P_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER CUSTOMER ID");
        int id = sc.nextInt();
        System.out.println("ENTER CUSTOMER NAME");
        String name = sc.next();
        System.out.println("ENTER CUSTOMER ADDRESS");
        String add = sc.next();
        Connection con = null;
        CallableStatement cs = null;
        ResultSet rs = null;

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/2datab","root","Suraj12345");
            cs=con.prepareCall("{call Demo1(?,?,?)}");
            cs.setInt(1,id);
            cs.setString(2,name);
            cs.setString(3,add);
            cs.execute();
            rs=cs.getResultSet();
            while(rs.next()){
                System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
                System.out.println();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
