package basics_Of_JDBC.display;
// FETCH USERNAME AND PASSWORD FROM LOGIN TABLE
import java.sql.*;
import java.util.Scanner;

public class D_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter username");
        String username = sc.next();
        System.out.println("Enter password");
        String pass = sc.next();

        String query = "select * from login where username='"+username+"'and pass='"+pass+"'";
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        boolean status = false;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1datab","root","Suraj12345");
            stmt = con.createStatement();
            rs=stmt.executeQuery(query);
            if(rs.next()) {
                System.out.println("Login Successfully");
            }
            else {
                System.out.println("Invalid Login");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
