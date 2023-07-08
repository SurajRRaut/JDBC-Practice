package basics_Of_JDBC.display;
// Fetch data of employees whose salary is between the 15000 and 85000 FROM EMPLOYEE TABLE !!
import java.sql.*;
import java.util.Scanner;

public class D_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter min Salary");
        double min = sc.nextDouble();
        System.out.println("Enter max Salary");
        double max = sc.nextDouble();

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        String query = "select * from employee where employee_sal>="+min+" and employee_sal<="+max;
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1datab","root","Suraj12345");
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            System.out.println("ID\tNAME\tSALARY");
            while(rs.next()){
                System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDouble(3));
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
