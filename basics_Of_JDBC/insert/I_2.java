package basics_Of_JDBC.insert;
// INSERT VALUES IN EMPLOYEE TABLE BY USING FOR LOOP...
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class I_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Connection con = null;
        Statement stmt = null;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1datab","root","Suraj12345");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0;i<2;i++){
            System.out.println("Enter employee id");
            int id = sc.nextInt();
            System.out.println("Enter employee name");
            String name = sc.next();
            System.out.println("Enter employee salary");
            double sal = sc.nextDouble();

            String query = "insert into employee values("+id+",'"+name+"',"+sal+")";

            try {
                int count = con.createStatement().executeUpdate(query);
                System.out.println(count+"Data Inserted Successfully");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
