package relational_Operations;
// Display all customer who does not buy any product (customer and products table)
import java.sql.*;

public class RO_3 {
    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        String query = "select customer_id from customer where customer_id in (select customer_ref from products)";

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1datab","root","Suraj12345");
            stmt = con.createStatement();
            rs =stmt.executeQuery(query);
            while (rs.next()){
                System.out.println(rs.getInt(1));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
