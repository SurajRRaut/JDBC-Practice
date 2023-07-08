package with_callableStatement.with_Stored_Procedure;

import java.sql.*;
import java.util.Scanner;

public class P_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER NEW SOURCE UPDATE AT ROUTE NO 101");
        String source = sc.next();
        System.out.println("ENTER ROUTE NUMBER TO DISPLAY ALL BUS DETAILS");
        int routeNo = sc.nextInt();
        Connection con = null;
        CallableStatement cs = null;
        ResultSet rs = null;

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/2datab","root","Suraj12345");
            cs=con.prepareCall("{call BusDepo(?,?)}");
            cs.setString(1,source);
            cs.setInt(2,routeNo);
            cs.execute();
            rs=cs.getResultSet();
            if(rs.next()){
                System.out.println(rs.getInt(1)+"\t"+rs.getInt(2)+"\t"+rs.getString(3)+"\t"+rs.getInt(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\t"+rs.getInt(4)+"\t"+rs.getInt(8));
                System.out.println();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
