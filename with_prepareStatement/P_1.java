package with_prepareStatement;
//INSERT DATA WITH PLACEHOLDER
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class P_1 {
    //hardcore values(sql original values) | dynamic values (entering by user in java)
    // ? > placeholder
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER THE ROLL NUMBER");
        int rollNo = sc.nextInt();
        System.out.println("ENTER STUDENT FULL NAME");
        sc.nextLine();
        String name = sc.nextLine();
        System.out.println("ENTER STUDENT DIVISION");
        char division = sc.next().charAt(0);

        String insert = "insert into student values(?,?,?)";
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1datab","root","Suraj12345");
           pstmt = con.prepareStatement(insert);
           pstmt.setInt(1,rollNo);
           pstmt.setString(2,name);
           pstmt.setString(3,division+"");
           int count = pstmt.executeUpdate();
           if(count>0){
               System.out.println(count +" DATA INSERTED");
           }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
