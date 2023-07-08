package with_callableStatement.with_Stored_Function;
import java.util.Scanner;
import java.sql.*;
public class F_5 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("ENTER MATHS MARKS");
        int math = sc.nextInt();
        System.out.println("ENTER PHYSICS MARKS");
        int phy = sc.nextInt();
        System.out.println("ENTER CHEMISTRY MARKS");
        int chem = sc.nextInt();
        Connection con = null;
        CallableStatement cstmt = null;

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1datab","root","Suraj12345");
            cstmt=con.prepareCall("{?=call PerStatus(?,?,?)}");
            cstmt.setInt(2,math);
            cstmt.setInt(3,phy);
            cstmt.setInt(4,chem);
            cstmt.registerOutParameter(1, Types.VARCHAR);
            cstmt.execute();
            int per = math+phy+chem/2;
            System.out.println("YOUR PERCENTAGE IS : "+per+" WITH "+cstmt.getString(1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
