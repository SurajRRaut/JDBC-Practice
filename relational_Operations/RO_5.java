package relational_Operations;
// Display customer details who purchase X-BOX (Customer and products table)
import java.sql.*;
public class RO_5 {
    public static void main (String []args){
        Connection con = null;
        Statement stmt = null;
        String query = "SELECT customer_id,customer_name,customer_address FROM customer c,products p WHERE p.customer_ref=c.customer_id AND product_name = 'X_BOX'";
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1datab","root","Suraj12345");
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            System.out.println("ID\tNAME\tADDRESS");
            while(rs.next()){
                System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
