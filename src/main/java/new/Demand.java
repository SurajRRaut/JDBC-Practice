package practice;
import java.sql.*;
public class Demand {
    public static void main(String[] args) {
        Connection con;
        CallableStatement cs;
        String query = "{?=call addTwoNumbers(?,?)}";
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1datab","root","Suraj12345");
            cs=con.prepareCall(query);
            cs.setInt(2,5);
            cs.setInt(3,5);
            cs.registerOutParameter(1, Types.INTEGER);
            cs.execute();
            ResultSet rs =cs.getResultSet();
            System.out.println(cs.getInt(1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
