package basics_Of_JDBC.insert;
// INSERT VALUES IN EMPLOYEE TABLE
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class I_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter employee id");
        int id = sc.nextInt();
        System.out.println("Enter employee name");
        String name = sc.next();
        System.out.println("Enter employee salary");
        double sal = sc.nextDouble();

        String query = "insert into employee values("+id+",'"+name+"',"+sal+")";
        Connection con = null;
        Statement stmt = null;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1datab","root","Suraj12345");
            int count = con.createStatement().executeUpdate(query);
            System.out.println(count+"Data Inserted Successfully");
            System.out.println(con);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
