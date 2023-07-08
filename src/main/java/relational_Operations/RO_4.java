package relational_Operations;
// Display list of quantity sold against each product-category from products table..
import java.sql.*;
public class RO_4 {
    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String query = "SELECT product_category,COUNT(*) AS total_category FROM products GROUP BY product_category HAVING COUNT(*)>1";
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1datab","root","Suraj12345");
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while(rs.next()){
                System.out.println(rs.getString(1)+"\t"+rs.getInt(2));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
