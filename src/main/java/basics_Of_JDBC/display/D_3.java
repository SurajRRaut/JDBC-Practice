package basics_Of_JDBC.display;
// IF USERNAME AND PASSWORD ARE SAME BY ENTERING END USER AS PER LOGIN TABLE RECORD THEN IT WILL SHOW LOGIN SUCCESSFULLY...
import java.sql.*;
import java.util.Scanner;

public class D_3 {
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
            while(rs.next()){
                String username1 = rs.getString(1);
                String pass1 = rs.getString(2);
                if(username.equals(username1) && pass.equals(pass1)){
                    System.out.println(username1+"\t"+pass1);
                    System.out.println("Login Successfully");
                    status = true;
                }
            }
            if(!status){
                System.out.println("Invalid Login");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
