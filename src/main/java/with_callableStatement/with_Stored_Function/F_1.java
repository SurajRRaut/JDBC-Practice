package with_callableStatement.with_Stored_Function;

import java.sql.*;

public class F_1 {
    public static void main(String[] args) {
        Connection con = null;
        CallableStatement cstmt = null;

        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1datab","root","Suraj12345");
            cstmt=con.prepareCall("{?=call addTwoNumbers(?,?)}");
            cstmt.setInt(2,10);
            cstmt.setInt(3,10);
            cstmt.registerOutParameter(1,Types.INTEGER);
            cstmt.execute();
            System.out.println(cstmt.getInt(1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
