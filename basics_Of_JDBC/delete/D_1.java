package basics_Of_JDBC.delete;
// DELETE THE EMPLOYEE TABLE...
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class D_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter employee id");
        int id = sc.nextInt();

        String query = "delete from employee where employee_id="+id;
        Connection con = null;
        Statement stmt = null;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1datab","root","Suraj12345");
            int count = con.createStatement().executeUpdate(query);
            if (count>0){
                System.out.println(count+"Data Deleted Successfully");
            }
            else {

                System.out.println("Data Not Found");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
