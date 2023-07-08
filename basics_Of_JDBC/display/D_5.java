package basics_Of_JDBC.display;
// LIST WHO EARNS MAXIMUM AND WHO EARNS MINIMUM SALARY FROM THE EMPLOYEE TABLE....(2)
import java.sql.*;

public class D_5 {
    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        String query1 = "SELECT * FROM employee WHERE employee_sal =(SELECT MIN(employee_sal) FROM employee)";
        String query2 = "SELECT * FROM employee WHERE employee_sal =(SELECT MAX(employee_sal) FROM employee)";

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1datab","root","Suraj12345");
            stmt=con.createStatement();

            rs=stmt.executeQuery(query1);
            System.out.println("Minimum salary");
            // use while loop statement if the records are More
            while(rs.next()){
                System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDouble(3));
            }

            rs=stmt.executeQuery(query2);
            System.out.println("Maximum Salary");
            while(rs.next()){
                System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDouble(3));
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
