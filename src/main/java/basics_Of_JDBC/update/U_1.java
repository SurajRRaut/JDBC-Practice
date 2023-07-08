package basics_Of_JDBC.update;
// UPDATE THE EMPLOYEE TABLE...
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class U_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter employee id");
        int id = sc.nextInt();
        System.out.println("Enter employee salary");
        double sal = sc.nextDouble();

        String query = "update employee set employee_sal="+sal+" where employee_id="+id;
        Connection con = null;
        Statement stmt = null;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1datab","root","Suraj12345");
            int count = con.createStatement().executeUpdate(query);
            if (count>0){
                System.out.println(count+"Data Updated Successfully");
            }
            else {
                System.out.println("Data Not Found");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
